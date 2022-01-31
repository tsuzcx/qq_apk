package dov.com.qq.im.editipc;

import bdhb;
import bmcy;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.qphone.base.util.QLog;

public class PeakIpcModuleServer$1
  implements Runnable
{
  public PeakIpcModuleServer$1(bmcy parambmcy, String paramString1, String paramString2) {}
  
  public void run()
  {
    String str = ShortVideoUtils.a(this.a, "jpg");
    if ((!bdhb.b(str)) && (!bdhb.d(this.b, str))) {
      QLog.e("PeakIpcModuleServer", 2, "copy thumbPath fail, exist: " + bdhb.b(this.b));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.qq.im.editipc.PeakIpcModuleServer.1
 * JD-Core Version:    0.7.0.1
 */