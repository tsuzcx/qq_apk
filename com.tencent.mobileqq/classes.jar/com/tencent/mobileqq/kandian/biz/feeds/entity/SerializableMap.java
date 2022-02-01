package com.tencent.mobileqq.kandian.biz.feeds.entity;

import java.io.Serializable;
import java.util.Map;

public class SerializableMap
  implements Serializable
{
  private Map<String, Object> map;
  
  public Map<String, Object> getMap()
  {
    return this.map;
  }
  
  public void setMap(Map<String, Object> paramMap)
  {
    this.map = paramMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.entity.SerializableMap
 * JD-Core Version:    0.7.0.1
 */