package com.tencent.smtt.utils;

import android.content.Context;
import com.tencent.smtt.sdk.QbSdk;
import java.io.File;

public class TbsConfigFile
{
  private static final String COMMON_CONFIG_FILE = "debug.conf";
  private static final String KEY_TBS_FORCE_USE_SYSTEMWEBVIEW = "setting_forceUseSystemWebview";
  private static final String KEY_TBS_FORCE_USE_SYSTEMWEBVIEW_RESULT = "result_systemWebviewForceUsed";
  static final String TBS_PRIVATE_FOLDER_NAME = "core_private";
  private static TbsConfigFile mInstance = null;
  private Context mContext = null;
  public boolean mForceUseSystemWebview = false;
  private boolean mForceUseSystemWebview_result = false;
  private File mTbsConfigDir = null;
  private File mpropFile = null;
  
  private TbsConfigFile(Context paramContext)
  {
    this.mContext = paramContext.getApplicationContext();
    loadProperties();
  }
  
  private File getConfigFile()
  {
    try
    {
      if (this.mTbsConfigDir == null)
      {
        this.mTbsConfigDir = new File(QbSdk.getTbsFolderDir(this.mContext), "core_private");
        if (this.mTbsConfigDir == null) {
          break label94;
        }
        if (!this.mTbsConfigDir.isDirectory()) {
          return null;
        }
      }
      File localFile2 = new File(this.mTbsConfigDir, "debug.conf");
      localFile1 = localFile2;
      if (localFile2 != null)
      {
        localFile1 = localFile2;
        if (!localFile2.exists())
        {
          localFile2.createNewFile();
          localFile1 = localFile2;
        }
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        File localFile1;
        localThrowable.printStackTrace();
        Object localObject = null;
      }
    }
    return localFile1;
    label94:
    return null;
  }
  
