import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.AssistantSettingActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ark.ArkAiAppCenter;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.ark.ArkAppDataReport;

public class rlf
  implements CompoundButton.OnCheckedChangeListener
{
  public rlf(AssistantSettingActivity paramAssistantSettingActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    paramCompoundButton = (ArkAppCenter)this.a.app.getManager(120);
    if (paramCompoundButton != null)
    {
      paramCompoundButton.a().a(this.a.app, paramBoolean);
      if (!paramBoolean) {
        ArkAppDataReport.a();
      }
    }
    else
    {
      return;
    }
    ArkAppDataReport.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     rlf
 * JD-Core Version:    0.7.0.1
 */