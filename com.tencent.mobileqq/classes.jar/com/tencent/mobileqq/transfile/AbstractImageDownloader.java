package com.tencent.mobileqq.transfile;

import android.app.Application;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.DownloadParams;
import com.tencent.image.RoundRectBitmap;
import com.tencent.image.Utils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.pic.PicDownloadInfo;
import com.tencent.mobileqq.pic.PicPreDownloader;
import com.tencent.mobileqq.pic.PicUiInterface;
import com.tencent.mobileqq.pic.PicUploadInfo;
import com.tencent.mobileqq.pic.PreDownloadStrategyBeta;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.peak.PeakUtils;
import java.io.File;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import mqq.app.AccountNotMatchException;

public abstract class AbstractImageDownloader
  extends AbsDownloader
{
  public static int a;
  public static int b;
  private static int c = 1048576;
  private static int d = c * 2;
  protected BaseApplicationImpl a;
  protected String a;
  
  public AbstractImageDownloader(String paramString, BaseApplicationImpl paramBaseApplicationImpl)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl = paramBaseApplicationImpl;
  }
  
  public static int a(Application paramApplication, int paramInt)
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
  
  public static int a(BitmapFactory.Options paramOptions, int paramInt1, int paramInt2)
  {
    return Utils.calculateInSampleSize(paramOptions, paramInt1, paramInt2);
  }
  
  private RoundRectBitmap a(Bitmap paramBitmap, DownloadParams paramDownloadParams)
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
        f3 = this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getResources().getDisplayMetrics().density;
        int m = this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getResources().getDisplayMetrics().densityDpi;
        boolean bool = PeakUtils.a(paramDownloadParams.mImgType);
        j = URLDrawableHelper.b(bool);
        i = URLDrawableHelper.a(bool);
        n = paramBitmap.getWidth();
        k = paramBitmap.getHeight();
        paramDownloadParams = new Paint(1);
        paramDownloadParams.setColor(-16777216);
        i1 = URLDrawableHelper.c(bool);
        int i2 = URLDrawableHelper.d(bool);
        if ((n >= i2) && (k >= i2)) {
          break label355;
        }
        if (n < k)
        {
          k = (int)(j / n * k + 0.5F);
          if (k <= i) {
            break label326;
          }
          Bitmap localBitmap = Bitmap.createBitmap(j, i, URLDrawableHelper.b);
          localBitmap.setDensity(m);
          new Canvas(localBitmap).drawBitmap(paramBitmap, null, new Rect(0, 0, j, i), paramDownloadParams);
          return new RoundRectBitmap(localBitmap, 12.0F * f3);
        }
        k = (int)(j / k * n + 0.5F);
        if (k <= i) {
          break label348;
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
      label326:
      int i = k;
      continue;
      for (;;)
      {
        k = i;
        i = j;
        j = k;
        break;
        label348:
        i = k;
      }
      label355:
      if ((n < i1) && (k < i1))
      {
        j = (int)(n * f3 + 0.5F);
        i = (int)(k * f3 + 0.5F);
      }
    }
  }
  
  public static String a(Exception paramException)
  {
    int i = 8;
    if (paramException == null) {
      return "Exception e is null,holy shit";
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
  
  private void a(Application paramApplication, String paramString1, int paramInt1, String paramString2, int paramInt2)
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
      StatisticCollector.a(BaseApplication.getContext()).a(paramApplication, paramString1, bool, 0L, 0L, paramString2, "");
      return;
      boolean bool = false;
      continue;
      paramApplication = paramString2;
      if (paramInt2 == 0) {
        bool = true;
      }
    }
  }
  
  private void a(Application paramApplication, String paramString, int paramInt, boolean paramBoolean)
  {
    int i = 0;
    paramInt *= 4;
    try
    {
      if (paramInt < c)
      {
        paramInt = i;
        if (!paramBoolean) {
          break label182;
        }
        paramInt = 1;
      }
      for (;;)
      {
        paramApplication = (QQAppInterface)BaseApplicationImpl.getApplication().getAppRuntime(paramString);
        paramString = new HashMap();
        paramString.put("param_FailCode", Integer.toString(paramInt + 88050));
        StatisticCollector.a(BaseApplication.getContext()).a(paramApplication.getCurrentAccountUin(), "report_aio_photo_size", false, 0L, 0L, paramString, "");
        return;
        paramInt /= d;
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
  
  private void a(DownloadParams paramDownloadParams)
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
      ((QQAppInterface)localObject).a().a.b(localMessageForPic, localMessageForPic.size);
      ((QQAppInterface)localObject).a().f();
      return;
    }
    catch (AccountNotMatchException localAccountNotMatchException)
    {
      a(paramDownloadParams, "payPicFlow", "FAIL,exceptionmsg:" + localAccountNotMatchException);
    }
  }
  
  private void a(DownloadParams paramDownloadParams, File paramFile, String paramString1, BitmapFactory.Options paramOptions, int paramInt, boolean paramBoolean, String paramString2)
  {
    if (paramBoolean) {
      if (QLog.isColorLevel()) {
        a(paramDownloadParams, "DecodeFile", "DecodeFile SUCCESS,retryCount=" + paramInt + ",options.inSampleSize=" + paramOptions.inSampleSize + ",cacheFile=" + paramFile.getAbsolutePath() + ",url=" + paramString1 + ",extraMsg=" + paramString2);
      }
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    a(paramDownloadParams, "DecodeFile", "DecodeFile FAIL,retryCount=" + paramInt + ",options.inSampleSize=" + paramOptions.inSampleSize + ",cacheFile=" + paramFile.getAbsolutePath() + ",url=" + paramString1 + ",extraMsg=" + paramString2);
  }
  
  public static void a(AbstractImageDownloader.ReportData paramReportData, boolean paramBoolean, int paramInt1, int paramInt2, String paramString, FileMsg.StepBaseInfo paramStepBaseInfo1, FileMsg.StepBaseInfo paramStepBaseInfo2, FileMsg.StepTransInfo paramStepTransInfo)
  {
    System.currentTimeMillis();
    long l1;
    if (paramStepTransInfo != null)
    {
      l1 = paramStepTransInfo.e;
      if (paramStepTransInfo == null) {
        break label42;
      }
    }
    label42:
    for (long l2 = paramStepTransInfo.f;; l2 = 0L)
    {
      if (!RichMediaStrategy.b(paramInt2)) {
        break label48;
      }
      return;
      l1 = 0L;
      break;
    }
    label48:
    HashMap localHashMap = new HashMap();
    String str2;
    String str1;
    if (!BaseTransProcessor.a(paramInt2, localHashMap))
    {
      localHashMap.put("param_FailCode", Integer.toString(paramInt2));
      if ((paramInt2 == -9527) || (paramInt2 == 9311) || (paramInt2 == 9044) || (paramInt2 == 9350) || (paramInt2 == 9351))
      {
        localHashMap.put(BaseTransProcessor.k, paramString);
        str2 = "";
        if ((!paramBoolean) || (paramStepBaseInfo1 != null) || (paramStepBaseInfo2 != null) || (paramStepTransInfo != null)) {
          break label472;
        }
        str1 = "1_-1_0_0_0;2_-1_0_0_0;3_-1_0_0_0";
        label152:
        if (QLog.isColorLevel()) {
          QLog.d("reportResult", 2, "parmStep: " + str1);
        }
        localHashMap.put("param_step", str1);
        localHashMap.put("param_uuid", paramReportData.f);
        localHashMap.put("flow", String.valueOf(l1));
        localHashMap.put("msgTime", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(paramReportData.jdField_a_of_type_Long * 1000L)));
        localHashMap.put("client_exist", String.valueOf(paramReportData.jdField_a_of_type_Boolean));
        if (paramStepBaseInfo2 != null) {
          localHashMap.put("param_RequestUrl", paramStepBaseInfo2.a());
        }
        if (paramStepTransInfo != null) {
          localHashMap.put("param_HttpTran", paramStepTransInfo.a());
        }
        if (paramStepTransInfo != null)
        {
          localHashMap.put("param_retry", String.valueOf(paramStepTransInfo.jdField_b_of_type_Int));
          if (!paramStepTransInfo.jdField_a_of_type_Boolean) {
            break label553;
          }
          localHashMap.put("serverip", paramStepTransInfo.jdField_b_of_type_JavaLangString);
          localHashMap.put("param_Server", paramStepTransInfo.jdField_b_of_type_JavaLangString);
        }
        label373:
        if (!paramBoolean) {
          break label621;
        }
        if ((!paramReportData.c.equals("actC2CPicDownloadV1")) && (!paramReportData.c.equals("actC2CPicSmallDownV1"))) {
          break label605;
        }
        localHashMap.put("param_toUin", paramReportData.jdField_a_of_type_JavaLangString);
      }
    }
    for (;;)
    {
      StatisticCollector.a(BaseApplication.getContext()).a(null, paramReportData.c, true, paramInt1, l1, localHashMap, "");
      return;
      localHashMap.put("param_errorDesc", paramString);
      break;
      paramInt2 = -9527;
      localHashMap.put("param_errorDesc", paramString);
      break;
      label472:
      str1 = str2;
      if (paramStepBaseInfo1 == null) {
        break label152;
      }
      str1 = str2;
      if (paramStepBaseInfo2 == null) {
        break label152;
      }
      str1 = str2;
      if (paramStepTransInfo == null) {
        break label152;
      }
      str1 = paramStepBaseInfo1.a(1) + ";" + paramStepBaseInfo2.a(2) + ";" + paramStepTransInfo.a(3);
      break label152;
      label553:
      localHashMap.put("serverip", paramStepTransInfo.c);
      localHashMap.put("param_Server", paramStepTransInfo.c);
      if (paramInt2 != -9527) {
        break label373;
      }
      localHashMap.put("param_rspHeader", paramStepTransInfo.d);
      break label373;
      label605:
      localHashMap.put("param_grpUin", paramReportData.jdField_a_of_type_JavaLangString);
    }
    label621:
    if (paramInt2 == 9301) {
      localHashMap.put("param_connecttrycount", paramString);
    }
    if ((paramReportData.g != null) && (!paramReportData.g.equals(""))) {
      localHashMap.put("param_MsgTime", paramReportData.g);
    }
    long l3 = paramInt1;
    if ((paramReportData.c.equals("actC2CPicDownloadV1")) || (paramReportData.c.equals("actC2CPicSmallDownV1")))
    {
      localHashMap.put("param_toUin", paramReportData.jdField_a_of_type_JavaLangString);
      localHashMap.put("param_url", paramReportData.e);
      localHashMap.put("param_fsized", l1 + "");
      localHashMap.put("param_fsizeo", l2 + "");
    }
    for (;;)
    {
      StatisticCollector.a(BaseApplication.getContext()).a(null, paramReportData.c, false, 0L, 0L, localHashMap, "");
      return;
      localHashMap.put("param_grpUin", paramReportData.jdField_a_of_type_JavaLangString);
      localHashMap.put("param_url", paramReportData.e);
      localHashMap.put("param_fsized", l1 + "");
      localHashMap.put("param_fsizeo", l2 + "");
    }
  }
  
  /* Error */
  protected static void a(java.io.OutputStream paramOutputStream, File paramFile, com.tencent.image.URLDrawableHandler paramURLDrawableHandler)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 454	java/io/File:length	()J
    //   4: lstore 6
    //   6: new 456	java/io/FileInputStream
    //   9: dup
    //   10: aload_1
    //   11: invokespecial 459	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   14: astore_1
    //   15: lconst_0
    //   16: lstore 4
    //   18: sipush 8192
    //   21: newarray byte
    //   23: astore 8
    //   25: aload_1
    //   26: aload 8
    //   28: invokevirtual 463	java/io/FileInputStream:read	([B)I
    //   31: istore_3
    //   32: iload_3
    //   33: iconst_m1
    //   34: if_icmpeq +94 -> 128
    //   37: aload_0
    //   38: aload 8
    //   40: iconst_0
    //   41: iload_3
    //   42: invokevirtual 469	java/io/OutputStream:write	([BII)V
    //   45: aload_0
    //   46: invokevirtual 472	java/io/OutputStream:flush	()V
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
    //   64: ldc_w 473
    //   67: fmul
    //   68: f2i
    //   69: invokeinterface 478 2 0
    //   74: goto -49 -> 25
    //   77: astore_2
    //   78: aload_1
    //   79: astore_0
    //   80: aload_2
    //   81: invokevirtual 479	java/io/IOException:getMessage	()Ljava/lang/String;
    //   84: ldc_w 481
    //   87: invokevirtual 485	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   90: ifeq +47 -> 137
    //   93: new 487	com/tencent/mobileqq/transfile/FileDownloadFailedException
    //   96: dup
    //   97: sipush 9040
    //   100: ldc2_w 488
    //   103: aload_2
    //   104: invokevirtual 479	java/io/IOException:getMessage	()Ljava/lang/String;
    //   107: iconst_0
    //   108: iconst_0
    //   109: invokespecial 492	com/tencent/mobileqq/transfile/FileDownloadFailedException:<init>	(IJLjava/lang/String;ZZ)V
    //   112: athrow
    //   113: astore_2
    //   114: aload_0
    //   115: astore_1
    //   116: aload_2
    //   117: astore_0
    //   118: aload_1
    //   119: ifnull +7 -> 126
    //   122: aload_1
    //   123: invokevirtual 495	java/io/FileInputStream:close	()V
    //   126: aload_0
    //   127: athrow
    //   128: aload_1
    //   129: ifnull +7 -> 136
    //   132: aload_1
    //   133: invokevirtual 495	java/io/FileInputStream:close	()V
    //   136: return
    //   137: new 487	com/tencent/mobileqq/transfile/FileDownloadFailedException
    //   140: dup
    //   141: sipush 9301
    //   144: ldc2_w 496
    //   147: aload_2
    //   148: invokevirtual 479	java/io/IOException:getMessage	()Ljava/lang/String;
    //   151: iconst_0
    //   152: iconst_0
    //   153: invokespecial 492	com/tencent/mobileqq/transfile/FileDownloadFailedException:<init>	(IJLjava/lang/String;ZZ)V
    //   156: athrow
    //   157: astore_0
    //   158: aconst_null
    //   159: astore_1
    //   160: goto -42 -> 118
    //   163: astore_0
    //   164: goto -46 -> 118
    //   167: astore_2
    //   168: aconst_null
    //   169: astore_0
    //   170: goto -90 -> 80
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	173	0	paramOutputStream	java.io.OutputStream
    //   0	173	1	paramFile	File
    //   0	173	2	paramURLDrawableHandler	com.tencent.image.URLDrawableHandler
    //   31	21	3	i	int
    //   16	42	4	l1	long
    //   4	57	6	l2	long
    //   23	16	8	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   18	25	77	java/io/IOException
    //   25	32	77	java/io/IOException
    //   37	49	77	java/io/IOException
    //   56	74	77	java/io/IOException
    //   80	113	113	finally
    //   137	157	113	finally
    //   6	15	157	finally
    //   18	25	163	finally
    //   25	32	163	finally
    //   37	49	163	finally
    //   56	74	163	finally
    //   6	15	167	java/io/IOException
  }
  
  private void a(Object paramObject, String paramString1, String paramString2)
  {
    if ((paramObject instanceof DownloadParams))
    {
      localObject = (DownloadParams)paramObject;
      if ((((DownloadParams)localObject).tag instanceof PicUiInterface))
      {
        paramObject = (PicUiInterface)((DownloadParams)localObject).tag;
        localObject = ((DownloadParams)localObject).url.getProtocol();
        if (paramObject.isSendFromLocal())
        {
          i = RichMediaUtil.a(URLDrawableHelper.a((String)localObject, false));
          paramObject = paramObject.getPicUploadInfo();
          RichMediaUtil.a(paramObject.jdField_b_of_type_Int, false, i, String.valueOf(paramObject.jdField_a_of_type_Long), paramString1, paramString2);
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
        i = RichMediaUtil.a(URLDrawableHelper.a((String)localObject, bool));
        RichMediaUtil.a(paramObject.jdField_b_of_type_Int, false, i, String.valueOf(paramObject.jdField_a_of_type_Long), paramString1, paramString2);
        return;
      }
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("obj").append(paramObject);
    ((StringBuilder)localObject).append(" \tstep:").append(paramString1);
    ((StringBuilder)localObject).append(" \tcontent:").append(paramString2);
    QLog.d("Q.richmedia.", 2, ((StringBuilder)localObject).toString());
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, int paramInt1, int paramInt2, String paramString, boolean paramBoolean5)
  {
    if (paramInt2 == 3)
    {
      paramInt2 = paramInt1 - 1;
      if (paramInt1 != 1) {
        break label51;
      }
      a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, "big_img_decode", 0, paramString, paramInt2);
      a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, "big_img_decode_long", 0, paramString, paramInt2);
    }
    label51:
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
            a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, "big_img_decode", -1, paramString, paramInt2);
            if (!paramBoolean2) {
              break label159;
            }
            a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, "big_img_decode_long", 3, paramString, paramInt2);
          }
        }
        for (;;)
        {
          if (!paramBoolean2) {
            break label176;
          }
          a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, "big_img_decode_slice", 0, paramString, paramInt2);
          return;
          a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, "big_img_decode", 2, paramString, paramInt2);
          break;
          a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, "big_img_decode", 1, paramString, paramInt2);
          break;
          a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, "big_img_decode_long", 4, paramString, paramInt2);
        }
      }
      if (paramBoolean1) {
        a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, "big_img_decode", 5, paramString, paramInt2);
      }
      if (paramBoolean2) {
        a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, "big_img_decode_long", 6, paramString, paramInt2);
      }
    } while (!paramBoolean4);
    label159:
    label176:
    a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, "big_img_decode_slice", 6, paramString, paramInt2);
  }
  
  /* Error */
  public Object decodeFile(File paramFile, DownloadParams paramDownloadParams, com.tencent.image.URLDrawableHandler paramURLDrawableHandler)
  {
    // Byte code:
    //   0: invokestatic 275	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +34 -> 37
    //   6: aload_0
    //   7: aload_2
    //   8: ldc_w 277
    //   11: new 158	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 175	java/lang/StringBuilder:<init>	()V
    //   18: ldc_w 561
    //   21: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: aload_2
    //   25: getfield 233	com/tencent/image/DownloadParams:tag	Ljava/lang/Object;
    //   28: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   31: invokevirtual 177	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   34: invokespecial 268	com/tencent/mobileqq/transfile/AbstractImageDownloader:a	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
    //   37: aload_2
    //   38: getfield 564	com/tencent/image/DownloadParams:urlStr	Ljava/lang/String;
    //   41: astore 17
    //   43: aload_2
    //   44: getfield 503	com/tencent/image/DownloadParams:url	Ljava/net/URL;
    //   47: astore 15
    //   49: aload 15
    //   51: invokevirtual 508	java/net/URL:getProtocol	()Ljava/lang/String;
    //   54: astore_3
    //   55: ldc_w 566
    //   58: aload_3
    //   59: invokevirtual 411	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   62: ifne +2015 -> 2077
    //   65: ldc_w 568
    //   68: aload_3
    //   69: invokevirtual 411	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   72: ifeq +168 -> 240
    //   75: goto +2002 -> 2077
    //   78: invokestatic 275	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   81: ifeq +45 -> 126
    //   84: aload_0
    //   85: aload_2
    //   86: ldc_w 277
    //   89: new 158	java/lang/StringBuilder
    //   92: dup
    //   93: invokespecial 175	java/lang/StringBuilder:<init>	()V
    //   96: ldc_w 570
    //   99: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: aload_1
    //   103: invokevirtual 296	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   106: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: ldc_w 298
    //   112: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: aload 17
    //   117: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: invokevirtual 177	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   123: invokespecial 268	com/tencent/mobileqq/transfile/AbstractImageDownloader:a	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
    //   126: new 286	android/graphics/BitmapFactory$Options
    //   129: dup
    //   130: invokespecial 571	android/graphics/BitmapFactory$Options:<init>	()V
    //   133: astore 18
    //   135: aload 18
    //   137: getstatic 573	com/tencent/mobileqq/transfile/URLDrawableHelper:jdField_a_of_type_AndroidGraphicsBitmap$Config	Landroid/graphics/Bitmap$Config;
    //   140: putfield 576	android/graphics/BitmapFactory$Options:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   143: aload 18
    //   145: sipush 160
    //   148: putfield 579	android/graphics/BitmapFactory$Options:inDensity	I
    //   151: aload 18
    //   153: sipush 160
    //   156: putfield 582	android/graphics/BitmapFactory$Options:inTargetDensity	I
    //   159: aload 18
    //   161: sipush 160
    //   164: putfield 585	android/graphics/BitmapFactory$Options:inScreenDensity	I
    //   167: aload 18
    //   169: iconst_1
    //   170: putfield 588	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   173: aload_1
    //   174: invokestatic 594	com/tencent/image/GifDrawable:isGifFile	(Ljava/io/File;)Z
    //   177: ifeq +69 -> 246
    //   180: iload 4
    //   182: ifne +64 -> 246
    //   185: aload_0
    //   186: aload_2
    //   187: invokespecial 596	com/tencent/mobileqq/transfile/AbstractImageDownloader:a	(Lcom/tencent/image/DownloadParams;)V
    //   190: invokestatic 275	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   193: ifeq +45 -> 238
    //   196: aload_0
    //   197: aload_2
    //   198: ldc_w 277
    //   201: new 158	java/lang/StringBuilder
    //   204: dup
    //   205: invokespecial 175	java/lang/StringBuilder:<init>	()V
    //   208: ldc_w 598
    //   211: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   214: aload_1
    //   215: invokevirtual 296	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   218: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   221: ldc_w 298
    //   224: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   227: aload 17
    //   229: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   232: invokevirtual 177	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   235: invokespecial 268	com/tencent/mobileqq/transfile/AbstractImageDownloader:a	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
    //   238: aconst_null
    //   239: areturn
    //   240: iconst_0
    //   241: istore 4
    //   243: goto -165 -> 78
    //   246: iload 4
    //   248: ifeq +877 -> 1125
    //   251: iconst_0
    //   252: istore 4
    //   254: aload 18
    //   256: getstatic 110	com/tencent/mobileqq/transfile/URLDrawableHelper:b	Landroid/graphics/Bitmap$Config;
    //   259: putfield 576	android/graphics/BitmapFactory$Options:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   262: aload 18
    //   264: iconst_0
    //   265: putfield 588	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   268: aload_1
    //   269: invokevirtual 601	java/io/File:getName	()Ljava/lang/String;
    //   272: astore_3
    //   273: aload_3
    //   274: ldc_w 603
    //   277: invokevirtual 607	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   280: ifne +382 -> 662
    //   283: aload_1
    //   284: invokevirtual 296	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   287: astore 15
    //   289: new 158	java/lang/StringBuilder
    //   292: dup
    //   293: invokespecial 175	java/lang/StringBuilder:<init>	()V
    //   296: aload_3
    //   297: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   300: ldc_w 603
    //   303: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   306: invokevirtual 177	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   309: astore_3
    //   310: new 293	java/io/File
    //   313: dup
    //   314: getstatic 610	com/tencent/mobileqq/transfile/URLDrawableHelper:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   317: aload_3
    //   318: invokespecial 613	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   321: astore_3
    //   322: aload_3
    //   323: invokevirtual 616	java/io/File:exists	()Z
    //   326: istore 9
    //   328: iload 9
    //   330: ifeq +56 -> 386
    //   333: iconst_1
    //   334: istore 4
    //   336: invokestatic 275	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   339: ifeq +45 -> 384
    //   342: aload_0
    //   343: aload_2
    //   344: ldc_w 277
    //   347: new 158	java/lang/StringBuilder
    //   350: dup
    //   351: invokespecial 175	java/lang/StringBuilder:<init>	()V
    //   354: ldc_w 618
    //   357: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   360: aload_3
    //   361: invokevirtual 296	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   364: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   367: ldc_w 620
    //   370: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   373: aload 17
    //   375: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   378: invokevirtual 177	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   381: invokespecial 268	com/tencent/mobileqq/transfile/AbstractImageDownloader:a	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
    //   384: aload_3
    //   385: astore_1
    //   386: aload 15
    //   388: astore_3
    //   389: aload_1
    //   390: invokevirtual 296	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   393: aload 18
    //   395: invokestatic 625	com/tencent/image/SafeBitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   398: astore 15
    //   400: aload 15
    //   402: astore 16
    //   404: aload 15
    //   406: ifnonnull +170 -> 576
    //   409: aload 15
    //   411: astore 16
    //   413: iload 4
    //   415: ifeq +161 -> 576
    //   418: aload_3
    //   419: invokestatic 629	com/tencent/mobileqq/utils/FileUtils:a	(Ljava/lang/String;)Z
    //   422: istore 9
    //   424: iload 9
    //   426: ifeq +74 -> 500
    //   429: aload_3
    //   430: aload 18
    //   432: invokestatic 625	com/tencent/image/SafeBitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   435: astore 16
    //   437: aload 16
    //   439: astore 15
    //   441: aload 16
    //   443: ifnonnull +57 -> 500
    //   446: aload_3
    //   447: invokestatic 634	com/tencent/open/base/MD5Utils:a	(Ljava/lang/String;)Ljava/lang/String;
    //   450: astore 19
    //   452: aload_3
    //   453: invokestatic 636	com/tencent/mobileqq/utils/FileUtils:d	(Ljava/lang/String;)Z
    //   456: pop
    //   457: aload 16
    //   459: astore 15
    //   461: invokestatic 275	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   464: ifeq +36 -> 500
    //   467: aload_0
    //   468: aload_2
    //   469: ldc_w 277
    //   472: new 158	java/lang/StringBuilder
    //   475: dup
    //   476: invokespecial 175	java/lang/StringBuilder:<init>	()V
    //   479: ldc_w 638
    //   482: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   485: aload 19
    //   487: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   490: invokevirtual 177	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   493: invokespecial 268	com/tencent/mobileqq/transfile/AbstractImageDownloader:a	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
    //   496: aload 16
    //   498: astore 15
    //   500: aload 15
    //   502: astore 16
    //   504: invokestatic 275	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   507: ifeq +69 -> 576
    //   510: new 158	java/lang/StringBuilder
    //   513: dup
    //   514: invokespecial 175	java/lang/StringBuilder:<init>	()V
    //   517: ldc_w 640
    //   520: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   523: aload_3
    //   524: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   527: ldc_w 642
    //   530: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   533: iload 9
    //   535: invokevirtual 645	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   538: ldc_w 647
    //   541: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   544: astore 16
    //   546: aload 15
    //   548: ifnull +155 -> 703
    //   551: iconst_1
    //   552: istore 9
    //   554: aload_0
    //   555: aload_2
    //   556: ldc_w 277
    //   559: aload 16
    //   561: iload 9
    //   563: invokevirtual 645	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   566: invokevirtual 177	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   569: invokespecial 268	com/tencent/mobileqq/transfile/AbstractImageDownloader:a	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
    //   572: aload 15
    //   574: astore 16
    //   576: aload 16
    //   578: ifnull +255 -> 833
    //   581: iload 4
    //   583: ifeq +8 -> 591
    //   586: aload_3
    //   587: invokestatic 636	com/tencent/mobileqq/utils/FileUtils:d	(Ljava/lang/String;)Z
    //   590: pop
    //   591: aload 16
    //   593: astore_3
    //   594: aload_2
    //   595: getfield 651	com/tencent/image/DownloadParams:mDecodeHandler	Lcom/tencent/image/DownloadParams$DecodeHandler;
    //   598: ifnull +16 -> 614
    //   601: aload_2
    //   602: getfield 651	com/tencent/image/DownloadParams:mDecodeHandler	Lcom/tencent/image/DownloadParams$DecodeHandler;
    //   605: aload_2
    //   606: aload 16
    //   608: invokeinterface 657 3 0
    //   613: astore_3
    //   614: aload_2
    //   615: getfield 233	com/tencent/image/DownloadParams:tag	Ljava/lang/Object;
    //   618: ifnull +91 -> 709
    //   621: aload_2
    //   622: getfield 233	com/tencent/image/DownloadParams:tag	Ljava/lang/Object;
    //   625: instanceof 235
    //   628: ifeq +81 -> 709
    //   631: aload_2
    //   632: getfield 233	com/tencent/image/DownloadParams:tag	Ljava/lang/Object;
    //   635: checkcast 235	com/tencent/mobileqq/data/MessageForPic
    //   638: getfield 660	com/tencent/mobileqq/data/MessageForPic:subMsgType	I
    //   641: iconst_2
    //   642: if_icmpeq +18 -> 660
    //   645: aload 17
    //   647: ldc_w 662
    //   650: invokevirtual 607	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   653: istore 9
    //   655: iload 9
    //   657: ifeq +52 -> 709
    //   660: aload_3
    //   661: areturn
    //   662: aload_3
    //   663: invokevirtual 664	java/lang/String:length	()I
    //   666: iconst_3
    //   667: if_icmple +1401 -> 2068
    //   670: aload_3
    //   671: iconst_0
    //   672: aload_3
    //   673: invokevirtual 664	java/lang/String:length	()I
    //   676: iconst_3
    //   677: isub
    //   678: invokevirtual 668	java/lang/String:substring	(II)Ljava/lang/String;
    //   681: astore_3
    //   682: new 293	java/io/File
    //   685: dup
    //   686: getstatic 610	com/tencent/mobileqq/transfile/URLDrawableHelper:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   689: aload_3
    //   690: invokespecial 613	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   693: invokevirtual 296	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   696: astore_3
    //   697: iconst_1
    //   698: istore 4
    //   700: goto -311 -> 389
    //   703: iconst_0
    //   704: istore 9
    //   706: goto -152 -> 554
    //   709: aload_0
    //   710: aload_3
    //   711: aload_2
    //   712: invokespecial 670	com/tencent/mobileqq/transfile/AbstractImageDownloader:a	(Landroid/graphics/Bitmap;Lcom/tencent/image/DownloadParams;)Lcom/tencent/image/RoundRectBitmap;
    //   715: astore 15
    //   717: aload_3
    //   718: aload 15
    //   720: getfield 674	com/tencent/image/RoundRectBitmap:mBitmap	Landroid/graphics/Bitmap;
    //   723: invokevirtual 677	java/lang/Object:equals	(Ljava/lang/Object;)Z
    //   726: ifne +7 -> 733
    //   729: aload_3
    //   730: invokevirtual 680	android/graphics/Bitmap:recycle	()V
    //   733: new 133	com/tencent/image/RoundRectBitmap
    //   736: dup
    //   737: new 682	com/tencent/mobileqq/transfile/bitmapcreator/ExifBitmapCreator
    //   740: dup
    //   741: aload_1
    //   742: invokevirtual 296	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   745: invokespecial 683	com/tencent/mobileqq/transfile/bitmapcreator/ExifBitmapCreator:<init>	(Ljava/lang/String;)V
    //   748: aload 15
    //   750: getfield 674	com/tencent/image/RoundRectBitmap:mBitmap	Landroid/graphics/Bitmap;
    //   753: invokevirtual 686	com/tencent/mobileqq/transfile/bitmapcreator/ExifBitmapCreator:a	(Landroid/graphics/Bitmap;)Landroid/graphics/Bitmap;
    //   756: aload 15
    //   758: getfield 689	com/tencent/image/RoundRectBitmap:mCornerRadius	F
    //   761: aload 15
    //   763: getfield 692	com/tencent/image/RoundRectBitmap:mBoardColor	I
    //   766: aload 15
    //   768: getfield 695	com/tencent/image/RoundRectBitmap:mBorderWidth	F
    //   771: invokespecial 698	com/tencent/image/RoundRectBitmap:<init>	(Landroid/graphics/Bitmap;FIF)V
    //   774: astore_3
    //   775: aload_0
    //   776: getfield 27	com/tencent/mobileqq/transfile/AbstractImageDownloader:jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl	Lcom/tencent/common/app/BaseApplicationImpl;
    //   779: ifnull +37 -> 816
    //   782: aload_3
    //   783: aload_0
    //   784: getfield 27	com/tencent/mobileqq/transfile/AbstractImageDownloader:jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl	Lcom/tencent/common/app/BaseApplicationImpl;
    //   787: invokevirtual 64	com/tencent/common/app/BaseApplicationImpl:getResources	()Landroid/content/res/Resources;
    //   790: invokevirtual 40	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   793: getfield 701	android/util/DisplayMetrics:widthPixels	I
    //   796: putfield 704	com/tencent/image/RoundRectBitmap:mDisplayWidth	I
    //   799: aload_3
    //   800: aload_0
    //   801: getfield 27	com/tencent/mobileqq/transfile/AbstractImageDownloader:jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl	Lcom/tencent/common/app/BaseApplicationImpl;
    //   804: invokevirtual 64	com/tencent/common/app/BaseApplicationImpl:getResources	()Landroid/content/res/Resources;
    //   807: invokevirtual 40	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   810: getfield 707	android/util/DisplayMetrics:heightPixels	I
    //   813: putfield 710	com/tencent/image/RoundRectBitmap:mDisplayHeight	I
    //   816: aload_0
    //   817: aload_2
    //   818: aload_1
    //   819: aload 17
    //   821: aload 18
    //   823: iconst_1
    //   824: iconst_1
    //   825: ldc_w 712
    //   828: invokespecial 714	com/tencent/mobileqq/transfile/AbstractImageDownloader:a	(Lcom/tencent/image/DownloadParams;Ljava/io/File;Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;IZLjava/lang/String;)V
    //   831: aload_3
    //   832: areturn
    //   833: aload_2
    //   834: getfield 233	com/tencent/image/DownloadParams:tag	Ljava/lang/Object;
    //   837: checkcast 499	com/tencent/mobileqq/pic/PicUiInterface
    //   840: invokeinterface 511 1 0
    //   845: ifne +99 -> 944
    //   848: aload_1
    //   849: invokevirtual 296	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   852: invokestatic 634	com/tencent/open/base/MD5Utils:a	(Ljava/lang/String;)Ljava/lang/String;
    //   855: astore_3
    //   856: aload_2
    //   857: getfield 233	com/tencent/image/DownloadParams:tag	Ljava/lang/Object;
    //   860: checkcast 499	com/tencent/mobileqq/pic/PicUiInterface
    //   863: invokeinterface 534 1 0
    //   868: astore 15
    //   870: new 158	java/lang/StringBuilder
    //   873: dup
    //   874: invokespecial 175	java/lang/StringBuilder:<init>	()V
    //   877: ldc_w 548
    //   880: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   883: aload 15
    //   885: getfield 539	com/tencent/mobileqq/pic/PicDownloadInfo:jdField_b_of_type_Int	I
    //   888: invokestatic 716	com/tencent/mobileqq/transfile/RichMediaUtil:b	(I)Ljava/lang/String;
    //   891: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   894: ldc_w 718
    //   897: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   900: invokevirtual 177	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   903: iconst_1
    //   904: new 158	java/lang/StringBuilder
    //   907: dup
    //   908: invokespecial 175	java/lang/StringBuilder:<init>	()V
    //   911: ldc_w 720
    //   914: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   917: aload 15
    //   919: getfield 540	com/tencent/mobileqq/pic/PicDownloadInfo:jdField_a_of_type_Long	J
    //   922: invokestatic 353	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   925: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   928: ldc_w 722
    //   931: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   934: aload_3
    //   935: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   938: invokevirtual 177	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   941: invokestatic 725	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   944: aload_1
    //   945: invokevirtual 728	java/io/File:delete	()Z
    //   948: pop
    //   949: aload_0
    //   950: aload_2
    //   951: aload_1
    //   952: aload 17
    //   954: aload 18
    //   956: iconst_1
    //   957: iconst_0
    //   958: ldc_w 730
    //   961: invokespecial 714	com/tencent/mobileqq/transfile/AbstractImageDownloader:a	(Lcom/tencent/image/DownloadParams;Ljava/io/File;Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;IZLjava/lang/String;)V
    //   964: new 451	java/io/IOException
    //   967: dup
    //   968: ldc_w 730
    //   971: invokespecial 731	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   974: athrow
    //   975: astore_3
    //   976: aload_0
    //   977: aload_2
    //   978: aload_1
    //   979: aload 17
    //   981: aload 18
    //   983: iconst_1
    //   984: iconst_0
    //   985: new 158	java/lang/StringBuilder
    //   988: dup
    //   989: invokespecial 175	java/lang/StringBuilder:<init>	()V
    //   992: ldc_w 733
    //   995: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   998: aload_3
    //   999: invokevirtual 734	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   1002: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1005: invokevirtual 177	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1008: invokespecial 714	com/tencent/mobileqq/transfile/AbstractImageDownloader:a	(Lcom/tencent/image/DownloadParams;Ljava/io/File;Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;IZLjava/lang/String;)V
    //   1011: aload_3
    //   1012: athrow
    //   1013: astore 15
    //   1015: aload 15
    //   1017: invokestatic 736	com/tencent/mobileqq/transfile/AbstractImageDownloader:a	(Ljava/lang/Exception;)Ljava/lang/String;
    //   1020: astore_3
    //   1021: aload_3
    //   1022: ifnull +12 -> 1034
    //   1025: aload_3
    //   1026: astore_1
    //   1027: aload_3
    //   1028: invokevirtual 664	java/lang/String:length	()I
    //   1031: ifne +9 -> 1040
    //   1034: aload 15
    //   1036: invokevirtual 176	java/lang/Exception:toString	()Ljava/lang/String;
    //   1039: astore_1
    //   1040: invokestatic 275	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1043: ifeq +40 -> 1083
    //   1046: aload_0
    //   1047: getfield 25	com/tencent/mobileqq/transfile/AbstractImageDownloader:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1050: iconst_2
    //   1051: aload_1
    //   1052: invokestatic 738	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1055: aload_0
    //   1056: aload_2
    //   1057: ldc_w 277
    //   1060: new 158	java/lang/StringBuilder
    //   1063: dup
    //   1064: invokespecial 175	java/lang/StringBuilder:<init>	()V
    //   1067: ldc_w 740
    //   1070: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1073: aload_1
    //   1074: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1077: invokevirtual 177	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1080: invokespecial 268	com/tencent/mobileqq/transfile/AbstractImageDownloader:a	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
    //   1083: new 195	java/util/HashMap
    //   1086: dup
    //   1087: invokespecial 196	java/util/HashMap:<init>	()V
    //   1090: astore_2
    //   1091: aload_2
    //   1092: ldc_w 742
    //   1095: aload_1
    //   1096: invokevirtual 208	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1099: pop
    //   1100: invokestatic 214	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1103: invokestatic 219	com/tencent/mobileqq/statistics/StatisticCollector:a	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   1106: aconst_null
    //   1107: ldc_w 744
    //   1110: iconst_0
    //   1111: ldc2_w 745
    //   1114: lconst_0
    //   1115: aload_2
    //   1116: ldc 221
    //   1118: iconst_1
    //   1119: invokevirtual 749	com/tencent/mobileqq/statistics/StatisticCollector:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
    //   1122: aload 15
    //   1124: athrow
    //   1125: aload_0
    //   1126: aload_2
    //   1127: invokespecial 596	com/tencent/mobileqq/transfile/AbstractImageDownloader:a	(Lcom/tencent/image/DownloadParams;)V
    //   1130: aload 18
    //   1132: iconst_1
    //   1133: putfield 588	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   1136: aload_1
    //   1137: invokevirtual 296	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   1140: aload 18
    //   1142: invokestatic 625	com/tencent/image/SafeBitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   1145: pop
    //   1146: aload 18
    //   1148: getfield 752	android/graphics/BitmapFactory$Options:outHeight	I
    //   1151: ifeq +11 -> 1162
    //   1154: aload 18
    //   1156: getfield 755	android/graphics/BitmapFactory$Options:outWidth	I
    //   1159: ifne +34 -> 1193
    //   1162: aload_1
    //   1163: invokevirtual 728	java/io/File:delete	()Z
    //   1166: pop
    //   1167: aload_0
    //   1168: aload_2
    //   1169: aload_1
    //   1170: aload 17
    //   1172: aload 18
    //   1174: iconst_1
    //   1175: iconst_0
    //   1176: ldc_w 757
    //   1179: invokespecial 714	com/tencent/mobileqq/transfile/AbstractImageDownloader:a	(Lcom/tencent/image/DownloadParams;Ljava/io/File;Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;IZLjava/lang/String;)V
    //   1182: new 451	java/io/IOException
    //   1185: dup
    //   1186: ldc_w 757
    //   1189: invokespecial 731	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   1192: athrow
    //   1193: aload 18
    //   1195: aload 18
    //   1197: aload_2
    //   1198: getfield 760	com/tencent/image/DownloadParams:reqWidth	I
    //   1201: aload_2
    //   1202: getfield 763	com/tencent/image/DownloadParams:reqHeight	I
    //   1205: invokestatic 765	com/tencent/mobileqq/transfile/AbstractImageDownloader:a	(Landroid/graphics/BitmapFactory$Options;II)I
    //   1208: putfield 289	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   1211: aload 18
    //   1213: getfield 755	android/graphics/BitmapFactory$Options:outWidth	I
    //   1216: istore 6
    //   1218: aload 18
    //   1220: getfield 752	android/graphics/BitmapFactory$Options:outHeight	I
    //   1223: istore 7
    //   1225: aload 18
    //   1227: iconst_0
    //   1228: putfield 588	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   1231: iconst_0
    //   1232: istore 9
    //   1234: aconst_null
    //   1235: astore_3
    //   1236: iconst_1
    //   1237: istore 5
    //   1239: aload 15
    //   1241: invokevirtual 508	java/net/URL:getProtocol	()Ljava/lang/String;
    //   1244: ldc_w 767
    //   1247: invokevirtual 411	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1250: ifne +63 -> 1313
    //   1253: aload 15
    //   1255: invokevirtual 508	java/net/URL:getProtocol	()Ljava/lang/String;
    //   1258: ldc_w 769
    //   1261: invokevirtual 411	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1264: ifne +49 -> 1313
    //   1267: aload 15
    //   1269: invokevirtual 508	java/net/URL:getProtocol	()Ljava/lang/String;
    //   1272: ldc_w 771
    //   1275: invokevirtual 411	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1278: ifne +35 -> 1313
    //   1281: aload 15
    //   1283: invokevirtual 508	java/net/URL:getProtocol	()Ljava/lang/String;
    //   1286: ldc_w 773
    //   1289: invokevirtual 411	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1292: ifne +21 -> 1313
    //   1295: aload 15
    //   1297: invokevirtual 508	java/net/URL:getProtocol	()Ljava/lang/String;
    //   1300: ldc_w 775
    //   1303: invokevirtual 411	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1306: istore 10
    //   1308: iload 10
    //   1310: ifeq +752 -> 2062
    //   1313: iconst_3
    //   1314: istore 4
    //   1316: iload 5
    //   1318: iload 4
    //   1320: if_icmpgt +731 -> 2051
    //   1323: aload_1
    //   1324: invokevirtual 296	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   1327: aload 18
    //   1329: invokestatic 625	com/tencent/image/SafeBitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   1332: astore 15
    //   1334: aload 15
    //   1336: astore_3
    //   1337: ldc_w 777
    //   1340: aload_2
    //   1341: getfield 780	com/tencent/image/DownloadParams:mExtraInfo	Ljava/lang/Object;
    //   1344: invokevirtual 411	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1347: ifeq +709 -> 2056
    //   1350: aload 15
    //   1352: astore_3
    //   1353: new 682	com/tencent/mobileqq/transfile/bitmapcreator/ExifBitmapCreator
    //   1356: dup
    //   1357: aload_1
    //   1358: invokevirtual 296	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   1361: invokespecial 683	com/tencent/mobileqq/transfile/bitmapcreator/ExifBitmapCreator:<init>	(Ljava/lang/String;)V
    //   1364: aload 15
    //   1366: invokevirtual 686	com/tencent/mobileqq/transfile/bitmapcreator/ExifBitmapCreator:a	(Landroid/graphics/Bitmap;)Landroid/graphics/Bitmap;
    //   1369: astore 15
    //   1371: aload 15
    //   1373: astore_3
    //   1374: aload_3
    //   1375: ifnonnull +258 -> 1633
    //   1378: iload 9
    //   1380: istore 10
    //   1382: invokestatic 275	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1385: ifeq +60 -> 1445
    //   1388: iload 9
    //   1390: istore 10
    //   1392: aload_0
    //   1393: aload_2
    //   1394: ldc_w 277
    //   1397: new 158	java/lang/StringBuilder
    //   1400: dup
    //   1401: invokespecial 175	java/lang/StringBuilder:<init>	()V
    //   1404: ldc_w 782
    //   1407: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1410: aload 17
    //   1412: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1415: ldc_w 784
    //   1418: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1421: iload 5
    //   1423: invokevirtual 282	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1426: ldc_w 786
    //   1429: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1432: aload_1
    //   1433: invokevirtual 296	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   1436: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1439: invokevirtual 177	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1442: invokespecial 268	com/tencent/mobileqq/transfile/AbstractImageDownloader:a	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
    //   1445: iload 9
    //   1447: istore 10
    //   1449: new 61	java/lang/OutOfMemoryError
    //   1452: dup
    //   1453: new 158	java/lang/StringBuilder
    //   1456: dup
    //   1457: invokespecial 175	java/lang/StringBuilder:<init>	()V
    //   1460: ldc_w 782
    //   1463: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1466: aload 17
    //   1468: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1471: ldc_w 784
    //   1474: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1477: iload 5
    //   1479: invokevirtual 282	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1482: ldc_w 786
    //   1485: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1488: aload_1
    //   1489: invokevirtual 296	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   1492: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1495: invokevirtual 177	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1498: invokespecial 787	java/lang/OutOfMemoryError:<init>	(Ljava/lang/String;)V
    //   1501: athrow
    //   1502: astore 15
    //   1504: iload 10
    //   1506: istore 9
    //   1508: aload_3
    //   1509: ifnull +7 -> 1516
    //   1512: aload_3
    //   1513: invokevirtual 680	android/graphics/Bitmap:recycle	()V
    //   1516: aload 15
    //   1518: ifnull +455 -> 1973
    //   1521: aload 15
    //   1523: invokevirtual 734	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   1526: astore 15
    //   1528: invokestatic 275	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1531: ifeq +81 -> 1612
    //   1534: aload_0
    //   1535: aload_2
    //   1536: ldc_w 277
    //   1539: new 158	java/lang/StringBuilder
    //   1542: dup
    //   1543: invokespecial 175	java/lang/StringBuilder:<init>	()V
    //   1546: ldc_w 789
    //   1549: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1552: iload 5
    //   1554: invokevirtual 282	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1557: ldc_w 284
    //   1560: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1563: aload 18
    //   1565: getfield 289	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   1568: invokevirtual 282	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1571: ldc_w 291
    //   1574: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1577: aload_1
    //   1578: invokevirtual 296	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   1581: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1584: ldc_w 298
    //   1587: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1590: aload 17
    //   1592: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1595: ldc_w 791
    //   1598: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1601: aload 15
    //   1603: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1606: invokevirtual 177	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1609: invokespecial 268	com/tencent/mobileqq/transfile/AbstractImageDownloader:a	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
    //   1612: iload 5
    //   1614: iconst_1
    //   1615: iadd
    //   1616: istore 5
    //   1618: aload 18
    //   1620: aload 18
    //   1622: getfield 289	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   1625: iconst_2
    //   1626: imul
    //   1627: putfield 289	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   1630: goto -314 -> 1316
    //   1633: iload 9
    //   1635: istore 10
    //   1637: getstatic 796	android/os/Build$VERSION:SDK_INT	I
    //   1640: bipush 11
    //   1642: if_icmplt +328 -> 1970
    //   1645: iload 9
    //   1647: istore 10
    //   1649: aload_3
    //   1650: invokestatic 802	com/tencent/image/SliceBitmap:needSlice	(Landroid/graphics/Bitmap;)Z
    //   1653: istore 11
    //   1655: iload 11
    //   1657: ifeq +313 -> 1970
    //   1660: iload 9
    //   1662: istore 10
    //   1664: new 798	com/tencent/image/SliceBitmap
    //   1667: dup
    //   1668: aload_3
    //   1669: invokespecial 803	com/tencent/image/SliceBitmap:<init>	(Landroid/graphics/Bitmap;)V
    //   1672: astore 15
    //   1674: iconst_1
    //   1675: istore 9
    //   1677: aload_3
    //   1678: invokevirtual 680	android/graphics/Bitmap:recycle	()V
    //   1681: aload_0
    //   1682: aload_2
    //   1683: aload_1
    //   1684: aload 17
    //   1686: aload 18
    //   1688: iload 5
    //   1690: iconst_1
    //   1691: ldc_w 805
    //   1694: invokespecial 714	com/tencent/mobileqq/transfile/AbstractImageDownloader:a	(Lcom/tencent/image/DownloadParams;Ljava/io/File;Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;IZLjava/lang/String;)V
    //   1697: aload 15
    //   1699: astore_3
    //   1700: iconst_1
    //   1701: istore 9
    //   1703: aload_3
    //   1704: ifnull +275 -> 1979
    //   1707: iconst_1
    //   1708: istore 10
    //   1710: aload_0
    //   1711: aload_2
    //   1712: aload_1
    //   1713: aload 17
    //   1715: aload 18
    //   1717: iload 5
    //   1719: iload 10
    //   1721: ldc 221
    //   1723: invokespecial 714	com/tencent/mobileqq/transfile/AbstractImageDownloader:a	(Lcom/tencent/image/DownloadParams;Ljava/io/File;Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;IZLjava/lang/String;)V
    //   1726: aload_2
    //   1727: getfield 233	com/tencent/image/DownloadParams:tag	Ljava/lang/Object;
    //   1730: ifnull +172 -> 1902
    //   1733: aload_2
    //   1734: getfield 233	com/tencent/image/DownloadParams:tag	Ljava/lang/Object;
    //   1737: instanceof 235
    //   1740: ifeq +162 -> 1902
    //   1743: aload_2
    //   1744: getfield 233	com/tencent/image/DownloadParams:tag	Ljava/lang/Object;
    //   1747: checkcast 235	com/tencent/mobileqq/data/MessageForPic
    //   1750: astore_1
    //   1751: aload_1
    //   1752: getfield 238	com/tencent/mobileqq/data/MessageForPic:selfuin	Ljava/lang/String;
    //   1755: astore 15
    //   1757: aload_1
    //   1758: invokevirtual 806	com/tencent/mobileqq/data/MessageForPic:isSendFromLocal	()Z
    //   1761: istore 14
    //   1763: aload_3
    //   1764: ifnull +221 -> 1985
    //   1767: iconst_1
    //   1768: istore 10
    //   1770: iload 6
    //   1772: iload 7
    //   1774: imul
    //   1775: istore 8
    //   1777: iload 8
    //   1779: getstatic 809	com/tencent/common/app/BaseApplicationImpl:sImageCacheSize	I
    //   1782: if_icmple +209 -> 1991
    //   1785: iconst_1
    //   1786: istore 11
    //   1788: goto +295 -> 2083
    //   1791: getstatic 811	com/tencent/mobileqq/transfile/AbstractImageDownloader:jdField_a_of_type_Int	I
    //   1794: ifeq +9 -> 1803
    //   1797: getstatic 812	com/tencent/mobileqq/transfile/AbstractImageDownloader:jdField_b_of_type_Int	I
    //   1800: ifne +35 -> 1835
    //   1803: aload_0
    //   1804: getfield 27	com/tencent/mobileqq/transfile/AbstractImageDownloader:jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl	Lcom/tencent/common/app/BaseApplicationImpl;
    //   1807: invokevirtual 64	com/tencent/common/app/BaseApplicationImpl:getResources	()Landroid/content/res/Resources;
    //   1810: invokevirtual 40	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   1813: getfield 701	android/util/DisplayMetrics:widthPixels	I
    //   1816: putstatic 811	com/tencent/mobileqq/transfile/AbstractImageDownloader:jdField_a_of_type_Int	I
    //   1819: aload_0
    //   1820: getfield 27	com/tencent/mobileqq/transfile/AbstractImageDownloader:jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl	Lcom/tencent/common/app/BaseApplicationImpl;
    //   1823: invokevirtual 64	com/tencent/common/app/BaseApplicationImpl:getResources	()Landroid/content/res/Resources;
    //   1826: invokevirtual 40	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   1829: getfield 707	android/util/DisplayMetrics:heightPixels	I
    //   1832: putstatic 812	com/tencent/mobileqq/transfile/AbstractImageDownloader:jdField_b_of_type_Int	I
    //   1835: getstatic 811	com/tencent/mobileqq/transfile/AbstractImageDownloader:jdField_a_of_type_Int	I
    //   1838: getstatic 812	com/tencent/mobileqq/transfile/AbstractImageDownloader:jdField_b_of_type_Int	I
    //   1841: if_icmple +162 -> 2003
    //   1844: getstatic 811	com/tencent/mobileqq/transfile/AbstractImageDownloader:jdField_a_of_type_Int	I
    //   1847: istore 6
    //   1849: iload 8
    //   1851: getstatic 813	com/tencent/mobileqq/transfile/URLDrawableHelper:jdField_a_of_type_Int	I
    //   1854: if_icmpgt +157 -> 2011
    //   1857: iload 6
    //   1859: sipush 1000
    //   1862: if_icmple +149 -> 2011
    //   1865: iconst_1
    //   1866: istore 13
    //   1868: aload_0
    //   1869: iload 11
    //   1871: iload 12
    //   1873: iload 13
    //   1875: iload 9
    //   1877: iload 5
    //   1879: iload 4
    //   1881: aload 15
    //   1883: iload 10
    //   1885: invokespecial 815	com/tencent/mobileqq/transfile/AbstractImageDownloader:a	(ZZZZIILjava/lang/String;Z)V
    //   1888: aload_0
    //   1889: aload_0
    //   1890: getfield 27	com/tencent/mobileqq/transfile/AbstractImageDownloader:jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl	Lcom/tencent/common/app/BaseApplicationImpl;
    //   1893: aload 15
    //   1895: iload 8
    //   1897: iload 14
    //   1899: invokespecial 817	com/tencent/mobileqq/transfile/AbstractImageDownloader:a	(Landroid/app/Application;Ljava/lang/String;IZ)V
    //   1902: aload_3
    //   1903: ifnonnull +114 -> 2017
    //   1906: new 451	java/io/IOException
    //   1909: dup
    //   1910: ldc_w 819
    //   1913: invokespecial 731	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   1916: athrow
    //   1917: astore 15
    //   1919: iload 9
    //   1921: istore 10
    //   1923: aload_0
    //   1924: aload_2
    //   1925: ldc_w 277
    //   1928: new 158	java/lang/StringBuilder
    //   1931: dup
    //   1932: invokespecial 175	java/lang/StringBuilder:<init>	()V
    //   1935: ldc_w 821
    //   1938: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1941: aload 15
    //   1943: invokevirtual 152	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1946: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1949: invokevirtual 177	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1952: invokespecial 268	com/tencent/mobileqq/transfile/AbstractImageDownloader:a	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
    //   1955: iload 9
    //   1957: istore 10
    //   1959: new 61	java/lang/OutOfMemoryError
    //   1962: dup
    //   1963: ldc_w 823
    //   1966: invokespecial 787	java/lang/OutOfMemoryError:<init>	(Ljava/lang/String;)V
    //   1969: athrow
    //   1970: goto -267 -> 1703
    //   1973: aconst_null
    //   1974: astore 15
    //   1976: goto -448 -> 1528
    //   1979: iconst_0
    //   1980: istore 10
    //   1982: goto -272 -> 1710
    //   1985: iconst_0
    //   1986: istore 10
    //   1988: goto -218 -> 1770
    //   1991: iconst_0
    //   1992: istore 11
    //   1994: goto +89 -> 2083
    //   1997: iconst_0
    //   1998: istore 12
    //   2000: goto -209 -> 1791
    //   2003: getstatic 812	com/tencent/mobileqq/transfile/AbstractImageDownloader:jdField_b_of_type_Int	I
    //   2006: istore 6
    //   2008: goto -159 -> 1849
    //   2011: iconst_0
    //   2012: istore 13
    //   2014: goto -146 -> 1868
    //   2017: aload_3
    //   2018: areturn
    //   2019: astore 15
    //   2021: goto -513 -> 1508
    //   2024: astore 15
    //   2026: goto -518 -> 1508
    //   2029: astore 15
    //   2031: iconst_1
    //   2032: istore 9
    //   2034: goto -115 -> 1919
    //   2037: astore_3
    //   2038: goto -1062 -> 976
    //   2041: astore 15
    //   2043: aload_3
    //   2044: astore_1
    //   2045: aload 15
    //   2047: astore_3
    //   2048: goto -1072 -> 976
    //   2051: aconst_null
    //   2052: astore_3
    //   2053: goto -350 -> 1703
    //   2056: aload 15
    //   2058: astore_3
    //   2059: goto -685 -> 1374
    //   2062: iconst_1
    //   2063: istore 4
    //   2065: goto -749 -> 1316
    //   2068: ldc 221
    //   2070: astore_3
    //   2071: iconst_0
    //   2072: istore 4
    //   2074: goto -1685 -> 389
    //   2077: iconst_1
    //   2078: istore 4
    //   2080: goto -2002 -> 78
    //   2083: iload 6
    //   2085: sipush 2048
    //   2088: if_icmpgt +11 -> 2099
    //   2091: iload 7
    //   2093: sipush 2048
    //   2096: if_icmple -99 -> 1997
    //   2099: iconst_1
    //   2100: istore 12
    //   2102: goto -311 -> 1791
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2105	0	this	AbstractImageDownloader
    //   0	2105	1	paramFile	File
    //   0	2105	2	paramDownloadParams	DownloadParams
    //   0	2105	3	paramURLDrawableHandler	com.tencent.image.URLDrawableHandler
    //   180	1899	4	i	int
    //   1237	641	5	j	int
    //   1216	873	6	k	int
    //   1223	874	7	m	int
    //   1775	121	8	n	int
    //   326	1707	9	bool1	boolean
    //   1306	681	10	bool2	boolean
    //   1653	340	11	bool3	boolean
    //   1871	230	12	bool4	boolean
    //   1866	147	13	bool5	boolean
    //   1761	137	14	bool6	boolean
    //   47	871	15	localObject1	Object
    //   1013	283	15	localException1	Exception
    //   1332	40	15	localBitmap	Bitmap
    //   1502	20	15	localOutOfMemoryError1	OutOfMemoryError
    //   1526	368	15	localObject2	Object
    //   1917	25	15	localException2	Exception
    //   1974	1	15	localObject3	Object
    //   2019	1	15	localOutOfMemoryError2	OutOfMemoryError
    //   2024	1	15	localOutOfMemoryError3	OutOfMemoryError
    //   2029	1	15	localException3	Exception
    //   2041	16	15	localOutOfMemoryError4	OutOfMemoryError
    //   402	205	16	localObject4	Object
    //   41	1673	17	str1	String
    //   133	1583	18	localOptions	BitmapFactory.Options
    //   450	36	19	str2	String
    // Exception table:
    //   from	to	target	type
    //   389	400	975	java/lang/OutOfMemoryError
    //   418	424	975	java/lang/OutOfMemoryError
    //   429	437	975	java/lang/OutOfMemoryError
    //   446	457	975	java/lang/OutOfMemoryError
    //   461	496	975	java/lang/OutOfMemoryError
    //   504	546	975	java/lang/OutOfMemoryError
    //   554	572	975	java/lang/OutOfMemoryError
    //   586	591	975	java/lang/OutOfMemoryError
    //   594	614	975	java/lang/OutOfMemoryError
    //   614	655	975	java/lang/OutOfMemoryError
    //   709	733	975	java/lang/OutOfMemoryError
    //   733	816	975	java/lang/OutOfMemoryError
    //   816	831	975	java/lang/OutOfMemoryError
    //   833	944	975	java/lang/OutOfMemoryError
    //   944	975	975	java/lang/OutOfMemoryError
    //   37	75	1013	java/lang/Exception
    //   78	126	1013	java/lang/Exception
    //   126	180	1013	java/lang/Exception
    //   185	238	1013	java/lang/Exception
    //   254	328	1013	java/lang/Exception
    //   336	384	1013	java/lang/Exception
    //   389	400	1013	java/lang/Exception
    //   418	424	1013	java/lang/Exception
    //   429	437	1013	java/lang/Exception
    //   446	457	1013	java/lang/Exception
    //   461	496	1013	java/lang/Exception
    //   504	546	1013	java/lang/Exception
    //   554	572	1013	java/lang/Exception
    //   586	591	1013	java/lang/Exception
    //   594	614	1013	java/lang/Exception
    //   614	655	1013	java/lang/Exception
    //   662	697	1013	java/lang/Exception
    //   709	733	1013	java/lang/Exception
    //   733	816	1013	java/lang/Exception
    //   816	831	1013	java/lang/Exception
    //   833	944	1013	java/lang/Exception
    //   944	975	1013	java/lang/Exception
    //   976	1013	1013	java/lang/Exception
    //   1125	1162	1013	java/lang/Exception
    //   1162	1193	1013	java/lang/Exception
    //   1193	1231	1013	java/lang/Exception
    //   1239	1308	1013	java/lang/Exception
    //   1323	1334	1013	java/lang/Exception
    //   1337	1350	1013	java/lang/Exception
    //   1353	1371	1013	java/lang/Exception
    //   1382	1388	1013	java/lang/Exception
    //   1392	1445	1013	java/lang/Exception
    //   1449	1502	1013	java/lang/Exception
    //   1512	1516	1013	java/lang/Exception
    //   1521	1528	1013	java/lang/Exception
    //   1528	1612	1013	java/lang/Exception
    //   1618	1630	1013	java/lang/Exception
    //   1637	1645	1013	java/lang/Exception
    //   1649	1655	1013	java/lang/Exception
    //   1710	1763	1013	java/lang/Exception
    //   1777	1785	1013	java/lang/Exception
    //   1791	1803	1013	java/lang/Exception
    //   1803	1835	1013	java/lang/Exception
    //   1835	1849	1013	java/lang/Exception
    //   1849	1857	1013	java/lang/Exception
    //   1868	1902	1013	java/lang/Exception
    //   1906	1917	1013	java/lang/Exception
    //   1923	1955	1013	java/lang/Exception
    //   1959	1970	1013	java/lang/Exception
    //   2003	2008	1013	java/lang/Exception
    //   1382	1388	1502	java/lang/OutOfMemoryError
    //   1392	1445	1502	java/lang/OutOfMemoryError
    //   1449	1502	1502	java/lang/OutOfMemoryError
    //   1637	1645	1502	java/lang/OutOfMemoryError
    //   1649	1655	1502	java/lang/OutOfMemoryError
    //   1664	1674	1502	java/lang/OutOfMemoryError
    //   1923	1955	1502	java/lang/OutOfMemoryError
    //   1959	1970	1502	java/lang/OutOfMemoryError
    //   1664	1674	1917	java/lang/Exception
    //   1323	1334	2019	java/lang/OutOfMemoryError
    //   1337	1350	2019	java/lang/OutOfMemoryError
    //   1353	1371	2019	java/lang/OutOfMemoryError
    //   1677	1697	2024	java/lang/OutOfMemoryError
    //   1677	1697	2029	java/lang/Exception
    //   254	328	2037	java/lang/OutOfMemoryError
    //   662	697	2037	java/lang/OutOfMemoryError
    //   336	384	2041	java/lang/OutOfMemoryError
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\a2.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.AbstractImageDownloader
 * JD-Core Version:    0.7.0.1
 */