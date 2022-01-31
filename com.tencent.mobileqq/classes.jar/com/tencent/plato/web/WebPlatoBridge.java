package com.tencent.plato.web;

import android.net.Uri;
import com.tencent.plato.IPlatoRuntime;
import com.tencent.plato.core.utils.PLog;
import java.util.List;

class WebPlatoBridge
  implements IWebView.IUrlRequestHandler
{
  private final IPlatoRuntime mPlatoRuntime;
  
  WebPlatoBridge(IPlatoRuntime paramIPlatoRuntime)
  {
    this.mPlatoRuntime = paramIPlatoRuntime;
  }
  
  private void nativeApiDirect(String paramString)
  {
    paramString = Uri.parse(paramString).getPathSegments();
    if (paramString.size() != 2) {
      return;
    }
    String str = (String)paramString.get(0);
    paramString = (String)paramString.get(1);
  }
  
  private void nativeBridge(String paramString)
  {
    Object localObject = Uri.parse(paramString).getPathSegments();
    if (((List)localObject).size() != 4) {
      return;
    }
    paramString = (String)((List)localObject).get(0);
    String str1 = (String)((List)localObject).get(1);
    String str2 = (String)((List)localObject).get(2);
    localObject = (String)((List)localObject).get(3);
    try
    {
      this.mPlatoRuntime.dispatchScriptRequest(Integer.parseInt(str1), Integer.parseInt(str2), new WebReadableArray(this.mPlatoRuntime, Integer.parseInt(paramString), (String)localObject));
      return;
    }
    catch (NumberFormatException paramString)
    {
      PLog.dumpStack(paramString);
    }
  }
  
  public void onUrlRequest(String paramString)
  {
    PLog.i("wanghuajie", "onUrlRequest:" + paramString);
    if (paramString.startsWith("plato://bridge/")) {
      nativeBridge(paramString);
    }
    while (!paramString.startsWith("plato://__native__/")) {
      return;
    }
    nativeApiDirect(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.plato.web.WebPlatoBridge
 * JD-Core Version:    0.7.0.1
 */