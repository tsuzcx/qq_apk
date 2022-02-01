package com.tencent.mobileqq.config.business;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.onlinestatus.OnlineStatusItem;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusManagerService;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusService;
import com.tencent.mobileqq.onlinestatus.manager.AutoStatusManager;
import com.tencent.mobileqq.onlinestatus.manager.IAutoStatusManager;
import com.tencent.mobileqq.onlinestatus.manager.IOnlineStatusDataManager;
import com.tencent.mobileqq.onlinestatus.manager.OnlineStatusDataManager;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

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
      OnlineAutoStatusBean localOnlineAutoStatusBean = OnlineAutoStatusBean.a(paramArrayOfQConfItem[0].b);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onParsed ");
        localStringBuilder.append(paramArrayOfQConfItem[0].b);
        QLog.d("OnlineAutoStatusConfProcessor", 2, localStringBuilder.toString());
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
    Object localObject1 = MobileQQ.sMobileQQ.waitAppRuntime(null);
    if (localObject1 == null) {
      return;
    }
    IOnlineStatusService localIOnlineStatusService = (IOnlineStatusService)((AppRuntime)localObject1).getRuntimeService(IOnlineStatusService.class, "");
    Object localObject2 = (IOnlineStatusManagerService)((AppRuntime)localObject1).getRuntimeService(IOnlineStatusManagerService.class, "");
    localObject1 = (OnlineStatusDataManager)((IOnlineStatusManagerService)localObject2).getManager(IOnlineStatusDataManager.class);
    localObject2 = (AutoStatusManager)((IOnlineStatusManagerService)localObject2).getManager(IAutoStatusManager.class);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[status][parser] onUpdate try startDetector conf: ");
      localStringBuilder.append(paramOnlineAutoStatusBean.toString());
      QLog.d("OnlineAutoStatusConfProcessor", 2, localStringBuilder.toString());
    }
    if (OnlineStatusItem.a(localIOnlineStatusService.getOnlineStatus(), localIOnlineStatusService.getExtOnlineStatus())) {
      ((AutoStatusManager)localObject2).a("configUpdate");
    }
    ((OnlineStatusDataManager)localObject1).d(localIOnlineStatusService.getExtOnlineStatus());
    ((OnlineStatusDataManager)localObject1).b(localIOnlineStatusService.getExtOnlineStatus());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.OnlineAutoStatusConfProcessor
 * JD-Core Version:    0.7.0.1
 */