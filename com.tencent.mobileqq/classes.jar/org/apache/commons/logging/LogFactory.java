package org.apache.commons.logging;

import java.util.Hashtable;

@Deprecated
public abstract class LogFactory
{
  public static final String DIAGNOSTICS_DEST_PROPERTY = "org.apache.commons.logging.diagnostics.dest";
  public static final String FACTORY_DEFAULT = "org.apache.commons.logging.impl.LogFactoryImpl";
  public static final String FACTORY_PROPERTIES = "commons-logging.properties";
  public static final String FACTORY_PROPERTY = "org.apache.commons.logging.LogFactory";
  public static final String HASHTABLE_IMPLEMENTATION_PROPERTY = "org.apache.commons.logging.LogFactory.HashtableImpl";
  public static final String PRIORITY_KEY = "priority";
  protected static final String SERVICE_ID = "META-INF/services/org.apache.commons.logging.LogFactory";
  public static final String TCCL_KEY = "use_tccl";
  protected static Hashtable factories;
  protected static LogFactory nullClassLoaderFactory;
  
  protected LogFactory()
  {
    throw new RuntimeException("Stub!");
  }
  
  protected static Object createFactory(String paramString, ClassLoader paramClassLoader)
  {
    throw new RuntimeException("Stub!");
  }
  
  protected static ClassLoader directGetContextClassLoader()
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
  
  public static LogFactory getFactory()
  {
    throw new RuntimeException("Stub!");
  }
  
  public static Log getLog(Class paramClass)
  {
    throw new RuntimeException("Stub!");
  }
  
  public static Log getLog(String paramString)
  {
    throw new RuntimeException("Stub!");
  }
  
  protected static boolean isDiagnosticsEnabled()
  {
    throw new RuntimeException("Stub!");
  }
  
  protected static final void logRawDiagnostic(String paramString)
  {
    throw new RuntimeException("Stub!");
  }
  
  protected static LogFactory newFactory(String paramString, ClassLoader paramClassLoader)
  {
    throw new RuntimeException("Stub!");
  }
  
  protected static LogFactory newFactory(String paramString, ClassLoader paramClassLoader1, ClassLoader paramClassLoader2)
  {
    throw new RuntimeException("Stub!");
  }
  
  public static String objectId(Object paramObject)
  {
    throw new RuntimeException("Stub!");
  }
  
  public static void release(ClassLoader paramClassLoader)
  {
    throw new RuntimeException("Stub!");
  }
  
  public static void releaseAll()
  {
    throw new RuntimeException("Stub!");
  }
  
  public abstract Object getAttribute(String paramString);
  
  public abstract String[] getAttributeNames();
  
  public abstract Log getInstance(Class paramClass);
  
  public abstract Log getInstance(String paramString);
  
  public abstract void release();
  
  public abstract void removeAttribute(String paramString);
  
  public abstract void setAttribute(String paramString, Object paramObject);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     org.apache.commons.logging.LogFactory
 * JD-Core Version:    0.7.0.1
 */