package com.tencent.mobileqq.data;

import android.view.View;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.qphone.base.util.QLog;

class MessageForGrayTips$UrlCenterImageSpan$1
  implements URLDrawable.URLDrawableListener
{
  MessageForGrayTips$UrlCenterImageSpan$1(MessageForGrayTips.UrlCenterImageSpan paramUrlCenterImageSpan) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable) {}
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable) {}
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MessageForGrayTips", 2, "onLoadSuccessed() called with: urlDrawable = [" + paramURLDrawable + "]");
    }
    paramURLDrawable = paramURLDrawable.getCallback();
    if ((paramURLDrawable instanceof View))
    {
      ((View)paramURLDrawable).invalidate();
      ((View)paramURLDrawable).requestLayout();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForGrayTips.UrlCenterImageSpan.1
 * JD-Core Version:    0.7.0.1
 */