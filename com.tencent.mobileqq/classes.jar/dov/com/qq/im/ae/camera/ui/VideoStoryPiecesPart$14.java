package dov.com.qq.im.ae.camera.ui;

import android.app.Activity;
import android.graphics.Bitmap;
import bgmo;
import bgtn;
import bnbn;
import bniq;

public class VideoStoryPiecesPart$14
  implements Runnable
{
  public VideoStoryPiecesPart$14(bniq parambniq) {}
  
  public void run()
  {
    try
    {
      bniq.a(this.this$0, bnbn.a(bniq.f(this.this$0), true));
      if ((bniq.a(this.this$0) != null) && (!bniq.a(this.this$0).isRecycled())) {
        bniq.a(this.this$0, bgmo.b(bniq.a(this.this$0), bgtn.a(3.0F), bniq.a(this.this$0).getWidth(), bniq.a(this.this$0).getHeight()));
      }
      bniq.g(this.this$0).runOnUiThread(new VideoStoryPiecesPart.14.1(this));
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.VideoStoryPiecesPart.14
 * JD-Core Version:    0.7.0.1
 */