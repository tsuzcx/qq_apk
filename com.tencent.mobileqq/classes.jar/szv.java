import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnticipateInterpolator;
import android.widget.ImageView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyFastWebBottomSocialView;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebArticleInfo;

public class szv
  implements Animation.AnimationListener
{
  public szv(ReadInJoyFastWebBottomSocialView paramReadInJoyFastWebBottomSocialView) {}
  
  public void onAnimationEnd(Animation paramAnimation) {}
  
  public void onAnimationRepeat(Animation paramAnimation)
  {
    ImageView localImageView = ReadInJoyFastWebBottomSocialView.a(this.a);
    if (ReadInJoyFastWebBottomSocialView.a(this.a).a) {}
    for (int i = 2130842914;; i = 2130842916)
    {
      localImageView.setImageResource(i);
      paramAnimation.setInterpolator(new AnticipateInterpolator());
      return;
    }
  }
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     szv
 * JD-Core Version:    0.7.0.1
 */