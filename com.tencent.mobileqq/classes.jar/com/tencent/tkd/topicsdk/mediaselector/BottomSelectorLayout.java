package com.tencent.tkd.topicsdk.mediaselector;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.RotateAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.tkd.R.id;
import com.tencent.tkd.R.layout;
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
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/mediaselector/BottomSelectorLayout;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "countView", "Landroid/widget/TextView;", "currentPanelInitY", "", "getCurrentPanelInitY", "()I", "value", "defaultPanelIndex", "getDefaultPanelIndex", "setDefaultPanelIndex", "(I)V", "extendState", "getExtendState", "setExtendState", "initY", "getInitY", "setInitY", "lastTouchY", "", "maxVideoLength", "getMaxVideoLength", "setMaxVideoLength", "minVideoLength", "getMinVideoLength", "setMinVideoLength", "needIntercept", "", "onAtButtonClickListener", "Lkotlin/Function0;", "", "getOnAtButtonClickListener", "()Lkotlin/jvm/functions/Function0;", "setOnAtButtonClickListener", "(Lkotlin/jvm/functions/Function0;)V", "onEmoJiItemClickListener", "Lkotlin/Function1;", "Lcom/tencent/tkd/comment/panel/model/Emotion;", "Lkotlin/ParameterName;", "name", "emotion", "getOnEmoJiItemClickListener", "()Lkotlin/jvm/functions/Function1;", "setOnEmoJiItemClickListener", "(Lkotlin/jvm/functions/Function1;)V", "onExtendStateChangeListener", "getOnExtendStateChangeListener", "setOnExtendStateChangeListener", "onMediaLoadedListener", "Lcom/tencent/tkd/topicsdk/mediaselector/PanelType;", "getOnMediaLoadedListener", "setOnMediaLoadedListener", "onMediaSelectChangeListener", "", "Lcom/tencent/tkd/topicsdk/bean/Media;", "selectedMedias", "getOnMediaSelectChangeListener", "setOnMediaSelectChangeListener", "onTopicButtonClickListener", "getOnTopicButtonClickListener", "setOnTopicButtonClickListener", "onTranslateListener", "translateY", "getOnTranslateListener", "setOnTranslateListener", "panelController", "Lcom/tencent/tkd/topicsdk/mediaselector/PanelController;", "parentHeight", "getParentHeight", "picPanelEnable", "getPicPanelEnable", "()Z", "setPicPanelEnable", "(Z)V", "recentMediaSlidingLayout", "Lcom/tencent/tkd/topicsdk/mediaselector/RecentMediaListView;", "getRecentMediaSlidingLayout", "()Lcom/tencent/tkd/topicsdk/mediaselector/RecentMediaListView;", "setRecentMediaSlidingLayout", "(Lcom/tencent/tkd/topicsdk/mediaselector/RecentMediaListView;)V", "selectorBarHeight", "getSelectorBarHeight", "slideDirection", "startTouchY", "velocityTracker", "Landroid/view/VelocityTracker;", "kotlin.jvm.PlatformType", "videoPanelEnable", "getVideoPanelEnable", "setVideoPanelEnable", "addAtButton", "addCountChangeTextView", "countLimit", "addEmotionPanel", "addIconViewToSelectorBar", "Landroid/widget/ImageView;", "resId", "description", "", "addMediaPanel", "panelType", "maxSelectCount", "maxSizeInByte", "", "addPhotoPanel", "addTopicButton", "addVideoPanel", "dispatchTouchEvent", "event", "Landroid/view/MotionEvent;", "getCurrentPanelType", "getPanelInitY", "getPanelMinY", "handleActionMove", "handleActionUp", "handleCloseRecentMediaItem", "handleOpenRecentMediaItem", "hasOpenRecentMediaItem", "hideToBottom", "needAnimation", "hideToHalfWithAnimation", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onAttachedToWindow", "onDetachedFromWindow", "onInterceptTouchEvent", "ev", "onTouchEvent", "onTranslateY", "removeSelectedMedia", "path", "setAllItemUnSelected", "setCurrentItemSelected", "setSelectedPanel", "showWithAnimation", "targetY", "slideTo", "startY", "endY", "updateCountText", "count", "updateExtendState", "updateItemSelectState", "updateSelectedMedias", "type", "paths", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Companion", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class BottomSelectorLayout
  extends LinearLayout
{
  public static final BottomSelectorLayout.Companion a = new BottomSelectorLayout.Companion(null);
  private VelocityTracker b = VelocityTracker.obtain();
  private int c;
  private TextView d;
  private float e;
  private float f;
  private PanelController g;
  private final int h;
  private int i;
  @Nullable
  private Function1<? super List<Media>, Unit> j;
  @Nullable
  private Function1<? super PanelType, Unit> k;
  @Nullable
  private Function1<? super Emotion, Unit> l;
  @Nullable
  private Function0<Unit> m;
  @Nullable
  private Function0<Unit> n;
  private int o;
  private boolean p;
  private boolean q;
  @Nullable
  private Function1<? super Float, Unit> r;
  @Nullable
  private RecentMediaListView s;
  private int t;
  @Nullable
  private Function1<? super Integer, Unit> u;
  private int v;
  private int w;
  private boolean x;
  private HashMap y;
  
  public BottomSelectorLayout(@NotNull Context paramContext, @NotNull AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.d = new TextView(paramContext);
    this.g = new PanelController();
    this.h = DisplayUtils.a.a(paramContext, 48.0F);
    this.i = ((int)getTranslationY());
    this.p = true;
    this.q = true;
    this.t = 2;
    LayoutInflater.from(paramContext).inflate(R.layout.D, (ViewGroup)this, true);
  }
  
  private final int a(PanelType paramPanelType)
  {
    int i1 = BottomSelectorLayout.WhenMappings.$EnumSwitchMapping$0[paramPanelType.ordinal()];
    if ((i1 != 1) && (i1 != 2))
    {
      int i2;
      if (i1 != 3) {
        i2 = getParentHeight();
      }
      Context localContext;
      for (i1 = this.h;; i1 = paramPanelType.a(localContext, 186.0F))
      {
        return i2 - i1;
        i2 = getParentHeight() - this.h;
        paramPanelType = DisplayUtils.a;
        localContext = getContext();
        Intrinsics.checkExpressionValueIsNotNull(localContext, "context");
      }
    }
    return this.i;
  }
  
  private final void a()
  {
    int i1 = this.c;
    if (i1 != 0)
    {
      if (i1 != 1)
      {
        if (i1 != 2) {
          return;
        }
        if (getTranslationY() < getCurrentPanelInitY())
        {
          a(this, getTranslationY(), getCurrentPanelInitY(), false, 4, null);
          return;
        }
        a(this, getTranslationY(), getParentHeight() - this.h, false, 4, null);
        return;
      }
      if (getTranslationY() < getCurrentPanelInitY())
      {
        a(this, getTranslationY(), b(this.g.f()), false, 4, null);
        return;
      }
      a(this, getTranslationY(), getCurrentPanelInitY(), false, 4, null);
      return;
    }
    if (getTranslationY() >= getCurrentPanelInitY())
    {
      if (getTranslationY() < getCurrentPanelInitY() + (getParentHeight() - getCurrentPanelInitY()) / 2)
      {
        a(this, getTranslationY(), getCurrentPanelInitY(), false, 4, null);
        return;
      }
      a(this, getTranslationY(), getParentHeight() - this.h, false, 4, null);
      return;
    }
    if (getTranslationY() < getCurrentPanelInitY())
    {
      if (getTranslationY() < getCurrentPanelInitY() / 2)
      {
        a(this, getTranslationY(), 0.0F, false, 4, null);
        return;
      }
      a(this, getTranslationY(), getCurrentPanelInitY(), false, 4, null);
    }
  }
  
  private final void a(float paramFloat)
  {
    int i1;
    if (paramFloat < getCurrentPanelInitY()) {
      i1 = 3;
    } else if (paramFloat > getCurrentPanelInitY()) {
      i1 = 1;
    } else {
      i1 = 2;
    }
    this.t = i1;
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
    b();
    Object localObject = this.u;
    if (localObject != null) {
      localObject = (Unit)((Function1)localObject).invoke(Integer.valueOf(this.t));
    }
  }
  
  private final void a(MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getRawY() - this.e;
    float f2 = getY();
    float f3 = b(this.g.f());
    int i2 = 1;
    int i1;
    if (((f2 > f3) && (getY() <= getParentHeight() - this.h)) || ((getY() <= b(this.g.f())) && (f1 > 0)) || ((getY() >= getParentHeight() - this.h) && (f1 < 0))) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    if (i1 != 0)
    {
      setTranslationY(getTranslationY() + f1);
      b(getTranslationY());
    }
    this.e = paramMotionEvent.getRawY();
    paramMotionEvent = this.b;
    ViewConfiguration localViewConfiguration = ViewConfiguration.get(getContext());
    Intrinsics.checkExpressionValueIsNotNull(localViewConfiguration, "ViewConfiguration.get(context)");
    paramMotionEvent.computeCurrentVelocity(1000, localViewConfiguration.getScaledMaximumFlingVelocity());
    paramMotionEvent = this.b;
    Intrinsics.checkExpressionValueIsNotNull(paramMotionEvent, "velocityTracker");
    if (paramMotionEvent.getYVelocity() >= 3)
    {
      i1 = 2;
    }
    else
    {
      paramMotionEvent = this.b;
      Intrinsics.checkExpressionValueIsNotNull(paramMotionEvent, "velocityTracker");
      if (paramMotionEvent.getYVelocity() <= -3) {
        i1 = i2;
      } else {
        i1 = 0;
      }
    }
    this.c = i1;
  }
  
  private final int b(PanelType paramPanelType)
  {
    int i1 = BottomSelectorLayout.WhenMappings.$EnumSwitchMapping$1[paramPanelType.ordinal()];
    if ((i1 != 1) && (i1 != 2))
    {
      int i2;
      if (i1 != 3) {
        i2 = getParentHeight();
      }
      Context localContext;
      for (i1 = this.h;; i1 = paramPanelType.a(localContext, 186.0F))
      {
        return i2 - i1;
        i2 = getParentHeight() - this.h;
        paramPanelType = DisplayUtils.a;
        localContext = getContext();
        Intrinsics.checkExpressionValueIsNotNull(localContext, "context");
      }
    }
    return 0;
  }
  
  private final void b()
  {
    if (this.t == 2)
    {
      c();
      return;
    }
    d();
  }
  
  private final void b(float paramFloat)
  {
    Object localObject = this.r;
    if (localObject != null) {
      localObject = (Unit)((Function1)localObject).invoke(Float.valueOf(getTranslationY()));
    }
    if (paramFloat <= 0)
    {
      localObject = a(R.id.al);
      Intrinsics.checkExpressionValueIsNotNull(localObject, "selectorBarTopLine");
      ((View)localObject).setVisibility(8);
      localObject = (LinearLayout)a(R.id.ak);
      Intrinsics.checkExpressionValueIsNotNull(localObject, "selectorBar");
      ((LinearLayout)localObject).setVisibility(8);
      if ((this.g.e() instanceof MediaSelectorPanel))
      {
        localObject = this.g.e();
        if (localObject != null)
        {
          localObject = ((MediaSelectorPanel)localObject).getMediaMap().keySet();
          Intrinsics.checkExpressionValueIsNotNull(localObject, "(panelController.current…ectorPanel).mediaMap.keys");
          if ((((Collection)localObject).isEmpty() ^ true))
          {
            localObject = (RoundBackgroundRelativeLayout)a(R.id.aa);
            Intrinsics.checkExpressionValueIsNotNull(localObject, "recentMediaItemLayout");
            ((RoundBackgroundRelativeLayout)localObject).setVisibility(0);
          }
        }
        else
        {
          throw new TypeCastException("null cannot be cast to non-null type com.tencent.tkd.topicsdk.mediaselector.MediaSelectorPanel");
        }
      }
      localObject = (RoundBackgroundTextView)a(R.id.s);
      Intrinsics.checkExpressionValueIsNotNull(localObject, "finishView");
      ((RoundBackgroundTextView)localObject).setVisibility(0);
      ((RoundBackgroundRelativeLayout)a(R.id.aa)).setOnClickListener((View.OnClickListener)new BottomSelectorLayout.onTranslateY.1(this));
      ((RoundBackgroundTextView)a(R.id.s)).setOnClickListener((View.OnClickListener)new BottomSelectorLayout.onTranslateY.2(this));
    }
    else
    {
      localObject = a(R.id.al);
      Intrinsics.checkExpressionValueIsNotNull(localObject, "selectorBarTopLine");
      ((View)localObject).setVisibility(0);
      localObject = (LinearLayout)a(R.id.ak);
      Intrinsics.checkExpressionValueIsNotNull(localObject, "selectorBar");
      ((LinearLayout)localObject).setVisibility(0);
      localObject = (RoundBackgroundRelativeLayout)a(R.id.aa);
      Intrinsics.checkExpressionValueIsNotNull(localObject, "recentMediaItemLayout");
      ((RoundBackgroundRelativeLayout)localObject).setVisibility(8);
      localObject = (RoundBackgroundTextView)a(R.id.s);
      Intrinsics.checkExpressionValueIsNotNull(localObject, "finishView");
      ((RoundBackgroundTextView)localObject).setVisibility(8);
    }
    if (g())
    {
      localObject = this.s;
      if (localObject != null)
      {
        localObject = ((RecentMediaListView)localObject).getAnimation();
        if ((localObject != null) && (!((Animation)localObject).hasStarted())) {}
      }
      else
      {
        localObject = this.s;
        if (localObject == null) {
          return;
        }
        localObject = ((RecentMediaListView)localObject).getAnimation();
        if ((localObject == null) || (((Animation)localObject).hasEnded() != true)) {
          return;
        }
      }
      f();
    }
  }
  
  private final void c()
  {
    PanelController localPanelController = this.g;
    localPanelController.a(localPanelController.c());
  }
  
  private final void d()
  {
    Iterator localIterator = this.g.a().iterator();
    while (localIterator.hasNext())
    {
      View localView = (View)localIterator.next();
      Intrinsics.checkExpressionValueIsNotNull(localView, "view");
      localView.setSelected(false);
    }
  }
  
  private final void e()
  {
    View localView = this.g.e();
    if ((localView instanceof MediaSelectorPanel))
    {
      Object localObject1 = getContext();
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "context");
      Object localObject2 = (MediaSelectorPanel)localView;
      this.s = new RecentMediaListView((Context)localObject1, ((MediaSelectorPanel)localObject2).getAllMediaList(), ((MediaSelectorPanel)localObject2).getMediaMap());
      localObject1 = this.s;
      if (localObject1 != null)
      {
        ((RecentMediaListView)localObject1).setBackgroundResource(17170443);
        ((FrameLayout)a(R.id.O)).addView((View)localObject1);
        localObject2 = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, -1.0F, 1, 0.0F);
        ((TranslateAnimation)localObject2).setDuration(250L);
        ((TranslateAnimation)localObject2).setFillAfter(true);
        ((RecentMediaListView)localObject1).startAnimation((Animation)localObject2);
        localObject2 = new RotateAnimation(0.0F, -180.0F, 1, 0.5F, 1, 0.5F);
        ((RotateAnimation)localObject2).setDuration(250L);
        ((RotateAnimation)localObject2).setFillAfter(true);
        ((ImageView)a(R.id.Z)).startAnimation((Animation)localObject2);
        ((RecentMediaListView)localObject1).setOnSelectCallback((Function3)new BottomSelectorLayout.handleOpenRecentMediaItem..inlined.let.lambda.1(this, localView));
      }
    }
  }
  
  private final void f()
  {
    Object localObject = this.s;
    if (localObject != null)
    {
      localObject = ((RecentMediaListView)localObject).getAnimation();
      if (localObject != null) {
        ((Animation)localObject).hasStarted();
      }
    }
    localObject = this.s;
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
      ((ImageView)a(R.id.Z)).startAnimation((Animation)localObject);
    }
  }
  
  private final boolean g()
  {
    return this.s != null;
  }
  
  private final int getParentHeight()
  {
    ViewParent localViewParent = getParent();
    if (localViewParent != null) {
      return ((ViewGroup)localViewParent).getHeight();
    }
    throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup");
  }
  
  public View a(int paramInt)
  {
    if (this.y == null) {
      this.y = new HashMap();
    }
    View localView2 = (View)this.y.get(Integer.valueOf(paramInt));
    View localView1 = localView2;
    if (localView2 == null)
    {
      localView1 = findViewById(paramInt);
      this.y.put(Integer.valueOf(paramInt), localView1);
    }
    return localView1;
  }
  
  public boolean dispatchTouchEvent(@NotNull MotionEvent paramMotionEvent)
  {
    Intrinsics.checkParameterIsNotNull(paramMotionEvent, "event");
    Object localObject = this.g.e();
    if ((localObject instanceof MediaSelectorPanel))
    {
      int i1 = paramMotionEvent.getAction();
      boolean bool2 = false;
      if (i1 != 0)
      {
        if (i1 == 2)
        {
          boolean bool1;
          if (g())
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
              f1 = Math.abs(paramMotionEvent.getRawY() - this.e);
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
              f2 = this.e;
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
              f1 = this.e;
              f2 = paramMotionEvent.getRawY();
              localObject = ViewConfiguration.get(getContext());
              Intrinsics.checkExpressionValueIsNotNull(localObject, "ViewConfiguration.get(context)");
              bool1 = bool2;
            } while (f1 - f2 > ((ViewConfiguration)localObject).getScaledTouchSlop());
          }
          label249:
          this.x = bool1;
        }
      }
      else
      {
        this.e = paramMotionEvent.getRawY();
        this.x = false;
      }
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public final int getCurrentPanelInitY()
  {
    return a(this.g.f());
  }
  
  @NotNull
  public final PanelType getCurrentPanelType()
  {
    return this.g.f();
  }
  
  public final int getDefaultPanelIndex()
  {
    return this.o;
  }
  
  public final int getExtendState()
  {
    return this.t;
  }
  
  public final int getInitY()
  {
    return this.i;
  }
  
  public final int getMaxVideoLength()
  {
    return this.w;
  }
  
  public final int getMinVideoLength()
  {
    return this.v;
  }
  
  @Nullable
  public final Function0<Unit> getOnAtButtonClickListener()
  {
    return this.m;
  }
  
  @Nullable
  public final Function1<Emotion, Unit> getOnEmoJiItemClickListener()
  {
    return this.l;
  }
  
  @Nullable
  public final Function1<Integer, Unit> getOnExtendStateChangeListener()
  {
    return this.u;
  }
  
  @Nullable
  public final Function1<PanelType, Unit> getOnMediaLoadedListener()
  {
    return this.k;
  }
  
  @Nullable
  public final Function1<List<Media>, Unit> getOnMediaSelectChangeListener()
  {
    return this.j;
  }
  
  @Nullable
  public final Function0<Unit> getOnTopicButtonClickListener()
  {
    return this.n;
  }
  
  @Nullable
  public final Function1<Float, Unit> getOnTranslateListener()
  {
    return this.r;
  }
  
  public final boolean getPicPanelEnable()
  {
    return this.p;
  }
  
  @Nullable
  public final RecentMediaListView getRecentMediaSlidingLayout()
  {
    return this.s;
  }
  
  public final int getSelectorBarHeight()
  {
    return this.h;
  }
  
  public final boolean getVideoPanelEnable()
  {
    return this.q;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.g.a((Function2)new BottomSelectorLayout.onAttachedToWindow.1(this));
    this.g.b((Function1)new BottomSelectorLayout.onAttachedToWindow.2(this));
    this.g.a((Function1)new BottomSelectorLayout.onAttachedToWindow.3(this));
    Object localObject2 = (Iterable)this.g.b();
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
    this.b.recycle();
    super.onDetachedFromWindow();
  }
  
  public boolean onInterceptTouchEvent(@Nullable MotionEvent paramMotionEvent)
  {
    return (this.x) || (super.onInterceptTouchEvent(paramMotionEvent));
  }
  
  public boolean onTouchEvent(@NotNull MotionEvent paramMotionEvent)
  {
    Intrinsics.checkParameterIsNotNull(paramMotionEvent, "event");
    this.b.addMovement(paramMotionEvent);
    int i1 = paramMotionEvent.getAction();
    if (i1 != 0)
    {
      if (i1 != 1)
      {
        if (i1 == 2) {
          a(paramMotionEvent);
        }
      }
      else {
        a();
      }
      return super.onTouchEvent(paramMotionEvent);
    }
    this.e = paramMotionEvent.getRawY();
    this.f = paramMotionEvent.getRawY();
    return true;
  }
  
  public final void setDefaultPanelIndex(int paramInt)
  {
    this.o = paramInt;
    this.g.a(paramInt);
  }
  
  public final void setExtendState(int paramInt)
  {
    this.t = paramInt;
  }
  
  public final void setInitY(int paramInt)
  {
    this.i = paramInt;
    setTranslationY(this.i);
  }
  
  public final void setMaxVideoLength(int paramInt)
  {
    this.w = paramInt;
  }
  
  public final void setMinVideoLength(int paramInt)
  {
    this.v = paramInt;
  }
  
  public final void setOnAtButtonClickListener(@Nullable Function0<Unit> paramFunction0)
  {
    this.m = paramFunction0;
  }
  
  public final void setOnEmoJiItemClickListener(@Nullable Function1<? super Emotion, Unit> paramFunction1)
  {
    this.l = paramFunction1;
  }
  
  public final void setOnExtendStateChangeListener(@Nullable Function1<? super Integer, Unit> paramFunction1)
  {
    this.u = paramFunction1;
  }
  
  public final void setOnMediaLoadedListener(@Nullable Function1<? super PanelType, Unit> paramFunction1)
  {
    this.k = paramFunction1;
  }
  
  public final void setOnMediaSelectChangeListener(@Nullable Function1<? super List<Media>, Unit> paramFunction1)
  {
    this.j = paramFunction1;
  }
  
  public final void setOnTopicButtonClickListener(@Nullable Function0<Unit> paramFunction0)
  {
    this.n = paramFunction0;
  }
  
  public final void setOnTranslateListener(@Nullable Function1<? super Float, Unit> paramFunction1)
  {
    this.r = paramFunction1;
  }
  
  public final void setPicPanelEnable(boolean paramBoolean)
  {
    this.p = paramBoolean;
    this.g.d().set(0, Boolean.valueOf(paramBoolean));
  }
  
  public final void setRecentMediaSlidingLayout(@Nullable RecentMediaListView paramRecentMediaListView)
  {
    this.s = paramRecentMediaListView;
  }
  
  public final void setSelectedPanel(@NotNull PanelType paramPanelType)
  {
    Intrinsics.checkParameterIsNotNull(paramPanelType, "panelType");
    this.g.a(paramPanelType);
  }
  
  public final void setVideoPanelEnable(boolean paramBoolean)
  {
    this.q = paramBoolean;
    this.g.d().set(1, Boolean.valueOf(paramBoolean));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.mediaselector.BottomSelectorLayout
 * JD-Core Version:    0.7.0.1
 */