package dov.com.qq.im.ae.camera.core;

import ahvy;
import ahyd;
import amfw;
import bijj;
import bijm;
import com.tencent.mobileqq.qmcf.QmcfManager;
import com.tencent.qphone.base.util.QLog;

public class AECameraManager$4
  implements Runnable
{
  public AECameraManager$4(bijj parambijj, boolean paramBoolean) {}
  
  public void run()
  {
    if (!amfw.d()) {
      return;
    }
    ahvy localahvy;
    if (bijj.a(this.this$0) == 1)
    {
      bijj.c(this.this$0, 2);
      ahua.a = bijj.a(this.this$0);
      if (bijj.a(this.this$0) != null)
      {
        localahvy = bijj.a(this.this$0);
        if (bijj.a(this.this$0) != 1) {
          break label170;
        }
      }
    }
    label170:
    for (boolean bool = true;; bool = false)
    {
      localahvy.a(bool);
      bijj.c(this.this$0, false);
      QmcfManager.getInstance().setCameraMode(bijj.a(this.this$0));
      ahyd.a().a(true);
      this.this$0.a(this.a);
      this.this$0.a();
      this.this$0.b();
      if (bijj.a(this.this$0) != null) {
        bijj.a(this.this$0).g();
      }
      QLog.d("AECameraManager", 4, "###  changeCamera");
      return;
      bijj.c(this.this$0, 1);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.core.AECameraManager.4
 * JD-Core Version:    0.7.0.1
 */