  public static TbsConfigFile getInstance()
  {
    try
    {
      TbsConfigFile localTbsConfigFile = mInstance;
      return localTbsConfigFile;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static TbsConfigFile getInstance(Context paramContext)
  {
    try
    {
      if (mInstance == null) {
        mInstance = new TbsConfigFile(paramContext);
      }
      paramContext = mInstance;
      return paramContext;
    }
    finally {}
  }
  
  /* Error */
  public void loadProperties()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aconst_null
    //   3: astore_2
    //   4: aconst_null
    //   5: astore_3
    //   6: aload_2
    //   7: astore_1
    //   8: aload_0
    //   9: getfield 46	com/tencent/smtt/utils/TbsConfigFile:mpropFile	Ljava/io/File;
    //   12: ifnonnull +13 -> 25
    //   15: aload_2
    //   16: astore_1
    //   17: aload_0
    //   18: aload_0
    //   19: invokespecial 92	com/tencent/smtt/utils/TbsConfigFile:getConfigFile	()Ljava/io/File;
    //   22: putfield 46	com/tencent/smtt/utils/TbsConfigFile:mpropFile	Ljava/io/File;
    //   25: aload_2
    //   26: astore_1
    //   27: aload_0
    //   28: getfield 46	com/tencent/smtt/utils/TbsConfigFile:mpropFile	Ljava/io/File;
    //   31: astore 4
    //   33: aload 4
    //   35: ifnonnull +31 -> 66
    //   38: iconst_0
    //   39: ifeq +11 -> 50
    //   42: new 94	java/lang/NullPointerException
    //   45: dup
    //   46: invokespecial 95	java/lang/NullPointerException:<init>	()V
    //   49: athrow
    //   50: aload_0
    //   51: monitorexit
    //   52: return
    //   53: astore_1
    //   54: aload_1
    //   55: invokevirtual 96	java/lang/Exception:printStackTrace	()V
    //   58: goto -8 -> 50
    //   61: astore_1
    //   62: aload_0
    //   63: monitorexit
    //   64: aload_1
    //   65: athrow
    //   66: aload_2
    //   67: astore_1
    //   68: new 98	java/io/BufferedInputStream
    //   71: dup
    //   72: new 100	java/io/FileInputStream
    //   75: dup
    //   76: aload_0
    //   77: getfield 46	com/tencent/smtt/utils/TbsConfigFile:mpropFile	Ljava/io/File;
    //   80: invokespecial 103	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   83: invokespecial 106	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   86: astore_2
    //   87: new 108	java/util/Properties
    //   90: dup
    //   91: invokespecial 109	java/util/Properties:<init>	()V
    //   94: astore_1
    //   95: aload_1
    //   96: aload_2
    //   97: invokevirtual 112	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   100: aload_1
    //   101: ldc 11
    //   103: ldc 114
    //   105: invokevirtual 118	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   108: astore_1
    //   109: ldc 114
    //   111: aload_1
    //   112: invokevirtual 124	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   115: ifne +11 -> 126
    //   118: aload_0
    //   119: aload_1
    //   120: invokestatic 130	java/lang/Boolean:parseBoolean	(Ljava/lang/String;)Z
    //   123: putfield 42	com/tencent/smtt/utils/TbsConfigFile:mForceUseSystemWebview	Z
    //   126: aload_2
    //   127: ifnull -77 -> 50
    //   130: aload_2
    //   131: invokevirtual 133	java/io/BufferedInputStream:close	()V
    //   134: goto -84 -> 50
    //   137: astore_1
    //   138: aload_1
    //   139: invokevirtual 96	java/lang/Exception:printStackTrace	()V
    //   142: goto -92 -> 50
    //   145: astore_1
    //   146: aload_3
    //   147: astore_2
    //   148: aload_1
    //   149: astore_3
    //   150: aload_2
    //   151: astore_1
    //   152: aload_3
    //   153: invokevirtual 83	java/lang/Throwable:printStackTrace	()V
    //   156: aload_2
    //   157: ifnull -107 -> 50
    //   160: aload_2
    //   161: invokevirtual 133	java/io/BufferedInputStream:close	()V
    //   164: goto -114 -> 50
    //   167: astore_1
    //   168: aload_1
    //   169: invokevirtual 96	java/lang/Exception:printStackTrace	()V
    //   172: goto -122 -> 50
    //   175: astore_3
    //   176: aload_1
    //   177: astore_2
    //   178: aload_3
    //   179: astore_1
    //   180: aload_2
    //   181: ifnull +7 -> 188
    //   184: aload_2
    //   185: invokevirtual 133	java/io/BufferedInputStream:close	()V
    //   188: aload_1
    //   189: athrow
    //   190: astore_2
    //   191: aload_2
    //   192: invokevirtual 96	java/lang/Exception:printStackTrace	()V
    //   195: goto -7 -> 188
    //   198: astore_1
    //   199: goto -19 -> 180
    //   202: astore_3
    //   203: goto -53 -> 150
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	206	0	this	TbsConfigFile
    //   7	20	1	localObject1	Object
    //   53	2	1	localException1	java.lang.Exception
    //   61	4	1	localObject2	Object
    //   67	53	1	localObject3	Object
    //   137	2	1	localException2	java.lang.Exception
    //   145	4	1	localThrowable1	Throwable
    //   151	1	1	localObject4	Object
    //   167	10	1	localException3	java.lang.Exception
    //   179	10	1	localObject5	Object
    //   198	1	1	localObject6	Object
    //   3	182	2	localObject7	Object
    //   190	2	2	localException4	java.lang.Exception
    //   5	148	3	localObject8	Object
    //   175	4	3	localObject9	Object
    //   202	1	3	localThrowable2	Throwable
    //   31	3	4	localFile	File
    // Exception table:
    //   from	to	target	type
    //   42	50	53	java/lang/Exception
    //   42	50	61	finally
    //   54	58	61	finally
    //   130	134	61	finally
    //   138	142	61	finally
    //   160	164	61	finally
    //   168	172	61	finally
    //   184	188	61	finally
    //   188	190	61	finally
    //   191	195	61	finally
    //   130	134	137	java/lang/Exception
    //   8	15	145	java/lang/Throwable
    //   17	25	145	java/lang/Throwable
    //   27	33	145	java/lang/Throwable
    //   68	87	145	java/lang/Throwable
    //   160	164	167	java/lang/Exception
    //   8	15	175	finally
    //   17	25	175	finally
    //   27	33	175	finally
    //   68	87	175	finally
    //   152	156	175	finally
    //   184	188	190	java/lang/Exception
    //   87	126	198	finally
    //   87	126	202	java/lang/Throwable
  }
  
  /* Error */
  public boolean resetProperties()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore_2
    //   5: iconst_0
    //   6: istore_1
    //   7: aload_0
    //   8: invokespecial 92	com/tencent/smtt/utils/TbsConfigFile:getConfigFile	()Ljava/io/File;
    //   11: astore 6
    //   13: aload 6
    //   15: ifnonnull +44 -> 59
    //   18: iconst_0
    //   19: ifeq +11 -> 30
    //   22: new 94	java/lang/NullPointerException
    //   25: dup
    //   26: invokespecial 95	java/lang/NullPointerException:<init>	()V
    //   29: athrow
    //   30: iconst_0
    //   31: ifeq +11 -> 42
    //   34: new 94	java/lang/NullPointerException
    //   37: dup
    //   38: invokespecial 95	java/lang/NullPointerException:<init>	()V
    //   41: athrow
    //   42: iload_1
    //   43: ireturn
    //   44: astore_2
    //   45: aload_2
    //   46: invokevirtual 96	java/lang/Exception:printStackTrace	()V
    //   49: goto -19 -> 30
    //   52: astore_2
    //   53: aload_2
    //   54: invokevirtual 96	java/lang/Exception:printStackTrace	()V
    //   57: iconst_0
    //   58: ireturn
    //   59: new 98	java/io/BufferedInputStream
    //   62: dup
    //   63: new 100	java/io/FileInputStream
    //   66: dup
    //   67: aload 6
    //   69: invokespecial 103	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   72: invokespecial 106	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   75: astore_3
    //   76: new 108	java/util/Properties
    //   79: dup
    //   80: invokespecial 109	java/util/Properties:<init>	()V
    //   83: astore 5
    //   85: aload 5
    //   87: aload_3
    //   88: invokevirtual 112	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   91: aload_0
    //   92: iconst_0
    //   93: putfield 42	com/tencent/smtt/utils/TbsConfigFile:mForceUseSystemWebview	Z
    //   96: aload 5
    //   98: ldc 11
    //   100: aload_0
    //   101: getfield 42	com/tencent/smtt/utils/TbsConfigFile:mForceUseSystemWebview	Z
    //   104: invokestatic 138	java/lang/Boolean:toString	(Z)Ljava/lang/String;
    //   107: invokevirtual 142	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   110: pop
    //   111: aload_0
    //   112: iconst_0
    //   113: putfield 44	com/tencent/smtt/utils/TbsConfigFile:mForceUseSystemWebview_result	Z
    //   116: aload 5
    //   118: ldc 14
    //   120: aload_0
    //   121: getfield 44	com/tencent/smtt/utils/TbsConfigFile:mForceUseSystemWebview_result	Z
    //   124: invokestatic 138	java/lang/Boolean:toString	(Z)Ljava/lang/String;
    //   127: invokevirtual 142	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   130: pop
    //   131: new 144	java/io/BufferedOutputStream
    //   134: dup
    //   135: new 146	java/io/FileOutputStream
    //   138: dup
    //   139: aload 6
    //   141: invokespecial 147	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   144: invokespecial 150	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   147: astore_2
    //   148: aload 5
    //   150: aload_2
    //   151: aconst_null
    //   152: invokevirtual 154	java/util/Properties:store	(Ljava/io/OutputStream;Ljava/lang/String;)V
    //   155: iconst_1
    //   156: istore_1
    //   157: aload_3
    //   158: ifnull +7 -> 165
    //   161: aload_3
    //   162: invokevirtual 133	java/io/BufferedInputStream:close	()V
    //   165: aload_2
    //   166: ifnull -124 -> 42
    //   169: aload_2
    //   170: invokevirtual 155	java/io/BufferedOutputStream:close	()V
    //   173: iconst_1
    //   174: ireturn
    //   175: astore_2
    //   176: aload_2
    //   177: invokevirtual 96	java/lang/Exception:printStackTrace	()V
    //   180: iconst_1
    //   181: ireturn
    //   182: astore_3
    //   183: aload_3
    //   184: invokevirtual 96	java/lang/Exception:printStackTrace	()V
    //   187: goto -22 -> 165
    //   190: astore 4
    //   192: aconst_null
    //   193: astore 5
    //   195: aload_2
    //   196: astore_3
    //   197: aload 5
    //   199: astore_2
    //   200: aload 4
    //   202: invokevirtual 83	java/lang/Throwable:printStackTrace	()V
    //   205: aload_3
    //   206: ifnull +7 -> 213
    //   209: aload_3
    //   210: invokevirtual 133	java/io/BufferedInputStream:close	()V
    //   213: aload_2
    //   214: ifnull -172 -> 42
    //   217: aload_2
    //   218: invokevirtual 155	java/io/BufferedOutputStream:close	()V
    //   221: iconst_0
    //   222: ireturn
    //   223: astore_2
    //   224: aload_2
    //   225: invokevirtual 96	java/lang/Exception:printStackTrace	()V
    //   228: iconst_0
    //   229: ireturn
    //   230: astore_3
    //   231: aload_3
    //   232: invokevirtual 96	java/lang/Exception:printStackTrace	()V
    //   235: goto -22 -> 213
    //   238: astore_2
    //   239: aconst_null
    //   240: astore_3
    //   241: aload_3
    //   242: ifnull +7 -> 249
    //   245: aload_3
    //   246: invokevirtual 133	java/io/BufferedInputStream:close	()V
    //   249: aload 4
    //   251: ifnull +8 -> 259
    //   254: aload 4
    //   256: invokevirtual 155	java/io/BufferedOutputStream:close	()V
    //   259: aload_2
    //   260: athrow
    //   261: astore_3
    //   262: aload_3
    //   263: invokevirtual 96	java/lang/Exception:printStackTrace	()V
    //   266: goto -17 -> 249
    //   269: astore_3
    //   270: aload_3
    //   271: invokevirtual 96	java/lang/Exception:printStackTrace	()V
    //   274: goto -15 -> 259
    //   277: astore_2
    //   278: goto -37 -> 241
    //   281: astore 5
    //   283: aload_2
    //   284: astore 4
    //   286: aload 5
    //   288: astore_2
    //   289: goto -48 -> 241
    //   292: astore 5
    //   294: aload_2
    //   295: astore 4
    //   297: aload 5
    //   299: astore_2
    //   300: goto -59 -> 241
    //   303: astore 4
    //   305: aconst_null
    //   306: astore_2
    //   307: goto -107 -> 200
    //   310: astore 4
    //   312: goto -112 -> 200
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	315	0	this	TbsConfigFile
    //   6	151	1	bool	boolean
    //   4	1	2	localObject1	Object
    //   44	2	2	localException1	java.lang.Exception
    //   52	2	2	localException2	java.lang.Exception
    //   147	23	2	localBufferedOutputStream	java.io.BufferedOutputStream
    //   175	21	2	localException3	java.lang.Exception
    //   199	19	2	localObject2	Object
    //   223	2	2	localException4	java.lang.Exception
    //   238	22	2	localObject3	Object
    //   277	7	2	localObject4	Object
    //   288	19	2	localObject5	Object
    //   75	87	3	localBufferedInputStream	java.io.BufferedInputStream
    //   182	2	3	localException5	java.lang.Exception
    //   196	14	3	localException6	java.lang.Exception
    //   230	2	3	localException7	java.lang.Exception
    //   240	6	3	localObject6	Object
    //   261	2	3	localException8	java.lang.Exception
    //   269	2	3	localException9	java.lang.Exception
    //   1	1	4	localObject7	Object
    //   190	65	4	localThrowable1	Throwable
    //   284	12	4	localObject8	Object
    //   303	1	4	localThrowable2	Throwable
    //   310	1	4	localThrowable3	Throwable
    //   83	115	5	localProperties	java.util.Properties
    //   281	6	5	localObject9	Object
    //   292	6	5	localObject10	Object
    //   11	129	6	localFile	File
    // Exception table:
    //   from	to	target	type
    //   22	30	44	java/lang/Exception
    //   34	42	52	java/lang/Exception
    //   169	173	175	java/lang/Exception
    //   161	165	182	java/lang/Exception
    //   7	13	190	java/lang/Throwable
    //   59	76	190	java/lang/Throwable
    //   217	221	223	java/lang/Exception
    //   209	213	230	java/lang/Exception
    //   7	13	238	finally
    //   59	76	238	finally
    //   245	249	261	java/lang/Exception
    //   254	259	269	java/lang/Exception
    //   76	148	277	finally
    //   148	155	281	finally
    //   200	205	292	finally
    //   76	148	303	java/lang/Throwable
    //   148	155	310	java/lang/Throwable
  }
  
