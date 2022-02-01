package com.tencent.mobileqq.qcircle.api.impl;

import com.tencent.mobileqq.qcircle.api.IQCirclePreLoaderService;
import cooperation.qqcircle.whitelist.QCirclePreLoadManager;
import mqq.app.AppRuntime;

public class QCirclePreLoaderServiceImpl
  implements IQCirclePreLoaderService
{
  public void onCreate(AppRuntime paramAppRuntime) {}
  
  public void onDestroy() {}
  
  public void requestWhiteList(String paramString)
  {
    QCirclePreLoadManager.getInstance().requestWhiteList(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qcircle.api.impl.QCirclePreLoaderServiceImpl
 * JD-Core Version:    0.7.0.1
 */