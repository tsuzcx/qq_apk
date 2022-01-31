package dov.com.qq.im.ae.camera.ui;

import aepi;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import bktp;
import com.tencent.biz.videostory.capture.widgets.SquareRoundImageView;

public class VideoStoryPiecesPart$1
  implements Runnable
{
  public VideoStoryPiecesPart$1(bktp parambktp) {}
  
  public void run()
  {
    Drawable localDrawable = bktp.a(this.this$0).getResources().getDrawable(2130848712);
    int i = aepi.a(36.0F, bktp.b(this.this$0).getResources());
    localDrawable.setBounds(0, 0, i, i);
    bktp.a(this.this$0).setImageDrawable(localDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.VideoStoryPiecesPart.1
 * JD-Core Version:    0.7.0.1
 */