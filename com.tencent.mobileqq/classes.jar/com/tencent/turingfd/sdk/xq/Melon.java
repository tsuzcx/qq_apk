package com.tencent.turingfd.sdk.xq;

import android.util.Base64;
import java.io.ByteArrayInputStream;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class Melon
{
  public static final String a = import.a(import.O0);
  public static final String b = import.a(import.P0);
  public static final String c = import.a(import.Q0);
  public static final String d = import.a(import.R0);
  public static final String e = import.a(import.S0);
  public long f = -1L;
  public int g = -1;
  public String h = "";
  public ArrayList<String> i = null;
  
  public Melon(String paramString1, String paramString2)
  {
    try
    {
      paramString1 = new JSONObject(paramString1);
      paramString2 = e;
      if (paramString1.has(paramString2))
      {
        paramString2 = paramString1.optJSONArray(paramString2);
        paramString2.length();
        this.i = new ArrayList();
        int j = 0;
        while (j < paramString2.length())
        {
          String str = paramString2.getString(j);
          this.i.add(str);
          j += 1;
        }
        a((X509Certificate)CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(((String)this.i.get(0)).getBytes())));
        paramString1.put(c, this.h);
        paramString1.put(d, this.g);
        paramString1.put(b, this.f);
        paramString1.toString();
        return;
      }
      this.f = paramString1.optLong(b);
      this.g = paramString1.optInt(d);
      this.h = paramString1.optString(c);
      paramString1.optString(a);
      return;
    }
    catch (Exception paramString1) {}
  }
  
  public Melon(Certificate[] paramArrayOfCertificate)
  {
    if (paramArrayOfCertificate != null) {}
    try
    {
      ArrayList localArrayList = new ArrayList();
      JSONArray localJSONArray = new JSONArray();
      int j = 0;
      while (j < paramArrayOfCertificate.length)
      {
        Certificate localCertificate = paramArrayOfCertificate[j];
        Base64.encodeToString(localCertificate.getEncoded(), 2);
        String str = Longan.a(localCertificate);
        if (j == 0) {
          a((X509Certificate)localCertificate);
        }
        localJSONArray.put(str);
        localArrayList.add(str);
        j += 1;
      }
      this.i = localArrayList;
      paramArrayOfCertificate = new JSONObject();
      paramArrayOfCertificate.put(e, localJSONArray);
      paramArrayOfCertificate.put(c, this.h);
      paramArrayOfCertificate.put(d, this.g);
      paramArrayOfCertificate.put(b, this.f);
      paramArrayOfCertificate.toString();
      return;
    }
    catch (Exception paramArrayOfCertificate) {}
  }
  
  public final void a(X509Certificate paramX509Certificate)
  {
    try
    {
      Longan.a(paramX509Certificate, this);
      return;
    }
    catch (Exception paramX509Certificate) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.Melon
 * JD-Core Version:    0.7.0.1
 */