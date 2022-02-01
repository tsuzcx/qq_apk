package com.tencent.mobileqq.mini.appbrand.page.embedded;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.Surface;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.mini.appbrand.BaseAppBrandRuntime;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.smtt.export.external.embeddedwidget.interfaces.IEmbeddedWidget;
import java.util.Map;
import org.json.JSONObject;

public class EmbeddedWidgetClientHolder
  implements IExtendedEmbeddedWidgetClient
{
  private static final String TAG = "miniapp-embedded-EmbeddedWidgetClientHolder";
  private Map<String, String> attributes;
  private IExtendedEmbeddedWidgetClient realClient;
  private Surface surfaceCreated;
  private String tagName;
  private IEmbeddedWidget widget;
  
  public EmbeddedWidgetClientHolder(String paramString, Map<String, String> paramMap, IEmbeddedWidget paramIEmbeddedWidget)
  {
    this.tagName = paramString;
    this.attributes = paramMap;
    this.widget = paramIEmbeddedWidget;
  }
  
  public void handleEmbeddedWidgetEvent(JsRuntime paramJsRuntime, String paramString, JSONObject paramJSONObject, int paramInt)
  {
    QLog.d("miniapp-embedded-EmbeddedWidgetClientHolder", 1, "handleEmbeddedWidgetEvent event:" + paramString);
    if ((this.realClient instanceof VideoEmbeddedWidgetClient)) {
      if ("operateXWebVideo".equals(paramString)) {
        ((VideoEmbeddedWidgetClient)this.realClient).handleOperateXWebVideo(paramJSONObject);
      }
    }
    label55:
    do
    {
      do
      {
        do
        {
          break label55;
          do
          {
            return;
          } while (!"updateXWebVideo".equals(paramString));
          ((VideoEmbeddedWidgetClient)this.realClient).handleUpdateXWebVideo(paramJSONObject);
          return;
          if (!(this.realClient instanceof LivePlayerEmbeddedWidgetClient)) {
            break;
          }
          if ("operateXWebLivePlayer".equals(paramString))
          {
            ((LivePlayerEmbeddedWidgetClient)this.realClient).handleOperateXWebLivePlayer(paramJsRuntime, paramJSONObject, paramInt);
            return;
          }
          if ("updateXWebLivePlayer".equals(paramString))
          {
            ((LivePlayerEmbeddedWidgetClient)this.realClient).handleUpdateXWebLivePlayer(paramJSONObject);
            return;
          }
        } while (!"removeXWebLivePlayer".equals(paramString));
        ((LivePlayerEmbeddedWidgetClient)this.realClient).handleRemoveXWebLivePlayer();
        return;
      } while (!(this.realClient instanceof LivePusherEmbeddedWidgetClient));
      if ("operateXWebLivePusher".equals(paramString))
      {
        ((LivePusherEmbeddedWidgetClient)this.realClient).handleOperateXWebLivePusher(paramJsRuntime, paramJSONObject, paramInt);
        return;
      }
      if ("updateXWebLivePusher".equals(paramString))
      {
        ((LivePusherEmbeddedWidgetClient)this.realClient).handleUpdateXWebLivePusher(paramJSONObject);
        return;
      }
    } while (!"removeXWebLivePusher".equals(paramString));
    ((LivePusherEmbeddedWidgetClient)this.realClient).handleRemoveXWebLivePusher();
  }
  
  public void handleInsertEmbeddedWidgetEvent(String paramString, JSONObject paramJSONObject, JsRuntime paramJsRuntime, BaseAppBrandRuntime paramBaseAppBrandRuntime)
  {
    QLog.d("miniapp-embedded-EmbeddedWidgetClientHolder", 1, "handleInsertEmbeddedWidgetEvent event:" + paramString);
    if ("insertXWebVideo".equals(paramString))
    {
      this.realClient = new VideoEmbeddedWidgetClient(this.tagName, this.attributes, this.widget);
      if (this.surfaceCreated != null) {
        this.realClient.onSurfaceCreated(this.surfaceCreated);
      }
      ((VideoEmbeddedWidgetClient)this.realClient).handleInsertXWebVideo(paramJSONObject, paramJsRuntime, paramBaseAppBrandRuntime);
    }
    do
    {
      return;
      if ("insertXWebLivePlayer".equals(paramString))
      {
        this.realClient = new LivePlayerEmbeddedWidgetClient(this.tagName, this.attributes, this.widget);
        if (this.surfaceCreated != null) {
          this.realClient.onSurfaceCreated(this.surfaceCreated);
        }
        ((LivePlayerEmbeddedWidgetClient)this.realClient).handleInsertXWebLivePlayer(paramJSONObject, paramJsRuntime, paramBaseAppBrandRuntime);
        return;
      }
    } while (!"insertXWebLivePusher".equals(paramString));
    this.realClient = new LivePusherEmbeddedWidgetClient(this.tagName, this.attributes, this.widget);
    if (this.surfaceCreated != null) {
      this.realClient.onSurfaceCreated(this.surfaceCreated);
    }
    ((LivePusherEmbeddedWidgetClient)this.realClient).handleInsertXWebLivePusher(paramJSONObject, paramJsRuntime, paramBaseAppBrandRuntime);
  }
  
  public void nativeDestroy()
  {
    QLog.d("miniapp-embedded-EmbeddedWidgetClientHolder", 1, "nativeDestroy");
    if (this.realClient != null)
    {
      this.realClient.nativeDestroy();
      return;
    }
    QLog.d("miniapp-embedded-EmbeddedWidgetClientHolder", 1, "nativeDestroy-realClient is null");
  }
  
  public void nativePause()
  {
    QLog.d("miniapp-embedded-EmbeddedWidgetClientHolder", 1, "nativePause");
    if (this.realClient != null)
    {
      this.realClient.nativePause();
      return;
    }
    QLog.d("miniapp-embedded-EmbeddedWidgetClientHolder", 1, "nativePause-realClient is null");
  }
  
  public void nativeResume()
  {
    QLog.d("miniapp-embedded-EmbeddedWidgetClientHolder", 1, "nativeResume");
    if (this.realClient != null)
    {
      this.realClient.nativeResume();
      return;
    }
    QLog.d("miniapp-embedded-EmbeddedWidgetClientHolder", 1, "nativeResume-realClient is null");
  }
  
  public void onActive()
  {
    QLog.d("miniapp-embedded-EmbeddedWidgetClientHolder", 1, "onActive");
    if (this.realClient != null)
    {
      this.realClient.onActive();
      return;
    }
    QLog.d("miniapp-embedded-EmbeddedWidgetClientHolder", 1, "onActive-realClient is null");
  }
  
  public void onDeactive()
  {
    QLog.d("miniapp-embedded-EmbeddedWidgetClientHolder", 1, "onDeactive");
    if (this.realClient != null)
    {
      this.realClient.onDestroy();
      return;
    }
    QLog.d("miniapp-embedded-EmbeddedWidgetClientHolder", 1, "onDeactive-realClient is null");
  }
  
  public void onDestroy()
  {
    QLog.d("miniapp-embedded-EmbeddedWidgetClientHolder", 1, "onDestroy");
    if (this.realClient != null)
    {
      this.realClient.onDestroy();
      return;
    }
    QLog.d("miniapp-embedded-EmbeddedWidgetClientHolder", 1, "onDestroy-realClient is null");
  }
  
  public void onRectChanged(Rect paramRect)
  {
    QLog.d("miniapp-embedded-EmbeddedWidgetClientHolder", 1, "onRectChanged");
    if (this.realClient != null)
    {
      QLog.d("miniapp-embedded-EmbeddedWidgetClientHolder", 1, "onRectChanged-realClient.onRectChanged");
      this.realClient.onRectChanged(paramRect);
      return;
    }
    QLog.d("miniapp-embedded-EmbeddedWidgetClientHolder", 1, "onRectChanged-realClient is null");
  }
  
  public void onRequestRedraw()
  {
    QLog.d("miniapp-embedded-EmbeddedWidgetClientHolder", 1, "onRequestRedraw");
    if (this.realClient != null)
    {
      this.realClient.onRequestRedraw();
      return;
    }
    QLog.d("miniapp-embedded-EmbeddedWidgetClientHolder", 1, "onRequestRedraw-realClient is null");
  }
  
  public void onSurfaceCreated(Surface paramSurface)
  {
    QLog.d("miniapp-embedded-EmbeddedWidgetClientHolder", 1, "onSurfaceCreated");
    if (this.realClient != null)
    {
      this.realClient.onSurfaceCreated(paramSurface);
      return;
    }
    this.surfaceCreated = paramSurface;
    QLog.e("miniapp-embedded-EmbeddedWidgetClientHolder", 1, "onSurfaceCreated-realClient is null");
  }
  
  public void onSurfaceDestroyed(Surface paramSurface)
  {
    QLog.d("miniapp-embedded-EmbeddedWidgetClientHolder", 1, "onSurfaceDestroyed");
    if (this.realClient != null)
    {
      this.realClient.onSurfaceDestroyed(paramSurface);
      return;
    }
    this.surfaceCreated = null;
    QLog.d("miniapp-embedded-EmbeddedWidgetClientHolder", 1, "onSurfaceDestroyed-realClient is null");
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    QLog.d("miniapp-embedded-EmbeddedWidgetClientHolder", 1, "onTouchEvent");
    if (this.realClient != null)
    {
      QLog.d("miniapp-embedded-EmbeddedWidgetClientHolder", 1, "onTouchEvent-realClient.onTouchEvent");
      return this.realClient.onTouchEvent(paramMotionEvent);
    }
    QLog.d("miniapp-embedded-EmbeddedWidgetClientHolder", 1, "onTouchEvent-realClient is null");
    return false;
  }
  
  public void onVisibilityChanged(boolean paramBoolean)
  {
    QLog.d("miniapp-embedded-EmbeddedWidgetClientHolder", 1, "onVisibilityChanged");
    if (this.realClient != null)
    {
      this.realClient.onVisibilityChanged(paramBoolean);
      return;
    }
    QLog.d("miniapp-embedded-EmbeddedWidgetClientHolder", 1, "onVisibilityChanged-realClient is null");
  }
  
  public void webViewDestory()
  {
    QLog.d("miniapp-embedded-EmbeddedWidgetClientHolder", 1, "webViewDestory");
    if (this.realClient != null)
    {
      this.realClient.webViewDestory();
      return;
    }
    QLog.d("miniapp-embedded-EmbeddedWidgetClientHolder", 1, "webViewDestory-realClient is null");
  }
  
  public void webViewPause()
  {
    QLog.d("miniapp-embedded-EmbeddedWidgetClientHolder", 1, "webViewPause");
    if (this.realClient != null)
    {
      this.realClient.webViewPause();
      return;
    }
    QLog.d("miniapp-embedded-EmbeddedWidgetClientHolder", 1, "webViewPause-realClient is null");
  }
  
  public void webViewResume()
  {
    QLog.d("miniapp-embedded-EmbeddedWidgetClientHolder", 1, "webViewResume");
    if (this.realClient != null)
    {
      this.realClient.webViewResume();
      return;
    }
    QLog.d("miniapp-embedded-EmbeddedWidgetClientHolder", 1, "webViewResume-realClient is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.page.embedded.EmbeddedWidgetClientHolder
 * JD-Core Version:    0.7.0.1
 */