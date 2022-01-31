import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.biz.pubaccount.Advertisement.view.VideoCoverView;

public class nkd
  implements ValueAnimator.AnimatorUpdateListener
{
  public nkd(VideoCoverView paramVideoCoverView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f1 = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    this.a.setRotation(90.0F * f1);
    float f2 = VideoCoverView.c(this.a) * 1.0F / VideoCoverView.d(this.a);
    this.a.setScaleX((f2 - 1.0F) * f1 + 1.0F);
    this.a.setScaleY(f1 * 0.7774618F + 1.0F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     nkd
 * JD-Core Version:    0.7.0.1
 */