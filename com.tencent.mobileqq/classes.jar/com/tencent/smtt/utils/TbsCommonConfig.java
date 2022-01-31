package com.tencent.smtt.utils;

import android.annotation.TargetApi;
import android.content.Context;
import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;

public class TbsCommonConfig
{
  private static final String COMMON_CONFIG_FILE = "tbsnet.conf";
  private static final String FORMAL_PV_POST_URL = "http://log.tbs.qq.com/ajax?c=pu&v=2&k=";
  private static final String FORMAL_PV_POST_URL_TK = "http://log.tbs.qq.com/ajax?c=pu&tk=";
  private static final String FORMAL_TBSLOG_POST_URL = "http://log.tbs.qq.com/ajax?c=ul&v=2&k=";
  private static final String FORMAL_TBS_CMD_POST_URL = "http://log.tbs.qq.com/ajax?c=ucfu&k=";
  private static final String FORMAL_TBS_DOWNLOADER_POST_URL = "http://cfg.imtt.qq.com/tbs?mk=";
  private static final String FORMAL_TBS_DOWNLOADER_POST_URL_V2 = "http://cfg.imtt.qq.com/tbs?v=2&mk=";
  private static final String FORMAL_TBS_DOWNLOAD_STAT_POST_URL = "http://log.tbs.qq.com/ajax?c=dl&k=";
  private static final String FORMAL_TIPS_URL = "http://mqqad.html5.qq.com/adjs";
  private static final String KEY_PV_POST_URL = "pv_post_url";
  private static final String KEY_PV_POST_URLWITHTK = "pv_post_url_tk";
  private static final String KEY_TBS_CMD_POST_URL = "tbs_cmd_post_url";
  private static final String KEY_TBS_DOWNLOADER_POST_URL = "tbs_downloader_post_url";
  private static final String KEY_TBS_DOWNLOAD_STAT_POST_URL = "tbs_download_stat_post_url";
  private static final String KEY_TBS_LOG_POST_URL = "tbs_log_post_url";
  private static final String KEY_TIPS_URL = "tips_url";
  private static final String KEY_WUP_PROXY_DOMAIN = "wup_proxy_domain";
  private static final String LOGTAG = "TbsCommonConfig";
  private static final String TBS_FOLDER_NAME = "tbs";
  private static final String TEST_PV_POST_URL = "http://tr.cs0309.imtt.qq.com/ajax?c=pu&k=";
  private static final String TEST_TBSLOG_POST_URL = "http://tr.cs0309.imtt.qq.com/ajax?c=ul&k=";
  private static final String TEST_TBS_CMD_POST_URL = "http://tr.cs0309.imtt.qq.com/ajax?c=ucfu&k=";
  private static final String TEST_TBS_DOWNLOADER_POST_URL = "http://cfg.cs0309.imtt.qq.com/tbs?mk=";
  private static final String TEST_TBS_DOWNLOAD_STAT_POST_URL = "http://tr.cs0309.imtt.qq.com/ajax?c=dl&k=";
  private static final String TEST_TIPS_URL = "http://mqqad.cs0309.html5.qq.com/adjs";
  private static final String WUP_PROXY_DOMAIN = "http://wup.imtt.qq.com:8080";
  private static TbsCommonConfig mInstance = null;
  private Context mContext = null;
  private String mPvUploadPostUrl = "http://log.tbs.qq.com/ajax?c=pu&v=2&k=";
  private String mPvUploadPostUrlTK = "http://log.tbs.qq.com/ajax?c=pu&tk=";
  private String mTbsCmdPostUrl = "http://log.tbs.qq.com/ajax?c=ucfu&k=";
  private File mTbsConfigDir = null;
  private String mTbsDownloadStatPostUrl = "http://log.tbs.qq.com/ajax?c=dl&k=";
  private String mTbsDownloaderPostUrl = "http://cfg.imtt.qq.com/tbs?v=2&mk=";
  private String mTbsLogPostUrl = "http://log.tbs.qq.com/ajax?c=ul&v=2&k=";
  private String mTipsUrl = "http://mqqad.html5.qq.com/adjs";
  private String mWupProxyDomain = "http://wup.imtt.qq.com:8080";
  
