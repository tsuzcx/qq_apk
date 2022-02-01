package com.tencent.xaction.trigger;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import com.tencent.xaction.api.IDecorView;
import com.tencent.xaction.api.IView;
import com.tencent.xaction.api.data.ViewData;
import com.tencent.xaction.impl.XAEngine;
import com.tencent.xaction.interpolator.SpringInterpolator;
import com.tencent.xaction.trigger.touch.TouchEventHelper;
import com.tencent.xaction.trigger.touch.VelocityTrackerHelper;
import com.tencent.xaction.trigger.touch.VelocityTrackerHelper.ScrollCallback;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/xaction/trigger/CardFlipTrigger;", "Lcom/tencent/xaction/trigger/BaseTrigger;", "()V", "backCardView", "Landroid/view/View;", "cameraDis", "", "getCameraDis", "()F", "setCameraDis", "(F)V", "flipBackId", "", "getFlipBackId", "()I", "setFlipBackId", "(I)V", "flipDir", "", "getFlipDir", "()Ljava/lang/String;", "setFlipDir", "(Ljava/lang/String;)V", "flipFrontId", "getFlipFrontId", "setFlipFrontId", "frontCardView", "isFling", "", "lastX", "lastY", "springAnimator", "Landroid/animation/Animator;", "velocityTrackerHelper", "Lcom/tencent/xaction/trigger/touch/VelocityTrackerHelper;", "vts", "getVts", "setVts", "actionUp", "", "flip", "isXDir", "distance", "monitor", "data", "Lcom/tencent/xaction/api/data/ViewData;", "iview", "Lcom/tencent/xaction/api/IView;", "onTouch", "view", "motionEvent", "Landroid/view/MotionEvent;", "springFlip", "Companion", "XActionCore_release"}, k=1, mv={1, 1, 16})
public final class CardFlipTrigger
  extends BaseTrigger
{
  public static final CardFlipTrigger.Companion a;
  private static final float e;
  private float jdField_a_of_type_Float = e;
  private int jdField_a_of_type_Int;
  private transient Animator jdField_a_of_type_AndroidAnimationAnimator;
  private transient View jdField_a_of_type_AndroidViewView;
  private transient VelocityTrackerHelper jdField_a_of_type_ComTencentXactionTriggerTouchVelocityTrackerHelper;
  @NotNull
  private String jdField_a_of_type_JavaLangString = "x";
  private transient boolean jdField_a_of_type_Boolean;
  private float jdField_b_of_type_Float = -1.0F;
  private int jdField_b_of_type_Int;
  private transient View jdField_b_of_type_AndroidViewView;
  private transient float c;
  private transient float d;
  
  static
  {
    jdField_a_of_type_ComTencentXactionTriggerCardFlipTrigger$Companion = new CardFlipTrigger.Companion(null);
    float f = 16000;
    Resources localResources = Resources.getSystem();
    Intrinsics.checkExpressionValueIsNotNull(localResources, "Resources.getSystem()");
    e = f * localResources.getDisplayMetrics().density;
  }
  
  private final void a()
  {
    if (this.jdField_b_of_type_Float > 0)
    {
      VelocityTrackerHelper localVelocityTrackerHelper = this.jdField_a_of_type_ComTencentXactionTriggerTouchVelocityTrackerHelper;
      if (localVelocityTrackerHelper == null) {
        Intrinsics.throwUninitializedPropertyAccessException("velocityTrackerHelper");
      }
      VelocityTrackerHelper.a(localVelocityTrackerHelper, (VelocityTrackerHelper.ScrollCallback)new CardFlipTrigger.actionUp.1(this), 0, 0, this.jdField_b_of_type_Float, 6, null);
      return;
    }
    b();
  }
  
  private final void a(boolean paramBoolean, float paramFloat)
  {
    View localView1 = this.jdField_a_of_type_AndroidViewView;
    if (localView1 == null) {
      Intrinsics.throwNpe();
    }
    View localView2 = this.jdField_b_of_type_AndroidViewView;
    if (localView2 == null) {
      Intrinsics.throwNpe();
    }
    if (paramBoolean) {
      f1 = localView1.getRotationX();
    } else {
      f1 = localView1.getRotationY();
    }
    float f2 = 360;
    paramFloat = (f1 - paramFloat) % f2;
    float f1 = Math.abs(paramFloat);
    if (((f1 >= 0) && (f1 < 90)) || ((f1 > 270) && (f1 <= f2)))
    {
      localView1.setVisibility(0);
      localView2.setVisibility(8);
    }
    else
    {
      localView1.setVisibility(8);
      localView2.setVisibility(0);
    }
    f1 = ('´' + paramFloat) % f2;
    if (paramBoolean)
    {
      localView1.setRotationX(paramFloat);
      localView2.setRotationX(f1);
      return;
    }
    localView1.setRotationY(paramFloat);
    localView2.setRotationY(f1);
  }
  
  private final boolean a(View paramView, MotionEvent paramMotionEvent)
  {
    if ((this.jdField_a_of_type_AndroidViewView == null) || (this.jdField_b_of_type_AndroidViewView == null))
    {
      paramView = getEngine();
      localView = null;
      if (paramView != null)
      {
        paramView = paramView.findById(this.jdField_a_of_type_Int);
        if (paramView != null)
        {
          paramView = paramView.getDecor();
          if (paramView != null)
          {
            paramView = paramView.getProxy();
            break label62;
          }
        }
      }
      paramView = null;
      label62:
      this.jdField_a_of_type_AndroidViewView = paramView;
      Object localObject = getEngine();
      paramView = localView;
      if (localObject != null)
      {
        localObject = ((XAEngine)localObject).findById(this.jdField_b_of_type_Int);
        paramView = localView;
        if (localObject != null)
        {
          localObject = ((IView)localObject).getDecor();
          paramView = localView;
          if (localObject != null) {
            paramView = ((IDecorView)localObject).getProxy();
          }
        }
      }
      this.jdField_b_of_type_AndroidViewView = paramView;
    }
    paramView = this.jdField_a_of_type_AndroidViewView;
    View localView = this.jdField_b_of_type_AndroidViewView;
    if (paramView != null)
    {
      if (localView == null) {
        return false;
      }
      paramView.setCameraDistance(this.jdField_a_of_type_Float);
      localView.setCameraDistance(this.jdField_a_of_type_Float);
      if (this.jdField_b_of_type_Float > 0.0F)
      {
        paramView = this.jdField_a_of_type_ComTencentXactionTriggerTouchVelocityTrackerHelper;
        if (paramView == null) {
          Intrinsics.throwUninitializedPropertyAccessException("velocityTrackerHelper");
        }
        paramView.a(paramMotionEvent);
      }
      float f1 = paramMotionEvent.getX();
      float f2 = paramMotionEvent.getY();
      int i = paramMotionEvent.getAction();
      if (i != 0)
      {
        if (i != 1)
        {
          if (i != 2) {
            return true;
          }
          f1 = paramMotionEvent.getX();
          f2 = this.c;
          float f3 = paramMotionEvent.getY();
          float f4 = this.d;
          if (Intrinsics.areEqual(this.jdField_a_of_type_JavaLangString, "x")) {
            a(true, f3 - f4);
          } else if (Intrinsics.areEqual(this.jdField_a_of_type_JavaLangString, "y")) {
            a(false, f1 - f2);
          }
          this.c = paramMotionEvent.getX();
          this.d = paramMotionEvent.getY();
          return true;
        }
        a();
        return true;
      }
      this.c = f1;
      this.d = f2;
      paramView = this.jdField_a_of_type_AndroidAnimationAnimator;
      if (paramView != null) {
        paramView.cancel();
      }
      if (this.jdField_b_of_type_Float > 0.0F)
      {
        paramView = this.jdField_a_of_type_ComTencentXactionTriggerTouchVelocityTrackerHelper;
        if (paramView == null) {
          Intrinsics.throwUninitializedPropertyAccessException("velocityTrackerHelper");
        }
        paramView.a();
      }
      return true;
    }
    return false;
  }
  
  private final void b()
  {
    Object localObject = this.jdField_a_of_type_AndroidViewView;
    if (localObject == null) {
      Intrinsics.throwNpe();
    }
    float f2 = ((View)localObject).getRotationX();
    localObject = this.jdField_a_of_type_AndroidViewView;
    if (localObject == null) {
      Intrinsics.throwNpe();
    }
    float f1 = ((View)localObject).getRotationY();
    boolean bool = Intrinsics.areEqual(this.jdField_a_of_type_JavaLangString, "x");
    if (!bool) {
      f2 = f1;
    }
    f1 = Math.abs(f2);
    float f3 = 0;
    if ((f1 >= f3) && (f1 < 90)) {
      f1 = 0.0F;
    } else if (((f1 >= 90) && (f1 < '´')) || ((f1 >= '´') && (f1 < 270)))
    {
      if (f2 < f3) {
        f1 = -180.0F;
      } else {
        f1 = 180.0F;
      }
    }
    else if (f2 < f3) {
      f1 = -360.0F;
    } else {
      f1 = 360.0F;
    }
    localObject = ValueAnimator.ofFloat(new float[] { f2, f1 });
    Intrinsics.checkExpressionValueIsNotNull(localObject, "animator");
    ((ValueAnimator)localObject).setDuration(2000L);
    SpringInterpolator localSpringInterpolator = new SpringInterpolator();
    localSpringInterpolator.a(0.2F);
    ((ValueAnimator)localObject).setInterpolator((TimeInterpolator)localSpringInterpolator);
    ((ValueAnimator)localObject).addUpdateListener((ValueAnimator.AnimatorUpdateListener)new CardFlipTrigger.springFlip.2(this, bool));
    ((ValueAnimator)localObject).start();
    this.jdField_a_of_type_AndroidAnimationAnimator = ((Animator)localObject);
  }
  
  @NotNull
  public final String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  public void monitor(@NotNull ViewData paramViewData, @NotNull IView paramIView)
  {
    Intrinsics.checkParameterIsNotNull(paramViewData, "data");
    Intrinsics.checkParameterIsNotNull(paramIView, "iview");
    super.monitor(paramViewData, paramIView);
    paramViewData = paramIView.getDecor().getProxy();
    if (paramViewData == null) {
      Intrinsics.throwNpe();
    }
    paramIView = paramViewData.getContext();
    Intrinsics.checkExpressionValueIsNotNull(paramIView, "view.context");
    this.jdField_a_of_type_ComTencentXactionTriggerTouchVelocityTrackerHelper = new VelocityTrackerHelper(paramIView, (Interpolator)new DecelerateInterpolator());
    TouchEventHelper.a.a(paramViewData, (View.OnTouchListener)new CardFlipTrigger.monitor.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.xaction.trigger.CardFlipTrigger
 * JD-Core Version:    0.7.0.1
 */