import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;
import com.tencent.biz.publicAccountImageCollection.PublicAccountImageCollectionMainActivity;

public class sbt
  implements Animation.AnimationListener
{
  public sbt(PublicAccountImageCollectionMainActivity paramPublicAccountImageCollectionMainActivity) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    paramAnimation = (ImageView)this.a.findViewById(2131312925);
    ImageView localImageView = (ImageView)this.a.findViewById(2131312926);
    PublicAccountImageCollectionMainActivity.a(this.a, localImageView, paramAnimation, 100L, 240L);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     sbt
 * JD-Core Version:    0.7.0.1
 */