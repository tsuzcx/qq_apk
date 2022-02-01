package dov.com.qq.im.editipc;

import bnau;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;

public class PeakIpcModuleServer$1
  implements Runnable
{
  public PeakIpcModuleServer$1(bnau parambnau, String paramString1, String paramString2) {}
  
  public void run()
  {
    String str = ShortVideoUtils.getShortVideoThumbPicPath(this.a, "jpg");
    if ((!FileUtils.fileExistsAndNotEmpty(str)) && (!FileUtils.copyFile(this.b, str))) {
      QLog.e("PeakIpcModuleServer", 2, "copy thumbPath fail, exist: " + FileUtils.fileExistsAndNotEmpty(this.b));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.editipc.PeakIpcModuleServer.1
 * JD-Core Version:    0.7.0.1
 */