  /* Error */
  public void saveProperties()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore_1
    //   4: aload_0
    //   5: invokespecial 92	com/tencent/smtt/utils/TbsConfigFile:getConfigFile	()Ljava/io/File;
    //   8: astore 4
    //   10: aload 4
    //   12: ifnonnull +33 -> 45
    //   15: new 94	java/lang/NullPointerException
    //   18: dup
    //   19: invokespecial 95	java/lang/NullPointerException:<init>	()V
    //   22: athrow
    //   23: new 94	java/lang/NullPointerException
    //   26: dup
    //   27: invokespecial 95	java/lang/NullPointerException:<init>	()V
    //   30: athrow
    //   31: astore_1
    //   32: aload_1
    //   33: invokevirtual 96	java/lang/Exception:printStackTrace	()V
    //   36: goto -13 -> 23
    //   39: astore_1
    //   40: aload_1
    //   41: invokevirtual 96	java/lang/Exception:printStackTrace	()V
    //   44: return
    //   45: new 98	java/io/BufferedInputStream
    //   48: dup
    //   49: new 100	java/io/FileInputStream
    //   52: dup
    //   53: aload 4
    //   55: invokespecial 103	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   58: invokespecial 106	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   61: astore_2
    //   62: new 108	java/util/Properties
    //   65: dup
    //   66: invokespecial 109	java/util/Properties:<init>	()V
    //   69: astore 5
    //   71: aload 5
    //   73: aload_2
    //   74: invokevirtual 112	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   77: aload 5
    //   79: ldc 11
    //   81: aload_0
    //   82: getfield 42	com/tencent/smtt/utils/TbsConfigFile:mForceUseSystemWebview	Z
    //   85: invokestatic 138	java/lang/Boolean:toString	(Z)Ljava/lang/String;
    //   88: invokevirtual 142	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   91: pop
    //   92: aload 5
    //   94: ldc 14
    //   96: aload_0
    //   97: getfield 44	com/tencent/smtt/utils/TbsConfigFile:mForceUseSystemWebview_result	Z
    //   100: invokestatic 138	java/lang/Boolean:toString	(Z)Ljava/lang/String;
    //   103: invokevirtual 142	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   106: pop
    //   107: new 144	java/io/BufferedOutputStream
    //   110: dup
    //   111: new 146	java/io/FileOutputStream
    //   114: dup
    //   115: aload 4
    //   117: invokespecial 147	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   120: invokespecial 150	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   123: astore_1
    //   124: aload 5
    //   126: aload_1
    //   127: aconst_null
    //   128: invokevirtual 154	java/util/Properties:store	(Ljava/io/OutputStream;Ljava/lang/String;)V
    //   131: aload_2
    //   132: invokevirtual 133	java/io/BufferedInputStream:close	()V
    //   135: aload_1
    //   136: invokevirtual 155	java/io/BufferedOutputStream:close	()V
    //   139: return
    //   140: astore_1
    //   141: aload_1
    //   142: invokevirtual 96	java/lang/Exception:printStackTrace	()V
    //   145: return
    //   146: astore_2
    //   147: aload_2
    //   148: invokevirtual 96	java/lang/Exception:printStackTrace	()V
    //   151: goto -16 -> 135
    //   154: astore_3
    //   155: aconst_null
    //   156: astore 4
    //   158: aload_1
    //   159: astore_2
    //   160: aload 4
    //   162: astore_1
    //   163: aload_3
    //   164: invokevirtual 83	java/lang/Throwable:printStackTrace	()V
    //   167: aload_2
    //   168: invokevirtual 133	java/io/BufferedInputStream:close	()V
    //   171: aload_1
    //   172: invokevirtual 155	java/io/BufferedOutputStream:close	()V
    //   175: return
    //   176: astore_1
    //   177: aload_1
    //   178: invokevirtual 96	java/lang/Exception:printStackTrace	()V
    //   181: return
    //   182: astore_2
    //   183: aload_2
    //   184: invokevirtual 96	java/lang/Exception:printStackTrace	()V
    //   187: goto -16 -> 171
    //   190: astore_1
    //   191: aconst_null
    //   192: astore_2
    //   193: aload_2
    //   194: invokevirtual 133	java/io/BufferedInputStream:close	()V
    //   197: aload_3
    //   198: invokevirtual 155	java/io/BufferedOutputStream:close	()V
    //   201: aload_1
    //   202: athrow
    //   203: astore_2
    //   204: aload_2
    //   205: invokevirtual 96	java/lang/Exception:printStackTrace	()V
    //   208: goto -11 -> 197
    //   211: astore_2
    //   212: aload_2
    //   213: invokevirtual 96	java/lang/Exception:printStackTrace	()V
    //   216: goto -15 -> 201
    //   219: astore_1
    //   220: goto -27 -> 193
    //   223: astore 4
    //   225: aload_1
    //   226: astore_3
    //   227: aload 4
    //   229: astore_1
    //   230: goto -37 -> 193
    //   233: astore 4
    //   235: aload_1
    //   236: astore_3
    //   237: aload 4
    //   239: astore_1
    //   240: goto -47 -> 193
    //   243: astore_3
    //   244: aconst_null
    //   245: astore_1
    //   246: goto -83 -> 163
    //   249: astore_3
    //   250: goto -87 -> 163
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	253	0	this	TbsConfigFile
    //   3	1	1	localObject1	Object
    //   31	2	1	localException1	java.lang.Exception
    //   39	2	1	localException2	java.lang.Exception
    //   123	13	1	localBufferedOutputStream	java.io.BufferedOutputStream
    //   140	19	1	localException3	java.lang.Exception
    //   162	10	1	localObject2	Object
    //   176	2	1	localException4	java.lang.Exception
    //   190	12	1	localObject3	Object
    //   219	7	1	localObject4	Object
    //   229	17	1	localObject5	Object
    //   61	71	2	localBufferedInputStream	java.io.BufferedInputStream
    //   146	2	2	localException5	java.lang.Exception
    //   159	9	2	localException6	java.lang.Exception
    //   182	2	2	localException7	java.lang.Exception
    //   192	2	2	localObject6	Object
    //   203	2	2	localException8	java.lang.Exception
    //   211	2	2	localException9	java.lang.Exception
    //   1	1	3	localObject7	Object
    //   154	44	3	localThrowable1	Throwable
    //   226	11	3	localObject8	Object
    //   243	1	3	localThrowable2	Throwable
    //   249	1	3	localThrowable3	Throwable
    //   8	153	4	localFile	File
    //   223	5	4	localObject9	Object
    //   233	5	4	localObject10	Object
    //   69	56	5	localProperties	java.util.Properties
    // Exception table:
    //   from	to	target	type
    //   15	23	31	java/lang/Exception
    //   23	31	39	java/lang/Exception
    //   135	139	140	java/lang/Exception
    //   131	135	146	java/lang/Exception
    //   4	10	154	java/lang/Throwable
    //   45	62	154	java/lang/Throwable
    //   171	175	176	java/lang/Exception
    //   167	171	182	java/lang/Exception
    //   4	10	190	finally
    //   45	62	190	finally
    //   193	197	203	java/lang/Exception
    //   197	201	211	java/lang/Exception
    //   62	124	219	finally
    //   124	131	223	finally
    //   163	167	233	finally
    //   62	124	243	java/lang/Throwable
    //   124	131	249	java/lang/Throwable
  }
  
  public void setForceUseSystemWebview(boolean paramBoolean)
  {
    this.mForceUseSystemWebview_result = paramBoolean;
    saveProperties();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.smtt.utils.TbsConfigFile
 * JD-Core Version:    0.7.0.1
 */