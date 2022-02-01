package com.tencent.smtt.sdk;

import java.security.Principal;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;

class SystemWebViewClient$a
  extends com.tencent.smtt.export.external.interfaces.ClientCertRequest
{
  private android.webkit.ClientCertRequest a;
  
  public SystemWebViewClient$a(android.webkit.ClientCertRequest paramClientCertRequest)
  {
    this.a = paramClientCertRequest;
  }
  
  public void cancel()
  {
    this.a.cancel();
  }
  
  public String getHost()
  {
    return this.a.getHost();
  }
  
  public String[] getKeyTypes()
  {
    return this.a.getKeyTypes();
  }
  
  public int getPort()
  {
    return this.a.getPort();
  }
  
  public Principal[] getPrincipals()
  {
    return this.a.getPrincipals();
  }
  
  public void ignore()
  {
    this.a.ignore();
  }
  
  public void proceed(PrivateKey paramPrivateKey, X509Certificate[] paramArrayOfX509Certificate)
  {
    this.a.proceed(paramPrivateKey, paramArrayOfX509Certificate);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.smtt.sdk.SystemWebViewClient.a
 * JD-Core Version:    0.7.0.1
 */