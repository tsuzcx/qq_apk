package dov.com.qq.im.ae.camera.ui;

import actj;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import bikt;
import com.tencent.biz.videostory.capture.widgets.SquareRoundImageView;

class VideoStoryPiecesPart$9$1
  implements Runnable
{
  VideoStoryPiecesPart$9$1(VideoStoryPiecesPart.9 param9) {}
  
  public void run()
  {
    if ((bikt.a(this.a.this$0) != null) && (bikt.a(this.a.this$0) != null))
    {
      BitmapDrawable localBitmapDrawable = new BitmapDrawable(bikt.a(this.a.this$0));
      int i = actj.a(36.0F, bikt.a(this.a.this$0).getResources());
      localBitmapDrawable.setBounds(0, 0, i, i);
      bikt.a(this.a.this$0).setImageDrawable(localBitmapDrawable);
      bikt.a(this.a.this$0).setEnabled(true);
      return;
    }
    bikt.a(this.a.this$0).setEnabled(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.VideoStoryPiecesPart.9.1
 * JD-Core Version:    0.7.0.1
 */