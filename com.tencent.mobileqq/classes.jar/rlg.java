import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.AssistantSettingActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.flashchat.FlashChatManager;

public class rlg
  implements CompoundButton.OnCheckedChangeListener
{
  public rlg(AssistantSettingActivity paramAssistantSettingActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    paramCompoundButton = (FlashChatManager)this.a.app.getManager(216);
    if (paramCompoundButton != null) {
      paramCompoundButton.b(paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     rlg
 * JD-Core Version:    0.7.0.1
 */