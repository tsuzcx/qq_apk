package com.tencent.mobileqq.mutualmark;

import android.view.View;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.qphone.base.util.QLog;

class UrlBottomImageSpan$1
  implements URLDrawable.URLDrawableListener
{
  UrlBottomImageSpan$1(UrlBottomImageSpan paramUrlBottomImageSpan) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable)
  {
    if (QLog.isColorLevel()) {
      QLog.i("UrlBottomImageSpan", 2, "onLoadCanceled");
    }
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    if (QLog.isColorLevel()) {
      QLog.i("UrlBottomImageSpan", 2, "onLoadFialed");
    }
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      paramURLDrawable = new StringBuilder();
      paramURLDrawable.append("onLoadProgressed i:");
      paramURLDrawable.append(paramInt);
      QLog.i("UrlBottomImageSpan", 2, paramURLDrawable.toString());
    }
  }
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    if (QLog.isColorLevel()) {
      QLog.i("UrlBottomImageSpan", 2, "onLoadSuccessed");
    }
    paramURLDrawable = paramURLDrawable.getCallback();
    if ((paramURLDrawable != null) && ((paramURLDrawable instanceof View)))
    {
      paramURLDrawable = (View)paramURLDrawable;
      paramURLDrawable.invalidate();
      paramURLDrawable.requestLayout();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.mutualmark.UrlBottomImageSpan.1
 * JD-Core Version:    0.7.0.1
 */