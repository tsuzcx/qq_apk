package com.tencent.smtt.sdk;

import android.net.http.SslCertificate;

class SystemWebViewClient$d
  implements com.tencent.smtt.export.external.interfaces.SslError
{
  android.net.http.SslError a;
  
  SystemWebViewClient$d(android.net.http.SslError paramSslError)
  {
    this.a = paramSslError;
  }
  
  public boolean addError(int paramInt)
  {
    return this.a.addError(paramInt);
  }
  
  public SslCertificate getCertificate()
  {
    return this.a.getCertificate();
  }
  
  public int getPrimaryError()
  {
    return this.a.getPrimaryError();
  }
  
  public String getUrl()
  {
    return this.a.getUrl();
  }
  
  public boolean hasError(int paramInt)
  {
    return this.a.hasError(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.smtt.sdk.SystemWebViewClient.d
 * JD-Core Version:    0.7.0.1
 */