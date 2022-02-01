package org.apache.commons.logging.impl;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Hashtable;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@Deprecated
public class LogFactoryImpl
  extends LogFactory
{
  public static final String ALLOW_FLAWED_CONTEXT_PROPERTY = "org.apache.commons.logging.Log.allowFlawedContext";
  public static final String ALLOW_FLAWED_DISCOVERY_PROPERTY = "org.apache.commons.logging.Log.allowFlawedDiscovery";
  public static final String ALLOW_FLAWED_HIERARCHY_PROPERTY = "org.apache.commons.logging.Log.allowFlawedHierarchy";
  public static final String LOG_PROPERTY = "org.apache.commons.logging.Log";
  protected static final String LOG_PROPERTY_OLD = "org.apache.commons.logging.log";
  protected Hashtable attributes;
  protected Hashtable instances;
  protected Constructor logConstructor;
  protected Class[] logConstructorSignature = null;
  protected Method logMethod;
  protected Class[] logMethodSignature = null;
  
  public LogFactoryImpl()
  {
    throw new RuntimeException("Stub!");
  }
  
  protected static ClassLoader getClassLoader(Class paramClass)
  {
    throw new RuntimeException("Stub!");
  }
  
  protected static ClassLoader getContextClassLoader()
  {
    throw new RuntimeException("Stub!");
  }
  
  protected static boolean isDiagnosticsEnabled()
  {
    throw new RuntimeException("Stub!");
  }
  
  public Object getAttribute(String paramString)
  {
    throw new RuntimeException("Stub!");
  }
  
  public String[] getAttributeNames()
  {
    throw new RuntimeException("Stub!");
  }
  
  public Log getInstance(Class paramClass)
  {
    throw new RuntimeException("Stub!");
  }
  
  public Log getInstance(String paramString)
  {
    throw new RuntimeException("Stub!");
  }
  
  @Deprecated
  protected String getLogClassName()
  {
    throw new RuntimeException("Stub!");
  }
  
  @Deprecated
  protected Constructor getLogConstructor()
  {
    throw new RuntimeException("Stub!");
  }
  
  @Deprecated
  protected boolean isJdk13LumberjackAvailable()
  {
    throw new RuntimeException("Stub!");
  }
  
  @Deprecated
  protected boolean isJdk14Available()
  {
    throw new RuntimeException("Stub!");
  }
  
  @Deprecated
  protected boolean isLog4JAvailable()
  {
    throw new RuntimeException("Stub!");
  }
  
  protected void logDiagnostic(String paramString)
  {
    throw new RuntimeException("Stub!");
  }
  
  protected Log newInstance(String paramString)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void release()
  {
    throw new RuntimeException("Stub!");
  }
  
  public void removeAttribute(String paramString)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void setAttribute(String paramString, Object paramObject)
  {
    throw new RuntimeException("Stub!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     org.apache.commons.logging.impl.LogFactoryImpl
 * JD-Core Version:    0.7.0.1
 */