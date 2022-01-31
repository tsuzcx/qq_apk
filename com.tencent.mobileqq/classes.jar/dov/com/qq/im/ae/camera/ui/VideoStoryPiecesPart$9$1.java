package dov.com.qq.im.ae.camera.ui;

import aepi;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import bktp;
import com.tencent.biz.videostory.capture.widgets.SquareRoundImageView;

class VideoStoryPiecesPart$9$1
  implements Runnable
{
  VideoStoryPiecesPart$9$1(VideoStoryPiecesPart.9 param9) {}
  
  public void run()
  {
    if ((bktp.a(this.a.this$0) != null) && (bktp.a(this.a.this$0) != null))
    {
      BitmapDrawable localBitmapDrawable = new BitmapDrawable(bktp.a(this.a.this$0));
      int i = aepi.a(36.0F, bktp.a(this.a.this$0).getResources());
      localBitmapDrawable.setBounds(0, 0, i, i);
      bktp.a(this.a.this$0).setImageDrawable(localBitmapDrawable);
      bktp.a(this.a.this$0).setEnabled(true);
      return;
    }
    bktp.a(this.a.this$0).setEnabled(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.VideoStoryPiecesPart.9.1
 * JD-Core Version:    0.7.0.1
 */