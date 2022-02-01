package com.tencent.smtt.sdk;

import com.tencent.smtt.export.external.interfaces.IX5CoreServiceWorkerController;
import com.tencent.smtt.export.external.interfaces.ServiceWorkerClient;
import com.tencent.smtt.export.external.interfaces.ServiceWorkerWebSettings;

final class ServiceWorkerController$1
  extends ServiceWorkerController
{
  ServiceWorkerController$1(IX5CoreServiceWorkerController paramIX5CoreServiceWorkerController) {}
  
  public ServiceWorkerWebSettings getServiceWorkerWebSettings()
  {
    return this.a.getServiceWorkerWebSettings();
  }
  
  public void setServiceWorkerClient(ServiceWorkerClient paramServiceWorkerClient)
  {
    this.a.setServiceWorkerClient(paramServiceWorkerClient);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.smtt.sdk.ServiceWorkerController.1
 * JD-Core Version:    0.7.0.1
 */