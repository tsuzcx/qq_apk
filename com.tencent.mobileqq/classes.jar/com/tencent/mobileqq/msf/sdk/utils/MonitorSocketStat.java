package com.tencent.mobileqq.msf.sdk.utils;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.d.d;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.msf.sdk.MsfServiceSdk;
import com.tencent.mobileqq.msf.service.MsfService;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.LinkedBlockingDeque;

public class MonitorSocketStat
  extends Thread
{
  private static Handler mMonitorSocketHandler;
  private static HandlerThread mMonitorSocketThread;
  static final String tag = "MonitorSocketStat";
  private byte STATUS = 0;
  private final LinkedBlockingDeque dataFlow = new LinkedBlockingDeque();
  private boolean isScreenOff = false;
  private long lastgotStatusTime;
  private BroadcastReceiver mReceiver;
  private String processName;
  private boolean running = true;
  
  public MonitorSocketStat()
  {
    setName("MonitorSocketStat");
    this.mReceiver = new MonitorSocketStat.a(this, null);
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.intent.action.SCREEN_ON");
    localIntentFilter.addAction("android.intent.action.SCREEN_OFF");
    BaseApplication.getContext().registerReceiver(this.mReceiver, localIntentFilter);
    mMonitorSocketThread = new HandlerThread("CheckNetFlowStatus");
    mMonitorSocketThread.start();
    mMonitorSocketHandler = new Handler(mMonitorSocketThread.getLooper());
  }
  
  private void getnetFlowStatus()
  {
    runOnMonitorSocketThread(new f(this), 0);
  }
  
  public static boolean runOnMonitorSocketThread(Runnable paramRunnable, int paramInt)
  {
    if (paramRunnable == null) {
      return false;
    }
    if (mMonitorSocketHandler == null)
    {
      QLog.d("MSF.D.MonitorSocket", 2, "MonitorSocketHandler is null");
      mMonitorSocketThread = new HandlerThread("CheckNetFlowStatus1");
      mMonitorSocketThread.start();
      mMonitorSocketHandler = new Handler(mMonitorSocketThread.getLooper());
    }
    if (paramInt > 0) {
      return mMonitorSocketHandler.postDelayed(paramRunnable, paramInt);
    }
    return mMonitorSocketHandler.post(paramRunnable);
  }
  
  public byte getSTATUS()
  {
    return this.STATUS;
  }
  
  public void insertData(b paramb)
  {
    if (this.running) {}
    try
    {
      this.dataFlow.add(paramb);
      return;
    }
    catch (Throwable paramb)
    {
      label17:
      break label17;
    }
    this.running = false;
    paramb = this.dataFlow;
    if (paramb != null) {
      paramb.clear();
    }
  }
  
  public void run()
  {
    if (this.processName == null) {
      this.processName = MsfSdkUtils.getProcessName(BaseApplication.getContext());
    }
    try
    {
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(BaseApplication.getContext().getPackageName());
      ((StringBuilder)localObject1).append(":MSF");
      boolean bool;
      Object localObject2;
      if (((StringBuilder)localObject1).toString().equals(this.processName)) {
        for (;;)
        {
          bool = this.running;
          if (!bool) {
            return;
          }
          try
          {
            localObject1 = (b)this.dataFlow.take();
            ((b)localObject1).a = this.processName;
            if (localObject1 != null) {
              MsfService.getCore().getNetFlowStore().a((b)localObject1);
            }
            if ((this.dataFlow.size() <= 1) && (System.currentTimeMillis() - this.lastgotStatusTime >= 60000L))
            {
              getnetFlowStatus();
              this.lastgotStatusTime = System.currentTimeMillis();
            }
          }
          catch (Throwable localThrowable1)
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("");
            ((StringBuilder)localObject2).append(localThrowable1);
            QLog.d("MSF.D.MonitorSocket", 1, ((StringBuilder)localObject2).toString(), localThrowable1);
            com.tencent.mobileqq.msf.sdk.b.e.a(localThrowable1);
            this.running = false;
            try
            {
              if (this.dataFlow == null) {
                return;
              }
              this.dataFlow.clear();
              return;
            }
            catch (Throwable localThrowable2)
            {
              QLog.d("MSF.D.MonitorSocket", 1, "clear", localThrowable2);
              return;
            }
          }
        }
      }
      for (;;)
      {
        bool = this.running;
        if (!bool) {
          break;
        }
        try
        {
          b localb = (b)this.dataFlow.take();
          if (localb != null)
          {
            localObject2 = MsfServiceSdk.get().getDataFlowMsg(this.processName, localb);
            int i = MsfServiceSdk.get().sendMsg((ToServiceMsg)localObject2);
            if (i < 0)
            {
              int j = (int)(Math.random() * 5.0D + 3.0D);
              runOnMonitorSocketThread(new e(this, localb, i), j * 1000);
            }
          }
          if ((this.dataFlow.size() <= 1) && (System.currentTimeMillis() - this.lastgotStatusTime >= 60000L))
          {
            getnetFlowStatus();
            this.lastgotStatusTime = System.currentTimeMillis();
          }
        }
        catch (Exception localException1)
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("");
          ((StringBuilder)localObject2).append(localException1);
          QLog.d("MSF.D.MonitorSocket", 1, ((StringBuilder)localObject2).toString(), localException1);
          this.running = false;
        }
      }
      return;
    }
    catch (Exception localException2)
    {
      localObject2 = this.dataFlow;
      if (localObject2 != null) {
        ((LinkedBlockingDeque)localObject2).clear();
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("");
      ((StringBuilder)localObject2).append(localException2);
      QLog.d("MSF.D.MonitorSocket", 1, ((StringBuilder)localObject2).toString(), localException2);
    }
  }
  
  public void setProcessName(String paramString)
  {
    this.processName = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msf.sdk.utils.MonitorSocketStat
 * JD-Core Version:    0.7.0.1
 */