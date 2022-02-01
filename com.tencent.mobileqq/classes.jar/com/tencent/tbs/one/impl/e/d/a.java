package com.tencent.tbs.one.impl.e.d;

import android.content.Context;
import android.os.Bundle;
import com.tencent.tbs.one.TBSOneException;
import com.tencent.tbs.one.impl.common.d.a;
import com.tencent.tbs.one.impl.d.a.a;
import com.tencent.tbs.one.impl.e.e;
import com.tencent.tbs.one.impl.e.e.a;
import com.tencent.tbs.one.optional.TBSOneRuntimeExtension;
import java.io.File;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

public final class a
  extends com.tencent.tbs.one.impl.a.a<e<File>>
  implements a.a
{
  int b;
  private Context c;
  private String d;
  private d.a e;
  private File f;
  private File g;
  private com.tencent.tbs.one.impl.d.a h;
  private long i = -1L;
  private Bundle j;
  
  public a(Context paramContext, String paramString, d.a parama, File paramFile, Bundle paramBundle)
  {
    this.c = paramContext;
    this.d = paramString;
    this.e = parama;
    this.f = paramFile;
    this.j = paramBundle;
    paramContext = this.c;
    this.g = com.tencent.tbs.one.impl.common.f.a(paramContext, paramContext, paramString, parama.a, parama.c);
  }
  
  protected final void a()
  {
    Object localObject = this.e.d;
    this.h = new com.tencent.tbs.one.impl.d.a(this.c, (String)localObject);
    localObject = this.h;
    ((com.tencent.tbs.one.impl.d.a)localObject).f = this;
    ((com.tencent.tbs.one.impl.d.a)localObject).a(new a.1(this));
  }
  
  public final void a(int paramInt, Map<String, List<String>> paramMap, InputStream paramInputStream)
  {
    Context localContext = this.c;
    String str1 = this.d;
    String str2 = this.e.a;
    int k = this.e.c;
    String str3 = this.e.d;
    File localFile2 = this.f;
    File localFile1 = this.g;
    if ((localFile1 != null) && (!localFile1.exists())) {
      this.g.mkdirs();
    }
    localFile1 = this.g;
    if (localFile1 == null)
    {
      localFile1 = null;
    }
    else
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.e.a);
      localStringBuilder.append(".tbs");
      localFile1 = new File(localFile1, localStringBuilder.toString());
    }
    com.tencent.tbs.one.impl.a.f.a("[%s] {%s} Receiving component response: [%d] %s", new Object[] { str1, str2, Integer.valueOf(paramInt), paramMap });
    if ((paramInt == 200) && (paramInputStream != null))
    {
      paramMap = (List)paramMap.get("Content-Length");
      if ((paramMap != null) && (paramMap.size() > 0)) {
        try
        {
          this.i = Long.parseLong((String)paramMap.get(0));
        }
        catch (Exception localException)
        {
          com.tencent.tbs.one.impl.a.f.c("Failed to parse Content-Length header %s, url: %s", new Object[] { paramMap, str3, localException });
        }
      } else {
        com.tencent.tbs.one.impl.a.f.a("No Content-Length header exists, url: %s", new Object[] { str3 });
      }
      paramMap = com.tencent.tbs.one.impl.common.a.b(localContext, str1);
      if (paramMap != null)
      {
        paramInt = paramMap.shouldInterceptComponentResponse(str1, str2, k, null, paramInputStream, localFile2, new a.2(this, str1, str2, localFile2));
        if (paramInt != 0)
        {
          com.tencent.tbs.one.impl.a.f.a("[%s] {%s} Intercepted component download stream by runtime extension", new Object[] { str1, str2 });
          this.b = paramInt;
          return;
        }
      }
      paramMap = this.e.e;
      long l = this.i;
      try
      {
        com.tencent.tbs.one.impl.e.f.a(paramInputStream, paramMap, l, localFile2, localFile1, new a.3(this));
        com.tencent.tbs.one.impl.e.f.a(localFile2, localFile2);
        com.tencent.tbs.one.impl.e.f.a(localFile2, k);
        com.tencent.tbs.one.impl.e.f.a(this.c.getDir("tbs", 0));
        com.tencent.tbs.one.impl.e.f.b(localFile2);
        a(e.a(e.a.d, localFile2));
        return;
      }
      catch (TBSOneException paramMap)
      {
        a(paramMap.getErrorCode(), paramMap.getMessage(), paramMap.getCause());
        return;
      }
    }
    paramMap = new StringBuilder("Invalid component response stream, url: ");
    paramMap.append(str3);
    paramMap.append(", statusCode: ");
    paramMap.append(paramInt);
    a(215, paramMap.toString(), null);
  }
  
  public final void b()
  {
    super.b();
    Object localObject = this.h;
    if (localObject != null) {
      ((com.tencent.tbs.one.impl.d.a)localObject).b();
    }
    if (this.b != 0)
    {
      localObject = com.tencent.tbs.one.impl.common.a.b(this.c, this.d);
      if (localObject != null) {
        ((TBSOneRuntimeExtension)localObject).cancel(this.b);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tbs.one.impl.e.d.a
 * JD-Core Version:    0.7.0.1
 */