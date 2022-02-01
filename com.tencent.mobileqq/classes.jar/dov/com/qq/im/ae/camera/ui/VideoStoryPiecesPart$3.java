package dov.com.qq.im.ae.camera.ui;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.tencent.biz.videostory.capture.widgets.SquareRoundImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;

class VideoStoryPiecesPart$3
  implements Runnable
{
  VideoStoryPiecesPart$3(VideoStoryPiecesPart paramVideoStoryPiecesPart) {}
  
  public void run()
  {
    Drawable localDrawable = VideoStoryPiecesPart.a(this.this$0).getResources().getDrawable(2130849591);
    int i = AIOUtils.a(36.0F, VideoStoryPiecesPart.b(this.this$0).getResources());
    localDrawable.setBounds(0, 0, i, i);
    VideoStoryPiecesPart.a(this.this$0).setImageDrawable(localDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.VideoStoryPiecesPart.3
 * JD-Core Version:    0.7.0.1
 */