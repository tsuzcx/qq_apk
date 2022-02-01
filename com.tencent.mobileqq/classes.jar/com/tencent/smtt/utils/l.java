package com.tencent.smtt.utils;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;

public class l
{
  private static l c = null;
  private Context a = null;
  private File b = null;
  private String d = "https://log.tbs.qq.com/ajax?c=pu&v=2&k=";
  private String e = "https://log.tbs.qq.com/ajax?c=pu&tk=";
  private String f = "https://log.tbs.qq.com/ajax?c=dl&k=";
  private String g = "https://cfg.imtt.qq.com/tbs?v=2&mk=";
  private String h = "https://log.tbs.qq.com/ajax?c=ul&v=2&k=";
  private String i = "https://mqqad.html5.qq.com/adjs";
  private String j = "https://log.tbs.qq.com/ajax?c=ucfu&k=";
  
  @TargetApi(11)
  private l(Context paramContext)
  {
    TbsLog.w("TbsCommonConfig", "TbsCommonConfig constructing...");
    this.a = paramContext.getApplicationContext();
    g();
  }
  
  public static l a()
  {
    try
    {
      l locall = c;
      return locall;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static l a(Context paramContext)
  {
    try
    {
      if (c == null) {
        c = new l(paramContext);
      }
      paramContext = c;
      return paramContext;
    }
    finally {}
  }
  
  /* Error */
  private void g()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aconst_null
    //   3: astore_1
    //   4: aload_0
    //   5: invokespecial 92	com/tencent/smtt/utils/l:h	()Ljava/io/File;
    //   8: astore_2
    //   9: aload_2
    //   10: ifnonnull +38 -> 48
    //   13: ldc 64
    //   15: ldc 94
    //   17: invokestatic 96	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   20: iconst_0
    //   21: ifeq +11 -> 32
    //   24: new 98	java/lang/NullPointerException
    //   27: dup
    //   28: invokespecial 99	java/lang/NullPointerException:<init>	()V
    //   31: athrow
    //   32: aload_0
    //   33: monitorexit
    //   34: return
    //   35: astore_1
    //   36: aload_1
    //   37: invokevirtual 102	java/io/IOException:printStackTrace	()V
    //   40: goto -8 -> 32
    //   43: astore_1
    //   44: aload_0
    //   45: monitorexit
    //   46: aload_1
    //   47: athrow
    //   48: new 104	java/io/BufferedInputStream
    //   51: dup
    //   52: new 106	java/io/FileInputStream
    //   55: dup
    //   56: aload_2
    //   57: invokespecial 109	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   60: invokespecial 112	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   63: astore_2
    //   64: new 114	java/util/Properties
    //   67: dup
    //   68: invokespecial 115	java/util/Properties:<init>	()V
    //   71: astore_1
    //   72: aload_1
    //   73: aload_2
    //   74: invokevirtual 118	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   77: aload_1
    //   78: ldc 120
    //   80: ldc 122
    //   82: invokevirtual 126	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   85: astore_3
    //   86: ldc 122
    //   88: aload_3
    //   89: invokevirtual 132	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   92: ifne +8 -> 100
    //   95: aload_0
    //   96: aload_3
    //   97: putfield 38	com/tencent/smtt/utils/l:d	Ljava/lang/String;
    //   100: aload_1
    //   101: ldc 134
    //   103: ldc 122
    //   105: invokevirtual 126	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   108: astore_3
    //   109: ldc 122
    //   111: aload_3
    //   112: invokevirtual 132	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   115: ifne +8 -> 123
    //   118: aload_0
    //   119: aload_3
    //   120: putfield 46	com/tencent/smtt/utils/l:f	Ljava/lang/String;
    //   123: aload_1
    //   124: ldc 136
    //   126: ldc 122
    //   128: invokevirtual 126	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   131: astore_3
    //   132: ldc 122
    //   134: aload_3
    //   135: invokevirtual 132	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   138: ifne +8 -> 146
    //   141: aload_0
    //   142: aload_3
    //   143: putfield 50	com/tencent/smtt/utils/l:g	Ljava/lang/String;
    //   146: aload_1
    //   147: ldc 138
    //   149: ldc 122
    //   151: invokevirtual 126	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   154: astore_3
    //   155: ldc 122
    //   157: aload_3
    //   158: invokevirtual 132	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   161: ifne +8 -> 169
    //   164: aload_0
    //   165: aload_3
    //   166: putfield 54	com/tencent/smtt/utils/l:h	Ljava/lang/String;
    //   169: aload_1
    //   170: ldc 140
    //   172: ldc 122
    //   174: invokevirtual 126	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   177: astore_3
    //   178: ldc 122
    //   180: aload_3
    //   181: invokevirtual 132	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   184: ifne +8 -> 192
    //   187: aload_0
    //   188: aload_3
    //   189: putfield 58	com/tencent/smtt/utils/l:i	Ljava/lang/String;
    //   192: aload_1
    //   193: ldc 142
    //   195: ldc 122
    //   197: invokevirtual 126	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   200: astore_3
    //   201: ldc 122
    //   203: aload_3
    //   204: invokevirtual 132	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   207: ifne +8 -> 215
    //   210: aload_0
    //   211: aload_3
    //   212: putfield 62	com/tencent/smtt/utils/l:j	Ljava/lang/String;
    //   215: aload_1
    //   216: ldc 144
    //   218: ldc 122
    //   220: invokevirtual 126	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   223: astore_1
    //   224: ldc 122
    //   226: aload_1
    //   227: invokevirtual 132	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   230: ifne +8 -> 238
    //   233: aload_0
    //   234: aload_1
    //   235: putfield 42	com/tencent/smtt/utils/l:e	Ljava/lang/String;
    //   238: aload_2
    //   239: ifnull -207 -> 32
    //   242: aload_2
    //   243: invokevirtual 147	java/io/BufferedInputStream:close	()V
    //   246: goto -214 -> 32
    //   249: astore_1
    //   250: aload_1
    //   251: invokevirtual 102	java/io/IOException:printStackTrace	()V
    //   254: goto -222 -> 32
    //   257: astore_2
    //   258: new 149	java/io/StringWriter
    //   261: dup
    //   262: invokespecial 150	java/io/StringWriter:<init>	()V
    //   265: astore_3
    //   266: aload_2
    //   267: new 152	java/io/PrintWriter
    //   270: dup
    //   271: aload_3
    //   272: invokespecial 155	java/io/PrintWriter:<init>	(Ljava/io/Writer;)V
    //   275: invokevirtual 158	java/lang/Throwable:printStackTrace	(Ljava/io/PrintWriter;)V
    //   278: ldc 64
    //   280: new 160	java/lang/StringBuilder
    //   283: dup
    //   284: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   287: ldc 163
    //   289: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   292: aload_3
    //   293: invokevirtual 171	java/io/StringWriter:toString	()Ljava/lang/String;
    //   296: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   299: invokevirtual 172	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   302: invokestatic 96	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   305: aload_1
    //   306: ifnull -274 -> 32
    //   309: aload_1
    //   310: invokevirtual 147	java/io/BufferedInputStream:close	()V
    //   313: goto -281 -> 32
    //   316: astore_1
    //   317: aload_1
    //   318: invokevirtual 102	java/io/IOException:printStackTrace	()V
    //   321: goto -289 -> 32
    //   324: astore_1
    //   325: aconst_null
    //   326: astore_2
    //   327: aload_2
    //   328: ifnull +7 -> 335
    //   331: aload_2
    //   332: invokevirtual 147	java/io/BufferedInputStream:close	()V
    //   335: aload_1
    //   336: athrow
    //   337: astore_2
    //   338: aload_2
    //   339: invokevirtual 102	java/io/IOException:printStackTrace	()V
    //   342: goto -7 -> 335
    //   345: astore_1
    //   346: goto -19 -> 327
    //   349: astore_3
    //   350: aload_1
    //   351: astore_2
    //   352: aload_3
    //   353: astore_1
    //   354: goto -27 -> 327
    //   357: astore_3
    //   358: aload_2
    //   359: astore_1
    //   360: aload_3
    //   361: astore_2
    //   362: goto -104 -> 258
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	365	0	this	l
    //   3	1	1	localObject1	Object
    //   35	2	1	localIOException1	java.io.IOException
    //   43	4	1	localObject2	Object
    //   71	164	1	localObject3	Object
    //   249	61	1	localIOException2	java.io.IOException
    //   316	2	1	localIOException3	java.io.IOException
    //   324	12	1	localObject4	Object
    //   345	6	1	localObject5	Object
    //   353	7	1	localObject6	Object
    //   8	235	2	localObject7	Object
    //   257	10	2	localThrowable1	Throwable
    //   326	6	2	localObject8	Object
    //   337	2	2	localIOException4	java.io.IOException
    //   351	11	2	localObject9	Object
    //   85	208	3	localObject10	Object
    //   349	4	3	localObject11	Object
    //   357	4	3	localThrowable2	Throwable
    // Exception table:
    //   from	to	target	type
    //   24	32	35	java/io/IOException
    //   24	32	43	finally
    //   36	40	43	finally
    //   242	246	43	finally
    //   250	254	43	finally
    //   309	313	43	finally
    //   317	321	43	finally
    //   331	335	43	finally
    //   335	337	43	finally
    //   338	342	43	finally
    //   242	246	249	java/io/IOException
    //   4	9	257	java/lang/Throwable
    //   13	20	257	java/lang/Throwable
    //   48	64	257	java/lang/Throwable
    //   309	313	316	java/io/IOException
    //   4	9	324	finally
    //   13	20	324	finally
    //   48	64	324	finally
    //   331	335	337	java/io/IOException
    //   64	100	345	finally
    //   100	123	345	finally
    //   123	146	345	finally
    //   146	169	345	finally
    //   169	192	345	finally
    //   192	215	345	finally
    //   215	238	345	finally
    //   258	305	349	finally
    //   64	100	357	java/lang/Throwable
    //   100	123	357	java/lang/Throwable
    //   123	146	357	java/lang/Throwable
    //   146	169	357	java/lang/Throwable
    //   169	192	357	java/lang/Throwable
    //   192	215	357	java/lang/Throwable
    //   215	238	357	java/lang/Throwable
  }
  
  private File h()
  {
    int m = 1;
    label67:
    label326:
    for (;;)
    {
      Object localObject;
      int k;
      try
      {
        if (this.b != null) {
          break label216;
        }
        localObject = this.a.getApplicationContext().getApplicationInfo().packageName;
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          break label193;
        }
        if (this.a.getPackageManager().checkPermission("android.permission.READ_EXTERNAL_STORAGE", (String)localObject) != 0) {
          break label318;
        }
        k = 1;
        if (this.a.getPackageManager().checkPermission("android.permission.WRITE_EXTERNAL_STORAGE", (String)localObject) != 0) {
          break label323;
        }
      }
      catch (Throwable localThrowable1)
      {
        localObject = null;
      }
      TbsLog.i("TbsCommonConfig", "no permission,use sdcard default folder");
      this.b = new File(FileUtil.a(this.a, 5));
      if (this.b != null) {
        if (!this.b.isDirectory())
        {
          break label316;
          label113:
          this.b = new File(FileUtil.a(this.a, 8));
        }
        else
        {
          for (;;)
          {
            StringWriter localStringWriter = new StringWriter();
            localThrowable1.printStackTrace(new PrintWriter(localStringWriter));
            TbsLog.e("TbsCommonConfig", "exceptions occurred2:" + localStringWriter.toString());
            return localObject;
            this.b = new File(FileUtil.a(this.a, 8));
            break;
            label216:
            localObject = new File(this.b, "tbsnet.conf");
            if (!((File)localObject).exists())
            {
              TbsLog.e("TbsCommonConfig", "Get file(" + ((File)localObject).getCanonicalPath() + ") failed!");
              return null;
            }
            try
            {
              TbsLog.w("TbsCommonConfig", "pathc:" + ((File)localObject).getCanonicalPath());
              return localObject;
            }
            catch (Throwable localThrowable2) {}
          }
        }
      }
      for (;;)
      {
        if (k != 0) {
          break label326;
        }
        if (m == 0) {
          break label113;
        }
        break label67;
        return null;
        k = 0;
        break;
        m = 0;
      }
    }
  }
  
  public String b()
  {
    return this.d;
  }
  
  public String c()
  {
    return this.f;
  }
  
  public String d()
  {
    return this.g;
  }
  
  public String e()
  {
    return this.h;
  }
  
  public String f()
  {
    return this.e;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.smtt.utils.l
 * JD-Core Version:    0.7.0.1
 */