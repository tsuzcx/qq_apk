package com.tencent.qqmini.miniapp.plugin;

import com.tencent.qqmini.sdk.action.PageAction;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;

@JsPlugin
public class ExternalElementJsPlugin
  extends BaseJsPlugin
{
  public static final String TAG = "ExternalElementJsPlugin";
  
  private EmbeddedWidgetClientFactory getFactory()
  {
    return (EmbeddedWidgetClientFactory)this.mMiniAppContext.performAction(new ExternalElementJsPlugin.1(this));
  }
  
  private int getPageWebViewId()
  {
    return PageAction.obtain(this.mMiniAppContext).getPageId();
  }
  
  @JsEvent({"insertXWebExternalElement"})
  public void insertExternalElement(RequestEvent paramRequestEvent)
  {
    EmbeddedWidgetClientFactory localEmbeddedWidgetClientFactory = getFactory();
    if ((localEmbeddedWidgetClientFactory != null) && (localEmbeddedWidgetClientFactory.handleInsertEmbeddedWidgetEvent(paramRequestEvent.event, this.mMiniAppContext, paramRequestEvent.jsonParams, paramRequestEvent.jsService)))
    {
      paramRequestEvent.ok();
      return;
    }
    paramRequestEvent.fail();
  }
  
  @JsEvent({"operateXWebExternalElement"})
  public void operateExternalElement(RequestEvent paramRequestEvent)
  {
    EmbeddedWidgetClientFactory localEmbeddedWidgetClientFactory = getFactory();
    if ((localEmbeddedWidgetClientFactory != null) && (localEmbeddedWidgetClientFactory.handleEmbeddedWidgetEvent(paramRequestEvent.event, this.mMiniAppContext, paramRequestEvent.jsonParams, paramRequestEvent.callbackId, paramRequestEvent.jsService)))
    {
      paramRequestEvent.ok();
      return;
    }
    paramRequestEvent.fail();
  }
  
  @JsEvent({"removeXWebExternalElement"})
  public void removeExternalElement(RequestEvent paramRequestEvent)
  {
    EmbeddedWidgetClientFactory localEmbeddedWidgetClientFactory = getFactory();
    if ((localEmbeddedWidgetClientFactory != null) && (localEmbeddedWidgetClientFactory.handleEmbeddedWidgetEvent(paramRequestEvent.event, this.mMiniAppContext, paramRequestEvent.jsonParams, paramRequestEvent.callbackId, paramRequestEvent.jsService)))
    {
      paramRequestEvent.ok();
      return;
    }
    paramRequestEvent.fail();
  }
  
  @JsEvent({"updateXWebExternalElement"})
  public void updateExternalElement(RequestEvent paramRequestEvent)
  {
    EmbeddedWidgetClientFactory localEmbeddedWidgetClientFactory = getFactory();
    if ((localEmbeddedWidgetClientFactory != null) && (localEmbeddedWidgetClientFactory.handleEmbeddedWidgetEvent(paramRequestEvent.event, this.mMiniAppContext, paramRequestEvent.jsonParams, paramRequestEvent.callbackId, paramRequestEvent.jsService)))
    {
      paramRequestEvent.ok();
      return;
    }
    paramRequestEvent.fail();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.plugin.ExternalElementJsPlugin
 * JD-Core Version:    0.7.0.1
 */