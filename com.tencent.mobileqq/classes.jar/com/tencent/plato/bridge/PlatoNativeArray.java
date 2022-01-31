package com.tencent.plato.bridge;

import org.json.JSONArray;

public class PlatoNativeArray
  extends JSONArray
{
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
 * Qualified Name:     com.tencent.plato.bridge.PlatoNativeArray
 * JD-Core Version:    0.7.0.1
 */