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
      PanoramaLoadingBall localPanoramaLoadingBall;
      if (!this.isSlow) {
        if (PanoramaLoadingBall.access$300(this.this$0) == 0)
        {
          localPanoramaLoadingBall = this.this$0;
          PanoramaLoadingBall.access$102(localPanoramaLoadingBall, PanoramaLoadingBall.access$100(localPanoramaLoadingBall) + 2.0F);
        }
        else
        {
          localPanoramaLoadingBall = this.this$0;
          PanoramaLoadingBall.access$102(localPanoramaLoadingBall, PanoramaLoadingBall.access$100(localPanoramaLoadingBall) - 2.0F);
        }
      }
      if (PanoramaLoadingBall.access$100(this.this$0) > PanoramaLoadingBall.access$400(this.this$0))
      {
        localPanoramaLoadingBall = this.this$0;
        PanoramaLoadingBall.access$102(localPanoramaLoadingBall, PanoramaLoadingBall.access$100(localPanoramaLoadingBall) - 0.3F);
        this.isSlow = true;
        if (PanoramaLoadingBall.access$100(this.this$0) <= PanoramaLoadingBall.access$400(this.this$0))
        {
          PanoramaLoadingBall.access$302(this.this$0, 1);
          this.isSlow = false;
        }
      }
      else if (PanoramaLoadingBall.access$100(this.this$0) < 0.0F)
      {
        localPanoramaLoadingBall = this.this$0;
        PanoramaLoadingBall.access$102(localPanoramaLoadingBall, PanoramaLoadingBall.access$100(localPanoramaLoadingBall) + 0.3F);
        this.isSlow = true;
        if (PanoramaLoadingBall.access$100(this.this$0) >= 0.0F)
        {
          PanoramaLoadingBall.access$302(this.this$0, 0);
          this.isSlow = false;
        }
      }
      PanoramaLoadingBall.access$500(this.this$0).sendEmptyMessage(291);
      return;
    }
    PanoramaLoadingBall.access$600(this.this$0).cancel();
    cancel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     cooperation.qzone.panorama.widget.PanoramaLoadingBall.2
 * JD-Core Version:    0.7.0.1
 */