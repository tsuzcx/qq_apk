package com.tencent.qqmini.flutter.core;

import com.tencent.qqmini.miniapp.core.BaseAppBrandRuntime;
import com.tencent.qqmini.miniapp.core.EventListener;
import com.tencent.qqmini.miniapp.core.page.IAppBrandPageContainer;
import com.tencent.qqmini.miniapp.core.service.IAppBrandService;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent.Builder;
import com.tencent.qqmini.sdk.launcher.core.utils.ApiUtil;
import com.tencent.qqmini.sdk.launcher.core.utils.AppBrandTask;
import com.tencent.qqmini.v8rt.engine.SpeedUtil;
import org.json.JSONObject;

public class NativeEventListener
  extends EventListener
{
  public NativeEventListener(NativeAppBrandRuntime paramNativeAppBrandRuntime)
  {
    super(paramNativeAppBrandRuntime);
    this.mRuntime = paramNativeAppBrandRuntime;
  }
  
  public String interruptOnServiceNativeRequest(String paramString1, String paramString2, int paramInt)
  {
    IAppBrandService localIAppBrandService = (IAppBrandService)this.mRuntime.getJsService();
    IAppBrandPageContainer localIAppBrandPageContainer = (IAppBrandPageContainer)this.mRuntime.getPage();
    if (((this.mRuntime instanceof NativeAppBrandRuntime)) && ("operateVideoPlayer".equals(paramString1)))
    {
      AppBrandTask.runTaskOnUiThread(new NativeEventListener.1(this, localIAppBrandPageContainer, paramString1, paramString2, new RequestEvent.Builder().setEvent(paramString1).setJsonParams(paramString2).setCallbackId(paramInt).setJsService(localIAppBrandService).build()));
      return ApiUtil.wrapCallbackOk(paramString1, null).toString();
    }
    return null;
  }
  
  public void onAppRoute(String paramString1, String paramString2, int paramInt)
  {
    SpeedUtil localSpeedUtil = SpeedUtil.DEFAULT;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onAppRoute ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" ");
    localStringBuilder.append(paramString2);
    localSpeedUtil.event(localStringBuilder.toString());
    super.onAppRoute(paramString1, paramString2, paramInt);
  }
  
  public String onServiceNativeRequest(String paramString1, String paramString2, int paramInt)
  {
    if ("initWeixinJSBridgeFinish".equals(paramString1)) {
      SpeedUtil.DEFAULT.event("initWeixinJSBridge finished");
    }
    return super.onServiceNativeRequest(paramString1, paramString2, paramInt);
  }
  
  public void onWebViewEvent(String paramString1, String paramString2, int paramInt)
  {
    if (paramString1.contains("GenerateFuncReady"))
    {
      SpeedUtil.DEFAULT.event("GenerateFuncReady");
    }
    else if ((paramString2 != null) && (paramString2.contains("__DOMReady")))
    {
      SpeedUtil.DEFAULT.event("domReady");
      SpeedUtil.DEFAULT.report(new String[0]);
      SpeedUtil.DEFAULT.clear();
    }
    super.onWebViewEvent(paramString1, paramString2, paramInt);
  }
  
  public void onWebViewReady(String paramString1, String paramString2, int paramInt)
  {
    SpeedUtil localSpeedUtil = SpeedUtil.DEFAULT;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onWebViewReady ");
    localStringBuilder.append(paramInt);
    localSpeedUtil.event(localStringBuilder.toString());
    super.onWebViewReady(paramString1, paramString2, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.flutter.core.NativeEventListener
 * JD-Core Version:    0.7.0.1
 */