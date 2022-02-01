package dov.com.qq.im.ae.camera.core;

import alsn;
import alun;
import android.graphics.Rect;
import bczn;
import bdbf;
import java.io.File;

class AECameraManager$7
  implements Runnable
{
  AECameraManager$7(AECameraManager paramAECameraManager, File paramFile, alsn paramalsn, alun paramalun, int paramInt, boolean paramBoolean) {}
  
  public void run()
  {
    if (this.this$0.requestFocusBeforeTakePicture())
    {
      AECameraManager.access$800(this.this$0).a(new bczn(true), new AECameraManager.7.1(this));
      return;
    }
    AECameraManager.access$800(this.this$0).a(this.val$photoFile, new Rect(0, 0, this.val$previewSize.a, this.val$previewSize.b), this.val$callback, this.val$photoOrientation, this.val$mirror, 1, AECameraManager.access$1000(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.core.AECameraManager.7
 * JD-Core Version:    0.7.0.1
 */