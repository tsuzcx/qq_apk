package com.tencent.mobileqq.intervideo;

import com.tencent.shadow.core.common.ILoggerFactory;
import com.tencent.shadow.core.common.Logger;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class IVLoggerFactory
  implements ILoggerFactory
{
  private static IVLoggerFactory jdField_a_of_type_ComTencentMobileqqIntervideoIVLoggerFactory = new IVLoggerFactory();
  private final ConcurrentMap<String, Logger> jdField_a_of_type_JavaUtilConcurrentConcurrentMap = new ConcurrentHashMap();
  
  public static ILoggerFactory a()
  {
    return jdField_a_of_type_ComTencentMobileqqIntervideoIVLoggerFactory;
  }
  
  public Logger getLogger(String paramString)
  {
    Object localObject = (Logger)this.jdField_a_of_type_JavaUtilConcurrentConcurrentMap.get(paramString);
    if (localObject != null) {
      return localObject;
    }
    localObject = new IVLoggerFactory.IVLogger(this, paramString);
    Logger localLogger = (Logger)this.jdField_a_of_type_JavaUtilConcurrentConcurrentMap.putIfAbsent(paramString, localObject);
    paramString = localLogger;
    if (localLogger == null) {
      paramString = (String)localObject;
    }
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.IVLoggerFactory
 * JD-Core Version:    0.7.0.1
 */