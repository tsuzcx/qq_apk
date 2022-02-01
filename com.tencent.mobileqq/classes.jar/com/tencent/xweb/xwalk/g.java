package com.tencent.xweb.xwalk;

import android.webkit.ConsoleMessage;
import android.webkit.ConsoleMessage.MessageLevel;
import com.tencent.xweb.WebResourceResponse;
import org.xwalk.core.XWalkUIClient.ConsoleMessageType;
import org.xwalk.core.XWalkWebResourceResponse;

public class g
{
  public static ConsoleMessage a(String paramString1, int paramInt, String paramString2, XWalkUIClient.ConsoleMessageType paramConsoleMessageType)
  {
    ConsoleMessage.MessageLevel localMessageLevel = ConsoleMessage.MessageLevel.DEBUG;
    int i = g.1.a[paramConsoleMessageType.ordinal()];
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i != 4)
          {
            if (i != 5) {
              paramConsoleMessageType = localMessageLevel;
            } else {
              paramConsoleMessageType = ConsoleMessage.MessageLevel.WARNING;
            }
          }
          else {
            paramConsoleMessageType = ConsoleMessage.MessageLevel.TIP;
          }
        }
        else {
          paramConsoleMessageType = ConsoleMessage.MessageLevel.LOG;
        }
      }
      else {
        paramConsoleMessageType = ConsoleMessage.MessageLevel.ERROR;
      }
    }
    else {
      paramConsoleMessageType = ConsoleMessage.MessageLevel.DEBUG;
    }
    return new ConsoleMessage(paramString1, paramString2, paramInt, paramConsoleMessageType);
  }
  
  public static WebResourceResponse a(XWalkWebResourceResponse paramXWalkWebResourceResponse)
  {
    if (paramXWalkWebResourceResponse == null) {
      return null;
    }
    return new WebResourceResponse(paramXWalkWebResourceResponse.getMimeType(), paramXWalkWebResourceResponse.getEncoding(), paramXWalkWebResourceResponse.getStatusCode(), paramXWalkWebResourceResponse.getReasonPhrase(), paramXWalkWebResourceResponse.getResponseHeaders(), paramXWalkWebResourceResponse.getData());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.xweb.xwalk.g
 * JD-Core Version:    0.7.0.1
 */