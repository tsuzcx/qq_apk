package io.flutter.plugin.platform;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.MotionEvent.PointerCoords;
import android.view.MotionEvent.PointerProperties;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import androidx.annotation.VisibleForTesting;
import io.flutter.embedding.android.AndroidTouchProcessor;
import io.flutter.embedding.android.FlutterImageView;
import io.flutter.embedding.android.FlutterImageView.SurfaceKind;
import io.flutter.embedding.android.FlutterView;
import io.flutter.embedding.android.MotionEventTracker;
import io.flutter.embedding.android.MotionEventTracker.MotionEventId;
import io.flutter.embedding.engine.FlutterOverlaySurface;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.embedding.engine.mutatorsstack.FlutterMutatorView;
import io.flutter.embedding.engine.mutatorsstack.FlutterMutatorsStack;
import io.flutter.embedding.engine.renderer.FlutterRenderer;
import io.flutter.embedding.engine.systemchannels.PlatformViewsChannel;
import io.flutter.embedding.engine.systemchannels.PlatformViewsChannel.PlatformViewTouch;
import io.flutter.embedding.engine.systemchannels.PlatformViewsChannel.PlatformViewsHandler;
import io.flutter.plugin.editing.TextInputPlugin;
import io.flutter.view.AccessibilityBridge;
import io.flutter.view.TextureRegistry;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class PlatformViewsController
  implements PlatformViewsAccessibilityDelegate
{
  private static final String TAG = "PlatformViewsController";
  private final AccessibilityEventsDelegate accessibilityEventsDelegate = new AccessibilityEventsDelegate();
  private AndroidTouchProcessor androidTouchProcessor;
  private final PlatformViewsChannel.PlatformViewsHandler channelHandler = new PlatformViewsController.1(this);
  private Context context;
  private final HashMap<Context, View> contextToPlatformView = new HashMap();
  private HashSet<Integer> currentFrameUsedOverlayLayerIds = new HashSet();
  private HashSet<Integer> currentFrameUsedPlatformViewIds = new HashSet();
  private View flutterView;
  private boolean flutterViewConvertedToImageView = false;
  private final MotionEventTracker motionEventTracker = MotionEventTracker.getInstance();
  private int nextOverlayLayerId = 0;
  private final SparseArray<FlutterImageView> overlayLayerViews = new SparseArray();
  private final SparseArray<FlutterMutatorView> platformViewParent = new SparseArray();
  private final SparseArray<PlatformView> platformViews = new SparseArray();
  private PlatformViewsChannel platformViewsChannel;
  private final PlatformViewRegistryImpl registry = new PlatformViewRegistryImpl();
  private TextInputPlugin textInputPlugin;
  private TextureRegistry textureRegistry;
  @VisibleForTesting
  final HashMap<Integer, VirtualDisplayController> vdControllers = new HashMap();
  
  private void finishFrame(boolean paramBoolean)
  {
    int i = 0;
    int j;
    Object localObject;
    while (i < this.overlayLayerViews.size())
    {
      j = this.overlayLayerViews.keyAt(i);
      localObject = (FlutterImageView)this.overlayLayerViews.valueAt(i);
      if (this.currentFrameUsedOverlayLayerIds.contains(Integer.valueOf(j)))
      {
        ((FlutterView)this.flutterView).attachOverlaySurfaceToRender((FlutterImageView)localObject);
        paramBoolean &= ((FlutterImageView)localObject).acquireLatestImage();
      }
      else
      {
        if (!this.flutterViewConvertedToImageView) {
          ((FlutterImageView)localObject).detachFromRenderer();
        }
        ((FlutterImageView)localObject).setVisibility(8);
      }
      i += 1;
    }
    i = 0;
    while (i < this.platformViewParent.size())
    {
      j = this.platformViewParent.keyAt(i);
      localObject = (View)this.platformViewParent.get(j);
      if ((paramBoolean) && (this.currentFrameUsedPlatformViewIds.contains(Integer.valueOf(j)))) {
        ((View)localObject).setVisibility(0);
      } else {
        ((View)localObject).setVisibility(8);
      }
      i += 1;
    }
  }
  
  private void flushAllViews()
  {
    Iterator localIterator = this.vdControllers.values().iterator();
    while (localIterator.hasNext()) {
      ((VirtualDisplayController)localIterator.next()).dispose();
    }
    this.vdControllers.clear();
    while (this.platformViews.size() > 0) {
      this.channelHandler.disposeAndroidViewForPlatformView(this.platformViews.keyAt(0));
    }
  }
  
  private float getDisplayDensity()
  {
    return this.context.getResources().getDisplayMetrics().density;
  }
  
  private void initializeRootImageViewIfNeeded()
  {
    if (!this.flutterViewConvertedToImageView)
    {
      ((FlutterView)this.flutterView).convertToImageView();
      this.flutterViewConvertedToImageView = true;
    }
  }
  
  private void lockInputConnection(@NonNull VirtualDisplayController paramVirtualDisplayController)
  {
    TextInputPlugin localTextInputPlugin = this.textInputPlugin;
    if (localTextInputPlugin == null) {
      return;
    }
    localTextInputPlugin.lockPlatformViewInputConnection();
    paramVirtualDisplayController.onInputConnectionLocked();
  }
  
  private static MotionEvent.PointerCoords parsePointerCoords(Object paramObject, float paramFloat)
  {
    paramObject = (List)paramObject;
    MotionEvent.PointerCoords localPointerCoords = new MotionEvent.PointerCoords();
    localPointerCoords.orientation = ((float)((Double)paramObject.get(0)).doubleValue());
    localPointerCoords.pressure = ((float)((Double)paramObject.get(1)).doubleValue());
    localPointerCoords.size = ((float)((Double)paramObject.get(2)).doubleValue());
    localPointerCoords.toolMajor = ((float)((Double)paramObject.get(3)).doubleValue() * paramFloat);
    localPointerCoords.toolMinor = ((float)((Double)paramObject.get(4)).doubleValue() * paramFloat);
    localPointerCoords.touchMajor = ((float)((Double)paramObject.get(5)).doubleValue() * paramFloat);
    localPointerCoords.touchMinor = ((float)((Double)paramObject.get(6)).doubleValue() * paramFloat);
    localPointerCoords.x = ((float)((Double)paramObject.get(7)).doubleValue() * paramFloat);
    localPointerCoords.y = ((float)((Double)paramObject.get(8)).doubleValue() * paramFloat);
    return localPointerCoords;
  }
  
  private static List<MotionEvent.PointerCoords> parsePointerCoordsList(Object paramObject, float paramFloat)
  {
    Object localObject = (List)paramObject;
    paramObject = new ArrayList();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      paramObject.add(parsePointerCoords(((Iterator)localObject).next(), paramFloat));
    }
    return paramObject;
  }
  
  private static MotionEvent.PointerProperties parsePointerProperties(Object paramObject)
  {
    paramObject = (List)paramObject;
    MotionEvent.PointerProperties localPointerProperties = new MotionEvent.PointerProperties();
    localPointerProperties.id = ((Integer)paramObject.get(0)).intValue();
    localPointerProperties.toolType = ((Integer)paramObject.get(1)).intValue();
    return localPointerProperties;
  }
  
  private static List<MotionEvent.PointerProperties> parsePointerPropertiesList(Object paramObject)
  {
    Object localObject = (List)paramObject;
    paramObject = new ArrayList();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      paramObject.add(parsePointerProperties(((Iterator)localObject).next()));
    }
    return paramObject;
  }
  
  private int toPhysicalPixels(double paramDouble)
  {
    double d = getDisplayDensity();
    Double.isNaN(d);
    Double.isNaN(d);
    return (int)Math.round(paramDouble * d);
  }
  
  private void unlockInputConnection(@NonNull VirtualDisplayController paramVirtualDisplayController)
  {
    TextInputPlugin localTextInputPlugin = this.textInputPlugin;
    if (localTextInputPlugin == null) {
      return;
    }
    localTextInputPlugin.unlockPlatformViewInputConnection();
    paramVirtualDisplayController.onInputConnectionUnlocked();
  }
  
  private static boolean validateDirection(int paramInt)
  {
    boolean bool = true;
    if (paramInt != 0)
    {
      if (paramInt == 1) {
        return true;
      }
      bool = false;
    }
    return bool;
  }
  
  private void validateVirtualDisplayDimensions(int paramInt1, int paramInt2)
  {
    DisplayMetrics localDisplayMetrics = this.context.getResources().getDisplayMetrics();
    if ((paramInt2 > localDisplayMetrics.heightPixels) || (paramInt1 > localDisplayMetrics.widthPixels))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Creating a virtual display of size: [");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(", ");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append("] may result in problems(https://github.com/flutter/flutter/issues/2897).It is larger than the device screen size: [");
      localStringBuilder.append(localDisplayMetrics.widthPixels);
      localStringBuilder.append(", ");
      localStringBuilder.append(localDisplayMetrics.heightPixels);
      localStringBuilder.append("].");
      Log.w("PlatformViewsController", localStringBuilder.toString());
    }
  }
  
  public void attach(Context paramContext, TextureRegistry paramTextureRegistry, @NonNull DartExecutor paramDartExecutor)
  {
    if (this.context == null)
    {
      this.context = paramContext;
      this.textureRegistry = paramTextureRegistry;
      this.platformViewsChannel = new PlatformViewsChannel(paramDartExecutor);
      this.platformViewsChannel.setPlatformViewsHandler(this.channelHandler);
      return;
    }
    throw new AssertionError("A PlatformViewsController can only be attached to a single output target.\nattach was called while the PlatformViewsController was already attached.");
  }
  
  public void attachAccessibilityBridge(AccessibilityBridge paramAccessibilityBridge)
  {
    this.accessibilityEventsDelegate.setAccessibilityBridge(paramAccessibilityBridge);
  }
  
  public void attachTextInputPlugin(TextInputPlugin paramTextInputPlugin)
  {
    this.textInputPlugin = paramTextInputPlugin;
  }
  
  public void attachToFlutterRenderer(FlutterRenderer paramFlutterRenderer)
  {
    this.androidTouchProcessor = new AndroidTouchProcessor(paramFlutterRenderer, true);
  }
  
  public void attachToView(@NonNull View paramView)
  {
    this.flutterView = paramView;
    Iterator localIterator = this.vdControllers.values().iterator();
    while (localIterator.hasNext()) {
      ((VirtualDisplayController)localIterator.next()).onFlutterViewAttached(paramView);
    }
  }
  
  public boolean checkInputConnectionProxy(@Nullable View paramView)
  {
    if (paramView == null) {
      return false;
    }
    if (!this.contextToPlatformView.containsKey(paramView.getContext())) {
      return false;
    }
    View localView = (View)this.contextToPlatformView.get(paramView.getContext());
    if (localView == paramView) {
      return true;
    }
    return localView.checkInputConnectionProxy(paramView);
  }
  
  @TargetApi(19)
  public FlutterOverlaySurface createOverlaySurface()
  {
    return createOverlaySurface(new FlutterImageView(this.flutterView.getContext(), this.flutterView.getWidth(), this.flutterView.getHeight(), FlutterImageView.SurfaceKind.overlay));
  }
  
  @TargetApi(19)
  @VisibleForTesting
  public FlutterOverlaySurface createOverlaySurface(@NonNull FlutterImageView paramFlutterImageView)
  {
    int i = this.nextOverlayLayerId;
    this.nextOverlayLayerId = (i + 1);
    this.overlayLayerViews.put(i, paramFlutterImageView);
    return new FlutterOverlaySurface(i, paramFlutterImageView.getSurface());
  }
  
  public void destroyOverlaySurfaces()
  {
    int i = 0;
    while (i < this.overlayLayerViews.size())
    {
      this.overlayLayerViews.keyAt(i);
      FlutterImageView localFlutterImageView = (FlutterImageView)this.overlayLayerViews.valueAt(i);
      localFlutterImageView.detachFromRenderer();
      ((FlutterView)this.flutterView).removeView(localFlutterImageView);
      i += 1;
    }
    this.overlayLayerViews.clear();
  }
  
  @UiThread
  public void detach()
  {
    this.platformViewsChannel.setPlatformViewsHandler(null);
    this.platformViewsChannel = null;
    this.context = null;
    this.textureRegistry = null;
  }
  
  public void detachAccessibiltyBridge()
  {
    this.accessibilityEventsDelegate.setAccessibilityBridge(null);
  }
  
  public void detachFromView()
  {
    this.flutterView = null;
    Iterator localIterator = this.vdControllers.values().iterator();
    while (localIterator.hasNext()) {
      ((VirtualDisplayController)localIterator.next()).onFlutterViewDetached();
    }
  }
  
  public void detachTextInputPlugin()
  {
    this.textInputPlugin = null;
  }
  
  public View getPlatformViewById(Integer paramInteger)
  {
    if (this.platformViews.get(paramInteger.intValue()) != null) {
      return ((PlatformView)this.platformViews.get(paramInteger.intValue())).getView();
    }
    paramInteger = (VirtualDisplayController)this.vdControllers.get(paramInteger);
    if (paramInteger == null) {
      return null;
    }
    return paramInteger.getView();
  }
  
  public PlatformViewRegistry getRegistry()
  {
    return this.registry;
  }
  
  @VisibleForTesting
  void initializePlatformViewIfNeeded(int paramInt)
  {
    PlatformView localPlatformView = (PlatformView)this.platformViews.get(paramInt);
    if (localPlatformView != null)
    {
      if (this.platformViewParent.get(paramInt) != null) {
        return;
      }
      if (localPlatformView.getView() != null)
      {
        if (localPlatformView.getView().getParent() == null)
        {
          Object localObject = this.context;
          localObject = new FlutterMutatorView((Context)localObject, ((Context)localObject).getResources().getDisplayMetrics().density, this.androidTouchProcessor);
          this.platformViewParent.put(paramInt, localObject);
          ((FlutterMutatorView)localObject).addView(localPlatformView.getView());
          ((FlutterView)this.flutterView).addView((View)localObject);
          return;
        }
        throw new IllegalStateException("The Android view returned from PlatformView#getView() was already added to a parent view.");
      }
      throw new IllegalStateException("PlatformView#getView() returned null, but an Android view reference was expected.");
    }
    throw new IllegalStateException("Platform view hasn't been initialized from the platform view channel.");
  }
  
  public void onAttachedToJNI() {}
  
  public void onBeginFrame()
  {
    this.currentFrameUsedOverlayLayerIds.clear();
    this.currentFrameUsedPlatformViewIds.clear();
  }
  
  public void onDetachedFromJNI()
  {
    flushAllViews();
  }
  
  public void onDisplayOverlaySurface(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    initializeRootImageViewIfNeeded();
    FlutterImageView localFlutterImageView = (FlutterImageView)this.overlayLayerViews.get(paramInt1);
    if (localFlutterImageView.getParent() == null) {
      ((FlutterView)this.flutterView).addView(localFlutterImageView);
    }
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(paramInt4, paramInt5);
    localLayoutParams.leftMargin = paramInt2;
    localLayoutParams.topMargin = paramInt3;
    localFlutterImageView.setLayoutParams(localLayoutParams);
    localFlutterImageView.setVisibility(0);
    localFlutterImageView.bringToFront();
    this.currentFrameUsedOverlayLayerIds.add(Integer.valueOf(paramInt1));
  }
  
  public void onDisplayPlatformView(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, FlutterMutatorsStack paramFlutterMutatorsStack)
  {
    initializeRootImageViewIfNeeded();
    initializePlatformViewIfNeeded(paramInt1);
    Object localObject = (FlutterMutatorView)this.platformViewParent.get(paramInt1);
    ((FlutterMutatorView)localObject).readyToDisplay(paramFlutterMutatorsStack, paramInt2, paramInt3, paramInt4, paramInt5);
    ((FlutterMutatorView)localObject).setVisibility(0);
    ((FlutterMutatorView)localObject).bringToFront();
    paramFlutterMutatorsStack = new FrameLayout.LayoutParams(paramInt6, paramInt7);
    localObject = ((PlatformView)this.platformViews.get(paramInt1)).getView();
    if (localObject != null)
    {
      ((View)localObject).setLayoutParams(paramFlutterMutatorsStack);
      ((View)localObject).bringToFront();
    }
    this.currentFrameUsedPlatformViewIds.add(Integer.valueOf(paramInt1));
  }
  
  public void onEndFrame()
  {
    FlutterView localFlutterView = (FlutterView)this.flutterView;
    boolean bool1 = this.flutterViewConvertedToImageView;
    boolean bool2 = false;
    if ((bool1) && (this.currentFrameUsedPlatformViewIds.isEmpty()))
    {
      this.flutterViewConvertedToImageView = false;
      localFlutterView.revertImageView(new PlatformViewsController.2(this));
      return;
    }
    bool1 = bool2;
    if (this.flutterViewConvertedToImageView)
    {
      bool1 = bool2;
      if (localFlutterView.acquireLatestImageViewFrame()) {
        bool1 = true;
      }
    }
    finishFrame(bool1);
  }
  
  public void onPreEngineRestart()
  {
    flushAllViews();
  }
  
  @VisibleForTesting
  public MotionEvent toMotionEvent(float paramFloat, PlatformViewsChannel.PlatformViewTouch paramPlatformViewTouch, boolean paramBoolean)
  {
    Object localObject = MotionEventTracker.MotionEventId.from(paramPlatformViewTouch.motionEventId);
    localObject = this.motionEventTracker.pop((MotionEventTracker.MotionEventId)localObject);
    MotionEvent.PointerProperties[] arrayOfPointerProperties = (MotionEvent.PointerProperties[])parsePointerPropertiesList(paramPlatformViewTouch.rawPointerPropertiesList).toArray(new MotionEvent.PointerProperties[paramPlatformViewTouch.pointerCount]);
    MotionEvent.PointerCoords[] arrayOfPointerCoords = (MotionEvent.PointerCoords[])parsePointerCoordsList(paramPlatformViewTouch.rawPointerCoords, paramFloat).toArray(new MotionEvent.PointerCoords[paramPlatformViewTouch.pointerCount]);
    if ((!paramBoolean) && (localObject != null)) {
      return MotionEvent.obtain(((MotionEvent)localObject).getDownTime(), ((MotionEvent)localObject).getEventTime(), ((MotionEvent)localObject).getAction(), paramPlatformViewTouch.pointerCount, arrayOfPointerProperties, arrayOfPointerCoords, ((MotionEvent)localObject).getMetaState(), ((MotionEvent)localObject).getButtonState(), ((MotionEvent)localObject).getXPrecision(), ((MotionEvent)localObject).getYPrecision(), ((MotionEvent)localObject).getDeviceId(), ((MotionEvent)localObject).getEdgeFlags(), ((MotionEvent)localObject).getSource(), ((MotionEvent)localObject).getFlags());
    }
    return MotionEvent.obtain(paramPlatformViewTouch.downTime.longValue(), paramPlatformViewTouch.eventTime.longValue(), paramPlatformViewTouch.action, paramPlatformViewTouch.pointerCount, arrayOfPointerProperties, arrayOfPointerCoords, paramPlatformViewTouch.metaState, paramPlatformViewTouch.buttonState, paramPlatformViewTouch.xPrecision, paramPlatformViewTouch.yPrecision, paramPlatformViewTouch.deviceId, paramPlatformViewTouch.edgeFlags, paramPlatformViewTouch.source, paramPlatformViewTouch.flags);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     io.flutter.plugin.platform.PlatformViewsController
 * JD-Core Version:    0.7.0.1
 */