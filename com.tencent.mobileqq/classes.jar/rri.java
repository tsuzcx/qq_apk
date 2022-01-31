import android.content.Intent;
import android.content.res.Resources;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import mqq.app.MobileQQ;

public class rri
  implements View.OnClickListener
{
  public rri(BaseChatPie paramBaseChatPie) {}
  
  public void onClick(View paramView)
  {
    Object localObject = paramView.getTag();
    if ((localObject == null) || (!(localObject instanceof Integer))) {}
    do
    {
      do
      {
        return;
        paramView = this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
        if (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1006) {
          paramView = this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.f;
        }
        switch (((Integer)localObject).intValue())
        {
        default: 
          return;
        case 1: 
          ChatActivityUtils.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramView, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.e, true);
        }
      } while (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1010);
      ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "0X8004954", "0X8004954", 0, 0, "", "", "", "");
      return;
      ChatActivityUtils.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramView, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.e, false);
    } while (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1010);
    ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "0X8004953", "0X8004953", 0, 0, "", "", "", "");
    return;
    if (ChatActivityUtils.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo)) {
      ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "Manage_stranger", "Manage_str_add", 0, 0, "", "", "", "");
    }
    paramView = this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity;
    localObject = this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
    String str = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131433698);
    if (this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getStringExtra("param_return_addr") != null) {}
    for (boolean bool = true;; bool = false)
    {
      ChatActivityUtils.a(paramView, (SessionInfo)localObject, str, bool);
      return;
    }
    paramView = (ActionSheet)ActionSheetHelper.a(this.a.a(), null);
    paramView.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources().getString(2131436915));
    paramView.a(2131436914, 3);
    paramView.c(2131433015);
    paramView.a(new rrj(this, paramView));
    paramView.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     rri
 * JD-Core Version:    0.7.0.1
 */