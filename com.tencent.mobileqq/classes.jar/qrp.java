import com.tencent.biz.pubaccount.readinjoy.struct.ReadInJoyUserInfo;
import com.tencent.mobileqq.app.QQAppInterface;

class qrp
  implements qhl
{
  qrp(qrm paramqrm, QQAppInterface paramQQAppInterface, String paramString) {}
  
  public void onLoadUserInfoFailed(String paramString1, String paramString2)
  {
    qrm.a(this.jdField_a_of_type_Qrm, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString, "", false);
  }
  
  public void onLoadUserInfoSucceed(String paramString, ReadInJoyUserInfo paramReadInJoyUserInfo)
  {
    qrm.a(this.jdField_a_of_type_Qrm, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString, paramReadInJoyUserInfo.faceUrl + "140", false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qrp
 * JD-Core Version:    0.7.0.1
 */