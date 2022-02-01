package com.tencent.mobileqq.qqgift.mvvm.business.view;

import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.mobileqq.qqgift.callback.IQQGiftAnimationListener;
import com.tencent.mobileqq.qqgift.mvvm.business.anim.GiftAnimData;

public abstract interface IQQGiftAnimationView
{
  public abstract FrameLayout.LayoutParams a(GiftAnimData paramGiftAnimData);
  
  public abstract void a();
  
  public abstract void a(IQQGiftAnimationListener paramIQQGiftAnimationListener);
  
  public abstract void a(String paramString);
  
  public abstract View b();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgift.mvvm.business.view.IQQGiftAnimationView
 * JD-Core Version:    0.7.0.1
 */