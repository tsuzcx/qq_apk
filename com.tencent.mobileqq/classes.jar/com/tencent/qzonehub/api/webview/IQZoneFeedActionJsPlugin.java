package com.tencent.qzonehub.api.webview;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IQZoneFeedActionJsPlugin
  extends QRouteApi
{
  public static final String ACTION_BROADCAST_NOTIFY_INPUT_FONT_SELECT = "FeedActionPanelActivity.font_select";
  public static final String ACTION_BROADCAST_NOTIFY_INPUT_PANEL_CLOSED = "FeedActionPanelActivity.inputpanel_closed";
  public static final String ACTION_CONTENT = "FeedActionPanelActivity.content";
  public static final String ACTION_H5PAY_CALL_BACK = "action_h5pay_callback";
  public static final String ACTION_PANEL_HEIGHT = "FeedActionPanelActivity.inputpanel_height";
  public static final String H5PAY_CALL_BACK_JSON = "h5pay_callback_json";
  public static final String INPUT_PANEL_HEIGHT = "panel_height";
  public static final String UNIQUE_KEY_FEEDACTION_ACTIVE = "FeedAction#isActive";
  
  public abstract String getName();
  
  public abstract boolean getsAcceptEncoded();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qzonehub.api.webview.IQZoneFeedActionJsPlugin
 * JD-Core Version:    0.7.0.1
 */