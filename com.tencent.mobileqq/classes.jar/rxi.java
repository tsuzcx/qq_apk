import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.viola.modules.BridgeModule;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

class rxi
  implements bfoq
{
  rxi(rxh paramrxh, String paramString) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    paramView = new JSONObject();
    for (;;)
    {
      try
      {
        paramView.put("index", paramInt);
        if ((!this.jdField_a_of_type_Rxh.a) || (paramInt != 0)) {
          continue;
        }
        paramView.put("type", 2);
        if (rxh.a(this.jdField_a_of_type_Rxh) != null) {
          ((BridgeModule)rxh.a(this.jdField_a_of_type_Rxh).get()).invokeCallJS(this.jdField_a_of_type_JavaLangString, paramView);
        }
      }
      catch (JSONException paramView)
      {
        continue;
      }
      rxh.a(this.jdField_a_of_type_Rxh).dismiss();
      return;
      paramView.put("type", 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rxi
 * JD-Core Version:    0.7.0.1
 */