import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.biz.pubaccount.readinjoy.viola.modules.BridgeModule;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

class rku
  implements DialogInterface.OnCancelListener
{
  rku(rkr paramrkr, String paramString) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    paramDialogInterface = new JSONObject();
    try
    {
      paramDialogInterface.put("index", rkr.a(this.jdField_a_of_type_Rkr));
      paramDialogInterface.put("type", 1);
      if (rkr.a(this.jdField_a_of_type_Rkr) != null) {
        ((BridgeModule)rkr.a(this.jdField_a_of_type_Rkr).get()).invokeCallJS(this.jdField_a_of_type_JavaLangString, paramDialogInterface);
      }
      return;
    }
    catch (JSONException paramDialogInterface) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rku
 * JD-Core Version:    0.7.0.1
 */