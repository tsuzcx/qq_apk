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
      parama = locala;
    }
    else
    {
      parama = c(parama);
    }
    c.a().b(parama);
    c.a().d();
  }
  
  public static void a(com.tencent.qapmsdk.impl.a.a.a parama, Exception paramException)
  {
    com.tencent.qapmsdk.socket.c.a locala = b(parama);
    if (locala != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(parama.g());
      if (parama.a() == null)
      {
        paramException = "";
      }
      else
      {
        paramException = new StringBuilder();
        paramException.append("?");
        paramException.append(parama.a());
        paramException = paramException.toString();
      }
      localStringBuilder.append(paramException);
      locala.b = localStringBuilder.toString();
      locala.s = parama.j();
      locala.o = parama.k();
      locala.C = parama.h();
      locala.B = parama.i();
      com.tencent.qapmsdk.socket.c.b.b(parama.g());
      parama = locala;
    }
    else
    {
      parama = c(parama);
    }
    c.a().b(parama);
    c.a().d();
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
      parama = paramString;
    }
    else
    {
      parama = c(parama);
    }
    c.a().b(parama);
    c.a().d();
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
      parama = paramTreeMap;
    }
    else
    {
      parama = c(parama);
    }
    c.a().b(parama);
    c.a().d();
  }
  
  private static boolean a(URL paramURL)
  {
    paramURL = paramURL.getHost();
    return Pattern.compile("^(2[0-5]{2}|[0-1]?\\d{1,2})(\\.(2[0-5]{2}|[0-1]?\\d{1,2})){3}$").matcher(paramURL).find();
  }
  
  private static com.tencent.qapmsdk.socket.c.a b(com.tencent.qapmsdk.impl.a.a.a parama)
  {
    try
    {
      localObject3 = parama.g();
      localURL = new URL((String)localObject3);
      int i = localURL.getPort();
      localObject1 = "";
      if (i == -1) {
        break label178;
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(":");
      ((StringBuilder)localObject2).append(i);
      localObject2 = Pattern.compile(((StringBuilder)localObject2).toString()).split((CharSequence)localObject3);
      if (localObject2.length <= 1) {
        break label291;
      }
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(localObject2[0]);
      ((StringBuilder)localObject3).append(localObject2[1]);
      localObject2 = ((StringBuilder)localObject3).toString();
    }
    catch (Exception parama)
    {
      for (;;)
      {
        Object localObject3;
        URL localURL;
        Object localObject1;
        label178:
        label243:
        continue;
        label291:
        Object localObject2 = localObject2[0];
      }
    }
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append((String)localObject2);
    if (parama.a() != null)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("?");
      ((StringBuilder)localObject1).append(parama.a());
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    ((StringBuilder)localObject3).append((String)localObject1);
    parama = ((StringBuilder)localObject3).toString();
    break label243;
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject3);
    if (parama.a() != null)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("?");
      ((StringBuilder)localObject1).append(parama.a());
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    ((StringBuilder)localObject2).append((String)localObject1);
    parama = ((StringBuilder)localObject2).toString();
    localObject2 = com.tencent.qapmsdk.socket.c.b.a(parama);
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = localObject2;
      if (a(localURL))
      {
        localObject1 = localURL.getHost();
        localObject1 = com.tencent.qapmsdk.socket.c.b.a(parama.replace((CharSequence)localObject1, com.tencent.qapmsdk.dns.b.b.c((String)localObject1)));
      }
    }
    return localObject1;
    return null;
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
      if (localObject.length > 0) {
        locala.e = localObject[0].getHostAddress();
      }
      return locala;
    }
    catch (Exception parama) {}
    return locala;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qapmsdk.impl.d.a
 * JD-Core Version:    0.7.0.1
 */