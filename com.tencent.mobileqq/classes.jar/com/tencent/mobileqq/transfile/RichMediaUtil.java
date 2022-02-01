package com.tencent.mobileqq.transfile;

import com.tencent.image.JpegExifReader;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.TicketManager;

public class RichMediaUtil
{
  public static final int DEFAULT_PROPERBALITY = 10000;
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
  private static Random random = new Random();
  private static HashMap<String, RichMediaUtil.ActiveRtpParam> sActiveRptMap = new HashMap();
  private static boolean sIsActiveReport = false;
  
  public static String getActionDesc(int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("");
    ((StringBuilder)localObject).append(paramInt);
    localObject = ((StringBuilder)localObject).toString();
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2) {
          return localObject;
        }
        return "fw";
      }
      return "up";
    }
    return "dw";
  }
  
  public static int getFileType(int paramInt)
  {
    int i = 65537;
    if (paramInt != 1)
    {
      if (paramInt != 65537)
      {
        if (paramInt != 131075) {
          return 65537;
        }
        return 131075;
      }
    }
    else {
      i = 1;
    }
    return i;
  }
  
  public static String getFileTypeDesc(int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("");
    ((StringBuilder)localObject).append(paramInt);
    localObject = ((StringBuilder)localObject).toString();
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if ((paramInt != 6) && (paramInt != 9) && (paramInt != 17) && (paramInt != 20))
          {
            if (paramInt != 131078)
            {
              switch (paramInt)
              {
              default: 
                switch (paramInt)
                {
                default: 
                  return localObject;
                case 131076: 
                  return "url";
                }
                return "raw";
              case 65538: 
                return "emo";
              }
              return "thu";
            }
            return "msg";
          }
          return "shortvideo";
        }
        return "ptt";
      }
      return "pic";
    }
    return "fil";
  }
  
  public static String[] getImageRecvTags()
  {
    Object localObject = imgRecvTags;
    if (localObject != null) {
      return localObject;
    }
    localObject = getImageTags("dw");
    imgRecvTags = (String[])((ArrayList)localObject).toArray(new String[((ArrayList)localObject).size()]);
    return imgRecvTags;
  }
  
  public static String[] getImageSendTags()
  {
    Object localObject = imgSendTags;
    if (localObject != null) {
      return localObject;
    }
    localObject = getImageTags("up");
    imgSendTags = (String[])((ArrayList)localObject).toArray(new String[((ArrayList)localObject).size()]);
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
        localArrayList.add(TransFileUtil.buildTag(str1, "pic", paramString, str2));
        localArrayList.add(TransFileUtil.buildTag(str1, "raw", paramString, str2));
        localArrayList.add(TransFileUtil.buildTag(str1, "thu", paramString, str2));
        j += 1;
      }
      i += 1;
    }
    return localArrayList;
  }
  
  public static String[] getImageTags()
  {
    Object localObject = imgAllTags;
    if (localObject != null) {
      return localObject;
    }
    localObject = getImageTags("up");
    ((ArrayList)localObject).addAll(getImageTags("dw"));
    imgAllTags = (String[])((ArrayList)localObject).toArray(new String[((ArrayList)localObject).size()]);
    return imgAllTags;
  }
  
  public static String[] getPttDownTags()
  {
    Object localObject = pttDownTags;
    if (localObject != null) {
      return localObject;
    }
    localObject = getPttTags("dw");
    pttDownTags = (String[])((ArrayList)localObject).toArray(new String[((ArrayList)localObject).size()]);
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
        localArrayList.add(TransFileUtil.buildTag(str, "ptt", paramString, arrayOfString2[j]));
        j += 1;
      }
      i += 1;
    }
    return localArrayList;
  }
  
  public static final boolean isActiveReporting()
  {
    return sIsActiveReport;
  }
  
  public static boolean isPicLandscape(String paramString)
  {
    boolean bool2 = FileUtils.fileExistsAndNotEmpty(paramString);
    boolean bool1 = false;
    int i;
    if (bool2)
    {
      int j = JpegExifReader.getRotationDegree(paramString);
      if (j != 90)
      {
        i = j;
        if (j != 270) {}
      }
      else
      {
        bool1 = true;
        i = j;
      }
    }
    else
    {
      i = 0;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isPicLandscape .result =  ");
      localStringBuilder.append(bool1);
      localStringBuilder.append(",degree = ");
      localStringBuilder.append(i);
      localStringBuilder.append(",path = ");
      localStringBuilder.append(paramString);
      QLog.d("RichMediaUtil", 2, localStringBuilder.toString());
    }
    return bool1;
  }
  
  public static void log(int paramInt1, boolean paramBoolean, int paramInt2, String paramString1, String paramString2, String paramString3)
  {
    TransFileUtil.log("T", TransFileUtil.getUinDesc(paramInt1), paramBoolean, getFileTypeDesc(paramInt2), paramString1, paramString2, paramString3, null);
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
    localStringBuilder.append(TransFileUtil.getVersionCode());
    if ("T".equals(paramString1))
    {
      localStringBuilder.append(" \ttid:");
      localStringBuilder.append(Thread.currentThread().getId());
    }
    paramString1 = TransFileUtil.buildTag(paramString2, paramString3, "fw", paramString1);
    if (paramThrowable != null)
    {
      QLog.e(paramString1, 1, localStringBuilder.toString(), paramThrowable);
      return;
    }
    if ((QLog.isColorLevel()) || (sIsActiveReport)) {
      QLog.d(paramString1, 2, localStringBuilder.toString());
    }
  }
  
  public static void logUI(int paramInt1, boolean paramBoolean, int paramInt2, String paramString1, String paramString2, String paramString3)
  {
    TransFileUtil.log("U", TransFileUtil.getUinDesc(paramInt1), paramBoolean, getFileTypeDesc(paramInt2), paramString1, paramString2, paramString3, null);
  }
  
  public static void logUI(int paramInt1, boolean paramBoolean, int paramInt2, String paramString1, String paramString2, String paramString3, Throwable paramThrowable)
  {
    TransFileUtil.log("U", TransFileUtil.getUinDesc(paramInt1), paramBoolean, getFileTypeDesc(paramInt2), paramString1, paramString2, paramString3, paramThrowable);
  }
  
  public static void logdLogic(int paramInt1, boolean paramBoolean, int paramInt2, String paramString1, String paramString2, String paramString3)
  {
    TransFileUtil.log("L", TransFileUtil.getUinDesc(paramInt1), paramBoolean, getFileTypeDesc(paramInt2), paramString1, paramString2, paramString3, null);
  }
  
  public static void loge(String paramString1, String paramString2, boolean paramBoolean, String paramString3, String paramString4, String paramString5, String paramString6, Throwable paramThrowable)
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
    localStringBuilder.append(TransFileUtil.getVersionCode());
    if ("T".equals(paramString1))
    {
      localStringBuilder.append(" \ttid:");
      localStringBuilder.append(Thread.currentThread().getId());
    }
    paramString1 = TransFileUtil.buildTag(paramString2, paramString3, paramString4, paramString1);
    if (paramThrowable != null)
    {
      QLog.e(paramString1, 2, localStringBuilder.toString(), paramThrowable);
      return;
    }
    if ((QLog.isColorLevel()) || (sIsActiveReport)) {
      QLog.e(paramString1, 2, localStringBuilder.toString());
    }
  }
  
  public static void logeLogic(int paramInt1, boolean paramBoolean, int paramInt2, String paramString1, String paramString2, String paramString3, Throwable paramThrowable)
  {
    loge("L", TransFileUtil.getUinDesc(paramInt1), paramBoolean, getFileTypeDesc(paramInt2), paramString1, paramString2, paramString3, paramThrowable);
  }
  
  public static void stopImageSendReport(boolean paramBoolean, String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "image_sending";
    }
    stopReport("image_sending", paramBoolean, str);
  }
  
  public static void stopReport(String paramString1, boolean paramBoolean, String paramString2)
  {
    synchronized (sActiveRptMap)
    {
      if (sActiveRptMap.containsKey(paramString1))
      {
        if ((QLog.isColorLevel()) || (sIsActiveReport))
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("activeReport stop : ");
          ((StringBuilder)localObject).append(paramString1);
          ((StringBuilder)localObject).append(", ");
          ((StringBuilder)localObject).append(paramBoolean);
          QLog.d("RichMediaUtil", 2, ((StringBuilder)localObject).toString());
        }
        Object localObject = (RichMediaUtil.ActiveRtpParam)sActiveRptMap.remove(paramString1);
        if (localObject != null)
        {
          paramString1 = MobileQQ.sMobileQQ.peekAppRuntime();
          if (paramString1 != null)
          {
            TicketManager localTicketManager = (TicketManager)paramString1.getManager(2);
            String str = paramString1.getAccount();
            paramString1 = "";
            if (localTicketManager != null) {
              paramString1 = localTicketManager.getSkey(str);
            }
            QLog.d("RichMediaUtil", 1, new Object[] { ((RichMediaUtil.ActiveRtpParam)localObject).tags, Integer.valueOf(((RichMediaUtil.ActiveRtpParam)localObject).appid), Boolean.valueOf(paramBoolean), paramString2, str, paramString1 });
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.RichMediaUtil
 * JD-Core Version:    0.7.0.1
 */