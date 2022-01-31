import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.AssistantSettingActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.qphone.base.util.BaseApplication;

public class rin
  implements CompoundButton.OnCheckedChangeListener
{
  public rin(AssistantSettingActivity paramAssistantSettingActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (AppSetting.b) {
      this.a.b.setContentDescription("加入寻找丢失儿童项目");
    }
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      SettingCloneUtil.writeValueForInt(BaseApplication.getContext(), this.a.app.getCurrentAccountUin(), null, "qqsetting_antilost_key", i);
      AssistantSettingActivity.a(this.a, paramBoolean);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     rin
 * JD-Core Version:    0.7.0.1
 */