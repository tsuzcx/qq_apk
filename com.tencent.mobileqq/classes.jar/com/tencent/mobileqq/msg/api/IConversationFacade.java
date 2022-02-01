package com.tencent.mobileqq.msg.api;

import com.tencent.mobileqq.data.ConversationInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qroute.annotation.Service;
import java.util.List;
import java.util.Set;
import mqq.app.api.IRuntimeService;

@Service(process={""})
public abstract interface IConversationFacade
  extends IRuntimeService
{
  public abstract void addNewSayHelloToSet(int paramInt, String paramString);
  
  public abstract void addUnread(List<MessageRecord> paramList);
  
  public abstract void calculateNearbyBoxUnreadCount(String paramString, int paramInt);
  
  public abstract void cleanUnread(String paramString, int paramInt, long paramLong, boolean paramBoolean);
  
  public abstract void cleanUnread(String paramString, int paramInt, long paramLong, boolean paramBoolean1, boolean paramBoolean2);
  
  public abstract void cleanUnread(String paramString, int paramInt1, long paramLong, boolean paramBoolean1, boolean paramBoolean2, int paramInt2);
  
  public abstract void cleanUnreadFrom(String paramString, int paramInt, long paramLong);
  
  public abstract void decreaseUnread(String paramString, int paramInt, MessageRecord paramMessageRecord);
  
  public abstract void decreaseUnreads(String paramString, int paramInt, List<MessageRecord> paramList);
  
  public abstract ConversationInfo getConversationInfo(String paramString, int paramInt);
  
  public abstract Set<ConversationInfo> getConversationInfoSet();
  
  public abstract long getLastRead(String paramString, int paramInt);
  
  public abstract int getPublicAccountConversationRedMask(String paramString, int paramInt);
  
  public abstract int getReadUnreadCount(String paramString, int paramInt);
  
  public abstract int getReadUnreadMark(String paramString, int paramInt);
  
  public abstract ConversationInfo getTinyConvInfo(String paramString, int paramInt);
  
  public abstract int getTroopMask(String paramString);
  
  public abstract int getUnreadCount(String paramString, int paramInt);
  
  public abstract int getUnreadCountConfess(String paramString, int paramInt1, int paramInt2);
  
  public abstract int getUnreadCountFromExtInt2(String paramString, int paramInt);
  
  public abstract void increaseUnread(String paramString, int paramInt1, int paramInt2);
  
  public abstract boolean isInMsgBox(String paramString, int paramInt);
  
  public abstract boolean isInMsgBox(String paramString1, int paramInt, String paramString2);
  
  public abstract boolean isSyncMsgFinish();
  
  public abstract boolean isUinInRecentList(String paramString, int paramInt);
  
  public abstract boolean isUinInRecentNotSubAccount(String paramString);
  
  public abstract void moveBoxToMessageTab(String paramString1, int paramInt1, String paramString2, int paramInt2);
  
  public abstract void removeUnreadItem(String paramString, int paramInt);
  
  public abstract void setSubAccountTroopUnReadMsg(String paramString, int paramInt1, int paramInt2);
  
  public abstract void setTroopMsgFilterToServer(String paramString, Integer paramInteger);
  
  public abstract void setUnreadMark(String paramString, int paramInt1, int paramInt2);
  
  public abstract void updateLastRead(String paramString, int paramInt, long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.msg.api.IConversationFacade
 * JD-Core Version:    0.7.0.1
 */