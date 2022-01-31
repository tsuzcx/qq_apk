package dov.com.qq.im.ae.camera.ui;

import android.app.Activity;
import android.graphics.Bitmap;
import bdda;
import bdkf;
import bkit;
import bkpi;

public class VideoStoryPiecesPart$9
  implements Runnable
{
  public VideoStoryPiecesPart$9(bkpi parambkpi) {}
  
  public void run()
  {
    try
    {
      bkpi.a(this.this$0, bkit.a(bkpi.f(this.this$0), true));
      if ((bkpi.a(this.this$0) != null) && (!bkpi.a(this.this$0).isRecycled())) {
        bkpi.a(this.this$0, bdda.b(bkpi.a(this.this$0), bdkf.a(3.0F), bkpi.a(this.this$0).getWidth(), bkpi.a(this.this$0).getHeight()));
      }
      bkpi.g(this.this$0).runOnUiThread(new VideoStoryPiecesPart.9.1(this));
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.VideoStoryPiecesPart.9
 * JD-Core Version:    0.7.0.1
 */