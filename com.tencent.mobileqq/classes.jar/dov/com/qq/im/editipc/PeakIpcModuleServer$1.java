package dov.com.qq.im.editipc;

import bhmi;
import bpxx;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.qphone.base.util.QLog;

public class PeakIpcModuleServer$1
  implements Runnable
{
  public PeakIpcModuleServer$1(bpxx parambpxx, String paramString1, String paramString2) {}
  
  public void run()
  {
    String str = ShortVideoUtils.a(this.a, "jpg");
    if ((!bhmi.b(str)) && (!bhmi.d(this.b, str))) {
      QLog.e("PeakIpcModuleServer", 2, "copy thumbPath fail, exist: " + bhmi.b(this.b));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.editipc.PeakIpcModuleServer.1
 * JD-Core Version:    0.7.0.1
 */