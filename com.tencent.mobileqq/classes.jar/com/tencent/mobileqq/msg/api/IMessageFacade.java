package com.tencent.mobileqq.msg.api;

import android.os.Bundle;
import android.os.Handler;
import com.tencent.common.app.AppInterface;
import com.tencent.imcore.message.Message;
import com.tencent.imcore.message.Registry;
import com.tencent.mobileqq.app.BaseMessageObserver;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.DraftSummaryInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.gamecenter.message.TinyIdCache;
import com.tencent.mobileqq.qroute.annotation.Service;
import com.tencent.mobileqq.revokemsg.RevokeMsgInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Observer;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.api.IRuntimeService;

@Service(needUin=false, process={""})
public abstract interface IMessageFacade
  extends IRuntimeService
{
  public abstract void addAIOHeadMessage(String paramString, int paramInt, List<MessageRecord> paramList);
  
  public abstract void addMessage(MessageRecord paramMessageRecord, String paramString);
  
  public abstract void addMessage(MessageRecord paramMessageRecord, String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4);
  
  public abstract void addMessage(ArrayList<MessageRecord> paramArrayList, String paramString, boolean paramBoolean);
  
  public abstract void addMessage(ArrayList<MessageRecord> paramArrayList, String paramString, boolean paramBoolean1, boolean paramBoolean2);
  
  public abstract void addMessage(ArrayList<MessageRecord> paramArrayList, String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3);
  
  public abstract void addMessage(List<MessageRecord> paramList, String paramString);
  
  public abstract void addMessage(List<MessageRecord> paramList, String paramString, boolean paramBoolean);
  
  public abstract void addMessageForMsgBackup(List<MessageRecord> paramList);
  
  public abstract void addObserver(Observer paramObserver);
  
  public abstract void cancelNotificationWhenRevokeMessage(MessageRecord paramMessageRecord);
  
  public abstract int clearHistory(String paramString, int paramInt);
  
  public abstract int clearHistory(String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2);
  
  public abstract void clearInAioParallerPullMsgMark(String paramString, long paramLong1, long paramLong2);
  
  public abstract void clearRecommendTroopMsgByMsgType(int paramInt);
  
  public abstract void clearTransFileInfo(String paramString);
  
  public abstract MessageRecord constructMessageForText(String paramString1, String paramString2, String paramString3, int paramInt);
  
  public abstract void decodeMsg(MessageRecord paramMessageRecord);
  
  public abstract void deleteObserver(Observer paramObserver);
  
  public abstract void dumpmsgs(String paramString, Collection<MessageRecord> paramCollection);
  
  public abstract MessageRecord findLongMsgHead(MessageRecord paramMessageRecord);
  
  public abstract List<MessageRecord> getAIOList(String paramString, int paramInt);
  
  public abstract List<ChatMessage> getAIOList(String paramString, int paramInt, long paramLong);
  
  public abstract List<MessageRecord> getAllMessages(String paramString, int paramInt, int[] paramArrayOfInt);
  
  public abstract List<MessageRecord> getAllMessages(String paramString, int paramInt1, int[] paramArrayOfInt, int paramInt2);
  
  public abstract ConcurrentHashMap<String, Boolean> getAutoPullCache();
  
  public abstract Map<String, Message> getCachedMsg();
  
  public abstract String getCurrChatUin();
  
  public abstract DraftSummaryInfo getDraftSummaryInfo(String paramString, int paramInt);
  
  public abstract Handler getFacadeHandler();
  
  public abstract Message getFirstUnreadMessage(String paramString, int paramInt);
  
  public abstract Message getIncomingMsg();
  
  public abstract int getIsLastMsgCacheLazyLoad();
  
  public abstract boolean getIsLastMsgCacheLoaded();
  
  public abstract Message getLastMessage(String paramString, int paramInt);
  
  public abstract Message getLastMessage(String paramString, int paramInt1, int paramInt2);
  
  public abstract MessageRecord getLastMsgForMsgTab(String paramString, int paramInt);
  
  public abstract MessageRecord getLastMsgForMsgTabWithAutoInit(String paramString, int paramInt);
  
  public abstract List<MessageRecord> getMessages(String paramString, int paramInt1, int paramInt2);
  
  public abstract List<MessageRecord> getMessagesFromDB(String paramString, int paramInt1, long paramLong1, int paramInt2, long paramLong2, int[] paramArrayOfInt, int paramInt3);
  
  public abstract MessageRecord getMsgItemByUniseq(String paramString, int paramInt, long paramLong);
  
  public abstract List<MessageRecord> getMsgList(String paramString, int paramInt);
  
  public abstract long getMsgUinSeq(MessageRecord paramMessageRecord);
  
  public abstract <T> List<T> getPBMsgElemsDecoders();
  
  public abstract ConcurrentHashMap<Integer, List<MessageRecord>> getPullCache();
  
  public abstract AtomicInteger getPullCounter();
  
  public abstract Object getQQMessageFacadeStub();
  
  public abstract int getQuickDBMsgCount(String paramString, long paramLong1, long paramLong2, boolean paramBoolean);
  
  public abstract List<MessageRecord> getQuickDbMessage(String paramString1, String paramString2);
  
  public abstract Map<String, Boolean> getRefreshActionMap();
  
  public abstract Registry getRegistry();
  
  public abstract int getRoutingType(int paramInt);
  
  public abstract MessageRecord getSendingTroopMsgItem(String paramString, int paramInt, MessageRecord paramMessageRecord);
  
  public abstract MessageRecord getSendingTroopMsgItem(String paramString, int paramInt, MessageRecord paramMessageRecord, List<MessageRecord> paramList);
  
  public abstract int getSlowDBMsgCount(String paramString, long paramLong1, long paramLong2, boolean paramBoolean);
  
  public abstract List<MessageRecord> getSlowDbMessage(String paramString1, String paramString2);
  
  public abstract String getSqlStr(String paramString, long paramLong1, long paramLong2, long paramLong3, int paramInt, boolean paramBoolean);
  
  public abstract TinyIdCache getTinyIdCache();
  
  public abstract int getUinType(int paramInt);
  
  public abstract int getUnreadMsgsNum();
  
  public abstract void handleReceivedMessage(int paramInt, boolean paramBoolean1, boolean paramBoolean2);
  
  public abstract void handleRefreshMessageListHeadResult(String paramString, int paramInt, List<MessageRecord> paramList1, List<MessageRecord> paramList2, Bundle paramBundle);
  
  public abstract void handleRevokedNotifyAndNotify(ArrayList<RevokeMsgInfo> paramArrayList, boolean paramBoolean);
  
  public abstract boolean isChatting();
  
  public abstract boolean isMessageForText(MessageRecord paramMessageRecord);
  
  public abstract boolean isTheLastTabMsg(MessageRecord paramMessageRecord);
  
  public abstract boolean pullRecentGroupMsg(String paramString);
  
  public abstract void putAioInParallelPullMsgMark(String paramString, long paramLong1, long paramLong2);
  
  public abstract void qLogColor(String paramString1, String paramString2);
  
  public abstract List<MessageRecord> queryMsgItemByShmsgseq(String paramString, int paramInt, long paramLong1, long paramLong2);
  
  public abstract MessageRecord queryMsgItemByUniseq(String paramString, int paramInt, long paramLong);
  
  public abstract void removeMsgByMessageRecord(MessageRecord paramMessageRecord, boolean paramBoolean);
  
  public abstract void removeMsgByUniseq(String paramString, int paramInt, long paramLong);
  
  public abstract void removeMsgByUniseq(String paramString, int paramInt, long paramLong, boolean paramBoolean);
  
  public abstract boolean removeMsgFromCacheByUniseq(String paramString, int paramInt1, int paramInt2, long paramLong);
  
  public abstract void removeNotification(String paramString, int paramInt);
  
  public abstract void removeRecentUser(RecentUser paramRecentUser);
  
  public abstract void sendMessage(MessageRecord paramMessageRecord, BaseMessageObserver paramBaseMessageObserver);
  
  public abstract void sendSpecialMessage(String paramString);
  
  public abstract boolean setAutoPullC2CMsgResult(String paramString, int paramInt, List<MessageRecord> paramList, boolean paramBoolean);
  
  public abstract void setChangeAndNotify(Object paramObject);
  
  public abstract void setIncomingMsg(MessageRecord paramMessageRecord);
  
  public abstract void setReadFrom(String paramString, int paramInt, long paramLong);
  
  public abstract void setReadFrom(String paramString, int paramInt, long paramLong, boolean paramBoolean);
  
  public abstract void setReaded(String paramString, int paramInt);
  
  public abstract void setReaded(String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2);
  
  public abstract void setRecommendTroopMsgReaded(int paramInt);
  
  public abstract boolean setRoutingHead(AppInterface paramAppInterface, int paramInt, Object paramObject1, Object paramObject2);
  
  public abstract void stopHttpProcessorIfNeed(MessageRecord paramMessageRecord);
  
  public abstract void updateGroupMsgSeqAndTimeByUniseq(String paramString, int paramInt, long paramLong1, long paramLong2, long paramLong3);
  
  public abstract void updateMsgContentByUniseq(String paramString, int paramInt, long paramLong, byte[] paramArrayOfByte);
  
  public abstract void updateMsgFieldByUniseq(String paramString1, int paramInt, long paramLong, String paramString2, Object paramObject);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msg.api.IMessageFacade
 * JD-Core Version:    0.7.0.1
 */