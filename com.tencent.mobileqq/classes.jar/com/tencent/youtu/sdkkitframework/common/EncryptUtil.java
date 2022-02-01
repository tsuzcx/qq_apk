package com.tencent.youtu.sdkkitframework.common;

import android.util.Base64;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class EncryptUtil
{
  public String generateEncReq(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    FaceLiveReq localFaceLiveReq = new FaceLiveReq();
    localFaceLiveReq.app_id = paramString2;
    paramString2 = paramString3;
    if (paramString3 == "") {
      paramString2 = "not_set";
    }
    localFaceLiveReq.session_id = paramString2;
    localFaceLiveReq.config = paramString4;
    paramString3 = new SecureRandom();
    paramString2 = new byte[16];
    paramString3.nextBytes(paramString2);
    paramString4 = new byte[16];
    paramString3.nextBytes(paramString4);
    paramString3 = new SecretKeySpec(paramString4, "AES");
    paramString4 = MessageDigest.getInstance("MD5");
    Object localObject = new byte[paramString3.getEncoded().length + paramString2.length];
    System.arraycopy(paramString3.getEncoded(), 0, localObject, 0, paramString3.getEncoded().length);
    System.arraycopy(paramString2, 0, localObject, paramString3.getEncoded().length, paramString2.length);
    paramString4.update((byte[])localObject);
    paramString4 = paramString4.digest();
    localObject = new StringBuffer();
    int i = 0;
    while (i < paramString4.length)
    {
      if (Integer.toHexString(paramString4[i] & 0xFF).length() == 1)
      {
        ((StringBuffer)localObject).append("0");
        ((StringBuffer)localObject).append(Integer.toHexString(paramString4[i] & 0xFF));
      }
      else
      {
        ((StringBuffer)localObject).append(Integer.toHexString(paramString4[i] & 0xFF));
      }
      i += 1;
    }
    localFaceLiveReq.sign = ((StringBuffer)localObject).toString();
    paramString4 = Cipher.getInstance("AES/CBC/PKCS5Padding");
    paramString4.init(1, paramString3, new IvParameterSpec(paramString2));
    paramString1 = paramString4.doFinal(paramString1.getBytes());
    paramString4 = ByteBuffer.wrap(new byte[paramString3.getEncoded().length + paramString2.length + paramString1.length]);
    paramString4.put(paramString3.getEncoded());
    paramString4.put(paramString2);
    paramString4.put(paramString1);
    localFaceLiveReq.data = new String(Base64.encodeToString(paramString4.array(), 0));
    return new WeJson().toJson(localFaceLiveReq);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.youtu.sdkkitframework.common.EncryptUtil
 * JD-Core Version:    0.7.0.1
 */