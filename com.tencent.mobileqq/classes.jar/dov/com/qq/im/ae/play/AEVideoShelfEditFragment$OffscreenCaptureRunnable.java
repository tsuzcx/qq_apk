package dov.com.qq.im.ae.play;

import android.widget.RelativeLayout;
import blil;

public class AEVideoShelfEditFragment$OffscreenCaptureRunnable
  implements Runnable
{
  private AEVideoShelfEditFragment$OffscreenCaptureRunnable(AEVideoShelfEditFragment paramAEVideoShelfEditFragment) {}
  
  public void run()
  {
    RelativeLayout localRelativeLayout = new RelativeLayout(this.this$0.getActivity());
    AEVideoShelfEditFragment.a(localRelativeLayout, AEVideoShelfEditFragment.a(this.this$0).getLeft(), AEVideoShelfEditFragment.a(this.this$0).getTop(), AEVideoShelfEditFragment.a(this.this$0), AEVideoShelfEditFragment.b(this.this$0));
    int i = 0;
    if (i < AEVideoShelfEditFragment.a(this.this$0).getItemCount())
    {
      if (i == 0) {
        AEVideoShelfEditFragment.d(this.this$0, i);
      }
      for (;;)
      {
        i += 1;
        break;
        AEVideoShelfEditFragment.a(this.this$0, localRelativeLayout, i);
        AEVideoShelfEditFragment.a(this.this$0, localRelativeLayout, i);
      }
    }
    localRelativeLayout.removeAllViews();
    if (AEVideoShelfEditFragment.a(this.this$0) != null) {
      AEVideoShelfEditFragment.a(this.this$0).a(AEVideoShelfEditFragment.a(this.this$0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.qq.im.ae.play.AEVideoShelfEditFragment.OffscreenCaptureRunnable
 * JD-Core Version:    0.7.0.1
 */