import android.view.animation.Animation;
import com.tencent.biz.pubaccount.readinjoy.ReadInJoyNaviController;
import com.tencent.util.AnimateUtils.AnimationAdapter;

class lbk
  extends AnimateUtils.AnimationAdapter
{
  lbk(lbj paramlbj) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    ReadInJoyNaviController.a(this.a.a.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lbk
 * JD-Core Version:    0.7.0.1
 */