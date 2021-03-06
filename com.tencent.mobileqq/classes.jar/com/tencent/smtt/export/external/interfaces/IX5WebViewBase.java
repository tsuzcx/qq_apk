package com.tencent.smtt.export.external.interfaces;

import android.graphics.Bitmap;
import android.graphics.Picture;
import android.net.http.SslCertificate;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.webkit.ValueCallback;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebViewExtension;
import java.io.BufferedWriter;
import java.io.File;
import java.util.Map;

public abstract interface IX5WebViewBase
{
  public static final int OVER_SCROLL_ALWAYS = 0;
  public static final int OVER_SCROLL_IF_CONTENT_SCROLLS = 1;
  public static final int OVER_SCROLL_NEVER = 2;
  
  public abstract void addJavascriptInterface(Object paramObject, String paramString);
  
  public abstract boolean canGoBack();
  
  public abstract boolean canGoBackOrForward(int paramInt);
  
  public abstract boolean canGoForward();
  
  @Deprecated
  public abstract boolean canZoomIn();
  
  @Deprecated
  public abstract boolean canZoomOut();
  
  public abstract Picture capturePicture();
  
  public abstract void clearCache(boolean paramBoolean);
  
  public abstract void clearFormData();
  
  public abstract void clearHistory();
  
  public abstract void clearMatches();
  
  public abstract void clearSslPreferences();
  
  @Deprecated
  public abstract void clearView();
  
  public abstract void computeScroll();
  
  public abstract IX5WebBackForwardList copyBackForwardList();
  
  public abstract Object createPrintDocumentAdapter(String paramString);
  
  public abstract void destroy();
  
  public abstract void documentHasImages(Message paramMessage);
  
  public abstract void dumpViewHierarchyWithProperties(BufferedWriter paramBufferedWriter, int paramInt);
  
  @Deprecated
  public abstract int findAll(String paramString);
  
  public abstract void findAllAsync(String paramString);
  
  public abstract View findHierarchyView(String paramString, int paramInt);
  
  public abstract void findNext(boolean paramBoolean);
  
  public abstract void flingScroll(int paramInt1, int paramInt2);
  
  public abstract void freeMemory();
  
  public abstract SslCertificate getCertificate();
  
  public abstract int getContentHeight();
  
  public abstract int getContentWidth();
  
  public abstract Bitmap getFavicon();
  
  public abstract IX5WebViewBase.HitTestResult getHitTestResult();
  
  public abstract String[] getHttpAuthUsernamePassword(String paramString1, String paramString2);
  
  public abstract String getOriginalUrl();
  
  public abstract int getProgress();
  
  @Deprecated
  public abstract float getScale();
  
  public abstract IX5WebSettings getSettings();
  
  public abstract String getTitle();
  
  public abstract String getUrl();
  
  public abstract View getView();
  
  public abstract int getVisibleTitleHeight();
  
  public abstract IX5WebViewExtension getX5WebViewExtension();
  
  @Deprecated
  public abstract View getZoomControls();
  
  public abstract void goBack();
  
  public abstract void goBackOrForward(int paramInt);
  
  public abstract void goForward();
  
  public abstract void invokeZoomPicker();
  
  public abstract boolean isPrivateBrowsingEnable();
  
  public abstract void loadData(String paramString1, String paramString2, String paramString3);
  
  public abstract void loadDataWithBaseURL(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5);
  
  public abstract void loadUrl(String paramString);
  
  public abstract void loadUrl(String paramString, Map<String, String> paramMap);
  
  public abstract void onPause();
  
  public abstract void onResume();
  
  public abstract boolean overlayHorizontalScrollbar();
  
  public abstract boolean overlayVerticalScrollbar();
  
  public abstract boolean pageDown(boolean paramBoolean, int paramInt);
  
  public abstract boolean pageUp(boolean paramBoolean, int paramInt);
  
  public abstract void pauseTimers();
  
  public abstract void postUrl(String paramString, byte[] paramArrayOfByte);
  
  public abstract void refreshPlugins(boolean paramBoolean);
  
  public abstract void reload();
  
  public abstract void removeJavascriptInterface(String paramString);
  
  public abstract void requestFocusNodeHref(Message paramMessage);
  
  public abstract void requestImageRef(Message paramMessage);
  
  @Deprecated
  public abstract boolean restorePicture(Bundle paramBundle, File paramFile);
  
  public abstract IX5WebBackForwardList restoreState(Bundle paramBundle);
  
  public abstract void resumeTimers();
  
  @Deprecated
  public abstract void savePassword(String paramString1, String paramString2, String paramString3);
  
  @Deprecated
  public abstract boolean savePicture(Bundle paramBundle, File paramFile);
  
  public abstract IX5WebBackForwardList saveState(Bundle paramBundle);
  
  public abstract void saveWebArchive(String paramString);
  
  public abstract void saveWebArchive(String paramString, boolean paramBoolean, ValueCallback<String> paramValueCallback);
  
  public abstract void setBackgroundColor(int paramInt);
  
  public abstract void setCertificate(SslCertificate paramSslCertificate);
  
  public abstract void setDownloadListener(DownloadListener paramDownloadListener);
  
  public abstract void setFindListener(IX5WebViewBase.FindListener paramFindListener);
  
  public abstract void setHorizontalScrollbarOverlay(boolean paramBoolean);
  
  public abstract void setHttpAuthUsernamePassword(String paramString1, String paramString2, String paramString3, String paramString4);
  
  public abstract void setInitialScale(int paramInt);
  
  @Deprecated
  public abstract void setMapTrackballToArrowKeys(boolean paramBoolean);
  
  public abstract void setNetworkAvailable(boolean paramBoolean);
  
  public abstract void setPictureListener(IX5WebViewBase.PictureListener paramPictureListener);
  
  public abstract void setVerticalScrollbarOverlay(boolean paramBoolean);
  
  public abstract void setWebChromeClient(IX5WebChromeClient paramIX5WebChromeClient);
  
  public abstract void setWebViewClient(IX5WebViewClient paramIX5WebViewClient);
  
  @Deprecated
  public abstract boolean showFindDialog(String paramString, boolean paramBoolean);
  
  public abstract void stopLoading();
  
  public abstract boolean zoomIn();
  
  public abstract boolean zoomOut();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.smtt.export.external.interfaces.IX5WebViewBase
 * JD-Core Version:    0.7.0.1
 */