package com.tencent.timi.game.tim.api.impl.message;

import com.tencent.imsdk.v2.V2TIMCustomElem;
import com.tencent.imsdk.v2.V2TIMMessage;
import com.tencent.imsdk.v2.V2TIMTextElem;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.timi.game.tim.api.message.IMsg;
import com.tencent.timi.game.tim.api.message.MsgStatus;
import com.tencent.timi.game.utils.Logger;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.ULong;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.UStringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.CommonOuterClass.QQUserId;
import trpc.yes.common.MessageOuterClass.MsgContent;
import trpc.yes.common.MessageOuterClass.TextMsg;
import trpc.yes.common.MessageOuterClass.TimMsgBody;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/tim/api/impl/message/MsgInfo;", "Lcom/tencent/timi/game/tim/api/message/IMsg;", "v2TIMMessage", "Lcom/tencent/imsdk/v2/V2TIMMessage;", "(Lcom/tencent/imsdk/v2/V2TIMMessage;)V", "TAG", "", "content", "Ltrpc/yes/common/MessageOuterClass$MsgContent;", "getContent", "()Ltrpc/yes/common/MessageOuterClass$MsgContent;", "setContent", "(Ltrpc/yes/common/MessageOuterClass$MsgContent;)V", "innerStatus", "Lcom/tencent/timi/game/tim/api/message/MsgStatus;", "memData", "", "msgRecord", "Ltrpc/yes/common/MessageOuterClass$TimMsgBody;", "timeDebug", "", "getV2TIMMessage", "()Lcom/tencent/imsdk/v2/V2TIMMessage;", "equals", "", "other", "getLocalData", "getLocalValue", "", "getMemData", "groupId", "hashCode", "id", "isGroup", "isSelf", "peerId", "read", "sender", "Ltrpc/yes/common/CommonOuterClass$QQUserId;", "seq", "setLocalData", "", "data", "setLocalValue", "value", "setMemData", "setStatus", "status", "time", "type", "Companion", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class MsgInfo
  implements IMsg
{
  public static final MsgInfo.Companion a = new MsgInfo.Companion(null);
  private final String b;
  @Nullable
  private MessageOuterClass.MsgContent c;
  private MessageOuterClass.TimMsgBody d;
  private MsgStatus e;
  private long f;
  private Object g;
  @NotNull
  private final V2TIMMessage h;
  
  public MsgInfo(@NotNull V2TIMMessage paramV2TIMMessage)
  {
    this.h = paramV2TIMMessage;
    this.b = "MessageInfo";
    this.f = (this.h.getTimestamp() * 1000L);
  }
  
  private final MessageOuterClass.TimMsgBody p()
  {
    if (this.h.getElemType() != 2) {
      return new MessageOuterClass.TimMsgBody();
    }
    if (this.d == null) {}
    try
    {
      localObject1 = new MessageOuterClass.TimMsgBody();
      localObject2 = this.h.getCustomElem();
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "v2TIMMessage.customElem");
      localObject1 = (MessageOuterClass.TimMsgBody)((MessageOuterClass.TimMsgBody)localObject1).mergeFrom(Base64Util.decode(((V2TIMCustomElem)localObject2).getData(), 2));
    }
    catch (Exception localException)
    {
      Object localObject1;
      Object localObject2;
      label67:
      MessageOuterClass.MsgContent localMsgContent;
      MessageOuterClass.TextMsg localTextMsg1;
      MessageOuterClass.TextMsg localTextMsg2;
      break label67;
    }
    localObject1 = this.b;
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("parse error:");
    ((StringBuilder)localObject2).append(this.h.getCustomElem().toString());
    Logger.a((String)localObject1, ((StringBuilder)localObject2).toString());
    localObject1 = new MessageOuterClass.TimMsgBody();
    ((MessageOuterClass.TimMsgBody)localObject1).msg_type.set(1);
    localObject2 = ((MessageOuterClass.TimMsgBody)localObject1).content;
    localMsgContent = new MessageOuterClass.MsgContent();
    localTextMsg1 = localMsgContent.text_msg;
    localTextMsg2 = new MessageOuterClass.TextMsg();
    localTextMsg2.text.set("[收到一条消息，当前版本不支持查看，请更新至新版本]");
    localTextMsg1.set((MessageMicro)localTextMsg2);
    ((MessageOuterClass.MsgContent)localObject2).set((MessageMicro)localMsgContent);
    this.d = ((MessageOuterClass.TimMsgBody)localObject1);
    localObject1 = this.d;
    if (localObject1 == null) {
      Intrinsics.throwNpe();
    }
    return localObject1;
  }
  
  @NotNull
  public String a()
  {
    String str = this.h.getMsgID();
    Intrinsics.checkExpressionValueIsNotNull(str, "v2TIMMessage.msgID");
    return str;
  }
  
  public void a(int paramInt)
  {
    this.h.setLocalCustomInt(paramInt);
  }
  
  public void a(@NotNull MsgStatus paramMsgStatus)
  {
    Intrinsics.checkParameterIsNotNull(paramMsgStatus, "status");
    this.e = paramMsgStatus;
  }
  
  public void a(@Nullable Object paramObject)
  {
    this.g = paramObject;
  }
  
  public void a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "data");
    this.h.setLocalCustomData(paramString);
  }
  
  public long b()
  {
    return this.h.getSeq();
  }
  
  public int c()
  {
    int k = this.h.getElemType();
    int j = 1;
    int i = j;
    if (k != 1)
    {
      if (k != 2) {
        return 1;
      }
      i = j;
      if (p().msg_type.has()) {
        i = p().msg_type.get();
      }
    }
    return i;
  }
  
  @NotNull
  public CommonOuterClass.QQUserId d()
  {
    CommonOuterClass.QQUserId localQQUserId = p().from_user;
    Intrinsics.checkExpressionValueIsNotNull(localQQUserId, "msgRecord().from_user");
    return localQQUserId;
  }
  
  public long e()
  {
    return this.h.getTimestamp() * 1000;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if ((MsgInfo)this == paramObject) {
      return true;
    }
    Class localClass2 = getClass();
    Class localClass1;
    if (paramObject != null) {
      localClass1 = paramObject.getClass();
    } else {
      localClass1 = null;
    }
    if ((Intrinsics.areEqual(localClass2, localClass1) ^ true)) {
      return false;
    }
    if (paramObject != null)
    {
      paramObject = (MsgInfo)paramObject;
      return !(Intrinsics.areEqual(a(), paramObject.a()) ^ true);
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.timi.game.tim.api.impl.message.MsgInfo");
  }
  
  @NotNull
  public MsgStatus f()
  {
    MsgStatus localMsgStatus = this.e;
    if (localMsgStatus != null)
    {
      if (localMsgStatus == null) {
        Intrinsics.throwNpe();
      }
      return localMsgStatus;
    }
    int i = this.h.getStatus();
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i != 4)
          {
            if (i != 6) {
              return MsgStatus.SUCCESS;
            }
            return MsgStatus.REVOKE;
          }
          return MsgStatus.DELETE;
        }
        return MsgStatus.FAILED;
      }
      return MsgStatus.SUCCESS;
    }
    return MsgStatus.SENDING;
  }
  
  @NotNull
  public MessageOuterClass.MsgContent g()
  {
    if (this.c == null)
    {
      if (this.h.getElemType() != 1)
      {
        localObject1 = p().content;
      }
      else
      {
        localObject1 = MessageUtils.a;
        Object localObject2 = this.h.getTextElem();
        Intrinsics.checkExpressionValueIsNotNull(localObject2, "v2TIMMessage.textElem");
        localObject2 = ((V2TIMTextElem)localObject2).getText();
        Intrinsics.checkExpressionValueIsNotNull(localObject2, "v2TIMMessage.textElem.text");
        localObject1 = ((MessageUtils.Companion)localObject1).a((String)localObject2);
      }
      this.c = ((MessageOuterClass.MsgContent)localObject1);
    }
    Object localObject1 = this.c;
    if (localObject1 != null) {
      return localObject1;
    }
    return new MessageOuterClass.MsgContent();
  }
  
  public long h()
  {
    Object localObject = this.h.getGroupID();
    if (localObject != null)
    {
      localObject = UStringsKt.toULongOrNull((String)localObject);
      if (localObject != null) {
        return ((ULong)localObject).unbox-impl();
      }
    }
    return 0L;
  }
  
  public int hashCode()
  {
    return this.h.hashCode();
  }
  
  public long i()
  {
    Object localObject = this.h.getUserID();
    if (localObject != null)
    {
      localObject = UStringsKt.toULongOrNull((String)localObject);
      if (localObject != null) {
        return ((ULong)localObject).unbox-impl();
      }
    }
    return 0L;
  }
  
  public boolean j()
  {
    return this.h.isSelf();
  }
  
  public boolean k()
  {
    return h() > 0L;
  }
  
  @Nullable
  public String l()
  {
    return this.h.getLocalCustomData();
  }
  
  public int m()
  {
    return this.h.getLocalCustomInt();
  }
  
  @Nullable
  public Object n()
  {
    return this.g;
  }
  
  @NotNull
  public final V2TIMMessage o()
  {
    return this.h;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.tim.api.impl.message.MsgInfo
 * JD-Core Version:    0.7.0.1
 */