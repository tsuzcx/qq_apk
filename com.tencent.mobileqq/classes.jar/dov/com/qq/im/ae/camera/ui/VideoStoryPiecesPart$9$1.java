package dov.com.qq.im.ae.camera.ui;

import actn;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import bikc;
import com.tencent.biz.videostory.capture.widgets.SquareRoundImageView;

class VideoStoryPiecesPart$9$1
  implements Runnable
{
  VideoStoryPiecesPart$9$1(VideoStoryPiecesPart.9 param9) {}
  
  public void run()
  {
    if ((bikc.a(this.a.this$0) != null) && (bikc.a(this.a.this$0) != null))
    {
      BitmapDrawable localBitmapDrawable = new BitmapDrawable(bikc.a(this.a.this$0));
      int i = actn.a(36.0F, bikc.a(this.a.this$0).getResources());
      localBitmapDrawable.setBounds(0, 0, i, i);
      bikc.a(this.a.this$0).setImageDrawable(localBitmapDrawable);
      bikc.a(this.a.this$0).setEnabled(true);
      return;
    }
    bikc.a(this.a.this$0).setEnabled(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.VideoStoryPiecesPart.9.1
 * JD-Core Version:    0.7.0.1
 */