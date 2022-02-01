package com.tencent.xweb.xwalk;

import org.xwalk.core.Log;
import org.xwalk.core.XWalkLogMessageListener;

class k$9
  extends XWalkLogMessageListener
{
  k$9(k paramk) {}
  
  public void onLogMessage(int paramInt1, String paramString1, int paramInt2, String paramString2)
  {
    paramString1 = new StringBuilder();
    paramString1.append("[WCWebview] :");
    paramString1.append(paramString2);
    Log.i("XWWebView", paramString1.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.xweb.xwalk.k.9
 * JD-Core Version:    0.7.0.1
 */