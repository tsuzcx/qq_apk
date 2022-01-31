package dov.com.qq.im.ae.camera.core;

import ahvw;
import ahyb;
import amfv;
import bika;
import bikd;
import com.tencent.mobileqq.qmcf.QmcfManager;
import com.tencent.qphone.base.util.QLog;

public class AECameraManager$4
  implements Runnable
{
  public AECameraManager$4(bika parambika, boolean paramBoolean) {}
  
  public void run()
  {
    if (!amfv.d()) {
      return;
    }
    ahvw localahvw;
    if (bika.a(this.this$0) == 1)
    {
      bika.c(this.this$0, 2);
      ahty.a = bika.a(this.this$0);
      if (bika.a(this.this$0) != null)
      {
        localahvw = bika.a(this.this$0);
        if (bika.a(this.this$0) != 1) {
          break label170;
        }
      }
    }
    label170:
    for (boolean bool = true;; bool = false)
    {
      localahvw.a(bool);
      bika.c(this.this$0, false);
      QmcfManager.getInstance().setCameraMode(bika.a(this.this$0));
      ahyb.a().a(true);
      this.this$0.a(this.a);
      this.this$0.a();
      this.this$0.b();
      if (bika.a(this.this$0) != null) {
        bika.a(this.this$0).g();
      }
      QLog.d("AECameraManager", 4, "###  changeCamera");
      return;
      bika.c(this.this$0, 1);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.core.AECameraManager.4
 * JD-Core Version:    0.7.0.1
 */