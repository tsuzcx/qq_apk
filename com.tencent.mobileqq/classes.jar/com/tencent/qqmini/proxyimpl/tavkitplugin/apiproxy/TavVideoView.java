package com.tencent.qqmini.proxyimpl.tavkitplugin.apiproxy;

import android.graphics.Rect;
import android.util.Log;
import android.view.MotionEvent;
import android.view.Surface;
import com.tencent.qqmini.proxyimpl.tavkitplugin.TavObjPool;
import com.tencent.qqmini.sdk.annotation.ProxyService;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.core.IJsService;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.proxy.ExternalElementProxy;
import com.tencent.qqmini.sdk.launcher.core.utils.ApiUtil;
import com.tencent.qqmini.sdk.launcher.utils.DisplayUtil;
import com.tencent.tav.decoder.logger.Logger;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

@ProxyService(proxy=ExternalElementProxy.class)
public class TavVideoView
  extends ExternalElementProxy
{
  private final String a;
  private Surface b;
  private int c;
  private int d;
  private TavPlayer e;
  
  public TavVideoView()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("WS_TavVideoView@");
    localStringBuilder.append(Integer.toHexString(hashCode()));
    this.a = localStringBuilder.toString();
    this.b = null;
    this.c = -1;
    this.d = -1;
  }
  
  private void a()
  {
    Object localObject1 = this.a;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("checkSurfaceCreated() called, player = ");
    ((StringBuilder)localObject2).append(this.e);
    ((StringBuilder)localObject2).append(", surface = ");
    ((StringBuilder)localObject2).append(this.b);
    ((StringBuilder)localObject2).append(", width&height = ");
    ((StringBuilder)localObject2).append(this.c);
    ((StringBuilder)localObject2).append("_");
    ((StringBuilder)localObject2).append(this.d);
    Logger.d((String)localObject1, ((StringBuilder)localObject2).toString());
    localObject1 = this.e;
    if (localObject1 != null)
    {
      localObject2 = this.b;
      if (localObject2 != null)
      {
        int i = this.c;
        if (i != -1)
        {
          int j = this.d;
          if (j == -1) {
            return;
          }
          ((TavPlayer)localObject1).a((Surface)localObject2, i, j);
        }
      }
    }
  }
  
  private void a(int paramInt, IJsService paramIJsService, String paramString)
  {
    String str = this.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("returnFail() called with: callbackId = [");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("], webview = [");
    localStringBuilder.append(paramIJsService);
    localStringBuilder.append("], msg = [");
    localStringBuilder.append(paramString);
    localStringBuilder.append("]");
    Logger.d(str, localStringBuilder.toString());
    paramIJsService.evaluateCallbackJs(paramInt, ApiUtil.wrapCallbackFail("operateXWebExternalElement", null, paramString).toString());
  }
  
  private void a(String paramString, int paramInt, IJsService paramIJsService)
  {
    String str = this.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("matchingGetObject() called with: type = [");
    localStringBuilder.append(paramString);
    localStringBuilder.append("], callbackId = [");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("], service = [");
    localStringBuilder.append(paramIJsService);
    localStringBuilder.append("]");
    Logger.d(str, localStringBuilder.toString());
    if (!"tav_getObject".equals(paramString))
    {
      a(paramInt, paramIJsService, "no match type");
      return;
    }
    paramIJsService.evaluateCallbackJs(paramInt, ApiUtil.wrapCallbackOk("operateXWebExternalElement", ObjConvector.a(this, TavObjPool.a().a(this))).toString());
  }
  
  private void b()
  {
    Object localObject = this.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("checkSurfaceDestroy() called, player = ");
    localStringBuilder.append(this.e);
    Logger.d((String)localObject, localStringBuilder.toString());
    localObject = this.e;
    if (localObject != null) {
      ((TavPlayer)localObject).b();
    }
    TavObjPool.a().c(this);
    localObject = this.b;
    if (localObject != null) {
      ((Surface)localObject).release();
    }
  }
  
  boolean a(TavPlayer paramTavPlayer)
  {
    Object localObject = this.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("attachPlayer() called with: player = [");
    localStringBuilder.append(paramTavPlayer);
    localStringBuilder.append("]");
    Logger.d((String)localObject, localStringBuilder.toString());
    localObject = this.e;
    if ((localObject != null) && (!localObject.equals(paramTavPlayer)))
    {
      Logger.w(this.a, "attachPlayer: this.player exits");
      return false;
    }
    this.e = paramTavPlayer;
    a();
    return true;
  }
  
  public void handleInsertXWebExternalElement(JSONObject paramJSONObject, long paramLong)
  {
    String str = this.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("handleInsertXWebExternalElement() called with: req = [");
    localStringBuilder.append(paramJSONObject);
    localStringBuilder.append("]");
    Logger.d(str, localStringBuilder.toString());
    if (paramJSONObject.has("position"))
    {
      paramJSONObject = paramJSONObject.optJSONObject("position");
      this.c = ((int)(DisplayUtil.getDensity(AppLoaderFactory.g().getContext()) * paramJSONObject.optInt("width", -1) + 0.5F));
      this.d = ((int)(DisplayUtil.getDensity(AppLoaderFactory.g().getContext()) * paramJSONObject.optInt("height", -1) + 0.5F));
      a();
    }
  }
  
  public void handleOperateExternalElement(JSONObject paramJSONObject, int paramInt, IJsService paramIJsService, long paramLong)
  {
    String str = this.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("handleOperateExternalElement() called with: req = [");
    localStringBuilder.append(paramJSONObject);
    localStringBuilder.append("], callbackId = [");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("]");
    Logger.d(str, localStringBuilder.toString());
    try
    {
      paramJSONObject = paramJSONObject.getJSONObject("data").getString("type");
      try
      {
        a(paramJSONObject, paramInt, paramIJsService);
        return;
      }
      catch (JSONException paramJSONObject)
      {
        Logger.e(this.a, "handleOperateExternalElement: ", paramJSONObject);
        a(paramInt, paramIJsService, "no match type");
        return;
      }
      return;
    }
    catch (Exception paramJSONObject)
    {
      Logger.e(this.a, "handleOperateExternalElement: ", paramJSONObject);
      a(paramInt, paramIJsService, "no match type");
    }
  }
  
  public void handleRemoveExternalElement(long paramLong)
  {
    Logger.d(this.a, "handleRemoveExternalElement() called");
  }
  
  public void handleUpdateExternalElement(JSONObject paramJSONObject, long paramLong)
  {
    String str = this.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("handleUpdateExternalElement() called with: req = [");
    localStringBuilder.append(paramJSONObject);
    localStringBuilder.append("]");
    Logger.d(str, localStringBuilder.toString());
  }
  
  public void nativeDestroy(long paramLong)
  {
    Logger.d(this.a, "nativeDestroy() called");
  }
  
  public void nativePause(long paramLong)
  {
    Logger.d(this.a, "nativePause() called");
  }
  
  public void nativeResume(long paramLong)
  {
    Logger.d(this.a, "nativeResume() called");
  }
  
  public void onActive(long paramLong)
  {
    Logger.d(this.a, "onActive() called");
  }
  
  public void onDeActive(long paramLong)
  {
    Log.d(this.a, "onDeactive() called");
  }
  
  public void onDestroy(long paramLong)
  {
    Logger.d(this.a, "onDestroy() called");
    b();
  }
  
  public void onInit(String paramString, Map<String, String> paramMap, long paramLong)
  {
    String str = this.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onInit() called with: tagName = [");
    localStringBuilder.append(paramString);
    localStringBuilder.append("], attributes = [");
    localStringBuilder.append(paramMap);
    localStringBuilder.append("]");
    Logger.d(str, localStringBuilder.toString());
  }
  
  public void onRectChanged(Rect paramRect, long paramLong)
  {
    String str = this.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onRectChanged() called with: rect = [");
    localStringBuilder.append(paramRect);
    localStringBuilder.append("]");
    Logger.d(str, localStringBuilder.toString());
  }
  
  public void onRequestRedraw(long paramLong)
  {
    Logger.d(this.a, "onRequestRedraw() called");
  }
  
  public void onSurfaceCreated(Surface paramSurface, long paramLong)
  {
    String str = this.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onSurfaceCreated() called with: surface = [");
    localStringBuilder.append(paramSurface);
    localStringBuilder.append("]");
    Logger.d(str, localStringBuilder.toString());
    this.b = paramSurface;
    a();
  }
  
  public void onSurfaceDestroyed(Surface paramSurface, long paramLong)
  {
    String str = this.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onSurfaceDestroyed() called with: surface = [");
    localStringBuilder.append(paramSurface);
    localStringBuilder.append("]");
    Logger.d(str, localStringBuilder.toString());
    b();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent, long paramLong)
  {
    String str = this.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onTouchEvent() called with: event = [");
    localStringBuilder.append(paramMotionEvent);
    localStringBuilder.append("]");
    Logger.d(str, localStringBuilder.toString());
    return false;
  }
  
  public void onVisibilityChanged(boolean paramBoolean, long paramLong)
  {
    Object localObject = this.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onVisibilityChanged() called with: visibility = [");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append("], player = ");
    localStringBuilder.append(this.e);
    Logger.d((String)localObject, localStringBuilder.toString());
    localObject = this.e;
    if ((localObject != null) && (!paramBoolean)) {
      ((TavPlayer)localObject).c();
    }
  }
  
  public void setCallBackWebView(IJsService paramIJsService, long paramLong)
  {
    String str = this.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setCallBackWebView() called with: callBackWebView = [");
    localStringBuilder.append(paramIJsService);
    localStringBuilder.append("], widgetId = [");
    localStringBuilder.append(paramLong);
    localStringBuilder.append("]");
    Logger.d(str, localStringBuilder.toString());
  }
  
  public void setCurPageWebViewId(int paramInt, long paramLong)
  {
    String str = this.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setCurPageWebViewId() called with: curPageWebViewId = [");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("], widgetId = [");
    localStringBuilder.append(paramLong);
    localStringBuilder.append("]");
    Logger.d(str, localStringBuilder.toString());
  }
  
  public void setMiniAppContext(IMiniAppContext paramIMiniAppContext, long paramLong)
  {
    String str = this.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setMiniAppContext() called with: miniAppContext = [");
    localStringBuilder.append(paramIMiniAppContext);
    localStringBuilder.append("], widgetId = [");
    localStringBuilder.append(paramLong);
    localStringBuilder.append("]");
    Logger.d(str, localStringBuilder.toString());
  }
  
  public void webViewDestroy(long paramLong)
  {
    Logger.d(this.a, "webViewDestroy() called");
  }
  
  public void webViewPause(long paramLong)
  {
    Logger.d(this.a, "webViewPause() called");
  }
  
  public void webViewResume(long paramLong)
  {
    Logger.d(this.a, "webViewResume() called");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.tavkitplugin.apiproxy.TavVideoView
 * JD-Core Version:    0.7.0.1
 */