package com.tencent.mobileqq.intervideo.huayang.impl;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.tencent.qphone.base.util.QLog;
import com.tencent.shadow.dynamic.host.PluginProcessService;
import com.tencent.shadow.dynamic.host.PpsController;
import java.util.concurrent.CountDownLatch;

class HuayangDowanloadHelperImpl$2
  implements ServiceConnection
{
  HuayangDowanloadHelperImpl$2(HuayangDowanloadHelperImpl paramHuayangDowanloadHelperImpl, CountDownLatch paramCountDownLatch) {}
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    QLog.i("IHuayangPluginNewDownloader", 2, "onServiceConnected ");
    HuayangDowanloadHelperImpl.access$400(this.jdField_a_of_type_ComTencentMobileqqIntervideoHuayangImplHuayangDowanloadHelperImpl).unbindService(this);
    paramComponentName = PluginProcessService.wrapBinder(paramIBinder);
    try
    {
      paramComponentName.exit();
    }
    catch (Exception paramComponentName)
    {
      QLog.d("IHuayangPluginNewDownloader", 2, "exit over", paramComponentName);
    }
    this.jdField_a_of_type_JavaUtilConcurrentCountDownLatch.countDown();
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.huayang.impl.HuayangDowanloadHelperImpl.2
 * JD-Core Version:    0.7.0.1
 */