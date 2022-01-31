import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.TextView;
import com.tencent.mobileqq.activity.ChatHistoryForC2C;
import com.tencent.mobileqq.activity.messagesearch.C2CMessageSearchDialog;

public class sbc
  implements Animation.AnimationListener
{
  public sbc(ChatHistoryForC2C paramChatHistoryForC2C, View paramView1, View paramView2) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryForC2C.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchC2CMessageSearchDialog.show();
    this.jdField_a_of_type_AndroidViewView.setAnimation(null);
    this.b.setVisibility(8);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryForC2C.jdField_a_of_type_AndroidWidgetTextView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryForC2C.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     sbc
 * JD-Core Version:    0.7.0.1
 */