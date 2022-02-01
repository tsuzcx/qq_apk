package com.tencent.mobileqq.kandian.biz.viola.barrage;

import android.animation.Animator.AnimatorListener;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Handler.Callback;
import android.support.v4.util.ArrayMap;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.LinearInterpolator;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/viola/barrage/BarrageController;", "Lcom/tencent/mobileqq/kandian/biz/viola/barrage/IBarrageControl;", "Lcom/tencent/mobileqq/kandian/biz/viola/barrage/BarrageTrack$BarrageLineCallback;", "barrageView", "Lcom/tencent/mobileqq/kandian/biz/viola/barrage/BarrageView;", "barrageConfig", "Lcom/tencent/mobileqq/kandian/biz/viola/barrage/BarrageConfig;", "businessName", "", "(Lcom/tencent/mobileqq/kandian/biz/viola/barrage/BarrageView;Lcom/tencent/mobileqq/kandian/biz/viola/barrage/BarrageConfig;Ljava/lang/String;)V", "animatorList", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/kandian/biz/viola/barrage/BarrageController$AnimatorState;", "Lkotlin/collections/ArrayList;", "barrageCallback", "Lcom/tencent/mobileqq/kandian/biz/viola/barrage/BarrageCallback;", "getBarrageCallback", "()Lcom/tencent/mobileqq/kandian/biz/viola/barrage/BarrageCallback;", "setBarrageCallback", "(Lcom/tencent/mobileqq/kandian/biz/viola/barrage/BarrageCallback;)V", "getBarrageConfig", "()Lcom/tencent/mobileqq/kandian/biz/viola/barrage/BarrageConfig;", "barrageData", "Lcom/tencent/mobileqq/kandian/biz/viola/barrage/BarrageInfo;", "barrageHandler", "Lcom/tencent/mobileqq/kandian/biz/viola/barrage/BarrageHandler;", "barrageObserver", "Lcom/tencent/mobileqq/kandian/biz/viola/barrage/BarrageController$BarrageBusinessObserver;", "barrageState", "Lcom/tencent/mobileqq/kandian/biz/viola/barrage/BarrageState;", "barrageTrack", "Lcom/tencent/mobileqq/kandian/biz/viola/barrage/BarrageTrack;", "getBarrageView", "()Lcom/tencent/mobileqq/kandian/biz/viola/barrage/BarrageView;", "getBusinessName", "()Ljava/lang/String;", "context", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "handler", "Landroid/os/Handler;", "playCalledButDataEmpty", "", "getPlayCalledButDataEmpty", "()Z", "setPlayCalledButDataEmpty", "(Z)V", "sessionParamsMap", "Landroid/support/v4/util/ArrayMap;", "Lcom/tencent/mobileqq/kandian/biz/viola/barrage/BarrageHandler$SessionParams;", "changeState", "", "state", "fetchBarrageList", "articleId", "", "rowKey", "puin", "layoutBarrageItemView", "barrageItemView", "Landroid/view/View;", "barrageLine", "Lcom/tencent/mobileqq/kandian/biz/viola/barrage/BarrageTrack$BarrageLine;", "notifyBarrageItemRightDistance", "Lcom/tencent/mobileqq/kandian/biz/viola/barrage/BarrageItemView;", "distance", "", "onBarragePlaceInLine", "barrageInfo", "barrageLines", "", "pause", "pauseAllAnimators", "pauseAnimator", "animatorState", "play", "release", "resumeAllAnimators", "resumeAnimator", "startBarrageItemAnimation", "stop", "stopAllAnimators", "AnimatorState", "BarrageBusinessObserver", "Companion", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class BarrageController
  implements BarrageTrack.BarrageLineCallback, IBarrageControl
{
  public static final BarrageController.Companion a = new BarrageController.Companion(null);
  @NotNull
  private static final Integer[] p = { Integer.valueOf(28), Integer.valueOf(140), Integer.valueOf(300) };
  private final Context b;
  private BarrageState c;
  private final BarrageTrack d;
  private final ArrayList<BarrageInfo> e;
  private final ArrayMap<String, BarrageHandler.SessionParams> f;
  private final BarrageHandler g;
  private final BarrageController.BarrageBusinessObserver h;
  private final ArrayList<BarrageController.AnimatorState> i;
  private boolean j;
  @Nullable
  private BarrageCallback k;
  private final Handler l;
  @NotNull
  private final BarrageView m;
  @NotNull
  private final BarrageConfig n;
  @NotNull
  private final String o;
  
  public BarrageController(@NotNull BarrageView paramBarrageView, @NotNull BarrageConfig paramBarrageConfig, @NotNull String paramString)
  {
    this.m = paramBarrageView;
    this.n = paramBarrageConfig;
    this.o = paramString;
    this.b = this.m.getContext();
    this.c = BarrageState.IDLE;
    this.d = new BarrageTrack();
    this.e = new ArrayList();
    this.f = new ArrayMap();
    this.i = new ArrayList();
    this.l = new Handler((Handler.Callback)BarrageController.handler.1.a);
    paramBarrageView = RIJQQAppInterfaceUtil.a();
    paramBarrageConfig = paramBarrageView.getBusinessHandler(this.o);
    if (paramBarrageConfig != null)
    {
      this.g = ((BarrageHandler)paramBarrageConfig);
      this.h = new BarrageController.BarrageBusinessObserver(this);
      this.d.a((BarrageTrack.BarrageLineCallback)this);
      if (paramBarrageView != null) {
        paramBarrageView.addObserver((BusinessObserver)this.h);
      }
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.kandian.biz.viola.barrage.BarrageHandler");
  }
  
  private final void a(View paramView, BarrageTrack.BarrageLine paramBarrageLine)
  {
    this.m.addView(paramView);
    paramView.setX(this.m.getWidth());
    paramView.setY(paramBarrageLine.c());
  }
  
  private final void a(BarrageController.AnimatorState paramAnimatorState)
  {
    if (Build.VERSION.SDK_INT >= 19)
    {
      paramAnimatorState.b().pause();
      return;
    }
    paramAnimatorState.a(paramAnimatorState.b().getCurrentPlayTime());
    paramAnimatorState.b().cancel();
  }
  
  private final void a(BarrageItemView paramBarrageItemView, int paramInt)
  {
    if ((paramInt > paramBarrageItemView.getBlockDistance()) && (paramBarrageItemView.getBusyInLineEntry()))
    {
      paramBarrageItemView.setBusyInLineEntry(false);
      Iterator localIterator = paramBarrageItemView.getPlaceLines().iterator();
      while (localIterator.hasNext()) {
        ((BarrageTrack.BarrageLine)localIterator.next()).a(true);
      }
      this.d.b();
    }
    if ((paramBarrageItemView.getAppearState() == BarrageItemView.AppearState.NONE) && (paramInt > -paramBarrageItemView.getWidth()))
    {
      paramBarrageItemView.setAppearState(BarrageItemView.AppearState.PART);
      return;
    }
    if ((paramBarrageItemView.getAppearState() == BarrageItemView.AppearState.PART) && (paramInt > 0))
    {
      paramBarrageItemView.setAppearState(BarrageItemView.AppearState.ALL);
      paramBarrageItemView = this.k;
      if (paramBarrageItemView != null) {
        paramBarrageItemView.onEventBarrageDidAppear();
      }
    }
  }
  
  private final void a(BarrageState paramBarrageState)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("changeState oldState:");
      localStringBuilder.append(this.c);
      localStringBuilder.append(" state:");
      localStringBuilder.append(paramBarrageState);
      QLog.d("BarrageController", 2, localStringBuilder.toString());
    }
    this.c = paramBarrageState;
  }
  
  private final void b(BarrageController.AnimatorState paramAnimatorState)
  {
    if (Build.VERSION.SDK_INT >= 19)
    {
      if (paramAnimatorState.b().isStarted())
      {
        paramAnimatorState.b().resume();
        return;
      }
      paramAnimatorState.b().start();
      return;
    }
    paramAnimatorState.b().start();
    paramAnimatorState.b().setCurrentPlayTime(paramAnimatorState.a());
  }
  
  private final void i()
  {
    Iterator localIterator = this.i.iterator();
    Intrinsics.checkExpressionValueIsNotNull(localIterator, "animatorList.iterator()");
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      Intrinsics.checkExpressionValueIsNotNull(localObject, "animatorListIterator.next()");
      b((BarrageController.AnimatorState)localObject);
    }
  }
  
  private final void j()
  {
    Iterator localIterator = this.i.iterator();
    Intrinsics.checkExpressionValueIsNotNull(localIterator, "animatorList.iterator()");
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      Intrinsics.checkExpressionValueIsNotNull(localObject, "animatorListIterator.next()");
      a((BarrageController.AnimatorState)localObject);
    }
  }
  
  private final void k()
  {
    Iterator localIterator = this.i.iterator();
    Intrinsics.checkExpressionValueIsNotNull(localIterator, "animatorList.iterator()");
    while (localIterator.hasNext()) {
      ((BarrageController.AnimatorState)localIterator.next()).b().cancel();
    }
  }
  
  public void a(long paramLong, @NotNull String paramString1, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "rowKey");
    Intrinsics.checkParameterIsNotNull(paramString2, "puin");
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("fetchBarrageList articleId:");
      localStringBuilder.append(paramLong);
      localStringBuilder.append(" rowKey:");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(" puin:");
      localStringBuilder.append(paramString2);
      QLog.d("BarrageController", 2, localStringBuilder.toString());
    }
    this.g.a(paramLong, paramString1, paramString2, (BarrageHandler.SessionParams)this.f.get(paramString1));
  }
  
  public final void a(@Nullable BarrageCallback paramBarrageCallback)
  {
    this.k = paramBarrageCallback;
  }
  
  public void a(@NotNull BarrageInfo paramBarrageInfo, @NotNull List<BarrageTrack.BarrageLine> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramBarrageInfo, "barrageInfo");
    Intrinsics.checkParameterIsNotNull(paramList, "barrageLines");
    Object localObject = BarrageFactory.a;
    Context localContext = this.b;
    Intrinsics.checkExpressionValueIsNotNull(localContext, "context");
    localObject = ((BarrageFactory)localObject).a(localContext, paramBarrageInfo);
    ((BarrageItemView)localObject).setBusyInLineEntry(true);
    ((BarrageItemView)localObject).setPlaceLines(paramList);
    ((BarrageItemView)localObject).setOnClickListener((View.OnClickListener)new BarrageController.onBarragePlaceInLine.1(this, paramBarrageInfo));
    a((View)localObject, (BarrageTrack.BarrageLine)paramList.get(0));
    ((BarrageItemView)localObject).a(paramBarrageInfo, this.n);
    this.l.post((Runnable)new BarrageController.onBarragePlaceInLine.2(this, (BarrageItemView)localObject));
  }
  
  public final void a(@NotNull BarrageItemView paramBarrageItemView)
  {
    Intrinsics.checkParameterIsNotNull(paramBarrageItemView, "barrageItemView");
    float f1 = paramBarrageItemView.getX();
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { f1, -paramBarrageItemView.getWidth() });
    Intrinsics.checkExpressionValueIsNotNull(localValueAnimator, "ValueAnimator.ofFloat(st…ItemView.width.toFloat())");
    localValueAnimator.setInterpolator((TimeInterpolator)new LinearInterpolator());
    localValueAnimator.setDuration((this.n.c() * 1000 * (paramBarrageItemView.getWidth() + f1) / f1));
    localValueAnimator.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new BarrageController.startBarrageItemAnimation.1(this, paramBarrageItemView, f1));
    localValueAnimator.addListener((Animator.AnimatorListener)new BarrageController.startBarrageItemAnimation.2(this, paramBarrageItemView, localValueAnimator));
    this.i.add(new BarrageController.AnimatorState(this, localValueAnimator));
    if (this.c == BarrageState.PLAYING) {
      localValueAnimator.start();
    }
  }
  
  public final boolean a()
  {
    return this.j;
  }
  
  @Nullable
  public final BarrageCallback b()
  {
    return this.k;
  }
  
  public void c()
  {
    if (this.e.isEmpty())
    {
      this.j = true;
      QLog.w("BarrageController", 2, "Barrage play failed for barrageData is empty.");
      return;
    }
    if (this.c == BarrageState.PLAYING)
    {
      QLog.w("BarrageController", 2, "Barrage play failed for status is PLAYING.");
      return;
    }
    if (this.c == BarrageState.PAUSE)
    {
      a(BarrageState.PLAYING);
      i();
      return;
    }
    if ((this.c != BarrageState.IDLE) && (this.c != BarrageState.STOPED))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("play ignore for state:");
      localStringBuilder.append(this.c);
      QLog.w("BarrageController", 2, localStringBuilder.toString());
      return;
    }
    a(BarrageState.PLAYING);
    this.d.a(this.n, (List)this.e);
    this.d.a();
  }
  
  public void d()
  {
    if (this.c != BarrageState.PLAYING) {
      return;
    }
    a(BarrageState.PAUSE);
    j();
  }
  
  public void e()
  {
    if (this.c == BarrageState.STOPED) {
      return;
    }
    a(BarrageState.STOPED);
    this.m.removeAllViews();
    k();
    this.i.clear();
  }
  
  public final void f()
  {
    if (this.c == BarrageState.IDLE) {
      return;
    }
    a(BarrageState.IDLE);
    QQAppInterface localQQAppInterface = RIJQQAppInterfaceUtil.a();
    if (localQQAppInterface != null) {
      localQQAppInterface.removeObserver((BusinessObserver)this.h);
    }
  }
  
  @NotNull
  public final BarrageView g()
  {
    return this.m;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.viola.barrage.BarrageController
 * JD-Core Version:    0.7.0.1
 */