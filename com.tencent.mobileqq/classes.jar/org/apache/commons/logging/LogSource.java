package org.apache.commons.logging;

import java.lang.reflect.Constructor;
import java.util.Hashtable;

@Deprecated
public class LogSource
{
  protected static boolean jdk14IsAvailable;
  protected static boolean log4jIsAvailable;
  protected static Constructor logImplctor;
  protected static Hashtable logs;
  
  LogSource()
  {
    throw new RuntimeException("Stub!");
  }
  
  public static Log getInstance(Class paramClass)
  {
    throw new RuntimeException("Stub!");
  }
  
  public static Log getInstance(String paramString)
  {
    throw new RuntimeException("Stub!");
  }
  
  public static String[] getLogNames()
  {
    throw new RuntimeException("Stub!");
  }
  
  public static Log makeNewLogInstance(String paramString)
  {
    throw new RuntimeException("Stub!");
  }
  
  public static void setLogImplementation(Class paramClass)
  {
    throw new RuntimeException("Stub!");
  }
  
  public static void setLogImplementation(String paramString)
  {
    throw new RuntimeException("Stub!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     org.apache.commons.logging.LogSource
 * JD-Core Version:    0.7.0.1
 */