package com.tencent.mobileqq.qcircle.tempapi.api.impl;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import cooperation.qzone.QZoneHelper;
import mqq.app.AppRuntime;

class QZoneHelperImpl$2
  implements Runnable
{
  QZoneHelperImpl$2(QZoneHelperImpl paramQZoneHelperImpl) {}
  
  public void run()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if (localAppRuntime == null) {}
    while (!(localAppRuntime instanceof QQAppInterface)) {
      return;
    }
    QZoneHelper.cancelQzoneAlive((QQAppInterface)localAppRuntime);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qcircle.tempapi.api.impl.QZoneHelperImpl.2
 * JD-Core Version:    0.7.0.1
 */