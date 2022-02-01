package com.tencent.mobileqq.qcircle.api.impl;

import com.tencent.mobileqq.qcircle.api.IQCircleEeveeManangerService;
import cooperation.qqcircle.eevee.QCircleEeveeMananger;
import mqq.app.AppRuntime;

public class QCircleEeveeManangerServiceImpl
  implements IQCircleEeveeManangerService
{
  public void onCreate(AppRuntime paramAppRuntime) {}
  
  public void onDestroy() {}
  
  public void onSend(int paramInt, String paramString1, String paramString2)
  {
    QCircleEeveeMananger.getInstance().onSend(paramInt, paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qcircle.api.impl.QCircleEeveeManangerServiceImpl
 * JD-Core Version:    0.7.0.1
 */