package com.tencent.qqmini.miniapp.plugin;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.Surface;
import com.tencent.qqmini.miniapp.core.page.BrandPageWebview;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.IJsService;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.proxy.ExternalElementProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.smtt.export.external.embeddedwidget.interfaces.IEmbeddedWidget;
import java.util.Map;
import org.json.JSONObject;

public class ExternalEmbeddedWidgetClient
  implements IExtendedEmbeddedWidgetClient
{
  private static final String TAG = "miniapp-embedded-external";
  private IMiniAppContext mMiniAppContext;
  private int mViewId = -1;
  private ExternalElementProxy proxy = (ExternalElementProxy)ProxyManager.get(ExternalElementProxy.class);
  private IEmbeddedWidget widget;
  
  public ExternalEmbeddedWidgetClient(IMiniAppContext paramIMiniAppContext, String paramString, Map<String, String> paramMap, IEmbeddedWidget paramIEmbeddedWidget)
  {
    this.widget = paramIEmbeddedWidget;
    this.mMiniAppContext = paramIMiniAppContext;
    ExternalElementProxy localExternalElementProxy = this.proxy;
    if (localExternalElementProxy != null)
    {
      localExternalElementProxy.setMiniAppContext(paramIMiniAppContext, paramIEmbeddedWidget.getWidgetId());
      this.proxy.onInit(paramString, paramMap, paramIEmbeddedWidget.getWidgetId());
    }
  }
  
  public IMiniAppContext getMiniAppContext()
  {
    return this.mMiniAppContext;
  }
  
  public int getViewId()
  {
    return this.mViewId;
  }
  
  public void handleInsertXWebExternalElement(JSONObject paramJSONObject, IJsService paramIJsService)
  {
    int i;
    if ((paramIJsService instanceof BrandPageWebview)) {
      i = ((BrandPageWebview)paramIJsService).getWebViewId();
    } else {
      i = -1;
    }
    if (paramJSONObject != null) {
      this.mViewId = paramJSONObject.optInt("viewId", -1);
    }
    ExternalElementProxy localExternalElementProxy = this.proxy;
    if (localExternalElementProxy != null)
    {
      localExternalElementProxy.setCurPageWebViewId(i, this.widget.getWidgetId());
      this.proxy.setCallBackWebView(paramIJsService, this.widget.getWidgetId());
      this.proxy.handleInsertXWebExternalElement(paramJSONObject, this.widget.getWidgetId());
    }
  }
  
  public void handleOperateXWebExternalElement(JSONObject paramJSONObject, int paramInt, IJsService paramIJsService)
  {
    ExternalElementProxy localExternalElementProxy = this.proxy;
    if (localExternalElementProxy != null) {
      localExternalElementProxy.handleOperateExternalElement(paramJSONObject, paramInt, paramIJsService, this.widget.getWidgetId());
    }
  }
  
  public void handleRemoveXWebExternalElement()
  {
    ExternalElementProxy localExternalElementProxy = this.proxy;
    if (localExternalElementProxy != null) {
      localExternalElementProxy.handleRemoveExternalElement(this.widget.getWidgetId());
    }
  }
  
  public void handleUpdateXWebExternalElement(JSONObject paramJSONObject)
  {
    ExternalElementProxy localExternalElementProxy = this.proxy;
    if (localExternalElementProxy != null) {
      localExternalElementProxy.handleUpdateExternalElement(paramJSONObject, this.widget.getWidgetId());
    }
  }
  
  public void nativeDestroy()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("ExternalEmbeddedWidgetClient.nativeDestroy ");
    ((StringBuilder)localObject).append(this);
    QMLog.d("miniapp-embedded-external", ((StringBuilder)localObject).toString());
    localObject = this.proxy;
    if (localObject != null) {
      ((ExternalElementProxy)localObject).nativeDestroy(this.widget.getWidgetId());
    }
  }
  
  public void nativePause()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("ExternalEmbeddedWidgetClient.nativePause ");
    ((StringBuilder)localObject).append(this);
    QMLog.d("miniapp-embedded-external", ((StringBuilder)localObject).toString());
    localObject = this.proxy;
    if (localObject != null) {
      ((ExternalElementProxy)localObject).nativePause(this.widget.getWidgetId());
    }
  }
  
  public void nativeResume()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("ExternalEmbeddedWidgetClient.nativeResume ");
    ((StringBuilder)localObject).append(this);
    QMLog.d("miniapp-embedded-external", ((StringBuilder)localObject).toString());
    localObject = this.proxy;
    if (localObject != null) {
      ((ExternalElementProxy)localObject).nativeResume(this.widget.getWidgetId());
    }
  }
  
  public void onActive()
  {
    QMLog.d("miniapp-embedded-external", "ExternalEmbeddedWidgetClient.onActive");
    ExternalElementProxy localExternalElementProxy = this.proxy;
    if (localExternalElementProxy != null) {
      localExternalElementProxy.onActive(this.widget.getWidgetId());
    }
  }
  
  public void onDeactive()
  {
    QMLog.d("miniapp-embedded-external", "ExternalEmbeddedWidgetClient.onDeactive");
    ExternalElementProxy localExternalElementProxy = this.proxy;
    if (localExternalElementProxy != null) {
      localExternalElementProxy.onDeActive(this.widget.getWidgetId());
    }
  }
  
  public void onDestroy()
  {
    QMLog.d("miniapp-embedded-external", "ExternalEmbeddedWidgetClient.onDestroy");
    ExternalElementProxy localExternalElementProxy = this.proxy;
    if (localExternalElementProxy != null) {
      localExternalElementProxy.onDestroy(this.widget.getWidgetId());
    }
  }
  
  public void onRectChanged(Rect paramRect)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("ExternalEmbeddedWidgetClient.onRectChanged, rect:");
    ((StringBuilder)localObject).append(paramRect.toString());
    ((StringBuilder)localObject).append("； size : ");
    ((StringBuilder)localObject).append(paramRect.right - paramRect.left);
    ((StringBuilder)localObject).append(",");
    ((StringBuilder)localObject).append(paramRect.bottom - paramRect.top);
    QMLog.d("miniapp-embedded-external", ((StringBuilder)localObject).toString());
    localObject = this.proxy;
    if (localObject != null) {
      ((ExternalElementProxy)localObject).onRectChanged(paramRect, this.widget.getWidgetId());
    }
  }
  
  public void onRequestRedraw()
  {
    QMLog.d("miniapp-embedded-external", "ExternalEmbeddedWidgetClient.onRequestRedraw");
    ExternalElementProxy localExternalElementProxy = this.proxy;
    if (localExternalElementProxy != null) {
      localExternalElementProxy.onRequestRedraw(this.widget.getWidgetId());
    }
  }
  
  public void onSurfaceCreated(Surface paramSurface)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onSurfaceCreated: ");
    ((StringBuilder)localObject).append(paramSurface);
    QMLog.d("miniapp-embedded-external", ((StringBuilder)localObject).toString());
    if ((paramSurface != null) && (paramSurface.isValid()))
    {
      localObject = this.proxy;
      if (localObject != null) {
        ((ExternalElementProxy)localObject).onSurfaceCreated(paramSurface, this.widget.getWidgetId());
      }
      return;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onSurfaceCreated isValid() : ");
    if (paramSurface != null) {
      paramSurface = Boolean.valueOf(paramSurface.isValid());
    } else {
      paramSurface = null;
    }
    ((StringBuilder)localObject).append(paramSurface);
    QMLog.e("miniapp-embedded-external", ((StringBuilder)localObject).toString());
  }
  
  public void onSurfaceDestroyed(Surface paramSurface)
  {
    QMLog.d("miniapp-embedded-external", "ExternalEmbeddedWidgetClient.onSurfaceDestroyed");
    ExternalElementProxy localExternalElementProxy = this.proxy;
    if (localExternalElementProxy != null) {
      localExternalElementProxy.onSurfaceDestroyed(paramSurface, this.widget.getWidgetId());
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("ExternalEmbeddedWidgetClient.onTouchEvent, rect:");
    ((StringBuilder)localObject).append(paramMotionEvent.toString());
    QMLog.d("miniapp-embedded-external", ((StringBuilder)localObject).toString());
    localObject = this.proxy;
    if (localObject != null) {
      return ((ExternalElementProxy)localObject).onTouchEvent(paramMotionEvent, this.widget.getWidgetId());
    }
    return false;
  }
  
  public void onVisibilityChanged(boolean paramBoolean)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("ExternalEmbeddedWidgetClient.onVisibilityChanged ： ");
    ((StringBuilder)localObject).append(paramBoolean);
    QMLog.d("miniapp-embedded-external", ((StringBuilder)localObject).toString());
    localObject = this.proxy;
    if (localObject != null) {
      ((ExternalElementProxy)localObject).onVisibilityChanged(paramBoolean, this.widget.getWidgetId());
    }
  }
  
  public void webViewDestroy()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("ExternalEmbeddedWidgetClient.webViewDestroy ");
    ((StringBuilder)localObject).append(this);
    QMLog.d("miniapp-embedded-external", ((StringBuilder)localObject).toString());
    localObject = this.proxy;
    if (localObject != null) {
      ((ExternalElementProxy)localObject).webViewDestroy(this.widget.getWidgetId());
    }
  }
  
  public void webViewPause()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("ExternalEmbeddedWidgetClient.webviewPause ");
    ((StringBuilder)localObject).append(this);
    QMLog.d("miniapp-embedded-external", ((StringBuilder)localObject).toString());
    localObject = this.proxy;
    if (localObject != null) {
      ((ExternalElementProxy)localObject).webViewPause(this.widget.getWidgetId());
    }
  }
  
  public void webViewResume()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("ExternalEmbeddedWidgetClient.webviewResume ");
    ((StringBuilder)localObject).append(this);
    QMLog.d("miniapp-embedded-external", ((StringBuilder)localObject).toString());
    localObject = this.proxy;
    if (localObject != null) {
      ((ExternalElementProxy)localObject).webViewResume(this.widget.getWidgetId());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.plugin.ExternalEmbeddedWidgetClient
 * JD-Core Version:    0.7.0.1
 */