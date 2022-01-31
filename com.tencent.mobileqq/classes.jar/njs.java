import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.biz.pubaccount.AccountDetail.jce.SetRecvMsgStateRsp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.qphone.base.util.QLog;

class njs
  extends alvc
{
  private nin b;
  
  public njs(nin paramnin1, nin paramnin2)
  {
    this.b = paramnin2;
  }
  
  public void a()
  {
    this.b = null;
  }
  
  public void a(boolean paramBoolean, SetRecvMsgStateRsp paramSetRecvMsgStateRsp)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AccountDetailGroupListContainer", 2, "onGetRecvMsgState isSuccess = " + paramBoolean);
    }
    if ((paramBoolean) && (paramSetRecvMsgStateRsp.result == 0))
    {
      nin.b(this.a, this.a.jdField_a_of_type_Int);
      if (this.a.jdField_a_of_type_AndroidContentSharedPreferences != null) {
        this.a.jdField_a_of_type_AndroidContentSharedPreferences.edit().putInt("setting_status_" + this.a.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.uin + "_" + this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.a.jdField_a_of_type_Int).commit();
      }
    }
  }
  
  public void a(boolean paramBoolean, npo paramnpo)
  {
    if ((paramBoolean) && (paramnpo != null)) {
      if (paramnpo.e != 3) {}
    }
    while (this.b == null) {
      for (;;)
      {
        syb.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), this.a.jdField_a_of_type_JavaLangString);
        return;
        if ((paramnpo.e == 6) && (this.b != null)) {
          nin.a(this.b, paramnpo);
        }
      }
    }
    nin.a(this.b, 2131695727);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     njs
 * JD-Core Version:    0.7.0.1
 */