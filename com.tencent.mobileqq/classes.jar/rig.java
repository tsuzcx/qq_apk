import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.AssistantSettingActivity;
import com.tencent.mobileqq.qcall.PstnManager;

public class rig
  implements CompoundButton.OnCheckedChangeListener
{
  public rig(AssistantSettingActivity paramAssistantSettingActivity, PstnManager paramPstnManager) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqQcallPstnManager.a(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     rig
 * JD-Core Version:    0.7.0.1
 */