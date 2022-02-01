package com.tencent.mobileqq.vas.qid;

import android.text.TextUtils;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import org.libpag.PAGFile;

class QidPagView$3
  implements URLDrawable.URLDrawableListener
{
  QidPagView$3(QidPagView paramQidPagView, PAGFile paramPAGFile, int paramInt, String paramString) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable) {}
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    if (!TextUtils.equals(this.c, "https://cmshowar-1251316161.cos.ap-guangzhou.myqcloud.com//qqshow/0/2d/body/100.png"))
    {
      if (TextUtils.equals(this.c, "https://cmshowar-1251316161.cos.ap-guangzhou.myqcloud.com//qqshow/1/2d/body/100.png")) {
        return;
      }
      QidPagView.a(this.d).d = QidCardManager.a();
      if (!TextUtils.isEmpty(QidPagView.a(this.d).d))
      {
        paramURLDrawable = this.d;
        QidPagView.a(paramURLDrawable, this.a, this.b, QidPagView.a(paramURLDrawable).d);
      }
    }
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    QidPagView.a(this.d, this.a, this.b, paramURLDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.qid.QidPagView.3
 * JD-Core Version:    0.7.0.1
 */