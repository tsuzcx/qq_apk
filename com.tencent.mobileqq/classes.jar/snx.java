import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.biz.pubaccount.readinjoy.viola.modules.BridgeModule;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

class snx
  implements DialogInterface.OnCancelListener
{
  snx(snu paramsnu, String paramString) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    paramDialogInterface = new JSONObject();
    try
    {
      paramDialogInterface.put("index", snu.a(this.jdField_a_of_type_Snu));
      paramDialogInterface.put("type", 1);
      if (snu.a(this.jdField_a_of_type_Snu) != null) {
        ((BridgeModule)snu.a(this.jdField_a_of_type_Snu).get()).invokeCallJS(this.jdField_a_of_type_JavaLangString, paramDialogInterface);
      }
      return;
    }
    catch (JSONException paramDialogInterface) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     snx
 * JD-Core Version:    0.7.0.1
 */