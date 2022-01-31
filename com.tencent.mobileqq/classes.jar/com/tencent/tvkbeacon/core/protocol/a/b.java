package com.tencent.tvkbeacon.core.protocol.a;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.util.Base64;
import java.security.KeyFactory;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.KeySpec;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;

public final class b
{
  public static byte[] a(Context paramContext, String paramString)
  {
    if (paramString == null) {
      return null;
    }
    try
    {
      Object localObject = new X509EncodedKeySpec(Base64.decode("MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCsAxNCSLyNUCOP1QqYStE8ZeiU\nv4afaMqEmoLCKb0mUZYvYOoVN7LPMi2IVY2MRaFJvuND3glVw1RDm2VJJtjQkwUd\n3kpR9TrHAf7UQOVTpNo3Vi7pXTOqZ6bh3ZA/fs56jDCCKV6+wT/pCeu8N6vVnPrD\nz3SdHIeNeWb/woazCwIDAQAB", 0));
      if (paramContext.getApplicationInfo().targetSdkVersion >= 28) {}
      for (paramContext = KeyFactory.getInstance("RSA");; paramContext = KeyFactory.getInstance("RSA", "BC"))
      {
        paramContext = (RSAPublicKey)paramContext.generatePublic((KeySpec)localObject);
        localObject = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        ((Cipher)localObject).init(1, paramContext);
        paramContext = ((Cipher)localObject).doFinal(paramString.getBytes());
        break;
      }
      return paramContext;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
      paramContext = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.tvkbeacon.core.protocol.a.b
 * JD-Core Version:    0.7.0.1
 */