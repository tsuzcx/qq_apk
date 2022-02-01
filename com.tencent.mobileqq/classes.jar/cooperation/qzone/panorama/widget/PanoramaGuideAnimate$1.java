package cooperation.qzone.panorama.widget;

import android.annotation.TargetApi;
import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;

class PanoramaGuideAnimate$1
  extends Handler
{
  PanoramaGuideAnimate$1(PanoramaGuideAnimate paramPanoramaGuideAnimate) {}
  
  @TargetApi(11)
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    switch (paramMessage.what)
    {
    }
    do
    {
      return;
      PanoramaGuideAnimate.access$100(this.this$0).setRotationY(PanoramaGuideAnimate.access$000(this.this$0));
      PanoramaGuideAnimate.access$100(this.this$0).setTranslationX(PanoramaGuideAnimate.access$200(this.this$0));
      return;
      if (PanoramaGuideAnimate.access$300(this.this$0) > 0.0F) {
        break;
      }
    } while (PanoramaGuideAnimate.access$400(this.this$0) == null);
    PanoramaGuideAnimate.access$400(this.this$0).onAnimateComplete();
    return;
    PanoramaGuideAnimate.access$302(this.this$0, PanoramaGuideAnimate.access$300(this.this$0) - 0.05F);
    this.this$0.setAlpha(PanoramaGuideAnimate.access$300(this.this$0));
    PanoramaGuideAnimate.access$500(this.this$0).sendEmptyMessage(292);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.panorama.widget.PanoramaGuideAnimate.1
 * JD-Core Version:    0.7.0.1
 */