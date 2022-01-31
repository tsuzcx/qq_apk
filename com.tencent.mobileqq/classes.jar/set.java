import android.view.View;
import com.tencent.mobileqq.activity.ChatHistoryFileActivity;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public class set
  implements ActionSheet.OnButtonClickListener
{
  public set(ChatHistoryFileActivity paramChatHistoryFileActivity, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if ((!this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryFileActivity.a(3, this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryFileActivity.a, this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryFileActivity.b, this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryFileActivity.c)) || (this.jdField_a_of_type_ComTencentWidgetActionSheet.isShowing())) {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     set
 * JD-Core Version:    0.7.0.1
 */