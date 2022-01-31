import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.biz.pubaccount.readinjoy.ReadInJoyNaviController.2;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyNavigationGridview;

public class nxi
  implements Animation.AnimationListener
{
  public nxi(ReadInJoyNaviController.2 param2) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    nxf.a(this.a.this$0, true);
    nxf.a(this.a.this$0).setAlpha(0.0F);
    nxf.a(this.a.this$0).removeView(nxf.a(this.a.this$0));
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     nxi
 * JD-Core Version:    0.7.0.1
 */