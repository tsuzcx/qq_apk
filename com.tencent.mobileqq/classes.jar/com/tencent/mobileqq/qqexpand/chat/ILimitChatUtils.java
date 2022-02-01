package com.tencent.mobileqq.qqexpand.chat;

import android.content.Context;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qqexpand.bean.match.MatchInfo;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.gdt.qq_ad_get.QQAdGet;

@QAPI(process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/qqexpand/chat/ILimitChatUtils;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "addExtendFriendUserInfo", "", "app", "Lcom/tencent/common/app/business/BaseQQAppInterface;", "toUin", "", "tagID", "", "tagName", "showTopicMsg", "", "fromType", "addFriendConversationNode", "matchUin", "addGrayTipsMessage", "uinType", "nickName", "tipsString", "tipsID", "keyWordString", "actionType", "lastMessage", "Lcom/tencent/mobileqq/data/MessageRecord;", "addTopicMessage", "", "matchInfo", "Lcom/tencent/mobileqq/qqexpand/bean/match/MatchInfo;", "msgTime", "from", "bNeedShowLimitChatByAllController", "checkInterceptMatchMessage", "mr", "closeIceBreakingPanel", "createRequest", "Ltencent/gdt/qq_ad_get$QQAdGet;", "uin", "posId", "count", "deepLinkVersion", "getLimitChatOnPlusName", "getSessionId", "currentAccountUinStr", "matchUinStr", "handleLimitChatC2CConfirmMsg", "msgR", "Lcom/tencent/common/app/AppInterface;", "handlePreLoadDataForArkMiniProfileCard", "createConversationNode", "data", "", "hasMiniProfileCard", "list", "", "hasValidMessage", "hasWatchedAdvertise", "isExtendMatchChatMsg", "isExtendMatchChatType", "isSystemMessage", "msgType", "needAddFriendConversationNode", "preLoadDataForArkMiniProfileCard", "extendObserver", "Lcom/tencent/mobileqq/app/BusinessObserver;", "(Lcom/tencent/common/app/business/BaseQQAppInterface;Ljava/lang/Long;Lcom/tencent/mobileqq/app/BusinessObserver;)V", "resetMatchChatAIOData", "startAddFriendActivity", "context", "Landroid/content/Context;", "friendUin", "friendNick", "Companion", "qqexpand-api_release"}, k=1, mv={1, 1, 16})
public abstract interface ILimitChatUtils
  extends QRouteApi
{
  public static final ILimitChatUtils.Companion Companion = ILimitChatUtils.Companion.a;
  @NotNull
  public static final String EXT_KEY_LIMIT_CHAT_ENTER_TYPE = "key_limitchat_enter_type";
  @NotNull
  public static final String EXT_KEY_LIMIT_CHAT_FROME_TYPE = "key_limitchat_from_type";
  @NotNull
  public static final String EXT_KEY_LIMIT_CHAT_MATCH_PURPOSE = "key_limitchat_match_purpose";
  @NotNull
  public static final String EXT_KEY_LIMIT_CHAT_MATCH_SEX_TYPE = "key_limitchat_match_sex_type";
  
  public abstract void addExtendFriendUserInfo(@Nullable BaseQQAppInterface paramBaseQQAppInterface, @Nullable String paramString1, int paramInt1, @Nullable String paramString2, boolean paramBoolean, int paramInt2);
  
  public abstract void addFriendConversationNode(@Nullable BaseQQAppInterface paramBaseQQAppInterface, @Nullable String paramString);
  
  public abstract void addGrayTipsMessage(@Nullable BaseQQAppInterface paramBaseQQAppInterface, @Nullable String paramString1, int paramInt1, @Nullable String paramString2, @Nullable String paramString3, int paramInt2, @Nullable String paramString4, int paramInt3, @Nullable MessageRecord paramMessageRecord);
  
  public abstract long addTopicMessage(@Nullable BaseQQAppInterface paramBaseQQAppInterface, @Nullable MatchInfo paramMatchInfo, long paramLong, int paramInt1, int paramInt2);
  
  public abstract boolean bNeedShowLimitChatByAllController(@Nullable BaseQQAppInterface paramBaseQQAppInterface);
  
  public abstract boolean checkInterceptMatchMessage(@Nullable BaseQQAppInterface paramBaseQQAppInterface, @Nullable MessageRecord paramMessageRecord);
  
  public abstract void closeIceBreakingPanel(@Nullable BaseQQAppInterface paramBaseQQAppInterface, @Nullable String paramString);
  
  @Nullable
  public abstract qq_ad_get.QQAdGet createRequest(long paramLong, @Nullable String paramString, int paramInt1, int paramInt2);
  
  @Nullable
  public abstract String getLimitChatOnPlusName(@Nullable BaseQQAppInterface paramBaseQQAppInterface);
  
  @Nullable
  public abstract String getSessionId(@Nullable String paramString1, @Nullable String paramString2);
  
  public abstract void handleLimitChatC2CConfirmMsg(@Nullable MessageRecord paramMessageRecord, @Nullable AppInterface paramAppInterface);
  
  public abstract void handlePreLoadDataForArkMiniProfileCard(@Nullable BaseQQAppInterface paramBaseQQAppInterface, @Nullable String paramString, int paramInt, boolean paramBoolean, @NotNull Object paramObject);
  
  public abstract boolean hasMiniProfileCard(@Nullable List<? extends MessageRecord> paramList);
  
  public abstract boolean hasValidMessage(@Nullable List<? extends MessageRecord> paramList);
  
  public abstract boolean hasWatchedAdvertise(@Nullable BaseQQAppInterface paramBaseQQAppInterface, @Nullable String paramString);
  
  public abstract boolean isExtendMatchChatMsg(@Nullable MessageRecord paramMessageRecord);
  
  public abstract boolean isExtendMatchChatType(int paramInt);
  
  public abstract boolean isSystemMessage(int paramInt);
  
  public abstract boolean needAddFriendConversationNode(@Nullable BaseQQAppInterface paramBaseQQAppInterface, @Nullable String paramString);
  
  public abstract void preLoadDataForArkMiniProfileCard(@Nullable BaseQQAppInterface paramBaseQQAppInterface, @Nullable Long paramLong, @Nullable BusinessObserver paramBusinessObserver);
  
  public abstract void resetMatchChatAIOData(@Nullable BaseQQAppInterface paramBaseQQAppInterface, @Nullable String paramString);
  
  public abstract void startAddFriendActivity(@Nullable Context paramContext, @Nullable String paramString1, @Nullable String paramString2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.chat.ILimitChatUtils
 * JD-Core Version:    0.7.0.1
 */