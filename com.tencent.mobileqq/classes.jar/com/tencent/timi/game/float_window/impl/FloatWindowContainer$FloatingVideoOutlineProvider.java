package com.tencent.timi.game.float_window.impl;

import android.graphics.Outline;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.annotation.RequiresApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/float_window/impl/FloatWindowContainer$FloatingVideoOutlineProvider;", "Landroid/view/ViewOutlineProvider;", "mRadius", "", "(I)V", "getOutline", "", "view", "Landroid/view/View;", "outline", "Landroid/graphics/Outline;", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
@RequiresApi(api=21)
public final class FloatWindowContainer$FloatingVideoOutlineProvider
  extends ViewOutlineProvider
{
  private final int a;
  
  public FloatWindowContainer$FloatingVideoOutlineProvider(int paramInt)
  {
    this.a = paramInt;
  }
  
  public void getOutline(@NotNull View paramView, @NotNull Outline paramOutline)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "view");
    Intrinsics.checkParameterIsNotNull(paramOutline, "outline");
    Rect localRect = new Rect();
    paramView.getGlobalVisibleRect(localRect);
    paramOutline.setRoundRect(new Rect(0, 0, localRect.right - localRect.left - 0, localRect.bottom - localRect.top - 0), this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.float_window.impl.FloatWindowContainer.FloatingVideoOutlineProvider
 * JD-Core Version:    0.7.0.1
 */