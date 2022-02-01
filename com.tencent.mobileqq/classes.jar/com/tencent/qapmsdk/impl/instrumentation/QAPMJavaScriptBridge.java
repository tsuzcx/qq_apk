package com.tencent.qapmsdk.impl.instrumentation;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.res.AssetManager;
import android.support.annotation.RequiresApi;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import com.tencent.qapmsdk.athena.BreadCrumb;
import com.tencent.qapmsdk.base.meta.BaseInfo;
import com.tencent.qapmsdk.base.meta.UrlMeta;
import com.tencent.qapmsdk.base.meta.UserMeta;
import com.tencent.qapmsdk.common.logger.Logger;
import com.tencent.qapmsdk.common.util.AndroidVersion;
import com.tencent.qapmsdk.common.util.FileUtil;
import com.tencent.qapmsdk.jserror.JsError;
import com.tencent.qapmsdk.webview.WebViewX5Proxy;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Set;

public class QAPMJavaScriptBridge
{
  private static final String TAG = "QAPM_instrumentation_QAPMJavaScriptBridge";
  private static volatile QAPMJavaScriptBridge javaScriptBridge;
  private String breadCrumbId = "";
  private String js = getLocalJs();
  private HashMap<Integer, Boolean> loadMap = new HashMap();
  
  public static QAPMJavaScriptBridge getInstance()
  {
    if (javaScriptBridge == null) {}
    try
    {
      if (javaScriptBridge == null) {
        javaScriptBridge = new QAPMJavaScriptBridge();
      }
      return javaScriptBridge;
    }
    finally {}
  }
  
  private String getLocalJs()
  {
    String str2 = "";
    String str1 = str2;
    try
    {
      if (BaseInfo.app == null) {
        return "";
      }
      str1 = str2;
      InputStream localInputStream = BaseInfo.app.getAssets().open("qapm-monitor.js");
      str1 = str2;
      str2 = "javascript:" + FileUtil.readStream(localInputStream, 8192);
      str1 = str2;
      localInputStream.close();
      return str2;
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
    }
    return str1;
  }
  
  private void injection(Object paramObject)
  {
    if (paramObject != null) {
      try
      {
        if (AndroidVersion.isKitKat())
        {
          if (TextUtils.isEmpty(this.js)) {
            this.js = getLocalJs();
          }
          if ((paramObject instanceof WebView))
          {
            WebViewX5Proxy.getInstance().setCodeTypeIsX5(false);
            paramObject = (WebView)paramObject;
            paramObject.evaluateJavascript(this.js, null);
            paramObject.evaluateJavascript("javascript:window.QAPM.qapmJsStart()", null);
            return;
          }
          Method localMethod = WebViewX5Proxy.getInstance().getX5EvaluateJavascript();
          if (localMethod != null) {
            try
            {
              WebViewX5Proxy.getInstance().setCodeTypeIsX5(true);
              localMethod.invoke(paramObject, new Object[] { this.js, null });
              localMethod.invoke(paramObject, new Object[] { "javascript:window.QAPM.qapmJsStart()", null });
              return;
            }
            catch (Exception paramObject)
            {
              Logger.INSTANCE.exception("QAPM_instrumentation_QAPMJavaScriptBridge", "invoke webview injection error:", paramObject);
              return;
            }
          }
        }
        return;
      }
      catch (Exception paramObject)
      {
        Logger.INSTANCE.w(new String[] { "QAPM_instrumentation_QAPMJavaScriptBridge", "injection js may be error, " + paramObject.getMessage() });
      }
    }
  }
  
  @JavascriptInterface
  public String getAppkey()
  {
    return BaseInfo.userMeta.appKey + "-" + BaseInfo.userMeta.appId;
  }
  
  @JavascriptInterface
  public String getAthenaUrl()
  {
    return BaseInfo.urlMeta.athenaDomain;
  }
  
  @JavascriptInterface
  public boolean getBreadCrumbEnable()
  {
    return BreadCrumb.getInstance().isEnable();
  }
  
  public String getBreadCrumbId()
  {
    return this.breadCrumbId;
  }
  
  @JavascriptInterface
  public String getDeviceId()
  {
    return BaseInfo.userMeta.deviceId;
  }
  
  @JavascriptInterface
  public boolean getJsErrorEnable()
  {
    return JsError.jsErrorEnable();
  }
  
  @JavascriptInterface
  public String getQAPMUrl()
  {
    return BaseInfo.urlMeta.qapmDomain;
  }
  
  @JavascriptInterface
  public String getUin()
  {
    return BaseInfo.userMeta.uin;
  }
  
  @JavascriptInterface
  public boolean getWebMonitorEnable()
  {
    return WebViewX5Proxy.getInstance().canWebMonitorEnable();
  }
  
  @RequiresApi(api=19)
  public void initFileJS(Object paramObject, int paramInt)
  {
    int i = paramObject.hashCode();
    boolean bool = this.loadMap.keySet().contains(Integer.valueOf(i));
    if (paramInt >= 100)
    {
      if (!bool) {
        injection(paramObject);
      }
      this.loadMap.put(Integer.valueOf(i), Boolean.valueOf(true));
    }
    for (;;)
    {
      return;
      if ((bool) && (((Boolean)this.loadMap.get(Integer.valueOf(i))).booleanValue()))
      {
        this.loadMap.remove(Integer.valueOf(i));
        bool = false;
      }
      while ((!bool) && (paramInt > 30))
      {
        this.loadMap.put(Integer.valueOf(i), Boolean.valueOf(false));
        injection(paramObject);
        return;
      }
    }
  }
  
  @JavascriptInterface
  public void setBreadCrumbId(String paramString)
  {
    this.breadCrumbId = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qapmsdk.impl.instrumentation.QAPMJavaScriptBridge
 * JD-Core Version:    0.7.0.1
 */