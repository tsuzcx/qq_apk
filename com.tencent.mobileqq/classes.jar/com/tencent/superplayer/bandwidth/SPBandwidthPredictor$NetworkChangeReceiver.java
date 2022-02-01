package com.tencent.superplayer.bandwidth;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.support.annotation.NonNull;

final class SPBandwidthPredictor$NetworkChangeReceiver
  extends BroadcastReceiver
{
  private SPBandwidthPredictor$NetworkChangeReceiver(SPBandwidthPredictor paramSPBandwidthPredictor) {}
  
  public void onReceive(@NonNull Context paramContext, @NonNull Intent paramIntent)
  {
    SPBandwidthPredictor.access$300(this.this$0).post(new SPBandwidthPredictor.NetworkChangeReceiver.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.superplayer.bandwidth.SPBandwidthPredictor.NetworkChangeReceiver
 * JD-Core Version:    0.7.0.1
 */