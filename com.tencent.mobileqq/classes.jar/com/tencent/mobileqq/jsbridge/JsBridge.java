package com.tencent.mobileqq.jsbridge;

import com.tencent.biz.AuthorizeConfig;
import com.tencent.biz.common.util.Util;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@Deprecated
public class JsBridge
{
  HashMap<String, JsBridge.JsHandler> a = new HashMap();
  AuthorizeConfig b;
  
  public void a(JsBridge.JsHandler paramJsHandler, String paramString)
  {
    this.a.put(paramString, paramJsHandler);
  }
  
  public void a(String paramString)
  {
    if (paramString == null)
    {
      this.a.clear();
      return;
    }
    this.a.remove(paramString);
  }
  
  public void a(String paramString1, String paramString2, List<String> paramList, JsBridge.JsBridgeListener paramJsBridgeListener)
  {
    int j = paramList.size();
    int i = 0;
    while (i < j)
    {
      try
      {
        paramList.set(i, URLDecoder.decode((String)paramList.get(i), "UTF-8"));
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        if (QLog.isDevelopLevel())
        {
          StringBuilder localStringBuilder1 = new StringBuilder();
          localStringBuilder1.append("decode failed, exception: ");
          localStringBuilder1.append((String)paramList.get(i));
          QLog.i("JB", 4, localStringBuilder1.toString());
        }
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        localUnsupportedEncodingException.printStackTrace();
        if (QLog.isDevelopLevel())
        {
          StringBuilder localStringBuilder2 = new StringBuilder();
          localStringBuilder2.append("decode failed: ");
          localStringBuilder2.append((String)paramList.get(i));
          QLog.i("JB", 4, localStringBuilder2.toString());
        }
      }
      i += 1;
    }
    paramString1 = (JsBridge.JsHandler)this.a.get(paramString1);
    if (paramString1 != null)
    {
      paramString1.call(paramString2, paramList, paramJsBridgeListener);
      return;
    }
    if (paramJsBridgeListener != null) {
      paramJsBridgeListener.a();
    }
  }
  
  public boolean a(WebView paramWebView, String paramString)
  {
    if (paramString == null) {
      return false;
    }
    if (!paramString.startsWith("jsbridge://")) {
      return false;
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(paramString);
    ((StringBuilder)localObject1).append("/#");
    Object localObject2 = Arrays.asList(((StringBuilder)localObject1).toString().split("/"));
    if (((List)localObject2).size() < 6) {
      return false;
    }
    localObject1 = (String)((List)localObject2).get(2);
    String str = (String)((List)localObject2).get(3);
    Object localObject3 = (String)((List)localObject2).get(4);
    try
    {
      long l = Long.parseLong((String)localObject3);
      localObject2 = ((List)localObject2).subList(5, ((List)localObject2).size() - 1);
      if (QLog.isDevelopLevel())
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("calling ");
        ((StringBuilder)localObject3).append((String)localObject1);
        ((StringBuilder)localObject3).append(".");
        ((StringBuilder)localObject3).append(str);
        QLog.d("JB", 4, ((StringBuilder)localObject3).toString());
      }
      paramString = new JsBridge.JsBridgeListener(paramWebView, l, paramString);
      paramWebView = paramWebView.getUrl();
      if (this.b == null) {
        this.b = AuthorizeConfig.a();
      }
      localObject3 = this.b;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject1);
      localStringBuilder.append(".");
      localStringBuilder.append(str);
      if (((AuthorizeConfig)localObject3).a(paramWebView, localStringBuilder.toString()))
      {
        a((String)localObject1, str, (List)localObject2, paramString);
        return true;
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("JS API no auth url = ");
      ((StringBuilder)localObject2).append(Util.b(paramWebView, new String[0]));
      ((StringBuilder)localObject2).append(" objectName = ");
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(" methodName = ");
      ((StringBuilder)localObject2).append(str);
      QLog.e("JsBridge", 1, ((StringBuilder)localObject2).toString());
      paramString.b();
      return true;
    }
    catch (Exception paramWebView) {}
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.jsbridge.JsBridge
 * JD-Core Version:    0.7.0.1
 */