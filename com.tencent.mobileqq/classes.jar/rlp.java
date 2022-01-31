import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.AssistantSettingActivity;
import com.tencent.mobileqq.activity.aio.zhitu.ZhituManager;

public class rlp
  implements CompoundButton.OnCheckedChangeListener
{
  public rlp(AssistantSettingActivity paramAssistantSettingActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    ZhituManager.a(this.a.app).a(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     rlp
 * JD-Core Version:    0.7.0.1
 */