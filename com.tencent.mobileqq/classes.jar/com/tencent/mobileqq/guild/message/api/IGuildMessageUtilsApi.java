package com.tencent.mobileqq.guild.message.api;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.AtTroopMemberInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.guild.message.eventflow.GuildMsgEventInfo;
import com.tencent.mobileqq.guild.message.eventflow.GuildMsgEventInfo.VersionItem;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.ArrayList;
import mqq.app.AppRuntime;

@QAPI(process={"all"})
public abstract interface IGuildMessageUtilsApi
  extends QRouteApi
{
  public static final String GUILD_AT_INFO_LIST = "guild_at_info_list";
  public static final String GUILD_ID_EXT_STR = "GUILD_ID";
  public static final int HANDLE_SELF_MSG_FROM_DUPLICATED_MSG = 3;
  public static final int HANDLE_SELF_MSG_FROM_PUSH = 2;
  public static final int HANDLE_SELF_MSG_FROM_RESP = 1;
  public static final String MSG_AT_ALL_SEQ = "GUILD_MSG_AT_ALL_SEQ";
  public static final String MSG_CHANNEL_NAME = "GUILD_MSG_CHANNEL_NAME";
  public static final String MSG_CNT_NAME = "GUILD_MSG_CNT_NAME";
  public static final String MSG_EVENT_INFO = "GUILD_MSG_EVENT_INFO";
  public static final String MSG_FROM_APPID = "GUILD_MSG_FROME_APPID";
  public static final String MSG_FROM_NICK = "GUILD_MSG_FROM_NICK";
  public static final String MSG_GAME_NICK = "GUILD_MSG_GAME_NICK";
  public static final String MSG_GAME_TYPE = "GUILD_MSG_GAME_TYPE";
  public static final String MSG_GUILD_CODE = "MSG_GUILD_CODE";
  public static final String MSG_GUILD_MEMBER_NAME = "MSG_GUILD_MEMBER_NAME";
  public static final String MSG_GUILD_MEMBER_NAME_SYNC_TIME = "MSG_GUILD_MEMBER_NAME_SYNC_TIME";
  public static final String MSG_GUILD_NAME = "MSG_GUILD_NAME";
  public static final String MSG_GUILD_TRANS_DATA = "MSG_GUILD_TRANS_DATA";
  public static final String MSG_LOCAL_ONLY = "GUILD_MSG_LOCAL_ONLY";
  public static final String MSG_META_STR = "GUILD_MSG_META_STR";
  public static final String MSG_NAME_TYPE = "GUILD_MSG_NAME_TYPE";
  public static final String MSG_NOTIFY_TYPE = "MSG_GUILD_NOTIFY_TYPE";
  public static final String MSG_SUB_TYPE = "GUILD_MSG_SUB_TYPE";
  public static final String MSG_TYPE = "GUILD_MSG_TYPE";
  public static final String MSG_UPDATE_MSG_SEQ = "GUILD_MSG_UPDATE_MSG_SEQ";
  public static final String MSG_VISIBLE_FLAG = "GUILD_MSG_VISIBLE_FLAG";
  
  public abstract IGuildMessageUtilsApi.GuildAioInfo checkIfInGuildAio();
  
  public abstract long getCntSeqFromMR(MessageRecord paramMessageRecord);
  
  public abstract GuildMsgEventInfo getEventFlow(MessageRecord paramMessageRecord);
  
  public abstract String getGuildIdFromAio(String paramString);
  
  public abstract long getGuildIdFromMR(MessageRecord paramMessageRecord);
  
  public abstract Class<? extends MessageRecord> getMessageRecordForGuildWelcomeClazz();
  
  public abstract byte[] getMsgMetaFromMr(MessageRecord paramMessageRecord);
  
  public abstract int getMsgRandomByMsgUid_Hummer(long paramLong);
  
  public abstract MessageRecord getNewMessageRecordForGuildWelcome();
  
  public abstract void handleSelfSendMsg(AppInterface paramAppInterface, MessageRecord paramMessageRecord1, MessageRecord paramMessageRecord2, int paramInt);
  
  public abstract boolean isAtAllMsg(MessageRecord paramMessageRecord);
  
  public abstract boolean isGuest(String paramString);
  
  public abstract boolean isLocalOnlyMsg(MessageRecord paramMessageRecord);
  
  public abstract boolean isMsgVisible(MessageRecord paramMessageRecord);
  
  public abstract boolean isSysMsg(MessageRecord paramMessageRecord);
  
  public abstract void saveAtInfoList(MessageRecord paramMessageRecord, ArrayList<AtTroopMemberInfo> paramArrayList);
  
  public abstract void saveEventFlowToMsg(MessageRecord paramMessageRecord, GuildMsgEventInfo paramGuildMsgEventInfo);
  
  public abstract void saveEventToMsg(MessageRecord paramMessageRecord, GuildMsgEventInfo.VersionItem paramVersionItem);
  
  public abstract void saveGuildIdToMR(MessageRecord paramMessageRecord, String paramString);
  
  public abstract void saveMsgMetaToMr(MessageRecord paramMessageRecord, byte[] paramArrayOfByte);
  
  public abstract void saveSyncTimeToMsg(MessageRecord paramMessageRecord, long paramLong);
  
  public abstract void setMsgReaded(AppInterface paramAppInterface, MessageRecord paramMessageRecord);
  
  public abstract boolean shouldShowNotificationPush(AppRuntime paramAppRuntime, MessageRecord paramMessageRecord);
  
  public abstract void updateMsgSeqAndTime(AppInterface paramAppInterface, long paramLong, MessageRecord paramMessageRecord);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.message.api.IGuildMessageUtilsApi
 * JD-Core Version:    0.7.0.1
 */