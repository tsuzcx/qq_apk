package com.tencent.timi.game.ui.widget.shadow;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.State;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/ui/widget/shadow/TopShadowStrategy;", "Lcom/tencent/timi/game/ui/widget/shadow/ShadowStrategy;", "shadowHeight", "", "paint", "Landroid/graphics/Paint;", "shadowColor", "", "(FLandroid/graphics/Paint;I)V", "isCanDrawShadow", "", "mScrollHelper", "Lcom/tencent/timi/game/ui/widget/shadow/RecyclerViewScrollHelper;", "getShader", "Landroid/graphics/Shader;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "onDrawOver", "", "canvas", "Landroid/graphics/Canvas;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class TopShadowStrategy
  extends ShadowStrategy
{
  private RecyclerViewScrollHelper a;
  private boolean b;
  
  public TopShadowStrategy(float paramFloat, @NotNull Paint paramPaint, int paramInt)
  {
    super(paramFloat, paramPaint, paramInt);
  }
  
  @NotNull
  public Shader a(@NotNull RecyclerView paramRecyclerView)
  {
    Intrinsics.checkParameterIsNotNull(paramRecyclerView, "parent");
    Object localObject = (TopShadowStrategy)this;
    if (((TopShadowStrategy)localObject).a == null)
    {
      this.a = new RecyclerViewScrollHelper();
      RecyclerViewScrollHelper localRecyclerViewScrollHelper = this.a;
      if (localRecyclerViewScrollHelper == null) {
        Intrinsics.throwUninitializedPropertyAccessException("mScrollHelper");
      }
      localRecyclerViewScrollHelper.a(paramRecyclerView, (RecyclerViewScrollHelper.Callback)new TopShadowStrategy.getShader.2(this));
    }
    float f = ((TopShadowStrategy)localObject).a();
    int i = ((TopShadowStrategy)localObject).c();
    paramRecyclerView = Shader.TileMode.CLAMP;
    localObject = (float[])null;
    return (Shader)new LinearGradient(0.0F, 0.0F, 0.0F, f, new int[] { 0, i }, (float[])localObject, paramRecyclerView);
  }
  
  public void a(@NotNull Canvas paramCanvas, @NotNull RecyclerView paramRecyclerView, @NotNull RecyclerView.State paramState)
  {
    Intrinsics.checkParameterIsNotNull(paramCanvas, "canvas");
    Intrinsics.checkParameterIsNotNull(paramRecyclerView, "parent");
    Intrinsics.checkParameterIsNotNull(paramState, "state");
    if (this.b) {
      paramCanvas.drawRect(new RectF(0.0F, 0.0F, paramRecyclerView.getWidth(), a()), b());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.ui.widget.shadow.TopShadowStrategy
 * JD-Core Version:    0.7.0.1
 */