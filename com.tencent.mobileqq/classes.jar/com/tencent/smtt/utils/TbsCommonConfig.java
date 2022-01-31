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
    //   5: invokespecial 216	com/tencent/smtt/utils/TbsCommonConfig:getConfigFile	()Ljava/io/File;
    //   8: astore_2
    //   9: aload_2
    //   10: ifnonnull +38 -> 48
    //   13: ldc 59
    //   15: ldc 218
    //   17: invokestatic 190	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   20: iconst_0
    //   21: ifeq +11 -> 32
    //   24: new 220	java/lang/NullPointerException
    //   27: dup
    //   28: invokespecial 221	java/lang/NullPointerException:<init>	()V
    //   31: athrow
    //   32: aload_0
    //   33: monitorexit
    //   34: return
    //   35: astore_1
    //   36: aload_1
    //   37: invokevirtual 223	java/io/IOException:printStackTrace	()V
    //   40: goto -8 -> 32
    //   43: astore_1
    //   44: aload_0
    //   45: monitorexit
    //   46: aload_1
    //   47: athrow
    //   48: new 225	java/io/BufferedInputStream
    //   51: dup
    //   52: new 227	java/io/FileInputStream
    //   55: dup
    //   56: aload_2
    //   57: invokespecial 230	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   60: invokespecial 233	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   63: astore_2
    //   64: new 235	java/util/Properties
    //   67: dup
    //   68: invokespecial 236	java/util/Properties:<init>	()V
    //   71: astore_1
    //   72: aload_1
    //   73: aload_2
    //   74: invokevirtual 239	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   77: aload_1
    //   78: ldc 35
    //   80: ldc 241
    //   82: invokevirtual 245	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   85: astore_3
    //   86: ldc 241
    //   88: aload_3
    //   89: invokevirtual 251	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   92: ifne +8 -> 100
    //   95: aload_0
    //   96: aload_3
    //   97: putfield 112	com/tencent/smtt/utils/TbsCommonConfig:mPvUploadPostUrl	Ljava/lang/String;
    //   100: aload_1
    //   101: ldc 56
    //   103: ldc 241
    //   105: invokevirtual 245	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   108: astore_3
    //   109: ldc 241
    //   111: aload_3
    //   112: invokevirtual 251	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   115: ifne +8 -> 123
    //   118: aload_0
    //   119: aload_3
    //   120: putfield 116	com/tencent/smtt/utils/TbsCommonConfig:mWupProxyDomain	Ljava/lang/String;
    //   123: aload_1
    //   124: ldc 47
    //   126: ldc 241
    //   128: invokevirtual 245	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   131: astore_3
    //   132: ldc 241
    //   134: aload_3
    //   135: invokevirtual 251	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   138: ifne +8 -> 146
    //   141: aload_0
    //   142: aload_3
    //   143: putfield 118	com/tencent/smtt/utils/TbsCommonConfig:mTbsDownloadStatPostUrl	Ljava/lang/String;
    //   146: aload_1
    //   147: ldc 44
    //   149: ldc 241
    //   151: invokevirtual 245	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   154: astore_3
    //   155: ldc 241
    //   157: aload_3
    //   158: invokevirtual 251	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   161: ifne +8 -> 169
    //   164: aload_0
    //   165: aload_3
    //   166: putfield 120	com/tencent/smtt/utils/TbsCommonConfig:mTbsDownloaderPostUrl	Ljava/lang/String;
    //   169: aload_1
    //   170: ldc 50
    //   172: ldc 241
    //   174: invokevirtual 245	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   177: astore_3
    //   178: ldc 241
    //   180: aload_3
    //   181: invokevirtual 251	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   184: ifne +8 -> 192
    //   187: aload_0
    //   188: aload_3
    //   189: putfield 122	com/tencent/smtt/utils/TbsCommonConfig:mTbsLogPostUrl	Ljava/lang/String;
    //   192: aload_1
    //   193: ldc 53
    //   195: ldc 241
    //   197: invokevirtual 245	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   200: astore_3
    //   201: ldc 241
    //   203: aload_3
    //   204: invokevirtual 251	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   207: ifne +8 -> 215
    //   210: aload_0
    //   211: aload_3
    //   212: putfield 124	com/tencent/smtt/utils/TbsCommonConfig:mTipsUrl	Ljava/lang/String;
    //   215: aload_1
    //   216: ldc 41
    //   218: ldc 241
    //   220: invokevirtual 245	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   223: astore_3
    //   224: ldc 241
    //   226: aload_3
    //   227: invokevirtual 251	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   230: ifne +8 -> 238
    //   233: aload_0
    //   234: aload_3
    //   235: putfield 126	com/tencent/smtt/utils/TbsCommonConfig:mTbsCmdPostUrl	Ljava/lang/String;
    //   238: aload_1
    //   239: ldc 38
    //   241: ldc 241
    //   243: invokevirtual 245	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   246: astore_1
    //   247: ldc 241
    //   249: aload_1
    //   250: invokevirtual 251	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   253: ifne +8 -> 261
    //   256: aload_0
    //   257: aload_1
    //   258: putfield 114	com/tencent/smtt/utils/TbsCommonConfig:mPvUploadPostUrlTK	Ljava/lang/String;
    //   261: aload_2
    //   262: ifnull -230 -> 32
    //   265: aload_2
    //   266: invokevirtual 254	java/io/BufferedInputStream:close	()V
    //   269: goto -237 -> 32
    //   272: astore_1
    //   273: aload_1
    //   274: invokevirtual 223	java/io/IOException:printStackTrace	()V
    //   277: goto -245 -> 32
    //   280: astore_2
    //   281: new 194	java/io/StringWriter
    //   284: dup
    //   285: invokespecial 195	java/io/StringWriter:<init>	()V
    //   288: astore_3
    //   289: aload_2
    //   290: new 197	java/io/PrintWriter
    //   293: dup
    //   294: aload_3
    //   295: invokespecial 200	java/io/PrintWriter:<init>	(Ljava/io/Writer;)V
    //   298: invokevirtual 204	java/lang/Throwable:printStackTrace	(Ljava/io/PrintWriter;)V
    //   301: ldc 59
    //   303: new 171	java/lang/StringBuilder
    //   306: dup
    //   307: invokespecial 172	java/lang/StringBuilder:<init>	()V
    //   310: ldc_w 256
    //   313: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   316: aload_3
    //   317: invokevirtual 207	java/io/StringWriter:toString	()Ljava/lang/String;
    //   320: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   323: invokevirtual 187	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   326: invokestatic 190	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   329: aload_1
    //   330: ifnull -298 -> 32
    //   333: aload_1
    //   334: invokevirtual 254	java/io/BufferedInputStream:close	()V
    //   337: goto -305 -> 32
    //   340: astore_1
    //   341: aload_1
    //   342: invokevirtual 223	java/io/IOException:printStackTrace	()V
    //   345: goto -313 -> 32
    //   348: astore_1
    //   349: aconst_null
    //   350: astore_2
    //   351: aload_2
    //   352: ifnull +7 -> 359
    //   355: aload_2
    //   356: invokevirtual 254	java/io/BufferedInputStream:close	()V
    //   359: aload_1
    //   360: athrow
    //   361: astore_2
    //   362: aload_2
    //   363: invokevirtual 223	java/io/IOException:printStackTrace	()V
    //   366: goto -7 -> 359
    //   369: astore_1
    //   370: goto -19 -> 351
    //   373: astore_3
    //   374: aload_1
    //   375: astore_2
    //   376: aload_3
    //   377: astore_1
    //   378: goto -27 -> 351
    //   381: astore_3
    //   382: aload_2
    //   383: astore_1
    //   384: aload_3
    //   385: astore_2
    //   386: goto -105 -> 281
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	389	0	this	TbsCommonConfig
    //   3	1	1	localObject1	Object
    //   35	2	1	localIOException1	java.io.IOException
    //   43	4	1	localObject2	Object
    //   71	187	1	localObject3	Object
    //   272	62	1	localIOException2	java.io.IOException
    //   340	2	1	localIOException3	java.io.IOException
    //   348	12	1	localObject4	Object
    //   369	6	1	localObject5	Object
    //   377	7	1	localObject6	Object
    //   8	258	2	localObject7	Object
    //   280	10	2	localThrowable1	Throwable
    //   350	6	2	localObject8	Object
    //   361	2	2	localIOException4	java.io.IOException
    //   375	11	2	localObject9	Object
    //   85	232	3	localObject10	Object
    //   373	4	3	localObject11	Object
    //   381	4	3	localThrowable2	Throwable
    // Exception table:
    //   from	to	target	type
    //   24	32	35	java/io/IOException
    //   24	32	43	finally
    //   36	40	43	finally
    //   265	269	43	finally
    //   273	277	43	finally
    //   333	337	43	finally
    //   341	345	43	finally
    //   355	359	43	finally
    //   359	361	43	finally
    //   362	366	43	finally
    //   265	269	272	java/io/IOException
    //   4	9	280	java/lang/Throwable
    //   13	20	280	java/lang/Throwable
    //   48	64	280	java/lang/Throwable
    //   333	337	340	java/io/IOException
    //   4	9	348	finally
    //   13	20	348	finally
    //   48	64	348	finally
    //   355	359	361	java/io/IOException
    //   64	100	369	finally
    //   100	123	369	finally
    //   123	146	369	finally
    //   146	169	369	finally
    //   169	192	369	finally
    //   192	215	369	finally
    //   215	238	369	finally
    //   238	261	369	finally
    //   281	329	373	finally
    //   64	100	381	java/lang/Throwable
    //   100	123	381	java/lang/Throwable
    //   123	146	381	java/lang/Throwable
    //   146	169	381	java/lang/Throwable
    //   169	192	381	java/lang/Throwable
    //   192	215	381	java/lang/Throwable
    //   215	238	381	java/lang/Throwable
    //   238	261	381	java/lang/Throwable
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