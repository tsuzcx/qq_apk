package com.tencent.qqmini.proxyimpl;

import android.graphics.Rect;
import android.util.Log;
import android.view.MotionEvent;
import android.view.Surface;
import com.tencent.qqmini.proxyimpl.tavkitplugin.apiproxy.TavVideoView;
import com.tencent.qqmini.sdk.annotation.ProxyService;
import com.tencent.qqmini.sdk.launcher.core.IJsService;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.proxy.ExternalElementProxy;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

@ProxyService(proxy=ExternalElementProxy.class)
public class ExternalElementProxyImpl
  extends ExternalElementProxy
{
  private Map<Long, ExternalElementProxy> a = new HashMap();
  
  public void handleInsertXWebExternalElement(JSONObject paramJSONObject, long paramLong)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("handleInsertXWebExternalElement() called with: jsonObject = [");
    ((StringBuilder)localObject).append(paramJSONObject);
    ((StringBuilder)localObject).append("], widgetId = [");
    ((StringBuilder)localObject).append(paramLong);
    ((StringBuilder)localObject).append("]");
    Log.d("ExternalElementProxyImp", ((StringBuilder)localObject).toString());
    localObject = (ExternalElementProxy)this.a.get(Long.valueOf(paramLong));
    if (localObject != null) {
      ((ExternalElementProxy)localObject).handleInsertXWebExternalElement(paramJSONObject, paramLong);
    }
  }
  
  public void handleOperateExternalElement(JSONObject paramJSONObject, int paramInt, IJsService paramIJsService, long paramLong)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("handleOperateExternalElement() called with: req = [");
    ((StringBuilder)localObject).append(paramJSONObject);
    ((StringBuilder)localObject).append("], callbackId = [");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append("], webview = [");
    ((StringBuilder)localObject).append(paramIJsService);
    ((StringBuilder)localObject).append("], widgetId = [");
    ((StringBuilder)localObject).append(paramLong);
    ((StringBuilder)localObject).append("]");
    Log.d("ExternalElementProxyImp", ((StringBuilder)localObject).toString());
    localObject = (ExternalElementProxy)this.a.get(Long.valueOf(paramLong));
    if (localObject != null) {
      ((ExternalElementProxy)localObject).handleOperateExternalElement(paramJSONObject, paramInt, paramIJsService, paramLong);
    }
  }
  
  public void handleRemoveExternalElement(long paramLong)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("handleRemoveExternalElement() called with: widgetId = [");
    ((StringBuilder)localObject).append(paramLong);
    ((StringBuilder)localObject).append("]");
    Log.d("ExternalElementProxyImp", ((StringBuilder)localObject).toString());
    localObject = (ExternalElementProxy)this.a.get(Long.valueOf(paramLong));
    if (localObject != null) {
      ((ExternalElementProxy)localObject).handleRemoveExternalElement(paramLong);
    }
  }
  
  public void handleUpdateExternalElement(JSONObject paramJSONObject, long paramLong)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("handleUpdateExternalElement() called with: jsonObject = [");
    ((StringBuilder)localObject).append(paramJSONObject);
    ((StringBuilder)localObject).append("], widgetId = [");
    ((StringBuilder)localObject).append(paramLong);
    ((StringBuilder)localObject).append("]");
    Log.d("ExternalElementProxyImp", ((StringBuilder)localObject).toString());
    localObject = (ExternalElementProxy)this.a.get(Long.valueOf(paramLong));
    if (localObject != null) {
      ((ExternalElementProxy)localObject).handleUpdateExternalElement(paramJSONObject, paramLong);
    }
  }
  
  public void nativeDestroy(long paramLong)
  {
    ExternalElementProxy localExternalElementProxy = (ExternalElementProxy)this.a.get(Long.valueOf(paramLong));
    if (localExternalElementProxy != null) {
      localExternalElementProxy.nativeDestroy(paramLong);
    }
  }
  
  public void nativePause(long paramLong)
  {
    ExternalElementProxy localExternalElementProxy = (ExternalElementProxy)this.a.get(Long.valueOf(paramLong));
    if (localExternalElementProxy != null) {
      localExternalElementProxy.nativePause(paramLong);
    }
  }
  
  public void nativeResume(long paramLong)
  {
    ExternalElementProxy localExternalElementProxy = (ExternalElementProxy)this.a.get(Long.valueOf(paramLong));
    if (localExternalElementProxy != null) {
      localExternalElementProxy.nativeResume(paramLong);
    }
  }
  
  public void onActive(long paramLong)
  {
    ExternalElementProxy localExternalElementProxy = (ExternalElementProxy)this.a.get(Long.valueOf(paramLong));
    if (localExternalElementProxy != null) {
      localExternalElementProxy.onActive(paramLong);
    }
  }
  
  public void onDeActive(long paramLong)
  {
    ExternalElementProxy localExternalElementProxy = (ExternalElementProxy)this.a.get(Long.valueOf(paramLong));
    if (localExternalElementProxy != null) {
      localExternalElementProxy.onDeActive(paramLong);
    }
  }
  
  public void onDestroy(long paramLong)
  {
    ExternalElementProxy localExternalElementProxy = (ExternalElementProxy)this.a.get(Long.valueOf(paramLong));
    if (localExternalElementProxy != null) {
      localExternalElementProxy.onDestroy(paramLong);
    }
  }
  
  public void onInit(String paramString, Map<String, String> paramMap, long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onInit() called with: s = [");
    localStringBuilder.append(paramString);
    localStringBuilder.append("], map = [");
    localStringBuilder.append(paramMap);
    localStringBuilder.append("], widgetId = [");
    localStringBuilder.append(paramLong);
    localStringBuilder.append("]");
    Log.d("ExternalElementProxyImp", localStringBuilder.toString());
    this.a.put(Long.valueOf(paramLong), new TavVideoView());
  }
  
  public void onRectChanged(Rect paramRect, long paramLong)
  {
    ExternalElementProxy localExternalElementProxy = (ExternalElementProxy)this.a.get(Long.valueOf(paramLong));
    if (localExternalElementProxy != null) {
      localExternalElementProxy.onRectChanged(paramRect, paramLong);
    }
  }
  
  public void onRequestRedraw(long paramLong)
  {
    ExternalElementProxy localExternalElementProxy = (ExternalElementProxy)this.a.get(Long.valueOf(paramLong));
    if (localExternalElementProxy != null) {
      localExternalElementProxy.onRequestRedraw(paramLong);
    }
  }
  
  public void onSurfaceCreated(Surface paramSurface, long paramLong)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onSurfaceCreated() called with: surface = [");
    ((StringBuilder)localObject).append(paramSurface);
    ((StringBuilder)localObject).append("], widgetId = [");
    ((StringBuilder)localObject).append(paramLong);
    ((StringBuilder)localObject).append("]");
    Log.d("ExternalElementProxyImp", ((StringBuilder)localObject).toString());
    localObject = (ExternalElementProxy)this.a.get(Long.valueOf(paramLong));
    if (localObject != null) {
      ((ExternalElementProxy)localObject).onSurfaceCreated(paramSurface, paramLong);
    }
  }
  
  public void onSurfaceDestroyed(Surface paramSurface, long paramLong)
  {
    ExternalElementProxy localExternalElementProxy = (ExternalElementProxy)this.a.get(Long.valueOf(paramLong));
    if (localExternalElementProxy != null) {
      localExternalElementProxy.onSurfaceDestroyed(paramSurface, paramLong);
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent, long paramLong)
  {
    ExternalElementProxy localExternalElementProxy = (ExternalElementProxy)this.a.get(Long.valueOf(paramLong));
    return (localExternalElementProxy != null) && (localExternalElementProxy.onTouchEvent(paramMotionEvent, paramLong));
  }
  
  public void onVisibilityChanged(boolean paramBoolean, long paramLong)
  {
    ExternalElementProxy localExternalElementProxy = (ExternalElementProxy)this.a.get(Long.valueOf(paramLong));
    if (localExternalElementProxy != null) {
      localExternalElementProxy.onVisibilityChanged(paramBoolean, paramLong);
    }
  }
  
  public void setCallBackWebView(IJsService paramIJsService, long paramLong)
  {
    ExternalElementProxy localExternalElementProxy = (ExternalElementProxy)this.a.get(Long.valueOf(paramLong));
    if (localExternalElementProxy != null) {
      localExternalElementProxy.setCallBackWebView(paramIJsService, paramLong);
    }
  }
  
  public void setCurPageWebViewId(int paramInt, long paramLong)
  {
    ExternalElementProxy localExternalElementProxy = (ExternalElementProxy)this.a.get(Long.valueOf(paramLong));
    if (localExternalElementProxy != null) {
      localExternalElementProxy.setCurPageWebViewId(paramInt, paramLong);
    }
  }
  
  public void setMiniAppContext(IMiniAppContext paramIMiniAppContext, long paramLong)
  {
    ExternalElementProxy localExternalElementProxy = (ExternalElementProxy)this.a.get(Long.valueOf(paramLong));
    if (localExternalElementProxy != null) {
      localExternalElementProxy.setMiniAppContext(paramIMiniAppContext, paramLong);
    }
  }
  
  public void webViewDestroy(long paramLong)
  {
    ExternalElementProxy localExternalElementProxy = (ExternalElementProxy)this.a.get(Long.valueOf(paramLong));
    if (localExternalElementProxy != null) {
      localExternalElementProxy.webViewDestroy(paramLong);
    }
  }
  
  public void webViewPause(long paramLong)
  {
    ExternalElementProxy localExternalElementProxy = (ExternalElementProxy)this.a.get(Long.valueOf(paramLong));
    if (localExternalElementProxy != null) {
      localExternalElementProxy.webViewPause(paramLong);
    }
  }
  
  public void webViewResume(long paramLong)
  {
    ExternalElementProxy localExternalElementProxy = (ExternalElementProxy)this.a.get(Long.valueOf(paramLong));
    if (localExternalElementProxy != null) {
      localExternalElementProxy.webViewResume(paramLong);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.ExternalElementProxyImpl
 * JD-Core Version:    0.7.0.1
 */