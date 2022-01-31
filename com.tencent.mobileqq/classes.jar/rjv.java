import android.view.View;
import com.tencent.mobileqq.activity.AssociatedAccountActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public class rjv
  implements ActionSheet.OnButtonClickListener
{
  public rjv(AssociatedAccountActivity paramAssociatedAccountActivity, boolean paramBoolean, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    int i = paramInt;
    if (!this.jdField_a_of_type_Boolean) {
      i = paramInt + 1;
    }
    this.jdField_a_of_type_ComTencentWidgetActionSheet.cancel();
    switch (i)
    {
    default: 
      return;
    case 0: 
      AssociatedAccountActivity.c(this.jdField_a_of_type_ComTencentMobileqqActivityAssociatedAccountActivity);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityAssociatedAccountActivity.app, "CliOper", "", "", "0X8007149", "0X8007149", 0, 0, "", "", "", "");
      return;
    case 1: 
      AssociatedAccountActivity.d(this.jdField_a_of_type_ComTencentMobileqqActivityAssociatedAccountActivity);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityAssociatedAccountActivity.app, "CliOper", "", "", "0X8007145", "0X8007145", 0, 0, "", "", "", "");
      return;
    }
    AssociatedAccountActivity.e(this.jdField_a_of_type_ComTencentMobileqqActivityAssociatedAccountActivity);
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityAssociatedAccountActivity.app, "CliOper", "", "", "0X8007148", "0X8007148", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     rjv
 * JD-Core Version:    0.7.0.1
 */