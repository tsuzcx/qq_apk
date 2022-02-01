package com.tencent.smtt.sdk;

import android.os.Build.VERSION;

class k$1
  extends com.tencent.smtt.export.external.interfaces.ServiceWorkerWebSettings
{
  k$1(k paramk, android.webkit.ServiceWorkerWebSettings paramServiceWorkerWebSettings) {}
  
  public boolean getAllowContentAccess()
  {
    if (Build.VERSION.SDK_INT >= 24) {
      return this.a.getAllowContentAccess();
    }
    return false;
  }
  
  public boolean getAllowFileAccess()
  {
    if (Build.VERSION.SDK_INT >= 24) {
      return this.a.getAllowFileAccess();
    }
    return false;
  }
  
  public boolean getBlockNetworkLoads()
  {
    if (Build.VERSION.SDK_INT >= 24) {
      return this.a.getBlockNetworkLoads();
    }
    return false;
  }
  
  public int getCacheMode()
  {
    if (Build.VERSION.SDK_INT >= 24) {
      return this.a.getCacheMode();
    }
    return -1;
  }
  
  public void setAllowContentAccess(boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT >= 24) {
      this.a.setAllowContentAccess(paramBoolean);
    }
  }
  
  public void setAllowFileAccess(boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT >= 24) {
      this.a.setAllowContentAccess(paramBoolean);
    }
  }
  
  public void setBlockNetworkLoads(boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT >= 24) {
      this.a.setBlockNetworkLoads(paramBoolean);
    }
  }
  
  public void setCacheMode(int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 24) {
      this.a.setCacheMode(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.smtt.sdk.k.1
 * JD-Core Version:    0.7.0.1
 */