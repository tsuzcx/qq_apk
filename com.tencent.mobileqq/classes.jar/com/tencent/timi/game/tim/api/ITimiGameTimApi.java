package com.tencent.timi.game.tim.api;

import com.tencent.timi.game.router.IService;
import com.tencent.timi.game.tim.api.group.IGroupManager;
import com.tencent.timi.game.tim.api.message.IMsgManager;
import com.tencent.timi.game.tim.api.message.INewMsgListener;
import com.tencent.timi.game.utils.IResultListener;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.MessageOuterClass.TimMsgBody;
import trpc.yes.common.TcloudServerOuterClass.GetUserTCloudSignRsp;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/tim/api/ITimiGameTimApi;", "Lcom/tencent/timi/game/router/IService;", "checkInit", "", "getC2CMsgManager", "Lcom/tencent/timi/game/tim/api/message/IMsgManager;", "uid", "", "getGroupManager", "Lcom/tencent/timi/game/tim/api/group/IGroupManager;", "getGroupMsgManager", "groupId", "getUserSig", "callback", "Lcom/tencent/timi/game/utils/IResultListener;", "Ltrpc/yes/common/TcloudServerOuterClass$GetUserTCloudSignRsp;", "isLoaded", "", "login", "Lcom/tencent/timi/game/tim/api/ILoginCallback;", "logout", "notifyGroupMsg", "", "timMsgBody", "Ltrpc/yes/common/MessageOuterClass$TimMsgBody;", "registerListener", "listener", "Lcom/tencent/timi/game/tim/api/message/INewMsgListener;", "unregisterListener", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public abstract interface ITimiGameTimApi
  extends IService
{
  @NotNull
  public abstract IMsgManager a(long paramLong);
  
  public abstract void a();
  
  public abstract void a(@Nullable ILoginCallback paramILoginCallback);
  
  public abstract void a(@NotNull INewMsgListener paramINewMsgListener);
  
  public abstract void a(@Nullable IResultListener<TcloudServerOuterClass.GetUserTCloudSignRsp> paramIResultListener);
  
  public abstract void a(@NotNull String paramString, @NotNull MessageOuterClass.TimMsgBody paramTimMsgBody);
  
  @NotNull
  public abstract IMsgManager b(long paramLong);
  
  public abstract void b(@NotNull INewMsgListener paramINewMsgListener);
  
  public abstract boolean b();
  
  public abstract void c();
  
  @NotNull
  public abstract IGroupManager d();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.tim.api.ITimiGameTimApi
 * JD-Core Version:    0.7.0.1
 */