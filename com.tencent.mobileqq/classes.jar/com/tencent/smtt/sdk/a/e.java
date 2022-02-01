package com.tencent.smtt.sdk.a;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.smtt.utils.TbsLog;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class e
{
  private static String a = "EmergencyManager";
  private static final Object f = new Object();
  private static HandlerThread g;
  private static Handler h;
  private String b;
  private String c;
  private String d;
  private Handler e;
  
  public e(Context paramContext, String paramString1, String paramString2)
  {
    this(paramContext, paramString1, paramString2, "POST");
  }
  
  public e(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    this.b = paramString1;
    this.c = paramString2;
    this.d = paramString3;
    this.e = new Handler(paramContext.getMainLooper());
  }
  
  private static Handler b()
  {
    synchronized (f)
    {
      if (h == null)
      {
        g = new HandlerThread("HttpThread");
        g.start();
        h = new Handler(g.getLooper());
      }
      Handler localHandler = h;
      return localHandler;
    }
  }
  
  public String a(String paramString)
  {
    Object localObject1 = a;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("Request url: ");
    ((StringBuilder)localObject2).append(this.b);
    ((StringBuilder)localObject2).append(",params: ");
    ((StringBuilder)localObject2).append(this.c);
    TbsLog.e((String)localObject1, ((StringBuilder)localObject2).toString());
    try
    {
      paramString = (HttpURLConnection)new URL(paramString.trim()).openConnection();
      paramString.setRequestMethod(this.d);
      paramString.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(this.c.length());
      ((StringBuilder)localObject1).append("");
      paramString.setRequestProperty("Content-Length", ((StringBuilder)localObject1).toString());
      paramString.setDoOutput(true);
      paramString.getOutputStream().write(this.c.getBytes());
      int i = paramString.getResponseCode();
      if (200 == i)
      {
        paramString = paramString.getInputStream();
        localObject1 = new ByteArrayOutputStream();
        localObject2 = new byte[1024];
        for (;;)
        {
          i = paramString.read((byte[])localObject2);
          if (-1 == i) {
            break;
          }
          ((ByteArrayOutputStream)localObject1).write((byte[])localObject2, 0, i);
          ((ByteArrayOutputStream)localObject1).flush();
        }
        return ((ByteArrayOutputStream)localObject1).toString("utf-8");
      }
      paramString = a;
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("Bad http request, code: ");
      ((StringBuilder)localObject1).append(i);
      TbsLog.e(paramString, ((StringBuilder)localObject1).toString());
    }
    catch (Exception paramString)
    {
      localObject1 = a;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("Http exception: ");
      ((StringBuilder)localObject2).append(paramString.getMessage());
      TbsLog.e((String)localObject1, ((StringBuilder)localObject2).toString());
    }
    return null;
  }
  
  public void a(e.a parama)
  {
    b().post(new e.1(this, parama));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.smtt.sdk.a.e
 * JD-Core Version:    0.7.0.1
 */