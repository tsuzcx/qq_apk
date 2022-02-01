package com.tencent.smtt.export.external.extension.proxy;

import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.ValueCallback;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebViewExtension;
import com.tencent.smtt.export.external.interfaces.JsResult;
import com.tencent.smtt.export.external.interfaces.WebResourceRequest;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import java.util.HashMap;
import java.util.List;

public abstract class ProxyWebViewClientExtension
  implements IX5WebViewClientExtension
{
  private static boolean sCompatibleOnMetricsSavedCountReceived = true;
  private static boolean sCompatibleOnPageLoadingStartedAndFinished = true;
  protected IX5WebViewClientExtension mWebViewClientExt;
  
  public boolean allowJavaScriptOpenWindowAutomatically(String paramString1, String paramString2)
  {
    IX5WebViewClientExtension localIX5WebViewClientExtension = this.mWebViewClientExt;
    if (localIX5WebViewClientExtension != null) {
      return localIX5WebViewClientExtension.allowJavaScriptOpenWindowAutomatically(paramString1, paramString2);
    }
    return false;
  }
  
  public void computeScroll(View paramView)
  {
    IX5WebViewClientExtension localIX5WebViewClientExtension = this.mWebViewClientExt;
    if (localIX5WebViewClientExtension != null) {
      localIX5WebViewClientExtension.computeScroll(paramView);
    }
  }
  
  public void didFirstVisuallyNonEmptyPaint()
  {
    IX5WebViewClientExtension localIX5WebViewClientExtension = this.mWebViewClientExt;
    if (localIX5WebViewClientExtension != null) {
      localIX5WebViewClientExtension.didFirstVisuallyNonEmptyPaint();
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent, View paramView)
  {
    IX5WebViewClientExtension localIX5WebViewClientExtension = this.mWebViewClientExt;
    if (localIX5WebViewClientExtension != null) {
      return localIX5WebViewClientExtension.dispatchTouchEvent(paramMotionEvent, paramView);
    }
    return false;
  }
  
  public void documentAvailableInMainFrame()
  {
    IX5WebViewClientExtension localIX5WebViewClientExtension = this.mWebViewClientExt;
    if (localIX5WebViewClientExtension != null) {
      localIX5WebViewClientExtension.documentAvailableInMainFrame();
    }
  }
  
  public int getHostByName(String paramString, List<String> paramList)
  {
    IX5WebViewClientExtension localIX5WebViewClientExtension = this.mWebViewClientExt;
    if (localIX5WebViewClientExtension != null) {}
    try
    {
      int i = localIX5WebViewClientExtension.getHostByName(paramString, paramList);
      return i;
    }
    catch (NoSuchMethodError paramString) {}
    return 0;
    return 0;
  }
  
  public void handlePluginTag(String paramString1, String paramString2, boolean paramBoolean, String paramString3)
  {
    IX5WebViewClientExtension localIX5WebViewClientExtension = this.mWebViewClientExt;
    if (localIX5WebViewClientExtension != null) {
      localIX5WebViewClientExtension.handlePluginTag(paramString1, paramString2, paramBoolean, paramString3);
    }
  }
  
  public void hideAddressBar()
  {
    IX5WebViewClientExtension localIX5WebViewClientExtension = this.mWebViewClientExt;
    if (localIX5WebViewClientExtension != null) {
      localIX5WebViewClientExtension.hideAddressBar();
    }
  }
  
  public void invalidate()
  {
    IX5WebViewClientExtension localIX5WebViewClientExtension = this.mWebViewClientExt;
    if (localIX5WebViewClientExtension != null) {
      localIX5WebViewClientExtension.invalidate();
    }
  }
  
  public boolean notifyAutoAudioPlay(String paramString, JsResult paramJsResult)
  {
    IX5WebViewClientExtension localIX5WebViewClientExtension = this.mWebViewClientExt;
    if (localIX5WebViewClientExtension != null) {
      try
      {
        boolean bool = localIX5WebViewClientExtension.notifyAutoAudioPlay(paramString, paramJsResult);
        return bool;
      }
      catch (NoSuchMethodError paramString)
      {
        paramString.printStackTrace();
      }
    }
    return false;
  }
  
  public boolean notifyJavaScriptOpenWindowsBlocked(String paramString, String[] paramArrayOfString, ValueCallback<Boolean> paramValueCallback, boolean paramBoolean)
  {
    IX5WebViewClientExtension localIX5WebViewClientExtension = this.mWebViewClientExt;
    if (localIX5WebViewClientExtension != null) {
      return localIX5WebViewClientExtension.notifyJavaScriptOpenWindowsBlocked(paramString, paramArrayOfString, paramValueCallback, paramBoolean);
    }
    return false;
  }
  
  public void onDoubleTapStart()
  {
    IX5WebViewClientExtension localIX5WebViewClientExtension = this.mWebViewClientExt;
    if (localIX5WebViewClientExtension != null) {
      localIX5WebViewClientExtension.onDoubleTapStart();
    }
  }
  
  public void onFakeLoginRecognised(Bundle paramBundle)
  {
    IX5WebViewClientExtension localIX5WebViewClientExtension = this.mWebViewClientExt;
    if (localIX5WebViewClientExtension != null) {
      localIX5WebViewClientExtension.onFakeLoginRecognised(paramBundle);
    }
  }
  
  public void onFlingScrollBegin(int paramInt1, int paramInt2, int paramInt3)
  {
    IX5WebViewClientExtension localIX5WebViewClientExtension = this.mWebViewClientExt;
    if (localIX5WebViewClientExtension != null) {
      localIX5WebViewClientExtension.onFlingScrollBegin(paramInt1, paramInt2, paramInt3);
    }
  }
  
  public void onFlingScrollEnd()
  {
    IX5WebViewClientExtension localIX5WebViewClientExtension = this.mWebViewClientExt;
    if (localIX5WebViewClientExtension != null) {
      localIX5WebViewClientExtension.onFlingScrollEnd();
    }
  }
  
  public void onHideListBox()
  {
    IX5WebViewClientExtension localIX5WebViewClientExtension = this.mWebViewClientExt;
    if (localIX5WebViewClientExtension != null) {
      localIX5WebViewClientExtension.onHideListBox();
    }
  }
  
  public void onHistoryItemChanged()
  {
    IX5WebViewClientExtension localIX5WebViewClientExtension = this.mWebViewClientExt;
    if (localIX5WebViewClientExtension != null) {
      localIX5WebViewClientExtension.onHistoryItemChanged();
    }
  }
  
  public void onInputBoxTextChanged(IX5WebViewExtension paramIX5WebViewExtension, String paramString)
  {
    IX5WebViewClientExtension localIX5WebViewClientExtension = this.mWebViewClientExt;
    if (localIX5WebViewClientExtension != null) {
      localIX5WebViewClientExtension.onInputBoxTextChanged(paramIX5WebViewExtension, paramString);
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent, View paramView)
  {
    IX5WebViewClientExtension localIX5WebViewClientExtension = this.mWebViewClientExt;
    if (localIX5WebViewClientExtension != null) {
      return localIX5WebViewClientExtension.onInterceptTouchEvent(paramMotionEvent, paramView);
    }
    return false;
  }
  
  public void onMetricsSavedCountReceived(String paramString1, boolean paramBoolean, long paramLong, String paramString2, int paramInt)
  {
    IX5WebViewClientExtension localIX5WebViewClientExtension = this.mWebViewClientExt;
    if ((localIX5WebViewClientExtension != null) && (sCompatibleOnMetricsSavedCountReceived)) {
      try
      {
        localIX5WebViewClientExtension.onMetricsSavedCountReceived(paramString1, paramBoolean, paramLong, paramString2, paramInt);
        return;
      }
      catch (NoSuchMethodError paramString1)
      {
        if ((paramString1.getMessage() != null) && (paramString1.getMessage().contains("onMetricsSavedCountReceived")))
        {
          Log.d("incompatible-oldcore", "IX5WebViewClientExtension.onMetricsSavedCountReceived");
          sCompatibleOnMetricsSavedCountReceived = false;
          return;
        }
        throw paramString1;
      }
    }
  }
  
  public Object onMiscCallBack(String paramString, Bundle paramBundle)
  {
    IX5WebViewClientExtension localIX5WebViewClientExtension = this.mWebViewClientExt;
    if (localIX5WebViewClientExtension != null) {
      return localIX5WebViewClientExtension.onMiscCallBack(paramString, paramBundle);
    }
    return null;
  }
  
  public Object onMiscCallBack(String paramString, Bundle paramBundle, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4)
  {
    IX5WebViewClientExtension localIX5WebViewClientExtension = this.mWebViewClientExt;
    if (localIX5WebViewClientExtension != null) {
      return localIX5WebViewClientExtension.onMiscCallBack(paramString, paramBundle, paramObject1, paramObject2, paramObject3, paramObject4);
    }
    return null;
  }
  
  public void onMissingPluginClicked(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    IX5WebViewClientExtension localIX5WebViewClientExtension = this.mWebViewClientExt;
    if (localIX5WebViewClientExtension != null) {
      localIX5WebViewClientExtension.onMissingPluginClicked(paramString1, paramString2, paramString3, paramInt);
    }
  }
  
  public void onNativeCrashReport(int paramInt, String paramString)
  {
    IX5WebViewClientExtension localIX5WebViewClientExtension = this.mWebViewClientExt;
    if (localIX5WebViewClientExtension != null) {
      localIX5WebViewClientExtension.onNativeCrashReport(paramInt, paramString);
    }
  }
  
  public void onOverScrolled(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, View paramView)
  {
    IX5WebViewClientExtension localIX5WebViewClientExtension = this.mWebViewClientExt;
    if (localIX5WebViewClientExtension != null) {
      localIX5WebViewClientExtension.onOverScrolled(paramInt1, paramInt2, paramBoolean1, paramBoolean2, paramView);
    }
  }
  
  public void onPinchToZoomStart()
  {
    IX5WebViewClientExtension localIX5WebViewClientExtension = this.mWebViewClientExt;
    if (localIX5WebViewClientExtension != null) {
      localIX5WebViewClientExtension.onPinchToZoomStart();
    }
  }
  
  public void onPreReadFinished()
  {
    IX5WebViewClientExtension localIX5WebViewClientExtension = this.mWebViewClientExt;
    if (localIX5WebViewClientExtension != null) {
      localIX5WebViewClientExtension.onPreReadFinished();
    }
  }
  
  public void onPrefetchResourceHit(boolean paramBoolean)
  {
    IX5WebViewClientExtension localIX5WebViewClientExtension = this.mWebViewClientExt;
    if (localIX5WebViewClientExtension != null) {
      localIX5WebViewClientExtension.onPrefetchResourceHit(paramBoolean);
    }
  }
  
  public void onPreloadCallback(int paramInt, String paramString)
  {
    IX5WebViewClientExtension localIX5WebViewClientExtension = this.mWebViewClientExt;
    if (localIX5WebViewClientExtension != null) {
      localIX5WebViewClientExtension.onPreloadCallback(paramInt, paramString);
    }
  }
  
  public void onPromptScaleSaved()
  {
    IX5WebViewClientExtension localIX5WebViewClientExtension = this.mWebViewClientExt;
    if (localIX5WebViewClientExtension != null) {
      localIX5WebViewClientExtension.onPromptScaleSaved();
    }
  }
  
  public void onReceivedSslErrorCancel()
  {
    IX5WebViewClientExtension localIX5WebViewClientExtension = this.mWebViewClientExt;
    if (localIX5WebViewClientExtension != null) {
      localIX5WebViewClientExtension.onReceivedSslErrorCancel();
    }
  }
  
  public void onReceivedViewSource(String paramString)
  {
    IX5WebViewClientExtension localIX5WebViewClientExtension = this.mWebViewClientExt;
    if (localIX5WebViewClientExtension != null) {
      localIX5WebViewClientExtension.onReceivedViewSource(paramString);
    }
  }
  
  public void onReportAdFilterInfo(int paramInt1, int paramInt2, String paramString, boolean paramBoolean)
  {
    IX5WebViewClientExtension localIX5WebViewClientExtension = this.mWebViewClientExt;
    if (localIX5WebViewClientExtension != null) {
      localIX5WebViewClientExtension.onReportAdFilterInfo(paramInt1, paramInt2, paramString, paramBoolean);
    }
  }
  
  public void onReportHtmlInfo(int paramInt, String paramString)
  {
    IX5WebViewClientExtension localIX5WebViewClientExtension = this.mWebViewClientExt;
    if (localIX5WebViewClientExtension != null) {
      localIX5WebViewClientExtension.onReportHtmlInfo(paramInt, paramString);
    }
  }
  
  public void onReportMemoryCachedResponse(String paramString, int paramInt, HashMap<String, String> paramHashMap)
  {
    IX5WebViewClientExtension localIX5WebViewClientExtension = this.mWebViewClientExt;
    if (localIX5WebViewClientExtension != null) {
      localIX5WebViewClientExtension.onReportMemoryCachedResponse(paramString, paramInt, paramHashMap);
    }
  }
  
  public void onReportResponseHeaders(String paramString, int paramInt, HashMap<String, String> paramHashMap)
  {
    IX5WebViewClientExtension localIX5WebViewClientExtension = this.mWebViewClientExt;
    if (localIX5WebViewClientExtension != null) {
      localIX5WebViewClientExtension.onReportResponseHeaders(paramString, paramInt, paramHashMap);
    }
  }
  
  public void onResponseReceived(WebResourceRequest paramWebResourceRequest, WebResourceResponse paramWebResourceResponse, int paramInt)
  {
    IX5WebViewClientExtension localIX5WebViewClientExtension = this.mWebViewClientExt;
    if (localIX5WebViewClientExtension != null) {
      localIX5WebViewClientExtension.onResponseReceived(paramWebResourceRequest, paramWebResourceResponse, paramInt);
    }
  }
  
  public void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    IX5WebViewClientExtension localIX5WebViewClientExtension = this.mWebViewClientExt;
    if (localIX5WebViewClientExtension != null) {
      localIX5WebViewClientExtension.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  public void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4, View paramView)
  {
    IX5WebViewClientExtension localIX5WebViewClientExtension = this.mWebViewClientExt;
    if (localIX5WebViewClientExtension != null) {
      localIX5WebViewClientExtension.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4, paramView);
    }
  }
  
  public void onSetButtonStatus(boolean paramBoolean1, boolean paramBoolean2)
  {
    IX5WebViewClientExtension localIX5WebViewClientExtension = this.mWebViewClientExt;
    if (localIX5WebViewClientExtension != null) {
      localIX5WebViewClientExtension.onSetButtonStatus(paramBoolean1, paramBoolean2);
    }
  }
  
  public void onShowListBox(String[] paramArrayOfString, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt)
  {
    IX5WebViewClientExtension localIX5WebViewClientExtension = this.mWebViewClientExt;
    if (localIX5WebViewClientExtension != null) {
      localIX5WebViewClientExtension.onShowListBox(paramArrayOfString, paramArrayOfInt1, paramArrayOfInt2, paramInt);
    }
  }
  
  public boolean onShowLongClickPopupMenu()
  {
    IX5WebViewClientExtension localIX5WebViewClientExtension = this.mWebViewClientExt;
    if (localIX5WebViewClientExtension != null) {
      try
      {
        boolean bool = localIX5WebViewClientExtension.onShowLongClickPopupMenu();
        return bool;
      }
      catch (NoSuchMethodError localNoSuchMethodError)
      {
        localNoSuchMethodError.printStackTrace();
      }
    }
    return false;
  }
  
  public void onShowMutilListBox(String[] paramArrayOfString, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3)
  {
    IX5WebViewClientExtension localIX5WebViewClientExtension = this.mWebViewClientExt;
    if (localIX5WebViewClientExtension != null) {
      localIX5WebViewClientExtension.onShowMutilListBox(paramArrayOfString, paramArrayOfInt1, paramArrayOfInt2, paramArrayOfInt3);
    }
  }
  
  public void onSlidingTitleOffScreen(int paramInt1, int paramInt2)
  {
    IX5WebViewClientExtension localIX5WebViewClientExtension = this.mWebViewClientExt;
    if (localIX5WebViewClientExtension != null) {
      localIX5WebViewClientExtension.onSlidingTitleOffScreen(paramInt1, paramInt2);
    }
  }
  
  public void onSoftKeyBoardHide(int paramInt)
  {
    IX5WebViewClientExtension localIX5WebViewClientExtension = this.mWebViewClientExt;
    if (localIX5WebViewClientExtension != null) {
      localIX5WebViewClientExtension.onSoftKeyBoardHide(paramInt);
    }
  }
  
  public void onSoftKeyBoardShow()
  {
    IX5WebViewClientExtension localIX5WebViewClientExtension = this.mWebViewClientExt;
    if (localIX5WebViewClientExtension != null) {
      localIX5WebViewClientExtension.onSoftKeyBoardShow();
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent, View paramView)
  {
    IX5WebViewClientExtension localIX5WebViewClientExtension = this.mWebViewClientExt;
    if (localIX5WebViewClientExtension != null) {
      return localIX5WebViewClientExtension.onTouchEvent(paramMotionEvent, paramView);
    }
    return false;
  }
  
  public void onTransitionToCommitted()
  {
    IX5WebViewClientExtension localIX5WebViewClientExtension = this.mWebViewClientExt;
    if (localIX5WebViewClientExtension != null) {
      localIX5WebViewClientExtension.onTransitionToCommitted();
    }
  }
  
  public void onUploadProgressChange(int paramInt1, int paramInt2, String paramString)
  {
    IX5WebViewClientExtension localIX5WebViewClientExtension = this.mWebViewClientExt;
    if (localIX5WebViewClientExtension != null) {
      localIX5WebViewClientExtension.onUploadProgressChange(paramInt1, paramInt2, paramString);
    }
  }
  
  public void onUploadProgressStart(int paramInt)
  {
    IX5WebViewClientExtension localIX5WebViewClientExtension = this.mWebViewClientExt;
    if (localIX5WebViewClientExtension != null) {
      localIX5WebViewClientExtension.onUploadProgressStart(paramInt);
    }
  }
  
  public void onUrlChange(String paramString1, String paramString2)
  {
    IX5WebViewClientExtension localIX5WebViewClientExtension = this.mWebViewClientExt;
    if (localIX5WebViewClientExtension != null) {
      localIX5WebViewClientExtension.onUrlChange(paramString1, paramString2);
    }
  }
  
  public boolean overScrollBy(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, boolean paramBoolean, View paramView)
  {
    IX5WebViewClientExtension localIX5WebViewClientExtension = this.mWebViewClientExt;
    if (localIX5WebViewClientExtension != null) {
      return localIX5WebViewClientExtension.overScrollBy(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramBoolean, paramView);
    }
    return false;
  }
  
  public boolean preShouldOverrideUrlLoading(IX5WebViewExtension paramIX5WebViewExtension, String paramString)
  {
    IX5WebViewClientExtension localIX5WebViewClientExtension = this.mWebViewClientExt;
    if (localIX5WebViewClientExtension != null) {
      return localIX5WebViewClientExtension.preShouldOverrideUrlLoading(paramIX5WebViewExtension, paramString);
    }
    return false;
  }
  
  public void showTranslateBubble(int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    IX5WebViewClientExtension localIX5WebViewClientExtension = this.mWebViewClientExt;
    if (localIX5WebViewClientExtension != null) {
      localIX5WebViewClientExtension.showTranslateBubble(paramInt1, paramString1, paramString2, paramInt2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.smtt.export.external.extension.proxy.ProxyWebViewClientExtension
 * JD-Core Version:    0.7.0.1
 */