package com.tencent.mobileqq.qqgift.mvvm.business.view;

import android.widget.ImageView;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;

class QQGiftPngAnimationViewImpl$1
  implements Runnable
{
  QQGiftPngAnimationViewImpl$1(QQGiftPngAnimationViewImpl paramQQGiftPngAnimationViewImpl, String paramString) {}
  
  public void run()
  {
    int i = ScreenUtil.dip2px(250.0F);
    QQGiftPngAnimationViewImpl localQQGiftPngAnimationViewImpl = this.this$0;
    QQGiftPngAnimationViewImpl.a(localQQGiftPngAnimationViewImpl, BitmapUtils.decodeSampleBitmap(QQGiftPngAnimationViewImpl.a(localQQGiftPngAnimationViewImpl).getContext(), this.a, i, i));
    QQGiftPngAnimationViewImpl.a(this.this$0).post(new QQGiftPngAnimationViewImpl.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgift.mvvm.business.view.QQGiftPngAnimationViewImpl.1
 * JD-Core Version:    0.7.0.1
 */