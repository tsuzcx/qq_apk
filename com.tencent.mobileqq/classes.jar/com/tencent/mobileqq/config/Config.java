package com.tencent.mobileqq.config;

import android.graphics.Bitmap;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.struct.BaseConf;
import com.tencent.mobileqq.config.struct.PicAndAdConf;
import com.tencent.mobileqq.transfile.HttpCommunicator;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;
import java.util.ArrayList;
import mqq.app.AppRuntime;

public class Config
{
  public static byte a = 3;
  public static byte b = 1;
  public static PicAndAdConf c;
  static PicAndAdConf d;
  static BaseConf[] e;
  private static HttpCommunicator f;
  private static ConfigManager g;
  private static ArrayList<ConfigListener> h;
  private boolean i = true;
  
  public Config(QQAppInterface paramQQAppInterface, String paramString)
  {
    f = (HttpCommunicator)((IHttpEngineService)paramQQAppInterface.getRuntimeService(IHttpEngineService.class, "all")).getCommunicator();
    g = new ConfigManager(paramQQAppInterface.getApp(), paramString);
    h = new ArrayList();
    c = new PicAndAdConf((short)24, (byte)0);
    d = new PicAndAdConf((short)12, (byte)1);
    e = new BaseConf[] { c, d };
    g.b();
  }
  
  public static String a()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.sApplication.getRuntime();
    if (localAppRuntime != null) {
      return localAppRuntime.getAccount();
    }
    return null;
  }
  
  public static String a(String paramString1, int paramInt, String paramString2)
  {
    paramString1 = new StringBuffer(ConfigManager.a(paramString1, paramInt).trim());
    if (paramString2 != null)
    {
      paramString2 = paramString2.trim();
      if (paramString2.length() > 0)
      {
        if (paramString2.charAt(0) != '&') {
          paramString1.append('&');
        }
        paramString1.append(paramString2);
      }
    }
    return paramString1.toString();
  }
  
  public static HttpCommunicator b()
  {
    return f;
  }
  
  public static ConfigManager c()
  {
    return g;
  }
  
  public static ArrayList<ConfigListener> d()
  {
    return h;
  }
  
  public static void e()
  {
    g = null;
    HttpCommunicator localHttpCommunicator = f;
    if (localHttpCommunicator != null) {
      localHttpCommunicator.close();
    }
    f = null;
  }
  
  public int a(int paramInt)
  {
    return e[paramInt].b();
  }
  
  public Bitmap a(int paramInt1, int paramInt2)
  {
    return ((PicAndAdConf)e[paramInt1]).d(paramInt2);
  }
  
  public short b(int paramInt1, int paramInt2)
  {
    return ((PicAndAdConf)e[paramInt1]).a(paramInt2);
  }
  
  public String c(int paramInt1, int paramInt2)
  {
    return ((PicAndAdConf)e[paramInt1]).e(paramInt2);
  }
  
  public String d(int paramInt1, int paramInt2)
  {
    return ((PicAndAdConf)e[paramInt1]).b(paramInt2);
  }
  
  public String e(int paramInt1, int paramInt2)
  {
    return ((PicAndAdConf)e[paramInt1]).c(paramInt2);
  }
  
  public long f(int paramInt1, int paramInt2)
  {
    return ((PicAndAdConf)e[paramInt1]).f(paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.config.Config
 * JD-Core Version:    0.7.0.1
 */