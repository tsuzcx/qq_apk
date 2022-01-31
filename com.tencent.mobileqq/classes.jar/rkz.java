import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnticipateInterpolator;
import android.widget.ImageView;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebArticleInfo;

class rkz
  implements Animation.AnimationListener
{
  rkz(rkv paramrkv, FastWebArticleInfo paramFastWebArticleInfo) {}
  
  public void onAnimationEnd(Animation paramAnimation) {}
  
  public void onAnimationRepeat(Animation paramAnimation)
  {
    ImageView localImageView = rkv.c(this.jdField_a_of_type_Rkv);
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.a) {}
    for (int i = 2130842306;; i = 2130841221)
    {
      localImageView.setImageResource(i);
      paramAnimation.setInterpolator(new AnticipateInterpolator());
      return;
    }
  }
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rkz
 * JD-Core Version:    0.7.0.1
 */