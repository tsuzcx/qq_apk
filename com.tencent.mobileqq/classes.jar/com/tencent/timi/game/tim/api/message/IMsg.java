package com.tencent.timi.game.tim.api.message;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.CommonOuterClass.QQUserId;
import trpc.yes.common.MessageOuterClass.MsgContent;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/tim/api/message/IMsg;", "", "content", "Ltrpc/yes/common/MessageOuterClass$MsgContent;", "getLocalData", "", "getLocalValue", "", "getMemData", "groupId", "", "id", "isGroup", "", "isSelf", "peerId", "read", "sender", "Ltrpc/yes/common/CommonOuterClass$QQUserId;", "seq", "setLocalData", "", "data", "setLocalValue", "value", "setMemData", "setStatus", "status", "Lcom/tencent/timi/game/tim/api/message/MsgStatus;", "time", "type", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public abstract interface IMsg
{
  @NotNull
  public abstract String a();
  
  public abstract void a(int paramInt);
  
  public abstract void a(@NotNull MsgStatus paramMsgStatus);
  
  public abstract void a(@Nullable Object paramObject);
  
  public abstract void a(@NotNull String paramString);
  
  public abstract long b();
  
  public abstract int c();
  
  @NotNull
  public abstract CommonOuterClass.QQUserId d();
  
  public abstract long e();
  
  @NotNull
  public abstract MsgStatus f();
  
  @NotNull
  public abstract MessageOuterClass.MsgContent g();
  
  public abstract long h();
  
  public abstract long i();
  
  public abstract boolean j();
  
  public abstract boolean k();
  
  @Nullable
  public abstract String l();
  
  public abstract int m();
  
  @Nullable
  public abstract Object n();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.tim.api.message.IMsg
 * JD-Core Version:    0.7.0.1
 */