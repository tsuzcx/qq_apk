package dov.com.qq.im.ae.camera.ui;

import afur;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import bniq;
import com.tencent.biz.videostory.capture.widgets.SquareRoundImageView;

class VideoStoryPiecesPart$14$1
  implements Runnable
{
  VideoStoryPiecesPart$14$1(VideoStoryPiecesPart.14 param14) {}
  
  public void run()
  {
    if ((bniq.a(this.a.this$0) != null) && (bniq.a(this.a.this$0) != null))
    {
      BitmapDrawable localBitmapDrawable = new BitmapDrawable(bniq.a(this.a.this$0));
      int i = afur.a(36.0F, bniq.a(this.a.this$0).getResources());
      localBitmapDrawable.setBounds(0, 0, i, i);
      bniq.a(this.a.this$0).setImageDrawable(localBitmapDrawable);
      bniq.a(this.a.this$0).setEnabled(true);
      return;
    }
    bniq.a(this.a.this$0).setEnabled(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.VideoStoryPiecesPart.14.1
 * JD-Core Version:    0.7.0.1
 */