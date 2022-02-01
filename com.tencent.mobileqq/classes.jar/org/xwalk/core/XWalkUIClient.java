package org.xwalk.core;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Message;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient.FileChooserParams;
import java.util.ArrayList;
import java.util.Map;

public class XWalkUIClient
{
  private LazyReflectMethod OnGetSampleStringXWalkViewInternalMapCallbackMethod = new LazyReflectMethod(null, "OnGetSampleString", new Class[0]);
  private Object bridge;
  private ArrayList<Object> constructorParams;
  private ArrayList<Object> constructorTypes = new ArrayList();
  private XWalkCoreWrapper coreWrapper;
  private LazyReflectMethod enumConsoleMessageTypeClassValueOfMethod = new LazyReflectMethod();
  private LazyReflectMethod enumInitiateByClassValueOfMethod = new LazyReflectMethod();
  private LazyReflectMethod enumJavascriptMessageTypeClassValueOfMethod = new LazyReflectMethod();
  private LazyReflectMethod enumLoadStatusClassValueOfMethod = new LazyReflectMethod();
  private LazyReflectMethod getVideoLoadingProgressViewMethod = new LazyReflectMethod(null, "getVideoLoadingProgressView", new Class[0]);
  private LazyReflectMethod isSearchableMethod = new LazyReflectMethod(null, "isSearchable", new Class[0]);
  private LazyReflectMethod onConsoleMessageXWalkViewInternalStringintStringConsoleMessageTypeMethod = new LazyReflectMethod(null, "onConsoleMessage", new Class[0]);
  private LazyReflectMethod onCreateWindowRequestedXWalkViewInternalInitiateByInternalValueCallbackMethod = new LazyReflectMethod(null, "onCreateWindowRequested", new Class[0]);
  private LazyReflectMethod onDidChangeThemeColorXWalkViewInternalStringMessageMethod = new LazyReflectMethod(null, "onDidChangeThemeColor", new Class[0]);
  private LazyReflectMethod onFullscreenToggledXWalkViewInternalbooleanMethod = new LazyReflectMethod(null, "onFullscreenToggled", new Class[0]);
  private LazyReflectMethod onGeolocationPermissionsHidePromptMethod = new LazyReflectMethod(null, "onGeolocationPermissionsHidePrompt", new Class[0]);
  private LazyReflectMethod onGeolocationPermissionsShowPromptStringXWalkGeolocationPermissionsCallbackInternalMethod = new LazyReflectMethod(null, "onGeolocationPermissionsShowPrompt", new Class[0]);
  private LazyReflectMethod onGetTranslateStringXWalkViewInternalMapCallbackMethod = new LazyReflectMethod(null, "onGetTranslateString", new Class[0]);
  private LazyReflectMethod onHideCustomViewMethod = new LazyReflectMethod(null, "onHideCustomView", new Class[0]);
  private LazyReflectMethod onIconAvailableXWalkViewInternalStringMessageMethod = new LazyReflectMethod(null, "onIconAvailable", new Class[0]);
  private LazyReflectMethod onJavascriptCloseWindowXWalkViewInternalMethod = new LazyReflectMethod(null, "onJavascriptCloseWindow", new Class[0]);
  private LazyReflectMethod onJavascriptModalDialogXWalkViewInternalJavascriptMessageTypeInternalStringStringStringXWalkJavascriptResultInternalMethod = new LazyReflectMethod(null, "onJavascriptModalDialog", new Class[0]);
  private LazyReflectMethod onJsAlertXWalkViewInternalStringStringXWalkJavascriptResultInternalMethod = new LazyReflectMethod(null, "onJsAlert", new Class[0]);
  private LazyReflectMethod onJsConfirmXWalkViewInternalStringStringXWalkJavascriptResultInternalMethod = new LazyReflectMethod(null, "onJsConfirm", new Class[0]);
  private LazyReflectMethod onJsPromptXWalkViewInternalStringStringStringXWalkJavascriptResultInternalMethod = new LazyReflectMethod(null, "onJsPrompt", new Class[0]);
  private LazyReflectMethod onPageCommitVisibleXWalkViewInternalStringMethod = new LazyReflectMethod(null, "onPageCommitVisible", new Class[0]);
  private LazyReflectMethod onPageLoadStartedXWalkViewInternalStringMethod = new LazyReflectMethod(null, "onPageLoadStarted", new Class[0]);
  private LazyReflectMethod onPageLoadStoppedXWalkViewInternalStringLoadStatusInternalMethod = new LazyReflectMethod(null, "onPageLoadStopped", new Class[0]);
  private LazyReflectMethod onReceivedIconXWalkViewInternalStringBitmapMethod = new LazyReflectMethod(null, "onReceivedIcon", new Class[0]);
  private LazyReflectMethod onReceivedTitleXWalkViewInternalStringMethod = new LazyReflectMethod(null, "onReceivedTitle", new Class[0]);
  private LazyReflectMethod onRequestFocusXWalkViewInternalMethod = new LazyReflectMethod(null, "onRequestFocus", new Class[0]);
  private LazyReflectMethod onScaleChangedXWalkViewInternalfloatfloatMethod = new LazyReflectMethod(null, "onScaleChanged", new Class[0]);
  private LazyReflectMethod onSearchWordXWalkViewInternalStringStringStringCallbackMethod = new LazyReflectMethod(null, "onSearchWord", new Class[0]);
  private LazyReflectMethod onSelectInfoChangedXWalkViewInternallongStringStringStringCallbackMethod = new LazyReflectMethod(null, "onSelectInfoChanged", new Class[0]);
  private LazyReflectMethod onShowCustomViewViewCustomViewCallbackInternalMethod = new LazyReflectMethod(null, "onShowCustomView", new Class[0]);
  private LazyReflectMethod onShowCustomViewViewintCustomViewCallbackInternalMethod = new LazyReflectMethod(null, "onShowCustomView", new Class[0]);
  private LazyReflectMethod onShowFileChooserXWalkViewInternalValueCallbackStringStringMethod = new LazyReflectMethod(null, "onShowFileChooser", new Class[0]);
  private LazyReflectMethod onShowSosMethod = new LazyReflectMethod(null, "onShowSos", new Class[0]);
  private LazyReflectMethod onUnhandledKeyEventXWalkViewInternalKeyEventMethod = new LazyReflectMethod(null, "onUnhandledKeyEvent", new Class[0]);
  private LazyReflectMethod openFileChooserXWalkViewInternalValueCallbackStringStringMethod = new LazyReflectMethod(null, "openFileChooser", new Class[0]);
  private LazyReflectMethod postWrapperMethod;
  private LazyReflectMethod shouldOverrideKeyEventXWalkViewInternalKeyEventMethod = new LazyReflectMethod(null, "shouldOverrideKeyEvent", new Class[0]);
  
