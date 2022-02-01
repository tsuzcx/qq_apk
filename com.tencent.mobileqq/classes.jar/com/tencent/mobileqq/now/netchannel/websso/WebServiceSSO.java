package com.tencent.mobileqq.now.netchannel.websso;

import java.util.concurrent.TimeUnit;
import okhttp3.ConnectionPool;
import okhttp3.Dispatcher;
import okhttp3.OkHttpClient;
import okhttp3.OkHttpClient.Builder;

public class WebServiceSSO
{
  private final String a;
  private final WebServiceSSO.WebServiceSSOSender b = new WebServiceSSO.WebServiceSSOSender(this);
  private boolean c;
  private Dispatcher d;
  private ConnectionPool e;
  private OkHttpClient f;
  
  public WebServiceSSO(int paramInt1, int paramInt2, String paramString1, long paramLong, String paramString2, int paramInt3)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("?SdkAppId=");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append("&AccountType=");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append("&AppIdAt3rd=");
    localStringBuilder.append(paramString1);
    localStringBuilder.append("&Identifier=");
    localStringBuilder.append(paramLong);
    localStringBuilder.append("&UserSig=");
    localStringBuilder.append(paramString2);
    localStringBuilder.append("&Apn=");
    localStringBuilder.append(paramInt3);
    localStringBuilder.append("&ContentType=binary");
    this.a = localStringBuilder.toString();
    this.e = new ConnectionPool(5, 20L, TimeUnit.SECONDS);
    this.d = new Dispatcher();
    this.d.setMaxRequests(20);
    this.d.setMaxRequestsPerHost(4);
    this.f = new OkHttpClient.Builder().connectTimeout(10000L, TimeUnit.MILLISECONDS).readTimeout(10000L, TimeUnit.MILLISECONDS).writeTimeout(10000L, TimeUnit.MILLISECONDS).connectionPool(this.e).dispatcher(this.d).build();
  }
  
  public void a(String paramString, byte[] paramArrayOfByte, SSOCallback paramSSOCallback)
  {
    this.b.a(paramString, paramArrayOfByte, paramSSOCallback);
  }
  
  public void a(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }
  
  public boolean a()
  {
    return this.c;
  }
  
  public void b()
  {
    this.b.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.now.netchannel.websso.WebServiceSSO
 * JD-Core Version:    0.7.0.1
 */