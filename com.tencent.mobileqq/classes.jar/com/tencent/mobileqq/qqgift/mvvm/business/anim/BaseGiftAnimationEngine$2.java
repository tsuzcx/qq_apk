package com.tencent.mobileqq.qqgift.mvvm.business.anim;

import android.content.Context;
import com.tencent.mobileqq.qqgift.mvvm.business.view.IQQGiftAnimationView;
import com.tencent.mobileqq.qqgift.mvvm.business.view.QQGiftPngAnimationViewImpl;
import com.tencent.mobileqq.qqgift.mvvm.business.view.builder.IQQGiftAnimationViewBuilder;

class BaseGiftAnimationEngine$2
  implements IQQGiftAnimationViewBuilder
{
  private QQGiftPngAnimationViewImpl b = null;
  
  BaseGiftAnimationEngine$2(BaseGiftAnimationEngine paramBaseGiftAnimationEngine) {}
  
  public IQQGiftAnimationView a(Context paramContext, GiftAnimData paramGiftAnimData)
  {
    if ((paramGiftAnimData.b == 0) && (paramGiftAnimData.m == 0))
    {
      if (this.b == null) {
        this.b = new QQGiftPngAnimationViewImpl(paramContext);
      }
      return this.b;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgift.mvvm.business.anim.BaseGiftAnimationEngine.2
 * JD-Core Version:    0.7.0.1
 */