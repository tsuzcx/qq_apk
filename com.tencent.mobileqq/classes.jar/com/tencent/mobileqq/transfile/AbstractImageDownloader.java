package com.tencent.mobileqq.transfile;

import android.app.Application;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import aydl;
import aydz;
import ayeb;
import ayee;
import bkkh;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.DownloadParams;
import com.tencent.image.DownloadParams.DecodeHandler;
import com.tencent.image.GifDrawable;
import com.tencent.image.RoundRectBitmap;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.image.URLDrawableHandler;
import com.tencent.image.Utils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.pic.PicPreDownloader;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.bitmapcreator.CustomBitmap;
import com.tencent.mobileqq.transfile.bitmapcreator.ExifBitmapCreator;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import mqq.app.AccountNotMatchException;

public abstract class AbstractImageDownloader
  extends AbsDownloader
{
  private static final String BIG_IMG_DECODE = "big_img_decode";
  private static final String BIG_IMG_DECODE_LONG = "big_img_decode_long";
  private static final String BIG_IMG_DECODE_SLICE = "big_img_decode_slice";
  private static int BITMAP_CACHE_1M = 1048576;
  private static int BITMAP_CACHE_2M = BITMAP_CACHE_1M * 2;
  public static int DISPLAY_HEIGHT = 0;
  public static int DISPLAY_WIDTH = 0;
  private static final int ERRORCODE_BIG_IMG_LARGER_THAN_CACHE = 1;
  private static final int ERRORCODE_BIG_IMG_OOM_FAILED_LARGER_THAN_CACHE = 5;
  private static final int ERRORCODE_BIG_IMG_OOM_FAILED_LONG_IMG = 6;
  private static final int ERRORCODE_BIG_IMG_OOM_LONG_IMG = 3;
  private static final int ERRORCODE_BIG_IMG_OOM_NOT_LONG_IMG = 4;
  private static final int ERRORCODE_BIG_IMG_OOM_SMALLER_THAN_1280 = -1;
  private static final int ERRORCODE_BIG_IMG_OOM_SMALLER_THAN_CACHE = 2;
  private static final int ERRORCODE_BIG_IMG_SUCCESS = 0;
  private static final int REPORT_BIG_IMG_BASE_CONST = 88000;
  public static final String TAG_C2C = "c2c_file";
  public static final String TAG_DISCUSS = "discuss_file";
  public static final String TAG_GROUP = "group_file";
  protected BaseApplicationImpl application;
  protected String tag;
  
  public AbstractImageDownloader(String paramString, BaseApplicationImpl paramBaseApplicationImpl)
  {
    this.tag = paramString;
    this.application = paramBaseApplicationImpl;
  }
  
  public static int calculateInSampleSize(BitmapFactory.Options paramOptions, int paramInt1, int paramInt2)
  {
    return Utils.calculateInSampleSize(paramOptions, paramInt1, paramInt2);
  }
  
  /* Error */
  protected static void copyFromFile(java.io.OutputStream paramOutputStream, File paramFile, URLDrawableHandler paramURLDrawableHandler)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 81	java/io/File:length	()J
    //   4: lstore 6
    //   6: new 83	java/io/FileInputStream
    //   9: dup
    //   10: aload_1
    //   11: invokespecial 86	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   14: astore_1
    //   15: lconst_0
    //   16: lstore 4
    //   18: sipush 8192
    //   21: newarray byte
    //   23: astore 8
    //   25: aload_1
    //   26: aload 8
    //   28: invokevirtual 90	java/io/FileInputStream:read	([B)I
    //   31: istore_3
    //   32: iload_3
    //   33: iconst_m1
    //   34: if_icmpeq +92 -> 126
    //   37: aload_0
    //   38: aload 8
    //   40: iconst_0
    //   41: iload_3
    //   42: invokevirtual 96	java/io/OutputStream:write	([BII)V
    //   45: aload_0
    //   46: invokevirtual 99	java/io/OutputStream:flush	()V
    //   49: lload 4
    //   51: iload_3
    //   52: i2l
    //   53: ladd
    //   54: lstore 4
    //   56: aload_2
    //   57: lload 4
    //   59: l2f
    //   60: lload 6
    //   62: l2f
    //   63: fdiv
    //   64: ldc 100
    //   66: fmul
    //   67: f2i
    //   68: invokeinterface 106 2 0
    //   73: goto -48 -> 25
    //   76: astore_2
    //   77: aload_1
    //   78: astore_0
    //   79: aload_2
    //   80: invokevirtual 110	java/io/IOException:getMessage	()Ljava/lang/String;
    //   83: ldc 112
    //   85: invokevirtual 118	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   88: ifeq +47 -> 135
    //   91: new 120	com/tencent/mobileqq/transfile/FileDownloadFailedException
    //   94: dup
    //   95: sipush 9040
    //   98: ldc2_w 121
    //   101: aload_2
    //   102: invokevirtual 110	java/io/IOException:getMessage	()Ljava/lang/String;
    //   105: iconst_0
    //   106: iconst_0
    //   107: invokespecial 125	com/tencent/mobileqq/transfile/FileDownloadFailedException:<init>	(IJLjava/lang/String;ZZ)V
    //   110: athrow
    //   111: astore_2
    //   112: aload_0
    //   113: astore_1
    //   114: aload_2
    //   115: astore_0
    //   116: aload_1
    //   117: ifnull +7 -> 124
    //   120: aload_1
    //   121: invokevirtual 128	java/io/FileInputStream:close	()V
    //   124: aload_0
    //   125: athrow
    //   126: aload_1
    //   127: ifnull +7 -> 134
    //   130: aload_1
    //   131: invokevirtual 128	java/io/FileInputStream:close	()V
    //   134: return
    //   135: new 120	com/tencent/mobileqq/transfile/FileDownloadFailedException
    //   138: dup
    //   139: sipush 9301
    //   142: ldc2_w 129
    //   145: aload_2
    //   146: invokevirtual 110	java/io/IOException:getMessage	()Ljava/lang/String;
    //   149: iconst_0
    //   150: iconst_0
    //   151: invokespecial 125	com/tencent/mobileqq/transfile/FileDownloadFailedException:<init>	(IJLjava/lang/String;ZZ)V
    //   154: athrow
    //   155: astore_0
    //   156: aconst_null
    //   157: astore_1
    //   158: goto -42 -> 116
    //   161: astore_0
    //   162: goto -46 -> 116
    //   165: astore_2
    //   166: aconst_null
    //   167: astore_0
    //   168: goto -89 -> 79
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	171	0	paramOutputStream	java.io.OutputStream
    //   0	171	1	paramFile	File
    //   0	171	2	paramURLDrawableHandler	URLDrawableHandler
    //   31	21	3	i	int
    //   16	42	4	l1	long
    //   4	57	6	l2	long
    //   23	16	8	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   18	25	76	java/io/IOException
    //   25	32	76	java/io/IOException
    //   37	49	76	java/io/IOException
    //   56	73	76	java/io/IOException
    //   79	111	111	finally
    //   135	155	111	finally
    //   6	15	155	finally
    //   18	25	161	finally
    //   25	32	161	finally
    //   37	49	161	finally
    //   56	73	161	finally
    //   6	15	165	java/io/IOException
  }
  
  public static void generateReason(HashMap<String, String> paramHashMap, int paramInt, String paramString, FileMsg.StepBaseInfo paramStepBaseInfo1, FileMsg.StepTransInfo paramStepTransInfo, boolean paramBoolean, FileMsg.StepBaseInfo paramStepBaseInfo2)
  {
    String str;
    if (!BaseTransProcessor.adjustErrorCode(paramInt, paramHashMap))
    {
      paramHashMap.put("param_FailCode", Integer.toString(paramInt));
      if ((paramInt == -9527) || (paramInt == 9311) || (paramInt == 9044) || (paramInt == 9350) || (paramInt == 9351))
      {
        paramHashMap.put(BaseTransProcessor.param_Reason, paramString);
        str = "";
        if ((!paramBoolean) || (paramStepBaseInfo2 != null) || (paramStepBaseInfo1 != null) || (paramStepTransInfo != null)) {
          break label151;
        }
        paramString = "1_-1_0_0_0;2_-1_0_0_0;3_-1_0_0_0";
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("reportResult", 2, "parmStep: " + paramString);
      }
      paramHashMap.put("param_step", paramString);
      return;
      paramHashMap.put("param_errorDesc", paramString);
      break;
      paramHashMap.put("param_errorDesc", paramString);
      break;
      label151:
      paramString = str;
      if (paramStepBaseInfo2 != null)
      {
        paramString = str;
        if (paramStepBaseInfo1 != null)
        {
          paramString = str;
          if (paramStepTransInfo != null) {
            paramString = paramStepBaseInfo2.getStepReportInfo(1) + ";" + paramStepBaseInfo1.getStepReportInfo(2) + ";" + paramStepTransInfo.getStepReportInfo(3);
          }
        }
      }
    }
  }
  
  public static String getExceptionMessage(Exception paramException)
  {
    int i = 8;
    if (paramException == null) {
      return "Exception e is null";
    }
    Object localObject = paramException.getMessage();
    StackTraceElement[] arrayOfStackTraceElement = paramException.getStackTrace();
    if (arrayOfStackTraceElement != null)
    {
      localObject = new StringBuilder(":");
      int j = arrayOfStackTraceElement.length;
      if (j > 8) {}
      for (;;)
      {
        ((StringBuilder)localObject).append("\n");
        j = 0;
        while (j < i)
        {
          ((StringBuilder)localObject).append(arrayOfStackTraceElement[j].toString()).append("\n");
          j += 1;
        }
        i = j;
      }
      return paramException.toString() + ((StringBuilder)localObject).toString();
    }
    return localObject;
  }
  
  public static int getRoundRadius(Application paramApplication, int paramInt)
  {
    float f1 = 1.0F;
    if (paramInt > 150) {
      f1 = paramInt / 100;
    }
    float f2 = paramApplication.getResources().getDisplayMetrics().density;
    if (f2 <= 1.5D) {
      return (int)(f1 * 9.0F);
    }
    if (f2 <= 2.0D) {
      return (int)(f1 * 9.0F);
    }
    return (int)(f1 * 4.0F);
  }
  
  private void log(Object paramObject, String paramString1, String paramString2)
  {
    if ((paramObject instanceof DownloadParams))
    {
      localObject = (DownloadParams)paramObject;
      if ((((DownloadParams)localObject).tag instanceof aydz))
      {
        paramObject = (aydz)((DownloadParams)localObject).tag;
        localObject = ((DownloadParams)localObject).url.getProtocol();
        if (paramObject.isSendFromLocal())
        {
          i = RichMediaUtil.getFileType(URLDrawableHelper.getFileSizeType((String)localObject, false));
          paramObject = paramObject.getPicUploadInfo();
          RichMediaUtil.log(paramObject.b, false, i, String.valueOf(paramObject.a), paramString1, paramString2);
        }
      }
    }
    while (!QLog.isColorLevel())
    {
      int i;
      return;
      paramObject = paramObject.getPicDownloadInfo();
      if (paramObject.e == 1) {}
      for (boolean bool = true;; bool = false)
      {
        i = RichMediaUtil.getFileType(URLDrawableHelper.getFileSizeType((String)localObject, bool));
        RichMediaUtil.log(paramObject.b, false, i, String.valueOf(paramObject.a), paramString1, paramString2);
        return;
      }
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("obj").append(paramObject);
    ((StringBuilder)localObject).append(" \tstep:").append(paramString1);
    ((StringBuilder)localObject).append(" \tcontent:").append(paramString2);
    QLog.d("Q.richmedia.", 2, ((StringBuilder)localObject).toString());
  }
  
  private void logDecodeFile(DownloadParams paramDownloadParams, File paramFile, String paramString1, BitmapFactory.Options paramOptions, int paramInt, boolean paramBoolean, String paramString2)
  {
    if (paramBoolean) {
      if (QLog.isColorLevel()) {
        log(paramDownloadParams, "DecodeFile", "DecodeFile SUCCESS,retryCount=" + paramInt + ",options.inSampleSize=" + paramOptions.inSampleSize + ",cacheFile=" + paramFile.getAbsolutePath() + ",url=" + paramString1 + ",extraMsg=" + paramString2);
      }
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    log(paramDownloadParams, "DecodeFile", "DecodeFile FAIL,retryCount=" + paramInt + ",options.inSampleSize=" + paramOptions.inSampleSize + ",cacheFile=" + paramFile.getAbsolutePath() + ",url=" + paramString1 + ",extraMsg=" + paramString2);
  }
  
  private void payPicFlow(DownloadParams paramDownloadParams)
  {
    MessageForPic localMessageForPic;
    Object localObject;
    if ((paramDownloadParams.tag != null) && ((paramDownloadParams.tag instanceof MessageForPic)))
    {
      localMessageForPic = (MessageForPic)paramDownloadParams.tag;
      localObject = localMessageForPic.selfuin;
    }
    try
    {
      localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getAppRuntime((String)localObject);
      ((QQAppInterface)localObject).getPicPreDownloader().a.b(localMessageForPic, localMessageForPic.size);
      ((QQAppInterface)localObject).getPicPreDownloader().d();
      return;
    }
    catch (AccountNotMatchException localAccountNotMatchException)
    {
      log(paramDownloadParams, "payPicFlow", "FAIL,exceptionmsg:" + localAccountNotMatchException);
    }
  }
  
  private void reportBitmapSize(Application paramApplication, String paramString, int paramInt, boolean paramBoolean)
  {
    int i = 0;
    paramInt *= 4;
    try
    {
      if (paramInt < BITMAP_CACHE_1M)
      {
        paramInt = i;
        if (!paramBoolean) {
          break label184;
        }
        paramInt = 1;
      }
      for (;;)
      {
        paramApplication = (QQAppInterface)BaseApplicationImpl.getApplication().getAppRuntime(paramString);
        paramString = new HashMap();
        paramString.put("param_FailCode", Integer.toString(paramInt + 88050));
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(paramApplication.getCurrentAccountUin(), "report_aio_photo_size", false, 0L, 0L, paramString, "");
        return;
        paramInt /= BITMAP_CACHE_2M;
        if (paramInt >= 10)
        {
          if (paramBoolean) {}
          for (paramInt = 17;; paramInt = 16) {
            break;
          }
        }
        if (paramInt >= 8)
        {
          if (paramBoolean) {}
          for (paramInt = 15;; paramInt = 14) {
            break;
          }
        }
        if (paramInt >= 6)
        {
          if (paramBoolean) {}
          for (paramInt = 13;; paramInt = 12) {
            break;
          }
        }
        if (paramBoolean) {}
        for (paramInt = paramInt * 2 + 3;; paramInt = paramInt * 2 + 2) {
          break;
        }
      }
    }
    catch (AccountNotMatchException paramApplication) {}
  }
  
  private void reportDecodeData(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, int paramInt1, int paramInt2, String paramString, boolean paramBoolean5)
  {
    if (paramInt2 == 3)
    {
      paramInt2 = paramInt1 - 1;
      if (paramInt1 != 1) {
        break label49;
      }
      reportDecodeImage(this.application, "big_img_decode", 0, paramString, paramInt2);
      reportDecodeImage(this.application, "big_img_decode_long", 0, paramString, paramInt2);
    }
    label49:
    do
    {
      for (;;)
      {
        return;
        if (!paramBoolean5) {
          break;
        }
        if (!paramBoolean1) {
          if (paramBoolean3)
          {
            reportDecodeImage(this.application, "big_img_decode", -1, paramString, paramInt2);
            if (!paramBoolean2) {
              break label152;
            }
            reportDecodeImage(this.application, "big_img_decode_long", 3, paramString, paramInt2);
          }
        }
        for (;;)
        {
          if (!paramBoolean2) {
            break label168;
          }
          reportDecodeImage(this.application, "big_img_decode_slice", 0, paramString, paramInt2);
          return;
          reportDecodeImage(this.application, "big_img_decode", 2, paramString, paramInt2);
          break;
          reportDecodeImage(this.application, "big_img_decode", 1, paramString, paramInt2);
          break;
          reportDecodeImage(this.application, "big_img_decode_long", 4, paramString, paramInt2);
        }
      }
      if (paramBoolean1) {
        reportDecodeImage(this.application, "big_img_decode", 5, paramString, paramInt2);
      }
      if (paramBoolean2) {
        reportDecodeImage(this.application, "big_img_decode_long", 6, paramString, paramInt2);
      }
    } while (!paramBoolean4);
    label152:
    label168:
    reportDecodeImage(this.application, "big_img_decode_slice", 6, paramString, paramInt2);
  }
  
  private void reportDecodeImage(Application paramApplication, String paramString1, int paramInt1, String paramString2, int paramInt2)
  {
    if (paramString2 != null) {}
    for (;;)
    {
      try
      {
        paramApplication = ((QQAppInterface)BaseApplicationImpl.getApplication().getAppRuntime(paramString2)).getCurrentAccountUin();
      }
      catch (AccountNotMatchException paramApplication)
      {
        return;
      }
      paramString2 = new HashMap();
      paramString2.put("param_FailCode", Integer.toString(paramInt2 * 7 + paramInt1 + 88000));
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(paramApplication, paramString1, bool, 0L, 0L, paramString2, "");
      return;
      boolean bool = false;
      continue;
      paramApplication = paramString2;
      if (paramInt2 == 0) {
        bool = true;
      }
    }
  }
  
  public static void reportResult(AbstractImageDownloader.ReportData paramReportData, boolean paramBoolean, int paramInt1, int paramInt2, String paramString, FileMsg.StepBaseInfo paramStepBaseInfo1, FileMsg.StepBaseInfo paramStepBaseInfo2, FileMsg.StepTransInfo paramStepTransInfo)
  {
    System.currentTimeMillis();
    long l1;
    if (paramStepTransInfo != null)
    {
      l1 = paramStepTransInfo.flowDown;
      if (paramStepTransInfo == null) {
        break label42;
      }
    }
    label42:
    for (long l2 = paramStepTransInfo.contentSize;; l2 = 0L)
    {
      if (!RichMediaStrategy.noReportByErrorCode(paramInt2)) {
        break label48;
      }
      return;
      l1 = 0L;
      break;
    }
    label48:
    HashMap localHashMap = new HashMap();
    generateReason(localHashMap, paramInt2, paramString, paramStepBaseInfo2, paramStepTransInfo, paramBoolean, paramStepBaseInfo1);
    localHashMap.put("param_uuid", paramReportData.uuid);
    localHashMap.put("flow", String.valueOf(l1));
    localHashMap.put("msgTime", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(paramReportData.msgTime * 1000L)));
    localHashMap.put("client_exist", String.valueOf(paramReportData.clientExist));
    if (paramStepBaseInfo2 != null) {
      localHashMap.put("param_RequestUrl", paramStepBaseInfo2.toReportJson());
    }
    if (paramStepTransInfo != null) {
      localHashMap.put("param_HttpTran", paramStepTransInfo.toReportJson());
    }
    if (paramStepTransInfo != null)
    {
      localHashMap.put("param_retry", String.valueOf(paramStepTransInfo.retryCount));
      if (paramStepTransInfo.result)
      {
        localHashMap.put("serverip", paramStepTransInfo.firstIp);
        localHashMap.put("param_Server", paramStepTransInfo.firstIp);
      }
    }
    else
    {
      if (!paramBoolean) {
        break label383;
      }
      if ((!paramReportData.multiMediaEvtTag.equals("actC2CPicDownloadV1")) && (!paramReportData.multiMediaEvtTag.equals("actC2CPicSmallDownV1"))) {
        break label367;
      }
      localHashMap.put("param_toUin", paramReportData.peerUin);
    }
    for (;;)
    {
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, paramReportData.multiMediaEvtTag, true, paramInt1, l1, localHashMap, "");
      return;
      localHashMap.put("serverip", paramStepTransInfo.lastUseIp);
      localHashMap.put("param_Server", paramStepTransInfo.lastUseIp);
      if (paramInt2 != -9527) {
        break;
      }
      localHashMap.put("param_rspHeader", paramStepTransInfo.respHeader);
      break;
      label367:
      localHashMap.put("param_grpUin", paramReportData.peerUin);
    }
    label383:
    if (paramInt2 == 9301) {
      localHashMap.put("param_connecttrycount", paramString);
    }
    if ((paramReportData.msgDate != null) && (!paramReportData.msgDate.equals(""))) {
      localHashMap.put("param_MsgTime", paramReportData.msgDate);
    }
    long l3 = paramInt1;
    if ((paramReportData.multiMediaEvtTag.equals("actC2CPicDownloadV1")) || (paramReportData.multiMediaEvtTag.equals("actC2CPicSmallDownV1")))
    {
      localHashMap.put("param_toUin", paramReportData.peerUin);
      localHashMap.put("param_url", paramReportData.srvUrl);
      localHashMap.put("param_fsized", l1 + "");
      localHashMap.put("param_fsizeo", l2 + "");
    }
    for (;;)
    {
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, paramReportData.multiMediaEvtTag, false, 0L, 0L, localHashMap, "");
      return;
      localHashMap.put("param_grpUin", paramReportData.peerUin);
      localHashMap.put("param_url", paramReportData.srvUrl);
      localHashMap.put("param_fsized", l1 + "");
      localHashMap.put("param_fsizeo", l2 + "");
    }
  }
  
  public Object decodeAioPicThumb(File paramFile, DownloadParams paramDownloadParams, BitmapFactory.Options paramOptions)
  {
    String str1 = paramDownloadParams.urlStr;
    for (;;)
    {
      try
      {
        localObject1 = paramFile.getAbsolutePath();
        paramOptions.inPreferredConfig = URLDrawableHelper.mThumbConfig;
        paramOptions.inJustDecodeBounds = false;
        localObject2 = paramFile.getName();
        if (!((String)localObject2).endsWith("_hd"))
        {
          localObject2 = new File((String)localObject1 + "_hd");
          bool = ((File)localObject2).exists();
          if (!bool) {
            continue;
          }
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError2)
      {
        Object localObject1;
        Object localObject2;
        boolean bool;
        Object localObject3;
        continue;
        int i = 0;
        continue;
      }
      try
      {
        if (QLog.isColorLevel()) {
          log(paramDownloadParams, "DecodeFile", "DecodeFile hd thumb instead,cacheFile=" + ((File)localObject2).getAbsolutePath() + ", url=" + str1);
        }
        paramFile = (File)localObject2;
        i = 1;
      }
      catch (OutOfMemoryError localOutOfMemoryError3)
      {
        paramFile = (File)localObject2;
        continue;
        i = 0;
        continue;
      }
      try
      {
        localObject2 = SafeBitmapFactory.decodeFile(paramFile.getAbsolutePath(), paramOptions);
        localObject3 = localObject2;
        if (localObject2 == null)
        {
          localObject3 = localObject2;
          if (i != 0)
          {
            bool = FileUtils.fileExists((String)localObject1);
            if (bool)
            {
              localObject3 = SafeBitmapFactory.decodeFile((String)localObject1, paramOptions);
              localObject2 = localObject3;
              if (localObject3 == null)
              {
                String str2 = MD5Utils.encodeFileHexStr((String)localObject1);
                FileUtils.deleteFile((String)localObject1);
                localObject2 = localObject3;
                if (QLog.isColorLevel())
                {
                  log(paramDownloadParams, "DecodeFile", "delete err thumb md5=" + str2);
                  localObject2 = localObject3;
                }
              }
            }
            localObject3 = localObject2;
            if (QLog.isColorLevel())
            {
              localObject3 = new StringBuilder().append("decode hd failed, try decode thumb ").append((String)localObject1).append(" exist=").append(bool).append(" result=");
              if (localObject2 == null) {
                continue;
              }
              bool = true;
              log(paramDownloadParams, "DecodeFile", bool);
              localObject3 = localObject2;
            }
          }
        }
        if (localObject3 != null)
        {
          if (i != 0) {
            FileUtils.deleteFile((String)localObject1);
          }
          localObject1 = localObject3;
          if (paramDownloadParams.mDecodeHandler != null) {
            localObject1 = paramDownloadParams.mDecodeHandler.run(paramDownloadParams, (Bitmap)localObject3);
          }
          if (paramDownloadParams.tag != null)
          {
            if ((paramDownloadParams.tag instanceof MessageForPic)) {
              if (((MessageForPic)paramDownloadParams.tag).subMsgType != 2)
              {
                bool = str1.endsWith("?noRound");
                if (!bool) {}
              }
              else
              {
                return localObject1;
                if (((String)localObject2).length() <= 3) {
                  continue;
                }
                if (QLog.isColorLevel()) {
                  log(paramDownloadParams, "DecodeFile", "DecodeFile hd ,hdPath=" + (String)localObject1);
                }
                localObject1 = ((String)localObject1).substring(0, ((String)localObject1).length() - 3);
                i = 1;
                continue;
                bool = false;
                continue;
              }
            }
            if ((paramDownloadParams.tag instanceof CustomBitmap)) {
              return ((CustomBitmap)paramDownloadParams.tag).createBitmap((Bitmap)localObject1);
            }
          }
          localObject2 = resizeAndClipBitmap((Bitmap)localObject1, paramDownloadParams);
          if (!localObject1.equals(((RoundRectBitmap)localObject2).mBitmap)) {
            ((Bitmap)localObject1).recycle();
          }
          localObject1 = new RoundRectBitmap(new ExifBitmapCreator(paramFile.getAbsolutePath()).creatBitmap(((RoundRectBitmap)localObject2).mBitmap), ((RoundRectBitmap)localObject2).mCornerRadius, ((RoundRectBitmap)localObject2).mBoardColor, ((RoundRectBitmap)localObject2).mBorderWidth);
          if (this.application != null)
          {
            ((RoundRectBitmap)localObject1).mDisplayWidth = this.application.getResources().getDisplayMetrics().widthPixels;
            ((RoundRectBitmap)localObject1).mDisplayHeight = this.application.getResources().getDisplayMetrics().heightPixels;
          }
          logDecodeFile(paramDownloadParams, paramFile, str1, paramOptions, 1, true, "step:create roundBitmap");
          return localObject1;
        }
        if (!((aydz)paramDownloadParams.tag).isSendFromLocal())
        {
          localObject1 = MD5Utils.encodeFileHexStr(paramFile.getAbsolutePath());
          localObject2 = ((aydz)paramDownloadParams.tag).getPicDownloadInfo();
          QLog.i("Q.richmedia." + RichMediaUtil.getUinDesc(((aydl)localObject2).b) + ".dw", 1, "id:" + String.valueOf(((aydl)localObject2).a) + "step: UIDecoder FAIL srcPicMD5:" + (String)localObject1);
        }
        paramFile.delete();
        logDecodeFile(paramDownloadParams, paramFile, str1, paramOptions, 1, false, "step:decode error, not valid pic");
        throw new IOException("step:decode error, not valid pic");
      }
      catch (OutOfMemoryError localOutOfMemoryError1)
      {
        logDecodeFile(paramDownloadParams, paramFile, str1, paramOptions, 1, false, "step:create roundBitmap, " + localOutOfMemoryError1.getMessage());
        throw localOutOfMemoryError1;
      }
    }
  }
  
  protected boolean decodeByAIOPicThumb(File paramFile, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    return "lbsthumb".equals(paramDownloadParams.url.getProtocol());
  }
  
  protected boolean decodeByGif(File paramFile, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    return GifDrawable.isGifFile(paramFile);
  }
  
  public Object decodeFile(File paramFile, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    if (QLog.isColorLevel()) {
      log(paramDownloadParams, "DecodeFile", "decodeFile config.tag " + paramDownloadParams.tag);
    }
    URL localURL;
    BitmapFactory.Options localOptions;
    try
    {
      String str = paramDownloadParams.urlStr;
      localURL = paramDownloadParams.url;
      if (QLog.isColorLevel()) {
        log(paramDownloadParams, "DecodeFile", "DecodeFile START,cacheFile=" + paramFile.getAbsolutePath() + ",url=" + str);
      }
      localOptions = new BitmapFactory.Options();
      localOptions.inPreferredConfig = URLDrawableHelper.mConfig;
      localOptions.inDensity = 160;
      localOptions.inTargetDensity = 160;
      localOptions.inScreenDensity = 160;
      localOptions.inJustDecodeBounds = true;
      if (decodeByGif(paramFile, paramDownloadParams, paramURLDrawableHandler))
      {
        payPicFlow(paramDownloadParams);
        if (!QLog.isColorLevel()) {
          break label422;
        }
        log(paramDownloadParams, "DecodeFile", "DecodeFile END,GIF image,cacheFile=" + paramFile.getAbsolutePath() + ",url=" + str);
        break label422;
      }
      if (decodeByAIOPicThumb(paramFile, paramDownloadParams, paramURLDrawableHandler)) {
        return decodeAioPicThumb(paramFile, paramDownloadParams, localOptions);
      }
      payPicFlow(paramDownloadParams);
      localOptions.inJustDecodeBounds = true;
      SafeBitmapFactory.decodeFile(paramFile.getAbsolutePath(), localOptions);
      if ((localOptions.outHeight == 0) || (localOptions.outWidth == 0))
      {
        paramFile.delete();
        logDecodeFile(paramDownloadParams, paramFile, str, localOptions, 1, false, "step:decode bounds error, not valid pic");
        throw new IOException("step:decode bounds error, not valid pic");
      }
    }
    catch (Exception localException)
    {
      paramURLDrawableHandler = getExceptionMessage(localException);
      if (paramURLDrawableHandler != null)
      {
        paramFile = paramURLDrawableHandler;
        if (paramURLDrawableHandler.length() != 0) {}
      }
      else
      {
        paramFile = localException.toString();
      }
      if (QLog.isColorLevel())
      {
        QLog.e(this.tag, 2, paramFile);
        log(paramDownloadParams, "DecodeFile", "DecodeFile FAIL,exceptionmsg:" + paramFile);
      }
      paramDownloadParams = new HashMap();
      paramDownloadParams.put("params_failDesc", paramFile);
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "actPicUIDecoder", false, -1L, 0L, paramDownloadParams, "", true);
      throw localException;
    }
    paramFile = decodeImage(localURL, paramFile, paramDownloadParams, localOptions);
    return paramFile;
    label422:
    return null;
  }
  
  /* Error */
  public Object decodeImage(URL paramURL, File paramFile, DownloadParams paramDownloadParams, BitmapFactory.Options paramOptions)
  {
    // Byte code:
    //   0: aload_3
    //   1: getfield 559	com/tencent/image/DownloadParams:urlStr	Ljava/lang/String;
    //   4: astore 17
    //   6: aload 4
    //   8: aload 4
    //   10: aload_3
    //   11: getfield 790	com/tencent/image/DownloadParams:reqWidth	I
    //   14: aload_3
    //   15: getfield 793	com/tencent/image/DownloadParams:reqHeight	I
    //   18: invokestatic 794	com/tencent/mobileqq/transfile/AbstractImageDownloader:calculateInSampleSize	(Landroid/graphics/BitmapFactory$Options;II)I
    //   21: putfield 337	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   24: aload 4
    //   26: getfield 766	android/graphics/BitmapFactory$Options:outWidth	I
    //   29: istore 7
    //   31: aload 4
    //   33: getfield 763	android/graphics/BitmapFactory$Options:outHeight	I
    //   36: istore 8
    //   38: aload 4
    //   40: iconst_0
    //   41: putfield 569	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   44: iconst_0
    //   45: istore 10
    //   47: aconst_null
    //   48: astore 16
    //   50: iconst_1
    //   51: istore 6
    //   53: aload_1
    //   54: invokevirtual 264	java/net/URL:getProtocol	()Ljava/lang/String;
    //   57: ldc_w 796
    //   60: invokevirtual 516	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   63: ifne +42 -> 105
    //   66: aload_1
    //   67: invokevirtual 264	java/net/URL:getProtocol	()Ljava/lang/String;
    //   70: ldc_w 798
    //   73: invokevirtual 516	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   76: ifne +29 -> 105
    //   79: aload_1
    //   80: invokevirtual 264	java/net/URL:getProtocol	()Ljava/lang/String;
    //   83: ldc_w 800
    //   86: invokevirtual 516	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   89: ifne +16 -> 105
    //   92: aload_1
    //   93: invokevirtual 264	java/net/URL:getProtocol	()Ljava/lang/String;
    //   96: ldc_w 802
    //   99: invokevirtual 516	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   102: ifeq +754 -> 856
    //   105: iconst_3
    //   106: istore 5
    //   108: aload 16
    //   110: astore_1
    //   111: iload 6
    //   113: iload 5
    //   115: if_icmpgt +730 -> 845
    //   118: aload_2
    //   119: invokevirtual 342	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   122: aload 4
    //   124: invokestatic 592	com/tencent/image/SafeBitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   127: astore 16
    //   129: aload 16
    //   131: astore_1
    //   132: ldc_w 804
    //   135: aload_3
    //   136: getfield 807	com/tencent/image/DownloadParams:mExtraInfo	Ljava/lang/Object;
    //   139: invokevirtual 516	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   142: ifeq +708 -> 850
    //   145: aload 16
    //   147: astore_1
    //   148: new 667	com/tencent/mobileqq/transfile/bitmapcreator/ExifBitmapCreator
    //   151: dup
    //   152: aload_2
    //   153: invokevirtual 342	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   156: invokespecial 668	com/tencent/mobileqq/transfile/bitmapcreator/ExifBitmapCreator:<init>	(Ljava/lang/String;)V
    //   159: aload 16
    //   161: invokevirtual 671	com/tencent/mobileqq/transfile/bitmapcreator/ExifBitmapCreator:creatBitmap	(Landroid/graphics/Bitmap;)Landroid/graphics/Bitmap;
    //   164: astore 16
    //   166: aload 16
    //   168: astore_1
    //   169: aload_1
    //   170: ifnonnull +258 -> 428
    //   173: iload 10
    //   175: istore 11
    //   177: invokestatic 165	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   180: ifeq +60 -> 240
    //   183: iload 10
    //   185: istore 11
    //   187: aload_0
    //   188: aload_3
    //   189: ldc_w 325
    //   192: new 169	java/lang/StringBuilder
    //   195: dup
    //   196: invokespecial 170	java/lang/StringBuilder:<init>	()V
    //   199: ldc_w 809
    //   202: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   205: aload 17
    //   207: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   210: ldc_w 811
    //   213: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   216: iload 6
    //   218: invokevirtual 330	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   221: ldc_w 813
    //   224: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   227: aload_2
    //   228: invokevirtual 342	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   231: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   234: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   237: invokespecial 348	com/tencent/mobileqq/transfile/AbstractImageDownloader:log	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
    //   240: iload 10
    //   242: istore 11
    //   244: new 556	java/lang/OutOfMemoryError
    //   247: dup
    //   248: new 169	java/lang/StringBuilder
    //   251: dup
    //   252: invokespecial 170	java/lang/StringBuilder:<init>	()V
    //   255: ldc_w 809
    //   258: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   261: aload 17
    //   263: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   266: ldc_w 811
    //   269: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   272: iload 6
    //   274: invokevirtual 330	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   277: ldc_w 813
    //   280: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   283: aload_2
    //   284: invokevirtual 342	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   287: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   290: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   293: invokespecial 814	java/lang/OutOfMemoryError:<init>	(Ljava/lang/String;)V
    //   296: athrow
    //   297: astore 16
    //   299: iload 11
    //   301: istore 10
    //   303: aload_1
    //   304: ifnull +7 -> 311
    //   307: aload_1
    //   308: invokevirtual 665	android/graphics/Bitmap:recycle	()V
    //   311: aload 16
    //   313: ifnull +468 -> 781
    //   316: aload 16
    //   318: invokevirtual 721	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   321: astore 16
    //   323: invokestatic 165	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   326: ifeq +81 -> 407
    //   329: aload_0
    //   330: aload_3
    //   331: ldc_w 325
    //   334: new 169	java/lang/StringBuilder
    //   337: dup
    //   338: invokespecial 170	java/lang/StringBuilder:<init>	()V
    //   341: ldc_w 816
    //   344: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   347: iload 6
    //   349: invokevirtual 330	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   352: ldc_w 332
    //   355: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   358: aload 4
    //   360: getfield 337	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   363: invokevirtual 330	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   366: ldc_w 339
    //   369: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   372: aload_2
    //   373: invokevirtual 342	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   376: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   379: ldc_w 344
    //   382: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   385: aload 17
    //   387: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   390: ldc_w 818
    //   393: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   396: aload 16
    //   398: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   401: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   404: invokespecial 348	com/tencent/mobileqq/transfile/AbstractImageDownloader:log	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
    //   407: iload 6
    //   409: iconst_1
    //   410: iadd
    //   411: istore 6
    //   413: aload 4
    //   415: aload 4
    //   417: getfield 337	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   420: iconst_2
    //   421: imul
    //   422: putfield 337	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   425: goto -314 -> 111
    //   428: iload 10
    //   430: istore 11
    //   432: getstatic 823	android/os/Build$VERSION:SDK_INT	I
    //   435: bipush 11
    //   437: if_icmplt +341 -> 778
    //   440: iload 10
    //   442: istore 11
    //   444: aload_1
    //   445: invokestatic 829	com/tencent/image/SliceBitmap:needSlice	(Landroid/graphics/Bitmap;)Z
    //   448: istore 12
    //   450: iload 12
    //   452: ifeq +326 -> 778
    //   455: iload 10
    //   457: istore 11
    //   459: new 825	com/tencent/image/SliceBitmap
    //   462: dup
    //   463: aload_1
    //   464: invokespecial 832	com/tencent/image/SliceBitmap:<init>	(Landroid/graphics/Bitmap;)V
    //   467: astore 16
    //   469: iconst_1
    //   470: istore 10
    //   472: aload_1
    //   473: invokevirtual 665	android/graphics/Bitmap:recycle	()V
    //   476: aload_0
    //   477: aload_3
    //   478: aload_2
    //   479: aload 17
    //   481: aload 4
    //   483: iload 6
    //   485: iconst_1
    //   486: ldc_w 834
    //   489: invokespecial 700	com/tencent/mobileqq/transfile/AbstractImageDownloader:logDecodeFile	(Lcom/tencent/image/DownloadParams;Ljava/io/File;Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;IZLjava/lang/String;)V
    //   492: aload 16
    //   494: astore_1
    //   495: iconst_1
    //   496: istore 10
    //   498: aload_1
    //   499: ifnull +288 -> 787
    //   502: iconst_1
    //   503: istore 11
    //   505: aload_0
    //   506: aload_3
    //   507: aload_2
    //   508: aload 17
    //   510: aload 4
    //   512: iload 6
    //   514: iload 11
    //   516: ldc 157
    //   518: invokespecial 700	com/tencent/mobileqq/transfile/AbstractImageDownloader:logDecodeFile	(Lcom/tencent/image/DownloadParams;Ljava/io/File;Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;IZLjava/lang/String;)V
    //   521: aload_3
    //   522: getfield 253	com/tencent/image/DownloadParams:tag	Ljava/lang/Object;
    //   525: ifnull +185 -> 710
    //   528: aload_3
    //   529: getfield 253	com/tencent/image/DownloadParams:tag	Ljava/lang/Object;
    //   532: instanceof 356
    //   535: ifeq +175 -> 710
    //   538: aload_3
    //   539: getfield 253	com/tencent/image/DownloadParams:tag	Ljava/lang/Object;
    //   542: checkcast 356	com/tencent/mobileqq/data/MessageForPic
    //   545: astore_2
    //   546: aload_2
    //   547: getfield 359	com/tencent/mobileqq/data/MessageForPic:selfuin	Ljava/lang/String;
    //   550: astore_3
    //   551: aload_2
    //   552: invokevirtual 835	com/tencent/mobileqq/data/MessageForPic:isSendFromLocal	()Z
    //   555: istore 15
    //   557: aload_1
    //   558: ifnull +235 -> 793
    //   561: iconst_1
    //   562: istore 11
    //   564: iload 7
    //   566: iload 8
    //   568: imul
    //   569: istore 9
    //   571: iload 9
    //   573: getstatic 838	com/tencent/common/app/BaseApplicationImpl:sImageCacheSize	I
    //   576: if_icmple +223 -> 799
    //   579: iconst_1
    //   580: istore 12
    //   582: iload 7
    //   584: sipush 2048
    //   587: if_icmpgt +11 -> 598
    //   590: iload 8
    //   592: sipush 2048
    //   595: if_icmple +210 -> 805
    //   598: iconst_1
    //   599: istore 13
    //   601: getstatic 840	com/tencent/mobileqq/transfile/AbstractImageDownloader:DISPLAY_WIDTH	I
    //   604: ifeq +9 -> 613
    //   607: getstatic 842	com/tencent/mobileqq/transfile/AbstractImageDownloader:DISPLAY_HEIGHT	I
    //   610: ifne +35 -> 645
    //   613: aload_0
    //   614: getfield 65	com/tencent/mobileqq/transfile/AbstractImageDownloader:application	Lcom/tencent/common/app/BaseApplicationImpl;
    //   617: invokevirtual 684	com/tencent/common/app/BaseApplicationImpl:getResources	()Landroid/content/res/Resources;
    //   620: invokevirtual 234	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   623: getfield 687	android/util/DisplayMetrics:widthPixels	I
    //   626: putstatic 840	com/tencent/mobileqq/transfile/AbstractImageDownloader:DISPLAY_WIDTH	I
    //   629: aload_0
    //   630: getfield 65	com/tencent/mobileqq/transfile/AbstractImageDownloader:application	Lcom/tencent/common/app/BaseApplicationImpl;
    //   633: invokevirtual 684	com/tencent/common/app/BaseApplicationImpl:getResources	()Landroid/content/res/Resources;
    //   636: invokevirtual 234	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   639: getfield 693	android/util/DisplayMetrics:heightPixels	I
    //   642: putstatic 842	com/tencent/mobileqq/transfile/AbstractImageDownloader:DISPLAY_HEIGHT	I
    //   645: getstatic 840	com/tencent/mobileqq/transfile/AbstractImageDownloader:DISPLAY_WIDTH	I
    //   648: getstatic 842	com/tencent/mobileqq/transfile/AbstractImageDownloader:DISPLAY_HEIGHT	I
    //   651: if_icmple +160 -> 811
    //   654: getstatic 840	com/tencent/mobileqq/transfile/AbstractImageDownloader:DISPLAY_WIDTH	I
    //   657: istore 7
    //   659: iload 9
    //   661: getstatic 845	com/tencent/mobileqq/transfile/URLDrawableHelper:smallSize	I
    //   664: if_icmpgt +155 -> 819
    //   667: iload 7
    //   669: sipush 1000
    //   672: if_icmple +147 -> 819
    //   675: iconst_1
    //   676: istore 14
    //   678: aload_0
    //   679: iload 12
    //   681: iload 13
    //   683: iload 14
    //   685: iload 10
    //   687: iload 6
    //   689: iload 5
    //   691: aload_3
    //   692: iload 11
    //   694: invokespecial 847	com/tencent/mobileqq/transfile/AbstractImageDownloader:reportDecodeData	(ZZZZIILjava/lang/String;Z)V
    //   697: aload_0
    //   698: aload_0
    //   699: getfield 65	com/tencent/mobileqq/transfile/AbstractImageDownloader:application	Lcom/tencent/common/app/BaseApplicationImpl;
    //   702: aload_3
    //   703: iload 9
    //   705: iload 15
    //   707: invokespecial 849	com/tencent/mobileqq/transfile/AbstractImageDownloader:reportBitmapSize	(Landroid/app/Application;Ljava/lang/String;IZ)V
    //   710: aload_1
    //   711: ifnonnull +114 -> 825
    //   714: new 75	java/io/IOException
    //   717: dup
    //   718: ldc_w 851
    //   721: invokespecial 718	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   724: athrow
    //   725: astore 16
    //   727: iload 10
    //   729: istore 11
    //   731: aload_0
    //   732: aload_3
    //   733: ldc_w 325
    //   736: new 169	java/lang/StringBuilder
    //   739: dup
    //   740: invokespecial 170	java/lang/StringBuilder:<init>	()V
    //   743: ldc_w 853
    //   746: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   749: aload 16
    //   751: invokevirtual 205	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   754: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   757: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   760: invokespecial 348	com/tencent/mobileqq/transfile/AbstractImageDownloader:log	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
    //   763: iload 10
    //   765: istore 11
    //   767: new 556	java/lang/OutOfMemoryError
    //   770: dup
    //   771: ldc_w 855
    //   774: invokespecial 814	java/lang/OutOfMemoryError:<init>	(Ljava/lang/String;)V
    //   777: athrow
    //   778: goto -280 -> 498
    //   781: aconst_null
    //   782: astore 16
    //   784: goto -461 -> 323
    //   787: iconst_0
    //   788: istore 11
    //   790: goto -285 -> 505
    //   793: iconst_0
    //   794: istore 11
    //   796: goto -232 -> 564
    //   799: iconst_0
    //   800: istore 12
    //   802: goto -220 -> 582
    //   805: iconst_0
    //   806: istore 13
    //   808: goto -207 -> 601
    //   811: getstatic 842	com/tencent/mobileqq/transfile/AbstractImageDownloader:DISPLAY_HEIGHT	I
    //   814: istore 7
    //   816: goto -157 -> 659
    //   819: iconst_0
    //   820: istore 14
    //   822: goto -144 -> 678
    //   825: aload_1
    //   826: areturn
    //   827: astore 16
    //   829: goto -526 -> 303
    //   832: astore 16
    //   834: goto -531 -> 303
    //   837: astore 16
    //   839: iconst_1
    //   840: istore 10
    //   842: goto -115 -> 727
    //   845: aconst_null
    //   846: astore_1
    //   847: goto -349 -> 498
    //   850: aload 16
    //   852: astore_1
    //   853: goto -684 -> 169
    //   856: iconst_1
    //   857: istore 5
    //   859: aload 16
    //   861: astore_1
    //   862: goto -751 -> 111
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	865	0	this	AbstractImageDownloader
    //   0	865	1	paramURL	URL
    //   0	865	2	paramFile	File
    //   0	865	3	paramDownloadParams	DownloadParams
    //   0	865	4	paramOptions	BitmapFactory.Options
    //   106	752	5	i	int
    //   51	637	6	j	int
    //   29	786	7	k	int
    //   36	560	8	m	int
    //   569	135	9	n	int
    //   45	796	10	bool1	boolean
    //   175	620	11	bool2	boolean
    //   448	353	12	bool3	boolean
    //   599	208	13	bool4	boolean
    //   676	145	14	bool5	boolean
    //   555	151	15	bool6	boolean
    //   48	119	16	localBitmap	Bitmap
    //   297	20	16	localOutOfMemoryError1	OutOfMemoryError
    //   321	172	16	localObject1	Object
    //   725	25	16	localException1	Exception
    //   782	1	16	localObject2	Object
    //   827	1	16	localOutOfMemoryError2	OutOfMemoryError
    //   832	1	16	localOutOfMemoryError3	OutOfMemoryError
    //   837	23	16	localException2	Exception
    //   4	505	17	str	String
    // Exception table:
    //   from	to	target	type
    //   177	183	297	java/lang/OutOfMemoryError
    //   187	240	297	java/lang/OutOfMemoryError
    //   244	297	297	java/lang/OutOfMemoryError
    //   432	440	297	java/lang/OutOfMemoryError
    //   444	450	297	java/lang/OutOfMemoryError
    //   459	469	297	java/lang/OutOfMemoryError
    //   731	763	297	java/lang/OutOfMemoryError
    //   767	778	297	java/lang/OutOfMemoryError
    //   459	469	725	java/lang/Exception
    //   118	129	827	java/lang/OutOfMemoryError
    //   132	145	827	java/lang/OutOfMemoryError
    //   148	166	827	java/lang/OutOfMemoryError
    //   472	492	832	java/lang/OutOfMemoryError
    //   472	492	837	java/lang/Exception
  }
  
  protected RoundRectBitmap resizeAndClipBitmap(Bitmap paramBitmap, DownloadParams paramDownloadParams)
  {
    for (;;)
    {
      float f3;
      int j;
      int n;
      int k;
      int i1;
      try
      {
        f3 = this.application.getResources().getDisplayMetrics().density;
        int m = this.application.getResources().getDisplayMetrics().densityDpi;
        boolean bool = bkkh.a(paramDownloadParams.mImgType);
        j = CommonImgThumbHelper.getImgThumbMinPx(bool);
        i = CommonImgThumbHelper.getImgThumbMaxPx(bool);
        n = paramBitmap.getWidth();
        k = paramBitmap.getHeight();
        paramDownloadParams = new Paint(1);
        paramDownloadParams.setColor(-16777216);
        i1 = CommonImgThumbHelper.getImgThumbMaxDp(bool);
        int i2 = CommonImgThumbHelper.getImgThumbMinDp(bool);
        if ((n >= i2) && (k >= i2)) {
          break label362;
        }
        if (n < k)
        {
          k = (int)(j / n * k + 0.5F);
          if (k <= i) {
            break label333;
          }
          Bitmap localBitmap = Bitmap.createBitmap(j, i, URLDrawableHelper.mThumbConfig);
          localBitmap.setDensity(m);
          new Canvas(localBitmap).drawBitmap(paramBitmap, null, new Rect(0, 0, j, i), paramDownloadParams);
          return new RoundRectBitmap(localBitmap, 12.0F * f3);
        }
        k = (int)(j / k * n + 0.5F);
        if (k <= i) {
          break label355;
        }
      }
      catch (OutOfMemoryError paramDownloadParams)
      {
        float f1;
        float f2;
        return new RoundRectBitmap(paramBitmap, 12.0F);
      }
      if (n > k)
      {
        f1 = i / n;
        if (n > k)
        {
          f2 = j / k;
          f1 = Math.max(f1, f2);
          j = (int)(n * f1 + 0.5F);
          i = (int)(f1 * k + 0.5F);
        }
      }
      else
      {
        f1 = i / k;
        continue;
      }
      f2 = j / n;
      continue;
      label333:
      int i = k;
      continue;
      for (;;)
      {
        k = i;
        i = j;
        j = k;
        break;
        label355:
        i = k;
      }
      label362:
      if ((n < i1) && (k < i1))
      {
        j = (int)(n * f3 + 0.5F);
        i = (int)(k * f3 + 0.5F);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.AbstractImageDownloader
 * JD-Core Version:    0.7.0.1
 */