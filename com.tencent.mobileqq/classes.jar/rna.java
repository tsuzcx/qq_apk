import com.tencent.mobileqq.activity.AssociatedAccountManageActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.FTSDBManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.managers.MessageRecordManagerImpl;
import com.tencent.mobileqq.utils.DBUtils;

public class rna
  implements Runnable
{
  public rna(AssociatedAccountManageActivity paramAssociatedAccountManageActivity, boolean paramBoolean, String paramString) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      ProxyManager localProxyManager = this.jdField_a_of_type_ComTencentMobileqqActivityAssociatedAccountManageActivity.app.a();
      if (localProxyManager != null)
      {
        localProxyManager.d();
        FTSDBManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAssociatedAccountManageActivity.app, this.jdField_a_of_type_JavaLangString, true);
        new MessageRecordManagerImpl().a(this.jdField_a_of_type_JavaLangString);
        DBUtils.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAssociatedAccountManageActivity.app.getApp(), this.jdField_a_of_type_JavaLangString, false);
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAssociatedAccountManageActivity.runOnUiThread(new rnb(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     rna
 * JD-Core Version:    0.7.0.1
 */