package com.tencent.qqmini.sdk.monitor.service;

import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.monitor.common.FPSCalculator;
import java.util.concurrent.ConcurrentHashMap;

public class TaskMonitorManager
{
  public static final String SCENE_TAG_HIDE = "hide";
  public static final String SCENE_TAG_SHOW = "show";
  public static final String TAG = "TaskMonitorManager";
  public static String TASK_PERFM_SWITCH_PAGE = "切换页面耗时";
  protected static TaskMonitorManager mInstance = null;
  protected boolean isCalcDeviceUsageOk = true;
  protected volatile long mAppCurUsage = 0L;
  protected volatile long mAppLastUsage = 0L;
  protected volatile double mCurrentFps = 0.0D;
  protected volatile long mDeviceCurUsage = 0L;
  protected volatile long mDeviceLastUsage = 0L;
  protected boolean mEnable = ((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).isDebugVersion();
  private TaskMonitorManager.FpsListener mFpsListener = new TaskMonitorManager.FpsListener(this, null);
  protected ConcurrentHashMap<String, ThreadMsgInfo> mMsgInfoList = new ConcurrentHashMap();
  protected volatile int sTotalCpuUsage = 0;
  
  protected TaskMonitorManager()
  {
    FPSCalculator.getInstance().addListener(this.mFpsListener);
    updateCpuInfoSync();
  }
  
  public static TaskMonitorManager g()
  {
    if (mInstance == null) {}
    try
    {
      if (mInstance == null) {
        mInstance = new TaskMonitorManager();
      }
      return mInstance;
    }
    finally {}
  }
  
  protected ThreadMsgInfo fillEndThreadInfo(ThreadMsgInfo paramThreadMsgInfo)
  {
    long l2 = 0L;
    long l1;
    if (paramThreadMsgInfo != null)
    {
      paramThreadMsgInfo.realTimeEnd = System.currentTimeMillis();
      paramThreadMsgInfo.threadTimeEnd = SystemClock.currentThreadTimeMillis();
      l1 = paramThreadMsgInfo.realTimeEnd - paramThreadMsgInfo.realTimeStart;
      if (l1 <= 0L) {
        break label73;
      }
    }
    for (;;)
    {
      paramThreadMsgInfo.realTimeCost = l1;
      long l3 = paramThreadMsgInfo.threadTimeEnd - paramThreadMsgInfo.threadTimeStart;
      l1 = l2;
      if (l3 > 0L) {
        l1 = l3;
      }
      paramThreadMsgInfo.threadTimeCost = l1;
      return paramThreadMsgInfo;
      label73:
      l1 = 0L;
    }
  }
  
  protected String genKey(String paramString, Runnable paramRunnable)
  {
    if (TextUtils.isEmpty(paramString))
    {
      if (paramRunnable == null) {
        return "null";
      }
      return paramRunnable.toString();
    }
    return paramString;
  }
  
  protected ThreadMsgInfo genStartThreadInfo(String paramString, Thread paramThread)
  {
    ThreadMsgInfo localThreadMsgInfo = new ThreadMsgInfo();
    localThreadMsgInfo.key = genKey(paramString, paramThread);
    if (paramThread != null)
    {
      localThreadMsgInfo.currentRunnable = paramThread.toString();
      localThreadMsgInfo.currentThreadName = paramThread.getName();
      localThreadMsgInfo.currentThreadId = paramThread.getId();
    }
    try
    {
      localThreadMsgInfo.currentThreadStack = paramThread.getStackTrace();
      localThreadMsgInfo.realTimeStart = System.currentTimeMillis();
      localThreadMsgInfo.threadTimeStart = SystemClock.currentThreadTimeMillis();
      return localThreadMsgInfo;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        localThreadMsgInfo.currentThreadStack = null;
      }
    }
  }
  
  public String getCpuUsageInfo()
  {
    long l1 = this.mAppCurUsage;
    long l2 = this.mAppLastUsage;
    return "CPU已使用: " + (l1 - l2);
  }
  
  public String getCpuUsageRate()
  {
    if (this.sTotalCpuUsage > 0) {}
    for (String str = "CPU使用率: " + this.sTotalCpuUsage + "%";; str = "CPU使用率: -")
    {
      updateCpuInfoSync();
      return str;
    }
  }
  
  public double getCurrentFps()
  {
    return this.mCurrentFps;
  }
  
  public boolean getEnable()
  {
    return this.mEnable;
  }
  
