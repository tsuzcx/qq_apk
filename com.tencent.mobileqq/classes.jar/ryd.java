import com.tencent.biz.pubaccount.readinjoy.viola.CommonSuspensionGestureLayout;
import com.tencent.biz.pubaccount.readinjoy.viola.modules.BridgeModule;
import com.tencent.viola.bridge.ViolaBridgeManager;
import com.tencent.viola.core.ViolaInstance;
import org.json.JSONException;
import org.json.JSONObject;

public class ryd
  implements rwo
{
  public ryd(BridgeModule paramBridgeModule, String paramString) {}
  
  public void a(int paramInt)
  {
    if ((BridgeModule.access$000(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaModulesBridgeModule) != paramInt) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaModulesBridgeModule.getViolaInstance() != null)) {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        if ((paramInt == CommonSuspensionGestureLayout.c) || (paramInt == CommonSuspensionGestureLayout.e)) {
          localJSONObject.put("state", 1);
        }
        for (;;)
        {
          BridgeModule.access$002(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaModulesBridgeModule, paramInt);
          ViolaBridgeManager.getInstance().callbackJavascript(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaModulesBridgeModule.getViolaInstance().getInstanceId(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaModulesBridgeModule.getModuleName(), "callback", this.jdField_a_of_type_JavaLangString, localJSONObject, true);
          return;
          localJSONObject.put("state", 0);
        }
        return;
      }
      catch (JSONException localJSONException) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ryd
 * JD-Core Version:    0.7.0.1
 */