package com.tencent.smtt.sdk;

import java.security.Principal;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;

class SystemWebViewClient$ClientCertRequestImpl
  extends com.tencent.smtt.export.external.interfaces.ClientCertRequest
{
  private android.webkit.ClientCertRequest mClientCertRequest;
  
  public SystemWebViewClient$ClientCertRequestImpl(android.webkit.ClientCertRequest paramClientCertRequest)
  {
    this.mClientCertRequest = paramClientCertRequest;
  }
  
  public void cancel()
  {
    this.mClientCertRequest.cancel();
  }
  
  public String getHost()
  {
    return this.mClientCertRequest.getHost();
  }
  
  public String[] getKeyTypes()
  {
    return this.mClientCertRequest.getKeyTypes();
  }
  
  public int getPort()
  {
    return this.mClientCertRequest.getPort();
  }
  
  public Principal[] getPrincipals()
  {
    return this.mClientCertRequest.getPrincipals();
  }
  
  public void ignore()
  {
    this.mClientCertRequest.ignore();
  }
  
  public void proceed(PrivateKey paramPrivateKey, X509Certificate[] paramArrayOfX509Certificate)
  {
    this.mClientCertRequest.proceed(paramPrivateKey, paramArrayOfX509Certificate);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.smtt.sdk.SystemWebViewClient.ClientCertRequestImpl
 * JD-Core Version:    0.7.0.1
 */