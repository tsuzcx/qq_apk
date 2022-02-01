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
    this.jsContent = paramString1;
    this.jsPath = paramString2;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("JsState id:");
    localStringBuilder.append(this.id);
    localStringBuilder.append(" contentLength=");
    int j = 0;
    int i;
    if (paramString1 != null) {
      i = paramString1.length();
    } else {
      i = 0;
    }
    localStringBuilder.append(i);
    localStringBuilder.append(" path=");
    localStringBuilder.append(paramString2);
    localStringBuilder.append(" (");
    localStringBuilder.append(this);
    localStringBuilder.append(")");
    QMLog.i("JsDebugInfo", localStringBuilder.toString());
    try
    {
      if (!TextUtils.isEmpty(this.jsContent))
      {
        paramString1 = this.jsContent;
        if (this.jsContent.length() > 150) {
          i = 150;
        } else {
          i = this.jsContent.length();
        }
        paramString1 = paramString1.substring(0, i);
        paramString2 = this.jsContent;
        i = j;
        if (this.jsContent.length() > 150) {
          i = this.jsContent.length() - 150;
        }
        paramString2 = paramString2.substring(i);
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("JsState id:");
        localStringBuilder.append(this.id);
        localStringBuilder.append(" begin=");
        localStringBuilder.append(paramString1);
        localStringBuilder.append(" (");
        localStringBuilder.append(this);
        localStringBuilder.append(")");
        QMLog.i("JsDebugInfo", localStringBuilder.toString());
        paramString1 = new StringBuilder();
        paramString1.append("JsState id:");
        paramString1.append(this.id);
        paramString1.append(" end=");
        paramString1.append(paramString2);
        paramString1.append(" (");
        paramString1.append(this);
        paramString1.append(")");
        QMLog.i("JsDebugInfo", paramString1.toString());
        return;
      }
    }
    catch (Throwable paramString1)
    {
      paramString2 = new StringBuilder();
      paramString2.append(" (");
      paramString2.append(this);
      paramString2.append(")");
      QMLog.i("JsDebugInfo", paramString2.toString(), paramString1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.core.fsm.JsStatMachine.JsState
 * JD-Core Version:    0.7.0.1
 */