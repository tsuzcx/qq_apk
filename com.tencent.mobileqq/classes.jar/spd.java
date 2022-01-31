import com.tencent.biz.pubaccount.readinjoy.viola.modules.BridgeModule;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class spd
  implements qfu
{
  public spd(BridgeModule paramBridgeModule, String paramString) {}
  
  public void a(String paramString)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("wording", paramString);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaModulesBridgeModule.invokeCallJS(this.jdField_a_of_type_JavaLangString, localJSONObject);
      return;
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        QLog.e(BridgeModule.TAG, 1, "onClickBubbleTips error: " + paramString.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     spd
 * JD-Core Version:    0.7.0.1
 */