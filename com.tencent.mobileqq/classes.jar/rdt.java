import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

public class rdt
{
  private static Map<String, rdu> a = new ConcurrentHashMap();
  
  static
  {
    a();
  }
  
  public static String a(String paramString)
  {
    JSONObject localJSONObject = new JSONObject();
    Object localObject;
    try
    {
      localObject = (rdu)a.get(paramString);
      localJSONObject.put("app", "QQ");
      localJSONObject.put("appVersion", "8.2.6");
      localJSONObject.put("businessID", ((rdu)localObject).b);
      localJSONObject.put("os", "android");
      localObject = new JSONObject();
      paramString = rdw.a(paramString, false);
      if (paramString != null)
      {
        paramString = paramString.a().entrySet().iterator();
        while (paramString.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)paramString.next();
          ((JSONObject)localObject).put((String)localEntry.getKey(), localEntry.getValue());
          continue;
          return localJSONObject.toString();
        }
      }
    }
    catch (Exception paramString)
    {
      QLog.d("RealTimeController", 1, "", paramString);
    }
    for (;;)
    {
      localJSONObject.put("styles", localObject);
      QLog.d("RealTimeController", 1, "styles: " + localJSONObject);
    }
  }
  
  public static rdw a(String paramString)
  {
    if (a.containsKey(paramString))
    {
      paramString = (rdu)a.get(paramString);
      if ((paramString != null) && (paramString.jdField_a_of_type_Rdv != null)) {
        return paramString.jdField_a_of_type_Rdv.a();
      }
    }
    return null;
  }
  
  private static void a()
  {
    a(new rdu("default_feeds", "1"));
  }
  
  public static void a(String paramString1, String paramString2)
  {
    QLog.d("RealTimeController", 1, "serviceKey:" + paramString1 + " styles:" + paramString2);
    if (TextUtils.isEmpty(paramString2)) {}
    rdu localrdu;
    do
    {
      return;
      localrdu = (rdu)a.get(paramString1);
    } while (localrdu == null);
    paramString1 = rdw.a(paramString1, true);
    if (paramString1 == null)
    {
      QLog.d("RealTimeController", 1, "realTimeTemplateFactory == null styles:" + paramString2);
      return;
    }
    for (;;)
    {
      try
      {
        paramString1.a(rdm.a());
        localObject = new JSONObject(paramString2);
        paramString2 = ((JSONObject)localObject).getString("businessID");
        QLog.d("RealTimeController", 1, "realTimeBusinessID: " + paramString2);
        paramString2 = ((JSONObject)localObject).getJSONArray("styleList");
        if (!((JSONObject)localObject).has("deleteList")) {
          break label282;
        }
        localObject = ((JSONObject)localObject).getJSONArray("deleteList");
        ArrayList localArrayList = new ArrayList();
        i = 0;
        if (i < ((JSONArray)localObject).length())
        {
          String str = ((JSONArray)localObject).getString(i);
          localArrayList.add(str);
          paramString1.c(str);
          i += 1;
          continue;
        }
        localrdu.jdField_a_of_type_Rdv.a(localArrayList);
      }
      catch (Exception paramString1)
      {
        Object localObject;
        QLog.d("RealTimeController", 1, "", paramString1);
        return;
      }
      if (i >= paramString2.length()) {
        break;
      }
      localObject = (JSONObject)paramString2.get(i);
      localrdu.jdField_a_of_type_Rdv.a(paramString1, (JSONObject)localObject, true);
      i += 1;
      continue;
      label282:
      int i = 0;
    }
  }
  
  public static void a(rdu paramrdu)
  {
    if ((paramrdu.jdField_a_of_type_JavaLangString == null) || (paramrdu.b == null)) {
      return;
    }
    a.put(paramrdu.jdField_a_of_type_JavaLangString, paramrdu);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rdt
 * JD-Core Version:    0.7.0.1
 */