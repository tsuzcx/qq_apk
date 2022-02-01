package com.tencent.mobileqq.transfile;

import bhgy;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.JpegExifReader;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Timer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.app.AppRuntime;
import mqq.manager.ServerConfigManager.ConfigType;
import mqq.manager.TicketManager;

public class RichMediaUtil
{
  public static final int DEFAULT_PROPERBALITY = 10000;
  public static final Pattern HTTP_HOST_REGEX;
  public static final Pattern HTTP_URL_REGEX;
  public static final long MAX_ACTIVE_REPORT_DURATION = 600000L;
  public static final int REPORT_RECV_TIME_THRESHHOLD = 30000;
  public static final int REPORT_SEND_TIME_THRESHHOLD = 60000;
  private static final String[] SUPPORTED_MODULE = { "T", "U", "L" };
  private static final String[] SUPPORTED_UINTYPE = { "c2c", "grp", "dis" };
  private static final String TAG = "RichMediaUtil";
  private static String[] imgAllTags;
  private static String[] imgRecvTags;
  private static String[] imgSendTags;
  private static String[] pttDownTags;
  private static Random random;
  private static HashMap<String, RichMediaUtil.ActiveRtpParam> sActiveRptMap = new HashMap();
  private static int sForceReport;
  private static boolean sIsActiveReport;
  public static String versionCode;
  
  static
  {
    HTTP_URL_REGEX = Pattern.compile("https?://(\\d{1,3}\\.){3}\\d{1,3}(:\\d{1,5})?[/\\?].*");
    HTTP_HOST_REGEX = Pattern.compile("https?://[^/]*/{1}");
    random = new Random();
    sForceReport = -1;
  }
  
  public static void activeReport(String paramString, int paramInt1, String[] paramArrayOfString, int paramInt2, long paramLong)
  {
    synchronized (sActiveRptMap)
    {
      if (sActiveRptMap.containsKey(paramString)) {
        return;
      }
      if ((paramInt2 < 2) || (random.nextInt(paramInt2) == 1) || (forceReport())) {
        synchronized (sActiveRptMap)
        {
          sIsActiveReport = true;
          if ((QLog.isColorLevel()) || (sIsActiveReport)) {
            QLog.d("RichMediaUtil", 2, "activeReport start : " + paramString);
          }
          sActiveRptMap.put(paramString, new RichMediaUtil.ActiveRtpParam(paramInt1, paramArrayOfString));
          QLog.startColorLog(paramArrayOfString);
          paramString = new RichMediaUtil.1(paramString);
          new Timer().schedule(paramString, paramLong);
          return;
        }
      }
    }
  }
  
  public static String buildTag(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    StringBuilder localStringBuilder = new StringBuilder("Q.richmedia.");
    localStringBuilder.append(paramString4).append(".");
    localStringBuilder.append(paramString1).append(".");
    localStringBuilder.append(paramString2).append(".");
    localStringBuilder.append(paramString3);
    return localStringBuilder.toString();
  }
  
  private static boolean forceReport()
  {
    if (sForceReport == -1)
    {
      String str = bhgy.a(ServerConfigManager.ConfigType.app, "active_log_upload");
      if ((str == null) || (!str.equals("1"))) {
        break label42;
      }
    }
    label42:
    for (sForceReport = 1; sForceReport == 1; sForceReport = 0) {
      return true;
    }
    return false;
  }
  
  public static String getActionDesc(int paramInt)
  {
    String str = "" + paramInt;
    switch (paramInt)
    {
    default: 
      return str;
    case 0: 
      return "dw";
    case 1: 
      return "up";
    }
    return "fw";
  }
  
  public static int getFileType(int paramInt)
  {
    switch (paramInt)
    {
    case 65537: 
    default: 
      return 65537;
    case 1: 
      return 1;
    }
    return 131075;
  }
  
