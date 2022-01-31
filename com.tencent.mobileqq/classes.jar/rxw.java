import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.viola.modules.BridgeModule;
import org.json.JSONException;
import org.json.JSONObject;

public class rxw
  implements View.OnClickListener
{
  public rxw(BridgeModule paramBridgeModule, String paramString) {}
  
  public void onClick(View paramView)
  {
    paramView = new JSONObject();
    try
    {
      paramView.put("timestamp", System.currentTimeMillis());
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaModulesBridgeModule.invokeCallJS(this.jdField_a_of_type_JavaLangString, paramView);
      return;
    }
    catch (JSONException paramView) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rxw
 * JD-Core Version:    0.7.0.1
 */