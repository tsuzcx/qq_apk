package com.tencent.xweb.util;

import android.util.Base64;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.KeySpec;
import java.security.spec.X509EncodedKeySpec;
import org.xwalk.core.Log;

class b$a
{
  String a;
  String b;
  String c;
  String d;
  
  public b$a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramString3;
    this.d = paramString4;
  }
  
  public boolean a()
  {
    try
    {
      Object localObject1 = new X509EncodedKeySpec(Base64.decode(this.c, 0));
      localObject2 = KeyFactory.getInstance("EC").generatePublic((KeySpec)localObject1);
      localObject1 = Signature.getInstance(this.d);
      ((Signature)localObject1).initVerify((PublicKey)localObject2);
      localObject2 = Base64.decode(this.b, 0);
      ((Signature)localObject1).update(this.a.getBytes());
      boolean bool = ((Signature)localObject1).verify((byte[])localObject2);
      return bool;
    }
    catch (Exception localException)
    {
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("verify failed ");
      ((StringBuilder)localObject2).append(localException.getMessage());
      Log.e("ECCUtil", ((StringBuilder)localObject2).toString());
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.xweb.util.b.a
 * JD-Core Version:    0.7.0.1
 */