import android.text.TextUtils;
import com.tencent.mobileqq.activity.AssociatedAccountActivity;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.subaccount.logic.SubAccountBackProtocData;
import com.tencent.mobileqq.subaccount.logic.SubAccountThirdQQBackProtocData;
import com.tencent.qphone.base.util.QLog;

public class rmg
  extends MessageObserver
{
  public rmg(AssociatedAccountActivity paramAssociatedAccountActivity) {}
  
  public void a(boolean paramBoolean, String paramString, SubAccountBackProtocData paramSubAccountBackProtocData)
  {
    if ((this.a.isFinishing()) || (TextUtils.isEmpty(paramString)) || (paramSubAccountBackProtocData == null)) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("AssociatedAccountActivity", 2, "onPushSubAccountMsg subUin" + paramString);
      }
    } while (!paramBoolean);
    AssociatedAccountActivity.d(this.a, false);
  }
  
  public void a(boolean paramBoolean, String paramString, SubAccountThirdQQBackProtocData paramSubAccountThirdQQBackProtocData)
  {
    if ((this.a.isFinishing()) || (paramSubAccountThirdQQBackProtocData == null) || (this.a.app == null) || (!TextUtils.equals(paramString, this.a.app.c()))) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("AssociatedAccountActivity", 2, "onSubAccountThirdQQUnreadMsgNum mIsFromPull=" + this.a.jdField_b_of_type_Boolean + "  mPullReqNeedBackNum=" + this.a.jdField_a_of_type_Int + " isSuccess=" + paramBoolean + "  mainAccount=" + paramString + "  data=" + paramSubAccountThirdQQBackProtocData);
      }
      if (this.a.jdField_b_of_type_Boolean)
      {
        AssociatedAccountActivity.a(this.a, paramBoolean, false);
        return;
      }
      this.a.jdField_a_of_type_Int = 0;
      this.a.c = false;
    } while (!paramBoolean);
    AssociatedAccountActivity.a(this.a, paramSubAccountThirdQQBackProtocData);
  }
  
  public void a(boolean paramBoolean, String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return;
    }
    if (QLog.isColorLevel())
    {
      paramString1 = new StringBuilder().append("onSubAccountMsgNumConfirm isSuccess=").append(paramBoolean).append(" subUin=").append(paramString1).append(" set need2ConfirmMsgNum=");
      if (paramBoolean) {
        break label164;
      }
    }
    label164:
    for (paramBoolean = true;; paramBoolean = false)
    {
      QLog.d("AssociatedAccountActivity", 2, paramBoolean + " nextAction=" + paramString2 + " mNeed2ConfirmMsgNum=" + this.a.jdField_b_of_type_Int);
      if (!"sub.account.switchAccount".equals(paramString2)) {
        break;
      }
      paramString1 = this.a;
      paramString1.jdField_b_of_type_Int -= 1;
      if (this.a.jdField_b_of_type_Int <= 0)
      {
        AssociatedAccountActivity.c(this.a, false);
        AssociatedAccountActivity.a(this.a, this.a.jdField_a_of_type_JavaLangString);
      }
      if (this.a.jdField_b_of_type_Int >= 0) {
        break;
      }
      this.a.jdField_b_of_type_Int = 0;
      return;
    }
  }
  
  public void b(boolean paramBoolean, String paramString, SubAccountBackProtocData paramSubAccountBackProtocData)
  {
    if ((TextUtils.isEmpty(paramString)) || (this.a.isFinishing()) || (paramSubAccountBackProtocData == null)) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("AssociatedAccountActivity", 2, "onGetSubAccountMsg subAccount=" + paramString + " mIsFromPull=" + this.a.jdField_b_of_type_Boolean + " isSuccess=" + paramBoolean + "  mPullReqNeedBackNum=" + this.a.jdField_a_of_type_Int);
      }
      if (this.a.jdField_b_of_type_Boolean)
      {
        AssociatedAccountActivity.a(this.a, paramBoolean, true);
        return;
      }
      this.a.jdField_a_of_type_Int = 0;
      this.a.c = false;
      if ((paramBoolean) && (paramSubAccountBackProtocData.c))
      {
        AssociatedAccountActivity.b(this.a);
        return;
      }
    } while (!paramBoolean);
    AssociatedAccountActivity.f(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     rmg
 * JD-Core Version:    0.7.0.1
 */