import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import com.tencent.mobileqq.activity.MainFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.contactsync.syncadapter.SyncService;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.qcall.QCallFacade;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.plugin.PatternLockUtils;

public class tft
  implements View.OnClickListener
{
  public tft(MainFragment paramMainFragment, Dialog paramDialog) {}
  
  public void onClick(View paramView)
  {
    QLog.flushLog();
    boolean bool = ((CheckBox)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131363708)).isChecked();
    this.jdField_a_of_type_ComTencentMobileqqActivityMainFragment.d = bool;
    SettingCloneUtil.writeValue(this.jdField_a_of_type_ComTencentMobileqqActivityMainFragment.getActivity(), MainFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityMainFragment).getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqActivityMainFragment.getString(2131435419), "qqsetting_receivemsg_whenexit_key", bool);
    SyncService.a(this.jdField_a_of_type_ComTencentMobileqqActivityMainFragment.getActivity(), this.jdField_a_of_type_ComTencentMobileqqActivityMainFragment.d);
    int i = MainFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityMainFragment).a().b();
    int j = MainFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityMainFragment).a().a();
    paramView = this.jdField_a_of_type_ComTencentMobileqqActivityMainFragment.getActivity().getSharedPreferences("unreadcount", 4).edit();
    paramView.putInt("unread", i + j);
    paramView.commit();
    this.jdField_a_of_type_ComTencentMobileqqActivityMainFragment.g();
    MainFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityMainFragment).a = this.jdField_a_of_type_ComTencentMobileqqActivityMainFragment.d;
    MainFragment.c = true;
    if (QQPlayerService.a())
    {
      paramView = new Intent();
      paramView.setAction("qqplayer_exit_action");
      this.jdField_a_of_type_ComTencentMobileqqActivityMainFragment.getActivity().sendBroadcast(paramView);
    }
    PatternLockUtils.setFirstEnterAfterLoginState(this.jdField_a_of_type_ComTencentMobileqqActivityMainFragment.getActivity(), MainFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityMainFragment).getCurrentAccountUin(), true);
    this.jdField_a_of_type_ComTencentMobileqqActivityMainFragment.getActivity().finish();
    ReportController.b(MainFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityMainFragment), "CliOper", "", "", "Quit", "Setting_Quit", 0, 0, "0", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tft
 * JD-Core Version:    0.7.0.1
 */