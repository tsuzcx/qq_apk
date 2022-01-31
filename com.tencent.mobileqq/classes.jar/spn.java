import android.app.Dialog;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.TranslateAnimation;
import com.tencent.mobileqq.activity.DiscussionMemberActivity;

public class spn
  implements Animation.AnimationListener
{
  public spn(DiscussionMemberActivity paramDiscussionMemberActivity, TranslateAnimation paramTranslateAnimation1, Dialog paramDialog, TranslateAnimation paramTranslateAnimation2, int paramInt) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (paramAnimation == this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation)
    {
      this.jdField_a_of_type_AndroidAppDialog.show();
      this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionMemberActivity.a.setAnimation(null);
      DiscussionMemberActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionMemberActivity).setVisibility(8);
    }
    while (paramAnimation != this.b) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionMemberActivity.a.setAnimation(null);
    this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionMemberActivity.a.offsetTopAndBottom(this.jdField_a_of_type_Int);
    this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionMemberActivity.a.requestLayout();
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     spn
 * JD-Core Version:    0.7.0.1
 */