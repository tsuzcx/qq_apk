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

public class svl
{
  private static Map<String, svm> a = new ConcurrentHashMap();
  
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
      localObject = (svm)a.get(paramString);
      localJSONObject.put("app", "QQ");
      localJSONObject.put("appVersion", "8.4.5");
      localJSONObject.put("businessID", ((svm)localObject).b);
      localJSONObject.put("os", "android");
      localObject = new JSONObject();
      paramString = svo.a(paramString, false);
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
  
  public static svo a(String paramString)
  {
    if (a.containsKey(paramString))
    {
      paramString = (svm)a.get(paramString);
      if ((paramString != null) && (paramString.jdField_a_of_type_Svn != null)) {
        return paramString.jdField_a_of_type_Svn.a();
      }
    }
    return null;
  }
  
  private static void a()
  {
    a(new svm("default_feeds", "1"));
  }
  
  public static void a(String paramString1, String paramString2)
  {
    QLog.d("RealTimeController", 1, "serviceKey:" + paramString1 + " styles:" + paramString2);
    if (TextUtils.isEmpty(paramString2)) {}
    svm localsvm;
    do
    {
      return;
      localsvm = (svm)a.get(paramString1);
    } while (localsvm == null);
    paramString1 = svo.a(paramString1, true);
    if (paramString1 == null)
    {
      QLog.d("RealTimeController", 1, "realTimeTemplateFactory == null styles:" + paramString2);
      return;
    }
    for (;;)
    {
      try
      {
        paramString1.a(svf.a());
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
          paramString1.d(str);
          i += 1;
          continue;
        }
        localsvm.jdField_a_of_type_Svn.a(localArrayList);
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
      localsvm.jdField_a_of_type_Svn.a(paramString1, (JSONObject)localObject, true);
      i += 1;
      continue;
      label282:
      int i = 0;
    }
  }
  
  public static void a(svm paramsvm)
  {
    if ((paramsvm.jdField_a_of_type_JavaLangString == null) || (paramsvm.b == null)) {
      return;
    }
    a.put(paramsvm.jdField_a_of_type_JavaLangString, paramsvm);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     svl
 * JD-Core Version:    0.7.0.1
 */