  public static String getFileTypeDesc(int paramInt)
  {
    String str = "" + paramInt;
    switch (paramInt)
    {
    default: 
      return str;
    case 65537: 
      return "thu";
    case 1: 
      return "pic";
    case 65538: 
      return "emo";
    case 131075: 
      return "raw";
    case 2: 
      return "ptt";
    case 0: 
      return "fil";
    case 131078: 
      return "msg";
    case 131076: 
      return "url";
    }
    return "shortvideo";
  }
  
  public static String[] getImageRecvTags()
  {
    if (imgRecvTags != null) {
      return imgRecvTags;
    }
    ArrayList localArrayList = getImageTags("dw");
    imgRecvTags = (String[])localArrayList.toArray(new String[localArrayList.size()]);
    return imgRecvTags;
  }
  
  public static String[] getImageSendTags()
  {
    if (imgSendTags != null) {
      return imgSendTags;
    }
    ArrayList localArrayList = getImageTags("up");
    imgSendTags = (String[])localArrayList.toArray(new String[localArrayList.size()]);
    return imgSendTags;
  }
  
  private static ArrayList<String> getImageTags(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    String[] arrayOfString1 = SUPPORTED_UINTYPE;
    int k = arrayOfString1.length;
    int i = 0;
    while (i < k)
    {
      String str1 = arrayOfString1[i];
      String[] arrayOfString2 = SUPPORTED_MODULE;
      int m = arrayOfString2.length;
      int j = 0;
      while (j < m)
      {
        String str2 = arrayOfString2[j];
        localArrayList.add(buildTag(str1, "pic", paramString, str2));
        localArrayList.add(buildTag(str1, "raw", paramString, str2));
        localArrayList.add(buildTag(str1, "thu", paramString, str2));
        j += 1;
      }
      i += 1;
    }
    return localArrayList;
  }
  
  public static String[] getImageTags()
  {
    if (imgAllTags != null) {
      return imgAllTags;
    }
    ArrayList localArrayList = getImageTags("up");
    localArrayList.addAll(getImageTags("dw"));
    imgAllTags = (String[])localArrayList.toArray(new String[localArrayList.size()]);
    return imgAllTags;
  }
  
  public static ServerAddr getIpAndPortFromUrl(String paramString)
  {
    if ((HTTP_URL_REGEX == null) || (paramString == null)) {}
    while ((!HTTP_URL_REGEX.matcher(paramString).matches()) || (paramString.split("/").length < 3)) {
      return null;
    }
    ServerAddr localServerAddr = new ServerAddr();
    paramString = paramString.split("/")[2].split(":");
    localServerAddr.mIp = paramString[0];
    if (paramString.length == 2)
    {
      localServerAddr.port = Integer.valueOf(paramString[1]).intValue();
      return localServerAddr;
    }
    localServerAddr.port = 80;
    return localServerAddr;
  }
  
  public static String getIpOrDomainFromURL(String paramString)
  {
    String str = paramString;
    if (paramString != null)
    {
      Matcher localMatcher = Pattern.compile("http://([^/\\s]*)/").matcher(paramString);
      str = paramString;
      if (localMatcher.find()) {
        str = localMatcher.group(0);
      }
    }
    return str;
  }
  
  public static String[] getPttDownTags()
  {
    if (pttDownTags != null) {
      return pttDownTags;
    }
    ArrayList localArrayList = getPttTags("dw");
    pttDownTags = (String[])localArrayList.toArray(new String[localArrayList.size()]);
    return pttDownTags;
  }
  
  private static ArrayList<String> getPttTags(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    String[] arrayOfString1 = SUPPORTED_UINTYPE;
    int k = arrayOfString1.length;
    int i = 0;
    while (i < k)
    {
      String str = arrayOfString1[i];
      String[] arrayOfString2 = SUPPORTED_MODULE;
      int m = arrayOfString2.length;
      int j = 0;
      while (j < m)
      {
        localArrayList.add(buildTag(str, "ptt", paramString, arrayOfString2[j]));
        j += 1;
      }
      i += 1;
    }
    return localArrayList;
  }
  
