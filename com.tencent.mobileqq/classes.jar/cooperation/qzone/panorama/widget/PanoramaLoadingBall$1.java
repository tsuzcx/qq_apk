package cooperation.qzone.panorama.widget;

import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class PanoramaLoadingBall$1
  extends Handler
{
  PanoramaLoadingBall$1(PanoramaLoadingBall paramPanoramaLoadingBall, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    if ((paramMessage.what == 291) && (Build.VERSION.SDK_INT >= 11))
    {
      if (PanoramaLoadingBall.access$000(this.this$0)) {
        PanoramaLoadingBall.access$102(this.this$0, 60.0F);
      }
      if (PanoramaLoadingBall.access$200(this.this$0) == 0)
      {
        paramMessage = this.this$0;
        paramMessage.setRotationX(PanoramaLoadingBall.access$100(paramMessage));
        return;
      }
      paramMessage = this.this$0;
      paramMessage.setRotationY(PanoramaLoadingBall.access$100(paramMessage));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     cooperation.qzone.panorama.widget.PanoramaLoadingBall.1
 * JD-Core Version:    0.7.0.1
 */