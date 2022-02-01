package com.tencent.mobileqq.msf.core.net.b;

import android.text.TextUtils;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Random;

public class b
  extends a
{
  private static final String h = "HttpEchoTask";
  private String i;
  private URL j;
  private String k;
  private int l = 10000;
  private HttpURLConnection m;
  private int n;
  private String o;
  
  public b(int paramInt1, String paramString1, String paramString2, int paramInt2, a.a parama)
  {
    super(paramInt1, parama);
    parama = new StringBuilder();
    parama.append(paramString1);
    parama.append(b(paramString1));
    this.i = parama.toString();
    this.i = MsfSdkUtils.insertMtype("netdetect", this.i);
    this.k = paramString2;
    this.l = paramInt2;
  }
  
  private String b(String paramString)
  {
    Object localObject = new Random(System.currentTimeMillis());
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("r=");
    localStringBuilder.append(String.valueOf(((Random)localObject).nextInt(100000)));
    localObject = localStringBuilder.toString();
    if (paramString.contains("?"))
    {
      if (paramString.endsWith("?"))
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString);
        localStringBuilder.append((String)localObject);
        return localStringBuilder.toString();
      }
      paramString = new StringBuilder();
      paramString.append((String)localObject);
      paramString.append("&");
      paramString.append((String)localObject);
      return paramString.toString();
    }
    paramString = new StringBuilder();
    paramString.append("?");
    paramString.append((String)localObject);
    return paramString.toString();
  }
  
  protected int a(String paramString)
  {
    if ((this.n == 200) && (this.j.getHost().equals(this.o)) && (!TextUtils.isEmpty(paramString)) && (paramString.equals(this.k)))
    {
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("WIFI detect, HttpEchoTask ");
        paramString.append(this.e);
        paramString.append(" valid succ");
        QLog.d("HttpEchoTask", 2, paramString.toString());
      }
      return 0;
    }
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("WIFI detect, HttpEchoTask ");
      paramString.append(this.e);
      paramString.append(" valid failed.");
      QLog.d("HttpEchoTask", 2, paramString.toString());
    }
    return -3;
  }
  
  protected boolean a()
  {
    try
    {
      StringBuilder localStringBuilder1;
      if (QLog.isColorLevel())
      {
        localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append("WIFI detect, HttpEchoTask ");
        localStringBuilder1.append(this.e);
        localStringBuilder1.append(" try connect ");
        localStringBuilder1.append(this.i);
        QLog.d("HttpEchoTask", 2, localStringBuilder1.toString());
      }
      this.j = new URL(this.i);
      this.m = ((HttpURLConnection)this.j.openConnection());
      this.m.setDoOutput(true);
      this.m.setDoInput(true);
      this.m.setUseCaches(false);
      this.m.setRequestMethod("GET");
      this.m.setConnectTimeout(this.l);
      this.m.setReadTimeout(10000);
      this.m.connect();
      if (QLog.isColorLevel())
      {
        localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append("WIFI detect, HttpEchoTask ");
        localStringBuilder1.append(this.e);
        localStringBuilder1.append(" connect ");
        localStringBuilder1.append(this.i);
        localStringBuilder1.append(" succ.");
        QLog.d("HttpEchoTask", 2, localStringBuilder1.toString());
      }
      return true;
    }
    catch (Throwable localThrowable)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("WIFI detect, HttpEchoTask ");
        localStringBuilder2.append(this.e);
        localStringBuilder2.append(" connect ");
        localStringBuilder2.append(this.i);
        localStringBuilder2.append(" failed.");
        QLog.d("HttpEchoTask", 2, localStringBuilder2.toString(), localThrowable);
      }
      HttpURLConnection localHttpURLConnection = this.m;
      if (localHttpURLConnection != null) {
        localHttpURLConnection.disconnect();
      }
    }
    return false;
  }
  
  protected void b()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("WIFI detect, HttpEchoTask ");
      ((StringBuilder)localObject).append(this.e);
      ((StringBuilder)localObject).append(" disconnect ");
      ((StringBuilder)localObject).append(this.i);
      QLog.d("HttpEchoTask", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.m;
    if (localObject != null) {
      ((HttpURLConnection)localObject).disconnect();
    }
  }
  
  protected String c()
  {
    for (;;)
    {
      try
      {
        this.n = this.m.getResponseCode();
        this.o = this.m.getURL().getHost();
        localObject1 = new BufferedReader(new InputStreamReader(this.m.getInputStream()));
        String str = "";
        Object localObject2 = ((BufferedReader)localObject1).readLine();
        if (localObject2 != null)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(str);
          localStringBuilder.append((String)localObject2);
          str = localStringBuilder.toString();
          continue;
        }
        ((BufferedReader)localObject1).close();
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("WIFI detect, HttpEchoTask ");
          ((StringBuilder)localObject2).append(this.e);
          ((StringBuilder)localObject2).append(" echo content: ");
          if (str.length() > 10)
          {
            localObject1 = str.substring(0, 10);
            ((StringBuilder)localObject2).append((String)localObject1);
            QLog.d("HttpEchoTask", 2, ((StringBuilder)localObject2).toString());
          }
        }
        else
        {
          return str;
        }
      }
      catch (Throwable localThrowable)
      {
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("WIFI detect, HttpEchoTask ");
          ((StringBuilder)localObject1).append(this.e);
          ((StringBuilder)localObject1).append(" echo failed");
          QLog.d("HttpEchoTask", 2, ((StringBuilder)localObject1).toString(), localThrowable);
        }
        return null;
      }
      Object localObject1 = localThrowable;
    }
  }
  
  protected Object d()
  {
    return this.i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.net.b.b
 * JD-Core Version:    0.7.0.1
 */