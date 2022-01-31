package dov.com.qq.im.AECamera.View;

import ahjh;
import ahll;
import alrg;
import bgys;
import bgyv;
import com.tencent.mobileqq.qmcf.QmcfManager;
import com.tencent.qphone.base.util.QLog;

public class AECameraManager$4
  implements Runnable
{
  public AECameraManager$4(bgys parambgys) {}
  
  public void run()
  {
    if (!alrg.d()) {
      return;
    }
    ahjh localahjh;
    if (bgys.a(this.this$0) == 1)
    {
      bgys.c(this.this$0, 2);
      ahhj.a = bgys.a(this.this$0);
      if (bgys.a(this.this$0) != null)
      {
        localahjh = bgys.a(this.this$0);
        if (bgys.a(this.this$0) != 1) {
          break label167;
        }
      }
    }
    label167:
    for (boolean bool = true;; bool = false)
    {
      localahjh.a(bool);
      bgys.c(this.this$0, false);
      QmcfManager.getInstance().setCameraMode(bgys.a(this.this$0));
      ahll.a().a(true);
      this.this$0.b();
      this.this$0.a();
      this.this$0.e();
      if (bgys.a(this.this$0) != null) {
        bgys.a(this.this$0).g();
      }
      QLog.d(bgys.b(), 4, "###  changeCamera");
      return;
      bgys.c(this.this$0, 1);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.AECamera.View.AECameraManager.4
 * JD-Core Version:    0.7.0.1
 */