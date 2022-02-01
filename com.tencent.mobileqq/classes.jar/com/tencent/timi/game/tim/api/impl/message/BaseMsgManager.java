package com.tencent.timi.game.tim.api.impl.message;

import com.tencent.imsdk.v2.V2TIMAdvancedMsgListener;
import com.tencent.imsdk.v2.V2TIMCallback;
import com.tencent.imsdk.v2.V2TIMManager;
import com.tencent.imsdk.v2.V2TIMMessage;
import com.tencent.imsdk.v2.V2TIMMessageManager;
import com.tencent.imsdk.v2.V2TIMSendCallback;
import com.tencent.imsdk.v2.V2TIMValueCallback;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.tim.api.ILoginCallback;
import com.tencent.timi.game.tim.api.ITimiGameTimApi;
import com.tencent.timi.game.tim.api.impl.ex.LongExKt;
import com.tencent.timi.game.tim.api.message.IMsg;
import com.tencent.timi.game.tim.api.message.IMsgListener;
import com.tencent.timi.game.tim.api.message.IMsgManager;
import com.tencent.timi.game.tim.api.message.MsgStatus;
import com.tencent.timi.game.ui.widget.CustomToastView;
import com.tencent.timi.game.utils.Logger;
import com.tencent.timi.game.utils.ThreadPool;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.CommonOuterClass.QQUserId;
import trpc.yes.common.MessageOuterClass.MsgContent;
import trpc.yes.common.MessageOuterClass.TextMsg;
import trpc.yes.common.MessageOuterClass.TimMsgBody;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/tim/api/impl/message/BaseMsgManager;", "Lcom/tencent/timi/game/tim/api/message/IMsgManager;", "chatId", "", "(Ljava/lang/String;)V", "TAG", "getChatId", "()Ljava/lang/String;", "images", "", "Lcom/tencent/timi/game/tim/api/impl/message/MsgInfo;", "isLoadingHistory", "", "()Z", "setLoadingHistory", "(Z)V", "listeners", "Lcom/tencent/timi/game/tim/api/message/IMsgListener;", "getListeners", "()Ljava/util/List;", "setListeners", "(Ljava/util/List;)V", "msgListener", "com/tencent/timi/game/tim/api/impl/message/BaseMsgManager$msgListener$1", "Lcom/tencent/timi/game/tim/api/impl/message/BaseMsgManager$msgListener$1;", "checkLoginAndSendMessage", "", "msgInfo", "checkLoginGetHistoryMsgList", "lastMsg", "Lcom/tencent/timi/game/tim/api/message/IMsg;", "count", "", "createChat", "listener", "delete", "msg", "destroyChat", "finalSendMessage", "getHistoryMsgList", "insertGroupMsg", "timMsgBody", "Ltrpc/yes/common/MessageOuterClass$TimMsgBody;", "sender", "Ltrpc/yes/common/CommonOuterClass$QQUserId;", "isGroup", "isSoLoad", "resend", "sendAtMessage", "userId", "text", "content", "Ltrpc/yes/common/MessageOuterClass$MsgContent;", "sendCustom", "type", "sendMessage", "sendText", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public abstract class BaseMsgManager
  implements IMsgManager
{
  private final String a;
  @NotNull
  private List<IMsgListener> b;
  private boolean c;
  private List<MsgInfo> d;
  private final BaseMsgManager.msgListener.1 e;
  @NotNull
  private final String f;
  
  public BaseMsgManager(@NotNull String paramString)
  {
    this.f = paramString;
    this.a = "BaseMsgManager";
    this.b = ((List)new ArrayList());
    this.d = ((List)new ArrayList());
    this.e = new BaseMsgManager.msgListener.1(this);
  }
  
  private final void a(MsgInfo paramMsgInfo)
  {
    a(paramMsgInfo, false);
  }
  
  private final void a(MsgInfo paramMsgInfo, boolean paramBoolean)
  {
    b(paramMsgInfo);
    ThreadPool.a((Runnable)new BaseMsgManager.sendMessage.1(this, paramMsgInfo, paramBoolean));
  }
  
  private final void a(IMsg paramIMsg, int paramInt)
  {
    if (this.c) {
      return;
    }
    String str = this.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("lastMsg = [");
    localStringBuilder.append(paramIMsg);
    localStringBuilder.append("], count = [");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(']');
    Logger.b(str, localStringBuilder.toString());
    this.c = true;
    ((ITimiGameTimApi)ServiceCenter.a(ITimiGameTimApi.class)).a((ILoginCallback)new BaseMsgManager.checkLoginGetHistoryMsgList.1(this, paramInt, paramIMsg));
  }
  
  private final void b(MsgInfo paramMsgInfo)
  {
    ((ITimiGameTimApi)ServiceCenter.a(ITimiGameTimApi.class)).a((ILoginCallback)new BaseMsgManager.checkLoginAndSendMessage.1(this, paramMsgInfo));
  }
  
  private final void c(MsgInfo paramMsgInfo)
  {
    V2TIMMessageManager localV2TIMMessageManager = V2TIMManager.getMessageManager();
    V2TIMMessage localV2TIMMessage = paramMsgInfo.o();
    boolean bool = b();
    String str2 = null;
    String str1;
    if (!bool) {
      str1 = this.f;
    } else {
      str1 = null;
    }
    if (b()) {
      str2 = this.f;
    }
    localV2TIMMessageManager.sendMessage(localV2TIMMessage, str1, str2, 0, false, null, (V2TIMSendCallback)new BaseMsgManager.finalSendMessage.1(this, paramMsgInfo));
  }
  
  private final boolean d()
  {
    return ((ITimiGameTimApi)ServiceCenter.a(ITimiGameTimApi.class)).b();
  }
  
  @Nullable
  public IMsg a(@NotNull CommonOuterClass.QQUserId paramQQUserId, int paramInt, @NotNull MessageOuterClass.MsgContent paramMsgContent)
  {
    Intrinsics.checkParameterIsNotNull(paramQQUserId, "userId");
    Intrinsics.checkParameterIsNotNull(paramMsgContent, "content");
    if (!d())
    {
      CustomToastView.a("网络异常无法发送");
      return null;
    }
    MessageOuterClass.TimMsgBody localTimMsgBody = new MessageOuterClass.TimMsgBody();
    localTimMsgBody.msg_type.set(paramInt);
    localTimMsgBody.content.set((MessageMicro)paramMsgContent);
    localTimMsgBody.from_user.set((MessageMicro)paramQQUserId);
    paramQQUserId = V2TIMManager.getMessageManager().createCustomMessage(Base64Util.encode(localTimMsgBody.toByteArray(), 2));
    Intrinsics.checkExpressionValueIsNotNull(paramQQUserId, "V2TIMManager.getMessageM…y(), Base64Util.NO_WRAP))");
    paramQQUserId = new MsgInfo(paramQQUserId);
    a(paramQQUserId);
    return (IMsg)paramQQUserId;
  }
  
  @Nullable
  public IMsg a(@NotNull CommonOuterClass.QQUserId paramQQUserId, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramQQUserId, "userId");
    Intrinsics.checkParameterIsNotNull(paramString, "text");
    MessageOuterClass.MsgContent localMsgContent = new MessageOuterClass.MsgContent();
    MessageOuterClass.TextMsg localTextMsg1 = localMsgContent.text_msg;
    MessageOuterClass.TextMsg localTextMsg2 = new MessageOuterClass.TextMsg();
    localTextMsg2.text.set(paramString);
    localTextMsg1.set((MessageMicro)localTextMsg2);
    return a(paramQQUserId, 1, localMsgContent);
  }
  
  @Nullable
  public IMsg a(@NotNull CommonOuterClass.QQUserId paramQQUserId, @NotNull String paramString, @NotNull MessageOuterClass.MsgContent paramMsgContent)
  {
    Intrinsics.checkParameterIsNotNull(paramQQUserId, "userId");
    Intrinsics.checkParameterIsNotNull(paramString, "text");
    Intrinsics.checkParameterIsNotNull(paramMsgContent, "content");
    return a(paramQQUserId, 70, paramMsgContent);
  }
  
  @NotNull
  public final List<IMsgListener> a()
  {
    return this.b;
  }
  
  public void a(@Nullable IMsg paramIMsg)
  {
    a(paramIMsg, 20);
  }
  
  public void a(@Nullable IMsgListener paramIMsgListener)
  {
    this.c = false;
    if (paramIMsgListener == null) {
      return;
    }
    if (this.b.isEmpty()) {
      V2TIMManager.getMessageManager().addAdvancedMsgListener((V2TIMAdvancedMsgListener)this.e);
    }
    if (!this.b.contains(paramIMsgListener)) {
      this.b.add(paramIMsgListener);
    }
  }
  
  public final void a(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }
  
  public boolean a(@NotNull MessageOuterClass.TimMsgBody paramTimMsgBody, @NotNull CommonOuterClass.QQUserId paramQQUserId)
  {
    Intrinsics.checkParameterIsNotNull(paramTimMsgBody, "timMsgBody");
    Intrinsics.checkParameterIsNotNull(paramQQUserId, "sender");
    if (!d())
    {
      Logger.c(this.a, "insertGroupMsg failt: so is not load");
      return false;
    }
    paramTimMsgBody.from_user.set((MessageMicro)paramQQUserId);
    paramTimMsgBody = V2TIMManager.getMessageManager().createCustomMessage(Base64Util.encode(paramTimMsgBody.toByteArray(), 2));
    Intrinsics.checkExpressionValueIsNotNull(paramTimMsgBody, "v2TIMMessage");
    MsgInfo localMsgInfo = new MsgInfo(paramTimMsgBody);
    V2TIMManager.getMessageManager().insertGroupMessageToLocalStorage(paramTimMsgBody, this.f, LongExKt.a(paramQQUserId.uid.get()), (V2TIMValueCallback)new BaseMsgManager.insertGroupMsg.1(this, localMsgInfo));
    localMsgInfo.a(MsgStatus.SUCCESS);
    paramQQUserId = ((Iterable)this.b).iterator();
    while (paramQQUserId.hasNext()) {
      ((IMsgListener)paramQQUserId.next()).e((IMsg)new MsgInfo(paramTimMsgBody));
    }
    return true;
  }
  
  public void b(@NotNull IMsg paramIMsg)
  {
    Intrinsics.checkParameterIsNotNull(paramIMsg, "msg");
    a((MsgInfo)paramIMsg, true);
  }
  
  public void b(@Nullable IMsgListener paramIMsgListener)
  {
    Collection localCollection = (Collection)this.b;
    if (localCollection != null)
    {
      TypeIntrinsics.asMutableCollection(localCollection).remove(paramIMsgListener);
      if (this.b.isEmpty()) {
        V2TIMManager.getMessageManager().removeAdvancedMsgListener((V2TIMAdvancedMsgListener)this.e);
      }
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.MutableCollection<T>");
  }
  
  public abstract boolean b();
  
  @NotNull
  public final String c()
  {
    return this.f;
  }
  
  public void c(@NotNull IMsg paramIMsg)
  {
    Intrinsics.checkParameterIsNotNull(paramIMsg, "msg");
    V2TIMManager.getMessageManager().deleteMessageFromLocalStorage(((MsgInfo)paramIMsg).o(), (V2TIMCallback)new BaseMsgManager.delete.1(this, paramIMsg));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.tim.api.impl.message.BaseMsgManager
 * JD-Core Version:    0.7.0.1
 */