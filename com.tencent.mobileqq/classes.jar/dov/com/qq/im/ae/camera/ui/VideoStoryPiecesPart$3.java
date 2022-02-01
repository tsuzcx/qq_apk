package dov.com.qq.im.ae.camera.ui;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import bloe;
import com.tencent.biz.videostory.capture.widgets.SquareRoundImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;

public class VideoStoryPiecesPart$3
  implements Runnable
{
  public VideoStoryPiecesPart$3(bloe parambloe) {}
  
  public void run()
  {
    Drawable localDrawable = bloe.a(this.this$0).getResources().getDrawable(2130849119);
    int i = AIOUtils.dp2px(36.0F, bloe.b(this.this$0).getResources());
    localDrawable.setBounds(0, 0, i, i);
    bloe.a(this.this$0).setImageDrawable(localDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.VideoStoryPiecesPart.3
 * JD-Core Version:    0.7.0.1
 */