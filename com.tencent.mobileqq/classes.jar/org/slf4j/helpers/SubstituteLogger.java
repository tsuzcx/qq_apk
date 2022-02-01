package org.slf4j.helpers;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Queue;
import org.slf4j.Logger;
import org.slf4j.Marker;
import org.slf4j.event.EventRecodingLogger;
import org.slf4j.event.LoggingEvent;
import org.slf4j.event.SubstituteLoggingEvent;

public class SubstituteLogger
  implements Logger
{
  private volatile Logger _delegate;
  private final boolean createdPostInitialization;
  private Boolean delegateEventAware;
  private Queue<SubstituteLoggingEvent> eventQueue;
  private EventRecodingLogger eventRecodingLogger;
  private Method logMethodCache;
  private final String name;
  
  public SubstituteLogger(String paramString, Queue<SubstituteLoggingEvent> paramQueue, boolean paramBoolean)
  {
    this.name = paramString;
    this.eventQueue = paramQueue;
    this.createdPostInitialization = paramBoolean;
  }
  
  private Logger getEventRecordingLogger()
  {
    if (this.eventRecodingLogger == null) {
      this.eventRecodingLogger = new EventRecodingLogger(this, this.eventQueue);
    }
    return this.eventRecodingLogger;
  }
  
  public void debug(String paramString)
  {
    delegate().debug(paramString);
  }
  
  public void debug(String paramString, Object paramObject)
  {
    delegate().debug(paramString, paramObject);
  }
  
  public void debug(String paramString, Object paramObject1, Object paramObject2)
  {
    delegate().debug(paramString, paramObject1, paramObject2);
  }
  
  public void debug(String paramString, Throwable paramThrowable)
  {
    delegate().debug(paramString, paramThrowable);
  }
  
  public void debug(String paramString, Object... paramVarArgs)
  {
    delegate().debug(paramString, paramVarArgs);
  }
  
  public void debug(Marker paramMarker, String paramString)
  {
    delegate().debug(paramMarker, paramString);
  }
  
  public void debug(Marker paramMarker, String paramString, Object paramObject)
  {
    delegate().debug(paramMarker, paramString, paramObject);
  }
  
  public void debug(Marker paramMarker, String paramString, Object paramObject1, Object paramObject2)
  {
    delegate().debug(paramMarker, paramString, paramObject1, paramObject2);
  }
  
  public void debug(Marker paramMarker, String paramString, Throwable paramThrowable)
  {
    delegate().debug(paramMarker, paramString, paramThrowable);
  }
  
  public void debug(Marker paramMarker, String paramString, Object... paramVarArgs)
  {
    delegate().debug(paramMarker, paramString, paramVarArgs);
  }
  
  Logger delegate()
  {
    if (this._delegate != null) {
      return this._delegate;
    }
    if (this.createdPostInitialization) {
      return NOPLogger.NOP_LOGGER;
    }
    return getEventRecordingLogger();
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        return false;
      }
      paramObject = (SubstituteLogger)paramObject;
    } while (this.name.equals(paramObject.name));
    return false;
  }
  
  public void error(String paramString)
  {
    delegate().error(paramString);
  }
  
  public void error(String paramString, Object paramObject)
  {
    delegate().error(paramString, paramObject);
  }
  
  public void error(String paramString, Object paramObject1, Object paramObject2)
  {
    delegate().error(paramString, paramObject1, paramObject2);
  }
  
  public void error(String paramString, Throwable paramThrowable)
  {
    delegate().error(paramString, paramThrowable);
  }
  
  public void error(String paramString, Object... paramVarArgs)
  {
    delegate().error(paramString, paramVarArgs);
  }
  
  public void error(Marker paramMarker, String paramString)
  {
    delegate().error(paramMarker, paramString);
  }
  
  public void error(Marker paramMarker, String paramString, Object paramObject)
  {
    delegate().error(paramMarker, paramString, paramObject);
  }
  
  public void error(Marker paramMarker, String paramString, Object paramObject1, Object paramObject2)
  {
    delegate().error(paramMarker, paramString, paramObject1, paramObject2);
  }
  
  public void error(Marker paramMarker, String paramString, Throwable paramThrowable)
  {
    delegate().error(paramMarker, paramString, paramThrowable);
  }
  
  public void error(Marker paramMarker, String paramString, Object... paramVarArgs)
  {
    delegate().error(paramMarker, paramString, paramVarArgs);
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public int hashCode()
  {
    return this.name.hashCode();
  }
  
  public void info(String paramString)
  {
    delegate().info(paramString);
  }
  
  public void info(String paramString, Object paramObject)
  {
    delegate().info(paramString, paramObject);
  }
  
  public void info(String paramString, Object paramObject1, Object paramObject2)
  {
    delegate().info(paramString, paramObject1, paramObject2);
  }
  
  public void info(String paramString, Throwable paramThrowable)
  {
    delegate().info(paramString, paramThrowable);
  }
  
  public void info(String paramString, Object... paramVarArgs)
  {
    delegate().info(paramString, paramVarArgs);
  }
  
  public void info(Marker paramMarker, String paramString)
  {
    delegate().info(paramMarker, paramString);
  }
  
  public void info(Marker paramMarker, String paramString, Object paramObject)
  {
    delegate().info(paramMarker, paramString, paramObject);
  }
  
  public void info(Marker paramMarker, String paramString, Object paramObject1, Object paramObject2)
  {
    delegate().info(paramMarker, paramString, paramObject1, paramObject2);
  }
  
  public void info(Marker paramMarker, String paramString, Throwable paramThrowable)
  {
    delegate().info(paramMarker, paramString, paramThrowable);
  }
  
  public void info(Marker paramMarker, String paramString, Object... paramVarArgs)
  {
    delegate().info(paramMarker, paramString, paramVarArgs);
  }
  
  public boolean isDebugEnabled()
  {
    return delegate().isDebugEnabled();
  }
  
  public boolean isDebugEnabled(Marker paramMarker)
  {
    return delegate().isDebugEnabled(paramMarker);
  }
  
  public boolean isDelegateEventAware()
  {
    if (this.delegateEventAware != null) {
      return this.delegateEventAware.booleanValue();
    }
    try
    {
      this.logMethodCache = this._delegate.getClass().getMethod("log", new Class[] { LoggingEvent.class });
      this.delegateEventAware = Boolean.TRUE;
      return this.delegateEventAware.booleanValue();
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      for (;;)
      {
        this.delegateEventAware = Boolean.FALSE;
      }
    }
  }
  
  public boolean isDelegateNOP()
  {
    return this._delegate instanceof NOPLogger;
  }
  
  public boolean isDelegateNull()
  {
    return this._delegate == null;
  }
  
  public boolean isErrorEnabled()
  {
    return delegate().isErrorEnabled();
  }
  
  public boolean isErrorEnabled(Marker paramMarker)
  {
    return delegate().isErrorEnabled(paramMarker);
  }
  
  public boolean isInfoEnabled()
  {
    return delegate().isInfoEnabled();
  }
  
  public boolean isInfoEnabled(Marker paramMarker)
  {
    return delegate().isInfoEnabled(paramMarker);
  }
  
  public boolean isTraceEnabled()
  {
    return delegate().isTraceEnabled();
  }
  
  public boolean isTraceEnabled(Marker paramMarker)
  {
    return delegate().isTraceEnabled(paramMarker);
  }
  
  public boolean isWarnEnabled()
  {
    return delegate().isWarnEnabled();
  }
  
  public boolean isWarnEnabled(Marker paramMarker)
  {
    return delegate().isWarnEnabled(paramMarker);
  }
  
  public void log(LoggingEvent paramLoggingEvent)
  {
    if (isDelegateEventAware()) {}
    try
    {
      this.logMethodCache.invoke(this._delegate, new Object[] { paramLoggingEvent });
      return;
    }
    catch (InvocationTargetException paramLoggingEvent) {}catch (IllegalArgumentException paramLoggingEvent) {}catch (IllegalAccessException paramLoggingEvent) {}
  }
  
  public void setDelegate(Logger paramLogger)
  {
    this._delegate = paramLogger;
  }
  
  public void trace(String paramString)
  {
    delegate().trace(paramString);
  }
  
  public void trace(String paramString, Object paramObject)
  {
    delegate().trace(paramString, paramObject);
  }
  
  public void trace(String paramString, Object paramObject1, Object paramObject2)
  {
    delegate().trace(paramString, paramObject1, paramObject2);
  }
  
  public void trace(String paramString, Throwable paramThrowable)
  {
    delegate().trace(paramString, paramThrowable);
  }
  
  public void trace(String paramString, Object... paramVarArgs)
  {
    delegate().trace(paramString, paramVarArgs);
  }
  
  public void trace(Marker paramMarker, String paramString)
  {
    delegate().trace(paramMarker, paramString);
  }
  
  public void trace(Marker paramMarker, String paramString, Object paramObject)
  {
    delegate().trace(paramMarker, paramString, paramObject);
  }
  
  public void trace(Marker paramMarker, String paramString, Object paramObject1, Object paramObject2)
  {
    delegate().trace(paramMarker, paramString, paramObject1, paramObject2);
  }
  
  public void trace(Marker paramMarker, String paramString, Throwable paramThrowable)
  {
    delegate().trace(paramMarker, paramString, paramThrowable);
  }
  
  public void trace(Marker paramMarker, String paramString, Object... paramVarArgs)
  {
    delegate().trace(paramMarker, paramString, paramVarArgs);
  }
  
  public void warn(String paramString)
  {
    delegate().warn(paramString);
  }
  
  public void warn(String paramString, Object paramObject)
  {
    delegate().warn(paramString, paramObject);
  }
  
  public void warn(String paramString, Object paramObject1, Object paramObject2)
  {
    delegate().warn(paramString, paramObject1, paramObject2);
  }
  
  public void warn(String paramString, Throwable paramThrowable)
  {
    delegate().warn(paramString, paramThrowable);
  }
  
  public void warn(String paramString, Object... paramVarArgs)
  {
    delegate().warn(paramString, paramVarArgs);
  }
  
  public void warn(Marker paramMarker, String paramString)
  {
    delegate().warn(paramMarker, paramString);
  }
  
  public void warn(Marker paramMarker, String paramString, Object paramObject)
  {
    delegate().warn(paramMarker, paramString, paramObject);
  }
  
  public void warn(Marker paramMarker, String paramString, Object paramObject1, Object paramObject2)
  {
    delegate().warn(paramMarker, paramString, paramObject1, paramObject2);
  }
  
  public void warn(Marker paramMarker, String paramString, Throwable paramThrowable)
  {
    delegate().warn(paramMarker, paramString, paramThrowable);
  }
  
  public void warn(Marker paramMarker, String paramString, Object... paramVarArgs)
  {
    delegate().warn(paramMarker, paramString, paramVarArgs);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     org.slf4j.helpers.SubstituteLogger
 * JD-Core Version:    0.7.0.1
 */