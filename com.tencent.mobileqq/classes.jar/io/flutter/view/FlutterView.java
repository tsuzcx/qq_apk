package io.flutter.view;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Insets;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.os.Build.VERSION;
import android.os.LocaleList;
import android.text.format.DateFormat;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.View;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeProvider;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.UiThread;
import io.flutter.app.FlutterPluginRegistry;
import io.flutter.embedding.android.AndroidKeyProcessor;
import io.flutter.embedding.android.AndroidTouchProcessor;
import io.flutter.embedding.engine.FlutterJNI;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.embedding.engine.renderer.FlutterRenderer;
import io.flutter.embedding.engine.systemchannels.AccessibilityChannel;
import io.flutter.embedding.engine.systemchannels.KeyEventChannel;
import io.flutter.embedding.engine.systemchannels.LifecycleChannel;
import io.flutter.embedding.engine.systemchannels.LocalizationChannel;
import io.flutter.embedding.engine.systemchannels.NavigationChannel;
import io.flutter.embedding.engine.systemchannels.PlatformChannel;
import io.flutter.embedding.engine.systemchannels.SettingsChannel;
import io.flutter.embedding.engine.systemchannels.SettingsChannel.MessageBuilder;
import io.flutter.embedding.engine.systemchannels.SettingsChannel.PlatformBrightness;
import io.flutter.embedding.engine.systemchannels.SystemChannel;
import io.flutter.plugin.common.ActivityLifecycleListener;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.BinaryMessenger.BinaryMessageHandler;
import io.flutter.plugin.common.BinaryMessenger.BinaryReply;
import io.flutter.plugin.editing.TextInputPlugin;
import io.flutter.plugin.platform.PlatformPlugin;
import io.flutter.plugin.platform.PlatformViewsController;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class FlutterView
  extends SurfaceView
  implements BinaryMessenger, TextureRegistry
{
  private static final String TAG = "FlutterView";
  private final AndroidKeyProcessor androidKeyProcessor;
  private final AndroidTouchProcessor androidTouchProcessor;
  private final DartExecutor dartExecutor;
  private boolean didRenderFirstFrame = false;
  private final FlutterRenderer flutterRenderer;
  private final KeyEventChannel keyEventChannel;
  private final LifecycleChannel lifecycleChannel;
  private final LocalizationChannel localizationChannel;
  private AccessibilityBridge mAccessibilityNodeProvider;
  private final List<ActivityLifecycleListener> mActivityLifecycleListeners;
  private final List<FlutterView.FirstFrameListener> mFirstFrameListeners;
  private final InputMethodManager mImm;
  private boolean mIsSoftwareRenderingEnabled = false;
  private final FlutterView.ViewportMetrics mMetrics;
  private FlutterNativeView mNativeView;
  private final SurfaceHolder.Callback mSurfaceCallback;
  private final TextInputPlugin mTextInputPlugin;
  private final NavigationChannel navigationChannel;
  private final AtomicLong nextTextureId = new AtomicLong(0L);
  private final AccessibilityBridge.OnAccessibilityChangeListener onAccessibilityChangeListener = new FlutterView.1(this);
  private final PlatformChannel platformChannel;
  private final SettingsChannel settingsChannel;
  private final SystemChannel systemChannel;
  
  public FlutterView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public FlutterView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, null);
  }
  
  public FlutterView(Context paramContext, AttributeSet paramAttributeSet, FlutterNativeView paramFlutterNativeView)
  {
    super(paramContext, paramAttributeSet);
    paramAttributeSet = getActivity(getContext());
    if (paramAttributeSet != null)
    {
      if (paramFlutterNativeView == null) {}
      for (this.mNativeView = new FlutterNativeView(paramAttributeSet.getApplicationContext());; this.mNativeView = paramFlutterNativeView)
      {
        this.dartExecutor = this.mNativeView.getDartExecutor();
        this.flutterRenderer = new FlutterRenderer(this.mNativeView.getFlutterJNI());
        this.mIsSoftwareRenderingEnabled = this.mNativeView.getFlutterJNI().nativeGetIsSoftwareRenderingEnabled();
        this.mMetrics = new FlutterView.ViewportMetrics();
        this.mMetrics.devicePixelRatio = paramContext.getResources().getDisplayMetrics().density;
        setFocusable(true);
        setFocusableInTouchMode(true);
        this.mNativeView.attachViewAndActivity(this, paramAttributeSet);
        this.mSurfaceCallback = new FlutterView.2(this);
        getHolder().addCallback(this.mSurfaceCallback);
        this.mActivityLifecycleListeners = new ArrayList();
        this.mFirstFrameListeners = new ArrayList();
        this.navigationChannel = new NavigationChannel(this.dartExecutor);
        this.keyEventChannel = new KeyEventChannel(this.dartExecutor);
        this.lifecycleChannel = new LifecycleChannel(this.dartExecutor);
        this.localizationChannel = new LocalizationChannel(this.dartExecutor);
        this.platformChannel = new PlatformChannel(this.dartExecutor);
        this.systemChannel = new SystemChannel(this.dartExecutor);
        this.settingsChannel = new SettingsChannel(this.dartExecutor);
        addActivityLifecycleListener(new FlutterView.3(this, new PlatformPlugin(paramAttributeSet, this.platformChannel)));
        this.mImm = ((InputMethodManager)getContext().getSystemService("input_method"));
        paramContext = this.mNativeView.getPluginRegistry().getPlatformViewsController();
        this.mTextInputPlugin = new TextInputPlugin(this, this.dartExecutor, paramContext);
        this.androidKeyProcessor = new AndroidKeyProcessor(this.keyEventChannel, this.mTextInputPlugin);
        this.androidTouchProcessor = new AndroidTouchProcessor(this.flutterRenderer);
        this.mNativeView.getPluginRegistry().getPlatformViewsController().attachTextInputPlugin(this.mTextInputPlugin);
        sendLocalesToDart(getResources().getConfiguration());
        sendUserPlatformSettingsToDart();
        return;
      }
    }
    throw new IllegalArgumentException("Bad context");
  }
  
  private static Activity getActivity(Context paramContext)
  {
    if (paramContext == null) {
      return null;
    }
    if ((paramContext instanceof Activity)) {
      return (Activity)paramContext;
    }
    if ((paramContext instanceof ContextWrapper)) {
      return getActivity(((ContextWrapper)paramContext).getBaseContext());
    }
    return null;
  }
  
  private boolean isAttached()
  {
    return (this.mNativeView != null) && (this.mNativeView.isAttached());
  }
  
  private void postRun() {}
  
  private void preRun()
  {
    resetAccessibilityTree();
  }
  
  private void resetWillNotDraw(boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool2 = false;
    if (!this.mIsSoftwareRenderingEnabled)
    {
      boolean bool1 = bool2;
      if (!paramBoolean1)
      {
        bool1 = bool2;
        if (!paramBoolean2) {
          bool1 = true;
        }
      }
      setWillNotDraw(bool1);
      return;
    }
    setWillNotDraw(false);
  }
  
  private void sendLocalesToDart(Configuration paramConfiguration)
  {
    ArrayList localArrayList = new ArrayList();
    if (Build.VERSION.SDK_INT >= 24)
    {
      paramConfiguration = paramConfiguration.getLocales();
      int j = paramConfiguration.size();
      int i = 0;
      while (i < j)
      {
        localArrayList.add(paramConfiguration.get(i));
        i += 1;
      }
    }
    localArrayList.add(paramConfiguration.locale);
    this.localizationChannel.sendLocales(localArrayList);
  }
  
  private void sendUserPlatformSettingsToDart()
  {
    int i;
    if ((getResources().getConfiguration().uiMode & 0x30) == 32)
    {
      i = 1;
      if (i == 0) {
        break label71;
      }
    }
    label71:
    for (SettingsChannel.PlatformBrightness localPlatformBrightness = SettingsChannel.PlatformBrightness.dark;; localPlatformBrightness = SettingsChannel.PlatformBrightness.light)
    {
      this.settingsChannel.startMessage().setTextScaleFactor(getResources().getConfiguration().fontScale).setUse24HourFormat(DateFormat.is24HourFormat(getContext())).setPlatformBrightness(localPlatformBrightness).send();
      return;
      i = 0;
      break;
    }
  }
  
  private void updateViewportMetrics()
  {
    if (!isAttached()) {
      return;
    }
    this.mNativeView.getFlutterJNI().setViewportMetrics(this.mMetrics.devicePixelRatio, this.mMetrics.physicalWidth, this.mMetrics.physicalHeight, this.mMetrics.physicalPaddingTop, this.mMetrics.physicalPaddingRight, this.mMetrics.physicalPaddingBottom, this.mMetrics.physicalPaddingLeft, this.mMetrics.physicalViewInsetTop, this.mMetrics.physicalViewInsetRight, this.mMetrics.physicalViewInsetBottom, this.mMetrics.physicalViewInsetLeft, this.mMetrics.systemGestureInsetTop, this.mMetrics.systemGestureInsetRight, this.mMetrics.systemGestureInsetBottom, this.mMetrics.systemGestureInsetLeft);
  }
  
  public void addActivityLifecycleListener(ActivityLifecycleListener paramActivityLifecycleListener)
  {
    this.mActivityLifecycleListeners.add(paramActivityLifecycleListener);
  }
  
  public void addFirstFrameListener(FlutterView.FirstFrameListener paramFirstFrameListener)
  {
    this.mFirstFrameListeners.add(paramFirstFrameListener);
  }
  
  void assertAttached()
  {
    if (isAttached()) {
      return;
    }
    throw new AssertionError("Platform view is not attached");
  }
  
  @TargetApi(20)
  @RequiresApi(20)
  int calculateBottomKeyboardInset(WindowInsets paramWindowInsets)
  {
    int i = getRootView().getHeight();
    double d1 = paramWindowInsets.getSystemWindowInsetBottom();
    double d2 = i;
    Double.isNaN(d2);
    if (d1 < d2 * 0.18D) {
      return 0;
    }
    return paramWindowInsets.getSystemWindowInsetBottom();
  }
  
  FlutterView.ZeroSides calculateShouldZeroSides()
  {
    Activity localActivity = (Activity)getContext();
    int i = localActivity.getResources().getConfiguration().orientation;
    int j = localActivity.getWindowManager().getDefaultDisplay().getRotation();
    if (i == 2)
    {
      if (j == 1) {
        return FlutterView.ZeroSides.RIGHT;
      }
      if (j == 3)
      {
        if (Build.VERSION.SDK_INT >= 23) {
          return FlutterView.ZeroSides.LEFT;
        }
        return FlutterView.ZeroSides.RIGHT;
      }
      if ((j == 0) || (j == 2)) {
        return FlutterView.ZeroSides.BOTH;
      }
    }
    return FlutterView.ZeroSides.NONE;
  }
  
  public boolean checkInputConnectionProxy(View paramView)
  {
    return this.mNativeView.getPluginRegistry().getPlatformViewsController().checkInputConnectionProxy(paramView);
  }
  
  public TextureRegistry.SurfaceTextureEntry createSurfaceTexture()
  {
    SurfaceTexture localSurfaceTexture = new SurfaceTexture(0);
    localSurfaceTexture.detachFromGLContext();
    FlutterView.SurfaceTextureRegistryEntry localSurfaceTextureRegistryEntry = new FlutterView.SurfaceTextureRegistryEntry(this, this.nextTextureId.getAndIncrement(), localSurfaceTexture);
    this.mNativeView.getFlutterJNI().registerTexture(localSurfaceTextureRegistryEntry.id(), localSurfaceTexture);
    return localSurfaceTextureRegistryEntry;
  }
  
  public void destroy()
  {
    if (!isAttached()) {
      return;
    }
    getHolder().removeCallback(this.mSurfaceCallback);
    this.mNativeView.destroy();
    this.mNativeView = null;
  }
  
  public FlutterNativeView detach()
  {
    if (!isAttached()) {
      return null;
    }
    getHolder().removeCallback(this.mSurfaceCallback);
    this.mNativeView.detachFromFlutterView();
    FlutterNativeView localFlutterNativeView = this.mNativeView;
    this.mNativeView = null;
    return localFlutterNativeView;
  }
  
  public void disableTransparentBackground()
  {
    setZOrderOnTop(false);
    getHolder().setFormat(-1);
  }
  
  @Deprecated
  public void enableTransparentBackground()
  {
    Log.w("FlutterView", "Warning: FlutterView is set on top of the window. Accessibility highlights will not be visible in the Flutter UI. https://github.com/flutter/flutter/issues/37025");
    setZOrderOnTop(true);
    getHolder().setFormat(-2);
  }
  
  protected boolean fitSystemWindows(Rect paramRect)
  {
    if (Build.VERSION.SDK_INT <= 19)
    {
      this.mMetrics.physicalPaddingTop = paramRect.top;
      this.mMetrics.physicalPaddingRight = paramRect.right;
      this.mMetrics.physicalPaddingBottom = 0;
      this.mMetrics.physicalPaddingLeft = paramRect.left;
      this.mMetrics.physicalViewInsetTop = 0;
      this.mMetrics.physicalViewInsetRight = 0;
      this.mMetrics.physicalViewInsetBottom = paramRect.bottom;
      this.mMetrics.physicalViewInsetLeft = 0;
      updateViewportMetrics();
      return true;
    }
    return super.fitSystemWindows(paramRect);
  }
  
  public AccessibilityNodeProvider getAccessibilityNodeProvider()
  {
    if ((this.mAccessibilityNodeProvider != null) && (this.mAccessibilityNodeProvider.isAccessibilityEnabled())) {
      return this.mAccessibilityNodeProvider;
    }
    return null;
  }
  
  public Bitmap getBitmap()
  {
    assertAttached();
    return this.mNativeView.getFlutterJNI().getBitmap();
  }
  
  @NonNull
  public DartExecutor getDartExecutor()
  {
    return this.dartExecutor;
  }
  
  float getDevicePixelRatio()
  {
    return this.mMetrics.devicePixelRatio;
  }
  
  public FlutterNativeView getFlutterNativeView()
  {
    return this.mNativeView;
  }
  
  public String getLookupKeyForAsset(String paramString)
  {
    return FlutterMain.getLookupKeyForAsset(paramString);
  }
  
  public String getLookupKeyForAsset(String paramString1, String paramString2)
  {
    return FlutterMain.getLookupKeyForAsset(paramString1, paramString2);
  }
  
  public FlutterPluginRegistry getPluginRegistry()
  {
    return this.mNativeView.getPluginRegistry();
  }
  
  public boolean hasRenderedFirstFrame()
  {
    return this.didRenderFirstFrame;
  }
  
  @SuppressLint({"InlinedApi", "NewApi"})
  @TargetApi(20)
  @RequiresApi(20)
  public final WindowInsets onApplyWindowInsets(WindowInsets paramWindowInsets)
  {
    int i = 1;
    int j;
    label22:
    Object localObject;
    if ((getWindowSystemUiVisibility() & 0x4) != 0)
    {
      j = 1;
      if ((getWindowSystemUiVisibility() & 0x2) == 0) {
        break label246;
      }
      localObject = FlutterView.ZeroSides.NONE;
      if (i != 0) {
        localObject = calculateShouldZeroSides();
      }
      FlutterView.ViewportMetrics localViewportMetrics = this.mMetrics;
      if (j == 0) {
        break label251;
      }
      j = 0;
      label49:
      localViewportMetrics.physicalPaddingTop = j;
      localViewportMetrics = this.mMetrics;
      if ((localObject != FlutterView.ZeroSides.RIGHT) && (localObject != FlutterView.ZeroSides.BOTH)) {
        break label259;
      }
      j = 0;
      label79:
      localViewportMetrics.physicalPaddingRight = j;
      this.mMetrics.physicalPaddingBottom = 0;
      localViewportMetrics = this.mMetrics;
      if ((localObject != FlutterView.ZeroSides.LEFT) && (localObject != FlutterView.ZeroSides.BOTH)) {
        break label267;
      }
      j = 0;
      label117:
      localViewportMetrics.physicalPaddingLeft = j;
      this.mMetrics.physicalViewInsetTop = 0;
      this.mMetrics.physicalViewInsetRight = 0;
      localObject = this.mMetrics;
      if (i == 0) {
        break label275;
      }
    }
    label259:
    label267:
    label275:
    for (i = calculateBottomKeyboardInset(paramWindowInsets);; i = paramWindowInsets.getSystemWindowInsetBottom())
    {
      ((FlutterView.ViewportMetrics)localObject).physicalViewInsetBottom = i;
      this.mMetrics.physicalViewInsetLeft = 0;
      if (Build.VERSION.SDK_INT >= 29)
      {
        localObject = paramWindowInsets.getSystemGestureInsets();
        this.mMetrics.systemGestureInsetTop = ((Insets)localObject).top;
        this.mMetrics.systemGestureInsetRight = ((Insets)localObject).right;
        this.mMetrics.systemGestureInsetBottom = ((Insets)localObject).bottom;
        this.mMetrics.systemGestureInsetLeft = ((Insets)localObject).left;
      }
      updateViewportMetrics();
      return super.onApplyWindowInsets(paramWindowInsets);
      j = 0;
      break;
      label246:
      i = 0;
      break label22;
      label251:
      j = paramWindowInsets.getSystemWindowInsetTop();
      break label49;
      j = paramWindowInsets.getSystemWindowInsetRight();
      break label79;
      j = paramWindowInsets.getSystemWindowInsetLeft();
      break label117;
    }
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    PlatformViewsController localPlatformViewsController = getPluginRegistry().getPlatformViewsController();
    this.mAccessibilityNodeProvider = new AccessibilityBridge(this, new AccessibilityChannel(this.dartExecutor, getFlutterNativeView().getFlutterJNI()), (AccessibilityManager)getContext().getSystemService("accessibility"), getContext().getContentResolver(), localPlatformViewsController);
    this.mAccessibilityNodeProvider.setOnAccessibilityChangeListener(this.onAccessibilityChangeListener);
    resetWillNotDraw(this.mAccessibilityNodeProvider.isAccessibilityEnabled(), this.mAccessibilityNodeProvider.isTouchExplorationEnabled());
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    sendLocalesToDart(paramConfiguration);
    sendUserPlatformSettingsToDart();
  }
  
  public InputConnection onCreateInputConnection(EditorInfo paramEditorInfo)
  {
    return this.mTextInputPlugin.createInputConnection(this, paramEditorInfo);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.mAccessibilityNodeProvider.release();
    this.mAccessibilityNodeProvider = null;
  }
  
  public void onFirstFrame()
  {
    this.didRenderFirstFrame = true;
    Iterator localIterator = new ArrayList(this.mFirstFrameListeners).iterator();
    while (localIterator.hasNext()) {
      ((FlutterView.FirstFrameListener)localIterator.next()).onFirstFrame();
    }
  }
  
  public boolean onGenericMotionEvent(MotionEvent paramMotionEvent)
  {
    if ((isAttached()) && (this.androidTouchProcessor.onGenericMotionEvent(paramMotionEvent))) {}
    for (int i = 1; i != 0; i = 0) {
      return true;
    }
    return super.onGenericMotionEvent(paramMotionEvent);
  }
  
  public boolean onHoverEvent(MotionEvent paramMotionEvent)
  {
    if (!isAttached()) {
      return super.onHoverEvent(paramMotionEvent);
    }
    return this.mAccessibilityNodeProvider.onAccessibilityHoverEvent(paramMotionEvent);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (!isAttached()) {
      return super.onKeyDown(paramInt, paramKeyEvent);
    }
    this.androidKeyProcessor.onKeyDown(paramKeyEvent);
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    if (!isAttached()) {
      return super.onKeyUp(paramInt, paramKeyEvent);
    }
    this.androidKeyProcessor.onKeyUp(paramKeyEvent);
    return super.onKeyUp(paramInt, paramKeyEvent);
  }
  
  public void onMemoryPressure()
  {
    this.systemChannel.sendMemoryPressureWarning();
  }
  
  public void onPause()
  {
    this.lifecycleChannel.appIsInactive();
  }
  
  public void onPostResume()
  {
    Iterator localIterator = this.mActivityLifecycleListeners.iterator();
    while (localIterator.hasNext()) {
      ((ActivityLifecycleListener)localIterator.next()).onPostResume();
    }
    this.lifecycleChannel.appIsResumed();
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.mMetrics.physicalWidth = paramInt1;
    this.mMetrics.physicalHeight = paramInt2;
    updateViewportMetrics();
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void onStart()
  {
    this.lifecycleChannel.appIsInactive();
  }
  
  public void onStop()
  {
    this.lifecycleChannel.appIsPaused();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!isAttached()) {
      return super.onTouchEvent(paramMotionEvent);
    }
    if (Build.VERSION.SDK_INT >= 21) {
      requestUnbufferedDispatch(paramMotionEvent);
    }
    return this.androidTouchProcessor.onTouchEvent(paramMotionEvent);
  }
  
  public void popRoute()
  {
    this.navigationChannel.popRoute();
  }
  
  public void pushRoute(String paramString)
  {
    this.navigationChannel.pushRoute(paramString);
  }
  
  public void removeFirstFrameListener(FlutterView.FirstFrameListener paramFirstFrameListener)
  {
    this.mFirstFrameListeners.remove(paramFirstFrameListener);
  }
  
  void resetAccessibilityTree()
  {
    if (this.mAccessibilityNodeProvider != null) {
      this.mAccessibilityNodeProvider.reset();
    }
  }
  
  public void runFromBundle(FlutterRunArguments paramFlutterRunArguments)
  {
    assertAttached();
    preRun();
    this.mNativeView.runFromBundle(paramFlutterRunArguments);
    postRun();
  }
  
  @UiThread
  public void send(String paramString, ByteBuffer paramByteBuffer)
  {
    send(paramString, paramByteBuffer, null);
  }
  
  @UiThread
  public void send(String paramString, ByteBuffer paramByteBuffer, BinaryMessenger.BinaryReply paramBinaryReply)
  {
    if (!isAttached())
    {
      paramByteBuffer = new StringBuilder();
      paramByteBuffer.append("FlutterView.send called on a detached view, channel=");
      paramByteBuffer.append(paramString);
      Log.d("FlutterView", paramByteBuffer.toString());
      return;
    }
    this.mNativeView.send(paramString, paramByteBuffer, paramBinaryReply);
  }
  
  public void setInitialRoute(String paramString)
  {
    this.navigationChannel.setInitialRoute(paramString);
  }
  
  @UiThread
  public void setMessageHandler(String paramString, BinaryMessenger.BinaryMessageHandler paramBinaryMessageHandler)
  {
    this.mNativeView.setMessageHandler(paramString, paramBinaryMessageHandler);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     io.flutter.view.FlutterView
 * JD-Core Version:    0.7.0.1
 */