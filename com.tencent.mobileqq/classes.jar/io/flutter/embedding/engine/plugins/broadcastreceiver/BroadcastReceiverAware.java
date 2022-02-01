package io.flutter.embedding.engine.plugins.broadcastreceiver;

import androidx.annotation.NonNull;

public abstract interface BroadcastReceiverAware
{
  public abstract void onAttachedToBroadcastReceiver(@NonNull BroadcastReceiverPluginBinding paramBroadcastReceiverPluginBinding);
  
  public abstract void onDetachedFromBroadcastReceiver();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     io.flutter.embedding.engine.plugins.broadcastreceiver.BroadcastReceiverAware
 * JD-Core Version:    0.7.0.1
 */