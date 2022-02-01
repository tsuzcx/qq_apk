package com.tencent.mobileqq.troop.api;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.qroute.annotation.Service;
import com.tencent.mobileqq.troop.data.ShowExternalTroop;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.api.IRuntimeService;
import tencent.im.oidb.cmd0xb36.oidb_cmd0xb36.RspBody;
import tencent.im.oidb.cmd0xb36.oidb_cmd0xb36.ToastInfo;

@Service(process={""})
public abstract interface IBizTroopInfoService
  extends IRuntimeService
{
  public abstract boolean addShowExternalTroop(String paramString, long paramLong);
  
  public abstract int getAssociatedTroopCount(String paramString);
  
  public abstract String getCurrentOpenTroop();
  
  public abstract ConcurrentHashMap<String, Entity> getShowExternalTroopLazyCache();
  
  public abstract List<ShowExternalTroop> getShowExternalTroopList();
  
  public abstract oidb_cmd0xb36.ToastInfo getTroopSurveyList(String paramString);
  
  public abstract boolean getmIsShowTroopBigClub();
  
  public abstract boolean isCurrentOpenTroop(String paramString);
  
  public abstract boolean isFansTroop(String paramString);
  
  public abstract boolean isShowExternalTroop(String paramString);
  
  public abstract boolean isShowTroopBigClub();
  
  public abstract boolean isTroopAIOOpen();
  
  public abstract boolean isTroopConfessPanelOpen();
  
  public abstract void onTroopReceiveOrSendMsg(String paramString);
  
  public abstract void prePareShowExternalTroop(Map<String, Long> paramMap);
  
  public abstract void refreshShowExternalTroop();
  
  public abstract boolean removeShowExternalTroop(String paramString);
  
  public abstract void setAssociatedTroopCount(String paramString, int paramInt);
  
  public abstract void setCurrentOpenTroop(String paramString);
  
  public abstract void setShowTroopBigClub(boolean paramBoolean);
  
  public abstract void setTroopAIOOpen(boolean paramBoolean);
  
  public abstract void setTroopConfessPanelOpen(boolean paramBoolean);
  
  public abstract void updateTroopSurveyList(oidb_cmd0xb36.RspBody paramRspBody);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.api.IBizTroopInfoService
 * JD-Core Version:    0.7.0.1
 */