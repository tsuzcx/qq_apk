package com.tencent.mobileqq.util;

import android.view.View;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;

final class QQSettingUtil$2
  implements URLDrawable.URLDrawableListener
{
  QQSettingUtil$2(View paramView) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable)
  {
    if (paramURLDrawable != null) {
      paramURLDrawable.setBounds(0, 0, 0, 0);
    }
    paramURLDrawable = this.a;
    if (paramURLDrawable != null) {
      paramURLDrawable.postInvalidate();
    }
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    if (paramURLDrawable != null) {
      paramURLDrawable.setBounds(0, 0, 0, 0);
    }
    paramURLDrawable = this.a;
    if (paramURLDrawable != null) {
      paramURLDrawable.postInvalidate();
    }
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    if (paramURLDrawable != null) {
      paramURLDrawable.setBounds(0, 0, UIUtils.a(BaseApplicationImpl.getContext(), 47.0F), UIUtils.a(BaseApplicationImpl.getContext(), 14.0F));
    }
    paramURLDrawable = this.a;
    if (paramURLDrawable != null) {
      paramURLDrawable.postInvalidate();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.util.QQSettingUtil.2
 * JD-Core Version:    0.7.0.1
 */