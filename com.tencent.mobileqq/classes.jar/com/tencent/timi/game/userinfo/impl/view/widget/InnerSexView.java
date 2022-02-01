package com.tencent.timi.game.userinfo.impl.view.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/userinfo/impl/view/widget/InnerSexView;", "Landroid/widget/ImageView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "sexIcon", "Landroid/graphics/drawable/Drawable;", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "setSexInco", "icon", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class InnerSexView
  extends ImageView
{
  private Drawable a;
  
  public InnerSexView(@Nullable Context paramContext)
  {
    super(paramContext);
  }
  
  public InnerSexView(@Nullable Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public InnerSexView(@Nullable Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void onDraw(@NotNull Canvas paramCanvas)
  {
    Intrinsics.checkParameterIsNotNull(paramCanvas, "canvas");
    super.onDraw(paramCanvas);
    Drawable localDrawable = this.a;
    if ((localDrawable != null) && (localDrawable != null))
    {
      paramCanvas.save();
      float f = getMeasuredHeight() * 16 / 48.0F;
      int i = (int)f;
      localDrawable.setBounds(0, 0, i, i);
      paramCanvas.translate(getMeasuredWidth() - f - getPaddingRight(), getMeasuredHeight() - f - getPaddingBottom());
      localDrawable.draw(paramCanvas);
      paramCanvas.restore();
    }
  }
  
  public final void setSexInco(@Nullable Drawable paramDrawable)
  {
    this.a = paramDrawable;
    invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.userinfo.impl.view.widget.InnerSexView
 * JD-Core Version:    0.7.0.1
 */