  public long getHeapAllocatedMemory()
  {
    return (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / 1048576L;
  }
  
  public long getMemeryUsage()
  {
    int j = 0;
    long l1 = Runtime.getRuntime().maxMemory();
    long l2 = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
    int i = j;
    if (l1 > 0L)
    {
      i = j;
      if (l2 > 0L) {
        i = (int)((float)l2 / (float)l1 * 100.0F);
      }
    }
    return i;
  }
  
  public ThreadMsgInfo getTaskLooperInfo(String paramString)
  {
    if (!this.mEnable) {}
    while ((TextUtils.isEmpty(paramString)) || (this.mMsgInfoList == null) || (!this.mMsgInfoList.containsKey(paramString))) {
      return null;
    }
    return (ThreadMsgInfo)this.mMsgInfoList.get(paramString);
  }
  
  public ThreadMsgInfo getTaskPerfmSwitchPageInfo()
  {
    return getTaskLooperInfo(TASK_PERFM_SWITCH_PAGE);
  }
  
  public long getTotalCpuUsageAndUpdate()
  {
    return this.sTotalCpuUsage;
  }
  
  public void setCurrentFps(double paramDouble)
  {
    this.mCurrentFps = paramDouble;
  }
  
  public void setEnable(boolean paramBoolean)
  {
    this.mEnable = paramBoolean;
  }
  
  public void startLooperMonitor(String paramString)
  {
    startLooperMonitor(paramString, null, null, null, null);
  }
  
  public void startLooperMonitor(String paramString1, Thread paramThread, String paramString2, String paramString3, String paramString4)
  {
    if (!this.mEnable) {}
    String str;
    do
    {
      do
      {
        return;
        str = genKey(paramString1, paramThread);
      } while (TextUtils.isEmpty(str));
      if (QMLog.isColorLevel()) {
        QMLog.d("TaskMonitorManager", "startLooperMonitor, key is " + paramString1);
      }
    } while (this.mMsgInfoList == null);
    ThreadMsgInfo localThreadMsgInfo1 = null;
    if (this.mMsgInfoList.containsKey(str)) {
      localThreadMsgInfo1 = (ThreadMsgInfo)this.mMsgInfoList.get(paramString1);
    }
    ThreadMsgInfo localThreadMsgInfo2 = localThreadMsgInfo1;
    if (localThreadMsgInfo1 == null) {
      localThreadMsgInfo2 = genStartThreadInfo(paramString1, paramThread);
    }
    localThreadMsgInfo2.realTimeStart = System.currentTimeMillis();
    localThreadMsgInfo2.threadTimeStart = SystemClock.currentThreadTimeMillis();
    localThreadMsgInfo2.sceneName = paramString2;
    localThreadMsgInfo2.sceneDes = paramString3;
    localThreadMsgInfo2.sceneTag = paramString4;
    this.mMsgInfoList.put(str, localThreadMsgInfo2);
  }
  
  public void stopLooperMonitor(String paramString)
  {
    stopLooperMonitor(paramString, null);
  }
  
  public void stopLooperMonitor(String paramString, Runnable paramRunnable)
  {
    if (!this.mEnable) {}
    do
    {
      return;
      paramRunnable = genKey(paramString, paramRunnable);
      if (QMLog.isColorLevel()) {
        QMLog.d("TaskMonitorManager", "stopLooperMonitor, key is " + paramRunnable);
      }
    } while ((TextUtils.isEmpty(paramRunnable)) || (this.mMsgInfoList == null) || (!this.mMsgInfoList.containsKey(paramRunnable)));
    paramRunnable = fillEndThreadInfo((ThreadMsgInfo)this.mMsgInfoList.get(paramRunnable));
    this.mMsgInfoList.put(paramString, paramRunnable);
  }
  
  public void switchPerfmPage(String paramString, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    ThreadMsgInfo localThreadMsgInfo = getTaskPerfmSwitchPageInfo();
    String str;
    if (QMLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder().append("switchPerfmPage, page url is ").append(paramString).append(", ");
      if (paramBoolean)
      {
        str = "show";
        QMLog.d("TaskMonitorManager", str);
      }
    }
    else
    {
      if (!paramBoolean) {
        break label97;
      }
      str = "show";
    }
    for (;;)
    {
      if (localThreadMsgInfo != null)
      {
        if (paramBoolean)
        {
          stopLooperMonitor(TASK_PERFM_SWITCH_PAGE, null);
          return;
          str = "hide";
          break;
          label97:
          str = "hide";
          continue;
        }
        startLooperMonitor(TASK_PERFM_SWITCH_PAGE, null, TASK_PERFM_SWITCH_PAGE, paramString, str);
        return;
      }
    }
    startLooperMonitor(TASK_PERFM_SWITCH_PAGE, null, TASK_PERFM_SWITCH_PAGE, paramString, str);
  }
  
  public void updateCpuInfoSync()
  {
    ThreadManager.getSubThreadHandler().post(new TaskMonitorManager.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.monitor.service.TaskMonitorManager
 * JD-Core Version:    0.7.0.1
 */