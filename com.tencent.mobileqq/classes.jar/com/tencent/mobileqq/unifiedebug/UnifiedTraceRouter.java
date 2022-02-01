package com.tencent.mobileqq.unifiedebug;

import android.os.Handler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UnifiedTraceRouter
{
  public final int a = 32;
  public int b = 1;
  public String c;
  public float d;
  public Handler e;
  public List<UnifiedTraceRouter.TraceRouteInfo> f;
  public QQAppInterface g;
  public String h = "";
  
  public UnifiedTraceRouter(QQAppInterface paramQQAppInterface, Handler paramHandler)
  {
    this.g = paramQQAppInterface;
    this.e = paramHandler;
    this.f = new ArrayList();
  }
  
  public String a(String paramString)
  {
    Object localObject1 = String.format("/system/bin/ping -i 0.2 -c 1 -s 0 -t %d -W 4 %s", new Object[] { Integer.valueOf(this.b), paramString });
    long l = System.currentTimeMillis();
    Process localProcess = Runtime.getRuntime().exec((String)localObject1);
    BufferedReader localBufferedReader = new BufferedReader(new InputStreamReader(localProcess.getInputStream()));
    localObject1 = "";
    Object localObject2;
    for (;;)
    {
      String str = localBufferedReader.readLine();
      if (str == null) {
        break;
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(str);
      ((StringBuilder)localObject2).append("\n");
      localObject2 = ((StringBuilder)localObject2).toString();
      if (!str.contains("From"))
      {
        localObject1 = localObject2;
        if (!str.contains("from")) {}
      }
      else
      {
        this.d = ((float)(System.currentTimeMillis() - l));
        localObject1 = localObject2;
      }
    }
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("ping url = ");
      ((StringBuilder)localObject2).append(paramString);
      ((StringBuilder)localObject2).append(" result = ");
      ((StringBuilder)localObject2).append((String)localObject1);
      QLog.d("UnifiedTraceRouter", 2, ((StringBuilder)localObject2).toString());
    }
    try
    {
      localProcess.destroy();
      label219:
      if (!((String)localObject1).equals(""))
      {
        if (this.b == 1)
        {
          this.c = c((String)localObject1);
          if (QLog.isColorLevel())
          {
            paramString = new StringBuilder();
            paramString.append("final ip: ");
            paramString.append(this.c);
            QLog.d("UnifiedTraceRouter", 2, paramString.toString());
          }
        }
        return localObject1;
      }
      paramString = new IllegalArgumentException("ping result is empty");
      for (;;)
      {
        throw paramString;
      }
    }
    catch (Exception paramString)
    {
      break label219;
    }
  }
  
  public void a(long paramLong, String paramString, Map<String, Object> paramMap)
  {
    this.e.post(new UnifiedTraceRouter.1(this, paramString, paramLong, paramMap));
  }
  
  public String b(String paramString)
  {
    int i;
    int j;
    if (paramString.contains("From"))
    {
      String str = paramString.substring(paramString.indexOf("From") + 5);
      if (str.contains("("))
      {
        i = str.indexOf("(");
        j = str.indexOf(")");
        paramString = str;
        if (i >= 0)
        {
          paramString = str;
          if (j >= 0) {
            return str.substring(i + 1, j);
          }
        }
      }
      else
      {
        str = str.substring(0, str.indexOf("\n"));
        if (str.contains(":")) {
          i = str.indexOf(":");
        } else {
          i = str.indexOf(" ");
        }
        paramString = str;
        if (i > 0) {
          return str.substring(0, i);
        }
      }
    }
    else
    {
      i = paramString.indexOf("(");
      j = paramString.indexOf(")");
      if ((i >= 0) && (j >= 0)) {
        return paramString.substring(i + 1, j);
      }
      paramString = null;
    }
    return paramString;
  }
  
  public String c(String paramString)
  {
    if (paramString.contains("PING")) {
      return paramString.substring(paramString.indexOf("(") + 1, paramString.indexOf(")"));
    }
    return "";
  }
  
  public String d(String paramString)
  {
    if (paramString.contains("time="))
    {
      paramString = paramString.substring(paramString.indexOf("time=") + 5);
      return paramString.substring(0, paramString.indexOf(" "));
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.unifiedebug.UnifiedTraceRouter
 * JD-Core Version:    0.7.0.1
 */