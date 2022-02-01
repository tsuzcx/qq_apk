package com.tencent.qapmsdk.socket.a;

import com.tencent.qapmsdk.socket.c.a;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class j
{
  private static final Set<e> a = Collections.newSetFromMap(new ConcurrentHashMap());
  private static final Set<g> b = Collections.newSetFromMap(new ConcurrentHashMap());
  
  static
  {
    a.add(new j.d(null));
    b.add(new j.f(null));
  }
  
  public static Set<e> a()
  {
    return a;
  }
  
  public static void a(e parame)
  {
    if (parame == null) {
      return;
    }
    a.add(parame);
  }
  
  public static void a(g paramg)
  {
    if (paramg == null) {
      return;
    }
    b.add(paramg);
  }
  
  private static String b(a parama)
  {
    Object localObject = h.a();
    if (parama.g != null) {
      if (parama.a)
      {
        str = "https";
        parama.c = str;
        StringBuilder localStringBuilder = new StringBuilder().append(parama.d).append("/").append(parama.e).append(":").append(parama.f).append(", ");
        if (localObject == null) {
          break label237;
        }
        localObject = ((c)localObject).a(parama.i);
        label85:
        localObject = localStringBuilder.append((String)localObject).append(", ").append(parama.g).append(", ").append(parama.h).append(", ").append(str).append(", ").append(parama.m);
        if (!parama.y) {
          break label245;
        }
        str = ", gzip";
        label146:
        localObject = ((StringBuilder)localObject).append(str);
        if (!parama.z) {
          break label251;
        }
      }
    }
    label237:
    label245:
    label251:
    for (String str = ", chunked";; str = "")
    {
      return str + ", " + parama.j + ", impl[@" + parama.k + "], tid[" + parama.l + "]";
      str = "http";
      break;
      if (parama.a)
      {
        str = "ssl";
        break;
      }
      str = "tcp";
      break;
      localObject = parama.i;
      break label85;
      str = "";
      break label146;
    }
  }
  
  public static Set<g> b()
  {
    return b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qapmsdk.socket.a.j
 * JD-Core Version:    0.7.0.1
 */