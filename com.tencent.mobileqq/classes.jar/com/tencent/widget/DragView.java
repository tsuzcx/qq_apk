package com.tencent.widget;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.ThrowablesUtils;
import java.util.ArrayList;

public class DragView
  extends RelativeLayout
  implements Animator.AnimatorListener, ValueAnimator.AnimatorUpdateListener, GestureDetector.OnGestureListener
{
  public static final String TAG = "DragView";
  private float alphaOffset = 0.0F;
  private View curView;
  private float downX = 0.0F;
  private float downY = 0.0F;
  private boolean enableDrag = true;
  private boolean firstDown = false;
  private boolean isInAnimation = false;
  private DragView.OnDragChangeListener mDragChangeListener;
  public boolean mFinishAnimation = false;
  private DragView.OnGestureChangeListener mGestureChangeListener = null;
  private GestureDetector mGestureDetector = new GestureDetector(paramContext, this);
  private float mScrollDisX = 0.0F;
  private float mScrollDisY = 0.0F;
  private Rect originRect = null;
  private AnimatorSet quitAnim;
  private boolean ratioModify = false;
  private AnimatorSet releaseAnim;
  private float scale = 0.0F;
  private float scaleThreshold = 0.25F;
  
  public DragView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public DragView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void onContentMove(float paramFloat)
  {
    DragView.OnGestureChangeListener localOnGestureChangeListener = this.mGestureChangeListener;
    if (localOnGestureChangeListener != null) {
      localOnGestureChangeListener.onContentMove(paramFloat);
    }
  }
  
  private void onUP(MotionEvent paramMotionEvent)
  {
    this.releaseAnim.setupStartValues();
    this.releaseAnim.start();
  }
  
  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    if (this.curView != null) {
      return;
    }
    super.addView(paramView, paramInt, paramLayoutParams);
    this.curView = paramView;
    paramView = ObjectAnimator.ofFloat(this.curView, "translationX", new float[] { 0.0F });
    paramLayoutParams = ObjectAnimator.ofFloat(this.curView, "translationY", new float[] { 0.0F });
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(this.curView, "scaleX", new float[] { 1.0F });
    ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(this.curView, "scaleY", new float[] { 1.0F });
    this.releaseAnim = new AnimatorSet();
    this.releaseAnim.playTogether(new Animator[] { paramView, paramLayoutParams, localObjectAnimator1, localObjectAnimator2 });
    localObjectAnimator2.addUpdateListener(this);
    this.releaseAnim.addListener(this);
    paramView = ObjectAnimator.ofFloat(this.curView, "translationX", new float[] { 0.0F });
    paramLayoutParams = ObjectAnimator.ofFloat(this.curView, "translationY", new float[] { 0.0F });
    localObjectAnimator1 = ObjectAnimator.ofFloat(this.curView, "scaleX", new float[] { 0.0F });
    localObjectAnimator2 = ObjectAnimator.ofFloat(this.curView, "scaleY", new float[] { 0.0F });
    this.quitAnim = new AnimatorSet();
    this.quitAnim.playTogether(new Animator[] { paramView, paramLayoutParams, localObjectAnimator1, localObjectAnimator2 });
    localObjectAnimator2.addUpdateListener(this);
    this.quitAnim.addListener(this);
  }
  
  public void init()
  {
    this.curView.setScaleX(1.0F);
    this.curView.setScaleY(1.0F);
    this.curView.setTranslationX(0.0F);
    this.curView.setTranslationY(0.0F);
    this.mFinishAnimation = false;
  }
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.isInAnimation = false;
    if (paramAnimator == this.quitAnim)
    {
      this.mFinishAnimation = true;
      paramAnimator = this.mGestureChangeListener;
      if (paramAnimator != null) {
        paramAnimator.onGestureFinish();
      }
    }
    else if (paramAnimator == this.releaseAnim)
    {
      paramAnimator = this.mGestureChangeListener;
      if (paramAnimator != null) {
        paramAnimator.onResetPosition();
      }
    }
  }
  
  public void onAnimationEnd(Animator paramAnimator, boolean paramBoolean)
  {
    this.isInAnimation = false;
    onAnimationEnd(paramAnimator);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    this.isInAnimation = true;
  }
  
  public void onAnimationStart(Animator paramAnimator, boolean paramBoolean)
  {
    this.isInAnimation = true;
  }
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    Float localFloat2 = (Float)paramValueAnimator.getAnimatedValue();
    Float localFloat1 = localFloat2;
    if (this.quitAnim.getChildAnimations().contains(paramValueAnimator))
    {
      paramValueAnimator = this.originRect;
      float f;
      int i;
      if (paramValueAnimator == null)
      {
        f = getHeight();
        i = this.curView.getHeight();
      }
      else
      {
        f = paramValueAnimator.bottom - this.originRect.top;
        i = this.curView.getHeight();
      }
      paramValueAnimator = Float.valueOf(f / i / localFloat2.floatValue());
      if (paramValueAnimator.floatValue() > 1.0F) {
        f = 1.0F;
      } else {
        f = paramValueAnimator.floatValue();
      }
      localFloat1 = Float.valueOf(1.0F - Float.valueOf(f).floatValue());
    }
    if (QLog.isColorLevel())
    {
      paramValueAnimator = new StringBuilder();
      paramValueAnimator.append("onAnimationUpdate : ");
      paramValueAnimator.append(localFloat1);
      QLog.d("DragView", 2, paramValueAnimator.toString());
    }
    onContentMove(localFloat1.floatValue() - this.alphaOffset);
  }
  
  public boolean onDown(MotionEvent paramMotionEvent)
  {
    this.mScrollDisY = 0.0F;
    this.mScrollDisX = 0.0F;
    this.downX = paramMotionEvent.getX();
    this.downY = paramMotionEvent.getY();
    this.scale = 1.0F;
    return false;
  }
  
  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if (this.curView == null) {
      return false;
    }
    paramMotionEvent1 = this.quitAnim.getChildAnimations();
    if ((this.originRect != null) && (this.curView != null) && (paramMotionEvent1 != null) && (paramMotionEvent1.size() == 4))
    {
      int k = this.curView.getWidth();
      int m = this.curView.getHeight();
      paramMotionEvent2 = this.mDragChangeListener;
      int j = m;
      int i = k;
      if (paramMotionEvent2 != null)
      {
        paramMotionEvent2 = paramMotionEvent2.onModifyCurViewSize();
        j = m;
        i = k;
        if (paramMotionEvent2 != null)
        {
          i = paramMotionEvent2[0];
          j = paramMotionEvent2[1];
        }
      }
      paramMotionEvent2 = new Rect(this.originRect);
      if (this.ratioModify)
      {
        paramFloat1 = i / j;
        try
        {
          paramFloat2 = this.originRect.width() / this.originRect.height();
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("sonRatio : ");
            localStringBuilder.append(paramFloat2);
            localStringBuilder.append("  parentRatio : ");
            localStringBuilder.append(paramFloat1);
            localStringBuilder.append(" getWidth() : ");
            localStringBuilder.append(getWidth());
            localStringBuilder.append(" getHeight() : ");
            localStringBuilder.append(getHeight());
            localStringBuilder.append(" oriHeight :");
            localStringBuilder.append(this.originRect.height());
            localStringBuilder.append(" oriWidth : ");
            localStringBuilder.append(this.originRect.width());
            QLog.d("DragView", 2, localStringBuilder.toString());
          }
          if (paramFloat2 < paramFloat1)
          {
            k = (int)(this.originRect.height() * paramFloat1 - this.originRect.width()) / 2;
            paramMotionEvent2.left -= k;
            paramMotionEvent2.right += k;
          }
          else if (paramFloat2 > paramFloat1)
          {
            k = (int)(this.originRect.width() / paramFloat1 - this.originRect.height()) / 2;
            paramMotionEvent2.top -= k;
            paramMotionEvent2.bottom += k;
          }
        }
        catch (Exception localException)
        {
          if (QLog.isColorLevel()) {
            QLog.d("DragView", 2, ThrowablesUtils.a(localException));
          }
        }
      }
      paramFloat1 = (paramMotionEvent2.left + paramMotionEvent2.right) / 2 - getWidth() / 2;
      paramFloat2 = (paramMotionEvent2.top + paramMotionEvent2.bottom) / 2 - getHeight() / 2;
      float f1 = (paramMotionEvent2.right - paramMotionEvent2.left) / i;
      float f2 = (paramMotionEvent2.bottom - paramMotionEvent2.top) / j;
      ((ObjectAnimator)paramMotionEvent1.get(0)).setFloatValues(new float[] { paramFloat1 });
      ((ObjectAnimator)paramMotionEvent1.get(1)).setFloatValues(new float[] { paramFloat2 });
      ((ObjectAnimator)paramMotionEvent1.get(2)).setFloatValues(new float[] { f1 });
      ((ObjectAnimator)paramMotionEvent1.get(3)).setFloatValues(new float[] { f2 });
      paramMotionEvent1 = this.curView;
      paramMotionEvent1.setPivotX(paramMotionEvent1.getWidth() / 2);
      paramMotionEvent1 = this.curView;
      paramMotionEvent1.setPivotY(paramMotionEvent1.getHeight() / 2);
    }
    else
    {
      this.curView.setPivotX(getWidth() / 2);
      this.curView.setPivotY(getHeight() / 2);
    }
    this.quitAnim.setupStartValues();
    this.quitAnim.start();
    return true;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!this.enableDrag) {
      return false;
    }
    if (paramMotionEvent.getAction() != 0) {
      return true;
    }
    this.mGestureDetector.onTouchEvent(paramMotionEvent);
    return false;
  }
  
  public void onLongPress(MotionEvent paramMotionEvent) {}
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if (this.curView == null) {
      return false;
    }
    this.mScrollDisX -= paramFloat1;
    this.mScrollDisY -= paramFloat2;
    paramFloat2 = this.mScrollDisY;
    paramFloat1 = paramFloat2;
    if (paramFloat2 < 0.0F) {
      paramFloat1 = 0.0F;
    }
    float f1 = 1.0F - paramFloat1 / getHeight();
    paramMotionEvent1 = this.curView;
    paramMotionEvent1.setPivotX(this.downX - paramMotionEvent1.getLeft());
    paramMotionEvent1 = this.curView;
    paramMotionEvent1.setPivotY(this.downY - paramMotionEvent1.getTop());
    float f2 = this.scaleThreshold;
    paramFloat2 = f2;
    if (f1 > f2) {
      paramFloat2 = f1;
    }
    this.scale = paramFloat2;
    this.curView.setScaleX(this.scale);
    this.curView.setScaleY(this.scale);
    this.curView.setTranslationX(this.mScrollDisX);
    this.curView.setTranslationY(paramFloat1);
    onContentMove(f1 - this.alphaOffset);
    return false;
  }
  
  public void onShowPress(MotionEvent paramMotionEvent) {}
  
  public boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    paramMotionEvent = this.mGestureChangeListener;
    if (paramMotionEvent != null) {
      paramMotionEvent.onClickDragView();
    }
    return true;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = this.isInAnimation;
    int i = 0;
    if (bool) {
      return false;
    }
    int j = paramMotionEvent.getAction();
    if (j == 0)
    {
      this.firstDown = true;
    }
    else if (j == 1)
    {
      this.firstDown = false;
    }
    else if ((j == 2) && (!this.firstDown))
    {
      MotionEvent localMotionEvent = MotionEvent.obtain(paramMotionEvent);
      localMotionEvent.setAction(0);
      this.mGestureDetector.onTouchEvent(localMotionEvent);
      this.firstDown = true;
    }
    if (paramMotionEvent.getAction() == 1) {
      i = 1;
    }
    if ((!this.mGestureDetector.onTouchEvent(paramMotionEvent)) && (i != 0)) {
      onUP(paramMotionEvent);
    }
    return true;
  }
  
  public void setDragChangeListener(DragView.OnDragChangeListener paramOnDragChangeListener)
  {
    this.mDragChangeListener = paramOnDragChangeListener;
  }
  
  public void setEnableDrag(boolean paramBoolean)
  {
    this.enableDrag = paramBoolean;
  }
  
  public void setGestureChangeListener(DragView.OnGestureChangeListener paramOnGestureChangeListener)
  {
    this.mGestureChangeListener = paramOnGestureChangeListener;
  }
  
  public void setOriginRect(Rect paramRect)
  {
    this.originRect = paramRect;
  }
  
  public void setRatioModify(boolean paramBoolean)
  {
    this.ratioModify = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.widget.DragView
 * JD-Core Version:    0.7.0.1
 */