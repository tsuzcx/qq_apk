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
    if (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      Object localObject2 = localEntry.getValue();
      Object localObject1;
      if ((localObject2 instanceof HippyMap)) {
        localObject1 = ((HippyMap)localObject2).copy();
      }
      for (;;)
      {
        localHippyMap.pushObject((String)localEntry.getKey(), localObject1);
        break;
        localObject1 = localObject2;
        if ((localObject2 instanceof HippyArray)) {
          localObject1 = ((HippyArray)localObject2).copy();
        }
      }
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
    for (;;)
    {
      String str;
      Object localObject1;
      try
      {
        Iterator localIterator = paramJSONObject.keys();
        if (!localIterator.hasNext()) {
          break;
        }
        str = localIterator.next().toString();
        localObject1 = paramJSONObject.opt(str);
        if (paramJSONObject.isNull(str))
        {
          pushNull(str);
          continue;
        }
        if (!(localObject1 instanceof JSONObject)) {
          break label95;
        }
      }
      catch (Exception paramJSONObject)
      {
        paramJSONObject.printStackTrace();
        return;
      }
      Object localObject2 = new HippyMap();
      ((HippyMap)localObject2).pushJSONObject((JSONObject)localObject1);
      pushMap(str, (HippyMap)localObject2);
      continue;
      label95:
      if ((localObject1 instanceof JSONArray))
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
      pushInt(paramString, ((Integer)paramObject).intValue());
      return;
    }
    if ((paramObject instanceof Boolean))
    {
      pushBoolean(paramString, ((Boolean)paramObject).booleanValue());
      return;
    }
    if ((paramObject instanceof Double))
    {
      pushDouble(paramString, ((Double)paramObject).doubleValue());
      return;
    }
    if ((paramObject instanceof Float))
    {
      pushDouble(paramString, ((Number)paramObject).doubleValue());
      return;
    }
    if ((paramObject instanceof Long))
    {
      pushLong(paramString, ((Long)paramObject).longValue());
      return;
    }
    Class localClass = paramObject.getClass();
    if (localClass.isAssignableFrom(Integer.TYPE))
    {
      pushInt(paramString, ((Integer)paramObject).intValue());
      return;
    }
    if (localClass.isAssignableFrom(Boolean.TYPE))
    {
      pushBoolean(paramString, ((Boolean)paramObject).booleanValue());
      return;
    }
    if (localClass.isAssignableFrom(Double.TYPE))
    {
      pushDouble(paramString, ((Double)paramObject).doubleValue());
      return;
    }
    if (localClass.isAssignableFrom(Float.TYPE))
    {
      pushDouble(paramString, ((Number)paramObject).doubleValue());
      return;
    }
    if (localClass.isAssignableFrom(Long.TYPE))
    {
      pushLong(paramString, ((Long)paramObject).longValue());
      return;
    }
    throw new RuntimeException("push unsupported object into HippyMap");
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
    JSONObject localJSONObject = new JSONObject();
    if (size() <= 0) {
      return localJSONObject;
    }
    Iterator localIterator = entrySet().iterator();
    for (;;)
    {
      Map.Entry localEntry;
      String str;
      try
      {
        if (localIterator.hasNext())
        {
          localEntry = (Map.Entry)localIterator.next();
          str = (String)localEntry.getKey();
          if ((localEntry.getValue() instanceof HippyMap)) {
            localJSONObject.put(str, ((HippyMap)localEntry.getValue()).toJSONObject());
          }
        }
        else
        {
          return localJSONObject;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      if ((localEntry.getValue() instanceof HippyArray)) {
        localJSONObject.put(str, ((HippyArray)localEntry.getValue()).toJSONArray());
      } else {
        localJSONObject.put(str, localEntry.getValue());
      }
    }
  }
  
  public String toString()
  {
    if (this.mDatas == null) {
      return "null";
    }
    return this.mDatas.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mtt.hippy.common.HippyMap
 * JD-Core Version:    0.7.0.1
 */