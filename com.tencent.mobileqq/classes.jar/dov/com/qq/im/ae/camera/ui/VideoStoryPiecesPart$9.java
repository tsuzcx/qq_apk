package dov.com.qq.im.ae.camera.ui;

import android.app.Activity;
import android.graphics.Bitmap;
import bdhj;
import bdoo;
import bkna;
import bktp;

public class VideoStoryPiecesPart$9
  implements Runnable
{
  public VideoStoryPiecesPart$9(bktp parambktp) {}
  
  public void run()
  {
    try
    {
      bktp.a(this.this$0, bkna.a(bktp.f(this.this$0), true));
      if ((bktp.a(this.this$0) != null) && (!bktp.a(this.this$0).isRecycled())) {
        bktp.a(this.this$0, bdhj.b(bktp.a(this.this$0), bdoo.a(3.0F), bktp.a(this.this$0).getWidth(), bktp.a(this.this$0).getHeight()));
      }
      bktp.g(this.this$0).runOnUiThread(new VideoStoryPiecesPart.9.1(this));
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