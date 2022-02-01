package org.xwalk.core;

import java.util.ArrayList;
import java.util.Map;

public class XWalkSettings
{
  public static final int InvokeChannel_func_id_log = 30002;
  public static final int InvokeChannel_func_native_trans = 30003;
  public static final int LOAD_CACHE_ELSE_NETWORK = 1;
  public static final int LOAD_CACHE_ONLY = 3;
  public static final int LOAD_DEFAULT = -1;
  public static final int LOAD_NO_CACHE = 2;
  private LazyReflectMethod InvokeChannelInternalMethod = new LazyReflectMethod(null, "InvokeChannel", new Class[0]);
  private LazyReflectMethod SetJSExceptionCallBackXWalkJSExceptionListenerInternalMethod = new LazyReflectMethod(null, "SetJSExceptionCallBack", new Class[0]);
  private LazyReflectMethod SetLogCallBackXWalkLogMessageListenerInternalMethod = new LazyReflectMethod(null, "SetLogCallBack", new Class[0]);
  private Object bridge;
  private ArrayList<Object> constructorParams;
  private ArrayList<Object> constructorTypes;
  private XWalkCoreWrapper coreWrapper;
  private LazyReflectMethod disableCustomizedLongPressTimeoutVoidMethod = new LazyReflectMethod(null, "disableCustomizedLongPressTimeout", new Class[0]);
  private LazyReflectMethod enableCustomizedLongPressTimeoutIntMethod = new LazyReflectMethod(null, "enableCustomizedLongPressTimeout", new Class[0]);
  private LazyReflectMethod enumLayoutAlgorithmClassValueOfMethod = new LazyReflectMethod();
  private LazyReflectMethod getAcceptLanguagesMethod = new LazyReflectMethod(null, "getAcceptLanguages", new Class[0]);
  private LazyReflectMethod getAllowContentAccessMethod = new LazyReflectMethod(null, "getAllowContentAccess", new Class[0]);
  private LazyReflectMethod getAllowFileAccessFromFileURLsMethod = new LazyReflectMethod(null, "getAllowFileAccessFromFileURLs", new Class[0]);
  private LazyReflectMethod getAllowFileAccessMethod = new LazyReflectMethod(null, "getAllowFileAccess", new Class[0]);
  private LazyReflectMethod getAllowUniversalAccessFromFileURLsMethod = new LazyReflectMethod(null, "getAllowUniversalAccessFromFileURLs", new Class[0]);
  private LazyReflectMethod getAppBrandInfoMethod = new LazyReflectMethod(null, "getAppBrandInfoSuper", new Class[0]);
  private LazyReflectMethod getAudioPlaybackRequiresUserGestureMethod = new LazyReflectMethod(null, "getAudioPlaybackRequiresUserGesture", new Class[0]);
  private LazyReflectMethod getBackgroundAudioPauseMethod = new LazyReflectMethod(null, "getBackgroundAudioPauseSuper", new Class[0]);
  private LazyReflectMethod getBlockNetworkImageMethod = new LazyReflectMethod(null, "getBlockNetworkImage", new Class[0]);
  private LazyReflectMethod getBlockNetworkLoadsMethod = new LazyReflectMethod(null, "getBlockNetworkLoads", new Class[0]);
  private LazyReflectMethod getBuiltInZoomControlsMethod = new LazyReflectMethod(null, "getBuiltInZoomControls", new Class[0]);
  private LazyReflectMethod getCacheModeMethod = new LazyReflectMethod(null, "getCacheMode", new Class[0]);
  private LazyReflectMethod getCursiveFontFamilyMethod = new LazyReflectMethod(null, "getCursiveFontFamily", new Class[0]);
  private LazyReflectMethod getDatabaseEnabledMethod = new LazyReflectMethod(null, "getDatabaseEnabled", new Class[0]);
  private LazyReflectMethod getDefaultFixedFontSizeMethod = new LazyReflectMethod(null, "getDefaultFixedFontSize", new Class[0]);
  private LazyReflectMethod getDefaultFontSizeMethod = new LazyReflectMethod(null, "getDefaultFontSize", new Class[0]);
  private LazyReflectMethod getDomStorageEnabledMethod = new LazyReflectMethod(null, "getDomStorageEnabled", new Class[0]);
  private LazyReflectMethod getFantasyFontFamilyMethod = new LazyReflectMethod(null, "getFantasyFontFamily", new Class[0]);
  private LazyReflectMethod getFixedFontFamilyMethod = new LazyReflectMethod(null, "getFixedFontFamily", new Class[0]);
  private LazyReflectMethod getForceDarkBehaviorMethod = new LazyReflectMethod(null, "getForceDarkBehavior", new Class[0]);
  private LazyReflectMethod getForceDarkModeMethod = new LazyReflectMethod(null, "getForceDarkMode", new Class[0]);
  private LazyReflectMethod getJavaScriptCanOpenWindowsAutomaticallyMethod = new LazyReflectMethod(null, "getJavaScriptCanOpenWindowsAutomatically", new Class[0]);
  private LazyReflectMethod getJavaScriptEnabledMethod = new LazyReflectMethod(null, "getJavaScriptEnabled", new Class[0]);
  private LazyReflectMethod getLayoutAlgorithmMethod = new LazyReflectMethod(null, "getLayoutAlgorithm", new Class[0]);
  private LazyReflectMethod getLoadWithOverviewModeMethod = new LazyReflectMethod(null, "getLoadWithOverviewMode", new Class[0]);
  private LazyReflectMethod getLoadsImagesAutomaticallyMethod = new LazyReflectMethod(null, "getLoadsImagesAutomatically", new Class[0]);
  private LazyReflectMethod getMediaPlaybackRequiresUserGestureMethod = new LazyReflectMethod(null, "getMediaPlaybackRequiresUserGesture", new Class[0]);
  private LazyReflectMethod getMinimumFontSizeMethod = new LazyReflectMethod(null, "getMinimumFontSize", new Class[0]);
  private LazyReflectMethod getMinimumLogicalFontSizeMethod = new LazyReflectMethod(null, "getMinimumLogicalFontSize", new Class[0]);
  private LazyReflectMethod getSansSerifFontFamilyMethod = new LazyReflectMethod(null, "getSansSerifFontFamily", new Class[0]);
  private LazyReflectMethod getSaveFormDataMethod = new LazyReflectMethod(null, "getSaveFormData", new Class[0]);
  private LazyReflectMethod getSerifFontFamilyMethod = new LazyReflectMethod(null, "getSerifFontFamily", new Class[0]);
  private LazyReflectMethod getStandardFontFamilyMethod = new LazyReflectMethod(null, "getStandardFontFamily", new Class[0]);
  private LazyReflectMethod getSupportQuirksModeMethod = new LazyReflectMethod(null, "getSupportQuirksMode", new Class[0]);
  private LazyReflectMethod getSupportSpatialNavigationMethod = new LazyReflectMethod(null, "getSupportSpatialNavigation", new Class[0]);
  private LazyReflectMethod getTextZoomMethod = new LazyReflectMethod(null, "getTextZoom", new Class[0]);
  private LazyReflectMethod getUseWideViewPortMethod = new LazyReflectMethod(null, "getUseWideViewPort", new Class[0]);
  private LazyReflectMethod getUserAgentStringMethod = new LazyReflectMethod(null, "getUserAgentString", new Class[0]);
  private LazyReflectMethod getUsingForAppBrandMethod = new LazyReflectMethod(null, "getUsingForAppBrand", new Class[0]);
  private LazyReflectMethod getVideoPlaybackRequiresUserGestureMethod = new LazyReflectMethod(null, "getVideoPlaybackRequiresUserGesture", new Class[0]);
  private LazyReflectMethod postWrapperMethod;
  private LazyReflectMethod setAcceptLanguagesStringMethod = new LazyReflectMethod(null, "setAcceptLanguages", new Class[0]);
  private LazyReflectMethod setAllowContentAccessbooleanMethod = new LazyReflectMethod(null, "setAllowContentAccess", new Class[0]);
  private LazyReflectMethod setAllowFileAccessFromFileURLsbooleanMethod = new LazyReflectMethod(null, "setAllowFileAccessFromFileURLs", new Class[0]);
  private LazyReflectMethod setAllowFileAccessbooleanMethod = new LazyReflectMethod(null, "setAllowFileAccess", new Class[0]);
  private LazyReflectMethod setAllowUniversalAccessFromFileURLsbooleanMethod = new LazyReflectMethod(null, "setAllowUniversalAccessFromFileURLs", new Class[0]);
  private LazyReflectMethod setAppBrandInfoMethod = new LazyReflectMethod(null, "setAppBrandInfo", new Class[0]);
  private LazyReflectMethod setAppCacheEnabledbooleanMethod = new LazyReflectMethod(null, "setAppCacheEnabled", new Class[0]);
  private LazyReflectMethod setAppCachePathStringMethod = new LazyReflectMethod(null, "setAppCachePath", new Class[0]);
  private LazyReflectMethod setAudioPlaybackRequiresUserGesturebooleanMethod = new LazyReflectMethod(null, "setAudioPlaybackRequiresUserGesture", new Class[0]);
  private LazyReflectMethod setBackgroundAudioPauseMethod = new LazyReflectMethod(null, "setBackgroundAudioPauseSuper", new Class[0]);
  private LazyReflectMethod setBlockNetworkImagebooleanMethod = new LazyReflectMethod(null, "setBlockNetworkImage", new Class[0]);
  private LazyReflectMethod setBlockNetworkLoadsbooleanMethod = new LazyReflectMethod(null, "setBlockNetworkLoads", new Class[0]);
  private LazyReflectMethod setBuiltInZoomControlsbooleanMethod = new LazyReflectMethod(null, "setBuiltInZoomControls", new Class[0]);
  private LazyReflectMethod setCacheModeintMethod = new LazyReflectMethod(null, "setCacheMode", new Class[0]);
  private LazyReflectMethod setCursiveFontFamilyStringMethod = new LazyReflectMethod(null, "setCursiveFontFamily", new Class[0]);
  private LazyReflectMethod setDatabaseEnabledbooleanMethod = new LazyReflectMethod(null, "setDatabaseEnabled", new Class[0]);
  private LazyReflectMethod setDefaultFixedFontSizeintMethod = new LazyReflectMethod(null, "setDefaultFixedFontSize", new Class[0]);
  private LazyReflectMethod setDefaultFontSizeintMethod = new LazyReflectMethod(null, "setDefaultFontSize", new Class[0]);
  private LazyReflectMethod setDomStorageEnabledbooleanMethod = new LazyReflectMethod(null, "setDomStorageEnabled", new Class[0]);
  private LazyReflectMethod setFantasyFontFamilyStringMethod = new LazyReflectMethod(null, "setFantasyFontFamily", new Class[0]);
  private LazyReflectMethod setFixedFontFamilyStringMethod = new LazyReflectMethod(null, "setFixedFontFamily", new Class[0]);
  private LazyReflectMethod setForceDarkBehaviorintMethod = new LazyReflectMethod(null, "setForceDarkBehavior", new Class[0]);
  private LazyReflectMethod setForceDarkModeintMethod = new LazyReflectMethod(null, "setForceDarkMode", new Class[0]);
  private LazyReflectMethod setInitialPageScalefloatMethod = new LazyReflectMethod(null, "setInitialPageScale", new Class[0]);
  private LazyReflectMethod setJavaScriptCanOpenWindowsAutomaticallybooleanMethod = new LazyReflectMethod(null, "setJavaScriptCanOpenWindowsAutomatically", new Class[0]);
  private LazyReflectMethod setJavaScriptEnabledbooleanMethod = new LazyReflectMethod(null, "setJavaScriptEnabled", new Class[0]);
  private LazyReflectMethod setLayoutAlgorithmLayoutAlgorithmInternalMethod = new LazyReflectMethod(null, "setLayoutAlgorithm", new Class[0]);
  private LazyReflectMethod setLoadWithOverviewModebooleanMethod = new LazyReflectMethod(null, "setLoadWithOverviewMode", new Class[0]);
  private LazyReflectMethod setLoadsImagesAutomaticallybooleanMethod = new LazyReflectMethod(null, "setLoadsImagesAutomatically", new Class[0]);
  private LazyReflectMethod setMediaPlaybackRequiresUserGesturebooleanMethod = new LazyReflectMethod(null, "setMediaPlaybackRequiresUserGesture", new Class[0]);
  private LazyReflectMethod setMinimumFontSizeIntMethod = new LazyReflectMethod(null, "setMinimumFontSize", new Class[0]);
  private LazyReflectMethod setMinimumLogicalFontSizeIntMethod = new LazyReflectMethod(null, "setMinimumLogicalFontSize", new Class[0]);
  private LazyReflectMethod setSansSerifFontFamilyStringMethod = new LazyReflectMethod(null, "setSansSerifFontFamily", new Class[0]);
  private LazyReflectMethod setSaveFormDatabooleanMethod = new LazyReflectMethod(null, "setSaveFormData", new Class[0]);
  private LazyReflectMethod setSerifFontFamilyStringMethod = new LazyReflectMethod(null, "setSerifFontFamily", new Class[0]);
  private LazyReflectMethod setStandardFontFamilyStringMethod = new LazyReflectMethod(null, "setStandardFontFamily", new Class[0]);
  private LazyReflectMethod setSupportMultipleWindowsbooleanMethod = new LazyReflectMethod(null, "setSupportMultipleWindows", new Class[0]);
  private LazyReflectMethod setSupportQuirksModebooleanMethod = new LazyReflectMethod(null, "setSupportQuirksMode", new Class[0]);
  private LazyReflectMethod setSupportSpatialNavigationbooleanMethod = new LazyReflectMethod(null, "setSupportSpatialNavigation", new Class[0]);
  private LazyReflectMethod setSupportZoombooleanMethod = new LazyReflectMethod(null, "setSupportZoom", new Class[0]);
  private LazyReflectMethod setTextZoomintMethod = new LazyReflectMethod(null, "setTextZoom", new Class[0]);
  private LazyReflectMethod setUseWideViewPortbooleanMethod = new LazyReflectMethod(null, "setUseWideViewPort", new Class[0]);
  private LazyReflectMethod setUserAgentStringStringMethod = new LazyReflectMethod(null, "setUserAgentString", new Class[0]);
  private LazyReflectMethod setUsingForAppBrandMethod = new LazyReflectMethod(null, "setUsingForAppBrand", new Class[0]);
  private LazyReflectMethod setVideoPlaybackRequiresUserGesturebooleanMethod = new LazyReflectMethod(null, "setVideoPlaybackRequiresUserGesture", new Class[0]);
  private LazyReflectMethod supportMultipleWindowsMethod = new LazyReflectMethod(null, "supportMultipleWindows", new Class[0]);
  private LazyReflectMethod supportZoomMethod = new LazyReflectMethod(null, "supportZoom", new Class[0]);
  private LazyReflectMethod supportsMultiTouchZoomForTestMethod = new LazyReflectMethod(null, "supportsMultiTouchZoomForTest", new Class[0]);
  
