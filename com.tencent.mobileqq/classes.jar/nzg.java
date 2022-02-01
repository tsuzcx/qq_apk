import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class nzg
  extends nyy
{
  public long a;
  public nzh a;
  public int d;
  public String d;
  public String e;
  public String f;
  
  public static nzg a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {}
    nzg localnzg;
    Object localObject;
    for (;;)
    {
      return null;
      localnzg = new nzg();
      try
      {
        localObject = paramJSONObject.optJSONObject("video");
        if (localObject != null)
        {
          localnzg.e = ((JSONObject)localObject).optString("coverUrl");
          localnzg.jdField_d_of_type_JavaLangString = ((JSONObject)localObject).optString("videoUrl");
          if (TextUtils.isEmpty(localnzg.jdField_d_of_type_JavaLangString))
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
    localnzg.jdField_a_of_type_Long = paramJSONObject.optLong("duration");
    localnzg.jdField_d_of_type_Int = paramJSONObject.optInt("mixType");
    localnzg.f = paramJSONObject.optString("linkUrl");
    paramJSONObject = paramJSONObject.optString("appInfo");
    if (!TextUtils.isEmpty(paramJSONObject))
    {
      paramJSONObject = new JSONObject(paramJSONObject);
      localObject = new nzh();
      ((nzh)localObject).a = paramJSONObject.optString("appid");
      ((nzh)localObject).b = paramJSONObject.optString("scheme");
      ((nzh)localObject).c = paramJSONObject.optString("packageName");
      ((nzh)localObject).jdField_d_of_type_JavaLangString = paramJSONObject.optString("androidDownloadUrl");
      ((nzh)localObject).e = paramJSONObject.optString("appName");
      localnzg.jdField_a_of_type_Nzh = ((nzh)localObject);
    }
    return localnzg;
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nzg
 * JD-Core Version:    0.7.0.1
 */