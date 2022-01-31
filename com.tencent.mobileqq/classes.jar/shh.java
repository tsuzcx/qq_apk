import android.view.View;
import com.tencent.mobileqq.activity.DiscussionInfoCardActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public class shh
  implements ActionSheet.OnButtonClickListener
{
  public shh(DiscussionInfoCardActivity paramDiscussionInfoCardActivity, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
    switch (paramInt)
    {
    default: 
      return;
    }
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity.app, "P_CliOper", "Grp_discuss", "", "0X80040ED", "0X80040ED", 0, 0, "", "", "", "");
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity.app, "CliOper", "", "", "0X8006623", "0X8006623", 0, 0, "", "", "", "");
    this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity.g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     shh
 * JD-Core Version:    0.7.0.1
 */