package dov.com.qq.im.ae.camera.ui;

import afur;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import bniq;
import com.tencent.biz.videostory.capture.widgets.SquareRoundImageView;

public class VideoStoryPiecesPart$2
  implements Runnable
{
  public VideoStoryPiecesPart$2(bniq parambniq) {}
  
  public void run()
  {
    Drawable localDrawable = bniq.a(this.this$0).getResources().getDrawable(2130849189);
    int i = afur.a(36.0F, bniq.b(this.this$0).getResources());
    localDrawable.setBounds(0, 0, i, i);
    bniq.a(this.this$0).setImageDrawable(localDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.VideoStoryPiecesPart.2
 * JD-Core Version:    0.7.0.1
 */