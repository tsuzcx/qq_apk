package com.tencent.turingfd.sdk.ams.ga;

import android.util.Base64;
import java.io.BufferedWriter;
import java.io.StringWriter;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import org.json.JSONObject;

public class Lyra
{
  public static final String Yd = const.get(const._b);
  public static final String Zd = const.get(const.ac);
  public static final String _d = const.get(const.bc);
  public static final String dc;
  
  static
  {
    dc = const.get(const.dc);
  }
  
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
      while (j != localObject.length)
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
      i += localObject.length;
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
  
  public static void a(X509Certificate paramX509Certificate, Pyxis paramPyxis)
  {
    paramX509Certificate = paramX509Certificate.getExtensionValue(dc);
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
            break label225;
          }
          m = i;
          break label241;
        }
        if ((j > 0) && (j < k))
        {
          if ((!r) && (paramX509Certificate[(j - 1)] != k - j + 1)) {
            throw new AssertionError();
          }
          i = k - j + 1;
          byte[] arrayOfByte = new byte[i];
          System.arraycopy(paramX509Certificate, j, arrayOfByte, 0, i);
          paramX509Certificate = new JSONObject(new String(arrayOfByte));
          paramPyxis.Ee = paramX509Certificate.getString(Zd);
          paramPyxis.uid = paramX509Certificate.getInt(_d);
          paramPyxis.De = paramX509Certificate.getLong(Yd);
        }
        return;
      }
      catch (Exception paramX509Certificate)
      {
        paramPyxis = do.b("C");
        paramPyxis.append(paramX509Certificate.getStackTrace());
        throw new Exception(paramPyxis.toString());
      }
      paramX509Certificate = new Exception("Couldn't find the keystore attestation extension data.");
      for (;;)
      {
        throw paramX509Certificate;
      }
      label225:
      int m = j;
      if (i2 == i1)
      {
        k = i;
        m = j;
      }
      label241:
      i += 1;
      int j = m;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.turingfd.sdk.ams.ga.Lyra
 * JD-Core Version:    0.7.0.1
 */