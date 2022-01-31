package com.tencent.smtt.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class TbsDownloadUpload
{
  private static final String TAG = "TbsDownloadUpload";
  private static final String TBS_CFG_FILE = "tbs_download_upload";
  private static TbsDownloadUpload mInstance;
  private Context mAppContext;
  public SharedPreferences mPreferences;
  Map<String, Object> mSyncMap = new HashMap();
  private int m_tbs_local_core_version;
  private int m_tbs_needdownload_code;
  private int m_tbs_needdownload_return;
  private int m_tbs_needdownload_sent;
  private int m_tbs_startdownload_code;
  private int m_tbs_startdownload_sent;
  
  public TbsDownloadUpload(Context paramContext)
  {
    this.mPreferences = paramContext.getSharedPreferences("tbs_download_upload", 4);
    this.mAppContext = paramContext.getApplicationContext();
    if (this.mAppContext == null) {
      this.mAppContext = paramContext;
    }
  }
  
  public static void clear()
  {
    try
    {
      mInstance = null;
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
      TbsDownloadUpload localTbsDownloadUpload = mInstance;
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
      if (mInstance == null) {
        mInstance = new TbsDownloadUpload(paramContext);
      }
      paramContext = mInstance;
      return paramContext;
    }
    finally {}
  }
  
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
  
  public void clearUploadCode()
  {
    this.mSyncMap.put("tbs_needdownload_code", Integer.valueOf(0));
    this.mSyncMap.put("tbs_startdownload_code", Integer.valueOf(0));
    this.mSyncMap.put("tbs_needdownload_return", Integer.valueOf(0));
    this.mSyncMap.put("tbs_needdownload_sent", Integer.valueOf(0));
    this.mSyncMap.put("tbs_startdownload_sent", Integer.valueOf(0));
    this.mSyncMap.put("tbs_local_core_version", Integer.valueOf(0));
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
      int i = this.m_tbs_local_core_version;
      return i;
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
    //   3: getfield 124	com/tencent/smtt/sdk/TbsDownloadUpload:m_tbs_needdownload_sent	I
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
    //   21: getfield 126	com/tencent/smtt/sdk/TbsDownloadUpload:m_tbs_needdownload_code	I
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
    //   6	19	1	i	int
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
      int i = this.m_tbs_needdownload_return;
      return i;
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
    //   3: getfield 132	com/tencent/smtt/sdk/TbsDownloadUpload:m_tbs_startdownload_sent	I
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
    //   21: getfield 134	com/tencent/smtt/sdk/TbsDownloadUpload:m_tbs_startdownload_code	I
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
    //   6	19	1	i	int
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
    //   3: getfield 51	com/tencent/smtt/sdk/TbsDownloadUpload:mAppContext	Landroid/content/Context;
    //   6: ldc 141
    //   8: invokestatic 143	com/tencent/smtt/sdk/TbsDownloadUpload:getTbsFile	(Landroid/content/Context;Ljava/lang/String;)Ljava/io/File;
    //   11: astore_1
    //   12: aload_1
    //   13: ifnonnull +31 -> 44
    //   16: iconst_0
    //   17: ifeq +11 -> 28
    //   20: new 145	java/lang/NullPointerException
    //   23: dup
    //   24: invokespecial 146	java/lang/NullPointerException:<init>	()V
    //   27: athrow
    //   28: aload_0
    //   29: monitorexit
    //   30: return
    //   31: astore_1
    //   32: aload_1
    //   33: invokevirtual 147	java/lang/Exception:printStackTrace	()V
    //   36: goto -8 -> 28
    //   39: astore_1
    //   40: aload_0
    //   41: monitorexit
    //   42: aload_1
    //   43: athrow
    //   44: new 149	java/io/BufferedInputStream
    //   47: dup
    //   48: new 151	java/io/FileInputStream
    //   51: dup
    //   52: aload_1
    //   53: invokespecial 154	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   56: invokespecial 157	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   59: astore_2
    //   60: aload_2
    //   61: astore_1
    //   62: new 159	java/util/Properties
    //   65: dup
    //   66: invokespecial 160	java/util/Properties:<init>	()V
    //   69: astore_3
    //   70: aload_2
    //   71: astore_1
    //   72: aload_3
    //   73: aload_2
    //   74: invokevirtual 163	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   77: aload_2
    //   78: astore_1
    //   79: aload_3
    //   80: ldc 91
    //   82: ldc 165
    //   84: invokevirtual 169	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   87: astore 4
    //   89: aload_2
    //   90: astore_1
    //   91: ldc 165
    //   93: aload 4
    //   95: invokevirtual 175	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   98: ifne +18 -> 116
    //   101: aload_2
    //   102: astore_1
    //   103: aload_0
    //   104: aload 4
    //   106: invokestatic 179	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   109: iconst_0
    //   110: invokestatic 185	java/lang/Math:max	(II)I
    //   113: putfield 126	com/tencent/smtt/sdk/TbsDownloadUpload:m_tbs_needdownload_code	I
    //   116: aload_2
    //   117: astore_1
    //   118: aload_3
    //   119: ldc 105
    //   121: ldc 165
    //   123: invokevirtual 169	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   126: astore 4
    //   128: aload_2
    //   129: astore_1
    //   130: ldc 165
    //   132: aload 4
    //   134: invokevirtual 175	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   137: ifne +18 -> 155
    //   140: aload_2
    //   141: astore_1
    //   142: aload_0
    //   143: aload 4
    //   145: invokestatic 179	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   148: iconst_0
    //   149: invokestatic 185	java/lang/Math:max	(II)I
    //   152: putfield 134	com/tencent/smtt/sdk/TbsDownloadUpload:m_tbs_startdownload_code	I
    //   155: aload_2
    //   156: astore_1
    //   157: aload_3
    //   158: ldc 107
    //   160: ldc 165
    //   162: invokevirtual 169	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   165: astore 4
    //   167: aload_2
    //   168: astore_1
    //   169: ldc 165
    //   171: aload 4
    //   173: invokevirtual 175	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   176: ifne +18 -> 194
    //   179: aload_2
    //   180: astore_1
    //   181: aload_0
    //   182: aload 4
    //   184: invokestatic 179	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   187: iconst_0
    //   188: invokestatic 185	java/lang/Math:max	(II)I
    //   191: putfield 129	com/tencent/smtt/sdk/TbsDownloadUpload:m_tbs_needdownload_return	I
    //   194: aload_2
    //   195: astore_1
    //   196: aload_3
    //   197: ldc 109
    //   199: ldc 165
    //   201: invokevirtual 169	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   204: astore 4
    //   206: aload_2
    //   207: astore_1
    //   208: ldc 165
    //   210: aload 4
    //   212: invokevirtual 175	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   215: ifne +18 -> 233
    //   218: aload_2
    //   219: astore_1
    //   220: aload_0
    //   221: aload 4
    //   223: invokestatic 179	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   226: iconst_0
    //   227: invokestatic 185	java/lang/Math:max	(II)I
    //   230: putfield 124	com/tencent/smtt/sdk/TbsDownloadUpload:m_tbs_needdownload_sent	I
    //   233: aload_2
    //   234: astore_1
    //   235: aload_3
    //   236: ldc 111
    //   238: ldc 165
    //   240: invokevirtual 169	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   243: astore 4
    //   245: aload_2
    //   246: astore_1
    //   247: ldc 165
    //   249: aload 4
    //   251: invokevirtual 175	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   254: ifne +18 -> 272
    //   257: aload_2
    //   258: astore_1
    //   259: aload_0
    //   260: aload 4
    //   262: invokestatic 179	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   265: iconst_0
    //   266: invokestatic 185	java/lang/Math:max	(II)I
    //   269: putfield 132	com/tencent/smtt/sdk/TbsDownloadUpload:m_tbs_startdownload_sent	I
    //   272: aload_2
    //   273: astore_1
    //   274: aload_3
    //   275: ldc 113
    //   277: ldc 165
    //   279: invokevirtual 169	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   282: astore_3
    //   283: aload_2
    //   284: astore_1
    //   285: ldc 165
    //   287: aload_3
    //   288: invokevirtual 175	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   291: ifne +17 -> 308
    //   294: aload_2
    //   295: astore_1
    //   296: aload_0
    //   297: aload_3
    //   298: invokestatic 179	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   301: iconst_0
    //   302: invokestatic 185	java/lang/Math:max	(II)I
    //   305: putfield 121	com/tencent/smtt/sdk/TbsDownloadUpload:m_tbs_local_core_version	I
    //   308: aload_2
    //   309: ifnull -281 -> 28
    //   312: aload_2
    //   313: invokevirtual 188	java/io/BufferedInputStream:close	()V
    //   316: goto -288 -> 28
    //   319: astore_1
    //   320: aload_1
    //   321: invokevirtual 147	java/lang/Exception:printStackTrace	()V
    //   324: goto -296 -> 28
    //   327: astore_3
    //   328: aconst_null
    //   329: astore_2
    //   330: aload_2
    //   331: astore_1
    //   332: aload_3
    //   333: invokevirtual 189	java/lang/Throwable:printStackTrace	()V
    //   336: aload_2
    //   337: ifnull -309 -> 28
    //   340: aload_2
    //   341: invokevirtual 188	java/io/BufferedInputStream:close	()V
    //   344: goto -316 -> 28
    //   347: astore_1
    //   348: aload_1
    //   349: invokevirtual 147	java/lang/Exception:printStackTrace	()V
    //   352: goto -324 -> 28
    //   355: astore_2
    //   356: aconst_null
    //   357: astore_1
    //   358: aload_1
    //   359: ifnull +7 -> 366
    //   362: aload_1
    //   363: invokevirtual 188	java/io/BufferedInputStream:close	()V
    //   366: aload_2
    //   367: athrow
    //   368: astore_1
    //   369: aload_1
    //   370: invokevirtual 147	java/lang/Exception:printStackTrace	()V
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
    //   7: ldc 8
    //   9: ldc 191
    //   11: invokestatic 197	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   14: aload_0
    //   15: getfield 51	com/tencent/smtt/sdk/TbsDownloadUpload:mAppContext	Landroid/content/Context;
    //   18: ldc 141
    //   20: invokestatic 143	com/tencent/smtt/sdk/TbsDownloadUpload:getTbsFile	(Landroid/content/Context;Ljava/lang/String;)Ljava/io/File;
    //   23: astore 7
    //   25: aload 7
    //   27: ifnonnull +51 -> 78
    //   30: iconst_0
    //   31: ifeq +11 -> 42
    //   34: new 145	java/lang/NullPointerException
    //   37: dup
    //   38: invokespecial 146	java/lang/NullPointerException:<init>	()V
    //   41: athrow
    //   42: iconst_0
    //   43: ifeq +11 -> 54
    //   46: new 145	java/lang/NullPointerException
    //   49: dup
    //   50: invokespecial 146	java/lang/NullPointerException:<init>	()V
    //   53: athrow
    //   54: aload_0
    //   55: monitorexit
    //   56: return
    //   57: astore_1
    //   58: aload_1
    //   59: invokevirtual 147	java/lang/Exception:printStackTrace	()V
    //   62: goto -20 -> 42
    //   65: astore_1
    //   66: aload_0
    //   67: monitorexit
    //   68: aload_1
    //   69: athrow
    //   70: astore_1
    //   71: aload_1
    //   72: invokevirtual 147	java/lang/Exception:printStackTrace	()V
    //   75: goto -21 -> 54
    //   78: new 149	java/io/BufferedInputStream
    //   81: dup
    //   82: new 151	java/io/FileInputStream
    //   85: dup
    //   86: aload 7
    //   88: invokespecial 154	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   91: invokespecial 157	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   94: astore_2
    //   95: new 159	java/util/Properties
    //   98: dup
    //   99: invokespecial 160	java/util/Properties:<init>	()V
    //   102: astore 5
    //   104: aload 5
    //   106: aload_2
    //   107: invokevirtual 163	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   110: aload_0
    //   111: getfield 37	com/tencent/smtt/sdk/TbsDownloadUpload:mSyncMap	Ljava/util/Map;
    //   114: invokeinterface 201 1 0
    //   119: invokeinterface 207 1 0
    //   124: astore 6
    //   126: aload 6
    //   128: invokeinterface 212 1 0
    //   133: ifeq +127 -> 260
    //   136: aload 6
    //   138: invokeinterface 216 1 0
    //   143: checkcast 171	java/lang/String
    //   146: astore_1
    //   147: aload_0
    //   148: getfield 37	com/tencent/smtt/sdk/TbsDownloadUpload:mSyncMap	Ljava/util/Map;
    //   151: aload_1
    //   152: invokeinterface 220 2 0
    //   157: astore 8
    //   159: aload 5
    //   161: aload_1
    //   162: new 222	java/lang/StringBuilder
    //   165: dup
    //   166: invokespecial 223	java/lang/StringBuilder:<init>	()V
    //   169: ldc 165
    //   171: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   174: aload 8
    //   176: invokevirtual 230	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   179: invokevirtual 234	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   182: invokevirtual 238	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   185: pop
    //   186: ldc 8
    //   188: new 222	java/lang/StringBuilder
    //   191: dup
    //   192: invokespecial 223	java/lang/StringBuilder:<init>	()V
    //   195: ldc 240
    //   197: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   200: aload_1
    //   201: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   204: ldc 242
    //   206: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   209: aload 8
    //   211: invokevirtual 230	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   214: invokevirtual 234	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   217: invokestatic 197	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   220: goto -94 -> 126
    //   223: astore_3
    //   224: aload_2
    //   225: astore_1
    //   226: aload 4
    //   228: astore_2
    //   229: aload_3
    //   230: invokevirtual 189	java/lang/Throwable:printStackTrace	()V
    //   233: aload_1
    //   234: ifnull +7 -> 241
    //   237: aload_1
    //   238: invokevirtual 188	java/io/BufferedInputStream:close	()V
    //   241: aload_2
    //   242: ifnull -188 -> 54
    //   245: aload_2
    //   246: invokevirtual 245	java/io/BufferedOutputStream:close	()V
    //   249: goto -195 -> 54
    //   252: astore_1
    //   253: aload_1
    //   254: invokevirtual 147	java/lang/Exception:printStackTrace	()V
    //   257: goto -203 -> 54
    //   260: aload_0
    //   261: getfield 37	com/tencent/smtt/sdk/TbsDownloadUpload:mSyncMap	Ljava/util/Map;
    //   264: invokeinterface 247 1 0
    //   269: new 244	java/io/BufferedOutputStream
    //   272: dup
    //   273: new 249	java/io/FileOutputStream
    //   276: dup
    //   277: aload 7
    //   279: invokespecial 250	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   282: invokespecial 253	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   285: astore_1
    //   286: aload 5
    //   288: aload_1
    //   289: aconst_null
    //   290: invokevirtual 257	java/util/Properties:store	(Ljava/io/OutputStream;Ljava/lang/String;)V
    //   293: aload_2
    //   294: ifnull +7 -> 301
    //   297: aload_2
    //   298: invokevirtual 188	java/io/BufferedInputStream:close	()V
    //   301: aload_1
    //   302: ifnull -248 -> 54
    //   305: aload_1
    //   306: invokevirtual 245	java/io/BufferedOutputStream:close	()V
    //   309: goto -255 -> 54
    //   312: astore_1
    //   313: aload_1
    //   314: invokevirtual 147	java/lang/Exception:printStackTrace	()V
    //   317: goto -263 -> 54
    //   320: astore_2
    //   321: aload_2
    //   322: invokevirtual 147	java/lang/Exception:printStackTrace	()V
    //   325: goto -24 -> 301
    //   328: astore_1
    //   329: aload_1
    //   330: invokevirtual 147	java/lang/Exception:printStackTrace	()V
    //   333: goto -92 -> 241
    //   336: astore_1
    //   337: aconst_null
    //   338: astore_2
    //   339: aload_2
    //   340: ifnull +7 -> 347
    //   343: aload_2
    //   344: invokevirtual 188	java/io/BufferedInputStream:close	()V
    //   347: aload_3
    //   348: ifnull +7 -> 355
    //   351: aload_3
    //   352: invokevirtual 245	java/io/BufferedOutputStream:close	()V
    //   355: aload_1
    //   356: athrow
    //   357: astore_2
    //   358: aload_2
    //   359: invokevirtual 147	java/lang/Exception:printStackTrace	()V
    //   362: goto -15 -> 347
    //   365: astore_2
    //   366: aload_2
    //   367: invokevirtual 147	java/lang/Exception:printStackTrace	()V
    //   370: goto -15 -> 355
    //   373: astore_1
    //   374: goto -35 -> 339
    //   377: astore 4
    //   379: aload_1
    //   380: astore_3
    //   381: aload 4
    //   383: astore_1
    //   384: goto -45 -> 339
    //   387: astore_3
    //   388: aload_1
    //   389: astore 4
    //   391: aload_3
    //   392: astore_1
    //   393: aload_2
    //   394: astore_3
    //   395: aload 4
    //   397: astore_2
    //   398: goto -59 -> 339
    //   401: astore_3
    //   402: aconst_null
    //   403: astore_1
    //   404: aload 4
    //   406: astore_2
    //   407: goto -178 -> 229
    //   410: astore_3
    //   411: aload_2
    //   412: astore 4
    //   414: aload_1
    //   415: astore_2
    //   416: aload 4
    //   418: astore_1
    //   419: goto -190 -> 229
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	422	0	this	TbsDownloadUpload
    //   57	2	1	localException1	java.lang.Exception
    //   65	4	1	localObject1	Object
    //   70	2	1	localException2	java.lang.Exception
    //   146	92	1	localObject2	Object
    //   252	2	1	localException3	java.lang.Exception
    //   285	21	1	localBufferedOutputStream	java.io.BufferedOutputStream
    //   312	2	1	localException4	java.lang.Exception
    //   328	2	1	localException5	java.lang.Exception
    //   336	20	1	localObject3	Object
    //   373	7	1	localObject4	Object
    //   383	36	1	localObject5	Object
    //   94	204	2	localObject6	Object
    //   320	2	2	localException6	java.lang.Exception
    //   338	6	2	localObject7	Object
    //   357	2	2	localException7	java.lang.Exception
    //   365	29	2	localException8	java.lang.Exception
    //   397	19	2	localObject8	Object
    //   1	1	3	localObject9	Object
    //   223	129	3	localThrowable1	java.lang.Throwable
    //   380	1	3	localObject10	Object
    //   387	5	3	localObject11	Object
    //   394	1	3	localObject12	Object
    //   401	1	3	localThrowable2	java.lang.Throwable
    //   410	1	3	localThrowable3	java.lang.Throwable
    //   3	224	4	localObject13	Object
    //   377	5	4	localObject14	Object
    //   389	28	4	localObject15	Object
    //   102	185	5	localProperties	java.util.Properties
    //   124	13	6	localIterator	java.util.Iterator
    //   23	255	7	localFile	File
    //   157	53	8	localObject16	Object
    // Exception table:
    //   from	to	target	type
    //   34	42	57	java/lang/Exception
    //   7	14	65	finally
    //   34	42	65	finally
    //   46	54	65	finally
    //   58	62	65	finally
    //   71	75	65	finally
    //   237	241	65	finally
    //   245	249	65	finally
    //   253	257	65	finally
    //   297	301	65	finally
    //   305	309	65	finally
    //   313	317	65	finally
    //   321	325	65	finally
    //   329	333	65	finally
    //   343	347	65	finally
    //   351	355	65	finally
    //   355	357	65	finally
    //   358	362	65	finally
    //   366	370	65	finally
    //   46	54	70	java/lang/Exception
    //   95	126	223	java/lang/Throwable
    //   126	220	223	java/lang/Throwable
    //   260	286	223	java/lang/Throwable
    //   245	249	252	java/lang/Exception
    //   305	309	312	java/lang/Exception
    //   297	301	320	java/lang/Exception
    //   237	241	328	java/lang/Exception
    //   14	25	336	finally
    //   78	95	336	finally
    //   343	347	357	java/lang/Exception
    //   351	355	365	java/lang/Exception
    //   95	126	373	finally
    //   126	220	373	finally
    //   260	286	373	finally
    //   286	293	377	finally
    //   229	233	387	finally
    //   14	25	401	java/lang/Throwable
    //   78	95	401	java/lang/Throwable
    //   286	293	410	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.smtt.sdk.TbsDownloadUpload
 * JD-Core Version:    0.7.0.1
 */