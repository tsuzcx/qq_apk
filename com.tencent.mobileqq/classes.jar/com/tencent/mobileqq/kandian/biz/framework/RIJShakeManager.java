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
  private ShakeListener jdField_a_of_type_ComTencentMobileqqAppShakeListener = new RIJShakeManager.1(this);
  private RIJDataManager jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataManager;
  
  public RIJShakeManager(RIJDataManager paramRIJDataManager)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataManager = paramRIJDataManager;
  }
  
  public void a()
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    int j = ReadInJoyNoteCardUtil.a();
    int i = 2;
    if ((j == 2) && (ReadInJoyNoteCardUtil.b(this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataManager.a().a(), (String)localObject) > 0))
    {
      localObject = (SensorManager)this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataManager.a().a().getSystemService("sensor");
      ShakeListener localShakeListener = this.jdField_a_of_type_ComTencentMobileqqAppShakeListener;
      Sensor localSensor = ((SensorManager)localObject).getDefaultSensor(1);
      if (!BackgroundCpuMonitor.a().a()) {
        i = 0;
      }
      ((SensorManager)localObject).registerListener(localShakeListener, localSensor, i);
    }
  }
  
  public void b()
  {
    ((SensorManager)this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataManager.a().a().getSystemService("sensor")).unregisterListener(this.jdField_a_of_type_ComTencentMobileqqAppShakeListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.framework.RIJShakeManager
 * JD-Core Version:    0.7.0.1
 */