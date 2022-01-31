import com.tencent.biz.pubaccount.PublicAccountJavascriptInterface;
import org.json.JSONObject;

public class lao
  implements Runnable
{
  public lao(PublicAccountJavascriptInterface paramPublicAccountJavascriptInterface, String paramString1, JSONObject paramJSONObject, String paramString2) {}
  
  public void run()
  {
    long l = PublicAccountJavascriptInterface.a();
    try
    {
      PublicAccountJavascriptInterface.a(l);
      if (PublicAccountJavascriptInterface.b() > 52428800L)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountJavascriptInterface.callJs(this.jdField_a_of_type_JavaLangString, new String[] { "{ret:-12, response:" + this.jdField_a_of_type_OrgJsonJSONObject.toString() + "}" });
        return;
      }
    }
    finally {}
    this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountJavascriptInterface.a(this.b, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_OrgJsonJSONObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lao
 * JD-Core Version:    0.7.0.1
 */