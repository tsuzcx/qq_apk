package com.tencent.timi.game.component.chat.at;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import trpc.yes.common.CommonOuterClass.QQUserId;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/timi/game/component/chat/at/ChatAtMessageUtil$realSetAtSpan$1", "Landroid/text/style/ClickableSpan;", "onClick", "", "widget", "Landroid/view/View;", "updateDrawState", "ds", "Landroid/text/TextPaint;", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class ChatAtMessageUtil$realSetAtSpan$1
  extends ClickableSpan
{
  ChatAtMessageUtil$realSetAtSpan$1(AtMessageClickListener paramAtMessageClickListener, CommonOuterClass.QQUserId paramQQUserId, int paramInt, boolean paramBoolean) {}
  
  public void onClick(@NotNull View paramView)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "widget");
    this.a.a(this.b);
  }
  
  public void updateDrawState(@NotNull TextPaint paramTextPaint)
  {
    Intrinsics.checkParameterIsNotNull(paramTextPaint, "ds");
    paramTextPaint.setColor(this.c);
    paramTextPaint.setUnderlineText(this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.component.chat.at.ChatAtMessageUtil.realSetAtSpan.1
 * JD-Core Version:    0.7.0.1
 */