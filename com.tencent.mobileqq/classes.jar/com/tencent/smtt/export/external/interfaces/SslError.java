package com.tencent.smtt.export.external.interfaces;

import android.net.http.SslCertificate;

public abstract interface SslError
{
  public abstract boolean addError(int paramInt);
  
  public abstract SslCertificate getCertificate();
  
  public abstract int getPrimaryError();
  
  public abstract String getUrl();
  
  public abstract boolean hasError(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.smtt.export.external.interfaces.SslError
 * JD-Core Version:    0.7.0.1
 */