package com.tencent.plato;

import com.tencent.plato.core.IFunction;
import com.tencent.plato.core.IReadableArray;
import com.tencent.plato.core.IReadableMap;
import com.tencent.plato.core.IWritableArray;
import com.tencent.plato.core.IWritableMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JSONWritableArray
  implements IWritableArray
{
  private final JSONArray mJSONArray;
  
  public JSONWritableArray()
  {
    this.mJSONArray = new JSONArray();
  }
  
  public JSONWritableArray(JSONArray paramJSONArray)
  {
    this.mJSONArray = paramJSONArray;
  }
  
  public IWritableArray add(double paramDouble)
  {
    try
    {
      this.mJSONArray.put(paramDouble);
      return this;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return this;
  }
  
  public IWritableArray add(int paramInt)
  {
    this.mJSONArray.put(paramInt);
    return this;
  }
  
  public IWritableArray add(IFunction paramIFunction)
  {
    this.mJSONArray.put(paramIFunction);
    return this;
  }
  
  public IWritableArray add(IReadableArray paramIReadableArray)
  {
    this.mJSONArray.put(paramIReadableArray.toJSONArray());
    return this;
  }
  
  public IWritableArray add(IReadableMap paramIReadableMap)
  {
    this.mJSONArray.put(paramIReadableMap.toJSONObject());
    return this;
  }
  
  public IWritableArray add(Object paramObject)
  {
    this.mJSONArray.put(paramObject);
    return this;
  }
  
  public IWritableArray add(String paramString)
  {
    this.mJSONArray.put(paramString);
    return this;
  }
  
  public IWritableArray add(boolean paramBoolean)
  {
    this.mJSONArray.put(paramBoolean);
    return this;
  }
  
  public Object get(int paramInt)
  {
    return this.mJSONArray.opt(paramInt);
  }
  
  public boolean getBoolean(int paramInt, boolean paramBoolean)
  {
    return this.mJSONArray.optBoolean(paramInt, paramBoolean);
  }
  
  public double getDouble(int paramInt, double paramDouble)
  {
    return this.mJSONArray.optDouble(paramInt, paramDouble);
  }
  
  public float getFloat(int paramInt, float paramFloat)
  {
    return (float)this.mJSONArray.optDouble(paramInt, paramFloat);
  }
  
  public IFunction getFunction(int paramInt)
  {
    return Argument.toFunction(this.mJSONArray.opt(paramInt));
  }
  
  public int getInt(int paramInt1, int paramInt2)
  {
    return this.mJSONArray.optInt(paramInt1, paramInt2);
  }
  
  public long getLong(int paramInt, long paramLong)
  {
    return this.mJSONArray.optLong(paramInt, paramLong);
  }
  
  public IWritableArray getReadableArray(int paramInt)
  {
    JSONArray localJSONArray = this.mJSONArray.optJSONArray(paramInt);
    if (localJSONArray != null) {
      return new JSONWritableArray(localJSONArray);
    }
    return null;
  }
  
  public IWritableMap getReadableMap(int paramInt)
  {
    JSONObject localJSONObject = this.mJSONArray.optJSONObject(paramInt);
    if (localJSONObject != null) {
      return new JSONWritableMap(localJSONObject);
    }
    return null;
  }
  
  public String getString(int paramInt, String paramString)
  {
    return this.mJSONArray.optString(paramInt, paramString);
  }
  
  public int length()
  {
    return this.mJSONArray.length();
  }
  
  public JSONArray toJSONArray()
  {
    return this.mJSONArray;
  }
  
  public String toString()
  {
    return this.mJSONArray.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.plato.JSONWritableArray
 * JD-Core Version:    0.7.0.1
 */