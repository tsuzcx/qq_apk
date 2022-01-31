import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.ConversationHotChatCtrl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HotChatHandler;
import com.tencent.mobileqq.app.HotChatManager.HotChatStateWrapper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;

public class sjd
  implements DialogInterface.OnClickListener
{
  public sjd(ConversationHotChatCtrl paramConversationHotChatCtrl, HotChatInfo paramHotChatInfo, QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.isWifiHotChat) {}
    for (paramInt = 1;; paramInt = 2)
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004D2C", "0X8004D2C", paramInt, 0, "", "", "", "");
      if (NetworkUtil.d(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity)) {
        break;
      }
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getApplicationContext(), "退出失败，请检查网络连接。", 0).b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getTitleBarHeight());
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.addObserver(ConversationHotChatCtrl.a(this.jdField_a_of_type_ComTencentMobileqqActivityConversationHotChatCtrl));
    ((HotChatHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(35)).a(this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo, HotChatManager.HotChatStateWrapper.STATE_LEFT_NORMAL__ACTION_DELETE_SHELL);
    this.jdField_a_of_type_ComTencentMobileqqActivityConversationHotChatCtrl.a = new QQProgressDialog(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getTitleBarHeight());
    this.jdField_a_of_type_ComTencentMobileqqActivityConversationHotChatCtrl.a.setContentView(2130971508);
    this.jdField_a_of_type_ComTencentMobileqqActivityConversationHotChatCtrl.a.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131435283));
    this.jdField_a_of_type_ComTencentMobileqqActivityConversationHotChatCtrl.a.setCancelable(true);
    this.jdField_a_of_type_ComTencentMobileqqActivityConversationHotChatCtrl.a.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     sjd
 * JD-Core Version:    0.7.0.1
 */