package com.tencent.mobileqq.vaswebviewplugin;

import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Method;
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
  private Map<String, VasWebviewJsPluginV2.SubscriberMethod> mMethodCache;
  
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
      Object localObject = paramClass[i];
      if (QLog.isColorLevel())
      {
        QLog.e("VasWebviewJsPluginV2", 1, "method : " + ((Method)localObject).toString());
        QLog.e("VasWebviewJsPluginV2", 1, "annotations : " + Arrays.toString(((Method)localObject).getAnnotations()));
      }
      VasWebviewJsPluginV2.JsbridgeSubscribe localJsbridgeSubscribe = (VasWebviewJsPluginV2.JsbridgeSubscribe)((Method)localObject).getAnnotation(VasWebviewJsPluginV2.JsbridgeSubscribe.class);
      if ((localJsbridgeSubscribe != null) && (!TextUtils.isEmpty(localJsbridgeSubscribe.method())))
      {
        localObject = new VasWebviewJsPluginV2.SubscriberMethod((Method)localObject, localJsbridgeSubscribe.method(), localJsbridgeSubscribe.threadMode(), localJsbridgeSubscribe.args());
        if (QLog.isColorLevel()) {
          QLog.e("VasWebviewJsPluginV2", 1, "register : " + ((VasWebviewJsPluginV2.SubscriberMethod)localObject).toString());
        }
        localArrayList.add(localObject);
      }
      i += 1;
    }
    return localArrayList;
  }
  
  public final boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VasWebviewJsPluginV2", 2, "handleJsRequest, url=" + paramString1 + ", nameSpace=" + paramString2 + ", method=" + paramString3);
    }
    if ((paramString1 == null) || (!this.mPluginNameSpace.equals(paramString2)) || (paramString3 == null)) {
      return false;
    }
    paramString2 = WebViewPlugin.getJsonFromJSBridge(paramString1);
    if (paramString2 == null) {
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("VasWebviewJsPluginV2", 2, "handleJsRequest JSON = " + paramString2.toString());
    }
    String str = paramString2.optString("callback");
    if (this.mMethodCache == null)
    {
      Object localObject = findJSBMethod(getClass());
      try
      {
        if (this.mMethodCache == null)
        {
          this.mMethodCache = new HashMap(((List)localObject).size() * 2);
          localObject = ((List)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            VasWebviewJsPluginV2.SubscriberMethod localSubscriberMethod = (VasWebviewJsPluginV2.SubscriberMethod)((Iterator)localObject).next();
            this.mMethodCache.put(localSubscriberMethod.scheme, localSubscriberMethod);
          }
        }
      }
      finally {}
    }
    paramString3 = (VasWebviewJsPluginV2.SubscriberMethod)this.mMethodCache.get(paramString3);
    if (paramString3 != null)
    {
      paramJsBridgeListener = paramString3.buildSafeRunnable(this, new VasWebviewJsPluginV2.JsData(str, paramJsBridgeListener, paramString1, paramVarArgs), paramString2);
      if (paramString3.threadMode == 0) {
        paramJsBridgeListener.run();
      }
      for (;;)
      {
        return true;
        if (paramString3.threadMode == 1) {
          ThreadManager.getUIHandler().post(paramJsBridgeListener);
        } else if (paramString3.threadMode == 2) {
          ThreadManager.getFileThreadHandler().post(paramJsBridgeListener);
        }
      }
    }
    QLog.e("VasWebviewJsPluginV2", 1, "not find jsbridge");
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.VasWebviewJsPluginV2
 * JD-Core Version:    0.7.0.1
 */