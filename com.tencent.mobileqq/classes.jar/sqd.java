import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnticipateInterpolator;
import android.widget.ImageView;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebArticleInfo;

class sqd
  implements Animation.AnimationListener
{
  sqd(sqc paramsqc, FastWebArticleInfo paramFastWebArticleInfo) {}
  
  public void onAnimationEnd(Animation paramAnimation) {}
  
  public void onAnimationRepeat(Animation paramAnimation)
  {
    ImageView localImageView = sqc.a(this.jdField_a_of_type_Sqc);
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.a) {}
    for (int i = 2130842828;; i = 2130841656)
    {
      localImageView.setImageResource(i);
      paramAnimation.setInterpolator(new AnticipateInterpolator());
      return;
    }
  }
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sqd
 * JD-Core Version:    0.7.0.1
 */