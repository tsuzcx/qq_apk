package com.tencent.mobileqq.forward;

import android.view.View;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener.Adapter;
import com.tencent.qphone.base.util.QLog;

class ForwardPluginShareStructMsgOption$1
  extends URLDrawableDownListener.Adapter
{
  ForwardPluginShareStructMsgOption$1(ForwardPluginShareStructMsgOption paramForwardPluginShareStructMsgOption) {}
  
  public void onLoadCancelled(View paramView, URLDrawable paramURLDrawable)
  {
    super.onLoadCancelled(paramView, paramURLDrawable);
    if (QLog.isColorLevel()) {
      QLog.d("ForwardOption.ForwardPluginShareStructMsgOption", 2, "onLoadCancelled");
    }
  }
  
  public void onLoadFailed(View paramView, URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    super.onLoadFailed(paramView, paramURLDrawable, paramThrowable);
    if (QLog.isColorLevel())
    {
      paramView = new StringBuilder();
      paramView.append("onLoadFailed ,cause = ");
      paramView.append(paramThrowable);
      QLog.d("ForwardOption.ForwardPluginShareStructMsgOption", 2, paramView.toString());
    }
  }
  
  public void onLoadInterrupted(View paramView, URLDrawable paramURLDrawable, InterruptedException paramInterruptedException)
  {
    super.onLoadInterrupted(paramView, paramURLDrawable, paramInterruptedException);
    if (QLog.isColorLevel()) {
      QLog.d("ForwardOption.ForwardPluginShareStructMsgOption", 2, "onLoadInterrupted");
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
      ImageView localImageView = (ImageView)paramView;
      localImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
      localImageView.setImageDrawable(paramURLDrawable);
      paramView.requestLayout();
    }
    if (QLog.isColorLevel()) {
      QLog.d("ForwardOption.ForwardPluginShareStructMsgOption", 2, "onLoadSuccessed");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardPluginShareStructMsgOption.1
 * JD-Core Version:    0.7.0.1
 */