import android.view.animation.Animation;
import com.tencent.biz.pubaccount.readinjoy.ReadInJoyNaviController;
import com.tencent.util.AnimateUtils.AnimationAdapter;

class lde
  extends AnimateUtils.AnimationAdapter
{
  lde(ldd paramldd) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    ReadInJoyNaviController.a(this.a.a.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lde
 * JD-Core Version:    0.7.0.1
 */