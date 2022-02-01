package com.tencent.qqmini.miniapp.core.fsm;

import android.text.TextUtils;
import com.tencent.qqmini.sdk.launcher.log.QMLog;

public class JsStatMachine$JsState
  extends StateMachine.State
{
  private String jsContent;
  private String jsPath;
  private StateMachine.State nextState;
  
  public JsStatMachine$JsState(JsStatMachine paramJsStatMachine, int paramInt)
  {
    super(paramJsStatMachine, Integer.valueOf(paramInt));
  }
  
  public String getJsContent()
  {
    return this.jsContent;
  }
  
  public String getJsPath()
  {
    return this.jsPath;
  }
  
  public JsState nextState(StateMachine.State paramState)
  {
    this.nextState = paramState;
    return this;
  }
  
  public void onStart()
  {
    super.onStart();
    if (TextUtils.isEmpty(this.jsContent))
    {
      this.this$0.sendEvent(JsStatMachine.EVENT_JS_EVALUATE_SUCC);
      return;
    }
    if (this.this$0.mJsStateListener != null) {
      this.this$0.mJsStateListener.onJsStateStart(this);
    }
    this.this$0.evaluateJs(this.jsContent, new JsStatMachine.JsState.1(this), this.jsPath);
  }
  
  public void setJsContent(String paramString)
  {
    setJsContent(paramString, null);
  }
  
  public void setJsContent(String paramString1, String paramString2)
  {
    int j = 0;
    this.jsContent = paramString1;
    this.jsPath = paramString2;
    StringBuilder localStringBuilder = new StringBuilder().append("JsState id:").append(this.id).append(" contentLength=");
    if (paramString1 != null) {}
    for (int i = paramString1.length();; i = 0)
    {
      QMLog.i("JsDebugInfo", i + " path=" + paramString2);
      try
      {
        if (!TextUtils.isEmpty(this.jsContent))
        {
          paramString1 = this.jsContent;
          if (this.jsContent.length() > 150) {}
          for (i = 150;; i = this.jsContent.length())
          {
            paramString1 = paramString1.substring(0, i);
            paramString2 = this.jsContent;
            i = j;
            if (this.jsContent.length() > 150) {
              i = this.jsContent.length() - 150;
            }
            paramString2 = paramString2.substring(i);
            QMLog.i("JsDebugInfo", "JsState id:" + this.id + " begin=" + paramString1);
            QMLog.i("JsDebugInfo", "JsState id:" + this.id + " end=" + paramString2);
            return;
          }
        }
        return;
      }
      catch (Throwable paramString1)
      {
        QMLog.i("JsDebugInfo", "", paramString1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.core.fsm.JsStatMachine.JsState
 * JD-Core Version:    0.7.0.1
 */