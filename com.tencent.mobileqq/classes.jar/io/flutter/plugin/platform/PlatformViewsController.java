package io.flutter.plugin.platform;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent.PointerCoords;
import android.view.MotionEvent.PointerProperties;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.UiThread;
import androidx.annotation.VisibleForTesting;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.embedding.engine.systemchannels.PlatformViewsChannel;
import io.flutter.embedding.engine.systemchannels.PlatformViewsChannel.PlatformViewsHandler;
import io.flutter.plugin.editing.TextInputPlugin;
import io.flutter.view.AccessibilityBridge;
import io.flutter.view.TextureRegistry;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class PlatformViewsController
  implements PlatformViewsAccessibilityDelegate
{
  private static final int MINIMAL_SDK = 20;
  private static final String TAG = "PlatformViewsController";
  private final AccessibilityEventsDelegate accessibilityEventsDelegate = new AccessibilityEventsDelegate();
  private final PlatformViewsChannel.PlatformViewsHandler channelHandler = new PlatformViewsController.1(this);
  private Context context;
  private final HashMap<Context, View> contextToPlatformView = new HashMap();
  private View flutterView;
  private PlatformViewsChannel platformViewsChannel;
  private final PlatformViewRegistryImpl registry = new PlatformViewRegistryImpl();
  private TextInputPlugin textInputPlugin;
  private TextureRegistry textureRegistry;
  @VisibleForTesting
  final HashMap<Integer, VirtualDisplayController> vdControllers = new HashMap();
  
  private void flushAllViews()
  {
    Iterator localIterator = this.vdControllers.values().iterator();
    while (localIterator.hasNext()) {
      ((VirtualDisplayController)localIterator.next()).dispose();
    }
    this.vdControllers.clear();
  }
  
  private void lockInputConnection(@NonNull VirtualDisplayController paramVirtualDisplayController)
  {
    if (this.textInputPlugin == null) {
      return;
    }
    this.textInputPlugin.lockPlatformViewInputConnection();
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
    double d = this.context.getResources().getDisplayMetrics().density;
    Double.isNaN(d);
    return (int)Math.round(d * paramDouble);
  }
  
  private void unlockInputConnection(@NonNull VirtualDisplayController paramVirtualDisplayController)
  {
    if (this.textInputPlugin == null) {
      return;
    }
    this.textInputPlugin.unlockPlatformViewInputConnection();
    paramVirtualDisplayController.onInputConnectionUnlocked();
  }
  
  private static boolean validateDirection(int paramInt)
  {
    return (paramInt == 0) || (paramInt == 1);
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
  
  public void attachToView(@NonNull View paramView)
  {
    this.flutterView = paramView;
    Iterator localIterator = this.vdControllers.values().iterator();
    while (localIterator.hasNext()) {
      ((VirtualDisplayController)localIterator.next()).onFlutterViewAttached(paramView);
    }
  }
  
  public boolean checkInputConnectionProxy(View paramView)
  {
    if (!this.contextToPlatformView.containsKey(paramView.getContext())) {
      return false;
    }
    View localView = (View)this.contextToPlatformView.get(paramView.getContext());
    if (localView == paramView) {
      return true;
    }
    return localView.checkInputConnectionProxy(paramView);
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
  
  public void onFlutterViewDestroyed()
  {
    flushAllViews();
  }
  
  public void onPreEngineRestart()
  {
    flushAllViews();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     io.flutter.plugin.platform.PlatformViewsController
 * JD-Core Version:    0.7.0.1
 */