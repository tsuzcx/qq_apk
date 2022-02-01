package com.tencent.qqmini.sdk.ui;

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
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.qqmini.sdk.R.style;
import com.tencent.qqmini.sdk.utils.ViewUtils;

public class MiniAppDialog
  extends ReportDialog
{
  private static final int mAnimationDuration = 200;
  private View mContentView;
  private boolean mIsAnimating = false;
  private MiniAppDialog.OnBottomSheetShowListener mOnBottomSheetShowListener;
  
  public MiniAppDialog(@NonNull Context paramContext)
  {
    super(paramContext, R.style.mini_sdk_BottomSheet);
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
    localAnimationSet.setAnimationListener(new MiniAppDialog.1(this));
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
    int i = ViewUtils.getScreenWidth();
    int j = ViewUtils.getScreenHeight();
    if (i >= j) {
      i = j;
    }
    paramBundle.width = i;
    getWindow().setAttributes(paramBundle);
    setCanceledOnTouchOutside(true);
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
    MiniAppDialog.OnBottomSheetShowListener localOnBottomSheetShowListener = this.mOnBottomSheetShowListener;
    if (localOnBottomSheetShowListener != null) {
      localOnBottomSheetShowListener.onShow();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.ui.MiniAppDialog
 * JD-Core Version:    0.7.0.1
 */