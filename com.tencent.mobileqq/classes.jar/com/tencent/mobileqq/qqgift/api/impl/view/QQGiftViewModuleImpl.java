package com.tencent.mobileqq.qqgift.api.impl.view;

import android.content.Context;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.qqgift.api.IQQGiftSDK;
import com.tencent.mobileqq.qqgift.api.view.IQQGiftViewModule;
import com.tencent.mobileqq.qqgift.business.qqlive.QQGiftPanelViewForLive;
import com.tencent.mobileqq.qqgift.mvvm.business.anim.IQQGiftAnimationEngine;
import com.tencent.mobileqq.qqgift.mvvm.business.anim.QQGiftAnimationEngineImpl;
import com.tencent.mobileqq.qqgift.mvvm.business.anim.QQLiveGiftAnimationEngineImpl;
import com.tencent.mobileqq.qqgift.mvvm.business.view.IQQGiftPanelView;
import com.tencent.mobileqq.qqgift.mvvm.business.view.QQGiftPanelViewImpl;

public class QQGiftViewModuleImpl
  implements IQQGiftViewModule
{
  private IQQGiftSDK a;
  
  public IQQGiftAnimationEngine a(Context paramContext)
  {
    return new QQLiveGiftAnimationEngineImpl(paramContext, this.a);
  }
  
  public IQQGiftAnimationEngine a(Context paramContext, int paramInt)
  {
    if (paramInt != 0) {
      return new QQLiveGiftAnimationEngineImpl(paramContext, this.a);
    }
    return new QQGiftAnimationEngineImpl(paramContext, this.a);
  }
  
  public IQQGiftPanelView a(QBaseActivity paramQBaseActivity)
  {
    return a(paramQBaseActivity, 0);
  }
  
  public IQQGiftPanelView a(QBaseActivity paramQBaseActivity, int paramInt)
  {
    if (paramInt == 1) {
      return new QQGiftPanelViewForLive(paramQBaseActivity, this.a);
    }
    if (paramInt == 2)
    {
      paramQBaseActivity = new QQGiftPanelViewForLive(paramQBaseActivity, this.a);
      paramQBaseActivity.setIsForBlack(true);
      return paramQBaseActivity;
    }
    return new QQGiftPanelViewImpl(paramQBaseActivity, this.a);
  }
  
  public void a() {}
  
  public void a(IQQGiftSDK paramIQQGiftSDK)
  {
    this.a = paramIQQGiftSDK;
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgift.api.impl.view.QQGiftViewModuleImpl
 * JD-Core Version:    0.7.0.1
 */