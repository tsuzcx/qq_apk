package com.tencent.timi.game.ui.widget.shadow;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuffXfermode;
import android.graphics.Xfermode;
import android.os.Build.VERSION;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ItemDecoration;
import androidx.recyclerview.widget.RecyclerView.State;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref.IntRef;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/timi/game/ui/widget/shadow/ShadowUtilKt$initTopAndBottomShadow$1", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "onDraw", "", "c", "Landroid/graphics/Canvas;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "onDrawOver", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class ShadowUtilKt$initTopAndBottomShadow$1
  extends RecyclerView.ItemDecoration
{
  ShadowUtilKt$initTopAndBottomShadow$1(Ref.IntRef paramIntRef, Paint paramPaint, PorterDuffXfermode paramPorterDuffXfermode, TopShadowStrategy paramTopShadowStrategy, BottomShadowStrategy paramBottomShadowStrategy) {}
  
  public void onDraw(@NotNull Canvas paramCanvas, @NotNull RecyclerView paramRecyclerView, @NotNull RecyclerView.State paramState)
  {
    Intrinsics.checkParameterIsNotNull(paramCanvas, "c");
    Intrinsics.checkParameterIsNotNull(paramRecyclerView, "parent");
    Intrinsics.checkParameterIsNotNull(paramState, "state");
    super.onDraw(paramCanvas, paramRecyclerView, paramState);
    paramState = this.a;
    int i;
    if (Build.VERSION.SDK_INT >= 21) {
      i = paramCanvas.saveLayer(0.0F, 0.0F, paramRecyclerView.getWidth(), paramRecyclerView.getHeight(), this.b);
    } else {
      i = paramCanvas.saveLayer(0.0F, 0.0F, paramRecyclerView.getWidth(), paramRecyclerView.getHeight(), this.b, 31);
    }
    paramState.element = i;
  }
  
  public void onDrawOver(@NotNull Canvas paramCanvas, @NotNull RecyclerView paramRecyclerView, @NotNull RecyclerView.State paramState)
  {
    Intrinsics.checkParameterIsNotNull(paramCanvas, "c");
    Intrinsics.checkParameterIsNotNull(paramRecyclerView, "parent");
    Intrinsics.checkParameterIsNotNull(paramState, "state");
    super.onDrawOver(paramCanvas, paramRecyclerView, paramState);
    this.b.setXfermode((Xfermode)this.c);
    this.b.setShader(this.d.a(paramRecyclerView));
    this.d.a(paramCanvas, paramRecyclerView, paramState);
    this.b.setShader(this.e.a(paramRecyclerView));
    this.e.a(paramCanvas, paramRecyclerView, paramState);
    this.b.setXfermode((Xfermode)null);
    paramCanvas.restoreToCount(this.a.element);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.ui.widget.shadow.ShadowUtilKt.initTopAndBottomShadow.1
 * JD-Core Version:    0.7.0.1
 */