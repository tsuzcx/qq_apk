import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class nlt
  extends nll
{
  public long a;
  public nlu a;
  public int d;
  public String d;
  public String e;
  public String f;
  
  public static nlt a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {}
    nlt localnlt;
    Object localObject;
    for (;;)
    {
      return null;
      localnlt = new nlt();
      try
      {
        localObject = paramJSONObject.optJSONObject("video");
        if (localObject != null)
        {
          localnlt.e = ((JSONObject)localObject).optString("coverUrl");
          localnlt.jdField_d_of_type_JavaLangString = ((JSONObject)localObject).optString("videoUrl");
          if (TextUtils.isEmpty(localnlt.jdField_d_of_type_JavaLangString))
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
    localnlt.jdField_a_of_type_Long = paramJSONObject.optLong("duration");
    localnlt.jdField_d_of_type_Int = paramJSONObject.optInt("mixType");
    localnlt.f = paramJSONObject.optString("linkUrl");
    paramJSONObject = paramJSONObject.optString("appInfo");
    if (!TextUtils.isEmpty(paramJSONObject))
    {
      paramJSONObject = new JSONObject(paramJSONObject);
      localObject = new nlu();
      ((nlu)localObject).a = paramJSONObject.optString("appid");
      ((nlu)localObject).b = paramJSONObject.optString("scheme");
      ((nlu)localObject).c = paramJSONObject.optString("packageName");
      ((nlu)localObject).jdField_d_of_type_JavaLangString = paramJSONObject.optString("androidDownloadUrl");
      ((nlu)localObject).e = paramJSONObject.optString("appName");
      localnlt.jdField_a_of_type_Nlu = ((nlu)localObject);
    }
    return localnlt;
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nlt
 * JD-Core Version:    0.7.0.1
 */