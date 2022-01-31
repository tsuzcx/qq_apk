import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.biz.pubaccount.AccountDetail.jce.SetRecvMsgStateRsp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.qphone.base.util.QLog;

class ngw
  extends akdn
{
  private nfr b;
  
  public ngw(nfr paramnfr1, nfr paramnfr2)
  {
    this.b = paramnfr2;
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
      nfr.b(this.a, this.a.jdField_a_of_type_Int);
      if (this.a.jdField_a_of_type_AndroidContentSharedPreferences != null) {
        this.a.jdField_a_of_type_AndroidContentSharedPreferences.edit().putInt("setting_status_" + this.a.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.uin + "_" + this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.a.jdField_a_of_type_Int).commit();
      }
    }
  }
  
  public void a(boolean paramBoolean, nms paramnms)
  {
    if ((paramBoolean) && (paramnms != null)) {
      if (paramnms.e != 3) {}
    }
    while (this.b == null) {
      for (;;)
      {
        sgg.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), this.a.jdField_a_of_type_JavaLangString);
        return;
        if ((paramnms.e == 6) && (this.b != null)) {
          nfr.a(this.b, paramnms);
        }
      }
    }
    nfr.a(this.b, 2131695569);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ngw
 * JD-Core Version:    0.7.0.1
 */