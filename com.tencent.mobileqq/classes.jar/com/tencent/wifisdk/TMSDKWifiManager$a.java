package com.tencent.wifisdk;

import com.tencent.qqpimsecure.wificore.api.event.CurrentSessionItem;
import java.util.Iterator;
import java.util.Set;
import wf7.bn;
import wf7.fo;
import wf7.hm;

class TMSDKWifiManager$a
  implements fo
{
  private TMSDKWifiManager$a(TMSDKWifiManager paramTMSDKWifiManager) {}
  
  public void a(int paramInt, CurrentSessionItem paramCurrentSessionItem)
  {
    paramCurrentSessionItem = hm.g(paramCurrentSessionItem);
    if (paramCurrentSessionItem != null) {}
    for (paramCurrentSessionItem = hm.x(paramCurrentSessionItem);; paramCurrentSessionItem = null)
    {
      Iterator localIterator = TMSDKWifiManager.c(this.qs).iterator();
      while (localIterator.hasNext()) {
        ((TMSDKWifiEventListener)localIterator.next()).onConnectionStateChanged(paramInt, paramCurrentSessionItem);
      }
      return;
    }
  }
  
  public void d(CurrentSessionItem paramCurrentSessionItem)
  {
    paramCurrentSessionItem = hm.h(paramCurrentSessionItem);
    Iterator localIterator = TMSDKWifiManager.c(this.qs).iterator();
    while (localIterator.hasNext()) {
      ((TMSDKWifiEventListener)localIterator.next()).onConnectionSuccess(paramCurrentSessionItem);
    }
  }
  
  public void onConnectionFailed(int paramInt)
  {
    Iterator localIterator = TMSDKWifiManager.c(this.qs).iterator();
    while (localIterator.hasNext()) {
      ((TMSDKWifiEventListener)localIterator.next()).onConnectionFailed(paramInt);
    }
  }
  
  public void onGPSDisabled()
  {
    Iterator localIterator = TMSDKWifiManager.c(this.qs).iterator();
    while (localIterator.hasNext()) {
      ((TMSDKWifiEventListener)localIterator.next()).onGPSDisabled();
    }
  }
  
  public void onGPSEnabled()
  {
    Iterator localIterator = TMSDKWifiManager.c(this.qs).iterator();
    while (localIterator.hasNext()) {
      ((TMSDKWifiEventListener)localIterator.next()).onGPSEnabled();
    }
  }
  
  public void onWifiDisabled()
  {
    Iterator localIterator = TMSDKWifiManager.c(this.qs).iterator();
    while (localIterator.hasNext()) {
      ((TMSDKWifiEventListener)localIterator.next()).onWifiDisabled();
    }
  }
  
  public void onWifiEnabled()
  {
    Iterator localIterator = TMSDKWifiManager.c(this.qs).iterator();
    while (localIterator.hasNext()) {
      ((TMSDKWifiEventListener)localIterator.next()).onWifiEnabled();
    }
  }
  
  public void t(bn parambn)
  {
    parambn = hm.x(parambn);
    Iterator localIterator = TMSDKWifiManager.c(this.qs).iterator();
    while (localIterator.hasNext()) {
      ((TMSDKWifiEventListener)localIterator.next()).onConnectionStart(parambn);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.wifisdk.TMSDKWifiManager.a
 * JD-Core Version:    0.7.0.1
 */