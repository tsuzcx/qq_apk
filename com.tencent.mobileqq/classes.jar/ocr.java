import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.biz.pubaccount.AccountDetail.jce.SetRecvMsgStateRsp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.qphone.base.util.QLog;

class ocr
  extends aoav
{
  private obm b;
  
  public ocr(obm paramobm1, obm paramobm2)
  {
    this.b = paramobm2;
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
      obm.b(this.a, this.a.jdField_a_of_type_Int);
      if (this.a.jdField_a_of_type_AndroidContentSharedPreferences != null) {
        this.a.jdField_a_of_type_AndroidContentSharedPreferences.edit().putInt("setting_status_" + this.a.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.uin + "_" + this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.a.jdField_a_of_type_Int).commit();
      }
    }
  }
  
  public void onUpdateFunctionFlag(boolean paramBoolean, oji paramoji)
  {
    if ((paramBoolean) && (paramoji != null)) {
      if (paramoji.e != 3) {}
    }
    while (this.b == null) {
      for (;;)
      {
        uuc.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), this.a.jdField_a_of_type_JavaLangString);
        return;
        if ((paramoji.e == 6) && (this.b != null)) {
          obm.a(this.b, paramoji);
        }
      }
    }
    obm.a(this.b, 2131694983);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ocr
 * JD-Core Version:    0.7.0.1
 */