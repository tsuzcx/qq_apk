import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.AssistantSettingActivity;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;

public class rlz
  implements CompoundButton.OnCheckedChangeListener
{
  public rlz(AssistantSettingActivity paramAssistantSettingActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    SettingCloneUtil.writeValue(this.a, null, this.a.getString(2131433572), "qqsetting_auto_receive_magic_face_key", paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     rlz
 * JD-Core Version:    0.7.0.1
 */