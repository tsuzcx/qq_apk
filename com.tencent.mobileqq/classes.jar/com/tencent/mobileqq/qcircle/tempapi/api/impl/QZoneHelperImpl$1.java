package com.tencent.mobileqq.qcircle.tempapi.api.impl;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import cooperation.qzone.QZoneHelper;
import mqq.app.AppRuntime;

class QZoneHelperImpl$1
  implements Runnable
{
  QZoneHelperImpl$1(QZoneHelperImpl paramQZoneHelperImpl) {}
  
  public void run()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if (localAppRuntime == null) {}
    while (!(localAppRuntime instanceof QQAppInterface)) {
      return;
    }
    QZoneHelper.preloadQzone((QQAppInterface)localAppRuntime, "QCircle", true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qcircle.tempapi.api.impl.QZoneHelperImpl.1
 * JD-Core Version:    0.7.0.1
 */