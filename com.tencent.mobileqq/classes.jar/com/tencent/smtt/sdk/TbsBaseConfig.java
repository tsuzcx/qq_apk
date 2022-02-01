package com.tencent.smtt.sdk;

import android.content.Context;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public abstract class TbsBaseConfig
{
  public static final String TAG = "TbsBaseConfig";
  Map<String, String> a;
  private Context b;
  
  private static File a(Context paramContext, String paramString)
  {
    n.a();
    paramContext = n.s(paramContext);
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
  
  public void clear()
  {
    this.a.clear();
    commit();
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
  
  public abstract String getConfigFileName();
  
  public void init(Context paramContext)
  {
    this.a = new HashMap();
    this.b = paramContext.getApplicationContext();
    if (this.b == null) {
      this.b = paramContext;
    }
    refreshSyncMap(paramContext);
  }
  
  /* Error */
  public void refreshSyncMap(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 73	com/tencent/smtt/sdk/TbsBaseConfig:b	Landroid/content/Context;
    //   6: aload_0
    //   7: invokevirtual 82	com/tencent/smtt/sdk/TbsBaseConfig:getConfigFileName	()Ljava/lang/String;
    //   10: invokestatic 84	com/tencent/smtt/sdk/TbsBaseConfig:a	(Landroid/content/Context;Ljava/lang/String;)Ljava/io/File;
    //   13: astore_1
    //   14: aload_1
    //   15: ifnonnull +31 -> 46
    //   18: iconst_0
    //   19: ifeq +11 -> 30
    //   22: new 86	java/lang/NullPointerException
    //   25: dup
    //   26: invokespecial 87	java/lang/NullPointerException:<init>	()V
    //   29: athrow
    //   30: aload_0
    //   31: monitorexit
    //   32: return
    //   33: astore_1
    //   34: aload_1
    //   35: invokevirtual 88	java/lang/Exception:printStackTrace	()V
    //   38: goto -8 -> 30
    //   41: astore_1
    //   42: aload_0
    //   43: monitorexit
    //   44: aload_1
    //   45: athrow
    //   46: aload_0
    //   47: getfield 48	com/tencent/smtt/sdk/TbsBaseConfig:a	Ljava/util/Map;
    //   50: invokeinterface 52 1 0
    //   55: new 90	java/io/BufferedInputStream
    //   58: dup
    //   59: new 92	java/io/FileInputStream
    //   62: dup
    //   63: aload_1
    //   64: invokespecial 95	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   67: invokespecial 98	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   70: astore_2
    //   71: aload_2
    //   72: astore_1
    //   73: new 100	java/util/Properties
    //   76: dup
    //   77: invokespecial 101	java/util/Properties:<init>	()V
    //   80: astore_3
    //   81: aload_2
    //   82: astore_1
    //   83: aload_3
    //   84: aload_2
    //   85: invokevirtual 104	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   88: aload_2
    //   89: astore_1
    //   90: aload_3
    //   91: invokevirtual 108	java/util/Properties:stringPropertyNames	()Ljava/util/Set;
    //   94: invokeinterface 114 1 0
    //   99: astore 4
    //   101: aload_2
    //   102: astore_1
    //   103: aload 4
    //   105: invokeinterface 119 1 0
    //   110: ifeq +66 -> 176
    //   113: aload_2
    //   114: astore_1
    //   115: aload 4
    //   117: invokeinterface 123 1 0
    //   122: checkcast 125	java/lang/String
    //   125: astore 5
    //   127: aload_2
    //   128: astore_1
    //   129: aload_0
    //   130: getfield 48	com/tencent/smtt/sdk/TbsBaseConfig:a	Ljava/util/Map;
    //   133: aload 5
    //   135: aload_3
    //   136: aload 5
    //   138: invokevirtual 129	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   141: invokeinterface 133 3 0
    //   146: pop
    //   147: goto -46 -> 101
    //   150: astore_3
    //   151: aload_2
    //   152: astore_1
    //   153: aload_3
    //   154: invokevirtual 134	java/lang/Throwable:printStackTrace	()V
    //   157: aload_2
    //   158: ifnull -128 -> 30
    //   161: aload_2
    //   162: invokevirtual 137	java/io/BufferedInputStream:close	()V
    //   165: goto -135 -> 30
    //   168: astore_1
    //   169: aload_1
    //   170: invokevirtual 88	java/lang/Exception:printStackTrace	()V
    //   173: goto -143 -> 30
    //   176: aload_2
    //   177: ifnull -147 -> 30
    //   180: aload_2
    //   181: invokevirtual 137	java/io/BufferedInputStream:close	()V
    //   184: goto -154 -> 30
    //   187: astore_1
    //   188: aload_1
    //   189: invokevirtual 88	java/lang/Exception:printStackTrace	()V
    //   192: goto -162 -> 30
    //   195: astore_2
    //   196: aconst_null
    //   197: astore_1
    //   198: aload_1
    //   199: ifnull +7 -> 206
    //   202: aload_1
    //   203: invokevirtual 137	java/io/BufferedInputStream:close	()V
    //   206: aload_2
    //   207: athrow
    //   208: astore_1
    //   209: aload_1
    //   210: invokevirtual 88	java/lang/Exception:printStackTrace	()V
    //   213: goto -7 -> 206
    //   216: astore_2
    //   217: goto -19 -> 198
    //   220: astore_3
    //   221: aconst_null
    //   222: astore_2
    //   223: goto -72 -> 151
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	226	0	this	TbsBaseConfig
    //   0	226	1	paramContext	Context
    //   70	111	2	localBufferedInputStream	java.io.BufferedInputStream
    //   195	12	2	localObject1	Object
    //   216	1	2	localObject2	Object
    //   222	1	2	localObject3	Object
    //   80	56	3	localProperties	java.util.Properties
    //   150	4	3	localThrowable1	java.lang.Throwable
    //   220	1	3	localThrowable2	java.lang.Throwable
    //   99	17	4	localIterator	java.util.Iterator
    //   125	12	5	str	String
    // Exception table:
    //   from	to	target	type
    //   22	30	33	java/lang/Exception
    //   22	30	41	finally
    //   34	38	41	finally
    //   161	165	41	finally
    //   169	173	41	finally
    //   180	184	41	finally
    //   188	192	41	finally
    //   202	206	41	finally
    //   206	208	41	finally
    //   209	213	41	finally
    //   73	81	150	java/lang/Throwable
    //   83	88	150	java/lang/Throwable
    //   90	101	150	java/lang/Throwable
    //   103	113	150	java/lang/Throwable
    //   115	127	150	java/lang/Throwable
    //   129	147	150	java/lang/Throwable
    //   161	165	168	java/lang/Exception
    //   180	184	187	java/lang/Exception
    //   2	14	195	finally
    //   46	71	195	finally
    //   202	206	208	java/lang/Exception
    //   73	81	216	finally
    //   83	88	216	finally
    //   90	101	216	finally
    //   103	113	216	finally
    //   115	127	216	finally
    //   129	147	216	finally
    //   153	157	216	finally
    //   2	14	220	java/lang/Throwable
    //   46	71	220	java/lang/Throwable
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
    //   7: ldc 8
    //   9: ldc 139
    //   11: invokestatic 145	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   14: aload_0
    //   15: getfield 73	com/tencent/smtt/sdk/TbsBaseConfig:b	Landroid/content/Context;
    //   18: aload_0
    //   19: invokevirtual 82	com/tencent/smtt/sdk/TbsBaseConfig:getConfigFileName	()Ljava/lang/String;
    //   22: invokestatic 84	com/tencent/smtt/sdk/TbsBaseConfig:a	(Landroid/content/Context;Ljava/lang/String;)Ljava/io/File;
    //   25: astore 7
    //   27: aload 7
    //   29: ifnonnull +51 -> 80
    //   32: iconst_0
    //   33: ifeq +11 -> 44
    //   36: new 86	java/lang/NullPointerException
    //   39: dup
    //   40: invokespecial 87	java/lang/NullPointerException:<init>	()V
    //   43: athrow
    //   44: iconst_0
    //   45: ifeq +11 -> 56
    //   48: new 86	java/lang/NullPointerException
    //   51: dup
    //   52: invokespecial 87	java/lang/NullPointerException:<init>	()V
    //   55: athrow
    //   56: aload_0
    //   57: monitorexit
    //   58: return
    //   59: astore_1
    //   60: aload_1
    //   61: invokevirtual 88	java/lang/Exception:printStackTrace	()V
    //   64: goto -20 -> 44
    //   67: astore_1
    //   68: aload_0
    //   69: monitorexit
    //   70: aload_1
    //   71: athrow
    //   72: astore_1
    //   73: aload_1
    //   74: invokevirtual 88	java/lang/Exception:printStackTrace	()V
    //   77: goto -21 -> 56
    //   80: new 90	java/io/BufferedInputStream
    //   83: dup
    //   84: new 92	java/io/FileInputStream
    //   87: dup
    //   88: aload 7
    //   90: invokespecial 95	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   93: invokespecial 98	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   96: astore_2
    //   97: new 100	java/util/Properties
    //   100: dup
    //   101: invokespecial 101	java/util/Properties:<init>	()V
    //   104: astore 5
    //   106: aload 5
    //   108: aload_2
    //   109: invokevirtual 104	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   112: aload 5
    //   114: invokevirtual 146	java/util/Properties:clear	()V
    //   117: aload_0
    //   118: getfield 48	com/tencent/smtt/sdk/TbsBaseConfig:a	Ljava/util/Map;
    //   121: invokeinterface 149 1 0
    //   126: invokeinterface 114 1 0
    //   131: astore 6
    //   133: aload 6
    //   135: invokeinterface 119 1 0
    //   140: ifeq +127 -> 267
    //   143: aload 6
    //   145: invokeinterface 123 1 0
    //   150: checkcast 125	java/lang/String
    //   153: astore_1
    //   154: aload_0
    //   155: getfield 48	com/tencent/smtt/sdk/TbsBaseConfig:a	Ljava/util/Map;
    //   158: aload_1
    //   159: invokeinterface 153 2 0
    //   164: astore 8
    //   166: aload 5
    //   168: aload_1
    //   169: new 155	java/lang/StringBuilder
    //   172: dup
    //   173: invokespecial 156	java/lang/StringBuilder:<init>	()V
    //   176: ldc 158
    //   178: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   181: aload 8
    //   183: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   186: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   189: invokevirtual 172	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   192: pop
    //   193: ldc 8
    //   195: new 155	java/lang/StringBuilder
    //   198: dup
    //   199: invokespecial 156	java/lang/StringBuilder:<init>	()V
    //   202: ldc 174
    //   204: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   207: aload_1
    //   208: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   211: ldc 176
    //   213: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   216: aload 8
    //   218: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   221: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   224: invokestatic 145	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   227: goto -94 -> 133
    //   230: astore_3
    //   231: aload_2
    //   232: astore_1
    //   233: aload 4
    //   235: astore_2
    //   236: aload_3
    //   237: invokevirtual 134	java/lang/Throwable:printStackTrace	()V
    //   240: aload_1
    //   241: ifnull +7 -> 248
    //   244: aload_1
    //   245: invokevirtual 137	java/io/BufferedInputStream:close	()V
    //   248: aload_2
    //   249: ifnull -193 -> 56
    //   252: aload_2
    //   253: invokevirtual 179	java/io/BufferedOutputStream:close	()V
    //   256: goto -200 -> 56
    //   259: astore_1
    //   260: aload_1
    //   261: invokevirtual 88	java/lang/Exception:printStackTrace	()V
    //   264: goto -208 -> 56
    //   267: aload_0
    //   268: getfield 48	com/tencent/smtt/sdk/TbsBaseConfig:a	Ljava/util/Map;
    //   271: invokeinterface 52 1 0
    //   276: new 178	java/io/BufferedOutputStream
    //   279: dup
    //   280: new 181	java/io/FileOutputStream
    //   283: dup
    //   284: aload 7
    //   286: invokespecial 182	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   289: invokespecial 185	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   292: astore_1
    //   293: aload 5
    //   295: aload_1
    //   296: aconst_null
    //   297: invokevirtual 189	java/util/Properties:store	(Ljava/io/OutputStream;Ljava/lang/String;)V
    //   300: aload_2
    //   301: ifnull +7 -> 308
    //   304: aload_2
    //   305: invokevirtual 137	java/io/BufferedInputStream:close	()V
    //   308: aload_1
    //   309: ifnull -253 -> 56
    //   312: aload_1
    //   313: invokevirtual 179	java/io/BufferedOutputStream:close	()V
    //   316: goto -260 -> 56
    //   319: astore_1
    //   320: aload_1
    //   321: invokevirtual 88	java/lang/Exception:printStackTrace	()V
    //   324: goto -268 -> 56
    //   327: astore_2
    //   328: aload_2
    //   329: invokevirtual 88	java/lang/Exception:printStackTrace	()V
    //   332: goto -24 -> 308
    //   335: astore_1
    //   336: aload_1
    //   337: invokevirtual 88	java/lang/Exception:printStackTrace	()V
    //   340: goto -92 -> 248
    //   343: astore_1
    //   344: aconst_null
    //   345: astore_2
    //   346: aload_2
    //   347: ifnull +7 -> 354
    //   350: aload_2
    //   351: invokevirtual 137	java/io/BufferedInputStream:close	()V
    //   354: aload_3
    //   355: ifnull +7 -> 362
    //   358: aload_3
    //   359: invokevirtual 179	java/io/BufferedOutputStream:close	()V
    //   362: aload_1
    //   363: athrow
    //   364: astore_2
    //   365: aload_2
    //   366: invokevirtual 88	java/lang/Exception:printStackTrace	()V
    //   369: goto -15 -> 354
    //   372: astore_2
    //   373: aload_2
    //   374: invokevirtual 88	java/lang/Exception:printStackTrace	()V
    //   377: goto -15 -> 362
    //   380: astore_1
    //   381: goto -35 -> 346
    //   384: astore 4
    //   386: aload_1
    //   387: astore_3
    //   388: aload 4
    //   390: astore_1
    //   391: goto -45 -> 346
    //   394: astore_3
    //   395: aload_1
    //   396: astore 4
    //   398: aload_3
    //   399: astore_1
    //   400: aload_2
    //   401: astore_3
    //   402: aload 4
    //   404: astore_2
    //   405: goto -59 -> 346
    //   408: astore_3
    //   409: aconst_null
    //   410: astore_1
    //   411: aload 4
    //   413: astore_2
    //   414: goto -178 -> 236
    //   417: astore_3
    //   418: aload_2
    //   419: astore 4
    //   421: aload_1
    //   422: astore_2
    //   423: aload 4
    //   425: astore_1
    //   426: goto -190 -> 236
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	429	0	this	TbsBaseConfig
    //   59	2	1	localException1	java.lang.Exception
    //   67	4	1	localObject1	Object
    //   72	2	1	localException2	java.lang.Exception
    //   153	92	1	localObject2	Object
    //   259	2	1	localException3	java.lang.Exception
    //   292	21	1	localBufferedOutputStream	java.io.BufferedOutputStream
    //   319	2	1	localException4	java.lang.Exception
    //   335	2	1	localException5	java.lang.Exception
    //   343	20	1	localObject3	Object
    //   380	7	1	localObject4	Object
    //   390	36	1	localObject5	Object
    //   96	209	2	localObject6	Object
    //   327	2	2	localException6	java.lang.Exception
    //   345	6	2	localObject7	Object
    //   364	2	2	localException7	java.lang.Exception
    //   372	29	2	localException8	java.lang.Exception
    //   404	19	2	localObject8	Object
    //   1	1	3	localObject9	Object
    //   230	129	3	localThrowable1	java.lang.Throwable
    //   387	1	3	localObject10	Object
    //   394	5	3	localObject11	Object
    //   401	1	3	localObject12	Object
    //   408	1	3	localThrowable2	java.lang.Throwable
    //   417	1	3	localThrowable3	java.lang.Throwable
    //   3	231	4	localObject13	Object
    //   384	5	4	localObject14	Object
    //   396	28	4	localObject15	Object
    //   104	190	5	localProperties	java.util.Properties
    //   131	13	6	localIterator	java.util.Iterator
    //   25	260	7	localFile	File
    //   164	53	8	localObject16	Object
    // Exception table:
    //   from	to	target	type
    //   36	44	59	java/lang/Exception
    //   7	14	67	finally
    //   36	44	67	finally
    //   48	56	67	finally
    //   60	64	67	finally
    //   73	77	67	finally
    //   244	248	67	finally
    //   252	256	67	finally
    //   260	264	67	finally
    //   304	308	67	finally
    //   312	316	67	finally
    //   320	324	67	finally
    //   328	332	67	finally
    //   336	340	67	finally
    //   350	354	67	finally
    //   358	362	67	finally
    //   362	364	67	finally
    //   365	369	67	finally
    //   373	377	67	finally
    //   48	56	72	java/lang/Exception
    //   97	133	230	java/lang/Throwable
    //   133	227	230	java/lang/Throwable
    //   267	293	230	java/lang/Throwable
    //   252	256	259	java/lang/Exception
    //   312	316	319	java/lang/Exception
    //   304	308	327	java/lang/Exception
    //   244	248	335	java/lang/Exception
    //   14	27	343	finally
    //   80	97	343	finally
    //   350	354	364	java/lang/Exception
    //   358	362	372	java/lang/Exception
    //   97	133	380	finally
    //   133	227	380	finally
    //   267	293	380	finally
    //   293	300	384	finally
    //   236	240	394	finally
    //   14	27	408	java/lang/Throwable
    //   80	97	408	java/lang/Throwable
    //   293	300	417	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.smtt.sdk.TbsBaseConfig
 * JD-Core Version:    0.7.0.1
 */