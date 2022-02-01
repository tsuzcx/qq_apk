package com.tencent.mobileqq.nearby.now.share;

import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.mobileqq.app.QQAppInterface;

final class ShortVideoShareUtil$3
  implements URLDrawable.URLDrawableListener
{
  ShortVideoShareUtil$3(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, String paramString4, IShortVideoShareUtil.OnShareCallBack paramOnShareCallBack) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable)
  {
    SLog.c("ShortVideoShareUtil", "onLoadCanceled --");
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    ShortVideoShareUtil.a(this.a, this.b, this.c, this.d, this.e, null, this.f);
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt)
  {
    paramURLDrawable = new StringBuilder();
    paramURLDrawable.append("onLoadProgressed --");
    paramURLDrawable.append(paramInt);
    SLog.c("ShortVideoShareUtil", paramURLDrawable.toString());
  }
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    paramURLDrawable = ShortVideoShareUtil.a(paramURLDrawable);
    ShortVideoShareUtil.a(this.a, this.b, this.c, this.d, this.e, paramURLDrawable, this.f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.share.ShortVideoShareUtil.3
 * JD-Core Version:    0.7.0.1
 */