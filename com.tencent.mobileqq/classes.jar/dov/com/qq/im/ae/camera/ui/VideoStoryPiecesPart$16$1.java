package dov.com.qq.im.ae.camera.ui;

import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.tencent.biz.videostory.capture.widgets.SquareRoundImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;

class VideoStoryPiecesPart$16$1
  implements Runnable
{
  VideoStoryPiecesPart$16$1(VideoStoryPiecesPart.16 param16) {}
  
  public void run()
  {
    if ((VideoStoryPiecesPart.a(this.a.this$0) != null) && (VideoStoryPiecesPart.a(this.a.this$0) != null))
    {
      BitmapDrawable localBitmapDrawable = new BitmapDrawable(VideoStoryPiecesPart.a(this.a.this$0));
      int i = AIOUtils.a(36.0F, VideoStoryPiecesPart.a(this.a.this$0).getResources());
      localBitmapDrawable.setBounds(0, 0, i, i);
      VideoStoryPiecesPart.a(this.a.this$0).setImageDrawable(localBitmapDrawable);
      VideoStoryPiecesPart.a(this.a.this$0).setEnabled(true);
      return;
    }
    VideoStoryPiecesPart.a(this.a.this$0).setEnabled(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.VideoStoryPiecesPart.16.1
 * JD-Core Version:    0.7.0.1
 */