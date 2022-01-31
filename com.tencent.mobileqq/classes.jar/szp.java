import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.kingkong.Common;
import com.tencent.mobileqq.activity.recent.RecentDataListManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;

public final class szp
  implements Runnable
{
  public szp(QQAppInterface paramQQAppInterface, String paramString) {}
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b = NetConnInfoCenter.getServerTime();
    RecentDataListManager.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, BaseApplicationImpl.sApplication, false);
    try
    {
      Common.OnLogin(BaseApplicationImpl.sApplication, this.jdField_a_of_type_JavaLangString);
      return;
    }
    catch (Throwable localThrowable)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("login", 2, "loginSuccessInit kingkong OnLogin throwable: " + localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     szp
 * JD-Core Version:    0.7.0.1
 */