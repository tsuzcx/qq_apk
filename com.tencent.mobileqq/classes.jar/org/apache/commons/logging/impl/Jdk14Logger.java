package org.apache.commons.logging.impl;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.logging.Log;

@Deprecated
public class Jdk14Logger
  implements Serializable, Log
{
  protected static final Level dummyLevel;
  protected transient Logger logger;
  protected String name;
  
  public Jdk14Logger(String paramString)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void debug(Object paramObject)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void debug(Object paramObject, Throwable paramThrowable)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void error(Object paramObject)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void error(Object paramObject, Throwable paramThrowable)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void fatal(Object paramObject)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void fatal(Object paramObject, Throwable paramThrowable)
  {
    throw new RuntimeException("Stub!");
  }
  
  public Logger getLogger()
  {
    throw new RuntimeException("Stub!");
  }
  
  public void info(Object paramObject)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void info(Object paramObject, Throwable paramThrowable)
  {
    throw new RuntimeException("Stub!");
  }
  
  public boolean isDebugEnabled()
  {
    throw new RuntimeException("Stub!");
  }
  
  public boolean isErrorEnabled()
  {
    throw new RuntimeException("Stub!");
  }
  
  public boolean isFatalEnabled()
  {
    throw new RuntimeException("Stub!");
  }
  
  public boolean isInfoEnabled()
  {
    throw new RuntimeException("Stub!");
  }
  
  public boolean isTraceEnabled()
  {
    throw new RuntimeException("Stub!");
  }
  
  public boolean isWarnEnabled()
  {
    throw new RuntimeException("Stub!");
  }
  
  public void trace(Object paramObject)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void trace(Object paramObject, Throwable paramThrowable)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void warn(Object paramObject)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void warn(Object paramObject, Throwable paramThrowable)
  {
    throw new RuntimeException("Stub!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     org.apache.commons.logging.impl.Jdk14Logger
 * JD-Core Version:    0.7.0.1
 */