package dov.com.qq.im.ae.camera.ui;

import agej;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import bojy;
import com.tencent.biz.videostory.capture.widgets.SquareRoundImageView;

class VideoStoryPiecesPart$15$1
  implements Runnable
{
  VideoStoryPiecesPart$15$1(VideoStoryPiecesPart.15 param15) {}
  
  public void run()
  {
    if ((bojy.a(this.a.this$0) != null) && (bojy.a(this.a.this$0) != null))
    {
      BitmapDrawable localBitmapDrawable = new BitmapDrawable(bojy.a(this.a.this$0));
      int i = agej.a(36.0F, bojy.a(this.a.this$0).getResources());
      localBitmapDrawable.setBounds(0, 0, i, i);
      bojy.a(this.a.this$0).setImageDrawable(localBitmapDrawable);
      bojy.a(this.a.this$0).setEnabled(true);
      return;
    }
    bojy.a(this.a.this$0).setEnabled(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.VideoStoryPiecesPart.15.1
 * JD-Core Version:    0.7.0.1
 */