package com.tencent.mobileqq.config.business;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusManagerService;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusService;
import com.tencent.mobileqq.onlinestatus.manager.IOnlineStatusDataManager;
import com.tencent.mobileqq.onlinestatus.manager.OnlineStatusDataManager;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

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
      OnlineStatusBean localOnlineStatusBean = OnlineStatusBean.a(paramArrayOfQConfItem[0].b);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onParsed ");
        localStringBuilder.append(paramArrayOfQConfItem[0].b);
        QLog.d("OnlineStatusConfProcessor", 2, localStringBuilder.toString());
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
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onUpdate ");
      ((StringBuilder)localObject).append(paramOnlineStatusBean.toString());
      QLog.d("OnlineStatusConfProcessor", 2, ((StringBuilder)localObject).toString());
    }
    paramOnlineStatusBean = MobileQQ.sMobileQQ.peekAppRuntime();
    Object localObject = (IOnlineStatusService)paramOnlineStatusBean.getRuntimeService(IOnlineStatusService.class, "");
    ((OnlineStatusDataManager)((IOnlineStatusManagerService)paramOnlineStatusBean.getRuntimeService(IOnlineStatusManagerService.class, "")).getManager(IOnlineStatusDataManager.class)).c(((IOnlineStatusService)localObject).getExtOnlineStatus());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.OnlineStatusConfProcessor
 * JD-Core Version:    0.7.0.1
 */