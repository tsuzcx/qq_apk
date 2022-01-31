import android.app.Application;
import android.content.res.Resources;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.PermisionPrivacyActivity;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.app.activateFriends.ActivateFriendsManager;
import com.tencent.mobileqq.contactsync.ContactSyncManager;
import com.tencent.mobileqq.qcall.LightalkSwitchHanlder;
import com.tencent.mobileqq.richstatus.StatusManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQProgressNotifier;
import com.tencent.mobileqq.widget.QQToast;
import mqq.app.MobileQQ;

public class tci
  implements CompoundButton.OnCheckedChangeListener
{
  public tci(PermisionPrivacyActivity paramPermisionPrivacyActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    Object localObject;
    if (((paramCompoundButton == this.a.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.a()) || (paramCompoundButton == PermisionPrivacyActivity.b(this.a)) || (paramCompoundButton == PermisionPrivacyActivity.a(this.a)) || (paramCompoundButton == this.a.b.a()) || (paramCompoundButton == this.a.d.a()) || (paramCompoundButton == this.a.i.a())) && (!NetworkUtil.d(this.a.getActivity())))
    {
      this.a.a(2131434595, 1);
      localObject = this.a;
      if (!paramBoolean)
      {
        paramBoolean = true;
        PermisionPrivacyActivity.a((PermisionPrivacyActivity)localObject, paramCompoundButton, paramBoolean);
      }
    }
    int i;
    label417:
    label751:
    do
    {
      do
      {
        return;
        paramBoolean = false;
        break;
        if (paramCompoundButton == this.a.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.a())
        {
          if (AppSetting.b) {
            this.a.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription("允许附近的人赞我");
          }
          if (paramBoolean) {}
          for (i = 1;; i = 0)
          {
            ReportController.b(this.a.app, "CliOper", "", "", "Setting_tab", "Nearby_likeme", 0, i, String.valueOf(i), "", "", "");
            this.a.app.d(true, paramBoolean);
            return;
          }
        }
        if (paramCompoundButton == this.a.jdField_a_of_type_AndroidWidgetCompoundButton)
        {
          if (!NetworkUtil.d(this.a.app.getApplication().getApplicationContext()))
          {
            QQToast.a(this.a.getApplicationContext(), 2131434794, 1).a();
            this.a.jdField_a_of_type_AndroidWidgetCompoundButton.setOnCheckedChangeListener(null);
            paramCompoundButton = this.a.jdField_a_of_type_AndroidWidgetCompoundButton;
            if (this.a.app.e() == 1) {}
            for (paramBoolean = true;; paramBoolean = false)
            {
              paramCompoundButton.setChecked(paramBoolean);
              this.a.jdField_a_of_type_AndroidWidgetCompoundButton.setOnCheckedChangeListener(this.a.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
              return;
            }
          }
          if (paramBoolean)
          {
            i = 1;
            ReportController.b(this.a.app, "CliOper", "", "", "Setting_tab", "Latest_chatlog_syn", 0, i, String.valueOf(i), "", "", "");
            this.a.a(this.a.getApplication().getResources().getString(2131436208));
            if (!paramBoolean) {
              break label417;
            }
          }
          for (i = 1;; i = 0)
          {
            this.a.app.g(i);
            return;
            i = 0;
            break;
          }
        }
        if (paramCompoundButton == PermisionPrivacyActivity.b(this.a))
        {
          if (paramBoolean) {}
          for (i = 1;; i = 0)
          {
            ReportController.b(this.a.app, "CliOper", "", "", "Setting_tab", "Visible_same", 0, i, String.valueOf(i), "", "", "");
            this.a.app.b(paramBoolean, false);
            this.a.a(paramBoolean);
            return;
          }
        }
        if (paramCompoundButton == PermisionPrivacyActivity.a(this.a))
        {
          if (paramBoolean) {}
          for (i = 1;; i = 0)
          {
            ReportController.b(this.a.app, "CliOper", "", "", "Setting_tab", "Same_likeme", 0, i, String.valueOf(i), "", "", "");
            this.a.app.d(false, paramBoolean);
            return;
          }
        }
        if (paramCompoundButton == this.a.g.a())
        {
          if (paramBoolean) {}
          for (i = 1;; i = 0)
          {
            ReportController.b(this.a.app, "CliOper", "", "", "Setting_tab", "Clk_signature_qzone", 0, i, String.valueOf(i), "", "", "");
            if ((!NetworkUtil.d(this.a.getActivity())) || (PermisionPrivacyActivity.a(this.a) == null)) {
              break;
            }
            if (AppSetting.b) {
              this.a.g.setContentDescription("个性签名同步到说说");
            }
            PermisionPrivacyActivity.a(this.a).a(paramBoolean);
            return;
          }
          paramCompoundButton = this.a;
          if (PermisionPrivacyActivity.a(this.a) != null)
          {
            i = 2131434595;
            PermisionPrivacyActivity.a(paramCompoundButton, i);
            paramCompoundButton = this.a;
            localObject = this.a.g.a();
            if (paramBoolean) {
              break label751;
            }
          }
          for (paramBoolean = true;; paramBoolean = false)
          {
            PermisionPrivacyActivity.a(paramCompoundButton, (CompoundButton)localObject, paramBoolean);
            return;
            i = 2131436049;
            break;
          }
        }
        if (paramCompoundButton == this.a.f.a())
        {
          if (AppSetting.b) {
            this.a.f.setContentDescription("可通过系统通讯录发起QQ聊天");
          }
          ((ContactSyncManager)this.a.app.getManager(40)).a(paramBoolean);
          return;
        }
        if (paramCompoundButton == this.a.b.a())
        {
          if (AppSetting.b) {
            this.a.b.setContentDescription("向好友展示网络状态");
          }
          PermisionPrivacyActivity.a(this.a, this.a.b.a(), paramBoolean);
          this.a.app.c(paramBoolean, true);
          return;
        }
        if (paramCompoundButton == this.a.d.a())
        {
          if (AppSetting.b) {
            this.a.d.setContentDescription("在联系人展示可能认识的人");
          }
          this.a.b(paramBoolean);
          paramCompoundButton = (CardHandler)this.a.app.a(2);
          if (paramBoolean) {}
          for (short s = 0;; s = 1)
          {
            paramCompoundButton.a((short)-23447, s);
            if (!paramBoolean) {
              break;
            }
            ReportController.b(this.a.app, "dc00898", "", "", "0X80084F9", "0X80084F9", 0, 0, "", "", "", "");
            return;
          }
          ReportController.b(this.a.app, "dc00898", "", "", "0X80084F8", "0X80084F8", 0, 0, "", "", "", "");
          return;
        }
        if (paramCompoundButton != this.a.i.a()) {
          break label1214;
        }
        PermisionPrivacyActivity.a(this.a, this.a.i.a(), paramBoolean);
        if (AppSetting.b) {
          this.a.i.setContentDescription("接收来电消息");
        }
        if (!paramBoolean) {
          break label1176;
        }
        ReportController.b(this.a.app, "CliOper", "", "", "0X8004E71", "0X8004E71", 0, 0, "", "", "", "");
        paramCompoundButton = (LightalkSwitchHanlder)this.a.app.a(52);
      } while (paramCompoundButton == null);
      if (paramBoolean) {}
      for (byte b = 0;; b = 1)
      {
        paramCompoundButton.a(b);
        if ((!this.a.isResume()) || (this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier == null) || (this.a.isFinishing())) {
          break;
        }
        this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.a(0, 2131434436, 1000);
        return;
        ReportController.b(this.a.app, "CliOper", "", "", "0X8004E72", "0X8004E72", 0, 0, "", "", "", "");
        break label1098;
      }
      if (paramCompoundButton == this.a.h.a())
      {
        PermisionPrivacyActivity.a(this.a, this.a.h.a(), paramBoolean);
        PermisionPrivacyActivity.a(this.a).a(paramBoolean, true);
        return;
      }
      if (paramCompoundButton == this.a.c.a())
      {
        paramCompoundButton = this.a.app;
        if (paramBoolean) {}
        for (i = 1;; i = 0)
        {
          ReportController.b(paramCompoundButton, "CliOper", "", "", "0X800487E", "0X800487E", 0, 0, String.valueOf(i), "", "", "");
          if (!NetworkUtil.d(this.a.getActivity())) {
            break;
          }
          if (AppSetting.b) {
            this.a.c.setContentDescription("连续登录天数对他人可见");
          }
          ((CardHandler)this.a.app.a(2)).f(paramBoolean);
          return;
        }
        paramCompoundButton = this.a;
        if (PermisionPrivacyActivity.a(this.a) != null)
        {
          i = 2131434595;
          PermisionPrivacyActivity.a(paramCompoundButton, i);
          paramCompoundButton = this.a;
          localObject = this.a.c.a();
          if (paramBoolean) {
            break label1437;
          }
        }
        for (paramBoolean = true;; paramBoolean = false)
        {
          PermisionPrivacyActivity.a(paramCompoundButton, (CompoundButton)localObject, paramBoolean);
          return;
          i = 2131436049;
          break;
        }
      }
    } while (paramCompoundButton != this.a.e.a());
    label1098:
    if ((paramCompoundButton.getTag() != null) && (((Boolean)paramCompoundButton.getTag()).booleanValue()))
    {
      paramCompoundButton.setTag(Boolean.FALSE);
      return;
    }
    label1176:
    label1214:
    this.a.jdField_a_of_type_ComTencentMobileqqAppTroopHandler.a(paramBoolean);
    label1437:
    paramCompoundButton = this.a.jdField_a_of_type_AndroidWidgetTextView;
    if (paramBoolean)
    {
      i = 2131435375;
      paramCompoundButton.setText(i);
      localObject = this.a.app;
      if (!paramBoolean) {
        break label1571;
      }
    }
    label1571:
    for (paramCompoundButton = "open_autopass";; paramCompoundButton = "close_autopass")
    {
      ReportController.b((QQAppInterface)localObject, "dc00899", "Grp_invite_friend", "", "auto_pass", paramCompoundButton, 0, 0, "", "", "", "");
      return;
      i = 2131435376;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tci
 * JD-Core Version:    0.7.0.1
 */