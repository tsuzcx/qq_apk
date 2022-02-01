package com.tencent.mobileqq.transfile;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.format.Time;
import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.transfile.richmediavfs.RmVFSUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.jetbrains.annotations.NotNull;

public class TransFileUtil
{
  public static final String FILE_PHOTO_DIR = "photo/";
  public static final Pattern HTTP_HOST_REGEX = Pattern.compile("https?://[^/]*/{1}");
  public static final Pattern HTTP_URL_REGEX = Pattern.compile("https?://(\\d{1,3}\\.){3}\\d{1,3}(:\\d{1,5})?[/\\?].*");
  static final String TAG = "TransFileUtil";
  public static String versionCode = null;
  
  public static void addDomainToList(ArrayList<ServerAddr> paramArrayList, String paramString)
  {
    if ((paramArrayList != null) && (paramString != null))
    {
      ServerAddr localServerAddr = new ServerAddr();
      localServerAddr.mIp = paramString;
      localServerAddr.isDomain = true;
      paramArrayList.add(localServerAddr);
    }
  }
  
  private static void buildAssistantFileInfo(String paramString, TransFileUtil.FileInfo paramFileInfo)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramFileInfo.fileDir);
    localStringBuilder.append("ast/");
    localStringBuilder.append(getPttTimeDir());
    localStringBuilder.append("/");
    paramFileInfo.fileDir = localStringBuilder.toString();
    paramFileInfo.fileDir = RmVFSUtils.getVFSPath(paramFileInfo.fileDir, true);
    paramFileInfo.suffix = ".ast";
    if (paramString == null) {
      paramFileInfo.name = getTransFileDateTime();
    }
  }
  
  private static void buildFileFileInfo(String paramString, byte[] paramArrayOfByte, TransFileUtil.FileInfo paramFileInfo)
  {
    paramFileInfo.fileDir = AppConstants.SDCARD_FILE_SAVE_PATH;
    if (paramString == null)
    {
      paramFileInfo.name = getTransFileDateTime();
      if (paramArrayOfByte != null)
      {
        paramString = new StringBuilder();
        paramString.append(paramFileInfo.name);
        paramString.append(HexUtil.bytes2HexStr(paramArrayOfByte).substring(0, 5));
        paramFileInfo.name = paramString.toString();
      }
    }
    else
    {
      paramFileInfo.name = paramString;
    }
    paramFileInfo.suffix = "";
  }
  
  @NotNull
  protected static TransFileUtil.FileInfo buildFileInfo(String paramString1, String paramString2, int paramInt, byte[] paramArrayOfByte)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AppConstants.SDCARD_PATH);
    localStringBuilder.append(paramString1);
    localStringBuilder.append("/");
    paramString1 = new TransFileUtil.FileInfo(localStringBuilder.toString(), null, "");
    if (paramInt != 0)
    {
      if (paramInt != 1) {
        if (paramInt != 2)
        {
          if (paramInt != 23)
          {
            if (paramInt != 25)
            {
              if (paramInt != 53)
              {
                if (paramInt != 65)
                {
                  if (paramInt != 65537)
                  {
                    if (paramInt != 327697) {
                      return paramString1;
                    }
                    buildAssistantFileInfo(paramString2, paramString1);
                    return paramString1;
                  }
                }
                else
                {
                  paramArrayOfByte = new StringBuilder();
                  paramArrayOfByte.append(paramString1.fileDir);
                  paramArrayOfByte.append("ptt/");
                  paramString1.fileDir = paramArrayOfByte.toString();
                  paramString1.suffix = ".slk";
                  if (paramString2 != null) {
                    return paramString1;
                  }
                  paramString2 = new StringBuilder();
                  paramString2.append("homework_");
                  paramString2.append(getTransFileDateTime());
                  paramString1.name = paramString2.toString();
                  return paramString1;
                }
              }
              else
              {
                paramArrayOfByte = new StringBuilder();
                paramArrayOfByte.append(paramString1.fileDir);
                paramArrayOfByte.append("ptt/");
                paramString1.fileDir = paramArrayOfByte.toString();
                paramString1.suffix = ".slk";
                if (paramString2 != null) {
                  return paramString1;
                }
                paramString2 = new StringBuilder();
                paramString2.append("vs_");
                paramString2.append(getTransFileDateTime());
                paramString1.name = paramString2.toString();
                return paramString1;
              }
            }
            else
            {
              paramArrayOfByte = new StringBuilder();
              paramArrayOfByte.append(paramString1.fileDir);
              paramArrayOfByte.append("ptt/");
              paramString1.fileDir = paramArrayOfByte.toString();
              paramString1.suffix = ".slk";
              if (paramString2 != null) {
                return paramString1;
              }
              paramString2 = new StringBuilder();
              paramString2.append("buluo_");
              paramString2.append(getTransFileDateTime());
              paramString1.name = paramString2.toString();
              return paramString1;
            }
          }
          else
          {
            paramArrayOfByte = new StringBuilder();
            paramArrayOfByte.append(paramString1.fileDir);
            paramArrayOfByte.append("ptt/");
            paramString1.fileDir = paramArrayOfByte.toString();
            paramString1.suffix = ".slk";
            if (paramString2 == null)
            {
              paramString2 = new StringBuilder();
              paramString2.append("ef_");
              paramString2.append(getTransFileDateTime());
              paramString1.name = paramString2.toString();
              return paramString1;
            }
            paramArrayOfByte = new StringBuilder();
            paramArrayOfByte.append("ef_");
            paramArrayOfByte.append(paramString2);
            paramString1.name = paramArrayOfByte.toString();
            return paramString1;
          }
        }
        else
        {
          buildPttFileInfo(paramString2, paramString1);
          return paramString1;
        }
      }
      buildPicFileInfo(paramString2, paramArrayOfByte, paramString1);
      return paramString1;
    }
    else
    {
      buildFileFileInfo(paramString2, paramArrayOfByte, paramString1);
    }
    return paramString1;
  }
  
  private static void buildPicFileInfo(String paramString, byte[] paramArrayOfByte, TransFileUtil.FileInfo paramFileInfo)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramFileInfo.fileDir);
    localStringBuilder.append("photo/");
    paramFileInfo.fileDir = localStringBuilder.toString();
    paramFileInfo.suffix = ".jpg";
    if (paramString == null)
    {
      paramFileInfo.name = getTransFileDateTime();
      if (paramArrayOfByte != null)
      {
        paramString = new StringBuilder();
        paramString.append(paramFileInfo.name);
        paramString.append(HexUtil.bytes2HexStr(paramArrayOfByte).substring(0, 5));
        paramFileInfo.name = paramString.toString();
      }
    }
  }
  
  private static void buildPttFileInfo(String paramString, TransFileUtil.FileInfo paramFileInfo)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramFileInfo.fileDir);
    localStringBuilder.append("ptt/");
    localStringBuilder.append(getPttTimeDir());
    localStringBuilder.append("/");
    paramFileInfo.fileDir = localStringBuilder.toString();
    paramFileInfo.fileDir = RmVFSUtils.getVFSPath(paramFileInfo.fileDir, true);
    paramFileInfo.suffix = ".amr";
    if (paramString == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("TransFileUtil", 2, "pttdown,33333");
      }
      paramString = new StringBuilder();
      paramString.append("stream_");
      paramString.append(getTransFileDateTime());
      paramFileInfo.name = paramString.toString();
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("pttdown,name = ");
        paramString.append(paramFileInfo.name);
        QLog.i("TransFileUtil", 2, paramString.toString());
      }
    }
  }
  
  public static String buildTag(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    StringBuilder localStringBuilder = new StringBuilder("Q.richmedia.");
    localStringBuilder.append(paramString4);
    localStringBuilder.append(".");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(".");
    localStringBuilder.append(paramString2);
    localStringBuilder.append(".");
    localStringBuilder.append(paramString3);
    return localStringBuilder.toString();
  }
  
  public static ServerAddr getIpAndPortFromUrl(String paramString)
  {
    Pattern localPattern = HTTP_URL_REGEX;
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (localPattern != null)
    {
      if (paramString == null) {
        return null;
      }
      localObject1 = localObject2;
      if (localPattern.matcher(paramString).matches())
      {
        if (paramString.split("/").length < 3) {
          return null;
        }
        localObject1 = new ServerAddr();
        paramString = paramString.split("/")[2].split(":");
        ((ServerAddr)localObject1).mIp = paramString[0];
        if (paramString.length == 2)
        {
          ((ServerAddr)localObject1).port = Integer.valueOf(paramString[1]).intValue();
          return localObject1;
        }
        ((ServerAddr)localObject1).port = 80;
      }
    }
    return localObject1;
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
  
  public static String getPttTimeDir()
  {
    Time localTime = new Time();
    localTime.setToNow();
    return getPttTimeDirByTime(localTime);
  }
  
  @NotNull
  protected static String getPttTimeDirByTime(Time paramTime)
  {
    if (paramTime.month + 1 > 9)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("");
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("0");
    }
    ((StringBuilder)localObject).append(paramTime.month + 1);
    Object localObject = ((StringBuilder)localObject).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(paramTime.year);
    localStringBuilder.append((String)localObject);
    localStringBuilder.append("/");
    localStringBuilder.append(paramTime.monthDay);
    return localStringBuilder.toString();
  }
  
  /* Error */
  private static String getTransFileDateTime()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: lconst_1
    //   4: invokestatic 257	java/lang/Thread:sleep	(J)V
    //   7: goto +12 -> 19
    //   10: astore_2
    //   11: goto +39 -> 50
    //   14: astore_2
    //   15: aload_2
    //   16: invokevirtual 260	java/lang/InterruptedException:printStackTrace	()V
    //   19: invokestatic 266	java/lang/System:currentTimeMillis	()J
    //   22: lstore_0
    //   23: new 268	java/text/SimpleDateFormat
    //   26: dup
    //   27: ldc_w 270
    //   30: invokespecial 271	java/text/SimpleDateFormat:<init>	(Ljava/lang/String;)V
    //   33: new 273	java/util/Date
    //   36: dup
    //   37: lload_0
    //   38: invokespecial 275	java/util/Date:<init>	(J)V
    //   41: invokevirtual 279	java/text/SimpleDateFormat:format	(Ljava/util/Date;)Ljava/lang/String;
    //   44: astore_2
    //   45: ldc 2
    //   47: monitorexit
    //   48: aload_2
    //   49: areturn
    //   50: ldc 2
    //   52: monitorexit
    //   53: aload_2
    //   54: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   22	16	0	l	long
    //   10	1	2	localObject	Object
    //   14	2	2	localInterruptedException	java.lang.InterruptedException
    //   44	10	2	str	String
    // Exception table:
    //   from	to	target	type
    //   3	7	10	finally
    //   15	19	10	finally
    //   19	45	10	finally
    //   3	7	14	java/lang/InterruptedException
  }
  
  public static String getTransferFilePath(String paramString1, String paramString2, int paramInt, byte[] paramArrayOfByte)
  {
    return getTransferFilePath(paramString1, paramString2, paramInt, paramArrayOfByte, true);
  }
  
  public static String getTransferFilePath(String paramString1, String paramString2, int paramInt, byte[] paramArrayOfByte, boolean paramBoolean)
  {
    paramString1 = buildFileInfo(paramString1, paramString2, paramInt, paramArrayOfByte);
    if (QLog.isColorLevel())
    {
      paramString2 = new StringBuilder();
      paramString2.append("getTransferFilePath dir: ");
      paramString2.append(paramString1.fileDir);
      QLog.d("TransFileUtil", 2, paramString2.toString());
    }
    paramString2 = new File(paramString1.fileDir);
    if (!paramString2.exists()) {
      paramString2.mkdirs();
    }
    paramString2 = new StringBuilder();
    paramString2.append(paramString1.fileDir);
    paramString2.append(paramString1.name);
    paramString2.append(paramString1.suffix);
    paramString1 = new File(paramString2.toString());
    if ((paramInt != 0) && (paramBoolean) && (!paramString1.exists())) {}
    try
    {
      paramString1.createNewFile();
    }
    catch (IOException paramString2)
    {
      label144:
      break label144;
    }
    if (QLog.isColorLevel())
    {
      paramString2 = new StringBuilder();
      paramString2.append("getTransferFilePath : ");
      paramString2.append(paramString1.getAbsoluteFile().toString());
      QLog.d("TransFileUtil", 2, paramString2.toString());
    }
    return paramString1.getAbsoluteFile().toString();
  }
  
  public static String getUinDesc(int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("");
    ((StringBuilder)localObject).append(paramInt);
    localObject = ((StringBuilder)localObject).toString();
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 3000)
        {
          if (paramInt != 10014) {
            return localObject;
          }
          return "<gld>";
        }
        return "dis";
      }
      return "grp";
    }
    return "c2c";
  }
  
  public static String getUrlResoursePath(String paramString, boolean paramBoolean)
  {
    if ((getIpAndPortFromUrl(paramString) == null) && (!paramBoolean)) {
      return paramString;
    }
    Matcher localMatcher = HTTP_HOST_REGEX.matcher(paramString);
    String str = paramString;
    if (localMatcher.find()) {
      str = paramString.replace(localMatcher.group(), "");
    }
    return str;
  }
  
  public static String getVersionCode()
  {
    try
    {
      Object localObject1;
      if (versionCode != null)
      {
        localObject1 = versionCode;
        return localObject1;
      }
      versionCode = "unkownVersion";
      try
      {
        localObject1 = BaseApplication.getContext().getPackageManager().getPackageInfo(BaseApplication.getContext().getPackageName(), 0);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(((PackageInfo)localObject1).versionName);
        localStringBuilder.append(".");
        localStringBuilder.append(((PackageInfo)localObject1).versionCode);
        versionCode = localStringBuilder.toString();
      }
      catch (Exception localException)
      {
        versionCode = "unkownVersion";
        localException.printStackTrace();
      }
      String str = versionCode;
      return str;
    }
    finally {}
  }
  
  public static void log(String paramString1, String paramString2, boolean paramBoolean, String paramString3, String paramString4, String paramString5, String paramString6, Throwable paramThrowable)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("id:");
    localStringBuilder.append(paramString4);
    if (paramBoolean) {
      paramString4 = "up";
    } else {
      paramString4 = "dw";
    }
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
    if (paramThrowable != null)
    {
      QLog.e(paramString1, 1, localStringBuilder.toString(), paramThrowable);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(paramString1, 2, localStringBuilder.toString());
    }
  }
  
  public static void log(String paramString1, boolean paramBoolean, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    log("T", paramString1, paramBoolean, paramString2, paramString3, paramString4, paramString5, null);
  }
  
  public static void printRichMediaDebug(Object paramObject, String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("step:");
    localStringBuilder.append(paramString1);
    localStringBuilder.append("    \tcontent:");
    localStringBuilder.append(paramString2);
    paramString1 = new StringBuilder();
    paramString1.append("Q.richmedia.L.");
    paramString1.append(paramObject);
    QLog.d(paramString1.toString(), 2, localStringBuilder.toString());
  }
  
  public static void printRichMediaError(Object paramObject, String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("step:");
    localStringBuilder.append(paramString1);
    localStringBuilder.append("    \tcontent:");
    localStringBuilder.append(paramString2);
    paramString1 = new StringBuilder();
    paramString1.append("Q.richmedia.L.");
    paramString1.append(paramObject);
    QLog.e(paramString1.toString(), 2, localStringBuilder.toString());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.TransFileUtil
 * JD-Core Version:    0.7.0.1
 */