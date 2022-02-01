package io.flutter.embedding.engine;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.os.Build.VERSION;
import android.os.Looper;
import android.view.Surface;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import androidx.annotation.VisibleForTesting;
import io.flutter.Log;
import io.flutter.embedding.engine.dart.PlatformMessageHandler;
import io.flutter.embedding.engine.mutatorsstack.FlutterMutatorsStack;
import io.flutter.embedding.engine.renderer.FlutterUiDisplayListener;
import io.flutter.plugin.common.StandardMessageCodec;
import io.flutter.plugin.localization.LocalizationPlugin;
import io.flutter.plugin.platform.PlatformViewsController;
import io.flutter.view.AccessibilityBridge.Action;
import io.flutter.view.FlutterCallbackInformation;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Locale.Builder;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

@Keep
public class FlutterJNI
{
  private static final String TAG = "FlutterJNI";
  @Nullable
  private static FlutterJNI.AsyncWaitForVsyncDelegate asyncWaitForVsyncDelegate;
  @Nullable
  private static String observatoryUri;
  private static float refreshRateFPS;
  @Nullable
  private FlutterJNI.AccessibilityDelegate accessibilityDelegate;
  @NonNull
  private final Set<FlutterEngine.EngineLifecycleListener> engineLifecycleListeners = new CopyOnWriteArraySet();
  @NonNull
  private final Set<FlutterUiDisplayListener> flutterUiDisplayListeners = new CopyOnWriteArraySet();
  @Nullable
  private LocalizationPlugin localizationPlugin;
  @NonNull
  private final Looper mainLooper = Looper.getMainLooper();
  @Nullable
  private Long nativePlatformViewId;
  @Nullable
  private PlatformMessageHandler platformMessageHandler;
  @Nullable
  private PlatformViewsController platformViewsController;
  
  private static void asyncWaitForVsync(long paramLong)
  {
    FlutterJNI.AsyncWaitForVsyncDelegate localAsyncWaitForVsyncDelegate = asyncWaitForVsyncDelegate;
    if (localAsyncWaitForVsyncDelegate != null)
    {
      localAsyncWaitForVsyncDelegate.asyncWaitForVsync(paramLong);
      return;
    }
    throw new IllegalStateException("An AsyncWaitForVsyncDelegate must be registered with FlutterJNI before asyncWaitForVsync() is invoked.");
  }
  
  private void ensureAttachedToNative()
  {
    if (this.nativePlatformViewId != null) {
      return;
    }
    throw new RuntimeException("Cannot execute operation because FlutterJNI is not attached to native.");
  }
  
  private void ensureNotAttachedToNative()
  {
    if (this.nativePlatformViewId == null) {
      return;
    }
    throw new RuntimeException("Cannot execute operation because FlutterJNI is attached to native.");
  }
  
  private void ensureRunningOnMainThread()
  {
    if (Looper.myLooper() == this.mainLooper) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Methods marked with @UiThread must be executed on the main thread. Current thread: ");
    localStringBuilder.append(Thread.currentThread().getName());
    throw new RuntimeException(localStringBuilder.toString());
  }
  
  @Nullable
  public static String getObservatoryUri()
  {
    return observatoryUri;
  }
  
  private void handlePlatformMessageResponse(int paramInt, byte[] paramArrayOfByte)
  {
    PlatformMessageHandler localPlatformMessageHandler = this.platformMessageHandler;
    if (localPlatformMessageHandler != null) {
      localPlatformMessageHandler.handlePlatformMessageResponse(paramInt, paramArrayOfByte);
    }
  }
  
  private native long nativeAttach(@NonNull FlutterJNI paramFlutterJNI, boolean paramBoolean, String[] paramArrayOfString);
  
  private native void nativeDestroy(long paramLong);
  
  private native void nativeDispatchEmptyPlatformMessage(long paramLong, @NonNull String paramString, int paramInt);
  
  private native void nativeDispatchPlatformMessage(long paramLong, @NonNull String paramString, @Nullable ByteBuffer paramByteBuffer, int paramInt1, int paramInt2);
  
  private native void nativeDispatchPointerDataPacket(long paramLong, @NonNull ByteBuffer paramByteBuffer, int paramInt);
  
