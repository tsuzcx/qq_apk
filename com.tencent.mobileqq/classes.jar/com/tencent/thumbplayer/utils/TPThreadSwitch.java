package com.tencent.thumbplayer.utils;

import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;

public class TPThreadSwitch
{
  private static final int API_CALL_TIME_OUT_MS = 500;
  private static final boolean ENV_DEBUG = false;
  private Class<?> mClass;
  private TPThreadSwitch.EventHandler mEventHandler;
  private Object mHandleListener;
  private TPReadWriteLock mLock;
  private String mLogTag;
  private Looper mLooper;
  
  public TPThreadSwitch(String paramString, Looper paramLooper, @NonNull Object paramObject)
  {
    this.mLogTag = paramString;
    this.mLooper = paramLooper;
    this.mLock = new TPReadWriteLock();
    this.mEventHandler = new TPThreadSwitch.EventHandler(this, this.mLooper, null);
    this.mHandleListener = paramObject;
    this.mClass = this.mHandleListener.getClass();
    if (TPThreadAnnotations.register(this.mClass, 0)) {
      return;
    }
    paramString = this.mLogTag;
    paramLooper = new StringBuilder();
    paramLooper.append("Register ");
    paramLooper.append(this.mClass.getName());
    paramLooper.append(" @ThreadSwitch method failed, version: ");
    paramLooper.append("2.16.0.1123");
    TPLogUtil.e(paramString, paramLooper.toString());
    throw new RuntimeException("register @ThreadSwitch method failed, player can not work");
  }
  
  private Object dealResult(String paramString, Object paramObject1, Object paramObject2)
  {
    if (paramObject1 != null) {
      return paramObject1;
    }
    paramString = TPThreadAnnotations.getMethod(this.mClass, paramString, getMethodParams(paramObject2)).getReturnType().getName();
    if (paramString.equals("boolean")) {
      return Boolean.valueOf(false);
    }
    if (paramString.equals("int")) {
      return Integer.valueOf(0);
    }
    if (paramString.equals("long")) {
      return Long.valueOf(0L);
    }
    if (paramString.equals("float")) {
      return Float.valueOf(0.0F);
    }
    return null;
  }
  
  private Object[] getMethodParams(Object paramObject)
  {
    if (paramObject == null) {
      return null;
    }
    if ((paramObject instanceof TPThreadSwitch.MessageParams))
    {
      paramObject = ((TPThreadSwitch.MessageParams)paramObject).params;
      if (paramObject == null) {
        return null;
      }
      return (Object[])paramObject;
    }
    return (Object[])paramObject;
  }
  
  private void handleEventMessage(Message paramMessage)
  {
    if (this.mHandleListener == null)
    {
      TPLogUtil.e(this.mLogTag, "handle listener is null, return");
      return;
    }
    invokeMethod(paramMessage.what, paramMessage.obj);
  }
  
  private boolean internalMessage(int paramInt1, int paramInt2, int paramInt3, Object paramObject, boolean paramBoolean1, boolean paramBoolean2, long paramLong)
  {
    if (this.mEventHandler == null)
    {
      paramObject = this.mLogTag;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(messageToCommand(paramInt1));
      ((StringBuilder)localObject).append(" , send failed , handler null");
      TPLogUtil.e(paramObject, ((StringBuilder)localObject).toString());
      return false;
    }
    if ((paramBoolean1) && (paramObject == null))
    {
      paramObject = this.mLogTag;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(messageToCommand(paramInt1));
      ((StringBuilder)localObject).append(", send failed , params null");
      TPLogUtil.e(paramObject, ((StringBuilder)localObject).toString());
      return false;
    }
    if (!this.mLooper.getThread().isAlive())
    {
      paramObject = this.mLogTag;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(messageToCommand(paramInt1));
      ((StringBuilder)localObject).append(", send failed , thread had dead");
      TPLogUtil.e(paramObject, ((StringBuilder)localObject).toString());
      return false;
    }
    if (!isSameLooper()) {
      this.mLock.readLock().lock();
    }
    if (paramBoolean2) {
      this.mEventHandler.removeMessages(paramInt1);
    }
    Object localObject = this.mEventHandler.obtainMessage();
    ((Message)localObject).what = paramInt1;
    ((Message)localObject).arg1 = paramInt2;
    ((Message)localObject).arg2 = paramInt3;
    ((Message)localObject).obj = paramObject;
    if (isSameLooper())
    {
      handleEventMessage((Message)localObject);
    }
    else
    {
      this.mEventHandler.sendMessageDelayed((Message)localObject, paramLong);
      this.mLock.readLock().unlock();
    }
    return true;
  }
  
  private boolean internalMessage(int paramInt, Object paramObject)
  {
    return internalMessage(paramInt, 0, 0, paramObject, false, false, 0L);
  }
  
  private Object internalMessageLock(int paramInt1, int paramInt2, int paramInt3, Object paramObject, boolean paramBoolean1, boolean paramBoolean2, long paramLong)
  {
    TPFutureResult localTPFutureResult = new TPFutureResult();
    TPThreadSwitch.MessageParams localMessageParams = new TPThreadSwitch.MessageParams(null);
    localMessageParams.params = paramObject;
    localMessageParams.result = localTPFutureResult;
    internalMessage(paramInt1, paramInt2, paramInt3, localMessageParams, paramBoolean1, paramBoolean2, paramLong);
    return localTPFutureResult.getResult(500L);
  }
  
