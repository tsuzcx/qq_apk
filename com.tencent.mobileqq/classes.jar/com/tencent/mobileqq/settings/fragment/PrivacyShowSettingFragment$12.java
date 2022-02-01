package com.tencent.mobileqq.settings.fragment;

import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.FormSimpleItem;

class PrivacyShowSettingFragment$12
  implements URLDrawable.URLDrawableListener
{
  public void onLoadCanceled(URLDrawable paramURLDrawable)
  {
    if (paramURLDrawable != null) {
      paramURLDrawable.setBounds(0, 0, 0, 0);
    }
    if (PrivacyShowSettingFragment.g(this.a) != null) {
      PrivacyShowSettingFragment.g(this.a).postInvalidate();
    }
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    if (paramURLDrawable != null) {
      paramURLDrawable.setBounds(0, 0, 0, 0);
    }
    if (PrivacyShowSettingFragment.g(this.a) != null) {
      PrivacyShowSettingFragment.g(this.a).postInvalidate();
    }
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    if (paramURLDrawable != null) {
      paramURLDrawable.setBounds(0, 0, UIUtils.a(this.a.a.getApp(), 47.0F), UIUtils.a(this.a.a.getApp(), 14.0F));
    }
    if (PrivacyShowSettingFragment.g(this.a) != null) {
      PrivacyShowSettingFragment.g(this.a).postInvalidate();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.settings.fragment.PrivacyShowSettingFragment.12
 * JD-Core Version:    0.7.0.1
 */