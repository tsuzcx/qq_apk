package dov.com.qq.im.ae;

import bndy;
import bnne;
import bnvb;
import dov.com.qq.im.ae.mode.AECaptureMode;

public class AEPituCameraUnit$32
  implements Runnable
{
  public AEPituCameraUnit$32(bndy parambndy) {}
  
  public void run()
  {
    boolean bool = true;
    if (bndy.a(this.this$0) != null) {
      bndy.a(this.this$0).d();
    }
    bnvb localbnvb;
    if (bndy.a(this.this$0) != null)
    {
      localbnvb = bndy.a(this.this$0);
      if (bndy.b(this.this$0) != AECaptureMode.GIF) {
        break label87;
      }
    }
    for (;;)
    {
      localbnvb.a(196611, new Object[] { Boolean.valueOf(bool) });
      bndy.a(this.this$0).a(327685, new Object[0]);
      return;
      label87:
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.AEPituCameraUnit.32
 * JD-Core Version:    0.7.0.1
 */