import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class teh
{
  public tej a;
  public tek a;
  
  public teh()
  {
    this.jdField_a_of_type_Tek = new tek(null);
    this.jdField_a_of_type_Tej = new tej(null);
  }
  
  private static JSONObject a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      try
      {
        paramString = new JSONObject(paramString);
        return paramString;
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
      }
    }
    return null;
  }
  
  public static teh a()
  {
    return (teh)aogj.a().a(447);
  }
  
  public void a(String paramString)
  {
    tlo.b("WeSeeConfigBean", "WeSeeConfigBean content = " + paramString);
    paramString = a(paramString);
    if (paramString == null) {
      return;
    }
    this.jdField_a_of_type_Tek = tek.a(paramString.optJSONObject("video_plugin_threshold"));
    this.jdField_a_of_type_Tej = tej.a(paramString.optJSONObject("trends_tab_strategy"));
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("WeSeeConfigBean{mPluginConfigInfo=").append(this.jdField_a_of_type_Tek).append(", mStrategyConfig=");
    if (this.jdField_a_of_type_Tej != null) {}
    for (String str = this.jdField_a_of_type_Tej.a;; str = "null") {
      return str + '}';
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     teh
 * JD-Core Version:    0.7.0.1
 */