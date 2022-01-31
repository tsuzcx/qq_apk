package dov.com.qq.im.ae.camera.core;

import ajng;
import ajpl;
import anwv;
import bkoi;
import bkol;
import com.tencent.mobileqq.qmcf.QmcfManager;
import com.tencent.qphone.base.util.QLog;

public class AECameraManager$4
  implements Runnable
{
  public AECameraManager$4(bkoi parambkoi, boolean paramBoolean) {}
  
  public void run()
  {
    if (!anwv.d()) {
      return;
    }
    ajng localajng;
    if (bkoi.a(this.this$0) == 1)
    {
      bkoi.c(this.this$0, 2);
      ajli.a = bkoi.a(this.this$0);
      if (bkoi.a(this.this$0) != null)
      {
        localajng = bkoi.a(this.this$0);
        if (bkoi.a(this.this$0) != 1) {
          break label170;
        }
      }
    }
    label170:
    for (boolean bool = true;; bool = false)
    {
      localajng.a(bool);
      bkoi.c(this.this$0, false);
      QmcfManager.getInstance().setCameraMode(bkoi.a(this.this$0));
      ajpl.a().a(true);
      this.this$0.a(this.a);
      this.this$0.a();
      this.this$0.b();
      if (bkoi.a(this.this$0) != null) {
        bkoi.a(this.this$0).g();
      }
      QLog.d("AECameraManager", 4, "###  changeCamera");
      return;
      bkoi.c(this.this$0, 1);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.core.AECameraManager.4
 * JD-Core Version:    0.7.0.1
 */