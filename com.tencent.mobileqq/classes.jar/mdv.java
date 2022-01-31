import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.av.VideoController;
import com.tencent.av.ui.GAudioMembersCtrlActivity;

public class mdv
  implements View.OnClickListener
{
  public mdv(GAudioMembersCtrlActivity paramGAudioMembersCtrlActivity, bfpc parambfpc) {}
  
  public void onClick(View paramView)
  {
    boolean bool = false;
    if (this.jdField_a_of_type_ComTencentAvUiGAudioMembersCtrlActivity.a.a().U) {
      if (this.jdField_a_of_type_ComTencentAvUiGAudioMembersCtrlActivity.a.a().i == 1) {
        axqy.b(null, "CliOper", "", "", "0X8005C28", "0X8005C28", 0, 0, "", "", "", "");
      }
    }
    for (;;)
    {
      if (!this.jdField_a_of_type_ComTencentAvUiGAudioMembersCtrlActivity.a.a().U) {
        bool = true;
      }
      this.jdField_a_of_type_ComTencentAvUiGAudioMembersCtrlActivity.a.b(bool);
      this.jdField_a_of_type_ComTencentAvUiGAudioMembersCtrlActivity.a.a().b("OnClick", bool);
      this.jdField_a_of_type_ComTencentAvUiGAudioMembersCtrlActivity.a();
      this.jdField_a_of_type_ComTencentAvUiGAudioMembersCtrlActivity.b();
      try
      {
        this.jdField_a_of_type_Bfpc.dismiss();
        return;
      }
      catch (Throwable paramView)
      {
        paramView.printStackTrace();
      }
      if (this.jdField_a_of_type_ComTencentAvUiGAudioMembersCtrlActivity.a.a().i == 3000)
      {
        axqy.b(null, "CliOper", "", "", "0X8005C23", "0X8005C23", 0, 0, "", "", "", "");
        continue;
        if (this.jdField_a_of_type_ComTencentAvUiGAudioMembersCtrlActivity.a.a().i == 1) {
          axqy.b(null, "CliOper", "", "", "0X8005C27", "0X8005C27", 0, 0, "", "", "", "");
        } else if (this.jdField_a_of_type_ComTencentAvUiGAudioMembersCtrlActivity.a.a().i == 3000) {
          axqy.b(null, "CliOper", "", "", "0X8005C22", "0X8005C22", 0, 0, "", "", "", "");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     mdv
 * JD-Core Version:    0.7.0.1
 */