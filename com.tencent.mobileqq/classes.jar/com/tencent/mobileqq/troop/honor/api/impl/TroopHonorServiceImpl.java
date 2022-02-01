package com.tencent.mobileqq.troop.honor.api.impl;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.troop.honor.TroopHonorManager;
import com.tencent.mobileqq.troop.honor.api.ITroopHonorService;
import com.tencent.mobileqq.troop.honor.api.ITroopHonorService.IGetTroopHonorListCallback;
import com.tencent.mobileqq.troop.honor.config.TroopHonor;
import com.tencent.mobileqq.troop.honor.config.TroopHonorConfig;
import com.tencent.mobileqq.troop.managerfactory.api.IManagerFactoryService;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;
import tencent.im.oidb.oidb_0xdc9.oidb_0xdc9.HonorList;

public class TroopHonorServiceImpl
  implements ITroopHonorService
{
  private static final String TAG = "TroopHonorServiceImpl";
  AppRuntime mAppRuntime;
  TroopHonorManager manager = null;
  
  public void asyncGetTroopHonorListByDirect(String paramString1, String paramString2, ITroopHonorService.IGetTroopHonorListCallback paramIGetTroopHonorListCallback)
  {
    TroopHonorManager localTroopHonorManager = this.manager;
    if (localTroopHonorManager != null) {
      localTroopHonorManager.a(paramString1, paramString2, paramIGetTroopHonorListCallback);
    }
  }
  
  public List<TroopHonor> convertToHonorList(String paramString, Byte paramByte)
  {
    TroopHonorManager localTroopHonorManager = this.manager;
    if (localTroopHonorManager != null) {
      return localTroopHonorManager.a(paramString, paramByte);
    }
    return new ArrayList();
  }
  
  public List<TroopHonor> getTroopHonorList(String paramString1, String paramString2)
  {
    TroopHonorManager localTroopHonorManager = this.manager;
    if (localTroopHonorManager != null) {
      return localTroopHonorManager.a(paramString1, paramString2);
    }
    return new ArrayList();
  }
  
  public TroopHonorManager getTroopHonorManager()
  {
    AppRuntime localAppRuntime = this.mAppRuntime;
    if (localAppRuntime == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopHonorServiceImpl", 1, "mAppRuntime == null");
      }
      return null;
    }
    return (TroopHonorManager)((IManagerFactoryService)localAppRuntime.getRuntimeService(IManagerFactoryService.class, "")).getManager(TroopHonorManager.class);
  }
  
  public boolean isGrayTroopHonor(String paramString)
  {
    TroopHonorManager localTroopHonorManager = this.manager;
    if (localTroopHonorManager != null) {
      return localTroopHonorManager.a(paramString);
    }
    return false;
  }
  
  public boolean isSupportTroopHonor(String paramString)
  {
    TroopHonorManager localTroopHonorManager = this.manager;
    if (localTroopHonorManager != null) {
      return localTroopHonorManager.b(paramString);
    }
    return false;
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    this.mAppRuntime = paramAppRuntime;
    this.manager = getTroopHonorManager();
  }
  
  public void onDestroy() {}
  
  public void saveHostHonorListRichTag(short paramShort)
  {
    TroopHonorManager localTroopHonorManager = this.manager;
    if (localTroopHonorManager != null) {
      localTroopHonorManager.a(paramShort);
    }
  }
  
  public void updateConfig(TroopHonorConfig paramTroopHonorConfig, boolean paramBoolean)
  {
    TroopHonorManager localTroopHonorManager = this.manager;
    if (localTroopHonorManager != null) {
      localTroopHonorManager.a(paramTroopHonorConfig, paramBoolean);
    }
  }
  
  public boolean updateEntity(Entity paramEntity)
  {
    TroopHonorManager localTroopHonorManager = this.manager;
    if (localTroopHonorManager != null) {
      return localTroopHonorManager.a(paramEntity);
    }
    return false;
  }
  
  public void updateHostHonorList(List<oidb_0xdc9.HonorList> paramList, boolean paramBoolean)
  {
    TroopHonorManager localTroopHonorManager = this.manager;
    if (localTroopHonorManager != null) {
      localTroopHonorManager.a(paramList, paramBoolean);
    }
  }
  
  public void updateHostHonorList(boolean paramBoolean)
  {
    TroopHonorManager localTroopHonorManager = this.manager;
    if (localTroopHonorManager != null) {
      localTroopHonorManager.a(paramBoolean);
    }
  }
  
  public void updatePushTroopHonor(String paramString, byte[] paramArrayOfByte, int paramInt)
  {
    TroopHonorManager localTroopHonorManager = this.manager;
    if (localTroopHonorManager != null) {
      localTroopHonorManager.a(paramString, paramArrayOfByte, paramInt);
    }
  }
  
  public void updateTroopHonorAIOSwitch(String paramString, boolean paramBoolean)
  {
    TroopHonorManager localTroopHonorManager = this.manager;
    if (localTroopHonorManager != null) {
      localTroopHonorManager.a(paramString, paramBoolean);
    }
  }
  
  public void updateTroopMemberHonor(String paramString1, String paramString2, String paramString3, byte paramByte, long paramLong)
  {
    TroopHonorManager localTroopHonorManager = this.manager;
    if (localTroopHonorManager != null) {
      localTroopHonorManager.a(paramString1, paramString2, paramString3, paramByte, paramLong);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.honor.api.impl.TroopHonorServiceImpl
 * JD-Core Version:    0.7.0.1
 */