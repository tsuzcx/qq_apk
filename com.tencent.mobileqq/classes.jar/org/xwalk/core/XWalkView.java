package org.xwalk.core;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.graphics.Rect;
import android.net.Uri;
import android.net.http.SslCertificate;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.webkit.ValueCallback;
import android.widget.AbsoluteLayout;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.xweb.util.h;
import java.util.ArrayList;
import java.util.Map;
import org.xwalk.core.extension.XWalkExternalExtensionManagerImpl;

public class XWalkView
  extends AbsoluteLayout
{
  private static final String ANIMATABLE = "animatable";
  public static final int RELOAD_IGNORE_CACHE = 1;
  public static final int RELOAD_NORMAL = 0;
  public static final String SURFACE_VIEW = "SurfaceView";
  private static final String TAG = "XWalkView";
  public static final String TEXTURE_VIEW = "TextureView";
  private static final String XWALK_ATTRS_NAMESPACE = "http://schemas.android.com/apk/res-auto";
  private LazyReflectMethod addJavascriptInterfaceObjectStringMethod = new LazyReflectMethod(null, "addJavascriptInterface", new Class[0]);
  private LazyReflectMethod adjustSelectPositionlongStringintintMethod = new LazyReflectMethod(null, "adjustSelectPosition", new Class[0]);
  private Object bridge;
  private LazyReflectMethod canZoomInMethod = new LazyReflectMethod(null, "canZoomIn", new Class[0]);
  private LazyReflectMethod canZoomOutMethod = new LazyReflectMethod(null, "canZoomOut", new Class[0]);
  private LazyReflectMethod captureBitmapAsyncXWalkGetBitmapCallbackInternalMethod = new LazyReflectMethod(null, "captureBitmapAsync", new Class[0]);
  private LazyReflectMethod clearCacheForSingleFileStringMethod = new LazyReflectMethod(null, "clearCacheForSingleFile", new Class[0]);
  private LazyReflectMethod clearCachebooleanMethod = new LazyReflectMethod(null, "clearCache", new Class[0]);
  private LazyReflectMethod clearClientCertPreferencesRunnableMethod = new LazyReflectMethod(null, "clearClientCertPreferences", new Class[0]);
  private LazyReflectMethod clearFormDataMethod = new LazyReflectMethod(null, "clearFormData", new Class[0]);
  private LazyReflectMethod clearMatchesMethod = new LazyReflectMethod(null, "clearMatches", new Class[0]);
  private LazyReflectMethod clearSslPreferencesMethod = new LazyReflectMethod(null, "clearSslPreferences", new Class[0]);
  private LazyReflectMethod computeHorizontalScrollOffsetMethod = new LazyReflectMethod(null, "computeHorizontalScrollOffset", new Class[0]);
  private LazyReflectMethod computeHorizontalScrollRangeMethod = new LazyReflectMethod(null, "computeHorizontalScrollRange", new Class[0]);
  private LazyReflectMethod computeVerticalScrollExtentMethod = new LazyReflectMethod(null, "computeVerticalScrollExtent", new Class[0]);
  private LazyReflectMethod computeVerticalScrollOffsetMethod = new LazyReflectMethod(null, "computeVerticalScrollOffset", new Class[0]);
  private LazyReflectMethod computeVerticalScrollRangeMethod = new LazyReflectMethod(null, "computeVerticalScrollRange", new Class[0]);
  private ArrayList<Object> constructorParams;
  private ArrayList<Object> constructorTypes;
  private XWalkCoreWrapper coreWrapper;
  private LazyReflectMethod evaluateJavascriptStringValueCallbackMethod = new LazyReflectMethod(null, "evaluateJavascript", new Class[0]);
  private LazyReflectMethod findAllAsyncStringMethod = new LazyReflectMethod(null, "findAllAsync", new Class[0]);
  private LazyReflectMethod findNextbooleanMethod = new LazyReflectMethod(null, "findNext", new Class[0]);
  private LazyReflectMethod getAPIVersionMethod = new LazyReflectMethod(null, "getAPIVersion", new Class[0]);
  private LazyReflectMethod getCertificateMethod = new LazyReflectMethod(null, "getCertificate", new Class[0]);
  private LazyReflectMethod getCompositingSurfaceTypeMethod = new LazyReflectMethod(null, "getCompositingSurfaceType", new Class[0]);
  private LazyReflectMethod getContentHeightMethod = new LazyReflectMethod(null, "getContentHeight", new Class[0]);
  private LazyReflectMethod getExtensionManagerMethod = new LazyReflectMethod(null, "getExtensionManager", new Class[0]);
  private LazyReflectMethod getFaviconMethod = new LazyReflectMethod(null, "getFavicon", new Class[0]);
  private LazyReflectMethod getHitTestResultMethod = new LazyReflectMethod(null, "getHitTestResult", new Class[0]);
  private LazyReflectMethod getImageBitmapToFileMethod = new LazyReflectMethod(null, "getImageBitmapToFile", new Class[0]);
  private LazyReflectMethod getNavigationHistoryMethod = new LazyReflectMethod(null, "getNavigationHistory", new Class[0]);
  private LazyReflectMethod getOriginalUrlMethod = new LazyReflectMethod(null, "getOriginalUrl", new Class[0]);
  private LazyReflectMethod getRefererUrlMethod = new LazyReflectMethod(null, "getRefererUrl", new Class[0]);
  private LazyReflectMethod getRemoteDebuggingUrlMethod = new LazyReflectMethod(null, "getRemoteDebuggingUrl", new Class[0]);
  private LazyReflectMethod getScalenMethod = new LazyReflectMethod(null, "getScale", new Class[0]);
  private LazyReflectMethod getSettingsMethod = new LazyReflectMethod(null, "getSettings", new Class[0]);
  private LazyReflectMethod getTitleMethod = new LazyReflectMethod(null, "getTitle", new Class[0]);
  private LazyReflectMethod getTranslateSampleStringintMethod = new LazyReflectMethod(null, "getTranslateSampleString", new Class[0]);
  private LazyReflectMethod getUrlMethod = new LazyReflectMethod(null, "getUrl", new Class[0]);
  private LazyReflectMethod getUserAgentStringMethod = new LazyReflectMethod(null, "getUserAgentString", new Class[0]);
  private LazyReflectMethod getXWalkContentViewMethod = new LazyReflectMethod(null, "getXWalkContentView", new Class[0]);
  private LazyReflectMethod getXWalkVersionMethod = new LazyReflectMethod(null, "getXWalkVersion", new Class[0]);
  private LazyReflectMethod hasEnteredFullscreenMethod = new LazyReflectMethod(null, "hasEnteredFullscreen", new Class[0]);
  private LazyReflectMethod invokeExtensionMethod = new LazyReflectMethod(null, "invokeExtension", new Class[0]);
  boolean isInitedBottomHeightMethod = false;
  private LazyReflectMethod isSupportExtendPluginForAppbrandMethod = new LazyReflectMethod(null, "isSupportExtendPluginForAppbrand", new Class[0]);
  private LazyReflectMethod leaveFullscreenMethod = new LazyReflectMethod(null, "leaveFullscreen", new Class[0]);
  private LazyReflectMethod loadAppFromManifestStringStringMethod = new LazyReflectMethod(null, "loadAppFromManifest", new Class[0]);
  private LazyReflectMethod loadDataStringStringStringMethod = new LazyReflectMethod(null, "loadData", new Class[0]);
  private LazyReflectMethod loadDataWithBaseURLStringStringStringStringStringMethod = new LazyReflectMethod(null, "loadDataWithBaseURL", new Class[0]);
  private LazyReflectMethod loadStringStringMapMethod = new LazyReflectMethod(null, "load", new Class[0]);
  private LazyReflectMethod loadStringStringMethod = new LazyReflectMethod(null, "load", new Class[0]);
  private LazyReflectMethod loadUrlStringMapMethod = new LazyReflectMethod(null, "loadUrl", new Class[0]);
  private LazyReflectMethod loadUrlStringMethod = new LazyReflectMethod(null, "loadUrl", new Class[0]);
  private String mAnimatable;
  private XWalkView.OverScrolledListener mOverScrolledListener;
  private XWalkView.ScrollChangedListener mScrollChangedListener;
  private LazyReflectMethod onActivityResultintintIntentMethod = new LazyReflectMethod(null, "onActivityResult", new Class[0]);
  private LazyReflectMethod onCreateInputConnectionEditorInfoMethod = new LazyReflectMethod(null, "onCreateInputConnection", new Class[0]);
  private LazyReflectMethod onDestroyMethod = new LazyReflectMethod(null, "onDestroy", new Class[0]);
  private LazyReflectMethod onHideMethod = new LazyReflectMethod(null, "onHide", new Class[0]);
  private LazyReflectMethod onNewIntentIntentMethod = new LazyReflectMethod(null, "onNewIntent", new Class[0]);
  private LazyReflectMethod onPauseMethod = new LazyReflectMethod(null, "onPause", new Class[0]);
  private LazyReflectMethod onResumeMethod = new LazyReflectMethod(null, "onResume", new Class[0]);
  private LazyReflectMethod onShowMethod = new LazyReflectMethod(null, "onShow", new Class[0]);
  private LazyReflectMethod onTouchEventMotionEventMethod = new LazyReflectMethod(null, "onTouchEvent", new Class[0]);
  private LazyReflectMethod pauseTimersMethod = new LazyReflectMethod(null, "pauseTimers", new Class[0]);
  private LazyReflectMethod postWrapperMethod;
  private LazyReflectMethod preInitViewSizeMethod = new LazyReflectMethod(null, "preInitViewSize", new Class[0]);
  private LazyReflectMethod reloadintMethod = new LazyReflectMethod(null, "reload", new Class[0]);
  private LazyReflectMethod removeJavascriptInterfaceStringMethod = new LazyReflectMethod(null, "removeJavascriptInterface", new Class[0]);
  private LazyReflectMethod replaceTranslatedStringMethod = new LazyReflectMethod(null, "replaceTranslatedString", new Class[0]);
  private LazyReflectMethod restoreStateBundleMethod = new LazyReflectMethod(null, "restoreState", new Class[0]);
  private LazyReflectMethod resumeTimersMethod = new LazyReflectMethod(null, "resumeTimers", new Class[0]);
  private LazyReflectMethod savePageMethod = new LazyReflectMethod(null, "savePage", new Class[0]);
  private LazyReflectMethod saveStateBundleMethod = new LazyReflectMethod(null, "saveState", new Class[0]);
  private LazyReflectMethod scrollByintintMethod = new LazyReflectMethod(null, "scrollBy", new Class[0]);
  private LazyReflectMethod scrollTointintMethod = new LazyReflectMethod(null, "scrollTo", new Class[0]);
  private LazyReflectMethod setAcceptLanguagesStringMethod = new LazyReflectMethod(null, "setAcceptLanguages", new Class[0]);
  private LazyReflectMethod setBackgroundColorintMethod = new LazyReflectMethod(null, "setBackgroundColor", new Class[0]);
  private LazyReflectMethod setBottomHeightMethod = new LazyReflectMethod(null, "setBottomHeight", new Class[0]);
  private LazyReflectMethod setDownloadListenerXWalkDownloadListenerInternalMethod = new LazyReflectMethod(null, "setDownloadListener", new Class[0]);
  private LazyReflectMethod setExtendCanvasClientXWalkExtendCanvasClientInternalMethod = new LazyReflectMethod(null, "setExtendCanvasClient", new Class[0]);
  private LazyReflectMethod setExtendPluginClientXWalkExtendPluginClientInternalMethod = new LazyReflectMethod(null, "setExtendPluginClient", new Class[0]);
  private LazyReflectMethod setExtendTextAreaClientXWalkExtendTextAreaClientInternalMethod = new LazyReflectMethod(null, "setExtendTextAreaClient", new Class[0]);
  private LazyReflectMethod setFindListenerXWalkFindListenerInternalMethod = new LazyReflectMethod(null, "setFindListener", new Class[0]);
  private LazyReflectMethod setHorizontalScrollBarEnablebooleanMethod = new LazyReflectMethod(null, "setHorizontalScrollBarEnable", new Class[0]);
  private LazyReflectMethod setInitialScaleintMethod = new LazyReflectMethod(null, "setInitialScale", new Class[0]);
  private LazyReflectMethod setNetworkAvailablebooleanMethod = new LazyReflectMethod(null, "setNetworkAvailable", new Class[0]);
  private LazyReflectMethod setOnTouchListenerOnTouchListenerMethod = new LazyReflectMethod(null, "setOnTouchListener", new Class[0]);
  private LazyReflectMethod setOriginAccessWhitelistStringStringArrayMethod = new LazyReflectMethod(null, "setOriginAccessWhitelist", new Class[0]);
  private LazyReflectMethod setProxyWebViewClientExtensionInternalMethod = new LazyReflectMethod(null, "setProxyWebViewClientExtension", new Class[0]);
  private LazyReflectMethod setResourceClientXWalkResourceClientInternalMethod = new LazyReflectMethod(null, "setResourceClient", new Class[0]);
  private LazyReflectMethod setSurfaceViewVisibilityintMethod = new LazyReflectMethod(null, "setSurfaceViewVisibility", new Class[0]);
  private LazyReflectMethod setTranslateModebooleanMethod = new LazyReflectMethod(null, "setTranslateMode", new Class[0]);
  private LazyReflectMethod setUIClientXWalkUIClientInternalMethod = new LazyReflectMethod(null, "setUIClient", new Class[0]);
  private LazyReflectMethod setUserAgentStringStringMethod = new LazyReflectMethod(null, "setUserAgentString", new Class[0]);
  private LazyReflectMethod setVerticalScrollBarEnablebooleanMethod = new LazyReflectMethod(null, "setVerticalScrollBarEnable", new Class[0]);
  private LazyReflectMethod setXWalkViewInternalVisibilityintMethod = new LazyReflectMethod(null, "setXWalkViewInternalVisibility", new Class[0]);
  private LazyReflectMethod setZOrderOnTopbooleanMethod = new LazyReflectMethod(null, "setZOrderOnTop", new Class[0]);
  private LazyReflectMethod smoothScrollintintMethod = new LazyReflectMethod(null, "smoothScroll", new Class[0]);
  private LazyReflectMethod startActivityForResultIntentintBundleMethod = new LazyReflectMethod(null, "startActivityForResult", new Class[0]);
  private LazyReflectMethod stopLoadingMethod = new LazyReflectMethod(null, "stopLoading", new Class[0]);
  private LazyReflectMethod zoomByfloatMethod = new LazyReflectMethod(null, "zoomBy", new Class[0]);
  private LazyReflectMethod zoomInMethod = new LazyReflectMethod(null, "zoomIn", new Class[0]);
  private LazyReflectMethod zoomOutMethod = new LazyReflectMethod(null, "zoomOut", new Class[0]);
  
  public XWalkView(Context paramContext)
  {
    super(paramContext, null);
    SurfaceView localSurfaceView = new SurfaceView(paramContext);
    localSurfaceView.setLayoutParams(new ViewGroup.LayoutParams(0, 0));
    addView(localSurfaceView);
    this.constructorTypes = new ArrayList();
    this.constructorTypes.add(Context.class);
    this.constructorParams = new ArrayList();
    this.constructorParams.add(paramContext);
    this.postWrapperMethod = new LazyReflectMethod(this, "postXWalkViewInternalContextConstructor", new Class[0]);
    reflectionInit();
  }
  
  @Deprecated
  public XWalkView(Context paramContext, Activity paramActivity)
  {
    super(paramContext, null);
    SurfaceView localSurfaceView = new SurfaceView(paramContext);
    localSurfaceView.setLayoutParams(new ViewGroup.LayoutParams(0, 0));
    addView(localSurfaceView);
    this.constructorTypes = new ArrayList();
    this.constructorTypes.add(Context.class);
    this.constructorTypes.add(Activity.class);
    this.constructorParams = new ArrayList();
    this.constructorParams.add(paramContext);
    this.constructorParams.add(paramActivity);
    this.postWrapperMethod = new LazyReflectMethod(this, "postXWalkViewInternalContextActivityConstructor", new Class[0]);
    reflectionInit();
  }
  
  public XWalkView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    if (isInEditMode()) {
      return;
    }
    if (paramAttributeSet != null) {
      this.mAnimatable = paramAttributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "animatable");
    }
    SurfaceView localSurfaceView = new SurfaceView(paramContext);
    localSurfaceView.setLayoutParams(new ViewGroup.LayoutParams(0, 0));
    addView(localSurfaceView);
    this.constructorTypes = new ArrayList();
    this.constructorTypes.add(Context.class);
    this.constructorTypes.add(AttributeSet.class);
    this.constructorParams = new ArrayList();
    this.constructorParams.add(paramContext);
    this.constructorParams.add(paramAttributeSet);
    this.postWrapperMethod = new LazyReflectMethod(this, "postXWalkViewInternalContextAttributeSetConstructor", new Class[0]);
    reflectionInit();
  }
  
  private void onFocusChangedDelegate(boolean paramBoolean, int paramInt, Rect paramRect)
  {
    onFocusChanged(paramBoolean, paramInt, paramRect);
  }
  
  private void onOverScrolledDelegate(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    onOverScrolled(paramInt1, paramInt2, paramBoolean1, paramBoolean2);
  }
  
  private void onOverscrollRefresh(boolean paramBoolean)
  {
    XWalkView.OverScrolledListener localOverScrolledListener = this.mOverScrolledListener;
    if (localOverScrolledListener != null) {
      localOverScrolledListener.onOverScrolled(paramBoolean);
    }
  }
  
  private boolean onTouchEventDelegate(MotionEvent paramMotionEvent)
  {
    return onTouchEvent(paramMotionEvent);
  }
  
  private boolean performLongClickDelegate()
  {
    return performLongClick();
  }
  
  public void addJavascriptInterface(Object paramObject, String paramString)
  {
    try
    {
      this.addJavascriptInterfaceObjectStringMethod.invoke(new Object[] { paramObject, paramString });
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      if (this.coreWrapper == null)
      {
        this.addJavascriptInterfaceObjectStringMethod.setArguments(new Object[] { paramObject, paramString });
        XWalkCoreWrapper.reserveReflectMethod(this.addJavascriptInterfaceObjectStringMethod);
        return;
      }
      XWalkCoreWrapper.handleRuntimeError(localUnsupportedOperationException);
    }
  }
  
  public void adjustSelectPosition(long paramLong, String paramString, int paramInt1, int paramInt2)
  {
    try
    {
      this.adjustSelectPositionlongStringintintMethod.invoke(new Object[] { Long.valueOf(paramLong), paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      return;
    }
    catch (UnsupportedOperationException paramString)
    {
      if (this.coreWrapper != null)
      {
        XWalkCoreWrapper.handleRuntimeError(paramString);
        return;
      }
      throw new RuntimeException("Crosswalk's APIs are not ready yet");
    }
  }
  
  public boolean canZoomIn()
  {
    try
    {
      boolean bool = ((Boolean)this.canZoomInMethod.invoke(new Object[0])).booleanValue();
      return bool;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      if (this.coreWrapper != null)
      {
        XWalkCoreWrapper.handleRuntimeError(localUnsupportedOperationException);
        return false;
      }
      throw new RuntimeException("Crosswalk's APIs are not ready yet");
    }
  }
  
  public boolean canZoomOut()
  {
    try
    {
      boolean bool = ((Boolean)this.canZoomOutMethod.invoke(new Object[0])).booleanValue();
      return bool;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      if (this.coreWrapper != null)
      {
        XWalkCoreWrapper.handleRuntimeError(localUnsupportedOperationException);
        return false;
      }
      throw new RuntimeException("Crosswalk's APIs are not ready yet");
    }
  }
  
  public void captureBitmapAsync(XWalkGetBitmapCallback paramXWalkGetBitmapCallback)
  {
    try
    {
      this.captureBitmapAsyncXWalkGetBitmapCallbackInternalMethod.invoke(new Object[] { paramXWalkGetBitmapCallback.getBridge() });
      return;
    }
    catch (UnsupportedOperationException paramXWalkGetBitmapCallback)
    {
      if (this.coreWrapper != null)
      {
        XWalkCoreWrapper.handleRuntimeError(paramXWalkGetBitmapCallback);
        return;
      }
      throw new RuntimeException("Crosswalk's APIs are not ready yet");
    }
  }
  
  public void clearCache(boolean paramBoolean)
  {
    try
    {
      this.clearCachebooleanMethod.invoke(new Object[] { Boolean.valueOf(paramBoolean) });
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      if (this.coreWrapper != null)
      {
        XWalkCoreWrapper.handleRuntimeError(localUnsupportedOperationException);
        return;
      }
      throw new RuntimeException("Crosswalk's APIs are not ready yet");
    }
  }
  
  public void clearCacheForSingleFile(String paramString)
  {
    try
    {
      this.clearCacheForSingleFileStringMethod.invoke(new Object[] { paramString });
      return;
    }
    catch (UnsupportedOperationException paramString)
    {
      if (this.coreWrapper != null)
      {
        XWalkCoreWrapper.handleRuntimeError(paramString);
        return;
      }
      throw new RuntimeException("Crosswalk's APIs are not ready yet");
    }
  }
  
  public void clearClientCertPreferences(Runnable paramRunnable)
  {
    try
    {
      this.clearClientCertPreferencesRunnableMethod.invoke(new Object[] { paramRunnable });
      return;
    }
    catch (UnsupportedOperationException paramRunnable)
    {
      if (this.coreWrapper != null)
      {
        XWalkCoreWrapper.handleRuntimeError(paramRunnable);
        return;
      }
      throw new RuntimeException("Crosswalk's APIs are not ready yet");
    }
  }
  
  public void clearFormData()
  {
    try
    {
      this.clearFormDataMethod.invoke(new Object[0]);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      if (this.coreWrapper != null)
      {
        XWalkCoreWrapper.handleRuntimeError(localUnsupportedOperationException);
        return;
      }
      throw new RuntimeException("Crosswalk's APIs are not ready yet");
    }
  }
  
  public void clearMatches()
  {
    try
    {
      this.clearMatchesMethod.invoke(new Object[0]);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      if (this.coreWrapper != null)
      {
        XWalkCoreWrapper.handleRuntimeError(localUnsupportedOperationException);
        return;
      }
      throw new RuntimeException("Crosswalk's APIs are not ready yet");
    }
  }
  
  public void clearSslPreferences()
  {
    try
    {
      this.clearSslPreferencesMethod.invoke(new Object[0]);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      if (this.coreWrapper != null)
      {
        XWalkCoreWrapper.handleRuntimeError(localUnsupportedOperationException);
        return;
      }
      throw new RuntimeException("Crosswalk's APIs are not ready yet");
    }
  }
  
  public int computeHorizontalScrollOffset()
  {
    try
    {
      int i = ((Integer)this.computeHorizontalScrollOffsetMethod.invoke(new Object[0])).intValue();
      return i;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      if (this.coreWrapper != null)
      {
        XWalkCoreWrapper.handleRuntimeError(localUnsupportedOperationException);
        return 0;
      }
      throw new RuntimeException("Crosswalk's APIs are not ready yet");
    }
  }
  
  public int computeHorizontalScrollRange()
  {
    try
    {
      int i = ((Integer)this.computeHorizontalScrollRangeMethod.invoke(new Object[0])).intValue();
      return i;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      if (this.coreWrapper != null)
      {
        XWalkCoreWrapper.handleRuntimeError(localUnsupportedOperationException);
        return 0;
      }
      throw new RuntimeException("Crosswalk's APIs are not ready yet");
    }
  }
  
  public int computeVerticalScrollExtent()
  {
    try
    {
      int i = ((Integer)this.computeVerticalScrollExtentMethod.invoke(new Object[0])).intValue();
      return i;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      if (this.coreWrapper != null)
      {
        XWalkCoreWrapper.handleRuntimeError(localUnsupportedOperationException);
        return 0;
      }
      throw new RuntimeException("Crosswalk's APIs are not ready yet");
    }
  }
  
  public int computeVerticalScrollOffset()
  {
    try
    {
      int i = ((Integer)this.computeVerticalScrollOffsetMethod.invoke(new Object[0])).intValue();
      return i;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      if (this.coreWrapper != null)
      {
        XWalkCoreWrapper.handleRuntimeError(localUnsupportedOperationException);
        return 0;
      }
      throw new RuntimeException("Crosswalk's APIs are not ready yet");
    }
  }
  
  public int computeVerticalScrollRange()
  {
    try
    {
      int i = ((Integer)this.computeVerticalScrollRangeMethod.invoke(new Object[0])).intValue();
      return i;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      if (this.coreWrapper != null)
      {
        XWalkCoreWrapper.handleRuntimeError(localUnsupportedOperationException);
        return 0;
      }
      throw new RuntimeException("Crosswalk's APIs are not ready yet");
    }
  }
  
  public void evaluateJavascript(String paramString, ValueCallback<String> paramValueCallback)
  {
    try
    {
      this.evaluateJavascriptStringValueCallbackMethod.invoke(new Object[] { paramString, paramValueCallback });
      return;
    }
    catch (UnsupportedOperationException paramString)
    {
      if (this.coreWrapper != null)
      {
        XWalkCoreWrapper.handleRuntimeError(paramString);
        return;
      }
      throw new RuntimeException("Crosswalk's APIs are not ready yet");
    }
  }
  
  public void findAllAsync(String paramString)
  {
    try
    {
      this.findAllAsyncStringMethod.invoke(new Object[] { paramString });
      return;
    }
    catch (UnsupportedOperationException paramString)
    {
      if (this.coreWrapper != null)
      {
        XWalkCoreWrapper.handleRuntimeError(paramString);
        return;
      }
      throw new RuntimeException("Crosswalk's APIs are not ready yet");
    }
  }
  
  public void findNext(boolean paramBoolean)
  {
    try
    {
      this.findNextbooleanMethod.invoke(new Object[] { Boolean.valueOf(paramBoolean) });
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      if (this.coreWrapper != null)
      {
        XWalkCoreWrapper.handleRuntimeError(localUnsupportedOperationException);
        return;
      }
      throw new RuntimeException("Crosswalk's APIs are not ready yet");
    }
  }
  
  public String getAPIVersion()
  {
    try
    {
      String str = (String)this.getAPIVersionMethod.invoke(new Object[0]);
      return str;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      if (this.coreWrapper != null)
      {
        XWalkCoreWrapper.handleRuntimeError(localUnsupportedOperationException);
        return null;
      }
      throw new RuntimeException("Crosswalk's APIs are not ready yet");
    }
  }
  
  public Object getBridge()
  {
    return this.bridge;
  }
  
  public SslCertificate getCertificate()
  {
    try
    {
      SslCertificate localSslCertificate = (SslCertificate)this.getCertificateMethod.invoke(new Object[0]);
      return localSslCertificate;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      if (this.coreWrapper != null)
      {
        XWalkCoreWrapper.handleRuntimeError(localUnsupportedOperationException);
        return null;
      }
      throw new RuntimeException("Crosswalk's APIs are not ready yet");
    }
  }
  
  public String getCompositingSurfaceType()
  {
    try
    {
      String str = (String)this.getCompositingSurfaceTypeMethod.invoke(new Object[0]);
      return str;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      if (this.coreWrapper != null)
      {
        XWalkCoreWrapper.handleRuntimeError(localUnsupportedOperationException);
        return null;
      }
      throw new RuntimeException("Crosswalk's APIs are not ready yet");
    }
  }
  
  public int getContentHeight()
  {
    try
    {
      int i = ((Integer)this.getContentHeightMethod.invoke(new Object[0])).intValue();
      return i;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      if (this.coreWrapper != null)
      {
        XWalkCoreWrapper.handleRuntimeError(localUnsupportedOperationException);
        return 0;
      }
      throw new RuntimeException("Crosswalk's APIs are not ready yet");
    }
  }
  
  public XWalkExternalExtensionManager getExtensionManager()
  {
    try
    {
      XWalkExternalExtensionManager localXWalkExternalExtensionManager = (XWalkExternalExtensionManager)this.coreWrapper.getWrapperObject(this.getExtensionManagerMethod.invoke(new Object[0]));
      return localXWalkExternalExtensionManager;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      if (this.coreWrapper != null)
      {
        XWalkCoreWrapper.handleRuntimeError(localUnsupportedOperationException);
        return null;
      }
      throw new RuntimeException("Crosswalk's APIs are not ready yet");
    }
  }
  
  public Bitmap getFavicon()
  {
    try
    {
      Bitmap localBitmap = (Bitmap)this.getFaviconMethod.invoke(new Object[0]);
      return localBitmap;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      if (this.coreWrapper != null)
      {
        XWalkCoreWrapper.handleRuntimeError(localUnsupportedOperationException);
        return null;
      }
      throw new RuntimeException("Crosswalk's APIs are not ready yet");
    }
  }
  
  public XWalkHitTestResult getHitTestResult()
  {
    try
    {
      XWalkHitTestResult localXWalkHitTestResult = (XWalkHitTestResult)this.coreWrapper.getWrapperObject(this.getHitTestResultMethod.invoke(new Object[0]));
      return localXWalkHitTestResult;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      if (this.coreWrapper != null)
      {
        XWalkCoreWrapper.handleRuntimeError(localUnsupportedOperationException);
        return null;
      }
      throw new RuntimeException("Crosswalk's APIs are not ready yet");
    }
  }
  
  public boolean getImageBitmapToFile(String paramString1, String paramString2, String paramString3, XWalkGetImageBitmapToFileFinishedCallback paramXWalkGetImageBitmapToFileFinishedCallback)
  {
    try
    {
      paramString1 = this.getImageBitmapToFileMethod.invoke(new Object[] { paramString1, paramString2, paramString3, paramXWalkGetImageBitmapToFileFinishedCallback.getBridge() });
      if ((paramString1 instanceof Boolean))
      {
        boolean bool = ((Boolean)paramString1).booleanValue();
        return bool;
      }
    }
    catch (Exception paramString1)
    {
      paramString2 = new StringBuilder();
      paramString2.append("getImageBitmapToFile error:");
      paramString2.append(paramString1.getMessage());
      Log.e("XWalkView", paramString2.toString());
      return false;
    }
    catch (UnsupportedOperationException paramString1)
    {
      if (this.coreWrapper != null)
      {
        XWalkCoreWrapper.handleRuntimeError(paramString1);
        return false;
      }
      throw new RuntimeException("Crosswalk's APIs are not ready yet");
    }
  }
  
  public XWalkNavigationHistory getNavigationHistory()
  {
    try
    {
      XWalkNavigationHistory localXWalkNavigationHistory = (XWalkNavigationHistory)this.coreWrapper.getWrapperObject(this.getNavigationHistoryMethod.invoke(new Object[0]));
      return localXWalkNavigationHistory;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      if (this.coreWrapper != null)
      {
        XWalkCoreWrapper.handleRuntimeError(localUnsupportedOperationException);
        return null;
      }
      throw new RuntimeException("Crosswalk's APIs are not ready yet");
    }
  }
  
  public String getOriginalUrl()
  {
    try
    {
      String str = (String)this.getOriginalUrlMethod.invoke(new Object[0]);
      return str;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      if (this.coreWrapper != null)
      {
        XWalkCoreWrapper.handleRuntimeError(localUnsupportedOperationException);
        return null;
      }
      throw new RuntimeException("Crosswalk's APIs are not ready yet");
    }
  }
  
  public String getRefererUrl()
  {
    try
    {
      String str = (String)this.getRefererUrlMethod.invoke(new Object[0]);
      return str;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      if (this.coreWrapper != null)
      {
        XWalkCoreWrapper.handleRuntimeError(localUnsupportedOperationException);
        return null;
      }
      throw new RuntimeException("Crosswalk's APIs are not ready yet");
    }
  }
  
  public Uri getRemoteDebuggingUrl()
  {
    try
    {
      Uri localUri = (Uri)this.getRemoteDebuggingUrlMethod.invoke(new Object[0]);
      return localUri;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      if (this.coreWrapper != null)
      {
        XWalkCoreWrapper.handleRuntimeError(localUnsupportedOperationException);
        return null;
      }
      throw new RuntimeException("Crosswalk's APIs are not ready yet");
    }
  }
  
  public float getScale()
  {
    try
    {
      float f = ((Float)this.getScalenMethod.invoke(new Object[0])).floatValue();
      return f;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      if (this.coreWrapper != null)
      {
        XWalkCoreWrapper.handleRuntimeError(localUnsupportedOperationException);
        return 1.0F;
      }
      throw new RuntimeException("Crosswalk's APIs are not ready yet");
    }
  }
  
  public XWalkSettings getSettings()
  {
    try
    {
      XWalkSettings localXWalkSettings = (XWalkSettings)this.coreWrapper.getWrapperObject(this.getSettingsMethod.invoke(new Object[0]));
      return localXWalkSettings;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      if (this.coreWrapper != null)
      {
        XWalkCoreWrapper.handleRuntimeError(localUnsupportedOperationException);
        return null;
      }
      throw new RuntimeException("Crosswalk's APIs are not ready yet");
    }
  }
  
  public String getTitle()
  {
    try
    {
      String str = (String)this.getTitleMethod.invoke(new Object[0]);
      return str;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      if (this.coreWrapper != null)
      {
        XWalkCoreWrapper.handleRuntimeError(localUnsupportedOperationException);
        return null;
      }
      throw new RuntimeException("Crosswalk's APIs are not ready yet");
    }
  }
  
  public void getTranslateSampleString(int paramInt)
  {
    try
    {
      this.getTranslateSampleStringintMethod.invoke(new Object[] { Integer.valueOf(paramInt) });
      h.a(938, 103);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      if (this.coreWrapper != null)
      {
        XWalkCoreWrapper.handleRuntimeError(localUnsupportedOperationException);
        return;
      }
      throw new RuntimeException("Crosswalk's APIs are not ready yet");
    }
  }
  
  public String getUrl()
  {
    try
    {
      String str = (String)this.getUrlMethod.invoke(new Object[0]);
      return str;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      if (this.coreWrapper != null)
      {
        XWalkCoreWrapper.handleRuntimeError(localUnsupportedOperationException);
        return null;
      }
      throw new RuntimeException("Crosswalk's APIs are not ready yet");
    }
  }
  
  public String getUserAgentString()
  {
    try
    {
      String str = (String)this.getUserAgentStringMethod.invoke(new Object[0]);
      return str;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      if (this.coreWrapper != null)
      {
        XWalkCoreWrapper.handleRuntimeError(localUnsupportedOperationException);
        return null;
      }
      throw new RuntimeException("Crosswalk's APIs are not ready yet");
    }
  }
  
  public ViewGroup getXWalkContentView()
  {
    try
    {
      ViewGroup localViewGroup = (ViewGroup)this.getXWalkContentViewMethod.invoke(new Object[0]);
      return localViewGroup;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      if (this.coreWrapper != null)
      {
        XWalkCoreWrapper.handleRuntimeError(localUnsupportedOperationException);
        return null;
      }
      throw new RuntimeException("Crosswalk's APIs are not ready yet");
    }
  }
  
  public String getXWalkVersion()
  {
    try
    {
      String str = (String)this.getXWalkVersionMethod.invoke(new Object[0]);
      return str;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      if (this.coreWrapper != null)
      {
        XWalkCoreWrapper.handleRuntimeError(localUnsupportedOperationException);
        return null;
      }
      throw new RuntimeException("Crosswalk's APIs are not ready yet");
    }
  }
  
  public boolean hasEnteredFullscreen()
  {
    try
    {
      boolean bool = ((Boolean)this.hasEnteredFullscreenMethod.invoke(new Object[0])).booleanValue();
      return bool;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      if (this.coreWrapper != null)
      {
        XWalkCoreWrapper.handleRuntimeError(localUnsupportedOperationException);
        return false;
      }
      throw new RuntimeException("Crosswalk's APIs are not ready yet");
    }
  }
  
  public Object invokeExtension(int paramInt, Object paramObject)
  {
    Object localObject = this.invokeExtensionMethod;
    if (localObject == null)
    {
      Log.e("XWalkView", "invokeExtension not support this feature:");
      return null;
    }
    try
    {
      paramObject = ((LazyReflectMethod)localObject).invoke(new Object[] { Integer.valueOf(paramInt), paramObject });
      return paramObject;
    }
    catch (Exception paramObject)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("invokeExtension error:");
      ((StringBuilder)localObject).append(paramObject.getMessage());
      Log.e("XWalkView", ((StringBuilder)localObject).toString());
      return null;
    }
    catch (UnsupportedOperationException paramObject)
    {
      if (this.coreWrapper != null)
      {
        XWalkCoreWrapper.handleRuntimeError(paramObject);
        return null;
      }
      throw new RuntimeException("Crosswalk's APIs are not ready yet");
    }
  }
  
  public boolean isSupportExtendPluginForAppbrand()
  {
    try
    {
      boolean bool = ((Boolean)this.isSupportExtendPluginForAppbrandMethod.invoke(new Object[0])).booleanValue();
      return bool;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      if (this.coreWrapper != null)
      {
        XWalkCoreWrapper.handleRuntimeError(localUnsupportedOperationException);
        return false;
      }
      throw new RuntimeException("Crosswalk's APIs are not ready yet");
    }
  }
  
  public void leaveFullscreen()
  {
    try
    {
      this.leaveFullscreenMethod.invoke(new Object[0]);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      if (this.coreWrapper != null)
      {
        XWalkCoreWrapper.handleRuntimeError(localUnsupportedOperationException);
        return;
      }
      throw new RuntimeException("Crosswalk's APIs are not ready yet");
    }
  }
  
  @Deprecated
  public void load(String paramString1, String paramString2)
  {
    try
    {
      this.loadStringStringMethod.invoke(new Object[] { paramString1, paramString2 });
      return;
    }
    catch (UnsupportedOperationException paramString1)
    {
      if (this.coreWrapper != null)
      {
        XWalkCoreWrapper.handleRuntimeError(paramString1);
        return;
      }
      throw new RuntimeException("Crosswalk's APIs are not ready yet");
    }
  }
  
  @Deprecated
  public void load(String paramString1, String paramString2, Map<String, String> paramMap)
  {
    try
    {
      this.loadStringStringMapMethod.invoke(new Object[] { paramString1, paramString2, paramMap });
      return;
    }
    catch (UnsupportedOperationException paramString1)
    {
      if (this.coreWrapper != null)
      {
        XWalkCoreWrapper.handleRuntimeError(paramString1);
        return;
      }
      throw new RuntimeException("Crosswalk's APIs are not ready yet");
    }
  }
  
  public void loadAppFromManifest(String paramString1, String paramString2)
  {
    try
    {
      this.loadAppFromManifestStringStringMethod.invoke(new Object[] { paramString1, paramString2 });
      return;
    }
    catch (UnsupportedOperationException paramString1)
    {
      if (this.coreWrapper != null)
      {
        XWalkCoreWrapper.handleRuntimeError(paramString1);
        return;
      }
      throw new RuntimeException("Crosswalk's APIs are not ready yet");
    }
  }
  
  public void loadData(String paramString1, String paramString2, String paramString3)
  {
    try
    {
      this.loadDataStringStringStringMethod.invoke(new Object[] { paramString1, paramString2, paramString3 });
      return;
    }
    catch (UnsupportedOperationException paramString1)
    {
      if (this.coreWrapper != null)
      {
        XWalkCoreWrapper.handleRuntimeError(paramString1);
        return;
      }
      throw new RuntimeException("Crosswalk's APIs are not ready yet");
    }
  }
  
  public void loadDataWithBaseURL(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    try
    {
      this.loadDataWithBaseURLStringStringStringStringStringMethod.invoke(new Object[] { paramString1, paramString2, paramString3, paramString4, paramString5 });
      return;
    }
    catch (UnsupportedOperationException paramString1)
    {
      if (this.coreWrapper != null)
      {
        XWalkCoreWrapper.handleRuntimeError(paramString1);
        return;
      }
      throw new RuntimeException("Crosswalk's APIs are not ready yet");
    }
  }
  
  public void loadUrl(String paramString)
  {
    try
    {
      this.loadUrlStringMethod.invoke(new Object[] { paramString });
      return;
    }
    catch (UnsupportedOperationException paramString)
    {
      if (this.coreWrapper != null)
      {
        XWalkCoreWrapper.handleRuntimeError(paramString);
        return;
      }
      throw new RuntimeException("Crosswalk's APIs are not ready yet");
    }
  }
  
  public void loadUrl(String paramString, Map<String, String> paramMap)
  {
    try
    {
      this.loadUrlStringMapMethod.invoke(new Object[] { paramString, paramMap });
      return;
    }
    catch (UnsupportedOperationException paramString)
    {
      if (this.coreWrapper != null)
      {
        XWalkCoreWrapper.handleRuntimeError(paramString);
        return;
      }
      throw new RuntimeException("Crosswalk's APIs are not ready yet");
    }
  }
  
  @Deprecated
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    try
    {
      this.onActivityResultintintIntentMethod.invoke(new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramIntent });
      return;
    }
    catch (UnsupportedOperationException paramIntent)
    {
      if (this.coreWrapper != null)
      {
        XWalkCoreWrapper.handleRuntimeError(paramIntent);
        return;
      }
      throw new RuntimeException("Crosswalk's APIs are not ready yet");
    }
  }
  
  public InputConnection onCreateInputConnection(EditorInfo paramEditorInfo)
  {
    try
    {
      paramEditorInfo = (InputConnection)this.onCreateInputConnectionEditorInfoMethod.invoke(new Object[] { paramEditorInfo });
      return paramEditorInfo;
    }
    catch (UnsupportedOperationException paramEditorInfo)
    {
      if (this.coreWrapper != null)
      {
        XWalkCoreWrapper.handleRuntimeError(paramEditorInfo);
        return null;
      }
      throw new RuntimeException("Crosswalk's APIs are not ready yet");
    }
  }
  
  public void onDestroy()
  {
    try
    {
      this.onDestroyMethod.invoke(new Object[0]);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      if (this.coreWrapper != null)
      {
        XWalkCoreWrapper.handleRuntimeError(localUnsupportedOperationException);
        return;
      }
      throw new RuntimeException("Crosswalk's APIs are not ready yet");
    }
  }
  
  public void onHide()
  {
    try
    {
      this.onHideMethod.invoke(new Object[0]);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      if (this.coreWrapper != null)
      {
        XWalkCoreWrapper.handleRuntimeError(localUnsupportedOperationException);
        return;
      }
      throw new RuntimeException("Crosswalk's APIs are not ready yet");
    }
  }
  
  public boolean onNewIntent(Intent paramIntent)
  {
    try
    {
      boolean bool = ((Boolean)this.onNewIntentIntentMethod.invoke(new Object[] { paramIntent })).booleanValue();
      return bool;
    }
    catch (UnsupportedOperationException paramIntent)
    {
      if (this.coreWrapper != null)
      {
        XWalkCoreWrapper.handleRuntimeError(paramIntent);
        return false;
      }
      throw new RuntimeException("Crosswalk's APIs are not ready yet");
    }
  }
  
  public void onPause()
  {
    if (!XWalkCoreWrapper.getInstance().hasFeature(1)) {
      return;
    }
    try
    {
      this.onPauseMethod.invoke(new Object[0]);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      if (this.coreWrapper != null)
      {
        XWalkCoreWrapper.handleRuntimeError(localUnsupportedOperationException);
        return;
      }
      throw new RuntimeException("Crosswalk's APIs are not ready yet");
    }
  }
  
  public void onResume()
  {
    if (!XWalkCoreWrapper.getInstance().hasFeature(1)) {
      return;
    }
    try
    {
      this.onResumeMethod.invoke(new Object[0]);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      if (this.coreWrapper != null)
      {
        XWalkCoreWrapper.handleRuntimeError(localUnsupportedOperationException);
        return;
      }
      throw new RuntimeException("Crosswalk's APIs are not ready yet");
    }
  }
  
  public void onScrollChangedDelegate(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    XWalkView.ScrollChangedListener localScrollChangedListener = this.mScrollChangedListener;
    if (localScrollChangedListener != null) {
      localScrollChangedListener.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  public void onShow()
  {
    try
    {
      this.onShowMethod.invoke(new Object[0]);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      if (this.coreWrapper != null)
      {
        XWalkCoreWrapper.handleRuntimeError(localUnsupportedOperationException);
        return;
      }
      throw new RuntimeException("Crosswalk's APIs are not ready yet");
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    try
    {
      boolean bool = ((Boolean)this.onTouchEventMotionEventMethod.invoke(new Object[] { paramMotionEvent })).booleanValue();
      return bool;
    }
    catch (UnsupportedOperationException paramMotionEvent)
    {
      if (this.coreWrapper != null)
      {
        XWalkCoreWrapper.handleRuntimeError(paramMotionEvent);
        return false;
      }
      throw new RuntimeException("Crosswalk's APIs are not ready yet");
    }
  }
  
  public void pauseTimers()
  {
    try
    {
      this.pauseTimersMethod.invoke(new Object[0]);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      if (this.coreWrapper != null)
      {
        XWalkCoreWrapper.handleRuntimeError(localUnsupportedOperationException);
        return;
      }
      throw new RuntimeException("Crosswalk's APIs are not ready yet");
    }
  }
  
  public void postXWalkViewInternalContextActivityConstructor()
  {
    addView((FrameLayout)this.bridge, new FrameLayout.LayoutParams(-1, -1));
    removeViewAt(0);
    new XWalkExternalExtensionManagerImpl(this);
  }
  
  public void postXWalkViewInternalContextAttributeSetConstructor()
  {
    addView((FrameLayout)this.bridge, new FrameLayout.LayoutParams(-1, -1));
    removeViewAt(0);
    new XWalkExternalExtensionManagerImpl(this);
  }
  
  public void postXWalkViewInternalContextConstructor()
  {
    addView((FrameLayout)this.bridge, new FrameLayout.LayoutParams(-1, -1));
    removeViewAt(0);
    new XWalkExternalExtensionManagerImpl(this);
  }
  
  public boolean preInitViewSize(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    try
    {
      paramBoolean = ((Boolean)this.preInitViewSizeMethod.invoke(new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(paramBoolean) })).booleanValue();
      return paramBoolean;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("fakeViewSizeForPreload error exception:");
      localStringBuilder.append(localException);
      Log.e("XWalkView", localStringBuilder.toString());
      return false;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      if (this.coreWrapper != null)
      {
        XWalkCoreWrapper.handleRuntimeError(localUnsupportedOperationException);
        return false;
      }
      throw new RuntimeException("Crosswalk's APIs are not ready yet");
    }
  }
  
  void reflectionInit()
  {
    XWalkCoreWrapper.initEmbeddedMode();
    this.coreWrapper = XWalkCoreWrapper.getInstance();
    if (this.coreWrapper == null)
    {
      XWalkCoreWrapper.reserveReflectObject(this);
      return;
    }
    int j = this.constructorTypes.size();
    Object localObject1 = new Class[j + 1];
    int i = 0;
    while (i < j)
    {
      Object localObject2 = this.constructorTypes.get(i);
      if ((localObject2 instanceof String))
      {
        localObject1[i] = this.coreWrapper.getBridgeClass((String)localObject2);
        localObject2 = this.constructorParams;
        ((ArrayList)localObject2).set(i, this.coreWrapper.getBridgeObject(((ArrayList)localObject2).get(i)));
      }
      else if ((localObject2 instanceof Class))
      {
        localObject1[i] = ((Class)localObject2);
      }
      i += 1;
    }
    localObject1[j] = Object.class;
    this.constructorParams.add(this);
    localObject1 = new ReflectConstructor(this.coreWrapper.getBridgeClass("XWalkViewBridge"), (Class[])localObject1);
    try
    {
      this.bridge = ((ReflectConstructor)localObject1).newInstance(this.constructorParams.toArray());
      localObject1 = this.postWrapperMethod;
      if (localObject1 != null) {
        ((LazyReflectMethod)localObject1).invoke(new Object[0]);
      }
      this.loadStringStringMethod.init(this.bridge, null, "loadSuper", new Class[] { String.class, String.class });
      this.loadStringStringMapMethod.init(this.bridge, null, "loadSuper", new Class[] { String.class, String.class, Map.class });
      this.loadDataStringStringStringMethod.init(this.bridge, null, "loadDataSuper", new Class[] { String.class, String.class, String.class });
      this.loadDataWithBaseURLStringStringStringStringStringMethod.init(this.bridge, null, "loadDataWithBaseURLSuper", new Class[] { String.class, String.class, String.class, String.class, String.class });
      this.loadUrlStringMethod.init(this.bridge, null, "loadUrlSuper", new Class[] { String.class });
      this.loadUrlStringMapMethod.init(this.bridge, null, "loadUrlSuper", new Class[] { String.class, Map.class });
      this.loadAppFromManifestStringStringMethod.init(this.bridge, null, "loadAppFromManifestSuper", new Class[] { String.class, String.class });
      this.reloadintMethod.init(this.bridge, null, "reloadSuper", new Class[] { Integer.TYPE });
      this.stopLoadingMethod.init(this.bridge, null, "stopLoadingSuper", new Class[0]);
      this.getUrlMethod.init(this.bridge, null, "getUrlSuper", new Class[0]);
      this.savePageMethod.init(this.bridge, null, "savePageSuper", new Class[] { String.class, String.class, Integer.TYPE });
      this.getHitTestResultMethod.init(this.bridge, null, "getHitTestResultSuper", new Class[0]);
      this.getContentHeightMethod.init(this.bridge, null, "getContentHeightSuper", new Class[0]);
      this.getTitleMethod.init(this.bridge, null, "getTitleSuper", new Class[0]);
      this.getOriginalUrlMethod.init(this.bridge, null, "getOriginalUrlSuper", new Class[0]);
      this.getNavigationHistoryMethod.init(this.bridge, null, "getNavigationHistorySuper", new Class[0]);
      this.addJavascriptInterfaceObjectStringMethod.init(this.bridge, null, "addJavascriptInterfaceSuper", new Class[] { Object.class, String.class });
      this.removeJavascriptInterfaceStringMethod.init(this.bridge, null, "removeJavascriptInterfaceSuper", new Class[] { String.class });
      this.evaluateJavascriptStringValueCallbackMethod.init(this.bridge, null, "evaluateJavascriptSuper", new Class[] { String.class, ValueCallback.class });
      this.clearCachebooleanMethod.init(this.bridge, null, "clearCacheSuper", new Class[] { Boolean.TYPE });
      this.clearCacheForSingleFileStringMethod.init(this.bridge, null, "clearCacheForSingleFileSuper", new Class[] { String.class });
      this.hasEnteredFullscreenMethod.init(this.bridge, null, "hasEnteredFullscreenSuper", new Class[0]);
      this.leaveFullscreenMethod.init(this.bridge, null, "leaveFullscreenSuper", new Class[0]);
      this.pauseTimersMethod.init(this.bridge, null, "pauseTimersSuper", new Class[0]);
      this.resumeTimersMethod.init(this.bridge, null, "resumeTimersSuper", new Class[0]);
      this.onHideMethod.init(this.bridge, null, "onHideSuper", new Class[0]);
      this.onShowMethod.init(this.bridge, null, "onShowSuper", new Class[0]);
      if (XWalkCoreWrapper.getInstance().hasFeature(1))
      {
        this.onPauseMethod.init(this.bridge, null, "onPauseSuper", new Class[0]);
        this.onResumeMethod.init(this.bridge, null, "onResumeSuper", new Class[0]);
      }
      this.onDestroyMethod.init(this.bridge, null, "onDestroySuper", new Class[0]);
      this.startActivityForResultIntentintBundleMethod.init(this.bridge, null, "startActivityForResultSuper", new Class[] { Intent.class, Integer.TYPE, Bundle.class });
      this.onActivityResultintintIntentMethod.init(this.bridge, null, "onActivityResultSuper", new Class[] { Integer.TYPE, Integer.TYPE, Intent.class });
      this.onNewIntentIntentMethod.init(this.bridge, null, "onNewIntentSuper", new Class[] { Intent.class });
      this.saveStateBundleMethod.init(this.bridge, null, "saveStateSuper", new Class[] { Bundle.class });
      this.restoreStateBundleMethod.init(this.bridge, null, "restoreStateSuper", new Class[] { Bundle.class });
      this.getAPIVersionMethod.init(this.bridge, null, "getAPIVersionSuper", new Class[0]);
      this.getXWalkVersionMethod.init(this.bridge, null, "getXWalkVersionSuper", new Class[0]);
      this.setUIClientXWalkUIClientInternalMethod.init(this.bridge, null, "setUIClientSuper", new Class[] { this.coreWrapper.getBridgeClass("XWalkUIClientBridge") });
      this.setExtendPluginClientXWalkExtendPluginClientInternalMethod.init(this.bridge, null, "setExtendPluginClientSuper", new Class[] { this.coreWrapper.getBridgeClass("XWalkExtendPluginClientBridge") });
      this.setExtendCanvasClientXWalkExtendCanvasClientInternalMethod.init(this.bridge, null, "setExtendCanvasClientSuper", new Class[] { this.coreWrapper.getBridgeClass("XWalkExtendCanvasClientBridge") });
      this.setExtendTextAreaClientXWalkExtendTextAreaClientInternalMethod.init(this.bridge, null, "setExtendTextAreaClientSuper", new Class[] { this.coreWrapper.getBridgeClass("XWalkExtendTextAreaClientBridge") });
      this.setResourceClientXWalkResourceClientInternalMethod.init(this.bridge, null, "setResourceClientSuper", new Class[] { this.coreWrapper.getBridgeClass("XWalkResourceClientBridge") });
      this.setProxyWebViewClientExtensionInternalMethod.init(this.bridge, null, "setProxyWebViewClientExtensionSuper", new Class[] { this.coreWrapper.getBridgeClass("XWalkProxyWebViewClientExtensionBridge") });
      this.setBackgroundColorintMethod.init(this.bridge, null, "setBackgroundColorSuper", new Class[] { Integer.TYPE });
      this.setOriginAccessWhitelistStringStringArrayMethod.init(this.bridge, null, "setOriginAccessWhitelistSuper", new Class[] { String.class, [Ljava.lang.String.class });
      this.setUserAgentStringStringMethod.init(this.bridge, null, "setUserAgentStringSuper", new Class[] { String.class });
      this.getUserAgentStringMethod.init(this.bridge, null, "getUserAgentStringSuper", new Class[0]);
      this.setAcceptLanguagesStringMethod.init(this.bridge, null, "setAcceptLanguagesSuper", new Class[] { String.class });
      this.captureBitmapAsyncXWalkGetBitmapCallbackInternalMethod.init(this.bridge, null, "captureBitmapAsyncSuper", new Class[] { this.coreWrapper.getBridgeClass("XWalkGetBitmapCallbackBridge") });
      this.getSettingsMethod.init(this.bridge, null, "getSettingsSuper", new Class[0]);
      this.setNetworkAvailablebooleanMethod.init(this.bridge, null, "setNetworkAvailableSuper", new Class[] { Boolean.TYPE });
      this.getRemoteDebuggingUrlMethod.init(this.bridge, null, "getRemoteDebuggingUrlSuper", new Class[0]);
      this.getScalenMethod.init(this.bridge, null, "getScaleSuper", new Class[0]);
      this.zoomInMethod.init(this.bridge, null, "zoomInSuper", new Class[0]);
      this.zoomOutMethod.init(this.bridge, null, "zoomOutSuper", new Class[0]);
      this.zoomByfloatMethod.init(this.bridge, null, "zoomBySuper", new Class[] { Float.TYPE });
      this.canZoomInMethod.init(this.bridge, null, "canZoomInSuper", new Class[0]);
      this.canZoomOutMethod.init(this.bridge, null, "canZoomOutSuper", new Class[0]);
      this.onCreateInputConnectionEditorInfoMethod.init(this.bridge, null, "onCreateInputConnectionSuper", new Class[] { EditorInfo.class });
      this.setInitialScaleintMethod.init(this.bridge, null, "setInitialScaleSuper", new Class[] { Integer.TYPE });
      this.getFaviconMethod.init(this.bridge, null, "getFaviconSuper", new Class[0]);
      this.setZOrderOnTopbooleanMethod.init(this.bridge, null, "setZOrderOnTopSuper", new Class[] { Boolean.TYPE });
      this.clearFormDataMethod.init(this.bridge, null, "clearFormDataSuper", new Class[0]);
      this.setSurfaceViewVisibilityintMethod.init(this.bridge, null, "setSurfaceViewVisibilitySuper", new Class[] { Integer.TYPE });
      this.setXWalkViewInternalVisibilityintMethod.init(this.bridge, null, "setXWalkViewInternalVisibilitySuper", new Class[] { Integer.TYPE });
      this.setDownloadListenerXWalkDownloadListenerInternalMethod.init(this.bridge, null, "setDownloadListenerSuper", new Class[] { this.coreWrapper.getBridgeClass("XWalkDownloadListenerBridge") });
      this.onTouchEventMotionEventMethod.init(this.bridge, null, "onTouchEventSuper", new Class[] { MotionEvent.class });
      this.setOnTouchListenerOnTouchListenerMethod.init(this.bridge, null, "setOnTouchListenerSuper", new Class[] { View.OnTouchListener.class });
      this.smoothScrollintintMethod.init(this.bridge, null, "smoothScrollSuper", new Class[] { Integer.TYPE, Integer.TYPE, Long.TYPE });
      this.scrollTointintMethod.init(this.bridge, null, "scrollToSuper", new Class[] { Integer.TYPE, Integer.TYPE });
      this.scrollByintintMethod.init(this.bridge, null, "scrollBySuper", new Class[] { Integer.TYPE, Integer.TYPE });
      this.computeHorizontalScrollRangeMethod.init(this.bridge, null, "computeHorizontalScrollRangeSuper", new Class[0]);
      this.computeHorizontalScrollOffsetMethod.init(this.bridge, null, "computeHorizontalScrollOffsetSuper", new Class[0]);
      this.computeVerticalScrollRangeMethod.init(this.bridge, null, "computeVerticalScrollRangeSuper", new Class[0]);
      this.computeVerticalScrollOffsetMethod.init(this.bridge, null, "computeVerticalScrollOffsetSuper", new Class[0]);
      this.computeVerticalScrollExtentMethod.init(this.bridge, null, "computeVerticalScrollExtentSuper", new Class[0]);
      this.getExtensionManagerMethod.init(this.bridge, null, "getExtensionManagerSuper", new Class[0]);
      this.clearSslPreferencesMethod.init(this.bridge, null, "clearSslPreferencesSuper", new Class[0]);
      this.clearClientCertPreferencesRunnableMethod.init(this.bridge, null, "clearClientCertPreferencesSuper", new Class[] { Runnable.class });
      this.getCertificateMethod.init(this.bridge, null, "getCertificateSuper", new Class[0]);
      this.setFindListenerXWalkFindListenerInternalMethod.init(this.bridge, null, "setFindListenerSuper", new Class[] { this.coreWrapper.getBridgeClass("XWalkFindListenerBridge") });
      this.findAllAsyncStringMethod.init(this.bridge, null, "findAllAsyncSuper", new Class[] { String.class });
      this.findNextbooleanMethod.init(this.bridge, null, "findNextSuper", new Class[] { Boolean.TYPE });
      this.clearMatchesMethod.init(this.bridge, null, "clearMatchesSuper", new Class[0]);
      this.getCompositingSurfaceTypeMethod.init(this.bridge, null, "getCompositingSurfaceTypeSuper", new Class[0]);
      this.getXWalkContentViewMethod.init(this.bridge, null, "getXWalkContentViewSuper", new Class[0]);
      this.adjustSelectPositionlongStringintintMethod.init(this.bridge, null, "adjustSelectPositionSuper", new Class[] { Long.TYPE, String.class, Integer.TYPE, Integer.TYPE });
      this.getRefererUrlMethod.init(this.bridge, null, "getRefererUrlSuper", new Class[0]);
      this.isSupportExtendPluginForAppbrandMethod.init(this.bridge, null, "isSupportExtendPluginForAppbrandSuper", new Class[0]);
      this.setVerticalScrollBarEnablebooleanMethod.init(this.bridge, null, "setVerticalScrollBarEnableSuper", new Class[] { Boolean.TYPE });
      this.setHorizontalScrollBarEnablebooleanMethod.init(this.bridge, null, "setHorizontalScrollBarEnableSuper", new Class[] { Boolean.TYPE });
      this.replaceTranslatedStringMethod.init(this.bridge, null, "replaceTranslatedStringSuper", new Class[] { Map.class });
      this.setTranslateModebooleanMethod.init(this.bridge, null, "setTranslateModeSuper", new Class[] { Boolean.TYPE });
      this.getTranslateSampleStringintMethod.init(this.bridge, null, "getTranslateSampleStringSuper", new Class[] { Integer.TYPE });
      this.getImageBitmapToFileMethod.init(this.bridge, null, "getImageBitmapToFileSuper", new Class[] { String.class, String.class, String.class, this.coreWrapper.getBridgeClass("XWalkGetImageBitmapToFileFinishedCallbackBridge") });
      if (XWalkCoreWrapper.getInstance().hasFeature(9)) {
        this.invokeExtensionMethod.init(this.bridge, null, "invokeExtension", new Class[] { Integer.TYPE, Object.class });
      } else {
        this.invokeExtensionMethod = null;
      }
      this.preInitViewSizeMethod.init(this.bridge, null, "preInitViewSizeSuper", new Class[] { Integer.TYPE, Integer.TYPE, Boolean.TYPE });
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException) {}
  }
  
  public void reload(int paramInt)
  {
    try
    {
      this.reloadintMethod.invoke(new Object[] { Integer.valueOf(paramInt) });
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      if (this.coreWrapper != null)
      {
        XWalkCoreWrapper.handleRuntimeError(localUnsupportedOperationException);
        return;
      }
      throw new RuntimeException("Crosswalk's APIs are not ready yet");
    }
  }
  
  public void removeJavascriptInterface(String paramString)
  {
    try
    {
      this.removeJavascriptInterfaceStringMethod.invoke(new Object[] { paramString });
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      if (this.coreWrapper == null)
      {
        this.removeJavascriptInterfaceStringMethod.setArguments(new Object[] { paramString });
        XWalkCoreWrapper.reserveReflectMethod(this.removeJavascriptInterfaceStringMethod);
        return;
      }
      XWalkCoreWrapper.handleRuntimeError(localUnsupportedOperationException);
    }
  }
  
  public void replaceTranslatedString(Map<String, String> paramMap)
  {
    try
    {
      this.replaceTranslatedStringMethod.invoke(new Object[] { paramMap });
      return;
    }
    catch (UnsupportedOperationException paramMap)
    {
      if (this.coreWrapper != null)
      {
        XWalkCoreWrapper.handleRuntimeError(paramMap);
        return;
      }
      throw new RuntimeException("Crosswalk's APIs are not ready yet");
    }
  }
  
  public boolean restoreState(Bundle paramBundle)
  {
    try
    {
      boolean bool = ((Boolean)this.restoreStateBundleMethod.invoke(new Object[] { paramBundle })).booleanValue();
      return bool;
    }
    catch (UnsupportedOperationException paramBundle)
    {
      if (this.coreWrapper != null)
      {
        XWalkCoreWrapper.handleRuntimeError(paramBundle);
        return false;
      }
      throw new RuntimeException("Crosswalk's APIs are not ready yet");
    }
  }
  
  public void resumeTimers()
  {
    try
    {
      this.resumeTimersMethod.invoke(new Object[0]);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      if (this.coreWrapper != null)
      {
        XWalkCoreWrapper.handleRuntimeError(localUnsupportedOperationException);
        return;
      }
      throw new RuntimeException("Crosswalk's APIs are not ready yet");
    }
  }
  
  public boolean savePage(String paramString1, String paramString2, int paramInt)
  {
    try
    {
      boolean bool = ((Boolean)this.savePageMethod.invoke(new Object[] { paramString1, paramString2, Integer.valueOf(paramInt) })).booleanValue();
      return bool;
    }
    catch (UnsupportedOperationException paramString1)
    {
      if (this.coreWrapper != null)
      {
        XWalkCoreWrapper.handleRuntimeError(paramString1);
        return false;
      }
      throw new RuntimeException("Crosswalk's APIs are not ready yet");
    }
  }
  
  public boolean saveState(Bundle paramBundle)
  {
    try
    {
      boolean bool = ((Boolean)this.saveStateBundleMethod.invoke(new Object[] { paramBundle })).booleanValue();
      return bool;
    }
    catch (UnsupportedOperationException paramBundle)
    {
      if (this.coreWrapper != null)
      {
        XWalkCoreWrapper.handleRuntimeError(paramBundle);
        return false;
      }
      throw new RuntimeException("Crosswalk's APIs are not ready yet");
    }
  }
  
  public void scrollBy(int paramInt1, int paramInt2)
  {
    try
    {
      this.scrollByintintMethod.invoke(new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      if (this.coreWrapper != null)
      {
        XWalkCoreWrapper.handleRuntimeError(localUnsupportedOperationException);
        return;
      }
      throw new RuntimeException("Crosswalk's APIs are not ready yet");
    }
  }
  
  public void scrollTo(int paramInt1, int paramInt2)
  {
    try
    {
      this.scrollTointintMethod.invoke(new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      if (this.coreWrapper != null)
      {
        XWalkCoreWrapper.handleRuntimeError(localUnsupportedOperationException);
        return;
      }
      throw new RuntimeException("Crosswalk's APIs are not ready yet");
    }
  }
  
  public void setAcceptLanguages(String paramString)
  {
    try
    {
      this.setAcceptLanguagesStringMethod.invoke(new Object[] { paramString });
      return;
    }
    catch (UnsupportedOperationException paramString)
    {
      if (this.coreWrapper != null)
      {
        XWalkCoreWrapper.handleRuntimeError(paramString);
        return;
      }
      throw new RuntimeException("Crosswalk's APIs are not ready yet");
    }
  }
  
  public void setBackgroundColor(int paramInt)
  {
    try
    {
      this.setBackgroundColorintMethod.invoke(new Object[] { Integer.valueOf(paramInt) });
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      if (this.coreWrapper != null)
      {
        XWalkCoreWrapper.handleRuntimeError(localUnsupportedOperationException);
        return;
      }
      throw new RuntimeException("Crosswalk's APIs are not ready yet");
    }
  }
  
  public void setBottomHeight(int paramInt)
  {
    if (!this.isInitedBottomHeightMethod)
    {
      this.isInitedBottomHeightMethod = true;
      this.setBottomHeightMethod.init(this.bridge, null, "setBottomHeightSuper", new Class[] { Integer.TYPE });
    }
    LazyReflectMethod localLazyReflectMethod = this.setBottomHeightMethod;
    if (localLazyReflectMethod != null)
    {
      if (localLazyReflectMethod.isNull()) {
        return;
      }
      try
      {
        this.setBottomHeightMethod.invoke(new Object[] { Integer.valueOf(paramInt) });
        return;
      }
      catch (Exception localException)
      {
        if (this.coreWrapper != null)
        {
          XWalkCoreWrapper.handleRuntimeError(localException);
          return;
        }
        throw new RuntimeException("Crosswalk's APIs are not ready yet");
      }
    }
  }
  
  public void setCustomOnOverScrolledListener(XWalkView.OverScrolledListener paramOverScrolledListener)
  {
    this.mOverScrolledListener = paramOverScrolledListener;
  }
  
  public void setCustomOnScrollChangedListener(XWalkView.ScrollChangedListener paramScrollChangedListener)
  {
    this.mScrollChangedListener = paramScrollChangedListener;
  }
  
  public void setDownloadListener(XWalkDownloadListener paramXWalkDownloadListener)
  {
    try
    {
      this.setDownloadListenerXWalkDownloadListenerInternalMethod.invoke(new Object[] { paramXWalkDownloadListener.getBridge() });
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      if (this.coreWrapper == null)
      {
        this.setDownloadListenerXWalkDownloadListenerInternalMethod.setArguments(new Object[] { new LazyReflectMethod(paramXWalkDownloadListener, "getBridge", new Class[0]) });
        XWalkCoreWrapper.reserveReflectMethod(this.setDownloadListenerXWalkDownloadListenerInternalMethod);
        return;
      }
      XWalkCoreWrapper.handleRuntimeError(localUnsupportedOperationException);
    }
  }
  
  public void setExtendCanvasClient(XWalkExtendCanvasClient paramXWalkExtendCanvasClient)
  {
    try
    {
      this.setExtendCanvasClientXWalkExtendCanvasClientInternalMethod.invoke(new Object[] { paramXWalkExtendCanvasClient.getBridge() });
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      if (this.coreWrapper == null)
      {
        this.setExtendCanvasClientXWalkExtendCanvasClientInternalMethod.setArguments(new Object[] { new LazyReflectMethod(paramXWalkExtendCanvasClient, "getBridge", new Class[0]) });
        XWalkCoreWrapper.reserveReflectMethod(this.setExtendCanvasClientXWalkExtendCanvasClientInternalMethod);
        return;
      }
      XWalkCoreWrapper.handleRuntimeError(localUnsupportedOperationException);
    }
  }
  
  public void setExtendPluginClient(XWalkExtendPluginClient paramXWalkExtendPluginClient)
  {
    try
    {
      this.setExtendPluginClientXWalkExtendPluginClientInternalMethod.invoke(new Object[] { paramXWalkExtendPluginClient.getBridge() });
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      if (this.coreWrapper == null)
      {
        this.setExtendPluginClientXWalkExtendPluginClientInternalMethod.setArguments(new Object[] { new LazyReflectMethod(paramXWalkExtendPluginClient, "getBridge", new Class[0]) });
        XWalkCoreWrapper.reserveReflectMethod(this.setExtendPluginClientXWalkExtendPluginClientInternalMethod);
        return;
      }
      XWalkCoreWrapper.handleRuntimeError(localUnsupportedOperationException);
    }
  }
  
  public void setExtendTextAreaClient(XWalkExtendTextAreaClient paramXWalkExtendTextAreaClient)
  {
    try
    {
      this.setExtendTextAreaClientXWalkExtendTextAreaClientInternalMethod.invoke(new Object[] { paramXWalkExtendTextAreaClient.getBridge() });
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      if (this.coreWrapper == null)
      {
        this.setExtendTextAreaClientXWalkExtendTextAreaClientInternalMethod.setArguments(new Object[] { new LazyReflectMethod(paramXWalkExtendTextAreaClient, "getBridge", new Class[0]) });
        XWalkCoreWrapper.reserveReflectMethod(this.setExtendTextAreaClientXWalkExtendTextAreaClientInternalMethod);
        return;
      }
      XWalkCoreWrapper.handleRuntimeError(localUnsupportedOperationException);
    }
  }
  
  public void setFindListener(XWalkFindListener paramXWalkFindListener)
  {
    try
    {
      this.setFindListenerXWalkFindListenerInternalMethod.invoke(new Object[] { paramXWalkFindListener.getBridge() });
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      if (this.coreWrapper == null)
      {
        this.setFindListenerXWalkFindListenerInternalMethod.setArguments(new Object[] { new LazyReflectMethod(paramXWalkFindListener, "getBridge", new Class[0]) });
        XWalkCoreWrapper.reserveReflectMethod(this.setFindListenerXWalkFindListenerInternalMethod);
        return;
      }
      XWalkCoreWrapper.handleRuntimeError(localUnsupportedOperationException);
    }
  }
  
  public void setFocusable(boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      setDescendantFocusability(393216);
      super.setFocusable(false);
      return;
    }
    setDescendantFocusability(131072);
    super.setFocusable(false);
  }
  
  public void setFocusableInTouchMode(boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      setDescendantFocusability(393216);
      super.setFocusableInTouchMode(false);
      return;
    }
    setDescendantFocusability(131072);
    super.setFocusableInTouchMode(false);
  }
  
  public void setHorizontalScrollBarEnable(boolean paramBoolean)
  {
    try
    {
      this.setHorizontalScrollBarEnablebooleanMethod.invoke(new Object[] { Boolean.valueOf(paramBoolean) });
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      if (this.coreWrapper != null)
      {
        XWalkCoreWrapper.handleRuntimeError(localUnsupportedOperationException);
        return;
      }
      throw new RuntimeException("Crosswalk's APIs are not ready yet");
    }
  }
  
  public void setInitialScale(int paramInt)
  {
    try
    {
      this.setInitialScaleintMethod.invoke(new Object[] { Integer.valueOf(paramInt) });
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      if (this.coreWrapper != null)
      {
        XWalkCoreWrapper.handleRuntimeError(localUnsupportedOperationException);
        return;
      }
      throw new RuntimeException("Crosswalk's APIs are not ready yet");
    }
  }
  
  public void setLayerType(int paramInt, Paint paramPaint) {}
  
  public void setNetworkAvailable(boolean paramBoolean)
  {
    try
    {
      this.setNetworkAvailablebooleanMethod.invoke(new Object[] { Boolean.valueOf(paramBoolean) });
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      if (this.coreWrapper != null)
      {
        XWalkCoreWrapper.handleRuntimeError(localUnsupportedOperationException);
        return;
      }
      throw new RuntimeException("Crosswalk's APIs are not ready yet");
    }
  }
  
  public void setOnTouchListener(View.OnTouchListener paramOnTouchListener)
  {
    try
    {
      this.setOnTouchListenerOnTouchListenerMethod.invoke(new Object[] { paramOnTouchListener });
      return;
    }
    catch (UnsupportedOperationException paramOnTouchListener)
    {
      if (this.coreWrapper != null)
      {
        XWalkCoreWrapper.handleRuntimeError(paramOnTouchListener);
        return;
      }
      throw new RuntimeException("Crosswalk's APIs are not ready yet");
    }
  }
  
  public void setOriginAccessWhitelist(String paramString, String[] paramArrayOfString)
  {
    try
    {
      this.setOriginAccessWhitelistStringStringArrayMethod.invoke(new Object[] { paramString, paramArrayOfString });
      return;
    }
    catch (UnsupportedOperationException paramString)
    {
      if (this.coreWrapper != null)
      {
        XWalkCoreWrapper.handleRuntimeError(paramString);
        return;
      }
      throw new RuntimeException("Crosswalk's APIs are not ready yet");
    }
  }
  
  public void setProxyWebViewClientExtension(XWalkProxyWebViewClientExtension paramXWalkProxyWebViewClientExtension)
  {
    try
    {
      this.setProxyWebViewClientExtensionInternalMethod.invoke(new Object[] { paramXWalkProxyWebViewClientExtension.getBridge() });
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      if (this.coreWrapper == null)
      {
        this.setProxyWebViewClientExtensionInternalMethod.setArguments(new Object[] { new LazyReflectMethod(paramXWalkProxyWebViewClientExtension, "getBridge", new Class[0]) });
        XWalkCoreWrapper.reserveReflectMethod(this.setProxyWebViewClientExtensionInternalMethod);
        return;
      }
      XWalkCoreWrapper.handleRuntimeError(localUnsupportedOperationException);
    }
  }
  
  public void setResourceClient(XWalkResourceClient paramXWalkResourceClient)
  {
    try
    {
      this.setResourceClientXWalkResourceClientInternalMethod.invoke(new Object[] { paramXWalkResourceClient.getBridge() });
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      if (this.coreWrapper == null)
      {
        this.setResourceClientXWalkResourceClientInternalMethod.setArguments(new Object[] { new LazyReflectMethod(paramXWalkResourceClient, "getBridge", new Class[0]) });
        XWalkCoreWrapper.reserveReflectMethod(this.setResourceClientXWalkResourceClientInternalMethod);
        return;
      }
      XWalkCoreWrapper.handleRuntimeError(localUnsupportedOperationException);
    }
  }
  
  public void setSurfaceViewVisibility(int paramInt)
  {
    try
    {
      this.setSurfaceViewVisibilityintMethod.invoke(new Object[] { Integer.valueOf(paramInt) });
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      if (this.coreWrapper == null)
      {
        this.setSurfaceViewVisibilityintMethod.setArguments(new Object[] { Integer.valueOf(paramInt) });
        XWalkCoreWrapper.reserveReflectMethod(this.setSurfaceViewVisibilityintMethod);
        return;
      }
      XWalkCoreWrapper.handleRuntimeError(localUnsupportedOperationException);
    }
  }
  
  public void setTranslateMode(boolean paramBoolean)
  {
    try
    {
      this.setTranslateModebooleanMethod.invoke(new Object[] { Boolean.valueOf(paramBoolean) });
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      if (this.coreWrapper != null)
      {
        XWalkCoreWrapper.handleRuntimeError(localUnsupportedOperationException);
        return;
      }
      throw new RuntimeException("Crosswalk's APIs are not ready yet");
    }
  }
  
  public void setUIClient(XWalkUIClient paramXWalkUIClient)
  {
    try
    {
      this.setUIClientXWalkUIClientInternalMethod.invoke(new Object[] { paramXWalkUIClient.getBridge() });
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      if (this.coreWrapper == null)
      {
        this.setUIClientXWalkUIClientInternalMethod.setArguments(new Object[] { new LazyReflectMethod(paramXWalkUIClient, "getBridge", new Class[0]) });
        XWalkCoreWrapper.reserveReflectMethod(this.setUIClientXWalkUIClientInternalMethod);
        return;
      }
      XWalkCoreWrapper.handleRuntimeError(localUnsupportedOperationException);
    }
  }
  
  public void setUserAgentString(String paramString)
  {
    try
    {
      this.setUserAgentStringStringMethod.invoke(new Object[] { paramString });
      return;
    }
    catch (UnsupportedOperationException paramString)
    {
      if (this.coreWrapper != null)
      {
        XWalkCoreWrapper.handleRuntimeError(paramString);
        return;
      }
      throw new RuntimeException("Crosswalk's APIs are not ready yet");
    }
  }
  
  public void setVerticalScrollBarEnable(boolean paramBoolean)
  {
    try
    {
      this.setVerticalScrollBarEnablebooleanMethod.invoke(new Object[] { Boolean.valueOf(paramBoolean) });
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      if (this.coreWrapper != null)
      {
        XWalkCoreWrapper.handleRuntimeError(localUnsupportedOperationException);
        return;
      }
      throw new RuntimeException("Crosswalk's APIs are not ready yet");
    }
  }
  
  public void setVisibility(int paramInt)
  {
    super.setVisibility(paramInt);
    setXWalkViewInternalVisibility(paramInt);
    setSurfaceViewVisibility(paramInt);
  }
  
  public void setXWalkViewInternalVisibility(int paramInt)
  {
    try
    {
      this.setXWalkViewInternalVisibilityintMethod.invoke(new Object[] { Integer.valueOf(paramInt) });
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      if (this.coreWrapper == null)
      {
        this.setXWalkViewInternalVisibilityintMethod.setArguments(new Object[] { Integer.valueOf(paramInt) });
        XWalkCoreWrapper.reserveReflectMethod(this.setXWalkViewInternalVisibilityintMethod);
        return;
      }
      XWalkCoreWrapper.handleRuntimeError(localUnsupportedOperationException);
    }
  }
  
  public void setZOrderOnTop(boolean paramBoolean)
  {
    try
    {
      this.setZOrderOnTopbooleanMethod.invoke(new Object[] { Boolean.valueOf(paramBoolean) });
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      if (this.coreWrapper != null)
      {
        XWalkCoreWrapper.handleRuntimeError(localUnsupportedOperationException);
        return;
      }
      throw new RuntimeException("Crosswalk's APIs are not ready yet");
    }
  }
  
  public void smoothScroll(int paramInt1, int paramInt2, long paramLong)
  {
    try
    {
      this.smoothScrollintintMethod.invoke(new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Long.valueOf(paramLong) });
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      if (this.coreWrapper != null)
      {
        XWalkCoreWrapper.handleRuntimeError(localUnsupportedOperationException);
        return;
      }
      throw new RuntimeException("Crosswalk's APIs are not ready yet");
    }
  }
  
  @Deprecated
  public void startActivityForResult(Intent paramIntent, int paramInt, Bundle paramBundle)
  {
    try
    {
      this.startActivityForResultIntentintBundleMethod.invoke(new Object[] { paramIntent, Integer.valueOf(paramInt), paramBundle });
      return;
    }
    catch (UnsupportedOperationException paramIntent)
    {
      if (this.coreWrapper != null)
      {
        XWalkCoreWrapper.handleRuntimeError(paramIntent);
        return;
      }
      throw new RuntimeException("Crosswalk's APIs are not ready yet");
    }
  }
  
  public void stopLoading()
  {
    try
    {
      this.stopLoadingMethod.invoke(new Object[0]);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      if (this.coreWrapper != null)
      {
        XWalkCoreWrapper.handleRuntimeError(localUnsupportedOperationException);
        return;
      }
      throw new RuntimeException("Crosswalk's APIs are not ready yet");
    }
  }
  
  public void zoomBy(float paramFloat)
  {
    try
    {
      this.zoomByfloatMethod.invoke(new Object[] { Float.valueOf(paramFloat) });
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      if (this.coreWrapper != null)
      {
        XWalkCoreWrapper.handleRuntimeError(localUnsupportedOperationException);
        return;
      }
      throw new RuntimeException("Crosswalk's APIs are not ready yet");
    }
  }
  
  public boolean zoomIn()
  {
    try
    {
      boolean bool = ((Boolean)this.zoomInMethod.invoke(new Object[0])).booleanValue();
      return bool;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      if (this.coreWrapper != null)
      {
        XWalkCoreWrapper.handleRuntimeError(localUnsupportedOperationException);
        return false;
      }
      throw new RuntimeException("Crosswalk's APIs are not ready yet");
    }
  }
  
  public boolean zoomOut()
  {
    try
    {
      boolean bool = ((Boolean)this.zoomOutMethod.invoke(new Object[0])).booleanValue();
      return bool;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      if (this.coreWrapper != null)
      {
        XWalkCoreWrapper.handleRuntimeError(localUnsupportedOperationException);
        return false;
      }
      throw new RuntimeException("Crosswalk's APIs are not ready yet");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.xwalk.core.XWalkView
 * JD-Core Version:    0.7.0.1
 */