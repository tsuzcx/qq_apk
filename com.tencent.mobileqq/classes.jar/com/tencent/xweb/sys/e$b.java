package com.tencent.xweb.sys;

import android.webkit.JavascriptInterface;
import android.webkit.ValueCallback;
import java.util.HashMap;

public class e$b
{
  HashMap<String, ValueCallback<String>> a = new HashMap();
  int b = 0;
  
  public String a(ValueCallback<String> paramValueCallback)
  {
    Object localObject = "";
    if (paramValueCallback != null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("");
      int i = this.b;
      this.b = (i + 1);
      ((StringBuilder)localObject).append(i);
      localObject = ((StringBuilder)localObject).toString();
      this.a.put(localObject, paramValueCallback);
    }
    return localObject;
  }
  
  @JavascriptInterface
  public void notifyJava(String paramString1, String paramString2)
  {
    ValueCallback localValueCallback = (ValueCallback)this.a.get(paramString1);
    if (localValueCallback != null)
    {
      localValueCallback.onReceiveValue(paramString2);
      this.a.remove(paramString1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.xweb.sys.e.b
 * JD-Core Version:    0.7.0.1
 */