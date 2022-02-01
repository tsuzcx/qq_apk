package com.tencent.mobileqq.qcircle.api.impl;

import android.content.SharedPreferences;
import com.tencent.biz.qcircleshadow.local.QCircleShadow;
import com.tencent.mobileqq.qcircle.api.IQCircleConfigApi;
import common.config.service.QzoneConfig;
import cooperation.qqcircle.QCircleConfig;

public class QCircleConfigApiImpl
  implements IQCircleConfigApi
{
  private static final String TAG = "QCircleConfigApiImpl";
  
  public String getPluginQUA()
  {
    return QCircleShadow.a().a();
  }
  
  public SharedPreferences getQCircleSp()
  {
    return QCircleConfig.getQCircleSp();
  }
  
  public long getQQCircleFollowTabUpdateNotificationShowInterval()
  {
    return QCircleConfig.getQQCircleFollowTabUpdateNotificationShowInterval();
  }
  
  public boolean isShowQQCircleMainTabEntrance(boolean paramBoolean)
  {
    return QzoneConfig.isShowQQCircleMainTabEntrance(paramBoolean);
  }
  
  public void tryGetSplashVideoAsync()
  {
    QCircleConfig.getInstance().tryGetSplashVideoAsync();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qcircle.api.impl.QCircleConfigApiImpl
 * JD-Core Version:    0.7.0.1
 */