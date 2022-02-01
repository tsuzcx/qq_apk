package com.tencent.qqmini.sdk.plugins;

import android.content.Context;
import com.tencent.qqmini.sdk.R.string;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.core.utils.AppBrandTask;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.widget.MiniToast;

@JsPlugin
public class ClipboardJsPlugin
  extends BaseJsPlugin
{
  private void showClipboardWarningToast()
  {
    Object localObject = getMiniAppInfo();
    if ((this.mContext != null) && (localObject != null))
    {
      localObject = this.mContext.getString(R.string.mini_sdk_read_clipboard_warning, new Object[] { ((MiniAppInfo)localObject).name });
      MiniToast.makeText(this.mContext, (CharSequence)localObject, 0).show();
    }
  }
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.ClipboardJsPlugin
 * JD-Core Version:    0.7.0.1
 */