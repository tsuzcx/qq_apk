package com.tencent.smtt.sdk;

import android.content.Context;
import android.os.Build.VERSION;
import com.tencent.smtt.utils.TbsLog;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

class d
{
  static int a = 0;
  static boolean b = false;
  private static d e = null;
  private static int h = 0;
  private static int i = 3;
  private static String k = null;
  private t c = null;
  private t d = null;
  private boolean f = false;
  private boolean g = false;
  private File j = null;
  
  public static d a(boolean paramBoolean)
  {
    if ((e == null) && (paramBoolean)) {}
    try
    {
      if (e == null) {
        e = new d();
      }
      return e;
    }
    finally {}
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
    catch (FileNotFoundException localFileNotFoundException)
    {
      localFileNotFoundException.printStackTrace();
      return;
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
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
    //   0: iconst_0
    //   1: istore_2
    //   2: new 73	java/io/File
    //   5: dup
    //   6: aload_0
    //   7: getfield 49	com/tencent/smtt/sdk/d:j	Ljava/io/File;
    //   10: ldc 75
    //   12: invokespecial 78	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   15: astore 4
    //   17: aload 4
    //   19: invokevirtual 96	java/io/File:exists	()Z
    //   22: istore_3
    //   23: iload_3
    //   24: ifne +26 -> 50
    //   27: iconst_0
    //   28: ifeq +11 -> 39
    //   31: new 98	java/lang/NullPointerException
    //   34: dup
    //   35: invokespecial 99	java/lang/NullPointerException:<init>	()V
    //   38: athrow
    //   39: iload_2
    //   40: ireturn
    //   41: astore 4
    //   43: aload 4
    //   45: invokevirtual 89	java/io/IOException:printStackTrace	()V
    //   48: iconst_0
    //   49: ireturn
    //   50: new 101	java/io/BufferedInputStream
    //   53: dup
    //   54: new 103	java/io/FileInputStream
    //   57: dup
    //   58: aload 4
    //   60: invokespecial 104	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   63: invokespecial 107	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   66: astore 5
    //   68: aload 5
    //   70: astore 4
    //   72: new 58	java/util/Properties
    //   75: dup
    //   76: invokespecial 59	java/util/Properties:<init>	()V
    //   79: astore 6
    //   81: aload 5
    //   83: astore 4
    //   85: aload 6
    //   87: aload 5
    //   89: invokevirtual 110	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   92: aload 5
    //   94: astore 4
    //   96: aload 6
    //   98: getstatic 35	com/tencent/smtt/sdk/d:k	Ljava/lang/String;
    //   101: ldc 112
    //   103: invokevirtual 116	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   106: invokestatic 121	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   109: invokevirtual 124	java/lang/Integer:intValue	()I
    //   112: istore_1
    //   113: iload_1
    //   114: istore_2
    //   115: aload 5
    //   117: ifnull -78 -> 39
    //   120: aload 5
    //   122: invokevirtual 127	java/io/BufferedInputStream:close	()V
    //   125: iload_1
    //   126: ireturn
    //   127: astore 4
    //   129: aload 4
    //   131: invokevirtual 89	java/io/IOException:printStackTrace	()V
    //   134: iload_1
    //   135: ireturn
    //   136: astore 6
    //   138: aconst_null
    //   139: astore 5
    //   141: aload 5
    //   143: astore 4
    //   145: aload 6
    //   147: invokevirtual 128	java/lang/Exception:printStackTrace	()V
    //   150: aload 5
    //   152: ifnull -113 -> 39
    //   155: aload 5
    //   157: invokevirtual 127	java/io/BufferedInputStream:close	()V
    //   160: iconst_0
    //   161: ireturn
    //   162: astore 4
    //   164: aload 4
    //   166: invokevirtual 89	java/io/IOException:printStackTrace	()V
    //   169: iconst_0
    //   170: ireturn
    //   171: astore 5
    //   173: aconst_null
    //   174: astore 4
    //   176: aload 4
    //   178: ifnull +8 -> 186
    //   181: aload 4
    //   183: invokevirtual 127	java/io/BufferedInputStream:close	()V
    //   186: aload 5
    //   188: athrow
    //   189: astore 4
    //   191: aload 4
    //   193: invokevirtual 89	java/io/IOException:printStackTrace	()V
    //   196: goto -10 -> 186
    //   199: astore 5
    //   201: goto -25 -> 176
    //   204: astore 6
    //   206: goto -65 -> 141
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	209	0	this	d
    //   112	23	1	m	int
    //   1	114	2	n	int
    //   22	2	3	bool	boolean
    //   15	3	4	localFile	File
    //   41	18	4	localIOException1	IOException
    //   70	25	4	localObject1	Object
    //   127	3	4	localIOException2	IOException
    //   143	1	4	localObject2	Object
    //   162	3	4	localIOException3	IOException
    //   174	8	4	localObject3	Object
    //   189	3	4	localIOException4	IOException
    //   66	90	5	localBufferedInputStream	java.io.BufferedInputStream
    //   171	16	5	localObject4	Object
    //   199	1	5	localObject5	Object
    //   79	18	6	localProperties	Properties
    //   136	10	6	localException1	java.lang.Exception
    //   204	1	6	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   31	39	41	java/io/IOException
    //   120	125	127	java/io/IOException
    //   2	23	136	java/lang/Exception
    //   50	68	136	java/lang/Exception
    //   155	160	162	java/io/IOException
    //   2	23	171	finally
    //   50	68	171	finally
    //   181	186	189	java/io/IOException
    //   72	81	199	finally
    //   85	92	199	finally
    //   96	113	199	finally
    //   145	150	199	finally
    //   72	81	204	java/lang/Exception
    //   85	92	204	java/lang/Exception
    //   96	113	204	java/lang/Exception
  }
  
  public t a()
  {
    if (this.f) {
      return this.c;
    }
    return null;
  }
  
  public void a(Context paramContext, boolean paramBoolean1, boolean paramBoolean2, m paramm)
  {
    boolean bool2;
    label271:
    label291:
    Object localObject3;
    Object localObject2;
    label439:
    label469:
    label490:
    label505:
    Object localObject4;
    int m;
    for (;;)
    {
      try
      {
        TbsLog.addLog(999, null, new Object[0]);
        TbsLog.initIfNeed(paramContext);
        TbsLog.i("SDKEngine", "init -- context: " + paramContext + ", isPreIniting: " + paramBoolean2);
        a += 1;
        if (paramm != null)
        {
          if (a == 1)
          {
            bool1 = true;
            paramm.b = bool1;
          }
        }
        else
        {
          TbsCoreLoadStat.getInstance().a();
          if (paramm != null) {
            paramm.a("tbs_rename_task", (byte)1);
          }
          localObject1 = n.a();
          if (a != 1) {
            continue;
          }
          bool1 = true;
          ((n)localObject1).b(paramContext, bool1);
          n.a().k(paramContext);
          if (paramm != null) {
            paramm.a("tbs_rename_task", (byte)2);
          }
          TbsShareManager.forceToLoadX5ForThirdApp(paramContext, true);
          if (paramm != null) {
            paramm.a("can_load_x5", (byte)1);
          }
          bool2 = QbSdk.a(paramContext, paramBoolean1, paramBoolean2);
          if (paramm != null) {
            paramm.a("can_load_x5", (byte)2);
          }
          if (Build.VERSION.SDK_INT < 7) {
            continue;
          }
          paramBoolean2 = true;
          break label864;
          bool1 = paramBoolean1;
          if (paramBoolean1)
          {
            long l = System.currentTimeMillis();
            bool1 = n.a().g(paramContext, c());
            TbsLog.i("SDKEngine", "isTbsCoreLegal: " + bool1 + "; cost: " + (System.currentTimeMillis() - l));
          }
          if (!bool1) {
            break label750;
          }
          paramBoolean1 = this.f;
          if (!paramBoolean1) {
            continue;
          }
          return;
        }
        boolean bool1 = false;
        continue;
        bool1 = false;
        continue;
        paramBoolean2 = false;
        break label864;
        paramBoolean1 = false;
        continue;
        try
        {
          if (!TbsShareManager.isThirdPartyApp(paramContext)) {
            break;
          }
          TbsLog.addLog(995, null, new Object[0]);
          if (paramm != null) {
            paramm.a("read_core_info", (byte)1);
          }
          paramBoolean1 = TbsShareManager.j(paramContext);
          if (paramm != null) {
            paramm.a("read_core_info", (byte)2);
          }
          if (!paramBoolean1) {
            break label490;
          }
          localObject3 = new File(TbsShareManager.c(paramContext));
          localObject2 = n.a().q(paramContext);
          localObject1 = TbsShareManager.e(paramContext);
          if (localObject2 != null) {
            break label878;
          }
          this.f = false;
          QbSdk.a(paramContext, "SDKEngine::useSystemWebView by error_tbs_core_dexopt_dir null!");
        }
        catch (Throwable paramm)
        {
          TbsLog.e("SDKEngine", "useSystemWebView by exception: " + paramm);
          if (paramm != null) {
            break label735;
          }
        }
        TbsCoreLoadStat.getInstance().a(paramContext, 326);
        this.f = false;
        QbSdk.a(paramContext, "SDKEngine::useSystemWebView by exception: " + paramm);
        this.j = n.s(paramContext);
        this.g = true;
        continue;
        this.f = false;
      }
      finally {}
      QbSdk.a(paramContext, "SDKEngine::useSystemWebView by error_host_unavailable");
      continue;
      localObject4 = QbSdk.getDexLoaderFileList(paramContext, (Context)localObject1, ((File)localObject3).getAbsolutePath());
      m = 0;
    }
    while (m < localObject4.length)
    {
      m += 1;
      continue;
      TbsLog.addLog(996, null, new Object[0]);
      localObject2 = n.a().q(paramContext);
      if (h == 25436) {
        break label881;
      }
      if (h != 25437) {
        break label887;
      }
      break label881;
      label579:
      if (m == 0) {
        break label893;
      }
    }
    label621:
    label750:
    label878:
    label881:
    label887:
    label893:
    for (Object localObject1 = paramContext.getApplicationContext();; localObject1 = paramContext)
    {
      if (localObject2 == null)
      {
        this.f = false;
        QbSdk.a(paramContext, "SDKEngine::useSystemWebView by tbs_core_share_dir null!");
        break label271;
        if (TbsShareManager.getHostCorePathAppDefined() != null)
        {
          localObject2 = TbsShareManager.getHostCorePathAppDefined();
          TbsLog.i("SDKEngine", "SDKEngine init optDir is " + (String)localObject2);
          if (this.d == null) {
            break label704;
          }
          this.c = this.d;
          this.c.a(paramContext, (Context)localObject1, ((File)localObject3).getAbsolutePath(), (String)localObject2, (String[])localObject4, QbSdk.d, paramm);
        }
        for (;;)
        {
          this.f = true;
          break;
          localObject2 = ((File)localObject2).getAbsolutePath();
          break label621;
          this.c = new t(paramContext, (Context)localObject1, ((File)localObject3).getAbsolutePath(), (String)localObject2, (String[])localObject4, QbSdk.d, paramm);
        }
        TbsCoreLoadStat.getInstance().a(paramContext, 327, paramm);
        break label439;
        paramm = "can_load_x5=" + bool2 + "; is_compatible=" + paramBoolean2;
        TbsLog.e("SDKEngine", "SDKEngine.init canLoadTbs=false; failure: " + paramm);
        if ((QbSdk.a) && (this.f)) {
          break label469;
        }
        this.f = false;
        TbsCoreLoadStat.getInstance().a(paramContext, 405, new Throwable(paramm));
        break label469;
      }
      localObject4 = localObject2;
      localObject3 = localObject2;
      localObject2 = localObject4;
      break label505;
      if ((!bool2) || (!paramBoolean2)) {
        break label291;
      }
      paramBoolean1 = true;
      break;
      break label505;
      m = 1;
      break label579;
      m = 0;
      break label579;
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
    if ((this.c == null) || (QbSdk.a)) {
      return "system webview get nothing...";
    }
    return this.c.a();
  }
  
  boolean e()
  {
    int m;
    if (b)
    {
      if (k == null) {
        return false;
      }
      m = h();
      if (m != 0) {
        break label32;
      }
      b(1);
    }
    for (;;)
    {
      return b;
      label32:
      if (m + 1 > i) {
        break;
      }
      b(m + 1);
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.smtt.sdk.d
 * JD-Core Version:    0.7.0.1
 */