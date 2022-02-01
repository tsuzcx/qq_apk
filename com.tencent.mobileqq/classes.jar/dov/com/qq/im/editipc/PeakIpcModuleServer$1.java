package dov.com.qq.im.editipc;

import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;

class PeakIpcModuleServer$1
  implements Runnable
{
  PeakIpcModuleServer$1(PeakIpcModuleServer paramPeakIpcModuleServer, String paramString1, String paramString2) {}
  
  public void run()
  {
    String str = ShortVideoUtils.getShortVideoThumbPicPath(this.a, "jpg");
    if ((!FileUtils.b(str)) && (!FileUtils.d(this.b, str))) {
      QLog.e("PeakIpcModuleServer", 2, "copy thumbPath fail, exist: " + FileUtils.b(this.b));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.qq.im.editipc.PeakIpcModuleServer.1
 * JD-Core Version:    0.7.0.1
 */