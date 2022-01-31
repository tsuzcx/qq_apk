import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;
import com.tencent.biz.publicAccountImageCollection.PublicAccountImageCollectionMainActivity;

public class myu
  implements Animation.AnimationListener
{
  public myu(PublicAccountImageCollectionMainActivity paramPublicAccountImageCollectionMainActivity) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    paramAnimation = (ImageView)this.a.findViewById(2131365588);
    ImageView localImageView = (ImageView)this.a.findViewById(2131365589);
    PublicAccountImageCollectionMainActivity.a(this.a, localImageView, paramAnimation, 100L, 240L);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     myu
 * JD-Core Version:    0.7.0.1
 */