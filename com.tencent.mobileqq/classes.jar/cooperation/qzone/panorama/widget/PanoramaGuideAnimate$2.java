package cooperation.qzone.panorama.widget;

import android.os.Handler;
import java.util.Timer;
import java.util.TimerTask;

class PanoramaGuideAnimate$2
  extends TimerTask
{
  private float rotateOffest = 0.15F;
  private float translationOffest = 0.4666667F;
  
  PanoramaGuideAnimate$2(PanoramaGuideAnimate paramPanoramaGuideAnimate) {}
  
  public void run()
  {
    if (PanoramaGuideAnimate.access$600(this.this$0) == 0)
    {
      PanoramaGuideAnimate.access$002(this.this$0, PanoramaGuideAnimate.access$000(this.this$0) + this.rotateOffest);
      PanoramaGuideAnimate.access$202(this.this$0, PanoramaGuideAnimate.access$200(this.this$0) - this.translationOffest);
    }
    for (;;)
    {
      if ((PanoramaGuideAnimate.access$000(this.this$0) >= 45.0F) || (PanoramaGuideAnimate.access$200(this.this$0) <= -140.0F)) {
        PanoramaGuideAnimate.access$602(this.this$0, 1);
      }
      if ((PanoramaGuideAnimate.access$000(this.this$0) > -45.0F) && (PanoramaGuideAnimate.access$200(this.this$0) < 140.0F)) {
        break;
      }
      if (PanoramaGuideAnimate.access$700(this.this$0) != null) {
        PanoramaGuideAnimate.access$700(this.this$0).cancel();
      }
      if (PanoramaGuideAnimate.access$800(this.this$0) != null) {
        PanoramaGuideAnimate.access$800(this.this$0).cancel();
      }
      PanoramaGuideAnimate.access$500(this.this$0).sendEmptyMessage(292);
      return;
      PanoramaGuideAnimate.access$002(this.this$0, PanoramaGuideAnimate.access$000(this.this$0) - this.rotateOffest);
      PanoramaGuideAnimate.access$202(this.this$0, PanoramaGuideAnimate.access$200(this.this$0) + this.translationOffest);
    }
    PanoramaGuideAnimate.access$500(this.this$0).sendEmptyMessage(291);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.panorama.widget.PanoramaGuideAnimate.2
 * JD-Core Version:    0.7.0.1
 */