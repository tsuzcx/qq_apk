package com.tencent.mobileqq.config.business;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.qphone.base.util.QLog;

public class NotificationBannerConfProcessor
  extends IQConfigProcessor<NotificationBannerBean>
{
  public static NotificationBannerBean a()
  {
    return (NotificationBannerBean)QConfigManager.a().a(572);
  }
  
  @NonNull
  public NotificationBannerBean a(int paramInt)
  {
    return new NotificationBannerBean();
  }
  
  @Nullable
  public NotificationBannerBean a(QConfItem[] paramArrayOfQConfItem)
  {
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0))
    {
      new NotificationBannerBean();
      return NotificationBannerBean.a(paramArrayOfQConfItem);
    }
    return null;
  }
  
  public void a(NotificationBannerBean paramNotificationBannerBean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NotificationBannerConfProcessor", 2, "onUpdate " + paramNotificationBannerBean.toString());
    }
  }
  
  public Class<NotificationBannerBean> clazz()
  {
    return NotificationBannerBean.class;
  }
  
  public boolean isAccountRelated()
  {
    return true;
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
    return 0;
  }
  
  public void onReqFailed(int paramInt) {}
  
  public int type()
  {
    return 572;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.NotificationBannerConfProcessor
 * JD-Core Version:    0.7.0.1
 */