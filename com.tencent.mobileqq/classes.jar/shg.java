import android.view.View;
import com.tencent.mobileqq.activity.DiscussionInfoCardActivity;
import com.tencent.mobileqq.app.DiscussionHandler;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public class shg
  implements ActionSheet.OnButtonClickListener
{
  public shg(DiscussionInfoCardActivity paramDiscussionInfoCardActivity, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      return;
      if (NetworkUtil.d(this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity.getActivity()))
      {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity.app, "CliOper", "", "", "0X80040EA", "0X80040EA", 0, 0, "", "", "", "");
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity.app, "CliOper", "", "", "0X8006669", "0X8006669", 0, 0, "", "", "", "");
        DiscussionInfoCardActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity).c(Long.valueOf(DiscussionInfoCardActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity)).longValue());
        this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity.getString(2131435266));
        DiscussionInfoCardActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity).show();
      }
      else
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity.a(1, this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity.getString(2131434596));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     shg
 * JD-Core Version:    0.7.0.1
 */