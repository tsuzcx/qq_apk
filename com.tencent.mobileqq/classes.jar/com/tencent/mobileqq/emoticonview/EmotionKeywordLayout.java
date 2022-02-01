package com.tencent.mobileqq.emoticonview;

import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewParent;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
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
    this.mHeight = AIOUtils.dp2px(81.0F, paramContext.getResources());
  }
  
  private void initUIView()
  {
    if (this.mTitleContainer == null) {
      this.mTitleContainer = ((LinearLayout)findViewById(2131365988));
    }
    if (this.mTitleView == null) {
      this.mTitleView = ((TextView)findViewById(2131365987));
    }
    if (this.mEmotionView == null) {
      this.mEmotionView = ((EmotionKeywordHorizonListView)findViewById(2131366017));
    }
    if (this.mAnimationContainer == null) {
      this.mAnimationContainer = ((LinearLayout)findViewById(2131362694));
    }
  }
  
  private void updateHeight()
  {
    if (this.mTitleContainer.getVisibility() == 0) {}
    for (int i = 100;; i = 81)
    {
      this.mHeight = AIOUtils.dp2px(i, getResources());
      return;
    }
  }
  
  public void hide()
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmotionKeywordLayout", 2, "hide");
    }
    initUIView();
    if (getVisibility() == 8) {}
    do
    {
      return;
      if (!this.mEnableAnim)
      {
        setVisibility(8);
        return;
      }
    } while ((this.mHideAnim != null) && (this.mHideAnim.isRunning()));
    if ((this.mShowAnim != null) && (this.mShowAnim.isRunning())) {
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
    this.mEnableAnim = paramBoolean;
  }
  
  public void setOnVisibilityListener(EmotionKeywordLayout.OnVisibilityListener paramOnVisibilityListener)
  {
    this.mOnVisibilityListener = paramOnVisibilityListener;
  }
  
  public void setVisibility(int paramInt)
  {
    super.setVisibility(paramInt);
    if (this.mOnVisibilityListener != null) {
      this.mOnVisibilityListener.onVisibilityChanged(paramInt);
    }
  }
  
  public void show(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmotionKeywordLayout", 2, "show");
    }
    initUIView();
    if (StringUtil.isEmpty(paramString))
    {
      this.mTitleView.setText("");
      this.mTitleContainer.setVisibility(8);
      updateHeight();
      if (getVisibility() != 0) {
        break label74;
      }
    }
    label74:
    do
    {
      return;
      this.mTitleView.setText(paramString);
      this.mTitleContainer.setVisibility(0);
      break;
      setVisibility(0);
    } while ((this.mShowAnim != null) && (this.mShowAnim.isRunning()));
    if ((this.mHideAnim != null) && (this.mHideAnim.isRunning())) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmotionKeywordLayout
 * JD-Core Version:    0.7.0.1
 */