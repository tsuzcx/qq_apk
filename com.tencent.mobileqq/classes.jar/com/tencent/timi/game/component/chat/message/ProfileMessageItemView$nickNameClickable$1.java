package com.tencent.timi.game.component.chat.message;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.timi.game.utils.NoDoubleClickUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/timi/game/component/chat/message/ProfileMessageItemView$nickNameClickable$1", "Landroid/text/style/ClickableSpan;", "onClick", "", "widget", "Landroid/view/View;", "updateDrawState", "ds", "Landroid/text/TextPaint;", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class ProfileMessageItemView$nickNameClickable$1
  extends ClickableSpan
{
  public void onClick(@NotNull View paramView)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "widget");
    if (!NoDoubleClickUtils.a()) {
      ProfileMessageItemView.h(this.a);
    }
  }
  
  public void updateDrawState(@NotNull TextPaint paramTextPaint)
  {
    Intrinsics.checkParameterIsNotNull(paramTextPaint, "ds");
    paramTextPaint.setColor(ProfileMessageItemView.i(this.a));
    paramTextPaint.setUnderlineText(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.component.chat.message.ProfileMessageItemView.nickNameClickable.1
 * JD-Core Version:    0.7.0.1
 */