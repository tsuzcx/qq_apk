import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.AssistantSettingActivity;
import com.tencent.mobileqq.doutu.DoutuManager;
import com.tencent.mobileqq.statistics.ReportController;

public class rir
  implements CompoundButton.OnCheckedChangeListener
{
  public rir(AssistantSettingActivity paramAssistantSettingActivity, DoutuManager paramDoutuManager) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqDoutuDoutuManager.a(paramBoolean);
    if (!paramBoolean)
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityAssistantSettingActivity.app, "dc00898", "", "", "0X80081DD", "0X80081DD", 0, 0, "", "", "", "");
      return;
    }
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityAssistantSettingActivity.app, "dc00898", "", "", "0X80081F1", "0X80081F1", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     rir
 * JD-Core Version:    0.7.0.1
 */