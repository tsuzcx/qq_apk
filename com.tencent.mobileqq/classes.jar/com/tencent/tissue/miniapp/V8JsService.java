package com.tencent.tissue.miniapp;

import android.content.Context;
import android.text.TextUtils;
import bekp;
import belh;
import com.tencent.qqmini.sdk.core.manager.BaselibLoader;
import com.tencent.qqmini.sdk.core.service.AbsAppBrandService;
import com.tencent.qqmini.sdk.core.service.ServiceEventListener;
import com.tencent.smtt.sdk.ValueCallback;
import com.tencent.tissue.v8rt.engine.Engine;
import com.tencent.tissue.v8rt.engine.Logger;
import com.tencent.tissue.v8rt.engine.ServiceEventHandlerProvider;
import com.tencent.tissue.v8rt.engine.V8JsContext;
import com.tencent.tissue.v8rt.engine.V8JsRuntime;
import java.io.File;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

public class V8JsService
  extends AbsAppBrandService
{
  public static final String TAG = "V8ServiceRuntime";
  private Context context;
  private Engine engine;
  private V8JsRuntime jsRuntime;
  
  static
  {
    Logger.init(new V8LogImpl());
  }
  
  public V8JsService(Context paramContext)
  {
    this.engine = Engine.getInstance().initEngine(paramContext);
    this.context = paramContext;
    if (this.engine.getStatus() == 0) {
      try
      {
        this.jsRuntime = this.engine.createJsRuntime();
        this.jsRuntime.getDefaultContext().injectAll();
        sendEvent(Integer.valueOf(3));
        Logger.i("TV8ENG", "create jsruntime success " + this.jsRuntime);
        return;
      }
      finally {}
    }
    Logger.e("TV8ENG", "create jsruntime failed, engine status:" + this.engine.getStatus());
  }
  
  public void evaluateCallbackJs(int paramInt, String paramString)
  {
    if (this.jsRuntime != null)
    {
      Logger.d("V8ServiceRuntime", "evaluateCallbackJs  callbackId=" + paramInt + ",result=" + paramString);
      evaluateJs(String.format("WeixinJSBridge.invokeCallbackHandler(%d, %s)", new Object[] { Integer.valueOf(paramInt), paramString }), null);
      return;
    }
    Logger.e("V8ServiceRuntime", "evaluateCallbackJs failed jsRuntime null");
  }
  
  public void evaluateJs(String paramString, ValueCallback paramValueCallback)
  {
    evaluateJs(paramString, paramValueCallback, null);
  }
  
  public void evaluateJs(String paramString1, ValueCallback paramValueCallback, String paramString2)
  {
    if ((!TextUtils.isEmpty(paramString2)) && (paramString2.endsWith("QLogic.js"))) {
      if (paramString2.startsWith("assets://"))
      {
        localObject = new File(paramString2.substring("assets://".length()));
        localObject = new File(this.context.getCacheDir().getPath() + File.separator + "cc_assets" + File.separator + ((File)localObject).getParentFile().getPath());
        ((File)localObject).mkdirs();
        if ((!((File)localObject).exists()) || (!((File)localObject).isDirectory())) {
          break label323;
        }
        paramString2 = new File(paramString2).getName();
        localObject = new File((File)localObject, paramString2);
      }
    }
    for (Object localObject = ((File)localObject).getAbsolutePath() + ".cc";; localObject = null)
    {
      if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!TextUtils.isEmpty((CharSequence)localObject))) {}
      for (int i = 1;; i = 0)
      {
        if (this.jsRuntime != null)
        {
          if (paramValueCallback != null) {
            break label273;
          }
          if (i == 0) {
            break label260;
          }
          this.jsRuntime.getDefaultContext().evaluateJsAsyncWithCodeCache(paramString1, new V8JsService.1(this), paramString2, (String)localObject);
        }
        return;
        localObject = new File(paramString2).getParentFile();
        ((File)localObject).mkdirs();
        break;
      }
      label260:
      this.jsRuntime.getDefaultContext().evaluateJsAsync(paramString1, null);
      return;
      label273:
      if (i != 0)
      {
        this.jsRuntime.getDefaultContext().evaluateJsAsyncWithCodeCache(paramString1, new V8JsService.2(this, paramValueCallback), paramString2, (String)localObject);
        return;
      }
      this.jsRuntime.getDefaultContext().evaluateJsAsyncWithReturn(paramString1, new V8JsService.3(this, paramValueCallback));
      return;
      label323:
      paramString2 = null;
    }
  }
  
  public void evaluateSubscribeJS(String paramString1, String paramString2, int paramInt)
  {
    paramString1 = "WeixinJSBridge.subscribeHandler(\"" + paramString1 + "\"," + paramString2 + "," + paramInt + "," + 0 + ")";
    Logger.d("V8ServiceRuntime", "evaluateSubscribeJS: " + paramString1);
    if (this.jsRuntime != null)
    {
      this.jsRuntime.getDefaultContext().evaluateJsSync(paramString1);
      return;
    }
    Logger.e("V8ServiceRuntime", "evaluateSubscribeJS failed jsRuntime null");
  }
  
  public String getJSGlobalConfig(bekp parambekp)
  {
    if (parambekp == null) {
      return "";
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("appId", parambekp.d);
      localJSONObject.put("icon", parambekp.e);
      localJSONObject.put("nickname", "testuser");
      parambekp = String.format("if (typeof __qqConfig === 'undefined') var __qqConfig = {};var __tempConfig=%1$s; Object.assign(__qqConfig, __tempConfig); __qqConfig.accountInfo=JSON.parse('%2$s'); __qqConfig.QUA='V1_AND_SQ_8.1.3_0_RDM_B';", new Object[] { parambekp.b, localJSONObject.toString() });
      return parambekp + "if (typeof WeixinJSBridge != 'undefined' && typeof WeixinJSBridge.subscribeHandler == 'function') {WeixinJSBridge.subscribeHandler('onWxConfigReady')};";
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
  }
  
  public String getJsDefaultConfig(boolean paramBoolean)
  {
    try
    {
      Object localObject = new JSONObject();
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("USER_DATA_PATH", "qqfile://usr");
      ((JSONObject)localObject).put("env", localJSONObject);
      ((JSONObject)localObject).put("preload", paramBoolean);
      localObject = String.format("if (typeof __qqConfig === 'undefined') var __qqConfig = {};var __tempConfig = %1$s; Object.assign(__qqConfig, __tempConfig); ", new Object[] { localObject });
      return localObject;
    }
    catch (Exception localException)
    {
      Logger.e("V8ServiceRuntime", "getJsDefaultConfig failed: " + localException);
    }
    return "";
  }
  
  public int getStatus()
  {
    return this.engine.getStatus();
  }
  
  public void initBaseJs()
  {
    setDefaultConfigJs(getJsDefaultConfig(true));
    setWaServiceJS(BaselibLoader.g().getWaServiceJs(), BaselibLoader.g().getWaServicePath());
  }
  
  public void release()
  {
    if (this.jsRuntime != null)
    {
      this.jsRuntime.release();
      ServiceEventHandlerProvider.getInstance().removeServiceEventHandler(this.jsRuntime);
    }
  }
  
  public void setApkgInfo(bekp parambekp)
  {
    if (parambekp == null) {
      return;
    }
    setGlobalConfigJs(getJSGlobalConfig(parambekp));
    String str = "";
    try
    {
      parambekp = belh.b(new File(parambekp.a()));
      setAppServiceJs(parambekp);
      return;
    }
    catch (IOException parambekp)
    {
      for (;;)
      {
        parambekp.printStackTrace();
        parambekp = str;
      }
    }
  }
  
  public void setAppBrandEventInterface(ServiceEventListener paramServiceEventListener)
  {
    ServiceEventHandlerProvider.getInstance().setServiceEventHandler(this.jsRuntime, new V8JsService.4(this, paramServiceEventListener));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.tissue.miniapp.V8JsService
 * JD-Core Version:    0.7.0.1
 */