package com.tencent.mobileqq.qcircle.api.impl;

import android.content.SharedPreferences;
import com.tencent.mobileqq.auto.engine.loader.ASDynamicEngine;
import com.tencent.mobileqq.auto.engine.loader.ASDynamicEngineFactory;
import com.tencent.mobileqq.qcircle.api.IQCircleConfigApi;
import com.tencent.qcircle.cooperation.config.QCircleConfigHelper;
import cooperation.qqcircle.QCircleConfig;

public class QCircleConfigApiImpl
  implements IQCircleConfigApi
{
  private static final String TAG = "QCircleConfigApiImpl";
  
  public String getPluginMark()
  {
    return ASDynamicEngineFactory.a("qcircle-app").i();
  }
  
  public String getPluginQUA()
  {
    return ASDynamicEngineFactory.a("qcircle-app").h();
  }
  
  public SharedPreferences getQCircleSp()
  {
    return QCircleConfig.getQCircleSp();
  }
  
  public long getQQCircleFollowTabUpdateNotificationShowInterval()
  {
    return QCircleConfig.getQQCircleFollowTabUpdateNotificationShowInterval();
  }
  
  public boolean isShowQCircleEnter(boolean paramBoolean)
  {
    return QCircleConfigHelper.d(paramBoolean);
  }
  
  public boolean isShowQQCircleMainTabEntrance(boolean paramBoolean)
  {
    return QCircleConfigHelper.a(paramBoolean);
  }
  
  public void tryGetSplashVideoAsync()
  {
    QCircleConfig.getInstance().tryGetSplashVideoAsync();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qcircle.api.impl.QCircleConfigApiImpl
 * JD-Core Version:    0.7.0.1
 */