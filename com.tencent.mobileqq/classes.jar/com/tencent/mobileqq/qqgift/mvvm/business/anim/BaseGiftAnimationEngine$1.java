package com.tencent.mobileqq.qqgift.mvvm.business.anim;

import android.content.Context;
import com.tencent.mobileqq.qqgift.mvvm.business.view.IQQGiftAnimationView;
import com.tencent.mobileqq.qqgift.mvvm.business.view.QQGiftPAGAnimationViewImpl;
import com.tencent.mobileqq.qqgift.mvvm.business.view.builder.IQQGiftAnimationViewBuilder;

class BaseGiftAnimationEngine$1
  implements IQQGiftAnimationViewBuilder
{
  private QQGiftPAGAnimationViewImpl b = null;
  
  BaseGiftAnimationEngine$1(BaseGiftAnimationEngine paramBaseGiftAnimationEngine) {}
  
  public IQQGiftAnimationView a(Context paramContext, GiftAnimData paramGiftAnimData)
  {
    if ((paramGiftAnimData.b != 1) && ((paramGiftAnimData.b != 0) || (paramGiftAnimData.m == 0))) {
      return null;
    }
    if (this.b == null) {
      this.b = new QQGiftPAGAnimationViewImpl(paramContext);
    }
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgift.mvvm.business.anim.BaseGiftAnimationEngine.1
 * JD-Core Version:    0.7.0.1
 */