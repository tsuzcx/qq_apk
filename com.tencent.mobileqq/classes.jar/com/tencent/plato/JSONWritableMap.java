package com.tencent.plato;

import com.tencent.plato.core.IFunction;
import com.tencent.plato.core.IReadableArray;
import com.tencent.plato.core.IReadableMap;
import com.tencent.plato.core.IWritableArray;
import com.tencent.plato.core.IWritableMap;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JSONWritableMap
  implements IWritableMap
{
  private final JSONObject mJSONObject;
  
  public JSONWritableMap()
  {
    this.mJSONObject = new JSONObject();
  }
  
  public JSONWritableMap(String paramString)
  {
    Object localObject = null;
    try
    {
      paramString = new JSONObject(paramString);
      if (paramString != null)
      {
        this.mJSONObject = paramString;
        return;
      }
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
        paramString = localObject;
      }
      this.mJSONObject = new JSONObject();
    }
  }
  
  public JSONWritableMap(JSONObject paramJSONObject)
  {
    this.mJSONObject = paramJSONObject;
  }
  
  public Object get(String paramString)
  {
    return this.mJSONObject.opt(paramString);
  }
  
  public boolean getBoolean(String paramString, boolean paramBoolean)
  {
    return this.mJSONObject.optBoolean(paramString, paramBoolean);
  }
  
  public double getDouble(String paramString, double paramDouble)
  {
    return this.mJSONObject.optDouble(paramString, paramDouble);
  }
  
  public float getFloat(String paramString, float paramFloat)
  {
    return (float)this.mJSONObject.optDouble(paramString, paramFloat);
  }
  
  public IFunction getFunction(String paramString)
  {
    return Argument.toFunction(this.mJSONObject.opt(paramString));
  }
  
  public int getInt(String paramString, int paramInt)
  {
    return this.mJSONObject.optInt(paramString, paramInt);
  }
  
  public long getLong(String paramString, long paramLong)
  {
    return this.mJSONObject.optLong(paramString, paramLong);
  }
  
  public IWritableArray getReadableArray(String paramString)
  {
    paramString = this.mJSONObject.optJSONArray(paramString);
    if (paramString != null) {
      return new JSONWritableArray(paramString);
    }
    return null;
  }
  
  public IWritableMap getReadableMap(String paramString)
  {
    paramString = this.mJSONObject.optJSONObject(paramString);
    if (paramString != null) {
      return new JSONWritableMap(paramString);
    }
    return null;
  }
  
  public String getString(String paramString1, String paramString2)
  {
    return this.mJSONObject.optString(paramString1, paramString2);
  }
  
  public boolean has(String paramString)
  {
    return this.mJSONObject.has(paramString);
  }
  
  public List<String> names()
  {
    ArrayList localArrayList = new ArrayList();
    JSONArray localJSONArray = this.mJSONObject.names();
    if (localJSONArray != null)
    {
      int i = 0;
      int j = localJSONArray.length();
      while (i < j)
      {
        localArrayList.add(localJSONArray.optString(i));
        i += 1;
      }
    }
    return localArrayList;
  }
  
  public IWritableMap put(String paramString, double paramDouble)
  {
    try
    {
      this.mJSONObject.put(paramString, paramDouble);
      return this;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
    return this;
  }
  
  public IWritableMap put(String paramString, int paramInt)
  {
    try
    {
      this.mJSONObject.put(paramString, paramInt);
      return this;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
    return this;
  }
  
  public IWritableMap put(String paramString, IFunction paramIFunction)
  {
    try
    {
      this.mJSONObject.put(paramString, paramIFunction);
      return this;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
    return this;
  }
  
  public IWritableMap put(String paramString, IReadableArray paramIReadableArray)
  {
    try
    {
      this.mJSONObject.put(paramString, paramIReadableArray.toJSONArray());
      return this;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
    return this;
  }
  
  public IWritableMap put(String paramString, IReadableMap paramIReadableMap)
  {
    try
    {
      this.mJSONObject.put(paramString, paramIReadableMap.toJSONObject());
      return this;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
    return this;
  }
  
  public IWritableMap put(String paramString, Object paramObject)
  {
    if ((paramObject instanceof IReadableMap))
    {
      put(paramString, (IReadableMap)paramObject);
      return this;
    }
    if ((paramObject instanceof IReadableArray))
    {
      put(paramString, (IReadableArray)paramObject);
      return this;
    }
    try
    {
      this.mJSONObject.put(paramString, paramObject);
      return this;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
    return this;
  }
  
  public IWritableMap put(String paramString1, String paramString2)
  {
    try
    {
      this.mJSONObject.put(paramString1, paramString2);
      return this;
    }
    catch (JSONException paramString1)
    {
      paramString1.printStackTrace();
    }
    return this;
  }
  
  public IWritableMap put(String paramString, boolean paramBoolean)
  {
    try
    {
      this.mJSONObject.put(paramString, paramBoolean);
      return this;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
    return this;
  }
  
  public void remove(String paramString)
  {
    this.mJSONObject.remove(paramString);
  }
  
  public JSONObject toJSONObject()
  {
    return this.mJSONObject;
  }
  
  public String toString()
  {
    return this.mJSONObject.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.plato.JSONWritableMap
 * JD-Core Version:    0.7.0.1
 */