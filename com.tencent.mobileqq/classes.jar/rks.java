import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.viola.modules.BridgeModule;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

class rks
  implements begw
{
  rks(rkr paramrkr, String paramString) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    paramView = new JSONObject();
    for (;;)
    {
      try
      {
        paramView.put("index", paramInt);
        if ((!this.jdField_a_of_type_Rkr.a) || (paramInt != 0)) {
          continue;
        }
        paramView.put("type", 2);
        if (rkr.a(this.jdField_a_of_type_Rkr) != null) {
          ((BridgeModule)rkr.a(this.jdField_a_of_type_Rkr).get()).invokeCallJS(this.jdField_a_of_type_JavaLangString, paramView);
        }
      }
      catch (JSONException paramView)
      {
        continue;
      }
      rkr.a(this.jdField_a_of_type_Rkr).dismiss();
      return;
      paramView.put("type", 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rks
 * JD-Core Version:    0.7.0.1
 */