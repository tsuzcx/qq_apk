import android.view.View;
import com.tencent.mobileqq.activity.FriendProfilePicBrowserActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public class stp
  implements ActionSheet.OnButtonClickListener
{
  public stp(FriendProfilePicBrowserActivity paramFriendProfilePicBrowserActivity, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      FriendProfilePicBrowserActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfilePicBrowserActivity);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfilePicBrowserActivity.app, "dc00898", "", "", "0X8007C14", "0X8007C14", this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfilePicBrowserActivity.a, 0, "", "", "", "");
      return;
    }
    FriendProfilePicBrowserActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfilePicBrowserActivity);
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfilePicBrowserActivity.app, "dc00898", "", "", "0X8007C15", "0X8007C15", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     stp
 * JD-Core Version:    0.7.0.1
 */