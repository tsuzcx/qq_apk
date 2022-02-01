package org.xwalk.core;

import java.util.List;

final class WebViewExtension$1
  extends WebViewExtensionInterface
{
  public int getHostByName(String paramString, List<String> paramList)
  {
    if (WebViewExtension.access$000() != null) {
      return WebViewExtension.access$000().getHostByName(paramString, paramList);
    }
    return 0;
  }
  
  public Object onMiscCallBack(String paramString, Object... paramVarArgs)
  {
    if (WebViewExtension.access$000() != null) {
      return WebViewExtension.access$000().onMiscCallBack(paramString, paramVarArgs);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.xwalk.core.WebViewExtension.1
 * JD-Core Version:    0.7.0.1
 */