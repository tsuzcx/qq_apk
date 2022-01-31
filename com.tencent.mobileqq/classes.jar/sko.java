import android.view.View;
import com.tencent.mobileqq.activity.DiscussionInfoCardActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.util.TroopReportor;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public class sko
  implements ActionSheet.OnButtonClickListener
{
  public sko(DiscussionInfoCardActivity paramDiscussionInfoCardActivity, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_ComTencentWidgetActionSheet != null) && (this.jdField_a_of_type_ComTencentWidgetActionSheet.isShowing()) && (!this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity.isFinishing()))
      {
        this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
        this.jdField_a_of_type_ComTencentWidgetActionSheet.cancel();
      }
      return;
      this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity.c();
      continue;
      ProfileCardUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity, DiscussionInfoCardActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity), null, this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity.app.getCurrentAccountUin(), 1014, null);
      TroopReportor.a("Grp_Dis_set", "Dis_info", "clk_report", 0, 0, new String[] { DiscussionInfoCardActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity), TroopReportor.a(this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity.app, this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity.a) });
      continue;
      DiscussionInfoCardActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     sko
 * JD-Core Version:    0.7.0.1
 */