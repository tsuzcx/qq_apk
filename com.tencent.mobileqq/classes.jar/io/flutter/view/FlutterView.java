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
import android.text.format.DateFormat;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.SparseArray;
import android.view.Display;
import android.view.DisplayCutout;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.PointerIcon;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewStructure;
import android.view.WindowInsets;
import android.view.WindowInsets.Type;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeProvider;
import android.view.autofill.AutofillValue;
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
import io.flutter.embedding.engine.systemchannels.MouseCursorChannel;
import io.flutter.embedding.engine.systemchannels.NavigationChannel;
import io.flutter.embedding.engine.systemchannels.PlatformChannel;
import io.flutter.embedding.engine.systemchannels.SettingsChannel;
import io.flutter.embedding.engine.systemchannels.SettingsChannel.MessageBuilder;
import io.flutter.embedding.engine.systemchannels.SettingsChannel.PlatformBrightness;
import io.flutter.embedding.engine.systemchannels.SystemChannel;
import io.flutter.embedding.engine.systemchannels.TextInputChannel;
import io.flutter.plugin.common.ActivityLifecycleListener;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.BinaryMessenger.BinaryMessageHandler;
import io.flutter.plugin.common.BinaryMessenger.BinaryReply;
import io.flutter.plugin.editing.TextInputPlugin;
import io.flutter.plugin.localization.LocalizationPlugin;
import io.flutter.plugin.mouse.MouseCursorPlugin;
import io.flutter.plugin.mouse.MouseCursorPlugin.MouseCursorViewDelegate;
import io.flutter.plugin.platform.PlatformPlugin;
import io.flutter.plugin.platform.PlatformViewsController;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class FlutterView
  extends SurfaceView
  implements BinaryMessenger, MouseCursorPlugin.MouseCursorViewDelegate, TextureRegistry
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
  private final LocalizationPlugin mLocalizationPlugin;
  private final FlutterView.ViewportMetrics mMetrics;
  private final MouseCursorPlugin mMouseCursorPlugin;
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
    Activity localActivity = getActivity(getContext());
    if (localActivity != null)
    {
      paramAttributeSet = paramFlutterNativeView;
      if (paramFlutterNativeView == null) {
        paramAttributeSet = new FlutterNativeView(localActivity.getApplicationContext());
      }
      this.mNativeView = paramAttributeSet;
      this.dartExecutor = this.mNativeView.getDartExecutor();
      this.flutterRenderer = new FlutterRenderer(this.mNativeView.getFlutterJNI());
      this.mIsSoftwareRenderingEnabled = this.mNativeView.getFlutterJNI().getIsSoftwareRenderingEnabled();
      this.mMetrics = new FlutterView.ViewportMetrics();
      this.mMetrics.devicePixelRatio = paramContext.getResources().getDisplayMetrics().density;
      setFocusable(true);
      setFocusableInTouchMode(true);
      this.mNativeView.attachViewAndActivity(this, localActivity);
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
      this.navigationChannel.setMethodCallHandler(new FlutterView.3(this));
      addActivityLifecycleListener(new FlutterView.4(this, new PlatformPlugin(localActivity, this.platformChannel)));
      this.mImm = ((InputMethodManager)getContext().getSystemService("input_method"));
      paramFlutterNativeView = this.mNativeView.getPluginRegistry().getPlatformViewsController();
      this.mTextInputPlugin = new TextInputPlugin(this, new TextInputChannel(this.dartExecutor), paramFlutterNativeView);
      if (Build.VERSION.SDK_INT >= 24) {
        paramAttributeSet = new MouseCursorPlugin(this, new MouseCursorChannel(this.dartExecutor));
      } else {
        paramAttributeSet = null;
      }
      this.mMouseCursorPlugin = paramAttributeSet;
      this.mLocalizationPlugin = new LocalizationPlugin(paramContext, this.localizationChannel);
      this.androidKeyProcessor = new AndroidKeyProcessor(this, this.keyEventChannel, this.mTextInputPlugin);
      this.androidTouchProcessor = new AndroidTouchProcessor(this.flutterRenderer, false);
      paramFlutterNativeView.attachToFlutterRenderer(this.flutterRenderer);
      this.mNativeView.getPluginRegistry().getPlatformViewsController().attachTextInputPlugin(this.mTextInputPlugin);
      this.mNativeView.getFlutterJNI().setLocalizationPlugin(this.mLocalizationPlugin);
      this.mLocalizationPlugin.sendLocalesToFlutter(getResources().getConfiguration());
      sendUserPlatformSettingsToDart();
      return;
    }
    throw new IllegalArgumentException("Bad context");
  }
  
  private FlutterView.ZeroSides calculateShouldZeroSides()
  {
    Context localContext = getContext();
    int i = localContext.getResources().getConfiguration().orientation;
    int j = ((WindowManager)localContext.getSystemService("window")).getDefaultDisplay().getRotation();
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
  
  @TargetApi(20)
  @RequiresApi(20)
  private int guessBottomKeyboardInset(WindowInsets paramWindowInsets)
  {
    int i = getRootView().getHeight();
    double d1 = paramWindowInsets.getSystemWindowInsetBottom();
    double d2 = i;
    Double.isNaN(d2);
    Double.isNaN(d2);
    if (d1 < d2 * 0.18D) {
      return 0;
    }
    return paramWindowInsets.getSystemWindowInsetBottom();
  }
  
  private boolean isAttached()
  {
    FlutterNativeView localFlutterNativeView = this.mNativeView;
    return (localFlutterNativeView != null) && (localFlutterNativeView.isAttached());
  }
  
  private void postRun() {}
  
  private void preRun()
  {
    resetAccessibilityTree();
  }
  
  private void releaseAccessibilityNodeProvider()
  {
    AccessibilityBridge localAccessibilityBridge = this.mAccessibilityNodeProvider;
    if (localAccessibilityBridge != null)
    {
      localAccessibilityBridge.release();
      this.mAccessibilityNodeProvider = null;
    }
  }
  
  private void resetWillNotDraw(boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool3 = this.mIsSoftwareRenderingEnabled;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (!bool3)
    {
      bool1 = bool2;
      if (!paramBoolean1)
      {
        bool1 = bool2;
        if (!paramBoolean2) {
          bool1 = true;
        }
      }
    }
    setWillNotDraw(bool1);
  }
  
  private void sendUserPlatformSettingsToDart()
  {
    int i;
    if ((getResources().getConfiguration().uiMode & 0x30) == 32) {
      i = 1;
    } else {
      i = 0;
    }
    SettingsChannel.PlatformBrightness localPlatformBrightness;
    if (i != 0) {
      localPlatformBrightness = SettingsChannel.PlatformBrightness.dark;
    } else {
      localPlatformBrightness = SettingsChannel.PlatformBrightness.light;
    }
    this.settingsChannel.startMessage().setTextScaleFactor(getResources().getConfiguration().fontScale).setUse24HourFormat(DateFormat.is24HourFormat(getContext())).setPlatformBrightness(localPlatformBrightness).send();
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
  
  public void autofill(SparseArray<AutofillValue> paramSparseArray)
  {
    this.mTextInputPlugin.autofill(paramSparseArray);
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
    releaseAccessibilityNodeProvider();
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
    Log.w("FlutterView", "FlutterView in the v1 embedding is always a SurfaceView and will cover accessibility highlights when transparent. Consider migrating to the v2 Android embedding. https://github.com/flutter/flutter/wiki/Upgrading-pre-1.12-Android-projects");
    setZOrderOnTop(true);
    getHolder().setFormat(-2);
  }
  
  protected boolean fitSystemWindows(Rect paramRect)
  {
    if (Build.VERSION.SDK_INT <= 19)
    {
      this.mMetrics.physicalPaddingTop = paramRect.top;
      this.mMetrics.physicalPaddingRight = paramRect.right;
      FlutterView.ViewportMetrics localViewportMetrics = this.mMetrics;
      localViewportMetrics.physicalPaddingBottom = 0;
      localViewportMetrics.physicalPaddingLeft = paramRect.left;
      localViewportMetrics = this.mMetrics;
      localViewportMetrics.physicalViewInsetTop = 0;
      localViewportMetrics.physicalViewInsetRight = 0;
      localViewportMetrics.physicalViewInsetBottom = paramRect.bottom;
      this.mMetrics.physicalViewInsetLeft = 0;
      updateViewportMetrics();
      return true;
    }
    return super.fitSystemWindows(paramRect);
  }
  
  public AccessibilityNodeProvider getAccessibilityNodeProvider()
  {
    AccessibilityBridge localAccessibilityBridge = this.mAccessibilityNodeProvider;
    if ((localAccessibilityBridge != null) && (localAccessibilityBridge.isAccessibilityEnabled())) {
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
  
  @TargetApi(24)
  @NonNull
  @RequiresApi(24)
  public PointerIcon getSystemPointerIcon(int paramInt)
  {
    return PointerIcon.getSystemIcon(getContext(), paramInt);
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
    Object localObject1;
    if (Build.VERSION.SDK_INT == 29)
    {
      localObject1 = paramWindowInsets.getSystemGestureInsets();
      this.mMetrics.systemGestureInsetTop = ((Insets)localObject1).top;
      this.mMetrics.systemGestureInsetRight = ((Insets)localObject1).right;
      this.mMetrics.systemGestureInsetBottom = ((Insets)localObject1).bottom;
      this.mMetrics.systemGestureInsetLeft = ((Insets)localObject1).left;
    }
    int k = getWindowSystemUiVisibility();
    int j = 1;
    int i = 0;
    if ((k & 0x4) == 0) {
      k = 1;
    } else {
      k = 0;
    }
    if ((getWindowSystemUiVisibility() & 0x2) != 0) {
      j = 0;
    }
    Object localObject2;
    if (Build.VERSION.SDK_INT >= 30)
    {
      if (j != 0) {
        i = 0x0 | WindowInsets.Type.navigationBars();
      }
      j = i;
      if (k != 0) {
        j = i | WindowInsets.Type.statusBars();
      }
      localObject1 = paramWindowInsets.getInsets(j);
      this.mMetrics.physicalPaddingTop = ((Insets)localObject1).top;
      this.mMetrics.physicalPaddingRight = ((Insets)localObject1).right;
      this.mMetrics.physicalPaddingBottom = ((Insets)localObject1).bottom;
      this.mMetrics.physicalPaddingLeft = ((Insets)localObject1).left;
      localObject1 = paramWindowInsets.getInsets(WindowInsets.Type.ime());
      this.mMetrics.physicalViewInsetTop = ((Insets)localObject1).top;
      this.mMetrics.physicalViewInsetRight = ((Insets)localObject1).right;
      this.mMetrics.physicalViewInsetBottom = ((Insets)localObject1).bottom;
      this.mMetrics.physicalViewInsetLeft = ((Insets)localObject1).left;
      localObject1 = paramWindowInsets.getInsets(WindowInsets.Type.systemGestures());
      this.mMetrics.systemGestureInsetTop = ((Insets)localObject1).top;
      this.mMetrics.systemGestureInsetRight = ((Insets)localObject1).right;
      this.mMetrics.systemGestureInsetBottom = ((Insets)localObject1).bottom;
      this.mMetrics.systemGestureInsetLeft = ((Insets)localObject1).left;
      localObject1 = paramWindowInsets.getDisplayCutout();
      if (localObject1 != null)
      {
        localObject2 = ((DisplayCutout)localObject1).getWaterfallInsets();
        FlutterView.ViewportMetrics localViewportMetrics = this.mMetrics;
        localViewportMetrics.physicalPaddingTop = Math.max(Math.max(localViewportMetrics.physicalPaddingTop, ((Insets)localObject2).top), ((DisplayCutout)localObject1).getSafeInsetTop());
        localViewportMetrics = this.mMetrics;
        localViewportMetrics.physicalPaddingRight = Math.max(Math.max(localViewportMetrics.physicalPaddingRight, ((Insets)localObject2).right), ((DisplayCutout)localObject1).getSafeInsetRight());
        localViewportMetrics = this.mMetrics;
        localViewportMetrics.physicalPaddingBottom = Math.max(Math.max(localViewportMetrics.physicalPaddingBottom, ((Insets)localObject2).bottom), ((DisplayCutout)localObject1).getSafeInsetBottom());
        localViewportMetrics = this.mMetrics;
        localViewportMetrics.physicalPaddingLeft = Math.max(Math.max(localViewportMetrics.physicalPaddingLeft, ((Insets)localObject2).left), ((DisplayCutout)localObject1).getSafeInsetLeft());
      }
    }
    else
    {
      localObject1 = FlutterView.ZeroSides.NONE;
      if (j == 0) {
        localObject1 = calculateShouldZeroSides();
      }
      localObject2 = this.mMetrics;
      if (k != 0) {
        i = paramWindowInsets.getSystemWindowInsetTop();
      } else {
        i = 0;
      }
      ((FlutterView.ViewportMetrics)localObject2).physicalPaddingTop = i;
      localObject2 = this.mMetrics;
      if ((localObject1 != FlutterView.ZeroSides.RIGHT) && (localObject1 != FlutterView.ZeroSides.BOTH)) {
        i = paramWindowInsets.getSystemWindowInsetRight();
      } else {
        i = 0;
      }
      ((FlutterView.ViewportMetrics)localObject2).physicalPaddingRight = i;
      localObject2 = this.mMetrics;
      ((FlutterView.ViewportMetrics)localObject2).physicalPaddingBottom = 0;
      if ((localObject1 != FlutterView.ZeroSides.LEFT) && (localObject1 != FlutterView.ZeroSides.BOTH)) {
        i = paramWindowInsets.getSystemWindowInsetLeft();
      } else {
        i = 0;
      }
      ((FlutterView.ViewportMetrics)localObject2).physicalPaddingLeft = i;
      localObject1 = this.mMetrics;
      ((FlutterView.ViewportMetrics)localObject1).physicalViewInsetTop = 0;
      ((FlutterView.ViewportMetrics)localObject1).physicalViewInsetRight = 0;
      if (j != 0) {
        i = paramWindowInsets.getSystemWindowInsetBottom();
      } else {
        i = guessBottomKeyboardInset(paramWindowInsets);
      }
      ((FlutterView.ViewportMetrics)localObject1).physicalViewInsetBottom = i;
      this.mMetrics.physicalViewInsetLeft = 0;
    }
    updateViewportMetrics();
    return super.onApplyWindowInsets(paramWindowInsets);
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
    this.mLocalizationPlugin.sendLocalesToFlutter(paramConfiguration);
    sendUserPlatformSettingsToDart();
  }
  
  public InputConnection onCreateInputConnection(EditorInfo paramEditorInfo)
  {
    return this.mTextInputPlugin.createInputConnection(this, paramEditorInfo);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    releaseAccessibilityNodeProvider();
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
    int i;
    if ((isAttached()) && (this.androidTouchProcessor.onGenericMotionEvent(paramMotionEvent))) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
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
    return (this.androidKeyProcessor.onKeyDown(paramKeyEvent)) || (super.onKeyDown(paramInt, paramKeyEvent));
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    if (!isAttached()) {
      return super.onKeyUp(paramInt, paramKeyEvent);
    }
    return (this.androidKeyProcessor.onKeyUp(paramKeyEvent)) || (super.onKeyUp(paramInt, paramKeyEvent));
  }
  
  public void onMemoryPressure()
  {
    this.mNativeView.getFlutterJNI().notifyLowMemoryWarning();
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
  
  public void onProvideAutofillVirtualStructure(ViewStructure paramViewStructure, int paramInt)
  {
    super.onProvideAutofillVirtualStructure(paramViewStructure, paramInt);
    this.mTextInputPlugin.onProvideAutofillVirtualStructure(paramViewStructure, paramInt);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    FlutterView.ViewportMetrics localViewportMetrics = this.mMetrics;
    localViewportMetrics.physicalWidth = paramInt1;
    localViewportMetrics.physicalHeight = paramInt2;
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
    AccessibilityBridge localAccessibilityBridge = this.mAccessibilityNodeProvider;
    if (localAccessibilityBridge != null) {
      localAccessibilityBridge.reset();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     io.flutter.view.FlutterView
 * JD-Core Version:    0.7.0.1
 */