package com.tencent.timi.game.expand.hall.impl.util;

import com.tencent.timi.game.tim.api.message.IMsg;
import com.tencent.timi.game.tim.api.message.MsgStatus;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref.LongRef;
import kotlin.jvm.internal.Ref.ObjectRef;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.CommonOuterClass.QQUserId;
import trpc.yes.common.MessageOuterClass.MsgContent;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/timi/game/expand/hall/impl/util/SafeNoticeMsgManager$obtainSafeNoticeMsg$1", "Lcom/tencent/timi/game/tim/api/message/IMsg;", "content", "Ltrpc/yes/common/MessageOuterClass$MsgContent;", "getLocalData", "", "getLocalValue", "", "getMemData", "", "groupId", "", "id", "isGroup", "", "isSelf", "peerId", "read", "sender", "Ltrpc/yes/common/CommonOuterClass$QQUserId;", "seq", "setLocalData", "", "data", "setLocalValue", "value", "setMemData", "setStatus", "status", "Lcom/tencent/timi/game/tim/api/message/MsgStatus;", "time", "type", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class SafeNoticeMsgManager$obtainSafeNoticeMsg$1
  implements IMsg
{
  SafeNoticeMsgManager$obtainSafeNoticeMsg$1(Ref.LongRef paramLongRef, Ref.ObjectRef paramObjectRef) {}
  
  @NotNull
  public String a()
  {
    return String.valueOf(this.b.element);
  }
  
  public void a(int paramInt) {}
  
  public void a(@NotNull MsgStatus paramMsgStatus)
  {
    Intrinsics.checkParameterIsNotNull(paramMsgStatus, "status");
  }
  
  public void a(@Nullable Object paramObject) {}
  
  public void a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "data");
  }
  
  public long b()
  {
    return 0L;
  }
  
  public int c()
  {
    return 63;
  }
  
  @NotNull
  public CommonOuterClass.QQUserId d()
  {
    return this.a.a();
  }
  
  public long e()
  {
    return this.b.element;
  }
  
  @NotNull
  public MsgStatus f()
  {
    return MsgStatus.SUCCESS;
  }
  
  @NotNull
  public MessageOuterClass.MsgContent g()
  {
    return (MessageOuterClass.MsgContent)this.c.element;
  }
  
  public long h()
  {
    return this.a.b();
  }
  
  public long i()
  {
    return this.a.b();
  }
  
  public boolean j()
  {
    return false;
  }
  
  public boolean k()
  {
    return true;
  }
  
  @NotNull
  public String l()
  {
    return "";
  }
  
  public int m()
  {
    return 0;
  }
  
  @Nullable
  public Object n()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.expand.hall.impl.util.SafeNoticeMsgManager.obtainSafeNoticeMsg.1
 * JD-Core Version:    0.7.0.1
 */