package com.tencent.timi.game.ui;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/ui/NoUnderlineClickSpan;", "Landroid/text/style/ClickableSpan;", "()V", "onClick", "", "widget", "Landroid/view/View;", "updateDrawState", "ds", "Landroid/text/TextPaint;", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public class NoUnderlineClickSpan
  extends ClickableSpan
{
  public void onClick(@NotNull View paramView)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "widget");
  }
  
  public void updateDrawState(@NotNull TextPaint paramTextPaint)
  {
    Intrinsics.checkParameterIsNotNull(paramTextPaint, "ds");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.ui.NoUnderlineClickSpan
 * JD-Core Version:    0.7.0.1
 */