package dov.com.qq.im.ae.camera.ui;

import aekt;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import bkpi;
import com.tencent.biz.videostory.capture.widgets.SquareRoundImageView;

class VideoStoryPiecesPart$9$1
  implements Runnable
{
  VideoStoryPiecesPart$9$1(VideoStoryPiecesPart.9 param9) {}
  
  public void run()
  {
    if ((bkpi.a(this.a.this$0) != null) && (bkpi.a(this.a.this$0) != null))
    {
      BitmapDrawable localBitmapDrawable = new BitmapDrawable(bkpi.a(this.a.this$0));
      int i = aekt.a(36.0F, bkpi.a(this.a.this$0).getResources());
      localBitmapDrawable.setBounds(0, 0, i, i);
      bkpi.a(this.a.this$0).setImageDrawable(localBitmapDrawable);
      bkpi.a(this.a.this$0).setEnabled(true);
      return;
    }
    bkpi.a(this.a.this$0).setEnabled(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.VideoStoryPiecesPart.9.1
 * JD-Core Version:    0.7.0.1
 */