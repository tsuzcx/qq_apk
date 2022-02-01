package com.tencent.mobileqq.qcircle.api.data;

import java.io.Serializable;
import java.util.Map;

public class SerializableMap
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  private Map mHashMap;
  
  public Map getMap()
  {
    return this.mHashMap;
  }
  
  public void setMap(Map paramMap)
  {
    this.mHashMap = paramMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qcircle.api.data.SerializableMap
 * JD-Core Version:    0.7.0.1
 */