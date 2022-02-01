package com.tencent.mobileqq.now.netchannel.websso;

import java.util.concurrent.TimeUnit;
import okhttp3.ConnectionPool;
import okhttp3.Dispatcher;
import okhttp3.OkHttpClient;
import okhttp3.OkHttpClient.Builder;

public class WebServiceSSO
{
  private final WebServiceSSO.WebServiceSSOSender jdField_a_of_type_ComTencentMobileqqNowNetchannelWebssoWebServiceSSO$WebServiceSSOSender = new WebServiceSSO.WebServiceSSOSender(this);
  private final String jdField_a_of_type_JavaLangString;
  private ConnectionPool jdField_a_of_type_Okhttp3ConnectionPool;
  private Dispatcher jdField_a_of_type_Okhttp3Dispatcher;
  private OkHttpClient jdField_a_of_type_Okhttp3OkHttpClient;
  private boolean jdField_a_of_type_Boolean;
  
  public WebServiceSSO(int paramInt1, int paramInt2, String paramString1, long paramLong, String paramString2, int paramInt3)
  {
    this.jdField_a_of_type_JavaLangString = ("?SdkAppId=" + paramInt1 + "&AccountType=" + paramInt2 + "&AppIdAt3rd=" + paramString1 + "&Identifier=" + paramLong + "&UserSig=" + paramString2 + "&Apn=" + paramInt3 + "&ContentType=binary");
    this.jdField_a_of_type_Okhttp3ConnectionPool = new ConnectionPool(5, 20L, TimeUnit.SECONDS);
    this.jdField_a_of_type_Okhttp3Dispatcher = new Dispatcher();
    this.jdField_a_of_type_Okhttp3Dispatcher.setMaxRequests(20);
    this.jdField_a_of_type_Okhttp3Dispatcher.setMaxRequestsPerHost(4);
    this.jdField_a_of_type_Okhttp3OkHttpClient = new OkHttpClient.Builder().connectTimeout(10000L, TimeUnit.MILLISECONDS).readTimeout(10000L, TimeUnit.MILLISECONDS).writeTimeout(10000L, TimeUnit.MILLISECONDS).connectionPool(this.jdField_a_of_type_Okhttp3ConnectionPool).dispatcher(this.jdField_a_of_type_Okhttp3Dispatcher).build();
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqNowNetchannelWebssoWebServiceSSO$WebServiceSSOSender.a();
  }
  
  public void a(String paramString, byte[] paramArrayOfByte, SSOCallback paramSSOCallback)
  {
    this.jdField_a_of_type_ComTencentMobileqqNowNetchannelWebssoWebServiceSSO$WebServiceSSOSender.a(paramString, paramArrayOfByte, paramSSOCallback);
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.now.netchannel.websso.WebServiceSSO
 * JD-Core Version:    0.7.0.1
 */