package com.tencent.qqmini.sdk.plugins;

import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.core.utils.AppBrandTask;

@JsPlugin
public class ClipboardJsPlugin
  extends BaseJsPlugin
{
  @JsEvent({"getClipboardData"})
  public String getClipboardData(RequestEvent paramRequestEvent)
  {
    AppBrandTask.runTaskOnUiThread(new ClipboardJsPlugin.1(this, paramRequestEvent));
    return "";
  }
  
  @JsEvent({"setClipboardData"})
  public String setClipboardData(RequestEvent paramRequestEvent)
  {
    AppBrandTask.runTaskOnUiThread(new ClipboardJsPlugin.2(this, paramRequestEvent));
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.ClipboardJsPlugin
 * JD-Core Version:    0.7.0.1
 */