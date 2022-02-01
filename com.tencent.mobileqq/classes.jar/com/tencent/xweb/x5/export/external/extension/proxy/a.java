package com.tencent.xweb.x5.export.external.extension.proxy;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.ValueCallback;
import com.tencent.xweb.JsResult;
import com.tencent.xweb.WebResourceRequest;
import com.tencent.xweb.WebResourceResponse;
import org.xwalk.core.Log;

public class a
{
  private static final String TAG = "ProxyWebViewClientExtension";
  IProxySuperWrapper mSuperProvider;
  
  public boolean allowJavaScriptOpenWindowAutomatically(String paramString1, String paramString2)
  {
    IProxySuperWrapper localIProxySuperWrapper = this.mSuperProvider;
    if (localIProxySuperWrapper != null) {
      return localIProxySuperWrapper.b(paramString1, paramString2);
    }
    Log.e("ProxyWebViewClientExtension", "mSuperProvider Is null");
    return false;
  }
  
  public void computeScroll(View paramView)
  {
    IProxySuperWrapper localIProxySuperWrapper = this.mSuperProvider;
    if (localIProxySuperWrapper != null) {
      localIProxySuperWrapper.a(paramView);
    }
  }
  
  public void didFirstVisuallyNonEmptyPaint()
  {
    IProxySuperWrapper localIProxySuperWrapper = this.mSuperProvider;
    if (localIProxySuperWrapper != null) {
      localIProxySuperWrapper.l();
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent, View paramView)
  {
    IProxySuperWrapper localIProxySuperWrapper = this.mSuperProvider;
    if (localIProxySuperWrapper != null) {
      return localIProxySuperWrapper.c(paramMotionEvent, paramView);
    }
    Log.e("ProxyWebViewClientExtension", "mSuperProvider Is null");
    return false;
  }
  
  public void documentAvailableInMainFrame()
  {
    IProxySuperWrapper localIProxySuperWrapper = this.mSuperProvider;
    if (localIProxySuperWrapper != null) {
      localIProxySuperWrapper.m();
    }
  }
  
  public void handlePluginTag(String paramString1, String paramString2, boolean paramBoolean, String paramString3)
  {
    IProxySuperWrapper localIProxySuperWrapper = this.mSuperProvider;
    if (localIProxySuperWrapper != null) {
      localIProxySuperWrapper.a(paramString1, paramString2, paramBoolean, paramString3);
    }
  }
  
  public void hasDiscardCurrentPage(boolean paramBoolean) {}
  
  public void hideAddressBar()
  {
    IProxySuperWrapper localIProxySuperWrapper = this.mSuperProvider;
    if (localIProxySuperWrapper != null) {
      localIProxySuperWrapper.h();
    }
  }
  
  public void invalidate() {}
  
  public boolean notifyAutoAudioPlay(String paramString, JsResult paramJsResult)
  {
    IProxySuperWrapper localIProxySuperWrapper = this.mSuperProvider;
    if (localIProxySuperWrapper != null) {
      return localIProxySuperWrapper.a(paramString, paramJsResult);
    }
    Log.e("ProxyWebViewClientExtension", "mSuperProvider Is null");
    return false;
  }
  
  public boolean notifyJavaScriptOpenWindowsBlocked(String paramString, String[] paramArrayOfString, ValueCallback<Boolean> paramValueCallback, boolean paramBoolean)
  {
    IProxySuperWrapper localIProxySuperWrapper = this.mSuperProvider;
    if (localIProxySuperWrapper != null) {
      return localIProxySuperWrapper.a(paramString, paramArrayOfString, paramValueCallback, paramBoolean);
    }
    Log.e("ProxyWebViewClientExtension", "mSuperProvider Is null");
    return false;
  }
  
  public void onDoubleTapStart()
  {
    IProxySuperWrapper localIProxySuperWrapper = this.mSuperProvider;
    if (localIProxySuperWrapper != null) {
      localIProxySuperWrapper.i();
    }
  }
  
  public void onFlingScrollBegin(int paramInt1, int paramInt2, int paramInt3)
  {
    IProxySuperWrapper localIProxySuperWrapper = this.mSuperProvider;
    if (localIProxySuperWrapper != null) {
      localIProxySuperWrapper.a(paramInt1, paramInt2, paramInt3);
    }
  }
  
  public void onFlingScrollEnd()
  {
    IProxySuperWrapper localIProxySuperWrapper = this.mSuperProvider;
    if (localIProxySuperWrapper != null) {
      localIProxySuperWrapper.e();
    }
  }
  
  public void onHideListBox()
  {
    IProxySuperWrapper localIProxySuperWrapper = this.mSuperProvider;
    if (localIProxySuperWrapper != null) {
      localIProxySuperWrapper.c();
    }
  }
  
  public void onHistoryItemChanged()
  {
    IProxySuperWrapper localIProxySuperWrapper = this.mSuperProvider;
    if (localIProxySuperWrapper != null) {
      localIProxySuperWrapper.g();
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent, View paramView)
  {
    IProxySuperWrapper localIProxySuperWrapper = this.mSuperProvider;
    if (localIProxySuperWrapper != null) {
      return localIProxySuperWrapper.a(paramMotionEvent, paramView);
    }
    Log.e("ProxyWebViewClientExtension", "mSuperProvider Is null");
    return false;
  }
  
  public void onMetricsSavedCountReceived(String paramString1, boolean paramBoolean, long paramLong, String paramString2, int paramInt)
  {
    IProxySuperWrapper localIProxySuperWrapper = this.mSuperProvider;
    if (localIProxySuperWrapper != null)
    {
      localIProxySuperWrapper.a(paramString1, paramBoolean, paramLong, paramString2, paramInt);
      return;
    }
    Log.e("ProxyWebViewClientExtension", "mSuperProvider Is null");
  }
  
  public Object onMiscCallBack(String paramString, Bundle paramBundle)
  {
    IProxySuperWrapper localIProxySuperWrapper = this.mSuperProvider;
    if (localIProxySuperWrapper != null) {
      return localIProxySuperWrapper.a(paramString, paramBundle);
    }
    return null;
  }
  
  public Object onMiscCallBack(String paramString, Bundle paramBundle, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4)
  {
    IProxySuperWrapper localIProxySuperWrapper = this.mSuperProvider;
    if (localIProxySuperWrapper != null) {
      return localIProxySuperWrapper.a(paramString, paramBundle, paramObject1, paramObject2, paramObject3, paramObject4);
    }
    return null;
  }
  
  public void onMissingPluginClicked(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    IProxySuperWrapper localIProxySuperWrapper = this.mSuperProvider;
    if (localIProxySuperWrapper != null) {
      localIProxySuperWrapper.a(paramString1, paramString2, paramString3, paramInt);
    }
  }
  
  public void onNativeCrashReport(int paramInt, String paramString)
  {
    IProxySuperWrapper localIProxySuperWrapper = this.mSuperProvider;
    if (localIProxySuperWrapper != null) {
      localIProxySuperWrapper.b(paramInt, paramString);
    }
  }
  
  public void onOverScrolled(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, View paramView)
  {
    IProxySuperWrapper localIProxySuperWrapper = this.mSuperProvider;
    if (localIProxySuperWrapper != null)
    {
      localIProxySuperWrapper.a(paramInt1, paramInt2, paramBoolean1, paramBoolean2, paramView);
      return;
    }
    Log.e("ProxyWebViewClientExtension", "mSuperProvider Is null");
  }
  
  public void onPinchToZoomStart()
  {
    IProxySuperWrapper localIProxySuperWrapper = this.mSuperProvider;
    if (localIProxySuperWrapper != null) {
      localIProxySuperWrapper.j();
    }
  }
  
  public void onPreReadFinished()
  {
    IProxySuperWrapper localIProxySuperWrapper = this.mSuperProvider;
    if (localIProxySuperWrapper != null) {
      localIProxySuperWrapper.a();
    }
  }
  
  public void onPrefetchResourceHit(boolean paramBoolean)
  {
    IProxySuperWrapper localIProxySuperWrapper = this.mSuperProvider;
    if (localIProxySuperWrapper != null) {
      localIProxySuperWrapper.a(paramBoolean);
    }
  }
  
  public void onPromptScaleSaved()
  {
    IProxySuperWrapper localIProxySuperWrapper = this.mSuperProvider;
    if (localIProxySuperWrapper != null) {
      localIProxySuperWrapper.b();
    }
  }
  
  public void onReceivedSslErrorCancel()
  {
    IProxySuperWrapper localIProxySuperWrapper = this.mSuperProvider;
    if (localIProxySuperWrapper != null) {
      localIProxySuperWrapper.n();
    }
  }
  
  public void onReceivedViewSource(String paramString)
  {
    IProxySuperWrapper localIProxySuperWrapper = this.mSuperProvider;
    if (localIProxySuperWrapper != null) {
      localIProxySuperWrapper.a(paramString);
    }
  }
  
  public void onReportAdFilterInfo(int paramInt1, int paramInt2, String paramString, boolean paramBoolean)
  {
    IProxySuperWrapper localIProxySuperWrapper = this.mSuperProvider;
    if (localIProxySuperWrapper != null) {
      localIProxySuperWrapper.a(paramInt1, paramInt2, paramString, paramBoolean);
    }
  }
  
  public void onReportHtmlInfo(int paramInt, String paramString)
  {
    IProxySuperWrapper localIProxySuperWrapper = this.mSuperProvider;
    if (localIProxySuperWrapper != null) {
      localIProxySuperWrapper.a(paramInt, paramString);
    }
  }
  
  public void onResponseReceived(WebResourceRequest paramWebResourceRequest, WebResourceResponse paramWebResourceResponse, int paramInt)
  {
    IProxySuperWrapper localIProxySuperWrapper = this.mSuperProvider;
    if (localIProxySuperWrapper != null)
    {
      localIProxySuperWrapper.a(paramWebResourceRequest, paramWebResourceResponse, paramInt);
      return;
    }
    Log.e("ProxyWebViewClientExtension", "mSuperProvider Is null");
  }
  
  public void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    IProxySuperWrapper localIProxySuperWrapper = this.mSuperProvider;
    if (localIProxySuperWrapper != null) {
      localIProxySuperWrapper.a(paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  public void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4, View paramView)
  {
    IProxySuperWrapper localIProxySuperWrapper = this.mSuperProvider;
    if (localIProxySuperWrapper != null)
    {
      localIProxySuperWrapper.a(paramInt1, paramInt2, paramInt3, paramInt4, paramView);
      return;
    }
    Log.e("ProxyWebViewClientExtension", "mSuperProvider Is null");
  }
  
  public void onSetButtonStatus(boolean paramBoolean1, boolean paramBoolean2)
  {
    IProxySuperWrapper localIProxySuperWrapper = this.mSuperProvider;
    if (localIProxySuperWrapper != null) {
      localIProxySuperWrapper.a(paramBoolean1, paramBoolean2);
    }
  }
  
  public void onShowListBox(String[] paramArrayOfString, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt)
  {
    IProxySuperWrapper localIProxySuperWrapper = this.mSuperProvider;
    if (localIProxySuperWrapper != null) {
      localIProxySuperWrapper.a(paramArrayOfString, paramArrayOfInt1, paramArrayOfInt2, paramInt);
    }
  }
  
  public boolean onShowLongClickPopupMenu()
  {
    IProxySuperWrapper localIProxySuperWrapper = this.mSuperProvider;
    if (localIProxySuperWrapper != null) {
      return localIProxySuperWrapper.k();
    }
    Log.e("ProxyWebViewClientExtension", "mSuperProvider Is null");
    return false;
  }
  
  public void onShowMutilListBox(String[] paramArrayOfString, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3)
  {
    IProxySuperWrapper localIProxySuperWrapper = this.mSuperProvider;
    if (localIProxySuperWrapper != null) {
      localIProxySuperWrapper.a(paramArrayOfString, paramArrayOfInt1, paramArrayOfInt2, paramArrayOfInt3);
    }
  }
  
  public void onSlidingTitleOffScreen(int paramInt1, int paramInt2)
  {
    IProxySuperWrapper localIProxySuperWrapper = this.mSuperProvider;
    if (localIProxySuperWrapper != null) {
      localIProxySuperWrapper.a(paramInt1, paramInt2);
    }
  }
  
  public void onSoftKeyBoardHide(int paramInt)
  {
    IProxySuperWrapper localIProxySuperWrapper = this.mSuperProvider;
    if (localIProxySuperWrapper != null) {
      localIProxySuperWrapper.b(paramInt);
    }
  }
  
  public void onSoftKeyBoardShow()
  {
    IProxySuperWrapper localIProxySuperWrapper = this.mSuperProvider;
    if (localIProxySuperWrapper != null) {
      localIProxySuperWrapper.f();
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent, View paramView)
  {
    IProxySuperWrapper localIProxySuperWrapper = this.mSuperProvider;
    if (localIProxySuperWrapper != null) {
      return localIProxySuperWrapper.b(paramMotionEvent, paramView);
    }
    Log.e("ProxyWebViewClientExtension", "mSuperProvider Is null");
    return false;
  }
  
  public void onTransitionToCommitted()
  {
    IProxySuperWrapper localIProxySuperWrapper = this.mSuperProvider;
    if (localIProxySuperWrapper != null) {
      localIProxySuperWrapper.d();
    }
  }
  
  public void onUploadProgressChange(int paramInt1, int paramInt2, String paramString)
  {
    IProxySuperWrapper localIProxySuperWrapper = this.mSuperProvider;
    if (localIProxySuperWrapper != null) {
      localIProxySuperWrapper.a(paramInt1, paramInt2, paramString);
    }
  }
  
  public void onUploadProgressStart(int paramInt)
  {
    IProxySuperWrapper localIProxySuperWrapper = this.mSuperProvider;
    if (localIProxySuperWrapper != null) {
      localIProxySuperWrapper.a(paramInt);
    }
  }
  
  public void onUrlChange(String paramString1, String paramString2)
  {
    IProxySuperWrapper localIProxySuperWrapper = this.mSuperProvider;
    if (localIProxySuperWrapper != null) {
      localIProxySuperWrapper.a(paramString1, paramString2);
    }
  }
  
  public boolean overScrollBy(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, boolean paramBoolean, View paramView)
  {
    IProxySuperWrapper localIProxySuperWrapper = this.mSuperProvider;
    if (localIProxySuperWrapper != null) {
      return localIProxySuperWrapper.a(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramBoolean, paramView);
    }
    Log.e("ProxyWebViewClientExtension", "mSuperProvider Is null");
    return false;
  }
  
  public void setSuperProvider(IProxySuperWrapper paramIProxySuperWrapper)
  {
    this.mSuperProvider = paramIProxySuperWrapper;
  }
  
  public boolean shouldDiscardCurrentPage()
  {
    return false;
  }
  
  public void showTranslateBubble(int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    IProxySuperWrapper localIProxySuperWrapper = this.mSuperProvider;
    if (localIProxySuperWrapper != null)
    {
      localIProxySuperWrapper.a(paramInt1, paramString1, paramString2, paramInt2);
      return;
    }
    Log.e("ProxyWebViewClientExtension", "mSuperProvider Is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.xweb.x5.export.external.extension.proxy.a
 * JD-Core Version:    0.7.0.1
 */