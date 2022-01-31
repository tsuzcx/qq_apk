package com.tencent.mobileqq.microapp.a;

import android.content.Context;
import android.os.Looper;
import android.support.v4.util.LruCache;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public final class d
{
  public static final Object a = new Object();
  private static final ConcurrentHashMap d = new ConcurrentHashMap();
  private a b;
  private LruCache c;
  private WeakReference e;
  private String f;
  private String g;
  
  private d(Context paramContext, String paramString1, String paramString2)
  {
    try
    {
      String str = b(paramContext.getCacheDir().getAbsolutePath(), paramString1, paramString2);
      if (!TextUtils.isEmpty(str))
      {
        this.e = new WeakReference(paramContext);
        this.f = paramString1;
        this.g = paramString2;
        this.b = a.a(new File(str), 1, 1, 10485760L);
        this.c = new e(this, 10485760);
        return;
      }
      QLog.e("RequestHandler", 1, "[Storage] can not create dir");
      return;
    }
    catch (Throwable paramContext)
    {
      QLog.e("RequestHandler", 1, paramContext, new Object[0]);
    }
  }
  
  /* Error */
  public static d a(Context paramContext, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: getstatic 26	com/tencent/mobileqq/microapp/a/d:d	Ljava/util/concurrent/ConcurrentHashMap;
    //   5: astore 5
    //   7: aload 5
    //   9: monitorenter
    //   10: aload_0
    //   11: ifnull +87 -> 98
    //   14: aload_1
    //   15: aload_2
    //   16: invokestatic 102	com/tencent/mobileqq/microapp/a/d:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   19: astore 6
    //   21: getstatic 26	com/tencent/mobileqq/microapp/a/d:d	Ljava/util/concurrent/ConcurrentHashMap;
    //   24: aload 6
    //   26: invokevirtual 106	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   29: checkcast 2	com/tencent/mobileqq/microapp/a/d
    //   32: astore 4
    //   34: aload 4
    //   36: astore_3
    //   37: aload 4
    //   39: ifnonnull +59 -> 98
    //   42: getstatic 29	com/tencent/mobileqq/microapp/a/d:a	Ljava/lang/Object;
    //   45: astore 7
    //   47: aload 7
    //   49: monitorenter
    //   50: getstatic 26	com/tencent/mobileqq/microapp/a/d:d	Ljava/util/concurrent/ConcurrentHashMap;
    //   53: aload_1
    //   54: aload_2
    //   55: invokestatic 102	com/tencent/mobileqq/microapp/a/d:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   58: invokevirtual 106	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   61: checkcast 2	com/tencent/mobileqq/microapp/a/d
    //   64: astore 4
    //   66: aload 4
    //   68: astore_3
    //   69: aload 4
    //   71: ifnonnull +24 -> 95
    //   74: new 2	com/tencent/mobileqq/microapp/a/d
    //   77: dup
    //   78: aload_0
    //   79: aload_1
    //   80: aload_2
    //   81: invokespecial 108	com/tencent/mobileqq/microapp/a/d:<init>	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    //   84: astore_3
    //   85: getstatic 26	com/tencent/mobileqq/microapp/a/d:d	Ljava/util/concurrent/ConcurrentHashMap;
    //   88: aload 6
    //   90: aload_3
    //   91: invokevirtual 112	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   94: pop
    //   95: aload 7
    //   97: monitorexit
    //   98: aload 5
    //   100: monitorexit
    //   101: aload_3
    //   102: areturn
    //   103: astore_0
    //   104: aload 7
    //   106: monitorexit
    //   107: aload_0
    //   108: athrow
    //   109: astore_0
    //   110: aload 5
    //   112: monitorexit
    //   113: aload_0
    //   114: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	115	0	paramContext	Context
    //   0	115	1	paramString1	String
    //   0	115	2	paramString2	String
    //   1	101	3	localObject1	Object
    //   32	38	4	locald	d
    //   5	106	5	localConcurrentHashMap	ConcurrentHashMap
    //   19	70	6	str	String
    // Exception table:
    //   from	to	target	type
    //   50	66	103	finally
    //   74	95	103	finally
    //   95	98	103	finally
    //   104	107	103	finally
    //   14	34	109	finally
    //   42	50	109	finally
    //   98	101	109	finally
    //   107	109	109	finally
    //   110	113	109	finally
  }
  
  private static String a(String paramString1, String paramString2)
  {
    return paramString1 + "_" + paramString2;
  }
  
  private static String b(String paramString1, String paramString2, String paramString3)
  {
    if (!TextUtils.isEmpty(paramString3))
    {
      StringBuilder localStringBuilder = new StringBuilder().append(paramString1).append("/");
      paramString1 = paramString2;
      if (TextUtils.isEmpty(paramString2)) {
        paramString1 = "default";
      }
      paramString1 = paramString1;
      paramString1 = paramString1 + "/" + paramString3;
      paramString2 = new File(paramString1);
      if ((paramString2.exists()) || (paramString2.mkdirs())) {}
    }
    else
    {
      return null;
    }
    QLog.i("StoragePlugin", 1, "[Storage] getCacheDir: " + paramString1);
    return paramString1;
  }
  
  private void f()
  {
    String str;
    if ((this.e != null) && (this.e.get() != null))
    {
      str = b(((Context)this.e.get()).getCacheDir().getAbsolutePath(), this.f, this.g);
      if (!TextUtils.isEmpty(str)) {
        this.e = new WeakReference(this.e.get());
      }
    }
    try
    {
      this.b = a.a(new File(str), 1, 1, 10485760L);
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("RequestHandler", 1, localThrowable, new Object[0]);
    }
  }
  
  public long a()
  {
    if (this.b != null) {
      return this.b.c();
    }
    return -1L;
  }
  
  public void a(String arg1, String paramString2, String paramString3)
  {
    if (Thread.currentThread().getName().equals(Looper.getMainLooper().getThread().getName())) {
      throw new IllegalStateException("ill thread access");
    }
    if (this.b != null) {
      try
      {
        paramString2 = i.a(paramString3, paramString2);
        if (!TextUtils.isEmpty(paramString2))
        {
          paramString3 = this.b.b(???);
          if (paramString3 != null)
          {
            paramString3.a(0, paramString2);
            paramString3.a();
          }
          if (this.c != null)
          {
            this.c.put(???, paramString2);
            synchronized (d)
            {
              this.c.trimToSize(10485760 / d.keySet().size());
              return;
            }
          }
        }
        return;
      }
      catch (Throwable ???)
      {
        QLog.e("RequestHandler", 1, ???, new Object[0]);
      }
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3, d.a parama)
  {
    ThreadManagerV2.excute(new f(this, paramString2, paramString3, paramString1, parama), 16, null, true);
  }
  
  public String[] a(String paramString)
  {
    if (this.c != null)
    {
      String str2 = (String)this.c.get(paramString);
      String str1 = str2;
      if (TextUtils.isEmpty(str2))
      {
        str1 = str2;
        if (this.b != null) {
          str1 = str2;
        }
      }
      try
      {
        if (this.b.d())
        {
          str1 = str2;
          f();
        }
        str1 = str2;
        a.c localc = this.b.a(paramString);
        str1 = str2;
        if (localc != null)
        {
          str1 = str2;
          str2 = localc.b(0);
          str1 = str2;
          this.c.put(paramString, str2);
          str1 = str2;
          paramString = d;
          str1 = str2;
        }
      }
      catch (Throwable paramString)
      {
        for (;;)
        {
          QLog.e("RequestHandler", 1, paramString, new Object[0]);
        }
      }
      try
      {
        this.c.trimToSize(10485760 / d.keySet().size());
        str1 = str2;
        if (!TextUtils.isEmpty(str1)) {
          return i.a(str1);
        }
      }
      finally
      {
        str1 = str2;
      }
    }
    return null;
  }
  
  public long b()
  {
    if (this.b != null) {
      return this.b.b();
    }
    return -1L;
  }
  
  public void b(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (this.c != null) {
        this.c.remove(paramString);
      }
      if (this.b == null) {}
    }
    try
    {
      this.b.c(paramString);
      return;
    }
    catch (Throwable paramString)
    {
      QLog.e("RequestHandler", 1, paramString, new Object[0]);
    }
  }
  
  public void c()
  {
    if (this.c != null) {
      this.c.trimToSize(0);
    }
    if (this.b != null) {}
    try
    {
      this.b.f();
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("RequestHandler", 1, localThrowable, new Object[0]);
    }
  }
  
  public Set d()
  {
    if ((this.b != null) && (!this.b.d())) {
      return this.b.a();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.a.d
 * JD-Core Version:    0.7.0.1
 */