  public XWalkSettings(Object paramObject)
  {
    this.bridge = paramObject;
    reflectionInit();
  }
  
  private Object ConvertLayoutAlgorithm(XWalkSettings.LayoutAlgorithm paramLayoutAlgorithm)
  {
    return this.enumLayoutAlgorithmClassValueOfMethod.invoke(new Object[] { paramLayoutAlgorithm.toString() });
  }
  
  public void InvokeChannel(int paramInt, Object[] paramArrayOfObject)
  {
    try
    {
      this.InvokeChannelInternalMethod.invoke(new Object[] { Integer.valueOf(paramInt), paramArrayOfObject });
      return;
    }
    catch (UnsupportedOperationException paramArrayOfObject)
    {
      if (this.coreWrapper != null)
      {
        XWalkCoreWrapper.handleRuntimeError(paramArrayOfObject);
        return;
      }
      throw new RuntimeException("Crosswalk's APIs are not ready yet");
    }
  }
  
  public void SetJSExceptionCallBack(XWalkJSExceptionListener paramXWalkJSExceptionListener)
  {
    try
    {
      this.SetJSExceptionCallBackXWalkJSExceptionListenerInternalMethod.invoke(new Object[] { paramXWalkJSExceptionListener.getBridge() });
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      if (this.coreWrapper == null)
      {
        this.SetJSExceptionCallBackXWalkJSExceptionListenerInternalMethod.setArguments(new Object[] { new LazyReflectMethod(paramXWalkJSExceptionListener, "getBridge", new Class[0]) });
        XWalkCoreWrapper.reserveReflectMethod(this.SetJSExceptionCallBackXWalkJSExceptionListenerInternalMethod);
        return;
      }
      XWalkCoreWrapper.handleRuntimeError(localUnsupportedOperationException);
    }
  }
  
