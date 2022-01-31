import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.biz.pubaccount.readinjoy.viola.modules.BridgeModule;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

class rxk
  implements DialogInterface.OnCancelListener
{
  rxk(rxh paramrxh, String paramString) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    paramDialogInterface = new JSONObject();
    try
    {
      paramDialogInterface.put("index", rxh.a(this.jdField_a_of_type_Rxh));
      paramDialogInterface.put("type", 1);
      if (rxh.a(this.jdField_a_of_type_Rxh) != null) {
        ((BridgeModule)rxh.a(this.jdField_a_of_type_Rxh).get()).invokeCallJS(this.jdField_a_of_type_JavaLangString, paramDialogInterface);
      }
      return;
    }
    catch (JSONException paramDialogInterface) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rxk
 * JD-Core Version:    0.7.0.1
 */