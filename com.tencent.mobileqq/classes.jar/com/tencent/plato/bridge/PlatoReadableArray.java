package com.tencent.plato.bridge;

import com.tencent.plato.Argument;
import com.tencent.plato.FunctionImpl;
import com.tencent.plato.core.IFunction;
import com.tencent.plato.core.IFunction.CallbackInvoker;
import com.tencent.plato.core.IReadableArray;
import com.tencent.plato.core.IReadableMap;
import com.tencent.plato.core.utils.PLog;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class PlatoReadableArray
  implements IReadableArray
{
  private final int mCallId;
  private final IFunction.CallbackInvoker mCallbackInvoker;
  private JSONArray mJSONArray;
  
  PlatoReadableArray(IFunction.CallbackInvoker paramCallbackInvoker, int paramInt, String paramString)
  {
    this.mCallbackInvoker = paramCallbackInvoker;
    this.mCallId = paramInt;
    try
    {
      this.mJSONArray = new JSONArray(paramString);
      return;
    }
    catch (JSONException paramCallbackInvoker)
    {
      PLog.dumpStack(paramCallbackInvoker);
      this.mJSONArray = new JSONArray();
    }
  }
  
  PlatoReadableArray(IFunction.CallbackInvoker paramCallbackInvoker, int paramInt, JSONArray paramJSONArray)
  {
    this.mCallbackInvoker = paramCallbackInvoker;
    this.mCallId = paramInt;
    this.mJSONArray = paramJSONArray;
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
    IFunction localIFunction = Argument.toFunction(this.mJSONArray.opt(paramInt));
    Object localObject = localIFunction;
    if (localIFunction == null)
    {
      paramInt = this.mJSONArray.optInt(paramInt, -1);
      localObject = localIFunction;
      if (-1 != paramInt) {
        localObject = new FunctionImpl(this.mCallbackInvoker, this.mCallId, paramInt);
      }
    }
    return localObject;
  }
  
  public int getInt(int paramInt1, int paramInt2)
  {
    return this.mJSONArray.optInt(paramInt1, paramInt2);
  }
  
  public long getLong(int paramInt, long paramLong)
  {
    return this.mJSONArray.optLong(paramInt, paramLong);
  }
  
  public IReadableArray getReadableArray(int paramInt)
  {
    JSONArray localJSONArray = this.mJSONArray.optJSONArray(paramInt);
    if (localJSONArray != null) {
      return new PlatoReadableArray(this.mCallbackInvoker, this.mCallId, localJSONArray);
    }
    return null;
  }
  
  public IReadableMap getReadableMap(int paramInt)
  {
    JSONObject localJSONObject = this.mJSONArray.optJSONObject(paramInt);
    if (localJSONObject != null) {
      return new PlatoReadableMap(this.mCallbackInvoker, this.mCallId, localJSONObject);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.plato.bridge.PlatoReadableArray
 * JD-Core Version:    0.7.0.1
 */