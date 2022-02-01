package com.tencent.timi.game.component.chat.message;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import com.tencent.timi.game.ex.LayoutExKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Landroid/graphics/drawable/GradientDrawable;", "invoke"}, k=3, mv={1, 1, 16})
final class BaseMessageView$onlineStatusDrawable$2
  extends Lambda
  implements Function0<GradientDrawable>
{
  public static final 2 INSTANCE = new 2();
  
  BaseMessageView$onlineStatusDrawable$2()
  {
    super(0);
  }
  
  @NotNull
  public final GradientDrawable invoke()
  {
    GradientDrawable localGradientDrawable = new GradientDrawable();
    localGradientDrawable.setCornerRadius(LayoutExKt.a(45));
    localGradientDrawable.setStroke(LayoutExKt.b(1), Color.parseColor("#00CC8F"));
    return localGradientDrawable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.component.chat.message.BaseMessageView.onlineStatusDrawable.2
 * JD-Core Version:    0.7.0.1
 */