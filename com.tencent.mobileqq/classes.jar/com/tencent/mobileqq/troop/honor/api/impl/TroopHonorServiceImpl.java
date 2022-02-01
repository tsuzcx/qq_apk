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
    if (this.manager != null) {
      this.manager.a(paramString1, paramString2, paramIGetTroopHonorListCallback);
    }
  }
  
  public List<TroopHonor> convertToHonorList(String paramString, Byte paramByte)
  {
    if (this.manager != null) {
      return this.manager.a(paramString, paramByte);
    }
    return new ArrayList();
  }
  
  public List<TroopHonor> getTroopHonorList(String paramString1, String paramString2)
  {
    if (this.manager != null) {
      return this.manager.a(paramString1, paramString2);
    }
    return new ArrayList();
  }
  
  public TroopHonorManager getTroopHonorManager()
  {
    if (this.mAppRuntime == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopHonorServiceImpl", 1, "mAppRuntime == null");
      }
      return null;
    }
    return (TroopHonorManager)((IManagerFactoryService)this.mAppRuntime.getRuntimeService(IManagerFactoryService.class, "")).getManager(TroopHonorManager.class);
  }
  
  public boolean isGrayTroopHonor(String paramString)
  {
    if (this.manager != null) {
      return this.manager.a(paramString);
    }
    return false;
  }
  
  public boolean isSupportTroopHonor(String paramString)
  {
    if (this.manager != null) {
      return this.manager.b(paramString);
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
    if (this.manager != null) {
      this.manager.a(paramShort);
    }
  }
  
  public void updateConfig(TroopHonorConfig paramTroopHonorConfig, boolean paramBoolean)
  {
    if (this.manager != null) {
      this.manager.a(paramTroopHonorConfig, paramBoolean);
    }
  }
  
  public boolean updateEntity(Entity paramEntity)
  {
    if (this.manager != null) {
      return this.manager.a(paramEntity);
    }
    return false;
  }
  
  public void updateHostHonorList(List<oidb_0xdc9.HonorList> paramList, boolean paramBoolean)
  {
    if (this.manager != null) {
      this.manager.a(paramList, paramBoolean);
    }
  }
  
  public void updateHostHonorList(boolean paramBoolean)
  {
    if (this.manager != null) {
      this.manager.a(paramBoolean);
    }
  }
  
  public void updatePushTroopHonor(String paramString, byte[] paramArrayOfByte, int paramInt)
  {
    if (this.manager != null) {
      this.manager.a(paramString, paramArrayOfByte, paramInt);
    }
  }
  
  public void updateTroopHonorAIOSwitch(String paramString, boolean paramBoolean)
  {
    if (this.manager != null) {
      this.manager.a(paramString, paramBoolean);
    }
  }
  
  public void updateTroopMemberHonor(String paramString1, String paramString2, String paramString3, byte paramByte, long paramLong)
  {
    if (this.manager != null) {
      this.manager.a(paramString1, paramString2, paramString3, paramByte, paramLong);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.honor.api.impl.TroopHonorServiceImpl
 * JD-Core Version:    0.7.0.1
 */