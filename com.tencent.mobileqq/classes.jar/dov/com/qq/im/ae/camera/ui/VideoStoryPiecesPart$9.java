package dov.com.qq.im.ae.camera.ui;

import android.app.Activity;
import android.graphics.Bitmap;
import bbdr;
import bbkx;
import bigg;
import bikc;

public class VideoStoryPiecesPart$9
  implements Runnable
{
  public VideoStoryPiecesPart$9(bikc parambikc) {}
  
  public void run()
  {
    try
    {
      bikc.a(this.this$0, bigg.a(bikc.a(this.this$0), true));
      if ((bikc.a(this.this$0) != null) && (!bikc.a(this.this$0).isRecycled())) {
        bikc.a(this.this$0, bbdr.b(bikc.a(this.this$0), bbkx.a(3.0F), bikc.a(this.this$0).getWidth(), bikc.a(this.this$0).getHeight()));
      }
      bikc.b(this.this$0).runOnUiThread(new VideoStoryPiecesPart.9.1(this));
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.VideoStoryPiecesPart.9
 * JD-Core Version:    0.7.0.1
 */