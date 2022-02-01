import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.av.VideoController;
import com.tencent.av.ui.GAudioMembersCtrlActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class meq
  implements View.OnClickListener
{
  public meq(GAudioMembersCtrlActivity paramGAudioMembersCtrlActivity, bkzi parambkzi) {}
  
  public void onClick(View paramView)
  {
    boolean bool = false;
    if (this.jdField_a_of_type_ComTencentAvUiGAudioMembersCtrlActivity.a.a().W) {
      if (this.jdField_a_of_type_ComTencentAvUiGAudioMembersCtrlActivity.a.a().j == 1) {
        bdla.b(null, "CliOper", "", "", "0X8005C28", "0X8005C28", 0, 0, "", "", "", "");
      }
    }
    for (;;)
    {
      if (!this.jdField_a_of_type_ComTencentAvUiGAudioMembersCtrlActivity.a.a().W) {
        bool = true;
      }
      this.jdField_a_of_type_ComTencentAvUiGAudioMembersCtrlActivity.a.b(bool);
      this.jdField_a_of_type_ComTencentAvUiGAudioMembersCtrlActivity.a.a().c("OnClick", bool);
      this.jdField_a_of_type_ComTencentAvUiGAudioMembersCtrlActivity.a();
      this.jdField_a_of_type_ComTencentAvUiGAudioMembersCtrlActivity.b();
      try
      {
        this.jdField_a_of_type_Bkzi.dismiss();
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        if (this.jdField_a_of_type_ComTencentAvUiGAudioMembersCtrlActivity.a.a().j != 3000) {
          continue;
        }
        bdla.b(null, "CliOper", "", "", "0X8005C23", "0X8005C23", 0, 0, "", "", "", "");
        continue;
        if (this.jdField_a_of_type_ComTencentAvUiGAudioMembersCtrlActivity.a.a().j == 1)
        {
          bdla.b(null, "CliOper", "", "", "0X8005C27", "0X8005C27", 0, 0, "", "", "", "");
          continue;
        }
        if (this.jdField_a_of_type_ComTencentAvUiGAudioMembersCtrlActivity.a.a().j != 3000) {
          continue;
        }
        bdla.b(null, "CliOper", "", "", "0X8005C22", "0X8005C22", 0, 0, "", "", "", "");
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          localThrowable.printStackTrace();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     meq
 * JD-Core Version:    0.7.0.1
 */