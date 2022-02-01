package dov.com.qq.im.ae.camera.ui;

import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import bnbp;
import com.tencent.biz.videostory.capture.widgets.SquareRoundImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;

class VideoStoryPiecesPart$15$1
  implements Runnable
{
  VideoStoryPiecesPart$15$1(VideoStoryPiecesPart.15 param15) {}
  
  public void run()
  {
    if ((bnbp.a(this.a.this$0) != null) && (bnbp.a(this.a.this$0) != null))
    {
      BitmapDrawable localBitmapDrawable = new BitmapDrawable(bnbp.a(this.a.this$0));
      int i = AIOUtils.dp2px(36.0F, bnbp.a(this.a.this$0).getResources());
      localBitmapDrawable.setBounds(0, 0, i, i);
      bnbp.a(this.a.this$0).setImageDrawable(localBitmapDrawable);
      bnbp.a(this.a.this$0).setEnabled(true);
      return;
    }
    bnbp.a(this.a.this$0).setEnabled(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.VideoStoryPiecesPart.15.1
 * JD-Core Version:    0.7.0.1
 */