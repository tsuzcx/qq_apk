package io.flutter.embedding.engine.dart;

import android.content.res.AssetManager;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.UiThread;
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
  private final FlutterJNI flutterJNI;
  private boolean isApplicationRunning = false;
  private final BinaryMessenger.BinaryMessageHandler isolateChannelMessageHandler = new DartExecutor.1(this);
  @Nullable
  private String isolateServiceId;
  @Nullable
  private DartExecutor.IsolateServiceIdListener isolateServiceIdListener;
  @NonNull
  private final DartMessenger messenger;
  
  public DartExecutor(@NonNull FlutterJNI paramFlutterJNI, @NonNull AssetManager paramAssetManager)
  {
    this.flutterJNI = paramFlutterJNI;
    this.assetManager = paramAssetManager;
    this.messenger = new DartMessenger(paramFlutterJNI);
    this.messenger.setMessageHandler("flutter/isolate", this.isolateChannelMessageHandler);
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
  
  @Nullable
  public String getIsolateServiceId()
  {
    return this.isolateServiceId;
  }
  
  @UiThread
  public int getPendingChannelResponseCount()
  {
    return this.messenger.getPendingChannelResponseCount();
  }
  
  public boolean isExecutingDart()
  {
    return this.isApplicationRunning;
  }
  
  public void onAttachedToJNI()
  {
    Log.v("DartExecutor", "Attached to JNI. Registering the platform message handler for this Dart execution context.");
    this.flutterJNI.setPlatformMessageHandler(this.messenger);
  }
  
  public void onDetachedFromJNI()
  {
    Log.v("DartExecutor", "Detached from JNI. De-registering the platform message handler for this Dart execution context.");
    this.flutterJNI.setPlatformMessageHandler(null);
  }
  
  @UiThread
  public void send(@NonNull String paramString, @Nullable ByteBuffer paramByteBuffer)
  {
    this.messenger.send(paramString, paramByteBuffer, null);
  }
  
  @UiThread
  public void send(@NonNull String paramString, @Nullable ByteBuffer paramByteBuffer, @Nullable BinaryMessenger.BinaryReply paramBinaryReply)
  {
    this.messenger.send(paramString, paramByteBuffer, paramBinaryReply);
  }
  
  public void setIsolateServiceIdListener(@Nullable DartExecutor.IsolateServiceIdListener paramIsolateServiceIdListener)
  {
    this.isolateServiceIdListener = paramIsolateServiceIdListener;
    if ((this.isolateServiceIdListener != null) && (this.isolateServiceId != null)) {
      this.isolateServiceIdListener.onIsolateServiceIdAvailable(this.isolateServiceId);
    }
  }
  
  @UiThread
  public void setMessageHandler(@NonNull String paramString, @Nullable BinaryMessenger.BinaryMessageHandler paramBinaryMessageHandler)
  {
    this.messenger.setMessageHandler(paramString, paramBinaryMessageHandler);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     io.flutter.embedding.engine.dart.DartExecutor
 * JD-Core Version:    0.7.0.1
 */