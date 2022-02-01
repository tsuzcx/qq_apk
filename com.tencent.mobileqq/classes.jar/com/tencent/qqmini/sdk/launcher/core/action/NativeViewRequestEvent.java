package com.tencent.qqmini.sdk.launcher.core.action;

import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;
import com.tencent.qqmini.sdk.launcher.core.IJsService;
import com.tencent.qqmini.sdk.launcher.core.IPage;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.log.QMLog;

public class NativeViewRequestEvent
  extends RequestEvent
  implements Action<String>
{
  public static final int DISPATCH_TO_BRAND_PAGE = 0;
  public static final int DISPATCH_TO_NATIVE_VIEW = 2;
  public static final int DISPATCH_TO_PAGE = 3;
  public static final int DISPATCH_TO_PAGE_WEBVIEW_CONTAINER = 1;
  public int dispatchTarget = 2;
  private IJsService mService;
  
  public static NativeViewRequestEvent obtain(RequestEvent paramRequestEvent, int paramInt)
  {
    NativeViewRequestEvent localNativeViewRequestEvent = new NativeViewRequestEvent();
    localNativeViewRequestEvent.event = paramRequestEvent.event;
    localNativeViewRequestEvent.jsonParams = paramRequestEvent.jsonParams;
    localNativeViewRequestEvent.jsService = paramRequestEvent.jsService;
    localNativeViewRequestEvent.callbackId = paramRequestEvent.callbackId;
    localNativeViewRequestEvent.dispatchTarget = paramInt;
    return localNativeViewRequestEvent;
  }
  
  public String perform(BaseRuntime paramBaseRuntime)
  {
    StringBuilder localStringBuilder = new StringBuilder("sendNativeViewEvent ");
    localStringBuilder.append("eventName = ");
    localStringBuilder.append(this.event);
    localStringBuilder.append(" ");
    localStringBuilder.append("jsService = ");
    localStringBuilder.append(this.jsService);
    localStringBuilder.append(" ");
    localStringBuilder.append("callbackId = ");
    localStringBuilder.append(this.callbackId);
    localStringBuilder.append(" ");
    localStringBuilder.append("target = ");
    localStringBuilder.append(this.dispatchTarget);
    QMLog.d("Action", localStringBuilder.toString());
    this.mService = paramBaseRuntime.getJsService();
    return paramBaseRuntime.getPage().dispatchEventToNativeView(this);
  }
  
  public void sendSubscribeJs(String paramString1, String paramString2, int paramInt)
  {
    IJsService localIJsService = this.mService;
    if (localIJsService != null) {
      localIJsService.evaluateSubscribeJS(paramString1, paramString2, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.core.action.NativeViewRequestEvent
 * JD-Core Version:    0.7.0.1
 */