package dov.com.qq.im.ae.camera.ui;

import android.graphics.drawable.AnimationDrawable;
import android.text.TextUtils;
import android.widget.ImageView;
import dov.com.qq.im.ae.entry.AECameraEntry;
import dov.com.qq.im.ae.view.AECompoundButton;

class VideoStoryPiecesPart$4
  implements Runnable
{
  VideoStoryPiecesPart$4(VideoStoryPiecesPart paramVideoStoryPiecesPart, String paramString) {}
  
  public void run()
  {
    if ((!AECameraEntry.g(VideoStoryPiecesPart.a(this.this$0))) || (TextUtils.isEmpty(this.a)) || (!VideoStoryPiecesPart.a(this.this$0)) || (!VideoStoryPiecesPart.b(this.this$0)))
    {
      VideoStoryPiecesPart.a(this.this$0).a().setImageResource(2130837711);
      AnimationDrawable localAnimationDrawable = (AnimationDrawable)VideoStoryPiecesPart.a(this.this$0).a().getDrawable();
      if (localAnimationDrawable != null) {
        localAnimationDrawable.start();
      }
      return;
    }
    VideoStoryPiecesPart.a(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.VideoStoryPiecesPart.4
 * JD-Core Version:    0.7.0.1
 */