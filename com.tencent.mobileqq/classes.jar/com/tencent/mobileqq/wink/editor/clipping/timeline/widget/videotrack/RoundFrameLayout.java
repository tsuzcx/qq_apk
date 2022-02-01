package com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.DrawFilter;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/RoundFrameLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "flagsDrawFilter", "Landroid/graphics/PaintFlagsDrawFilter;", "path", "Landroid/graphics/Path;", "radius", "rect", "Landroid/graphics/RectF;", "dispatchDraw", "", "canvas", "Landroid/graphics/Canvas;", "onSizeChanged", "w", "h", "oldw", "oldh", "roundRect", "setRadius", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class RoundFrameLayout
  extends FrameLayout
{
  private final Path a = new Path();
  private final RectF b = new RectF();
  private int c;
  private final PaintFlagsDrawFilter d = new PaintFlagsDrawFilter(0, 2);
  
  @JvmOverloads
  public RoundFrameLayout(@NotNull Context paramContext)
  {
    this(paramContext, null, 0, 6, null);
  }
  
  @JvmOverloads
  public RoundFrameLayout(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0, 4, null);
  }
  
  @JvmOverloads
  public RoundFrameLayout(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private final void a(int paramInt1, int paramInt2)
  {
    this.a.reset();
    this.b.set(0.0F, 0.0F, paramInt1, paramInt2);
    Path localPath = this.a;
    RectF localRectF = this.b;
    paramInt1 = this.c;
    localPath.addRoundRect(localRectF, paramInt1, paramInt1, Path.Direction.CW);
  }
  
  protected void dispatchDraw(@NotNull Canvas paramCanvas)
  {
    Intrinsics.checkParameterIsNotNull(paramCanvas, "canvas");
    paramCanvas.save();
    paramCanvas.setDrawFilter((DrawFilter)this.d);
    paramCanvas.clipPath(this.a);
    super.dispatchDraw(paramCanvas);
    paramCanvas.restore();
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    a(paramInt1, paramInt2);
  }
  
  public final void setRadius(int paramInt)
  {
    this.c = paramInt;
    a(getWidth(), getHeight());
    postInvalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack.RoundFrameLayout
 * JD-Core Version:    0.7.0.1
 */