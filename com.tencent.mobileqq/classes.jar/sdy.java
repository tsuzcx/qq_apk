import android.content.res.Resources;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.widget.immersive.ImmersiveTitleBar2;

public class sdy
  implements Animation.AnimationListener
{
  public sdy(ChatSettingForTroop paramChatSettingForTroop) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (this.a.jdField_a_of_type_AndroidWidgetRelativeLayout == null) {
      return;
    }
    if (paramAnimation == this.a.jdField_b_of_type_AndroidViewAnimationAlphaAnimation)
    {
      this.a.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(4);
      this.a.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2.setVisibility(4);
      this.a.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.a.getResources().getColor(2131494188));
      this.a.jdField_b_of_type_AndroidWidgetTextView.setTextColor(this.a.getResources().getColor(2131494188));
    }
    this.a.jdField_a_of_type_AndroidWidgetRelativeLayout.clearAnimation();
    this.a.jdField_a_of_type_AndroidWidgetRelativeLayout.setFocusable(true);
    this.a.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2.clearAnimation();
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    if (this.a.jdField_a_of_type_AndroidWidgetRelativeLayout == null) {}
    while (paramAnimation != this.a.jdField_a_of_type_AndroidViewAnimationAlphaAnimation) {
      return;
    }
    this.a.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    this.a.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2.setVisibility(0);
    this.a.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.a.getResources().getColor(2131494210));
    this.a.jdField_b_of_type_AndroidWidgetTextView.setTextColor(this.a.getResources().getColor(2131494210));
    this.a.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     sdy
 * JD-Core Version:    0.7.0.1
 */