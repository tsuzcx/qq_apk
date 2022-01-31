import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class ske
{
  public skg a;
  public skh a;
  
  public ske()
  {
    this.jdField_a_of_type_Skh = new skh(null);
    this.jdField_a_of_type_Skg = new skg(null);
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
  
  public static ske a()
  {
    return (ske)ampm.a().a(447);
  }
  
  public void a(String paramString)
  {
    sne.b("WeSeeConfigBean", "WeSeeConfigBean content = " + paramString);
    paramString = a(paramString);
    if (paramString == null) {
      return;
    }
    this.jdField_a_of_type_Skh = skh.a(paramString.optJSONObject("video_plugin_threshold"));
    this.jdField_a_of_type_Skg = skg.a(paramString.optJSONObject("trends_tab_strategy"));
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("WeSeeConfigBean{mPluginConfigInfo=").append(this.jdField_a_of_type_Skh).append(", mStrategyConfig=");
    if (this.jdField_a_of_type_Skg != null) {}
    for (String str = this.jdField_a_of_type_Skg.a;; str = "null") {
      return str + '}';
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ske
 * JD-Core Version:    0.7.0.1
 */