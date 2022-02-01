package com.tencent.timi.game.ui.widget.shadow;

import android.graphics.Paint;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/ui/widget/shadow/ShadowStrategy;", "", "shadowHeight", "", "paint", "Landroid/graphics/Paint;", "shadowColor", "", "(FLandroid/graphics/Paint;I)V", "getPaint", "()Landroid/graphics/Paint;", "getShadowColor", "()I", "getShadowHeight", "()F", "getShader", "Landroid/graphics/Shader;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "onDrawOver", "", "canvas", "Landroid/graphics/Canvas;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public abstract class ShadowStrategy
{
  private final float a;
  @NotNull
  private final Paint b;
  private final int c;
  
  public ShadowStrategy(float paramFloat, @NotNull Paint paramPaint, int paramInt)
  {
    this.a = paramFloat;
    this.b = paramPaint;
    this.c = paramInt;
  }
  
  public final float a()
  {
    return this.a;
  }
  
  @NotNull
  public final Paint b()
  {
    return this.b;
  }
  
  public final int c()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.ui.widget.shadow.ShadowStrategy
 * JD-Core Version:    0.7.0.1
 */