package com.tencent.mobileqq.emoticonview;

import aekt;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewParent;
import android.widget.LinearLayout;
import apsb;
import apsc;
import apsd;
import apse;
import com.tencent.qphone.base.util.QLog;

public class EmotionKeywordLayout
  extends LinearLayout
{
  private int jdField_a_of_type_Int;
  private Animator.AnimatorListener jdField_a_of_type_AndroidAnimationAnimator$AnimatorListener = new apsd(this);
  private ValueAnimator jdField_a_of_type_AndroidAnimationValueAnimator;
  private apse jdField_a_of_type_Apse;
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
    this.jdField_a_of_type_Int = aekt.a(81.0F, paramContext.getResources());
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
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionKeywordHorizonListView = ((EmotionKeywordHorizonListView)findViewById(2131365703));
    }
    if (this.jdField_a_of_type_AndroidAnimationValueAnimator == null)
    {
      this.jdField_a_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofFloat(new float[] { this.jdField_a_of_type_Int, 0.0F });
      this.jdField_a_of_type_AndroidAnimationValueAnimator.addUpdateListener(new apsb(this));
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
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionKeywordHorizonListView = ((EmotionKeywordHorizonListView)findViewById(2131365703));
    }
    if (this.b == null)
    {
      this.b = ValueAnimator.ofFloat(new float[] { 0.0F, this.jdField_a_of_type_Int });
      this.b.addUpdateListener(new apsc(this));
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
  
  public void setOnVisibilityListener(apse paramapse)
  {
    this.jdField_a_of_type_Apse = paramapse;
  }
  
  public void setVisibility(int paramInt)
  {
    super.setVisibility(paramInt);
    if (this.jdField_a_of_type_Apse != null) {
      this.jdField_a_of_type_Apse.a(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmotionKeywordLayout
 * JD-Core Version:    0.7.0.1
 */