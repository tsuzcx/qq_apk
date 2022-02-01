import com.tencent.biz.pubaccount.readinjoy.struct.ReadInJoyUserInfo;
import com.tencent.mobileqq.app.QQAppInterface;

class qrn
  implements qhl
{
  qrn(qrm paramqrm, QQAppInterface paramQQAppInterface, String paramString) {}
  
  public void onLoadUserInfoFailed(String paramString1, String paramString2)
  {
    qrm.a(this.jdField_a_of_type_Qrm, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString, "", true);
  }
  
  public void onLoadUserInfoSucceed(String paramString, ReadInJoyUserInfo paramReadInJoyUserInfo)
  {
    qrm.a(this.jdField_a_of_type_Qrm, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString, paramReadInJoyUserInfo.faceUrl + "140", true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qrn
 * JD-Core Version:    0.7.0.1
 */