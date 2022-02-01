package com.tencent.mobileqq.troop.onlinemember.api;

import com.tencent.mobileqq.qroute.annotation.Service;
import com.tencent.mobileqq.troop.onlinemember.data.TroopOnlineMemberItem;
import java.util.List;
import mqq.app.api.IRuntimeService;

@Service(process={""})
public abstract interface ITroopOnlineMemberService
  extends IRuntimeService
{
  public abstract long getAIOTipsNextReqTime(String paramString);
  
  public abstract List<String> getAllGameOnlineList(String paramString);
  
  public abstract long getAllGameOnlineNextReqTime(String paramString);
  
  public abstract long getAllNextReqTime(String paramString);
  
  public abstract List<String> getAllOnlineList(String paramString);
  
  public abstract List<TroopOnlineMemberItem> getDetailMemberListFromCache(String paramString);
  
  public abstract long getDetailNextReqTime(String paramString);
  
  public abstract long getLastReqLocationTime();
  
  public abstract int getOnlineCount(String paramString);
  
  public abstract String getOnlineTip(String paramString);
  
  public abstract int getRequestListServiceType(String paramString);
  
  public abstract void removeDetailOnlineData(String paramString);
  
  public abstract void removeDetailOnlineList(String paramString);
  
  public abstract void setLastReqLocationTime(long paramLong);
  
  public abstract void updateAIOTipsCache(String paramString1, int paramInt1, String paramString2, int paramInt2, int paramInt3);
  
  public abstract void updateAllGameOnlineList(String paramString, List<String> paramList, int paramInt);
  
  public abstract void updateAllOnlineList(String paramString, List<String> paramList, int paramInt);
  
  public abstract void updateDetailOnlineListCache(String paramString1, List<TroopOnlineMemberItem> paramList, int paramInt1, String paramString2, int paramInt2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.onlinemember.api.ITroopOnlineMemberService
 * JD-Core Version:    0.7.0.1
 */