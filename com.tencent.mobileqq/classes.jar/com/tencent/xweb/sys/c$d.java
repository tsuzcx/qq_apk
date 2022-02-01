package com.tencent.xweb.sys;

import android.webkit.JsPromptResult;
import com.tencent.xweb.l;

public class c$d
  extends l
{
  public JsPromptResult a;
  
  public c$d(JsPromptResult paramJsPromptResult)
  {
    this.a = paramJsPromptResult;
  }
  
  public void cancel()
  {
    JsPromptResult localJsPromptResult = this.a;
    if (localJsPromptResult != null) {
      localJsPromptResult.cancel();
    }
  }
  
  public void confirm()
  {
    JsPromptResult localJsPromptResult = this.a;
    if (localJsPromptResult != null) {
      localJsPromptResult.confirm();
    }
  }
  
  public void confirmWithResult(String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.xweb.sys.c.d
 * JD-Core Version:    0.7.0.1
 */