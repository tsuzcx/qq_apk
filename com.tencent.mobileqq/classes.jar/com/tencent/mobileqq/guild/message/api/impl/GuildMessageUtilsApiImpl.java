package com.tencent.mobileqq.guild.message.api.impl;

import android.content.ContentValues;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.imcore.message.BaseMessageManager;
import com.tencent.imcore.message.BaseMsgProxy;
import com.tencent.imcore.message.BaseQQMessageFacade;
import com.tencent.imcore.message.facade.api.IMessageFacadeService;
import com.tencent.mobileqq.data.AtTroopMemberInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.guild.api.IGuildHandlerNameApi;
import com.tencent.mobileqq.guild.message.GuildMsgProxyUtils;
import com.tencent.mobileqq.guild.message.MessageRecordForGuildWelcome;
import com.tencent.mobileqq.guild.message.api.IGuildMessageUtilsApi;
import com.tencent.mobileqq.guild.message.api.IGuildMessageUtilsApi.GuildAioInfo;
import com.tencent.mobileqq.guild.message.api.IGuildMsgSeqTimeService;
import com.tencent.mobileqq.guild.message.api.IGuildMsgSeqTimeService.MsgSeqTimeItem;
import com.tencent.mobileqq.guild.message.api.IGuildSendMessageHandler;
import com.tencent.mobileqq.guild.message.base.AbsGuildMessageUtilsCallback;
import com.tencent.mobileqq.guild.message.callback.GuildMessageCallbackRegister;
import com.tencent.mobileqq.guild.message.callback.GuildMessageProcessorCallbackConfig;
import com.tencent.mobileqq.guild.message.eventflow.GuildMsgEventInfo;
import com.tencent.mobileqq.guild.message.eventflow.GuildMsgEventInfo.VersionItem;
import com.tencent.mobileqq.guild.message.unread.api.IGuildMsgReadedService;
import com.tencent.mobileqq.guild.message.unread.api.IGuildUnreadCntService;
import com.tencent.mobileqq.guild.message.unread.api.IGuildUnreadCntService.UnreadCntInfo;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.troop.data.MessageInfo;
import com.tencent.mobileqq.troop.data.MessageNavInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.app.AppRuntime;
import org.json.JSONArray;
import org.json.JSONException;

