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
    if (this.proxy != null)
    {
      this.proxy.setMiniAppContext(paramIMiniAppContext, paramIEmbeddedWidget.getWidgetId());
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
    if ((paramIJsService instanceof BrandPageWebview)) {}
    for (int i = ((BrandPageWebview)paramIJsService).getWebViewId();; i = -1)
    {
      if (paramJSONObject != null) {
        this.mViewId = paramJSONObject.optInt("viewId", -1);
      }
      if (this.proxy != null)
      {
        this.proxy.setCurPageWebViewId(i, this.widget.getWidgetId());
        this.proxy.setCallBackWebView(paramIJsService, this.widget.getWidgetId());
        this.proxy.handleInsertXWebExternalElement(paramJSONObject, this.widget.getWidgetId());
      }
      return;
    }
  }
  
  public void handleOperateXWebExternalElement(JSONObject paramJSONObject, int paramInt, IJsService paramIJsService)
  {
    if (this.proxy != null) {
      this.proxy.handleOperateExternalElement(paramJSONObject, paramInt, paramIJsService, this.widget.getWidgetId());
    }
  }
  
  public void handleRemoveXWebExternalElement()
  {
    if (this.proxy != null) {
      this.proxy.handleRemoveExternalElement(this.widget.getWidgetId());
    }
  }
  
  public void handleUpdateXWebExternalElement(JSONObject paramJSONObject)
  {
    if (this.proxy != null) {
      this.proxy.handleUpdateExternalElement(paramJSONObject, this.widget.getWidgetId());
    }
  }
  
  public void nativeDestroy()
  {
    QMLog.d("miniapp-embedded-external", "ExternalEmbeddedWidgetClient.nativeDestroy " + this);
    if (this.proxy != null) {
      this.proxy.nativeDestroy(this.widget.getWidgetId());
    }
  }
  
  public void nativePause()
  {
    QMLog.d("miniapp-embedded-external", "ExternalEmbeddedWidgetClient.nativePause " + this);
    if (this.proxy != null) {
      this.proxy.nativePause(this.widget.getWidgetId());
    }
  }
  
  public void nativeResume()
  {
    QMLog.d("miniapp-embedded-external", "ExternalEmbeddedWidgetClient.nativeResume " + this);
    if (this.proxy != null) {
      this.proxy.nativeResume(this.widget.getWidgetId());
    }
  }
  
  public void onActive()
  {
    QMLog.d("miniapp-embedded-external", "ExternalEmbeddedWidgetClient.onActive");
    if (this.proxy != null) {
      this.proxy.onActive(this.widget.getWidgetId());
    }
  }
  
  public void onDeactive()
  {
    QMLog.d("miniapp-embedded-external", "ExternalEmbeddedWidgetClient.onDeactive");
    if (this.proxy != null) {
      this.proxy.onDeActive(this.widget.getWidgetId());
    }
  }
  
  public void onDestroy()
  {
    QMLog.d("miniapp-embedded-external", "ExternalEmbeddedWidgetClient.onDestroy");
    if (this.proxy != null) {
      this.proxy.onDestroy(this.widget.getWidgetId());
    }
  }
  
  public void onRectChanged(Rect paramRect)
  {
    QMLog.d("miniapp-embedded-external", "ExternalEmbeddedWidgetClient.onRectChanged, rect:" + paramRect.toString() + "； size : " + (paramRect.right - paramRect.left) + "," + (paramRect.bottom - paramRect.top));
    if (this.proxy != null) {
      this.proxy.onRectChanged(paramRect, this.widget.getWidgetId());
    }
  }
  
  public void onRequestRedraw()
  {
    QMLog.d("miniapp-embedded-external", "ExternalEmbeddedWidgetClient.onRequestRedraw");
    if (this.proxy != null) {
      this.proxy.onRequestRedraw(this.widget.getWidgetId());
    }
  }
  
  public void onSurfaceCreated(Surface paramSurface)
  {
    QMLog.d("miniapp-embedded-external", "onSurfaceCreated: " + paramSurface);
    if ((paramSurface == null) || (!paramSurface.isValid()))
    {
      localStringBuilder = new StringBuilder().append("onSurfaceCreated isValid() : ");
      if (paramSurface != null)
      {
        paramSurface = Boolean.valueOf(paramSurface.isValid());
        QMLog.e("miniapp-embedded-external", paramSurface);
      }
    }
    while (this.proxy == null) {
      for (;;)
      {
        StringBuilder localStringBuilder;
        return;
        paramSurface = null;
      }
    }
    this.proxy.onSurfaceCreated(paramSurface, this.widget.getWidgetId());
  }
  
  public void onSurfaceDestroyed(Surface paramSurface)
  {
    QMLog.d("miniapp-embedded-external", "ExternalEmbeddedWidgetClient.onSurfaceDestroyed");
    if (this.proxy != null) {
      this.proxy.onSurfaceDestroyed(paramSurface, this.widget.getWidgetId());
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    QMLog.d("miniapp-embedded-external", "ExternalEmbeddedWidgetClient.onTouchEvent, rect:" + paramMotionEvent.toString());
    if (this.proxy != null) {
      return this.proxy.onTouchEvent(paramMotionEvent, this.widget.getWidgetId());
    }
    return false;
  }
  
  public void onVisibilityChanged(boolean paramBoolean)
  {
    QMLog.d("miniapp-embedded-external", "ExternalEmbeddedWidgetClient.onVisibilityChanged ： " + paramBoolean);
    if (this.proxy != null) {
      this.proxy.onVisibilityChanged(paramBoolean, this.widget.getWidgetId());
    }
  }
  
  public void webViewDestroy()
  {
    QMLog.d("miniapp-embedded-external", "ExternalEmbeddedWidgetClient.webViewDestroy " + this);
    if (this.proxy != null) {
      this.proxy.webViewDestroy(this.widget.getWidgetId());
    }
  }
  
  public void webViewPause()
  {
    QMLog.d("miniapp-embedded-external", "ExternalEmbeddedWidgetClient.webviewPause " + this);
    if (this.proxy != null) {
      this.proxy.webViewPause(this.widget.getWidgetId());
    }
  }
  
  public void webViewResume()
  {
    QMLog.d("miniapp-embedded-external", "ExternalEmbeddedWidgetClient.webviewResume " + this);
    if (this.proxy != null) {
      this.proxy.webViewResume(this.widget.getWidgetId());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.plugin.ExternalEmbeddedWidgetClient
 * JD-Core Version:    0.7.0.1
 */