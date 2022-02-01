import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.qphone.base.util.QLog;

class ntm
  extends apee
{
  ntm(ntl paramntl) {}
  
  public int a()
  {
    return 7;
  }
  
  public void a(Object paramObject)
  {
    ntc.b(this.a.a, this.a.a.jdField_a_of_type_Int);
    if (this.a.a.jdField_a_of_type_AndroidContentSharedPreferences != null) {
      this.a.a.jdField_a_of_type_AndroidContentSharedPreferences.edit().putInt("setting_status_" + this.a.a.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.uin + "_" + this.a.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.a.a.jdField_a_of_type_Int).apply();
    }
  }
  
  public void a(boolean paramBoolean, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AccountDetailGroupListContainer", 2, "New 0xc76 onGetRecvMsgState isSuccess = " + paramBoolean);
    }
  }
  
  public void b(Object paramObject) {}
  
  public void b(boolean paramBoolean, Object paramObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ntm
 * JD-Core Version:    0.7.0.1
 */