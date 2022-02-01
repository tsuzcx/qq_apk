import com.tencent.biz.pubaccount.PublicAccountJavascriptInterface;
import com.tencent.mobileqq.app.soso.SosoInterface;
import mqq.app.QQPermissionDenied;
import mqq.app.QQPermissionGrant;

public class nzm
{
  public nzm(PublicAccountJavascriptInterface paramPublicAccountJavascriptInterface, boolean paramBoolean1, int paramInt, boolean paramBoolean2, String paramString, long paramLong) {}
  
  @QQPermissionDenied(1)
  public void denied()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountJavascriptInterface.callJs(this.jdField_a_of_type_JavaLangString, new String[] { "-3", "{}" });
  }
  
  @QQPermissionGrant(1)
  public void grant()
  {
    SosoInterface.a(new nzy(this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountJavascriptInterface, 0, this.jdField_a_of_type_Boolean, this.jdField_a_of_type_Int, this.b, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Long));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nzm
 * JD-Core Version:    0.7.0.1
 */