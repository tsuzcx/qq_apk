package com.tencent.plato.bridge;

import org.json.JSONException;
import org.json.JSONObject;

public class PlatoNativeMap
  extends JSONObject
{
  public PlatoNativeMap put(String paramString, Object paramObject)
  {
    try
    {
      super.put(paramString, paramObject);
      return this;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
    return this;
  }
  
  public byte[] toBytes()
  {
    return super.toString().getBytes();
  }
  
  public String toString()
  {
    return super.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.plato.bridge.PlatoNativeMap
 * JD-Core Version:    0.7.0.1
 */