  public XWalkUIClient(XWalkView paramXWalkView)
  {
    this.constructorTypes.add("XWalkViewBridge");
    this.constructorParams = new ArrayList();
    this.constructorParams.add(paramXWalkView);
    reflectionInit();
  }
  
  private Object ConvertConsoleMessageType(XWalkUIClient.ConsoleMessageType paramConsoleMessageType)
  {
    return this.enumConsoleMessageTypeClassValueOfMethod.invoke(new Object[] { paramConsoleMessageType.toString() });
  }
  
  private Object ConvertInitiateBy(XWalkUIClient.InitiateBy paramInitiateBy)
  {
    return this.enumInitiateByClassValueOfMethod.invoke(new Object[] { paramInitiateBy.toString() });
  }
  
  private Object ConvertJavascriptMessageType(XWalkUIClient.JavascriptMessageType paramJavascriptMessageType)
  {
    return this.enumJavascriptMessageTypeClassValueOfMethod.invoke(new Object[] { paramJavascriptMessageType.toString() });
  }
  
  private Object ConvertLoadStatus(XWalkUIClient.LoadStatus paramLoadStatus)
  {
    return this.enumLoadStatusClassValueOfMethod.invoke(new Object[] { paramLoadStatus.toString() });
  }
  
  public boolean OnGetSampleString(XWalkView paramXWalkView, Map<String, String> paramMap)
  {
    try
    {
      boolean bool = ((Boolean)this.OnGetSampleStringXWalkViewInternalMapCallbackMethod.invoke(new Object[] { paramXWalkView.getBridge(), paramMap })).booleanValue();
      return bool;
    }
    catch (UnsupportedOperationException paramXWalkView)
    {
      if (this.coreWrapper != null)
      {
        XWalkCoreWrapper.handleRuntimeError(paramXWalkView);
        return false;
      }
      throw new RuntimeException("Crosswalk's APIs are not ready yet");
    }
  }
  
  protected Object getBridge()
  {
    return this.bridge;
  }
  
