import com.tencent.biz.pubaccount.readinjoy.viola.modules.BridgeModule;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class sor
  implements qth
{
  public sor(BridgeModule paramBridgeModule, JSONObject paramJSONObject, String paramString) {}
  
  public void a(boolean paramBoolean, String paramString)
  {
    try
    {
      JSONObject localJSONObject = this.jdField_a_of_type_OrgJsonJSONObject;
      if (paramBoolean) {}
      for (int i = 0;; i = -1)
      {
        localJSONObject.put("errCode", i);
        this.jdField_a_of_type_OrgJsonJSONObject.put("errMsg", paramString);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaModulesBridgeModule.invokeJS(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_OrgJsonJSONObject);
        return;
      }
      return;
    }
    catch (JSONException paramString)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaModulesBridgeModule.invokeJS(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_OrgJsonJSONObject);
      QLog.e(BridgeModule.TAG, 1, "oidb_0xe2a error! e = " + paramString.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     sor
 * JD-Core Version:    0.7.0.1
 */