package dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face;

import android.support.annotation.NonNull;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class InfomationFacePackage
  extends FacePackage
{
  public static boolean b = false;
  public List<InfomationFacePackage.Item> a = new ArrayList();
  public Map<String, Map<String, InfomationFacePackage.CityRes>> a;
  public int c;
  public String f;
  public String g = "default";
  public String h;
  public String i;
  
  public InfomationFacePackage(@NonNull String paramString)
  {
    super(paramString);
  }
  
  public static List<InfomationFacePackage.Item> a(JSONArray paramJSONArray)
  {
    ArrayList localArrayList = new ArrayList();
    int j = 0;
    while (j < paramJSONArray.length())
    {
      localArrayList.add(new InfomationFacePackage.Item(paramJSONArray.getJSONObject(j)));
      j += 1;
    }
    return localArrayList;
  }
  
  public static Map<String, Map<String, InfomationFacePackage.CityRes>> a(JSONArray paramJSONArray)
  {
    Object localObject1;
    if (paramJSONArray != null) {
      try
      {
        if (paramJSONArray.length() > 0)
        {
          HashMap localHashMap1 = new HashMap(paramJSONArray.length());
          int j = 0;
          for (;;)
          {
            localObject1 = localHashMap1;
            if (j >= paramJSONArray.length()) {
              break;
            }
            Object localObject2 = paramJSONArray.getJSONObject(j);
            localObject1 = ((JSONObject)localObject2).getString("id");
            localObject2 = ((JSONObject)localObject2).getJSONArray("res");
            if ((localObject2 != null) && (((JSONArray)localObject2).length() > 0))
            {
              HashMap localHashMap2 = new HashMap(((JSONArray)localObject2).length());
              int k = 0;
              while (k < ((JSONArray)localObject2).length())
              {
                JSONObject localJSONObject = ((JSONArray)localObject2).getJSONObject(k);
                InfomationFacePackage.CityRes localCityRes = new InfomationFacePackage.CityRes();
                localCityRes.a = localJSONObject.getString("resname");
                localCityRes.b = localJSONObject.getString("resurl");
                localCityRes.d = localJSONObject.getString("cityname");
                localCityRes.c = localJSONObject.getString("md5");
                localHashMap2.put(localCityRes.d, localCityRes);
                k += 1;
              }
              localHashMap1.put(localObject1, localHashMap2);
            }
            j += 1;
          }
        }
        localObject1 = null;
      }
      catch (JSONException paramJSONArray)
      {
        QLog.e("FacePackage", 1, paramJSONArray, new Object[0]);
      }
    }
    return localObject1;
  }
  
  public InfomationFacePackage.Item a(String paramString)
  {
    if ((!StringUtil.a(paramString)) && (this.a != null))
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext())
      {
        InfomationFacePackage.Item localItem = (InfomationFacePackage.Item)localIterator.next();
        if (paramString.equals(localItem.a)) {
          return localItem;
        }
      }
    }
    return null;
  }
  
  public String a()
  {
    return "InformationFacePackage";
  }
  
  public String a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.a.size())) {
      return ((InfomationFacePackage.Item)this.a.get(paramInt)).c;
    }
    return null;
  }
  
  public int b()
  {
    return this.a.size();
  }
  
  public String b(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.a.size())) {
      return ((InfomationFacePackage.Item)this.a.get(paramInt)).d;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.InfomationFacePackage
 * JD-Core Version:    0.7.0.1
 */