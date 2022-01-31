import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ForwardFriendListActivity;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.contact.troop.TroopActivity;
import com.tencent.mobileqq.activity.phone.GuideBindPhoneActivity;
import com.tencent.mobileqq.activity.phone.PhoneFrameActivity;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.forward.ForwardAbility.ForwardAbilityType;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.ReportTask;

public class snu
  implements View.OnClickListener
{
  public snu(ForwardRecentActivity paramForwardRecentActivity) {}
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i == 2131368322) {
      ForwardRecentActivity.a(this.a, 10);
    }
    Intent localIntent;
    label139:
    label397:
    do
    {
      do
      {
        return;
        if (i == 2131363428)
        {
          if (this.a.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption != null)
          {
            this.a.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption.a(false);
            PhoneContactManagerImp.g = false;
          }
          this.a.finish();
          return;
        }
        localIntent = new Intent();
        localIntent.putExtra("call_by_forward", true);
        if (this.a.jdField_a_of_type_AndroidNetUri != null) {
          localIntent.setData(this.a.jdField_a_of_type_AndroidNetUri);
        }
        Bundle localBundle = this.a.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption.a();
        if (localBundle.getBoolean("sendMultiple", false))
        {
          localIntent.putStringArrayListExtra("foward_key_m_p_l", localBundle.getStringArrayList("foward_key_m_p_l"));
          localIntent.putExtras(this.a.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption.a());
          if (!this.a.getIntent().getBooleanExtra("isFromShare", false)) {
            break label397;
          }
          localIntent.putExtras(this.a.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption.a());
          localIntent.setAction(this.a.getIntent().getAction());
        }
        for (;;)
        {
          switch (paramView.getId())
          {
          default: 
            return;
          case 2131363908: 
            localIntent.putExtra("onlyOneSegement", true);
            localIntent.putExtra("_key_mode", 0);
            localIntent.putExtra("key_tab_mode", 1);
            localIntent.setClass(this.a, TroopActivity.class);
            this.a.startActivityForResult(localIntent, 20000);
            ReportController.b(this.a.app, "CliOper", "", "", "0X800404C", "0X800404C", 0, 0, "", "", "", "");
            return;
            localIntent.putExtra("forward_filepath", localBundle.getString("forward_filepath"));
            break label139;
            localIntent.putExtras(this.a.getIntent().getExtras());
          }
        }
        if (((PhoneContactManagerImp)this.a.app.getManager(10)).f())
        {
          localIntent.setClass(this.a, PhoneFrameActivity.class);
          localIntent.putExtra("key_req_type", 2);
          paramView = this.a.getIntent();
          if ((paramView != null) && (paramView.hasExtra("forward_type"))) {
            localIntent.putExtra("forward_type", paramView.getIntExtra("forward_type", 2147483647));
          }
          this.a.startActivityForResult(localIntent, 20000);
          ReportController.b(this.a.app, "CliOper", "", "", "0X8007011", "0X8007011", 0, 0, "", "", "", "");
          this.a.getSharedPreferences(this.a.app.getCurrentAccountUin(), 0).edit().putBoolean("forward_share_card", false).commit();
          ForwardRecentActivity.a(this.a).findViewById(2131364648).setVisibility(8);
          return;
        }
        paramView = new Intent(this.a, GuideBindPhoneActivity.class);
        this.a.startActivity(paramView);
        return;
        localIntent.putExtra("onlyOneSegement", true);
        localIntent.putExtra("_key_mode", 1);
        localIntent.putExtra("key_tab_mode", 1);
        localIntent.setClass(this.a, TroopActivity.class);
        this.a.startActivityForResult(localIntent, 20000);
        ReportController.b(this.a.app, "CliOper", "", "", "0X800404D", "0X800404D", 0, 0, "", "", "", "");
        return;
        this.a.a("0X8007824");
        ReportController.b(this.a.app, "CliOper", "", "", "0X800665F", "0X800665F", 0, 0, "", "", "", "");
        localIntent.setClass(this.a, ForwardFriendListActivity.class);
        localIntent.putExtra("extra_choose_friend", 5);
        this.a.startActivityForResult(localIntent, 20000);
        ReportController.b(this.a.app, "CliOper", "", "", "Two_call", "Tc_msg_cate", 0, 0, "0", "", "", "");
        ReportController.b(this.a.app, "CliOper", "", "", "0X800404A", "0X800404A", 0, 0, "", "", "", "");
      } while (!this.a.jdField_c_of_type_Boolean);
      if ((this.a.b == 1) && (this.a.jdField_c_of_type_Int == 1))
      {
        ReportController.b(this.a.app, "P_CliOper", "Vip_pay_mywallet", "", "wallet", "autofriendpay.buyerselectpage.select", 0, 0, "", "", "", "");
        return;
      }
    } while ((this.a.b != 1) || (this.a.jdField_c_of_type_Int != 2));
    ReportController.b(this.a.app, "P_CliOper", "Vip_pay_mywallet", "", "wallet", "autofriendpay.payerselectpage.select", 0, 0, "", "", "", "");
    return;
    paramView = new Bundle();
    paramView.putString("uin", String.valueOf("-1010"));
    paramView.putInt("uintype", -1);
    this.a.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption.a(ForwardAbility.ForwardAbilityType.e.intValue(), paramView);
    ReportController.b(this.a.app, "CliOper", "", "", "0X800404E", "0X800404E", 0, 0, "", "", "", "");
    return;
    this.a.a("0X8007826");
    int m = 1;
    int k = 99;
    boolean bool = false;
    if (!this.a.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption.f()) {}
    for (int j = 1;; j = 0)
    {
      i = j;
      if (!this.a.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption.a(ForwardAbility.ForwardAbilityType.c))
      {
        i = j;
        if (!this.a.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption.a(ForwardAbility.ForwardAbilityType.d)) {
          i = 1;
        }
      }
      j = m;
      if (!this.a.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption.a(ForwardAbility.ForwardAbilityType.b)) {
        j = 2;
      }
      if (!this.a.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption.a(ForwardAbility.ForwardAbilityType.h)) {
        bool = true;
      }
      if (this.a.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption.d())
      {
        k = 1;
        i = 1;
      }
      paramView = new Intent(this.a, SelectMemberActivity.class);
      paramView.putExtra("param_type", 3000);
      paramView.putExtra("param_subtype", 0);
      paramView.putExtra("param_done_button_wording", this.a.getString(2131435964));
      paramView.putExtra("param_done_button_highlight_wording", this.a.getString(2131435965));
      paramView.putExtra("param_min", j);
      paramView.putExtra("param_max", k);
      paramView.putExtra("param_donot_need_contacts", bool);
      if (i != 0)
      {
        paramView.putExtra("param_donot_need_troop", true);
        paramView.putExtra("param_donot_need_discussion", true);
      }
      paramView.putExtra("param_entrance", 12);
      this.a.startActivityForResult(paramView, 20003);
      ReportController.b(this.a.app, "CliOper", "", "", "0X8005A10", "0X8005A10", 0, 0, "", "", "", "");
      ReportController.b(this.a.app, "CliOper", "", "", "0X8006661", "0X8006661", 0, 0, "", "", "", "");
      return;
    }
    this.a.a("0X8007825");
    localIntent.setClass(this.a, TroopActivity.class);
    if (!this.a.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption.a(ForwardAbility.ForwardAbilityType.d))
    {
      localIntent.putExtra("onlyOneSegement", true);
      localIntent.putExtra("_key_mode", 0);
      localIntent.putExtra("key_tab_mode", 1);
    }
    for (;;)
    {
      this.a.startActivityForResult(localIntent, 20000);
      ReportController.b(this.a.app, "CliOper", "", "", "0X8006660", "0X8006660", 0, 0, "", "", "", "");
      new ReportTask(this.a.app).a("dc00899").b("Grp_listNew").c("send_to").d("clk_grpList").a();
      return;
      if (!this.a.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption.a(ForwardAbility.ForwardAbilityType.c))
      {
        localIntent.putExtra("onlyOneSegement", true);
        localIntent.putExtra("_key_mode", 1);
        localIntent.putExtra("key_tab_mode", 1);
      }
    }
    paramView = new Bundle();
    paramView.putString("uin", "-1");
    paramView.putInt("uintype", -1);
    this.a.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption.a(ForwardAbility.ForwardAbilityType.a.intValue(), paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     snu
 * JD-Core Version:    0.7.0.1
 */