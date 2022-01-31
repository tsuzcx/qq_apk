import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class nom
  extends noe
{
  public long a;
  public non a;
  public int d;
  public String d;
  public String e;
  public String f;
  
  public static nom a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {}
    nom localnom;
    Object localObject;
    for (;;)
    {
      return null;
      localnom = new nom();
      try
      {
        localObject = paramJSONObject.optJSONObject("video");
        if (localObject != null)
        {
          localnom.e = ((JSONObject)localObject).optString("coverUrl");
          localnom.jdField_d_of_type_JavaLangString = ((JSONObject)localObject).optString("videoUrl");
          if (TextUtils.isEmpty(localnom.jdField_d_of_type_JavaLangString))
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
    localnom.jdField_a_of_type_Long = paramJSONObject.optLong("duration");
    localnom.jdField_d_of_type_Int = paramJSONObject.optInt("mixType");
    localnom.f = paramJSONObject.optString("linkUrl");
    paramJSONObject = paramJSONObject.optString("appInfo");
    if (!TextUtils.isEmpty(paramJSONObject))
    {
      paramJSONObject = new JSONObject(paramJSONObject);
      localObject = new non();
      ((non)localObject).a = paramJSONObject.optString("appid");
      ((non)localObject).b = paramJSONObject.optString("scheme");
      ((non)localObject).c = paramJSONObject.optString("packageName");
      ((non)localObject).jdField_d_of_type_JavaLangString = paramJSONObject.optString("androidDownloadUrl");
      ((non)localObject).e = paramJSONObject.optString("appName");
      localnom.jdField_a_of_type_Non = ((non)localObject);
    }
    return localnom;
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     nom
 * JD-Core Version:    0.7.0.1
 */