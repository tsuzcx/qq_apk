package com.tencent.mobileqq.emoticonview;

import aciy;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewParent;
import android.widget.LinearLayout;
import anjq;
import anjr;
import anjs;
import anjt;
import com.tencent.qphone.base.util.QLog;

public class EmotionKeywordLayout
  extends LinearLayout
{
  private int jdField_a_of_type_Int;
  private Animator.AnimatorListener jdField_a_of_type_AndroidAnimationAnimator$AnimatorListener = new anjs(this);
  private ValueAnimator jdField_a_of_type_AndroidAnimationValueAnimator;
  private anjt jdField_a_of_type_Anjt;
  private EmotionKeywordHorizonListView jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionKeywordHorizonListView;
  private boolean jdField_a_of_type_Boolean;
  private ValueAnimator b;
  
  public EmotionKeywordLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public EmotionKeywordLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Int = aciy.a(81.0F, paramContext.getResources());
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmotionKeywordLayout", 2, "show");
    }
    if (getVisibility() == 0) {}
    do
    {
      return;
      setVisibility(0);
    } while ((this.jdField_a_of_type_AndroidAnimationValueAnimator != null) && (this.jdField_a_of_type_AndroidAnimationValueAnimator.isRunning()));
    if ((this.b != null) && (this.b.isRunning())) {
      this.b.cancel();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionKeywordHorizonListView == null) {
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionKeywordHorizonListView = ((EmotionKeywordHorizonListView)findViewById(2131300025));
    }
    if (this.jdField_a_of_type_AndroidAnimationValueAnimator == null)
    {
      this.jdField_a_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofFloat(new float[] { this.jdField_a_of_type_Int, 0.0F });
      this.jdField_a_of_type_AndroidAnimationValueAnimator.addUpdateListener(new anjq(this));
      this.jdField_a_of_type_AndroidAnimationValueAnimator.setDuration(200L);
      this.jdField_a_of_type_AndroidAnimationValueAnimator.addListener(this.jdField_a_of_type_AndroidAnimationAnimator$AnimatorListener);
    }
    this.jdField_a_of_type_AndroidAnimationValueAnimator.start();
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmotionKeywordLayout", 2, "hide");
    }
    if (getVisibility() == 8) {}
    do
    {
      return;
      if (!this.jdField_a_of_type_Boolean)
      {
        setVisibility(8);
        return;
      }
    } while ((this.b != null) && (this.b.isRunning()));
    if ((this.jdField_a_of_type_AndroidAnimationValueAnimator != null) && (this.jdField_a_of_type_AndroidAnimationValueAnimator.isRunning())) {
      this.jdField_a_of_type_AndroidAnimationValueAnimator.cancel();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionKeywordHorizonListView == null) {
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionKeywordHorizonListView = ((EmotionKeywordHorizonListView)findViewById(2131300025));
    }
    if (this.b == null)
    {
      this.b = ValueAnimator.ofFloat(new float[] { 0.0F, this.jdField_a_of_type_Int });
      this.b.addUpdateListener(new anjr(this));
      this.b.setDuration(200L);
      this.b.addListener(this.jdField_a_of_type_AndroidAnimationAnimator$AnimatorListener);
    }
    this.b.start();
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction() & 0xFF;
    if (i == 0) {
      getParent().requestDisallowInterceptTouchEvent(true);
    }
    for (;;)
    {
      return super.onInterceptTouchEvent(paramMotionEvent);
      if ((i == 1) || (i == 3)) {
        getParent().requestDisallowInterceptTouchEvent(false);
      }
    }
  }
  
  public void setEnableAnim(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void setOnVisibilityListener(anjt paramanjt)
  {
    this.jdField_a_of_type_Anjt = paramanjt;
  }
  
  public void setVisibility(int paramInt)
  {
    super.setVisibility(paramInt);
    if (this.jdField_a_of_type_Anjt != null) {
      this.jdField_a_of_type_Anjt.a(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmotionKeywordLayout
 * JD-Core Version:    0.7.0.1
 */