package dov.com.tencent.mobileqq.richmedia.capture.view;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import dov.com.tencent.mobileqq.activity.richmedia.FlowCameraMqqAction;

class BeautyBar$3
  implements Animation.AnimationListener
{
  BeautyBar$3(BeautyBar paramBeautyBar) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    FlowCameraMqqAction.a("", "0X8007C05", BeautyBar.a(this.a) + "", "", "", "");
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.mobileqq.richmedia.capture.view.BeautyBar.3
 * JD-Core Version:    0.7.0.1
 */