  public void SetLogCallBack(XWalkLogMessageListener paramXWalkLogMessageListener)
  {
    try
    {
      this.SetLogCallBackXWalkLogMessageListenerInternalMethod.invoke(new Object[] { paramXWalkLogMessageListener.getBridge() });
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      if (this.coreWrapper == null)
      {
        this.SetLogCallBackXWalkLogMessageListenerInternalMethod.setArguments(new Object[] { new LazyReflectMethod(paramXWalkLogMessageListener, "getBridge", new Class[0]) });
        XWalkCoreWrapper.reserveReflectMethod(this.SetLogCallBackXWalkLogMessageListenerInternalMethod);
        return;
      }
      XWalkCoreWrapper.handleRuntimeError(localUnsupportedOperationException);
    }
  }
  
  public void bindNativeTrans(long paramLong)
  {
    InvokeChannel(30003, new String[] { String.valueOf(paramLong) });
  }
  
  public void disableCustomizedLongPressTimeout()
  {
    try
    {
      this.disableCustomizedLongPressTimeoutVoidMethod.invoke(new Object[0]);
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
  
  public void enableCustomizedLongPressTimeout(int paramInt)
  {
    try
    {
      this.enableCustomizedLongPressTimeoutIntMethod.invoke(new Object[] { Integer.valueOf(paramInt) });
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
  
  public String getAcceptLanguages()
  {
    try
    {
      String str = (String)this.getAcceptLanguagesMethod.invoke(new Object[0]);
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
  
  public boolean getAllowContentAccess()
  {
    try
    {
      boolean bool = ((Boolean)this.getAllowContentAccessMethod.invoke(new Object[0])).booleanValue();
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
  
  public boolean getAllowFileAccess()
  {
    try
    {
      boolean bool = ((Boolean)this.getAllowFileAccessMethod.invoke(new Object[0])).booleanValue();
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
  
  public boolean getAllowFileAccessFromFileURLs()
  {
    try
    {
      boolean bool = ((Boolean)this.getAllowFileAccessFromFileURLsMethod.invoke(new Object[0])).booleanValue();
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
  
  public boolean getAllowUniversalAccessFromFileURLs()
  {
    try
    {
      boolean bool = ((Boolean)this.getAllowUniversalAccessFromFileURLsMethod.invoke(new Object[0])).booleanValue();
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
  
  public Map<String, String> getAppBrandInfo()
  {
    try
    {
      Map localMap = (Map)this.getAppBrandInfoMethod.invoke(new Object[0]);
      return localMap;
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
  
  public boolean getAudioPlaybackRequiresUserGesture()
  {
    try
    {
      boolean bool = ((Boolean)this.getAudioPlaybackRequiresUserGestureMethod.invoke(new Object[0])).booleanValue();
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
  
  public boolean getBackgroundAudioPause()
  {
    try
    {
      boolean bool = ((Boolean)this.getBackgroundAudioPauseMethod.invoke(new Object[0])).booleanValue();
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
  
  public boolean getBlockNetworkImage()
  {
    try
    {
      boolean bool = ((Boolean)this.getBlockNetworkImageMethod.invoke(new Object[0])).booleanValue();
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
  
  public boolean getBlockNetworkLoads()
  {
    try
    {
      boolean bool = ((Boolean)this.getBlockNetworkLoadsMethod.invoke(new Object[0])).booleanValue();
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
  
  protected Object getBridge()
  {
    return this.bridge;
  }
  
  public boolean getBuiltInZoomControls()
  {
    try
    {
      boolean bool = ((Boolean)this.getBuiltInZoomControlsMethod.invoke(new Object[0])).booleanValue();
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
  
  public int getCacheMode()
  {
    try
    {
      int i = ((Integer)this.getCacheModeMethod.invoke(new Object[0])).intValue();
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
  
  public String getCursiveFontFamily()
  {
    try
    {
      String str = (String)this.getCursiveFontFamilyMethod.invoke(new Object[0]);
      return str;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      if (this.coreWrapper != null)
      {
        XWalkCoreWrapper.handleRuntimeError(localUnsupportedOperationException);
        return "";
      }
      throw new RuntimeException("Crosswalk's APIs are not ready yet");
    }
  }
  
  public boolean getDatabaseEnabled()
  {
    try
    {
      boolean bool = ((Boolean)this.getDatabaseEnabledMethod.invoke(new Object[0])).booleanValue();
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
  
  public int getDefaultFixedFontSize()
  {
    try
    {
      int i = ((Integer)this.getDefaultFixedFontSizeMethod.invoke(new Object[0])).intValue();
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
  
  public int getDefaultFontSize()
  {
    try
    {
      int i = ((Integer)this.getDefaultFontSizeMethod.invoke(new Object[0])).intValue();
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
  
  public boolean getDomStorageEnabled()
  {
    try
    {
      boolean bool = ((Boolean)this.getDomStorageEnabledMethod.invoke(new Object[0])).booleanValue();
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
  
  public String getFantasyFontFamily()
  {
    try
    {
      String str = (String)this.getFantasyFontFamilyMethod.invoke(new Object[0]);
      return str;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      if (this.coreWrapper != null)
      {
        XWalkCoreWrapper.handleRuntimeError(localUnsupportedOperationException);
        return "";
      }
      throw new RuntimeException("Crosswalk's APIs are not ready yet");
    }
  }
  
  public String getFixedFontFamily()
  {
    try
    {
      String str = (String)this.getFixedFontFamilyMethod.invoke(new Object[0]);
      return str;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      if (this.coreWrapper != null)
      {
        XWalkCoreWrapper.handleRuntimeError(localUnsupportedOperationException);
        return "";
      }
      throw new RuntimeException("Crosswalk's APIs are not ready yet");
    }
  }
  
  public int getForceDarkBehavior()
  {
    try
    {
      int i = ((Integer)this.getForceDarkBehaviorMethod.invoke(new Object[0])).intValue();
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
  
  public int getForceDarkMode()
  {
    try
    {
      int i = ((Integer)this.getForceDarkModeMethod.invoke(new Object[0])).intValue();
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
  
  public boolean getJavaScriptCanOpenWindowsAutomatically()
  {
    try
    {
      boolean bool = ((Boolean)this.getJavaScriptCanOpenWindowsAutomaticallyMethod.invoke(new Object[0])).booleanValue();
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
  
  public boolean getJavaScriptEnabled()
  {
    try
    {
      boolean bool = ((Boolean)this.getJavaScriptEnabledMethod.invoke(new Object[0])).booleanValue();
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
  
  public XWalkSettings.LayoutAlgorithm getLayoutAlgorithm()
  {
    try
    {
      XWalkSettings.LayoutAlgorithm localLayoutAlgorithm = XWalkSettings.LayoutAlgorithm.valueOf(this.getLayoutAlgorithmMethod.invoke(new Object[0]).toString());
      return localLayoutAlgorithm;
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
  
  public boolean getLoadWithOverviewMode()
  {
    try
    {
      boolean bool = ((Boolean)this.getLoadWithOverviewModeMethod.invoke(new Object[0])).booleanValue();
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
  
  public boolean getLoadsImagesAutomatically()
  {
    try
    {
      boolean bool = ((Boolean)this.getLoadsImagesAutomaticallyMethod.invoke(new Object[0])).booleanValue();
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
  
  public boolean getMediaPlaybackRequiresUserGesture()
  {
    try
    {
      boolean bool = ((Boolean)this.getMediaPlaybackRequiresUserGestureMethod.invoke(new Object[0])).booleanValue();
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
  
  public int getMinimumFontSize()
  {
    try
    {
      int i = ((Integer)this.getMinimumFontSizeMethod.invoke(new Object[0])).intValue();
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
  
  public int getMinimumLogicalFontSize()
  {
    try
    {
      int i = ((Integer)this.getMinimumLogicalFontSizeMethod.invoke(new Object[0])).intValue();
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
  
  public String getSansSerifFontFamily()
  {
    try
    {
      String str = (String)this.getSansSerifFontFamilyMethod.invoke(new Object[0]);
      return str;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      if (this.coreWrapper != null)
      {
        XWalkCoreWrapper.handleRuntimeError(localUnsupportedOperationException);
        return "";
      }
      throw new RuntimeException("Crosswalk's APIs are not ready yet");
    }
  }
  
  public boolean getSaveFormData()
  {
    try
    {
      boolean bool = ((Boolean)this.getSaveFormDataMethod.invoke(new Object[0])).booleanValue();
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
  
  public String getSerifFontFamily()
  {
    try
    {
      String str = (String)this.getSerifFontFamilyMethod.invoke(new Object[0]);
      return str;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      if (this.coreWrapper != null)
      {
        XWalkCoreWrapper.handleRuntimeError(localUnsupportedOperationException);
        return "";
      }
      throw new RuntimeException("Crosswalk's APIs are not ready yet");
    }
  }
  
  public String getStandardFontFamily()
  {
    try
    {
      String str = (String)this.getStandardFontFamilyMethod.invoke(new Object[0]);
      return str;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      if (this.coreWrapper != null)
      {
        XWalkCoreWrapper.handleRuntimeError(localUnsupportedOperationException);
        return "";
      }
      throw new RuntimeException("Crosswalk's APIs are not ready yet");
    }
  }
  
  public boolean getSupportQuirksMode()
  {
    try
    {
      boolean bool = ((Boolean)this.getSupportQuirksModeMethod.invoke(new Object[0])).booleanValue();
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
  
  public boolean getSupportSpatialNavigation()
  {
    try
    {
      boolean bool = ((Boolean)this.getSupportSpatialNavigationMethod.invoke(new Object[0])).booleanValue();
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
  
  public int getTextZoom()
  {
    try
    {
      int i = ((Integer)this.getTextZoomMethod.invoke(new Object[0])).intValue();
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
  
  public boolean getUseWideViewPort()
  {
    try
    {
      boolean bool = ((Boolean)this.getUseWideViewPortMethod.invoke(new Object[0])).booleanValue();
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
  
  public int getUsingForAppBrand()
  {
    try
    {
      int i = ((Integer)this.getUsingForAppBrandMethod.invoke(new Object[0])).intValue();
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
  
  public boolean getVideoPlaybackRequiresUserGesture()
  {
    try
    {
      boolean bool = ((Boolean)this.getVideoPlaybackRequiresUserGestureMethod.invoke(new Object[0])).booleanValue();
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
  
  void reflectionInit()
  {
    XWalkCoreWrapper.initEmbeddedMode();
    this.coreWrapper = XWalkCoreWrapper.getInstance();
    XWalkCoreWrapper localXWalkCoreWrapper = this.coreWrapper;
    if (localXWalkCoreWrapper == null)
    {
      XWalkCoreWrapper.reserveReflectObject(this);
      return;
    }
    this.enumLayoutAlgorithmClassValueOfMethod.init(null, localXWalkCoreWrapper.getBridgeClass("XWalkSettingsInternal$LayoutAlgorithmInternal"), "valueOf", new Class[] { String.class });
    this.setCacheModeintMethod.init(this.bridge, null, "setCacheModeSuper", new Class[] { Integer.TYPE });
    this.getCacheModeMethod.init(this.bridge, null, "getCacheModeSuper", new Class[0]);
    this.setForceDarkModeintMethod.init(this.bridge, null, "setForceDarkModeSuper", new Class[] { Integer.TYPE });
    this.getForceDarkModeMethod.init(this.bridge, null, "getForceDarkModeSuper", new Class[0]);
    this.setForceDarkBehaviorintMethod.init(this.bridge, null, "setForceDarkBehaviorSuper", new Class[] { Integer.TYPE });
    this.getForceDarkBehaviorMethod.init(this.bridge, null, "getForceDarkBehaviorSuper", new Class[0]);
    this.setBlockNetworkLoadsbooleanMethod.init(this.bridge, null, "setBlockNetworkLoadsSuper", new Class[] { Boolean.TYPE });
    this.getBlockNetworkLoadsMethod.init(this.bridge, null, "getBlockNetworkLoadsSuper", new Class[0]);
    this.setAllowFileAccessbooleanMethod.init(this.bridge, null, "setAllowFileAccessSuper", new Class[] { Boolean.TYPE });
    this.getAllowFileAccessMethod.init(this.bridge, null, "getAllowFileAccessSuper", new Class[0]);
    this.setAllowContentAccessbooleanMethod.init(this.bridge, null, "setAllowContentAccessSuper", new Class[] { Boolean.TYPE });
    this.getAllowContentAccessMethod.init(this.bridge, null, "getAllowContentAccessSuper", new Class[0]);
    this.setJavaScriptEnabledbooleanMethod.init(this.bridge, null, "setJavaScriptEnabledSuper", new Class[] { Boolean.TYPE });
    this.setAllowUniversalAccessFromFileURLsbooleanMethod.init(this.bridge, null, "setAllowUniversalAccessFromFileURLsSuper", new Class[] { Boolean.TYPE });
    this.setAllowFileAccessFromFileURLsbooleanMethod.init(this.bridge, null, "setAllowFileAccessFromFileURLsSuper", new Class[] { Boolean.TYPE });
    this.setLoadsImagesAutomaticallybooleanMethod.init(this.bridge, null, "setLoadsImagesAutomaticallySuper", new Class[] { Boolean.TYPE });
    this.getLoadsImagesAutomaticallyMethod.init(this.bridge, null, "getLoadsImagesAutomaticallySuper", new Class[0]);
    this.setBlockNetworkImagebooleanMethod.init(this.bridge, null, "setBlockNetworkImageSuper", new Class[] { Boolean.TYPE });
    this.getBlockNetworkImageMethod.init(this.bridge, null, "getBlockNetworkImageSuper", new Class[0]);
    this.getJavaScriptEnabledMethod.init(this.bridge, null, "getJavaScriptEnabledSuper", new Class[0]);
    this.getAllowUniversalAccessFromFileURLsMethod.init(this.bridge, null, "getAllowUniversalAccessFromFileURLsSuper", new Class[0]);
    this.getAllowFileAccessFromFileURLsMethod.init(this.bridge, null, "getAllowFileAccessFromFileURLsSuper", new Class[0]);
    this.setJavaScriptCanOpenWindowsAutomaticallybooleanMethod.init(this.bridge, null, "setJavaScriptCanOpenWindowsAutomaticallySuper", new Class[] { Boolean.TYPE });
    this.getJavaScriptCanOpenWindowsAutomaticallyMethod.init(this.bridge, null, "getJavaScriptCanOpenWindowsAutomaticallySuper", new Class[0]);
    this.setSupportMultipleWindowsbooleanMethod.init(this.bridge, null, "setSupportMultipleWindowsSuper", new Class[] { Boolean.TYPE });
    this.supportMultipleWindowsMethod.init(this.bridge, null, "supportMultipleWindowsSuper", new Class[0]);
    this.setUseWideViewPortbooleanMethod.init(this.bridge, null, "setUseWideViewPortSuper", new Class[] { Boolean.TYPE });
    this.getUseWideViewPortMethod.init(this.bridge, null, "getUseWideViewPortSuper", new Class[0]);
    this.setAppCacheEnabledbooleanMethod.init(this.bridge, null, "setAppCacheEnabledSuper", new Class[] { Boolean.TYPE });
    this.setAppCachePathStringMethod.init(this.bridge, null, "setAppCachePathSuper", new Class[] { String.class });
    this.setDomStorageEnabledbooleanMethod.init(this.bridge, null, "setDomStorageEnabledSuper", new Class[] { Boolean.TYPE });
    this.getDomStorageEnabledMethod.init(this.bridge, null, "getDomStorageEnabledSuper", new Class[0]);
    this.setDatabaseEnabledbooleanMethod.init(this.bridge, null, "setDatabaseEnabledSuper", new Class[] { Boolean.TYPE });
    this.getDatabaseEnabledMethod.init(this.bridge, null, "getDatabaseEnabledSuper", new Class[0]);
    this.setMediaPlaybackRequiresUserGesturebooleanMethod.init(this.bridge, null, "setMediaPlaybackRequiresUserGestureSuper", new Class[] { Boolean.TYPE });
    this.getMediaPlaybackRequiresUserGestureMethod.init(this.bridge, null, "getMediaPlaybackRequiresUserGestureSuper", new Class[0]);
    this.setAudioPlaybackRequiresUserGesturebooleanMethod.init(this.bridge, null, "setAudioPlaybackRequiresUserGestureSuper", new Class[] { Boolean.TYPE });
    this.getAudioPlaybackRequiresUserGestureMethod.init(this.bridge, null, "getAudioPlaybackRequiresUserGestureSuper", new Class[0]);
    this.setVideoPlaybackRequiresUserGesturebooleanMethod.init(this.bridge, null, "setVideoPlaybackRequiresUserGestureSuper", new Class[] { Boolean.TYPE });
    this.getVideoPlaybackRequiresUserGestureMethod.init(this.bridge, null, "getVideoPlaybackRequiresUserGestureSuper", new Class[0]);
    this.enableCustomizedLongPressTimeoutIntMethod.init(this.bridge, null, "enableCustomizedLongPressTimeoutSuper", new Class[] { Integer.TYPE });
    this.disableCustomizedLongPressTimeoutVoidMethod.init(this.bridge, null, "disableCustomizedLongPressTimeoutSuper", new Class[0]);
    this.setUsingForAppBrandMethod.init(this.bridge, null, "setUsingForAppBrandSuper", new Class[] { Integer.TYPE });
    this.getUsingForAppBrandMethod.init(this.bridge, null, "getUsingForAppBrandSuper", new Class[0]);
    this.setUserAgentStringStringMethod.init(this.bridge, null, "setUserAgentStringSuper", new Class[] { String.class });
    this.getUserAgentStringMethod.init(this.bridge, null, "getUserAgentStringSuper", new Class[0]);
    this.setAcceptLanguagesStringMethod.init(this.bridge, null, "setAcceptLanguagesSuper", new Class[] { String.class });
    this.getAcceptLanguagesMethod.init(this.bridge, null, "getAcceptLanguagesSuper", new Class[0]);
    this.setSaveFormDatabooleanMethod.init(this.bridge, null, "setSaveFormDataSuper", new Class[] { Boolean.TYPE });
    this.getSaveFormDataMethod.init(this.bridge, null, "getSaveFormDataSuper", new Class[0]);
    this.setInitialPageScalefloatMethod.init(this.bridge, null, "setInitialPageScaleSuper", new Class[] { Float.TYPE });
    this.setTextZoomintMethod.init(this.bridge, null, "setTextZoomSuper", new Class[] { Integer.TYPE });
    this.getTextZoomMethod.init(this.bridge, null, "getTextZoomSuper", new Class[0]);
    this.setDefaultFontSizeintMethod.init(this.bridge, null, "setDefaultFontSizeSuper", new Class[] { Integer.TYPE });
    this.getDefaultFontSizeMethod.init(this.bridge, null, "getDefaultFontSizeSuper", new Class[0]);
    this.setDefaultFixedFontSizeintMethod.init(this.bridge, null, "setDefaultFixedFontSizeSuper", new Class[] { Integer.TYPE });
    this.getDefaultFixedFontSizeMethod.init(this.bridge, null, "getDefaultFixedFontSizeSuper", new Class[0]);
    this.setSupportZoombooleanMethod.init(this.bridge, null, "setSupportZoomSuper", new Class[] { Boolean.TYPE });
    this.supportZoomMethod.init(this.bridge, null, "supportZoomSuper", new Class[0]);
    this.setBuiltInZoomControlsbooleanMethod.init(this.bridge, null, "setBuiltInZoomControlsSuper", new Class[] { Boolean.TYPE });
    this.getBuiltInZoomControlsMethod.init(this.bridge, null, "getBuiltInZoomControlsSuper", new Class[0]);
    this.supportsMultiTouchZoomForTestMethod.init(this.bridge, null, "supportsMultiTouchZoomForTestSuper", new Class[0]);
    this.setSupportSpatialNavigationbooleanMethod.init(this.bridge, null, "setSupportSpatialNavigationSuper", new Class[] { Boolean.TYPE });
    this.getSupportSpatialNavigationMethod.init(this.bridge, null, "getSupportSpatialNavigationSuper", new Class[0]);
    this.setSupportQuirksModebooleanMethod.init(this.bridge, null, "setSupportQuirksModeSuper", new Class[] { Boolean.TYPE });
    this.getSupportQuirksModeMethod.init(this.bridge, null, "getSupportQuirksModeSuper", new Class[0]);
    this.setLayoutAlgorithmLayoutAlgorithmInternalMethod.init(this.bridge, null, "setLayoutAlgorithmSuper", new Class[] { this.coreWrapper.getBridgeClass("XWalkSettingsInternal$LayoutAlgorithmInternal") });
    this.getLayoutAlgorithmMethod.init(this.bridge, null, "getLayoutAlgorithmSuper", new Class[0]);
    this.setLoadWithOverviewModebooleanMethod.init(this.bridge, null, "setLoadWithOverviewModeSuper", new Class[] { Boolean.TYPE });
    this.getLoadWithOverviewModeMethod.init(this.bridge, null, "getLoadWithOverviewModeSuper", new Class[0]);
    this.SetLogCallBackXWalkLogMessageListenerInternalMethod.init(this.bridge, null, "SetLogCallBackSuper", new Class[] { this.coreWrapper.getBridgeClass("XWalkLogMessageListenerBridge") });
    this.setStandardFontFamilyStringMethod.init(this.bridge, null, "setStandardFontFamilySuper", new Class[] { String.class });
    this.setFixedFontFamilyStringMethod.init(this.bridge, null, "setFixedFontFamilySuper", new Class[] { String.class });
    this.setSansSerifFontFamilyStringMethod.init(this.bridge, null, "setSansSerifFontFamilySuper", new Class[] { String.class });
    this.setSerifFontFamilyStringMethod.init(this.bridge, null, "setSerifFontFamilySuper", new Class[] { String.class });
    this.setCursiveFontFamilyStringMethod.init(this.bridge, null, "setCursiveFontFamilySuper", new Class[] { String.class });
    this.setFantasyFontFamilyStringMethod.init(this.bridge, null, "setFantasyFontFamilySuper", new Class[] { String.class });
    this.setMinimumFontSizeIntMethod.init(this.bridge, null, "setMinimumFontSizeSuper", new Class[] { Integer.TYPE });
    this.setMinimumLogicalFontSizeIntMethod.init(this.bridge, null, "setMinimumLogicalFontSizeSuper", new Class[] { Integer.TYPE });
    this.getStandardFontFamilyMethod.init(this.bridge, null, "getStandardFontFamilySuper", new Class[0]);
    this.getFixedFontFamilyMethod.init(this.bridge, null, "getFixedFontFamilySuper", new Class[0]);
    this.getSansSerifFontFamilyMethod.init(this.bridge, null, "getSansSerifFontFamilySuper", new Class[0]);
    this.getSerifFontFamilyMethod.init(this.bridge, null, "getSerifFontFamilySuper", new Class[0]);
    this.getCursiveFontFamilyMethod.init(this.bridge, null, "getCursiveFontFamilySuper", new Class[0]);
    this.getFantasyFontFamilyMethod.init(this.bridge, null, "getFantasyFontFamilySuper", new Class[0]);
    this.getMinimumFontSizeMethod.init(this.bridge, null, "getMinimumFontSizeSuper", new Class[0]);
    this.getMinimumLogicalFontSizeMethod.init(this.bridge, null, "getMinimumLogicalFontSizeSuper", new Class[0]);
    this.getAppBrandInfoMethod.init(this.bridge, null, "getAppBrandInfoSuper", new Class[0]);
    this.setAppBrandInfoMethod.init(this.bridge, null, "setAppBrandInfoSuper", new Class[] { Map.class });
    this.getBackgroundAudioPauseMethod.init(this.bridge, null, "getBackgroundAudioPauseSuper", new Class[0]);
    this.setBackgroundAudioPauseMethod.init(this.bridge, null, "setBackgroundAudioPauseSuper", new Class[] { Boolean.TYPE });
    this.SetJSExceptionCallBackXWalkJSExceptionListenerInternalMethod.init(this.bridge, null, "SetJSExceptionCallBackSuper", new Class[] { this.coreWrapper.getBridgeClass("XWalkJSExceptionListenerBridge") });
    this.InvokeChannelInternalMethod.init(this.bridge, null, "InvokeChannel", new Class[] { Integer.TYPE, [Ljava.lang.Object.class });
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
  
  public void setAllowContentAccess(boolean paramBoolean)
  {
    try
    {
      this.setAllowContentAccessbooleanMethod.invoke(new Object[] { Boolean.valueOf(paramBoolean) });
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
  
  public void setAllowFileAccess(boolean paramBoolean)
  {
    try
    {
      this.setAllowFileAccessbooleanMethod.invoke(new Object[] { Boolean.valueOf(paramBoolean) });
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
  
  public void setAllowFileAccessFromFileURLs(boolean paramBoolean)
  {
    try
    {
      this.setAllowFileAccessFromFileURLsbooleanMethod.invoke(new Object[] { Boolean.valueOf(paramBoolean) });
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
  
  public void setAllowUniversalAccessFromFileURLs(boolean paramBoolean)
  {
    try
    {
      this.setAllowUniversalAccessFromFileURLsbooleanMethod.invoke(new Object[] { Boolean.valueOf(paramBoolean) });
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
  
  public void setAppBrandInfo(Map<String, String> paramMap)
  {
    try
    {
      this.setAppBrandInfoMethod.invoke(new Object[] { paramMap });
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
  
  public void setAppCacheEnabled(boolean paramBoolean)
  {
    try
    {
      this.setAppCacheEnabledbooleanMethod.invoke(new Object[] { Boolean.valueOf(paramBoolean) });
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
  
  public void setAppCachePath(String paramString)
  {
    try
    {
      this.setAppCachePathStringMethod.invoke(new Object[] { paramString });
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
  
  public void setAudioPlaybackRequiresUserGesture(boolean paramBoolean)
  {
    try
    {
      this.setAudioPlaybackRequiresUserGesturebooleanMethod.invoke(new Object[] { Boolean.valueOf(paramBoolean) });
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
  
  public void setBackgroundAudioPause(boolean paramBoolean)
  {
    try
    {
      this.setBackgroundAudioPauseMethod.invoke(new Object[] { Boolean.valueOf(paramBoolean) });
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
  
  public void setBlockNetworkImage(boolean paramBoolean)
  {
    try
    {
      this.setBlockNetworkImagebooleanMethod.invoke(new Object[] { Boolean.valueOf(paramBoolean) });
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
  
  public void setBlockNetworkLoads(boolean paramBoolean)
  {
    try
    {
      this.setBlockNetworkLoadsbooleanMethod.invoke(new Object[] { Boolean.valueOf(paramBoolean) });
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
  
  public void setBuiltInZoomControls(boolean paramBoolean)
  {
    try
    {
      this.setBuiltInZoomControlsbooleanMethod.invoke(new Object[] { Boolean.valueOf(paramBoolean) });
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
  
  public void setCacheMode(int paramInt)
  {
    try
    {
      this.setCacheModeintMethod.invoke(new Object[] { Integer.valueOf(paramInt) });
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
  
  public void setCursiveFontFamily(String paramString)
  {
    try
    {
      this.setCursiveFontFamilyStringMethod.invoke(new Object[] { paramString });
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
  
  public void setDatabaseEnabled(boolean paramBoolean)
  {
    try
    {
      this.setDatabaseEnabledbooleanMethod.invoke(new Object[] { Boolean.valueOf(paramBoolean) });
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
  
  public void setDefaultFixedFontSize(int paramInt)
  {
    try
    {
      this.setDefaultFixedFontSizeintMethod.invoke(new Object[] { Integer.valueOf(paramInt) });
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
  
  public void setDefaultFontSize(int paramInt)
  {
    try
    {
      this.setDefaultFontSizeintMethod.invoke(new Object[] { Integer.valueOf(paramInt) });
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
  
  public void setDomStorageEnabled(boolean paramBoolean)
  {
    try
    {
      this.setDomStorageEnabledbooleanMethod.invoke(new Object[] { Boolean.valueOf(paramBoolean) });
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
  
  public void setFantasyFontFamily(String paramString)
  {
    try
    {
      this.setFantasyFontFamilyStringMethod.invoke(new Object[] { paramString });
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
  
  public void setFixedFontFamily(String paramString)
  {
    try
    {
      this.setFixedFontFamilyStringMethod.invoke(new Object[] { paramString });
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
  
  public void setForceDarkBehavior(int paramInt)
  {
    try
    {
      this.setForceDarkBehaviorintMethod.invoke(new Object[] { Integer.valueOf(paramInt) });
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
  
  public void setForceDarkMode(int paramInt)
  {
    try
    {
      this.setForceDarkModeintMethod.invoke(new Object[] { Integer.valueOf(paramInt) });
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
  
  public void setInitialPageScale(float paramFloat)
  {
    try
    {
      this.setInitialPageScalefloatMethod.invoke(new Object[] { Float.valueOf(paramFloat) });
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
  
  public void setJavaScriptCanOpenWindowsAutomatically(boolean paramBoolean)
  {
    try
    {
      this.setJavaScriptCanOpenWindowsAutomaticallybooleanMethod.invoke(new Object[] { Boolean.valueOf(paramBoolean) });
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
  
  public void setJavaScriptEnabled(boolean paramBoolean)
  {
    try
    {
      this.setJavaScriptEnabledbooleanMethod.invoke(new Object[] { Boolean.valueOf(paramBoolean) });
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
  
  public void setLayoutAlgorithm(XWalkSettings.LayoutAlgorithm paramLayoutAlgorithm)
  {
    try
    {
      this.setLayoutAlgorithmLayoutAlgorithmInternalMethod.invoke(new Object[] { ConvertLayoutAlgorithm(paramLayoutAlgorithm) });
      return;
    }
    catch (UnsupportedOperationException paramLayoutAlgorithm)
    {
      if (this.coreWrapper != null)
      {
        XWalkCoreWrapper.handleRuntimeError(paramLayoutAlgorithm);
        return;
      }
      throw new RuntimeException("Crosswalk's APIs are not ready yet");
    }
  }
  
  public void setLoadWithOverviewMode(boolean paramBoolean)
  {
    try
    {
      this.setLoadWithOverviewModebooleanMethod.invoke(new Object[] { Boolean.valueOf(paramBoolean) });
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
  
  public void setLoadsImagesAutomatically(boolean paramBoolean)
  {
    try
    {
      this.setLoadsImagesAutomaticallybooleanMethod.invoke(new Object[] { Boolean.valueOf(paramBoolean) });
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
  
  public void setMediaPlaybackRequiresUserGesture(boolean paramBoolean)
  {
    try
    {
      this.setMediaPlaybackRequiresUserGesturebooleanMethod.invoke(new Object[] { Boolean.valueOf(paramBoolean) });
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
  
  public void setMinimumFontSize(int paramInt)
  {
    try
    {
      this.setMinimumFontSizeIntMethod.invoke(new Object[] { Integer.valueOf(paramInt) });
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
  
  public void setMinimumLogicalFontSize(int paramInt)
  {
    try
    {
      this.setMinimumLogicalFontSizeIntMethod.invoke(new Object[] { Integer.valueOf(paramInt) });
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
  
  public void setSansSerifFontFamily(String paramString)
  {
    try
    {
      this.setSansSerifFontFamilyStringMethod.invoke(new Object[] { paramString });
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
  
  public void setSaveFormData(boolean paramBoolean)
  {
    try
    {
      this.setSaveFormDatabooleanMethod.invoke(new Object[] { Boolean.valueOf(paramBoolean) });
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
  
  public void setSerifFontFamily(String paramString)
  {
    try
    {
      this.setSerifFontFamilyStringMethod.invoke(new Object[] { paramString });
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
  
  public void setStandardFontFamily(String paramString)
  {
    try
    {
      this.setStandardFontFamilyStringMethod.invoke(new Object[] { paramString });
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
  
  public void setSupportMultipleWindows(boolean paramBoolean)
  {
    try
    {
      this.setSupportMultipleWindowsbooleanMethod.invoke(new Object[] { Boolean.valueOf(paramBoolean) });
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
  
  public void setSupportQuirksMode(boolean paramBoolean)
  {
    try
    {
      this.setSupportQuirksModebooleanMethod.invoke(new Object[] { Boolean.valueOf(paramBoolean) });
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
  
  public void setSupportSpatialNavigation(boolean paramBoolean)
  {
    try
    {
      this.setSupportSpatialNavigationbooleanMethod.invoke(new Object[] { Boolean.valueOf(paramBoolean) });
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
  
  public void setSupportZoom(boolean paramBoolean)
  {
    try
    {
      this.setSupportZoombooleanMethod.invoke(new Object[] { Boolean.valueOf(paramBoolean) });
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
  
  public void setTextZoom(int paramInt)
  {
    try
    {
      this.setTextZoomintMethod.invoke(new Object[] { Integer.valueOf(paramInt) });
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
  
  public void setUseWideViewPort(boolean paramBoolean)
  {
    try
    {
      this.setUseWideViewPortbooleanMethod.invoke(new Object[] { Boolean.valueOf(paramBoolean) });
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
  
  public void setUsingForAppBrand(int paramInt)
  {
    try
    {
      this.setUsingForAppBrandMethod.invoke(new Object[] { Integer.valueOf(paramInt) });
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
  
  public void setVideoPlaybackRequiresUserGesture(boolean paramBoolean)
  {
    try
    {
      this.setVideoPlaybackRequiresUserGesturebooleanMethod.invoke(new Object[] { Boolean.valueOf(paramBoolean) });
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
  
  public boolean supportMultipleWindows()
  {
    try
    {
      boolean bool = ((Boolean)this.supportMultipleWindowsMethod.invoke(new Object[0])).booleanValue();
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
  
  public boolean supportZoom()
  {
    try
    {
      boolean bool = ((Boolean)this.supportZoomMethod.invoke(new Object[0])).booleanValue();
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
  
  public boolean supportsMultiTouchZoomForTest()
  {
    try
    {
      boolean bool = ((Boolean)this.supportsMultiTouchZoomForTestMethod.invoke(new Object[0])).booleanValue();
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
 * Qualified Name:     org.xwalk.core.XWalkSettings
 * JD-Core Version:    0.7.0.1
 */