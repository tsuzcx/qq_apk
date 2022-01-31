package com.tencent.mobileqq.vaswebviewplugin;

import android.app.Activity;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.JsWebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.open.appcommon.js.BaseInterface;
import com.tencent.open.appcommon.js.BaseJsCallBack;
import com.tencent.open.wadl.WLog;
import com.tencent.open.wadl.WadlJsBridge;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class WadlWebViewJsPlugin
  extends JsWebViewPlugin
{
  public static final String PLUGIN_NAMESPACE = "wadl_download";
  public static final String Tag = "WadlWebViewJsPlugin";
  private Map apiMap;
  
  private void initMap()
  {
    this.apiMap = new HashMap();
    Object localObject = this.mRuntime.a();
    new BaseJsCallBack((Activity)localObject);
    localObject = new WadlJsBridge((Activity)localObject, this.mRuntime.a());
    this.apiMap.put(((BaseInterface)localObject).getInterfaceName(), localObject);
  }
  
  protected Method getJsMethod(String paramString1, String paramString2, int paramInt)
  {
    paramString1 = (BaseInterface)this.apiMap.get(paramString1);
    if (paramString1 != null)
    {
      paramString1 = paramString1.getClass().getDeclaredMethods();
      int j = paramString1.length;
      int i = 0;
      while (i < j)
      {
        Method localMethod = paramString1[i];
        if ((localMethod.getName().equals(paramString2)) && (localMethod.getParameterTypes().length == paramInt)) {
          return localMethod;
        }
        i += 1;
      }
    }
    return null;
  }
  
  protected String getNameSpace()
  {
    return "wadl_download";
  }
  
  protected boolean handleEvent(String paramString, long paramLong, Map paramMap)
  {
    if (paramLong == 8589934593L) {}
    return false;
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    String str = null;
    paramString1 = null;
    if (this.apiMap == null) {
      initMap();
    }
    BaseInterface localBaseInterface = (BaseInterface)this.apiMap.get(paramString2);
    int i;
    if (localBaseInterface != null)
    {
      WLog.b(this.TAG, "handleJsRequest pkgName=" + paramString2 + ",methodName=" + paramString3);
      Method[] arrayOfMethod = localBaseInterface.getClass().getDeclaredMethods();
      int j = arrayOfMethod.length;
      i = 0;
      str = paramString1;
      if (i < j)
      {
        paramString2 = arrayOfMethod[i];
        if ((!paramString2.getName().equals(paramString3)) || (paramString2.getParameterTypes().length != paramVarArgs.length)) {
          break label222;
        }
        paramString1 = paramString2;
      }
    }
    label222:
    for (;;)
    {
      i += 1;
      break;
      if (str != null) {
        try
        {
          if (paramVarArgs.length == 0) {}
          for (paramString1 = str.invoke(localBaseInterface, new Object[0]);; paramString1 = str.invoke(localBaseInterface, paramVarArgs))
          {
            paramString2 = str.getReturnType();
            if ((paramString2 != Void.TYPE) && (paramString2 != Void.class)) {
              break;
            }
            if (paramJsBridgeListener == null) {
              break label225;
            }
            paramJsBridgeListener.a(null);
            break label225;
          }
          if (paramJsBridgeListener == null) {
            break label225;
          }
          paramJsBridgeListener.a(paramString1);
        }
        catch (Exception paramJsBridgeListener) {}
      }
      return false;
    }
    label225:
    return true;
  }
  
  public void onAppRuntimeReady(AppInterface paramAppInterface) {}
  
  protected void onCreate() {}
  
  protected void onDestroy()
  {
    if (this.apiMap == null) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.apiMap.entrySet().iterator();
      while (localIterator.hasNext()) {
        try
        {
          ((BaseInterface)((Map.Entry)localIterator.next()).getValue()).destroy();
        }
        catch (Exception localException) {}
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\b.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.WadlWebViewJsPlugin
 * JD-Core Version:    0.7.0.1
 */