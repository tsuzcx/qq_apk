package com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DrawFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Path;
import android.graphics.Path.Op;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import androidx.annotation.RequiresApi;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntProgression;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/PlayTrackExpandWidthView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "bitmapMatrix", "Landroid/graphics/Matrix;", "clickRegion", "Landroid/graphics/Region;", "clickRegionRectF", "Landroid/graphics/RectF;", "drawBitmapPaint", "Landroid/graphics/Paint;", "endClipPath", "Landroid/graphics/Path;", "endClipWidth", "", "filter", "Landroid/graphics/PaintFlagsDrawFilter;", "location", "", "maskPaint", "maxLeftBorderWidth", "path", "screenWidth", "singleBitmapWidth", "startClipPath", "startClipWidth", "videoThumbProvider", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/IVideoTrackBitmapProvider;", "checkNeedDraw", "", "checkRegion", "x", "y", "computeDrawHorizontalRegion", "Lkotlin/Pair;", "screenX", "computeSingleBitmapPath", "", "startDrawX", "bitmapWidth", "drawBitmapList", "canvas", "Landroid/graphics/Canvas;", "drawMask", "drawSingleBitmap", "bitmap", "Landroid/graphics/Bitmap;", "isClickEndClipRegion", "isClickStartClipRegion", "onDraw", "resetClipPath", "resetMatrix", "leftOffset", "topOffset", "resetShader", "paint", "setEndClipWidth", "px", "setMaxLeftBorderWidth", "setSingleBitmapWidth", "setStartClipWidth", "setThumbProvider", "provider", "Companion", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class PlayTrackExpandWidthView
  extends View
{
  public static final PlayTrackExpandWidthView.Companion a = new PlayTrackExpandWidthView.Companion(null);
  private final Paint b;
  private final PaintFlagsDrawFilter c;
  private int d;
  private int e;
  private final int[] f;
  private final Matrix g;
  private final Path h;
  private float i;
  private final Path j;
  private float k;
  private final Path l;
  private final RectF m;
  private final Region n;
  private IVideoTrackBitmapProvider o;
  private int p;
  private final Paint q;
  
  @JvmOverloads
  public PlayTrackExpandWidthView(@NotNull Context paramContext)
  {
    this(paramContext, null, 0, 6, null);
  }
  
  @JvmOverloads
  public PlayTrackExpandWidthView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0, 4, null);
  }
  
  @JvmOverloads
  public PlayTrackExpandWidthView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramAttributeSet = new Paint();
    paramAttributeSet.setAntiAlias(true);
    this.b = paramAttributeSet;
    this.c = new PaintFlagsDrawFilter(0, 3);
    this.f = new int[2];
    this.g = new Matrix();
    this.h = new Path();
    this.j = new Path();
    this.l = new Path();
    this.m = new RectF();
    this.n = new Region();
    this.o = ((IVideoTrackBitmapProvider)new PlayTrackExpandWidthView.videoThumbProvider.1());
    paramAttributeSet = new Paint();
    paramAttributeSet.setAntiAlias(true);
    paramAttributeSet.setStyle(Paint.Style.FILL);
    paramAttributeSet.setColor(Color.parseColor("#88000000"));
    this.q = paramAttributeSet;
    paramContext = paramContext.getResources();
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "context.resources");
    this.e = paramContext.getDisplayMetrics().widthPixels;
  }
  
  private final Pair<Integer, Integer> a(int paramInt)
  {
    int i1 = Math.max(-paramInt, 0);
    if (paramInt <= 0) {
      paramInt = Math.min(this.e, getMeasuredWidth() + paramInt);
    } else {
      paramInt = Math.min(this.e - paramInt, getMeasuredWidth());
    }
    return TuplesKt.to(Integer.valueOf(i1 - (this.p + i1) % this.d), Integer.valueOf(paramInt + i1));
  }
  
  private final void a()
  {
    Path localPath = this.j;
    localPath.reset();
    localPath.moveTo(0.0F, 0.0F);
    localPath.lineTo(this.i, 0.0F);
    localPath.lineTo(0.0F, getMeasuredHeight());
    localPath.lineTo(0.0F, 0.0F);
    localPath.close();
    localPath = this.l;
    localPath.reset();
    localPath.moveTo(getMeasuredWidth(), 0.0F);
    localPath.lineTo(getMeasuredWidth(), getMeasuredHeight());
    localPath.lineTo(getMeasuredWidth() - this.k, getMeasuredHeight());
    localPath.lineTo(getMeasuredWidth(), 0.0F);
    localPath.close();
  }
  
  private final void a(Bitmap paramBitmap, Paint paramPaint, float paramFloat1, float paramFloat2)
  {
    paramPaint.reset();
    paramBitmap = new BitmapShader(paramBitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
    c(paramFloat1, paramFloat2);
    paramBitmap.setLocalMatrix(this.g);
    paramPaint.setShader((Shader)paramBitmap);
  }
  
  private final void a(Canvas paramCanvas)
  {
    if (isSelected())
    {
      a();
      paramCanvas.drawPath(this.j, this.q);
      paramCanvas.drawPath(this.l, this.q);
    }
  }
  
  @RequiresApi(19)
  private final void a(Canvas paramCanvas, Bitmap paramBitmap, float paramFloat)
  {
    int i1 = paramBitmap.getWidth();
    int i2 = this.d;
    int i3 = paramBitmap.getHeight();
    int i4 = getHeight();
    a(paramBitmap, this.b, paramFloat - (i1 - i2 >> 1), i3 - i4 >> 1);
    a();
    d(paramFloat, this.d);
    paramCanvas.drawPath(this.h, this.b);
  }
  
  private final boolean a(Path paramPath, float paramFloat1, float paramFloat2)
  {
    RectF localRectF = this.m;
    localRectF.setEmpty();
    paramPath.computeBounds(localRectF, true);
    this.n.setPath(paramPath, new Region((int)localRectF.left, (int)localRectF.top, (int)localRectF.right, (int)localRectF.bottom));
    return this.n.contains((int)paramFloat1, (int)paramFloat2);
  }
  
  private final boolean a(int[] paramArrayOfInt)
  {
    int i1 = paramArrayOfInt.length;
    boolean bool = true;
    if (i1 == 0) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    if (i1 != 0) {
      return false;
    }
    if ((paramArrayOfInt[0] > this.e) || (paramArrayOfInt[0] + getMeasuredWidth() < 0)) {
      bool = false;
    }
    return bool;
  }
  
  @RequiresApi(19)
  private final void b(Canvas paramCanvas)
  {
    Object localObject = a(this.f[0]);
    localObject = RangesKt.step((IntProgression)new IntRange(((Number)((Pair)localObject).component1()).intValue(), ((Number)((Pair)localObject).component2()).intValue()), this.d);
    int i1 = ((IntProgression)localObject).getFirst();
    int i2 = ((IntProgression)localObject).getLast();
    int i3 = ((IntProgression)localObject).getStep();
    if (i3 >= 0 ? i1 <= i2 : i1 >= i2) {
      for (;;)
      {
        localObject = this.o.a(this.p + i1, null);
        if (localObject != null) {
          a(paramCanvas, (Bitmap)localObject, i1);
        }
        if (i1 == i2) {
          break;
        }
        i1 += i3;
      }
    }
  }
  
  private final void c(float paramFloat1, float paramFloat2)
  {
    this.g.reset();
    this.g.postTranslate(paramFloat1, -paramFloat2);
  }
  
  @RequiresApi(19)
  private final void d(float paramFloat1, float paramFloat2)
  {
    Path localPath = this.h;
    localPath.reset();
    localPath.moveTo(paramFloat1, 0.0F);
    paramFloat2 += paramFloat1;
    localPath.lineTo(paramFloat2, 0.0F);
    localPath.lineTo(paramFloat2, getMeasuredHeight());
    localPath.lineTo(paramFloat1, getMeasuredHeight());
    localPath.lineTo(paramFloat1, 0.0F);
    localPath.close();
    if (!isSelected())
    {
      localPath.op(this.j, Path.Op.DIFFERENCE);
      localPath.op(this.l, Path.Op.DIFFERENCE);
    }
  }
  
  public final boolean a(float paramFloat1, float paramFloat2)
  {
    return a(this.j, paramFloat1, paramFloat2);
  }
  
  public final boolean b(float paramFloat1, float paramFloat2)
  {
    return a(this.l, paramFloat1, paramFloat2);
  }
  
  @RequiresApi(19)
  protected void onDraw(@NotNull Canvas paramCanvas)
  {
    Intrinsics.checkParameterIsNotNull(paramCanvas, "canvas");
    super.onDraw(paramCanvas);
    getLocationOnScreen(this.f);
    if (!a(this.f)) {
      return;
    }
    paramCanvas.setDrawFilter((DrawFilter)this.c);
    b(paramCanvas);
    a(paramCanvas);
  }
  
  public final void setEndClipWidth(float paramFloat)
  {
    this.k = paramFloat;
  }
  
  public final void setMaxLeftBorderWidth(int paramInt)
  {
    this.p = paramInt;
  }
  
  public final void setSingleBitmapWidth(int paramInt)
  {
    this.d = paramInt;
  }
  
  public final void setStartClipWidth(float paramFloat)
  {
    this.i = paramFloat;
  }
  
  public final void setThumbProvider(@NotNull IVideoTrackBitmapProvider paramIVideoTrackBitmapProvider)
  {
    Intrinsics.checkParameterIsNotNull(paramIVideoTrackBitmapProvider, "provider");
    this.o = paramIVideoTrackBitmapProvider;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack.PlayTrackExpandWidthView
 * JD-Core Version:    0.7.0.1
 */