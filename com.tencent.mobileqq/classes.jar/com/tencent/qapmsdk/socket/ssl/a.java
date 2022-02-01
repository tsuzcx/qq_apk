package com.tencent.qapmsdk.socket.ssl;

import android.support.annotation.RestrictTo;
import java.security.Provider;

@RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY})
public class a
  extends Provider
{
  public a()
  {
    super("TrafficAndroidOpenSSL", 1.0D, "Custom Traffic Android's OpenSSL-backed security provider");
    a.a[] arrayOfa = a.a.values();
    int j = arrayOfa.length;
    int i = 0;
    while (i < j)
    {
      a.a locala = arrayOfa[i];
      put(locala.h, locala.i);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qapmsdk.socket.ssl.a
 * JD-Core Version:    0.7.0.1
 */