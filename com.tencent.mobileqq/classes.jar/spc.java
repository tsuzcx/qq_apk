import com.tencent.biz.pubaccount.readinjoy.viola.modules.BridgeModule;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class spc
  implements qfo
{
  public spc(BridgeModule paramBridgeModule, String paramString) {}
  
  public void a(boolean paramBoolean, String paramString, int paramInt)
  {
    JSONObject localJSONObject = new JSONObject();
    for (;;)
    {
      try
      {
        localJSONObject.put("wording", paramString);
        if (!paramBoolean) {
          continue;
        }
        i = 1;
        localJSONObject.put("shouldShow", i);
        localJSONObject.put("status", paramInt);
      }
      catch (JSONException paramString)
      {
        int i;
        QLog.e(BridgeModule.TAG, 1, "requestBubbleTipsWording error: " + paramString.toString());
        continue;
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaModulesBridgeModule.invokeCallJS(this.jdField_a_of_type_JavaLangString, localJSONObject);
      return;
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     spc
 * JD-Core Version:    0.7.0.1
 */