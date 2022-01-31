package com.tencent.smtt.utils;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
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
    int j = 1;
    label67:
    label326:
    for (;;)
    {
      Object localObject;
      int i;
      try
      {
        if (this.mTbsConfigDir != null) {
          break label216;
        }
        localObject = this.mContext.getApplicationContext().getApplicationInfo().packageName;
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          break label193;
        }
        if (this.mContext.getPackageManager().checkPermission("android.permission.READ_EXTERNAL_STORAGE", (String)localObject) != 0) {
          break label318;
        }
        i = 1;
        if (this.mContext.getPackageManager().checkPermission("android.permission.WRITE_EXTERNAL_STORAGE", (String)localObject) != 0) {
          break label323;
        }
      }
      catch (Throwable localThrowable1)
      {
        localObject = null;
      }
      TbsLog.i("TbsCommonConfig", "no permission,use sdcard default folder");
      this.mTbsConfigDir = new File(FileUtil.getTBSSdcardFilePath(this.mContext, 5));
      if (this.mTbsConfigDir != null) {
        if (!this.mTbsConfigDir.isDirectory())
        {
          break label316;
          label113:
          this.mTbsConfigDir = new File(FileUtil.getTBSSdcardFilePath(this.mContext, 8));
        }
        else
        {
          for (;;)
          {
            StringWriter localStringWriter = new StringWriter();
            localThrowable1.printStackTrace(new PrintWriter(localStringWriter));
            TbsLog.e("TbsCommonConfig", "exceptions occurred2:" + localStringWriter.toString());
            return localObject;
            this.mTbsConfigDir = new File(FileUtil.getTBSSdcardFilePath(this.mContext, 8));
            break;
            label216:
            localObject = new File(this.mTbsConfigDir, "tbsnet.conf");
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
        if (i != 0) {
          break label326;
        }
        if (j == 0) {
          break label113;
        }
        break label67;
        return null;
        i = 0;
        break;
        j = 0;
      }
    }
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
    //   5: invokespecial 250	com/tencent/smtt/utils/TbsCommonConfig:getConfigFile	()Ljava/io/File;
    //   8: astore_2
    //   9: aload_2
    //   10: ifnonnull +38 -> 48
    //   13: ldc 59
    //   15: ldc 252
    //   17: invokestatic 226	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   20: iconst_0
    //   21: ifeq +11 -> 32
    //   24: new 254	java/lang/NullPointerException
    //   27: dup
    //   28: invokespecial 255	java/lang/NullPointerException:<init>	()V
    //   31: athrow
    //   32: aload_0
    //   33: monitorexit
    //   34: return
    //   35: astore_1
    //   36: aload_1
    //   37: invokevirtual 257	java/io/IOException:printStackTrace	()V
    //   40: goto -8 -> 32
    //   43: astore_1
    //   44: aload_0
    //   45: monitorexit
    //   46: aload_1
    //   47: athrow
    //   48: new 259	java/io/BufferedInputStream
    //   51: dup
    //   52: new 261	java/io/FileInputStream
    //   55: dup
    //   56: aload_2
    //   57: invokespecial 264	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   60: invokespecial 267	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   63: astore_2
    //   64: new 269	java/util/Properties
    //   67: dup
    //   68: invokespecial 270	java/util/Properties:<init>	()V
    //   71: astore_1
    //   72: aload_1
    //   73: aload_2
    //   74: invokevirtual 273	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   77: aload_1
    //   78: ldc 35
    //   80: ldc_w 275
    //   83: invokevirtual 279	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   86: astore_3
    //   87: ldc_w 275
    //   90: aload_3
    //   91: invokevirtual 285	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   94: ifne +8 -> 102
    //   97: aload_0
    //   98: aload_3
    //   99: putfield 112	com/tencent/smtt/utils/TbsCommonConfig:mPvUploadPostUrl	Ljava/lang/String;
    //   102: aload_1
    //   103: ldc 56
    //   105: ldc_w 275
    //   108: invokevirtual 279	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   111: astore_3
    //   112: ldc_w 275
    //   115: aload_3
    //   116: invokevirtual 285	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   119: ifne +8 -> 127
    //   122: aload_0
    //   123: aload_3
    //   124: putfield 116	com/tencent/smtt/utils/TbsCommonConfig:mWupProxyDomain	Ljava/lang/String;
    //   127: aload_1
    //   128: ldc 47
    //   130: ldc_w 275
    //   133: invokevirtual 279	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   136: astore_3
    //   137: ldc_w 275
    //   140: aload_3
    //   141: invokevirtual 285	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   144: ifne +8 -> 152
    //   147: aload_0
    //   148: aload_3
    //   149: putfield 118	com/tencent/smtt/utils/TbsCommonConfig:mTbsDownloadStatPostUrl	Ljava/lang/String;
    //   152: aload_1
    //   153: ldc 44
    //   155: ldc_w 275
    //   158: invokevirtual 279	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   161: astore_3
    //   162: ldc_w 275
    //   165: aload_3
    //   166: invokevirtual 285	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   169: ifne +8 -> 177
    //   172: aload_0
    //   173: aload_3
    //   174: putfield 120	com/tencent/smtt/utils/TbsCommonConfig:mTbsDownloaderPostUrl	Ljava/lang/String;
    //   177: aload_1
    //   178: ldc 50
    //   180: ldc_w 275
    //   183: invokevirtual 279	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   186: astore_3
    //   187: ldc_w 275
    //   190: aload_3
    //   191: invokevirtual 285	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   194: ifne +8 -> 202
    //   197: aload_0
    //   198: aload_3
    //   199: putfield 122	com/tencent/smtt/utils/TbsCommonConfig:mTbsLogPostUrl	Ljava/lang/String;
    //   202: aload_1
    //   203: ldc 53
    //   205: ldc_w 275
    //   208: invokevirtual 279	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   211: astore_3
    //   212: ldc_w 275
    //   215: aload_3
    //   216: invokevirtual 285	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   219: ifne +8 -> 227
    //   222: aload_0
    //   223: aload_3
    //   224: putfield 124	com/tencent/smtt/utils/TbsCommonConfig:mTipsUrl	Ljava/lang/String;
    //   227: aload_1
    //   228: ldc 41
    //   230: ldc_w 275
    //   233: invokevirtual 279	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   236: astore_3
    //   237: ldc_w 275
    //   240: aload_3
    //   241: invokevirtual 285	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   244: ifne +8 -> 252
    //   247: aload_0
    //   248: aload_3
    //   249: putfield 126	com/tencent/smtt/utils/TbsCommonConfig:mTbsCmdPostUrl	Ljava/lang/String;
    //   252: aload_1
    //   253: ldc 38
    //   255: ldc_w 275
    //   258: invokevirtual 279	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   261: astore_1
    //   262: ldc_w 275
    //   265: aload_1
    //   266: invokevirtual 285	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   269: ifne +8 -> 277
    //   272: aload_0
    //   273: aload_1
    //   274: putfield 114	com/tencent/smtt/utils/TbsCommonConfig:mPvUploadPostUrlTK	Ljava/lang/String;
    //   277: aload_2
    //   278: ifnull -246 -> 32
    //   281: aload_2
    //   282: invokevirtual 288	java/io/BufferedInputStream:close	()V
    //   285: goto -253 -> 32
    //   288: astore_1
    //   289: aload_1
    //   290: invokevirtual 257	java/io/IOException:printStackTrace	()V
    //   293: goto -261 -> 32
    //   296: astore_2
    //   297: new 199	java/io/StringWriter
    //   300: dup
    //   301: invokespecial 200	java/io/StringWriter:<init>	()V
    //   304: astore_3
    //   305: aload_2
    //   306: new 202	java/io/PrintWriter
    //   309: dup
    //   310: aload_3
    //   311: invokespecial 205	java/io/PrintWriter:<init>	(Ljava/io/Writer;)V
    //   314: invokevirtual 209	java/lang/Throwable:printStackTrace	(Ljava/io/PrintWriter;)V
    //   317: ldc 59
    //   319: new 211	java/lang/StringBuilder
    //   322: dup
    //   323: invokespecial 212	java/lang/StringBuilder:<init>	()V
    //   326: ldc_w 290
    //   329: invokevirtual 218	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   332: aload_3
    //   333: invokevirtual 222	java/io/StringWriter:toString	()Ljava/lang/String;
    //   336: invokevirtual 218	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   339: invokevirtual 223	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   342: invokestatic 226	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   345: aload_1
    //   346: ifnull -314 -> 32
    //   349: aload_1
    //   350: invokevirtual 288	java/io/BufferedInputStream:close	()V
    //   353: goto -321 -> 32
    //   356: astore_1
    //   357: aload_1
    //   358: invokevirtual 257	java/io/IOException:printStackTrace	()V
    //   361: goto -329 -> 32
    //   364: astore_1
    //   365: aconst_null
    //   366: astore_2
    //   367: aload_2
    //   368: ifnull +7 -> 375
    //   371: aload_2
    //   372: invokevirtual 288	java/io/BufferedInputStream:close	()V
    //   375: aload_1
    //   376: athrow
    //   377: astore_2
    //   378: aload_2
    //   379: invokevirtual 257	java/io/IOException:printStackTrace	()V
    //   382: goto -7 -> 375
    //   385: astore_1
    //   386: goto -19 -> 367
    //   389: astore_3
    //   390: aload_1
    //   391: astore_2
    //   392: aload_3
    //   393: astore_1
    //   394: goto -27 -> 367
    //   397: astore_3
    //   398: aload_2
    //   399: astore_1
    //   400: aload_3
    //   401: astore_2
    //   402: goto -105 -> 297
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	405	0	this	TbsCommonConfig
    //   3	1	1	localObject1	Object
    //   35	2	1	localIOException1	java.io.IOException
    //   43	4	1	localObject2	Object
    //   71	203	1	localObject3	Object
    //   288	62	1	localIOException2	java.io.IOException
    //   356	2	1	localIOException3	java.io.IOException
    //   364	12	1	localObject4	Object
    //   385	6	1	localObject5	Object
    //   393	7	1	localObject6	Object
    //   8	274	2	localObject7	Object
    //   296	10	2	localThrowable1	Throwable
    //   366	6	2	localObject8	Object
    //   377	2	2	localIOException4	java.io.IOException
    //   391	11	2	localObject9	Object
    //   86	247	3	localObject10	Object
    //   389	4	3	localObject11	Object
    //   397	4	3	localThrowable2	Throwable
    // Exception table:
    //   from	to	target	type
    //   24	32	35	java/io/IOException
    //   24	32	43	finally
    //   36	40	43	finally
    //   281	285	43	finally
    //   289	293	43	finally
    //   349	353	43	finally
    //   357	361	43	finally
    //   371	375	43	finally
    //   375	377	43	finally
    //   378	382	43	finally
    //   281	285	288	java/io/IOException
    //   4	9	296	java/lang/Throwable
    //   13	20	296	java/lang/Throwable
    //   48	64	296	java/lang/Throwable
    //   349	353	356	java/io/IOException
    //   4	9	364	finally
    //   13	20	364	finally
    //   48	64	364	finally
    //   371	375	377	java/io/IOException
    //   64	102	385	finally
    //   102	127	385	finally
    //   127	152	385	finally
    //   152	177	385	finally
    //   177	202	385	finally
    //   202	227	385	finally
    //   227	252	385	finally
    //   252	277	385	finally
    //   297	345	389	finally
    //   64	102	397	java/lang/Throwable
    //   102	127	397	java/lang/Throwable
    //   127	152	397	java/lang/Throwable
    //   152	177	397	java/lang/Throwable
    //   177	202	397	java/lang/Throwable
    //   202	227	397	java/lang/Throwable
    //   227	252	397	java/lang/Throwable
    //   252	277	397	java/lang/Throwable
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.smtt.utils.TbsCommonConfig
 * JD-Core Version:    0.7.0.1
 */