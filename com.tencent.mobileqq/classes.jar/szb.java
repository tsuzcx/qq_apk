import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import org.json.JSONException;
import org.json.JSONObject;

final class szb
  implements DialogInterface.OnClickListener
{
  szb(int paramInt1, int paramInt2, Runnable paramRunnable) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramInt = 1;
    bjxj.a("readinjoy_user_data_switch", Integer.valueOf(1));
    paramDialogInterface.dismiss();
    paramDialogInterface = new JSONObject();
    try
    {
      if (this.jdField_a_of_type_Int == 1) {
        paramInt = 0;
      }
      paramDialogInterface.put("click_src", paramInt);
      paramDialogInterface.put("user_data_alert_interval", this.b);
      paramDialogInterface.put("click_opt", 2);
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
    nrt.a(null, "", "0X800A809", "0X800A809", 0, 0, "", "", "", paramDialogInterface.toString(), false);
    if (this.jdField_a_of_type_JavaLangRunnable != null) {
      this.jdField_a_of_type_JavaLangRunnable.run();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     szb
 * JD-Core Version:    0.7.0.1
 */