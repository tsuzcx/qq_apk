package com.tencent.tbs.one.impl.c.a;

import android.app.Service;
import android.content.Intent;
import com.tencent.tbs.one.impl.a.f;
import com.tencent.tbs.one.optional.TBSOneStandaloneService.ServiceImpl;
import dalvik.system.DexClassLoader;

public class b
  extends TBSOneStandaloneService.ServiceImpl
{
  public void onDestroy()
  {
    super.onDestroy();
    System.exit(0);
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    if (paramIntent != null)
    {
      String str1 = paramIntent.getStringExtra("dexPath");
      String str2 = paramIntent.getStringExtra("dexName");
      String str3 = paramIntent.getStringExtra("optimizedDirectory");
      paramIntent = paramIntent.getStringExtra("librarySearchPath");
      long l = System.currentTimeMillis();
      f.a("Optimizing dex %s in standalone service", new Object[] { str1 });
      ClassLoader localClassLoader = this.a.getClassLoader();
      try
      {
        new DexClassLoader(str1, str3, paramIntent, localClassLoader);
        com.tencent.tbs.one.impl.a.c.b(c.a(str3, str2));
      }
      catch (Exception paramIntent)
      {
        f.c("Failed to optimize dex %s", new Object[] { str1, paramIntent });
      }
      f.a("Optimized dex %s in standalone service, cost %dms", new Object[] { str1, Long.valueOf(System.currentTimeMillis() - l) });
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tbs.one.impl.c.a.b
 * JD-Core Version:    0.7.0.1
 */