  public static String getUinDesc(int paramInt)
  {
    String str = "" + paramInt;
    switch (paramInt)
    {
    default: 
      return str;
    case 0: 
      return "c2c";
    case 1: 
      return "grp";
    }
    return "dis";
  }
  
  public static String getUrlResoursePath(String paramString, boolean paramBoolean)
  {
    if ((getIpAndPortFromUrl(paramString) == null) && (!paramBoolean)) {}
    Matcher localMatcher;
    do
    {
      return paramString;
      localMatcher = HTTP_HOST_REGEX.matcher(paramString);
    } while (!localMatcher.find());
    return paramString.replace(localMatcher.group(), "");
  }
  
  /* Error */
  public static String getVersionCode()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 317	com/tencent/mobileqq/transfile/RichMediaUtil:versionCode	Ljava/lang/String;
    //   6: ifnull +12 -> 18
    //   9: getstatic 317	com/tencent/mobileqq/transfile/RichMediaUtil:versionCode	Ljava/lang/String;
    //   12: astore_0
    //   13: ldc 2
    //   15: monitorexit
    //   16: aload_0
    //   17: areturn
    //   18: ldc_w 319
    //   21: putstatic 317	com/tencent/mobileqq/transfile/RichMediaUtil:versionCode	Ljava/lang/String;
    //   24: invokestatic 325	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   27: invokevirtual 329	com/tencent/qphone/base/util/BaseApplication:getPackageManager	()Landroid/content/pm/PackageManager;
    //   30: invokestatic 325	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   33: invokevirtual 332	com/tencent/qphone/base/util/BaseApplication:getPackageName	()Ljava/lang/String;
    //   36: iconst_0
    //   37: invokevirtual 338	android/content/pm/PackageManager:getPackageInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   40: astore_0
    //   41: new 111	java/lang/StringBuilder
    //   44: dup
    //   45: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   48: aload_0
    //   49: getfield 343	android/content/pm/PackageInfo:versionName	Ljava/lang/String;
    //   52: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: ldc 158
    //   57: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: aload_0
    //   61: getfield 345	android/content/pm/PackageInfo:versionCode	I
    //   64: invokevirtual 184	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   67: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   70: putstatic 317	com/tencent/mobileqq/transfile/RichMediaUtil:versionCode	Ljava/lang/String;
    //   73: getstatic 317	com/tencent/mobileqq/transfile/RichMediaUtil:versionCode	Ljava/lang/String;
    //   76: astore_0
    //   77: goto -64 -> 13
    //   80: astore_0
    //   81: ldc_w 319
    //   84: putstatic 317	com/tencent/mobileqq/transfile/RichMediaUtil:versionCode	Ljava/lang/String;
    //   87: aload_0
    //   88: invokevirtual 348	java/lang/Exception:printStackTrace	()V
    //   91: goto -18 -> 73
    //   94: astore_0
    //   95: ldc 2
    //   97: monitorexit
    //   98: aload_0
    //   99: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   12	65	0	localObject1	Object
    //   80	8	0	localException	java.lang.Exception
    //   94	5	0	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   24	73	80	java/lang/Exception
    //   3	13	94	finally
    //   18	24	94	finally
    //   24	73	94	finally
    //   73	77	94	finally
    //   81	91	94	finally
  }
  
  public static final boolean isActiveReporting()
  {
    return sIsActiveReport;
  }
  
  public static boolean isPicLandscape(String paramString)
  {
    boolean bool = false;
    int j;
    if (FileUtils.fileExistsAndNotEmpty(paramString))
    {
      j = JpegExifReader.getRotationDegree(paramString);
      if (j != 90)
      {
        i = j;
        if (j != 270) {}
      }
      else
      {
        bool = true;
      }
    }
    for (int i = j;; i = 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("RichMediaUtil", 2, "isPicLandscape .result =  " + bool + ",degree = " + i + ",path = " + paramString);
      }
      return bool;
    }
  }
  
  public static void log(int paramInt1, boolean paramBoolean, int paramInt2, String paramString1, String paramString2, String paramString3)
  {
    log("T", getUinDesc(paramInt1), paramBoolean, getFileTypeDesc(paramInt2), paramString1, paramString2, paramString3, null);
  }
  
  public static void log(String paramString1, String paramString2, boolean paramBoolean, String paramString3, String paramString4, String paramString5, String paramString6, Throwable paramThrowable)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("id:");
    localStringBuilder.append(paramString4);
    if (paramBoolean)
    {
      paramString4 = "up";
      localStringBuilder.append(" \tstep:");
      localStringBuilder.append(paramString5);
      localStringBuilder.append(" \tcont:");
      localStringBuilder.append(paramString6);
      localStringBuilder.append(" \tver:");
      localStringBuilder.append(getVersionCode());
      if ("T".equals(paramString1))
      {
        localStringBuilder.append(" \ttid:");
        localStringBuilder.append(Thread.currentThread().getId());
      }
      paramString1 = buildTag(paramString2, paramString3, paramString4, paramString1);
      if (paramThrowable == null) {
        break label150;
      }
      QLog.e(paramString1, 1, localStringBuilder.toString(), paramThrowable);
    }
    label150:
    while ((!QLog.isColorLevel()) && (!sIsActiveReport))
    {
      return;
      paramString4 = "dw";
      break;
    }
    QLog.d(paramString1, 2, localStringBuilder.toString());
  }
  
  public static void log(String paramString1, boolean paramBoolean, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    log("T", paramString1, paramBoolean, paramString2, paramString3, paramString4, paramString5, null);
  }
  
  public static void logForFw(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, Throwable paramThrowable)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("id:");
    localStringBuilder.append(paramString4);
    localStringBuilder.append(" \tstep:");
    localStringBuilder.append(paramString5);
    localStringBuilder.append(" \tcont:");
    localStringBuilder.append(paramString6);
    localStringBuilder.append(" \tver:");
    localStringBuilder.append(getVersionCode());
    if ("T".equals(paramString1))
    {
      localStringBuilder.append(" \ttid:");
      localStringBuilder.append(Thread.currentThread().getId());
    }
    paramString1 = buildTag(paramString2, paramString3, "fw", paramString1);
    if (paramThrowable != null) {
      QLog.e(paramString1, 1, localStringBuilder.toString(), paramThrowable);
    }
    while ((!QLog.isColorLevel()) && (!sIsActiveReport)) {
      return;
    }
    QLog.d(paramString1, 2, localStringBuilder.toString());
  }
  
  public static void logUI(int paramInt1, boolean paramBoolean, int paramInt2, String paramString1, String paramString2, String paramString3)
  {
    log("U", getUinDesc(paramInt1), paramBoolean, getFileTypeDesc(paramInt2), paramString1, paramString2, paramString3, null);
  }
  
  public static void logUI(int paramInt1, boolean paramBoolean, int paramInt2, String paramString1, String paramString2, String paramString3, Throwable paramThrowable)
  {
    log("U", getUinDesc(paramInt1), paramBoolean, getFileTypeDesc(paramInt2), paramString1, paramString2, paramString3, paramThrowable);
  }
  
  public static void logdLogic(int paramInt1, boolean paramBoolean, int paramInt2, String paramString1, String paramString2, String paramString3)
  {
    log("L", getUinDesc(paramInt1), paramBoolean, getFileTypeDesc(paramInt2), paramString1, paramString2, paramString3, null);
  }
  
  public static void loge(String paramString1, String paramString2, boolean paramBoolean, String paramString3, String paramString4, String paramString5, String paramString6, Throwable paramThrowable)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("id:");
    localStringBuilder.append(paramString4);
    if (paramBoolean)
    {
      paramString4 = "up";
      localStringBuilder.append(" \tstep:");
      localStringBuilder.append(paramString5);
      localStringBuilder.append(" \tcont:");
      localStringBuilder.append(paramString6);
      localStringBuilder.append(" \tver:");
      localStringBuilder.append(getVersionCode());
      if ("T".equals(paramString1))
      {
        localStringBuilder.append(" \ttid:");
        localStringBuilder.append(Thread.currentThread().getId());
      }
      paramString1 = buildTag(paramString2, paramString3, paramString4, paramString1);
      if (paramThrowable == null) {
        break label150;
      }
      QLog.e(paramString1, 2, localStringBuilder.toString(), paramThrowable);
    }
    label150:
    while ((!QLog.isColorLevel()) && (!sIsActiveReport))
    {
      return;
      paramString4 = "dw";
      break;
    }
    QLog.e(paramString1, 2, localStringBuilder.toString());
  }
  
  public static void logeLogic(int paramInt1, boolean paramBoolean, int paramInt2, String paramString1, String paramString2, String paramString3, Throwable paramThrowable)
  {
    loge("L", getUinDesc(paramInt1), paramBoolean, getFileTypeDesc(paramInt2), paramString1, paramString2, paramString3, paramThrowable);
  }
  
  public static String replaceIp(String paramString1, String paramString2)
  {
    String str = paramString1;
    if (paramString1 != null)
    {
      str = paramString1;
      if (paramString2 != null)
      {
        str = paramString1;
        if (paramString2.length() > 0) {
          str = paramString1.replaceFirst("https?://[^/\\s]*/", paramString2);
        }
      }
    }
    return str;
  }
  
  public static void startImageRecvReportLog(int paramInt)
  {
    activeReport("image_receive", paramInt, getImageRecvTags(), 10000, 600000L);
  }
  
  public static void startImageSendReportLog(int paramInt)
  {
    activeReport("image_sending", paramInt, getImageSendTags(), 10000, 600000L);
  }
  
  public static void startPttRecvReportLog(int paramInt)
  {
    activeReport("ptt_recv", paramInt, getPttDownTags(), 10000, 600000L);
  }
  
  public static void stopImageRecvReport(boolean paramBoolean, String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "image_receive";
    }
    stopReport("image_receive", paramBoolean, str);
  }
  
  public static void stopImageSendReport(boolean paramBoolean, String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "image_sending";
    }
    stopReport("image_sending", paramBoolean, str);
  }
  
  public static void stopPttRecvReport(boolean paramBoolean, String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "ptt_recv";
    }
    stopReport("ptt_recv", paramBoolean, str);
  }
  
  public static void stopReport(String paramString1, boolean paramBoolean, String paramString2)
  {
    synchronized (sActiveRptMap)
    {
      if (sActiveRptMap.containsKey(paramString1))
      {
        if ((QLog.isColorLevel()) || (sIsActiveReport)) {
          QLog.d("RichMediaUtil", 2, "activeReport stop : " + paramString1 + ", " + paramBoolean);
        }
        RichMediaUtil.ActiveRtpParam localActiveRtpParam = (RichMediaUtil.ActiveRtpParam)sActiveRptMap.remove(paramString1);
        if (localActiveRtpParam != null)
        {
          paramString1 = BaseApplicationImpl.sApplication.getRuntime();
          if (paramString1 != null)
          {
            TicketManager localTicketManager = (TicketManager)paramString1.getManager(2);
            String str = paramString1.getAccount();
            paramString1 = "";
            if (localTicketManager != null) {
              paramString1 = localTicketManager.getSkey(str);
            }
            QLog.endColorLog(localActiveRtpParam.tags, localActiveRtpParam.appid, paramBoolean, paramString2, str, paramString1);
          }
        }
        if (sActiveRptMap.isEmpty()) {
          sIsActiveReport = false;
        }
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.RichMediaUtil
 * JD-Core Version:    0.7.0.1
 */