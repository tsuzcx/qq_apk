package com.tencent.xweb.xwalk;

import com.tencent.xweb.JsResult;
import org.xwalk.core.XWalkJavascriptResult;

public class g$c
  extends JsResult
{
  public XWalkJavascriptResult a;
  
  public g$c(XWalkJavascriptResult paramXWalkJavascriptResult)
  {
    this.a = paramXWalkJavascriptResult;
  }
  
  public XWalkJavascriptResult a()
  {
    return this.a;
  }
  
  public void cancel()
  {
    this.a.cancel();
  }
  
  public void confirm()
  {
    this.a.confirm();
  }
  
  public void confirmWithResult(String paramString)
  {
    this.a.confirmWithResult(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.xweb.xwalk.g.c
 * JD-Core Version:    0.7.0.1
 */