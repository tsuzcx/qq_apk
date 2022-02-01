package com.tencent.timi.game.ui.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.graphics.Xfermode;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.tencent.timi.game.utils.CommonExKt;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/ui/widget/FadeOutFrameLayout;", "Landroid/widget/FrameLayout;", "ctx", "Landroid/content/Context;", "attr", "Landroid/util/AttributeSet;", "def", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "dstInXfermode", "Landroid/graphics/PorterDuffXfermode;", "linearGradient", "Landroid/graphics/LinearGradient;", "offsetLeft", "", "offsetTop", "paint", "Landroid/graphics/Paint;", "rect", "Landroid/graphics/Rect;", "dispatchDraw", "", "canvas", "Landroid/graphics/Canvas;", "onSizeChanged", "w", "h", "oldw", "oldh", "setFadeOffset", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class FadeOutFrameLayout
  extends FrameLayout
{
  private final Paint a = new Paint();
  private final Rect b = new Rect();
  private LinearGradient c;
  private final PorterDuffXfermode d = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
  private float e = CommonExKt.b(16);
  private float f;
  
  @JvmOverloads
  public FadeOutFrameLayout(@NotNull Context paramContext)
  {
    this(paramContext, null, 0, 6, null);
  }
  
  @JvmOverloads
  public FadeOutFrameLayout(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0, 4, null);
  }
  
  @JvmOverloads
  public FadeOutFrameLayout(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setWillNotDraw(false);
  }
  
  protected void dispatchDraw(@Nullable Canvas paramCanvas)
  {
    if (paramCanvas != null)
    {
      int i = paramCanvas.saveLayer(0.0F, 0.0F, getWidth(), getHeight(), null, 31);
      super.dispatchDraw(paramCanvas);
      this.b.set(0, 0, getWidth(), getHeight());
      this.a.setShader((Shader)this.c);
      this.a.setXfermode((Xfermode)this.d);
      paramCanvas.translate(this.e, this.f);
      paramCanvas.drawRect(this.b, this.a);
      this.a.setShader((Shader)null);
      this.a.setXfermode((Xfermode)null);
      paramCanvas.restoreToCount(i);
    }
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.c = new LinearGradient(0.0F, 0.0F, getWidth() - this.e, 0.0F, Color.parseColor("#FFFFFF"), Color.parseColor("#00FFFFFF"), Shader.TileMode.CLAMP);
  }
  
  public final void setFadeOffset(float paramFloat1, float paramFloat2)
  {
    this.e = paramFloat1;
    this.f = paramFloat2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.ui.widget.FadeOutFrameLayout
 * JD-Core Version:    0.7.0.1
 */