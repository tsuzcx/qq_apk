package com.tencent.mobileqq.qqgift.mvvm.business.anim;

import android.view.View;
import com.tencent.mobileqq.qqgift.api.IQQGiftSDK;
import com.tencent.mobileqq.qqgift.callback.IQQGiftEngineAnimationListener;
import com.tencent.mobileqq.qqgift.mvvm.business.view.IQQGiftAnimationView;

public abstract interface IQQGiftAnimationEngine
{
  public abstract IQQGiftAnimationView a(GiftAnimData paramGiftAnimData);
  
  public abstract void a();
  
  public abstract void a(IQQGiftEngineAnimationListener paramIQQGiftEngineAnimationListener);
  
  public abstract void a(GiftAnimData paramGiftAnimData, int paramInt);
  
  public abstract IQQGiftSDK b();
  
  public abstract void b(IQQGiftEngineAnimationListener paramIQQGiftEngineAnimationListener);
  
  public abstract void b(GiftAnimData paramGiftAnimData);
  
  public abstract void c();
  
  public abstract View d();
  
  public abstract View e();
  
  public abstract View f();
  
  public abstract void g();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgift.mvvm.business.anim.IQQGiftAnimationEngine
 * JD-Core Version:    0.7.0.1
 */