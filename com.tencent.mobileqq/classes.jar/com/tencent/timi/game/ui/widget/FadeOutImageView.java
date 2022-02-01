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
import android.view.View;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.timi.game.utils.Logger;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/ui/widget/FadeOutImageView;", "Landroid/view/View;", "Lcom/tencent/image/URLDrawable$URLDrawableListener;", "ctx", "Landroid/content/Context;", "attr", "Landroid/util/AttributeSet;", "def", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "dstInXfermode", "Landroid/graphics/PorterDuffXfermode;", "imgDrawable", "Lcom/tencent/image/URLDrawable;", "linearGradient", "Landroid/graphics/LinearGradient;", "paint", "Landroid/graphics/Paint;", "rect", "Landroid/graphics/Rect;", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "onLoadCanceled", "p0", "onLoadFialed", "p1", "", "onLoadProgressed", "onLoadSuccessed", "onSizeChanged", "w", "h", "oldw", "oldh", "setImageResource", "Companion", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class FadeOutImageView
  extends View
  implements URLDrawable.URLDrawableListener
{
  public static final FadeOutImageView.Companion a = new FadeOutImageView.Companion(null);
  private final Paint b = new Paint();
  private URLDrawable c;
  private final Rect d = new Rect();
  private LinearGradient e;
  private final PorterDuffXfermode f = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
  
  @JvmOverloads
  public FadeOutImageView(@NotNull Context paramContext)
  {
    this(paramContext, null, 0, 6, null);
  }
  
  @JvmOverloads
  public FadeOutImageView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0, 4, null);
  }
  
  @JvmOverloads
  public FadeOutImageView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void onDraw(@Nullable Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (paramCanvas != null)
    {
      int i = paramCanvas.saveLayer(0.0F, 0.0F, getWidth(), getHeight(), null, 31);
      this.d.set(0, 0, getWidth(), getHeight());
      URLDrawable localURLDrawable = this.c;
      if (localURLDrawable != null)
      {
        localURLDrawable.getBounds().set(0, 0, getWidth(), getHeight());
        localURLDrawable.draw(paramCanvas);
      }
      this.b.setShader((Shader)this.e);
      this.b.setXfermode((Xfermode)this.f);
      paramCanvas.drawRect(this.d, this.b);
      this.b.setShader((Shader)null);
      this.b.setXfermode((Xfermode)null);
      paramCanvas.restoreToCount(i);
    }
  }
  
  public void onLoadCanceled(@Nullable URLDrawable paramURLDrawable)
  {
    Logger.c("FadeOutImageView", "onLoadCanceled");
  }
  
  public void onLoadFialed(@Nullable URLDrawable paramURLDrawable, @Nullable Throwable paramThrowable)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onLoadFialed ");
    if (paramThrowable != null) {
      paramURLDrawable = paramThrowable.getMessage();
    } else {
      paramURLDrawable = null;
    }
    localStringBuilder.append(paramURLDrawable);
    Logger.c("FadeOutImageView", localStringBuilder.toString());
  }
  
  public void onLoadProgressed(@Nullable URLDrawable paramURLDrawable, int paramInt)
  {
    Logger.c("FadeOutImageView", "onLoadProgressed");
  }
  
  public void onLoadSuccessed(@Nullable URLDrawable paramURLDrawable)
  {
    Logger.c("FadeOutImageView", "onLoadSuccessed");
    this.c = paramURLDrawable;
    invalidate();
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.e = new LinearGradient(0.0F, 0.0F, getWidth(), 0.0F, Color.parseColor("#FFFFFF"), Color.parseColor("#00FFFFFF"), Shader.TileMode.CLAMP);
  }
  
  public final void setImageResource(@Nullable URLDrawable paramURLDrawable)
  {
    URLDrawable localURLDrawable = this.c;
    if (localURLDrawable != null) {
      localURLDrawable.setURLDrawableListener(null);
    }
    if (paramURLDrawable != null) {
      paramURLDrawable.setURLDrawableListener((URLDrawable.URLDrawableListener)this);
    }
    this.c = paramURLDrawable;
    invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.ui.widget.FadeOutImageView
 * JD-Core Version:    0.7.0.1
 */