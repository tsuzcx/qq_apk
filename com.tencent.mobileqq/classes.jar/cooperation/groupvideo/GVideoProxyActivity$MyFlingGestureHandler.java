package cooperation.groupvideo;

import android.app.Activity;
import com.tencent.mobileqq.activity.fling.FlingGestureHandler;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;

public class GVideoProxyActivity$MyFlingGestureHandler
  extends FlingGestureHandler
{
  boolean a = true;
  
  public GVideoProxyActivity$MyFlingGestureHandler(Activity paramActivity)
  {
    super(paramActivity);
  }
  
  public void a(boolean paramBoolean)
  {
    this.a = paramBoolean;
    if (!a()) {
      a();
    }
    this.mTopLayout.setInterceptTouchFlag(paramBoolean);
  }
  
  public void flingLToR()
  {
    if (this.a) {
      super.flingLToR();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.groupvideo.GVideoProxyActivity.MyFlingGestureHandler
 * JD-Core Version:    0.7.0.1
 */