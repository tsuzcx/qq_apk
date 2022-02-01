package com.tencent.qzonehub.api.webview.impl;

import com.tencent.qzonehub.api.webview.IQZoneFeedActionJsPlugin;
import cooperation.qzone.webviewplugin.QZoneFeedActionJsPlugin;

public class QZoneFeedActionJsPluginImpl
  implements IQZoneFeedActionJsPlugin
{
  public String getName()
  {
    return QZoneFeedActionJsPlugin.name;
  }
  
  public boolean getsAcceptEncoded()
  {
    return QZoneFeedActionJsPlugin.sAcceptEncoded;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.qzonehub.api.webview.impl.QZoneFeedActionJsPluginImpl
 * JD-Core Version:    0.7.0.1
 */