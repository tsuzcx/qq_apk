package com.tencent.tbs.one.impl.e.a;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.tbs.one.impl.a.c;
import com.tencent.tbs.one.impl.a.m;
import com.tencent.tbs.one.impl.common.d.a;
import com.tencent.tbs.one.impl.common.h;
import com.tencent.tbs.one.impl.e.e;
import com.tencent.tbs.one.optional.TBSOneRuntimeExtension;
import java.io.File;
import org.json.JSONObject;

public final class a
  extends com.tencent.tbs.one.impl.a.a<e<File>>
{
  Context b;
  String c;
  String d;
  String e;
  int f;
  File g;
  File h;
  com.tencent.tbs.one.impl.d.a i;
  int j;
  JSONObject k;
  int l;
  String m;
  long n = -1L;
  d.a o;
  private Bundle p;
  
  public a(Context paramContext, String paramString1, String paramString2, d.a parama, File paramFile, Bundle paramBundle)
  {
    this.b = paramContext;
    this.c = paramString1;
    String str = parama.d;
    paramContext = str;
    if (TextUtils.isEmpty(str)) {
      paramContext = paramString2;
    }
    this.d = paramContext;
    this.e = parama.a;
    this.f = parama.c;
    this.g = paramFile;
    this.p = paramBundle;
    this.o = parama;
    paramContext = this.b;
    this.h = com.tencent.tbs.one.impl.common.f.a(paramContext, paramContext, paramString1, parama.a, parama.c);
  }
  
  protected final void a()
  {
    Context localContext = this.b;
    String str1 = this.c;
    String str2 = this.e;
    int i1 = this.f;
    File localFile = this.g;
    TBSOneRuntimeExtension localTBSOneRuntimeExtension = com.tencent.tbs.one.impl.common.a.b(localContext, str1);
    if (localTBSOneRuntimeExtension != null)
    {
      int i2 = localTBSOneRuntimeExtension.shouldOverrideInstallationJob(str1, str2, i1, null, localFile, new a.1(this, str1, str2, localFile));
      if (i2 != 0)
      {
        com.tencent.tbs.one.impl.a.f.a("[%s] {%s} Intercepted component installation job by runtime extension", new Object[] { str1, str2 });
        this.j = i2;
        return;
      }
    }
    if (localFile.exists()) {
      c.a(localFile);
    }
    m.d(new a.2(this, localContext, str1, str2, i1));
  }
  
  public final void a(int paramInt, String paramString, Throwable paramThrowable)
  {
    if (paramInt == 219) {
      if (d()) {
        h.a(1017, this.e);
      } else {
        h.a(1007, this.e);
      }
    }
    if (d()) {
      h.a(1014, this.e);
    } else {
      h.a(1004, this.e);
    }
    com.tencent.tbs.one.impl.e.f.a(this.g, System.currentTimeMillis());
    super.a(paramInt, paramString, paramThrowable);
  }
  
  public final void b()
  {
    super.b();
    Object localObject = this.i;
    if (localObject != null) {
      ((com.tencent.tbs.one.impl.d.a)localObject).b();
    }
    if (this.j != 0)
    {
      localObject = com.tencent.tbs.one.impl.common.a.b(this.b, this.c);
      if (localObject != null) {
        ((TBSOneRuntimeExtension)localObject).cancel(this.j);
      }
    }
  }
  
  final boolean c()
  {
    Bundle localBundle = this.p;
    if (localBundle != null) {
      return localBundle.getBoolean("is_ignore_wifi_state", false);
    }
    return false;
  }
  
  final boolean d()
  {
    Bundle localBundle = this.p;
    return (localBundle != null) && (localBundle.getInt("info_from", -1) == 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tbs.one.impl.e.a.a
 * JD-Core Version:    0.7.0.1
 */