package com.tencent.mobileqq.transfile;

import android.app.Application;
import android.content.res.Resources;
import android.graphics.BitmapFactory.Options;
import android.util.DisplayMetrics;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.DownloadParams;
import com.tencent.image.GifDrawable;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.image.URLDrawableHandler;
import com.tencent.image.Utils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pic.PicDownloadInfo;
import com.tencent.mobileqq.pic.PicUiInterface;
import com.tencent.mobileqq.pic.PicUploadInfo;
import com.tencent.mobileqq.pic.api.IPicHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.report.ProcessorReport;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import mqq.app.AccountNotMatchException;

public abstract class AbstractImageDownloader
  extends BaseImageDownloader
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
  
  public static int getRoundRadius(Application paramApplication, int paramInt)
  {
    float f1;
    if (paramInt > 150) {
      f1 = paramInt / 100;
    } else {
      f1 = 1.0F;
    }
    double d = paramApplication.getResources().getDisplayMetrics().density;
    float f2 = 9.0F;
    if (d <= 1.5D) {}
    for (;;)
    {
      return (int)(f1 * f2);
      if (d > 2.0D) {
        f2 = 4.0F;
      }
    }
  }
  
  private void log(Object paramObject, String paramString1, String paramString2)
  {
    Object localObject;
    if ((paramObject instanceof DownloadParams))
    {
      localObject = (DownloadParams)paramObject;
      if ((((DownloadParams)localObject).tag instanceof PicUiInterface))
      {
        paramObject = (PicUiInterface)((DownloadParams)localObject).tag;
        localObject = ((DownloadParams)localObject).url.getProtocol();
        boolean bool2 = paramObject.isSendFromLocal();
        boolean bool1 = false;
        if (bool2)
        {
          i = RichMediaUtil.getFileType(((IPicHelper)QRoute.api(IPicHelper.class)).getFileSizeType((String)localObject, false));
          paramObject = paramObject.getPicUploadInfo();
          RichMediaUtil.log(paramObject.c, false, i, String.valueOf(paramObject.g), paramString1, paramString2);
          return;
        }
        paramObject = paramObject.getPicDownloadInfo();
        if (paramObject.t == 1) {
          bool1 = true;
        }
        int i = RichMediaUtil.getFileType(((IPicHelper)QRoute.api(IPicHelper.class)).getFileSizeType((String)localObject, bool1));
        RichMediaUtil.log(paramObject.c, false, i, String.valueOf(paramObject.g), paramString1, paramString2);
        return;
      }
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("obj");
      ((StringBuilder)localObject).append(paramObject);
      ((StringBuilder)localObject).append(" \tstep:");
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append(" \tcontent:");
      ((StringBuilder)localObject).append(paramString2);
      QLog.d("Q.richmedia.", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  private void logDecodeFile(DownloadParams paramDownloadParams, File paramFile, String paramString1, BitmapFactory.Options paramOptions, int paramInt, boolean paramBoolean, String paramString2)
  {
    StringBuilder localStringBuilder;
    if (paramBoolean)
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("DecodeFile SUCCESS,retryCount=");
        localStringBuilder.append(paramInt);
        localStringBuilder.append(",options.inSampleSize=");
        localStringBuilder.append(paramOptions.inSampleSize);
        localStringBuilder.append(",cacheFile=");
        localStringBuilder.append(paramFile.getAbsolutePath());
        localStringBuilder.append(",url=");
        localStringBuilder.append(paramString1);
        localStringBuilder.append(",extraMsg=");
        localStringBuilder.append(paramString2);
        log(paramDownloadParams, "DecodeFile", localStringBuilder.toString());
      }
    }
    else if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("DecodeFile FAIL,retryCount=");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(",options.inSampleSize=");
      localStringBuilder.append(paramOptions.inSampleSize);
      localStringBuilder.append(",cacheFile=");
      localStringBuilder.append(paramFile.getAbsolutePath());
      localStringBuilder.append(",url=");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(",extraMsg=");
      localStringBuilder.append(paramString2);
      log(paramDownloadParams, "DecodeFile", localStringBuilder.toString());
    }
  }
  
  private void reportBitmapSize(Application paramApplication, String paramString, int paramInt, boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private void reportDecodeData(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, int paramInt1, int paramInt2, String paramString, boolean paramBoolean5)
  {
    if (paramInt2 == 3)
    {
      paramInt2 = paramInt1 - 1;
      if (paramInt1 == 1)
      {
        reportDecodeImage(this.application, "big_img_decode", 0, paramString, paramInt2);
        reportDecodeImage(this.application, "big_img_decode_long", 0, paramString, paramInt2);
        return;
      }
      if (paramBoolean5)
      {
        if (!paramBoolean1)
        {
          if (paramBoolean3) {
            reportDecodeImage(this.application, "big_img_decode", -1, paramString, paramInt2);
          } else {
            reportDecodeImage(this.application, "big_img_decode", 2, paramString, paramInt2);
          }
        }
        else {
          reportDecodeImage(this.application, "big_img_decode", 1, paramString, paramInt2);
        }
        if (paramBoolean2) {
          reportDecodeImage(this.application, "big_img_decode_long", 3, paramString, paramInt2);
        } else {
          reportDecodeImage(this.application, "big_img_decode_long", 4, paramString, paramInt2);
        }
        if (paramBoolean2) {
          reportDecodeImage(this.application, "big_img_decode_slice", 0, paramString, paramInt2);
        }
      }
      else
      {
        if (paramBoolean1) {
          reportDecodeImage(this.application, "big_img_decode", 5, paramString, paramInt2);
        }
        if (paramBoolean2) {
          reportDecodeImage(this.application, "big_img_decode_long", 6, paramString, paramInt2);
        }
        if (paramBoolean4) {
          reportDecodeImage(this.application, "big_img_decode_slice", 6, paramString, paramInt2);
        }
      }
    }
  }
  
  private void reportDecodeImage(Application paramApplication, String paramString1, int paramInt1, String paramString2, int paramInt2)
  {
    paramApplication = paramString2;
    if (paramString2 != null) {}
    for (;;)
    {
      boolean bool;
      try
      {
        paramApplication = ((QQAppInterface)BaseApplicationImpl.getApplication().getAppRuntime(paramString2)).getCurrentAccountUin();
      }
      catch (AccountNotMatchException paramApplication)
      {
        return;
      }
      paramString2 = new HashMap();
      paramString2.put("param_FailCode", Integer.toString(paramInt1 + paramInt2 * 7 + 88000));
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(paramApplication, paramString1, bool, 0L, 0L, paramString2, "");
      return;
      if (paramInt2 == 0) {
        bool = true;
      } else {
        bool = false;
      }
    }
  }
  
  public Object decodeFile(File paramFile, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    if (QLog.isColorLevel())
    {
      paramURLDrawableHandler = new StringBuilder();
      paramURLDrawableHandler.append("decodeFile config.tag ");
      paramURLDrawableHandler.append(paramDownloadParams.tag);
      log(paramDownloadParams, "DecodeFile", paramURLDrawableHandler.toString());
    }
    try
    {
      paramURLDrawableHandler = paramDownloadParams.urlStr;
      Object localObject1 = paramDownloadParams.url;
      boolean bool = QLog.isColorLevel();
      if (bool)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("DecodeFile START,cacheFile=");
        ((StringBuilder)localObject2).append(paramFile.getAbsolutePath());
        ((StringBuilder)localObject2).append(",url=");
        ((StringBuilder)localObject2).append(paramURLDrawableHandler);
        log(paramDownloadParams, "DecodeFile", ((StringBuilder)localObject2).toString());
      }
      Object localObject2 = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject2).inPreferredConfig = URLDrawableHelper.mConfig;
      ((BitmapFactory.Options)localObject2).inDensity = 160;
      ((BitmapFactory.Options)localObject2).inTargetDensity = 160;
      ((BitmapFactory.Options)localObject2).inScreenDensity = 160;
      ((BitmapFactory.Options)localObject2).inJustDecodeBounds = true;
      if (GifDrawable.isGifFile(paramFile))
      {
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("DecodeFile END,GIF image,cacheFile=");
          ((StringBuilder)localObject1).append(paramFile.getAbsolutePath());
          ((StringBuilder)localObject1).append(",url=");
          ((StringBuilder)localObject1).append(paramURLDrawableHandler);
          log(paramDownloadParams, "DecodeFile", ((StringBuilder)localObject1).toString());
        }
      }
      else
      {
        ((BitmapFactory.Options)localObject2).inJustDecodeBounds = true;
        SafeBitmapFactory.decodeFile(paramFile.getAbsolutePath(), (BitmapFactory.Options)localObject2);
        if ((((BitmapFactory.Options)localObject2).outHeight != 0) && (((BitmapFactory.Options)localObject2).outWidth != 0)) {
          return decodeImage((URL)localObject1, paramFile, paramDownloadParams, (BitmapFactory.Options)localObject2);
        }
        paramFile.delete();
        logDecodeFile(paramDownloadParams, paramFile, paramURLDrawableHandler, (BitmapFactory.Options)localObject2, 1, false, "step:decode bounds error, not valid pic");
        throw new IOException("step:decode bounds error, not valid pic");
      }
    }
    catch (Exception localException)
    {
      paramURLDrawableHandler = ProcessorReport.getExceptionMessage(localException);
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
        paramURLDrawableHandler = new StringBuilder();
        paramURLDrawableHandler.append("DecodeFile FAIL,exceptionmsg:");
        paramURLDrawableHandler.append(paramFile);
        log(paramDownloadParams, "DecodeFile", paramURLDrawableHandler.toString());
      }
      paramDownloadParams = new HashMap();
      paramDownloadParams.put("params_failDesc", paramFile);
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "actPicUIDecoder", false, -1L, 0L, paramDownloadParams, "", true);
      throw localException;
    }
    return null;
  }
  
  protected int getTryTime(URL paramURL)
  {
    if ((!paramURL.getProtocol().equals("datalineimage")) && (!paramURL.getProtocol().equals("favimage"))) {
      return super.getTryTime(paramURL);
    }
    return 3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.AbstractImageDownloader
 * JD-Core Version:    0.7.0.1
 */