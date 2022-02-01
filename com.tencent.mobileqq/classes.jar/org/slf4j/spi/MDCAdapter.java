package org.slf4j.spi;

import java.util.Map;

public abstract interface MDCAdapter
{
  public abstract void clear();
  
  public abstract String get(String paramString);
  
  public abstract Map<String, String> getCopyOfContextMap();
  
  public abstract void put(String paramString1, String paramString2);
  
  public abstract void remove(String paramString);
  
  public abstract void setContextMap(Map<String, String> paramMap);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     org.slf4j.spi.MDCAdapter
 * JD-Core Version:    0.7.0.1
 */