package com.tencent.mobileqq.config.business;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.onlinestatus.OnlineStatusManager;
import com.tencent.qphone.base.util.QLog;

public class OnlineStatusConfProcessor
  extends IQConfigProcessor<OnlineStatusBean>
{
  @NonNull
  public OnlineStatusBean a(int paramInt)
  {
    return new OnlineStatusBean();
  }
  
  @Nullable
  public OnlineStatusBean a(QConfItem[] paramArrayOfQConfItem)
  {
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0) && (paramArrayOfQConfItem[0] != null))
    {
      OnlineStatusBean localOnlineStatusBean = OnlineStatusBean.a(paramArrayOfQConfItem[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("OnlineStatusConfProcessor", 2, "onParsed " + paramArrayOfQConfItem[0].a);
      }
      return localOnlineStatusBean;
    }
    if (QLog.isColorLevel()) {
      QLog.d("OnlineStatusConfProcessor", 2, "onParsed is null");
    }
    return null;
  }
  
  public void a(OnlineStatusBean paramOnlineStatusBean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("OnlineStatusConfProcessor", 2, "onUpdate " + paramOnlineStatusBean.toString());
    }
    paramOnlineStatusBean = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (paramOnlineStatusBean == null) {
      return;
    }
    ((OnlineStatusManager)paramOnlineStatusBean.getManager(QQManagerFactory.ONLINE_STATUS_MANAGER)).d(paramOnlineStatusBean.getExtOnlineStatus());
  }
  
  public Class<OnlineStatusBean> clazz()
  {
    return OnlineStatusBean.class;
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
    QLog.d("OnlineStatusConfProcessor", 1, "isNeedUpgradeReset ");
    return true;
  }
  
  public int migrateOldVersion()
  {
    if (QLog.isColorLevel()) {
      QLog.d("OnlineStatusConfProcessor", 2, "migrateOldVersion");
    }
    return 0;
  }
  
  public void onReqFailed(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("OnlineStatusConfProcessor", 2, new Object[] { "onReqFailed ", Integer.valueOf(paramInt) });
    }
  }
  
  public int type()
  {
    return 578;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.OnlineStatusConfProcessor
 * JD-Core Version:    0.7.0.1
 */