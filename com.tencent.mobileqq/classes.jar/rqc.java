import android.app.Dialog;
import android.support.v4.app.FragmentActivity;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.DiscussChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.util.QLog;

public class rqc
  extends CardObserver
{
  public rqc(BaseChatPie paramBaseChatPie) {}
  
  protected void a(boolean paramBoolean, Object paramObject)
  {
    if ((paramObject instanceof Card)) {}
    for (paramObject = (Card)paramObject;; paramObject = null)
    {
      if ((paramBoolean) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString != null) && (paramObject != null) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(paramObject.uin)) && ((this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1001) || (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1003) || (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 10002)) && (paramObject.strCertificationInfo != null) && (!paramObject.strCertificationInfo.equals(""))) {
        ChatActivityFacade.f(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      }
      if ((paramBoolean) && (paramObject != null)) {}
      switch (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int)
      {
      default: 
        if ((this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString != null) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(paramObject.uin)))
        {
          this.a.v();
          if (QLog.isColorLevel()) {
            QLog.d("Q.aio.BaseChatPie", 2, "onCardDownload nick = " + Utils.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d));
          }
          this.a.jdField_d_of_type_AndroidWidgetTextView.setText(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d);
          if (AppSetting.b)
          {
            paramObject = this.a.jdField_d_of_type_AndroidWidgetTextView.getText().toString();
            this.a.jdField_d_of_type_AndroidWidgetTextView.setContentDescription(paramObject);
            this.a.a().setTitle(this.a.jdField_d_of_type_AndroidWidgetTextView.getText());
          }
          if ((3000 == this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int) && ((this.a instanceof DiscussChatPie))) {
            ((DiscussChatPie)this.a).a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.a.jdField_d_of_type_AndroidWidgetTextView);
          }
        }
      case 1034: 
        return;
      }
      this.a.a(false, false);
      return;
    }
  }
  
  protected void a(boolean paramBoolean, String paramString)
  {
    if ((this.a.jdField_d_of_type_AndroidAppDialog != null) && (this.a.jdField_d_of_type_AndroidAppDialog.isShowing())) {
      this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.dismissDialog(231);
    }
    if (paramBoolean)
    {
      this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.showDialog(232);
      return;
    }
    this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.showDialog(233);
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("interactive", 2, " baechatpie onGetCalReactiveDays isAllow= " + paramBoolean2);
      }
      this.a.aF();
    }
  }
  
  protected void c(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("interactive", 2, " baechatpie onGetCalReactiveDays");
      }
      this.a.aF();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     rqc
 * JD-Core Version:    0.7.0.1
 */