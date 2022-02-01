package dov.com.qq.im.ae.play;

import android.os.Build.VERSION;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.ttpic.videoshelf.ui.VideoShelfPlayView;

class AEVideoShelfPreviewFragment$1
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  AEVideoShelfPreviewFragment$1(AEVideoShelfPreviewFragment paramAEVideoShelfPreviewFragment) {}
  
  public void onGlobalLayout()
  {
    if (Build.VERSION.SDK_INT >= 16) {
      AEVideoShelfPreviewFragment.access$000(this.this$0).getViewTreeObserver().removeOnGlobalLayoutListener(this);
    }
    for (;;)
    {
      AEVideoShelfPreviewFragment.access$000(this.this$0).updateVideoSize(AEVideoShelfPreviewFragment.access$000(this.this$0).getVideoWidth(), AEVideoShelfPreviewFragment.access$000(this.this$0).getVideoHeight());
      return;
      AEVideoShelfPreviewFragment.access$000(this.this$0).getViewTreeObserver().removeGlobalOnLayoutListener(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.play.AEVideoShelfPreviewFragment.1
 * JD-Core Version:    0.7.0.1
 */