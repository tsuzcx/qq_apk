package com.tencent.xweb.xwalk;

import com.tencent.xweb.l;
import org.xwalk.core.XWalkJavascriptResult;

public class g$e
  extends l
{
  public XWalkJavascriptResult a;
  
  public g$e(XWalkJavascriptResult paramXWalkJavascriptResult)
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
 * Qualified Name:     com.tencent.xweb.xwalk.g.e
 * JD-Core Version:    0.7.0.1
 */