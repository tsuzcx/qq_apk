package com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.scale;

import androidx.annotation.VisibleForTesting;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.scale.size.DefaultSizeParamListDataProvider;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.scale.size.SizeParam;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/panel/scale/ScaleCalculator;", "", "()V", "currSizeParam", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/panel/scale/size/SizeParam;", "currentScrollX", "", "getCurrentScrollX", "()F", "endTimeUs", "", "maxSpace", "minSpace", "perSpace", "getPerSpace", "setPerSpace", "(F)V", "scaleList", "", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/panel/scale/ScalePoint;", "getScaleList", "()Ljava/util/List;", "scaleView", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/panel/scale/ScaleCalculator$IScaleView;", "sizeParamArrayList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "startTimeUs", "bindScaleView", "", "calcSizeChange", "Lkotlin/Pair;", "", "scaleFactor", "calcSizeParamRatio", "oldSize", "newSize", "getCurrentMaxSpace", "getCurrentTimeUs", "getEndTime", "getTimeByScalePoint", "scalePoint", "getTimeDecByScalePoint", "", "handleZoomIn", "space", "index", "handleZoomOut", "onSizeChange", "nextIndex", "setCurrSizeParamIndex", "setData", "dataProvider", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/panel/scale/ScaleCalculator$IDataProvider;", "setEndTime", "timeUs", "setMaxSpace", "setMinSpace", "setSizeParam", "sizeParam", "setUpScaleList", "translatePxToTimeInner", "px", "translatePxToTimeUs", "translateTimeToPx", "translateTimeToPxInner", "Companion", "IDataProvider", "IScaleView", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class ScaleCalculator
{
  public static final ScaleCalculator.Companion a = new ScaleCalculator.Companion(null);
  @NotNull
  private final List<ScalePoint> b = (List)new ArrayList();
  private final ArrayList<SizeParam> c = new ArrayList();
  private long d;
  private long e;
  private SizeParam f;
  private float g = 93.0F;
  private float h = 93.0F;
  private float i = 72.0F;
  private ScaleCalculator.IScaleView j;
  
  public ScaleCalculator()
  {
    a((ScaleCalculator.IDataProvider)new DefaultSizeParamListDataProvider());
  }
  
  private final float a(SizeParam paramSizeParam, float paramFloat)
  {
    return this.g * paramSizeParam.a(paramFloat);
  }
  
  private final float a(SizeParam paramSizeParam1, SizeParam paramSizeParam2)
  {
    return paramSizeParam1.a(1000000.0F) / paramSizeParam2.a(1000000.0F);
  }
  
  private final Pair<Integer, Integer> a(float paramFloat, int paramInt)
  {
    if (paramFloat <= this.i)
    {
      if (paramInt == CollectionsKt.getLastIndex((List)this.c)) {
        return TuplesKt.to(Integer.valueOf(1), Integer.valueOf(paramInt));
      }
      return TuplesKt.to(Integer.valueOf(0), Integer.valueOf(paramInt + 1));
    }
    return TuplesKt.to(Integer.valueOf(2), Integer.valueOf(paramInt));
  }
  
  private final void a(SizeParam paramSizeParam)
  {
    this.f = paramSizeParam;
    g();
  }
  
  private final Pair<Integer, Integer> b(float paramFloat, int paramInt)
  {
    if (paramFloat >= this.h)
    {
      if (paramInt == 0) {
        return TuplesKt.to(Integer.valueOf(1), Integer.valueOf(paramInt));
      }
      return TuplesKt.to(Integer.valueOf(0), Integer.valueOf(paramInt - 1));
    }
    return TuplesKt.to(Integer.valueOf(2), Integer.valueOf(paramInt));
  }
  
  private final void c(float paramFloat, int paramInt)
  {
    Object localObject = this.c.get(paramInt);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "sizeParamArrayList[nextIndex]");
    localObject = (SizeParam)localObject;
    SizeParam localSizeParam = this.f;
    float f1;
    if (localSizeParam != null) {
      f1 = a(localSizeParam, (SizeParam)localObject);
    } else {
      f1 = 1.0F;
    }
    if (paramFloat > 1) {
      paramFloat = this.h;
    } else {
      paramFloat = this.i;
    }
    this.g = (paramFloat * f1);
    a((SizeParam)localObject);
  }
  
  private final float f()
  {
    ScaleCalculator.IScaleView localIScaleView = this.j;
    if (localIScaleView != null) {
      return localIScaleView.b();
    }
    return 0.0F;
  }
  
  private final float f(float paramFloat)
  {
    SizeParam localSizeParam = this.f;
    if (localSizeParam != null) {
      return (float)this.d + localSizeParam.a(paramFloat, this.g);
    }
    return (float)this.d;
  }
  
  private final float g(float paramFloat)
  {
    SizeParam localSizeParam = this.f;
    if (localSizeParam != null) {
      return a(localSizeParam, paramFloat);
    }
    return 0.0F;
  }
  
  private final void g()
  {
    Object localObject = this.f;
    if (localObject != null)
    {
      this.b.clear();
      int n = (int)((SizeParam)localObject).a((float)(this.e - this.d));
      int k = 0;
      while (k < n + 1)
      {
        int m;
        if (k % 2 == 0) {
          m = 0;
        } else {
          m = 1;
        }
        localObject = new ScalePoint(k, m);
        this.b.add(localObject);
        k += 1;
      }
    }
  }
  
  public final long a(float paramFloat)
  {
    return f(paramFloat);
  }
  
  @NotNull
  public final String a(@NotNull ScalePoint paramScalePoint)
  {
    Intrinsics.checkParameterIsNotNull(paramScalePoint, "scalePoint");
    SizeParam localSizeParam = this.f;
    if (localSizeParam != null) {
      return localSizeParam.a(b(paramScalePoint));
    }
    return "";
  }
  
  @NotNull
  public final List<ScalePoint> a()
  {
    return this.b;
  }
  
  public final void a(int paramInt)
  {
    Object localObject = (List)this.c;
    if ((paramInt >= 0) && (paramInt <= CollectionsKt.getLastIndex((List)localObject)))
    {
      localObject = ((List)localObject).get(paramInt);
    }
    else
    {
      localObject = this.c.get(0);
      Intrinsics.checkExpressionValueIsNotNull(localObject, "sizeParamArrayList[0]");
      localObject = (SizeParam)localObject;
    }
    this.f = ((SizeParam)localObject);
  }
  
  public final void a(long paramLong)
  {
    this.e = paramLong;
    g();
  }
  
  public final void a(@NotNull ScaleCalculator.IDataProvider paramIDataProvider)
  {
    Intrinsics.checkParameterIsNotNull(paramIDataProvider, "dataProvider");
    Object localObject = (Collection)paramIDataProvider.a();
    if ((localObject != null) && (!((Collection)localObject).isEmpty())) {
      k = 0;
    } else {
      k = 1;
    }
    if (k != 0) {
      return;
    }
    localObject = this.c;
    ((ArrayList)localObject).clear();
    ((ArrayList)localObject).addAll((Collection)paramIDataProvider.a());
    int k = paramIDataProvider.b();
    paramIDataProvider = (List)localObject;
    if ((k >= 0) && (k <= CollectionsKt.getLastIndex(paramIDataProvider)))
    {
      paramIDataProvider = paramIDataProvider.get(k);
    }
    else
    {
      paramIDataProvider = ((ArrayList)localObject).get(0);
      Intrinsics.checkExpressionValueIsNotNull(paramIDataProvider, "this[0]");
      paramIDataProvider = (SizeParam)paramIDataProvider;
    }
    this.f = ((SizeParam)paramIDataProvider);
  }
  
  public final void a(@NotNull ScaleCalculator.IScaleView paramIScaleView)
  {
    Intrinsics.checkParameterIsNotNull(paramIScaleView, "scaleView");
    this.j = paramIScaleView;
  }
  
  public final float b()
  {
    return this.g;
  }
  
  public final int b(long paramLong)
  {
    return (int)g((float)paramLong);
  }
  
  public final long b(@NotNull ScalePoint paramScalePoint)
  {
    Intrinsics.checkParameterIsNotNull(paramScalePoint, "scalePoint");
    SizeParam localSizeParam = this.f;
    if (localSizeParam != null)
    {
      long l = this.d;
      float f1 = paramScalePoint.a();
      float f2 = this.g;
      return l + MathKt.roundToLong(localSizeParam.a(f1 * f2, f2));
    }
    return 0L;
  }
  
  @VisibleForTesting
  @NotNull
  public final Pair<Integer, Integer> b(float paramFloat)
  {
    int k = CollectionsKt.indexOf((List)this.c, this.f);
    if (paramFloat == 1.0F) {
      return TuplesKt.to(Integer.valueOf(1), Integer.valueOf(k));
    }
    float f1 = this.g * paramFloat;
    if (paramFloat > 1) {
      return b(f1, k);
    }
    return a(f1, k);
  }
  
  public final long c()
  {
    return this.e;
  }
  
  public final void c(float paramFloat)
  {
    this.h = paramFloat;
    this.g = paramFloat;
  }
  
  public final int d()
  {
    return MathKt.roundToInt(g((float)this.e));
  }
  
  public final void d(float paramFloat)
  {
    this.i = paramFloat;
  }
  
  public final long e()
  {
    return f(f());
  }
  
  public final void e(float paramFloat)
  {
    float f1 = f(f());
    Object localObject = b(paramFloat);
    int k = ((Number)((Pair)localObject).component1()).intValue();
    int m = ((Number)((Pair)localObject).component2()).intValue();
    if (k != 1)
    {
      if (k == 0) {
        c(paramFloat, m);
      } else {
        this.g *= paramFloat;
      }
      paramFloat = g(f1);
      localObject = this.j;
      if (localObject != null) {
        ((ScaleCalculator.IScaleView)localObject).a(MathKt.roundToInt(paramFloat));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.scale.ScaleCalculator
 * JD-Core Version:    0.7.0.1
 */