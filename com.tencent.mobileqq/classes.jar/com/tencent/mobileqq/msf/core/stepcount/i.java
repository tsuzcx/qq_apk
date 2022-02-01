package com.tencent.mobileqq.msf.core.stepcount;

import android.content.Context;
import android.hardware.SensorManager;
import android.os.Build.VERSION;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class i
  implements b
{
  private static final String a = "StepCounterManager";
  private final b b;
  
  private i()
  {
    BaseApplication localBaseApplication = BaseApplication.getContext();
    if ((localBaseApplication != null) && (Build.VERSION.SDK_INT >= 19) && (g.a().c() == 2))
    {
      SensorManager localSensorManager = (SensorManager)localBaseApplication.getSystemService("sensor");
      if ((localSensorManager != null) && (localSensorManager.getDefaultSensor(19) != null))
      {
        QLog.d("StepCounterManager", 1, "enable refactored step counter");
        this.b = new a(localBaseApplication);
        return;
      }
    }
    QLog.d("StepCounterManager", 1, "use legacy step counter");
    this.b = new e();
  }
  
  public static i b()
  {
    return i.a.a();
  }
  
  public static void b(String paramString, ToServiceMsg paramToServiceMsg)
  {
    if ("cmd_step_update_config".equals(paramToServiceMsg.getServiceCmd()))
    {
      g.a().a(paramToServiceMsg);
      return;
    }
    b().a(paramString, paramToServiceMsg);
  }
  
  public void a()
  {
    this.b.a();
  }
  
  public void a(String paramString, ToServiceMsg paramToServiceMsg)
  {
    this.b.a(paramString, paramToServiceMsg);
  }
  
  public void a(boolean paramBoolean)
  {
    this.b.a(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.stepcount.i
 * JD-Core Version:    0.7.0.1
 */