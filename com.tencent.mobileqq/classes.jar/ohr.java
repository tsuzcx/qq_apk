import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class ohr
  extends ohj
{
  public long a;
  public ohs a;
  public int d;
  public String d;
  public String e;
  public String f;
  
  public static ohr a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {}
    ohr localohr;
    Object localObject;
    for (;;)
    {
      return null;
      localohr = new ohr();
      try
      {
        localObject = paramJSONObject.optJSONObject("video");
        if (localObject != null)
        {
          localohr.e = ((JSONObject)localObject).optString("coverUrl");
          localohr.jdField_d_of_type_JavaLangString = ((JSONObject)localObject).optString("videoUrl");
          if (TextUtils.isEmpty(localohr.jdField_d_of_type_JavaLangString))
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
    localohr.jdField_a_of_type_Long = paramJSONObject.optLong("duration");
    localohr.jdField_d_of_type_Int = paramJSONObject.optInt("mixType");
    localohr.f = paramJSONObject.optString("linkUrl");
    paramJSONObject = paramJSONObject.optString("appInfo");
    if (!TextUtils.isEmpty(paramJSONObject))
    {
      paramJSONObject = new JSONObject(paramJSONObject);
      localObject = new ohs();
      ((ohs)localObject).a = paramJSONObject.optString("appid");
      ((ohs)localObject).b = paramJSONObject.optString("scheme");
      ((ohs)localObject).c = paramJSONObject.optString("packageName");
      ((ohs)localObject).jdField_d_of_type_JavaLangString = paramJSONObject.optString("androidDownloadUrl");
      ((ohs)localObject).e = paramJSONObject.optString("appName");
      localohr.jdField_a_of_type_Ohs = ((ohs)localObject);
    }
    return localohr;
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ohr
 * JD-Core Version:    0.7.0.1
 */