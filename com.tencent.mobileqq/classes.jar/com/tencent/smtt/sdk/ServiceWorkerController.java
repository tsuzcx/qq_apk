package com.tencent.smtt.sdk;

import android.content.Context;
import android.os.Build.VERSION;
import com.tencent.smtt.export.external.interfaces.ServiceWorkerClient;
import com.tencent.smtt.export.external.interfaces.ServiceWorkerWebSettings;

public abstract class ServiceWorkerController
{
  public static ServiceWorkerController getInstance(Context paramContext)
  {
    x localx = x.a();
    localx.a(paramContext, null);
    if (localx.b())
    {
      paramContext = x.a().c().p();
      if (paramContext != null) {
        return new ServiceWorkerController.1(paramContext);
      }
      return null;
    }
    if (Build.VERSION.SDK_INT >= 24) {
      return new k();
    }
    return null;
  }
  
  public abstract ServiceWorkerWebSettings getServiceWorkerWebSettings();
  
  public abstract void setServiceWorkerClient(ServiceWorkerClient paramServiceWorkerClient);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.smtt.sdk.ServiceWorkerController
 * JD-Core Version:    0.7.0.1
 */