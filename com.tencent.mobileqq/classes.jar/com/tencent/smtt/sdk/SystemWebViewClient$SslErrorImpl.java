package com.tencent.smtt.sdk;

import android.net.http.SslCertificate;

class SystemWebViewClient$SslErrorImpl
  implements com.tencent.smtt.export.external.interfaces.SslError
{
  android.net.http.SslError mSslError;
  
  SystemWebViewClient$SslErrorImpl(android.net.http.SslError paramSslError)
  {
    this.mSslError = paramSslError;
  }
  
  public boolean addError(int paramInt)
  {
    return this.mSslError.addError(paramInt);
  }
  
  public SslCertificate getCertificate()
  {
    return this.mSslError.getCertificate();
  }
  
  public int getPrimaryError()
  {
    return this.mSslError.getPrimaryError();
  }
  
  public String getUrl()
  {
    return this.mSslError.getUrl();
  }
  
  public boolean hasError(int paramInt)
  {
    return this.mSslError.hasError(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.smtt.sdk.SystemWebViewClient.SslErrorImpl
 * JD-Core Version:    0.7.0.1
 */