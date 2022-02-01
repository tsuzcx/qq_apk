package com.tencent.tbs.one.impl.e.a;

import android.content.Context;
import android.util.Log;
import com.tencent.tbs.one.TBSOneException;
import com.tencent.tbs.one.impl.common.d.a;
import com.tencent.tbs.one.impl.common.h;
import com.tencent.tbs.one.impl.d.a.a;
import com.tencent.tbs.one.impl.e.e;
import com.tencent.tbs.one.impl.e.e.a;
import com.tencent.tbs.one.optional.TBSOneRuntimeExtension;
import java.io.File;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

final class a$5
  implements a.a
{
  a$5(a parama, String paramString, int paramInt) {}
  
  public final void a(int paramInt, Map<String, List<String>> paramMap, InputStream paramInputStream)
  {
    a locala = this.c;
    Object localObject = this.a;
    int j = this.b;
    Context localContext = locala.b;
    String str1 = locala.c;
    String str2 = locala.e;
    int i = locala.f;
    File localFile = locala.g;
    if (locala.h != null)
    {
      if (!locala.h.exists()) {
        locala.h.mkdirs();
      }
      new File(locala.h, locala.o.a + ".tbs");
    }
    com.tencent.tbs.one.impl.a.f.a("[%s] {%s} Receiving component download response: [%d] %s", new Object[] { str1, str2, Integer.valueOf(paramInt), paramMap });
    if ((paramInt != 200) || (paramInputStream == null))
    {
      locala.a(220, "Invalid component download stream, url: " + (String)localObject + ", statusCode: " + paramInt, null);
      return;
    }
    if (locala.l == 1)
    {
      com.tencent.tbs.one.impl.a.f.a("[%s] {%s} Asking runtime extension to intercept download stream", new Object[] { str1, str2 });
      try
      {
        paramMap = com.tencent.tbs.one.impl.common.a.a(localContext, str1);
        localObject = new HashMap();
        ((Map)localObject).put("localVersion", Integer.valueOf(j));
        ((Map)localObject).put("localVersionDirectory", new File(com.tencent.tbs.one.impl.common.f.b(com.tencent.tbs.one.impl.common.f.a(localContext.getDir("tbs", 0), str1), str2), String.valueOf(j)).getAbsolutePath());
        ((Map)localObject).put("controlMessage", locala.k);
        paramInt = paramMap.shouldInterceptComponentResponse(str1, str2, i, (Map)localObject, paramInputStream, localFile, new a.7(locala, str1, str2, localFile, localContext, i));
        if (paramInt != 0)
        {
          com.tencent.tbs.one.impl.a.f.a("[%s] {%s} Intercepted component download stream by runtime extension", new Object[] { str1, str2 });
          locala.j = paramInt;
          return;
        }
      }
      catch (TBSOneException paramMap)
      {
        locala.a(paramMap.getErrorCode(), paramMap.getMessage(), paramMap.getCause());
        return;
      }
    }
    try
    {
      com.tencent.tbs.one.impl.e.f.a(paramInputStream, locala.m, locala.n, localFile, null, new a.8(locala));
      com.tencent.tbs.one.impl.e.f.a(localFile, localFile);
      com.tencent.tbs.one.impl.e.f.a(localFile, i);
      com.tencent.tbs.one.impl.e.f.a(locala.b.getDir("tbs", 0));
      com.tencent.tbs.one.impl.e.f.b(localFile);
      h.a("TBSOneAction", 1018, null);
      paramMap = e.a(e.a.d, localFile);
      paramMap.c = locala.k;
      locala.a(paramMap);
      return;
    }
    catch (TBSOneException paramMap)
    {
      locala.a(paramMap.getErrorCode(), paramMap.getMessage(), paramMap.getCause());
      return;
    }
    catch (Exception paramMap)
    {
      for (;;)
      {
        com.tencent.tbs.one.impl.a.f.c("null pointer occured,e=%s", new Object[] { Log.getStackTraceString(paramMap) });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tbs.one.impl.e.a.a.5
 * JD-Core Version:    0.7.0.1
 */