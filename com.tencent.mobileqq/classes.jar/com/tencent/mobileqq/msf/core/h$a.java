package com.tencent.mobileqq.msf.core;

import android.net.LinkProperties;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.os.Handler;
import com.tencent.mobileqq.msf.core.net.l.a;

class h$a
  extends l.a
{
  h$a(h paramh) {}
  
  public void a(int paramInt) {}
  
  public void b(int paramInt)
  {
    this.a.b = null;
  }
  
  public void onAvailable(Network paramNetwork)
  {
    h.a(this.a, false);
    this.a.b = paramNetwork;
    h.d(this.a).removeMessages(1);
    paramNetwork = h.d(this.a).obtainMessage(2);
    h.d(this.a).sendMessageAtFrontOfQueue(paramNetwork);
  }
  
  public void onCapabilitiesChanged(Network paramNetwork, NetworkCapabilities paramNetworkCapabilities) {}
  
  public void onLinkPropertiesChanged(Network paramNetwork, LinkProperties paramLinkProperties) {}
  
  public void onLosing(Network paramNetwork, int paramInt) {}
  
  public void onLost(Network paramNetwork) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.h.a
 * JD-Core Version:    0.7.0.1
 */