package com.tencent.mobileqq.emoticonview;

import agej;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewParent;
import android.widget.LinearLayout;
import android.widget.TextView;
import aspi;
import aspj;
import aspk;
import aspl;
import bhsr;
import com.tencent.qphone.base.util.QLog;

public class EmotionKeywordLayout
  extends LinearLayout
{
  private int jdField_a_of_type_Int;
  private Animator.AnimatorListener jdField_a_of_type_AndroidAnimationAnimator$AnimatorListener = new aspk(this);
  private ValueAnimator jdField_a_of_type_AndroidAnimationValueAnimator;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private aspl jdField_a_of_type_Aspl;
  private EmotionKeywordHorizonListView jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionKeywordHorizonListView;
  private boolean jdField_a_of_type_Boolean;
  private ValueAnimator jdField_b_of_type_AndroidAnimationValueAnimator;
  private LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout;
  
  public EmotionKeywordLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public EmotionKeywordLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Int = agej.a(81.0F, paramContext.getResources());
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout == null) {
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131365958));
    }
    if (this.jdField_a_of_type_AndroidWidgetTextView == null) {
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131365957));
    }
    if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionKeywordHorizonListView == null) {
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionKeywordHorizonListView = ((EmotionKeywordHorizonListView)findViewById(2131365987));
    }
    if (this.jdField_b_of_type_AndroidWidgetLinearLayout == null) {
      this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131362689));
    }
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout.getVisibility() == 0) {}
    for (int i = 100;; i = 81)
    {
      this.jdField_a_of_type_Int = agej.a(i, getResources());
      return;
    }
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmotionKeywordLayout", 2, "hide");
    }
    b();
    if (getVisibility() == 8) {}
    do
    {
      return;
      if (!this.jdField_a_of_type_Boolean)
      {
        setVisibility(8);
        return;
      }
    } while ((this.jdField_b_of_type_AndroidAnimationValueAnimator != null) && (this.jdField_b_of_type_AndroidAnimationValueAnimator.isRunning()));
    if ((this.jdField_a_of_type_AndroidAnimationValueAnimator != null) && (this.jdField_a_of_type_AndroidAnimationValueAnimator.isRunning())) {
      this.jdField_a_of_type_AndroidAnimationValueAnimator.cancel();
    }
    if (this.jdField_b_of_type_AndroidAnimationValueAnimator == null)
    {
      this.jdField_b_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, this.jdField_a_of_type_Int });
      this.jdField_b_of_type_AndroidAnimationValueAnimator.addUpdateListener(new aspj(this));
      this.jdField_b_of_type_AndroidAnimationValueAnimator.setDuration(200L);
      this.jdField_b_of_type_AndroidAnimationValueAnimator.addListener(this.jdField_a_of_type_AndroidAnimationAnimator$AnimatorListener);
    }
    this.jdField_b_of_type_AndroidAnimationValueAnimator.start();
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmotionKeywordLayout", 2, "show");
    }
    b();
    if (bhsr.a(paramString))
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText("");
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      c();
      if (getVisibility() != 0) {
        break label74;
      }
    }
    label74:
    do
    {
      return;
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      break;
      setVisibility(0);
    } while ((this.jdField_a_of_type_AndroidAnimationValueAnimator != null) && (this.jdField_a_of_type_AndroidAnimationValueAnimator.isRunning()));
    if ((this.jdField_b_of_type_AndroidAnimationValueAnimator != null) && (this.jdField_b_of_type_AndroidAnimationValueAnimator.isRunning())) {
      this.jdField_b_of_type_AndroidAnimationValueAnimator.cancel();
    }
    if (this.jdField_a_of_type_AndroidAnimationValueAnimator == null)
    {
      this.jdField_a_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofFloat(new float[] { this.jdField_a_of_type_Int, 0.0F });
      this.jdField_a_of_type_AndroidAnimationValueAnimator.addUpdateListener(new aspi(this));
      this.jdField_a_of_type_AndroidAnimationValueAnimator.setDuration(200L);
      this.jdField_a_of_type_AndroidAnimationValueAnimator.addListener(this.jdField_a_of_type_AndroidAnimationAnimator$AnimatorListener);
    }
    this.jdField_a_of_type_AndroidAnimationValueAnimator.start();
    invalidate();
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
  
  public void setOnVisibilityListener(aspl paramaspl)
  {
    this.jdField_a_of_type_Aspl = paramaspl;
  }
  
  public void setVisibility(int paramInt)
  {
    super.setVisibility(paramInt);
    if (this.jdField_a_of_type_Aspl != null) {
      this.jdField_a_of_type_Aspl.a(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmotionKeywordLayout
 * JD-Core Version:    0.7.0.1
 */