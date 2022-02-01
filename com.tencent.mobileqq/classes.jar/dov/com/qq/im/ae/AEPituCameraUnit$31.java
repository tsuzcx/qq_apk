package dov.com.qq.im.ae;

import bofh;
import boop;
import bown;
import dov.com.qq.im.ae.mode.AECaptureMode;

public class AEPituCameraUnit$31
  implements Runnable
{
  public AEPituCameraUnit$31(bofh parambofh) {}
  
  public void run()
  {
    boolean bool = true;
    if (bofh.a(this.this$0) != null) {
      bofh.a(this.this$0).d();
    }
    bown localbown;
    if (bofh.a(this.this$0) != null)
    {
      localbown = bofh.a(this.this$0);
      if (bofh.b(this.this$0) != AECaptureMode.GIF) {
        break label87;
      }
    }
    for (;;)
    {
      localbown.a(196611, new Object[] { Boolean.valueOf(bool) });
      bofh.a(this.this$0).a(327685, new Object[0]);
      return;
      label87:
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.AEPituCameraUnit.31
 * JD-Core Version:    0.7.0.1
 */