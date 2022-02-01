package com.tencent.mobileqq.troop.uniquetitle.api;

import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import com.tencent.mobileqq.qroute.annotation.Service;
import mqq.app.api.IRuntimeService;

@Service(process={""})
public abstract interface IUniqueTitleService
  extends IRuntimeService
{
  public static final String UNIQUE_TITLE_NEW_FLAG = "uniqueTitleNewFlag";
  
  public abstract long getOldestUniqueTitleExpireTime(String paramString);
  
  public abstract void getTroopMemberUniqueTitle(String paramString, long paramLong1, long paramLong2, ProtoUtils.TroopProtocolObserver paramTroopProtocolObserver);
  
  public abstract int getUniqueTitleNewFlag();
  
  public abstract boolean hasUniqueTitleExpireNotified(String paramString1, String paramString2);
  
  public abstract void saveTroopMemberUniqueTitle(String paramString1, String paramString2, String paramString3);
  
  public abstract void saveTroopMemberUniqueTitle(String paramString1, String paramString2, String paramString3, int paramInt);
  
  public abstract void saveTroopMemberUniqueTitle(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2);
  
  public abstract void saveTroopMemeberUniqueTitleAndExpire(String paramString1, String paramString2, String paramString3, int paramInt);
  
  public abstract void setOldestUniqueTitleExpireTime(String paramString, long paramLong);
  
  public abstract void setUniqueTitleExpireNotified(String paramString1, String paramString2, boolean paramBoolean);
  
  public abstract void setUniqueTitleNewFlag(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.uniquetitle.api.IUniqueTitleService
 * JD-Core Version:    0.7.0.1
 */