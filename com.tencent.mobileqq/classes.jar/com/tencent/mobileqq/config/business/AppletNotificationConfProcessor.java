package com.tencent.mobileqq.config.business;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.activity.recent.AppletsFolderManager;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.qphone.base.util.QLog;

public class AppletNotificationConfProcessor
  extends IQConfigProcessor<AppletNotificationConfigureBean>
{
  @NonNull
  public AppletNotificationConfigureBean a(int paramInt)
  {
    return new AppletNotificationConfigureBean();
  }
  
  @Nullable
  public AppletNotificationConfigureBean a(QConfItem[] paramArrayOfQConfItem)
  {
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0) && (paramArrayOfQConfItem[0] != null))
    {
      AppletNotificationConfigureBean localAppletNotificationConfigureBean = AppletNotificationConfigureBean.a(paramArrayOfQConfItem[0].a);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onParsed ");
        localStringBuilder.append(paramArrayOfQConfItem[0].a);
        QLog.d("AppletNotificationConfProcessor", 2, localStringBuilder.toString());
      }
      return localAppletNotificationConfigureBean;
    }
    if (QLog.isColorLevel()) {
      QLog.d("AppletNotificationConfProcessor", 2, "onParsed is null");
    }
    AppletsFolderManager.a(true);
    return null;
  }
  
  public void a(AppletNotificationConfigureBean paramAppletNotificationConfigureBean)
  {
    if (paramAppletNotificationConfigureBean == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AppletNotificationConfProcessor", 2, "onUpdate but newConf==null");
      }
      return;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onUpdate ");
      localStringBuilder.append(paramAppletNotificationConfigureBean.toString());
      QLog.d("AppletNotificationConfProcessor", 2, localStringBuilder.toString());
    }
    AppletsFolderManager.a(true);
  }
  
  public Class<AppletNotificationConfigureBean> clazz()
  {
    return AppletNotificationConfigureBean.class;
  }
  
  public boolean isAccountRelated()
  {
    return false;
  }
  
  public boolean isNeedCompressed()
  {
    return true;
  }
  
  public boolean isNeedStoreLargeFile()
  {
    return false;
  }
  
  public int migrateOldVersion()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AppletNotificationConfProcessor", 2, "migrateOldVersion");
    }
    AppletsFolderManager.a(true);
    return 0;
  }
  
  public void onReqFailed(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AppletNotificationConfProcessor", 2, new Object[] { "onReqFailed ", Integer.valueOf(paramInt) });
    }
    AppletsFolderManager.a(true);
  }
  
  public int type()
  {
    return 597;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.AppletNotificationConfProcessor
 * JD-Core Version:    0.7.0.1
 */