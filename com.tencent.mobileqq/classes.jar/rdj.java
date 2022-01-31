import com.tencent.mobileqq.activity.AccountManageActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.FTSDBManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.managers.MessageRecordManagerImpl;
import com.tencent.mobileqq.utils.DBUtils;
import com.tencent.open.OpenProxy;

public class rdj
  implements Runnable
{
  public rdj(AccountManageActivity paramAccountManageActivity, String paramString, boolean paramBoolean, int paramInt) {}
  
  public void run()
  {
    OpenProxy.a().b(this.jdField_a_of_type_JavaLangString);
    if (this.jdField_a_of_type_Boolean)
    {
      ProxyManager localProxyManager = this.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity.app.a();
      if (localProxyManager != null)
      {
        localProxyManager.d();
        FTSDBManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity.app, this.jdField_a_of_type_JavaLangString, true);
        new MessageRecordManagerImpl().a(this.jdField_a_of_type_JavaLangString);
        DBUtils.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity.app.getApp(), this.jdField_a_of_type_JavaLangString, false);
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity.runOnUiThread(new rdk(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     rdj
 * JD-Core Version:    0.7.0.1
 */