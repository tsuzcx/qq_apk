package io.flutter.embedding.engine.dart;

import android.content.res.AssetManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import io.flutter.Log;
import io.flutter.embedding.engine.FlutterJNI;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.BinaryMessenger.BinaryMessageHandler;
import io.flutter.plugin.common.BinaryMessenger.BinaryReply;
import io.flutter.view.FlutterCallbackInformation;
import java.nio.ByteBuffer;

public class DartExecutor
  implements BinaryMessenger
{
  private static final String TAG = "DartExecutor";
  @NonNull
  private final AssetManager assetManager;
  @NonNull
  private final BinaryMessenger binaryMessenger;
  @NonNull
  private final DartMessenger dartMessenger;
  @NonNull
  private final FlutterJNI flutterJNI;
  private boolean isApplicationRunning = false;
  private final BinaryMessenger.BinaryMessageHandler isolateChannelMessageHandler = new DartExecutor.1(this);
  @Nullable
  private String isolateServiceId;
  @Nullable
  private DartExecutor.IsolateServiceIdListener isolateServiceIdListener;
  
  public DartExecutor(@NonNull FlutterJNI paramFlutterJNI, @NonNull AssetManager paramAssetManager)
  {
    this.flutterJNI = paramFlutterJNI;
    this.assetManager = paramAssetManager;
    this.dartMessenger = new DartMessenger(paramFlutterJNI);
    this.dartMessenger.setMessageHandler("flutter/isolate", this.isolateChannelMessageHandler);
    this.binaryMessenger = new DartExecutor.DefaultBinaryMessenger(this.dartMessenger, null);
  }
  
  public void executeDartCallback(@NonNull DartExecutor.DartCallback paramDartCallback)
  {
    if (this.isApplicationRunning)
    {
      Log.w("DartExecutor", "Attempted to run a DartExecutor that is already running.");
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Executing Dart callback: ");
    localStringBuilder.append(paramDartCallback);
    Log.v("DartExecutor", localStringBuilder.toString());
    this.flutterJNI.runBundleAndSnapshotFromLibrary(paramDartCallback.pathToBundle, paramDartCallback.callbackHandle.callbackName, paramDartCallback.callbackHandle.callbackLibraryPath, paramDartCallback.androidAssetManager);
    this.isApplicationRunning = true;
  }
  
  public void executeDartEntrypoint(@NonNull DartExecutor.DartEntrypoint paramDartEntrypoint)
  {
    if (this.isApplicationRunning)
    {
      Log.w("DartExecutor", "Attempted to run a DartExecutor that is already running.");
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Executing Dart entrypoint: ");
    localStringBuilder.append(paramDartEntrypoint);
    Log.v("DartExecutor", localStringBuilder.toString());
    this.flutterJNI.runBundleAndSnapshotFromLibrary(paramDartEntrypoint.pathToBundle, paramDartEntrypoint.dartEntrypointFunctionName, null, this.assetManager);
    this.isApplicationRunning = true;
  }
  
  @NonNull
  public BinaryMessenger getBinaryMessenger()
  {
    return this.binaryMessenger;
  }
  
  @Nullable
  public String getIsolateServiceId()
  {
    return this.isolateServiceId;
  }
  
  @UiThread
  public int getPendingChannelResponseCount()
  {
    return this.dartMessenger.getPendingChannelResponseCount();
  }
  
  public boolean isExecutingDart()
  {
    return this.isApplicationRunning;
  }
  
  public void notifyLowMemoryWarning()
  {
    if (this.flutterJNI.isAttached()) {
      this.flutterJNI.notifyLowMemoryWarning();
    }
  }
  
  public void onAttachedToJNI()
  {
    Log.v("DartExecutor", "Attached to JNI. Registering the platform message handler for this Dart execution context.");
    this.flutterJNI.setPlatformMessageHandler(this.dartMessenger);
  }
  
  public void onDetachedFromJNI()
  {
    Log.v("DartExecutor", "Detached from JNI. De-registering the platform message handler for this Dart execution context.");
    this.flutterJNI.setPlatformMessageHandler(null);
  }
  
  @Deprecated
  @UiThread
  public void send(@NonNull String paramString, @Nullable ByteBuffer paramByteBuffer)
  {
    this.binaryMessenger.send(paramString, paramByteBuffer);
  }
  
  @Deprecated
  @UiThread
  public void send(@NonNull String paramString, @Nullable ByteBuffer paramByteBuffer, @Nullable BinaryMessenger.BinaryReply paramBinaryReply)
  {
    this.binaryMessenger.send(paramString, paramByteBuffer, paramBinaryReply);
  }
  
  public void setIsolateServiceIdListener(@Nullable DartExecutor.IsolateServiceIdListener paramIsolateServiceIdListener)
  {
    this.isolateServiceIdListener = paramIsolateServiceIdListener;
    paramIsolateServiceIdListener = this.isolateServiceIdListener;
    if (paramIsolateServiceIdListener != null)
    {
      String str = this.isolateServiceId;
      if (str != null) {
        paramIsolateServiceIdListener.onIsolateServiceIdAvailable(str);
      }
    }
  }
  
  @Deprecated
  @UiThread
  public void setMessageHandler(@NonNull String paramString, @Nullable BinaryMessenger.BinaryMessageHandler paramBinaryMessageHandler)
  {
    this.binaryMessenger.setMessageHandler(paramString, paramBinaryMessageHandler);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     io.flutter.embedding.engine.dart.DartExecutor
 * JD-Core Version:    0.7.0.1
 */