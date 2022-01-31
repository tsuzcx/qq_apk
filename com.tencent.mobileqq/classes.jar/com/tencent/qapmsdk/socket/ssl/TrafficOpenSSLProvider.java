package com.tencent.qapmsdk.socket.ssl;

import android.support.annotation.RestrictTo;
import java.security.Provider;

@RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY})
public class TrafficOpenSSLProvider
  extends Provider
{
  private static final String PROVIDER_NAME = "TrafficAndroidOpenSSL";
  private static final String TAG = "QAPM_Socket_TrafficOpenSSLProvider";
  
  public TrafficOpenSSLProvider()
  {
    super("TrafficAndroidOpenSSL", 1.0D, "Custom Traffic Android's OpenSSL-backed security provider");
    TrafficOpenSSLProvider.Service[] arrayOfService = TrafficOpenSSLProvider.Service.values();
    int j = arrayOfService.length;
    int i = 0;
    while (i < j)
    {
      TrafficOpenSSLProvider.Service localService = arrayOfService[i];
      put(localService.typeAlgorithm, localService.clazz);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qapmsdk.socket.ssl.TrafficOpenSSLProvider
 * JD-Core Version:    0.7.0.1
 */