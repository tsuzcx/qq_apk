package com.tencent.timi.game.ui.widget.shadow;

import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ItemDecoration;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref.IntRef;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"initTopAndBottomShadow", "", "Landroidx/recyclerview/widget/RecyclerView;", "topShadowHeight", "", "bottomShadowHeight", "shadowColor", "", "timi-game-impl_release"}, k=2, mv={1, 1, 16})
public final class ShadowUtilKt
{
  public static final void a(@NotNull RecyclerView paramRecyclerView, float paramFloat1, float paramFloat2, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramRecyclerView, "$this$initTopAndBottomShadow");
    Paint localPaint = new Paint();
    TopShadowStrategy localTopShadowStrategy = new TopShadowStrategy(paramFloat1, localPaint, paramInt);
    BottomShadowStrategy localBottomShadowStrategy = new BottomShadowStrategy(paramFloat2, localPaint, paramInt);
    PorterDuffXfermode localPorterDuffXfermode = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
    Ref.IntRef localIntRef = new Ref.IntRef();
    localIntRef.element = 0;
    paramRecyclerView.addItemDecoration((RecyclerView.ItemDecoration)new ShadowUtilKt.initTopAndBottomShadow.1(localIntRef, localPaint, localPorterDuffXfermode, localTopShadowStrategy, localBottomShadowStrategy));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.ui.widget.shadow.ShadowUtilKt
 * JD-Core Version:    0.7.0.1
 */