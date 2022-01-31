import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class skb
{
  public skd a;
  public ske a;
  
  public skb()
  {
    this.jdField_a_of_type_Ske = new ske(null);
    this.jdField_a_of_type_Skd = new skd(null);
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
  
  public static skb a()
  {
    return (skb)ampl.a().a(447);
  }
  
  public void a(String paramString)
  {
    snb.b("WeSeeConfigBean", "WeSeeConfigBean content = " + paramString);
    paramString = a(paramString);
    if (paramString == null) {
      return;
    }
    this.jdField_a_of_type_Ske = ske.a(paramString.optJSONObject("video_plugin_threshold"));
    this.jdField_a_of_type_Skd = skd.a(paramString.optJSONObject("trends_tab_strategy"));
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("WeSeeConfigBean{mPluginConfigInfo=").append(this.jdField_a_of_type_Ske).append(", mStrategyConfig=");
    if (this.jdField_a_of_type_Skd != null) {}
    for (String str = this.jdField_a_of_type_Skd.a;; str = "null") {
      return str + '}';
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     skb
 * JD-Core Version:    0.7.0.1
 */