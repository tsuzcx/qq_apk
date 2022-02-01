package com.tencent.mobileqq.qqexpand.manager;

import com.tencent.mobileqq.qqexpand.bean.chat.ExpandFriendData;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@QAPI(process={""})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/qqexpand/manager/IExpandManagerProxy;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "getExpandFriendDataCache", "Lcom/tencent/mobileqq/qqexpand/bean/chat/ExpandFriendData;", "appRuntime", "Lmqq/app/AppRuntime;", "uin", "", "loadDbIfNotExist", "", "getExpandFriendDataSingleAttribute", "", "matchUin", "attributeId", "", "getVoiceMaxDuration", "isResourceReady", "setExpandEntry", "", "updateExpandFriendData", "expandFriendData", "updateExpandFriendDataSingleAttribute", "content", "qqexpand-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IExpandManagerProxy
  extends QRouteApi
{
  @Nullable
  public abstract ExpandFriendData getExpandFriendDataCache(@NotNull AppRuntime paramAppRuntime, @Nullable String paramString, boolean paramBoolean);
  
  @Nullable
  public abstract Object getExpandFriendDataSingleAttribute(@NotNull AppRuntime paramAppRuntime, @Nullable String paramString, int paramInt);
  
  public abstract int getVoiceMaxDuration(@NotNull AppRuntime paramAppRuntime);
  
  public abstract boolean isResourceReady(@NotNull AppRuntime paramAppRuntime);
  
  public abstract void setExpandEntry(@NotNull AppRuntime paramAppRuntime);
  
  public abstract void updateExpandFriendData(@NotNull AppRuntime paramAppRuntime, @NotNull ExpandFriendData paramExpandFriendData);
  
  public abstract void updateExpandFriendDataSingleAttribute(@NotNull AppRuntime paramAppRuntime, @Nullable String paramString, int paramInt, @Nullable Object paramObject);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.manager.IExpandManagerProxy
 * JD-Core Version:    0.7.0.1
 */