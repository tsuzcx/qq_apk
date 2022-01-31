import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.viola.modules.BridgeModule;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

class rxf
  implements bfph
{
  rxf(rxe paramrxe, String paramString) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    paramView = new JSONObject();
    for (;;)
    {
      try
      {
        paramView.put("index", paramInt);
        if ((!this.jdField_a_of_type_Rxe.a) || (paramInt != 0)) {
          continue;
        }
        paramView.put("type", 2);
        if (rxe.a(this.jdField_a_of_type_Rxe) != null) {
          ((BridgeModule)rxe.a(this.jdField_a_of_type_Rxe).get()).invokeCallJS(this.jdField_a_of_type_JavaLangString, paramView);
        }
      }
      catch (JSONException paramView)
      {
        continue;
      }
      rxe.a(this.jdField_a_of_type_Rxe).dismiss();
      return;
      paramView.put("type", 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rxf
 * JD-Core Version:    0.7.0.1
 */