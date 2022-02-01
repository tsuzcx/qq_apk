package com.tencent.mobileqq.structmsg.view;

import android.view.View;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener.Adapter;
import com.tencent.image.URLImageView;
import com.tencent.qphone.base.util.QLog;

class StructMsgItemLayoutNew2$1
  extends URLDrawableDownListener.Adapter
{
  StructMsgItemLayoutNew2$1(StructMsgItemLayoutNew2 paramStructMsgItemLayoutNew2) {}
  
  public void onLoadCancelled(View paramView, URLDrawable paramURLDrawable)
  {
    super.onLoadCancelled(paramView, paramURLDrawable);
    if (QLog.isColorLevel()) {
      QLog.d(this.a.ac, 2, "onLoadCancelled");
    }
  }
  
  public void onLoadFailed(View paramView, URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    super.onLoadFailed(paramView, paramURLDrawable, paramThrowable);
    if (QLog.isColorLevel())
    {
      paramView = this.a.ac;
      paramURLDrawable = new StringBuilder();
      paramURLDrawable.append("onLoadFailed ,cause = ");
      paramURLDrawable.append(paramThrowable);
      QLog.d(paramView, 2, paramURLDrawable.toString());
    }
  }
  
  public void onLoadInterrupted(View paramView, URLDrawable paramURLDrawable, InterruptedException paramInterruptedException)
  {
    super.onLoadInterrupted(paramView, paramURLDrawable, paramInterruptedException);
    if (QLog.isColorLevel()) {
      QLog.d(this.a.ac, 2, "onLoadInterrupted");
    }
  }
  
  public void onLoadSuccessed(View paramView, URLDrawable paramURLDrawable)
  {
    if (paramView == null) {
      return;
    }
    paramView.setBackgroundDrawable(null);
    if ((paramView instanceof ImageView))
    {
      URLImageView localURLImageView = (URLImageView)paramView;
      localURLImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
      localURLImageView.setImageDrawable(paramURLDrawable);
      paramView.requestLayout();
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.a.ac, 2, "onLoadSuccessed");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.view.StructMsgItemLayoutNew2.1
 * JD-Core Version:    0.7.0.1
 */