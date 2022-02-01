package com.vivo.push.cache;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.vivo.push.util.f;
import com.vivo.push.util.o;
import com.vivo.push.util.z;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class a
  extends c<com.vivo.push.model.a>
{
  public a(Context paramContext)
  {
    super(paramContext);
  }
  
  public static boolean a(int paramInt)
  {
    if (paramInt != -1) {
      return (paramInt & 0x1) != 0;
    }
    return z.b("persist.sys.log.ctrl", "no").equals("yes");
  }
  
  protected final String a()
  {
    return "com.vivo.pushservice.back_up";
  }
  
  public final List<com.vivo.push.model.a> a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = paramString.trim().split("@#");
      int j = paramString.length;
      int i = 0;
      while (i < j)
      {
        String str = paramString[i].trim();
        String[] arrayOfString = str.trim().split(",");
        if (arrayOfString.length >= 2) {
          try
          {
            localArrayList.add(new com.vivo.push.model.a(arrayOfString[0], str.substring(arrayOfString[0].length() + 1)));
          }
          catch (Exception localException)
          {
            o.d("AppConfigSettings", "str2Clients E: ".concat(String.valueOf(localException)));
          }
        }
        i += 1;
      }
    }
    return localArrayList;
  }
  
  public final int b()
  {
    com.vivo.push.model.a locala = c("push_mode");
    if (locala != null) {
      if (TextUtils.isEmpty(locala.b())) {
        return -1;
      }
    }
    try
    {
      int i = Integer.parseInt(locala.b());
      return i;
    }
    catch (Exception localException) {}
    return -1;
    return -1;
  }
  
  final String b(String paramString)
  {
    return new String(f.a(f.a(e()), f.a(f()), Base64.decode(paramString, 2)), "utf-8");
  }
  
  public final com.vivo.push.model.a c(String paramString)
  {
    synchronized (a)
    {
      Iterator localIterator = this.b.iterator();
      while (localIterator.hasNext())
      {
        com.vivo.push.model.a locala = (com.vivo.push.model.a)localIterator.next();
        if ((!TextUtils.isEmpty(locala.a())) && (locala.a().equals(paramString))) {
          return locala;
        }
      }
      return null;
    }
    for (;;)
    {
      throw paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.vivo.push.cache.a
 * JD-Core Version:    0.7.0.1
 */