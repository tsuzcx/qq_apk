package com.tencent.smtt.sdk;

import android.content.Context;
import java.io.File;
import java.io.IOException;
import java.util.Properties;

class TbsCoreVerManager
{
  private static final String TAG = "TbsCoreVerManager";
  static final String TBS_APK_PATH = "install_apk_path";
  private static final String TBS_CORE_BACKUP_STATUS = "backup_status";
  static final String TBS_CORE_COPY_RETRY_NUM = "copy_retry_num";
  static final String TBS_CORE_COPY_STATUS = "copy_status";
  static final String TBS_CORE_COPY_VER = "copy_core_ver";
  static final String TBS_CORE_DEXOPT_RETRY_NUM = "dexopt_retry_num";
  static final String TBS_CORE_INCREUPDATE_NUM = "incrupdate_retry_num";
  static final String TBS_CORE_INSTALL_FILE = "tbscoreinstall.txt";
  static final String TBS_CORE_INSTALL_STATUS = "install_status";
  static final String TBS_CORE_INSTALL_VER = "install_core_ver";
  static final String TBS_CORE_TPATCH_NUM = "tpatch_num";
  static final String TBS_CORE_TPATCH_STATUS = "tpatch_status";
  static final String TBS_CORE_TPATCH_VER = "tpatch_ver";
  static final String TBS_CORE_UNZIP_RETRY_NUM = "unzip_retry_num";
  static final String TBS_INCRUPDATE_STATUS = "incrupdate_status";
  static final String TBS_THIRD_REMOVE_OLD_CORE = "remove_old_core";
  static final String TBS_UNLZMA_STATUS = "unlzma_status";
  private static Context mContext = null;
  private static TbsCoreVerManager mInstance = null;
  
  static TbsCoreVerManager getInstance(Context paramContext)
  {
    if (mInstance == null) {}
    try
    {
      if (mInstance == null) {
        mInstance = new TbsCoreVerManager();
      }
      mContext = paramContext.getApplicationContext();
      return mInstance;
    }
    finally {}
  }
  