  private native void nativeDispatchSemanticsAction(long paramLong, int paramInt1, int paramInt2, @Nullable ByteBuffer paramByteBuffer, int paramInt3);
  
  private native Bitmap nativeGetBitmap(long paramLong);
  
  private native boolean nativeGetIsSoftwareRenderingEnabled();
  
  public static native void nativeInit(@NonNull Context paramContext, @NonNull String[] paramArrayOfString, @Nullable String paramString1, @NonNull String paramString2, @NonNull String paramString3, long paramLong);
  
  private native void nativeInvokePlatformMessageEmptyResponseCallback(long paramLong, int paramInt);
  
  private native void nativeInvokePlatformMessageResponseCallback(long paramLong, int paramInt1, @Nullable ByteBuffer paramByteBuffer, int paramInt2);
  
  @NonNull
  public static native FlutterCallbackInformation nativeLookupCallbackInformation(long paramLong);
  
  private native void nativeMarkTextureFrameAvailable(long paramLong1, long paramLong2);
  
  private native void nativeNotifyLowMemoryWarning(long paramLong);
  
  public static native void nativeOnVsync(long paramLong1, long paramLong2, long paramLong3);
  
  public static native void nativePrefetchDefaultFontManager();
  
  private native void nativeRegisterTexture(long paramLong1, long paramLong2, @NonNull SurfaceTexture paramSurfaceTexture);
  
  private native void nativeRunBundleAndSnapshotFromLibrary(long paramLong, @NonNull String paramString1, @Nullable String paramString2, @Nullable String paramString3, @NonNull AssetManager paramAssetManager);
  
  private native void nativeSetAccessibilityFeatures(long paramLong, int paramInt);
  
  private native void nativeSetSemanticsEnabled(long paramLong, boolean paramBoolean);
  
  private native void nativeSetViewportMetrics(long paramLong, float paramFloat, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, int paramInt11, int paramInt12, int paramInt13, int paramInt14);
  
  private native void nativeSurfaceChanged(long paramLong, int paramInt1, int paramInt2);
  
  private native void nativeSurfaceCreated(long paramLong, @NonNull Surface paramSurface);
  
  private native void nativeSurfaceDestroyed(long paramLong);
  
  private native void nativeSurfaceWindowChanged(long paramLong, @NonNull Surface paramSurface);
  
  private native void nativeUnregisterTexture(long paramLong1, long paramLong2);
  
  private void onPreEngineRestart()
  {
    Iterator localIterator = this.engineLifecycleListeners.iterator();
    while (localIterator.hasNext()) {
      ((FlutterEngine.EngineLifecycleListener)localIterator.next()).onPreEngineRestart();
    }
  }
  
  public static void setAsyncWaitForVsyncDelegate(@Nullable FlutterJNI.AsyncWaitForVsyncDelegate paramAsyncWaitForVsyncDelegate)
  {
    asyncWaitForVsyncDelegate = paramAsyncWaitForVsyncDelegate;
  }
  
  public static void setRefreshRateFPS(float paramFloat)
  {
    refreshRateFPS = paramFloat;
  }
  
  @UiThread
  private void updateCustomAccessibilityActions(@NonNull ByteBuffer paramByteBuffer, @NonNull String[] paramArrayOfString)
  {
    ensureRunningOnMainThread();
    FlutterJNI.AccessibilityDelegate localAccessibilityDelegate = this.accessibilityDelegate;
    if (localAccessibilityDelegate != null) {
      localAccessibilityDelegate.updateCustomAccessibilityActions(paramByteBuffer, paramArrayOfString);
    }
  }
  
  @UiThread
  private void updateSemantics(@NonNull ByteBuffer paramByteBuffer, @NonNull String[] paramArrayOfString)
  {
    ensureRunningOnMainThread();
    FlutterJNI.AccessibilityDelegate localAccessibilityDelegate = this.accessibilityDelegate;
    if (localAccessibilityDelegate != null) {
      localAccessibilityDelegate.updateSemantics(paramByteBuffer, paramArrayOfString);
    }
  }
  
  @UiThread
  public void addEngineLifecycleListener(@NonNull FlutterEngine.EngineLifecycleListener paramEngineLifecycleListener)
  {
    ensureRunningOnMainThread();
    this.engineLifecycleListeners.add(paramEngineLifecycleListener);
  }
  
