package com.tencent.mobileqq.config.business;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.TMG.utils.QLog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.managers.PushNotificationManager;
import mqq.app.AppRuntime;

public class QConfPushProcessor
  extends IQConfigProcessor<QConfPushBean>
{
  @NonNull
  public QConfPushBean a(int paramInt)
  {
    return new QConfPushBean();
  }
  
  @Nullable
  public QConfPushBean a(QConfItem[] paramArrayOfQConfItem)
  {
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0))
    {
      QConfPushBean localQConfPushBean = QConfPushBean.a(paramArrayOfQConfItem[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("QConfPushProcessor", 0, "onParsed " + paramArrayOfQConfItem[0].a);
      }
      return localQConfPushBean;
    }
    return new QConfPushBean();
  }
  
  public void a(QConfPushBean paramQConfPushBean)
  {
    ((PushNotificationManager)BaseApplicationImpl.getApplication().getRuntime().getManager(QQManagerFactory.PUSH_NOTIFICATION_MANAGER)).a(paramQConfPushBean);
    if (QLog.isColorLevel()) {
      QLog.d("QConfPushProcessor", 0, "onUpdate " + paramQConfPushBean);
    }
  }
  
  public Class<QConfPushBean> clazz()
  {
    return QConfPushBean.class;
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
    return 390;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.QConfPushProcessor
 * JD-Core Version:    0.7.0.1
 */