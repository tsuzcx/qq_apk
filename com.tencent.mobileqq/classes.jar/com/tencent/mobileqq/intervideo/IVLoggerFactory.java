package com.tencent.mobileqq.intervideo;

import com.tencent.shadow.core.common.ILoggerFactory;
import com.tencent.shadow.core.common.Logger;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class IVLoggerFactory
  implements ILoggerFactory
{
  private static IVLoggerFactory a = new IVLoggerFactory();
  private final ConcurrentMap<String, Logger> b = new ConcurrentHashMap();
  
  public static ILoggerFactory a()
  {
    return a;
  }
  
  public Logger getLogger(String paramString)
  {
    Object localObject = (Logger)this.b.get(paramString);
    if (localObject != null) {
      return localObject;
    }
    localObject = new IVLoggerFactory.IVLogger(this, paramString);
    Logger localLogger = (Logger)this.b.putIfAbsent(paramString, localObject);
    paramString = localLogger;
    if (localLogger == null) {
      paramString = (String)localObject;
    }
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.IVLoggerFactory
 * JD-Core Version:    0.7.0.1
 */