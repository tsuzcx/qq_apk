package com.tencent.mobileqq.wink.editor.clipping.timeline.widget.dragdrop;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import androidx.annotation.RequiresApi;
import com.tencent.videocut.utils.DensityUtils;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/dragdrop/BottomLineRelativeLayout;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "bottomLineColor", "drawBottomLine", "", "needDrawTrackBackground", "paint", "Landroid/graphics/Paint;", "trackColor", "trackModels", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/dragdrop/TrackModel;", "trackRadius", "", "", "canvas", "Landroid/graphics/Canvas;", "drawTrackBackground", "getBottomLineColor", "getTrackColor", "isBottomLineShow", "isBottomLineShow$qq_wink_impl_release", "onDraw", "setBottomLineColor", "color", "setDrawBottomLine", "setNeedDrawTrackBackground", "setTrackColor", "setTrackList", "setTrackRadius", "radius", "Companion", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class BottomLineRelativeLayout
  extends RelativeLayout
{
  public static final BottomLineRelativeLayout.Companion a = new BottomLineRelativeLayout.Companion(null);
  private ArrayList<TrackModel> b;
  private boolean c;
  private Paint d;
  private boolean e;
  private int f;
  private int g;
  private float h;
  
  public BottomLineRelativeLayout(@Nullable Context paramContext)
  {
    super(paramContext);
    paramContext = new Paint();
    paramContext.setAntiAlias(true);
    paramContext.setStrokeWidth(DensityUtils.a.a(2.0F));
    this.d = paramContext;
    this.f = getResources().getColor(2131167867);
    this.g = getResources().getColor(2131166159);
    this.h = DensityUtils.a.a(2.0F);
  }
  
  public BottomLineRelativeLayout(@Nullable Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = new Paint();
    paramContext.setAntiAlias(true);
    paramContext.setStrokeWidth(DensityUtils.a.a(2.0F));
    this.d = paramContext;
    this.f = getResources().getColor(2131167867);
    this.g = getResources().getColor(2131166159);
    this.h = DensityUtils.a.a(2.0F);
  }
  
  public BottomLineRelativeLayout(@Nullable Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = new Paint();
    paramContext.setAntiAlias(true);
    paramContext.setStrokeWidth(DensityUtils.a.a(2.0F));
    this.d = paramContext;
    this.f = getResources().getColor(2131167867);
    this.g = getResources().getColor(2131166159);
    this.h = DensityUtils.a.a(2.0F);
  }
  
  @RequiresApi(21)
  private final void a(Canvas paramCanvas)
  {
    if (!this.c) {
      return;
    }
    Object localObject = this.b;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("trackModels");
    }
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      TrackModel localTrackModel = (TrackModel)((Iterator)localObject).next();
      this.d.setColor(getTrackColor());
      float f1 = localTrackModel.d();
      float f2 = localTrackModel.b();
      float f3 = getRight();
      float f4 = localTrackModel.e();
      float f5 = localTrackModel.c();
      float f6 = this.h;
      paramCanvas.drawRoundRect(f1, f2, f3 - f4, f5, f6, f6, this.d);
    }
  }
  
  private final void b(Canvas paramCanvas)
  {
    if (this.e)
    {
      this.d.setColor(getBottomLineColor());
      paramCanvas.drawLine(0.0F, getHeight() - this.d.getStrokeWidth(), getWidth(), getHeight(), this.d);
    }
  }
  
  private final int getBottomLineColor()
  {
    return this.f;
  }
  
  private final int getTrackColor()
  {
    return this.g;
  }
  
  public final boolean a()
  {
    return this.e;
  }
  
  @RequiresApi(21)
  protected void onDraw(@NotNull Canvas paramCanvas)
  {
    Intrinsics.checkParameterIsNotNull(paramCanvas, "canvas");
    super.onDraw(paramCanvas);
    a(paramCanvas);
    b(paramCanvas);
  }
  
  public final void setBottomLineColor(int paramInt)
  {
    this.f = paramInt;
  }
  
  public final void setDrawBottomLine(boolean paramBoolean)
  {
    this.e = paramBoolean;
    invalidate();
  }
  
  public final void setNeedDrawTrackBackground(boolean paramBoolean)
  {
    this.c = paramBoolean;
    invalidate();
  }
  
  public final void setTrackColor(int paramInt)
  {
    this.g = paramInt;
  }
  
  public final void setTrackList(@NotNull ArrayList<TrackModel> paramArrayList)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayList, "trackModels");
    this.b = paramArrayList;
  }
  
  public final void setTrackRadius(float paramFloat)
  {
    this.h = paramFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.clipping.timeline.widget.dragdrop.BottomLineRelativeLayout
 * JD-Core Version:    0.7.0.1
 */