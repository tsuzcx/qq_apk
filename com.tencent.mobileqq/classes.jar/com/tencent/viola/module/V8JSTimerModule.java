package com.tencent.viola.module;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.support.annotation.IntRange;
import com.eclipsesource.v8.V8;
import com.eclipsesource.v8.V8Function;
import com.tencent.viola.annotation.JSMethod;
import com.tencent.viola.commons.Destroyable;
import java.util.HashMap;
import java.util.Map;

public class V8JSTimerModule
  extends BaseModule
  implements Handler.Callback, Destroyable
{
  public static final String CALLBACK = "callback";
  public static final String DELAY = "delay";
  public static final String METHOD_CLEARTIMEOUT = "clearTimeout";
  public static final String METHOD_SETTIMEOUT = "setTimeout";
  public static final String MODULE_NAME = "jsTimer";
  public static final int MSG_TIMEOUT = 1;
  public static final String TAG = "JSTimerModule";
  public static final String TIMERID = "timerId";
  private Handler handler = new V8JSTimerModule.TimerHandler(this);
  public Map<Integer, Object> timeoutMap = new HashMap();
  private int timerCount = 0;
  
  @JSMethod(uiThread=false)
  public void clearTimeout(@IntRange(from=0L) int paramInt)
  {
    Object localObject = this.timeoutMap.get(Integer.valueOf(paramInt));
    if ((localObject instanceof V8JSTimerModule.TimerParam))
    {
      V8JSTimerModule.TimerParam localTimerParam = (V8JSTimerModule.TimerParam)localObject;
      if ((localTimerParam.v8Function != null) && (!localTimerParam.v8Function.isReleased()) && (localTimerParam.v8Function.getRuntime() != null) && (!localTimerParam.v8Function.getRuntime().isReleased())) {
        localTimerParam.v8Function.close();
      }
    }
    this.handler.removeMessages(1, localObject);
  }
  
  public void destroy()
  {
    Object localObject = this.handler;
    if (localObject != null) {
      ((Handler)localObject).removeCallbacksAndMessages(null);
    }
    localObject = this.timeoutMap;
    if ((localObject != null) && (((Map)localObject).size() > 0)) {
      this.timeoutMap.clear();
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    return false;
  }
  
  @JSMethod(uiThread=false)
  public void setTimeout(V8Function paramV8Function, int paramInt)
  {
    this.timerCount += 1;
    Message localMessage = Message.obtain();
    localMessage.what = 1;
    localMessage.obj = new V8JSTimerModule.TimerParam(paramV8Function, paramInt, this.timerCount);
    this.timeoutMap.put(Integer.valueOf(this.timerCount), localMessage.obj);
    this.handler.sendMessageDelayed(localMessage, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.viola.module.V8JSTimerModule
 * JD-Core Version:    0.7.0.1
 */