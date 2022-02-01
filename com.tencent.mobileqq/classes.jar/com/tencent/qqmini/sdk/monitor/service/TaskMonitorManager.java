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
  protected static TaskMonitorManager mInstance;
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
    if (mInstance == null) {
      try
      {
        if (mInstance == null) {
          mInstance = new TaskMonitorManager();
        }
      }
      finally {}
    }
    return mInstance;
  }
  
  protected ThreadMsgInfo fillEndThreadInfo(ThreadMsgInfo paramThreadMsgInfo)
  {
    if (paramThreadMsgInfo != null)
    {
      paramThreadMsgInfo.realTimeEnd = System.currentTimeMillis();
      paramThreadMsgInfo.threadTimeEnd = SystemClock.currentThreadTimeMillis();
      long l = paramThreadMsgInfo.realTimeEnd - paramThreadMsgInfo.realTimeStart;
      if (l <= 0L) {
        l = 0L;
      }
      paramThreadMsgInfo.realTimeCost = l;
      l = paramThreadMsgInfo.threadTimeEnd - paramThreadMsgInfo.threadTimeStart;
      if (l <= 0L) {
        l = 0L;
      }
      paramThreadMsgInfo.threadTimeCost = l;
    }
    return paramThreadMsgInfo;
  }
  
  protected String genKey(String paramString, Runnable paramRunnable)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString))
    {
      if (paramRunnable == null) {
        return "null";
      }
      str = paramRunnable.toString();
    }
    return str;
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
    }
    catch (Exception paramString)
    {
      label57:
      break label57;
    }
    localThreadMsgInfo.currentThreadStack = null;
    localThreadMsgInfo.realTimeStart = System.currentTimeMillis();
    localThreadMsgInfo.threadTimeStart = SystemClock.currentThreadTimeMillis();
    return localThreadMsgInfo;
  }
  
  public String getCpuUsageInfo()
  {
    long l1 = this.mAppCurUsage;
    long l2 = this.mAppLastUsage;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("CPU已使用: ");
    localStringBuilder.append(l1 - l2);
    return localStringBuilder.toString();
  }
  
  public String getCpuUsageRate()
  {
    Object localObject;
    if (this.sTotalCpuUsage > 0)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("CPU使用率: ");
      ((StringBuilder)localObject).append(this.sTotalCpuUsage);
      ((StringBuilder)localObject).append("%");
      localObject = ((StringBuilder)localObject).toString();
    }
    else
    {
      localObject = "CPU使用率: -";
    }
    updateCpuInfoSync();
    return localObject;
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
    long l1 = Runtime.getRuntime().maxMemory();
    long l2 = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
    int i;
    if ((l1 > 0L) && (l2 > 0L)) {
      i = (int)((float)l2 / (float)l1 * 100.0F);
    } else {
      i = 0;
    }
    return i;
  }
  
  public ThreadMsgInfo getTaskLooperInfo(String paramString)
  {
    if (!this.mEnable) {
      return null;
    }
    if (!TextUtils.isEmpty(paramString))
    {
      ConcurrentHashMap localConcurrentHashMap = this.mMsgInfoList;
      if ((localConcurrentHashMap != null) && (localConcurrentHashMap.containsKey(paramString))) {
        return (ThreadMsgInfo)this.mMsgInfoList.get(paramString);
      }
    }
    return null;
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
    if (!this.mEnable) {
      return;
    }
    String str = genKey(paramString1, paramThread);
    if (!TextUtils.isEmpty(str))
    {
      Object localObject1;
      if (QMLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("startLooperMonitor, key is ");
        ((StringBuilder)localObject1).append(paramString1);
        QMLog.d("TaskMonitorManager", ((StringBuilder)localObject1).toString());
      }
      Object localObject2 = this.mMsgInfoList;
      if (localObject2 != null)
      {
        localObject1 = null;
        if (((ConcurrentHashMap)localObject2).containsKey(str)) {
          localObject1 = (ThreadMsgInfo)this.mMsgInfoList.get(paramString1);
        }
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = genStartThreadInfo(paramString1, paramThread);
        }
        ((ThreadMsgInfo)localObject2).realTimeStart = System.currentTimeMillis();
        ((ThreadMsgInfo)localObject2).threadTimeStart = SystemClock.currentThreadTimeMillis();
        ((ThreadMsgInfo)localObject2).sceneName = paramString2;
        ((ThreadMsgInfo)localObject2).sceneDes = paramString3;
        ((ThreadMsgInfo)localObject2).sceneTag = paramString4;
        this.mMsgInfoList.put(str, localObject2);
      }
    }
  }
  
  public void stopLooperMonitor(String paramString)
  {
    stopLooperMonitor(paramString, null);
  }
  
  public void stopLooperMonitor(String paramString, Runnable paramRunnable)
  {
    if (!this.mEnable) {
      return;
    }
    paramRunnable = genKey(paramString, paramRunnable);
    Object localObject;
    if (QMLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("stopLooperMonitor, key is ");
      ((StringBuilder)localObject).append(paramRunnable);
      QMLog.d("TaskMonitorManager", ((StringBuilder)localObject).toString());
    }
    if (!TextUtils.isEmpty(paramRunnable))
    {
      localObject = this.mMsgInfoList;
      if ((localObject != null) && (((ConcurrentHashMap)localObject).containsKey(paramRunnable)))
      {
        paramRunnable = fillEndThreadInfo((ThreadMsgInfo)this.mMsgInfoList.get(paramRunnable));
        this.mMsgInfoList.put(paramString, paramRunnable);
      }
    }
  }
  
  public void switchPerfmPage(String paramString, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    Object localObject = getTaskPerfmSwitchPageInfo();
    String str;
    if (QMLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("switchPerfmPage, page url is ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(", ");
      if (paramBoolean) {
        str = "show";
      } else {
        str = "hide";
      }
      localStringBuilder.append(str);
      QMLog.d("TaskMonitorManager", localStringBuilder.toString());
    }
    if (paramBoolean) {
      str = "show";
    } else {
      str = "hide";
    }
    if (localObject != null)
    {
      if (paramBoolean)
      {
        stopLooperMonitor(TASK_PERFM_SWITCH_PAGE, null);
        return;
      }
      localObject = TASK_PERFM_SWITCH_PAGE;
      startLooperMonitor((String)localObject, null, (String)localObject, paramString, str);
      return;
    }
    localObject = TASK_PERFM_SWITCH_PAGE;
    startLooperMonitor((String)localObject, null, (String)localObject, paramString, str);
  }
  
  public void updateCpuInfoSync()
  {
    ThreadManager.getSubThreadHandler().post(new TaskMonitorManager.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.monitor.service.TaskMonitorManager
 * JD-Core Version:    0.7.0.1
 */