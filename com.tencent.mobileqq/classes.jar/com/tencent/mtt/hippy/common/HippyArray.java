package com.tencent.mtt.hippy.common;

import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

public class HippyArray
{
  private final ArrayList mDatas = new ArrayList();
  
  public void clear()
  {
    this.mDatas.clear();
  }
  
  public HippyArray copy()
  {
    HippyArray localHippyArray = new HippyArray();
    Iterator localIterator = this.mDatas.iterator();
    if (localIterator.hasNext())
    {
      Object localObject2 = localIterator.next();
      Object localObject1;
      if ((localObject2 instanceof HippyMap)) {
        localObject1 = ((HippyMap)localObject2).copy();
      }
      for (;;)
      {
        localHippyArray.pushObject(localObject1);
        break;
        localObject1 = localObject2;
        if ((localObject2 instanceof HippyArray)) {
          localObject1 = ((HippyArray)localObject2).copy();
        }
      }
    }
    return localHippyArray;
  }
  
  public Object get(int paramInt)
  {
    return this.mDatas.get(paramInt);
  }
  
  public HippyArray getArray(int paramInt)
  {
    if (this.mDatas.size() > paramInt)
    {
      Object localObject = this.mDatas.get(paramInt);
      if ((localObject instanceof HippyArray)) {
        return (HippyArray)localObject;
      }
      return null;
    }
    return null;
  }
  
  public boolean getBoolean(int paramInt)
  {
    if (this.mDatas.size() > paramInt)
    {
      Object localObject = this.mDatas.get(paramInt);
      return ((localObject instanceof Boolean)) && (((Boolean)localObject).booleanValue());
    }
    return false;
  }
  
  public double getDouble(int paramInt)
  {
    if (this.mDatas.size() > paramInt)
    {
      Object localObject = this.mDatas.get(paramInt);
      if ((localObject instanceof Number)) {
        return ((Number)localObject).doubleValue();
      }
      return 0.0D;
    }
    return 0.0D;
  }
  
  public int getInt(int paramInt)
  {
    if (this.mDatas.size() > paramInt)
    {
      Object localObject = this.mDatas.get(paramInt);
      if ((localObject instanceof Number)) {
        return ((Number)localObject).intValue();
      }
      return 0;
    }
    return 0;
  }
  
  public long getLong(int paramInt)
  {
    if (this.mDatas.size() > paramInt)
    {
      Object localObject = this.mDatas.get(paramInt);
      if ((localObject instanceof Number)) {
        return ((Number)localObject).longValue();
      }
      return 0L;
    }
    return 0L;
  }
  
  public HippyMap getMap(int paramInt)
  {
    if (this.mDatas.size() > paramInt)
    {
      Object localObject = this.mDatas.get(paramInt);
      if ((localObject instanceof HippyMap)) {
        return (HippyMap)localObject;
      }
      return null;
    }
    return null;
  }
  
  public Object getObject(int paramInt)
  {
    if (this.mDatas.size() > paramInt) {
      return this.mDatas.get(paramInt);
    }
    return null;
  }
  
  public String getString(int paramInt)
  {
    if (this.mDatas.size() > paramInt) {
      return String.valueOf(this.mDatas.get(paramInt));
    }
    return null;
  }
  
  public void pushArray(HippyArray paramHippyArray)
  {
    this.mDatas.add(paramHippyArray);
  }
  
  public void pushBoolean(boolean paramBoolean)
  {
    this.mDatas.add(Boolean.valueOf(paramBoolean));
  }
  
  public void pushDouble(double paramDouble)
  {
    this.mDatas.add(Double.valueOf(paramDouble));
  }
  
  public void pushInt(int paramInt)
  {
    this.mDatas.add(Integer.valueOf(paramInt));
  }
  
  public void pushJSONArray(JSONArray paramJSONArray)
  {
    if ((paramJSONArray == null) || (paramJSONArray.length() <= 0)) {
      return;
    }
    int i = 0;
    for (;;)
    {
      Object localObject1;
      Object localObject2;
      try
      {
        if (i >= paramJSONArray.length()) {
          break;
        }
        localObject1 = paramJSONArray.opt(i);
        if (localObject1 == null)
        {
          pushNull();
        }
        else if ((localObject1 instanceof JSONObject))
        {
          localObject2 = new HippyMap();
          ((HippyMap)localObject2).pushJSONObject((JSONObject)localObject1);
          pushMap((HippyMap)localObject2);
        }
      }
      catch (Exception paramJSONArray)
      {
        paramJSONArray.printStackTrace();
        return;
      }
      if ((localObject1 instanceof JSONArray))
      {
        localObject2 = new HippyArray();
        ((HippyArray)localObject2).pushJSONArray((JSONArray)localObject1);
        pushArray((HippyArray)localObject2);
      }
      else
      {
        pushObject(localObject1);
      }
      i += 1;
    }
  }
  
  public void pushLong(long paramLong)
  {
    this.mDatas.add(Long.valueOf(paramLong));
  }
  
  public void pushMap(HippyMap paramHippyMap)
  {
    this.mDatas.add(paramHippyMap);
  }
  
  public void pushNull()
  {
    this.mDatas.add(null);
  }
  
  public void pushObject(Object paramObject)
  {
    this.mDatas.add(paramObject);
  }
  
  public void pushString(String paramString)
  {
    this.mDatas.add(paramString);
  }
  
  public int size()
  {
    return this.mDatas.size();
  }
  
  public JSONArray toJSONArray()
  {
    JSONArray localJSONArray = new JSONArray();
    if (size() <= 0) {
      return localJSONArray;
    }
    for (;;)
    {
      Object localObject;
      try
      {
        Iterator localIterator = this.mDatas.iterator();
        if (localIterator.hasNext())
        {
          localObject = localIterator.next();
          if ((localObject instanceof HippyMap)) {
            localJSONArray.put(((HippyMap)localObject).toJSONObject());
          }
        }
        else
        {
          return localJSONArray;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      if ((localObject instanceof HippyArray)) {
        localJSONArray.put(((HippyArray)localObject).toJSONArray());
      } else {
        localJSONArray.put(localObject);
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
 * Qualified Name:     com.tencent.mtt.hippy.common.HippyArray
 * JD-Core Version:    0.7.0.1
 */