import android.text.TextUtils;
import com.tencent.biz.game.SensorAPIJavaScript;
import org.json.JSONException;
import org.json.JSONObject;

public class nes
  implements nbs
{
  public nes(SensorAPIJavaScript paramSensorAPIJavaScript, String paramString) {}
  
  public void loaded(String paramString, int paramInt)
  {
    if ((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (!TextUtils.isEmpty(paramString))) {}
    try
    {
      paramString = new JSONObject(paramString);
      this.jdField_a_of_type_ComTencentBizGameSensorAPIJavaScript.callJs(this.jdField_a_of_type_JavaLangString, new String[] { paramString.toString() });
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void progress(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     nes
 * JD-Core Version:    0.7.0.1
 */