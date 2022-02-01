package com.tencent.timi.game.tim.api.impl.message;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.text.TextUtils;
import com.tencent.imsdk.v2.V2TIMCallback;
import com.tencent.imsdk.v2.V2TIMManager;
import com.tencent.imsdk.v2.V2TIMMessageManager;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qmethodmonitor.monitor.ClipboardMonitor;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.timi.game.accusation.api.TimiGameAccusationApi;
import com.tencent.timi.game.base.TimiGameActivityManager;
import com.tencent.timi.game.component.chat.util.EmotionCodecUtils;
import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.tim.api.ITimiGameTimApi;
import com.tencent.timi.game.tim.api.impl.ex.LongExKt;
import com.tencent.timi.game.tim.api.message.IMsg;
import com.tencent.timi.game.tim.api.message.IMsgManager;
import com.tencent.timi.game.ui.widget.CommonDialog;
import com.tencent.timi.game.ui.widget.CommonDialog.Builder;
import com.tencent.timi.game.ui.widget.CustomToastView;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import trpc.yes.common.CommonOuterClass.QQUserId;
import trpc.yes.common.MessageOuterClass.AtUserMsg;
import trpc.yes.common.MessageOuterClass.MsgContent;
import trpc.yes.common.MessageOuterClass.TextMsg;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/tim/api/impl/message/MessageUtils$Companion;", "", "()V", "REVOCATION_EXPIRED", "", "TAG", "", "buildTextMessage", "Ltrpc/yes/common/MessageOuterClass$MsgContent;", "text", "copy", "", "context", "Landroid/content/Context;", "msg", "Lcom/tencent/timi/game/tim/api/message/IMsg;", "delete", "report", "resend", "revocation", "showMessageRevocationExpiredDialog", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class MessageUtils$Companion
{
  @NotNull
  public final MessageOuterClass.MsgContent a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "text");
    MessageOuterClass.MsgContent localMsgContent = new MessageOuterClass.MsgContent();
    MessageOuterClass.TextMsg localTextMsg1 = localMsgContent.text_msg;
    MessageOuterClass.TextMsg localTextMsg2 = new MessageOuterClass.TextMsg();
    localTextMsg2.text.set(paramString);
    localTextMsg1.set((MessageMicro)localTextMsg2);
    return localMsgContent;
  }
  
  public final void a()
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("\n                发送时间超过");
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(String.valueOf(2));
    ((StringBuilder)localObject2).append("分钟");
    ((StringBuilder)localObject1).append(((StringBuilder)localObject2).toString());
    ((StringBuilder)localObject1).append("");
    ((StringBuilder)localObject1).append("的消息\n                不能被撤回\n                ");
    localObject1 = StringsKt.trimIndent(((StringBuilder)localObject1).toString());
    localObject2 = TimiGameActivityManager.a();
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "TimiGameActivityManager.getTopQActivity()");
    new CommonDialog.Builder((Context)localObject2).c((String)localObject1).e(null).d("我知道了").a().show();
  }
  
  @JvmStatic
  public final void a(@NotNull Context paramContext, @NotNull IMsg paramIMsg)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    Intrinsics.checkParameterIsNotNull(paramIMsg, "msg");
    int i = paramIMsg.c();
    if (i != 1)
    {
      if (i != 70) {
        paramIMsg = "";
      } else {
        paramIMsg = paramIMsg.g().at_user_msg.text.get();
      }
    }
    else {
      paramIMsg = paramIMsg.g().text_msg.text.get();
    }
    if (!TextUtils.isEmpty((CharSequence)paramIMsg))
    {
      Object localObject = paramContext.getSystemService("clipboard");
      if (localObject != null)
      {
        localObject = (ClipboardManager)localObject;
        paramContext = ClipData.newPlainText((CharSequence)paramContext.getPackageName(), (CharSequence)EmotionCodecUtils.c(paramIMsg));
        ClipboardMonitor.setPrimaryClip((ClipboardManager)localObject, paramContext);
        ((ClipboardManager)localObject).setPrimaryClip(paramContext);
        CustomToastView.a("已复制");
        return;
      }
      throw new TypeCastException("null cannot be cast to non-null type android.content.ClipboardManager");
    }
    CustomToastView.a("复制失败");
  }
  
  @JvmStatic
  public final void a(@NotNull IMsg paramIMsg)
  {
    Intrinsics.checkParameterIsNotNull(paramIMsg, "msg");
    if (paramIMsg.k())
    {
      ((ITimiGameTimApi)ServiceCenter.a(ITimiGameTimApi.class)).b(paramIMsg.h()).c(paramIMsg);
      return;
    }
    ((ITimiGameTimApi)ServiceCenter.a(ITimiGameTimApi.class)).a(paramIMsg.i()).c(paramIMsg);
  }
  
  @JvmStatic
  public final void b(@NotNull IMsg paramIMsg)
  {
    Intrinsics.checkParameterIsNotNull(paramIMsg, "msg");
    if (paramIMsg.k())
    {
      ((ITimiGameTimApi)ServiceCenter.a(ITimiGameTimApi.class)).b(paramIMsg.h()).b(paramIMsg);
      return;
    }
    ((ITimiGameTimApi)ServiceCenter.a(ITimiGameTimApi.class)).a(paramIMsg.i()).b(paramIMsg);
  }
  
  @JvmStatic
  public final void c(@NotNull IMsg paramIMsg)
  {
    Intrinsics.checkParameterIsNotNull(paramIMsg, "msg");
    TimiGameAccusationApi.a(LongExKt.a(paramIMsg.d().uid.get()), LongExKt.a(paramIMsg.h()), LongExKt.a(paramIMsg.b()));
  }
  
  @JvmStatic
  public final void d(@NotNull IMsg paramIMsg)
  {
    Intrinsics.checkParameterIsNotNull(paramIMsg, "msg");
    if (!NetworkUtil.isNetworkAvailable())
    {
      CustomToastView.a("操作失败，请检查网络连接");
      return;
    }
    V2TIMManager.getMessageManager().revokeMessage(((MsgInfo)paramIMsg).o(), (V2TIMCallback)new MessageUtils.Companion.revocation.1(paramIMsg));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.tim.api.impl.message.MessageUtils.Companion
 * JD-Core Version:    0.7.0.1
 */