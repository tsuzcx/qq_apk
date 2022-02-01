package dov.com.qq.im.ae.camera.ui;

import android.app.Activity;
import android.graphics.Bitmap;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import dov.com.qq.im.QIMCameraUtil;

class VideoStoryPiecesPart$16
  implements Runnable
{
  VideoStoryPiecesPart$16(VideoStoryPiecesPart paramVideoStoryPiecesPart) {}
  
  public void run()
  {
    try
    {
      VideoStoryPiecesPart.a(this.this$0, QIMCameraUtil.a(VideoStoryPiecesPart.j(this.this$0), true));
      if ((VideoStoryPiecesPart.a(this.this$0) != null) && (!VideoStoryPiecesPart.a(this.this$0).isRecycled())) {
        VideoStoryPiecesPart.a(this.this$0, ImageUtil.b(VideoStoryPiecesPart.a(this.this$0), ViewUtils.a(3.0F), VideoStoryPiecesPart.a(this.this$0).getWidth(), VideoStoryPiecesPart.a(this.this$0).getHeight()));
      }
      VideoStoryPiecesPart.k(this.this$0).runOnUiThread(new VideoStoryPiecesPart.16.1(this));
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.VideoStoryPiecesPart.16
 * JD-Core Version:    0.7.0.1
 */