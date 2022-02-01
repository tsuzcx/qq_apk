package com.tencent.qqmini.sdk.core.proxy.service;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.Surface;
import com.tencent.qqmini.sdk.annotation.ProxyService;
import com.tencent.qqmini.sdk.launcher.core.IJsService;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.proxy.ExternalElementProxy;
import java.util.Map;
import org.json.JSONObject;

@ProxyService(proxy=ExternalElementProxy.class)
public class ExternalElementProxyDefault
  extends ExternalElementProxy
{
  public void handleInsertXWebExternalElement(JSONObject paramJSONObject, long paramLong) {}
  
  public void handleOperateExternalElement(JSONObject paramJSONObject, int paramInt, IJsService paramIJsService, long paramLong) {}
  
  public void handleRemoveExternalElement(long paramLong) {}
  
  public void handleUpdateExternalElement(JSONObject paramJSONObject, long paramLong) {}
  
  public void nativeDestroy(long paramLong) {}
  
  public void nativePause(long paramLong) {}
  
  public void nativeResume(long paramLong) {}
  
  public void onActive(long paramLong) {}
  
  public void onDeActive(long paramLong) {}
  
  public void onDestroy(long paramLong) {}
  
  public void onInit(String paramString, Map<String, String> paramMap, long paramLong) {}
  
  public void onRectChanged(Rect paramRect, long paramLong) {}
  
  public void onRequestRedraw(long paramLong) {}
  
  public void onSurfaceCreated(Surface paramSurface, long paramLong) {}
  
  public void onSurfaceDestroyed(Surface paramSurface, long paramLong) {}
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent, long paramLong)
  {
    return false;
  }
  
  public void onVisibilityChanged(boolean paramBoolean, long paramLong) {}
  
  public void setCallBackWebView(IJsService paramIJsService, long paramLong) {}
  
  public void setCurPageWebViewId(int paramInt, long paramLong) {}
  
  public void setMiniAppContext(IMiniAppContext paramIMiniAppContext, long paramLong) {}
  
  public void webViewDestroy(long paramLong) {}
  
  public void webViewPause(long paramLong) {}
  
  public void webViewResume(long paramLong) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.proxy.service.ExternalElementProxyDefault
 * JD-Core Version:    0.7.0.1
 */