  @UiThread
  public void addIsDisplayingFlutterUiListener(@NonNull FlutterUiDisplayListener paramFlutterUiDisplayListener)
  {
    ensureRunningOnMainThread();
    this.flutterUiDisplayListeners.add(paramFlutterUiDisplayListener);
  }
  
  @UiThread
  public void attachToNative(boolean paramBoolean)
  {
    attachToNative(paramBoolean, new String[0]);
  }
  
  @UiThread
  public void attachToNative(boolean paramBoolean, String[] paramArrayOfString)
  {
    ensureRunningOnMainThread();
    ensureNotAttachedToNative();
    this.nativePlatformViewId = Long.valueOf(performNativeAttach(this, paramBoolean, paramArrayOfString));
  }
  
  @VisibleForTesting
  String[] computePlatformResolvedLocale(@NonNull String[] paramArrayOfString)
  {
    if (this.localizationPlugin == null) {
      return new String[0];
    }
    Object localObject = new ArrayList();
    int i = 0;
    while (i < paramArrayOfString.length)
    {
      String str1 = paramArrayOfString[(i + 0)];
      String str2 = paramArrayOfString[(i + 1)];
      String str3 = paramArrayOfString[(i + 2)];
      if (Build.VERSION.SDK_INT >= 21)
      {
        Locale.Builder localBuilder = new Locale.Builder();
        if (!str1.isEmpty()) {
          localBuilder.setLanguage(str1);
        }
        if (!str2.isEmpty()) {
          localBuilder.setRegion(str2);
        }
        if (!str3.isEmpty()) {
          localBuilder.setScript(str3);
        }
        ((List)localObject).add(localBuilder.build());
      }
      else
      {
        ((List)localObject).add(new Locale(str1, str2));
      }
      i += 3;
    }
    paramArrayOfString = this.localizationPlugin.resolveNativeLocale((List)localObject);
    if (paramArrayOfString == null) {
      return new String[0];
    }
    localObject = new String[3];
    localObject[0] = paramArrayOfString.getLanguage();
    localObject[1] = paramArrayOfString.getCountry();
    if (Build.VERSION.SDK_INT >= 21)
    {
      localObject[2] = paramArrayOfString.getScript();
      return localObject;
    }
    localObject[2] = "";
    return localObject;
  }
  
  @UiThread
  public FlutterOverlaySurface createOverlaySurface()
  {
    ensureRunningOnMainThread();
    PlatformViewsController localPlatformViewsController = this.platformViewsController;
    if (localPlatformViewsController != null) {
      return localPlatformViewsController.createOverlaySurface();
    }
    throw new RuntimeException("platformViewsController must be set before attempting to position an overlay surface");
  }
  
  @UiThread
  public void destroyOverlaySurfaces()
  {
    ensureRunningOnMainThread();
    PlatformViewsController localPlatformViewsController = this.platformViewsController;
    if (localPlatformViewsController != null)
    {
      localPlatformViewsController.destroyOverlaySurfaces();
      return;
    }
    throw new RuntimeException("platformViewsController must be set before attempting to destroy an overlay surface");
  }
  
  @UiThread
  public void detachFromNativeAndReleaseResources()
  {
    ensureRunningOnMainThread();
    ensureAttachedToNative();
    nativeDestroy(this.nativePlatformViewId.longValue());
    this.nativePlatformViewId = null;
  }
  
