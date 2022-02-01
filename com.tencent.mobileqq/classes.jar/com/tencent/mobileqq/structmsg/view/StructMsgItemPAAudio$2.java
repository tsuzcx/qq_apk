package com.tencent.mobileqq.structmsg.view;

import android.view.View;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener.Adapter;

class StructMsgItemPAAudio$2
  extends URLDrawableDownListener.Adapter
{
  StructMsgItemPAAudio$2(StructMsgItemPAAudio paramStructMsgItemPAAudio) {}
  
  public void onLoadCancelled(View paramView, URLDrawable paramURLDrawable)
  {
    super.onLoadCancelled(paramView, paramURLDrawable);
  }
  
  public void onLoadFailed(View paramView, URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    super.onLoadFailed(paramView, paramURLDrawable, paramThrowable);
  }
  
  public void onLoadInterrupted(View paramView, URLDrawable paramURLDrawable, InterruptedException paramInterruptedException)
  {
    super.onLoadInterrupted(paramView, paramURLDrawable, paramInterruptedException);
  }
  
  public void onLoadSuccessed(View paramView, URLDrawable paramURLDrawable)
  {
    paramView.setBackgroundDrawable(paramURLDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.view.StructMsgItemPAAudio.2
 * JD-Core Version:    0.7.0.1
 */