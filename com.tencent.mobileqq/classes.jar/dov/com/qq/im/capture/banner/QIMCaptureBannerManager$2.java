package dov.com.qq.im.capture.banner;

import blrk;
import com.tencent.common.app.AppInterface;
import java.io.File;

public class QIMCaptureBannerManager$2
  implements Runnable
{
  public void run()
  {
    File localFile = new File(blrk.a, this.this$0.a().getCurrentAccountUin() + "banner_config");
    if (localFile.exists()) {
      localFile.delete();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.qq.im.capture.banner.QIMCaptureBannerManager.2
 * JD-Core Version:    0.7.0.1
 */