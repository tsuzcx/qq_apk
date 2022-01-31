package com.tencent.mobileqq.mini.monitor.service;

import ajyc;
import android.os.SystemClock;
import android.text.TextUtils;
import baxc;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.thread.QzoneBaseThread;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import java.util.concurrent.ConcurrentHashMap;

public class TaskMonitorManager
{
  public static final String SCENE_TAG_HIDE = "hide";
  public static final String SCENE_TAG_SHOW = "show";
  public static final String TAG = "TaskMonitorManager";
  public static String TASK_PERFM_SWITCH_PAGE = ajyc.a(2131714729);
  protected static TaskMonitorManager mInstance;
  protected boolean isCalcDeviceUsageOk = true;
  protected volatile long mAppCurUsage;
  protected volatile long mAppLastUsage;
  protected volatile double mCurrentFps;
  protected volatile long mDeviceCurUsage;
  protected volatile long mDeviceLastUsage;
  protected boolean mEnable = false;
  private TaskMonitorManager.FpsListener mFpsListener = new TaskMonitorManager.FpsListener(this, null);
  protected ConcurrentHashMap<String, ThreadMsgInfo> mMsgInfoList = new ConcurrentHashMap();
  protected volatile int sTotalCpuUsage;
  
  protected TaskMonitorManager()
  {
    baxc.a().a(this.mFpsListener);
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
      if (QLog.isColorLevel()) {
        QLog.d("TaskMonitorManager", 2, "startLooperMonitor, key is " + paramString1);
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
      if (QLog.isColorLevel()) {
        QLog.d("TaskMonitorManager", 2, "stopLooperMonitor, key is " + paramRunnable);
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
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder().append("switchPerfmPage, page url is ").append(paramString).append(", ");
      if (paramBoolean)
      {
        str = "show";
        QLog.d("TaskMonitorManager", 2, str);
      }
    }
    else
    {
      if (!paramBoolean) {
        break label98;
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
          label98:
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
    QzoneHandlerThreadFactory.getHandlerThread("BackGround_HandlerThread").post(new TaskMonitorManager.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.monitor.service.TaskMonitorManager
 * JD-Core Version:    0.7.0.1
 */