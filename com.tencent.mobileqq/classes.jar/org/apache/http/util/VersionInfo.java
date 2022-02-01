package org.apache.http.util;

import java.util.Map;

@Deprecated
public class VersionInfo
{
  public static final String PROPERTY_MODULE = "info.module";
  public static final String PROPERTY_RELEASE = "info.release";
  public static final String PROPERTY_TIMESTAMP = "info.timestamp";
  public static final String UNAVAILABLE = "UNAVAILABLE";
  public static final String VERSION_PROPERTY_FILE = "version.properties";
  
  protected VersionInfo(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    throw new RuntimeException("Stub!");
  }
  
  protected static final VersionInfo fromMap(String paramString, Map paramMap, ClassLoader paramClassLoader)
  {
    throw new RuntimeException("Stub!");
  }
  
  public static final VersionInfo loadVersionInfo(String paramString, ClassLoader paramClassLoader)
  {
    throw new RuntimeException("Stub!");
  }
  
  public static final VersionInfo[] loadVersionInfo(String[] paramArrayOfString, ClassLoader paramClassLoader)
  {
    throw new RuntimeException("Stub!");
  }
  
  public final String getClassloader()
  {
    throw new RuntimeException("Stub!");
  }
  
  public final String getModule()
  {
    throw new RuntimeException("Stub!");
  }
  
  public final String getPackage()
  {
    throw new RuntimeException("Stub!");
  }
  
  public final String getRelease()
  {
    throw new RuntimeException("Stub!");
  }
  
  public final String getTimestamp()
  {
    throw new RuntimeException("Stub!");
  }
  
  public String toString()
  {
    throw new RuntimeException("Stub!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     org.apache.http.util.VersionInfo
 * JD-Core Version:    0.7.0.1
 */