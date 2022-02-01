package com.tencent.mobileqq.troop.honor.api;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.qroute.annotation.Service;
import com.tencent.mobileqq.troop.honor.config.TroopHonor;
import com.tencent.mobileqq.troop.honor.config.TroopHonorConfig;
import java.util.List;
import mqq.app.api.IRuntimeService;
import tencent.im.oidb.oidb_0xdc9.oidb_0xdc9.HonorList;

@Service(process={""})
public abstract interface ITroopHonorService
  extends IRuntimeService
{
  public abstract void asyncGetTroopHonorListByDirect(String paramString1, String paramString2, ITroopHonorService.IGetTroopHonorListCallback paramIGetTroopHonorListCallback);
  
  public abstract List<TroopHonor> convertToHonorList(String paramString, Byte paramByte);
  
  public abstract List<TroopHonor> getTroopHonorList(String paramString1, String paramString2);
  
  public abstract boolean isGrayTroopHonor(String paramString);
  
  public abstract boolean isSupportTroopHonor(String paramString);
  
  public abstract void saveHostHonorListRichTag(short paramShort);
  
  public abstract void updateConfig(TroopHonorConfig paramTroopHonorConfig, boolean paramBoolean);
  
  public abstract boolean updateEntity(Entity paramEntity);
  
  public abstract void updateHostHonorList(List<oidb_0xdc9.HonorList> paramList, boolean paramBoolean);
  
  public abstract void updateHostHonorList(boolean paramBoolean);
  
  public abstract void updatePushTroopHonor(String paramString, byte[] paramArrayOfByte, int paramInt);
  
  public abstract void updateTroopHonorAIOSwitch(String paramString, boolean paramBoolean);
  
  public abstract void updateTroopMemberHonor(String paramString1, String paramString2, String paramString3, byte paramByte, long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.honor.api.ITroopHonorService
 * JD-Core Version:    0.7.0.1
 */