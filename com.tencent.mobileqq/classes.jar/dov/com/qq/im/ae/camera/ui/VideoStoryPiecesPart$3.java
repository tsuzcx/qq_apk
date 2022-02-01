package dov.com.qq.im.ae.camera.ui;

import agej;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import bojy;
import com.tencent.biz.videostory.capture.widgets.SquareRoundImageView;

public class VideoStoryPiecesPart$3
  implements Runnable
{
  public VideoStoryPiecesPart$3(bojy parambojy) {}
  
  public void run()
  {
    Drawable localDrawable = bojy.a(this.this$0).getResources().getDrawable(2130849208);
    int i = agej.a(36.0F, bojy.b(this.this$0).getResources());
    localDrawable.setBounds(0, 0, i, i);
    bojy.a(this.this$0).setImageDrawable(localDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.VideoStoryPiecesPart.3
 * JD-Core Version:    0.7.0.1
 */