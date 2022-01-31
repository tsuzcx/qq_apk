import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.ui.GAudioMembersCtrlActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.widget.ActionSheet;

public class juy
  implements View.OnClickListener
{
  public juy(GAudioMembersCtrlActivity paramGAudioMembersCtrlActivity, ActionSheet paramActionSheet) {}
  
  public void onClick(View paramView)
  {
    boolean bool = false;
    if (this.jdField_a_of_type_ComTencentAvUiGAudioMembersCtrlActivity.a.a().V) {
      if (this.jdField_a_of_type_ComTencentAvUiGAudioMembersCtrlActivity.a.a().i == 1) {
        ReportController.b(null, "CliOper", "", "", "0X8005C28", "0X8005C28", 0, 0, "", "", "", "");
      }
    }
    for (;;)
    {
      if (!this.jdField_a_of_type_ComTencentAvUiGAudioMembersCtrlActivity.a.a().V) {
        bool = true;
      }
      this.jdField_a_of_type_ComTencentAvUiGAudioMembersCtrlActivity.a.a(bool);
      this.jdField_a_of_type_ComTencentAvUiGAudioMembersCtrlActivity.a.a().V = bool;
      this.jdField_a_of_type_ComTencentAvUiGAudioMembersCtrlActivity.a();
      this.jdField_a_of_type_ComTencentAvUiGAudioMembersCtrlActivity.b();
      try
      {
        this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
        return;
      }
      catch (Throwable paramView)
      {
        paramView.printStackTrace();
      }
      if (this.jdField_a_of_type_ComTencentAvUiGAudioMembersCtrlActivity.a.a().i == 3000)
      {
        ReportController.b(null, "CliOper", "", "", "0X8005C23", "0X8005C23", 0, 0, "", "", "", "");
        continue;
        if (this.jdField_a_of_type_ComTencentAvUiGAudioMembersCtrlActivity.a.a().i == 1) {
          ReportController.b(null, "CliOper", "", "", "0X8005C27", "0X8005C27", 0, 0, "", "", "", "");
        } else if (this.jdField_a_of_type_ComTencentAvUiGAudioMembersCtrlActivity.a.a().i == 3000) {
          ReportController.b(null, "CliOper", "", "", "0X8005C22", "0X8005C22", 0, 0, "", "", "", "");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     juy
 * JD-Core Version:    0.7.0.1
 */