  @UiThread
  public void dispatchEmptyPlatformMessage(@NonNull String paramString, int paramInt)
  {
    ensureRunningOnMainThread();
    if (isAttached())
    {
      nativeDispatchEmptyPlatformMessage(this.nativePlatformViewId.longValue(), paramString, paramInt);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Tried to send a platform message to Flutter, but FlutterJNI was detached from native C++. Could not send. Channel: ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(". Response ID: ");
    localStringBuilder.append(paramInt);
    Log.w("FlutterJNI", localStringBuilder.toString());
  }
  
  @UiThread
  public void dispatchPlatformMessage(@NonNull String paramString, @Nullable ByteBuffer paramByteBuffer, int paramInt1, int paramInt2)
  {
    ensureRunningOnMainThread();
    if (isAttached())
    {
      nativeDispatchPlatformMessage(this.nativePlatformViewId.longValue(), paramString, paramByteBuffer, paramInt1, paramInt2);
      return;
    }
    paramByteBuffer = new StringBuilder();
    paramByteBuffer.append("Tried to send a platform message to Flutter, but FlutterJNI was detached from native C++. Could not send. Channel: ");
    paramByteBuffer.append(paramString);
    paramByteBuffer.append(". Response ID: ");
    paramByteBuffer.append(paramInt2);
    Log.w("FlutterJNI", paramByteBuffer.toString());
  }
  
  @UiThread
  public void dispatchPointerDataPacket(@NonNull ByteBuffer paramByteBuffer, int paramInt)
  {
    ensureRunningOnMainThread();
    ensureAttachedToNative();
    nativeDispatchPointerDataPacket(this.nativePlatformViewId.longValue(), paramByteBuffer, paramInt);
  }
  
  @UiThread
  public void dispatchSemanticsAction(int paramInt1, int paramInt2, @Nullable ByteBuffer paramByteBuffer, int paramInt3)
  {
    ensureRunningOnMainThread();
    ensureAttachedToNative();
    nativeDispatchSemanticsAction(this.nativePlatformViewId.longValue(), paramInt1, paramInt2, paramByteBuffer, paramInt3);
  }
  
  public void dispatchSemanticsAction(int paramInt, @NonNull AccessibilityBridge.Action paramAction)
  {
    dispatchSemanticsAction(paramInt, paramAction, null);
  }
  
  public void dispatchSemanticsAction(int paramInt, @NonNull AccessibilityBridge.Action paramAction, @Nullable Object paramObject)
  {
    ensureAttachedToNative();
    int i;
    if (paramObject != null)
    {
      paramObject = StandardMessageCodec.INSTANCE.encodeMessage(paramObject);
      i = paramObject.position();
    }
    else
    {
      paramObject = null;
      i = 0;
    }
    dispatchSemanticsAction(paramInt, paramAction.value, paramObject, i);
  }
  
  @UiThread
  public Bitmap getBitmap()
  {
    ensureRunningOnMainThread();
    ensureAttachedToNative();
    return nativeGetBitmap(this.nativePlatformViewId.longValue());
  }
  
  @UiThread
  public boolean getIsSoftwareRenderingEnabled()
  {
    return nativeGetIsSoftwareRenderingEnabled();
  }
  
  @VisibleForTesting
  public void handlePlatformMessage(@NonNull String paramString, byte[] paramArrayOfByte, int paramInt)
  {
    PlatformMessageHandler localPlatformMessageHandler = this.platformMessageHandler;
    if (localPlatformMessageHandler != null) {
      localPlatformMessageHandler.handleMessageFromDart(paramString, paramArrayOfByte, paramInt);
    }
  }
  
  @UiThread
  public void invokePlatformMessageEmptyResponseCallback(int paramInt)
  {
    ensureRunningOnMainThread();
    if (isAttached())
    {
      nativeInvokePlatformMessageEmptyResponseCallback(this.nativePlatformViewId.longValue(), paramInt);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Tried to send a platform message response, but FlutterJNI was detached from native C++. Could not send. Response ID: ");
    localStringBuilder.append(paramInt);
    Log.w("FlutterJNI", localStringBuilder.toString());
  }
  
  @UiThread
  public void invokePlatformMessageResponseCallback(int paramInt1, @Nullable ByteBuffer paramByteBuffer, int paramInt2)
  {
    ensureRunningOnMainThread();
    if (isAttached())
    {
      nativeInvokePlatformMessageResponseCallback(this.nativePlatformViewId.longValue(), paramInt1, paramByteBuffer, paramInt2);
      return;
    }
    paramByteBuffer = new StringBuilder();
    paramByteBuffer.append("Tried to send a platform message response, but FlutterJNI was detached from native C++. Could not send. Response ID: ");
    paramByteBuffer.append(paramInt1);
    Log.w("FlutterJNI", paramByteBuffer.toString());
  }
  
  public boolean isAttached()
  {
    return this.nativePlatformViewId != null;
  }
  
  @UiThread
  public void markTextureFrameAvailable(long paramLong)
  {
    ensureRunningOnMainThread();
    ensureAttachedToNative();
    nativeMarkTextureFrameAvailable(this.nativePlatformViewId.longValue(), paramLong);
  }
  
  public native boolean nativeFlutterTextUtilsIsEmoji(int paramInt);
  
  public native boolean nativeFlutterTextUtilsIsEmojiModifier(int paramInt);
  
  public native boolean nativeFlutterTextUtilsIsEmojiModifierBase(int paramInt);
  
  public native boolean nativeFlutterTextUtilsIsRegionalIndicator(int paramInt);
  
  public native boolean nativeFlutterTextUtilsIsVariationSelector(int paramInt);
  
  @UiThread
  public void notifyLowMemoryWarning()
  {
    ensureRunningOnMainThread();
    ensureAttachedToNative();
    nativeNotifyLowMemoryWarning(this.nativePlatformViewId.longValue());
  }
  
  @UiThread
  public void onBeginFrame()
  {
    ensureRunningOnMainThread();
    PlatformViewsController localPlatformViewsController = this.platformViewsController;
    if (localPlatformViewsController != null)
    {
      localPlatformViewsController.onBeginFrame();
      return;
    }
    throw new RuntimeException("platformViewsController must be set before attempting to begin the frame");
  }
  
  @UiThread
  public void onDisplayOverlaySurface(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    ensureRunningOnMainThread();
    PlatformViewsController localPlatformViewsController = this.platformViewsController;
    if (localPlatformViewsController != null)
    {
      localPlatformViewsController.onDisplayOverlaySurface(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
      return;
    }
    throw new RuntimeException("platformViewsController must be set before attempting to position an overlay surface");
  }
  
  @UiThread
  public void onDisplayPlatformView(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, FlutterMutatorsStack paramFlutterMutatorsStack)
  {
    ensureRunningOnMainThread();
    PlatformViewsController localPlatformViewsController = this.platformViewsController;
    if (localPlatformViewsController != null)
    {
      localPlatformViewsController.onDisplayPlatformView(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramFlutterMutatorsStack);
      return;
    }
    throw new RuntimeException("platformViewsController must be set before attempting to position a platform view");
  }
  
  @UiThread
  public void onEndFrame()
  {
    ensureRunningOnMainThread();
    PlatformViewsController localPlatformViewsController = this.platformViewsController;
    if (localPlatformViewsController != null)
    {
      localPlatformViewsController.onEndFrame();
      return;
    }
    throw new RuntimeException("platformViewsController must be set before attempting to end the frame");
  }
  
  @UiThread
  @VisibleForTesting
  public void onFirstFrame()
  {
    ensureRunningOnMainThread();
    Iterator localIterator = this.flutterUiDisplayListeners.iterator();
    while (localIterator.hasNext()) {
      ((FlutterUiDisplayListener)localIterator.next()).onFlutterUiDisplayed();
    }
  }
  
  @UiThread
  @VisibleForTesting
  void onRenderingStopped()
  {
    ensureRunningOnMainThread();
    Iterator localIterator = this.flutterUiDisplayListeners.iterator();
    while (localIterator.hasNext()) {
      ((FlutterUiDisplayListener)localIterator.next()).onFlutterUiNoLongerDisplayed();
    }
  }
  
  @UiThread
  public void onSurfaceChanged(int paramInt1, int paramInt2)
  {
    ensureRunningOnMainThread();
    ensureAttachedToNative();
    nativeSurfaceChanged(this.nativePlatformViewId.longValue(), paramInt1, paramInt2);
  }
  
  @UiThread
  public void onSurfaceCreated(@NonNull Surface paramSurface)
  {
    ensureRunningOnMainThread();
    ensureAttachedToNative();
    nativeSurfaceCreated(this.nativePlatformViewId.longValue(), paramSurface);
  }
  
  @UiThread
  public void onSurfaceDestroyed()
  {
    ensureRunningOnMainThread();
    ensureAttachedToNative();
    onRenderingStopped();
    nativeSurfaceDestroyed(this.nativePlatformViewId.longValue());
  }
  
  @UiThread
  public void onSurfaceWindowChanged(@NonNull Surface paramSurface)
  {
    ensureRunningOnMainThread();
    ensureAttachedToNative();
    nativeSurfaceWindowChanged(this.nativePlatformViewId.longValue(), paramSurface);
  }
  
  @VisibleForTesting
  public long performNativeAttach(@NonNull FlutterJNI paramFlutterJNI, boolean paramBoolean)
  {
    return performNativeAttach(this, paramBoolean, new String[0]);
  }
  
  @VisibleForTesting
  public long performNativeAttach(@NonNull FlutterJNI paramFlutterJNI, boolean paramBoolean, String[] paramArrayOfString)
  {
    return nativeAttach(this, paramBoolean, paramArrayOfString);
  }
  
  @UiThread
  public void registerTexture(long paramLong, @NonNull SurfaceTexture paramSurfaceTexture)
  {
    ensureRunningOnMainThread();
    ensureAttachedToNative();
    nativeRegisterTexture(this.nativePlatformViewId.longValue(), paramLong, paramSurfaceTexture);
  }
  
  @UiThread
  public void removeEngineLifecycleListener(@NonNull FlutterEngine.EngineLifecycleListener paramEngineLifecycleListener)
  {
    ensureRunningOnMainThread();
    this.engineLifecycleListeners.remove(paramEngineLifecycleListener);
  }
  
  @UiThread
  public void removeIsDisplayingFlutterUiListener(@NonNull FlutterUiDisplayListener paramFlutterUiDisplayListener)
  {
    ensureRunningOnMainThread();
    this.flutterUiDisplayListeners.remove(paramFlutterUiDisplayListener);
  }
  
  @UiThread
  public void runBundleAndSnapshotFromLibrary(@NonNull String paramString1, @Nullable String paramString2, @Nullable String paramString3, @NonNull AssetManager paramAssetManager)
  {
    ensureRunningOnMainThread();
    ensureAttachedToNative();
    nativeRunBundleAndSnapshotFromLibrary(this.nativePlatformViewId.longValue(), paramString1, paramString2, paramString3, paramAssetManager);
  }
  
  @UiThread
  public void setAccessibilityDelegate(@Nullable FlutterJNI.AccessibilityDelegate paramAccessibilityDelegate)
  {
    ensureRunningOnMainThread();
    this.accessibilityDelegate = paramAccessibilityDelegate;
  }
  
  @UiThread
  public void setAccessibilityFeatures(int paramInt)
  {
    ensureRunningOnMainThread();
    ensureAttachedToNative();
    nativeSetAccessibilityFeatures(this.nativePlatformViewId.longValue(), paramInt);
  }
  
  @UiThread
  public void setLocalizationPlugin(@Nullable LocalizationPlugin paramLocalizationPlugin)
  {
    ensureRunningOnMainThread();
    this.localizationPlugin = paramLocalizationPlugin;
  }
  
  @UiThread
  public void setPlatformMessageHandler(@Nullable PlatformMessageHandler paramPlatformMessageHandler)
  {
    ensureRunningOnMainThread();
    this.platformMessageHandler = paramPlatformMessageHandler;
  }
  
  @UiThread
  public void setPlatformViewsController(@NonNull PlatformViewsController paramPlatformViewsController)
  {
    ensureRunningOnMainThread();
    this.platformViewsController = paramPlatformViewsController;
  }
  
  @UiThread
  public void setSemanticsEnabled(boolean paramBoolean)
  {
    ensureRunningOnMainThread();
    ensureAttachedToNative();
    nativeSetSemanticsEnabled(this.nativePlatformViewId.longValue(), paramBoolean);
  }
  
  @UiThread
  public void setViewportMetrics(float paramFloat, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, int paramInt11, int paramInt12, int paramInt13, int paramInt14)
  {
    ensureRunningOnMainThread();
    ensureAttachedToNative();
    nativeSetViewportMetrics(this.nativePlatformViewId.longValue(), paramFloat, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramInt10, paramInt11, paramInt12, paramInt13, paramInt14);
  }
  
  @UiThread
  public void unregisterTexture(long paramLong)
  {
    ensureRunningOnMainThread();
    ensureAttachedToNative();
    nativeUnregisterTexture(this.nativePlatformViewId.longValue(), paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     io.flutter.embedding.engine.FlutterJNI
 * JD-Core Version:    0.7.0.1
 */