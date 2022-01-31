import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.biz.pubaccount.readinjoy.viola.CommonSuspensionGestureLayout;

public class rvq
  implements Animation.AnimationListener
{
  public rvq(CommonSuspensionGestureLayout paramCommonSuspensionGestureLayout) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    CommonSuspensionGestureLayout.c(this.a).setLayerType(0, null);
    CommonSuspensionGestureLayout.a(this.a).c();
    CommonSuspensionGestureLayout.a(this.a).a();
    CommonSuspensionGestureLayout.b(this.a);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    CommonSuspensionGestureLayout.a(this.a).b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rvq
 * JD-Core Version:    0.7.0.1
 */