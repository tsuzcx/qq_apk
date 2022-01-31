import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import com.tencent.mobileqq.activity.AssociatedAccountManageActivity;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.AccountObserver;

public class rry
  extends AccountObserver
{
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  
  public rry(AssociatedAccountManageActivity paramAssociatedAccountManageActivity, String paramString, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void onDeleteAccount(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AssociatedAccountManage", 2, "DelHistoryAccountObserver onDeleteAccount isSuccess " + paramBoolean + ",peerUin:" + this.jdField_a_of_type_JavaLangString + ",isDeleteHistory:" + this.jdField_a_of_type_Boolean);
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAssociatedAccountManageActivity;
    if (Build.VERSION.SDK_INT > 10) {}
    for (int i = 4;; i = 0)
    {
      localObject = ((AssociatedAccountManageActivity)localObject).getSharedPreferences("Last_Login", i);
      if ((paramBoolean) && (localObject != null) && (((SharedPreferences)localObject).contains("uin")) && (((SharedPreferences)localObject).getString("uin", "").equals(this.jdField_a_of_type_JavaLangString)))
      {
        ((SharedPreferences)localObject).edit().remove("uin").commit();
        if (QLog.isColorLevel()) {
          QLog.d("AssociatedAccountManage", 2, "delete Last_Login");
        }
      }
      if ((paramBoolean) && (this.jdField_a_of_type_Boolean)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAssociatedAccountManageActivity.a(this.jdField_a_of_type_JavaLangString);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     rry
 * JD-Core Version:    0.7.0.1
 */