package dov.com.qq.im.ae.camera.ui.capture;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.ttpic.openapi.filter.GLGestureProxy;

class VideoStoryCapturePart$2
  implements View.OnTouchListener
{
  VideoStoryCapturePart$2(VideoStoryCapturePart paramVideoStoryCapturePart) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if ((VideoStoryCapturePart.a(this.a) != null) && (VideoStoryCapturePart.b(this.a) != null)) {
      GLGestureProxy.getInstance().onTouchEvent(paramMotionEvent, false, VideoStoryCapturePart.b(this.a), VideoStoryCapturePart.a(this.a));
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.capture.VideoStoryCapturePart.2
 * JD-Core Version:    0.7.0.1
 */