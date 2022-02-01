package com.tencent.timi.game.component.chat.util;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.timi.game.sp.TGSharedPreferenceUtil;
import com.tencent.timi.game.tim.api.message.IMsgManager;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.CommonOuterClass.QQUserId;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/timi/game/component/chat/util/MessageUtil$showProfileSendTip$2", "Landroid/content/DialogInterface$OnClickListener;", "onClick", "", "dialog", "Landroid/content/DialogInterface;", "which", "", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class MessageUtil$showProfileSendTip$2
  implements DialogInterface.OnClickListener
{
  MessageUtil$showProfileSendTip$2(CommonOuterClass.QQUserId paramQQUserId, IMsgManager paramIMsgManager, Context paramContext) {}
  
  public void onClick(@Nullable DialogInterface paramDialogInterface, int paramInt)
  {
    TGSharedPreferenceUtil.a(MessageUtil.b(MessageUtil.a), true);
    MessageUtil.b(MessageUtil.a, this.a, this.b, this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.component.chat.util.MessageUtil.showProfileSendTip.2
 * JD-Core Version:    0.7.0.1
 */