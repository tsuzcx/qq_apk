package org.slf4j.helpers;

import org.slf4j.Logger;
import org.slf4j.Marker;

public abstract class MarkerIgnoringBase
  extends NamedLoggerBase
  implements Logger
{
  private static final long serialVersionUID = 9044267456635152283L;
  
  public void debug(Marker paramMarker, String paramString)
  {
    debug(paramString);
  }
  
  public void debug(Marker paramMarker, String paramString, Object paramObject)
  {
    debug(paramString, paramObject);
  }
  
  public void debug(Marker paramMarker, String paramString, Object paramObject1, Object paramObject2)
  {
    debug(paramString, paramObject1, paramObject2);
  }
  
  public void debug(Marker paramMarker, String paramString, Throwable paramThrowable)
  {
    debug(paramString, paramThrowable);
  }
  
  public void debug(Marker paramMarker, String paramString, Object... paramVarArgs)
  {
    debug(paramString, paramVarArgs);
  }
  
  public void error(Marker paramMarker, String paramString)
  {
    error(paramString);
  }
  
  public void error(Marker paramMarker, String paramString, Object paramObject)
  {
    error(paramString, paramObject);
  }
  
  public void error(Marker paramMarker, String paramString, Object paramObject1, Object paramObject2)
  {
    error(paramString, paramObject1, paramObject2);
  }
  
  public void error(Marker paramMarker, String paramString, Throwable paramThrowable)
  {
    error(paramString, paramThrowable);
  }
  
  public void error(Marker paramMarker, String paramString, Object... paramVarArgs)
  {
    error(paramString, paramVarArgs);
  }
  
  public void info(Marker paramMarker, String paramString)
  {
    info(paramString);
  }
  
  public void info(Marker paramMarker, String paramString, Object paramObject)
  {
    info(paramString, paramObject);
  }
  
  public void info(Marker paramMarker, String paramString, Object paramObject1, Object paramObject2)
  {
    info(paramString, paramObject1, paramObject2);
  }
  
  public void info(Marker paramMarker, String paramString, Throwable paramThrowable)
  {
    info(paramString, paramThrowable);
  }
  
  public void info(Marker paramMarker, String paramString, Object... paramVarArgs)
  {
    info(paramString, paramVarArgs);
  }
  
  public boolean isDebugEnabled(Marker paramMarker)
  {
    return isDebugEnabled();
  }
  
  public boolean isErrorEnabled(Marker paramMarker)
  {
    return isErrorEnabled();
  }
  
  public boolean isInfoEnabled(Marker paramMarker)
  {
    return isInfoEnabled();
  }
  
  public boolean isTraceEnabled(Marker paramMarker)
  {
    return isTraceEnabled();
  }
  
  public boolean isWarnEnabled(Marker paramMarker)
  {
    return isWarnEnabled();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getClass().getName());
    localStringBuilder.append("(");
    localStringBuilder.append(getName());
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
  
  public void trace(Marker paramMarker, String paramString)
  {
    trace(paramString);
  }
  
  public void trace(Marker paramMarker, String paramString, Object paramObject)
  {
    trace(paramString, paramObject);
  }
  
  public void trace(Marker paramMarker, String paramString, Object paramObject1, Object paramObject2)
  {
    trace(paramString, paramObject1, paramObject2);
  }
  
  public void trace(Marker paramMarker, String paramString, Throwable paramThrowable)
  {
    trace(paramString, paramThrowable);
  }
  
  public void trace(Marker paramMarker, String paramString, Object... paramVarArgs)
  {
    trace(paramString, paramVarArgs);
  }
  
  public void warn(Marker paramMarker, String paramString)
  {
    warn(paramString);
  }
  
  public void warn(Marker paramMarker, String paramString, Object paramObject)
  {
    warn(paramString, paramObject);
  }
  
  public void warn(Marker paramMarker, String paramString, Object paramObject1, Object paramObject2)
  {
    warn(paramString, paramObject1, paramObject2);
  }
  
  public void warn(Marker paramMarker, String paramString, Throwable paramThrowable)
  {
    warn(paramString, paramThrowable);
  }
  
  public void warn(Marker paramMarker, String paramString, Object... paramVarArgs)
  {
    warn(paramString, paramVarArgs);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     org.slf4j.helpers.MarkerIgnoringBase
 * JD-Core Version:    0.7.0.1
 */