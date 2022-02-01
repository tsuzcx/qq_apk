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
    for (this.renderSurface = this.flutterSurfaceView;; this.renderSurface = this.flutterTextureView)
    {
      init();
      return;
      if (paramRenderMode != FlutterView.RenderMode.texture) {
        break;
      }
      this.flutterTextureView = new FlutterTextureView(paramContext);
    }
    throw new IllegalArgumentException(String.format("RenderMode not supported with this constructor: %s", new Object[] { paramRenderMode }));
  }
  
  @Deprecated
  public FlutterView(@NonNull Context paramContext, @NonNull FlutterView.RenderMode paramRenderMode, @NonNull FlutterView.TransparencyMode paramTransparencyMode)
  {
    super(paramContext, null);
    if (paramRenderMode == FlutterView.RenderMode.surface) {
      if (paramTransparencyMode != FlutterView.TransparencyMode.transparent) {
        break label158;
      }
    }
    for (;;)
    {
      this.flutterSurfaceView = new FlutterSurfaceView(paramContext, bool);
      for (this.renderSurface = this.flutterSurfaceView;; this.renderSurface = this.flutterTextureView)
      {
        init();
        return;
        if (paramRenderMode != FlutterView.RenderMode.texture) {
          break;
        }
        this.flutterTextureView = new FlutterTextureView(paramContext);
      }
      throw new IllegalArgumentException(String.format("RenderMode not supported with this constructor: %s", new Object[] { paramRenderMode }));
      label158:
      bool = false;
    }
  }
  
  @Deprecated
  public FlutterView(@NonNull Context paramContext, @NonNull FlutterView.TransparencyMode paramTransparencyMode) {}
  
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
    if (d1 < d2 * 0.18D) {
      return 0;
    }
    return paramWindowInsets.getSystemWindowInsetBottom();
  }
  
  private void init()
  {
    Log.v("FlutterView", "Initializing FlutterView");
    if (this.flutterSurfaceView != null)
    {
      Log.v("FlutterView", "Internally using a FlutterSurfaceView.");
      addView(this.flutterSurfaceView);
    }
    for (;;)
    {
      setFocusable(true);
      setFocusableInTouchMode(true);
      if (Build.VERSION.SDK_INT >= 26) {
        setImportantForAutofill(4);
      }
      return;
      if (this.flutterTextureView != null)
      {
        Log.v("FlutterView", "Internally using a FlutterTextureView.");
        addView(this.flutterTextureView);
      }
      else
      {
        Log.v("FlutterView", "Internally using a FlutterImageView.");
        addView(this.flutterImageView);
      }
    }
  }
  
  private void resetWillNotDraw(boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool2 = false;
    if (!this.flutterEngine.getRenderer().isSoftwareRenderingEnabled())
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
    if (this.flutterImageView != null) {
      return this.flutterImageView.acquireLatestImage();
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
    if (this.flutterEngine != null) {
      paramFlutterImageView.attachToRenderer(this.flutterEngine.getRenderer());
    }
  }
  
  public void attachToFlutterEngine(@NonNull FlutterEngine paramFlutterEngine)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Attaching to a FlutterEngine: ");
    ((StringBuilder)localObject).append(paramFlutterEngine);
    Log.v("FlutterView", ((StringBuilder)localObject).toString());
    if (isAttachedToFlutterEngine()) {
      if (paramFlutterEngine == this.flutterEngine) {
        Log.v("FlutterView", "Already attached to this engine. Doing nothing.");
      }
    }
    do
    {
      return;
      Log.v("FlutterView", "Currently attached to a different engine. Detaching and then attaching to new engine.");
      detachFromFlutterEngine();
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
    } while (!this.isFlutterUiDisplayed);
    this.flutterUiDisplayListener.onFlutterUiDisplayed();
  }
  
  public void autofill(SparseArray<AutofillValue> paramSparseArray)
  {
    this.textInputPlugin.autofill(paramSparseArray);
  }
  
  public boolean checkInputConnectionProxy(View paramView)
  {
    if (this.flutterEngine != null) {
      return this.flutterEngine.getPlatformViewsController().checkInputConnectionProxy(paramView);
    }
    return super.checkInputConnectionProxy(paramView);
  }
  
  public void convertToImageView()
  {
    this.renderSurface.pause();
    if (this.flutterImageView == null)
    {
      this.flutterImageView = createImageView();
      addView(this.flutterImageView);
    }
    for (;;)
    {
      this.previousRenderSurface = this.renderSurface;
      this.renderSurface = this.flutterImageView;
      if (this.flutterEngine != null) {
        this.renderSurface.attachToRenderer(this.flutterEngine.getRenderer());
      }
      return;
      this.flutterImageView.resizeIfNeeded(getWidth(), getHeight());
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
    if (this.mouseCursorPlugin != null) {
      this.mouseCursorPlugin.destroy();
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
  
  public boolean fitSystemWindows(@NonNull Rect paramRect)
  {
    if (Build.VERSION.SDK_INT <= 19)
    {
      this.viewportMetrics.paddingTop = paramRect.top;
      this.viewportMetrics.paddingRight = paramRect.right;
      this.viewportMetrics.paddingBottom = 0;
      this.viewportMetrics.paddingLeft = paramRect.left;
      this.viewportMetrics.viewInsetTop = 0;
      this.viewportMetrics.viewInsetRight = 0;
      this.viewportMetrics.viewInsetBottom = paramRect.bottom;
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
    if ((this.accessibilityBridge != null) && (this.accessibilityBridge.isAccessibilityEnabled())) {
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
    return (this.flutterEngine != null) && (this.flutterEngine.getRenderer() == this.renderSurface.getAttachedRenderer());
  }
  
  @SuppressLint({"InlinedApi", "NewApi"})
  @TargetApi(20)
  @NonNull
  @RequiresApi(20)
  public final WindowInsets onApplyWindowInsets(@NonNull WindowInsets paramWindowInsets)
  {
    int i = 1;
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
    int j;
    if ((getWindowSystemUiVisibility() & 0x4) == 0)
    {
      j = 1;
      if ((getWindowSystemUiVisibility() & 0x2) != 0) {
        break label648;
      }
      label91:
      if (Build.VERSION.SDK_INT < 30) {
        break label653;
      }
      if (i == 0) {
        break label838;
      }
    }
    label648:
    label653:
    label683:
    label818:
    label826:
    label838:
    for (i = WindowInsets.Type.navigationBars() | 0x0;; i = 0)
    {
      if (j != 0) {
        i = WindowInsets.Type.statusBars() | i;
      }
      for (;;)
      {
        localObject = paramWindowInsets.getInsets(i);
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
          this.viewportMetrics.paddingTop = Math.max(Math.max(this.viewportMetrics.paddingTop, ((Insets)localObject).top), paramWindowInsets.getSafeInsetTop());
          this.viewportMetrics.paddingRight = Math.max(Math.max(this.viewportMetrics.paddingRight, ((Insets)localObject).right), paramWindowInsets.getSafeInsetRight());
          this.viewportMetrics.paddingBottom = Math.max(Math.max(this.viewportMetrics.paddingBottom, ((Insets)localObject).bottom), paramWindowInsets.getSafeInsetBottom());
          this.viewportMetrics.paddingLeft = Math.max(Math.max(this.viewportMetrics.paddingLeft, ((Insets)localObject).left), paramWindowInsets.getSafeInsetLeft());
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
        j = 0;
        break;
        i = 0;
        break label91;
        localObject = FlutterView.ZeroSides.NONE;
        if (i == 0) {
          localObject = calculateShouldZeroSides();
        }
        FlutterRenderer.ViewportMetrics localViewportMetrics = this.viewportMetrics;
        if (j != 0)
        {
          j = paramWindowInsets.getSystemWindowInsetTop();
          localViewportMetrics.paddingTop = j;
          localViewportMetrics = this.viewportMetrics;
          if ((localObject != FlutterView.ZeroSides.RIGHT) && (localObject != FlutterView.ZeroSides.BOTH)) {
            break label810;
          }
          j = 0;
          label713:
          localViewportMetrics.paddingRight = j;
          this.viewportMetrics.paddingBottom = 0;
          localViewportMetrics = this.viewportMetrics;
          if ((localObject != FlutterView.ZeroSides.LEFT) && (localObject != FlutterView.ZeroSides.BOTH)) {
            break label818;
          }
          j = 0;
          label751:
          localViewportMetrics.paddingLeft = j;
          this.viewportMetrics.viewInsetTop = 0;
          this.viewportMetrics.viewInsetRight = 0;
          localObject = this.viewportMetrics;
          if (i == 0) {
            break label826;
          }
        }
        for (i = paramWindowInsets.getSystemWindowInsetBottom();; i = guessBottomKeyboardInset(paramWindowInsets))
        {
          ((FlutterRenderer.ViewportMetrics)localObject).viewInsetBottom = i;
          this.viewportMetrics.viewInsetLeft = 0;
          break;
          j = 0;
          break label683;
          j = paramWindowInsets.getSystemWindowInsetRight();
          break label713;
          j = paramWindowInsets.getSystemWindowInsetLeft();
          break label751;
        }
      }
    }
  }
  
  public void onConfigurationChanged(@NonNull Configuration paramConfiguration)
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
    if ((isAttachedToFlutterEngine()) && (this.androidTouchProcessor.onGenericMotionEvent(paramMotionEvent))) {}
    for (int i = 1; i != 0; i = 0) {
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
  
  public void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Size changed. Sending Flutter new viewport metrics. FlutterView was ");
    localStringBuilder.append(paramInt3);
    localStringBuilder.append(" x ");
    localStringBuilder.append(paramInt4);
    localStringBuilder.append(", it is now ");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(" x ");
    localStringBuilder.append(paramInt2);
    Log.v("FlutterView", localStringBuilder.toString());
    this.viewportMetrics.width = paramInt1;
    this.viewportMetrics.height = paramInt2;
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
    if (this.flutterImageView == null)
    {
      Log.v("FlutterView", "Tried to revert the image view, but no image view is used.");
      return;
    }
    if (this.previousRenderSurface == null)
    {
      Log.v("FlutterView", "Tried to revert the image view, but no previous surface was used.");
      return;
    }
    this.renderSurface = this.previousRenderSurface;
    this.previousRenderSurface = null;
    if (this.flutterEngine == null)
    {
      this.flutterImageView.detachFromRenderer();
      paramRunnable.run();
      return;
    }
    FlutterRenderer localFlutterRenderer = this.flutterEngine.getRenderer();
    if (localFlutterRenderer == null)
    {
      this.flutterImageView.detachFromRenderer();
      paramRunnable.run();
      return;
    }
    this.renderSurface.attachToRenderer(localFlutterRenderer);
    localFlutterRenderer.addIsDisplayingFlutterUiListener(new FlutterView.4(this, localFlutterRenderer, paramRunnable));
  }
  
  @VisibleForTesting
  void sendUserSettingsToFlutter()
  {
    int i;
    if ((getResources().getConfiguration().uiMode & 0x30) == 32)
    {
      i = 1;
      if (i == 0) {
        break label74;
      }
    }
    label74:
    for (SettingsChannel.PlatformBrightness localPlatformBrightness = SettingsChannel.PlatformBrightness.dark;; localPlatformBrightness = SettingsChannel.PlatformBrightness.light)
    {
      this.flutterEngine.getSettingsChannel().startMessage().setTextScaleFactor(getResources().getConfiguration().fontScale).setUse24HourFormat(DateFormat.is24HourFormat(getContext())).setPlatformBrightness(localPlatformBrightness).send();
      return;
      i = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     io.flutter.embedding.android.FlutterView
 * JD-Core Version:    0.7.0.1
 */