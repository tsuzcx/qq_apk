package dov.com.qq.im.ae.camera.ui;

import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import bloe;
import com.tencent.biz.videostory.capture.widgets.SquareRoundImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;

class VideoStoryPiecesPart$15$1
  implements Runnable
{
  VideoStoryPiecesPart$15$1(VideoStoryPiecesPart.15 param15) {}
  
  public void run()
  {
    if ((bloe.a(this.a.this$0) != null) && (bloe.a(this.a.this$0) != null))
    {
      BitmapDrawable localBitmapDrawable = new BitmapDrawable(bloe.a(this.a.this$0));
      int i = AIOUtils.dp2px(36.0F, bloe.a(this.a.this$0).getResources());
      localBitmapDrawable.setBounds(0, 0, i, i);
      bloe.a(this.a.this$0).setImageDrawable(localBitmapDrawable);
      bloe.a(this.a.this$0).setEnabled(true);
      return;
    }
    bloe.a(this.a.this$0).setEnabled(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.VideoStoryPiecesPart.15.1
 * JD-Core Version:    0.7.0.1
 */