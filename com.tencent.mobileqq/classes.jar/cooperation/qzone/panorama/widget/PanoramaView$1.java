package cooperation.qzone.panorama.widget;

import cooperation.qzone.panorama.callback.OnPanoramaClickListener;
import cooperation.qzone.panorama.callback.PanoramaTouchListener;
import cooperation.qzone.panorama.controller.PanoramaRenderer;

class PanoramaView$1
  implements PanoramaTouchListener
{
  PanoramaView$1(PanoramaView paramPanoramaView) {}
  
  public void onClickListener()
  {
    if (PanoramaView.access$100(this.this$0) != null) {
      PanoramaView.access$100(this.this$0).onPanoramaClick();
    }
  }
  
  public void onTouchMove(float paramFloat1, float paramFloat2)
  {
    this.this$0.changeRotate(paramFloat1, paramFloat2);
  }
  
  public void onTouchScale(float paramFloat)
  {
    if (PanoramaView.access$000(this.this$0) != null) {
      PanoramaView.access$000(this.this$0).setScale(paramFloat);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.panorama.widget.PanoramaView.1
 * JD-Core Version:    0.7.0.1
 */