package org.xwalk.core;

class XWalkCoreWrapper$1
  extends XWalkLogMessageListener
{
  XWalkCoreWrapper$1(XWalkCoreWrapper paramXWalkCoreWrapper1, XWalkCoreWrapper paramXWalkCoreWrapper2)
  {
    super(paramXWalkCoreWrapper2);
  }
  
  public void onLogMessage(int paramInt1, String paramString1, int paramInt2, String paramString2)
  {
    paramString1 = new StringBuilder();
    paramString1.append("[WCWebview] :");
    paramString1.append(paramString2);
    Log.i("XWalkLib", paramString1.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.xwalk.core.XWalkCoreWrapper.1
 * JD-Core Version:    0.7.0.1
 */