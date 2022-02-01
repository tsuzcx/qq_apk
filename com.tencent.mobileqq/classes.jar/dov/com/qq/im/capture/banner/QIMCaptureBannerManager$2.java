package dov.com.qq.im.capture.banner;

import com.tencent.common.app.AppInterface;
import java.io.File;

class QIMCaptureBannerManager$2
  implements Runnable
{
  public void run()
  {
    File localFile = new File(QIMCaptureBannerManager.a, this.this$0.getApp().getCurrentAccountUin() + "banner_config");
    if (localFile.exists()) {
      localFile.delete();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.capture.banner.QIMCaptureBannerManager.2
 * JD-Core Version:    0.7.0.1
 */