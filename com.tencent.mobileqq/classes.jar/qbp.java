import android.app.Activity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;

class qbp
  implements Animation.AnimationListener
{
  qbp(qbn paramqbn, View paramView, boolean paramBoolean, Activity paramActivity, ArticleInfo paramArticleInfo) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      if (this.jdField_a_of_type_Boolean) {
        qbn.a(this.jdField_a_of_type_Qbn, this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, false);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qbp
 * JD-Core Version:    0.7.0.1
 */