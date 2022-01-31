import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.AssistantSettingActivity;
import com.tencent.mobileqq.qcall.PstnManager;

public class rld
  implements CompoundButton.OnCheckedChangeListener
{
  public rld(AssistantSettingActivity paramAssistantSettingActivity, PstnManager paramPstnManager) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqQcallPstnManager.a(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     rld
 * JD-Core Version:    0.7.0.1
 */