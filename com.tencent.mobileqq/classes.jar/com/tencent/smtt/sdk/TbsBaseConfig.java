package com.tencent.smtt.sdk;

import android.content.Context;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public abstract class TbsBaseConfig
{
  public static final String TAG = "TbsBaseConfig";
  private Context mAppContext;
  Map<String, String> mSyncMap;
  
  private static File getTbsFile(Context paramContext, String paramString)
  {
    TbsInstaller.getInstance();
    paramContext = TbsInstaller.getTbsCorePrivateDir(paramContext);
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
    this.mSyncMap.clear();
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
    this.mSyncMap = new HashMap();
    this.mAppContext = paramContext.getApplicationContext();
    if (this.mAppContext == null) {
      this.mAppContext = paramContext;
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
    //   3: getfield 75	com/tencent/smtt/sdk/TbsBaseConfig:mAppContext	Landroid/content/Context;
    //   6: aload_0
    //   7: invokevirtual 84	com/tencent/smtt/sdk/TbsBaseConfig:getConfigFileName	()Ljava/lang/String;
    //   10: invokestatic 86	com/tencent/smtt/sdk/TbsBaseConfig:getTbsFile	(Landroid/content/Context;Ljava/lang/String;)Ljava/io/File;
    //   13: astore_1
    //   14: aload_1
    //   15: ifnonnull +31 -> 46
    //   18: iconst_0
    //   19: ifeq +11 -> 30
    //   22: new 88	java/lang/NullPointerException
    //   25: dup
    //   26: invokespecial 89	java/lang/NullPointerException:<init>	()V
    //   29: athrow
    //   30: aload_0
    //   31: monitorexit
    //   32: return
    //   33: astore_1
    //   34: aload_1
    //   35: invokevirtual 90	java/lang/Exception:printStackTrace	()V
    //   38: goto -8 -> 30
    //   41: astore_1
    //   42: aload_0
    //   43: monitorexit
    //   44: aload_1
    //   45: athrow
    //   46: aload_0
    //   47: getfield 50	com/tencent/smtt/sdk/TbsBaseConfig:mSyncMap	Ljava/util/Map;
    //   50: invokeinterface 54 1 0
    //   55: new 92	java/io/BufferedInputStream
    //   58: dup
    //   59: new 94	java/io/FileInputStream
    //   62: dup
    //   63: aload_1
    //   64: invokespecial 97	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   67: invokespecial 100	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   70: astore_2
    //   71: aload_2
    //   72: astore_1
    //   73: new 102	java/util/Properties
    //   76: dup
    //   77: invokespecial 103	java/util/Properties:<init>	()V
    //   80: astore 5
    //   82: aload_2
    //   83: astore_1
    //   84: aload 5
    //   86: aload_2
    //   87: invokevirtual 106	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   90: aload_2
    //   91: astore_1
    //   92: aload 5
    //   94: invokevirtual 110	java/util/Properties:stringPropertyNames	()Ljava/util/Set;
    //   97: invokeinterface 116 1 0
    //   102: astore_3
    //   103: aload_2
    //   104: astore_1
    //   105: aload_3
    //   106: invokeinterface 121 1 0
    //   111: ifeq +66 -> 177
    //   114: aload_2
    //   115: astore_1
    //   116: aload_3
    //   117: invokeinterface 125 1 0
    //   122: checkcast 127	java/lang/String
    //   125: astore 4
    //   127: aload_2
    //   128: astore_1
    //   129: aload_0
    //   130: getfield 50	com/tencent/smtt/sdk/TbsBaseConfig:mSyncMap	Ljava/util/Map;
    //   133: aload 4
    //   135: aload 5
    //   137: aload 4
    //   139: invokevirtual 131	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   142: invokeinterface 135 3 0
    //   147: pop
    //   148: goto -45 -> 103
    //   151: astore_3
    //   152: aload_2
    //   153: astore_1
    //   154: aload_3
    //   155: invokevirtual 136	java/lang/Throwable:printStackTrace	()V
    //   158: aload_2
    //   159: ifnull -129 -> 30
    //   162: aload_2
    //   163: invokevirtual 139	java/io/BufferedInputStream:close	()V
    //   166: goto -136 -> 30
    //   169: astore_1
    //   170: aload_1
    //   171: invokevirtual 90	java/lang/Exception:printStackTrace	()V
    //   174: goto -144 -> 30
    //   177: aload_2
    //   178: ifnull -148 -> 30
    //   181: aload_2
    //   182: invokevirtual 139	java/io/BufferedInputStream:close	()V
    //   185: goto -155 -> 30
    //   188: astore_1
    //   189: aload_1
    //   190: invokevirtual 90	java/lang/Exception:printStackTrace	()V
    //   193: goto -163 -> 30
    //   196: astore_2
    //   197: aconst_null
    //   198: astore_1
    //   199: aload_1
    //   200: ifnull +7 -> 207
    //   203: aload_1
    //   204: invokevirtual 139	java/io/BufferedInputStream:close	()V
    //   207: aload_2
    //   208: athrow
    //   209: astore_1
    //   210: aload_1
    //   211: invokevirtual 90	java/lang/Exception:printStackTrace	()V
    //   214: goto -7 -> 207
    //   217: astore_2
    //   218: goto -19 -> 199
    //   221: astore_3
    //   222: aconst_null
    //   223: astore_2
    //   224: goto -72 -> 152
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	227	0	this	TbsBaseConfig
    //   0	227	1	paramContext	Context
    //   70	112	2	localBufferedInputStream	java.io.BufferedInputStream
    //   196	12	2	localObject1	Object
    //   217	1	2	localObject2	Object
    //   223	1	2	localObject3	Object
    //   102	15	3	localIterator	java.util.Iterator
    //   151	4	3	localThrowable1	java.lang.Throwable
    //   221	1	3	localThrowable2	java.lang.Throwable
    //   125	13	4	str	String
    //   80	56	5	localProperties	java.util.Properties
    // Exception table:
    //   from	to	target	type
    //   22	30	33	java/lang/Exception
    //   22	30	41	finally
    //   34	38	41	finally
    //   162	166	41	finally
    //   170	174	41	finally
    //   181	185	41	finally
    //   189	193	41	finally
    //   203	207	41	finally
    //   207	209	41	finally
    //   210	214	41	finally
    //   73	82	151	java/lang/Throwable
    //   84	90	151	java/lang/Throwable
    //   92	103	151	java/lang/Throwable
    //   105	114	151	java/lang/Throwable
    //   116	127	151	java/lang/Throwable
    //   129	148	151	java/lang/Throwable
    //   162	166	169	java/lang/Exception
    //   181	185	188	java/lang/Exception
    //   2	14	196	finally
    //   46	71	196	finally
    //   203	207	209	java/lang/Exception
    //   73	82	217	finally
    //   84	90	217	finally
    //   92	103	217	finally
    //   105	114	217	finally
    //   116	127	217	finally
    //   129	148	217	finally
    //   154	158	217	finally
    //   2	14	221	java/lang/Throwable
    //   46	71	221	java/lang/Throwable
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
    //   9: ldc 141
    //   11: invokestatic 147	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   14: aload_0
    //   15: getfield 75	com/tencent/smtt/sdk/TbsBaseConfig:mAppContext	Landroid/content/Context;
    //   18: aload_0
    //   19: invokevirtual 84	com/tencent/smtt/sdk/TbsBaseConfig:getConfigFileName	()Ljava/lang/String;
    //   22: invokestatic 86	com/tencent/smtt/sdk/TbsBaseConfig:getTbsFile	(Landroid/content/Context;Ljava/lang/String;)Ljava/io/File;
    //   25: astore_1
    //   26: aload_1
    //   27: ifnonnull +51 -> 78
    //   30: iconst_0
    //   31: ifeq +11 -> 42
    //   34: new 88	java/lang/NullPointerException
    //   37: dup
    //   38: invokespecial 89	java/lang/NullPointerException:<init>	()V
    //   41: athrow
    //   42: iconst_0
    //   43: ifeq +11 -> 54
    //   46: new 88	java/lang/NullPointerException
    //   49: dup
    //   50: invokespecial 89	java/lang/NullPointerException:<init>	()V
    //   53: athrow
    //   54: aload_0
    //   55: monitorexit
    //   56: return
    //   57: astore_1
    //   58: aload_1
    //   59: invokevirtual 90	java/lang/Exception:printStackTrace	()V
    //   62: goto -20 -> 42
    //   65: astore_1
    //   66: aload_0
    //   67: monitorexit
    //   68: aload_1
    //   69: athrow
    //   70: astore_1
    //   71: aload_1
    //   72: invokevirtual 90	java/lang/Exception:printStackTrace	()V
    //   75: goto -21 -> 54
    //   78: new 92	java/io/BufferedInputStream
    //   81: dup
    //   82: new 94	java/io/FileInputStream
    //   85: dup
    //   86: aload_1
    //   87: invokespecial 97	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   90: invokespecial 100	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   93: astore_2
    //   94: new 102	java/util/Properties
    //   97: dup
    //   98: invokespecial 103	java/util/Properties:<init>	()V
    //   101: astore 5
    //   103: aload 5
    //   105: aload_2
    //   106: invokevirtual 106	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   109: aload 5
    //   111: invokevirtual 148	java/util/Properties:clear	()V
    //   114: aload_0
    //   115: getfield 50	com/tencent/smtt/sdk/TbsBaseConfig:mSyncMap	Ljava/util/Map;
    //   118: invokeinterface 151 1 0
    //   123: invokeinterface 116 1 0
    //   128: astore 7
    //   130: aload 7
    //   132: invokeinterface 121 1 0
    //   137: ifeq +131 -> 268
    //   140: aload 7
    //   142: invokeinterface 125 1 0
    //   147: checkcast 127	java/lang/String
    //   150: astore 6
    //   152: aload_0
    //   153: getfield 50	com/tencent/smtt/sdk/TbsBaseConfig:mSyncMap	Ljava/util/Map;
    //   156: aload 6
    //   158: invokeinterface 155 2 0
    //   163: astore 8
    //   165: aload 5
    //   167: aload 6
    //   169: new 157	java/lang/StringBuilder
    //   172: dup
    //   173: invokespecial 158	java/lang/StringBuilder:<init>	()V
    //   176: ldc 160
    //   178: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   181: aload 8
    //   183: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   186: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   189: invokevirtual 174	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   192: pop
    //   193: ldc 8
    //   195: new 157	java/lang/StringBuilder
    //   198: dup
    //   199: invokespecial 158	java/lang/StringBuilder:<init>	()V
    //   202: ldc 176
    //   204: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   207: aload 6
    //   209: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   212: ldc 178
    //   214: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   217: aload 8
    //   219: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   222: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   225: invokestatic 147	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   228: goto -98 -> 130
    //   231: astore_3
    //   232: aload_2
    //   233: astore_1
    //   234: aload 4
    //   236: astore_2
    //   237: aload_3
    //   238: invokevirtual 136	java/lang/Throwable:printStackTrace	()V
    //   241: aload_1
    //   242: ifnull +7 -> 249
    //   245: aload_1
    //   246: invokevirtual 139	java/io/BufferedInputStream:close	()V
    //   249: aload_2
    //   250: ifnull -196 -> 54
    //   253: aload_2
    //   254: invokevirtual 181	java/io/BufferedOutputStream:close	()V
    //   257: goto -203 -> 54
    //   260: astore_1
    //   261: aload_1
    //   262: invokevirtual 90	java/lang/Exception:printStackTrace	()V
    //   265: goto -211 -> 54
    //   268: aload_0
    //   269: getfield 50	com/tencent/smtt/sdk/TbsBaseConfig:mSyncMap	Ljava/util/Map;
    //   272: invokeinterface 54 1 0
    //   277: new 180	java/io/BufferedOutputStream
    //   280: dup
    //   281: new 183	java/io/FileOutputStream
    //   284: dup
    //   285: aload_1
    //   286: invokespecial 184	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   289: invokespecial 187	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   292: astore_1
    //   293: aload 5
    //   295: aload_1
    //   296: aconst_null
    //   297: invokevirtual 191	java/util/Properties:store	(Ljava/io/OutputStream;Ljava/lang/String;)V
    //   300: aload_2
    //   301: ifnull +7 -> 308
    //   304: aload_2
    //   305: invokevirtual 139	java/io/BufferedInputStream:close	()V
    //   308: aload_1
    //   309: ifnull -255 -> 54
    //   312: aload_1
    //   313: invokevirtual 181	java/io/BufferedOutputStream:close	()V
    //   316: goto -262 -> 54
    //   319: astore_1
    //   320: aload_1
    //   321: invokevirtual 90	java/lang/Exception:printStackTrace	()V
    //   324: goto -270 -> 54
    //   327: astore_2
    //   328: aload_2
    //   329: invokevirtual 90	java/lang/Exception:printStackTrace	()V
    //   332: goto -24 -> 308
    //   335: astore_1
    //   336: aload_1
    //   337: invokevirtual 90	java/lang/Exception:printStackTrace	()V
    //   340: goto -91 -> 249
    //   343: astore_1
    //   344: aconst_null
    //   345: astore_2
    //   346: aload_2
    //   347: ifnull +7 -> 354
    //   350: aload_2
    //   351: invokevirtual 139	java/io/BufferedInputStream:close	()V
    //   354: aload_3
    //   355: ifnull +7 -> 362
    //   358: aload_3
    //   359: invokevirtual 181	java/io/BufferedOutputStream:close	()V
    //   362: aload_1
    //   363: athrow
    //   364: astore_2
    //   365: aload_2
    //   366: invokevirtual 90	java/lang/Exception:printStackTrace	()V
    //   369: goto -15 -> 354
    //   372: astore_2
    //   373: aload_2
    //   374: invokevirtual 90	java/lang/Exception:printStackTrace	()V
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
    //   414: goto -177 -> 237
    //   417: astore_3
    //   418: aload_2
    //   419: astore 4
    //   421: aload_1
    //   422: astore_2
    //   423: aload 4
    //   425: astore_1
    //   426: goto -189 -> 237
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	429	0	this	TbsBaseConfig
    //   25	2	1	localFile	File
    //   57	2	1	localException1	java.lang.Exception
    //   65	4	1	localObject1	Object
    //   70	17	1	localException2	java.lang.Exception
    //   233	13	1	localObject2	Object
    //   260	26	1	localException3	java.lang.Exception
    //   292	21	1	localBufferedOutputStream	java.io.BufferedOutputStream
    //   319	2	1	localException4	java.lang.Exception
    //   335	2	1	localException5	java.lang.Exception
    //   343	20	1	localObject3	Object
    //   380	7	1	localObject4	Object
    //   390	36	1	localObject5	Object
    //   93	212	2	localObject6	Object
    //   327	2	2	localException6	java.lang.Exception
    //   345	6	2	localObject7	Object
    //   364	2	2	localException7	java.lang.Exception
    //   372	29	2	localException8	java.lang.Exception
    //   404	19	2	localObject8	Object
    //   1	1	3	localObject9	Object
    //   231	128	3	localThrowable1	java.lang.Throwable
    //   387	1	3	localObject10	Object
    //   394	5	3	localObject11	Object
    //   401	1	3	localObject12	Object
    //   408	1	3	localThrowable2	java.lang.Throwable
    //   417	1	3	localThrowable3	java.lang.Throwable
    //   3	232	4	localObject13	Object
    //   384	5	4	localObject14	Object
    //   396	28	4	localObject15	Object
    //   101	193	5	localProperties	java.util.Properties
    //   150	58	6	str	String
    //   128	13	7	localIterator	java.util.Iterator
    //   163	55	8	localObject16	Object
    // Exception table:
    //   from	to	target	type
    //   34	42	57	java/lang/Exception
    //   7	14	65	finally
    //   34	42	65	finally
    //   46	54	65	finally
    //   58	62	65	finally
    //   71	75	65	finally
    //   245	249	65	finally
    //   253	257	65	finally
    //   261	265	65	finally
    //   304	308	65	finally
    //   312	316	65	finally
    //   320	324	65	finally
    //   328	332	65	finally
    //   336	340	65	finally
    //   350	354	65	finally
    //   358	362	65	finally
    //   362	364	65	finally
    //   365	369	65	finally
    //   373	377	65	finally
    //   46	54	70	java/lang/Exception
    //   94	130	231	java/lang/Throwable
    //   130	228	231	java/lang/Throwable
    //   268	293	231	java/lang/Throwable
    //   253	257	260	java/lang/Exception
    //   312	316	319	java/lang/Exception
    //   304	308	327	java/lang/Exception
    //   245	249	335	java/lang/Exception
    //   14	26	343	finally
    //   78	94	343	finally
    //   350	354	364	java/lang/Exception
    //   358	362	372	java/lang/Exception
    //   94	130	380	finally
    //   130	228	380	finally
    //   268	293	380	finally
    //   293	300	384	finally
    //   237	241	394	finally
    //   14	26	408	java/lang/Throwable
    //   78	94	408	java/lang/Throwable
    //   293	300	417	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.smtt.sdk.TbsBaseConfig
 * JD-Core Version:    0.7.0.1
 */