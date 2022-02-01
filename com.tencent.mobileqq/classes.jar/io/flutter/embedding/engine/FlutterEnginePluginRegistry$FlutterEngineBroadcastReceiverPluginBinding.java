package io.flutter.embedding.engine;

import android.content.BroadcastReceiver;
import androidx.annotation.NonNull;
import io.flutter.embedding.engine.plugins.broadcastreceiver.BroadcastReceiverPluginBinding;

class FlutterEnginePluginRegistry$FlutterEngineBroadcastReceiverPluginBinding
  implements BroadcastReceiverPluginBinding
{
  @NonNull
  private final BroadcastReceiver broadcastReceiver;
  
  FlutterEnginePluginRegistry$FlutterEngineBroadcastReceiverPluginBinding(@NonNull BroadcastReceiver paramBroadcastReceiver)
  {
    this.broadcastReceiver = paramBroadcastReceiver;
  }
  
  @NonNull
  public BroadcastReceiver getBroadcastReceiver()
  {
    return this.broadcastReceiver;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     io.flutter.embedding.engine.FlutterEnginePluginRegistry.FlutterEngineBroadcastReceiverPluginBinding
 * JD-Core Version:    0.7.0.1
 */