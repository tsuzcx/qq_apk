package com.tencent.tkd.topicsdk.mediaselector;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build.VERSION;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.RotateAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.tkd.R.drawable;
import com.tencent.tkd.R.id;
import com.tencent.tkd.R.layout;
import com.tencent.tkd.comment.panel.base.listener.OnEmotionItemClickListener;
import com.tencent.tkd.comment.panel.emoji.EmoJiEmotionPanel;
import com.tencent.tkd.comment.panel.model.Emotion;
import com.tencent.tkd.topicsdk.bean.Media;
import com.tencent.tkd.topicsdk.common.DisplayUtils;
import com.tencent.tkd.topicsdk.common.PermissionUtils;
import com.tencent.tkd.topicsdk.common.ViewExtensionsKt;
import com.tencent.tkd.topicsdk.widget.RoundBackgroundRelativeLayout;
import com.tencent.tkd.topicsdk.widget.RoundBackgroundTextView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/mediaselector/BottomSelectorLayout;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "countView", "Landroid/widget/TextView;", "currentPanelInitY", "", "getCurrentPanelInitY", "()I", "value", "defaultPanelIndex", "getDefaultPanelIndex", "setDefaultPanelIndex", "(I)V", "extendState", "getExtendState", "setExtendState", "initY", "getInitY", "setInitY", "lastTouchY", "", "maxVideoLength", "getMaxVideoLength", "setMaxVideoLength", "minVideoLength", "getMinVideoLength", "setMinVideoLength", "needIntercept", "", "onAtButtonClickListener", "Lkotlin/Function0;", "", "getOnAtButtonClickListener", "()Lkotlin/jvm/functions/Function0;", "setOnAtButtonClickListener", "(Lkotlin/jvm/functions/Function0;)V", "onEmoJiItemClickListener", "Lkotlin/Function1;", "Lcom/tencent/tkd/comment/panel/model/Emotion;", "Lkotlin/ParameterName;", "name", "emotion", "getOnEmoJiItemClickListener", "()Lkotlin/jvm/functions/Function1;", "setOnEmoJiItemClickListener", "(Lkotlin/jvm/functions/Function1;)V", "onExtendStateChangeListener", "getOnExtendStateChangeListener", "setOnExtendStateChangeListener", "onMediaLoadedListener", "Lcom/tencent/tkd/topicsdk/mediaselector/PanelType;", "getOnMediaLoadedListener", "setOnMediaLoadedListener", "onMediaSelectChangeListener", "", "Lcom/tencent/tkd/topicsdk/bean/Media;", "selectedMedias", "getOnMediaSelectChangeListener", "setOnMediaSelectChangeListener", "onTopicButtonClickListener", "getOnTopicButtonClickListener", "setOnTopicButtonClickListener", "onTranslateListener", "translateY", "getOnTranslateListener", "setOnTranslateListener", "panelController", "Lcom/tencent/tkd/topicsdk/mediaselector/PanelController;", "parentHeight", "getParentHeight", "picPanelEnable", "getPicPanelEnable", "()Z", "setPicPanelEnable", "(Z)V", "recentMediaSlidingLayout", "Lcom/tencent/tkd/topicsdk/mediaselector/RecentMediaListView;", "getRecentMediaSlidingLayout", "()Lcom/tencent/tkd/topicsdk/mediaselector/RecentMediaListView;", "setRecentMediaSlidingLayout", "(Lcom/tencent/tkd/topicsdk/mediaselector/RecentMediaListView;)V", "selectorBarHeight", "getSelectorBarHeight", "slideDirection", "startTouchY", "velocityTracker", "Landroid/view/VelocityTracker;", "kotlin.jvm.PlatformType", "videoPanelEnable", "getVideoPanelEnable", "setVideoPanelEnable", "addAtButton", "addCountChangeTextView", "countLimit", "addEmotionPanel", "addIconViewToSelectorBar", "Landroid/widget/ImageView;", "resId", "addMediaPanel", "panelType", "maxSelectCount", "maxMediaSize", "", "addPhotoPanel", "addTopicButton", "addVideoPanel", "dispatchTouchEvent", "event", "Landroid/view/MotionEvent;", "getCurrentPanelType", "getPanelInitY", "getPanelMinY", "handleActionMove", "handleActionUp", "handleCloseRecentMediaItem", "handleOpenRecentMediaItem", "hasOpenRecentMediaItem", "hideToBottom", "needAnimation", "hideToHalfWithAnimation", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onAttachedToWindow", "onDetachedFromWindow", "onInterceptTouchEvent", "ev", "onTouchEvent", "onTranslateY", "removeSelectedMedia", "path", "", "setAllItemUnSelected", "setCurrentItemSelected", "setSelectedPanel", "showWithAnimation", "targetY", "slideTo", "startY", "endY", "updateCountText", "count", "updateExtendState", "updateItemSelectState", "updateSelectedMedias", "type", "paths", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Companion", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class BottomSelectorLayout
  extends LinearLayout
{
  public static final BottomSelectorLayout.Companion a;
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private VelocityTracker jdField_a_of_type_AndroidViewVelocityTracker = VelocityTracker.obtain();
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private PanelController jdField_a_of_type_ComTencentTkdTopicsdkMediaselectorPanelController;
  @Nullable
  private RecentMediaListView jdField_a_of_type_ComTencentTkdTopicsdkMediaselectorRecentMediaListView;
  private HashMap jdField_a_of_type_JavaUtilHashMap;
  @Nullable
  private Function0<Unit> jdField_a_of_type_KotlinJvmFunctionsFunction0;
  @Nullable
  private Function1<? super List<Media>, Unit> jdField_a_of_type_KotlinJvmFunctionsFunction1;
  private boolean jdField_a_of_type_Boolean;
  private float jdField_b_of_type_Float;
  private final int jdField_b_of_type_Int;
  @Nullable
  private Function0<Unit> jdField_b_of_type_KotlinJvmFunctionsFunction0;
  @Nullable
  private Function1<? super PanelType, Unit> jdField_b_of_type_KotlinJvmFunctionsFunction1;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  @Nullable
  private Function1<? super Emotion, Unit> jdField_c_of_type_KotlinJvmFunctionsFunction1;
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int;
  @Nullable
  private Function1<? super Float, Unit> jdField_d_of_type_KotlinJvmFunctionsFunction1;
  private int jdField_e_of_type_Int;
  @Nullable
  private Function1<? super Integer, Unit> jdField_e_of_type_KotlinJvmFunctionsFunction1;
  private int f;
  private int g;
  
  static
  {
    jdField_a_of_type_ComTencentTkdTopicsdkMediaselectorBottomSelectorLayout$Companion = new BottomSelectorLayout.Companion(null);
  }
  
  public BottomSelectorLayout(@NotNull Context paramContext, @NotNull AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_AndroidWidgetTextView = new TextView(paramContext);
    this.jdField_a_of_type_ComTencentTkdTopicsdkMediaselectorPanelController = new PanelController();
    this.jdField_b_of_type_Int = DisplayUtils.a.a(paramContext, 48.0F);
    this.jdField_c_of_type_Int = ((int)getTranslationY());
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Boolean = true;
    this.jdField_e_of_type_Int = 2;
    LayoutInflater.from(paramContext).inflate(R.layout.H, (ViewGroup)this, true);
  }
  
  private final int a(PanelType paramPanelType)
  {
    int i = BottomSelectorLayout.WhenMappings.a[paramPanelType.ordinal()];
    if ((i != 1) && (i != 2))
    {
      int j;
      if (i != 3) {
        j = f();
      }
      Context localContext;
      for (i = this.jdField_b_of_type_Int;; i = paramPanelType.a(localContext, 186.0F))
      {
        return j - i;
        j = f() - this.jdField_b_of_type_Int;
        paramPanelType = DisplayUtils.a;
        localContext = getContext();
        Intrinsics.checkExpressionValueIsNotNull(localContext, "context");
      }
    }
    return this.jdField_c_of_type_Int;
  }
  
  private final ImageView a(int paramInt)
  {
    ImageView localImageView = new ImageView(getContext());
    localImageView.setImageResource(paramInt);
    Object localObject1 = DisplayUtils.a;
    Object localObject2 = getContext();
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "context");
    paramInt = ((DisplayUtils)localObject1).a((Context)localObject2, 28.0F);
    localObject1 = DisplayUtils.a;
    localObject2 = getContext();
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "context");
    localObject1 = new LinearLayout.LayoutParams(paramInt, ((DisplayUtils)localObject1).a((Context)localObject2, 28.0F));
    localObject2 = (LinearLayout)a(R.id.aI);
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "selectorBar");
    if (((LinearLayout)localObject2).getChildCount() > 0)
    {
      localObject2 = DisplayUtils.a;
      Context localContext = getContext();
      Intrinsics.checkExpressionValueIsNotNull(localContext, "context");
      ((LinearLayout.LayoutParams)localObject1).leftMargin = ((DisplayUtils)localObject2).a(localContext, 32.0F);
    }
    ((LinearLayout)a(R.id.aI)).addView((View)localImageView, (ViewGroup.LayoutParams)localObject1);
    return localImageView;
  }
  
  private final void a(float paramFloat)
  {
    int i;
    if (paramFloat < e()) {
      i = 3;
    } else if (paramFloat > e()) {
      i = 1;
    } else {
      i = 2;
    }
    this.jdField_e_of_type_Int = i;
  }
  
  private final void a(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      localObject = ValueAnimator.ofFloat(new float[] { paramFloat1, paramFloat2 });
      ((ValueAnimator)localObject).addUpdateListener((ValueAnimator.AnimatorUpdateListener)new BottomSelectorLayout.slideTo.1(this));
      Intrinsics.checkExpressionValueIsNotNull(localObject, "valueAnimator");
      ((ValueAnimator)localObject).setDuration(200L);
      ((ValueAnimator)localObject).start();
    }
    else
    {
      setTranslationY(paramFloat2);
    }
    a(paramFloat2);
    f();
    Object localObject = this.jdField_e_of_type_KotlinJvmFunctionsFunction1;
    if (localObject != null) {
      localObject = (Unit)((Function1)localObject).invoke(Integer.valueOf(this.jdField_e_of_type_Int));
    }
  }
  
  private final void a(int paramInt1, PanelType paramPanelType, int paramInt2, long paramLong)
  {
    ImageView localImageView = a(paramInt1);
    Object localObject1 = getContext();
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "context");
    Object localObject2 = getContext();
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "context");
    localObject1 = new MediaSelectorPanel((Context)localObject1, (IMediaContract.IPresenter)new MediaPresenter((IMediaContract.IModel)new SelectMediaModel((Context)localObject2)), paramPanelType);
    localObject2 = (FrameLayout)a(R.id.ak);
    View localView = (View)localObject1;
    ((FrameLayout)localObject2).addView(localView, new ViewGroup.LayoutParams(-1, -1));
    getRootView().post((Runnable)new BottomSelectorLayout.addMediaPanel.1(this, (MediaSelectorPanel)localObject1));
    ((MediaSelectorPanel)localObject1).setMaxSelectCount(paramInt2);
    ((MediaSelectorPanel)localObject1).setMaxMediaSize(paramLong);
    ((MediaSelectorPanel)localObject1).setOnMediaLoadedListener(this.jdField_b_of_type_KotlinJvmFunctionsFunction1);
    ((MediaSelectorPanel)localObject1).setOnSelectChangeListener((Function1)new BottomSelectorLayout.addMediaPanel.2(this, (MediaSelectorPanel)localObject1));
    ((MediaSelectorPanel)localObject1).setOnItemClickListener((Function1)new BottomSelectorLayout.addMediaPanel.3(this, paramPanelType, (MediaSelectorPanel)localObject1));
    ((MediaSelectorPanel)localObject1).setOnOverSelectListener((Function0)new BottomSelectorLayout.addMediaPanel.4(this, paramPanelType, paramInt2));
    ((MediaSelectorPanel)localObject1).setOnSelectedOverSizeListener((Function1)new BottomSelectorLayout.addMediaPanel.5(this, paramPanelType, paramLong));
    this.jdField_a_of_type_ComTencentTkdTopicsdkMediaselectorPanelController.a((View)localImageView, localView, paramPanelType);
  }
  
  private final void a(MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getRawY() - this.jdField_a_of_type_Float;
    float f2 = getY();
    float f3 = b(this.jdField_a_of_type_ComTencentTkdTopicsdkMediaselectorPanelController.a());
    int j = 1;
    int i;
    if (((f2 > f3) && (getY() <= f() - this.jdField_b_of_type_Int)) || ((getY() <= b(this.jdField_a_of_type_ComTencentTkdTopicsdkMediaselectorPanelController.a())) && (f1 > 0)) || ((getY() >= f() - this.jdField_b_of_type_Int) && (f1 < 0))) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      setTranslationY(getTranslationY() + f1);
      b(getTranslationY());
    }
    this.jdField_a_of_type_Float = paramMotionEvent.getRawY();
    paramMotionEvent = this.jdField_a_of_type_AndroidViewVelocityTracker;
    ViewConfiguration localViewConfiguration = ViewConfiguration.get(getContext());
    Intrinsics.checkExpressionValueIsNotNull(localViewConfiguration, "ViewConfiguration.get(context)");
    paramMotionEvent.computeCurrentVelocity(1000, localViewConfiguration.getScaledMaximumFlingVelocity());
    paramMotionEvent = this.jdField_a_of_type_AndroidViewVelocityTracker;
    Intrinsics.checkExpressionValueIsNotNull(paramMotionEvent, "velocityTracker");
    if (paramMotionEvent.getYVelocity() >= 3)
    {
      i = 2;
    }
    else
    {
      paramMotionEvent = this.jdField_a_of_type_AndroidViewVelocityTracker;
      Intrinsics.checkExpressionValueIsNotNull(paramMotionEvent, "velocityTracker");
      if (paramMotionEvent.getYVelocity() <= -3) {
        i = j;
      } else {
        i = 0;
      }
    }
    this.jdField_a_of_type_Int = i;
  }
  
  private final int b(PanelType paramPanelType)
  {
    int i = BottomSelectorLayout.WhenMappings.b[paramPanelType.ordinal()];
    if ((i != 1) && (i != 2))
    {
      int j;
      if (i != 3) {
        j = f();
      }
      Context localContext;
      for (i = this.jdField_b_of_type_Int;; i = paramPanelType.a(localContext, 186.0F))
      {
        return j - i;
        j = f() - this.jdField_b_of_type_Int;
        paramPanelType = DisplayUtils.a;
        localContext = getContext();
        Intrinsics.checkExpressionValueIsNotNull(localContext, "context");
      }
    }
    return 0;
  }
  
  private final void b(float paramFloat)
  {
    Object localObject = this.jdField_d_of_type_KotlinJvmFunctionsFunction1;
    if (localObject != null) {
      localObject = (Unit)((Function1)localObject).invoke(Float.valueOf(getTranslationY()));
    }
    if (paramFloat <= 0)
    {
      localObject = a(R.id.aJ);
      Intrinsics.checkExpressionValueIsNotNull(localObject, "selectorBarTopLine");
      ((View)localObject).setVisibility(8);
      localObject = (LinearLayout)a(R.id.aI);
      Intrinsics.checkExpressionValueIsNotNull(localObject, "selectorBar");
      ((LinearLayout)localObject).setVisibility(8);
      if ((this.jdField_a_of_type_ComTencentTkdTopicsdkMediaselectorPanelController.a() instanceof MediaSelectorPanel))
      {
        localObject = this.jdField_a_of_type_ComTencentTkdTopicsdkMediaselectorPanelController.a();
        if (localObject != null)
        {
          localObject = ((MediaSelectorPanel)localObject).a().keySet();
          Intrinsics.checkExpressionValueIsNotNull(localObject, "(panelController.current…ectorPanel).mediaMap.keys");
          if ((((Collection)localObject).isEmpty() ^ true))
          {
            localObject = (RoundBackgroundRelativeLayout)a(R.id.ax);
            Intrinsics.checkExpressionValueIsNotNull(localObject, "recentMediaItemLayout");
            ((RoundBackgroundRelativeLayout)localObject).setVisibility(0);
          }
        }
        else
        {
          throw new TypeCastException("null cannot be cast to non-null type com.tencent.tkd.topicsdk.mediaselector.MediaSelectorPanel");
        }
      }
      localObject = (RoundBackgroundTextView)a(R.id.D);
      Intrinsics.checkExpressionValueIsNotNull(localObject, "finishView");
      ((RoundBackgroundTextView)localObject).setVisibility(0);
      ((RoundBackgroundRelativeLayout)a(R.id.ax)).setOnClickListener((View.OnClickListener)new BottomSelectorLayout.onTranslateY.1(this));
      ((RoundBackgroundTextView)a(R.id.D)).setOnClickListener((View.OnClickListener)new BottomSelectorLayout.onTranslateY.2(this));
    }
    else
    {
      localObject = a(R.id.aJ);
      Intrinsics.checkExpressionValueIsNotNull(localObject, "selectorBarTopLine");
      ((View)localObject).setVisibility(0);
      localObject = (LinearLayout)a(R.id.aI);
      Intrinsics.checkExpressionValueIsNotNull(localObject, "selectorBar");
      ((LinearLayout)localObject).setVisibility(0);
      localObject = (RoundBackgroundRelativeLayout)a(R.id.ax);
      Intrinsics.checkExpressionValueIsNotNull(localObject, "recentMediaItemLayout");
      ((RoundBackgroundRelativeLayout)localObject).setVisibility(8);
      localObject = (RoundBackgroundTextView)a(R.id.D);
      Intrinsics.checkExpressionValueIsNotNull(localObject, "finishView");
      ((RoundBackgroundTextView)localObject).setVisibility(8);
    }
    if (c())
    {
      localObject = this.jdField_a_of_type_ComTencentTkdTopicsdkMediaselectorRecentMediaListView;
      if (localObject != null)
      {
        localObject = ((RecentMediaListView)localObject).getAnimation();
        if ((localObject != null) && (!((Animation)localObject).hasStarted())) {}
      }
      else
      {
        localObject = this.jdField_a_of_type_ComTencentTkdTopicsdkMediaselectorRecentMediaListView;
        if (localObject == null) {
          return;
        }
        localObject = ((RecentMediaListView)localObject).getAnimation();
        if ((localObject == null) || (((Animation)localObject).hasEnded() != true)) {
          return;
        }
      }
      j();
    }
  }
  
  private final boolean c()
  {
    return this.jdField_a_of_type_ComTencentTkdTopicsdkMediaselectorRecentMediaListView != null;
  }
  
  private final void e()
  {
    int i = this.jdField_a_of_type_Int;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2) {
          return;
        }
        if (getTranslationY() < e())
        {
          a(this, getTranslationY(), e(), false, 4, null);
          return;
        }
        a(this, getTranslationY(), f() - this.jdField_b_of_type_Int, false, 4, null);
        return;
      }
      if (getTranslationY() < e())
      {
        a(this, getTranslationY(), b(this.jdField_a_of_type_ComTencentTkdTopicsdkMediaselectorPanelController.a()), false, 4, null);
        return;
      }
      a(this, getTranslationY(), e(), false, 4, null);
      return;
    }
    if (getTranslationY() >= e())
    {
      if (getTranslationY() < e() + (f() - e()) / 2)
      {
        a(this, getTranslationY(), e(), false, 4, null);
        return;
      }
      a(this, getTranslationY(), f() - this.jdField_b_of_type_Int, false, 4, null);
      return;
    }
    if (getTranslationY() < e())
    {
      if (getTranslationY() < e() / 2)
      {
        a(this, getTranslationY(), 0.0F, false, 4, null);
        return;
      }
      a(this, getTranslationY(), e(), false, 4, null);
    }
  }
  
  private final int f()
  {
    ViewParent localViewParent = getParent();
    if (localViewParent != null) {
      return ((ViewGroup)localViewParent).getHeight();
    }
    throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup");
  }
  
  private final void f()
  {
    if (this.jdField_e_of_type_Int == 2)
    {
      g();
      return;
    }
    h();
  }
  
  private final void g()
  {
    PanelController localPanelController = this.jdField_a_of_type_ComTencentTkdTopicsdkMediaselectorPanelController;
    localPanelController.a(localPanelController.a());
  }
  
  private final void h()
  {
    Iterator localIterator = this.jdField_a_of_type_ComTencentTkdTopicsdkMediaselectorPanelController.a().iterator();
    while (localIterator.hasNext())
    {
      View localView = (View)localIterator.next();
      Intrinsics.checkExpressionValueIsNotNull(localView, "view");
      localView.setSelected(false);
    }
  }
  
  private final void i()
  {
    View localView = this.jdField_a_of_type_ComTencentTkdTopicsdkMediaselectorPanelController.a();
    if ((localView instanceof MediaSelectorPanel))
    {
      Object localObject1 = getContext();
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "context");
      Object localObject2 = (MediaSelectorPanel)localView;
      this.jdField_a_of_type_ComTencentTkdTopicsdkMediaselectorRecentMediaListView = new RecentMediaListView((Context)localObject1, ((MediaSelectorPanel)localObject2).b(), ((MediaSelectorPanel)localObject2).a());
      localObject1 = this.jdField_a_of_type_ComTencentTkdTopicsdkMediaselectorRecentMediaListView;
      if (localObject1 != null)
      {
        ((RecentMediaListView)localObject1).setBackgroundResource(17170443);
        ((FrameLayout)a(R.id.ak)).addView((View)localObject1);
        localObject2 = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, -1.0F, 1, 0.0F);
        ((TranslateAnimation)localObject2).setDuration(250L);
        ((TranslateAnimation)localObject2).setFillAfter(true);
        ((RecentMediaListView)localObject1).startAnimation((Animation)localObject2);
        localObject2 = new RotateAnimation(0.0F, -180.0F, 1, 0.5F, 1, 0.5F);
        ((RotateAnimation)localObject2).setDuration(250L);
        ((RotateAnimation)localObject2).setFillAfter(true);
        ((ImageView)a(R.id.aw)).startAnimation((Animation)localObject2);
        ((RecentMediaListView)localObject1).setOnSelectCallback((Function3)new BottomSelectorLayout.handleOpenRecentMediaItem..inlined.let.lambda.1(this, localView));
      }
    }
  }
  
  private final void j()
  {
    Object localObject = this.jdField_a_of_type_ComTencentTkdTopicsdkMediaselectorRecentMediaListView;
    if (localObject != null)
    {
      localObject = ((RecentMediaListView)localObject).getAnimation();
      if (localObject != null) {
        ((Animation)localObject).hasStarted();
      }
    }
    localObject = this.jdField_a_of_type_ComTencentTkdTopicsdkMediaselectorRecentMediaListView;
    if (localObject != null)
    {
      TranslateAnimation localTranslateAnimation = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 0.0F, 1, -1.0F);
      localTranslateAnimation.setDuration(250L);
      localTranslateAnimation.setFillAfter(true);
      localTranslateAnimation.setAnimationListener((Animation.AnimationListener)new BottomSelectorLayout.handleCloseRecentMediaItem..inlined.let.lambda.1((RecentMediaListView)localObject, this));
      ((RecentMediaListView)localObject).startAnimation((Animation)localTranslateAnimation);
      localObject = new RotateAnimation(-180.0F, 0.0F, 1, 0.5F, 1, 0.5F);
      ((RotateAnimation)localObject).setDuration(250L);
      ((RotateAnimation)localObject).setFillAfter(true);
      ((ImageView)a(R.id.aw)).startAnimation((Animation)localObject);
    }
  }
  
  public final int a()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public View a(int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilHashMap == null) {
      this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    }
    View localView2 = (View)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt));
    View localView1 = localView2;
    if (localView2 == null)
    {
      localView1 = findViewById(paramInt);
      this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(paramInt), localView1);
    }
    return localView1;
  }
  
  @NotNull
  public final PanelType a()
  {
    return this.jdField_a_of_type_ComTencentTkdTopicsdkMediaselectorPanelController.a();
  }
  
  @Nullable
  public final Function0<Unit> a()
  {
    return this.jdField_a_of_type_KotlinJvmFunctionsFunction0;
  }
  
  @Nullable
  public final Function1<List<Media>, Unit> a()
  {
    return this.jdField_a_of_type_KotlinJvmFunctionsFunction1;
  }
  
  public final void a()
  {
    ImageView localImageView = a(R.drawable.jdField_e_of_type_Int);
    Object localObject = new EmoJiEmotionPanel(getContext());
    ((EmoJiEmotionPanel)localObject).setOnEmotionItemClickListener((OnEmotionItemClickListener)new BottomSelectorLayout.addEmotionPanel..inlined.apply.lambda.1(this));
    ((EmoJiEmotionPanel)localObject).a();
    FrameLayout localFrameLayout = (FrameLayout)a(R.id.ak);
    localObject = (View)localObject;
    DisplayUtils localDisplayUtils = DisplayUtils.a;
    Context localContext = getContext();
    Intrinsics.checkExpressionValueIsNotNull(localContext, "context");
    localFrameLayout.addView((View)localObject, new ViewGroup.LayoutParams(-1, localDisplayUtils.a(localContext, 186.0F)));
    this.jdField_a_of_type_ComTencentTkdTopicsdkMediaselectorPanelController.a((View)localImageView, (View)localObject, PanelType.EMOJI);
  }
  
  public final void a(int paramInt)
  {
    Object localObject1 = new View(getContext());
    Object localObject2 = new LinearLayout.LayoutParams(0, -2);
    ((LinearLayout.LayoutParams)localObject2).weight = 1.0F;
    ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
    ((LinearLayout)a(R.id.aI)).addView((View)localObject1);
    this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)String.valueOf(paramInt));
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#AAAAAA"));
    this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(1, 16.0F);
    this.jdField_a_of_type_AndroidWidgetTextView.addTextChangedListener((TextWatcher)new BottomSelectorLayout.addCountChangeTextView..inlined.addTextChangedListener.1(this));
    localObject1 = new LinearLayout.LayoutParams(-2, -2);
    localObject2 = DisplayUtils.a;
    Context localContext = getContext();
    Intrinsics.checkExpressionValueIsNotNull(localContext, "context");
    ((LinearLayout.LayoutParams)localObject1).rightMargin = ((DisplayUtils)localObject2).a(localContext, 12.0F);
    this.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    ((LinearLayout)a(R.id.aI)).addView((View)this.jdField_a_of_type_AndroidWidgetTextView);
  }
  
  public final void a(int paramInt1, int paramInt2, @Nullable Intent paramIntent)
  {
    Object localObject;
    if (paramInt1 == 3)
    {
      if (paramIntent != null) {
        paramIntent = paramIntent.getStringArrayListExtra("selected_photo_list");
      } else {
        paramIntent = null;
      }
      localObject = this.jdField_a_of_type_ComTencentTkdTopicsdkMediaselectorPanelController.a(PanelType.PHOTO);
      if (localObject != null)
      {
        localObject = (MediaSelectorPanel)localObject;
        if (paramIntent != null) {
          ((MediaSelectorPanel)localObject).a(paramIntent);
        }
      }
      else
      {
        throw new TypeCastException("null cannot be cast to non-null type com.tencent.tkd.topicsdk.mediaselector.MediaSelectorPanel");
      }
    }
    else if ((paramInt1 == 4) && (paramIntent != null) && (Build.VERSION.SDK_INT >= 18))
    {
      paramIntent = paramIntent.getStringExtra("video_path");
      if (paramInt2 == -1)
      {
        Intrinsics.checkExpressionValueIsNotNull(paramIntent, "videoPath");
        if (((CharSequence)paramIntent).length() > 0) {
          paramInt1 = 1;
        } else {
          paramInt1 = 0;
        }
        if (paramInt1 != 0)
        {
          localObject = this.jdField_a_of_type_ComTencentTkdTopicsdkMediaselectorPanelController.a(PanelType.VIDEO);
          if (localObject != null)
          {
            ((MediaSelectorPanel)localObject).a(CollectionsKt.arrayListOf(new String[] { paramIntent }));
            return;
          }
          throw new TypeCastException("null cannot be cast to non-null type com.tencent.tkd.topicsdk.mediaselector.MediaSelectorPanel");
        }
      }
    }
  }
  
  public final void a(int paramInt, long paramLong)
  {
    a(R.drawable.f, PanelType.PHOTO, paramInt, paramLong);
  }
  
  public final void a(@NotNull PanelType paramPanelType, @NotNull ArrayList<String> paramArrayList)
  {
    Intrinsics.checkParameterIsNotNull(paramPanelType, "type");
    Intrinsics.checkParameterIsNotNull(paramArrayList, "paths");
    setSelectedPanel(paramPanelType);
    View localView = this.jdField_a_of_type_ComTencentTkdTopicsdkMediaselectorPanelController.a();
    paramPanelType = localView;
    if (!(localView instanceof MediaSelectorPanel)) {
      paramPanelType = null;
    }
    paramPanelType = (MediaSelectorPanel)paramPanelType;
    if (paramPanelType != null) {
      paramPanelType.a(paramArrayList);
    }
  }
  
  public final void a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "path");
    Object localObject2 = (Iterable)this.jdField_a_of_type_ComTencentTkdTopicsdkMediaselectorPanelController.b();
    Object localObject1 = (Collection)new ArrayList();
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      Object localObject3 = ((Iterator)localObject2).next();
      if ((localObject3 instanceof MediaSelectorPanel)) {
        ((Collection)localObject1).add(localObject3);
      }
    }
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((MediaSelectorPanel)((Iterator)localObject1).next()).a(paramString);
    }
  }
  
  public final void a(boolean paramBoolean)
  {
    a(getTranslationY(), f() - this.jdField_b_of_type_Int, paramBoolean);
  }
  
  public final boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public final int b()
  {
    return this.jdField_e_of_type_Int;
  }
  
  @Nullable
  public final Function0<Unit> b()
  {
    return this.jdField_b_of_type_KotlinJvmFunctionsFunction0;
  }
  
  @Nullable
  public final Function1<Emotion, Unit> b()
  {
    return this.jdField_c_of_type_KotlinJvmFunctionsFunction1;
  }
  
  public final void b()
  {
    ImageView localImageView = new ImageView(getContext());
    localImageView.setImageResource(R.drawable.jdField_d_of_type_Int);
    Object localObject1 = DisplayUtils.a;
    Object localObject2 = getContext();
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "context");
    int i = ((DisplayUtils)localObject1).a((Context)localObject2, 28.0F);
    localObject1 = DisplayUtils.a;
    localObject2 = getContext();
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "context");
    localObject1 = new LinearLayout.LayoutParams(i, ((DisplayUtils)localObject1).a((Context)localObject2, 28.0F));
    localObject2 = (LinearLayout)a(R.id.aI);
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "selectorBar");
    if (((LinearLayout)localObject2).getChildCount() > 0)
    {
      localObject2 = DisplayUtils.a;
      Context localContext = getContext();
      Intrinsics.checkExpressionValueIsNotNull(localContext, "context");
      ((LinearLayout.LayoutParams)localObject1).leftMargin = ((DisplayUtils)localObject2).a(localContext, 32.0F);
    }
    localImageView.setOnClickListener((View.OnClickListener)new BottomSelectorLayout.addAtButton.1(this));
    ((LinearLayout)a(R.id.aI)).addView((View)localImageView, (ViewGroup.LayoutParams)localObject1);
  }
  
  public final void b(int paramInt)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)String.valueOf(paramInt));
  }
  
  public final void b(int paramInt, long paramLong)
  {
    a(R.drawable.h, PanelType.VIDEO, paramInt, paramLong);
  }
  
  public final boolean b()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public final int c()
  {
    return this.f;
  }
  
  public final void c()
  {
    ImageView localImageView = new ImageView(getContext());
    localImageView.setImageResource(R.drawable.g);
    Object localObject1 = DisplayUtils.a;
    Object localObject2 = getContext();
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "context");
    int i = ((DisplayUtils)localObject1).a((Context)localObject2, 28.0F);
    localObject1 = DisplayUtils.a;
    localObject2 = getContext();
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "context");
    localObject1 = new LinearLayout.LayoutParams(i, ((DisplayUtils)localObject1).a((Context)localObject2, 28.0F));
    localObject2 = (LinearLayout)a(R.id.aI);
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "selectorBar");
    if (((LinearLayout)localObject2).getChildCount() > 0)
    {
      localObject2 = DisplayUtils.a;
      Context localContext = getContext();
      Intrinsics.checkExpressionValueIsNotNull(localContext, "context");
      ((LinearLayout.LayoutParams)localObject1).leftMargin = ((DisplayUtils)localObject2).a(localContext, 32.0F);
    }
    localImageView.setOnClickListener((View.OnClickListener)new BottomSelectorLayout.addTopicButton.1(this));
    ((LinearLayout)a(R.id.aI)).addView((View)localImageView, (ViewGroup.LayoutParams)localObject1);
  }
  
  public final void c(int paramInt)
  {
    a(this, getTranslationY(), paramInt, false, 4, null);
  }
  
  public final int d()
  {
    return this.g;
  }
  
  public final void d()
  {
    a(this, getTranslationY(), e(), false, 4, null);
  }
  
  public boolean dispatchTouchEvent(@NotNull MotionEvent paramMotionEvent)
  {
    Intrinsics.checkParameterIsNotNull(paramMotionEvent, "event");
    Object localObject = this.jdField_a_of_type_ComTencentTkdTopicsdkMediaselectorPanelController.a();
    if ((localObject instanceof MediaSelectorPanel))
    {
      int i = paramMotionEvent.getAction();
      boolean bool2 = false;
      if (i != 0)
      {
        if (i == 2)
        {
          boolean bool1;
          if (c())
          {
            bool1 = bool2;
          }
          else
          {
            localObject = (MediaSelectorPanel)localObject;
            float f1;
            float f2;
            if ((((MediaSelectorPanel)localObject).b()) && (((MediaSelectorPanel)localObject).a()))
            {
              f1 = Math.abs(paramMotionEvent.getRawY() - this.jdField_a_of_type_Float);
              localObject = ViewConfiguration.get(getContext());
              Intrinsics.checkExpressionValueIsNotNull(localObject, "ViewConfiguration.get(\n …                        )");
              bool1 = bool2;
              if (f1 <= ((ViewConfiguration)localObject).getScaledTouchSlop()) {
                break label249;
              }
            }
            else
            {
              if (!((MediaSelectorPanel)localObject).b()) {
                break label190;
              }
              f1 = paramMotionEvent.getRawY();
              f2 = this.jdField_a_of_type_Float;
              localObject = ViewConfiguration.get(getContext());
              Intrinsics.checkExpressionValueIsNotNull(localObject, "ViewConfiguration.get(context)");
              bool1 = bool2;
              if (f1 - f2 <= ((ViewConfiguration)localObject).getScaledTouchSlop()) {
                break label249;
              }
            }
            label190:
            do
            {
              bool1 = true;
              break;
              bool1 = bool2;
              if (!((MediaSelectorPanel)localObject).a()) {
                break;
              }
              f1 = this.jdField_a_of_type_Float;
              f2 = paramMotionEvent.getRawY();
              localObject = ViewConfiguration.get(getContext());
              Intrinsics.checkExpressionValueIsNotNull(localObject, "ViewConfiguration.get(context)");
              bool1 = bool2;
            } while (f1 - f2 > ((ViewConfiguration)localObject).getScaledTouchSlop());
          }
          label249:
          this.jdField_c_of_type_Boolean = bool1;
        }
      }
      else
      {
        this.jdField_a_of_type_Float = paramMotionEvent.getRawY();
        this.jdField_c_of_type_Boolean = false;
      }
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public final int e()
  {
    return a(this.jdField_a_of_type_ComTencentTkdTopicsdkMediaselectorPanelController.a());
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.jdField_a_of_type_ComTencentTkdTopicsdkMediaselectorPanelController.a((Function2)new BottomSelectorLayout.onAttachedToWindow.1(this));
    this.jdField_a_of_type_ComTencentTkdTopicsdkMediaselectorPanelController.b((Function1)new BottomSelectorLayout.onAttachedToWindow.2(this));
    this.jdField_a_of_type_ComTencentTkdTopicsdkMediaselectorPanelController.a((Function1)new BottomSelectorLayout.onAttachedToWindow.3(this));
    Object localObject2 = (Iterable)this.jdField_a_of_type_ComTencentTkdTopicsdkMediaselectorPanelController.b();
    Object localObject1 = (Collection)new ArrayList();
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      Object localObject3 = ((Iterator)localObject2).next();
      if ((localObject3 instanceof MediaSelectorPanel)) {
        ((Collection)localObject1).add(localObject3);
      }
    }
    if ((((Collection)localObject1).isEmpty() ^ true))
    {
      localObject1 = ViewExtensionsKt.a(this);
      if ((localObject1 != null) && (!PermissionUtils.a.a((Activity)localObject1))) {
        PermissionUtils.a.a((Activity)localObject1, null);
      }
    }
  }
  
  protected void onDetachedFromWindow()
  {
    this.jdField_a_of_type_AndroidViewVelocityTracker.recycle();
    super.onDetachedFromWindow();
  }
  
  public boolean onInterceptTouchEvent(@Nullable MotionEvent paramMotionEvent)
  {
    return (this.jdField_c_of_type_Boolean) || (super.onInterceptTouchEvent(paramMotionEvent));
  }
  
  public boolean onTouchEvent(@NotNull MotionEvent paramMotionEvent)
  {
    Intrinsics.checkParameterIsNotNull(paramMotionEvent, "event");
    this.jdField_a_of_type_AndroidViewVelocityTracker.addMovement(paramMotionEvent);
    int i = paramMotionEvent.getAction();
    if (i != 0)
    {
      if (i != 1)
      {
        if (i == 2) {
          a(paramMotionEvent);
        }
      }
      else {
        e();
      }
      return super.onTouchEvent(paramMotionEvent);
    }
    this.jdField_a_of_type_Float = paramMotionEvent.getRawY();
    this.jdField_b_of_type_Float = paramMotionEvent.getRawY();
    return true;
  }
  
  public final void setDefaultPanelIndex(int paramInt)
  {
    this.jdField_d_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentTkdTopicsdkMediaselectorPanelController.a(paramInt);
  }
  
  public final void setExtendState(int paramInt)
  {
    this.jdField_e_of_type_Int = paramInt;
  }
  
  public final void setInitY(int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
    setTranslationY(this.jdField_c_of_type_Int);
  }
  
  public final void setMaxVideoLength(int paramInt)
  {
    this.g = paramInt;
  }
  
  public final void setMinVideoLength(int paramInt)
  {
    this.f = paramInt;
  }
  
  public final void setOnAtButtonClickListener(@Nullable Function0<Unit> paramFunction0)
  {
    this.jdField_a_of_type_KotlinJvmFunctionsFunction0 = paramFunction0;
  }
  
  public final void setOnEmoJiItemClickListener(@Nullable Function1<? super Emotion, Unit> paramFunction1)
  {
    this.jdField_c_of_type_KotlinJvmFunctionsFunction1 = paramFunction1;
  }
  
  public final void setOnExtendStateChangeListener(@Nullable Function1<? super Integer, Unit> paramFunction1)
  {
    this.jdField_e_of_type_KotlinJvmFunctionsFunction1 = paramFunction1;
  }
  
  public final void setOnMediaLoadedListener(@Nullable Function1<? super PanelType, Unit> paramFunction1)
  {
    this.jdField_b_of_type_KotlinJvmFunctionsFunction1 = paramFunction1;
  }
  
  public final void setOnMediaSelectChangeListener(@Nullable Function1<? super List<Media>, Unit> paramFunction1)
  {
    this.jdField_a_of_type_KotlinJvmFunctionsFunction1 = paramFunction1;
  }
  
  public final void setOnTopicButtonClickListener(@Nullable Function0<Unit> paramFunction0)
  {
    this.jdField_b_of_type_KotlinJvmFunctionsFunction0 = paramFunction0;
  }
  
  public final void setOnTranslateListener(@Nullable Function1<? super Float, Unit> paramFunction1)
  {
    this.jdField_d_of_type_KotlinJvmFunctionsFunction1 = paramFunction1;
  }
  
  public final void setPicPanelEnable(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_ComTencentTkdTopicsdkMediaselectorPanelController.c().set(0, Boolean.valueOf(paramBoolean));
  }
  
  public final void setRecentMediaSlidingLayout(@Nullable RecentMediaListView paramRecentMediaListView)
  {
    this.jdField_a_of_type_ComTencentTkdTopicsdkMediaselectorRecentMediaListView = paramRecentMediaListView;
  }
  
  public final void setSelectedPanel(@NotNull PanelType paramPanelType)
  {
    Intrinsics.checkParameterIsNotNull(paramPanelType, "panelType");
    this.jdField_a_of_type_ComTencentTkdTopicsdkMediaselectorPanelController.a(paramPanelType);
  }
  
  public final void setVideoPanelEnable(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_ComTencentTkdTopicsdkMediaselectorPanelController.c().set(1, Boolean.valueOf(paramBoolean));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.mediaselector.BottomSelectorLayout
 * JD-Core Version:    0.7.0.1
 */