package io.flutter.embedding.android;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Insets;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.text.format.DateFormat;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.Display;
import android.view.DisplayCutout;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.PointerIcon;
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
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import io.flutter.Log;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.embedding.engine.renderer.FlutterRenderer;
import io.flutter.embedding.engine.renderer.FlutterRenderer.ViewportMetrics;
import io.flutter.embedding.engine.renderer.FlutterUiDisplayListener;
import io.flutter.embedding.engine.renderer.RenderSurface;
import io.flutter.embedding.engine.systemchannels.NavigationChannel;
import io.flutter.embedding.engine.systemchannels.SettingsChannel;
import io.flutter.embedding.engine.systemchannels.SettingsChannel.MessageBuilder;
import io.flutter.embedding.engine.systemchannels.SettingsChannel.PlatformBrightness;
import io.flutter.plugin.editing.TextInputPlugin;
import io.flutter.plugin.localization.LocalizationPlugin;
import io.flutter.plugin.mouse.MouseCursorPlugin;
import io.flutter.plugin.mouse.MouseCursorPlugin.MouseCursorViewDelegate;
import io.flutter.plugin.platform.PlatformViewsController;
import io.flutter.view.AccessibilityBridge;
import io.flutter.view.AccessibilityBridge.OnAccessibilityChangeListener;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class FlutterView
  extends FrameLayout
  implements MouseCursorPlugin.MouseCursorViewDelegate
{
  private static final String TAG = "FlutterView";
  @Nullable
  private AccessibilityBridge accessibilityBridge;
  @Nullable
  private AndroidKeyProcessor androidKeyProcessor;
  @Nullable
  private AndroidTouchProcessor androidTouchProcessor;
  @Nullable
  private FlutterEngine flutterEngine;
  @NonNull
  private final Set<FlutterView.FlutterEngineAttachmentListener> flutterEngineAttachmentListeners = new HashSet();
  @Nullable
  private FlutterImageView flutterImageView;
  @Nullable
  private FlutterSurfaceView flutterSurfaceView;
  @Nullable
  private FlutterTextureView flutterTextureView;
  private final FlutterUiDisplayListener flutterUiDisplayListener = new FlutterView.2(this);
  private final Set<FlutterUiDisplayListener> flutterUiDisplayListeners = new HashSet();
  private boolean isFlutterUiDisplayed;
  @Nullable
  private LocalizationPlugin localizationPlugin;
  @Nullable
  private MouseCursorPlugin mouseCursorPlugin;
  private final AccessibilityBridge.OnAccessibilityChangeListener onAccessibilityChangeListener = new FlutterView.1(this);
  @Nullable
  private RenderSurface previousRenderSurface;
  @Nullable
  private RenderSurface renderSurface;
  @Nullable
  private TextInputPlugin textInputPlugin;
  private final FlutterRenderer.ViewportMetrics viewportMetrics = new FlutterRenderer.ViewportMetrics();
  
  public FlutterView(@NonNull Context paramContext)
  {
    this(paramContext, null, new FlutterSurfaceView(paramContext));
  }
  
  public FlutterView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, new FlutterSurfaceView(paramContext));
  }
  
  @TargetApi(19)
  private FlutterView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, @NonNull FlutterImageView paramFlutterImageView)
  {
    super(paramContext, paramAttributeSet);
    this.flutterImageView = paramFlutterImageView;
    this.renderSurface = paramFlutterImageView;
    init();
  }
  
  private FlutterView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, @NonNull FlutterSurfaceView paramFlutterSurfaceView)
  {
    super(paramContext, paramAttributeSet);
    this.flutterSurfaceView = paramFlutterSurfaceView;
    this.renderSurface = paramFlutterSurfaceView;
    init();
  }
  
  private FlutterView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, @NonNull FlutterTextureView paramFlutterTextureView)
  {
    super(paramContext, paramAttributeSet);
    this.flutterTextureView = paramFlutterTextureView;
    this.renderSurface = paramFlutterTextureView;
    init();
  }
  
  @TargetApi(19)
  public FlutterView(@NonNull Context paramContext, @NonNull FlutterImageView paramFlutterImageView)
  {
    this(paramContext, null, paramFlutterImageView);
  }
  
  public FlutterView(@NonNull Context paramContext, @NonNull FlutterSurfaceView paramFlutterSurfaceView)
  {
    this(paramContext, null, paramFlutterSurfaceView);
  }
  
  public FlutterView(@NonNull Context paramContext, @NonNull FlutterTextureView paramFlutterTextureView)
  {
    this(paramContext, null, paramFlutterTextureView);
  }
  
  @Deprecated
  public FlutterView(@NonNull Context paramContext, @NonNull FlutterView.RenderMode paramRenderMode)
  {
    super(paramContext, null);
    if (paramRenderMode == FlutterView.RenderMode.surface) {
      this.flutterSurfaceView = new FlutterSurfaceView(paramContext);
    }
    for (paramContext = this.flutterSurfaceView;; paramContext = this.flutterTextureView)
    {
      this.renderSurface = paramContext;
      break;
      if (paramRenderMode != FlutterView.RenderMode.texture) {
        break label127;
      }
      this.flutterTextureView = new FlutterTextureView(paramContext);
    }
    init();
    return;
    label127:
    paramContext = new IllegalArgumentException(String.format("RenderMode not supported with this constructor: %s", new Object[] { paramRenderMode }));
    for (;;)
    {
      throw paramContext;
    }
  }
  
  @Deprecated
  public FlutterView(@NonNull Context paramContext, @NonNull FlutterView.RenderMode paramRenderMode, @NonNull FlutterView.TransparencyMode paramTransparencyMode)
  {
    super(paramContext, null);
    FlutterView.RenderMode localRenderMode = FlutterView.RenderMode.surface;
    boolean bool = true;
    if (paramRenderMode == localRenderMode)
    {
      if (paramTransparencyMode != FlutterView.TransparencyMode.transparent) {
        bool = false;
      }
      this.flutterSurfaceView = new FlutterSurfaceView(paramContext, bool);
      paramContext = this.flutterSurfaceView;
    }
    else
    {
      if (paramRenderMode != FlutterView.RenderMode.texture) {
        break label146;
      }
      this.flutterTextureView = new FlutterTextureView(paramContext);
      paramContext = this.flutterTextureView;
    }
    this.renderSurface = paramContext;
    init();
    return;
    label146:
    throw new IllegalArgumentException(String.format("RenderMode not supported with this constructor: %s", new Object[] { paramRenderMode }));
  }
  
  @Deprecated
  public FlutterView(@NonNull Context paramContext, @NonNull FlutterView.TransparencyMode paramTransparencyMode)
  {
    this(paramContext, null, new FlutterSurfaceView(paramContext, bool));
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
  
  private void init()
  {
    Log.v("FlutterView", "Initializing FlutterView");
    Object localObject;
    if (this.flutterSurfaceView != null)
    {
      Log.v("FlutterView", "Internally using a FlutterSurfaceView.");
      localObject = this.flutterSurfaceView;
    }
    for (;;)
    {
      addView((View)localObject);
      break;
      if (this.flutterTextureView != null)
      {
        Log.v("FlutterView", "Internally using a FlutterTextureView.");
        localObject = this.flutterTextureView;
      }
      else
      {
        Log.v("FlutterView", "Internally using a FlutterImageView.");
        localObject = this.flutterImageView;
      }
    }
    setFocusable(true);
    setFocusableInTouchMode(true);
    if (Build.VERSION.SDK_INT >= 26) {
      setImportantForAutofill(4);
    }
  }
  
  private void resetWillNotDraw(boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool3 = this.flutterEngine.getRenderer().isSoftwareRenderingEnabled();
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
  
  private void sendViewportMetricsToFlutter()
  {
    if (!isAttachedToFlutterEngine())
    {
      Log.w("FlutterView", "Tried to send viewport metrics from Android to Flutter but this FlutterView was not attached to a FlutterEngine.");
      return;
    }
    this.viewportMetrics.devicePixelRatio = getResources().getDisplayMetrics().density;
    this.flutterEngine.getRenderer().setViewportMetrics(this.viewportMetrics);
  }
  
  public boolean acquireLatestImageViewFrame()
  {
    FlutterImageView localFlutterImageView = this.flutterImageView;
    if (localFlutterImageView != null) {
      return localFlutterImageView.acquireLatestImage();
    }
    return false;
  }
  
  @VisibleForTesting
  public void addFlutterEngineAttachmentListener(@NonNull FlutterView.FlutterEngineAttachmentListener paramFlutterEngineAttachmentListener)
  {
    this.flutterEngineAttachmentListeners.add(paramFlutterEngineAttachmentListener);
  }
  
  public void addOnFirstFrameRenderedListener(@NonNull FlutterUiDisplayListener paramFlutterUiDisplayListener)
  {
    this.flutterUiDisplayListeners.add(paramFlutterUiDisplayListener);
  }
  
  public void attachOverlaySurfaceToRender(FlutterImageView paramFlutterImageView)
  {
    FlutterEngine localFlutterEngine = this.flutterEngine;
    if (localFlutterEngine != null) {
      paramFlutterImageView.attachToRenderer(localFlutterEngine.getRenderer());
    }
  }
  
  public void attachToFlutterEngine(@NonNull FlutterEngine paramFlutterEngine)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Attaching to a FlutterEngine: ");
    ((StringBuilder)localObject).append(paramFlutterEngine);
    Log.v("FlutterView", ((StringBuilder)localObject).toString());
    if (isAttachedToFlutterEngine())
    {
      if (paramFlutterEngine == this.flutterEngine)
      {
        Log.v("FlutterView", "Already attached to this engine. Doing nothing.");
        return;
      }
      Log.v("FlutterView", "Currently attached to a different engine. Detaching and then attaching to new engine.");
      detachFromFlutterEngine();
    }
    paramFlutterEngine.getNavigationChannel().setMethodCallHandler(null);
    this.flutterEngine = paramFlutterEngine;
    paramFlutterEngine.getNavigationChannel().setMethodCallHandler(new FlutterView.3(this));
    localObject = this.flutterEngine.getRenderer();
    this.isFlutterUiDisplayed = ((FlutterRenderer)localObject).isDisplayingFlutterUi();
    this.renderSurface.attachToRenderer((FlutterRenderer)localObject);
    ((FlutterRenderer)localObject).addIsDisplayingFlutterUiListener(this.flutterUiDisplayListener);
    if (Build.VERSION.SDK_INT >= 24) {
      this.mouseCursorPlugin = new MouseCursorPlugin(this, this.flutterEngine.getMouseCursorChannel());
    }
    this.textInputPlugin = new TextInputPlugin(this, this.flutterEngine.getTextInputChannel(), this.flutterEngine.getPlatformViewsController());
    this.localizationPlugin = this.flutterEngine.getLocalizationPlugin();
    this.androidKeyProcessor = new AndroidKeyProcessor(this, this.flutterEngine.getKeyEventChannel(), this.textInputPlugin);
    this.androidTouchProcessor = new AndroidTouchProcessor(this.flutterEngine.getRenderer(), false);
    this.accessibilityBridge = new AccessibilityBridge(this, paramFlutterEngine.getAccessibilityChannel(), (AccessibilityManager)getContext().getSystemService("accessibility"), getContext().getContentResolver(), this.flutterEngine.getPlatformViewsController());
    this.accessibilityBridge.setOnAccessibilityChangeListener(this.onAccessibilityChangeListener);
    resetWillNotDraw(this.accessibilityBridge.isAccessibilityEnabled(), this.accessibilityBridge.isTouchExplorationEnabled());
    this.flutterEngine.getPlatformViewsController().attachAccessibilityBridge(this.accessibilityBridge);
    this.flutterEngine.getPlatformViewsController().attachToFlutterRenderer(this.flutterEngine.getRenderer());
    this.textInputPlugin.getInputMethodManager().restartInput(this);
    sendUserSettingsToFlutter();
    this.localizationPlugin.sendLocalesToFlutter(getResources().getConfiguration());
    sendViewportMetricsToFlutter();
    paramFlutterEngine.getPlatformViewsController().attachToView(this);
    localObject = this.flutterEngineAttachmentListeners.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((FlutterView.FlutterEngineAttachmentListener)((Iterator)localObject).next()).onFlutterEngineAttachedToFlutterView(paramFlutterEngine);
    }
    if (this.isFlutterUiDisplayed) {
      this.flutterUiDisplayListener.onFlutterUiDisplayed();
    }
  }
  
  public void autofill(SparseArray<AutofillValue> paramSparseArray)
  {
    this.textInputPlugin.autofill(paramSparseArray);
  }
  
  public boolean checkInputConnectionProxy(View paramView)
  {
    FlutterEngine localFlutterEngine = this.flutterEngine;
    if (localFlutterEngine != null) {
      return localFlutterEngine.getPlatformViewsController().checkInputConnectionProxy(paramView);
    }
    return super.checkInputConnectionProxy(paramView);
  }
  
  public void convertToImageView()
  {
    this.renderSurface.pause();
    Object localObject = this.flutterImageView;
    if (localObject == null)
    {
      this.flutterImageView = createImageView();
      addView(this.flutterImageView);
    }
    else
    {
      ((FlutterImageView)localObject).resizeIfNeeded(getWidth(), getHeight());
    }
    this.previousRenderSurface = this.renderSurface;
    this.renderSurface = this.flutterImageView;
    localObject = this.flutterEngine;
    if (localObject != null) {
      this.renderSurface.attachToRenderer(((FlutterEngine)localObject).getRenderer());
    }
  }
  
  @NonNull
  @VisibleForTesting
  public FlutterImageView createImageView()
  {
    return new FlutterImageView(getContext(), getWidth(), getHeight(), FlutterImageView.SurfaceKind.background);
  }
  
  public void detachFromFlutterEngine()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Detaching from a FlutterEngine: ");
    ((StringBuilder)localObject).append(this.flutterEngine);
    Log.v("FlutterView", ((StringBuilder)localObject).toString());
    if (!isAttachedToFlutterEngine())
    {
      Log.v("FlutterView", "Not attached to an engine. Doing nothing.");
      return;
    }
    localObject = this.flutterEngineAttachmentListeners.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((FlutterView.FlutterEngineAttachmentListener)((Iterator)localObject).next()).onFlutterEngineDetachedFromFlutterView();
    }
    this.flutterEngine.getPlatformViewsController().detachFromView();
    this.flutterEngine.getPlatformViewsController().detachAccessibiltyBridge();
    this.accessibilityBridge.release();
    this.accessibilityBridge = null;
    this.textInputPlugin.getInputMethodManager().restartInput(this);
    this.textInputPlugin.destroy();
    this.androidKeyProcessor.destroy();
    localObject = this.mouseCursorPlugin;
    if (localObject != null) {
      ((MouseCursorPlugin)localObject).destroy();
    }
    localObject = this.flutterEngine.getRenderer();
    this.isFlutterUiDisplayed = false;
    ((FlutterRenderer)localObject).removeIsDisplayingFlutterUiListener(this.flutterUiDisplayListener);
    ((FlutterRenderer)localObject).stopRenderingToSurface();
    ((FlutterRenderer)localObject).setSemanticsEnabled(false);
    this.renderSurface.detachFromRenderer();
    this.flutterImageView = null;
    this.previousRenderSurface = null;
    this.flutterEngine = null;
  }
  
  protected boolean fitSystemWindows(@NonNull Rect paramRect)
  {
    if (Build.VERSION.SDK_INT <= 19)
    {
      this.viewportMetrics.paddingTop = paramRect.top;
      this.viewportMetrics.paddingRight = paramRect.right;
      FlutterRenderer.ViewportMetrics localViewportMetrics = this.viewportMetrics;
      localViewportMetrics.paddingBottom = 0;
      localViewportMetrics.paddingLeft = paramRect.left;
      localViewportMetrics = this.viewportMetrics;
      localViewportMetrics.viewInsetTop = 0;
      localViewportMetrics.viewInsetRight = 0;
      localViewportMetrics.viewInsetBottom = paramRect.bottom;
      this.viewportMetrics.viewInsetLeft = 0;
      paramRect = new StringBuilder();
      paramRect.append("Updating window insets (fitSystemWindows()):\nStatus bar insets: Top: ");
      paramRect.append(this.viewportMetrics.paddingTop);
      paramRect.append(", Left: ");
      paramRect.append(this.viewportMetrics.paddingLeft);
      paramRect.append(", Right: ");
      paramRect.append(this.viewportMetrics.paddingRight);
      paramRect.append("\nKeyboard insets: Bottom: ");
      paramRect.append(this.viewportMetrics.viewInsetBottom);
      paramRect.append(", Left: ");
      paramRect.append(this.viewportMetrics.viewInsetLeft);
      paramRect.append(", Right: ");
      paramRect.append(this.viewportMetrics.viewInsetRight);
      Log.v("FlutterView", paramRect.toString());
      sendViewportMetricsToFlutter();
      return true;
    }
    return super.fitSystemWindows(paramRect);
  }
  
  @Nullable
  public AccessibilityNodeProvider getAccessibilityNodeProvider()
  {
    AccessibilityBridge localAccessibilityBridge = this.accessibilityBridge;
    if ((localAccessibilityBridge != null) && (localAccessibilityBridge.isAccessibilityEnabled())) {
      return this.accessibilityBridge;
    }
    return null;
  }
  
  @Nullable
  @VisibleForTesting
  public FlutterEngine getAttachedFlutterEngine()
  {
    return this.flutterEngine;
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
    return this.isFlutterUiDisplayed;
  }
  
  @VisibleForTesting
  public boolean isAttachedToFlutterEngine()
  {
    FlutterEngine localFlutterEngine = this.flutterEngine;
    return (localFlutterEngine != null) && (localFlutterEngine.getRenderer() == this.renderSurface.getAttachedRenderer());
  }
  
  @SuppressLint({"InlinedApi", "NewApi"})
  @TargetApi(20)
  @NonNull
  @RequiresApi(20)
  public final WindowInsets onApplyWindowInsets(@NonNull WindowInsets paramWindowInsets)
  {
    WindowInsets localWindowInsets = super.onApplyWindowInsets(paramWindowInsets);
    Object localObject;
    if (Build.VERSION.SDK_INT == 29)
    {
      localObject = paramWindowInsets.getSystemGestureInsets();
      this.viewportMetrics.systemGestureInsetTop = ((Insets)localObject).top;
      this.viewportMetrics.systemGestureInsetRight = ((Insets)localObject).right;
      this.viewportMetrics.systemGestureInsetBottom = ((Insets)localObject).bottom;
      this.viewportMetrics.systemGestureInsetLeft = ((Insets)localObject).left;
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
    FlutterRenderer.ViewportMetrics localViewportMetrics;
    if (Build.VERSION.SDK_INT >= 30)
    {
      if (j != 0) {
        i = 0x0 | WindowInsets.Type.navigationBars();
      }
      j = i;
      if (k != 0) {
        j = i | WindowInsets.Type.statusBars();
      }
      localObject = paramWindowInsets.getInsets(j);
      this.viewportMetrics.paddingTop = ((Insets)localObject).top;
      this.viewportMetrics.paddingRight = ((Insets)localObject).right;
      this.viewportMetrics.paddingBottom = ((Insets)localObject).bottom;
      this.viewportMetrics.paddingLeft = ((Insets)localObject).left;
      localObject = paramWindowInsets.getInsets(WindowInsets.Type.ime());
      this.viewportMetrics.viewInsetTop = ((Insets)localObject).top;
      this.viewportMetrics.viewInsetRight = ((Insets)localObject).right;
      this.viewportMetrics.viewInsetBottom = ((Insets)localObject).bottom;
      this.viewportMetrics.viewInsetLeft = ((Insets)localObject).left;
      localObject = paramWindowInsets.getInsets(WindowInsets.Type.systemGestures());
      this.viewportMetrics.systemGestureInsetTop = ((Insets)localObject).top;
      this.viewportMetrics.systemGestureInsetRight = ((Insets)localObject).right;
      this.viewportMetrics.systemGestureInsetBottom = ((Insets)localObject).bottom;
      this.viewportMetrics.systemGestureInsetLeft = ((Insets)localObject).left;
      paramWindowInsets = paramWindowInsets.getDisplayCutout();
      if (paramWindowInsets != null)
      {
        localObject = paramWindowInsets.getWaterfallInsets();
        localViewportMetrics = this.viewportMetrics;
        localViewportMetrics.paddingTop = Math.max(Math.max(localViewportMetrics.paddingTop, ((Insets)localObject).top), paramWindowInsets.getSafeInsetTop());
        localViewportMetrics = this.viewportMetrics;
        localViewportMetrics.paddingRight = Math.max(Math.max(localViewportMetrics.paddingRight, ((Insets)localObject).right), paramWindowInsets.getSafeInsetRight());
        localViewportMetrics = this.viewportMetrics;
        localViewportMetrics.paddingBottom = Math.max(Math.max(localViewportMetrics.paddingBottom, ((Insets)localObject).bottom), paramWindowInsets.getSafeInsetBottom());
        localViewportMetrics = this.viewportMetrics;
        localViewportMetrics.paddingLeft = Math.max(Math.max(localViewportMetrics.paddingLeft, ((Insets)localObject).left), paramWindowInsets.getSafeInsetLeft());
      }
    }
    else
    {
      localObject = FlutterView.ZeroSides.NONE;
      if (j == 0) {
        localObject = calculateShouldZeroSides();
      }
      localViewportMetrics = this.viewportMetrics;
      if (k != 0) {
        i = paramWindowInsets.getSystemWindowInsetTop();
      } else {
        i = 0;
      }
      localViewportMetrics.paddingTop = i;
      localViewportMetrics = this.viewportMetrics;
      if ((localObject != FlutterView.ZeroSides.RIGHT) && (localObject != FlutterView.ZeroSides.BOTH)) {
        i = paramWindowInsets.getSystemWindowInsetRight();
      } else {
        i = 0;
      }
      localViewportMetrics.paddingRight = i;
      localViewportMetrics = this.viewportMetrics;
      localViewportMetrics.paddingBottom = 0;
      if ((localObject != FlutterView.ZeroSides.LEFT) && (localObject != FlutterView.ZeroSides.BOTH)) {
        i = paramWindowInsets.getSystemWindowInsetLeft();
      } else {
        i = 0;
      }
      localViewportMetrics.paddingLeft = i;
      localObject = this.viewportMetrics;
      ((FlutterRenderer.ViewportMetrics)localObject).viewInsetTop = 0;
      ((FlutterRenderer.ViewportMetrics)localObject).viewInsetRight = 0;
      if (j != 0) {
        i = paramWindowInsets.getSystemWindowInsetBottom();
      } else {
        i = guessBottomKeyboardInset(paramWindowInsets);
      }
      ((FlutterRenderer.ViewportMetrics)localObject).viewInsetBottom = i;
      this.viewportMetrics.viewInsetLeft = 0;
    }
    paramWindowInsets = new StringBuilder();
    paramWindowInsets.append("Updating window insets (onApplyWindowInsets()):\nStatus bar insets: Top: ");
    paramWindowInsets.append(this.viewportMetrics.paddingTop);
    paramWindowInsets.append(", Left: ");
    paramWindowInsets.append(this.viewportMetrics.paddingLeft);
    paramWindowInsets.append(", Right: ");
    paramWindowInsets.append(this.viewportMetrics.paddingRight);
    paramWindowInsets.append("\nKeyboard insets: Bottom: ");
    paramWindowInsets.append(this.viewportMetrics.viewInsetBottom);
    paramWindowInsets.append(", Left: ");
    paramWindowInsets.append(this.viewportMetrics.viewInsetLeft);
    paramWindowInsets.append(", Right: ");
    paramWindowInsets.append(this.viewportMetrics.viewInsetRight);
    paramWindowInsets.append("System Gesture Insets - Left: ");
    paramWindowInsets.append(this.viewportMetrics.systemGestureInsetLeft);
    paramWindowInsets.append(", Top: ");
    paramWindowInsets.append(this.viewportMetrics.systemGestureInsetTop);
    paramWindowInsets.append(", Right: ");
    paramWindowInsets.append(this.viewportMetrics.systemGestureInsetRight);
    paramWindowInsets.append(", Bottom: ");
    paramWindowInsets.append(this.viewportMetrics.viewInsetBottom);
    Log.v("FlutterView", paramWindowInsets.toString());
    sendViewportMetricsToFlutter();
    return localWindowInsets;
  }
  
  protected void onConfigurationChanged(@NonNull Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    if (this.flutterEngine != null)
    {
      Log.v("FlutterView", "Configuration changed. Sending locales and user settings to Flutter.");
      this.localizationPlugin.sendLocalesToFlutter(paramConfiguration);
      sendUserSettingsToFlutter();
    }
  }
  
  @Nullable
  public InputConnection onCreateInputConnection(@NonNull EditorInfo paramEditorInfo)
  {
    if (!isAttachedToFlutterEngine()) {
      return super.onCreateInputConnection(paramEditorInfo);
    }
    return this.textInputPlugin.createInputConnection(this, paramEditorInfo);
  }
  
  public boolean onGenericMotionEvent(@NonNull MotionEvent paramMotionEvent)
  {
    int i;
    if ((isAttachedToFlutterEngine()) && (this.androidTouchProcessor.onGenericMotionEvent(paramMotionEvent))) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      return true;
    }
    return super.onGenericMotionEvent(paramMotionEvent);
  }
  
  public boolean onHoverEvent(@NonNull MotionEvent paramMotionEvent)
  {
    if (!isAttachedToFlutterEngine()) {
      return super.onHoverEvent(paramMotionEvent);
    }
    return this.accessibilityBridge.onAccessibilityHoverEvent(paramMotionEvent);
  }
  
  public boolean onKeyDown(int paramInt, @NonNull KeyEvent paramKeyEvent)
  {
    if (!isAttachedToFlutterEngine()) {
      return super.onKeyDown(paramInt, paramKeyEvent);
    }
    return (this.androidKeyProcessor.onKeyDown(paramKeyEvent)) || (super.onKeyDown(paramInt, paramKeyEvent));
  }
  
  public boolean onKeyUp(int paramInt, @NonNull KeyEvent paramKeyEvent)
  {
    if (!isAttachedToFlutterEngine()) {
      return super.onKeyUp(paramInt, paramKeyEvent);
    }
    return (this.androidKeyProcessor.onKeyUp(paramKeyEvent)) || (super.onKeyUp(paramInt, paramKeyEvent));
  }
  
  public void onProvideAutofillVirtualStructure(ViewStructure paramViewStructure, int paramInt)
  {
    super.onProvideAutofillVirtualStructure(paramViewStructure, paramInt);
    this.textInputPlugin.onProvideAutofillVirtualStructure(paramViewStructure, paramInt);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Size changed. Sending Flutter new viewport metrics. FlutterView was ");
    ((StringBuilder)localObject).append(paramInt3);
    ((StringBuilder)localObject).append(" x ");
    ((StringBuilder)localObject).append(paramInt4);
    ((StringBuilder)localObject).append(", it is now ");
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append(" x ");
    ((StringBuilder)localObject).append(paramInt2);
    Log.v("FlutterView", ((StringBuilder)localObject).toString());
    localObject = this.viewportMetrics;
    ((FlutterRenderer.ViewportMetrics)localObject).width = paramInt1;
    ((FlutterRenderer.ViewportMetrics)localObject).height = paramInt2;
    sendViewportMetricsToFlutter();
  }
  
  public boolean onTouchEvent(@NonNull MotionEvent paramMotionEvent)
  {
    if (!isAttachedToFlutterEngine()) {
      return super.onTouchEvent(paramMotionEvent);
    }
    if (Build.VERSION.SDK_INT >= 21) {
      requestUnbufferedDispatch(paramMotionEvent);
    }
    return this.androidTouchProcessor.onTouchEvent(paramMotionEvent);
  }
  
  @VisibleForTesting
  public void removeFlutterEngineAttachmentListener(@NonNull FlutterView.FlutterEngineAttachmentListener paramFlutterEngineAttachmentListener)
  {
    this.flutterEngineAttachmentListeners.remove(paramFlutterEngineAttachmentListener);
  }
  
  public void removeOnFirstFrameRenderedListener(@NonNull FlutterUiDisplayListener paramFlutterUiDisplayListener)
  {
    this.flutterUiDisplayListeners.remove(paramFlutterUiDisplayListener);
  }
  
  public void revertImageView(@NonNull Runnable paramRunnable)
  {
    Object localObject1 = this.flutterImageView;
    if (localObject1 == null)
    {
      Log.v("FlutterView", "Tried to revert the image view, but no image view is used.");
      return;
    }
    Object localObject2 = this.previousRenderSurface;
    if (localObject2 == null)
    {
      Log.v("FlutterView", "Tried to revert the image view, but no previous surface was used.");
      return;
    }
    this.renderSurface = ((RenderSurface)localObject2);
    this.previousRenderSurface = null;
    localObject2 = this.flutterEngine;
    if (localObject2 == null)
    {
      ((FlutterImageView)localObject1).detachFromRenderer();
      paramRunnable.run();
      return;
    }
    localObject1 = ((FlutterEngine)localObject2).getRenderer();
    if (localObject1 == null)
    {
      this.flutterImageView.detachFromRenderer();
      paramRunnable.run();
      return;
    }
    this.renderSurface.attachToRenderer((FlutterRenderer)localObject1);
    ((FlutterRenderer)localObject1).addIsDisplayingFlutterUiListener(new FlutterView.4(this, (FlutterRenderer)localObject1, paramRunnable));
  }
  
  @VisibleForTesting
  void sendUserSettingsToFlutter()
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
    this.flutterEngine.getSettingsChannel().startMessage().setTextScaleFactor(getResources().getConfiguration().fontScale).setUse24HourFormat(DateFormat.is24HourFormat(getContext())).setPlatformBrightness(localPlatformBrightness).send();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     io.flutter.embedding.android.FlutterView
 * JD-Core Version:    0.7.0.1
 */