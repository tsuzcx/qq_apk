import com.tencent.biz.pubaccount.PublicAccountJavascriptInterface;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.app.QQPermissionDenied;
import mqq.app.QQPermissionGrant;

public class ncp
{
  public ncp(PublicAccountJavascriptInterface paramPublicAccountJavascriptInterface, String paramString, long paramLong) {}
  
  @QQPermissionDenied(1)
  public void denied()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountJavascriptInterface.callJs(this.jdField_a_of_type_JavaLangString, new String[] { "-3", "{}" });
  }
  
  @QQPermissionGrant(1)
  public void grant()
  {
    SosoInterface.a(new ncv(this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountJavascriptInterface, 0, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Long));
    if (QLog.isColorLevel()) {
      QLog.d("PAjs.location", 2, "SosoInterface.startLocation");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ncp
 * JD-Core Version:    0.7.0.1
 */