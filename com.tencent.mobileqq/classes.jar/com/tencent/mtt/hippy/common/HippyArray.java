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
    while (localIterator.hasNext())
    {
      Object localObject2 = localIterator.next();
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
      localHippyArray.pushObject(localObject1);
    }
    return localHippyArray;
  }
  
  public Object get(int paramInt)
  {
    return this.mDatas.get(paramInt);
  }
  
  public HippyArray getArray(int paramInt)
  {
    int i = this.mDatas.size();
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (i > paramInt)
    {
      Object localObject3 = this.mDatas.get(paramInt);
      localObject1 = localObject2;
      if ((localObject3 instanceof HippyArray)) {
        localObject1 = (HippyArray)localObject3;
      }
    }
    return localObject1;
  }
  
  public boolean getBoolean(int paramInt)
  {
    int i = this.mDatas.size();
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (i > paramInt)
    {
      Object localObject = this.mDatas.get(paramInt);
      bool1 = bool2;
      if ((localObject instanceof Boolean))
      {
        bool1 = bool2;
        if (((Boolean)localObject).booleanValue()) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public double getDouble(int paramInt)
  {
    int i = this.mDatas.size();
    double d2 = 0.0D;
    double d1 = d2;
    if (i > paramInt)
    {
      Object localObject = this.mDatas.get(paramInt);
      d1 = d2;
      if ((localObject instanceof Number)) {
        d1 = ((Number)localObject).doubleValue();
      }
    }
    return d1;
  }
  
  public int getInt(int paramInt)
  {
    int k = this.mDatas.size();
    int j = 0;
    int i = j;
    if (k > paramInt)
    {
      Object localObject = this.mDatas.get(paramInt);
      i = j;
      if ((localObject instanceof Number)) {
        i = ((Number)localObject).intValue();
      }
    }
    return i;
  }
  
  public long getLong(int paramInt)
  {
    int i = this.mDatas.size();
    long l2 = 0L;
    long l1 = l2;
    if (i > paramInt)
    {
      Object localObject = this.mDatas.get(paramInt);
      l1 = l2;
      if ((localObject instanceof Number)) {
        l1 = ((Number)localObject).longValue();
      }
    }
    return l1;
  }
  
  public HippyMap getMap(int paramInt)
  {
    int i = this.mDatas.size();
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (i > paramInt)
    {
      Object localObject3 = this.mDatas.get(paramInt);
      localObject1 = localObject2;
      if ((localObject3 instanceof HippyMap)) {
        localObject1 = (HippyMap)localObject3;
      }
    }
    return localObject1;
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
    if (paramJSONArray != null)
    {
      if (paramJSONArray.length() <= 0) {
        return;
      }
      int i = 0;
      try
      {
        while (i < paramJSONArray.length())
        {
          Object localObject1 = paramJSONArray.opt(i);
          if (localObject1 == null)
          {
            pushNull();
          }
          else
          {
            Object localObject2;
            if ((localObject1 instanceof JSONObject))
            {
              localObject2 = new HippyMap();
              ((HippyMap)localObject2).pushJSONObject((JSONObject)localObject1);
              pushMap((HippyMap)localObject2);
            }
            else if ((localObject1 instanceof JSONArray))
            {
              localObject2 = new HippyArray();
              ((HippyArray)localObject2).pushJSONArray((JSONArray)localObject1);
              pushArray((HippyArray)localObject2);
            }
            else
            {
              pushObject(localObject1);
            }
          }
          i += 1;
        }
        return;
      }
      catch (Exception paramJSONArray)
      {
        paramJSONArray.printStackTrace();
      }
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
    localJSONArray = new JSONArray();
    if (size() <= 0) {
      return localJSONArray;
    }
    try
    {
      Iterator localIterator = this.mDatas.iterator();
      if (localIterator.hasNext())
      {
        Object localObject2 = localIterator.next();
        Object localObject1;
        if ((localObject2 instanceof HippyMap)) {
          localObject1 = ((HippyMap)localObject2).toJSONObject();
        }
        for (;;)
        {
          localJSONArray.put(localObject1);
          break;
          localObject1 = localObject2;
          if ((localObject2 instanceof HippyArray)) {
            localObject1 = ((HippyArray)localObject2).toJSONArray();
          }
        }
      }
      return localJSONArray;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public String toString()
  {
    ArrayList localArrayList = this.mDatas;
    if (localArrayList == null) {
      return "null";
    }
    return localArrayList.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mtt.hippy.common.HippyArray
 * JD-Core Version:    0.7.0.1
 */