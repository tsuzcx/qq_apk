import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.viola.modules.BridgeModule;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

class snv
  implements bhuk
{
  snv(snu paramsnu, String paramString) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    paramView = new JSONObject();
    for (;;)
    {
      try
      {
        paramView.put("index", paramInt);
        if ((!this.jdField_a_of_type_Snu.a) || (paramInt != 0)) {
          continue;
        }
        paramView.put("type", 2);
        if (snu.a(this.jdField_a_of_type_Snu) != null) {
          ((BridgeModule)snu.a(this.jdField_a_of_type_Snu).get()).invokeCallJS(this.jdField_a_of_type_JavaLangString, paramView);
        }
      }
      catch (JSONException paramView)
      {
        continue;
      }
      snu.a(this.jdField_a_of_type_Snu).dismiss();
      return;
      paramView.put("type", 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     snv
 * JD-Core Version:    0.7.0.1
 */