  @TargetApi(11)
  private TbsCommonConfig(Context paramContext)
  {
    TbsLog.w("TbsCommonConfig", "TbsCommonConfig constructing...");
    this.mContext = paramContext.getApplicationContext();
    loadProperties();
  }
  
  private File getConfigFile()
  {
    try
    {
      if (this.mTbsConfigDir == null)
      {
        this.mTbsConfigDir = new File(FileUtil.getTBSSdcardFilePath(this.mContext, 5));
        if ((this.mTbsConfigDir == null) || (!this.mTbsConfigDir.isDirectory())) {
          break label186;
        }
      }
      localFile = new File(this.mTbsConfigDir, "tbsnet.conf");
      if (!localFile.exists())
      {
        TbsLog.e("TbsCommonConfig", "Get file(" + localFile.getCanonicalPath() + ") failed!");
        return null;
      }
      try
      {
        TbsLog.w("TbsCommonConfig", "pathc:" + localFile.getCanonicalPath());
        return localFile;
      }
      catch (Throwable localThrowable1) {}
    }
    catch (Throwable localThrowable2)
    {
      for (;;)
      {
        StringWriter localStringWriter;
        File localFile = null;
      }
    }
    localStringWriter = new StringWriter();
    localThrowable1.printStackTrace(new PrintWriter(localStringWriter));
    TbsLog.e("TbsCommonConfig", "exceptions occurred2:" + localStringWriter.toString());
    return localFile;
    label186:
    return null;
  }
  
