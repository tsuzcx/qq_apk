package com.tencent.mobileqq.kandian.biz.viola.barrage;

import android.content.Context;
import android.os.Handler;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/viola/barrage/BarrageTrack;", "", "()V", "bakBarrageData", "Ljava/util/ArrayDeque;", "Lcom/tencent/mobileqq/kandian/biz/viola/barrage/BarrageInfo;", "barrageConfig", "Lcom/tencent/mobileqq/kandian/biz/viola/barrage/BarrageConfig;", "barrageData", "barrageLineCallback", "Lcom/tencent/mobileqq/kandian/biz/viola/barrage/BarrageTrack$BarrageLineCallback;", "getBarrageLineCallback", "()Lcom/tencent/mobileqq/kandian/biz/viola/barrage/BarrageTrack$BarrageLineCallback;", "setBarrageLineCallback", "(Lcom/tencent/mobileqq/kandian/biz/viola/barrage/BarrageTrack$BarrageLineCallback;)V", "handler", "Landroid/os/Handler;", "isFirstTimePlaceBarrage", "", "lines", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/kandian/biz/viola/barrage/BarrageTrack$BarrageLine;", "Lkotlin/collections/ArrayList;", "canPlaceInThisLine", "index", "", "barrageType", "Lcom/tencent/mobileqq/kandian/biz/viola/barrage/BarrageItemView$BarrageType;", "checkPlaceLineIsValidate", "barrageLines", "", "findSuitableBarrageLines", "getIdleLineCount", "getPlaceLineCount", "handleBarrageDataForLoop", "", "init", "innerPlaceBarrageInLine", "barrageInfo", "notifyLineIdle", "placeBarrageInLine", "delay", "", "placeOneBarrageInLine", "reset", "tryPlaceBarragesInLine", "BarrageLine", "BarrageLineCallback", "Companion", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class BarrageTrack
{
  public static final BarrageTrack.Companion a = new BarrageTrack.Companion(null);
  private final Handler b = new Handler();
  private final ArrayList<BarrageTrack.BarrageLine> c = new ArrayList();
  private boolean d = true;
  private ArrayDeque<BarrageInfo> e = new ArrayDeque();
  private ArrayDeque<BarrageInfo> f = new ArrayDeque();
  private BarrageConfig g = new BarrageConfig();
  @Nullable
  private BarrageTrack.BarrageLineCallback h;
  
  private final List<BarrageTrack.BarrageLine> a(BarrageItemView.BarrageType paramBarrageType)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = this.c.iterator();
    Object localObject2;
    do
    {
      do
      {
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        localObject2 = (BarrageTrack.BarrageLine)((Iterator)localObject1).next();
      } while ((localArrayList.isEmpty()) && (!a(((BarrageTrack.BarrageLine)localObject2).b(), paramBarrageType)));
      if (((BarrageTrack.BarrageLine)localObject2).a()) {
        localArrayList.add(localObject2);
      } else {
        localArrayList.clear();
      }
    } while (localArrayList.size() != b(paramBarrageType));
    localObject1 = (List)localArrayList;
    if (!a((List)localObject1, paramBarrageType))
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("checkPlaceLineIsValidate not validate, barrageType:");
      ((StringBuilder)localObject2).append(paramBarrageType);
      QLog.w("BarrageTrack", 1, ((StringBuilder)localObject2).toString());
      localArrayList.clear();
    }
    return localObject1;
  }
  
  private final void a(BarrageInfo paramBarrageInfo, long paramLong)
  {
    if (paramBarrageInfo == null) {
      return;
    }
    this.b.postDelayed((Runnable)new BarrageTrack.placeBarrageInLine.1(this, paramBarrageInfo), paramLong);
  }
  
  private final void a(BarrageInfo paramBarrageInfo, List<BarrageTrack.BarrageLine> paramList)
  {
    if (QLog.isColorLevel())
    {
      int i = 1;
      localObject1 = new StringBuilder();
      Object localObject2 = paramList.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        BarrageTrack.BarrageLine localBarrageLine = (BarrageTrack.BarrageLine)((Iterator)localObject2).next();
        if (i == 0) {
          ((StringBuilder)localObject1).append(",");
        }
        ((StringBuilder)localObject1).append(localBarrageLine.b());
        i = 0;
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("placeOneBarrageInLine barrageInfo:");
      ((StringBuilder)localObject2).append(paramBarrageInfo.c);
      ((StringBuilder)localObject2).append("    barrageLines:");
      ((StringBuilder)localObject2).append(((StringBuilder)localObject1).toString());
      QLog.d("BarrageTrack", 2, ((StringBuilder)localObject2).toString());
    }
    Object localObject1 = paramList.iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((BarrageTrack.BarrageLine)((Iterator)localObject1).next()).a(false);
    }
    localObject1 = this.h;
    if (localObject1 != null) {
      ((BarrageTrack.BarrageLineCallback)localObject1).a(paramBarrageInfo, paramList);
    }
  }
  
  private final boolean a(int paramInt, BarrageItemView.BarrageType paramBarrageType)
  {
    return true;
  }
  
  private final boolean a(BarrageInfo paramBarrageInfo)
  {
    List localList = a(BarrageItemView.a.a(paramBarrageInfo.c));
    if (localList.isEmpty())
    {
      QLog.w("BarrageTrack", 2, "InnerPlaceBarrageInLine failed for no idle barrageLine.");
      return false;
    }
    a(paramBarrageInfo, localList);
    return true;
  }
  
  private final boolean a(List<BarrageTrack.BarrageLine> paramList, BarrageItemView.BarrageType paramBarrageType)
  {
    return b(paramBarrageType) == paramList.size();
  }
  
  private final int b(BarrageItemView.BarrageType paramBarrageType)
  {
    if (paramBarrageType == BarrageItemView.BarrageType.DOUBLE_LINE) {
      return 2;
    }
    return 1;
  }
  
  private final void c()
  {
    this.d = true;
  }
  
  private final void d()
  {
    if ((this.g.d()) && (this.e.size() < this.f.size()))
    {
      this.e.addAll((Collection)this.f.clone());
      this.b.post((Runnable)new BarrageTrack.handleBarrageDataForLoop.1(this));
    }
  }
  
  private final int e()
  {
    Iterator localIterator = this.c.iterator();
    int i = 0;
    while (localIterator.hasNext()) {
      if (((BarrageTrack.BarrageLine)localIterator.next()).a()) {
        i += 1;
      }
    }
    return i;
  }
  
  public final void a()
  {
    int j;
    if (this.d)
    {
      j = ((Collection)this.c).size();
      i = 0;
      while (i < j)
      {
        a((BarrageInfo)this.e.poll(), i * 500L);
        i += 1;
      }
    }
    int k = e();
    int i = 0;
    while (i < k)
    {
      j = i + 1;
      BarrageInfo localBarrageInfo = (BarrageInfo)this.e.peek();
      if (localBarrageInfo == null)
      {
        i = j;
      }
      else
      {
        i = j;
        if (a(localBarrageInfo))
        {
          this.e.remove(localBarrageInfo);
          i = j;
        }
      }
    }
    this.d = false;
    d();
  }
  
  public final void a(@NotNull BarrageConfig paramBarrageConfig, @NotNull List<? extends BarrageInfo> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramBarrageConfig, "barrageConfig");
    Intrinsics.checkParameterIsNotNull(paramList, "barrageData");
    this.g = paramBarrageConfig;
    c();
    this.c.clear();
    int m = BarrageItemView.a.a();
    int n = DisplayUtil.a((Context)BaseApplication.getContext(), paramBarrageConfig.b());
    int i1 = paramBarrageConfig.a();
    int i = 0;
    int k;
    for (int j = 0; i < i1; j = k)
    {
      paramBarrageConfig = new BarrageTrack.BarrageLine();
      paramBarrageConfig.a(true);
      paramBarrageConfig.a(i);
      k = j;
      if (i != 0) {
        k = j + (m + n);
      }
      paramBarrageConfig.b(k);
      this.c.add(paramBarrageConfig);
      i += 1;
    }
    this.e.clear();
    this.e.addAll((Collection)paramList);
    paramBarrageConfig = this.e.clone();
    Intrinsics.checkExpressionValueIsNotNull(paramBarrageConfig, "this.barrageData.clone()");
    this.f = paramBarrageConfig;
  }
  
  public final void a(@Nullable BarrageTrack.BarrageLineCallback paramBarrageLineCallback)
  {
    this.h = paramBarrageLineCallback;
  }
  
  public final void b()
  {
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.viola.barrage.BarrageTrack
 * JD-Core Version:    0.7.0.1
 */