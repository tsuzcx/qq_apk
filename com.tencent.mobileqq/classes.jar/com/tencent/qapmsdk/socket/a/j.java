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
    Object localObject2 = h.a();
    if (parama.g != null)
    {
      if (parama.a) {
        localObject1 = "https";
      } else {
        localObject1 = "http";
      }
    }
    else if (parama.a) {
      localObject1 = "ssl";
    } else {
      localObject1 = "tcp";
    }
    parama.c = ((String)localObject1);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(parama.d);
    localStringBuilder.append("/");
    localStringBuilder.append(parama.e);
    localStringBuilder.append(":");
    localStringBuilder.append(parama.f);
    localStringBuilder.append(", ");
    if (localObject2 != null) {
      localObject2 = ((c)localObject2).a(parama.i);
    } else {
      localObject2 = parama.i;
    }
    localStringBuilder.append((String)localObject2);
    localStringBuilder.append(", ");
    localStringBuilder.append(parama.g);
    localStringBuilder.append(", ");
    localStringBuilder.append(parama.h);
    localStringBuilder.append(", ");
    localStringBuilder.append((String)localObject1);
    localStringBuilder.append(", ");
    localStringBuilder.append(parama.m);
    boolean bool = parama.y;
    localObject2 = "";
    if (bool) {
      localObject1 = ", gzip";
    } else {
      localObject1 = "";
    }
    localStringBuilder.append((String)localObject1);
    Object localObject1 = localObject2;
    if (parama.z) {
      localObject1 = ", chunked";
    }
    localStringBuilder.append((String)localObject1);
    localStringBuilder.append(", ");
    localStringBuilder.append(parama.j);
    localStringBuilder.append(", impl[@");
    localStringBuilder.append(parama.k);
    localStringBuilder.append("], tid[");
    localStringBuilder.append(parama.l);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
  
  public static Set<g> b()
  {
    return b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qapmsdk.socket.a.j
 * JD-Core Version:    0.7.0.1
 */