  public static TbsCommonConfig getInstance()
  {
    try
    {
      TbsCommonConfig localTbsCommonConfig = mInstance;
      return localTbsCommonConfig;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static TbsCommonConfig getInstance(Context paramContext)
  {
    try
    {
      if (mInstance == null) {
        mInstance = new TbsCommonConfig(paramContext);
      }
      paramContext = mInstance;
      return paramContext;
    }
    finally {}
  }
  
  /* Error */
  private void loadProperties()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aconst_null
    //   3: astore_1
    //   4: aload_0
    //   5: invokespecial 219	com/tencent/smtt/utils/TbsCommonConfig:getConfigFile	()Ljava/io/File;
    //   8: astore_2
    //   9: aload_2
    //   10: ifnonnull +25 -> 35
    //   13: ldc 59
    //   15: ldc 221
    //   17: invokestatic 193	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   20: iconst_0
    //   21: ifeq +11 -> 32
    //   24: new 223	java/lang/NullPointerException
    //   27: dup
    //   28: invokespecial 224	java/lang/NullPointerException:<init>	()V
    //   31: athrow
    //   32: aload_0
    //   33: monitorexit
    //   34: return
    //   35: new 226	java/io/BufferedInputStream
    //   38: dup
    //   39: new 228	java/io/FileInputStream
    //   42: dup
    //   43: aload_2
    //   44: invokespecial 231	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   47: invokespecial 234	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   50: astore_2
    //   51: new 236	java/util/Properties
    //   54: dup
    //   55: invokespecial 237	java/util/Properties:<init>	()V
    //   58: astore_1
    //   59: aload_1
    //   60: aload_2
    //   61: invokevirtual 240	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   64: aload_1
    //   65: ldc 35
    //   67: ldc 242
    //   69: invokevirtual 246	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   72: astore_3
    //   73: ldc 242
    //   75: aload_3
    //   76: invokevirtual 252	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   79: ifne +8 -> 87
    //   82: aload_0
    //   83: aload_3
    //   84: putfield 115	com/tencent/smtt/utils/TbsCommonConfig:mPvUploadPostUrl	Ljava/lang/String;
    //   87: aload_1
    //   88: ldc 56
    //   90: ldc 242
    //   92: invokevirtual 246	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   95: astore_3
    //   96: ldc 242
    //   98: aload_3
    //   99: invokevirtual 252	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   102: ifne +8 -> 110
    //   105: aload_0
    //   106: aload_3
    //   107: putfield 119	com/tencent/smtt/utils/TbsCommonConfig:mWupProxyDomain	Ljava/lang/String;
    //   110: aload_1
    //   111: ldc 47
    //   113: ldc 242
    //   115: invokevirtual 246	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   118: astore_3
    //   119: ldc 242
    //   121: aload_3
    //   122: invokevirtual 252	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   125: ifne +8 -> 133
    //   128: aload_0
    //   129: aload_3
    //   130: putfield 121	com/tencent/smtt/utils/TbsCommonConfig:mTbsDownloadStatPostUrl	Ljava/lang/String;
    //   133: aload_1
    //   134: ldc 44
    //   136: ldc 242
    //   138: invokevirtual 246	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   141: astore_3
    //   142: ldc 242
    //   144: aload_3
    //   145: invokevirtual 252	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   148: ifne +8 -> 156
    //   151: aload_0
    //   152: aload_3
    //   153: putfield 123	com/tencent/smtt/utils/TbsCommonConfig:mTbsDownloaderPostUrl	Ljava/lang/String;
    //   156: aload_1
    //   157: ldc 50
    //   159: ldc 242
    //   161: invokevirtual 246	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   164: astore_3
    //   165: ldc 242
    //   167: aload_3
    //   168: invokevirtual 252	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   171: ifne +8 -> 179
    //   174: aload_0
    //   175: aload_3
    //   176: putfield 125	com/tencent/smtt/utils/TbsCommonConfig:mTbsLogPostUrl	Ljava/lang/String;
    //   179: aload_1
    //   180: ldc 53
    //   182: ldc 242
    //   184: invokevirtual 246	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   187: astore_3
    //   188: ldc 242
    //   190: aload_3
    //   191: invokevirtual 252	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   194: ifne +8 -> 202
    //   197: aload_0
    //   198: aload_3
    //   199: putfield 127	com/tencent/smtt/utils/TbsCommonConfig:mTipsUrl	Ljava/lang/String;
    //   202: aload_1
    //   203: ldc 41
    //   205: ldc 242
    //   207: invokevirtual 246	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   210: astore_3
    //   211: ldc 242
    //   213: aload_3
    //   214: invokevirtual 252	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   217: ifne +8 -> 225
    //   220: aload_0
    //   221: aload_3
    //   222: putfield 129	com/tencent/smtt/utils/TbsCommonConfig:mTbsCmdPostUrl	Ljava/lang/String;
    //   225: aload_1
    //   226: ldc 38
    //   228: ldc 242
    //   230: invokevirtual 246	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   233: astore_1
    //   234: ldc 242
    //   236: aload_1
    //   237: invokevirtual 252	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   240: ifne +8 -> 248
    //   243: aload_0
    //   244: aload_1
    //   245: putfield 117	com/tencent/smtt/utils/TbsCommonConfig:mPvUploadPostUrlTK	Ljava/lang/String;
    //   248: aload_2
    //   249: ifnull -217 -> 32
    //   252: aload_2
    //   253: invokevirtual 255	java/io/BufferedInputStream:close	()V
    //   256: goto -224 -> 32
    //   259: astore_1
    //   260: aload_1
    //   261: invokevirtual 257	java/io/IOException:printStackTrace	()V
    //   264: goto -232 -> 32
    //   267: astore_1
    //   268: aload_0
    //   269: monitorexit
    //   270: aload_1
    //   271: athrow
    //   272: astore_2
    //   273: new 197	java/io/StringWriter
    //   276: dup
    //   277: invokespecial 198	java/io/StringWriter:<init>	()V
    //   280: astore_3
    //   281: aload_2
    //   282: new 200	java/io/PrintWriter
    //   285: dup
    //   286: aload_3
    //   287: invokespecial 203	java/io/PrintWriter:<init>	(Ljava/io/Writer;)V
    //   290: invokevirtual 207	java/lang/Throwable:printStackTrace	(Ljava/io/PrintWriter;)V
    //   293: ldc 59
    //   295: new 174	java/lang/StringBuilder
    //   298: dup
    //   299: invokespecial 175	java/lang/StringBuilder:<init>	()V
    //   302: ldc_w 259
    //   305: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   308: aload_3
    //   309: invokevirtual 210	java/io/StringWriter:toString	()Ljava/lang/String;
    //   312: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   315: invokevirtual 190	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   318: invokestatic 193	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   321: aload_1
    //   322: ifnull -290 -> 32
    //   325: aload_1
    //   326: invokevirtual 255	java/io/BufferedInputStream:close	()V
    //   329: goto -297 -> 32
    //   332: astore_1
    //   333: aload_1
    //   334: invokevirtual 257	java/io/IOException:printStackTrace	()V
    //   337: goto -305 -> 32
    //   340: astore_1
    //   341: aconst_null
    //   342: astore_2
    //   343: aload_2
    //   344: ifnull +7 -> 351
    //   347: aload_2
    //   348: invokevirtual 255	java/io/BufferedInputStream:close	()V
    //   351: aload_1
    //   352: athrow
    //   353: astore_2
    //   354: aload_2
    //   355: invokevirtual 257	java/io/IOException:printStackTrace	()V
    //   358: goto -7 -> 351
    //   361: astore_1
    //   362: aload_1
    //   363: invokevirtual 257	java/io/IOException:printStackTrace	()V
    //   366: goto -334 -> 32
    //   369: astore_1
    //   370: goto -27 -> 343
    //   373: astore_3
    //   374: aload_1
    //   375: astore_2
    //   376: aload_3
    //   377: astore_1
    //   378: goto -35 -> 343
    //   381: astore_3
    //   382: aload_2
    //   383: astore_1
    //   384: aload_3
    //   385: astore_2
    //   386: goto -113 -> 273
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	389	0	this	TbsCommonConfig
    //   3	242	1	localObject1	Object
    //   259	2	1	localIOException1	java.io.IOException
    //   267	59	1	localObject2	Object
    //   332	2	1	localIOException2	java.io.IOException
    //   340	12	1	localObject3	Object
    //   361	2	1	localIOException3	java.io.IOException
    //   369	6	1	localObject4	Object
    //   377	7	1	localObject5	Object
    //   8	245	2	localObject6	Object
    //   272	10	2	localThrowable1	Throwable
    //   342	6	2	localObject7	Object
    //   353	2	2	localIOException4	java.io.IOException
    //   375	11	2	localObject8	Object
    //   72	237	3	localObject9	Object
    //   373	4	3	localObject10	Object
    //   381	4	3	localThrowable2	Throwable
    // Exception table:
    //   from	to	target	type
    //   252	256	259	java/io/IOException
    //   24	32	267	finally
    //   252	256	267	finally
    //   260	264	267	finally
    //   325	329	267	finally
    //   333	337	267	finally
    //   347	351	267	finally
    //   351	353	267	finally
    //   354	358	267	finally
    //   362	366	267	finally
    //   4	9	272	java/lang/Throwable
    //   13	20	272	java/lang/Throwable
    //   35	51	272	java/lang/Throwable
    //   325	329	332	java/io/IOException
    //   4	9	340	finally
    //   13	20	340	finally
    //   35	51	340	finally
    //   347	351	353	java/io/IOException
    //   24	32	361	java/io/IOException
    //   51	87	369	finally
    //   87	110	369	finally
    //   110	133	369	finally
    //   133	156	369	finally
    //   156	179	369	finally
    //   179	202	369	finally
    //   202	225	369	finally
    //   225	248	369	finally
    //   273	321	373	finally
    //   51	87	381	java/lang/Throwable
    //   87	110	381	java/lang/Throwable
    //   110	133	381	java/lang/Throwable
    //   133	156	381	java/lang/Throwable
    //   156	179	381	java/lang/Throwable
    //   179	202	381	java/lang/Throwable
    //   202	225	381	java/lang/Throwable
    //   225	248	381	java/lang/Throwable
  }
  
  public String getPvUploadPostUrl()
  {
    return this.mPvUploadPostUrl;
  }
  
  public String getPvUploadPostUrlWithToken()
  {
    return this.mPvUploadPostUrlTK;
  }
  
  public String getTbsDownloadStatPostUrl()
  {
    return this.mTbsDownloadStatPostUrl;
  }
  
  public String getTbsDownloaderPostUrl()
  {
    return this.mTbsDownloaderPostUrl;
  }
  
  public String getTbsLogPostUrl()
  {
    return this.mTbsLogPostUrl;
  }
  
  public String getTipsUrl()
  {
    return this.mTipsUrl;
  }
  
  public String getWupProxyDomain()
  {
    return this.mWupProxyDomain;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.smtt.utils.TbsCommonConfig
 * JD-Core Version:    0.7.0.1
 */