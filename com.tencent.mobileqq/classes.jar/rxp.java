import com.tencent.biz.pubaccount.readinjoy.viola.modules.BridgeModule;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class rxp
  implements rwf
{
  public rxp(BridgeModule paramBridgeModule, String paramString) {}
  
  public void a()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("result", false);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaModulesBridgeModule.invokeCallJS(this.jdField_a_of_type_JavaLangString, localJSONObject);
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e(BridgeModule.TAG, 2, "canOpenPage error" + localException.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rxp
 * JD-Core Version:    0.7.0.1
 */