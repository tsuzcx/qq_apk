package com.tencent.qqmini.sdk.launcher.core.proxy;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.Surface;
import com.tencent.qqmini.sdk.launcher.core.IJsService;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.action.ServiceSubscribeEvent;
import java.util.Map;
import org.json.JSONObject;

public abstract class ExternalElementProxy
{
  public static final String EVENT_INSERT_XWEB_EXTERNAL_ELEMENT = "insertXWebExternalElement";
  public static final String EVENT_OPERATE_XWEB_EXTERNAL_ELEMENT = "operateXWebExternalElement";
  public static final String EVENT_REMOVE_XWEB_EXTERNAL_ELEMENT = "removeXWebExternalElement";
  public static final String EVENT_UPDATE_XWEB_EXTERNAL_ELEMENT = "updateXWebExternalElement";
  public static final String ON_XWEB_EXTERNAL_ELEMENT_EVENT = "onExternalElementEvent";
  
  protected void callbackOnXWebExternalElementEvent(IMiniAppContext paramIMiniAppContext, IJsService paramIJsService, String paramString, int paramInt)
  {
    if (paramIMiniAppContext != null) {
      paramIMiniAppContext.performAction(ServiceSubscribeEvent.obtain("onExternalElementEvent", paramString, paramInt));
    }
    if (paramIJsService != null) {
      paramIJsService.evaluateSubscribeJS("onExternalElementEvent", paramString, paramInt);
    }
  }
  
  protected void evaluateCallbackJs(IJsService paramIJsService, int paramInt, String paramString)
  {
    if (paramIJsService != null) {
      paramIJsService.evaluateCallbackJs(paramInt, paramString);
    }
  }
  
  public abstract void handleInsertXWebExternalElement(JSONObject paramJSONObject, long paramLong);
  
  public abstract void handleOperateExternalElement(JSONObject paramJSONObject, int paramInt, IJsService paramIJsService, long paramLong);
  
  public abstract void handleRemoveExternalElement(long paramLong);
  
  public abstract void handleUpdateExternalElement(JSONObject paramJSONObject, long paramLong);
  
  public abstract void nativeDestroy(long paramLong);
  
  public abstract void nativePause(long paramLong);
  
  public abstract void nativeResume(long paramLong);
  
  public abstract void onActive(long paramLong);
  
  public abstract void onDeActive(long paramLong);
  
  public abstract void onDestroy(long paramLong);
  
  public abstract void onInit(String paramString, Map<String, String> paramMap, long paramLong);
  
  public abstract void onRectChanged(Rect paramRect, long paramLong);
  
  public abstract void onRequestRedraw(long paramLong);
  
  public abstract void onSurfaceCreated(Surface paramSurface, long paramLong);
  
  public abstract void onSurfaceDestroyed(Surface paramSurface, long paramLong);
  
  public abstract boolean onTouchEvent(MotionEvent paramMotionEvent, long paramLong);
  
  public abstract void onVisibilityChanged(boolean paramBoolean, long paramLong);
  
  public abstract void setCallBackWebView(IJsService paramIJsService, long paramLong);
  
  public abstract void setCurPageWebViewId(int paramInt, long paramLong);
  
  public abstract void setMiniAppContext(IMiniAppContext paramIMiniAppContext, long paramLong);
  
  public abstract void webViewDestroy(long paramLong);
  
  public abstract void webViewPause(long paramLong);
  
  public abstract void webViewResume(long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.core.proxy.ExternalElementProxy
 * JD-Core Version:    0.7.0.1
 */