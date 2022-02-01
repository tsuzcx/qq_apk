package com.tencent.tbs.one.impl.e;

import android.os.Bundle;
import com.tencent.tbs.one.TBSOneManager.Policy;
import com.tencent.tbs.one.impl.a.a;
import com.tencent.tbs.one.impl.a.c;
import java.io.File;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class j
  extends a<Void>
{
  i b;
  boolean c;
  Map<String, a> d = new ConcurrentHashMap();
  Bundle e;
  
  public j(i parami, Bundle paramBundle)
  {
    this.b = parami;
    this.e = paramBundle;
  }
  
  private void c()
  {
    Iterator localIterator = this.d.values().iterator();
    while (localIterator.hasNext()) {
      ((a)localIterator.next()).b();
    }
    this.d.clear();
  }
  
  public final void a()
  {
    com.tencent.tbs.one.impl.a.f.a("[%s] Requesting the latest DEPS", new Object[] { this.b.b });
    i locali = this.b;
    String str = locali.b;
    Object localObject = com.tencent.tbs.one.impl.common.f.c(locali.c);
    if (((File)localObject).exists()) {
      c.c((File)localObject);
    }
    localObject = locali.a(TBSOneManager.Policy.AUTO, -1, (File)localObject, this.e);
    ((a)localObject).a(new j.1(this, str, locali));
    this.d.put("DEPS", localObject);
  }
  
  public final void a(int paramInt, String paramString, Throwable paramThrowable)
  {
    com.tencent.tbs.one.impl.a.f.b("Failed to update, error: [%d] %s", new Object[] { Integer.valueOf(paramInt), paramString });
    this.c = true;
    c();
    File localFile = com.tencent.tbs.one.impl.common.f.c(this.b.c);
    if (localFile.exists()) {
      c.c(localFile);
    }
    super.a(paramInt, paramString, paramThrowable);
  }
  
  public final void b()
  {
    super.b();
    c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tbs.one.impl.e.j
 * JD-Core Version:    0.7.0.1
 */