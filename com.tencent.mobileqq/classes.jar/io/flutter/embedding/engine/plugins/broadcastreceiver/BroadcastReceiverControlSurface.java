package io.flutter.embedding.engine.plugins.broadcastreceiver;

import android.content.BroadcastReceiver;
import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;

public abstract interface BroadcastReceiverControlSurface
{
  public abstract void attachToBroadcastReceiver(@NonNull BroadcastReceiver paramBroadcastReceiver, @NonNull Lifecycle paramLifecycle);
  
  public abstract void detachFromBroadcastReceiver();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     io.flutter.embedding.engine.plugins.broadcastreceiver.BroadcastReceiverControlSurface
 * JD-Core Version:    0.7.0.1
 */