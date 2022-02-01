package dov.com.qq.im.ae.camera.core;

import alwd;
import alyi;
import boiw;
import boja;
import com.tencent.mobileqq.qmcf.QmcfManager;

public class AECameraManager$3
  implements Runnable
{
  public AECameraManager$3(boiw paramboiw, boja paramboja) {}
  
  public void run()
  {
    boiw.a(this.this$0, false);
    alwd localalwd;
    if (boiw.a(this.this$0) == 1)
    {
      boiw.a(this.this$0, 2);
      aluf.a = boiw.a(this.this$0);
      if (boiw.a(this.this$0) != null)
      {
        localalwd = boiw.a(this.this$0);
        if (boiw.a(this.this$0) != 1) {
          break label127;
        }
      }
    }
    label127:
    for (boolean bool = true;; bool = false)
    {
      localalwd.a(bool);
      boiw.a(this.this$0, false);
      QmcfManager.getInstance().setCameraMode(boiw.a(this.this$0));
      alyi.a().a(true);
      boiw.a(this.this$0, this.a);
      return;
      boiw.a(this.this$0, 1);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.core.AECameraManager.3
 * JD-Core Version:    0.7.0.1
 */