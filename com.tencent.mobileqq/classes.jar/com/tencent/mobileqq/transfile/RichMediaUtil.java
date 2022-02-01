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
    if (imgAllTags != null) {
      return imgAllTags;
    }
    ArrayList localArrayList = getImageTags("up");
    localArrayList.addAll(getImageTags("dw"));
    imgAllTags = (String[])localArrayList.toArray(new String[localArrayList.size()]);
    return imgAllTags;
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
    boolean bool = false;
    int j;
    if (FileUtils.b(paramString))
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
    if (paramBoolean)
    {
      paramString4 = "up";
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
      if (paramThrowable == null) {
        break label145;
      }
      QLog.e(paramString1, 2, localStringBuilder.toString(), paramThrowable);
    }
    label145:
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
    for (;;)
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
            Object localObject = MobileQQ.sMobileQQ.peekAppRuntime();
            if (localObject != null)
            {
              paramString1 = (TicketManager)((AppRuntime)localObject).getManager(2);
              localObject = ((AppRuntime)localObject).getAccount();
              if (paramString1 == null) {
                break label195;
              }
              paramString1 = paramString1.getSkey((String)localObject);
              QLog.d("RichMediaUtil", 1, new Object[] { localActiveRtpParam.tags, Integer.valueOf(localActiveRtpParam.appid), Boolean.valueOf(paramBoolean), paramString2, localObject, paramString1 });
            }
          }
          if (sActiveRptMap.isEmpty()) {
            sIsActiveReport = false;
          }
        }
        return;
      }
      label195:
      paramString1 = "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.RichMediaUtil
 * JD-Core Version:    0.7.0.1
 */