  private void invokeMethod(int paramInt, Object paramObject)
  {
    TPFutureResult localTPFutureResult;
    if ((paramObject instanceof TPThreadSwitch.MessageParams)) {
      localTPFutureResult = ((TPThreadSwitch.MessageParams)paramObject).result;
    } else {
      localTPFutureResult = null;
    }
    Object localObject1 = TPThreadAnnotations.getMethodByMsgId(this.mClass, paramInt);
    if (localObject1 == null)
    {
      paramObject = this.mLogTag;
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("invokeMethod, handle method name is empty, msg:");
      ((StringBuilder)localObject1).append(paramInt);
      TPLogUtil.e(paramObject, ((StringBuilder)localObject1).toString());
      if (localTPFutureResult != null) {
        localTPFutureResult.setException(new RuntimeException("invokeMethod, handle method name is empty"));
      }
      return;
    }
    try
    {
      if (((Method)localObject1).getParameterTypes().length == 0)
      {
        paramObject = ((Method)localObject1).invoke(this.mHandleListener, new Object[0]);
      }
      else
      {
        paramObject = getMethodParams(paramObject);
        paramObject = ((Method)localObject1).invoke(this.mHandleListener, paramObject);
      }
      if (localTPFutureResult != null)
      {
        localTPFutureResult.setResult(paramObject);
        return;
      }
    }
    catch (Exception paramObject)
    {
      localObject2 = this.mLogTag;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("invokeMethod ");
      localStringBuilder.append(((Method)localObject1).getName());
      localStringBuilder.append(" has excecption: ");
      localStringBuilder.append(paramObject.toString());
      TPLogUtil.e((String)localObject2, localStringBuilder.toString());
      if (localTPFutureResult != null)
      {
        localTPFutureResult.setException(paramObject);
        return;
      }
    }
    catch (InvocationTargetException paramObject)
    {
      Object localObject2 = this.mLogTag;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("invokeMethod ");
      localStringBuilder.append(((Method)localObject1).getName());
      localStringBuilder.append(" has excecption: ");
      localStringBuilder.append(paramObject.getTargetException().toString());
      TPLogUtil.e((String)localObject2, localStringBuilder.toString());
      if (localTPFutureResult == null) {
        return;
      }
      if ((paramObject.getTargetException() instanceof IllegalArgumentException))
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("invokeMethod ");
        ((StringBuilder)localObject2).append(((Method)localObject1).getName());
        ((StringBuilder)localObject2).append(" failed, params invalid");
        localTPFutureResult.setException(new IllegalArgumentException(((StringBuilder)localObject2).toString(), paramObject.getCause()));
        return;
      }
      if ((paramObject.getTargetException() instanceof IllegalStateException))
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("invokeMethod ");
        ((StringBuilder)localObject2).append(((Method)localObject1).getName());
        ((StringBuilder)localObject2).append(" failed, state invalid");
        localTPFutureResult.setException(new IllegalStateException(((StringBuilder)localObject2).toString(), paramObject.getCause()));
        return;
      }
      localTPFutureResult.setException(paramObject.getTargetException());
    }
  }
  
  private boolean isSameLooper()
  {
    return Looper.myLooper() == this.mLooper;
  }
  
  private String messageToCommand(int paramInt)
  {
    Object localObject = TPThreadAnnotations.getApi(this.mClass, paramInt);
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!((String)localObject).equals("unknown"))) {
      return localObject;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(" not find");
    return ((StringBuilder)localObject).toString();
  }
  
  private void recycle()
  {
    this.mEventHandler.removeCallbacksAndMessages(null);
  }
  
  public Object dealThreadSwitch(String paramString, Object paramObject)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      Object localObject = getMethodParams(paramObject);
      int i = TPThreadAnnotations.getMethodMsgId(this.mClass, paramString, (Object[])localObject);
      if (i >= 0)
      {
        boolean bool1 = TPThreadAnnotations.removeRepeat(this.mClass, i);
        boolean bool2 = TPThreadAnnotations.checkObj(this.mClass, i);
        if (TPThreadAnnotations.isNeedWait(this.mClass, i)) {
          return internalMessageLock(i, 0, 0, paramObject, bool2, bool1, 0L);
        }
        internalMessage(i, 0, 0, paramObject, bool2, bool1, 0L);
        return null;
      }
      paramObject = this.mLogTag;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("dealThreadSwitch failed , not match method:");
      ((StringBuilder)localObject).append(paramString);
      TPLogUtil.e(paramObject, ((StringBuilder)localObject).toString());
      paramObject = new StringBuilder();
      paramObject.append("dealThreadSwitch failed , not match method:");
      paramObject.append(paramString);
      throw new RuntimeException(paramObject.toString());
    }
    TPLogUtil.e(this.mLogTag, "dealThreadSwitch failed , methodName is null");
    throw new RuntimeException("dealThreadSwitch failed , methodName is null");
  }
  
  public Object dealThreadSwitchWithResult(String paramString, Object paramObject)
  {
    return dealResult(paramString, dealThreadSwitch(paramString, paramObject), paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.thumbplayer.utils.TPThreadSwitch
 * JD-Core Version:    0.7.0.1
 */