import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class rxi
{
  public rxk a;
  public rxl a;
  
  public rxi()
  {
    this.jdField_a_of_type_Rxl = new rxl(null);
    this.jdField_a_of_type_Rxk = new rxk(null);
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
  
  public static rxi a()
  {
    return (rxi)alzw.a().a(447);
  }
  
  public void a(String paramString)
  {
    sai.b("WeSeeConfigBean", "WeSeeConfigBean content = " + paramString);
    paramString = a(paramString);
    if (paramString == null) {
      return;
    }
    this.jdField_a_of_type_Rxl = rxl.a(paramString.optJSONObject("video_plugin_threshold"));
    this.jdField_a_of_type_Rxk = rxk.a(paramString.optJSONObject("trends_tab_strategy"));
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("WeSeeConfigBean{mPluginConfigInfo=").append(this.jdField_a_of_type_Rxl).append(", mStrategyConfig=");
    if (this.jdField_a_of_type_Rxk != null) {}
    for (String str = this.jdField_a_of_type_Rxk.a;; str = "null") {
      return str + '}';
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rxi
 * JD-Core Version:    0.7.0.1
 */