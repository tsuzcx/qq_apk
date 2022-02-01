package com.tencent.qqmini.miniapp.core.fsm;

import android.os.Handler;
import android.os.Looper;
import android.webkit.ValueCallback;

public abstract class JsStatMachine
  extends StateMachine<Integer, Integer>
{
  public static final Integer EVENT_JS_EVALUATE_FAIL = Integer.valueOf(2);
  public static final Integer EVENT_JS_EVALUATE_SUCC = Integer.valueOf(1);
  protected JsStatMachine.JsStateListener mJsStateListener;
  public Handler mMainHandler = new Handler(Looper.getMainLooper());
  
  public abstract void evaluateJs(String paramString1, ValueCallback paramValueCallback, String paramString2);
  
  public void sendEvent(Integer paramInteger)
  {
    Object localObject = getCurrState();
    if ((localObject instanceof JsStatMachine.JsState))
    {
      localObject = (JsStatMachine.JsState)localObject;
      if ((JsStatMachine.JsState.access$000((JsStatMachine.JsState)localObject) != null) && (EVENT_JS_EVALUATE_SUCC == paramInteger)) {
        setCurrState(JsStatMachine.JsState.access$000((JsStatMachine.JsState)localObject));
      }
    }
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        super.sendEvent(paramInteger);
      }
      return;
    }
  }
  
  public void setJsStateListener(JsStatMachine.JsStateListener paramJsStateListener)
  {
    this.mJsStateListener = paramJsStateListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.core.fsm.JsStatMachine
 * JD-Core Version:    0.7.0.1
 */