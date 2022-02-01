package com.tencent.smtt.sdk;

import android.content.Context;
import android.os.Build.VERSION;
import com.tencent.smtt.utils.TbsLog;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

class f
{
  static int a = 0;
  static boolean b = false;
  private static f e;
  private static int h = 0;
  private static int i = 3;
  private static String k;
  private v c = null;
  private v d = null;
  private boolean f = false;
  private boolean g = false;
  private File j = null;
  
  public static f a(boolean paramBoolean)
  {
    if ((e == null) && (paramBoolean)) {
      try
      {
        if (e == null) {
          e = new f();
        }
      }
      finally {}
    }
    return e;
  }
  
  static void a(int paramInt)
  {
    h = paramInt;
  }
  
  private void b(int paramInt)
  {
    Properties localProperties = new Properties();
    localProperties.setProperty(k, String.valueOf(paramInt));
    try
    {
      localProperties.store(new FileOutputStream(new File(this.j, "count.prop")), null);
      return;
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
      return;
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      localFileNotFoundException.printStackTrace();
    }
  }
  
  public static int c()
  {
    return h;
  }
  
  /* Error */
  private int h()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore_3
    //   5: aload_3
    //   6: astore_2
    //   7: new 69	java/io/File
    //   10: dup
    //   11: aload_0
    //   12: getfield 39	com/tencent/smtt/sdk/f:j	Ljava/io/File;
    //   15: ldc 71
    //   17: invokespecial 74	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   20: astore 4
    //   22: aload_3
    //   23: astore_2
    //   24: aload 4
    //   26: invokevirtual 92	java/io/File:exists	()Z
    //   29: ifne +5 -> 34
    //   32: iconst_0
    //   33: ireturn
    //   34: aload_3
    //   35: astore_2
    //   36: new 94	java/io/BufferedInputStream
    //   39: dup
    //   40: new 96	java/io/FileInputStream
    //   43: dup
    //   44: aload 4
    //   46: invokespecial 97	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   49: invokespecial 100	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   52: astore_3
    //   53: new 52	java/util/Properties
    //   56: dup
    //   57: invokespecial 53	java/util/Properties:<init>	()V
    //   60: astore_2
    //   61: aload_2
    //   62: aload_3
    //   63: invokevirtual 103	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   66: aload_2
    //   67: getstatic 55	com/tencent/smtt/sdk/f:k	Ljava/lang/String;
    //   70: ldc 105
    //   72: invokevirtual 109	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   75: invokestatic 114	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   78: invokevirtual 117	java/lang/Integer:intValue	()I
    //   81: istore_1
    //   82: aload_3
    //   83: invokevirtual 120	java/io/BufferedInputStream:close	()V
    //   86: iload_1
    //   87: ireturn
    //   88: astore_2
    //   89: aload_2
    //   90: invokevirtual 84	java/io/IOException:printStackTrace	()V
    //   93: iload_1
    //   94: ireturn
    //   95: astore 4
    //   97: aload_3
    //   98: astore_2
    //   99: aload 4
    //   101: astore_3
    //   102: goto +43 -> 145
    //   105: astore_2
    //   106: aload_2
    //   107: astore 4
    //   109: goto +12 -> 121
    //   112: astore_3
    //   113: goto +32 -> 145
    //   116: astore 4
    //   118: aload 5
    //   120: astore_3
    //   121: aload_3
    //   122: astore_2
    //   123: aload 4
    //   125: invokevirtual 121	java/lang/Exception:printStackTrace	()V
    //   128: aload_3
    //   129: ifnull +14 -> 143
    //   132: aload_3
    //   133: invokevirtual 120	java/io/BufferedInputStream:close	()V
    //   136: iconst_0
    //   137: ireturn
    //   138: astore_2
    //   139: aload_2
    //   140: invokevirtual 84	java/io/IOException:printStackTrace	()V
    //   143: iconst_0
    //   144: ireturn
    //   145: aload_2
    //   146: ifnull +15 -> 161
    //   149: aload_2
    //   150: invokevirtual 120	java/io/BufferedInputStream:close	()V
    //   153: goto +8 -> 161
    //   156: astore_2
    //   157: aload_2
    //   158: invokevirtual 84	java/io/IOException:printStackTrace	()V
    //   161: aload_3
    //   162: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	163	0	this	f
    //   81	13	1	m	int
    //   6	61	2	localObject1	Object
    //   88	2	2	localIOException1	IOException
    //   98	1	2	localObject2	Object
    //   105	2	2	localException1	java.lang.Exception
    //   122	1	2	localObject3	Object
    //   138	12	2	localIOException2	IOException
    //   156	2	2	localIOException3	IOException
    //   4	98	3	localObject4	Object
    //   112	1	3	localObject5	Object
    //   120	42	3	localObject6	Object
    //   20	25	4	localFile	File
    //   95	5	4	localObject7	Object
    //   107	1	4	localException2	java.lang.Exception
    //   116	8	4	localException3	java.lang.Exception
    //   1	118	5	localObject8	Object
    // Exception table:
    //   from	to	target	type
    //   82	86	88	java/io/IOException
    //   53	82	95	finally
    //   53	82	105	java/lang/Exception
    //   7	22	112	finally
    //   24	32	112	finally
    //   36	53	112	finally
    //   123	128	112	finally
    //   7	22	116	java/lang/Exception
    //   24	32	116	java/lang/Exception
    //   36	53	116	java/lang/Exception
    //   132	136	138	java/io/IOException
    //   149	153	156	java/io/IOException
  }
  
  public v a()
  {
    if (this.f) {
      return this.c;
    }
    return null;
  }
  
  public void a(Context paramContext, boolean paramBoolean1, boolean paramBoolean2, o paramo)
  {
    try
    {
      TbsLog.addLog(999, null, new Object[0]);
      TbsLog.initIfNeed(paramContext);
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("init -- context: ");
      ((StringBuilder)localObject1).append(paramContext);
      ((StringBuilder)localObject1).append(", isPreIniting: ");
      ((StringBuilder)localObject1).append(paramBoolean2);
      TbsLog.i("SDKEngine", ((StringBuilder)localObject1).toString());
      a += 1;
      if (paramo == null) {
        break label99;
      }
      if (a != 1) {
        break label929;
      }
      bool1 = true;
    }
    finally
    {
      for (;;)
      {
        Object localObject1;
        label99:
        boolean bool2;
        long l;
        int m;
        for (;;)
        {
          throw paramContext;
        }
        label929:
        boolean bool1 = false;
        continue;
        bool1 = false;
        continue;
        label941:
        paramBoolean2 = false;
        label943:
        if ((bool2) && (paramBoolean2))
        {
          paramBoolean1 = true;
        }
        else
        {
          paramBoolean1 = false;
          continue;
          label962:
          m = 0;
          continue;
          label968:
          m = 1;
          continue;
          label974:
          localObject1 = paramContext;
        }
      }
    }
    paramo.b = bool1;
    TbsCoreLoadStat.getInstance().a();
    if (paramo != null) {
      paramo.a("tbs_rename_task", (byte)1);
    }
    localObject1 = p.a();
    if (a == 1)
    {
      bool1 = true;
      ((p)localObject1).b(paramContext, bool1);
      p.a().l(paramContext);
      if (paramo != null) {
        paramo.a("tbs_rename_task", (byte)2);
      }
      TbsShareManager.forceToLoadX5ForThirdApp(paramContext, true);
      if (paramo != null) {
        paramo.a("can_load_x5", (byte)1);
      }
      bool2 = QbSdk.a(paramContext, paramBoolean1, paramBoolean2);
      if (paramo != null) {
        paramo.a("can_load_x5", (byte)2);
      }
      if (Build.VERSION.SDK_INT < 7) {
        break label941;
      }
      paramBoolean2 = true;
      break label943;
      bool1 = paramBoolean1;
      if (paramBoolean1)
      {
        l = System.currentTimeMillis();
        bool1 = p.a().g(paramContext, c());
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("isTbsCoreLegal: ");
        ((StringBuilder)localObject1).append(bool1);
        ((StringBuilder)localObject1).append("; cost: ");
        ((StringBuilder)localObject1).append(System.currentTimeMillis() - l);
        TbsLog.i("SDKEngine", ((StringBuilder)localObject1).toString());
      }
      if (bool1)
      {
        paramBoolean1 = this.f;
        if (paramBoolean1) {
          return;
        }
        try
        {
          File localFile;
          Object localObject2;
          if (TbsShareManager.isThirdPartyApp(paramContext))
          {
            TbsLog.addLog(995, null, new Object[0]);
            if (paramo != null) {
              paramo.a("read_core_info", (byte)1);
            }
            paramBoolean1 = TbsShareManager.j(paramContext);
            if (paramo != null) {
              paramo.a("read_core_info", (byte)2);
            }
            if (paramBoolean1)
            {
              localFile = new File(TbsShareManager.c(paramContext));
              localObject3 = p.a().r(paramContext);
              localObject1 = TbsShareManager.e(paramContext);
              localObject2 = localObject3;
              if (localObject3 == null)
              {
                this.f = false;
                QbSdk.a(paramContext, "SDKEngine::useSystemWebView by error_tbs_core_dexopt_dir null!");
              }
            }
            else
            {
              this.f = false;
              QbSdk.a(paramContext, "SDKEngine::useSystemWebView by error_host_unavailable");
            }
          }
          else
          {
            TbsLog.addLog(996, null, new Object[0]);
            localFile = p.a().r(paramContext);
            if (h == 25436) {
              break label968;
            }
            if (h != 25437) {
              break label962;
            }
            break label968;
            if (m == 0) {
              break label974;
            }
            localObject1 = paramContext.getApplicationContext();
            if (localFile == null)
            {
              this.f = false;
              QbSdk.a(paramContext, "SDKEngine::useSystemWebView by tbs_core_share_dir null!");
              return;
            }
            localObject2 = localFile;
          }
          Object localObject3 = QbSdk.getDexLoaderFileList(paramContext, (Context)localObject1, localFile.getAbsolutePath());
          m = 0;
          while (m < localObject3.length) {
            m += 1;
          }
          if (TbsShareManager.getHostCorePathAppDefined() != null) {
            localObject2 = TbsShareManager.getHostCorePathAppDefined();
          } else {
            localObject2 = ((File)localObject2).getAbsolutePath();
          }
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("SDKEngine init optDir is ");
          localStringBuilder.append((String)localObject2);
          TbsLog.i("SDKEngine", localStringBuilder.toString());
          if (this.d != null)
          {
            this.c = this.d;
            this.c.a(paramContext, (Context)localObject1, localFile.getAbsolutePath(), (String)localObject2, (String[])localObject3, QbSdk.d, paramo);
          }
          else
          {
            this.c = new v(paramContext, (Context)localObject1, localFile.getAbsolutePath(), (String)localObject2, (String[])localObject3, QbSdk.d, paramo);
          }
          this.f = true;
        }
        catch (Throwable paramo)
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("useSystemWebView by exception: ");
          ((StringBuilder)localObject1).append(paramo);
          TbsLog.e("SDKEngine", ((StringBuilder)localObject1).toString());
          TbsCoreLoadStat.getInstance().a(paramContext, 327, paramo);
          this.f = false;
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("SDKEngine::useSystemWebView by exception: ");
          ((StringBuilder)localObject1).append(paramo);
          QbSdk.a(paramContext, ((StringBuilder)localObject1).toString());
        }
      }
      else
      {
        paramo = new StringBuilder();
        paramo.append("can_load_x5=");
        paramo.append(bool2);
        paramo.append("; is_compatible=");
        paramo.append(paramBoolean2);
        paramo = paramo.toString();
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("SDKEngine.init canLoadTbs=false; failure: ");
        ((StringBuilder)localObject1).append(paramo);
        TbsLog.e("SDKEngine", ((StringBuilder)localObject1).toString());
        if ((!QbSdk.a) || (!this.f))
        {
          this.f = false;
          TbsCoreLoadStat.getInstance().a(paramContext, 405, new Throwable(paramo));
        }
      }
      d.a().a(paramContext);
      this.j = p.t(paramContext);
      this.g = true;
    }
  }
  
  void a(String paramString)
  {
    k = paramString;
  }
  
  public boolean b()
  {
    return this.f;
  }
  
  boolean b(boolean paramBoolean)
  {
    b = paramBoolean;
    return paramBoolean;
  }
  
  public String d()
  {
    if ((this.c != null) && (!QbSdk.a)) {
      return this.c.a();
    }
    return "system webview get nothing...";
  }
  
  boolean e()
  {
    if (b)
    {
      if (k == null) {
        return false;
      }
      int m = h();
      if (m == 0)
      {
        b(1);
      }
      else
      {
        m += 1;
        if (m <= i) {
          b(m);
        } else {
          return false;
        }
      }
    }
    return b;
  }
  
  boolean f()
  {
    return this.g;
  }
  
  public boolean g()
  {
    return QbSdk.useSoftWare();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.smtt.sdk.f
 * JD-Core Version:    0.7.0.1
 */