package com.tencent.mobileqq.emoticonview;

import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewParent;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;

public class EmotionKeywordLayout
  extends LinearLayout
{
  private static final int Height_Normal = 81;
  private static final int Height_WidthTitle = 100;
  private static final String TAG = "EmotionKeywordLayout";
  private LinearLayout mAnimationContainer;
  private Animator.AnimatorListener mAnimatorListener = new EmotionKeywordLayout.3(this);
  private EmotionKeywordHorizonListView mEmotionView;
  private boolean mEnableAnim;
  private int mHeight;
  private ValueAnimator mHideAnim;
  private EmotionKeywordLayout.OnVisibilityListener mOnVisibilityListener;
  private ValueAnimator mShowAnim;
  private LinearLayout mTitleContainer;
  private TextView mTitleView;
  
  public EmotionKeywordLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public EmotionKeywordLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.mHeight = Utils.a(81.0F, paramContext.getResources());
  }
  
  private void initUIView()
  {
    if (this.mTitleContainer == null) {
      this.mTitleContainer = ((LinearLayout)findViewById(2131366149));
    }
    if (this.mTitleView == null) {
      this.mTitleView = ((TextView)findViewById(2131366148));
    }
    if (this.mEmotionView == null) {
      this.mEmotionView = ((EmotionKeywordHorizonListView)findViewById(2131366178));
    }
    if (this.mAnimationContainer == null) {
      this.mAnimationContainer = ((LinearLayout)findViewById(2131362692));
    }
  }
  
  private void updateHeight()
  {
    int i;
    if (this.mTitleContainer.getVisibility() == 0) {
      i = 100;
    } else {
      i = 81;
    }
    this.mHeight = Utils.a(i, getResources());
  }
  
  public void hide()
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmotionKeywordLayout", 2, "hide");
    }
    initUIView();
    if (getVisibility() == 8) {
      return;
    }
    if (!this.mEnableAnim)
    {
      setVisibility(8);
      return;
    }
    ValueAnimator localValueAnimator = this.mHideAnim;
    if ((localValueAnimator != null) && (localValueAnimator.isRunning())) {
      return;
    }
    localValueAnimator = this.mShowAnim;
    if ((localValueAnimator != null) && (localValueAnimator.isRunning())) {
      this.mShowAnim.cancel();
    }
    if (this.mHideAnim == null)
    {
      this.mHideAnim = ValueAnimator.ofFloat(new float[] { 0.0F, this.mHeight });
      this.mHideAnim.addUpdateListener(new EmotionKeywordLayout.2(this));
      this.mHideAnim.setDuration(200L);
      this.mHideAnim.addListener(this.mAnimatorListener);
    }
    this.mHideAnim.start();
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction() & 0xFF;
    if (i == 0) {
      getParent().requestDisallowInterceptTouchEvent(true);
    } else if ((i == 1) || (i == 3)) {
      getParent().requestDisallowInterceptTouchEvent(false);
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  public void setEnableAnim(boolean paramBoolean)
  {
    this.mEnableAnim = paramBoolean;
  }
  
  public void setOnVisibilityListener(EmotionKeywordLayout.OnVisibilityListener paramOnVisibilityListener)
  {
    this.mOnVisibilityListener = paramOnVisibilityListener;
  }
  
  public void setVisibility(int paramInt)
  {
    super.setVisibility(paramInt);
    EmotionKeywordLayout.OnVisibilityListener localOnVisibilityListener = this.mOnVisibilityListener;
    if (localOnVisibilityListener != null) {
      localOnVisibilityListener.onVisibilityChanged(paramInt);
    }
  }
  
  public void show(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmotionKeywordLayout", 2, "show");
    }
    initUIView();
    if (StringUtil.a(paramString))
    {
      this.mTitleView.setText("");
      this.mTitleContainer.setVisibility(8);
    }
    else
    {
      this.mTitleView.setText(paramString);
      this.mTitleContainer.setVisibility(0);
    }
    updateHeight();
    if (getVisibility() == 0) {
      return;
    }
    setVisibility(0);
    paramString = this.mShowAnim;
    if ((paramString != null) && (paramString.isRunning())) {
      return;
    }
    paramString = this.mHideAnim;
    if ((paramString != null) && (paramString.isRunning())) {
      this.mHideAnim.cancel();
    }
    if (this.mShowAnim == null)
    {
      this.mShowAnim = ValueAnimator.ofFloat(new float[] { this.mHeight, 0.0F });
      this.mShowAnim.addUpdateListener(new EmotionKeywordLayout.1(this));
      this.mShowAnim.setDuration(200L);
      this.mShowAnim.addListener(this.mAnimatorListener);
    }
    this.mShowAnim.start();
    invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmotionKeywordLayout
 * JD-Core Version:    0.7.0.1
 */