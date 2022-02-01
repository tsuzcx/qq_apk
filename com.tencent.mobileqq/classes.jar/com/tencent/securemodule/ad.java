package com.tencent.securemodule;

import android.os.Bundle;
import org.apache.http.HttpHost;
import org.apache.http.client.HttpClient;
import org.apache.http.client.params.HttpClientParams;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

public class ad
{
  protected HttpParams a = null;
  protected ad.a b = null;
  private boolean c = false;
  private String d = null;
  private int e = 0;
  
  protected HttpClient a()
  {
    if (this.a == null) {
      this.a = new BasicHttpParams();
    }
    HttpConnectionParams.setConnectionTimeout(this.a, 10000);
    HttpConnectionParams.setSoTimeout(this.a, 20000);
    HttpConnectionParams.setSocketBufferSize(this.a, 4096);
    HttpClientParams.setRedirecting(this.a, true);
    DefaultHttpClient localDefaultHttpClient = new DefaultHttpClient(this.a);
    if (this.c)
    {
      HttpHost localHttpHost = new HttpHost(this.d, this.e);
      localDefaultHttpClient.getParams().setParameter("http.route.default-proxy", localHttpHost);
    }
    return localDefaultHttpClient;
  }
  
  protected void a(int paramInt, Bundle paramBundle)
  {
    ad.a locala = this.b;
    if (locala != null)
    {
      if (paramInt == 1)
      {
        locala.b(paramBundle);
        return;
      }
      if (paramInt == 2) {
        locala.a(paramBundle);
      }
    }
  }
  
  public void a(ad.a parama)
  {
    this.b = parama;
  }
  
  public void a(String paramString, int paramInt)
  {
    this.d = paramString;
    this.e = paramInt;
  }
  
  public void a(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.securemodule.ad
 * JD-Core Version:    0.7.0.1
 */