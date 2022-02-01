package io.flutter.plugin.platform;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.SurfaceTexture;
import android.hardware.display.DisplayManager;
import android.hardware.display.VirtualDisplay;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import io.flutter.view.TextureRegistry.SurfaceTextureEntry;

@TargetApi(20)
class VirtualDisplayController
{
  private final AccessibilityEventsDelegate accessibilityEventsDelegate;
  private final Context context;
  private final int densityDpi;
  private final View.OnFocusChangeListener focusChangeListener;
  @VisibleForTesting
  SingleViewPresentation presentation;
  private Surface surface;
  private final TextureRegistry.SurfaceTextureEntry textureEntry;
  private VirtualDisplay virtualDisplay;
  
  private VirtualDisplayController(Context paramContext, AccessibilityEventsDelegate paramAccessibilityEventsDelegate, VirtualDisplay paramVirtualDisplay, PlatformViewFactory paramPlatformViewFactory, Surface paramSurface, TextureRegistry.SurfaceTextureEntry paramSurfaceTextureEntry, View.OnFocusChangeListener paramOnFocusChangeListener, int paramInt, Object paramObject)
  {
    this.context = paramContext;
    this.accessibilityEventsDelegate = paramAccessibilityEventsDelegate;
    this.textureEntry = paramSurfaceTextureEntry;
    this.focusChangeListener = paramOnFocusChangeListener;
    this.surface = paramSurface;
    this.virtualDisplay = paramVirtualDisplay;
    this.densityDpi = paramContext.getResources().getDisplayMetrics().densityDpi;
    this.presentation = new SingleViewPresentation(paramContext, this.virtualDisplay.getDisplay(), paramPlatformViewFactory, paramAccessibilityEventsDelegate, paramInt, paramObject, paramOnFocusChangeListener);
    this.presentation.show();
  }
  
  public static VirtualDisplayController create(Context paramContext, AccessibilityEventsDelegate paramAccessibilityEventsDelegate, PlatformViewFactory paramPlatformViewFactory, TextureRegistry.SurfaceTextureEntry paramSurfaceTextureEntry, int paramInt1, int paramInt2, int paramInt3, Object paramObject, View.OnFocusChangeListener paramOnFocusChangeListener)
  {
    paramSurfaceTextureEntry.surfaceTexture().setDefaultBufferSize(paramInt1, paramInt2);
    Surface localSurface = new Surface(paramSurfaceTextureEntry.surfaceTexture());
    VirtualDisplay localVirtualDisplay = ((DisplayManager)paramContext.getSystemService("display")).createVirtualDisplay("flutter-vd", paramInt1, paramInt2, paramContext.getResources().getDisplayMetrics().densityDpi, localSurface, 0);
    if (localVirtualDisplay == null) {
      return null;
    }
    return new VirtualDisplayController(paramContext, paramAccessibilityEventsDelegate, localVirtualDisplay, paramPlatformViewFactory, localSurface, paramSurfaceTextureEntry, paramOnFocusChangeListener, paramInt3, paramObject);
  }
  
  public void dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    SingleViewPresentation localSingleViewPresentation = this.presentation;
    if (localSingleViewPresentation == null) {
      return;
    }
    localSingleViewPresentation.dispatchTouchEvent(paramMotionEvent);
  }
  
  public void dispose()
  {
    PlatformView localPlatformView = this.presentation.getView();
    this.presentation.cancel();
    this.presentation.detachState();
    localPlatformView.dispose();
    this.virtualDisplay.release();
    this.textureEntry.release();
  }
  
  public View getView()
  {
    SingleViewPresentation localSingleViewPresentation = this.presentation;
    if (localSingleViewPresentation == null) {
      return null;
    }
    return localSingleViewPresentation.getView().getView();
  }
  
  void onFlutterViewAttached(@NonNull View paramView)
  {
    SingleViewPresentation localSingleViewPresentation = this.presentation;
    if (localSingleViewPresentation != null)
    {
      if (localSingleViewPresentation.getView() == null) {
        return;
      }
      this.presentation.getView().onFlutterViewAttached(paramView);
    }
  }
  
  void onFlutterViewDetached()
  {
    SingleViewPresentation localSingleViewPresentation = this.presentation;
    if (localSingleViewPresentation != null)
    {
      if (localSingleViewPresentation.getView() == null) {
        return;
      }
      this.presentation.getView().onFlutterViewDetached();
    }
  }
  
  void onInputConnectionLocked()
  {
    SingleViewPresentation localSingleViewPresentation = this.presentation;
    if (localSingleViewPresentation != null)
    {
      if (localSingleViewPresentation.getView() == null) {
        return;
      }
      this.presentation.getView().onInputConnectionLocked();
    }
  }
  
  void onInputConnectionUnlocked()
  {
    SingleViewPresentation localSingleViewPresentation = this.presentation;
    if (localSingleViewPresentation != null)
    {
      if (localSingleViewPresentation.getView() == null) {
        return;
      }
      this.presentation.getView().onInputConnectionUnlocked();
    }
  }
  
  public void resize(int paramInt1, int paramInt2, Runnable paramRunnable)
  {
    boolean bool = getView().isFocused();
    SingleViewPresentation.PresentationState localPresentationState = this.presentation.detachState();
    this.virtualDisplay.setSurface(null);
    this.virtualDisplay.release();
    this.textureEntry.surfaceTexture().setDefaultBufferSize(paramInt1, paramInt2);
    this.virtualDisplay = ((DisplayManager)this.context.getSystemService("display")).createVirtualDisplay("flutter-vd", paramInt1, paramInt2, this.densityDpi, this.surface, 0);
    View localView = getView();
    localView.addOnAttachStateChangeListener(new VirtualDisplayController.1(this, localView, paramRunnable));
    paramRunnable = new SingleViewPresentation(this.context, this.virtualDisplay.getDisplay(), this.accessibilityEventsDelegate, localPresentationState, this.focusChangeListener, bool);
    paramRunnable.show();
    this.presentation.cancel();
    this.presentation = paramRunnable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     io.flutter.plugin.platform.VirtualDisplayController
 * JD-Core Version:    0.7.0.1
 */