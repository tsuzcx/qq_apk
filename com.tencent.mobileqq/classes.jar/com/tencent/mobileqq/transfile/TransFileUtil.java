package com.tencent.mobileqq.transfile;

import com.tencent.qphone.base.util.QLog;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TransFileUtil
{
  public static final Pattern HTTP_HOST_REGEX = Pattern.compile("https?://[^/]*/{1}");
  public static final Pattern HTTP_URL_REGEX = Pattern.compile("https?://(\\d{1,3}\\.){3}\\d{1,3}(:\\d{1,5})?[/\\?].*");
  public static String versionCode = null;
  
  public static String buildTag(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    StringBuilder localStringBuilder = new StringBuilder("Q.richmedia.");
    localStringBuilder.append(paramString4).append(".");
    localStringBuilder.append(paramString1).append(".");
    localStringBuilder.append(paramString2).append(".");
    localStringBuilder.append(paramString3);
    return localStringBuilder.toString();
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
    //   3: getstatic 27	com/tencent/mobileqq/transfile/TransFileUtil:versionCode	Ljava/lang/String;
    //   6: ifnull +12 -> 18
    //   9: getstatic 27	com/tencent/mobileqq/transfile/TransFileUtil:versionCode	Ljava/lang/String;
    //   12: astore_0
    //   13: ldc 2
    //   15: monitorexit
    //   16: aload_0
    //   17: areturn
    //   18: ldc 131
    //   20: putstatic 27	com/tencent/mobileqq/transfile/TransFileUtil:versionCode	Ljava/lang/String;
    //   23: invokestatic 137	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   26: invokevirtual 141	com/tencent/qphone/base/util/BaseApplication:getPackageManager	()Landroid/content/pm/PackageManager;
    //   29: invokestatic 137	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   32: invokevirtual 144	com/tencent/qphone/base/util/BaseApplication:getPackageName	()Ljava/lang/String;
    //   35: iconst_0
    //   36: invokevirtual 150	android/content/pm/PackageManager:getPackageInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   39: astore_0
    //   40: new 35	java/lang/StringBuilder
    //   43: dup
    //   44: invokespecial 105	java/lang/StringBuilder:<init>	()V
    //   47: aload_0
    //   48: getfield 155	android/content/pm/PackageInfo:versionName	Ljava/lang/String;
    //   51: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: ldc 46
    //   56: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: aload_0
    //   60: getfield 157	android/content/pm/PackageInfo:versionCode	I
    //   63: invokevirtual 110	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   66: invokevirtual 50	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   69: putstatic 27	com/tencent/mobileqq/transfile/TransFileUtil:versionCode	Ljava/lang/String;
    //   72: getstatic 27	com/tencent/mobileqq/transfile/TransFileUtil:versionCode	Ljava/lang/String;
    //   75: astore_0
    //   76: goto -63 -> 13
    //   79: astore_0
    //   80: ldc 131
    //   82: putstatic 27	com/tencent/mobileqq/transfile/TransFileUtil:versionCode	Ljava/lang/String;
    //   85: aload_0
    //   86: invokevirtual 160	java/lang/Exception:printStackTrace	()V
    //   89: goto -17 -> 72
    //   92: astore_0
    //   93: ldc 2
    //   95: monitorexit
    //   96: aload_0
    //   97: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   12	64	0	localObject1	Object
    //   79	7	0	localException	java.lang.Exception
    //   92	5	0	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   23	72	79	java/lang/Exception
    //   3	13	92	finally
    //   18	23	92	finally
    //   23	72	92	finally
    //   72	76	92	finally
    //   80	89	92	finally
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
        break label145;
      }
      QLog.e(paramString1, 1, localStringBuilder.toString(), paramThrowable);
    }
    label145:
    while (!QLog.isColorLevel())
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
  
  public static void printRichMediaDebug(Object paramObject, String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("step:").append(paramString1);
    localStringBuilder.append("    \tcontent:").append(paramString2);
    QLog.d("Q.richmedia.L." + paramObject, 2, localStringBuilder.toString());
  }
  
  public static void printRichMediaError(Object paramObject, String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("step:").append(paramString1);
    localStringBuilder.append("    \tcontent:").append(paramString2);
    QLog.e("Q.richmedia.L." + paramObject, 2, localStringBuilder.toString());
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.TransFileUtil
 * JD-Core Version:    0.7.0.1
 */