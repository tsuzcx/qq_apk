package com.tencent.turingfd.sdk.xq;

import android.util.Base64;
import java.io.BufferedWriter;
import java.io.StringWriter;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import org.json.JSONObject;

public class Longan
{
  public static final String a = import.a(import.T0);
  public static final String b = import.a(import.P0);
  public static final String c = import.a(import.Q0);
  public static final String d = import.a(import.R0);
  
  public static String a(Certificate paramCertificate)
  {
    StringWriter localStringWriter = new StringWriter();
    BufferedWriter localBufferedWriter = new BufferedWriter(localStringWriter);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("-----BEGIN ");
    ((StringBuilder)localObject).append("CERTIFICATE");
    ((StringBuilder)localObject).append("-----");
    localBufferedWriter.write(((StringBuilder)localObject).toString());
    localBufferedWriter.write("\n");
    paramCertificate = Base64.encode(paramCertificate.getEncoded(), 2);
    localObject = new char[64];
    int i = 0;
    while (i < paramCertificate.length)
    {
      int j = 0;
      while (j != 64)
      {
        int k = i + j;
        if (k >= paramCertificate.length) {
          break;
        }
        localObject[j] = ((char)paramCertificate[k]);
        j += 1;
      }
      localBufferedWriter.write((char[])localObject, 0, j);
      localBufferedWriter.write("\n");
      i += 64;
    }
    paramCertificate = new StringBuilder();
    paramCertificate.append("-----END ");
    paramCertificate.append("CERTIFICATE");
    paramCertificate.append("-----");
    localBufferedWriter.write(paramCertificate.toString());
    localBufferedWriter.write("\n");
    localBufferedWriter.close();
    return localStringWriter.toString();
  }
  
  public static void a(X509Certificate paramX509Certificate, Melon paramMelon)
  {
    paramX509Certificate = paramX509Certificate.getExtensionValue(a);
    if ((paramX509Certificate != null) && (paramX509Certificate.length != 0)) {}
    for (;;)
    {
      int i1;
      int i;
      int k;
      int i2;
      try
      {
        int n = "{".getBytes()[0];
        i1 = "}".getBytes()[0];
        i = 0;
        j = 0;
        k = 0;
        if (i < paramX509Certificate.length)
        {
          i2 = paramX509Certificate[i];
          if (i2 != n) {
            break label234;
          }
          m = i;
          break label250;
        }
        if ((j > 0) && (j < k))
        {
          if ((!e) && (paramX509Certificate[(j - 1)] != k - j + 1)) {
            throw new AssertionError();
          }
          i = k - j + 1;
          byte[] arrayOfByte = new byte[i];
          System.arraycopy(paramX509Certificate, j, arrayOfByte, 0, i);
          paramX509Certificate = new JSONObject(new String(arrayOfByte));
          paramMelon.h = paramX509Certificate.getString(c);
          paramMelon.g = paramX509Certificate.getInt(d);
          paramMelon.f = paramX509Certificate.getLong(b);
        }
        return;
      }
      catch (Exception paramX509Certificate)
      {
        paramMelon = new StringBuilder();
        paramMelon.append("C");
        paramMelon.append(paramX509Certificate.getStackTrace());
        throw new Exception(paramMelon.toString());
      }
      paramX509Certificate = new Exception("Couldn't find the keystore attestation extension data.");
      for (;;)
      {
        throw paramX509Certificate;
      }
      label234:
      int m = j;
      if (i2 == i1)
      {
        k = i;
        m = j;
      }
      label250:
      i += 1;
      int j = m;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.Longan
 * JD-Core Version:    0.7.0.1
 */