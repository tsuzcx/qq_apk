package com.tencent.qqmini.miniapp.plugin;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.Surface;
import com.tencent.qqmini.sdk.launcher.core.IJsService;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.smtt.export.external.embeddedwidget.interfaces.IEmbeddedWidget;
import java.util.Map;
import org.json.JSONObject;

public class EmbeddedWidgetClientHolder
  implements IExtendedEmbeddedWidgetClient
{
  private static final String TAG = "miniapp-embedded-EmbeddedWidgetClientHolder";
  private Map<String, String> attributes;
  private IExtendedEmbeddedWidgetClient realClient = null;
  private Surface surfaceCreated;
  private String tagName;
  private IEmbeddedWidget widget;
  
  public EmbeddedWidgetClientHolder(String paramString, Map<String, String> paramMap, IEmbeddedWidget paramIEmbeddedWidget)
  {
    this.tagName = paramString;
    this.attributes = paramMap;
    this.widget = paramIEmbeddedWidget;
  }
  
  private void createRealClient(String paramString, IMiniAppContext paramIMiniAppContext, JSONObject paramJSONObject, IJsService paramIJsService)
  {
    if (this.realClient == null) {
      if ((!"insertXWebVideo".equals(paramString)) && (!"updateXWebVideo".equals(paramString)))
      {
        if ((!"insertXWebLivePlayer".equals(paramString)) && (!"updateXWebLivePlayer".equals(paramString)))
        {
          if ((!"insertXWebLivePusher".equals(paramString)) && (!"updateXWebLivePusher".equals(paramString)))
          {
            if (("insertXWebExternalElement".equals(paramString)) || ("updateXWebExternalElement".equals(paramString)))
            {
              this.realClient = new ExternalEmbeddedWidgetClient(paramIMiniAppContext, this.tagName, this.attributes, this.widget);
              paramString = this.surfaceCreated;
              if (paramString != null) {
                this.realClient.onSurfaceCreated(paramString);
              }
              ((ExternalEmbeddedWidgetClient)this.realClient).handleInsertXWebExternalElement(paramJSONObject, paramIJsService);
            }
          }
          else
          {
            this.realClient = new LivePusherEmbeddedWidgetClient(paramIMiniAppContext, this.tagName, this.attributes, this.widget);
            paramString = this.surfaceCreated;
            if (paramString != null) {
              this.realClient.onSurfaceCreated(paramString);
            }
            ((LivePusherEmbeddedWidgetClient)this.realClient).handleInsertXWebLivePusher(paramJSONObject, paramIJsService);
          }
        }
        else
        {
          this.realClient = new LivePlayerEmbeddedWidgetClient(paramIMiniAppContext, this.tagName, this.attributes, this.widget);
          paramString = this.surfaceCreated;
          if (paramString != null) {
            this.realClient.onSurfaceCreated(paramString);
          }
          ((LivePlayerEmbeddedWidgetClient)this.realClient).handleInsertXWebLivePlayer(paramJSONObject, paramIJsService);
        }
      }
      else
      {
        this.realClient = new VideoEmbeddedWidgetClient(paramIMiniAppContext, this.tagName, this.attributes, this.widget);
        paramString = this.surfaceCreated;
        if (paramString != null) {
          this.realClient.onSurfaceCreated(paramString);
        }
        ((VideoEmbeddedWidgetClient)this.realClient).handleInsertXWebVideo(paramJSONObject, paramIJsService);
      }
    }
  }
  
  private void removeWidget()
  {
    IMiniAppContext localIMiniAppContext = this.realClient.getMiniAppContext();
    if (localIMiniAppContext != null) {
      localIMiniAppContext.performAction(new EmbeddedWidgetClientHolder.1(this));
    }
  }
  
  public IMiniAppContext getMiniAppContext()
  {
    return null;
  }
  
  public int getViewId()
  {
    IExtendedEmbeddedWidgetClient localIExtendedEmbeddedWidgetClient = this.realClient;
    if (localIExtendedEmbeddedWidgetClient != null) {
      return localIExtendedEmbeddedWidgetClient.getViewId();
    }
    return -1;
  }
  
  public void handleEmbeddedWidgetEvent(String paramString, IMiniAppContext paramIMiniAppContext, JSONObject paramJSONObject, int paramInt, IJsService paramIJsService)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("handleEmbeddedWidgetEvent event:");
    localStringBuilder.append(paramString);
    QMLog.d("miniapp-embedded-EmbeddedWidgetClientHolder", localStringBuilder.toString());
    createRealClient(paramString, paramIMiniAppContext, paramJSONObject, paramIJsService);
    if ("operateXWebVideo".equals(paramString))
    {
      ((VideoEmbeddedWidgetClient)this.realClient).handleOperateXWebVideo(paramJSONObject);
      return;
    }
    if ("updateXWebVideo".equals(paramString))
    {
      ((VideoEmbeddedWidgetClient)this.realClient).handleUpdateXWebVideo(paramJSONObject);
      return;
    }
    if ("operateXWebLivePlayer".equals(paramString))
    {
      ((LivePlayerEmbeddedWidgetClient)this.realClient).handleOperateXWebLivePlayer(paramJSONObject, paramInt);
      return;
    }
    if ("updateXWebLivePlayer".equals(paramString))
    {
      ((LivePlayerEmbeddedWidgetClient)this.realClient).handleUpdateXWebLivePlayer(paramJSONObject);
      return;
    }
    if ("removeXWebLivePlayer".equals(paramString))
    {
      ((LivePlayerEmbeddedWidgetClient)this.realClient).handleRemoveXWebLivePlayer();
      return;
    }
    if ("operateXWebLivePusher".equals(paramString))
    {
      ((LivePusherEmbeddedWidgetClient)this.realClient).handleOperateXWebLivePusher(paramJSONObject, paramInt);
      return;
    }
    if ("updateXWebLivePusher".equals(paramString))
    {
      ((LivePusherEmbeddedWidgetClient)this.realClient).handleUpdateXWebLivePusher(paramJSONObject);
      return;
    }
    if ("removeXWebLivePusher".equals(paramString))
    {
      ((LivePusherEmbeddedWidgetClient)this.realClient).handleRemoveXWebLivePusher();
      return;
    }
    if ("operateXWebExternalElement".equals(paramString))
    {
      ((ExternalEmbeddedWidgetClient)this.realClient).handleOperateXWebExternalElement(paramJSONObject, paramInt, paramIJsService);
      return;
    }
    if ("updateXWebExternalElement".equals(paramString))
    {
      ((ExternalEmbeddedWidgetClient)this.realClient).handleUpdateXWebExternalElement(paramJSONObject);
      return;
    }
    if ("removeXWebExternalElement".equals(paramString)) {
      ((ExternalEmbeddedWidgetClient)this.realClient).handleRemoveXWebExternalElement();
    }
  }
  
  public void handleInsertEmbeddedWidgetEvent(String paramString, IMiniAppContext paramIMiniAppContext, JSONObject paramJSONObject, IJsService paramIJsService)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("handleInsertEmbeddedWidgetEvent event:");
    localStringBuilder.append(paramString);
    QMLog.d("miniapp-embedded-EmbeddedWidgetClientHolder", localStringBuilder.toString());
    createRealClient(paramString, paramIMiniAppContext, paramJSONObject, paramIJsService);
  }
  
  public void nativeDestroy()
  {
    QMLog.d("miniapp-embedded-EmbeddedWidgetClientHolder", "nativeDestroy");
    IExtendedEmbeddedWidgetClient localIExtendedEmbeddedWidgetClient = this.realClient;
    if (localIExtendedEmbeddedWidgetClient != null)
    {
      localIExtendedEmbeddedWidgetClient.nativeDestroy();
      return;
    }
    QMLog.d("miniapp-embedded-EmbeddedWidgetClientHolder", "nativeDestroy-realClient is null");
  }
  
  public void nativePause()
  {
    QMLog.d("miniapp-embedded-EmbeddedWidgetClientHolder", "nativePause");
    IExtendedEmbeddedWidgetClient localIExtendedEmbeddedWidgetClient = this.realClient;
    if (localIExtendedEmbeddedWidgetClient != null)
    {
      localIExtendedEmbeddedWidgetClient.nativePause();
      return;
    }
    QMLog.d("miniapp-embedded-EmbeddedWidgetClientHolder", "nativePause-realClient is null");
  }
  
  public void nativeResume()
  {
    QMLog.d("miniapp-embedded-EmbeddedWidgetClientHolder", "nativeResume");
    IExtendedEmbeddedWidgetClient localIExtendedEmbeddedWidgetClient = this.realClient;
    if (localIExtendedEmbeddedWidgetClient != null)
    {
      localIExtendedEmbeddedWidgetClient.nativeResume();
      return;
    }
    QMLog.d("miniapp-embedded-EmbeddedWidgetClientHolder", "nativeResume-realClient is null");
  }
  
  public void onActive()
  {
    QMLog.d("miniapp-embedded-EmbeddedWidgetClientHolder", "onActive");
    IExtendedEmbeddedWidgetClient localIExtendedEmbeddedWidgetClient = this.realClient;
    if (localIExtendedEmbeddedWidgetClient != null)
    {
      localIExtendedEmbeddedWidgetClient.onActive();
      return;
    }
    QMLog.d("miniapp-embedded-EmbeddedWidgetClientHolder", "onActive-realClient is null");
  }
  
  public void onDeactive()
  {
    QMLog.d("miniapp-embedded-EmbeddedWidgetClientHolder", "onDeactive");
    IExtendedEmbeddedWidgetClient localIExtendedEmbeddedWidgetClient = this.realClient;
    if (localIExtendedEmbeddedWidgetClient != null)
    {
      localIExtendedEmbeddedWidgetClient.onDestroy();
      return;
    }
    QMLog.d("miniapp-embedded-EmbeddedWidgetClientHolder", "onDeactive-realClient is null");
  }
  
  public void onDestroy()
  {
    QMLog.d("miniapp-embedded-EmbeddedWidgetClientHolder", "onDestroy");
    if (this.realClient != null)
    {
      removeWidget();
      this.realClient.onDestroy();
      return;
    }
    QMLog.d("miniapp-embedded-EmbeddedWidgetClientHolder", "onDestroy-realClient is null");
  }
  
  public void onRectChanged(Rect paramRect)
  {
    QMLog.d("miniapp-embedded-EmbeddedWidgetClientHolder", "onRectChanged");
    if (this.realClient != null)
    {
      QMLog.d("miniapp-embedded-EmbeddedWidgetClientHolder", "onRectChanged-realClient.onRectChanged");
      this.realClient.onRectChanged(paramRect);
      return;
    }
    QMLog.d("miniapp-embedded-EmbeddedWidgetClientHolder", "onRectChanged-realClient is null");
  }
  
  public void onRequestRedraw()
  {
    QMLog.d("miniapp-embedded-EmbeddedWidgetClientHolder", "onRequestRedraw");
    IExtendedEmbeddedWidgetClient localIExtendedEmbeddedWidgetClient = this.realClient;
    if (localIExtendedEmbeddedWidgetClient != null)
    {
      localIExtendedEmbeddedWidgetClient.onRequestRedraw();
      return;
    }
    QMLog.d("miniapp-embedded-EmbeddedWidgetClientHolder", "onRequestRedraw-realClient is null");
  }
  
  public void onSurfaceCreated(Surface paramSurface)
  {
    QMLog.d("miniapp-embedded-EmbeddedWidgetClientHolder", "onSurfaceCreated");
    IExtendedEmbeddedWidgetClient localIExtendedEmbeddedWidgetClient = this.realClient;
    if (localIExtendedEmbeddedWidgetClient != null)
    {
      localIExtendedEmbeddedWidgetClient.onSurfaceCreated(paramSurface);
      return;
    }
    this.surfaceCreated = paramSurface;
    QMLog.e("miniapp-embedded-EmbeddedWidgetClientHolder", "onSurfaceCreated-realClient is null");
  }
  
  public void onSurfaceDestroyed(Surface paramSurface)
  {
    QMLog.d("miniapp-embedded-EmbeddedWidgetClientHolder", "onSurfaceDestroyed");
    IExtendedEmbeddedWidgetClient localIExtendedEmbeddedWidgetClient = this.realClient;
    if (localIExtendedEmbeddedWidgetClient != null)
    {
      localIExtendedEmbeddedWidgetClient.onSurfaceDestroyed(paramSurface);
      return;
    }
    this.surfaceCreated = null;
    QMLog.d("miniapp-embedded-EmbeddedWidgetClientHolder", "onSurfaceDestroyed-realClient is null");
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    QMLog.d("miniapp-embedded-EmbeddedWidgetClientHolder", "onTouchEvent");
    if (this.realClient != null)
    {
      QMLog.d("miniapp-embedded-EmbeddedWidgetClientHolder", "onTouchEvent-realClient.onTouchEvent");
      return this.realClient.onTouchEvent(paramMotionEvent);
    }
    QMLog.d("miniapp-embedded-EmbeddedWidgetClientHolder", "onTouchEvent-realClient is null");
    return false;
  }
  
  public void onVisibilityChanged(boolean paramBoolean)
  {
    QMLog.d("miniapp-embedded-EmbeddedWidgetClientHolder", "onVisibilityChanged");
    IExtendedEmbeddedWidgetClient localIExtendedEmbeddedWidgetClient = this.realClient;
    if (localIExtendedEmbeddedWidgetClient != null)
    {
      localIExtendedEmbeddedWidgetClient.onVisibilityChanged(paramBoolean);
      return;
    }
    QMLog.d("miniapp-embedded-EmbeddedWidgetClientHolder", "onVisibilityChanged-realClient is null");
  }
  
  public void webViewDestroy()
  {
    QMLog.d("miniapp-embedded-EmbeddedWidgetClientHolder", "webViewDestroy");
    IExtendedEmbeddedWidgetClient localIExtendedEmbeddedWidgetClient = this.realClient;
    if (localIExtendedEmbeddedWidgetClient != null)
    {
      localIExtendedEmbeddedWidgetClient.webViewDestroy();
      return;
    }
    QMLog.d("miniapp-embedded-EmbeddedWidgetClientHolder", "webViewDestroy-realClient is null");
  }
  
  public void webViewPause()
  {
    QMLog.d("miniapp-embedded-EmbeddedWidgetClientHolder", "webViewPause");
    IExtendedEmbeddedWidgetClient localIExtendedEmbeddedWidgetClient = this.realClient;
    if (localIExtendedEmbeddedWidgetClient != null)
    {
      localIExtendedEmbeddedWidgetClient.webViewPause();
      return;
    }
    QMLog.d("miniapp-embedded-EmbeddedWidgetClientHolder", "webViewPause-realClient is null");
  }
  
  public void webViewResume()
  {
    QMLog.d("miniapp-embedded-EmbeddedWidgetClientHolder", "webViewResume");
    IExtendedEmbeddedWidgetClient localIExtendedEmbeddedWidgetClient = this.realClient;
    if (localIExtendedEmbeddedWidgetClient != null)
    {
      localIExtendedEmbeddedWidgetClient.webViewResume();
      return;
    }
    QMLog.d("miniapp-embedded-EmbeddedWidgetClientHolder", "webViewResume-realClient is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.plugin.EmbeddedWidgetClientHolder
 * JD-Core Version:    0.7.0.1
 */