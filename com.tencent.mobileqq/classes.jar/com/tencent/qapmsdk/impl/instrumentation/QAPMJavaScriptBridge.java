package com.tencent.qapmsdk.impl.instrumentation;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.res.AssetManager;
import android.support.annotation.RequiresApi;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.tencent.qapmsdk.athena.BreadCrumb;
import com.tencent.qapmsdk.athena.BreadCrumbConfig;
import com.tencent.qapmsdk.athena.eventcon.core.EventCon;
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
    if (javaScriptBridge == null) {
      try
      {
        if (javaScriptBridge == null) {
          javaScriptBridge = new QAPMJavaScriptBridge();
        }
      }
      finally {}
    }
    return javaScriptBridge;
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
      StringBuilder localStringBuilder = new StringBuilder();
      str1 = str2;
      localStringBuilder.append("javascript:");
      str1 = str2;
      localStringBuilder.append(FileUtil.readStream(localInputStream, 8192));
      str1 = str2;
      str2 = localStringBuilder.toString();
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
        Object localObject1;
        Object localObject2;
        if (AndroidVersion.isKitKat())
        {
          if (TextUtils.isEmpty(this.js)) {
            this.js = getLocalJs();
          }
          boolean bool = paramObject instanceof WebView;
          if (bool)
          {
            ((WebView)paramObject).getSettings().setDomStorageEnabled(true);
            WebViewX5Proxy.getInstance().setCodeTypeIsX5(false);
            paramObject = (WebView)paramObject;
            paramObject.evaluateJavascript(this.js, null);
            paramObject.evaluateJavascript("javascript:window.QAPM.qapmJsStart()", null);
            return;
          }
          localObject1 = WebViewX5Proxy.getInstance().getX5EvaluateJavascript();
          localObject2 = WebViewX5Proxy.getInstance().getX5GetSettingst();
          Method localMethod = WebViewX5Proxy.getInstance().getX5SetDomStorageEnabled();
          if ((localObject2 != null) && (localMethod != null)) {
            localMethod.invoke(((Method)localObject2).invoke(paramObject, new Object[0]), new Object[] { Boolean.valueOf(true) });
          }
          if (localObject1 != null) {
            try
            {
              WebViewX5Proxy.getInstance().setCodeTypeIsX5(true);
              ((Method)localObject1).invoke(paramObject, new Object[] { this.js, null });
              ((Method)localObject1).invoke(paramObject, new Object[] { "javascript:window.QAPM.qapmJsStart()", null });
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
        localObject1 = Logger.INSTANCE;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("injection js may be error, ");
        ((StringBuilder)localObject2).append(paramObject.getMessage());
        ((Logger)localObject1).w(new String[] { "QAPM_instrumentation_QAPMJavaScriptBridge", ((StringBuilder)localObject2).toString() });
      }
    }
  }
  
  @JavascriptInterface
  public String getAppkey()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(BaseInfo.userMeta.appKey);
    localStringBuilder.append("-");
    localStringBuilder.append(BaseInfo.userMeta.appId);
    return localStringBuilder.toString();
  }
  
  @JavascriptInterface
  public String getAthenaUrl()
  {
    return BaseInfo.urlMeta.athenaDomain;
  }
  
  @JavascriptInterface
  public String getBreadCrumbBuckets()
  {
    return EventCon.getInstance().getBucketInfo();
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
  public int getBreadCrumbUploadInterval()
  {
    return BreadCrumbConfig.UPLOAD_MIN_INTERVAL;
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
  public String getVersion()
  {
    return BaseInfo.userMeta.version;
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
    boolean bool2 = this.loadMap.keySet().contains(Integer.valueOf(i));
    if (paramInt >= 100)
    {
      if (!bool2) {
        injection(paramObject);
      }
      this.loadMap.put(Integer.valueOf(i), Boolean.valueOf(true));
      return;
    }
    boolean bool1 = bool2;
    if (bool2)
    {
      bool1 = bool2;
      if (((Boolean)this.loadMap.get(Integer.valueOf(i))).booleanValue())
      {
        this.loadMap.remove(Integer.valueOf(i));
        bool1 = false;
      }
    }
    if ((!bool1) && (paramInt > 30))
    {
      this.loadMap.put(Integer.valueOf(i), Boolean.valueOf(false));
      injection(paramObject);
    }
  }
  
  @JavascriptInterface
  public void setBreadCrumbId(String paramString)
  {
    this.breadCrumbId = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qapmsdk.impl.instrumentation.QAPMJavaScriptBridge
 * JD-Core Version:    0.7.0.1
 */