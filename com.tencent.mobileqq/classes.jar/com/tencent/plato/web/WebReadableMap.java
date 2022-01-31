package com.tencent.plato.web;

import com.tencent.plato.Argument;
import com.tencent.plato.FunctionImpl;
import com.tencent.plato.core.IFunction;
import com.tencent.plato.core.IFunction.CallbackInvoker;
import com.tencent.plato.core.IReadableArray;
import com.tencent.plato.core.IReadableMap;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

class WebReadableMap
  implements IReadableMap
{
  private final int mCallId;
  private final IFunction.CallbackInvoker mCallbackInvoker;
  private final JSONObject mJSONObject;
  
  WebReadableMap(IFunction.CallbackInvoker paramCallbackInvoker, int paramInt, JSONObject paramJSONObject)
  {
    this.mCallbackInvoker = paramCallbackInvoker;
    this.mCallId = paramInt;
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
    IFunction localIFunction = Argument.toFunction(this.mJSONObject.opt(paramString));
    Object localObject = localIFunction;
    if (localIFunction == null)
    {
      localObject = localIFunction;
      if (this.mJSONObject.has(paramString))
      {
        int i = this.mJSONObject.optInt(paramString, -1);
        localObject = new FunctionImpl(this.mCallbackInvoker, this.mCallId, i);
      }
    }
    return localObject;
  }
  
  public int getInt(String paramString, int paramInt)
  {
    return this.mJSONObject.optInt(paramString, paramInt);
  }
  
  public long getLong(String paramString, long paramLong)
  {
    return this.mJSONObject.optLong(paramString, paramLong);
  }
  
  public IReadableArray getReadableArray(String paramString)
  {
    paramString = this.mJSONObject.optJSONArray(paramString);
    if (paramString != null) {
      return new WebReadableArray(this.mCallbackInvoker, this.mCallId, paramString);
    }
    return null;
  }
  
  public IReadableMap getReadableMap(String paramString)
  {
    paramString = this.mJSONObject.optJSONObject(paramString);
    if (paramString != null) {
      return new WebReadableMap(this.mCallbackInvoker, this.mCallId, paramString);
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
  
  public JSONObject toJSONObject()
  {
    return this.mJSONObject;
  }
  
  public String toString()
  {
    return this.mJSONObject.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.plato.web.WebReadableMap
 * JD-Core Version:    0.7.0.1
 */