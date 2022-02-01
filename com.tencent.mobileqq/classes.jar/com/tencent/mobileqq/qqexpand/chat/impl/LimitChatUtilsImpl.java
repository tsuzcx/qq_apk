package com.tencent.mobileqq.qqexpand.chat.impl;

import android.content.Context;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qqexpand.bean.match.MatchInfo;
import com.tencent.mobileqq.qqexpand.chat.ILimitChatUtils;
import com.tencent.mobileqq.qqexpand.chat.utils.LimitChatUtil;
import com.tencent.mobileqq.qqexpand.manager.ExtendFriendLimitChatManager;
import com.tencent.mobileqq.qqexpand.network.IExpandCmdCallback;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.manager.Manager;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.gdt.qq_ad_get.QQAdGet;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/qqexpand/chat/impl/LimitChatUtilsImpl;", "Lcom/tencent/mobileqq/qqexpand/chat/ILimitChatUtils;", "()V", "addExtendFriendUserInfo", "", "app", "Lcom/tencent/common/app/business/BaseQQAppInterface;", "toUin", "", "tagID", "", "tagName", "showTopicMsg", "", "fromType", "addFriendConversationNode", "matchUin", "addGrayTipsMessage", "uinType", "nickName", "tipsString", "tipsID", "keyWordString", "actionType", "lastMessage", "Lcom/tencent/mobileqq/data/MessageRecord;", "addTopicMessage", "", "matchInfo", "Lcom/tencent/mobileqq/qqexpand/bean/match/MatchInfo;", "msgTime", "from", "bNeedShowLimitChatByAllController", "checkInterceptMatchMessage", "mr", "closeIceBreakingPanel", "createRequest", "Ltencent/gdt/qq_ad_get$QQAdGet;", "uin", "posId", "count", "deepLinkVersion", "getExtendFriendSwitch", "callback", "Lcom/tencent/mobileqq/qqexpand/network/IExpandCmdCallback;", "(Lcom/tencent/common/app/business/BaseQQAppInterface;Ljava/lang/Long;Lcom/tencent/mobileqq/qqexpand/network/IExpandCmdCallback;)V", "getExtendFriendUserSwitch", "getExtendFriendUserSwitchText", "getLimitChatOnPlusName", "getSessionId", "currentAccountUinStr", "matchUinStr", "handleLimitChatC2CConfirmMsg", "msgR", "Lcom/tencent/common/app/AppInterface;", "handlePreLoadDataForArkMiniProfileCard", "createConversationNode", "data", "", "handlePreLoadDataForAvatarProfileCard", "hasMiniProfileCard", "list", "", "hasValidMessage", "hasWatchedAdvertise", "isExtendMatchChatMsg", "isExtendMatchChatType", "isSystemMessage", "msgType", "needAddFriendConversationNode", "preLoadDataForArkMiniProfileCard", "extendObserver", "Lcom/tencent/mobileqq/app/BusinessObserver;", "(Lcom/tencent/common/app/business/BaseQQAppInterface;Ljava/lang/Long;Lcom/tencent/mobileqq/app/BusinessObserver;)V", "preLoadDataForAvatarProfileCard", "requestAddMatchedRelation", "hostUin", "friendUin", "matchSourceId", "resetMatchChatAIOData", "saveTempC2cSignature", "Lmqq/app/AppRuntime;", "signature", "", "setExtendFriendSwitch", "siwtchOn", "setExtendFriendUserSwitch", "switchText", "nextTs", "startAddFriendActivity", "context", "Landroid/content/Context;", "friendNick", "startExtendFriendCardOnClickAvatar", "targetUin", "fromPage", "qqexpand_impl_release"}, k=1, mv={1, 1, 16})
public final class LimitChatUtilsImpl
  implements ILimitChatUtils
{
  public void addExtendFriendUserInfo(@Nullable BaseQQAppInterface paramBaseQQAppInterface, @Nullable String paramString1, int paramInt1, @Nullable String paramString2, boolean paramBoolean, int paramInt2)
  {
    LimitChatUtil.a(paramBaseQQAppInterface, paramString1, paramInt1, paramString2, paramBoolean, paramInt2);
  }
  
  public void addFriendConversationNode(@Nullable BaseQQAppInterface paramBaseQQAppInterface, @Nullable String paramString)
  {
    LimitChatUtil.a(paramBaseQQAppInterface, paramString);
  }
  
  public void addGrayTipsMessage(@Nullable BaseQQAppInterface paramBaseQQAppInterface, @Nullable String paramString1, int paramInt1, @Nullable String paramString2, @Nullable String paramString3, int paramInt2, @Nullable String paramString4, int paramInt3, @Nullable MessageRecord paramMessageRecord)
  {
    LimitChatUtil.a(paramBaseQQAppInterface, paramString1, paramInt1, paramString2, paramString3, paramInt2, paramString4, paramInt3, paramMessageRecord);
  }
  
  public long addTopicMessage(@Nullable BaseQQAppInterface paramBaseQQAppInterface, @Nullable MatchInfo paramMatchInfo, long paramLong, int paramInt1, int paramInt2)
  {
    return LimitChatUtil.a(paramBaseQQAppInterface, paramMatchInfo, paramLong, paramInt1, paramInt2);
  }
  
  public boolean bNeedShowLimitChatByAllController(@Nullable BaseQQAppInterface paramBaseQQAppInterface)
  {
    return LimitChatUtil.a((AppInterface)paramBaseQQAppInterface);
  }
  
  public boolean checkInterceptMatchMessage(@Nullable BaseQQAppInterface paramBaseQQAppInterface, @Nullable MessageRecord paramMessageRecord)
  {
    return LimitChatUtil.a(paramBaseQQAppInterface, paramMessageRecord);
  }
  
  public void closeIceBreakingPanel(@Nullable BaseQQAppInterface paramBaseQQAppInterface, @Nullable String paramString)
  {
    LimitChatUtil.e(paramBaseQQAppInterface, paramString);
  }
  
  @Nullable
  public qq_ad_get.QQAdGet createRequest(long paramLong, @Nullable String paramString, int paramInt1, int paramInt2)
  {
    return LimitChatUtil.a(paramLong, paramString, paramInt1, paramInt2);
  }
  
  public void getExtendFriendSwitch(@Nullable BaseQQAppInterface paramBaseQQAppInterface, @Nullable Long paramLong, @Nullable IExpandCmdCallback paramIExpandCmdCallback)
  {
    LimitChatUtil.a(paramBaseQQAppInterface, paramLong, paramIExpandCmdCallback);
  }
  
  public boolean getExtendFriendUserSwitch(@Nullable BaseQQAppInterface paramBaseQQAppInterface)
  {
    return LimitChatUtil.b(paramBaseQQAppInterface);
  }
  
  @NotNull
  public String getExtendFriendUserSwitchText()
  {
    String str = LimitChatUtil.a();
    Intrinsics.checkExpressionValueIsNotNull(str, "LimitChatUtil.getExtendFriendSwitchText()");
    return str;
  }
  
  @Nullable
  public String getLimitChatOnPlusName(@Nullable BaseQQAppInterface paramBaseQQAppInterface)
  {
    return LimitChatUtil.a(paramBaseQQAppInterface);
  }
  
  @Nullable
  public String getSessionId(@Nullable String paramString1, @Nullable String paramString2)
  {
    return LimitChatUtil.a(paramString1, paramString2);
  }
  
  public void handleLimitChatC2CConfirmMsg(@Nullable MessageRecord paramMessageRecord, @Nullable AppInterface paramAppInterface)
  {
    LimitChatUtil.a(paramMessageRecord, paramAppInterface);
  }
  
  public void handlePreLoadDataForArkMiniProfileCard(@Nullable BaseQQAppInterface paramBaseQQAppInterface, @Nullable String paramString, int paramInt, boolean paramBoolean, @NotNull Object paramObject)
  {
    Intrinsics.checkParameterIsNotNull(paramObject, "data");
    LimitChatUtil.a((AppInterface)paramBaseQQAppInterface, paramString, paramInt, paramBoolean, paramObject);
  }
  
  public void handlePreLoadDataForAvatarProfileCard(@Nullable BaseQQAppInterface paramBaseQQAppInterface, @Nullable String paramString, @NotNull Object paramObject)
  {
    Intrinsics.checkParameterIsNotNull(paramObject, "data");
    LimitChatUtil.a((AppInterface)paramBaseQQAppInterface, paramString, paramObject);
  }
  
  public boolean hasMiniProfileCard(@Nullable List<? extends MessageRecord> paramList)
  {
    return LimitChatUtil.b(paramList);
  }
  
  public boolean hasValidMessage(@Nullable List<? extends MessageRecord> paramList)
  {
    return LimitChatUtil.a(paramList);
  }
  
  public boolean hasWatchedAdvertise(@Nullable BaseQQAppInterface paramBaseQQAppInterface, @Nullable String paramString)
  {
    return LimitChatUtil.d(paramBaseQQAppInterface, paramString);
  }
  
  public boolean isExtendMatchChatMsg(@Nullable MessageRecord paramMessageRecord)
  {
    return LimitChatUtil.a(paramMessageRecord);
  }
  
  public boolean isExtendMatchChatType(int paramInt)
  {
    return LimitChatUtil.a(paramInt);
  }
  
  public boolean isSystemMessage(int paramInt)
  {
    return LimitChatUtil.b(paramInt);
  }
  
  public boolean needAddFriendConversationNode(@Nullable BaseQQAppInterface paramBaseQQAppInterface, @Nullable String paramString)
  {
    return LimitChatUtil.b(paramBaseQQAppInterface, paramString);
  }
  
  public void preLoadDataForArkMiniProfileCard(@Nullable BaseQQAppInterface paramBaseQQAppInterface, @Nullable Long paramLong, @Nullable BusinessObserver paramBusinessObserver)
  {
    LimitChatUtil.b(paramBaseQQAppInterface, paramLong, paramBusinessObserver);
  }
  
  public void preLoadDataForAvatarProfileCard(@Nullable BaseQQAppInterface paramBaseQQAppInterface, @Nullable Long paramLong, @Nullable BusinessObserver paramBusinessObserver)
  {
    LimitChatUtil.a(paramBaseQQAppInterface, paramLong, paramBusinessObserver);
  }
  
  public void requestAddMatchedRelation(@Nullable BaseQQAppInterface paramBaseQQAppInterface, @Nullable String paramString1, @Nullable String paramString2, int paramInt)
  {
    LimitChatUtil.a(paramBaseQQAppInterface, paramString1, paramString2, paramInt);
  }
  
  public void resetMatchChatAIOData(@Nullable BaseQQAppInterface paramBaseQQAppInterface, @Nullable String paramString)
  {
    LimitChatUtil.c(paramBaseQQAppInterface, paramString);
  }
  
  public void saveTempC2cSignature(@NotNull AppRuntime paramAppRuntime, @NotNull String paramString, @NotNull byte[] paramArrayOfByte)
  {
    Intrinsics.checkParameterIsNotNull(paramAppRuntime, "app");
    Intrinsics.checkParameterIsNotNull(paramString, "matchUin");
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "signature");
    Manager localManager = paramAppRuntime.getManager(QQManagerFactory.EXTEND_FRIEND_LIMIT_CHAT_MANAGER);
    if (localManager != null)
    {
      ((ExtendFriendLimitChatManager)localManager).a(paramString, paramAppRuntime.getCurrentAccountUin(), paramArrayOfByte);
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.qqexpand.manager.ExtendFriendLimitChatManager");
  }
  
  public void setExtendFriendSwitch(@Nullable BaseQQAppInterface paramBaseQQAppInterface, boolean paramBoolean, @Nullable IExpandCmdCallback paramIExpandCmdCallback)
  {
    LimitChatUtil.a(paramBaseQQAppInterface, paramBoolean, paramIExpandCmdCallback);
  }
  
  public void setExtendFriendUserSwitch(@Nullable BaseQQAppInterface paramBaseQQAppInterface, boolean paramBoolean, @NotNull String paramString, long paramLong)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "switchText");
    LimitChatUtil.a(paramBaseQQAppInterface, paramBoolean, paramString, paramLong);
  }
  
  public void startAddFriendActivity(@Nullable Context paramContext, @Nullable String paramString1, @Nullable String paramString2)
  {
    LimitChatUtil.a(paramContext, paramString1, paramString2);
  }
  
  public void startExtendFriendCardOnClickAvatar(@Nullable Context paramContext, @Nullable String paramString, int paramInt)
  {
    LimitChatUtil.a(paramContext, paramString, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.chat.impl.LimitChatUtilsImpl
 * JD-Core Version:    0.7.0.1
 */