import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

public class pjc
{
  public static String a()
  {
    uwo.a();
    StringBuilder localStringBuilder = new StringBuilder("{");
    a(localStringBuilder, "probesize", Long.valueOf(bmhv.b()));
    localStringBuilder.append(",");
    a(localStringBuilder, "isFFProbelistSwitch", Boolean.valueOf(bmhv.u()));
    localStringBuilder.append(",");
    a(localStringBuilder, "isDownloadAsyncIo", Boolean.valueOf(bmhv.v()));
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  public static JSONArray a(JSONArray paramJSONArray1, JSONArray paramJSONArray2)
  {
    if (paramJSONArray2 == null) {
      return paramJSONArray1;
    }
    int i = 0;
    for (;;)
    {
      try
      {
        if ((i >= paramJSONArray1.length()) || (i >= paramJSONArray2.length())) {
          break;
        }
        if (((paramJSONArray2.get(i) instanceof JSONObject)) && ((paramJSONArray1.get(i) instanceof JSONObject)))
        {
          JSONObject localJSONObject1 = (JSONObject)paramJSONArray2.get(i);
          JSONObject localJSONObject2 = (JSONObject)paramJSONArray1.get(i);
          Iterator localIterator = localJSONObject1.keys();
          if (localIterator.hasNext())
          {
            String str = (String)localIterator.next();
            localJSONObject2.put(str, localJSONObject1.get(str));
            continue;
          }
        }
        i += 1;
      }
      catch (Exception paramJSONArray2)
      {
        QLog.e("RIJJsonUtils", 2, "setCellArray:remoteArray: ", paramJSONArray2);
        return paramJSONArray1;
      }
    }
  }
  
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
  
  private static void a(StringBuilder paramStringBuilder, String paramString, Object paramObject)
  {
    paramStringBuilder.append("\"");
    paramStringBuilder.append(paramString);
    paramStringBuilder.append("\":");
    paramStringBuilder.append("\"");
    paramStringBuilder.append(paramObject);
    paramStringBuilder.append("\"");
  }
  
  public static void a(JSONObject paramJSONObject, String paramString, int paramInt)
  {
    if (paramInt >= 0) {}
    try
    {
      paramJSONObject.put(paramString, paramInt);
      return;
    }
    catch (Exception paramJSONObject)
    {
      QLog.d("RIJJsonUtils", 1, "putSafeIntValueToJson error!  msg=" + paramJSONObject);
    }
  }
  
  public static void a(JSONObject paramJSONObject, String paramString, long paramLong)
  {
    if (paramLong > 0L) {}
    try
    {
      paramJSONObject.put(paramString, paramLong);
      return;
    }
    catch (Exception paramJSONObject)
    {
      QLog.d("RIJJsonUtils", 1, "putSafeLongValueToJson error!  msg=" + paramJSONObject);
    }
  }
  
  public static void a(JSONObject paramJSONObject, String paramString, long paramLong, boolean paramBoolean)
  {
    if ((paramBoolean) && (paramLong > 0L)) {}
    try
    {
      paramJSONObject.put(paramString, String.valueOf(paramLong));
      return;
    }
    catch (Exception paramJSONObject)
    {
      QLog.d("RIJJsonUtils", 1, "putSafeLongValueConvertStringToJson error!  msg=" + paramJSONObject);
    }
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
  
  public static void a(JSONObject paramJSONObject, String paramString1, String paramString2, boolean paramBoolean)
  {
    if (paramBoolean) {}
    try
    {
      paramJSONObject.put(paramString1, paramString2);
      return;
    }
    catch (Exception paramJSONObject)
    {
      QLog.d("RIJJsonUtils", 1, "putSafeLongValueConvertStringToJson error!  msg=" + paramJSONObject);
    }
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
  
  public static void b(JSONObject paramJSONObject, String paramString, long paramLong, boolean paramBoolean)
  {
    if (paramBoolean) {}
    try
    {
      paramJSONObject.put(paramString, paramLong);
      return;
    }
    catch (Exception paramJSONObject)
    {
      QLog.d("RIJJsonUtils", 1, "putSafeLongValueConvertStringToJson error!  msg=" + paramJSONObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pjc
 * JD-Core Version:    0.7.0.1
 */