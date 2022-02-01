package com.tencent.mobileqq.qqexpand.manager.impl;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.qqexpand.bean.chat.ExpandFriendData;
import com.tencent.mobileqq.qqexpand.config.ExpandConfig;
import com.tencent.mobileqq.qqexpand.manager.ExpandManager;
import com.tencent.mobileqq.qqexpand.manager.ExtendFriendLimitChatManager;
import com.tencent.mobileqq.qqexpand.manager.IExpandManagerProxy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/qqexpand/manager/impl/ExpandManagerProxyImpl;", "Lcom/tencent/mobileqq/qqexpand/manager/IExpandManagerProxy;", "()V", "getExpandFriendDataCache", "Lcom/tencent/mobileqq/qqexpand/bean/chat/ExpandFriendData;", "appRuntime", "Lmqq/app/AppRuntime;", "uin", "", "loadDbIfNotExist", "", "getExpandFriendDataSingleAttribute", "", "matchUin", "attributeId", "", "getVoiceMaxDuration", "isResourceReady", "setExpandEntry", "", "updateExpandFriendData", "expandFriendData", "updateExpandFriendDataSingleAttribute", "content", "qqexpand_impl_release"}, k=1, mv={1, 1, 16})
public final class ExpandManagerProxyImpl
  implements IExpandManagerProxy
{
  @Nullable
  public ExpandFriendData getExpandFriendDataCache(@NotNull AppRuntime paramAppRuntime, @Nullable String paramString, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramAppRuntime, "appRuntime");
    paramAppRuntime = (ExtendFriendLimitChatManager)paramAppRuntime.getManager(QQManagerFactory.EXTEND_FRIEND_LIMIT_CHAT_MANAGER);
    if (paramAppRuntime != null) {
      return paramAppRuntime.a(paramString, paramBoolean);
    }
    return null;
  }
  
  @Nullable
  public Object getExpandFriendDataSingleAttribute(@NotNull AppRuntime paramAppRuntime, @Nullable String paramString, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramAppRuntime, "appRuntime");
    paramAppRuntime = (ExtendFriendLimitChatManager)paramAppRuntime.getManager(QQManagerFactory.EXTEND_FRIEND_LIMIT_CHAT_MANAGER);
    if (paramAppRuntime != null) {
      return paramAppRuntime.a(paramString, paramInt);
    }
    return null;
  }
  
  public int getVoiceMaxDuration(@NotNull AppRuntime paramAppRuntime)
  {
    Intrinsics.checkParameterIsNotNull(paramAppRuntime, "appRuntime");
    paramAppRuntime = (ExpandManager)paramAppRuntime.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER);
    if (paramAppRuntime != null)
    {
      paramAppRuntime = paramAppRuntime.a();
      if (paramAppRuntime != null) {
        return paramAppRuntime.voiceMaxLength;
      }
    }
    return 0;
  }
  
  public boolean isResourceReady(@NotNull AppRuntime paramAppRuntime)
  {
    Intrinsics.checkParameterIsNotNull(paramAppRuntime, "appRuntime");
    paramAppRuntime = (ExpandManager)paramAppRuntime.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER);
    if (paramAppRuntime != null) {
      return paramAppRuntime.d();
    }
    return false;
  }
  
  public void setExpandEntry(@NotNull AppRuntime paramAppRuntime)
  {
    Intrinsics.checkParameterIsNotNull(paramAppRuntime, "appRuntime");
    ExpandManager localExpandManager = (ExpandManager)paramAppRuntime.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER);
    if (localExpandManager != null) {
      localExpandManager.a((BaseQQAppInterface)paramAppRuntime);
    }
  }
  
  public void updateExpandFriendData(@NotNull AppRuntime paramAppRuntime, @NotNull ExpandFriendData paramExpandFriendData)
  {
    Intrinsics.checkParameterIsNotNull(paramAppRuntime, "appRuntime");
    Intrinsics.checkParameterIsNotNull(paramExpandFriendData, "expandFriendData");
    paramAppRuntime = (ExtendFriendLimitChatManager)paramAppRuntime.getManager(QQManagerFactory.EXTEND_FRIEND_LIMIT_CHAT_MANAGER);
    if (paramAppRuntime != null) {
      paramAppRuntime.a(paramExpandFriendData);
    }
  }
  
  public void updateExpandFriendDataSingleAttribute(@NotNull AppRuntime paramAppRuntime, @Nullable String paramString, int paramInt, @Nullable Object paramObject)
  {
    Intrinsics.checkParameterIsNotNull(paramAppRuntime, "appRuntime");
    paramAppRuntime = (ExtendFriendLimitChatManager)paramAppRuntime.getManager(QQManagerFactory.EXTEND_FRIEND_LIMIT_CHAT_MANAGER);
    if (paramAppRuntime != null) {
      paramAppRuntime.a(paramString, paramInt, paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.manager.impl.ExpandManagerProxyImpl
 * JD-Core Version:    0.7.0.1
 */