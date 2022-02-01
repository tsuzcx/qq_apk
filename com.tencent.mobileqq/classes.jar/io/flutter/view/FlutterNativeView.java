package io.flutter.view;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.UiThread;
import io.flutter.app.FlutterPluginRegistry;
import io.flutter.embedding.engine.FlutterJNI;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.embedding.engine.renderer.FlutterUiDisplayListener;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.BinaryMessenger.BinaryMessageHandler;
import io.flutter.plugin.common.BinaryMessenger.BinaryReply;
import java.nio.ByteBuffer;

public class FlutterNativeView
  implements BinaryMessenger
{
  private static final String TAG = "FlutterNativeView";
  private boolean applicationIsRunning;
  private final DartExecutor dartExecutor;
  private final FlutterUiDisplayListener flutterUiDisplayListener = new FlutterNativeView.1(this);
  private final Context mContext;
  private final FlutterJNI mFlutterJNI;
  private FlutterView mFlutterView;
  private final FlutterPluginRegistry mPluginRegistry;
  
  public FlutterNativeView(@NonNull Context paramContext)
  {
    this(paramContext, false);
  }
  
  public FlutterNativeView(@NonNull Context paramContext, boolean paramBoolean)
  {
    this.mContext = paramContext;
    this.mPluginRegistry = new FlutterPluginRegistry(this, paramContext);
    this.mFlutterJNI = new FlutterJNI();
    this.mFlutterJNI.addIsDisplayingFlutterUiListener(this.flutterUiDisplayListener);
    this.dartExecutor = new DartExecutor(this.mFlutterJNI, paramContext.getAssets());
    this.mFlutterJNI.addEngineLifecycleListener(new FlutterNativeView.EngineLifecycleListenerImpl(this, null));
    attach(this, paramBoolean);
    assertAttached();
  }
  
  private void attach(FlutterNativeView paramFlutterNativeView, boolean paramBoolean)
  {
    this.mFlutterJNI.attachToNative(paramBoolean);
    this.dartExecutor.onAttachedToJNI();
  }
  
  public static String getObservatoryUri()
  {
    return FlutterJNI.getObservatoryUri();
  }
  
  public void assertAttached()
  {
    if (isAttached()) {
      return;
    }
    throw new AssertionError("Platform view is not attached");
  }
  
  public void attachViewAndActivity(FlutterView paramFlutterView, Activity paramActivity)
  {
    this.mFlutterView = paramFlutterView;
    this.mPluginRegistry.attach(paramFlutterView, paramActivity);
  }
  
  public void destroy()
  {
    this.mPluginRegistry.destroy();
    this.dartExecutor.onDetachedFromJNI();
    this.mFlutterView = null;
    this.mFlutterJNI.removeIsDisplayingFlutterUiListener(this.flutterUiDisplayListener);
    this.mFlutterJNI.detachFromNativeAndReleaseResources();
    this.applicationIsRunning = false;
  }
  
  public void detachFromFlutterView()
  {
    this.mPluginRegistry.detach();
    this.mFlutterView = null;
  }
  
  @NonNull
  public DartExecutor getDartExecutor()
  {
    return this.dartExecutor;
  }
  
  FlutterJNI getFlutterJNI()
  {
    return this.mFlutterJNI;
  }
  
  @NonNull
  public FlutterPluginRegistry getPluginRegistry()
  {
    return this.mPluginRegistry;
  }
  
  public boolean isApplicationRunning()
  {
    return this.applicationIsRunning;
  }
  
  public boolean isAttached()
  {
    return this.mFlutterJNI.isAttached();
  }
  
  public void runFromBundle(FlutterRunArguments paramFlutterRunArguments)
  {
    if (paramFlutterRunArguments.entrypoint != null)
    {
      assertAttached();
      if (!this.applicationIsRunning)
      {
        this.mFlutterJNI.runBundleAndSnapshotFromLibrary(paramFlutterRunArguments.bundlePath, paramFlutterRunArguments.entrypoint, paramFlutterRunArguments.libraryPath, this.mContext.getResources().getAssets());
        this.applicationIsRunning = true;
        return;
      }
      throw new AssertionError("This Flutter engine instance is already running an application");
    }
    throw new AssertionError("An entrypoint must be specified");
  }
  
  @UiThread
  public void send(String paramString, ByteBuffer paramByteBuffer)
  {
    this.dartExecutor.getBinaryMessenger().send(paramString, paramByteBuffer);
  }
  
  @UiThread
  public void send(String paramString, ByteBuffer paramByteBuffer, BinaryMessenger.BinaryReply paramBinaryReply)
  {
    if (!isAttached())
    {
      paramByteBuffer = new StringBuilder();
      paramByteBuffer.append("FlutterView.send called on a detached view, channel=");
      paramByteBuffer.append(paramString);
      Log.d("FlutterNativeView", paramByteBuffer.toString());
      return;
    }
    this.dartExecutor.getBinaryMessenger().send(paramString, paramByteBuffer, paramBinaryReply);
  }
  
  @UiThread
  public void setMessageHandler(String paramString, BinaryMessenger.BinaryMessageHandler paramBinaryMessageHandler)
  {
    this.dartExecutor.getBinaryMessenger().setMessageHandler(paramString, paramBinaryMessageHandler);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     io.flutter.view.FlutterNativeView
 * JD-Core Version:    0.7.0.1
 */