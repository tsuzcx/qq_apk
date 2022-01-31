package dov.com.qq.im.editipc;

import bbdx;
import bjnd;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.qphone.base.util.QLog;

public class PeakIpcModuleServer$1
  implements Runnable
{
  public PeakIpcModuleServer$1(bjnd parambjnd, String paramString1, String paramString2) {}
  
  public void run()
  {
    String str = ShortVideoUtils.a(this.a, "jpg");
    if ((!bbdx.b(str)) && (!bbdx.d(this.b, str))) {
      QLog.e("PeakIpcModuleServer", 2, "copy thumbPath fail, exist: " + bbdx.b(this.b));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.editipc.PeakIpcModuleServer.1
 * JD-Core Version:    0.7.0.1
 */