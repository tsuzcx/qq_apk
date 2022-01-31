import android.widget.CompoundButton;
import com.tencent.mobileqq.activity.AssistantSettingActivity;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.Switch;

public class riv
  extends CardObserver
{
  public riv(AssistantSettingActivity paramAssistantSettingActivity) {}
  
  protected void a(boolean paramBoolean)
  {
    int i = 1;
    boolean bool = false;
    if (!paramBoolean)
    {
      QQToast.a(this.a.app.getApp(), 1, this.a.getString(2131436049), 3000).b(this.a.getTitleBarHeight());
      localObject1 = this.a;
      localObject2 = AssistantSettingActivity.a(this.a).a();
      paramBoolean = bool;
      if (!AssistantSettingActivity.a(this.a).a().isChecked()) {
        paramBoolean = true;
      }
      AssistantSettingActivity.a((AssistantSettingActivity)localObject1, (CompoundButton)localObject2, paramBoolean);
      if (QLog.isColorLevel()) {
        QLog.d("IphoneTitleBarActivity", 2, "AssistantSettingActivity onSetMedal failed");
      }
      return;
    }
    Object localObject1 = ((FriendsManager)this.a.app.getManager(50)).b(this.a.app.getCurrentAccountUin());
    if (!this.a.isFinishing())
    {
      localObject2 = this.a;
      Switch localSwitch = AssistantSettingActivity.a(this.a).a();
      if (((Card)localObject1).medalSwitchDisable) {
        break label260;
      }
      paramBoolean = true;
      AssistantSettingActivity.a((AssistantSettingActivity)localObject2, localSwitch, paramBoolean);
      if (QLog.isColorLevel()) {
        QLog.d("IphoneTitleBarActivity", 2, "AssistantSettingActivity onSetMedal medalSwitchDisable= " + ((Card)localObject1).medalSwitchDisable);
      }
    }
    Object localObject2 = this.a.app;
    if (((Card)localObject1).medalSwitchDisable) {}
    for (;;)
    {
      ReportController.b((QQAppInterface)localObject2, "dc00898", "", "", "0X80073A0", "0X80073A0", i, 0, "", "", "", "");
      return;
      label260:
      paramBoolean = false;
      break;
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     riv
 * JD-Core Version:    0.7.0.1
 */