package com.tencent.mobileqq.mini.ui.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;

public class DialogFromBottom
  extends Dialog
{
  private static final int mAnimationDuration = 200;
  private View mContentView;
  private boolean mIsAnimating;
  private DialogFromBottom.OnBottomSheetShowListener mOnBottomSheetShowListener;
  
  public DialogFromBottom(@NonNull Context paramContext)
  {
    super(paramContext, 2131755054);
  }
  
  private void animateDown()
  {
    if (this.mContentView == null) {
      return;
    }
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 0.0F, 1, 1.0F);
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    AnimationSet localAnimationSet = new AnimationSet(true);
    localAnimationSet.addAnimation(localTranslateAnimation);
    localAnimationSet.addAnimation(localAlphaAnimation);
    localAnimationSet.setInterpolator(new DecelerateInterpolator());
    localAnimationSet.setDuration(200L);
    localAnimationSet.setFillAfter(true);
    localAnimationSet.setAnimationListener(new DialogFromBottom.1(this));
    this.mContentView.startAnimation(localAnimationSet);
  }
  
  private void animateUp()
  {
    if (this.mContentView == null) {
      return;
    }
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 1.0F, 1, 0.0F);
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
    AnimationSet localAnimationSet = new AnimationSet(true);
    localAnimationSet.addAnimation(localTranslateAnimation);
    localAnimationSet.addAnimation(localAlphaAnimation);
    localAnimationSet.setInterpolator(new DecelerateInterpolator());
    localAnimationSet.setDuration(200L);
    localAnimationSet.setFillAfter(true);
    this.mContentView.startAnimation(localAnimationSet);
  }
  
  public void dismiss()
  {
    if (this.mIsAnimating) {
      return;
    }
    animateDown();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    getWindow().getDecorView().setPadding(0, 0, 0, 0);
    paramBundle = getWindow().getAttributes();
    paramBundle.height = -2;
    paramBundle.gravity = 81;
    int i = DisplayHelper.getScreenWidth(getContext());
    int j = DisplayHelper.getScreenHeight(getContext());
    if (i < j) {}
    for (;;)
    {
      paramBundle.width = i;
      getWindow().setAttributes(paramBundle);
      setCanceledOnTouchOutside(true);
      return;
      i = j;
    }
  }
  
  public void setContentView(int paramInt)
  {
    this.mContentView = LayoutInflater.from(getContext()).inflate(paramInt, null);
    super.setContentView(this.mContentView);
  }
  
  public void setContentView(@NonNull View paramView)
  {
    this.mContentView = paramView;
    super.setContentView(paramView);
  }
  
  public void setContentView(@NonNull View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    this.mContentView = paramView;
    super.setContentView(paramView, paramLayoutParams);
  }
  
  public void show()
  {
    super.show();
    animateUp();
    if (this.mOnBottomSheetShowListener != null) {
      this.mOnBottomSheetShowListener.onShow();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.ui.dialog.DialogFromBottom
 * JD-Core Version:    0.7.0.1
 */