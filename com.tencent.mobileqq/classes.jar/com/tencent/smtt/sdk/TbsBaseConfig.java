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
    //   102: astore 4
    //   104: aload_2
    //   105: astore_1
    //   106: aload 4
    //   108: invokeinterface 121 1 0
    //   113: ifeq +64 -> 177
    //   116: aload_2
    //   117: astore_1
    //   118: aload 4
    //   120: invokeinterface 125 1 0
    //   125: checkcast 127	java/lang/String
    //   128: astore_3
    //   129: aload_2
    //   130: astore_1
    //   131: aload_0
    //   132: getfield 50	com/tencent/smtt/sdk/TbsBaseConfig:mSyncMap	Ljava/util/Map;
    //   135: aload_3
    //   136: aload 5
    //   138: aload_3
    //   139: invokevirtual 131	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   142: invokeinterface 135 3 0
    //   147: pop
    //   148: goto -44 -> 104
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
    //   128	11	3	str	String
    //   151	4	3	localThrowable1	java.lang.Throwable
    //   221	1	3	localThrowable2	java.lang.Throwable
    //   102	17	4	localIterator	java.util.Iterator
    //   80	57	5	localProperties	java.util.Properties
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
    //   92	104	151	java/lang/Throwable
    //   106	116	151	java/lang/Throwable
    //   118	129	151	java/lang/Throwable
    //   131	148	151	java/lang/Throwable
    //   162	166	169	java/lang/Exception
    //   181	185	188	java/lang/Exception
    //   2	14	196	finally
    //   46	71	196	finally
    //   203	207	209	java/lang/Exception
    //   73	82	217	finally
    //   84	90	217	finally
    //   92	104	217	finally
    //   106	116	217	finally
    //   118	129	217	finally
    //   131	148	217	finally
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
    //   25: astore 7
    //   27: aload 7
    //   29: ifnonnull +51 -> 80
    //   32: iconst_0
    //   33: ifeq +11 -> 44
    //   36: new 88	java/lang/NullPointerException
    //   39: dup
    //   40: invokespecial 89	java/lang/NullPointerException:<init>	()V
    //   43: athrow
    //   44: iconst_0
    //   45: ifeq +11 -> 56
    //   48: new 88	java/lang/NullPointerException
    //   51: dup
    //   52: invokespecial 89	java/lang/NullPointerException:<init>	()V
    //   55: athrow
    //   56: aload_0
    //   57: monitorexit
    //   58: return
    //   59: astore_1
    //   60: aload_1
    //   61: invokevirtual 90	java/lang/Exception:printStackTrace	()V
    //   64: goto -20 -> 44
    //   67: astore_1
    //   68: aload_0
    //   69: monitorexit
    //   70: aload_1
    //   71: athrow
    //   72: astore_1
    //   73: aload_1
    //   74: invokevirtual 90	java/lang/Exception:printStackTrace	()V
    //   77: goto -21 -> 56
    //   80: new 92	java/io/BufferedInputStream
    //   83: dup
    //   84: new 94	java/io/FileInputStream
    //   87: dup
    //   88: aload 7
    //   90: invokespecial 97	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   93: invokespecial 100	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   96: astore_2
    //   97: new 102	java/util/Properties
    //   100: dup
    //   101: invokespecial 103	java/util/Properties:<init>	()V
    //   104: astore 5
    //   106: aload 5
    //   108: aload_2
    //   109: invokevirtual 106	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   112: aload 5
    //   114: invokevirtual 148	java/util/Properties:clear	()V
    //   117: aload_0
    //   118: getfield 50	com/tencent/smtt/sdk/TbsBaseConfig:mSyncMap	Ljava/util/Map;
    //   121: invokeinterface 151 1 0
    //   126: invokeinterface 116 1 0
    //   131: astore_1
    //   132: aload_1
    //   133: invokeinterface 121 1 0
    //   138: ifeq +130 -> 268
    //   141: aload_1
    //   142: invokeinterface 125 1 0
    //   147: checkcast 127	java/lang/String
    //   150: astore 8
    //   152: aload_0
    //   153: getfield 50	com/tencent/smtt/sdk/TbsBaseConfig:mSyncMap	Ljava/util/Map;
    //   156: aload 8
    //   158: invokeinterface 155 2 0
    //   163: astore 6
    //   165: aload 5
    //   167: aload 8
    //   169: new 157	java/lang/StringBuilder
    //   172: dup
    //   173: invokespecial 158	java/lang/StringBuilder:<init>	()V
    //   176: ldc 160
    //   178: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   181: aload 6
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
    //   207: aload 8
    //   209: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   212: ldc 178
    //   214: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   217: aload 6
    //   219: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   222: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   225: invokestatic 147	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   228: goto -96 -> 132
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
    //   250: ifnull -194 -> 56
    //   253: aload_2
    //   254: invokevirtual 181	java/io/BufferedOutputStream:close	()V
    //   257: goto -201 -> 56
    //   260: astore_1
    //   261: aload_1
    //   262: invokevirtual 90	java/lang/Exception:printStackTrace	()V
    //   265: goto -209 -> 56
    //   268: aload_0
    //   269: getfield 50	com/tencent/smtt/sdk/TbsBaseConfig:mSyncMap	Ljava/util/Map;
    //   272: invokeinterface 54 1 0
    //   277: new 180	java/io/BufferedOutputStream
    //   280: dup
    //   281: new 183	java/io/FileOutputStream
    //   284: dup
    //   285: aload 7
    //   287: invokespecial 184	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   290: invokespecial 187	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   293: astore_1
    //   294: aload 5
    //   296: aload_1
    //   297: aconst_null
    //   298: invokevirtual 191	java/util/Properties:store	(Ljava/io/OutputStream;Ljava/lang/String;)V
    //   301: aload_2
    //   302: ifnull +7 -> 309
    //   305: aload_2
    //   306: invokevirtual 139	java/io/BufferedInputStream:close	()V
    //   309: aload_1
    //   310: ifnull -254 -> 56
    //   313: aload_1
    //   314: invokevirtual 181	java/io/BufferedOutputStream:close	()V
    //   317: goto -261 -> 56
    //   320: astore_1
    //   321: aload_1
    //   322: invokevirtual 90	java/lang/Exception:printStackTrace	()V
    //   325: goto -269 -> 56
    //   328: astore_2
    //   329: aload_2
    //   330: invokevirtual 90	java/lang/Exception:printStackTrace	()V
    //   333: goto -24 -> 309
    //   336: astore_1
    //   337: aload_1
    //   338: invokevirtual 90	java/lang/Exception:printStackTrace	()V
    //   341: goto -92 -> 249
    //   344: astore_1
    //   345: aconst_null
    //   346: astore_2
    //   347: aload_2
    //   348: ifnull +7 -> 355
    //   351: aload_2
    //   352: invokevirtual 139	java/io/BufferedInputStream:close	()V
    //   355: aload_3
    //   356: ifnull +7 -> 363
    //   359: aload_3
    //   360: invokevirtual 181	java/io/BufferedOutputStream:close	()V
    //   363: aload_1
    //   364: athrow
    //   365: astore_2
    //   366: aload_2
    //   367: invokevirtual 90	java/lang/Exception:printStackTrace	()V
    //   370: goto -15 -> 355
    //   373: astore_2
    //   374: aload_2
    //   375: invokevirtual 90	java/lang/Exception:printStackTrace	()V
    //   378: goto -15 -> 363
    //   381: astore_1
    //   382: goto -35 -> 347
    //   385: astore 4
    //   387: aload_1
    //   388: astore_3
    //   389: aload 4
    //   391: astore_1
    //   392: goto -45 -> 347
    //   395: astore_3
    //   396: aload_1
    //   397: astore 4
    //   399: aload_3
    //   400: astore_1
    //   401: aload_2
    //   402: astore_3
    //   403: aload 4
    //   405: astore_2
    //   406: goto -59 -> 347
    //   409: astore_3
    //   410: aconst_null
    //   411: astore_1
    //   412: aload 4
    //   414: astore_2
    //   415: goto -178 -> 237
    //   418: astore_3
    //   419: aload_1
    //   420: astore 4
    //   422: aload_2
    //   423: astore_1
    //   424: aload 4
    //   426: astore_2
    //   427: goto -190 -> 237
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	430	0	this	TbsBaseConfig
    //   59	2	1	localException1	java.lang.Exception
    //   67	4	1	localObject1	Object
    //   72	2	1	localException2	java.lang.Exception
    //   131	115	1	localObject2	Object
    //   260	2	1	localException3	java.lang.Exception
    //   293	21	1	localBufferedOutputStream	java.io.BufferedOutputStream
    //   320	2	1	localException4	java.lang.Exception
    //   336	2	1	localException5	java.lang.Exception
    //   344	20	1	localObject3	Object
    //   381	7	1	localObject4	Object
    //   391	33	1	localObject5	Object
    //   96	210	2	localObject6	Object
    //   328	2	2	localException6	java.lang.Exception
    //   346	6	2	localObject7	Object
    //   365	2	2	localException7	java.lang.Exception
    //   373	29	2	localException8	java.lang.Exception
    //   405	22	2	localObject8	Object
    //   1	1	3	localObject9	Object
    //   231	129	3	localThrowable1	java.lang.Throwable
    //   388	1	3	localObject10	Object
    //   395	5	3	localObject11	Object
    //   402	1	3	localObject12	Object
    //   409	1	3	localThrowable2	java.lang.Throwable
    //   418	1	3	localThrowable3	java.lang.Throwable
    //   3	232	4	localObject13	Object
    //   385	5	4	localObject14	Object
    //   397	28	4	localObject15	Object
    //   104	191	5	localProperties	java.util.Properties
    //   163	55	6	localObject16	Object
    //   25	261	7	localFile	File
    //   150	58	8	str	String
    // Exception table:
    //   from	to	target	type
    //   36	44	59	java/lang/Exception
    //   7	14	67	finally
    //   36	44	67	finally
    //   48	56	67	finally
    //   60	64	67	finally
    //   73	77	67	finally
    //   245	249	67	finally
    //   253	257	67	finally
    //   261	265	67	finally
    //   305	309	67	finally
    //   313	317	67	finally
    //   321	325	67	finally
    //   329	333	67	finally
    //   337	341	67	finally
    //   351	355	67	finally
    //   359	363	67	finally
    //   363	365	67	finally
    //   366	370	67	finally
    //   374	378	67	finally
    //   48	56	72	java/lang/Exception
    //   97	132	231	java/lang/Throwable
    //   132	228	231	java/lang/Throwable
    //   268	294	231	java/lang/Throwable
    //   253	257	260	java/lang/Exception
    //   313	317	320	java/lang/Exception
    //   305	309	328	java/lang/Exception
    //   245	249	336	java/lang/Exception
    //   14	27	344	finally
    //   80	97	344	finally
    //   351	355	365	java/lang/Exception
    //   359	363	373	java/lang/Exception
    //   97	132	381	finally
    //   132	228	381	finally
    //   268	294	381	finally
    //   294	301	385	finally
    //   237	241	395	finally
    //   14	27	409	java/lang/Throwable
    //   80	97	409	java/lang/Throwable
    //   294	301	418	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.smtt.sdk.TbsBaseConfig
 * JD-Core Version:    0.7.0.1
 */