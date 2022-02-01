import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.kandianreport.ReadInJoyMMapKvStorage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class qhc
{
  public String a;
  public List<String> a;
  public String b;
  public List<String> b;
  public String c = "";
  public String d = "";
  
  public qhc()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
  }
  
  public static String a()
  {
    return a(-1);
  }
  
  public static String a(int paramInt)
  {
    for (;;)
    {
      try
      {
        JSONArray localJSONArray = new JSONArray();
        if (bmhv.a(paramInt))
        {
          if (-1 == paramInt) {
            break label203;
          }
          localObject1 = (String)bmhv.a("DAILY_CHILD_FEEDS_REQUEST_CONFIG" + paramInt, "");
          if (!TextUtils.isEmpty((CharSequence)localObject1))
          {
            localObject3 = new JSONObject();
            ((JSONObject)localObject3).put("daily_sub_channel_request_data", localObject1);
            localJSONArray.put(localObject3);
          }
          if (bmhv.C()) {
            localJSONArray.put(bmhv.a());
          }
          localJSONArray.put(bmhv.b());
          return localJSONArray.toString();
        }
        Object localObject1 = ReadInJoyMMapKvStorage.getInstance().getValeForKey("KANDIAN_DAILY_SETTING_CONFIG");
        Object localObject3 = (String)bmhv.a("KANDIAN_DAILY_LCAOL_SETTING_CONFIG", "");
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          break label198;
        }
        localObject1 = new JSONArray((String)localObject1);
        if (!TextUtils.isEmpty((CharSequence)localObject3))
        {
          localObject3 = new JSONArray((String)localObject3);
          a((JSONArray)localObject1, localJSONArray);
          a((JSONArray)localObject3, localJSONArray);
          if (!plm.b()) {
            continue;
          }
          localJSONArray.put(qff.a(true));
          continue;
        }
        localObject3 = null;
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
        return "";
      }
      continue;
      label198:
      Object localObject2 = null;
      continue;
      label203:
      localObject2 = null;
    }
  }
  
  public static qhc a(JSONObject paramJSONObject)
  {
    int j = 0;
    qhc localqhc = new qhc();
    if (paramJSONObject != null)
    {
      localqhc.jdField_a_of_type_JavaLangString = paramJSONObject.optString("key");
      localqhc.jdField_b_of_type_JavaLangString = paramJSONObject.optString("name");
      localqhc.d = paramJSONObject.optString("value");
      localqhc.c = paramJSONObject.optString("id");
      Object localObject = paramJSONObject.optJSONArray("valuelist");
      int i;
      if (localObject != null)
      {
        localqhc.jdField_b_of_type_JavaUtilList = new ArrayList();
        i = 0;
        while (i < ((JSONArray)localObject).length())
        {
          String str = ((JSONArray)localObject).optString(i);
          localqhc.jdField_b_of_type_JavaUtilList.add(str);
          i += 1;
        }
      }
      paramJSONObject = paramJSONObject.optJSONArray("idlist");
      if (paramJSONObject != null)
      {
        localqhc.jdField_a_of_type_JavaUtilList = new ArrayList();
        i = j;
        while (i < paramJSONObject.length())
        {
          localObject = paramJSONObject.optString(i);
          localqhc.jdField_a_of_type_JavaUtilList.add(localObject);
          i += 1;
        }
      }
    }
    return localqhc;
  }
  
  private static void a(JSONArray paramJSONArray1, JSONArray paramJSONArray2)
  {
    if (paramJSONArray1 != null)
    {
      int i = 0;
      for (;;)
      {
        if (i < paramJSONArray1.length())
        {
          JSONObject localJSONObject = paramJSONArray1.optJSONObject(i);
          String str1 = localJSONObject.optString("key");
          String str2 = localJSONObject.optString("id");
          if (!TextUtils.isEmpty(str2)) {
            localJSONObject = new JSONObject();
          }
          try
          {
            localJSONObject.put(str1, str2);
            paramJSONArray2.put(localJSONObject);
            i += 1;
          }
          catch (JSONException localJSONException)
          {
            for (;;)
            {
              localJSONException.printStackTrace();
            }
          }
        }
      }
    }
  }
  
  public JSONObject a()
  {
    JSONObject localJSONObject = new JSONObject();
    Iterator localIterator;
    try
    {
      localJSONObject.put("key", this.jdField_a_of_type_JavaLangString);
      localJSONObject.put("name", this.jdField_b_of_type_JavaLangString);
      localJSONObject.put("id", this.c);
      localJSONObject.put("value", this.d);
      JSONArray localJSONArray1 = new JSONArray();
      if (this.jdField_b_of_type_JavaUtilList != null)
      {
        localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
        while (localIterator.hasNext()) {
          localJSONArray1.put((String)localIterator.next());
        }
      }
      localJSONObject.put("valuelist", localJSONException);
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
      return localJSONObject;
    }
    JSONArray localJSONArray2 = new JSONArray();
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        localJSONArray2.put((String)localIterator.next());
      }
    }
    localJSONObject.put("idlist", localJSONArray2);
    return localJSONObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qhc
 * JD-Core Version:    0.7.0.1
 */