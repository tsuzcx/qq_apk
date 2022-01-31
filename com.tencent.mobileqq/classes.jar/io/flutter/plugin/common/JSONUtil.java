package io.flutter.plugin.common;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public class JSONUtil
{
  public static Object unwrap(Object paramObject)
  {
    Object localObject;
    if ((JSONObject.NULL.equals(paramObject)) || (paramObject == null)) {
      localObject = null;
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      return localObject;
                      localObject = paramObject;
                    } while ((paramObject instanceof Boolean));
                    localObject = paramObject;
                  } while ((paramObject instanceof Byte));
                  localObject = paramObject;
                } while ((paramObject instanceof Character));
                localObject = paramObject;
              } while ((paramObject instanceof Double));
              localObject = paramObject;
            } while ((paramObject instanceof Float));
            localObject = paramObject;
          } while ((paramObject instanceof Integer));
          localObject = paramObject;
        } while ((paramObject instanceof Long));
        localObject = paramObject;
      } while ((paramObject instanceof Short));
      localObject = paramObject;
    } while ((paramObject instanceof String));
    try
    {
      if ((paramObject instanceof JSONArray))
      {
        localObject = new ArrayList();
        paramObject = (JSONArray)paramObject;
        int i = 0;
        while (i < paramObject.length())
        {
          ((List)localObject).add(unwrap(paramObject.get(i)));
          i += 1;
        }
      }
      if ((paramObject instanceof JSONObject))
      {
        localObject = new HashMap();
        paramObject = (JSONObject)paramObject;
        Iterator localIterator = paramObject.keys();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          ((Map)localObject).put(str, unwrap(paramObject.get(str)));
        }
      }
      return null;
    }
    catch (Exception paramObject) {}
    return localObject;
    return localObject;
  }
  
  public static Object wrap(Object paramObject)
  {
    Object localObject;
    if (paramObject == null) {
      localObject = JSONObject.NULL;
    }
    for (;;)
    {
      return localObject;
      localObject = paramObject;
      if (!(paramObject instanceof JSONArray))
      {
        localObject = paramObject;
        if (!(paramObject instanceof JSONObject))
        {
          localObject = paramObject;
          if (!paramObject.equals(JSONObject.NULL)) {
            try
            {
              if ((paramObject instanceof Collection))
              {
                localObject = new JSONArray();
                paramObject = ((Collection)paramObject).iterator();
                while (paramObject.hasNext()) {
                  ((JSONArray)localObject).put(wrap(paramObject.next()));
                }
              }
              if (paramObject.getClass().isArray())
              {
                localObject = new JSONArray();
                int j = Array.getLength(paramObject);
                int i = 0;
                while (i < j)
                {
                  ((JSONArray)localObject).put(wrap(Array.get(paramObject, i)));
                  i += 1;
                }
              }
              if ((paramObject instanceof Map))
              {
                localObject = new JSONObject();
                paramObject = ((Map)paramObject).entrySet().iterator();
                while (paramObject.hasNext())
                {
                  Map.Entry localEntry = (Map.Entry)paramObject.next();
                  ((JSONObject)localObject).put((String)localEntry.getKey(), wrap(localEntry.getValue()));
                }
              }
              localObject = paramObject;
              if (!(paramObject instanceof Boolean))
              {
                localObject = paramObject;
                if (!(paramObject instanceof Byte))
                {
                  localObject = paramObject;
                  if (!(paramObject instanceof Character))
                  {
                    localObject = paramObject;
                    if (!(paramObject instanceof Double))
                    {
                      localObject = paramObject;
                      if (!(paramObject instanceof Float))
                      {
                        localObject = paramObject;
                        if (!(paramObject instanceof Integer))
                        {
                          localObject = paramObject;
                          if (!(paramObject instanceof Long))
                          {
                            localObject = paramObject;
                            if (!(paramObject instanceof Short))
                            {
                              localObject = paramObject;
                              if (!(paramObject instanceof String)) {
                                if (paramObject.getClass().getPackage().getName().startsWith("java."))
                                {
                                  paramObject = paramObject.toString();
                                  return paramObject;
                                }
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
            catch (Exception paramObject) {}
          }
        }
      }
    }
    return null;
    return localObject;
    return localObject;
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     io.flutter.plugin.common.JSONUtil
 * JD-Core Version:    0.7.0.1
 */