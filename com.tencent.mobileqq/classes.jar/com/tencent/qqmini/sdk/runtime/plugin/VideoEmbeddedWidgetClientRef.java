package com.tencent.qqmini.sdk.runtime.plugin;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.Surface;
import com.tencent.smtt.export.external.embeddedwidget.interfaces.IEmbeddedWidget;
import com.tencent.smtt.export.external.embeddedwidget.interfaces.IEmbeddedWidgetClient;
import java.util.Map;
import org.json.JSONObject;

public class VideoEmbeddedWidgetClientRef
  implements IEmbeddedWidgetClient
{
  private Map<String, String> mAttributes;
  private String mTagName;
  private IEmbeddedWidget mWidget;
  
  public VideoEmbeddedWidgetClientRef(String paramString, Map<String, String> paramMap, IEmbeddedWidget paramIEmbeddedWidget)
  {
    this.mTagName = paramString;
    this.mAttributes = paramMap;
    this.mWidget = paramIEmbeddedWidget;
  }
  
  public void handleInsertXWebVideo(JSONObject paramJSONObject) {}
  
  public void handleOperateXWebVideo(JSONObject paramJSONObject) {}
  
  public void handleUpdateXWebVideo(JSONObject paramJSONObject) {}
  
  public void nativeDestroy() {}
  
  public void nativePause() {}
  
  public void nativeResume() {}
  
  public void onActive() {}
  
  public void onDeactive() {}
  
  public void onDestroy() {}
  
  public void onRectChanged(Rect paramRect) {}
  
  public void onRequestRedraw() {}
  
  public void onSurfaceCreated(Surface paramSurface) {}
  
  public void onSurfaceDestroyed(Surface paramSurface) {}
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public void onVisibilityChanged(boolean paramBoolean) {}
  
  public void webviewDestory() {}
  
  public void webviewPause() {}
  
  public void webviewResume() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.runtime.plugin.VideoEmbeddedWidgetClientRef
 * JD-Core Version:    0.7.0.1
 */