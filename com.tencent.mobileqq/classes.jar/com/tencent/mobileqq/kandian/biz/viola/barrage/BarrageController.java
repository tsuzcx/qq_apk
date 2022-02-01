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
  public static final BarrageController.Companion a;
  @NotNull
  private static final Integer[] jdField_a_of_type_ArrayOfJavaLangInteger = { Integer.valueOf(28), Integer.valueOf(140), Integer.valueOf(300) };
  private final Context jdField_a_of_type_AndroidContentContext;
  private final Handler jdField_a_of_type_AndroidOsHandler;
  private final ArrayMap<String, BarrageHandler.SessionParams> jdField_a_of_type_AndroidSupportV4UtilArrayMap;
  @Nullable
  private BarrageCallback jdField_a_of_type_ComTencentMobileqqKandianBizViolaBarrageBarrageCallback;
  @NotNull
  private final BarrageConfig jdField_a_of_type_ComTencentMobileqqKandianBizViolaBarrageBarrageConfig;
  private final BarrageController.BarrageBusinessObserver jdField_a_of_type_ComTencentMobileqqKandianBizViolaBarrageBarrageController$BarrageBusinessObserver;
  private final BarrageHandler jdField_a_of_type_ComTencentMobileqqKandianBizViolaBarrageBarrageHandler;
  private BarrageState jdField_a_of_type_ComTencentMobileqqKandianBizViolaBarrageBarrageState;
  private final BarrageTrack jdField_a_of_type_ComTencentMobileqqKandianBizViolaBarrageBarrageTrack;
  @NotNull
  private final BarrageView jdField_a_of_type_ComTencentMobileqqKandianBizViolaBarrageBarrageView;
  @NotNull
  private final String jdField_a_of_type_JavaLangString;
  private final ArrayList<BarrageInfo> jdField_a_of_type_JavaUtilArrayList;
  private boolean jdField_a_of_type_Boolean;
  private final ArrayList<BarrageController.AnimatorState> b;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqKandianBizViolaBarrageBarrageController$Companion = new BarrageController.Companion(null);
  }
  
  public BarrageController(@NotNull BarrageView paramBarrageView, @NotNull BarrageConfig paramBarrageConfig, @NotNull String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizViolaBarrageBarrageView = paramBarrageView;
    this.jdField_a_of_type_ComTencentMobileqqKandianBizViolaBarrageBarrageConfig = paramBarrageConfig;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_AndroidContentContext = this.jdField_a_of_type_ComTencentMobileqqKandianBizViolaBarrageBarrageView.getContext();
    this.jdField_a_of_type_ComTencentMobileqqKandianBizViolaBarrageBarrageState = BarrageState.IDLE;
    this.jdField_a_of_type_ComTencentMobileqqKandianBizViolaBarrageBarrageTrack = new BarrageTrack();
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_AndroidSupportV4UtilArrayMap = new ArrayMap();
    this.b = new ArrayList();
    this.jdField_a_of_type_AndroidOsHandler = new Handler((Handler.Callback)BarrageController.handler.1.a);
    paramBarrageView = RIJQQAppInterfaceUtil.a();
    paramBarrageConfig = paramBarrageView.getBusinessHandler(this.jdField_a_of_type_JavaLangString);
    if (paramBarrageConfig != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizViolaBarrageBarrageHandler = ((BarrageHandler)paramBarrageConfig);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizViolaBarrageBarrageController$BarrageBusinessObserver = new BarrageController.BarrageBusinessObserver(this);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizViolaBarrageBarrageTrack.a((BarrageTrack.BarrageLineCallback)this);
      if (paramBarrageView != null) {
        paramBarrageView.addObserver((BusinessObserver)this.jdField_a_of_type_ComTencentMobileqqKandianBizViolaBarrageBarrageController$BarrageBusinessObserver);
      }
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.kandian.biz.viola.barrage.BarrageHandler");
  }
  
  private final void a(View paramView, BarrageTrack.BarrageLine paramBarrageLine)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizViolaBarrageBarrageView.addView(paramView);
    paramView.setX(this.jdField_a_of_type_ComTencentMobileqqKandianBizViolaBarrageBarrageView.getWidth());
    paramView.setY(paramBarrageLine.b());
  }
  
  private final void a(BarrageController.AnimatorState paramAnimatorState)
  {
    if (Build.VERSION.SDK_INT >= 19)
    {
      paramAnimatorState.a().pause();
      return;
    }
    paramAnimatorState.a(paramAnimatorState.a().getCurrentPlayTime());
    paramAnimatorState.a().cancel();
  }
  
  private final void a(BarrageItemView paramBarrageItemView, int paramInt)
  {
    if ((paramInt > paramBarrageItemView.a()) && (paramBarrageItemView.a()))
    {
      paramBarrageItemView.setBusyInLineEntry(false);
      Iterator localIterator = paramBarrageItemView.a().iterator();
      while (localIterator.hasNext()) {
        ((BarrageTrack.BarrageLine)localIterator.next()).a(true);
      }
      this.jdField_a_of_type_ComTencentMobileqqKandianBizViolaBarrageBarrageTrack.b();
    }
    if ((paramBarrageItemView.a() == BarrageItemView.AppearState.NONE) && (paramInt > -paramBarrageItemView.getWidth()))
    {
      paramBarrageItemView.setAppearState(BarrageItemView.AppearState.PART);
      return;
    }
    if ((paramBarrageItemView.a() == BarrageItemView.AppearState.PART) && (paramInt > 0))
    {
      paramBarrageItemView.setAppearState(BarrageItemView.AppearState.ALL);
      paramBarrageItemView = this.jdField_a_of_type_ComTencentMobileqqKandianBizViolaBarrageBarrageCallback;
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
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqKandianBizViolaBarrageBarrageState);
      localStringBuilder.append(" state:");
      localStringBuilder.append(paramBarrageState);
      QLog.d("BarrageController", 2, localStringBuilder.toString());
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBizViolaBarrageBarrageState = paramBarrageState;
  }
  
  private final void b(BarrageController.AnimatorState paramAnimatorState)
  {
    if (Build.VERSION.SDK_INT >= 19)
    {
      if (paramAnimatorState.a().isStarted())
      {
        paramAnimatorState.a().resume();
        return;
      }
      paramAnimatorState.a().start();
      return;
    }
    paramAnimatorState.a().start();
    paramAnimatorState.a().setCurrentPlayTime(paramAnimatorState.a());
  }
  
  private final void e()
  {
    Iterator localIterator = this.b.iterator();
    Intrinsics.checkExpressionValueIsNotNull(localIterator, "animatorList.iterator()");
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      Intrinsics.checkExpressionValueIsNotNull(localObject, "animatorListIterator.next()");
      b((BarrageController.AnimatorState)localObject);
    }
  }
  
  private final void f()
  {
    Iterator localIterator = this.b.iterator();
    Intrinsics.checkExpressionValueIsNotNull(localIterator, "animatorList.iterator()");
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      Intrinsics.checkExpressionValueIsNotNull(localObject, "animatorListIterator.next()");
      a((BarrageController.AnimatorState)localObject);
    }
  }
  
  private final void g()
  {
    Iterator localIterator = this.b.iterator();
    Intrinsics.checkExpressionValueIsNotNull(localIterator, "animatorList.iterator()");
    while (localIterator.hasNext()) {
      ((BarrageController.AnimatorState)localIterator.next()).a().cancel();
    }
  }
  
  @Nullable
  public final BarrageCallback a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianBizViolaBarrageBarrageCallback;
  }
  
  @NotNull
  public final BarrageView a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianBizViolaBarrageBarrageView;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList.isEmpty())
    {
      this.jdField_a_of_type_Boolean = true;
      QLog.w("BarrageController", 2, "Barrage play failed for barrageData is empty.");
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizViolaBarrageBarrageState == BarrageState.PLAYING)
    {
      QLog.w("BarrageController", 2, "Barrage play failed for status is PLAYING.");
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizViolaBarrageBarrageState == BarrageState.PAUSE)
    {
      a(BarrageState.PLAYING);
      e();
      return;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqKandianBizViolaBarrageBarrageState != BarrageState.IDLE) && (this.jdField_a_of_type_ComTencentMobileqqKandianBizViolaBarrageBarrageState != BarrageState.STOPED))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("play ignore for state:");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqKandianBizViolaBarrageBarrageState);
      QLog.w("BarrageController", 2, localStringBuilder.toString());
      return;
    }
    a(BarrageState.PLAYING);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizViolaBarrageBarrageTrack.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizViolaBarrageBarrageConfig, (List)this.jdField_a_of_type_JavaUtilArrayList);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizViolaBarrageBarrageTrack.a();
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
    this.jdField_a_of_type_ComTencentMobileqqKandianBizViolaBarrageBarrageHandler.a(paramLong, paramString1, paramString2, (BarrageHandler.SessionParams)this.jdField_a_of_type_AndroidSupportV4UtilArrayMap.get(paramString1));
  }
  
  public final void a(@Nullable BarrageCallback paramBarrageCallback)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizViolaBarrageBarrageCallback = paramBarrageCallback;
  }
  
  public void a(@NotNull BarrageInfo paramBarrageInfo, @NotNull List<BarrageTrack.BarrageLine> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramBarrageInfo, "barrageInfo");
    Intrinsics.checkParameterIsNotNull(paramList, "barrageLines");
    Object localObject = BarrageFactory.a;
    Context localContext = this.jdField_a_of_type_AndroidContentContext;
    Intrinsics.checkExpressionValueIsNotNull(localContext, "context");
    localObject = ((BarrageFactory)localObject).a(localContext, paramBarrageInfo);
    ((BarrageItemView)localObject).setBusyInLineEntry(true);
    ((BarrageItemView)localObject).setPlaceLines(paramList);
    ((BarrageItemView)localObject).setOnClickListener((View.OnClickListener)new BarrageController.onBarragePlaceInLine.1(this, paramBarrageInfo));
    a((View)localObject, (BarrageTrack.BarrageLine)paramList.get(0));
    ((BarrageItemView)localObject).a(paramBarrageInfo, this.jdField_a_of_type_ComTencentMobileqqKandianBizViolaBarrageBarrageConfig);
    this.jdField_a_of_type_AndroidOsHandler.post((Runnable)new BarrageController.onBarragePlaceInLine.2(this, (BarrageItemView)localObject));
  }
  
  public final void a(@NotNull BarrageItemView paramBarrageItemView)
  {
    Intrinsics.checkParameterIsNotNull(paramBarrageItemView, "barrageItemView");
    float f = paramBarrageItemView.getX();
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { f, -paramBarrageItemView.getWidth() });
    Intrinsics.checkExpressionValueIsNotNull(localValueAnimator, "ValueAnimator.ofFloat(st…ItemView.width.toFloat())");
    localValueAnimator.setInterpolator((TimeInterpolator)new LinearInterpolator());
    localValueAnimator.setDuration((this.jdField_a_of_type_ComTencentMobileqqKandianBizViolaBarrageBarrageConfig.a() * 1000 * (paramBarrageItemView.getWidth() + f) / f));
    localValueAnimator.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new BarrageController.startBarrageItemAnimation.1(this, paramBarrageItemView, f));
    localValueAnimator.addListener((Animator.AnimatorListener)new BarrageController.startBarrageItemAnimation.2(this, paramBarrageItemView, localValueAnimator));
    this.b.add(new BarrageController.AnimatorState(this, localValueAnimator));
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizViolaBarrageBarrageState == BarrageState.PLAYING) {
      localValueAnimator.start();
    }
  }
  
  public final boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizViolaBarrageBarrageState != BarrageState.PLAYING) {
      return;
    }
    a(BarrageState.PAUSE);
    f();
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizViolaBarrageBarrageState == BarrageState.STOPED) {
      return;
    }
    a(BarrageState.STOPED);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizViolaBarrageBarrageView.removeAllViews();
    g();
    this.b.clear();
  }
  
  public final void d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizViolaBarrageBarrageState == BarrageState.IDLE) {
      return;
    }
    a(BarrageState.IDLE);
    QQAppInterface localQQAppInterface = RIJQQAppInterfaceUtil.a();
    if (localQQAppInterface != null) {
      localQQAppInterface.removeObserver((BusinessObserver)this.jdField_a_of_type_ComTencentMobileqqKandianBizViolaBarrageBarrageController$BarrageBusinessObserver);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.viola.barrage.BarrageController
 * JD-Core Version:    0.7.0.1
 */