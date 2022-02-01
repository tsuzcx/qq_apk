import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class nxm
  extends nxe
{
  public long a;
  public nxn a;
  public int d;
  public String d;
  public String e;
  public String f;
  
  public static nxm a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {}
    nxm localnxm;
    Object localObject;
    for (;;)
    {
      return null;
      localnxm = new nxm();
      try
      {
        localObject = paramJSONObject.optJSONObject("video");
        if (localObject != null)
        {
          localnxm.e = ((JSONObject)localObject).optString("coverUrl");
          localnxm.jdField_d_of_type_JavaLangString = ((JSONObject)localObject).optString("videoUrl");
          if (TextUtils.isEmpty(localnxm.jdField_d_of_type_JavaLangString))
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
    localnxm.jdField_a_of_type_Long = paramJSONObject.optLong("duration");
    localnxm.jdField_d_of_type_Int = paramJSONObject.optInt("mixType");
    localnxm.f = paramJSONObject.optString("linkUrl");
    paramJSONObject = paramJSONObject.optString("appInfo");
    if (!TextUtils.isEmpty(paramJSONObject))
    {
      paramJSONObject = new JSONObject(paramJSONObject);
      localObject = new nxn();
      ((nxn)localObject).a = paramJSONObject.optString("appid");
      ((nxn)localObject).b = paramJSONObject.optString("scheme");
      ((nxn)localObject).c = paramJSONObject.optString("packageName");
      ((nxn)localObject).jdField_d_of_type_JavaLangString = paramJSONObject.optString("androidDownloadUrl");
      ((nxn)localObject).e = paramJSONObject.optString("appName");
      localnxm.jdField_a_of_type_Nxn = ((nxn)localObject);
    }
    return localnxm;
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nxm
 * JD-Core Version:    0.7.0.1
 */