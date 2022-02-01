package com.tencent.qapmsdk.impl.d;

import com.tencent.qapmsdk.impl.e.c;
import java.net.InetAddress;
import java.net.URL;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class a
{
  public static void a(com.tencent.qapmsdk.impl.a.a.a parama)
  {
    com.tencent.qapmsdk.socket.c.a locala = b(parama);
    if (locala != null)
    {
      locala.b = parama.g();
      locala.s = parama.j();
      locala.o = parama.k();
      if (locala.C == 0) {
        locala.C = parama.h();
      }
      com.tencent.qapmsdk.socket.c.b.b(parama.g());
    }
    for (parama = locala;; parama = c(parama))
    {
      c.a().b(parama);
      c.a().d();
      return;
    }
  }
  
  public static void a(com.tencent.qapmsdk.impl.a.a.a parama, Exception paramException)
  {
    com.tencent.qapmsdk.socket.c.a locala = b(parama);
    if (locala != null)
    {
      StringBuilder localStringBuilder = new StringBuilder().append(parama.g());
      if (parama.a() == null)
      {
        paramException = "";
        locala.b = paramException;
        locala.s = parama.j();
        locala.o = parama.k();
        locala.C = parama.h();
        locala.B = parama.i();
        com.tencent.qapmsdk.socket.c.b.b(parama.g());
      }
    }
    for (parama = locala;; parama = c(parama))
    {
      c.a().b(parama);
      c.a().d();
      return;
      paramException = "?" + parama.a();
      break;
    }
  }
  
  public static void a(com.tencent.qapmsdk.impl.a.a.a parama, String paramString)
  {
    paramString = b(parama);
    if (paramString != null)
    {
      paramString.b = parama.g();
      paramString.s = parama.j();
      paramString.o = parama.k();
      if ((paramString.C == 0) || (parama.i() > 400))
      {
        paramString.C = parama.h();
        paramString.B = parama.i();
      }
      com.tencent.qapmsdk.socket.c.b.b(parama.g());
    }
    for (parama = paramString;; parama = c(parama))
    {
      c.a().b(parama);
      c.a().d();
      return;
    }
  }
  
  public static void a(com.tencent.qapmsdk.impl.a.a.a parama, TreeMap paramTreeMap, String paramString)
  {
    paramTreeMap = b(parama);
    if (paramTreeMap != null)
    {
      paramTreeMap.b = parama.g();
      paramTreeMap.s = parama.j();
      paramTreeMap.o = parama.k();
      if ((paramTreeMap.C == 0) || (parama.i() > 400))
      {
        paramTreeMap.C = parama.h();
        paramTreeMap.B = parama.i();
      }
      com.tencent.qapmsdk.socket.c.b.b(parama.g());
    }
    for (parama = paramTreeMap;; parama = c(parama))
    {
      c.a().b(parama);
      c.a().d();
      return;
    }
  }
  
  private static boolean a(URL paramURL)
  {
    paramURL = paramURL.getHost();
    return Pattern.compile("^(2[0-5]{2}|[0-1]?\\d{1,2})(\\.(2[0-5]{2}|[0-1]?\\d{1,2})){3}$").matcher(paramURL).find();
  }
  
  private static com.tencent.qapmsdk.socket.c.a b(com.tencent.qapmsdk.impl.a.a.a parama)
  {
    for (;;)
    {
      try
      {
        localObject = parama.g();
        URL localURL = new URL((String)localObject);
        int i = localURL.getPort();
        if (i != -1)
        {
          localObject = Pattern.compile(":" + i).split((CharSequence)localObject);
          if (localObject.length <= 1) {
            break label244;
          }
          localObject = localObject[0] + localObject[1];
          localObject = new StringBuilder().append((String)localObject);
          if (parama.a() == null)
          {
            parama = "";
            parama = parama;
            com.tencent.qapmsdk.socket.c.a locala = com.tencent.qapmsdk.socket.c.b.a(parama);
            localObject = locala;
            if (locala == null)
            {
              localObject = locala;
              if (a(localURL))
              {
                localObject = localURL.getHost();
                return com.tencent.qapmsdk.socket.c.b.a(parama.replace((CharSequence)localObject, com.tencent.qapmsdk.dns.b.b.c((String)localObject)));
              }
            }
          }
          else
          {
            parama = "?" + parama.a();
            continue;
          }
        }
        else
        {
          localObject = new StringBuilder().append((String)localObject);
          if (parama.a() == null)
          {
            parama = "";
            parama = parama;
            continue;
          }
          parama = "?" + parama.a();
          continue;
        }
        return localObject;
      }
      catch (Exception parama)
      {
        localObject = null;
      }
      label244:
      Object localObject = localObject[0];
    }
  }
  
  private static com.tencent.qapmsdk.socket.c.a c(com.tencent.qapmsdk.impl.a.a.a parama)
  {
    com.tencent.qapmsdk.socket.c.a locala = new com.tencent.qapmsdk.socket.c.a();
    Object localObject = parama.g();
    locala.b = ((String)localObject);
    locala.s = parama.j();
    locala.o = parama.k();
    locala.n = parama.b();
    locala.C = parama.h();
    locala.B = parama.i();
    try
    {
      parama = new URL((String)localObject);
      locala.d = parama.getHost();
      if (a(parama))
      {
        locala.e = parama.getHost();
        return locala;
      }
      localObject = InetAddress.getAllByName(parama.getHost());
      locala.q = com.tencent.qapmsdk.dns.b.b.b(parama.getHost());
      if (localObject.length > 0)
      {
        locala.e = localObject[0].getHostAddress();
        return locala;
      }
    }
    catch (Exception parama) {}
    return locala;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qapmsdk.impl.d.a
 * JD-Core Version:    0.7.0.1
 */