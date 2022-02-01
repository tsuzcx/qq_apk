package com.tencent.mobileqq.msg.api.impl;

import android.os.Bundle;
import android.os.Handler;
import com.tencent.common.app.AppInterface;
import com.tencent.imcore.message.Message;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.Registry;
import com.tencent.imcore.message.core.codec.IPBMsgElemDecoder;
import com.tencent.imcore.message.core.codec.RoutingType;
import com.tencent.imcore.message.core.codec.RoutingTypeGenerator;
import com.tencent.imcore.message.core.codec.UinTypeRoutingTypeMap;
import com.tencent.imcore.message.facade.QQMessageFacadeRefresher;
import com.tencent.mobileqq.app.BaseMessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.msgnotify.MsgNotifyManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.DraftSummaryInfo;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.gamecenter.message.TinyIdCache;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.revokemsg.RevokeMsgInfo;
import com.tencent.mobileqq.troop.data.TroopMessageManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Observer;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.AppRuntime;
import msf.msgsvc.msg_svc.RoutingHead;

public class MessageFacadeImpl
  implements IMessageFacade
{
  public static final String TAG = "MessageFacadeImpl";
  private QQAppInterface mApp;
  
  private QQMessageFacade getMessageFacade()
  {
    return this.mApp.getMessageFacade();
  }
  
  public void addAIOHeadMessage(String paramString, int paramInt, List<MessageRecord> paramList)
  {
    this.mApp.getMessageFacade().c(paramString, paramInt, paramList);
  }
  
  public void addMessage(MessageRecord paramMessageRecord, String paramString)
  {
    getMessageFacade().a(paramMessageRecord, paramString);
  }
  
  public void addMessage(MessageRecord paramMessageRecord, String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    if (checkAppRuntimeInValid()) {
      return;
    }
    getMessageFacade().a(paramMessageRecord, paramString, paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4);
  }
  
  public void addMessage(ArrayList<MessageRecord> paramArrayList, String paramString, boolean paramBoolean)
  {
    getMessageFacade().a(paramArrayList, paramString, paramBoolean);
  }
  
  public void addMessage(ArrayList<MessageRecord> paramArrayList, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    getMessageFacade().a(paramArrayList, paramString, paramBoolean1, paramBoolean2);
  }
  
  public void addMessage(ArrayList<MessageRecord> paramArrayList, String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    getMessageFacade().a(paramArrayList, paramString, paramBoolean1, paramBoolean2, paramBoolean3);
  }
  
  public void addMessage(List<MessageRecord> paramList, String paramString)
  {
    if (checkAppRuntimeInValid()) {
      return;
    }
    getMessageFacade().a(paramList, paramString, this.mApp.isBackgroundStop);
  }
  
  public void addMessage(List<MessageRecord> paramList, String paramString, boolean paramBoolean)
  {
    if (checkAppRuntimeInValid()) {
      return;
    }
    this.mApp.getMessageFacade().a(paramList, paramString, paramBoolean);
  }
  
  public void addMessageForMsgBackup(List<MessageRecord> paramList)
  {
    getMessageFacade().d(paramList);
  }
  
  public void addObserver(Observer paramObserver)
  {
    getMessageFacade().addObserver(paramObserver);
  }
  
  public void cancelNotificationWhenRevokeMessage(MessageRecord paramMessageRecord)
  {
    getMessageFacade().d.a(paramMessageRecord);
  }
  
  public boolean checkAppRuntimeInValid()
  {
    if (QLog.isColorLevel())
    {
      boolean bool;
      if (this.mApp == null) {
        bool = true;
      } else {
        bool = false;
      }
      QLog.d("MessageFacadeImpl", 2, new Object[] { "checkAppRuntimeInValid: ", Boolean.valueOf(bool) });
    }
    return this.mApp == null;
  }
  
  public int clearHistory(String paramString, int paramInt)
  {
    return getMessageFacade().c(paramString, paramInt);
  }
  
  public int clearHistory(String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    return getMessageFacade().b(paramString, paramInt, paramBoolean1, paramBoolean2);
  }
  
  public void clearInAioParallerPullMsgMark(String paramString, long paramLong1, long paramLong2)
  {
    getMessageFacade().p().b(paramString, paramLong1, paramLong2);
  }
  
  public void clearRecommendTroopMsgByMsgType(int paramInt)
  {
    this.mApp.getMessageFacade().e(paramInt);
  }
  
  public void clearTransFileInfo(String paramString)
  {
    getMessageFacade().b(paramString);
  }
  
  public MessageRecord constructMessageForText(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    MessageForText localMessageForText = new MessageForText();
    localMessageForText.selfuin = this.mApp.getCurrentAccountUin();
    localMessageForText.frienduin = paramString3;
    localMessageForText.istroop = paramInt;
    localMessageForText.senderuin = "";
    localMessageForText.time = NetConnInfoCenter.getServerTime();
    localMessageForText.msg = paramString1;
    localMessageForText.uniseq = paramString2.hashCode();
    return localMessageForText;
  }
  
  public void decodeMsg(MessageRecord paramMessageRecord)
  {
    getMessageFacade().a((Message)paramMessageRecord);
  }
  
  public void deleteObserver(Observer paramObserver)
  {
    getMessageFacade().deleteObserver(paramObserver);
  }
  
  public void dumpmsgs(String paramString, Collection<MessageRecord> paramCollection)
  {
    getMessageFacade().a(paramString, paramCollection);
  }
  
  public MessageRecord findLongMsgHead(MessageRecord paramMessageRecord)
  {
    return getMessageFacade().d(paramMessageRecord);
  }
  
  public List<MessageRecord> getAIOList(String paramString, int paramInt)
  {
    return new ArrayList(this.mApp.getMessageFacade().o(paramString, paramInt));
  }
  
  public List<ChatMessage> getAIOList(String paramString, int paramInt, long paramLong)
  {
    return getMessageFacade().i(paramString, paramInt, paramLong);
  }
  
  public List<MessageRecord> getAllMessages(String paramString, int paramInt, int[] paramArrayOfInt)
  {
    return getMessageFacade().a(paramString, paramInt, paramArrayOfInt);
  }
  
  public List<MessageRecord> getAllMessages(String paramString, int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    if (checkAppRuntimeInValid()) {
      return null;
    }
    return getMessageFacade().a(paramString, paramInt1, paramArrayOfInt, paramInt2);
  }
  
  public ConcurrentHashMap<String, Boolean> getAutoPullCache()
  {
    return getMessageFacade().h;
  }
  
  public Map<String, Message> getCachedMsg()
  {
    return this.mApp.getMessageFacade().a;
  }
  
  public String getCurrChatUin()
  {
    return this.mApp.getMessageFacade().l();
  }
  
  public DraftSummaryInfo getDraftSummaryInfo(String paramString, int paramInt)
  {
    return getMessageFacade().getDraftSummaryInfo(paramString, paramInt);
  }
  
  public Handler getFacadeHandler()
  {
    return getMessageFacade().c;
  }
  
  public Message getFirstUnreadMessage(String paramString, int paramInt)
  {
    return this.mApp.getMessageFacade().l(paramString, paramInt);
  }
  
  public Message getIncomingMsg()
  {
    return getMessageFacade().B();
  }
  
  public int getIsLastMsgCacheLazyLoad()
  {
    return getMessageFacade().m.b();
  }
  
  public boolean getIsLastMsgCacheLoaded()
  {
    return getMessageFacade().m.a();
  }
  
  public Message getLastMessage(String paramString, int paramInt)
  {
    return getMessageFacade().getLastMessage(paramString, paramInt);
  }
  
  public Message getLastMessage(String paramString, int paramInt1, int paramInt2)
  {
    return getMessageFacade().b(paramString, paramInt1, paramInt2);
  }
  
  public MessageRecord getLastMsgForMsgTab(String paramString, int paramInt)
  {
    return getMessageFacade().r(paramString, paramInt);
  }
  
  public MessageRecord getLastMsgForMsgTabWithAutoInit(String paramString, int paramInt)
  {
    return getMessageFacade().q(paramString, paramInt);
  }
  
  public List<MessageRecord> getMessages(String paramString, int paramInt1, int paramInt2)
  {
    return getMessageFacade().a(paramString, paramInt1, paramInt2);
  }
  
  public List<MessageRecord> getMessagesFromDB(String paramString, int paramInt1, long paramLong1, int paramInt2, long paramLong2, int[] paramArrayOfInt, int paramInt3)
  {
    if (checkAppRuntimeInValid()) {
      return null;
    }
    return getMessageFacade().a(paramString, paramInt1, paramLong1, paramInt2, paramLong2, paramArrayOfInt, paramInt3);
  }
  
  public MessageRecord getMsgItemByUniseq(String paramString, int paramInt, long paramLong)
  {
    return getMessageFacade().a(paramString, paramInt, paramLong);
  }
  
  public List<MessageRecord> getMsgList(String paramString, int paramInt)
  {
    if (checkAppRuntimeInValid()) {
      return null;
    }
    return getMessageFacade().h(paramString, paramInt);
  }
  
  public long getMsgUinSeq(MessageRecord paramMessageRecord)
  {
    return paramMessageRecord.uniseq;
  }
  
  public List<IPBMsgElemDecoder> getPBMsgElemsDecoders()
  {
    return getMessageFacade().c().e();
  }
  
  public ConcurrentHashMap<Integer, List<MessageRecord>> getPullCache()
  {
    return getMessageFacade().g;
  }
  
  public AtomicInteger getPullCounter()
  {
    return getMessageFacade().f;
  }
  
  public Object getQQMessageFacadeStub()
  {
    return getMessageFacade();
  }
  
  public int getQuickDBMsgCount(String paramString, long paramLong1, long paramLong2, boolean paramBoolean)
  {
    return getMessageFacade().a(paramString, paramLong1, paramLong2, paramBoolean);
  }
  
  public List<MessageRecord> getQuickDbMessage(String paramString1, String paramString2)
  {
    return getMessageFacade().c(paramString1, paramString2);
  }
  
  public Map<String, Boolean> getRefreshActionMap()
  {
    return getMessageFacade().b;
  }
  
  public Registry getRegistry()
  {
    return getMessageFacade().c();
  }
  
  public int getRoutingType(int paramInt)
  {
    return getMessageFacade().c().b().a(paramInt);
  }
  
  public MessageRecord getSendingTroopMsgItem(String paramString, int paramInt, MessageRecord paramMessageRecord)
  {
    return getMessageFacade().a(paramString, paramInt, paramMessageRecord);
  }
  
  public MessageRecord getSendingTroopMsgItem(String paramString, int paramInt, MessageRecord paramMessageRecord, List<MessageRecord> paramList)
  {
    return getMessageFacade().a(paramString, paramInt, paramMessageRecord, paramList);
  }
  
  public int getSlowDBMsgCount(String paramString, long paramLong1, long paramLong2, boolean paramBoolean)
  {
    return getMessageFacade().b(paramString, paramLong1, paramLong2, paramBoolean);
  }
  
  public List<MessageRecord> getSlowDbMessage(String paramString1, String paramString2)
  {
    return getMessageFacade().b(paramString1, paramString2);
  }
  
  public String getSqlStr(String paramString, long paramLong1, long paramLong2, long paramLong3, int paramInt, boolean paramBoolean)
  {
    return getMessageFacade().a(paramString, paramLong1, paramLong2, paramLong3, paramInt, paramBoolean);
  }
  
  public TinyIdCache getTinyIdCache()
  {
    return getMessageFacade().h();
  }
  
  public int getUinType(int paramInt)
  {
    return ((RoutingType)getMessageFacade().c().a().a(Integer.valueOf(paramInt))).a();
  }
  
  public int getUnreadMsgsNum()
  {
    return this.mApp.getMessageFacade().w();
  }
  
  public void handleReceivedMessage(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.mApp.handleReceivedMessage(paramInt, paramBoolean1, paramBoolean2);
  }
  
  public void handleRefreshMessageListHeadResult(String paramString, int paramInt, List<MessageRecord> paramList1, List<MessageRecord> paramList2, Bundle paramBundle)
  {
    getMessageFacade().a(paramString, paramInt, paramList1, paramList2, paramBundle);
  }
  
  public void handleRevokedNotifyAndNotify(ArrayList<RevokeMsgInfo> paramArrayList, boolean paramBoolean)
  {
    getMessageFacade().a(paramArrayList, paramBoolean);
  }
  
  public boolean isChatting()
  {
    return this.mApp.getMessageFacade().n();
  }
  
  public boolean isMessageForText(MessageRecord paramMessageRecord)
  {
    return (paramMessageRecord instanceof MessageForText);
  }
  
  public boolean isTheLastTabMsg(MessageRecord paramMessageRecord)
  {
    return getMessageFacade().b(paramMessageRecord);
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    if (QLog.isColorLevel())
    {
      boolean bool1 = false;
      boolean bool2 = paramAppRuntime instanceof QQAppInterface;
      if (paramAppRuntime == null) {
        bool1 = true;
      }
      QLog.d("MessageFacadeImpl", 2, new Object[] { "MessageFacadeImpl onCreate: app instanceOf QQApp: ", Boolean.valueOf(bool2), "app is null: ", Boolean.valueOf(bool1) });
    }
    if ((paramAppRuntime instanceof QQAppInterface)) {
      this.mApp = ((QQAppInterface)paramAppRuntime);
    }
  }
  
  public void onDestroy() {}
  
  public boolean pullRecentGroupMsg(String paramString)
  {
    return getMessageFacade().c(paramString);
  }
  
  public void putAioInParallelPullMsgMark(String paramString, long paramLong1, long paramLong2)
  {
    getMessageFacade().p().a(paramString, paramLong1, paramLong2);
  }
  
  public void qLogColor(String paramString1, String paramString2)
  {
    getMessageFacade().a(paramString1, paramString2);
  }
  
  public List<MessageRecord> queryMsgItemByShmsgseq(String paramString, int paramInt, long paramLong1, long paramLong2)
  {
    return getMessageFacade().b(paramString, paramInt, paramLong1, paramLong2);
  }
  
  public MessageRecord queryMsgItemByUniseq(String paramString, int paramInt, long paramLong)
  {
    return getMessageFacade().b(paramString, paramInt, paramLong);
  }
  
  public void removeMsgByMessageRecord(MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    if (checkAppRuntimeInValid()) {
      return;
    }
    if (paramMessageRecord != null) {
      getMessageFacade().a(paramMessageRecord, paramBoolean);
    }
  }
  
  public void removeMsgByUniseq(String paramString, int paramInt, long paramLong)
  {
    if (checkAppRuntimeInValid()) {
      return;
    }
    getMessageFacade().h(paramString, paramInt, paramLong);
  }
  
  public void removeMsgByUniseq(String paramString, int paramInt, long paramLong, boolean paramBoolean)
  {
    getMessageFacade().b(paramString, paramInt, paramLong, paramBoolean);
  }
  
  public boolean removeMsgFromCacheByUniseq(String paramString, int paramInt1, int paramInt2, long paramLong)
  {
    return this.mApp.getMessageFacade().a(paramString, paramInt1, paramInt2, paramLong);
  }
  
  public void removeNotification(String paramString, int paramInt)
  {
    getMessageFacade().d.a(paramString, paramInt);
  }
  
  public void removeRecentUser(RecentUser paramRecentUser)
  {
    getMessageFacade().a(paramRecentUser);
  }
  
  public void sendMessage(MessageRecord paramMessageRecord, BaseMessageObserver paramBaseMessageObserver)
  {
    if (checkAppRuntimeInValid()) {
      return;
    }
    if (paramMessageRecord == null) {
      return;
    }
    paramBaseMessageObserver = new MessageFacadeImpl.1(this, paramBaseMessageObserver);
    this.mApp.getMessageFacade().b(paramMessageRecord, paramBaseMessageObserver);
  }
  
  public void sendSpecialMessage(String paramString)
  {
    getMessageFacade().d(paramString);
  }
  
  public boolean setAutoPullC2CMsgResult(String paramString, int paramInt, List<MessageRecord> paramList, boolean paramBoolean)
  {
    return getMessageFacade().a(paramString, paramInt, paramList, paramBoolean);
  }
  
  public void setChangeAndNotify(Object paramObject)
  {
    if (checkAppRuntimeInValid()) {
      return;
    }
    getMessageFacade().a(paramObject);
  }
  
  public void setIncomingMsg(MessageRecord paramMessageRecord)
  {
    getMessageFacade().c((Message)paramMessageRecord);
  }
  
  public void setReadFrom(String paramString, int paramInt, long paramLong)
  {
    getMessageFacade().f(paramString, paramInt, paramLong);
  }
  
  public void setReadFrom(String paramString, int paramInt, long paramLong, boolean paramBoolean)
  {
    getMessageFacade().a(paramString, paramInt, paramLong, paramBoolean);
  }
  
  public void setReaded(String paramString, int paramInt)
  {
    this.mApp.getMessageFacade().a(paramString, paramInt);
  }
  
  public void setReaded(String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    getMessageFacade().a(paramString, paramInt, paramBoolean1, paramBoolean2);
  }
  
  public void setRecommendTroopMsgReaded(int paramInt)
  {
    this.mApp.getMessageFacade().c(paramInt);
  }
  
  public boolean setRoutingHead(AppInterface paramAppInterface, int paramInt, Object paramObject1, Object paramObject2)
  {
    if (((paramObject2 instanceof MessageRecord)) && ((paramObject1 instanceof msg_svc.RoutingHead)) && ((paramAppInterface instanceof QQAppInterface))) {
      return ((RoutingType)getMessageFacade().c().a().a(Integer.valueOf(paramInt))).a((msg_svc.RoutingHead)paramObject1, (MessageRecord)paramObject2, (QQAppInterface)paramAppInterface);
    }
    return false;
  }
  
  public void stopHttpProcessorIfNeed(MessageRecord paramMessageRecord)
  {
    getMessageFacade().e(paramMessageRecord);
  }
  
  public void updateGroupMsgSeqAndTimeByUniseq(String paramString, int paramInt, long paramLong1, long paramLong2, long paramLong3)
  {
    getMessageFacade().a(paramString, paramInt, paramLong1, paramLong2, paramLong3);
  }
  
  public void updateMsgContentByUniseq(String paramString, int paramInt, long paramLong, byte[] paramArrayOfByte)
  {
    if (checkAppRuntimeInValid()) {
      return;
    }
    getMessageFacade().a(paramString, paramInt, paramLong, paramArrayOfByte);
  }
  
  public void updateMsgFieldByUniseq(String paramString1, int paramInt, long paramLong, String paramString2, Object paramObject)
  {
    getMessageFacade().a(paramString1, paramInt, paramLong, paramString2, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msg.api.impl.MessageFacadeImpl
 * JD-Core Version:    0.7.0.1
 */