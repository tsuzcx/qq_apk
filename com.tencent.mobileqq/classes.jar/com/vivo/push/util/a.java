package com.vivo.push.util;

import android.content.Context;
import android.util.Base64;
import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class a
{
  private static volatile a c;
  private byte[] a;
  private byte[] b;
  
  private a(Context paramContext)
  {
    w.b().a(ContextDelegate.getContext(paramContext));
    paramContext = w.b();
    this.a = paramContext.c();
    this.b = paramContext.d();
  }
  
  public static a a(Context paramContext)
  {
    if (c == null) {
      try
      {
        if (c == null) {
          c = new a(paramContext.getApplicationContext());
        }
      }
      finally {}
    }
    return c;
  }
  
  private byte[] a()
  {
    byte[] arrayOfByte = this.a;
    if ((arrayOfByte != null) && (arrayOfByte.length > 0)) {
      return arrayOfByte;
    }
    return w.b().c();
  }
  
  private byte[] b()
  {
    byte[] arrayOfByte = this.b;
    if ((arrayOfByte != null) && (arrayOfByte.length > 0)) {
      return arrayOfByte;
    }
    return w.b().d();
  }
  
  public final String a(String paramString)
  {
    String str = f.a(a());
    Object localObject = f.a(b());
    paramString = paramString.getBytes("utf-8");
    localObject = new SecretKeySpec(((String)localObject).getBytes("utf-8"), "AES");
    Cipher localCipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
    localCipher.init(1, (Key)localObject, new IvParameterSpec(str.getBytes("utf-8")));
    return Base64.encodeToString(localCipher.doFinal(paramString), 2);
  }
  
  public final String b(String paramString)
  {
    return new String(f.a(f.a(a()), f.a(b()), Base64.decode(paramString, 2)), "utf-8");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.vivo.push.util.a
 * JD-Core Version:    0.7.0.1
 */