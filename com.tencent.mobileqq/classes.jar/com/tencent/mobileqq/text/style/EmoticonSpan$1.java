package com.tencent.mobileqq.text.style;

import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;

class EmoticonSpan$1
  implements URLDrawable.URLDrawableListener
{
  EmoticonSpan$1(EmoticonSpan paramEmoticonSpan) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable) {}
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable) {}
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    this.this$0.invlidateEmoticonSpan(paramURLDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.text.style.EmoticonSpan.1
 * JD-Core Version:    0.7.0.1
 */