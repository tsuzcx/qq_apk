import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.biz.pubaccount.AccountDetail.jce.SetRecvMsgStateRsp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.qphone.base.util.QLog;

class nuh
  extends aoeg
{
  private ntc b;
  
  public nuh(ntc paramntc1, ntc paramntc2)
  {
    this.b = paramntc2;
  }
  
  public void a()
  {
    this.b = null;
  }
  
  public void onSetRecvMsgState(boolean paramBoolean, SetRecvMsgStateRsp paramSetRecvMsgStateRsp)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AccountDetailGroupListContainer", 2, "onGetRecvMsgState isSuccess = " + paramBoolean);
    }
    if ((paramBoolean) && (paramSetRecvMsgStateRsp.result == 0))
    {
      ntc.b(this.a, this.a.jdField_a_of_type_Int);
      if (this.a.jdField_a_of_type_AndroidContentSharedPreferences != null) {
        this.a.jdField_a_of_type_AndroidContentSharedPreferences.edit().putInt("setting_status_" + this.a.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.uin + "_" + this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.a.jdField_a_of_type_Int).commit();
      }
    }
  }
  
  public void onUpdateFunctionFlag(boolean paramBoolean, oag paramoag)
  {
    if ((paramBoolean) && (paramoag != null)) {
      if (paramoag.e != 3) {}
    }
    while (this.b == null) {
      for (;;)
      {
        tzq.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), this.a.jdField_a_of_type_JavaLangString);
        return;
        if ((paramoag.e == 6) && (this.b != null)) {
          ntc.a(this.b, paramoag);
        }
      }
    }
    ntc.a(this.b, 2131694659);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nuh
 * JD-Core Version:    0.7.0.1
 */