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

public abstract class ProxyWebViewClientExtension
  implements IX5WebViewClientExtension
{
  private static boolean sCompatibleOnMetricsSavedCountReceived = true;
  private static boolean sCompatibleOnPageLoadingStartedAndFinished = true;
  protected IX5WebViewClientExtension mWebViewClientExt;
  
  public boolean allowJavaScriptOpenWindowAutomatically(String paramString1, String paramString2)
  {
    if (this.mWebViewClientExt != null) {
      return this.mWebViewClientExt.allowJavaScriptOpenWindowAutomatically(paramString1, paramString2);
    }
    return false;
  }
  
  public void computeScroll(View paramView)
  {
    if (this.mWebViewClientExt != null) {
      this.mWebViewClientExt.computeScroll(paramView);
    }
  }
  
  public void didFirstVisuallyNonEmptyPaint()
  {
    if (this.mWebViewClientExt != null) {
      this.mWebViewClientExt.didFirstVisuallyNonEmptyPaint();
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent, View paramView)
  {
    if (this.mWebViewClientExt != null) {
      return this.mWebViewClientExt.dispatchTouchEvent(paramMotionEvent, paramView);
    }
    return false;
  }
  
  public void documentAvailableInMainFrame()
  {
    if (this.mWebViewClientExt != null) {
      this.mWebViewClientExt.documentAvailableInMainFrame();
    }
  }
  
  public void handlePluginTag(String paramString1, String paramString2, boolean paramBoolean, String paramString3)
  {
    if (this.mWebViewClientExt != null) {
      this.mWebViewClientExt.handlePluginTag(paramString1, paramString2, paramBoolean, paramString3);
    }
  }
  
  public void hideAddressBar()
  {
    if (this.mWebViewClientExt != null) {
      this.mWebViewClientExt.hideAddressBar();
    }
  }
  
  public void invalidate()
  {
    if (this.mWebViewClientExt != null) {
      this.mWebViewClientExt.invalidate();
    }
  }
  
  public boolean notifyAutoAudioPlay(String paramString, JsResult paramJsResult)
  {
    if (this.mWebViewClientExt != null) {
      try
      {
        boolean bool = this.mWebViewClientExt.notifyAutoAudioPlay(paramString, paramJsResult);
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
    if (this.mWebViewClientExt != null) {
      return this.mWebViewClientExt.notifyJavaScriptOpenWindowsBlocked(paramString, paramArrayOfString, paramValueCallback, paramBoolean);
    }
    return false;
  }
  
  public void onDoubleTapStart()
  {
    if (this.mWebViewClientExt != null) {
      this.mWebViewClientExt.onDoubleTapStart();
    }
  }
  
  public void onFakeLoginRecognised(Bundle paramBundle)
  {
    if (this.mWebViewClientExt != null) {
      this.mWebViewClientExt.onFakeLoginRecognised(paramBundle);
    }
  }
  
  public void onFlingScrollBegin(int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.mWebViewClientExt != null) {
      this.mWebViewClientExt.onFlingScrollBegin(paramInt1, paramInt2, paramInt3);
    }
  }
  
  public void onFlingScrollEnd()
  {
    if (this.mWebViewClientExt != null) {
      this.mWebViewClientExt.onFlingScrollEnd();
    }
  }
  
  public void onHideListBox()
  {
    if (this.mWebViewClientExt != null) {
      this.mWebViewClientExt.onHideListBox();
    }
  }
  
  public void onHistoryItemChanged()
  {
    if (this.mWebViewClientExt != null) {
      this.mWebViewClientExt.onHistoryItemChanged();
    }
  }
  
  public void onInputBoxTextChanged(IX5WebViewExtension paramIX5WebViewExtension, String paramString)
  {
    if (this.mWebViewClientExt != null) {
      this.mWebViewClientExt.onInputBoxTextChanged(paramIX5WebViewExtension, paramString);
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent, View paramView)
  {
    if (this.mWebViewClientExt != null) {
      return this.mWebViewClientExt.onInterceptTouchEvent(paramMotionEvent, paramView);
    }
    return false;
  }
  
  public void onMetricsSavedCountReceived(String paramString1, boolean paramBoolean, long paramLong, String paramString2, int paramInt)
  {
    if ((this.mWebViewClientExt != null) && (sCompatibleOnMetricsSavedCountReceived)) {}
    try
    {
      this.mWebViewClientExt.onMetricsSavedCountReceived(paramString1, paramBoolean, paramLong, paramString2, paramInt);
      return;
    }
    catch (NoSuchMethodError paramString1)
    {
      if ((paramString1.getMessage() == null) || (!paramString1.getMessage().contains("onMetricsSavedCountReceived"))) {
        throw paramString1;
      }
      Log.d("incompatible-oldcore", "IX5WebViewClientExtension.onMetricsSavedCountReceived");
      sCompatibleOnMetricsSavedCountReceived = false;
    }
  }
  
  public Object onMiscCallBack(String paramString, Bundle paramBundle)
  {
    if (this.mWebViewClientExt != null) {
      return this.mWebViewClientExt.onMiscCallBack(paramString, paramBundle);
    }
    return null;
  }
  
  public Object onMiscCallBack(String paramString, Bundle paramBundle, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4)
  {
    if (this.mWebViewClientExt != null) {
      return this.mWebViewClientExt.onMiscCallBack(paramString, paramBundle, paramObject1, paramObject2, paramObject3, paramObject4);
    }
    return null;
  }
  
  public void onMissingPluginClicked(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    if (this.mWebViewClientExt != null) {
      this.mWebViewClientExt.onMissingPluginClicked(paramString1, paramString2, paramString3, paramInt);
    }
  }
  
  public void onNativeCrashReport(int paramInt, String paramString)
  {
    if (this.mWebViewClientExt != null) {
      this.mWebViewClientExt.onNativeCrashReport(paramInt, paramString);
    }
  }
  
  public void onOverScrolled(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, View paramView)
  {
    if (this.mWebViewClientExt != null) {
      this.mWebViewClientExt.onOverScrolled(paramInt1, paramInt2, paramBoolean1, paramBoolean2, paramView);
    }
  }
  
  public void onPinchToZoomStart()
  {
    if (this.mWebViewClientExt != null) {
      this.mWebViewClientExt.onPinchToZoomStart();
    }
  }
  
  public void onPreReadFinished()
  {
    if (this.mWebViewClientExt != null) {
      this.mWebViewClientExt.onPreReadFinished();
    }
  }
  
  public void onPrefetchResourceHit(boolean paramBoolean)
  {
    if (this.mWebViewClientExt != null) {
      this.mWebViewClientExt.onPrefetchResourceHit(paramBoolean);
    }
  }
  
  public void onPreloadCallback(int paramInt, String paramString)
  {
    if (this.mWebViewClientExt != null) {
      this.mWebViewClientExt.onPreloadCallback(paramInt, paramString);
    }
  }
  
  public void onPromptScaleSaved()
  {
    if (this.mWebViewClientExt != null) {
      this.mWebViewClientExt.onPromptScaleSaved();
    }
  }
  
  public void onReceivedSslErrorCancel()
  {
    if (this.mWebViewClientExt != null) {
      this.mWebViewClientExt.onReceivedSslErrorCancel();
    }
  }
  
  public void onReceivedViewSource(String paramString)
  {
    if (this.mWebViewClientExt != null) {
      this.mWebViewClientExt.onReceivedViewSource(paramString);
    }
  }
  
  public void onReportAdFilterInfo(int paramInt1, int paramInt2, String paramString, boolean paramBoolean)
  {
    if (this.mWebViewClientExt != null) {
      this.mWebViewClientExt.onReportAdFilterInfo(paramInt1, paramInt2, paramString, paramBoolean);
    }
  }
  
  public void onReportHtmlInfo(int paramInt, String paramString)
  {
    if (this.mWebViewClientExt != null) {
      this.mWebViewClientExt.onReportHtmlInfo(paramInt, paramString);
    }
  }
  
  public void onReportResponseHeaders(String paramString, int paramInt, HashMap<String, String> paramHashMap)
  {
    if (this.mWebViewClientExt != null) {
      this.mWebViewClientExt.onReportResponseHeaders(paramString, paramInt, paramHashMap);
    }
  }
  
  public void onResponseReceived(WebResourceRequest paramWebResourceRequest, WebResourceResponse paramWebResourceResponse, int paramInt)
  {
    if (this.mWebViewClientExt != null) {
      this.mWebViewClientExt.onResponseReceived(paramWebResourceRequest, paramWebResourceResponse, paramInt);
    }
  }
  
  public void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (this.mWebViewClientExt != null) {
      this.mWebViewClientExt.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  public void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4, View paramView)
  {
    if (this.mWebViewClientExt != null) {
      this.mWebViewClientExt.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4, paramView);
    }
  }
  
  public void onSetButtonStatus(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.mWebViewClientExt != null) {
      this.mWebViewClientExt.onSetButtonStatus(paramBoolean1, paramBoolean2);
    }
  }
  
  public void onShowListBox(String[] paramArrayOfString, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt)
  {
    if (this.mWebViewClientExt != null) {
      this.mWebViewClientExt.onShowListBox(paramArrayOfString, paramArrayOfInt1, paramArrayOfInt2, paramInt);
    }
  }
  
  public boolean onShowLongClickPopupMenu()
  {
    if (this.mWebViewClientExt != null) {
      try
      {
        boolean bool = this.mWebViewClientExt.onShowLongClickPopupMenu();
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
    if (this.mWebViewClientExt != null) {
      this.mWebViewClientExt.onShowMutilListBox(paramArrayOfString, paramArrayOfInt1, paramArrayOfInt2, paramArrayOfInt3);
    }
  }
  
  public void onSlidingTitleOffScreen(int paramInt1, int paramInt2)
  {
    if (this.mWebViewClientExt != null) {
      this.mWebViewClientExt.onSlidingTitleOffScreen(paramInt1, paramInt2);
    }
  }
  
  public void onSoftKeyBoardHide(int paramInt)
  {
    if (this.mWebViewClientExt != null) {
      this.mWebViewClientExt.onSoftKeyBoardHide(paramInt);
    }
  }
  
  public void onSoftKeyBoardShow()
  {
    if (this.mWebViewClientExt != null) {
      this.mWebViewClientExt.onSoftKeyBoardShow();
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent, View paramView)
  {
    if (this.mWebViewClientExt != null) {
      return this.mWebViewClientExt.onTouchEvent(paramMotionEvent, paramView);
    }
    return false;
  }
  
  public void onTransitionToCommitted()
  {
    if (this.mWebViewClientExt != null) {
      this.mWebViewClientExt.onTransitionToCommitted();
    }
  }
  
  public void onUploadProgressChange(int paramInt1, int paramInt2, String paramString)
  {
    if (this.mWebViewClientExt != null) {
      this.mWebViewClientExt.onUploadProgressChange(paramInt1, paramInt2, paramString);
    }
  }
  
  public void onUploadProgressStart(int paramInt)
  {
    if (this.mWebViewClientExt != null) {
      this.mWebViewClientExt.onUploadProgressStart(paramInt);
    }
  }
  
  public void onUrlChange(String paramString1, String paramString2)
  {
    if (this.mWebViewClientExt != null) {
      this.mWebViewClientExt.onUrlChange(paramString1, paramString2);
    }
  }
  
  public boolean overScrollBy(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, boolean paramBoolean, View paramView)
  {
    if (this.mWebViewClientExt != null) {
      return this.mWebViewClientExt.overScrollBy(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramBoolean, paramView);
    }
    return false;
  }
  
  public boolean preShouldOverrideUrlLoading(IX5WebViewExtension paramIX5WebViewExtension, String paramString)
  {
    if (this.mWebViewClientExt != null) {
      return this.mWebViewClientExt.preShouldOverrideUrlLoading(paramIX5WebViewExtension, paramString);
    }
    return false;
  }
  
  public void showTranslateBubble(int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    if (this.mWebViewClientExt != null) {
      this.mWebViewClientExt.showTranslateBubble(paramInt1, paramString1, paramString2, paramInt2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.smtt.export.external.extension.proxy.ProxyWebViewClientExtension
 * JD-Core Version:    0.7.0.1
 */