package cooperation.qzone.panorama.widget;

import android.os.Handler;
import java.util.Timer;
import java.util.TimerTask;

class PanoramaGuideAnimate$2
  extends TimerTask
{
  private float a = 0.15F;
  private float b = 0.4666667F;
  
  PanoramaGuideAnimate$2(PanoramaGuideAnimate paramPanoramaGuideAnimate) {}
  
  public void run()
  {
    if (PanoramaGuideAnimate.a(this.this$0) == 0)
    {
      PanoramaGuideAnimate.b(this.this$0, PanoramaGuideAnimate.a(this.this$0) + this.a);
      PanoramaGuideAnimate.c(this.this$0, PanoramaGuideAnimate.b(this.this$0) - this.b);
    }
    for (;;)
    {
      if ((PanoramaGuideAnimate.a(this.this$0) >= 45.0F) || (PanoramaGuideAnimate.b(this.this$0) <= -140.0F)) {
        PanoramaGuideAnimate.a(this.this$0, 1);
      }
      if ((PanoramaGuideAnimate.a(this.this$0) > -45.0F) && (PanoramaGuideAnimate.b(this.this$0) < 140.0F)) {
        break;
      }
      if (PanoramaGuideAnimate.a(this.this$0) != null) {
        PanoramaGuideAnimate.a(this.this$0).cancel();
      }
      if (PanoramaGuideAnimate.a(this.this$0) != null) {
        PanoramaGuideAnimate.a(this.this$0).cancel();
      }
      PanoramaGuideAnimate.a(this.this$0).sendEmptyMessage(292);
      return;
      PanoramaGuideAnimate.b(this.this$0, PanoramaGuideAnimate.a(this.this$0) - this.a);
      PanoramaGuideAnimate.c(this.this$0, PanoramaGuideAnimate.b(this.this$0) + this.b);
    }
    PanoramaGuideAnimate.a(this.this$0).sendEmptyMessage(291);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.panorama.widget.PanoramaGuideAnimate.2
 * JD-Core Version:    0.7.0.1
 */