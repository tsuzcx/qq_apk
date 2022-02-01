package com.tencent.timi.game.component.chat.message;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import com.tencent.timi.game.ex.LayoutExKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Landroid/graphics/drawable/GradientDrawable;", "invoke"}, k=3, mv={1, 1, 16})
final class TeamMessageItemView$grayDefaultDrawable$2
  extends Lambda
  implements Function0<GradientDrawable>
{
  public static final 2 INSTANCE = new 2();
  
  TeamMessageItemView$grayDefaultDrawable$2()
  {
    super(0);
  }
  
  @NotNull
  public final GradientDrawable invoke()
  {
    GradientDrawable localGradientDrawable = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[] { Color.parseColor("#BEBEBE"), Color.parseColor("#BEBEBE") });
    localGradientDrawable.setCornerRadius(LayoutExKt.a(15));
    return localGradientDrawable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.component.chat.message.TeamMessageItemView.grayDefaultDrawable.2
 * JD-Core Version:    0.7.0.1
 */