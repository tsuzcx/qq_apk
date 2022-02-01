package com.tencent.smtt.export.external.extension.proxy;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.webkit.ValueCallback;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebChromeClientExtension;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebViewExtension;
import com.tencent.smtt.export.external.interfaces.IX5WebViewBase.HitTestResult;
import com.tencent.smtt.export.external.interfaces.JsResult;
import com.tencent.smtt.export.external.interfaces.MediaAccessPermissionsCallback;
import java.util.HashMap;

public class ProxyWebChromeClientExtension
  implements IX5WebChromeClientExtension
{
  private static boolean sCompatibleNewOnSavePassword = true;
  private static boolean sCompatibleOpenFileChooser = true;
  protected IX5WebChromeClientExtension mWebChromeClient;
  
  public void acquireWakeLock()
  {
    if (this.mWebChromeClient != null) {
      this.mWebChromeClient.acquireWakeLock();
    }
  }
  
  public void addFlashView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    if (this.mWebChromeClient != null) {
      this.mWebChromeClient.addFlashView(paramView, paramLayoutParams);
    }
  }
  
  public void exitFullScreenFlash()
  {
    if (this.mWebChromeClient != null) {
      this.mWebChromeClient.exitFullScreenFlash();
    }
  }
  
  public Context getApplicationContex()
  {
    if (this.mWebChromeClient != null) {
      return this.mWebChromeClient.getApplicationContex();
    }
    return null;
  }
  
  public View getVideoLoadingProgressView()
  {
    if (this.mWebChromeClient != null) {
      return this.mWebChromeClient.getVideoLoadingProgressView();
    }
    return null;
  }
  
  public Object getX5WebChromeClientInstance()
  {
    return this.mWebChromeClient;
  }
  
  public IX5WebChromeClientExtension getmWebChromeClient()
  {
    return this.mWebChromeClient;
  }
  
  public void h5videoExitFullScreen(String paramString)
  {
    if (this.mWebChromeClient != null) {
      this.mWebChromeClient.h5videoExitFullScreen(paramString);
    }
  }
  
  public void h5videoRequestFullScreen(String paramString)
  {
    if (this.mWebChromeClient != null) {
      this.mWebChromeClient.h5videoRequestFullScreen(paramString);
    }
  }
  
  public void jsExitFullScreen()
  {
    if (this.mWebChromeClient != null) {
      this.mWebChromeClient.jsExitFullScreen();
    }
  }
  
  public void jsRequestFullScreen()
  {
    if (this.mWebChromeClient != null) {
      this.mWebChromeClient.jsRequestFullScreen();
    }
  }
  
  public boolean onAddFavorite(IX5WebViewExtension paramIX5WebViewExtension, String paramString1, String paramString2, JsResult paramJsResult)
  {
    if (this.mWebChromeClient != null) {
      return this.mWebChromeClient.onAddFavorite(paramIX5WebViewExtension, paramString1, paramString2, paramJsResult);
    }
    return false;
  }
  
  public void onAllMetaDataFinished(IX5WebViewExtension paramIX5WebViewExtension, HashMap<String, String> paramHashMap)
  {
    if (this.mWebChromeClient != null) {
      this.mWebChromeClient.onAllMetaDataFinished(paramIX5WebViewExtension, paramHashMap);
    }
  }
  
  public void onBackforwardFinished(int paramInt)
  {
    if (this.mWebChromeClient != null) {
      this.mWebChromeClient.onBackforwardFinished(paramInt);
    }
  }
  
  public void onColorModeChanged(long paramLong) {}
  
  public void onHitTestResultFinished(IX5WebViewExtension paramIX5WebViewExtension, IX5WebViewBase.HitTestResult paramHitTestResult)
  {
    if (this.mWebChromeClient != null) {
      this.mWebChromeClient.onHitTestResultFinished(paramIX5WebViewExtension, paramHitTestResult);
    }
  }
  
  public void onHitTestResultForPluginFinished(IX5WebViewExtension paramIX5WebViewExtension, IX5WebViewBase.HitTestResult paramHitTestResult, Bundle paramBundle)
  {
    if (this.mWebChromeClient != null) {
      this.mWebChromeClient.onHitTestResultForPluginFinished(paramIX5WebViewExtension, paramHitTestResult, paramBundle);
    }
  }
  
  public Object onMiscCallBack(String paramString, Bundle paramBundle)
  {
    if (this.mWebChromeClient != null) {
      return this.mWebChromeClient.onMiscCallBack(paramString, paramBundle);
    }
    return null;
  }
  
  public boolean onPageNotResponding(Runnable paramRunnable)
  {
    if (this.mWebChromeClient != null) {
      return this.mWebChromeClient.onPageNotResponding(paramRunnable);
    }
    return false;
  }
  
  public boolean onPermissionRequest(String paramString, long paramLong, MediaAccessPermissionsCallback paramMediaAccessPermissionsCallback)
  {
    return false;
  }
  
  public void onPrepareX5ReadPageDataFinished(IX5WebViewExtension paramIX5WebViewExtension, HashMap<String, String> paramHashMap)
  {
    if (this.mWebChromeClient != null) {
      this.mWebChromeClient.onPrepareX5ReadPageDataFinished(paramIX5WebViewExtension, paramHashMap);
    }
  }
  
  public void onPrintPage() {}
  
  public void onPromptNotScalable(IX5WebViewExtension paramIX5WebViewExtension)
  {
    if (this.mWebChromeClient != null) {
      this.mWebChromeClient.onPromptNotScalable(paramIX5WebViewExtension);
    }
  }
  
  public void onPromptScaleSaved(IX5WebViewExtension paramIX5WebViewExtension)
  {
    if (this.mWebChromeClient != null) {
      this.mWebChromeClient.onPromptScaleSaved(paramIX5WebViewExtension);
    }
  }
  
  public boolean onSavePassword(ValueCallback<String> paramValueCallback, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, boolean paramBoolean)
  {
    if ((this.mWebChromeClient != null) && (sCompatibleNewOnSavePassword)) {
      try
      {
        paramBoolean = this.mWebChromeClient.onSavePassword(paramValueCallback, paramString1, paramString2, paramString3, paramString4, paramString5, paramBoolean);
        return paramBoolean;
      }
      catch (NoSuchMethodError paramValueCallback)
      {
        if ((paramValueCallback.getMessage() == null) || (!paramValueCallback.getMessage().contains("onSavePassword"))) {
          throw paramValueCallback;
        }
        Log.d("incompatible-oldcore", "IX5WebChromeClientExtension.onSavePassword");
        sCompatibleNewOnSavePassword = false;
      }
    }
    return false;
  }
  
  public boolean onSavePassword(String paramString1, String paramString2, String paramString3, boolean paramBoolean, Message paramMessage)
  {
    if (this.mWebChromeClient != null) {
      try
      {
        paramBoolean = this.mWebChromeClient.onSavePassword(paramString1, paramString2, paramString3, paramBoolean, paramMessage);
        return paramBoolean;
      }
      catch (NoSuchMethodError paramString1)
      {
        paramString1.printStackTrace();
      }
    }
    return false;
  }
  
  public void onX5ReadModeAvailableChecked(HashMap<String, String> paramHashMap)
  {
    if (this.mWebChromeClient != null) {
      this.mWebChromeClient.onX5ReadModeAvailableChecked(paramHashMap);
    }
  }
  
  public void openFileChooser(ValueCallback<Uri[]> paramValueCallback, String paramString1, String paramString2)
  {
    if ((this.mWebChromeClient != null) && (sCompatibleOpenFileChooser)) {}
    try
    {
      this.mWebChromeClient.openFileChooser(paramValueCallback, paramString1, paramString2);
      return;
    }
    catch (NoSuchMethodError paramValueCallback)
    {
      if ((paramValueCallback.getMessage() == null) || (!paramValueCallback.getMessage().contains("openFileChooser"))) {
        throw paramValueCallback;
      }
      Log.d("incompatible-oldcore", "IX5WebChromeClientExtension.openFileChooser");
      sCompatibleOpenFileChooser = false;
    }
  }
  
  public void releaseWakeLock()
  {
    if (this.mWebChromeClient != null) {
      this.mWebChromeClient.releaseWakeLock();
    }
  }
  
  public void requestFullScreenFlash()
  {
    if (this.mWebChromeClient != null) {
      this.mWebChromeClient.requestFullScreenFlash();
    }
  }
  
  public void setWebChromeClientExtend(IX5WebChromeClientExtension paramIX5WebChromeClientExtension)
  {
    this.mWebChromeClient = paramIX5WebChromeClientExtension;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.smtt.export.external.extension.proxy.ProxyWebChromeClientExtension
 * JD-Core Version:    0.7.0.1
 */