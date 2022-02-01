package com.tencent.timi.game.ui.widget;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.av.utils.UITools;
import com.tencent.timi.game.ui.ViewStateChangeListener;
import com.tencent.timi.game.utils.Logger;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/ui/widget/TGRightDrawerView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "canDrag", "", "(Landroid/content/Context;Landroid/util/AttributeSet;IZ)V", "mContentTranX", "", "mOnAnimation", "mShadowAlpha", "mState", "mState$annotations", "()V", "mTouchDownTime", "", "mTouchDownX", "mTouchDownY", "stateListenerPool", "Ljava/util/ArrayList;", "Lcom/tencent/timi/game/ui/ViewStateChangeListener;", "Lkotlin/collections/ArrayList;", "addContent", "", "content", "Landroid/view/View;", "layoutParams", "Landroid/widget/FrameLayout$LayoutParams;", "addViewStateChangeListener", "l", "drag", "doAnim", "fromTranX", "targetTranX", "fromAlpha", "targetAlpha", "targetState", "getState", "handleMoveEndEvent", "motionEvent", "Landroid/view/MotionEvent;", "handleMoveEvent", "hide", "hideAnim", "hideSelf", "initViews", "isShowing", "onBackPressed", "onInterceptTouchEvent", "setBackgroundResource", "resid", "show", "showAnim", "Companion", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public class TGRightDrawerView
  extends FrameLayout
{
  public static final TGRightDrawerView.Companion b = new TGRightDrawerView.Companion(null);
  private int a;
  private float c;
  private float d;
  private long e;
  private float f;
  private float g;
  private boolean h;
  private ArrayList<ViewStateChangeListener> i;
  private boolean j;
  private HashMap k;
  
  @JvmOverloads
  public TGRightDrawerView(@NotNull Context paramContext)
  {
    this(paramContext, null, 0, false, 14, null);
  }
  
  @JvmOverloads
  public TGRightDrawerView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0, false, 12, null);
  }
  
  @JvmOverloads
  public TGRightDrawerView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    this(paramContext, paramAttributeSet, paramInt, false, 8, null);
  }
  
  @JvmOverloads
  public TGRightDrawerView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt, boolean paramBoolean)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.j = paramBoolean;
    this.a = 2;
    this.i = new ArrayList();
    View.inflate(paramContext, 2131629523, (ViewGroup)this);
    setBackgroundResource(2131168376);
    d();
  }
  
  private final void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt)
  {
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat((FrameLayout)a(2131431334), "translationX", new float[] { paramFloat1, paramFloat2 });
    int m = UITools.a(getContext());
    float f1 = Math.abs(paramFloat2 - paramFloat1) / m;
    long l = ((float)500L * f1);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("doAnim fromTranX:");
    ((StringBuilder)localObject).append(paramFloat1);
    ((StringBuilder)localObject).append(", targetTranX:");
    ((StringBuilder)localObject).append(paramFloat2);
    ((StringBuilder)localObject).append(", durationFactor:");
    ((StringBuilder)localObject).append(f1);
    ((StringBuilder)localObject).append(", screenWith:");
    ((StringBuilder)localObject).append(m);
    Logger.a("TGRightDrawerView", ((StringBuilder)localObject).toString());
    Intrinsics.checkExpressionValueIsNotNull(localObjectAnimator, "transAnim");
    localObjectAnimator.setDuration(l);
    localObjectAnimator.addListener((Animator.AnimatorListener)new TGRightDrawerView.doAnim.1(this, paramInt));
    localObject = ObjectAnimator.ofFloat(a(2131445743), "alpha", new float[] { paramFloat3, paramFloat4 });
    Intrinsics.checkExpressionValueIsNotNull(localObject, "alphaAnim");
    ((ObjectAnimator)localObject).setDuration(500L);
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.play((Animator)localObjectAnimator);
    localAnimatorSet.play((Animator)localObject);
    localAnimatorSet.start();
  }
  
  private final boolean a(MotionEvent paramMotionEvent)
  {
    long l = System.currentTimeMillis() - this.e;
    float f1 = paramMotionEvent.getRawX() - this.c;
    float f2 = paramMotionEvent.getRawY() - this.d;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("distanceX:");
    localStringBuilder.append(f1);
    localStringBuilder.append(", duration:");
    localStringBuilder.append(l);
    localStringBuilder.append(", motionEvent.action=");
    localStringBuilder.append(paramMotionEvent.getAction());
    Logger.a("TGRightDrawerView", localStringBuilder.toString());
    boolean bool1;
    if ((l <= 200L) && ((float)50L < f1)) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    boolean bool2;
    if ((l > 200L) && (f1 >= (float)300L)) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    paramMotionEvent = new StringBuilder();
    paramMotionEvent.append("shortSlide:");
    paramMotionEvent.append(bool1);
    paramMotionEvent.append(", slideEnoughDistance:");
    paramMotionEvent.append(bool2);
    Logger.a("TGRightDrawerView", paramMotionEvent.toString());
    if (f2 == 0.0F)
    {
      if (f1 <= 0) {}
    }
    else {
      while ((f1 > 0) && (f1 / Math.abs(f2) > 1.3F))
      {
        m = 1;
        break;
      }
    }
    int m = 0;
    if ((m != 0) && ((bool1) || (bool2)))
    {
      a(0.0F, UITools.a(getContext()), 1.0F, 0.0F, 2);
      return true;
    }
    if (f1 != 0.0F)
    {
      if (this.j)
      {
        a(this.f, 0.0F, this.g, 1.0F, 1);
        return false;
      }
    }
    else {
      Logger.a("TGRightDrawerView", "distanceX is 0, do nothing!");
    }
    return false;
  }
  
  private final void b(MotionEvent paramMotionEvent)
  {
    float f3 = paramMotionEvent.getRawX() - this.c;
    float f4 = 0;
    float f2 = 0.0F;
    float f1 = f3;
    if (f3 < f4) {
      f1 = 0.0F;
    }
    this.f = f1;
    paramMotionEvent = (FrameLayout)a(2131431334);
    Intrinsics.checkExpressionValueIsNotNull(paramMotionEvent, "contentRootView");
    paramMotionEvent.setTranslationX(this.f);
    f1 = this.f / UITools.a(getContext());
    f3 = 1;
    if (f1 < f4) {
      f1 = f2;
    } else if (f1 > f3) {
      f1 = 1.0F;
    }
    this.g = (f3 - f1);
    paramMotionEvent = a(2131445743);
    Intrinsics.checkExpressionValueIsNotNull(paramMotionEvent, "shadowView");
    paramMotionEvent.setAlpha(this.g);
  }
  
  private final void d()
  {
    a(2131445743).setOnClickListener((View.OnClickListener)new TGRightDrawerView.initViews.1(this));
    a(2131445743).setOnLongClickListener((View.OnLongClickListener)TGRightDrawerView.initViews.2.a);
    ((FrameLayout)a(2131431334)).setPadding(0, ImmersiveUtils.getStatusBarHeight(getContext()), 0, 0);
    ((FrameLayout)a(2131431334)).setOnClickListener((View.OnClickListener)TGRightDrawerView.initViews.3.a);
  }
  
  private final void e()
  {
    Logger.a("TGRightDrawerView", "showAnim");
    setVisibility(0);
    this.h = true;
    View localView = a(2131445743);
    Intrinsics.checkExpressionValueIsNotNull(localView, "shadowView");
    localView.setAlpha(0.0F);
    post((Runnable)new TGRightDrawerView.showAnim.1(this));
  }
  
  private final void f()
  {
    this.h = true;
    post((Runnable)new TGRightDrawerView.hideAnim.1(this));
  }
  
  private final void g()
  {
    Logger.a("TGRightDrawerView", "hideSelf");
    setVisibility(8);
    this.a = 2;
    Object localObject = (FrameLayout)a(2131431334);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "contentRootView");
    int m = ((FrameLayout)localObject).getWidth();
    localObject = (FrameLayout)a(2131431334);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "contentRootView");
    ((FrameLayout)localObject).setTranslationX(m);
    localObject = a(2131445743);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "shadowView");
    ((View)localObject).setAlpha(0.0F);
  }
  
  public View a(int paramInt)
  {
    if (this.k == null) {
      this.k = new HashMap();
    }
    View localView2 = (View)this.k.get(Integer.valueOf(paramInt));
    View localView1 = localView2;
    if (localView2 == null)
    {
      localView1 = findViewById(paramInt);
      this.k.put(Integer.valueOf(paramInt), localView1);
    }
    return localView1;
  }
  
  public final void a(@NotNull View paramView, @NotNull FrameLayout.LayoutParams paramLayoutParams)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "content");
    Intrinsics.checkParameterIsNotNull(paramLayoutParams, "layoutParams");
    ((FrameLayout)a(2131431334)).removeAllViews();
    ((FrameLayout)a(2131431334)).addView(paramView, (ViewGroup.LayoutParams)paramLayoutParams);
  }
  
  public final void a(@NotNull ViewStateChangeListener paramViewStateChangeListener)
  {
    Intrinsics.checkParameterIsNotNull(paramViewStateChangeListener, "l");
    this.i.add(paramViewStateChangeListener);
  }
  
  public final boolean a()
  {
    return this.a == 1;
  }
  
  public final void b()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("show mState=");
    ((StringBuilder)localObject).append(this.a);
    Logger.a("TGRightDrawerView", ((StringBuilder)localObject).toString());
    if (this.a == 1) {
      return;
    }
    this.a = 1;
    e();
    localObject = this.i.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((ViewStateChangeListener)((Iterator)localObject).next()).a((View)this);
    }
  }
  
  public final void c()
  {
    if (this.a == 2) {
      return;
    }
    this.a = 2;
    f();
    Iterator localIterator = this.i.iterator();
    while (localIterator.hasNext()) {
      ((ViewStateChangeListener)localIterator.next()).b((View)this);
    }
  }
  
  public final int getState()
  {
    return this.a;
  }
  
  public boolean onInterceptTouchEvent(@NotNull MotionEvent paramMotionEvent)
  {
    Intrinsics.checkParameterIsNotNull(paramMotionEvent, "motionEvent");
    if (this.h)
    {
      Logger.a("TGRightDrawerView", "onInterceptTouchEvent give up, mOnAnimation is true");
      return super.onInterceptTouchEvent(paramMotionEvent);
    }
    int m = paramMotionEvent.getAction();
    if (m != 0)
    {
      if (m != 1) {
        if (m != 2)
        {
          if (m != 3) {
            break label251;
          }
        }
        else
        {
          if ((!this.j) || (this.e <= 0L) || (this.c <= 0)) {
            break label251;
          }
          b(paramMotionEvent);
          break label251;
        }
      }
      if ((this.e > 0L) && (this.c > 0) && (a(paramMotionEvent))) {
        return true;
      }
    }
    else
    {
      Rect localRect = new Rect();
      ((FrameLayout)a(2131431334)).getGlobalVisibleRect(localRect);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("pos.left=");
      localStringBuilder.append(localRect.left);
      localStringBuilder.append(", rawX=");
      localStringBuilder.append(paramMotionEvent.getRawX());
      Logger.a("TGRightDrawerView", localStringBuilder.toString());
      if (paramMotionEvent.getRawX() < localRect.left)
      {
        this.e = 0L;
        this.c = 0.0F;
        this.d = 0.0F;
      }
      else
      {
        this.e = System.currentTimeMillis();
        this.c = paramMotionEvent.getRawX();
        this.d = paramMotionEvent.getRawY();
      }
    }
    label251:
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  public final void setBackgroundResource(int paramInt)
  {
    super.setBackgroundResource(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.ui.widget.TGRightDrawerView
 * JD-Core Version:    0.7.0.1
 */