package cooperation.qzone.panorama.widget;

import android.os.Handler;
import java.util.Timer;
import java.util.TimerTask;

class PanoramaLoadingBall$2
  extends TimerTask
{
  boolean isSlow = false;
  
  PanoramaLoadingBall$2(PanoramaLoadingBall paramPanoramaLoadingBall) {}
  
  public void run()
  {
    if (!PanoramaLoadingBall.access$000(this.this$0))
    {
      if (!this.isSlow)
      {
        if (PanoramaLoadingBall.access$300(this.this$0) == 0) {
          PanoramaLoadingBall.access$102(this.this$0, PanoramaLoadingBall.access$100(this.this$0) + 2.0F);
        }
      }
      else
      {
        if (PanoramaLoadingBall.access$100(this.this$0) <= PanoramaLoadingBall.access$400(this.this$0)) {
          break label152;
        }
        PanoramaLoadingBall.access$102(this.this$0, PanoramaLoadingBall.access$100(this.this$0) - 0.3F);
        this.isSlow = true;
        if (PanoramaLoadingBall.access$100(this.this$0) <= PanoramaLoadingBall.access$400(this.this$0))
        {
          PanoramaLoadingBall.access$302(this.this$0, 1);
          this.isSlow = false;
        }
      }
      for (;;)
      {
        PanoramaLoadingBall.access$500(this.this$0).sendEmptyMessage(291);
        return;
        PanoramaLoadingBall.access$102(this.this$0, PanoramaLoadingBall.access$100(this.this$0) - 2.0F);
        break;
        label152:
        if (PanoramaLoadingBall.access$100(this.this$0) < 0.0F)
        {
          PanoramaLoadingBall.access$102(this.this$0, PanoramaLoadingBall.access$100(this.this$0) + 0.3F);
          this.isSlow = true;
          if (PanoramaLoadingBall.access$100(this.this$0) >= 0.0F)
          {
            PanoramaLoadingBall.access$302(this.this$0, 0);
            this.isSlow = false;
          }
        }
      }
    }
    PanoramaLoadingBall.access$600(this.this$0).cancel();
    cancel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.panorama.widget.PanoramaLoadingBall.2
 * JD-Core Version:    0.7.0.1
 */