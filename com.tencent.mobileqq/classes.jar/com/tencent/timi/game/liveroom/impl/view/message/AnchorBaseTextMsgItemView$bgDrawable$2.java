package com.tencent.timi.game.liveroom.impl.view.message;

import android.graphics.drawable.GradientDrawable;
import com.tencent.timi.game.ex.LayoutExKt;
import com.tencent.timi.game.ex.ViewExKt;
import com.tencent.timi.game.ui.utils.ResUtils;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Landroid/graphics/drawable/GradientDrawable;", "invoke"}, k=3, mv={1, 1, 16})
final class AnchorBaseTextMsgItemView$bgDrawable$2
  extends Lambda
  implements Function0<GradientDrawable>
{
  public static final 2 INSTANCE = new 2();
  
  AnchorBaseTextMsgItemView$bgDrawable$2()
  {
    super(0);
  }
  
  @NotNull
  public final GradientDrawable invoke()
  {
    GradientDrawable localGradientDrawable = ViewExKt.a(new GradientDrawable(), LayoutExKt.a(4), LayoutExKt.a(50), LayoutExKt.a(50), LayoutExKt.a(50));
    localGradientDrawable.setColor(ResUtils.b(2131165574));
    return localGradientDrawable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.view.message.AnchorBaseTextMsgItemView.bgDrawable.2
 * JD-Core Version:    0.7.0.1
 */