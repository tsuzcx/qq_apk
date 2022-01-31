package dov.com.qq.im.ae.camera.ui;

import actj;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import bikt;
import com.tencent.biz.videostory.capture.widgets.SquareRoundImageView;

public class VideoStoryPiecesPart$1
  implements Runnable
{
  public VideoStoryPiecesPart$1(bikt parambikt) {}
  
  public void run()
  {
    Drawable localDrawable = bikt.a(this.this$0).getResources().getDrawable(2130848254);
    int i = actj.a(36.0F, bikt.b(this.this$0).getResources());
    localDrawable.setBounds(0, 0, i, i);
    bikt.a(this.this$0).setImageDrawable(localDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.VideoStoryPiecesPart.1
 * JD-Core Version:    0.7.0.1
 */