package com.tencent.mobileqq.config.business;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.onlinestatus.OnlineStatusItem;
import com.tencent.mobileqq.onlinestatus.OnlineStatusManager;
import com.tencent.mobileqq.onlinestatus.auto.AutoStatusManager;
import com.tencent.qphone.base.util.QLog;

public class OnlineAutoStatusConfProcessor
  extends IQConfigProcessor<OnlineAutoStatusBean>
{
  @NonNull
  public OnlineAutoStatusBean a(int paramInt)
  {
    return new OnlineAutoStatusBean();
  }
  
  @Nullable
  public OnlineAutoStatusBean a(QConfItem[] paramArrayOfQConfItem)
  {
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0) && (paramArrayOfQConfItem[0] != null))
    {
      OnlineAutoStatusBean localOnlineAutoStatusBean = OnlineAutoStatusBean.a(paramArrayOfQConfItem[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("OnlineAutoStatusConfProcessor", 2, "onParsed " + paramArrayOfQConfItem[0].a);
      }
      return localOnlineAutoStatusBean;
    }
    if (QLog.isColorLevel()) {
      QLog.d("OnlineAutoStatusConfProcessor", 2, "onParsed is null");
    }
    return new OnlineAutoStatusBean();
  }
  
  public void a(OnlineAutoStatusBean paramOnlineAutoStatusBean)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (localQQAppInterface == null) {
      return;
    }
    OnlineStatusManager localOnlineStatusManager = (OnlineStatusManager)localQQAppInterface.getManager(QQManagerFactory.ONLINE_STATUS_MANAGER);
    AutoStatusManager localAutoStatusManager = localOnlineStatusManager.a();
    if (QLog.isColorLevel()) {
      QLog.d("OnlineAutoStatusConfProcessor", 2, "[status][parser] onUpdate try startDetector conf: " + paramOnlineAutoStatusBean.toString());
    }
    if (OnlineStatusItem.a(localQQAppInterface.getOnlineStatus(), localQQAppInterface.getExtOnlineStatus())) {
      localAutoStatusManager.a("configUpdate");
    }
    localOnlineStatusManager.c(localQQAppInterface.getExtOnlineStatus());
    localOnlineStatusManager.b(localQQAppInterface.getExtOnlineStatus());
  }
  
  public Class<OnlineAutoStatusBean> clazz()
  {
    return OnlineAutoStatusBean.class;
  }
  
  public boolean isNeedCompressed()
  {
    return true;
  }
  
  public boolean isNeedStoreLargeFile()
  {
    return false;
  }
  
  public boolean isNeedUpgradeReset()
  {
    QLog.d("OnlineAutoStatusConfProcessor", 1, "isNeedUpgradeReset ");
    return true;
  }
  
  public int migrateOldVersion()
  {
    if (QLog.isColorLevel()) {
      QLog.d("OnlineAutoStatusConfProcessor", 2, "migrateOldVersion");
    }
    return 0;
  }
  
  public void onReqFailed(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("OnlineAutoStatusConfProcessor", 2, new Object[] { "onReqFailed ", Integer.valueOf(paramInt) });
    }
  }
  
  public int type()
  {
    return 652;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.OnlineAutoStatusConfProcessor
 * JD-Core Version:    0.7.0.1
 */