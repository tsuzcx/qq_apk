package com.tencent.smtt.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class TbsDownloadUpload
{
  private static TbsDownloadUpload b;
  Map<String, Object> a = new HashMap();
  private Context c;
  private int d;
  private int e;
  private int f;
  private int g;
  private int h;
  private int i;
  public SharedPreferences mPreferences;
  
  public TbsDownloadUpload(Context paramContext)
  {
    this.mPreferences = paramContext.getSharedPreferences("tbs_download_upload", 4);
    this.c = paramContext.getApplicationContext();
    if (this.c == null) {
      this.c = paramContext;
    }
  }
  
  private static File a(Context paramContext, String paramString)
  {
    p.a();
    paramContext = p.s(paramContext);
    if (paramContext == null) {
      return null;
    }
    paramContext = new File(paramContext, paramString);
    if ((paramContext != null) && (paramContext.exists())) {
      return paramContext;
    }
    try
    {
      paramContext.createNewFile();
      return paramContext;
    }
    catch (IOException paramContext)
    {
      paramContext.printStackTrace();
    }
    return null;
  }
  
  public static void clear()
  {
    try
    {
      b = null;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static TbsDownloadUpload getInstance()
  {
    try
    {
      TbsDownloadUpload localTbsDownloadUpload = b;
      return localTbsDownloadUpload;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static TbsDownloadUpload getInstance(Context paramContext)
  {
    try
    {
      if (b == null) {
        b = new TbsDownloadUpload(paramContext);
      }
      paramContext = b;
      return paramContext;
    }
    finally {}
  }
  
  public void clearUploadCode()
  {
    this.a.put("tbs_needdownload_code", Integer.valueOf(0));
    this.a.put("tbs_startdownload_code", Integer.valueOf(0));
    this.a.put("tbs_needdownload_return", Integer.valueOf(0));
    this.a.put("tbs_needdownload_sent", Integer.valueOf(0));
    this.a.put("tbs_startdownload_sent", Integer.valueOf(0));
    this.a.put("tbs_local_core_version", Integer.valueOf(0));
    writeTbsDownloadInfo();
  }
  
  public void commit()
  {
    try
    {
      writeTbsDownloadInfo();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public int getLocalCoreVersion()
  {
    try
    {
      int j = this.i;
      return j;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public int getNeedDownloadCode()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 118	com/tencent/smtt/sdk/TbsDownloadUpload:g	I
    //   6: istore_1
    //   7: iload_1
    //   8: iconst_1
    //   9: if_icmpne +11 -> 20
    //   12: sipush 148
    //   15: istore_1
    //   16: aload_0
    //   17: monitorexit
    //   18: iload_1
    //   19: ireturn
    //   20: aload_0
    //   21: getfield 120	com/tencent/smtt/sdk/TbsDownloadUpload:d	I
    //   24: istore_1
    //   25: goto -9 -> 16
    //   28: astore_2
    //   29: aload_0
    //   30: monitorexit
    //   31: aload_2
    //   32: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	33	0	this	TbsDownloadUpload
    //   6	19	1	j	int
    //   28	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	28	finally
    //   20	25	28	finally
  }
  
  public int getNeedDownloadReturn()
  {
    try
    {
      int j = this.f;
      return j;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public int getStartDownloadCode()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 126	com/tencent/smtt/sdk/TbsDownloadUpload:h	I
    //   6: istore_1
    //   7: iload_1
    //   8: iconst_1
    //   9: if_icmpne +11 -> 20
    //   12: sipush 168
    //   15: istore_1
    //   16: aload_0
    //   17: monitorexit
    //   18: iload_1
    //   19: ireturn
    //   20: aload_0
    //   21: getfield 128	com/tencent/smtt/sdk/TbsDownloadUpload:e	I
    //   24: istore_1
    //   25: goto -9 -> 16
    //   28: astore_2
    //   29: aload_0
    //   30: monitorexit
    //   31: aload_2
    //   32: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	33	0	this	TbsDownloadUpload
    //   6	19	1	j	int
    //   28	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	28	finally
    //   20	25	28	finally
  }
  
  /* Error */
  public void readTbsDownloadInfo(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 46	com/tencent/smtt/sdk/TbsDownloadUpload:c	Landroid/content/Context;
    //   6: ldc 135
    //   8: invokestatic 137	com/tencent/smtt/sdk/TbsDownloadUpload:a	(Landroid/content/Context;Ljava/lang/String;)Ljava/io/File;
    //   11: astore_1
    //   12: aload_1
    //   13: ifnonnull +31 -> 44
    //   16: iconst_0
    //   17: ifeq +11 -> 28
    //   20: new 139	java/lang/NullPointerException
    //   23: dup
    //   24: invokespecial 140	java/lang/NullPointerException:<init>	()V
    //   27: athrow
    //   28: aload_0
    //   29: monitorexit
    //   30: return
    //   31: astore_1
    //   32: aload_1
    //   33: invokevirtual 141	java/lang/Exception:printStackTrace	()V
    //   36: goto -8 -> 28
    //   39: astore_1
    //   40: aload_0
    //   41: monitorexit
    //   42: aload_1
    //   43: athrow
    //   44: new 143	java/io/BufferedInputStream
    //   47: dup
    //   48: new 145	java/io/FileInputStream
    //   51: dup
    //   52: aload_1
    //   53: invokespecial 148	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   56: invokespecial 151	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   59: astore_2
    //   60: aload_2
    //   61: astore_1
    //   62: new 153	java/util/Properties
    //   65: dup
    //   66: invokespecial 154	java/util/Properties:<init>	()V
    //   69: astore_3
    //   70: aload_2
    //   71: astore_1
    //   72: aload_3
    //   73: aload_2
    //   74: invokevirtual 157	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   77: aload_2
    //   78: astore_1
    //   79: aload_3
    //   80: ldc 85
    //   82: ldc 159
    //   84: invokevirtual 163	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   87: astore 4
    //   89: aload_2
    //   90: astore_1
    //   91: ldc 159
    //   93: aload 4
    //   95: invokevirtual 169	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   98: ifne +18 -> 116
    //   101: aload_2
    //   102: astore_1
    //   103: aload_0
    //   104: aload 4
    //   106: invokestatic 173	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   109: iconst_0
    //   110: invokestatic 179	java/lang/Math:max	(II)I
    //   113: putfield 120	com/tencent/smtt/sdk/TbsDownloadUpload:d	I
    //   116: aload_2
    //   117: astore_1
    //   118: aload_3
    //   119: ldc 99
    //   121: ldc 159
    //   123: invokevirtual 163	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   126: astore 4
    //   128: aload_2
    //   129: astore_1
    //   130: ldc 159
    //   132: aload 4
    //   134: invokevirtual 169	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   137: ifne +18 -> 155
    //   140: aload_2
    //   141: astore_1
    //   142: aload_0
    //   143: aload 4
    //   145: invokestatic 173	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   148: iconst_0
    //   149: invokestatic 179	java/lang/Math:max	(II)I
    //   152: putfield 128	com/tencent/smtt/sdk/TbsDownloadUpload:e	I
    //   155: aload_2
    //   156: astore_1
    //   157: aload_3
    //   158: ldc 101
    //   160: ldc 159
    //   162: invokevirtual 163	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   165: astore 4
    //   167: aload_2
    //   168: astore_1
    //   169: ldc 159
    //   171: aload 4
    //   173: invokevirtual 169	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   176: ifne +18 -> 194
    //   179: aload_2
    //   180: astore_1
    //   181: aload_0
    //   182: aload 4
    //   184: invokestatic 173	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   187: iconst_0
    //   188: invokestatic 179	java/lang/Math:max	(II)I
    //   191: putfield 123	com/tencent/smtt/sdk/TbsDownloadUpload:f	I
    //   194: aload_2
    //   195: astore_1
    //   196: aload_3
    //   197: ldc 103
    //   199: ldc 159
    //   201: invokevirtual 163	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   204: astore 4
    //   206: aload_2
    //   207: astore_1
    //   208: ldc 159
    //   210: aload 4
    //   212: invokevirtual 169	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   215: ifne +18 -> 233
    //   218: aload_2
    //   219: astore_1
    //   220: aload_0
    //   221: aload 4
    //   223: invokestatic 173	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   226: iconst_0
    //   227: invokestatic 179	java/lang/Math:max	(II)I
    //   230: putfield 118	com/tencent/smtt/sdk/TbsDownloadUpload:g	I
    //   233: aload_2
    //   234: astore_1
    //   235: aload_3
    //   236: ldc 105
    //   238: ldc 159
    //   240: invokevirtual 163	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   243: astore 4
    //   245: aload_2
    //   246: astore_1
    //   247: ldc 159
    //   249: aload 4
    //   251: invokevirtual 169	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   254: ifne +18 -> 272
    //   257: aload_2
    //   258: astore_1
    //   259: aload_0
    //   260: aload 4
    //   262: invokestatic 173	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   265: iconst_0
    //   266: invokestatic 179	java/lang/Math:max	(II)I
    //   269: putfield 126	com/tencent/smtt/sdk/TbsDownloadUpload:h	I
    //   272: aload_2
    //   273: astore_1
    //   274: aload_3
    //   275: ldc 107
    //   277: ldc 159
    //   279: invokevirtual 163	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   282: astore_3
    //   283: aload_2
    //   284: astore_1
    //   285: ldc 159
    //   287: aload_3
    //   288: invokevirtual 169	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   291: ifne +17 -> 308
    //   294: aload_2
    //   295: astore_1
    //   296: aload_0
    //   297: aload_3
    //   298: invokestatic 173	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   301: iconst_0
    //   302: invokestatic 179	java/lang/Math:max	(II)I
    //   305: putfield 115	com/tencent/smtt/sdk/TbsDownloadUpload:i	I
    //   308: aload_2
    //   309: ifnull -281 -> 28
    //   312: aload_2
    //   313: invokevirtual 182	java/io/BufferedInputStream:close	()V
    //   316: goto -288 -> 28
    //   319: astore_1
    //   320: aload_1
    //   321: invokevirtual 141	java/lang/Exception:printStackTrace	()V
    //   324: goto -296 -> 28
    //   327: astore_3
    //   328: aconst_null
    //   329: astore_2
    //   330: aload_2
    //   331: astore_1
    //   332: aload_3
    //   333: invokevirtual 183	java/lang/Throwable:printStackTrace	()V
    //   336: aload_2
    //   337: ifnull -309 -> 28
    //   340: aload_2
    //   341: invokevirtual 182	java/io/BufferedInputStream:close	()V
    //   344: goto -316 -> 28
    //   347: astore_1
    //   348: aload_1
    //   349: invokevirtual 141	java/lang/Exception:printStackTrace	()V
    //   352: goto -324 -> 28
    //   355: astore_2
    //   356: aconst_null
    //   357: astore_1
    //   358: aload_1
    //   359: ifnull +7 -> 366
    //   362: aload_1
    //   363: invokevirtual 182	java/io/BufferedInputStream:close	()V
    //   366: aload_2
    //   367: athrow
    //   368: astore_1
    //   369: aload_1
    //   370: invokevirtual 141	java/lang/Exception:printStackTrace	()V
    //   373: goto -7 -> 366
    //   376: astore_2
    //   377: goto -19 -> 358
    //   380: astore_3
    //   381: goto -51 -> 330
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	384	0	this	TbsDownloadUpload
    //   0	384	1	paramContext	Context
    //   59	282	2	localBufferedInputStream	java.io.BufferedInputStream
    //   355	12	2	localObject1	Object
    //   376	1	2	localObject2	Object
    //   69	229	3	localObject3	Object
    //   327	6	3	localThrowable1	java.lang.Throwable
    //   380	1	3	localThrowable2	java.lang.Throwable
    //   87	174	4	str	String
    // Exception table:
    //   from	to	target	type
    //   20	28	31	java/lang/Exception
    //   20	28	39	finally
    //   32	36	39	finally
    //   312	316	39	finally
    //   320	324	39	finally
    //   340	344	39	finally
    //   348	352	39	finally
    //   362	366	39	finally
    //   366	368	39	finally
    //   369	373	39	finally
    //   312	316	319	java/lang/Exception
    //   2	12	327	java/lang/Throwable
    //   44	60	327	java/lang/Throwable
    //   340	344	347	java/lang/Exception
    //   2	12	355	finally
    //   44	60	355	finally
    //   362	366	368	java/lang/Exception
    //   62	70	376	finally
    //   72	77	376	finally
    //   79	89	376	finally
    //   91	101	376	finally
    //   103	116	376	finally
    //   118	128	376	finally
    //   130	140	376	finally
    //   142	155	376	finally
    //   157	167	376	finally
    //   169	179	376	finally
    //   181	194	376	finally
    //   196	206	376	finally
    //   208	218	376	finally
    //   220	233	376	finally
    //   235	245	376	finally
    //   247	257	376	finally
    //   259	272	376	finally
    //   274	283	376	finally
    //   285	294	376	finally
    //   296	308	376	finally
    //   332	336	376	finally
    //   62	70	380	java/lang/Throwable
    //   72	77	380	java/lang/Throwable
    //   79	89	380	java/lang/Throwable
    //   91	101	380	java/lang/Throwable
    //   103	116	380	java/lang/Throwable
    //   118	128	380	java/lang/Throwable
    //   130	140	380	java/lang/Throwable
    //   142	155	380	java/lang/Throwable
    //   157	167	380	java/lang/Throwable
    //   169	179	380	java/lang/Throwable
    //   181	194	380	java/lang/Throwable
    //   196	206	380	java/lang/Throwable
    //   208	218	380	java/lang/Throwable
    //   220	233	380	java/lang/Throwable
    //   235	245	380	java/lang/Throwable
    //   247	257	380	java/lang/Throwable
    //   259	272	380	java/lang/Throwable
    //   274	283	380	java/lang/Throwable
    //   285	294	380	java/lang/Throwable
    //   296	308	380	java/lang/Throwable
  }
  
  /* Error */
  public void writeTbsDownloadInfo()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore 4
    //   5: aload_0
    //   6: monitorenter
    //   7: ldc 185
    //   9: ldc 187
    //   11: invokestatic 192	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   14: aload_0
    //   15: getfield 46	com/tencent/smtt/sdk/TbsDownloadUpload:c	Landroid/content/Context;
    //   18: ldc 135
    //   20: invokestatic 137	com/tencent/smtt/sdk/TbsDownloadUpload:a	(Landroid/content/Context;Ljava/lang/String;)Ljava/io/File;
    //   23: astore 7
    //   25: aload 7
    //   27: ifnonnull +51 -> 78
    //   30: iconst_0
    //   31: ifeq +11 -> 42
    //   34: new 139	java/lang/NullPointerException
    //   37: dup
    //   38: invokespecial 140	java/lang/NullPointerException:<init>	()V
    //   41: athrow
    //   42: iconst_0
    //   43: ifeq +11 -> 54
    //   46: new 139	java/lang/NullPointerException
    //   49: dup
    //   50: invokespecial 140	java/lang/NullPointerException:<init>	()V
    //   53: athrow
    //   54: aload_0
    //   55: monitorexit
    //   56: return
    //   57: astore_1
    //   58: aload_1
    //   59: invokevirtual 141	java/lang/Exception:printStackTrace	()V
    //   62: goto -20 -> 42
    //   65: astore_1
    //   66: aload_0
    //   67: monitorexit
    //   68: aload_1
    //   69: athrow
    //   70: astore_1
    //   71: aload_1
    //   72: invokevirtual 141	java/lang/Exception:printStackTrace	()V
    //   75: goto -21 -> 54
    //   78: new 143	java/io/BufferedInputStream
    //   81: dup
    //   82: new 145	java/io/FileInputStream
    //   85: dup
    //   86: aload 7
    //   88: invokespecial 148	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   91: invokespecial 151	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   94: astore_2
    //   95: new 153	java/util/Properties
    //   98: dup
    //   99: invokespecial 154	java/util/Properties:<init>	()V
    //   102: astore 5
    //   104: aload 5
    //   106: aload_2
    //   107: invokevirtual 157	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   110: aload_0
    //   111: getfield 30	com/tencent/smtt/sdk/TbsDownloadUpload:a	Ljava/util/Map;
    //   114: invokeinterface 196 1 0
    //   119: invokeinterface 202 1 0
    //   124: astore_1
    //   125: aload_1
    //   126: invokeinterface 207 1 0
    //   131: ifeq +130 -> 261
    //   134: aload_1
    //   135: invokeinterface 211 1 0
    //   140: checkcast 165	java/lang/String
    //   143: astore 8
    //   145: aload_0
    //   146: getfield 30	com/tencent/smtt/sdk/TbsDownloadUpload:a	Ljava/util/Map;
    //   149: aload 8
    //   151: invokeinterface 215 2 0
    //   156: astore 6
    //   158: aload 5
    //   160: aload 8
    //   162: new 217	java/lang/StringBuilder
    //   165: dup
    //   166: invokespecial 218	java/lang/StringBuilder:<init>	()V
    //   169: ldc 159
    //   171: invokevirtual 222	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   174: aload 6
    //   176: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   179: invokevirtual 229	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   182: invokevirtual 233	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   185: pop
    //   186: ldc 185
    //   188: new 217	java/lang/StringBuilder
    //   191: dup
    //   192: invokespecial 218	java/lang/StringBuilder:<init>	()V
    //   195: ldc 235
    //   197: invokevirtual 222	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   200: aload 8
    //   202: invokevirtual 222	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   205: ldc 237
    //   207: invokevirtual 222	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   210: aload 6
    //   212: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   215: invokevirtual 229	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   218: invokestatic 192	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   221: goto -96 -> 125
    //   224: astore_3
    //   225: aload_2
    //   226: astore_1
    //   227: aload 4
    //   229: astore_2
    //   230: aload_3
    //   231: invokevirtual 183	java/lang/Throwable:printStackTrace	()V
    //   234: aload_1
    //   235: ifnull +7 -> 242
    //   238: aload_1
    //   239: invokevirtual 182	java/io/BufferedInputStream:close	()V
    //   242: aload_2
    //   243: ifnull -189 -> 54
    //   246: aload_2
    //   247: invokevirtual 240	java/io/BufferedOutputStream:close	()V
    //   250: goto -196 -> 54
    //   253: astore_1
    //   254: aload_1
    //   255: invokevirtual 141	java/lang/Exception:printStackTrace	()V
    //   258: goto -204 -> 54
    //   261: aload_0
    //   262: getfield 30	com/tencent/smtt/sdk/TbsDownloadUpload:a	Ljava/util/Map;
    //   265: invokeinterface 242 1 0
    //   270: new 239	java/io/BufferedOutputStream
    //   273: dup
    //   274: new 244	java/io/FileOutputStream
    //   277: dup
    //   278: aload 7
    //   280: invokespecial 245	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   283: invokespecial 248	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   286: astore_1
    //   287: aload 5
    //   289: aload_1
    //   290: aconst_null
    //   291: invokevirtual 252	java/util/Properties:store	(Ljava/io/OutputStream;Ljava/lang/String;)V
    //   294: aload_2
    //   295: ifnull +7 -> 302
    //   298: aload_2
    //   299: invokevirtual 182	java/io/BufferedInputStream:close	()V
    //   302: aload_1
    //   303: ifnull -249 -> 54
    //   306: aload_1
    //   307: invokevirtual 240	java/io/BufferedOutputStream:close	()V
    //   310: goto -256 -> 54
    //   313: astore_1
    //   314: aload_1
    //   315: invokevirtual 141	java/lang/Exception:printStackTrace	()V
    //   318: goto -264 -> 54
    //   321: astore_2
    //   322: aload_2
    //   323: invokevirtual 141	java/lang/Exception:printStackTrace	()V
    //   326: goto -24 -> 302
    //   329: astore_1
    //   330: aload_1
    //   331: invokevirtual 141	java/lang/Exception:printStackTrace	()V
    //   334: goto -92 -> 242
    //   337: astore_1
    //   338: aconst_null
    //   339: astore_2
    //   340: aload_2
    //   341: ifnull +7 -> 348
    //   344: aload_2
    //   345: invokevirtual 182	java/io/BufferedInputStream:close	()V
    //   348: aload_3
    //   349: ifnull +7 -> 356
    //   352: aload_3
    //   353: invokevirtual 240	java/io/BufferedOutputStream:close	()V
    //   356: aload_1
    //   357: athrow
    //   358: astore_2
    //   359: aload_2
    //   360: invokevirtual 141	java/lang/Exception:printStackTrace	()V
    //   363: goto -15 -> 348
    //   366: astore_2
    //   367: aload_2
    //   368: invokevirtual 141	java/lang/Exception:printStackTrace	()V
    //   371: goto -15 -> 356
    //   374: astore_1
    //   375: goto -35 -> 340
    //   378: astore 4
    //   380: aload_1
    //   381: astore_3
    //   382: aload 4
    //   384: astore_1
    //   385: goto -45 -> 340
    //   388: astore_3
    //   389: aload_1
    //   390: astore 4
    //   392: aload_3
    //   393: astore_1
    //   394: aload_2
    //   395: astore_3
    //   396: aload 4
    //   398: astore_2
    //   399: goto -59 -> 340
    //   402: astore_3
    //   403: aconst_null
    //   404: astore_1
    //   405: aload 4
    //   407: astore_2
    //   408: goto -178 -> 230
    //   411: astore_3
    //   412: aload_1
    //   413: astore 4
    //   415: aload_2
    //   416: astore_1
    //   417: aload 4
    //   419: astore_2
    //   420: goto -190 -> 230
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	423	0	this	TbsDownloadUpload
    //   57	2	1	localException1	java.lang.Exception
    //   65	4	1	localObject1	Object
    //   70	2	1	localException2	java.lang.Exception
    //   124	115	1	localObject2	Object
    //   253	2	1	localException3	java.lang.Exception
    //   286	21	1	localBufferedOutputStream	java.io.BufferedOutputStream
    //   313	2	1	localException4	java.lang.Exception
    //   329	2	1	localException5	java.lang.Exception
    //   337	20	1	localObject3	Object
    //   374	7	1	localObject4	Object
    //   384	33	1	localObject5	Object
    //   94	205	2	localObject6	Object
    //   321	2	2	localException6	java.lang.Exception
    //   339	6	2	localObject7	Object
    //   358	2	2	localException7	java.lang.Exception
    //   366	29	2	localException8	java.lang.Exception
    //   398	22	2	localObject8	Object
    //   1	1	3	localObject9	Object
    //   224	129	3	localThrowable1	java.lang.Throwable
    //   381	1	3	localObject10	Object
    //   388	5	3	localObject11	Object
    //   395	1	3	localObject12	Object
    //   402	1	3	localThrowable2	java.lang.Throwable
    //   411	1	3	localThrowable3	java.lang.Throwable
    //   3	225	4	localObject13	Object
    //   378	5	4	localObject14	Object
    //   390	28	4	localObject15	Object
    //   102	186	5	localProperties	java.util.Properties
    //   156	55	6	localObject16	Object
    //   23	256	7	localFile	File
    //   143	58	8	str	String
    // Exception table:
    //   from	to	target	type
    //   34	42	57	java/lang/Exception
    //   7	14	65	finally
    //   34	42	65	finally
    //   46	54	65	finally
    //   58	62	65	finally
    //   71	75	65	finally
    //   238	242	65	finally
    //   246	250	65	finally
    //   254	258	65	finally
    //   298	302	65	finally
    //   306	310	65	finally
    //   314	318	65	finally
    //   322	326	65	finally
    //   330	334	65	finally
    //   344	348	65	finally
    //   352	356	65	finally
    //   356	358	65	finally
    //   359	363	65	finally
    //   367	371	65	finally
    //   46	54	70	java/lang/Exception
    //   95	125	224	java/lang/Throwable
    //   125	221	224	java/lang/Throwable
    //   261	287	224	java/lang/Throwable
    //   246	250	253	java/lang/Exception
    //   306	310	313	java/lang/Exception
    //   298	302	321	java/lang/Exception
    //   238	242	329	java/lang/Exception
    //   14	25	337	finally
    //   78	95	337	finally
    //   344	348	358	java/lang/Exception
    //   352	356	366	java/lang/Exception
    //   95	125	374	finally
    //   125	221	374	finally
    //   261	287	374	finally
    //   287	294	378	finally
    //   230	234	388	finally
    //   14	25	402	java/lang/Throwable
    //   78	95	402	java/lang/Throwable
    //   287	294	411	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.smtt.sdk.TbsDownloadUpload
 * JD-Core Version:    0.7.0.1
 */