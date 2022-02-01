package com.tencent.mobileqq.flutter.router;

import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class SerializableMap
  implements Serializable
{
  private Map<String, Object> map;
  
  private static Object a(Object paramObject)
  {
    Object localObject1;
    if (paramObject == null) {
      localObject1 = JSONObject.NULL;
    }
    do
    {
      do
      {
        do
        {
          return localObject1;
          localObject1 = paramObject;
        } while ((paramObject instanceof JSONObject));
        localObject1 = paramObject;
      } while ((paramObject instanceof JSONArray));
      localObject1 = paramObject;
    } while (paramObject.equals(JSONObject.NULL));
    label156:
    do
    {
      Object localObject2;
      try
      {
        if ((paramObject instanceof Collection))
        {
          localObject1 = new JSONArray();
          localObject2 = ((Collection)paramObject).iterator();
          while (((Iterator)localObject2).hasNext()) {
            ((JSONArray)localObject1).put(a(((Iterator)localObject2).next()));
          }
        }
        if (!paramObject.getClass().isArray()) {
          break label156;
        }
      }
      catch (Exception paramObject)
      {
        QLog.d("SerializableMap", 2, "SerializableMap wrap", paramObject);
        return null;
      }
      localObject1 = new JSONArray();
      int j = Array.getLength(paramObject);
      int i = 0;
      while (i < j)
      {
        ((JSONArray)localObject1).put(a(Array.get(paramObject, i)));
        i += 1;
      }
      if ((paramObject instanceof Map))
      {
        localObject1 = new JSONObject();
        paramObject = ((Map)paramObject).entrySet().iterator();
        while (paramObject.hasNext())
        {
          localObject2 = (Map.Entry)paramObject.next();
          ((JSONObject)localObject1).put((String)((Map.Entry)localObject2).getKey(), a(((Map.Entry)localObject2).getValue()));
        }
      }
      localObject1 = paramObject;
      if ((paramObject instanceof Boolean)) {
        break;
      }
      localObject1 = paramObject;
      if ((paramObject instanceof Byte)) {
        break;
      }
      localObject1 = paramObject;
      if ((paramObject instanceof Character)) {
        break;
      }
      localObject1 = paramObject;
      if ((paramObject instanceof Double)) {
        break;
      }
      localObject1 = paramObject;
      if ((paramObject instanceof Float)) {
        break;
      }
      localObject1 = paramObject;
      if ((paramObject instanceof Integer)) {
        break;
      }
      localObject1 = paramObject;
      if ((paramObject instanceof Long)) {
        break;
      }
      localObject1 = paramObject;
      if ((paramObject instanceof Short)) {
        break;
      }
      localObject1 = paramObject;
      if ((paramObject instanceof String)) {
        break;
      }
    } while (!paramObject.getClass().getPackage().getName().startsWith("java."));
    paramObject = paramObject.toString();
    return paramObject;
    return localObject1;
    return localObject1;
  }
  
  public Map<String, Object> getMap()
  {
    return this.map;
  }
  
  public void setMap(Map<String, Object> paramMap)
  {
    this.map = paramMap;
  }
  
  public String toJson()
  {
    if (this.map == null) {
      return "";
    }
    localJSONObject = new JSONObject();
    try
    {
      Iterator localIterator = this.map.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        localJSONObject.put((String)localEntry.getKey(), a(localEntry.getValue()));
      }
      return localJSONObject.toString();
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.flutter.router.SerializableMap
 * JD-Core Version:    0.7.0.1
 */