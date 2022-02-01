import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import org.json.JSONObject;

public class ozw
{
  public static JSONObject a(JSONObject paramJSONObject, String paramString, Object paramObject)
  {
    JSONObject localJSONObject = paramJSONObject;
    if (paramJSONObject == null) {
      localJSONObject = new JSONObject();
    }
    try
    {
      localJSONObject.put(paramString, paramObject);
      return localJSONObject;
    }
    catch (Exception paramJSONObject)
    {
      QLog.d("RIJJsonUtils", 1, "addInfo2Json error!  msg=" + paramJSONObject);
    }
    return localJSONObject;
  }
  
  public static void a(JSONObject paramJSONObject, String paramString1, String paramString2)
  {
    if (paramJSONObject == null)
    {
      QLog.d("RIJJsonUtils", 2, "addDataString2Json | jsonObject is null");
      return;
    }
    if (TextUtils.isEmpty(paramString1))
    {
      QLog.d("RIJJsonUtils", 2, "addDataString2Json | jsonObject key null");
      return;
    }
    if (TextUtils.isEmpty(paramString2))
    {
      QLog.d("RIJJsonUtils", 2, "addDataString2Json | jsonObject value null");
      return;
    }
    paramJSONObject.put(paramString1, paramString2);
  }
  
  public static void a(JSONObject paramJSONObject1, JSONObject paramJSONObject2)
  {
    if ((paramJSONObject1 == null) || (paramJSONObject2 == null)) {}
    for (;;)
    {
      return;
      Iterator localIterator = paramJSONObject2.keys();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        try
        {
          paramJSONObject1.put(str, paramJSONObject2.get(str));
        }
        catch (Exception localException)
        {
          QLog.d("RIJJsonUtils", 1, "mergeJSONData error!  msg=" + localException);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ozw
 * JD-Core Version:    0.7.0.1
 */