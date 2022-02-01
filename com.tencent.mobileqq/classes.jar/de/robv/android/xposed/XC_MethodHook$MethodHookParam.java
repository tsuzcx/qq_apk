package de.robv.android.xposed;

import de.robv.android.xposed.callbacks.XCallback.Param;
import java.lang.reflect.Member;

public class XC_MethodHook$MethodHookParam
  extends XCallback.Param
{
  public Object[] args;
  public Member method;
  private Object result = null;
  boolean returnEarly = false;
  public Object thisObject;
  private Throwable throwable = null;
  
  public Object getResult()
  {
    return this.result;
  }
  
  public Object getResultOrThrowable()
  {
    if (this.throwable != null) {
      throw this.throwable;
    }
    return this.result;
  }
  
  public Throwable getThrowable()
  {
    return this.throwable;
  }
  
  public boolean hasThrowable()
  {
    return this.throwable != null;
  }
  
  public void setResult(Object paramObject)
  {
    this.result = paramObject;
    this.throwable = null;
    this.returnEarly = true;
  }
  
  public void setThrowable(Throwable paramThrowable)
  {
    this.throwable = paramThrowable;
    this.result = null;
    this.returnEarly = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     de.robv.android.xposed.XC_MethodHook.MethodHookParam
 * JD-Core Version:    0.7.0.1
 */