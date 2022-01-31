import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.biz.pubaccount.readinjoy.viola.modules.BridgeModule;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

class rxh
  implements DialogInterface.OnCancelListener
{
  rxh(rxe paramrxe, String paramString) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    paramDialogInterface = new JSONObject();
    try
    {
      paramDialogInterface.put("index", rxe.a(this.jdField_a_of_type_Rxe));
      paramDialogInterface.put("type", 1);
      if (rxe.a(this.jdField_a_of_type_Rxe) != null) {
        ((BridgeModule)rxe.a(this.jdField_a_of_type_Rxe).get()).invokeCallJS(this.jdField_a_of_type_JavaLangString, paramDialogInterface);
      }
      return;
    }
    catch (JSONException paramDialogInterface) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rxh
 * JD-Core Version:    0.7.0.1
 */