import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.biz.pubaccount.readinjoy.viola.modules.BridgeModule;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

class tdu
  implements DialogInterface.OnCancelListener
{
  tdu(tdr paramtdr, String paramString) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    paramDialogInterface = new JSONObject();
    try
    {
      paramDialogInterface.put("index", tdr.a(this.jdField_a_of_type_Tdr));
      paramDialogInterface.put("type", 1);
      if (tdr.a(this.jdField_a_of_type_Tdr) != null) {
        ((BridgeModule)tdr.a(this.jdField_a_of_type_Tdr).get()).invokeCallJS(this.jdField_a_of_type_JavaLangString, paramDialogInterface);
      }
      return;
    }
    catch (JSONException paramDialogInterface) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tdu
 * JD-Core Version:    0.7.0.1
 */