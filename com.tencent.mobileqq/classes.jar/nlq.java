import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class nlq
  extends nli
{
  public long a;
  public nlr a;
  public int d;
  public String d;
  public String e;
  public String f;
  
  public static nlq a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {}
    nlq localnlq;
    Object localObject;
    for (;;)
    {
      return null;
      localnlq = new nlq();
      try
      {
        localObject = paramJSONObject.optJSONObject("video");
        if (localObject != null)
        {
          localnlq.e = ((JSONObject)localObject).optString("coverUrl");
          localnlq.jdField_d_of_type_JavaLangString = ((JSONObject)localObject).optString("videoUrl");
          if (TextUtils.isEmpty(localnlq.jdField_d_of_type_JavaLangString))
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
    localnlq.jdField_a_of_type_Long = paramJSONObject.optLong("duration");
    localnlq.jdField_d_of_type_Int = paramJSONObject.optInt("mixType");
    localnlq.f = paramJSONObject.optString("linkUrl");
    paramJSONObject = paramJSONObject.optString("appInfo");
    if (!TextUtils.isEmpty(paramJSONObject))
    {
      paramJSONObject = new JSONObject(paramJSONObject);
      localObject = new nlr();
      ((nlr)localObject).a = paramJSONObject.optString("appid");
      ((nlr)localObject).b = paramJSONObject.optString("scheme");
      ((nlr)localObject).c = paramJSONObject.optString("packageName");
      ((nlr)localObject).jdField_d_of_type_JavaLangString = paramJSONObject.optString("androidDownloadUrl");
      ((nlr)localObject).e = paramJSONObject.optString("appName");
      localnlq.jdField_a_of_type_Nlr = ((nlr)localObject);
    }
    return localnlq;
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nlq
 * JD-Core Version:    0.7.0.1
 */