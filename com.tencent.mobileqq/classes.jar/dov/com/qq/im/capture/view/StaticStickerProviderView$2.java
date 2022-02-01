package dov.com.qq.im.capture.view;

import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.music.CaptureConfigUpdateObserver;

class StaticStickerProviderView$2
  extends CaptureConfigUpdateObserver
{
  StaticStickerProviderView$2(StaticStickerProviderView paramStaticStickerProviderView) {}
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.i("StaticStickerProviderView", 2, "paster config get notify");
    }
    this.a.g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.qq.im.capture.view.StaticStickerProviderView.2
 * JD-Core Version:    0.7.0.1
 */