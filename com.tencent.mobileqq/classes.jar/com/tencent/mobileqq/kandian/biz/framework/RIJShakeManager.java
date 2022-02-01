package com.tencent.mobileqq.kandian.biz.framework;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ShakeListener;
import com.tencent.mobileqq.kandian.biz.accesslayer.data.RIJDataManager;
import com.tencent.mobileqq.kandian.biz.accesslayer.data.RIJDataManager.Builder;
import com.tencent.mobileqq.kandian.biz.notecard.ReadInJoyNoteCardUtil;
import com.tencent.qqperf.monitor.backgroundcpu.BackgroundCpuMonitor;
import mqq.app.AppRuntime;

public class RIJShakeManager
{
  private RIJDataManager a;
  private ShakeListener b = new RIJShakeManager.1(this);
  
  public RIJShakeManager(RIJDataManager paramRIJDataManager)
  {
    this.a = paramRIJDataManager;
  }
  
  public void a()
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    int j = ReadInJoyNoteCardUtil.a();
    int i = 2;
    if ((j == 2) && (ReadInJoyNoteCardUtil.b(this.a.a().A(), (String)localObject) > 0))
    {
      localObject = (SensorManager)this.a.a().A().getSystemService("sensor");
      ShakeListener localShakeListener = this.b;
      Sensor localSensor = ((SensorManager)localObject).getDefaultSensor(1);
      if (!BackgroundCpuMonitor.a().b()) {
        i = 0;
      }
      ((SensorManager)localObject).registerListener(localShakeListener, localSensor, i);
    }
  }
  
  public void b()
  {
    ((SensorManager)this.a.a().A().getSystemService("sensor")).unregisterListener(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.framework.RIJShakeManager
 * JD-Core Version:    0.7.0.1
 */