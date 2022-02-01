import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class oar
  extends oaj
{
  public long a;
  public oas a;
  public int d;
  public String d;
  public String e;
  public String f;
  
  public static oar a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {}
    oar localoar;
    Object localObject;
    for (;;)
    {
      return null;
      localoar = new oar();
      try
      {
        localObject = paramJSONObject.optJSONObject("video");
        if (localObject != null)
        {
          localoar.e = ((JSONObject)localObject).optString("coverUrl");
          localoar.jdField_d_of_type_JavaLangString = ((JSONObject)localObject).optString("videoUrl");
          if (TextUtils.isEmpty(localoar.jdField_d_of_type_JavaLangString))
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
    localoar.jdField_a_of_type_Long = paramJSONObject.optLong("duration");
    localoar.jdField_d_of_type_Int = paramJSONObject.optInt("mixType");
    localoar.f = paramJSONObject.optString("linkUrl");
    paramJSONObject = paramJSONObject.optString("appInfo");
    if (!TextUtils.isEmpty(paramJSONObject))
    {
      paramJSONObject = new JSONObject(paramJSONObject);
      localObject = new oas();
      ((oas)localObject).a = paramJSONObject.optString("appid");
      ((oas)localObject).b = paramJSONObject.optString("scheme");
      ((oas)localObject).c = paramJSONObject.optString("packageName");
      ((oas)localObject).jdField_d_of_type_JavaLangString = paramJSONObject.optString("androidDownloadUrl");
      ((oas)localObject).e = paramJSONObject.optString("appName");
      localoar.jdField_a_of_type_Oas = ((oas)localObject);
    }
    return localoar;
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     oar
 * JD-Core Version:    0.7.0.1
 */