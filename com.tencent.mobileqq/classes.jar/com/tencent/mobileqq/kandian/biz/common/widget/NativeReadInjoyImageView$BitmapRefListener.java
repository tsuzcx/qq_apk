package com.tencent.mobileqq.kandian.biz.common.widget;

import com.tencent.biz.pubaccount.imagecollection.api.IPublicAccountImageDownListener;
import com.tencent.mobileqq.kandian.base.image.imageloader.CloseableBitmap;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;

class NativeReadInjoyImageView$BitmapRefListener
  implements IPublicAccountImageDownListener
{
  public void a(URL paramURL, int paramInt) {}
  
  public void a(URL paramURL, Object paramObject)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setImageDrawable: url is ");
    localStringBuilder.append(paramURL);
    QLog.d("NativeReadInjoyImageView", 2, localStringBuilder.toString());
    if ((paramObject instanceof CloseableBitmap)) {
      ((CloseableBitmap)paramObject).d();
    }
  }
  
  public void a(URL paramURL, Throwable paramThrowable) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.common.widget.NativeReadInjoyImageView.BitmapRefListener
 * JD-Core Version:    0.7.0.1
 */