  public View getVideoLoadingProgressView()
  {
    try
    {
      View localView = (View)this.getVideoLoadingProgressViewMethod.invoke(new Object[0]);
      return localView;
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
  
  public boolean isSearchable()
  {
    try
    {
      boolean bool = ((Boolean)this.isSearchableMethod.invoke(new Object[0])).booleanValue();
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
  
  public void onClearCurrentPage() {}
  
  public boolean onConsoleMessage(XWalkView paramXWalkView, String paramString1, int paramInt, String paramString2, XWalkUIClient.ConsoleMessageType paramConsoleMessageType)
  {
    try
    {
      boolean bool = ((Boolean)this.onConsoleMessageXWalkViewInternalStringintStringConsoleMessageTypeMethod.invoke(new Object[] { paramXWalkView.getBridge(), paramString1, Integer.valueOf(paramInt), paramString2, ConvertConsoleMessageType(paramConsoleMessageType) })).booleanValue();
      return bool;
    }
    catch (UnsupportedOperationException paramXWalkView)
    {
      if (this.coreWrapper != null)
      {
        XWalkCoreWrapper.handleRuntimeError(paramXWalkView);
        return false;
      }
      throw new RuntimeException("Crosswalk's APIs are not ready yet");
    }
  }
  
  public boolean onCreateWindowRequested(XWalkView paramXWalkView, XWalkUIClient.InitiateBy paramInitiateBy, ValueCallback<XWalkView> paramValueCallback)
  {
    try
    {
      boolean bool = ((Boolean)this.onCreateWindowRequestedXWalkViewInternalInitiateByInternalValueCallbackMethod.invoke(new Object[] { paramXWalkView.getBridge(), ConvertInitiateBy(paramInitiateBy), paramValueCallback })).booleanValue();
      return bool;
    }
    catch (UnsupportedOperationException paramXWalkView)
    {
      if (this.coreWrapper != null)
      {
        XWalkCoreWrapper.handleRuntimeError(paramXWalkView);
        return false;
      }
      throw new RuntimeException("Crosswalk's APIs are not ready yet");
    }
  }
  
  public void onDidChangeThemeColor(XWalkView paramXWalkView, int paramInt)
  {
    try
    {
      this.onDidChangeThemeColorXWalkViewInternalStringMessageMethod.invoke(new Object[] { paramXWalkView.getBridge(), Integer.valueOf(paramInt) });
      return;
    }
    catch (UnsupportedOperationException paramXWalkView)
    {
      if (this.coreWrapper != null)
      {
        XWalkCoreWrapper.handleRuntimeError(paramXWalkView);
        return;
      }
      throw new RuntimeException("Crosswalk's APIs are not ready yet");
    }
  }
  
  public void onExitFullscreenVideo(Bitmap paramBitmap) {}
  
  public void onFullscreenToggled(XWalkView paramXWalkView, boolean paramBoolean)
  {
    try
    {
      this.onFullscreenToggledXWalkViewInternalbooleanMethod.invoke(new Object[] { paramXWalkView.getBridge(), Boolean.valueOf(paramBoolean) });
      return;
    }
    catch (UnsupportedOperationException paramXWalkView)
    {
      if (this.coreWrapper != null)
      {
        XWalkCoreWrapper.handleRuntimeError(paramXWalkView);
        return;
      }
      throw new RuntimeException("Crosswalk's APIs are not ready yet");
    }
  }
  
  public void onGeolocationPermissionsHidePrompt()
  {
    try
    {
      this.onGeolocationPermissionsHidePromptMethod.invoke(new Object[0]);
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
  
  public void onGeolocationPermissionsShowPrompt(String paramString, XWalkGeolocationPermissionsCallback paramXWalkGeolocationPermissionsCallback)
  {
    try
    {
      this.onGeolocationPermissionsShowPromptStringXWalkGeolocationPermissionsCallbackInternalMethod.invoke(new Object[] { paramString, ((XWalkGeolocationPermissionsCallbackHandler)paramXWalkGeolocationPermissionsCallback).getBridge() });
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
  
  public boolean onGetTranslateString(XWalkView paramXWalkView, Map<String, String> paramMap)
  {
    try
    {
      boolean bool = ((Boolean)this.onGetTranslateStringXWalkViewInternalMapCallbackMethod.invoke(new Object[] { paramXWalkView.getBridge(), paramMap })).booleanValue();
      return bool;
    }
    catch (UnsupportedOperationException paramXWalkView)
    {
      if (this.coreWrapper != null)
      {
        XWalkCoreWrapper.handleRuntimeError(paramXWalkView);
        return false;
      }
      throw new RuntimeException("Crosswalk's APIs are not ready yet");
    }
  }
  
  public void onHideCustomView()
  {
    try
    {
      this.onHideCustomViewMethod.invoke(new Object[0]);
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
  
  public void onIconAvailable(XWalkView paramXWalkView, String paramString, Message paramMessage)
  {
    try
    {
      this.onIconAvailableXWalkViewInternalStringMessageMethod.invoke(new Object[] { paramXWalkView.getBridge(), paramString, paramMessage });
      return;
    }
    catch (UnsupportedOperationException paramXWalkView)
    {
      if (this.coreWrapper != null)
      {
        XWalkCoreWrapper.handleRuntimeError(paramXWalkView);
        return;
      }
      throw new RuntimeException("Crosswalk's APIs are not ready yet");
    }
  }
  
  public void onJavascriptCloseWindow(XWalkView paramXWalkView)
  {
    try
    {
      this.onJavascriptCloseWindowXWalkViewInternalMethod.invoke(new Object[] { paramXWalkView.getBridge() });
      return;
    }
    catch (UnsupportedOperationException paramXWalkView)
    {
      if (this.coreWrapper != null)
      {
        XWalkCoreWrapper.handleRuntimeError(paramXWalkView);
        return;
      }
      throw new RuntimeException("Crosswalk's APIs are not ready yet");
    }
  }
  
  public boolean onJavascriptModalDialog(XWalkView paramXWalkView, XWalkUIClient.JavascriptMessageType paramJavascriptMessageType, String paramString1, String paramString2, String paramString3, XWalkJavascriptResult paramXWalkJavascriptResult)
  {
    try
    {
      boolean bool = ((Boolean)this.onJavascriptModalDialogXWalkViewInternalJavascriptMessageTypeInternalStringStringStringXWalkJavascriptResultInternalMethod.invoke(new Object[] { paramXWalkView.getBridge(), ConvertJavascriptMessageType(paramJavascriptMessageType), paramString1, paramString2, paramString3, ((XWalkJavascriptResultHandler)paramXWalkJavascriptResult).getBridge() })).booleanValue();
      return bool;
    }
    catch (UnsupportedOperationException paramXWalkView)
    {
      if (this.coreWrapper != null)
      {
        XWalkCoreWrapper.handleRuntimeError(paramXWalkView);
        return false;
      }
      throw new RuntimeException("Crosswalk's APIs are not ready yet");
    }
  }
  
  public boolean onJsAlert(XWalkView paramXWalkView, String paramString1, String paramString2, XWalkJavascriptResult paramXWalkJavascriptResult)
  {
    try
    {
      boolean bool = ((Boolean)this.onJsAlertXWalkViewInternalStringStringXWalkJavascriptResultInternalMethod.invoke(new Object[] { paramXWalkView.getBridge(), paramString1, paramString2, ((XWalkJavascriptResultHandler)paramXWalkJavascriptResult).getBridge() })).booleanValue();
      return bool;
    }
    catch (UnsupportedOperationException paramXWalkView)
    {
      if (this.coreWrapper != null)
      {
        XWalkCoreWrapper.handleRuntimeError(paramXWalkView);
        return false;
      }
      throw new RuntimeException("Crosswalk's APIs are not ready yet");
    }
  }
  
  public boolean onJsConfirm(XWalkView paramXWalkView, String paramString1, String paramString2, XWalkJavascriptResult paramXWalkJavascriptResult)
  {
    try
    {
      boolean bool = ((Boolean)this.onJsConfirmXWalkViewInternalStringStringXWalkJavascriptResultInternalMethod.invoke(new Object[] { paramXWalkView.getBridge(), paramString1, paramString2, ((XWalkJavascriptResultHandler)paramXWalkJavascriptResult).getBridge() })).booleanValue();
      return bool;
    }
    catch (UnsupportedOperationException paramXWalkView)
    {
      if (this.coreWrapper != null)
      {
        XWalkCoreWrapper.handleRuntimeError(paramXWalkView);
        return false;
      }
      throw new RuntimeException("Crosswalk's APIs are not ready yet");
    }
  }
  
  public boolean onJsPrompt(XWalkView paramXWalkView, String paramString1, String paramString2, String paramString3, XWalkJavascriptResult paramXWalkJavascriptResult)
  {
    try
    {
      boolean bool = ((Boolean)this.onJsPromptXWalkViewInternalStringStringStringXWalkJavascriptResultInternalMethod.invoke(new Object[] { paramXWalkView.getBridge(), paramString1, paramString2, paramString3, ((XWalkJavascriptResultHandler)paramXWalkJavascriptResult).getBridge() })).booleanValue();
      return bool;
    }
    catch (UnsupportedOperationException paramXWalkView)
    {
      if (this.coreWrapper != null)
      {
        XWalkCoreWrapper.handleRuntimeError(paramXWalkView);
        return false;
      }
      throw new RuntimeException("Crosswalk's APIs are not ready yet");
    }
  }
  
  public void onPageCommitVisible(XWalkView paramXWalkView, String paramString)
  {
    try
    {
      this.onPageCommitVisibleXWalkViewInternalStringMethod.invoke(new Object[] { paramXWalkView.getBridge(), paramString });
      return;
    }
    catch (UnsupportedOperationException paramXWalkView)
    {
      if (this.coreWrapper != null)
      {
        XWalkCoreWrapper.handleRuntimeError(paramXWalkView);
        return;
      }
      throw new RuntimeException("Crosswalk's APIs are not ready yet");
    }
  }
  
  public void onPageLoadStarted(XWalkView paramXWalkView, String paramString)
  {
    try
    {
      this.onPageLoadStartedXWalkViewInternalStringMethod.invoke(new Object[] { paramXWalkView.getBridge(), paramString });
      return;
    }
    catch (UnsupportedOperationException paramXWalkView)
    {
      if (this.coreWrapper != null)
      {
        XWalkCoreWrapper.handleRuntimeError(paramXWalkView);
        return;
      }
      throw new RuntimeException("Crosswalk's APIs are not ready yet");
    }
  }
  
  public void onPageLoadStopped(XWalkView paramXWalkView, String paramString, XWalkUIClient.LoadStatus paramLoadStatus)
  {
    try
    {
      this.onPageLoadStoppedXWalkViewInternalStringLoadStatusInternalMethod.invoke(new Object[] { paramXWalkView.getBridge(), paramString, ConvertLoadStatus(paramLoadStatus) });
      return;
    }
    catch (UnsupportedOperationException paramXWalkView)
    {
      if (this.coreWrapper != null)
      {
        XWalkCoreWrapper.handleRuntimeError(paramXWalkView);
        return;
      }
      throw new RuntimeException("Crosswalk's APIs are not ready yet");
    }
  }
  
  public void onReceivedIcon(XWalkView paramXWalkView, String paramString, Bitmap paramBitmap)
  {
    try
    {
      this.onReceivedIconXWalkViewInternalStringBitmapMethod.invoke(new Object[] { paramXWalkView.getBridge(), paramString, paramBitmap });
      return;
    }
    catch (UnsupportedOperationException paramXWalkView)
    {
      if (this.coreWrapper != null)
      {
        XWalkCoreWrapper.handleRuntimeError(paramXWalkView);
        return;
      }
      throw new RuntimeException("Crosswalk's APIs are not ready yet");
    }
  }
  
  public void onReceivedTitle(XWalkView paramXWalkView, String paramString)
  {
    try
    {
      this.onReceivedTitleXWalkViewInternalStringMethod.invoke(new Object[] { paramXWalkView.getBridge(), paramString });
      return;
    }
    catch (UnsupportedOperationException paramXWalkView)
    {
      if (this.coreWrapper != null)
      {
        XWalkCoreWrapper.handleRuntimeError(paramXWalkView);
        return;
      }
      throw new RuntimeException("Crosswalk's APIs are not ready yet");
    }
  }
  
  public void onRequestFocus(XWalkView paramXWalkView)
  {
    try
    {
      this.onRequestFocusXWalkViewInternalMethod.invoke(new Object[] { paramXWalkView.getBridge() });
      return;
    }
    catch (UnsupportedOperationException paramXWalkView)
    {
      if (this.coreWrapper != null)
      {
        XWalkCoreWrapper.handleRuntimeError(paramXWalkView);
        return;
      }
      throw new RuntimeException("Crosswalk's APIs are not ready yet");
    }
  }
  
  public void onScaleChanged(XWalkView paramXWalkView, float paramFloat1, float paramFloat2)
  {
    try
    {
      this.onScaleChangedXWalkViewInternalfloatfloatMethod.invoke(new Object[] { paramXWalkView.getBridge(), Float.valueOf(paramFloat1), Float.valueOf(paramFloat2) });
      return;
    }
    catch (UnsupportedOperationException paramXWalkView)
    {
      if (this.coreWrapper != null)
      {
        XWalkCoreWrapper.handleRuntimeError(paramXWalkView);
        return;
      }
      throw new RuntimeException("Crosswalk's APIs are not ready yet");
    }
  }
  
  public boolean onSearchWord(XWalkView paramXWalkView, String paramString1, String paramString2, String paramString3)
  {
    try
    {
      boolean bool = ((Boolean)this.onSearchWordXWalkViewInternalStringStringStringCallbackMethod.invoke(new Object[] { paramXWalkView.getBridge(), paramString1, paramString2, paramString3 })).booleanValue();
      return bool;
    }
    catch (UnsupportedOperationException paramXWalkView)
    {
      if (this.coreWrapper != null)
      {
        XWalkCoreWrapper.handleRuntimeError(paramXWalkView);
        return false;
      }
      throw new RuntimeException("Crosswalk's APIs are not ready yet");
    }
  }
  
  public boolean onSelectInfoChanged(XWalkView paramXWalkView, long paramLong, String paramString1, String paramString2, String paramString3)
  {
    try
    {
      boolean bool = ((Boolean)this.onSelectInfoChangedXWalkViewInternallongStringStringStringCallbackMethod.invoke(new Object[] { paramXWalkView.getBridge(), Long.valueOf(paramLong), paramString1, paramString2, paramString3 })).booleanValue();
      return bool;
    }
    catch (UnsupportedOperationException paramXWalkView)
    {
      if (this.coreWrapper != null)
      {
        XWalkCoreWrapper.handleRuntimeError(paramXWalkView);
        return false;
      }
      throw new RuntimeException("Crosswalk's APIs are not ready yet");
    }
  }
  
  public void onShowCustomView(View paramView, int paramInt, CustomViewCallback paramCustomViewCallback)
  {
    try
    {
      this.onShowCustomViewViewintCustomViewCallbackInternalMethod.invoke(new Object[] { paramView, Integer.valueOf(paramInt), ((CustomViewCallbackHandler)paramCustomViewCallback).getBridge() });
      return;
    }
    catch (UnsupportedOperationException paramView)
    {
      if (this.coreWrapper != null)
      {
        XWalkCoreWrapper.handleRuntimeError(paramView);
        return;
      }
      throw new RuntimeException("Crosswalk's APIs are not ready yet");
    }
  }
  
  public void onShowCustomView(View paramView, CustomViewCallback paramCustomViewCallback)
  {
    try
    {
      this.onShowCustomViewViewCustomViewCallbackInternalMethod.invoke(new Object[] { paramView, ((CustomViewCallbackHandler)paramCustomViewCallback).getBridge() });
      return;
    }
    catch (UnsupportedOperationException paramView)
    {
      if (this.coreWrapper != null)
      {
        XWalkCoreWrapper.handleRuntimeError(paramView);
        return;
      }
      throw new RuntimeException("Crosswalk's APIs are not ready yet");
    }
  }
  
  public boolean onShowFileChooser(XWalkView paramXWalkView, ValueCallback<Uri[]> paramValueCallback, WebChromeClient.FileChooserParams paramFileChooserParams)
  {
    try
    {
      boolean bool = ((Boolean)this.onShowFileChooserXWalkViewInternalValueCallbackStringStringMethod.invoke(new Object[] { paramXWalkView.getBridge(), paramValueCallback, paramFileChooserParams })).booleanValue();
      return bool;
    }
    catch (UnsupportedOperationException paramXWalkView)
    {
      if (this.coreWrapper != null)
      {
        XWalkCoreWrapper.handleRuntimeError(paramXWalkView);
        return false;
      }
      throw new RuntimeException("Crosswalk's APIs are not ready yet");
    }
  }
  
  public void onShowSos()
  {
    try
    {
      this.onShowSosMethod.invoke(new Object[0]);
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
  
  public void onUnhandledKeyEvent(XWalkView paramXWalkView, KeyEvent paramKeyEvent)
  {
    try
    {
      this.onUnhandledKeyEventXWalkViewInternalKeyEventMethod.invoke(new Object[] { paramXWalkView.getBridge(), paramKeyEvent });
      return;
    }
    catch (UnsupportedOperationException paramXWalkView)
    {
      if (this.coreWrapper != null)
      {
        XWalkCoreWrapper.handleRuntimeError(paramXWalkView);
        return;
      }
      throw new RuntimeException("Crosswalk's APIs are not ready yet");
    }
  }
  
  public void openFileChooser(XWalkView paramXWalkView, ValueCallback<Uri> paramValueCallback, String paramString1, String paramString2)
  {
    try
    {
      this.openFileChooserXWalkViewInternalValueCallbackStringStringMethod.invoke(new Object[] { paramXWalkView.getBridge(), paramValueCallback, paramString1, paramString2 });
      return;
    }
    catch (UnsupportedOperationException paramXWalkView)
    {
      if (this.coreWrapper != null)
      {
        XWalkCoreWrapper.handleRuntimeError(paramXWalkView);
        return;
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
    localObject1 = new ReflectConstructor(this.coreWrapper.getBridgeClass("XWalkUIClientBridge"), (Class[])localObject1);
    try
    {
      this.bridge = ((ReflectConstructor)localObject1).newInstance(this.constructorParams.toArray());
      localObject1 = this.postWrapperMethod;
      if (localObject1 != null) {
        ((LazyReflectMethod)localObject1).invoke(new Object[0]);
      }
      this.enumJavascriptMessageTypeClassValueOfMethod.init(null, this.coreWrapper.getBridgeClass("XWalkUIClientInternal$JavascriptMessageTypeInternal"), "valueOf", new Class[] { String.class });
      this.enumConsoleMessageTypeClassValueOfMethod.init(null, this.coreWrapper.getBridgeClass("XWalkUIClientInternal$ConsoleMessageType"), "valueOf", new Class[] { String.class });
      this.enumInitiateByClassValueOfMethod.init(null, this.coreWrapper.getBridgeClass("XWalkUIClientInternal$InitiateByInternal"), "valueOf", new Class[] { String.class });
      this.enumLoadStatusClassValueOfMethod.init(null, this.coreWrapper.getBridgeClass("XWalkUIClientInternal$LoadStatusInternal"), "valueOf", new Class[] { String.class });
      this.onCreateWindowRequestedXWalkViewInternalInitiateByInternalValueCallbackMethod.init(this.bridge, null, "onCreateWindowRequestedSuper", new Class[] { this.coreWrapper.getBridgeClass("XWalkViewBridge"), this.coreWrapper.getBridgeClass("XWalkUIClientInternal$InitiateByInternal"), ValueCallback.class });
      this.onDidChangeThemeColorXWalkViewInternalStringMessageMethod.init(this.bridge, null, "onDidChangeThemeColorSuper", new Class[] { this.coreWrapper.getBridgeClass("XWalkViewBridge"), Integer.TYPE });
      this.onIconAvailableXWalkViewInternalStringMessageMethod.init(this.bridge, null, "onIconAvailableSuper", new Class[] { this.coreWrapper.getBridgeClass("XWalkViewBridge"), String.class, Message.class });
      this.onReceivedIconXWalkViewInternalStringBitmapMethod.init(this.bridge, null, "onReceivedIconSuper", new Class[] { this.coreWrapper.getBridgeClass("XWalkViewBridge"), String.class, Bitmap.class });
      this.onRequestFocusXWalkViewInternalMethod.init(this.bridge, null, "onRequestFocusSuper", new Class[] { this.coreWrapper.getBridgeClass("XWalkViewBridge") });
      this.onJavascriptCloseWindowXWalkViewInternalMethod.init(this.bridge, null, "onJavascriptCloseWindowSuper", new Class[] { this.coreWrapper.getBridgeClass("XWalkViewBridge") });
      this.onJavascriptModalDialogXWalkViewInternalJavascriptMessageTypeInternalStringStringStringXWalkJavascriptResultInternalMethod.init(this.bridge, null, "onJavascriptModalDialogSuper", new Class[] { this.coreWrapper.getBridgeClass("XWalkViewBridge"), this.coreWrapper.getBridgeClass("XWalkUIClientInternal$JavascriptMessageTypeInternal"), String.class, String.class, String.class, this.coreWrapper.getBridgeClass("XWalkJavascriptResultHandlerBridge") });
      this.onFullscreenToggledXWalkViewInternalbooleanMethod.init(this.bridge, null, "onFullscreenToggledSuper", new Class[] { this.coreWrapper.getBridgeClass("XWalkViewBridge"), Boolean.TYPE });
      this.openFileChooserXWalkViewInternalValueCallbackStringStringMethod.init(this.bridge, null, "openFileChooserSuper", new Class[] { this.coreWrapper.getBridgeClass("XWalkViewBridge"), ValueCallback.class, String.class, String.class });
      this.onShowFileChooserXWalkViewInternalValueCallbackStringStringMethod.init(this.bridge, null, "onShowFileChooser", new Class[] { this.coreWrapper.getBridgeClass("XWalkViewBridge"), ValueCallback.class, WebChromeClient.FileChooserParams.class });
      this.onScaleChangedXWalkViewInternalfloatfloatMethod.init(this.bridge, null, "onScaleChangedSuper", new Class[] { this.coreWrapper.getBridgeClass("XWalkViewBridge"), Float.TYPE, Float.TYPE });
      this.shouldOverrideKeyEventXWalkViewInternalKeyEventMethod.init(this.bridge, null, "shouldOverrideKeyEventSuper", new Class[] { this.coreWrapper.getBridgeClass("XWalkViewBridge"), KeyEvent.class });
      this.onUnhandledKeyEventXWalkViewInternalKeyEventMethod.init(this.bridge, null, "onUnhandledKeyEventSuper", new Class[] { this.coreWrapper.getBridgeClass("XWalkViewBridge"), KeyEvent.class });
      this.onConsoleMessageXWalkViewInternalStringintStringConsoleMessageTypeMethod.init(this.bridge, null, "onConsoleMessageSuper", new Class[] { this.coreWrapper.getBridgeClass("XWalkViewBridge"), String.class, Integer.TYPE, String.class, this.coreWrapper.getBridgeClass("XWalkUIClientInternal$ConsoleMessageType") });
      this.onReceivedTitleXWalkViewInternalStringMethod.init(this.bridge, null, "onReceivedTitleSuper", new Class[] { this.coreWrapper.getBridgeClass("XWalkViewBridge"), String.class });
      this.onPageLoadStartedXWalkViewInternalStringMethod.init(this.bridge, null, "onPageLoadStartedSuper", new Class[] { this.coreWrapper.getBridgeClass("XWalkViewBridge"), String.class });
      this.onPageLoadStoppedXWalkViewInternalStringLoadStatusInternalMethod.init(this.bridge, null, "onPageLoadStoppedSuper", new Class[] { this.coreWrapper.getBridgeClass("XWalkViewBridge"), String.class, this.coreWrapper.getBridgeClass("XWalkUIClientInternal$LoadStatusInternal") });
      this.onPageCommitVisibleXWalkViewInternalStringMethod.init(this.bridge, null, "onPageCommitVisibleSuper", new Class[] { this.coreWrapper.getBridgeClass("XWalkViewBridge"), String.class });
      this.onJsAlertXWalkViewInternalStringStringXWalkJavascriptResultInternalMethod.init(this.bridge, null, "onJsAlertSuper", new Class[] { this.coreWrapper.getBridgeClass("XWalkViewBridge"), String.class, String.class, this.coreWrapper.getBridgeClass("XWalkJavascriptResultHandlerBridge") });
      this.onJsConfirmXWalkViewInternalStringStringXWalkJavascriptResultInternalMethod.init(this.bridge, null, "onJsConfirmSuper", new Class[] { this.coreWrapper.getBridgeClass("XWalkViewBridge"), String.class, String.class, this.coreWrapper.getBridgeClass("XWalkJavascriptResultHandlerBridge") });
      this.onJsPromptXWalkViewInternalStringStringStringXWalkJavascriptResultInternalMethod.init(this.bridge, null, "onJsPromptSuper", new Class[] { this.coreWrapper.getBridgeClass("XWalkViewBridge"), String.class, String.class, String.class, this.coreWrapper.getBridgeClass("XWalkJavascriptResultHandlerBridge") });
      this.onShowCustomViewViewCustomViewCallbackInternalMethod.init(this.bridge, null, "onShowCustomViewSuper", new Class[] { View.class, this.coreWrapper.getBridgeClass("CustomViewCallbackHandlerBridge") });
      this.onShowCustomViewViewintCustomViewCallbackInternalMethod.init(this.bridge, null, "onShowCustomViewSuper", new Class[] { View.class, Integer.TYPE, this.coreWrapper.getBridgeClass("CustomViewCallbackHandlerBridge") });
      this.onHideCustomViewMethod.init(this.bridge, null, "onHideCustomViewSuper", new Class[0]);
      this.onGeolocationPermissionsShowPromptStringXWalkGeolocationPermissionsCallbackInternalMethod.init(this.bridge, null, "onGeolocationPermissionsShowPromptSuper", new Class[] { String.class, this.coreWrapper.getBridgeClass("XWalkGeolocationPermissionsCallbackHandlerBridge") });
      this.onGeolocationPermissionsHidePromptMethod.init(this.bridge, null, "onGeolocationPermissionsHidePromptSuper", new Class[0]);
      this.getVideoLoadingProgressViewMethod.init(this.bridge, null, "getVideoLoadingProgressView", new Class[0]);
      this.onSelectInfoChangedXWalkViewInternallongStringStringStringCallbackMethod.init(this.bridge, null, "onSelectInfoChanged", new Class[] { this.coreWrapper.getBridgeClass("XWalkViewBridge"), Long.TYPE, String.class, String.class, String.class });
      this.isSearchableMethod.init(this.bridge, null, "isSearchable", new Class[0]);
      this.onShowSosMethod.init(this.bridge, null, "onShowSos", new Class[0]);
      this.onSearchWordXWalkViewInternalStringStringStringCallbackMethod.init(this.bridge, null, "onSearchWord", new Class[] { this.coreWrapper.getBridgeClass("XWalkViewBridge"), String.class, String.class, String.class });
      this.onGetTranslateStringXWalkViewInternalMapCallbackMethod.init(this.bridge, null, "onGetTranslateString", new Class[] { this.coreWrapper.getBridgeClass("XWalkViewBridge"), Map.class });
      this.OnGetSampleStringXWalkViewInternalMapCallbackMethod.init(this.bridge, null, "OnGetSampleString", new Class[] { this.coreWrapper.getBridgeClass("XWalkViewBridge"), Map.class });
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException) {}
  }
  
  public boolean shouldDiscardCurrentPage()
  {
    return false;
  }
  
  public boolean shouldOverrideKeyEvent(XWalkView paramXWalkView, KeyEvent paramKeyEvent)
  {
    try
    {
      boolean bool = ((Boolean)this.shouldOverrideKeyEventXWalkViewInternalKeyEventMethod.invoke(new Object[] { paramXWalkView.getBridge(), paramKeyEvent })).booleanValue();
      return bool;
    }
    catch (UnsupportedOperationException paramXWalkView)
    {
      if (this.coreWrapper != null)
      {
        XWalkCoreWrapper.handleRuntimeError(paramXWalkView);
        return false;
      }
      throw new RuntimeException("Crosswalk's APIs are not ready yet");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.xwalk.core.XWalkUIClient
 * JD-Core Version:    0.7.0.1
 */