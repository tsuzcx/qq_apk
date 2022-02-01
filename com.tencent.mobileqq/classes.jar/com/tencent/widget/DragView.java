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
    if (this.mGestureChangeListener != null) {
      this.mGestureChangeListener.onContentMove(paramFloat);
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
      if (this.mGestureChangeListener != null) {
        this.mGestureChangeListener.onGestureFinish();
      }
    }
    while ((paramAnimator != this.releaseAnim) || (this.mGestureChangeListener == null)) {
      return;
    }
    this.mGestureChangeListener.onResetPosition();
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    this.isInAnimation = true;
  }
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    Float localFloat2 = (Float)paramValueAnimator.getAnimatedValue();
    Float localFloat1 = localFloat2;
    if (this.quitAnim.getChildAnimations().contains(paramValueAnimator))
    {
      if (this.originRect != null) {
        break label128;
      }
      f = getHeight() / this.curView.getHeight();
      paramValueAnimator = Float.valueOf(f / localFloat2.floatValue());
      if (paramValueAnimator.floatValue() <= 1.0F) {
        break label157;
      }
    }
    label128:
    label157:
    for (float f = 1.0F;; f = paramValueAnimator.floatValue())
    {
      localFloat1 = Float.valueOf(1.0F - Float.valueOf(f).floatValue());
      if (QLog.isColorLevel()) {
        QLog.d("DragView", 2, "onAnimationUpdate : " + localFloat1);
      }
      onContentMove(localFloat1.floatValue() - this.alphaOffset);
      return;
      f = (this.originRect.bottom - this.originRect.top) / this.curView.getHeight();
      break;
    }
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
    int k;
    if ((this.originRect != null) && (this.curView != null) && (paramMotionEvent1 != null) && (paramMotionEvent1.size() == 4))
    {
      k = this.curView.getWidth();
      int m = this.curView.getHeight();
      int j = m;
      int i = k;
      if (this.mDragChangeListener != null)
      {
        paramMotionEvent2 = this.mDragChangeListener.onModifyCurViewSize();
        j = m;
        i = k;
        if (paramMotionEvent2 != null)
        {
          i = paramMotionEvent2[0];
          j = paramMotionEvent2[1];
        }
      }
      paramMotionEvent2 = new Rect(this.originRect);
      if (this.ratioModify) {
        paramFloat1 = i / j;
      }
      try
      {
        paramFloat2 = this.originRect.width() / this.originRect.height();
        if (QLog.isColorLevel()) {
          QLog.d("DragView", 2, "sonRatio : " + paramFloat2 + "  parentRatio : " + paramFloat1 + " getWidth() : " + getWidth() + " getHeight() : " + getHeight() + " oriHeight :" + this.originRect.height() + " oriWidth : " + this.originRect.width());
        }
        if (paramFloat2 >= paramFloat1) {
          break label506;
        }
        k = (int)(paramFloat1 * this.originRect.height() - this.originRect.width()) / 2;
        paramMotionEvent2.left -= k;
        paramMotionEvent2.right = (k + paramMotionEvent2.right);
      }
      catch (Exception localException)
      {
        for (;;)
        {
          float f1;
          float f2;
          if (QLog.isColorLevel()) {
            QLog.d("DragView", 2, ThrowablesUtils.a(localException));
          }
        }
      }
      paramFloat1 = (paramMotionEvent2.left + paramMotionEvent2.right) / 2 - getWidth() / 2;
      paramFloat2 = (paramMotionEvent2.top + paramMotionEvent2.bottom) / 2 - getHeight() / 2;
      f1 = (paramMotionEvent2.right - paramMotionEvent2.left) / i;
      f2 = (paramMotionEvent2.bottom - paramMotionEvent2.top) / j;
      ((ObjectAnimator)paramMotionEvent1.get(0)).setFloatValues(new float[] { paramFloat1 });
      ((ObjectAnimator)paramMotionEvent1.get(1)).setFloatValues(new float[] { paramFloat2 });
      ((ObjectAnimator)paramMotionEvent1.get(2)).setFloatValues(new float[] { f1 });
      ((ObjectAnimator)paramMotionEvent1.get(3)).setFloatValues(new float[] { f2 });
      this.curView.setPivotX(this.curView.getWidth() / 2);
      this.curView.setPivotY(this.curView.getHeight() / 2);
    }
    for (;;)
    {
      this.quitAnim.setupStartValues();
      this.quitAnim.start();
      return true;
      label506:
      if (paramFloat2 <= paramFloat1) {
        break;
      }
      k = (int)(this.originRect.width() / paramFloat1 - this.originRect.height()) / 2;
      paramMotionEvent2.top -= k;
      paramMotionEvent2.bottom = (k + paramMotionEvent2.bottom);
      break;
      this.curView.setPivotX(getWidth() / 2);
      this.curView.setPivotY(getHeight() / 2);
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!this.enableDrag) {
      return false;
    }
    switch (paramMotionEvent.getAction())
    {
    default: 
      return true;
    }
    this.mGestureDetector.onTouchEvent(paramMotionEvent);
    return false;
  }
  
  public void onLongPress(MotionEvent paramMotionEvent) {}
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    float f = 0.0F;
    if (this.curView == null) {
      return false;
    }
    this.mScrollDisX -= paramFloat1;
    this.mScrollDisY -= paramFloat2;
    if (this.mScrollDisY < 0.0F)
    {
      paramFloat1 = f;
      f = 1.0F - paramFloat1 / getHeight();
      this.curView.setPivotX(this.downX - this.curView.getLeft());
      this.curView.setPivotY(this.downY - this.curView.getTop());
      if (f <= this.scaleThreshold) {
        break label178;
      }
    }
    label178:
    for (paramFloat2 = f;; paramFloat2 = this.scaleThreshold)
    {
      this.scale = paramFloat2;
      this.curView.setScaleX(this.scale);
      this.curView.setScaleY(this.scale);
      this.curView.setTranslationX(this.mScrollDisX);
      this.curView.setTranslationY(paramFloat1);
      onContentMove(f - this.alphaOffset);
      return false;
      paramFloat1 = this.mScrollDisY;
      break;
    }
  }
  
  public void onShowPress(MotionEvent paramMotionEvent) {}
  
  public boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    if (this.mGestureChangeListener != null) {
      this.mGestureChangeListener.onClickDragView();
    }
    return true;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = 0;
    if (this.isInAnimation) {
      return false;
    }
    int j = paramMotionEvent.getAction();
    if (j == 0) {
      this.firstDown = true;
    }
    for (;;)
    {
      if (paramMotionEvent.getAction() == 1) {
        i = 1;
      }
      if ((!this.mGestureDetector.onTouchEvent(paramMotionEvent)) && (i != 0)) {
        onUP(paramMotionEvent);
      }
      return true;
      if (j == 1)
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
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.widget.DragView
 * JD-Core Version:    0.7.0.1
 */