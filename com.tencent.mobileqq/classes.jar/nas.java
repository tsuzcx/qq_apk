import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class nas
  extends nak
{
  public long a;
  public nat a;
  public int d;
  public String d;
  public String e;
  public String f;
  
  public static nas a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {}
    nas localnas;
    Object localObject;
    for (;;)
    {
      return null;
      localnas = new nas();
      try
      {
        localObject = paramJSONObject.optJSONObject("video");
        if (localObject != null)
        {
          localnas.e = ((JSONObject)localObject).optString("coverUrl");
          localnas.jdField_d_of_type_JavaLangString = ((JSONObject)localObject).optString("videoUrl");
          if (TextUtils.isEmpty(localnas.jdField_d_of_type_JavaLangString))
          {
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.d("AdModuleVideo", 2, "video url is null");
            return null;
          }
        }
      }
      catch (JSONException paramJSONObject)
      {
        paramJSONObject.printStackTrace();
        return null;
      }
    }
    localnas.jdField_a_of_type_Long = paramJSONObject.optLong("duration");
    localnas.jdField_d_of_type_Int = paramJSONObject.optInt("mixType");
    localnas.f = paramJSONObject.optString("linkUrl");
    paramJSONObject = paramJSONObject.optString("appInfo");
    if (!TextUtils.isEmpty(paramJSONObject))
    {
      paramJSONObject = new JSONObject(paramJSONObject);
      localObject = new nat();
      ((nat)localObject).a = paramJSONObject.optString("appid");
      ((nat)localObject).b = paramJSONObject.optString("scheme");
      ((nat)localObject).c = paramJSONObject.optString("packageName");
      ((nat)localObject).jdField_d_of_type_JavaLangString = paramJSONObject.optString("androidDownloadUrl");
      ((nat)localObject).e = paramJSONObject.optString("appName");
      localnas.jdField_a_of_type_Nat = ((nat)localObject);
    }
    return localnas;
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nas
 * JD-Core Version:    0.7.0.1
 */