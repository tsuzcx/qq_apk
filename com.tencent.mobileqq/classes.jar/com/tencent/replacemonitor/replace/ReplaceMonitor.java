package com.tencent.replacemonitor.replace;

import android.content.Context;
import com.tencent.replacemonitor.MonitorListener;
import com.tencent.replacemonitor.MonitorResult;
import com.tencent.replacemonitor.MonitorStep;
import com.tencent.replacemonitor.MonitorTask;
import com.tencent.replacemonitor.replace.c.a;
import java.util.Map;

public class ReplaceMonitor
{
  public static final String WASH_TAG = "WashMonitor";
  private static ReplaceMonitor sInstance = null;
  private a mRealMonitor = new a();
  
  public static ReplaceMonitor get()
  {
    try
    {
      if (sInstance == null) {
        sInstance = new ReplaceMonitor();
      }
      ReplaceMonitor localReplaceMonitor = sInstance;
      return localReplaceMonitor;
    }
    finally {}
  }
  
  public long addTask(MonitorTask paramMonitorTask)
  {
    return this.mRealMonitor.a(paramMonitorTask);
  }
  
  public void deleteTask(MonitorTask paramMonitorTask)
  {
    this.mRealMonitor.b(paramMonitorTask);
  }
  
  public MonitorResult execAsync(MonitorTask paramMonitorTask, MonitorStep paramMonitorStep)
  {
    return this.mRealMonitor.b(paramMonitorTask, paramMonitorStep);
  }
  
  public void execSync(MonitorTask paramMonitorTask, MonitorStep paramMonitorStep)
  {
    this.mRealMonitor.a(paramMonitorTask, paramMonitorStep);
  }
  
  public MonitorTask getTask(long paramLong)
  {
    return this.mRealMonitor.a(paramLong);
  }
  
  public MonitorTask getTask(String paramString)
  {
    return this.mRealMonitor.a(paramString);
  }
  
  public void init(Context paramContext, Map<String, String> paramMap)
  {
    this.mRealMonitor.a(paramContext, paramMap);
  }
  
  public void onAppInstalled(String paramString, boolean paramBoolean)
  {
    this.mRealMonitor.a(paramString, paramBoolean);
  }
  
  public void register(MonitorListener paramMonitorListener)
  {
    this.mRealMonitor.a(paramMonitorListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.replacemonitor.replace.ReplaceMonitor
 * JD-Core Version:    0.7.0.1
 */