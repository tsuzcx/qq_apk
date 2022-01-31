import android.view.animation.Animation;
import com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabFrame;
import com.tencent.util.AnimateUtils.AnimationAdapter;

class mnq
  extends AnimateUtils.AnimationAdapter
{
  mnq(mnp parammnp) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    ReadinjoyTabFrame.a(this.a.a, true);
    if (ReadinjoyTabFrame.a(this.a.a) != null) {
      ReadinjoyTabFrame.a(this.a.a, ReadinjoyTabFrame.a(this.a.a), ReadinjoyTabFrame.a(this.a.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mnq
 * JD-Core Version:    0.7.0.1
 */