public class GuildMessageUtilsApiImpl
  implements IGuildMessageUtilsApi
{
  private static final String TAG = "GuildMessageUtilsApiImpl";
  private static AbsGuildMessageUtilsCallback msgUtilsCB;
  
  static
  {
    try
    {
      if ((GuildMessageCallbackRegister.b != null) && (!GuildMessageCallbackRegister.b.isEmpty()))
      {
        Iterator localIterator = GuildMessageCallbackRegister.c.iterator();
        while (localIterator.hasNext()) {
          msgUtilsCB = (AbsGuildMessageUtilsCallback)((Class)localIterator.next()).newInstance();
        }
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.e("GuildMessageUtilsApiImpl", 1, "[static] ", localException);
    }
  }
  
  private boolean isOnlyAtMessage(MessageRecord paramMessageRecord, IGProChannelInfo paramIGProChannelInfo)
  {
    Object localObject = paramMessageRecord.mMessageInfo;
    boolean bool1 = false;
    boolean bool2 = false;
    if (localObject == null)
    {
      bool1 = bool2;
      if (paramIGProChannelInfo != null)
      {
        bool1 = bool2;
        if (paramIGProChannelInfo.getFinalMsgNotify() == 1) {
          bool1 = true;
        }
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[shouldShowNotificationPush][isOnlyAtMessage], getFinalMsgNotify: ");
      if (paramIGProChannelInfo != null) {
        paramMessageRecord = Integer.valueOf(paramIGProChannelInfo.getFinalMsgNotify());
      } else {
        paramMessageRecord = "null";
      }
      ((StringBuilder)localObject).append(paramMessageRecord);
      ((StringBuilder)localObject).append(", shouldNotify: ");
      ((StringBuilder)localObject).append(bool1);
      QLog.i("GuildMessageUtilsApiImpl", 1, ((StringBuilder)localObject).toString());
      return bool1;
    }
    paramMessageRecord = paramMessageRecord.mMessageInfo.c;
    if ((paramMessageRecord.a == 24) || (paramMessageRecord.a == 13)) {
      bool1 = true;
    }
    paramIGProChannelInfo = new StringBuilder();
    paramIGProChannelInfo.append("[shouldShowNotificationPush][isOnlyAtMessage], bizType: ");
    paramIGProChannelInfo.append(paramMessageRecord.a);
    paramIGProChannelInfo.append(", shouldNotify: ");
    paramIGProChannelInfo.append(bool1);
    QLog.i("GuildMessageUtilsApiImpl", 1, paramIGProChannelInfo.toString());
    return bool1;
  }
  
  public IGuildMessageUtilsApi.GuildAioInfo checkIfInGuildAio()
  {
    AbsGuildMessageUtilsCallback localAbsGuildMessageUtilsCallback = msgUtilsCB;
    if (localAbsGuildMessageUtilsCallback != null) {
      return localAbsGuildMessageUtilsCallback.a();
    }
    return null;
  }
  
  public long getCntSeqFromMR(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null) {
      return 0L;
    }
    try
    {
      long l = Long.parseLong(paramMessageRecord.getExtInfoFromExtStr("GUILD_MSG_CNT_NAME"));
      return l;
    }
    catch (Exception paramMessageRecord) {}
    return 0L;
  }
  
  public GuildMsgEventInfo getEventFlow(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null) {
      return null;
    }
    paramMessageRecord = paramMessageRecord.getExtInfoFromExtStr("GUILD_MSG_EVENT_INFO");
    if (TextUtils.isEmpty(paramMessageRecord)) {
      return null;
    }
    return GuildMsgEventInfo.a(paramMessageRecord);
  }
  
  public String getGuildIdFromAio(String paramString)
  {
    AbsGuildMessageUtilsCallback localAbsGuildMessageUtilsCallback = msgUtilsCB;
    if (localAbsGuildMessageUtilsCallback != null) {
      return localAbsGuildMessageUtilsCallback.a(paramString);
    }
    return "";
  }
  
  public long getGuildIdFromMR(MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord != null) && (!TextUtils.isEmpty(paramMessageRecord.extStr)) && (paramMessageRecord.extStr.contains("GUILD_ID"))) {
      paramMessageRecord = paramMessageRecord.getExtInfoFromExtStr("GUILD_ID");
    }
    try
    {
      long l = Long.parseLong(paramMessageRecord);
      return l;
    }
    catch (Exception paramMessageRecord)
    {
      label40:
      break label40;
    }
    return 0L;
  }
  
  public Class<? extends MessageRecord> getMessageRecordForGuildWelcomeClazz()
  {
    return MessageRecordForGuildWelcome.class;
  }
  
  public byte[] getMsgMetaFromMr(MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord != null) && (!TextUtils.isEmpty(paramMessageRecord.extStr)) && (paramMessageRecord.extStr.contains("GUILD_MSG_META_STR")))
    {
      paramMessageRecord = paramMessageRecord.getExtInfoFromExtStr("GUILD_MSG_META_STR");
      if (paramMessageRecord != null) {
        return Base64.decode(paramMessageRecord, 0);
      }
    }
    return null;
  }
  
  public int getMsgRandomByMsgUid_Hummer(long paramLong)
  {
    return (int)(paramLong & 0xFFFFFFFF);
  }
  
  public MessageRecord getNewMessageRecordForGuildWelcome()
  {
    return new MessageRecordForGuildWelcome();
  }
  
  public void handleSelfSendMsg(AppInterface paramAppInterface, MessageRecord paramMessageRecord1, MessageRecord paramMessageRecord2, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("handleSelfSendMsg : findMr: ");
      ((StringBuilder)localObject).append(paramMessageRecord2.toString());
      ((StringBuilder)localObject).append(", extstr: ");
      ((StringBuilder)localObject).append(paramMessageRecord2.extStr);
      ((StringBuilder)localObject).append(", newMr: ");
      ((StringBuilder)localObject).append(paramMessageRecord1.toString());
      ((StringBuilder)localObject).append(", extstr: ");
      ((StringBuilder)localObject).append(paramMessageRecord1.extStr);
      ((StringBuilder)localObject).append(", fromeType: ");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("GuildMessageUtilsApiImpl", 2, ((StringBuilder)localObject).toString());
    }
    paramMessageRecord2.extStr = paramMessageRecord1.extStr;
    paramMessageRecord2.mExJsonObject = paramMessageRecord1.mExJsonObject;
    paramMessageRecord2.extLong = paramMessageRecord1.extLong;
    paramMessageRecord2.senderuin = paramMessageRecord1.senderuin;
    Object localObject = ((IMessageFacadeService)QRoute.api(IMessageFacadeService.class)).getMessageFacade((BaseQQAppInterface)paramAppInterface).a(10014).a(10014);
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("extStr", paramMessageRecord2.extStr);
    localContentValues.put("extLong", Integer.valueOf(paramMessageRecord2.extLong));
    localContentValues.put("senderuin", paramMessageRecord2.senderuin);
    ((BaseMsgProxy)localObject).a(paramMessageRecord2.frienduin, 10014, paramMessageRecord2.uniseq, localContentValues);
    updateMsgSeqAndTime(paramAppInterface, paramMessageRecord2.uniseq, paramMessageRecord1);
    GuildMessageProcessorCallbackConfig.a();
    GuildMessageProcessorCallbackConfig.a(paramMessageRecord1, paramMessageRecord2);
    if ((((MessageCache)paramAppInterface.getMsgCache()).f(paramMessageRecord2)) && (paramInt != 3)) {
      ((IGuildSendMessageHandler)paramAppInterface.getBusinessHandler(((IGuildHandlerNameApi)QRoute.api(IGuildHandlerNameApi.class)).getGuildSendMsgHandlerName())).a(paramMessageRecord1.frienduin, paramMessageRecord1.uniseq, paramMessageRecord2.msgseq);
    }
    paramMessageRecord1 = new ArrayList();
    paramMessageRecord1.add(paramMessageRecord2);
    ((IGuildMsgSeqTimeService)paramAppInterface.getRuntimeService(IGuildMsgSeqTimeService.class, "")).updateLastSeqAndTime(paramMessageRecord1);
    if (QLog.isColorLevel())
    {
      paramAppInterface = new StringBuilder();
      paramAppInterface.append("after handleSelfSendMsg. findMr: ");
      paramAppInterface.append(paramMessageRecord2.toString());
      paramAppInterface.append(", extstr: ");
      paramAppInterface.append(paramMessageRecord2.extStr);
      QLog.d("GuildMessageUtilsApiImpl", 2, paramAppInterface.toString());
    }
  }
  
  public boolean isAtAllMsg(MessageRecord paramMessageRecord)
  {
    AbsGuildMessageUtilsCallback localAbsGuildMessageUtilsCallback = msgUtilsCB;
    if (localAbsGuildMessageUtilsCallback != null) {
      return localAbsGuildMessageUtilsCallback.a(paramMessageRecord);
    }
    return false;
  }
  
  public boolean isGuest(String paramString)
  {
    AbsGuildMessageUtilsCallback localAbsGuildMessageUtilsCallback = msgUtilsCB;
    if (localAbsGuildMessageUtilsCallback != null) {
      return localAbsGuildMessageUtilsCallback.b(paramString);
    }
    return false;
  }
  
  public boolean isLocalOnlyMsg(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null) {
      return false;
    }
    if (GuildMsgProxyUtils.a(paramMessageRecord)) {
      return true;
    }
    return "1".equals(paramMessageRecord.getExtInfoFromExtStr("GUILD_MSG_LOCAL_ONLY"));
  }
  
  public boolean isMsgVisible(MessageRecord paramMessageRecord)
  {
    return (paramMessageRecord != null) && (paramMessageRecord.msgtype != -2006);
  }
  
  public boolean isSysMsg(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null) {
      return false;
    }
    return paramMessageRecord.getExtInfoFromExtStr("GUILD_MSG_TYPE").equals(String.valueOf(3841));
  }
  
  public void saveAtInfoList(MessageRecord paramMessageRecord, ArrayList<AtTroopMemberInfo> paramArrayList)
  {
    if (paramMessageRecord == null) {
      return;
    }
    if (paramArrayList.size() > 0) {
      try
      {
        JSONArray localJSONArray = new JSONArray();
        int i = 0;
        paramArrayList = paramArrayList.iterator();
        while (paramArrayList.hasNext())
        {
          localJSONArray.put(i, ((AtTroopMemberInfo)paramArrayList.next()).toJsonObject());
          i += 1;
        }
        paramMessageRecord.saveExtInfoToExtStr("guild_at_info_list", localJSONArray.toString());
        return;
      }
      catch (JSONException paramMessageRecord)
      {
        paramMessageRecord.printStackTrace();
        return;
      }
    }
    paramMessageRecord.removeExtInfoToExtStr("guild_at_info_list");
  }
  
  public void saveEventFlowToMsg(MessageRecord paramMessageRecord, GuildMsgEventInfo paramGuildMsgEventInfo)
  {
    if (paramMessageRecord == null) {
      return;
    }
    Object localObject = getEventFlow(paramMessageRecord);
    if (localObject != null)
    {
      if (((GuildMsgEventInfo)localObject).b > paramGuildMsgEventInfo.b) {
        paramGuildMsgEventInfo.b = ((GuildMsgEventInfo)localObject).b;
      }
      localObject = ((GuildMsgEventInfo)localObject).a.iterator();
      while (((Iterator)localObject).hasNext())
      {
        GuildMsgEventInfo.VersionItem localVersionItem1 = (GuildMsgEventInfo.VersionItem)((Iterator)localObject).next();
        GuildMsgEventInfo.VersionItem localVersionItem2 = paramGuildMsgEventInfo.a(localVersionItem1.a);
        if (localVersionItem2 != null)
        {
          if (localVersionItem1.b > localVersionItem2.b) {
            localVersionItem2.b = localVersionItem1.b;
          }
          if (localVersionItem1.c > localVersionItem2.c) {
            localVersionItem2.c = localVersionItem1.c;
          }
        }
        else
        {
          paramGuildMsgEventInfo.a.add(localVersionItem1);
        }
      }
    }
    paramMessageRecord.saveExtInfoToExtStr("GUILD_MSG_EVENT_INFO", paramGuildMsgEventInfo.c());
  }
  
  public void saveEventToMsg(MessageRecord paramMessageRecord, GuildMsgEventInfo.VersionItem paramVersionItem)
  {
    if (paramMessageRecord == null) {
      return;
    }
    GuildMsgEventInfo localGuildMsgEventInfo = getEventFlow(paramMessageRecord);
    if (localGuildMsgEventInfo != null)
    {
      GuildMsgEventInfo.VersionItem localVersionItem = localGuildMsgEventInfo.a(paramVersionItem.a);
      if (localVersionItem != null)
      {
        if (localVersionItem.c < paramVersionItem.c) {
          localVersionItem.c = paramVersionItem.c;
        }
      }
      else {
        localGuildMsgEventInfo.a.add(paramVersionItem);
      }
      paramMessageRecord.saveExtInfoToExtStr("GUILD_MSG_EVENT_INFO", localGuildMsgEventInfo.c());
      return;
    }
    localGuildMsgEventInfo = new GuildMsgEventInfo();
    localGuildMsgEventInfo.a.add(paramVersionItem);
    paramMessageRecord.saveExtInfoToExtStr("GUILD_MSG_EVENT_INFO", localGuildMsgEventInfo.c());
  }
  
  public void saveGuildIdToMR(MessageRecord paramMessageRecord, String paramString)
  {
    if (paramMessageRecord != null) {
      paramMessageRecord.saveExtInfoToExtStr("GUILD_ID", paramString);
    }
  }
  
  public void saveMsgMetaToMr(MessageRecord paramMessageRecord, byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null)
    {
      if (paramMessageRecord == null) {
        return;
      }
      paramMessageRecord.saveExtInfoToExtStr("GUILD_MSG_META_STR", Base64.encodeToString(paramArrayOfByte, 0));
    }
  }
  
  public void saveSyncTimeToMsg(MessageRecord paramMessageRecord, long paramLong)
  {
    if (paramMessageRecord == null) {
      return;
    }
    GuildMsgEventInfo localGuildMsgEventInfo = getEventFlow(paramMessageRecord);
    localGuildMsgEventInfo.b = paramLong;
    saveEventFlowToMsg(paramMessageRecord, localGuildMsgEventInfo);
  }
  
  public void setMsgReaded(AppInterface paramAppInterface, MessageRecord paramMessageRecord)
  {
    try
    {
      long l = Long.parseLong(paramMessageRecord.getExtInfoFromExtStr("GUILD_MSG_CNT_NAME"));
      IGuildMsgSeqTimeService.MsgSeqTimeItem localMsgSeqTimeItem = new IGuildMsgSeqTimeService.MsgSeqTimeItem(paramMessageRecord.shmsgseq, l, paramMessageRecord.time, getMsgMetaFromMr(paramMessageRecord));
      ((IGuildMsgReadedService)paramAppInterface.getRuntimeService(IGuildMsgReadedService.class, "")).setMsgReadedAndReport(String.valueOf(getGuildIdFromMR(paramMessageRecord)), paramMessageRecord.frienduin, localMsgSeqTimeItem);
      return;
    }
    catch (Exception paramAppInterface) {}
  }
  
  public boolean shouldShowNotificationPush(AppRuntime paramAppRuntime, MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null) {
      return false;
    }
    String str2 = paramMessageRecord.frienduin;
    IGProChannelInfo localIGProChannelInfo = ((IGPSService)paramAppRuntime.getRuntimeService(IGPSService.class, "")).getChannelInfo(str2);
    if (localIGProChannelInfo == null)
    {
      paramAppRuntime = new StringBuilder();
      paramAppRuntime.append("[shouldShowNotificationPush], channelId: ");
      paramAppRuntime.append(str2);
      paramAppRuntime.append(", messageRecord seq: ");
      paramAppRuntime.append(paramMessageRecord.shmsgseq);
      paramAppRuntime.append(", channelInfo = null!");
      QLog.e("GuildMessageUtilsApiImpl", 1, paramAppRuntime.toString());
      return false;
    }
    if (localIGProChannelInfo.getFinalMsgNotify() == 1) {
      paramAppRuntime = ((IGuildUnreadCntService)paramAppRuntime.getRuntimeService(IGuildUnreadCntService.class, "")).getChannelUnreadCnt(str2, 1);
    } else {
      paramAppRuntime = ((IGuildUnreadCntService)paramAppRuntime.getRuntimeService(IGuildUnreadCntService.class, "")).getChannelUnreadCnt(str2, 6);
    }
    if ((paramAppRuntime != null) && (paramAppRuntime.b != 2) && (paramAppRuntime.a > 0L))
    {
      if ((localIGProChannelInfo.getFinalMsgNotify() != 2) && (localIGProChannelInfo.getFinalMsgNotify() != 1))
      {
        paramAppRuntime = new StringBuilder();
        paramAppRuntime.append("[shouldShowNotificationPush], should NOT show notification push. getFinalMsgNotify() = ");
        paramAppRuntime.append(localIGProChannelInfo.getFinalMsgNotify());
        paramAppRuntime.append(", channelId: ");
        paramAppRuntime.append(str2);
        QLog.i("GuildMessageUtilsApiImpl", 1, paramAppRuntime.toString());
        return false;
      }
      return isOnlyAtMessage(paramMessageRecord, localIGProChannelInfo);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[shouldShowNotificationPush], messageRecord seq: ");
    localStringBuilder.append(paramMessageRecord.shmsgseq);
    localStringBuilder.append(", unreadCntInfo showType: ");
    String str1 = "null";
    if (paramAppRuntime != null) {
      paramMessageRecord = Integer.valueOf(paramAppRuntime.b);
    } else {
      paramMessageRecord = "null";
    }
    localStringBuilder.append(paramMessageRecord);
    localStringBuilder.append(", unreadCntInfo unread: ");
    paramMessageRecord = str1;
    if (paramAppRuntime != null) {
      paramMessageRecord = Long.valueOf(paramAppRuntime.a);
    }
    localStringBuilder.append(paramMessageRecord);
    localStringBuilder.append(", getFinalMsgNotify: ");
    localStringBuilder.append(localIGProChannelInfo.getFinalMsgNotify());
    localStringBuilder.append(", channelId: ");
    localStringBuilder.append(str2);
    QLog.i("GuildMessageUtilsApiImpl", 1, localStringBuilder.toString());
    return false;
  }
  
  public void updateMsgSeqAndTime(AppInterface paramAppInterface, long paramLong, MessageRecord paramMessageRecord)
  {
    Object localObject = (IMessageFacadeService)QRoute.api(IMessageFacadeService.class);
    BaseQQAppInterface localBaseQQAppInterface = (BaseQQAppInterface)paramAppInterface;
    localObject = ((IMessageFacadeService)localObject).getMessageFacade(localBaseQQAppInterface).a(10014).a(10014).a(paramMessageRecord.frienduin, 10014, paramLong, paramMessageRecord.shmsgseq, paramMessageRecord.time);
    ((IMessageFacadeService)QRoute.api(IMessageFacadeService.class)).getMessageFacade(localBaseQQAppInterface).a(10014).a(paramMessageRecord.frienduin, 10014, (MessageRecord)localObject, 3);
    setMsgReaded(paramAppInterface, (MessageRecord)localObject);
    ((IMessageFacade)paramAppInterface.getRuntimeService(IMessageFacade.class, "")).setChangeAndNotify(localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.message.api.impl.GuildMessageUtilsApiImpl
 * JD-Core Version:    0.7.0.1
 */