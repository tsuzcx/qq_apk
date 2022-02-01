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
    if (paramObject == null) {
      return JSONObject.NULL;
    }
    Object localObject1 = paramObject;
    if (!(paramObject instanceof JSONObject))
    {
      if ((paramObject instanceof JSONArray)) {
        return paramObject;
      }
      if (paramObject.equals(JSONObject.NULL)) {
        return paramObject;
      }
      try
      {
        Object localObject2;
        if ((paramObject instanceof Collection))
        {
          localObject1 = new JSONArray();
          localObject2 = ((Collection)paramObject).iterator();
          while (((Iterator)localObject2).hasNext()) {
            ((JSONArray)localObject1).put(a(((Iterator)localObject2).next()));
          }
        }
        if (paramObject.getClass().isArray())
        {
          localObject1 = new JSONArray();
          int j = Array.getLength(paramObject);
          int i = 0;
          while (i < j)
          {
            ((JSONArray)localObject1).put(a(Array.get(paramObject, i)));
            i += 1;
          }
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
        if (!(paramObject instanceof Boolean))
        {
          localObject1 = paramObject;
          if (!(paramObject instanceof Byte))
          {
            localObject1 = paramObject;
            if (!(paramObject instanceof Character))
            {
              localObject1 = paramObject;
              if (!(paramObject instanceof Double))
              {
                localObject1 = paramObject;
                if (!(paramObject instanceof Float))
                {
                  localObject1 = paramObject;
                  if (!(paramObject instanceof Integer))
                  {
                    localObject1 = paramObject;
                    if (!(paramObject instanceof Long))
                    {
                      localObject1 = paramObject;
                      if (!(paramObject instanceof Short))
                      {
                        if ((paramObject instanceof String)) {
                          return paramObject;
                        }
                        if (!paramObject.getClass().getPackage().getName().startsWith("java.")) {
                          break label336;
                        }
                        localObject1 = paramObject.toString();
                      }
                    }
                  }
                }
              }
            }
          }
        }
        return localObject1;
      }
      catch (Exception paramObject)
      {
        QLog.d("SerializableMap", 2, "SerializableMap wrap", paramObject);
        label336:
        localObject1 = null;
      }
    }
    else
    {
      return localObject1;
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flutter.router.SerializableMap
 * JD-Core Version:    0.7.0.1
 */