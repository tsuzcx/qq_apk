package com.tencent.tvkbeacon.core.c;

import android.content.Context;
import com.tencent.tvkbeacon.core.info.a;
import com.tencent.tvkbeacon.core.info.b;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

public final class h
{
  public static AtomicBoolean a = new AtomicBoolean(false);
  
  public static void a(Context paramContext)
  {
    if (a.get())
    {
      if (c.b) {
        throw new IllegalStateException("[strict] 实时联调未关闭!正式发布后必须关闭实时联调！");
      }
      b localb = b.a(paramContext);
      if (localb.b().equals(localb.a())) {
        throw new IllegalStateException("[strict] AppKey未设置，当前AppKey为默认：" + localb.b());
      }
      if (i.a(localb.a(null))) {
        throw new IllegalStateException("[strict] Channel未设置！");
      }
      if ((!a.a(paramContext, "android.permission.INTERNET")) || (!a.a(paramContext, "android.permission.ACCESS_NETWORK_STATE"))) {
        a("当前无网络相关权限！");
      }
    }
  }
  
  public static void a(String paramString)
  {
    if (a.get()) {
      throw new RuntimeException("[strict] ".concat(String.valueOf(paramString)));
    }
  }
  
  public static void a(Map paramMap)
  {
    Iterator localIterator;
    if ((a.get()) && (paramMap != null)) {
      localIterator = paramMap.keySet().iterator();
    }
    for (;;)
    {
      Object localObject;
      if (localIterator.hasNext())
      {
        localObject = localIterator.next();
        if (!(localObject instanceof String)) {
          a("Key必须为String类型!");
        }
        if (!(paramMap.get(localObject) instanceof String)) {
          a("Value必须为String类型!");
        }
        localObject = (String)paramMap.get(localObject);
        if (!((String)localObject).contains(";")) {}
      }
      else
      {
        return;
      }
      try
      {
        if (((String)localObject).getBytes("UTF-8").length >= 1024) {
          a("单条事件长度超过1024,建议使用\";\"延长事件长度！");
        }
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        localUnsupportedEncodingException.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.tvkbeacon.core.c.h
 * JD-Core Version:    0.7.0.1
 */