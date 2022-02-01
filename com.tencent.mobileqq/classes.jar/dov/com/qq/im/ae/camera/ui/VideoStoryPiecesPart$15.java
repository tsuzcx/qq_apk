package dov.com.qq.im.ae.camera.ui;

import android.app.Activity;
import android.graphics.Bitmap;
import bheg;
import bmuu;
import bnbp;
import com.tencent.mobileqq.utils.ViewUtils;

public class VideoStoryPiecesPart$15
  implements Runnable
{
  public VideoStoryPiecesPart$15(bnbp parambnbp) {}
  
  public void run()
  {
    try
    {
      bnbp.a(this.this$0, bmuu.a(bnbp.i(this.this$0), true));
      if ((bnbp.a(this.this$0) != null) && (!bnbp.a(this.this$0).isRecycled())) {
        bnbp.a(this.this$0, bheg.b(bnbp.a(this.this$0), ViewUtils.dip2px(3.0F), bnbp.a(this.this$0).getWidth(), bnbp.a(this.this$0).getHeight()));
      }
      bnbp.j(this.this$0).runOnUiThread(new VideoStoryPiecesPart.15.1(this));
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