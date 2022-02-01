package com.tencent.smtt.utils;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;

public class m
{
  private static m c = null;
  private Context a = null;
  private File b = null;
  private String d = "https://log.tbs.qq.com/ajax?c=pu&v=2&k=";
  private String e = "https://log.tbs.qq.com/ajax?c=pu&tk=";
  private String f = "https://log.tbs.qq.com/ajax?c=dl&k=";
  private String g = "https://cfg.imtt.qq.com/tbs?v=2&mk=";
  private String h = "https://log.tbs.qq.com/ajax?c=ul&v=2&k=";
  private String i = "https://mqqad.html5.qq.com/adjs";
  private String j = "https://log.tbs.qq.com/ajax?c=ucfu&k=";
  private String k = "https://tbsrecovery.imtt.qq.com/getconfig";
  
  @TargetApi(11)
  private m(Context paramContext)
  {
    TbsLog.w("TbsCommonConfig", "TbsCommonConfig constructing...");
    this.a = paramContext.getApplicationContext();
    h();
  }
  
  public static m a()
  {
    try
    {
      m localm = c;
      return localm;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static m a(Context paramContext)
  {
    try
    {
      if (c == null) {
        c = new m(paramContext);
      }
      paramContext = c;
      return paramContext;
    }
    finally {}
  }
  
  /* Error */
  private void h()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aconst_null
    //   3: astore_1
    //   4: aload_0
    //   5: invokespecial 97	com/tencent/smtt/utils/m:i	()Ljava/io/File;
    //   8: astore_2
    //   9: aload_2
    //   10: ifnonnull +38 -> 48
    //   13: ldc 69
    //   15: ldc 99
    //   17: invokestatic 101	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   20: iconst_0
    //   21: ifeq +11 -> 32
    //   24: new 103	java/lang/NullPointerException
    //   27: dup
    //   28: invokespecial 104	java/lang/NullPointerException:<init>	()V
    //   31: athrow
    //   32: aload_0
    //   33: monitorexit
    //   34: return
    //   35: astore_1
    //   36: aload_1
    //   37: invokevirtual 107	java/io/IOException:printStackTrace	()V
    //   40: goto -8 -> 32
    //   43: astore_1
    //   44: aload_0
    //   45: monitorexit
    //   46: aload_1
    //   47: athrow
    //   48: new 109	java/io/BufferedInputStream
    //   51: dup
    //   52: new 111	java/io/FileInputStream
    //   55: dup
    //   56: aload_2
    //   57: invokespecial 114	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   60: invokespecial 117	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   63: astore_2
    //   64: new 119	java/util/Properties
    //   67: dup
    //   68: invokespecial 120	java/util/Properties:<init>	()V
    //   71: astore_1
    //   72: aload_1
    //   73: aload_2
    //   74: invokevirtual 123	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   77: aload_1
    //   78: ldc 125
    //   80: ldc 127
    //   82: invokevirtual 131	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   85: astore_3
    //   86: ldc 127
    //   88: aload_3
    //   89: invokevirtual 137	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   92: ifne +8 -> 100
    //   95: aload_0
    //   96: aload_3
    //   97: putfield 39	com/tencent/smtt/utils/m:d	Ljava/lang/String;
    //   100: aload_1
    //   101: ldc 139
    //   103: ldc 127
    //   105: invokevirtual 131	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   108: astore_3
    //   109: ldc 127
    //   111: aload_3
    //   112: invokevirtual 137	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   115: ifne +8 -> 123
    //   118: aload_0
    //   119: aload_3
    //   120: putfield 47	com/tencent/smtt/utils/m:f	Ljava/lang/String;
    //   123: aload_1
    //   124: ldc 141
    //   126: ldc 127
    //   128: invokevirtual 131	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   131: astore_3
    //   132: ldc 127
    //   134: aload_3
    //   135: invokevirtual 137	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   138: ifne +8 -> 146
    //   141: aload_0
    //   142: aload_3
    //   143: putfield 51	com/tencent/smtt/utils/m:g	Ljava/lang/String;
    //   146: aload_1
    //   147: ldc 143
    //   149: ldc 127
    //   151: invokevirtual 131	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   154: astore_3
    //   155: ldc 127
    //   157: aload_3
    //   158: invokevirtual 137	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   161: ifne +8 -> 169
    //   164: aload_0
    //   165: aload_3
    //   166: putfield 55	com/tencent/smtt/utils/m:h	Ljava/lang/String;
    //   169: aload_1
    //   170: ldc 145
    //   172: ldc 127
    //   174: invokevirtual 131	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   177: astore_3
    //   178: ldc 127
    //   180: aload_3
    //   181: invokevirtual 137	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   184: ifne +8 -> 192
    //   187: aload_0
    //   188: aload_3
    //   189: putfield 59	com/tencent/smtt/utils/m:i	Ljava/lang/String;
    //   192: aload_1
    //   193: ldc 147
    //   195: ldc 127
    //   197: invokevirtual 131	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   200: astore_3
    //   201: ldc 127
    //   203: aload_3
    //   204: invokevirtual 137	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   207: ifne +8 -> 215
    //   210: aload_0
    //   211: aload_3
    //   212: putfield 63	com/tencent/smtt/utils/m:j	Ljava/lang/String;
    //   215: aload_1
    //   216: ldc 149
    //   218: ldc 127
    //   220: invokevirtual 131	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   223: astore_3
    //   224: ldc 127
    //   226: aload_3
    //   227: invokevirtual 137	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   230: ifne +8 -> 238
    //   233: aload_0
    //   234: aload_3
    //   235: putfield 67	com/tencent/smtt/utils/m:k	Ljava/lang/String;
    //   238: aload_1
    //   239: ldc 151
    //   241: ldc 127
    //   243: invokevirtual 131	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   246: astore_1
    //   247: ldc 127
    //   249: aload_1
    //   250: invokevirtual 137	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   253: ifne +8 -> 261
    //   256: aload_0
    //   257: aload_1
    //   258: putfield 43	com/tencent/smtt/utils/m:e	Ljava/lang/String;
    //   261: aload_2
    //   262: ifnull -230 -> 32
    //   265: aload_2
    //   266: invokevirtual 154	java/io/BufferedInputStream:close	()V
    //   269: goto -237 -> 32
    //   272: astore_1
    //   273: aload_1
    //   274: invokevirtual 107	java/io/IOException:printStackTrace	()V
    //   277: goto -245 -> 32
    //   280: astore_2
    //   281: new 156	java/io/StringWriter
    //   284: dup
    //   285: invokespecial 157	java/io/StringWriter:<init>	()V
    //   288: astore_3
    //   289: aload_2
    //   290: new 159	java/io/PrintWriter
    //   293: dup
    //   294: aload_3
    //   295: invokespecial 162	java/io/PrintWriter:<init>	(Ljava/io/Writer;)V
    //   298: invokevirtual 165	java/lang/Throwable:printStackTrace	(Ljava/io/PrintWriter;)V
    //   301: ldc 69
    //   303: new 167	java/lang/StringBuilder
    //   306: dup
    //   307: invokespecial 168	java/lang/StringBuilder:<init>	()V
    //   310: ldc 170
    //   312: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   315: aload_3
    //   316: invokevirtual 178	java/io/StringWriter:toString	()Ljava/lang/String;
    //   319: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   322: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   325: invokestatic 101	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   328: aload_1
    //   329: ifnull -297 -> 32
    //   332: aload_1
    //   333: invokevirtual 154	java/io/BufferedInputStream:close	()V
    //   336: goto -304 -> 32
    //   339: astore_1
    //   340: aload_1
    //   341: invokevirtual 107	java/io/IOException:printStackTrace	()V
    //   344: goto -312 -> 32
    //   347: astore_1
    //   348: aconst_null
    //   349: astore_2
    //   350: aload_2
    //   351: ifnull +7 -> 358
    //   354: aload_2
    //   355: invokevirtual 154	java/io/BufferedInputStream:close	()V
    //   358: aload_1
    //   359: athrow
    //   360: astore_2
    //   361: aload_2
    //   362: invokevirtual 107	java/io/IOException:printStackTrace	()V
    //   365: goto -7 -> 358
    //   368: astore_1
    //   369: goto -19 -> 350
    //   372: astore_3
    //   373: aload_1
    //   374: astore_2
    //   375: aload_3
    //   376: astore_1
    //   377: goto -27 -> 350
    //   380: astore_3
    //   381: aload_2
    //   382: astore_1
    //   383: aload_3
    //   384: astore_2
    //   385: goto -104 -> 281
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	388	0	this	m
    //   3	1	1	localObject1	Object
    //   35	2	1	localIOException1	java.io.IOException
    //   43	4	1	localObject2	Object
    //   71	187	1	localObject3	Object
    //   272	61	1	localIOException2	java.io.IOException
    //   339	2	1	localIOException3	java.io.IOException
    //   347	12	1	localObject4	Object
    //   368	6	1	localObject5	Object
    //   376	7	1	localObject6	Object
    //   8	258	2	localObject7	Object
    //   280	10	2	localThrowable1	Throwable
    //   349	6	2	localObject8	Object
    //   360	2	2	localIOException4	java.io.IOException
    //   374	11	2	localObject9	Object
    //   85	231	3	localObject10	Object
    //   372	4	3	localObject11	Object
    //   380	4	3	localThrowable2	Throwable
    // Exception table:
    //   from	to	target	type
    //   24	32	35	java/io/IOException
    //   24	32	43	finally
    //   36	40	43	finally
    //   265	269	43	finally
    //   273	277	43	finally
    //   332	336	43	finally
    //   340	344	43	finally
    //   354	358	43	finally
    //   358	360	43	finally
    //   361	365	43	finally
    //   265	269	272	java/io/IOException
    //   4	9	280	java/lang/Throwable
    //   13	20	280	java/lang/Throwable
    //   48	64	280	java/lang/Throwable
    //   332	336	339	java/io/IOException
    //   4	9	347	finally
    //   13	20	347	finally
    //   48	64	347	finally
    //   354	358	360	java/io/IOException
    //   64	100	368	finally
    //   100	123	368	finally
    //   123	146	368	finally
    //   146	169	368	finally
    //   169	192	368	finally
    //   192	215	368	finally
    //   215	238	368	finally
    //   238	261	368	finally
    //   281	328	372	finally
    //   64	100	380	java/lang/Throwable
    //   100	123	380	java/lang/Throwable
    //   123	146	380	java/lang/Throwable
    //   146	169	380	java/lang/Throwable
    //   169	192	380	java/lang/Throwable
    //   192	215	380	java/lang/Throwable
    //   215	238	380	java/lang/Throwable
    //   238	261	380	java/lang/Throwable
  }
  
  private File i()
  {
    int n = 1;
    label67:
    label326:
    for (;;)
    {
      Object localObject;
      int m;
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
        m = 1;
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
        if (m != 0) {
          break label326;
        }
        if (n == 0) {
          break label113;
        }
        break label67;
        return null;
        m = 0;
        break;
        n = 0;
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
  
  public String g()
  {
    return this.k;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.smtt.utils.m
 * JD-Core Version:    0.7.0.1
 */