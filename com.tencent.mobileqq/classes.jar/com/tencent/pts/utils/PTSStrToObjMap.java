package com.tencent.pts.utils;

import android.support.annotation.Nullable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class PTSStrToObjMap
  implements Map<String, Object>
{
  protected String TAG = getClass().getSimpleName();
  private final HashMap<String, Object> mMap = new HashMap();
  
  public PTSStrToObjMap() {}
  
  public PTSStrToObjMap(Map<String, Object> paramMap)
  {
    this();
    if (paramMap != null) {
      putAll(paramMap);
    }
  }
  
  public PTSStrToObjMap(JSONObject paramJSONObject)
  {
    this();
    if (paramJSONObject != null)
    {
      Iterator localIterator = paramJSONObject.keys();
      while (localIterator.hasNext()) {
        try
        {
          String str = (String)localIterator.next();
          put(str, paramJSONObject.get(str));
        }
        catch (JSONException localJSONException)
        {
          PTSLog.e(this.TAG, "init PTSStrToObjMap, e = ", localJSONException);
        }
      }
    }
  }
  
  public void clear()
  {
    this.mMap.clear();
  }
  
  public boolean containsKey(Object paramObject)
  {
    return this.mMap.containsKey(paramObject);
  }
  
  public boolean containsValue(Object paramObject)
  {
    return this.mMap.containsValue(paramObject);
  }
  
  public Set<Map.Entry<String, Object>> entrySet()
  {
    return this.mMap.entrySet();
  }
  
  public Object get(@Nullable Object paramObject)
  {
    return this.mMap.get(paramObject);
  }
  
  public boolean isEmpty()
  {
    return this.mMap.isEmpty();
  }
  
  public Set keySet()
  {
    return this.mMap.keySet();
  }
  
  public Object put(String paramString, Object paramObject)
  {
    return this.mMap.put(paramString, paramObject);
  }
  
  public void putAll(Map<? extends String, ?> paramMap)
  {
    this.mMap.putAll(paramMap);
  }
  
  public Object remove(Object paramObject)
  {
    return this.mMap.remove(paramObject);
  }
  
  public int size()
  {
    return this.mMap.size();
  }
  
  public Collection values()
  {
    return this.mMap.values();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.pts.utils.PTSStrToObjMap
 * JD-Core Version:    0.7.0.1
 */