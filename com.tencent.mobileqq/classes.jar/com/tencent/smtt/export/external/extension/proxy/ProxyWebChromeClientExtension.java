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
    IX5WebChromeClientExtension localIX5WebChromeClientExtension = this.mWebChromeClient;
    if (localIX5WebChromeClientExtension != null) {
      localIX5WebChromeClientExtension.acquireWakeLock();
    }
  }
  
  public void addFlashView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    IX5WebChromeClientExtension localIX5WebChromeClientExtension = this.mWebChromeClient;
    if (localIX5WebChromeClientExtension != null) {
      localIX5WebChromeClientExtension.addFlashView(paramView, paramLayoutParams);
    }
  }
  
  public void exitFullScreenFlash()
  {
    IX5WebChromeClientExtension localIX5WebChromeClientExtension = this.mWebChromeClient;
    if (localIX5WebChromeClientExtension != null) {
      localIX5WebChromeClientExtension.exitFullScreenFlash();
    }
  }
  
  public Context getApplicationContex()
  {
    IX5WebChromeClientExtension localIX5WebChromeClientExtension = this.mWebChromeClient;
    if (localIX5WebChromeClientExtension != null) {
      return localIX5WebChromeClientExtension.getApplicationContex();
    }
    return null;
  }
  
  public View getVideoLoadingProgressView()
  {
    IX5WebChromeClientExtension localIX5WebChromeClientExtension = this.mWebChromeClient;
    if (localIX5WebChromeClientExtension != null) {
      return localIX5WebChromeClientExtension.getVideoLoadingProgressView();
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
    IX5WebChromeClientExtension localIX5WebChromeClientExtension = this.mWebChromeClient;
    if (localIX5WebChromeClientExtension != null) {
      localIX5WebChromeClientExtension.h5videoExitFullScreen(paramString);
    }
  }
  
  public void h5videoRequestFullScreen(String paramString)
  {
    IX5WebChromeClientExtension localIX5WebChromeClientExtension = this.mWebChromeClient;
    if (localIX5WebChromeClientExtension != null) {
      localIX5WebChromeClientExtension.h5videoRequestFullScreen(paramString);
    }
  }
  
  public void jsExitFullScreen()
  {
    IX5WebChromeClientExtension localIX5WebChromeClientExtension = this.mWebChromeClient;
    if (localIX5WebChromeClientExtension != null) {
      localIX5WebChromeClientExtension.jsExitFullScreen();
    }
  }
  
  public void jsRequestFullScreen()
  {
    IX5WebChromeClientExtension localIX5WebChromeClientExtension = this.mWebChromeClient;
    if (localIX5WebChromeClientExtension != null) {
      localIX5WebChromeClientExtension.jsRequestFullScreen();
    }
  }
  
  public boolean onAddFavorite(IX5WebViewExtension paramIX5WebViewExtension, String paramString1, String paramString2, JsResult paramJsResult)
  {
    IX5WebChromeClientExtension localIX5WebChromeClientExtension = this.mWebChromeClient;
    if (localIX5WebChromeClientExtension != null) {
      return localIX5WebChromeClientExtension.onAddFavorite(paramIX5WebViewExtension, paramString1, paramString2, paramJsResult);
    }
    return false;
  }
  
  public void onAllMetaDataFinished(IX5WebViewExtension paramIX5WebViewExtension, HashMap<String, String> paramHashMap)
  {
    IX5WebChromeClientExtension localIX5WebChromeClientExtension = this.mWebChromeClient;
    if (localIX5WebChromeClientExtension != null) {
      localIX5WebChromeClientExtension.onAllMetaDataFinished(paramIX5WebViewExtension, paramHashMap);
    }
  }
  
  public void onBackforwardFinished(int paramInt)
  {
    IX5WebChromeClientExtension localIX5WebChromeClientExtension = this.mWebChromeClient;
    if (localIX5WebChromeClientExtension != null) {
      localIX5WebChromeClientExtension.onBackforwardFinished(paramInt);
    }
  }
  
  public void onColorModeChanged(long paramLong) {}
  
  public void onHitTestResultFinished(IX5WebViewExtension paramIX5WebViewExtension, IX5WebViewBase.HitTestResult paramHitTestResult)
  {
    IX5WebChromeClientExtension localIX5WebChromeClientExtension = this.mWebChromeClient;
    if (localIX5WebChromeClientExtension != null) {
      localIX5WebChromeClientExtension.onHitTestResultFinished(paramIX5WebViewExtension, paramHitTestResult);
    }
  }
  
  public void onHitTestResultForPluginFinished(IX5WebViewExtension paramIX5WebViewExtension, IX5WebViewBase.HitTestResult paramHitTestResult, Bundle paramBundle)
  {
    IX5WebChromeClientExtension localIX5WebChromeClientExtension = this.mWebChromeClient;
    if (localIX5WebChromeClientExtension != null) {
      localIX5WebChromeClientExtension.onHitTestResultForPluginFinished(paramIX5WebViewExtension, paramHitTestResult, paramBundle);
    }
  }
  
  public Object onMiscCallBack(String paramString, Bundle paramBundle)
  {
    IX5WebChromeClientExtension localIX5WebChromeClientExtension = this.mWebChromeClient;
    if (localIX5WebChromeClientExtension != null) {
      return localIX5WebChromeClientExtension.onMiscCallBack(paramString, paramBundle);
    }
    return null;
  }
  
  public boolean onPageNotResponding(Runnable paramRunnable)
  {
    IX5WebChromeClientExtension localIX5WebChromeClientExtension = this.mWebChromeClient;
    if (localIX5WebChromeClientExtension != null) {
      return localIX5WebChromeClientExtension.onPageNotResponding(paramRunnable);
    }
    return false;
  }
  
  public boolean onPermissionRequest(String paramString, long paramLong, MediaAccessPermissionsCallback paramMediaAccessPermissionsCallback)
  {
    return false;
  }
  
  public void onPrepareX5ReadPageDataFinished(IX5WebViewExtension paramIX5WebViewExtension, HashMap<String, String> paramHashMap)
  {
    IX5WebChromeClientExtension localIX5WebChromeClientExtension = this.mWebChromeClient;
    if (localIX5WebChromeClientExtension != null) {
      localIX5WebChromeClientExtension.onPrepareX5ReadPageDataFinished(paramIX5WebViewExtension, paramHashMap);
    }
  }
  
  public void onPrintPage() {}
  
  public void onPromptNotScalable(IX5WebViewExtension paramIX5WebViewExtension)
  {
    IX5WebChromeClientExtension localIX5WebChromeClientExtension = this.mWebChromeClient;
    if (localIX5WebChromeClientExtension != null) {
      localIX5WebChromeClientExtension.onPromptNotScalable(paramIX5WebViewExtension);
    }
  }
  
  public void onPromptScaleSaved(IX5WebViewExtension paramIX5WebViewExtension)
  {
    IX5WebChromeClientExtension localIX5WebChromeClientExtension = this.mWebChromeClient;
    if (localIX5WebChromeClientExtension != null) {
      localIX5WebChromeClientExtension.onPromptScaleSaved(paramIX5WebViewExtension);
    }
  }
  
  public boolean onSavePassword(ValueCallback<String> paramValueCallback, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, boolean paramBoolean)
  {
    IX5WebChromeClientExtension localIX5WebChromeClientExtension = this.mWebChromeClient;
    if ((localIX5WebChromeClientExtension != null) && (sCompatibleNewOnSavePassword)) {
      try
      {
        paramBoolean = localIX5WebChromeClientExtension.onSavePassword(paramValueCallback, paramString1, paramString2, paramString3, paramString4, paramString5, paramBoolean);
        return paramBoolean;
      }
      catch (NoSuchMethodError paramValueCallback)
      {
        if ((paramValueCallback.getMessage() != null) && (paramValueCallback.getMessage().contains("onSavePassword")))
        {
          Log.d("incompatible-oldcore", "IX5WebChromeClientExtension.onSavePassword");
          sCompatibleNewOnSavePassword = false;
          return false;
        }
        throw paramValueCallback;
      }
    }
    return false;
  }
  
  public boolean onSavePassword(String paramString1, String paramString2, String paramString3, boolean paramBoolean, Message paramMessage)
  {
    IX5WebChromeClientExtension localIX5WebChromeClientExtension = this.mWebChromeClient;
    if (localIX5WebChromeClientExtension != null) {
      try
      {
        paramBoolean = localIX5WebChromeClientExtension.onSavePassword(paramString1, paramString2, paramString3, paramBoolean, paramMessage);
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
    IX5WebChromeClientExtension localIX5WebChromeClientExtension = this.mWebChromeClient;
    if (localIX5WebChromeClientExtension != null) {
      localIX5WebChromeClientExtension.onX5ReadModeAvailableChecked(paramHashMap);
    }
  }
  
  public void openFileChooser(ValueCallback<Uri[]> paramValueCallback, String paramString1, String paramString2)
  {
    IX5WebChromeClientExtension localIX5WebChromeClientExtension = this.mWebChromeClient;
    if ((localIX5WebChromeClientExtension != null) && (sCompatibleOpenFileChooser)) {
      try
      {
        localIX5WebChromeClientExtension.openFileChooser(paramValueCallback, paramString1, paramString2);
        return;
      }
      catch (NoSuchMethodError paramValueCallback)
      {
        if ((paramValueCallback.getMessage() != null) && (paramValueCallback.getMessage().contains("openFileChooser")))
        {
          Log.d("incompatible-oldcore", "IX5WebChromeClientExtension.openFileChooser");
          sCompatibleOpenFileChooser = false;
          return;
        }
        throw paramValueCallback;
      }
    }
  }
  
  public void releaseWakeLock()
  {
    IX5WebChromeClientExtension localIX5WebChromeClientExtension = this.mWebChromeClient;
    if (localIX5WebChromeClientExtension != null) {
      localIX5WebChromeClientExtension.releaseWakeLock();
    }
  }
  
  public void requestFullScreenFlash()
  {
    IX5WebChromeClientExtension localIX5WebChromeClientExtension = this.mWebChromeClient;
    if (localIX5WebChromeClientExtension != null) {
      localIX5WebChromeClientExtension.requestFullScreenFlash();
    }
  }
  
  public void setWebChromeClientExtend(IX5WebChromeClientExtension paramIX5WebChromeClientExtension)
  {
    this.mWebChromeClient = paramIX5WebChromeClientExtension;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.smtt.export.external.extension.proxy.ProxyWebChromeClientExtension
 * JD-Core Version:    0.7.0.1
 */