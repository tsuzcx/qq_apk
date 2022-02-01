package dov.com.qq.im.ae.camera.ui;

import android.app.Activity;
import android.graphics.Bitmap;
import bhmq;
import bhtq;
import bocv;
import bojy;

public class VideoStoryPiecesPart$15
  implements Runnable
{
  public VideoStoryPiecesPart$15(bojy parambojy) {}
  
  public void run()
  {
    try
    {
      bojy.a(this.this$0, bocv.a(bojy.o(this.this$0), true));
      if ((bojy.a(this.this$0) != null) && (!bojy.a(this.this$0).isRecycled())) {
        bojy.a(this.this$0, bhmq.b(bojy.a(this.this$0), bhtq.a(3.0F), bojy.a(this.this$0).getWidth(), bojy.a(this.this$0).getHeight()));
      }
      bojy.p(this.this$0).runOnUiThread(new VideoStoryPiecesPart.15.1(this));
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.VideoStoryPiecesPart.15
 * JD-Core Version:    0.7.0.1
 */