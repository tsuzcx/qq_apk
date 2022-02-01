package dov.com.qq.im.ae.camera.core;

import alkl;
import almq;
import bnho;
import bnhs;
import com.tencent.mobileqq.qmcf.QmcfManager;

public class AECameraManager$3
  implements Runnable
{
  public AECameraManager$3(bnho parambnho, bnhs parambnhs) {}
  
  public void run()
  {
    bnho.a(this.this$0, false);
    alkl localalkl;
    if (bnho.a(this.this$0) == 1)
    {
      bnho.a(this.this$0, 2);
      alin.a = bnho.a(this.this$0);
      if (bnho.a(this.this$0) != null)
      {
        localalkl = bnho.a(this.this$0);
        if (bnho.a(this.this$0) != 1) {
          break label127;
        }
      }
    }
    label127:
    for (boolean bool = true;; bool = false)
    {
      localalkl.a(bool);
      bnho.a(this.this$0, false);
      QmcfManager.getInstance().setCameraMode(bnho.a(this.this$0));
      almq.a().a(true);
      bnho.a(this.this$0, this.a);
      return;
      bnho.a(this.this$0, 1);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.core.AECameraManager.3
 * JD-Core Version:    0.7.0.1
 */