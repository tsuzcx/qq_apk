package com.tencent.mobileqq.troop.roamsetting.api;

import com.tencent.mobileqq.qroute.annotation.Service;
import com.tencent.mobileqq.troop.roamsetting.IReqGetSettingsHandler;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.api.IRuntimeService;

@Service(process={""})
public abstract interface IRoamSettingService
  extends IRuntimeService
{
  public abstract ConcurrentHashMap<String, Boolean> getMapRequest();
  
  public abstract ConcurrentHashMap<String, Integer> getMapUploading();
  
  public abstract IReqGetSettingsHandler getReqGetSettingsHandler();
  
  public abstract int getSettingValue(String paramString, int paramInt);
  
  public abstract int getTroopMsgFilter(String paramString, int paramInt);
  
  public abstract Map<String, Integer> getTroopMsgFilterList(List<String> paramList, int paramInt);
  
  public abstract void loadAllRoamSettings(boolean paramBoolean);
  
  public abstract String makeGeneralSettingsKey(String paramString, int paramInt);
  
  public abstract void setRoamSettingNewValue(String paramString, Integer paramInteger);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.roamsetting.api.IRoamSettingService
 * JD-Core Version:    0.7.0.1
 */