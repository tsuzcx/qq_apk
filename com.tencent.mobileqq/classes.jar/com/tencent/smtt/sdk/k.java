package com.tencent.smtt.sdk;

import android.os.Build.VERSION;
import com.tencent.smtt.export.external.interfaces.ServiceWorkerClient;
import com.tencent.smtt.export.external.interfaces.ServiceWorkerWebSettings;

public class k
  extends ServiceWorkerController
{
  public ServiceWorkerWebSettings getServiceWorkerWebSettings()
  {
    if (Build.VERSION.SDK_INT < 24) {
      return null;
    }
    return new k.1(this, android.webkit.ServiceWorkerController.getInstance().getServiceWorkerWebSettings());
  }
  
  public void setServiceWorkerClient(ServiceWorkerClient paramServiceWorkerClient)
  {
    if (Build.VERSION.SDK_INT >= 24) {
      android.webkit.ServiceWorkerController.getInstance().setServiceWorkerClient(new k.2(this, paramServiceWorkerClient));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.smtt.sdk.k
 * JD-Core Version:    0.7.0.1
 */