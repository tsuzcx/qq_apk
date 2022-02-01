package com.tencent.mobileqq.vas.qid;

import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import org.libpag.PAGFile;

class QidPagView$2
  implements URLDrawable.URLDrawableListener
{
  QidPagView$2(QidPagView paramQidPagView, PAGFile paramPAGFile, int paramInt) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable) {}
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable) {}
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    QidPagView.a(this.c, this.a, this.b, paramURLDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.qid.QidPagView.2
 * JD-Core Version:    0.7.0.1
 */