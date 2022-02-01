package io.flutter.embedding.engine.systemchannels;

import androidx.annotation.NonNull;
import io.flutter.Log;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugin.common.StringCodec;

public class LifecycleChannel
{
  private static final String TAG = "LifecycleChannel";
  @NonNull
  public final BasicMessageChannel<String> channel;
  
  public LifecycleChannel(@NonNull DartExecutor paramDartExecutor)
  {
    this.channel = new BasicMessageChannel(paramDartExecutor, "flutter/lifecycle", StringCodec.INSTANCE);
  }
  
  public void appIsDetached()
  {
    Log.v("LifecycleChannel", "Sending AppLifecycleState.detached message.");
    this.channel.send("AppLifecycleState.detached");
  }
  
  public void appIsInactive()
  {
    Log.v("LifecycleChannel", "Sending AppLifecycleState.inactive message.");
    this.channel.send("AppLifecycleState.inactive");
  }
  
  public void appIsPaused()
  {
    Log.v("LifecycleChannel", "Sending AppLifecycleState.paused message.");
    this.channel.send("AppLifecycleState.paused");
  }
  
  public void appIsResumed()
  {
    Log.v("LifecycleChannel", "Sending AppLifecycleState.resumed message.");
    this.channel.send("AppLifecycleState.resumed");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     io.flutter.embedding.engine.systemchannels.LifecycleChannel
 * JD-Core Version:    0.7.0.1
 */