import android.app.Activity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;

class pls
  implements Animation.AnimationListener
{
  pls(plq paramplq, View paramView, boolean paramBoolean, Activity paramActivity, ArticleInfo paramArticleInfo) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      if (this.jdField_a_of_type_Boolean) {
        plq.a(this.jdField_a_of_type_Plq, this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, false);
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_AndroidViewView.setVisibility(4);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     pls
 * JD-Core Version:    0.7.0.1
 */