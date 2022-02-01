package com.tencent.superplayer.bandwidth;

import android.net.ConnectivityManager.NetworkCallback;
import android.net.Network;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;

@RequiresApi(21)
final class SPBandwidthPredictor$NetworkCallbackImpl
  extends ConnectivityManager.NetworkCallback
{
  private SPBandwidthPredictor$NetworkCallbackImpl(SPBandwidthPredictor paramSPBandwidthPredictor) {}
  
  public void onAvailable(@Nullable Network paramNetwork)
  {
    SPBandwidthPredictor.access$300(this.this$0).post(new SPBandwidthPredictor.NetworkCallbackImpl.1(this));
  }
  
  public void onLost(@Nullable Network paramNetwork)
  {
    SPBandwidthPredictor.access$300(this.this$0).post(new SPBandwidthPredictor.NetworkCallbackImpl.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.superplayer.bandwidth.SPBandwidthPredictor.NetworkCallbackImpl
 * JD-Core Version:    0.7.0.1
 */