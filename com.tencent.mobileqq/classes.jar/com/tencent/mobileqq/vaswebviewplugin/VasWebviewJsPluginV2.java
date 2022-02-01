package com.tencent.mobileqq.vaswebviewplugin;

import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Method;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.os.MqqHandler;
import org.json.JSONObject;

public abstract class VasWebviewJsPluginV2
  extends VasWebviewJsPlugin
{
  private static final String TAG = "VasWebviewJsPluginV2";
  protected static final int THREADMODE_DEFAULT = 0;
  protected static final int THREADMODE_FILE = 2;
  protected static final int THREADMODE_UI = 1;
  private Map<String, VasWebviewJsPluginV2.SubscriberMethod> mMethodCache = null;
  
  public VasWebviewJsPluginV2(String paramString)
  {
    this.mPluginNameSpace = paramString;
  }
  
  private List<VasWebviewJsPluginV2.SubscriberMethod> findJSBMethod(Class<?> paramClass)
  {
    ArrayList localArrayList = new ArrayList();
    paramClass = paramClass.getDeclaredMethods();
    int j = paramClass.length;
    int i = 0;
    while (i < j)
    {
      Object localObject1 = paramClass[i];
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("method : ");
        ((StringBuilder)localObject2).append(((Method)localObject1).toString());
        QLog.e("VasWebviewJsPluginV2", 1, ((StringBuilder)localObject2).toString());
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("annotations : ");
        ((StringBuilder)localObject2).append(Arrays.toString(((Method)localObject1).getAnnotations()));
        QLog.e("VasWebviewJsPluginV2", 1, ((StringBuilder)localObject2).toString());
      }
      Object localObject2 = (VasWebviewJsPluginV2.JsbridgeSubscribe)((Method)localObject1).getAnnotation(VasWebviewJsPluginV2.JsbridgeSubscribe.class);
      if ((localObject2 != null) && (!TextUtils.isEmpty(((VasWebviewJsPluginV2.JsbridgeSubscribe)localObject2).method())))
      {
        localObject1 = new VasWebviewJsPluginV2.SubscriberMethod((Method)localObject1, ((VasWebviewJsPluginV2.JsbridgeSubscribe)localObject2).method(), ((VasWebviewJsPluginV2.JsbridgeSubscribe)localObject2).threadMode(), ((VasWebviewJsPluginV2.JsbridgeSubscribe)localObject2).args());
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("register : ");
          ((StringBuilder)localObject2).append(((VasWebviewJsPluginV2.SubscriberMethod)localObject1).toString());
          QLog.e("VasWebviewJsPluginV2", 1, ((StringBuilder)localObject2).toString());
        }
        localArrayList.add(localObject1);
      }
      i += 1;
    }
    return localArrayList;
  }
  
  protected final boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("handleJsRequest, url=");
      ((StringBuilder)localObject1).append(paramString1);
      ((StringBuilder)localObject1).append(", nameSpace=");
      ((StringBuilder)localObject1).append(paramString2);
      ((StringBuilder)localObject1).append(", method=");
      ((StringBuilder)localObject1).append(paramString3);
      QLog.d("VasWebviewJsPluginV2", 2, ((StringBuilder)localObject1).toString());
    }
    if ((paramString1 != null) && (this.mPluginNameSpace.equals(paramString2)))
    {
      if (paramString3 == null) {
        return false;
      }
      localObject1 = WebViewPlugin.getJsonFromJSBridge(paramString1);
      paramString2 = (String)localObject1;
      if (localObject1 == null)
      {
        int i = paramString1.indexOf("#");
        if (i != -1)
        {
          i += 1;
          if (i > paramString1.length() - 1) {
            return true;
          }
          try
          {
            localObject1 = URLDecoder.decode(paramString1.substring(i), "UTF-8");
            paramString2 = new JSONObject();
            paramString2.put("callback", localObject1);
          }
          catch (Exception paramJsBridgeListener)
          {
            paramString2 = new StringBuilder();
            paramString2.append("getJsonFromJSBridge error!");
            paramString2.append(paramString1);
            QLog.e("WebViewPlugin", 1, paramString2.toString(), paramJsBridgeListener);
          }
        }
        else
        {
          return true;
        }
      }
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("handleJsRequest JSON = ");
        ((StringBuilder)localObject1).append(paramString2.toString());
        QLog.d("VasWebviewJsPluginV2", 2, ((StringBuilder)localObject1).toString());
      }
      localObject1 = paramString2.optString("callback");
      if (this.mMethodCache == null)
      {
        Object localObject2 = findJSBMethod(getClass());
        try
        {
          if (this.mMethodCache == null)
          {
            this.mMethodCache = new HashMap(((List)localObject2).size() * 2);
            localObject2 = ((List)localObject2).iterator();
            while (((Iterator)localObject2).hasNext())
            {
              VasWebviewJsPluginV2.SubscriberMethod localSubscriberMethod = (VasWebviewJsPluginV2.SubscriberMethod)((Iterator)localObject2).next();
              this.mMethodCache.put(localSubscriberMethod.scheme, localSubscriberMethod);
            }
          }
        }
        finally {}
      }
      paramString3 = (VasWebviewJsPluginV2.SubscriberMethod)this.mMethodCache.get(paramString3);
      if (paramString3 != null)
      {
        paramJsBridgeListener = paramString3.buildSafeRunnable(this, new VasWebviewJsPluginV2.JsData((String)localObject1, paramJsBridgeListener, paramString1, paramVarArgs), paramString2);
        if (paramString3.threadMode == 0)
        {
          paramJsBridgeListener.run();
          return true;
        }
        if (paramString3.threadMode == 1)
        {
          ThreadManager.getUIHandler().post(paramJsBridgeListener);
          return true;
        }
        if (paramString3.threadMode == 2) {
          ThreadManager.getFileThreadHandler().post(paramJsBridgeListener);
        }
        return true;
      }
      QLog.e("VasWebviewJsPluginV2", 1, "not find jsbridge");
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.VasWebviewJsPluginV2
 * JD-Core Version:    0.7.0.1
 */