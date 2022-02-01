package com.tencent.mobileqq.qqgift.api.view;

import android.content.Context;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.qqgift.api.IQQGiftModule;
import com.tencent.mobileqq.qqgift.mvvm.business.anim.IQQGiftAnimationEngine;
import com.tencent.mobileqq.qqgift.mvvm.business.view.IQQGiftPanelView;

public abstract interface IQQGiftViewModule
  extends IQQGiftModule
{
  public abstract IQQGiftAnimationEngine a(Context paramContext);
  
  public abstract IQQGiftAnimationEngine a(Context paramContext, int paramInt);
  
  public abstract IQQGiftPanelView a(QBaseActivity paramQBaseActivity);
  
  public abstract IQQGiftPanelView a(QBaseActivity paramQBaseActivity, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgift.api.view.IQQGiftViewModule
 * JD-Core Version:    0.7.0.1
 */