package dov.com.qq.im.ae.camera.core;

import ajrv;
import ajua;
import aobe;
import bksp;
import bkss;
import com.tencent.mobileqq.qmcf.QmcfManager;
import com.tencent.qphone.base.util.QLog;

public class AECameraManager$4
  implements Runnable
{
  public AECameraManager$4(bksp parambksp, boolean paramBoolean) {}
  
  public void run()
  {
    if (!aobe.d()) {
      return;
    }
    ajrv localajrv;
    if (bksp.a(this.this$0) == 1)
    {
      bksp.c(this.this$0, 2);
      ajpx.a = bksp.a(this.this$0);
      if (bksp.a(this.this$0) != null)
      {
        localajrv = bksp.a(this.this$0);
        if (bksp.a(this.this$0) != 1) {
          break label170;
        }
      }
    }
    label170:
    for (boolean bool = true;; bool = false)
    {
      localajrv.a(bool);
      bksp.c(this.this$0, false);
      QmcfManager.getInstance().setCameraMode(bksp.a(this.this$0));
      ajua.a().a(true);
      this.this$0.a(this.a);
      this.this$0.a();
      this.this$0.b();
      if (bksp.a(this.this$0) != null) {
        bksp.a(this.this$0).g();
      }
      QLog.d("AECameraManager", 4, "###  changeCamera");
      return;
      bksp.c(this.this$0, 1);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.core.AECameraManager.4
 * JD-Core Version:    0.7.0.1
 */