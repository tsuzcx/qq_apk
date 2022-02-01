package com.vivo.push.cache;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.vivo.push.model.a;
import com.vivo.push.util.f;
import com.vivo.push.util.o;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class e
  extends c<a>
{
  public e(Context paramContext)
  {
    super(paramContext);
  }
  
  protected final String a()
  {
    return "com.vivo.pushservice.other";
  }
  
  public final List<a> a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
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
          localArrayList.add(new a(arrayOfString[0], str.substring(arrayOfString[0].length() + 1)));
        }
        catch (Exception localException)
        {
          o.d("PushConfigSettings", "str2Clients E: ".concat(String.valueOf(localException)));
        }
      }
      i += 1;
    }
    return localArrayList;
  }
  
  final String b(String paramString)
  {
    return new String(f.a(f.a(e()), f.a(f()), Base64.decode(paramString, 2)), "utf-8");
  }
  
  public final String c(String paramString)
  {
    synchronized (a)
    {
      Iterator localIterator = this.b.iterator();
      while (localIterator.hasNext())
      {
        a locala = (a)localIterator.next();
        if ((!TextUtils.isEmpty(locala.a())) && (locala.a().equals(paramString)))
        {
          paramString = locala.b();
          return paramString;
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
 * Qualified Name:     com.vivo.push.cache.e
 * JD-Core Version:    0.7.0.1
 */