  /* Error */
  private Properties getTbsCoreInstallProp()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aload_0
    //   3: invokevirtual 92	com/tencent/smtt/sdk/TbsCoreVerManager:getTbsCoreInstallFile	()Ljava/io/File;
    //   6: astore_2
    //   7: new 94	java/util/Properties
    //   10: dup
    //   11: invokespecial 95	java/util/Properties:<init>	()V
    //   14: astore_1
    //   15: aload_2
    //   16: ifnull +115 -> 131
    //   19: aload_1
    //   20: ifnull +111 -> 131
    //   23: new 97	java/io/BufferedInputStream
    //   26: dup
    //   27: new 99	java/io/FileInputStream
    //   30: dup
    //   31: aload_2
    //   32: invokespecial 102	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   35: invokespecial 105	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   38: astore_2
    //   39: aload_1
    //   40: aload_2
    //   41: invokevirtual 108	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   44: aload_2
    //   45: ifnull +7 -> 52
    //   48: aload_2
    //   49: invokevirtual 111	java/io/BufferedInputStream:close	()V
    //   52: aload_1
    //   53: astore_3
    //   54: aload_3
    //   55: areturn
    //   56: astore_2
    //   57: aload_2
    //   58: invokevirtual 114	java/io/IOException:printStackTrace	()V
    //   61: goto -9 -> 52
    //   64: astore_3
    //   65: aconst_null
    //   66: astore_2
    //   67: aconst_null
    //   68: astore_1
    //   69: aload_3
    //   70: invokevirtual 115	java/lang/Exception:printStackTrace	()V
    //   73: aload_1
    //   74: astore_3
    //   75: aload_2
    //   76: ifnull -22 -> 54
    //   79: aload_2
    //   80: invokevirtual 111	java/io/BufferedInputStream:close	()V
    //   83: aload_1
    //   84: areturn
    //   85: astore_2
    //   86: aload_2
    //   87: invokevirtual 114	java/io/IOException:printStackTrace	()V
    //   90: aload_1
    //   91: areturn
    //   92: astore_1
    //   93: aload_3
    //   94: astore_2
    //   95: aload_2
    //   96: ifnull +7 -> 103
    //   99: aload_2
    //   100: invokevirtual 111	java/io/BufferedInputStream:close	()V
    //   103: aload_1
    //   104: athrow
    //   105: astore_2
    //   106: aload_2
    //   107: invokevirtual 114	java/io/IOException:printStackTrace	()V
    //   110: goto -7 -> 103
    //   113: astore_1
    //   114: goto -19 -> 95
    //   117: astore_1
    //   118: goto -23 -> 95
    //   121: astore_3
    //   122: aconst_null
    //   123: astore_2
    //   124: goto -55 -> 69
    //   127: astore_3
    //   128: goto -59 -> 69
    //   131: aconst_null
    //   132: astore_2
    //   133: goto -89 -> 44
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	136	0	this	TbsCoreVerManager
    //   14	77	1	localProperties	Properties
    //   92	12	1	localObject1	Object
    //   113	1	1	localObject2	Object
    //   117	1	1	localObject3	Object
    //   6	43	2	localObject4	Object
    //   56	2	2	localIOException1	IOException
    //   66	14	2	localObject5	Object
    //   85	2	2	localIOException2	IOException
    //   94	6	2	localObject6	Object
    //   105	2	2	localIOException3	IOException
    //   123	10	2	localObject7	Object
    //   1	54	3	localObject8	Object
    //   64	6	3	localException1	java.lang.Exception
    //   74	20	3	localObject9	Object
    //   121	1	3	localException2	java.lang.Exception
    //   127	1	3	localException3	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   48	52	56	java/io/IOException
    //   2	15	64	java/lang/Exception
    //   79	83	85	java/io/IOException
    //   2	15	92	finally
    //   23	39	92	finally
    //   99	103	105	java/io/IOException
    //   39	44	113	finally
    //   69	73	117	finally
    //   23	39	121	java/lang/Exception
    //   39	44	127	java/lang/Exception
  }
  
  int getIntNum(String paramString)
  {
    Properties localProperties = getTbsCoreInstallProp();
    if ((localProperties != null) && (localProperties.getProperty(paramString) != null)) {
      return Integer.parseInt(localProperties.getProperty(paramString));
    }
    return 0;
  }
  
  int getIntStatus(String paramString)
  {
    Properties localProperties = getTbsCoreInstallProp();
    if ((localProperties != null) && (localProperties.getProperty(paramString) != null)) {
      return Integer.parseInt(localProperties.getProperty(paramString));
    }
    return -1;
  }
  
  String getStringValue(String paramString)
  {
    Properties localProperties = getTbsCoreInstallProp();
    if ((localProperties != null) && (localProperties.getProperty(paramString) != null)) {
      return localProperties.getProperty(paramString);
    }
    return null;
  }
  
  int getTbsCoreIncrUpdateStatus()
  {
    return getIntStatus("incrupdate_status");
  }
  
  File getTbsCoreInstallFile()
  {
    TbsInstaller.getInstance();
    File localFile = new File(TbsInstaller.getTbsCorePrivateDir(mContext), "tbscoreinstall.txt");
    if ((localFile != null) && (!localFile.exists())) {}
    try
    {
      localFile.createNewFile();
      return localFile;
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
    }
    return null;
  }
  
  int getTbsCoreInstallStatus()
  {
    return getIntStatus("install_status");
  }
  
  int getTbsCoreInstallVer()
  {
    return getIntNum("install_core_ver");
  }
  
  void setStatus(String paramString, int paramInt)
  {
    setStatus(paramString, String.valueOf(paramInt));
  }
  
  /* Error */
  void setStatus(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aload_0
    //   4: invokespecial 119	com/tencent/smtt/sdk/TbsCoreVerManager:getTbsCoreInstallProp	()Ljava/util/Properties;
    //   7: astore 5
    //   9: aload 4
    //   11: astore_3
    //   12: aload 5
    //   14: ifnull +64 -> 78
    //   17: aload 5
    //   19: aload_1
    //   20: aload_2
    //   21: invokevirtual 174	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   24: pop
    //   25: aload_0
    //   26: invokevirtual 92	com/tencent/smtt/sdk/TbsCoreVerManager:getTbsCoreInstallFile	()Ljava/io/File;
    //   29: astore_2
    //   30: aload 4
    //   32: astore_3
    //   33: aload_2
    //   34: ifnull +44 -> 78
    //   37: new 176	java/io/FileOutputStream
    //   40: dup
    //   41: aload_2
    //   42: invokespecial 177	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   45: astore_3
    //   46: aload_3
    //   47: astore_2
    //   48: aload 5
    //   50: aload_3
    //   51: new 179	java/lang/StringBuilder
    //   54: dup
    //   55: invokespecial 180	java/lang/StringBuilder:<init>	()V
    //   58: ldc 182
    //   60: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: aload_1
    //   64: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: ldc 188
    //   69: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: invokevirtual 192	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   75: invokevirtual 196	java/util/Properties:store	(Ljava/io/OutputStream;Ljava/lang/String;)V
    //   78: aload_3
    //   79: ifnull +7 -> 86
    //   82: aload_3
    //   83: invokevirtual 197	java/io/FileOutputStream:close	()V
    //   86: return
    //   87: astore_1
    //   88: aload_1
    //   89: invokevirtual 114	java/io/IOException:printStackTrace	()V
    //   92: return
    //   93: astore_1
    //   94: aconst_null
    //   95: astore_3
    //   96: aload_3
    //   97: astore_2
    //   98: aload_1
    //   99: invokevirtual 115	java/lang/Exception:printStackTrace	()V
    //   102: aload_3
    //   103: ifnull -17 -> 86
    //   106: aload_3
    //   107: invokevirtual 197	java/io/FileOutputStream:close	()V
    //   110: return
    //   111: astore_1
    //   112: aload_1
    //   113: invokevirtual 114	java/io/IOException:printStackTrace	()V
    //   116: return
    //   117: astore_1
    //   118: aconst_null
    //   119: astore_2
    //   120: aload_2
    //   121: ifnull +7 -> 128
    //   124: aload_2
    //   125: invokevirtual 197	java/io/FileOutputStream:close	()V
    //   128: aload_1
    //   129: athrow
    //   130: astore_2
    //   131: aload_2
    //   132: invokevirtual 114	java/io/IOException:printStackTrace	()V
    //   135: goto -7 -> 128
    //   138: astore_1
    //   139: goto -19 -> 120
    //   142: astore_1
    //   143: goto -47 -> 96
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	146	0	this	TbsCoreVerManager
    //   0	146	1	paramString1	String
    //   0	146	2	paramString2	String
    //   11	96	3	localObject1	Object
    //   1	30	4	localObject2	Object
    //   7	42	5	localProperties	Properties
    // Exception table:
    //   from	to	target	type
    //   82	86	87	java/io/IOException
    //   3	9	93	java/lang/Exception
    //   17	30	93	java/lang/Exception
    //   37	46	93	java/lang/Exception
    //   106	110	111	java/io/IOException
    //   3	9	117	finally
    //   17	30	117	finally
    //   37	46	117	finally
    //   124	128	130	java/io/IOException
    //   48	78	138	finally
    //   98	102	138	finally
    //   48	78	142	java/lang/Exception
  }
  
  void setTbsApkPath(String paramString)
  {
    setStatus("install_apk_path", paramString);
  }
  
  void setTbsCoreCopyStatus(int paramInt1, int paramInt2)
  {
    setStatus("copy_core_ver", paramInt1);
    setStatus("copy_status", paramInt2);
  }
  
  void setTbsCoreDexoptRetryNum(int paramInt)
  {
    setStatus("dexopt_retry_num", paramInt);
  }
  
  void setTbsCoreIncrUpdateStatus(int paramInt)
  {
    setStatus("incrupdate_status", paramInt);
  }
  
  void setTbsCoreInstallStatus(int paramInt1, int paramInt2)
  {
    setStatus("install_core_ver", paramInt1);
    setStatus("install_status", paramInt2);
  }
  
  void setTbsCoreTpatchStatus(int paramInt1, int paramInt2)
  {
    setStatus("tpatch_ver", paramInt1);
    setStatus("tpatch_status", paramInt2);
  }
  
  void setTbsCoreUnlzmaStatus(int paramInt)
  {
    setStatus("unlzma_status", paramInt);
  }
  
  void setTbsCoreUnzipRetryNum(int paramInt)
  {
    setStatus("unzip_retry_num", paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.smtt.sdk.TbsCoreVerManager
 * JD-Core Version:    0.7.0.1
 */