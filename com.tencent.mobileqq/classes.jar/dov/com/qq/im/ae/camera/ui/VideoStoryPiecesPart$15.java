package dov.com.qq.im.ae.camera.ui;

import android.app.Activity;
import android.graphics.Bitmap;
import bfvo;
import blid;
import bloe;
import com.tencent.mobileqq.utils.ViewUtils;

public class VideoStoryPiecesPart$15
  implements Runnable
{
  public VideoStoryPiecesPart$15(bloe parambloe) {}
  
  public void run()
  {
    try
    {
      bloe.a(this.this$0, blid.a(bloe.i(this.this$0), true));
      if ((bloe.a(this.this$0) != null) && (!bloe.a(this.this$0).isRecycled())) {
        bloe.a(this.this$0, bfvo.b(bloe.a(this.this$0), ViewUtils.dip2px(3.0F), bloe.a(this.this$0).getWidth(), bloe.a(this.this$0).getHeight()));
      }
      bloe.j(this.this$0).runOnUiThread(new VideoStoryPiecesPart.15.1(this));
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