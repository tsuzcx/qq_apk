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
    File localFile1 = locala.g;
    if (locala.h != null)
    {
      if (!locala.h.exists()) {
        locala.h.mkdirs();
      }
      File localFile2 = locala.h;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(locala.o.a);
      localStringBuilder.append(".tbs");
      new File(localFile2, localStringBuilder.toString());
    }
    com.tencent.tbs.one.impl.a.f.a("[%s] {%s} Receiving component download response: [%d] %s", new Object[] { str1, str2, Integer.valueOf(paramInt), paramMap });
    if ((paramInt == 200) && (paramInputStream != null))
    {
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
          paramInt = paramMap.shouldInterceptComponentResponse(str1, str2, i, (Map)localObject, paramInputStream, localFile1, new a.7(locala, str1, str2, localFile1, localContext, i));
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
        try
        {
          com.tencent.tbs.one.impl.e.f.a(paramInputStream, locala.m, locala.n, localFile1, null, new a.8(locala));
          com.tencent.tbs.one.impl.e.f.a(localFile1, localFile1);
          com.tencent.tbs.one.impl.e.f.a(localFile1, i);
          com.tencent.tbs.one.impl.e.f.a(locala.b.getDir("tbs", 0));
          com.tencent.tbs.one.impl.e.f.b(localFile1);
          h.a("TBSOneAction", 1018, null);
        }
        catch (Exception paramMap)
        {
          com.tencent.tbs.one.impl.a.f.c("null pointer occured,e=%s", new Object[] { Log.getStackTraceString(paramMap) });
        }
        paramMap = e.a(e.a.d, localFile1);
        paramMap.c = locala.k;
        locala.a(paramMap);
        return;
      }
      catch (TBSOneException paramMap)
      {
        locala.a(paramMap.getErrorCode(), paramMap.getMessage(), paramMap.getCause());
        return;
      }
    }
    paramMap = new StringBuilder("Invalid component download stream, url: ");
    paramMap.append((String)localObject);
    paramMap.append(", statusCode: ");
    paramMap.append(paramInt);
    locala.a(220, paramMap.toString(), null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tbs.one.impl.e.a.a.5
 * JD-Core Version:    0.7.0.1
 */