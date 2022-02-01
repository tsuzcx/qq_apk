package com.tencent.mtt.hippy.common;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public class HippyMap
{
  private final HashMap<String, Object> mDatas = new HashMap();
  
  public void clear()
  {
    this.mDatas.clear();
  }
  
  public boolean containsKey(String paramString)
  {
    return this.mDatas.containsKey(paramString);
  }
  
  public HippyMap copy()
  {
    HippyMap localHippyMap = new HippyMap();
    Iterator localIterator = this.mDatas.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      Object localObject2 = localEntry.getValue();
      Object localObject1;
      if ((localObject2 instanceof HippyMap))
      {
        localObject1 = ((HippyMap)localObject2).copy();
      }
      else
      {
        localObject1 = localObject2;
        if ((localObject2 instanceof HippyArray)) {
          localObject1 = ((HippyArray)localObject2).copy();
        }
      }
      localHippyMap.pushObject((String)localEntry.getKey(), localObject1);
    }
    return localHippyMap;
  }
  
  public Set<Map.Entry<String, Object>> entrySet()
  {
    return this.mDatas.entrySet();
  }
  
  public Object get(String paramString)
  {
    return this.mDatas.get(paramString);
  }
  
  public HippyArray getArray(String paramString)
  {
    paramString = this.mDatas.get(paramString);
    if ((paramString instanceof HippyArray)) {
      return (HippyArray)paramString;
    }
    return null;
  }
  
  public boolean getBoolean(String paramString)
  {
    paramString = this.mDatas.get(paramString);
    return (paramString != null) && (((Boolean)paramString).booleanValue());
  }
  
  public double getDouble(String paramString)
  {
    paramString = this.mDatas.get(paramString);
    if ((paramString instanceof Number)) {
      return ((Number)paramString).doubleValue();
    }
    return 0.0D;
  }
  
  public int getInt(String paramString)
  {
    paramString = this.mDatas.get(paramString);
    if ((paramString instanceof Number)) {
      return ((Number)paramString).intValue();
    }
    return 0;
  }
  
  public long getLong(String paramString)
  {
    paramString = this.mDatas.get(paramString);
    if ((paramString instanceof Number)) {
      return ((Number)paramString).longValue();
    }
    return 0L;
  }
  
  public HippyMap getMap(String paramString)
  {
    paramString = this.mDatas.get(paramString);
    if ((paramString instanceof HippyMap)) {
      return (HippyMap)paramString;
    }
    return null;
  }
  
  public String getString(String paramString)
  {
    paramString = this.mDatas.get(paramString);
    if (paramString == null) {
      return null;
    }
    return String.valueOf(paramString);
  }
  
  public boolean isNull(String paramString)
  {
    return this.mDatas.get(paramString) == null;
  }
  
  public Set<String> keySet()
  {
    return this.mDatas.keySet();
  }
  
  public void pushAll(HippyMap paramHippyMap)
  {
    if (paramHippyMap != null) {
      this.mDatas.putAll(paramHippyMap.mDatas);
    }
  }
  
  public void pushArray(String paramString, HippyArray paramHippyArray)
  {
    this.mDatas.put(paramString, paramHippyArray);
  }
  
  public void pushBoolean(String paramString, boolean paramBoolean)
  {
    this.mDatas.put(paramString, Boolean.valueOf(paramBoolean));
  }
  
  public void pushDouble(String paramString, double paramDouble)
  {
    this.mDatas.put(paramString, Double.valueOf(paramDouble));
  }
  
  public void pushInt(String paramString, int paramInt)
  {
    this.mDatas.put(paramString, Integer.valueOf(paramInt));
  }
  
  public void pushJSONObject(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return;
    }
    try
    {
      Iterator localIterator = paramJSONObject.keys();
      while (localIterator.hasNext())
      {
        String str = localIterator.next().toString();
        Object localObject1 = paramJSONObject.opt(str);
        if (paramJSONObject.isNull(str))
        {
          pushNull(str);
        }
        else
        {
          Object localObject2;
          if ((localObject1 instanceof JSONObject))
          {
            localObject2 = new HippyMap();
            ((HippyMap)localObject2).pushJSONObject((JSONObject)localObject1);
            pushMap(str, (HippyMap)localObject2);
          }
          else if ((localObject1 instanceof JSONArray))
          {
            localObject2 = new HippyArray();
            ((HippyArray)localObject2).pushJSONArray((JSONArray)localObject1);
            pushArray(str, (HippyArray)localObject2);
          }
          else
          {
            pushObject(str, localObject1);
          }
        }
      }
      return;
    }
    catch (Exception paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
  }
  
  public void pushLong(String paramString, long paramLong)
  {
    this.mDatas.put(paramString, Long.valueOf(paramLong));
  }
  
  public void pushMap(String paramString, HippyMap paramHippyMap)
  {
    this.mDatas.put(paramString, paramHippyMap);
  }
  
  public void pushNull(String paramString)
  {
    this.mDatas.put(paramString, null);
  }
  
  public void pushObject(String paramString, Object paramObject)
  {
    if (paramObject == null)
    {
      pushNull(paramString);
      return;
    }
    if ((paramObject instanceof String))
    {
      pushString(paramString, (String)paramObject);
      return;
    }
    if ((paramObject instanceof HippyMap))
    {
      pushMap(paramString, (HippyMap)paramObject);
      return;
    }
    if ((paramObject instanceof HippyArray))
    {
      pushArray(paramString, (HippyArray)paramObject);
      return;
    }
    if ((paramObject instanceof Integer))
    {
      paramObject = (Integer)paramObject;
      label73:
      pushInt(paramString, paramObject.intValue());
      return;
    }
    if ((paramObject instanceof Boolean))
    {
      label90:
      pushBoolean(paramString, ((Boolean)paramObject).booleanValue());
      return;
    }
    if ((paramObject instanceof Double)) {}
    label110:
    for (double d = ((Double)paramObject).doubleValue();; d = ((Number)paramObject).doubleValue())
    {
      pushDouble(paramString, d);
      return;
      if (!(paramObject instanceof Float)) {
        break;
      }
    }
    label132:
    if ((paramObject instanceof Long)) {}
    Class localClass;
    do
    {
      pushLong(paramString, ((Long)paramObject).longValue());
      return;
      if ((paramObject instanceof Byte))
      {
        paramObject = Integer.valueOf(((Byte)paramObject).intValue());
        break label73;
      }
      localClass = paramObject.getClass();
      if (localClass.isAssignableFrom(Integer.TYPE)) {
        break;
      }
      if (localClass.isAssignableFrom(Boolean.TYPE)) {
        break label90;
      }
      if (localClass.isAssignableFrom(Double.TYPE)) {
        break label110;
      }
      if (localClass.isAssignableFrom(Float.TYPE)) {
        break label132;
      }
    } while (localClass.isAssignableFrom(Long.TYPE));
    paramString = new RuntimeException("push unsupported object into HippyMap");
    for (;;)
    {
      throw paramString;
    }
  }
  
  public void pushString(String paramString1, String paramString2)
  {
    this.mDatas.put(paramString1, paramString2);
  }
  
  public void remove(String paramString)
  {
    this.mDatas.remove(paramString);
  }
  
  public int size()
  {
    return this.mDatas.size();
  }
  
  public JSONObject toJSONObject()
  {
    localJSONObject = new JSONObject();
    if (size() <= 0) {
      return localJSONObject;
    }
    Iterator localIterator = entrySet().iterator();
    try
    {
      if (localIterator.hasNext())
      {
        Object localObject = (Map.Entry)localIterator.next();
        String str = (String)((Map.Entry)localObject).getKey();
        if ((((Map.Entry)localObject).getValue() instanceof HippyMap)) {
          localObject = ((HippyMap)((Map.Entry)localObject).getValue()).toJSONObject();
        }
        for (;;)
        {
          localJSONObject.put(str, localObject);
          break;
          if ((((Map.Entry)localObject).getValue() instanceof HippyArray)) {
            localObject = ((HippyArray)((Map.Entry)localObject).getValue()).toJSONArray();
          } else {
            localObject = ((Map.Entry)localObject).getValue();
          }
        }
      }
      return localJSONObject;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public String toString()
  {
    HashMap localHashMap = this.mDatas;
    if (localHashMap == null) {
      return "null";
    }
    return localHashMap.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mtt.hippy.common.HippyMap
 * JD-Core Version:    0.7.0.1
 */