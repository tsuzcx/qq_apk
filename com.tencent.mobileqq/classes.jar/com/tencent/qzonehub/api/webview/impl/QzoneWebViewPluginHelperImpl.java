package com.tencent.qzonehub.api.webview.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.util.IWebViewBuilder;
import com.tencent.qzonehub.api.webview.IQzoneWebViewPluginHelper;
import com.tencent.smtt.sdk.WebView;
import cooperation.qzone.model.Size;
import cooperation.qzone.webviewplugin.QZoneWebViewPlugin;
import cooperation.qzone.webviewplugin.QzoneDynamicAlbumPlugin;
import cooperation.qzone.webviewplugin.QzoneOfflineCacheHelper;
import cooperation.qzone.webviewplugin.QzoneOfflineCacheHelperCallBack;
import cooperation.qzone.webviewplugin.QzoneOfflinePluginJsForQQ;
import cooperation.qzone.webviewplugin.QzonePersonalizeJsPlugin;
import cooperation.qzone.webviewplugin.QzonePhotoWallPlugin;
import cooperation.qzone.webviewplugin.QzoneWebViewOfflinePlugin;
import cooperation.qzone.webviewplugin.personalize.QZonePersonalizeH5Service;
import cooperation.qzone.webviewwrapper.IWebviewWrapper;
import cooperation.qzone.webviewwrapper.QzoneWebViewBaseBuilder;
import cooperation.qzone.webviewwrapper.WebviewWrapper;
import java.io.File;
import java.util.Map;

public class QzoneWebViewPluginHelperImpl
  implements IQzoneWebViewPluginHelper
{
  public boolean checkOfflineUrl(String paramString)
  {
    return QzoneOfflinePluginJsForQQ.checkOfflineUrl(paramString);
  }
  
  public File downLoadFileIfNeeded(AppInterface paramAppInterface, String paramString1, QzoneOfflineCacheHelperCallBack paramQzoneOfflineCacheHelperCallBack, boolean paramBoolean, String paramString2)
  {
    return QzoneOfflineCacheHelper.downLoadFileIfNeeded(paramAppInterface, paramString1, paramQzoneOfflineCacheHelperCallBack, paramBoolean, paramString2);
  }
  
  public String encodeBase64File(String paramString, int paramInt1, int paramInt2)
  {
    return QzoneDynamicAlbumPlugin.encodeBase64File(paramString, paramInt1, paramInt2);
  }
  
  public Size getBitmapSize(String paramString)
  {
    return QzoneDynamicAlbumPlugin.getBitmapSize(paramString);
  }
  
  public Map<Integer, Long> getCTime(Long paramLong)
  {
    return QZonePersonalizeH5Service.getCTime(paramLong);
  }
  
  public IWebViewBuilder getQzoneWebViewBaseBuilder(Context paramContext, Activity paramActivity, Intent paramIntent, AppInterface paramAppInterface, boolean paramBoolean, WebView paramWebView)
  {
    paramContext = new QzoneWebViewBaseBuilder(paramContext, paramActivity, paramIntent, paramAppInterface, paramBoolean);
    if ((paramWebView instanceof TouchWebView)) {
      paramContext.setWebView((TouchWebView)paramWebView);
    }
    return paramContext;
  }
  
  public WebViewPlugin getQzoneWebViewOfflinePlugin()
  {
    return new QzoneWebViewOfflinePlugin();
  }
  
  public WebViewPlugin getQzoneWebViewPlugin()
  {
    return new QZoneWebViewPlugin();
  }
  
  public double getRatio(Context paramContext, int paramInt, Size paramSize)
  {
    return QzonePhotoWallPlugin.getRatio(paramContext, paramInt, paramSize);
  }
  
  public IWebviewWrapper getWebviewWrapper(Context paramContext)
  {
    return new WebviewWrapper(paramContext);
  }
  
  public void notifyWebviewStartAnimation(WebView paramWebView)
  {
    if ((paramWebView instanceof CustomWebView)) {
      QzonePersonalizeJsPlugin.notifyWebviewStartAnimation((CustomWebView)paramWebView);
    }
  }
  
  public void updateCTime(Integer paramInteger, Long paramLong)
  {
    QZonePersonalizeH5Service.updateCTime(paramInteger, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.qzonehub.api.webview.impl.QzoneWebViewPluginHelperImpl
 * JD-Core Version:    0.7.0.1
 */