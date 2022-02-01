package com.tencent.mobileqq.shortvideo;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.format.Formatter;
import android.util.DisplayMetrics;
import com.tencent.biz.qqstory.app.QQStoryConstant;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.DownloadParams;
import com.tencent.image.RoundRectBitmap;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.shortvideo.ShortVideoPlayActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.camera.utils.CameraUtils;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.ThumbWidthHeightDP;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.editor.composite.VideoCompositeHelper;
import com.tencent.mobileqq.guild.temp.api.IGuildFeatureAdapterApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.util.VidUtil;
import com.tencent.mobileqq.statistics.AVShortVideoReportController;
import com.tencent.mobileqq.statistics.AVShortVideoReportController.ReportData;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.CommonImgThumbHelper;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.util.QZLog;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.atomic.AtomicInteger;

public class ShortVideoUtils
  implements ShortVideoConstants
{
  private static final int CLEAN_TEMP_FILE_INTERVAL = 604800000;
  private static String[] FULL_SCREEN_BLACK_LIST = { "GT-N7108" };
  public static final int MERGE_TIPS_SHOW_TIME = 3;
  public static final int MSG_SAVE_DISMISS = 10003;
  public static final int MSG_SAVE_FAILED = 10001;
  public static final int MSG_SAVE_SUCCESS = 10000;
  public static final String SHORT_VIDEO_AE_CAMERA_TAKE_SAME_SWITCH = "short_video_ae_pitu_takesame_switch";
  public static final String SHORT_VIDEO_AIO_RED_DOT_SHOWED = "short_video_red_dot_showed";
  public static final String SHORT_VIDEO_AIO_TIPS_SHOWED = "short_video_tips_showed";
  public static final String SHORT_VIDEO_AND_HOT_PIC_CONFIG_SP = "ptv_and_hot_pic_reddot_sp";
  public static final String SHORT_VIDEO_HOT_PIC_CONFIG_CFG_VERSION = "short_video_hotpic_cfg_version_";
  public static final String SHORT_VIDEO_HOT_PIC_CONFIG_PIC_VERSION = "short_video_hotpic_pic_version_";
  public static final String SHORT_VIDEO_HOT_PIC_CONFIG_PTV_VERSION = "short_video_hotpic_ptv_version_";
  public static final String SHORT_VIDEO_HOT_PIC_CONFIG_SHOW_PIC = "short_video_hotpic_show_pic_";
  public static final String SHORT_VIDEO_HOT_PIC_CONFIG_SHOW_PTV = "short_video_hotpic_show_ptv_";
  public static final String SHORT_VIDEO_PHOTO_MORE_FILTER = "short_video_photo_more_filter";
  public static final String SHORT_VIDEO_PTU_PTVTEMPLATE_SDK_SP = "short_video_ptu_template_sdk_sp";
  public static final String T2 = "0X8008E50";
  public static final String T3 = "0X8008E51";
  public static final String T5 = "0X8008E53";
  public static final String TAG = "ShortVideoUtils";
  public static final int VIDEO_THUMBNAIL_MAX_LENGTH_DEFAULT = 640;
  public static boolean isHotPicConfiginitied = false;
  public static boolean isPtvConfiginitied = false;
  private static AtomicInteger mDefaultShortVideoPreDownloadStrategy = new AtomicInteger(0);
  private static int mDefaultShortVideoPreDownloadTime = 2;
  private static volatile boolean mSoLoadState = false;
  private static int mSupportPhotoMerge = 1;
  private static boolean sDarkModeInited = false;
  private static int[] sDarkModeValues = { 1, 97, 125 };
  public static boolean sPredownloadShortVideoInited = false;
  private static boolean sShutdownSkipClipPhoto = false;
  private static boolean sShutdownSkipClipPhotoInited = false;
  private static boolean sSupportPhotoMergeInited = false;
  public static boolean sSupportShortVideo = true;
  
  static
  {
    isPtvConfiginitied = false;
    isHotPicConfiginitied = false;
    ThreadManager.excute(new ShortVideoUtils.1(), 64, null, false);
  }
  
  public static native int adjustMoovPosition(String paramString1, String paramString2);
  
  public static int[] adjustSize(int paramInt1, int paramInt2)
  {
    int m = 100;
    if (paramInt1 > 0) {
      k = paramInt1;
    } else {
      k = 100;
    }
    if (paramInt2 > 0) {
      m = paramInt2;
    }
    double d = BaseChatItemLayout.f;
    Double.isNaN(d);
    int i = (int)(d + 0.5D);
    int n = URLDrawableHelper.getVideoThumbMaxDp();
    int j = i;
    if (n >= 135)
    {
      n = AIOUtils.b(n, BaseApplicationImpl.getApplication().getResources());
      j = i;
      if (n < i) {
        j = n;
      }
    }
    n = AIOUtils.b(305.0F, BaseApplicationImpl.getApplication().getResources());
    i = j;
    if (j > n) {
      i = n;
    }
    if (k >= m) {
      j = 1;
    } else {
      j = 0;
    }
    String str;
    if (j != 0)
    {
      float f = k / m;
      if (f > 1.555556F)
      {
        d = i * 9.0F / 16.0F;
        Double.isNaN(d);
        j = (int)(d + 0.5D);
      }
      for (str = "landscape close to 16:9";; str = "landscape close to 4:3")
      {
        k = j;
        j = i;
        break label300;
        if (f <= 1.166667F) {
          break;
        }
        d = i * 3.0F / 4.0F;
        Double.isNaN(d);
        j = (int)(d + 0.5D);
      }
      str = "landscape close to 1:1";
    }
    else
    {
      if (m / k > 1.3F)
      {
        d = i * 10.0F / 16.0F;
        Double.isNaN(d);
        j = (int)(d + 0.5D);
        str = "portrait close to 10:16";
        k = i;
        break label300;
      }
      str = "portrait close to 1:1";
    }
    j = i;
    int k = j;
    label300:
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("adjustSize ");
      localStringBuilder.append(str);
      localStringBuilder.append(" maxPixel:");
      localStringBuilder.append(i);
      localStringBuilder.append(" ow:");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(" oh:");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append(" w:");
      localStringBuilder.append(j);
      localStringBuilder.append(" h:");
      localStringBuilder.append(k);
      QLog.d("ShortVideoUtils", 2, localStringBuilder.toString());
    }
    return new int[] { j, k };
  }
  
  public static int[] adjustSizeforGuild(int paramInt1, int paramInt2)
  {
    int k = 100;
    if (paramInt1 > 0) {
      j = paramInt1;
    } else {
      j = 100;
    }
    if (paramInt2 > 0) {
      k = paramInt2;
    }
    double d = ((IGuildFeatureAdapterApi)QRoute.api(IGuildFeatureAdapterApi.class)).getCONTENTVIEW_MAX_WIDTH_SIZE();
    Double.isNaN(d);
    int m = (int)(d + 0.5D);
    int n = AIOUtils.b(305.0F, BaseApplicationImpl.getApplication().getResources());
    int i = m;
    if (m > n) {
      i = n;
    }
    if (j >= k) {
      m = 1;
    } else {
      m = 0;
    }
    String str;
    if (m != 0)
    {
      float f = j / k;
      if (f > 1.555556F)
      {
        d = i * 9.0F / 16.0F;
        Double.isNaN(d);
        j = (int)(d + 0.5D);
      }
      for (str = "landscape close to 16:9";; str = "landscape close to 4:3")
      {
        k = j;
        j = i;
        break label264;
        if (f <= 1.166667F) {
          break;
        }
        d = i * 3.0F / 4.0F;
        Double.isNaN(d);
        j = (int)(d + 0.5D);
      }
      str = "landscape close to 1:1";
    }
    else
    {
      if (k / j > 1.3F)
      {
        d = i * 10.0F / 16.0F;
        Double.isNaN(d);
        j = (int)(d + 0.5D);
        str = "portrait close to 10:16";
        k = i;
        break label264;
      }
      str = "portrait close to 1:1";
    }
    int j = i;
    k = j;
    label264:
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("adjustSize ");
      localStringBuilder.append(str);
      localStringBuilder.append(" maxPixel:");
      localStringBuilder.append(i);
      localStringBuilder.append(" ow:");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(" oh:");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append(" w:");
      localStringBuilder.append(j);
      localStringBuilder.append(" h:");
      localStringBuilder.append(k);
      QLog.d("ShortVideoUtils", 2, localStringBuilder.toString());
    }
    return new int[] { j, k };
  }
  
  public static int[] calculateScaledThumbWH(Bitmap paramBitmap)
  {
    if (paramBitmap == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("ShortVideoUtils", 2, "calculateThumbWH, bitmap == null ！");
      }
      return null;
    }
    if (paramBitmap.isRecycled())
    {
      if (QLog.isColorLevel()) {
        QLog.e("ShortVideoUtils", 2, "calculateThumbWH, bitmap isRecycled !");
      }
      return null;
    }
    return calculateScaledThumbWH(new int[] { paramBitmap.getWidth(), paramBitmap.getHeight() });
  }
  
  public static int[] calculateScaledThumbWH(int[] paramArrayOfInt)
  {
    if (paramArrayOfInt == null) {
      return null;
    }
    int j = paramArrayOfInt[0];
    int k = paramArrayOfInt[1];
    if ((j != 0) && (k != 0))
    {
      if (k > j)
      {
        f1 = k;
        f2 = j;
      }
      else
      {
        f1 = j;
        f2 = k;
      }
      float f2 = f1 / f2;
      float f1 = f2;
      if (f2 > 2.0F) {
        f1 = 2.0F;
      }
      int i;
      if (k > j)
      {
        if (k > 160)
        {
          i = 160;
        }
        else
        {
          i = k;
          if (k < 100) {
            i = 100;
          }
        }
        int m = (int)(i / f1);
        j = m;
        k = i;
        if (m < 80)
        {
          j = 80;
          k = i;
        }
      }
      else
      {
        if (j > 160)
        {
          i = 160;
        }
        else
        {
          i = j;
          if (j < 100) {
            i = 100;
          }
        }
        k = (int)(i / f1);
        j = k;
        if (k < 80) {
          j = 80;
        }
        k = j;
        j = i;
      }
      return new int[] { j, k };
    }
    if (QLog.isColorLevel()) {
      QLog.e("ShortVideoUtils", 2, "calculateThumbWH, w or h == 0 !");
    }
    return null;
  }
  
  public static boolean canRecordShortVideo()
  {
    Object localObject = ((IDPCApi)QRoute.api(IDPCApi.class)).getFeatureValue(DPCNames.pg_switch.name(), "1|1|1");
    if (QLog.isDevelopLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("DeviceProfileManager.DpcNames.pg_switch value ");
      localStringBuilder.append((String)localObject);
      QLog.d("peak_pgjpeg", 4, localStringBuilder.toString());
    }
    localObject = ((String)localObject).split("\\|");
    if (localObject.length < 3) {
      return false;
    }
    return localObject[2].equals("1");
  }
  
  public static boolean checkEntranceType(int paramInt)
  {
    if ((paramInt != 1) && (paramInt != 2) && (paramInt != 3) && (paramInt != 4) && (paramInt != 5) && (paramInt != 122)) {
      switch (paramInt)
      {
      default: 
        switch (paramInt)
        {
        default: 
          return false;
        }
        break;
      }
    }
    return true;
  }
  
  public static boolean checkShortVideoSoReadyToLoad()
  {
    try
    {
      if (VideoEnvironment.supportShortVideoRecordAndPlay())
      {
        if (isVideoSoLibLoaded()) {
          return true;
        }
        boolean bool = VideoEnvironment.checkShortVideoSoReadyToLoad();
        return bool;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      if (QLog.isColorLevel()) {
        QLog.e("ShortVideoUtils", 2, "checkShortVideoSoReadyToLoad failure.", localException);
      }
    }
    return false;
  }
  
  public static void deleteCacheFileByMsg(MessageForShortVideo paramMessageForShortVideo)
  {
    if (paramMessageForShortVideo == null) {
      return;
    }
    if (TextUtils.isEmpty(paramMessageForShortVideo.getMd5()))
    {
      if (QLog.isColorLevel()) {
        QLog.e("ShortVideoUtils", 2, "deleteCacheFileByMessage, md5 == null! ");
      }
      return;
    }
    FileUtils.deleteFile(SVUtils.a(paramMessageForShortVideo, "mp4"));
  }
  
  public static void deleteDownloadTempFile()
  {
    deleteDownloadTempFile("", false);
  }
  
  public static void deleteDownloadTempFile(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("deleteDownloadTempFile, exclude :");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(",compareModifiedTime : ");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.d("ShortVideoUtils", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new File(SVUtils.c());
    if (!((File)localObject).exists()) {
      return;
    }
    localObject = ((File)localObject).listFiles();
    if (localObject == null) {
      return;
    }
    int k = localObject.length;
    int i = 0;
    while (i < k)
    {
      File[] arrayOfFile = localObject[i].listFiles();
      if (arrayOfFile != null)
      {
        int m = arrayOfFile.length;
        int j = 0;
        while (j < m)
        {
          File localFile = arrayOfFile[j];
          if ((!localFile.getName().equals(paramString)) && (localFile.isFile()) && (localFile.getName().contains(".tmp"))) {
            if (paramBoolean)
            {
              long l = localFile.lastModified();
              if (604800000L <= System.currentTimeMillis() - l) {
                localFile.delete();
              }
            }
            else
            {
              localFile.delete();
            }
          }
          j += 1;
        }
      }
      i += 1;
    }
  }
  
  public static boolean ensureShortVideoSoLoaded(AppInterface paramAppInterface)
  {
    if (isVideoSoLibLoaded()) {
      return true;
    }
    loadShortVideoSo(paramAppInterface);
    return isVideoSoLibLoaded();
  }
  
  @Deprecated
  public static String findVideoPathIfExists(MessageForShortVideo paramMessageForShortVideo)
  {
    if (paramMessageForShortVideo == null) {
      return null;
    }
    String str = SVUtils.a(paramMessageForShortVideo, "mp4");
    if (FileUtils.fileExistsAndNotEmpty(str)) {
      return str;
    }
    if (paramMessageForShortVideo.isSendFromLocal())
    {
      paramMessageForShortVideo = paramMessageForShortVideo.videoFileName;
      if (FileUtils.fileExistsAndNotEmpty(paramMessageForShortVideo)) {
        return paramMessageForShortVideo;
      }
    }
    return null;
  }
  
  public static String getCameraPath()
  {
    Object localObject = Build.MODEL.toUpperCase();
    if (((String)localObject).contains("GN9000L"))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(AppConstants.SDCARD_ROOT);
      ((StringBuilder)localObject).append(HardCodeUtil.a(2131898855));
      localObject = ((StringBuilder)localObject).toString();
    }
    else if ((!((String)localObject).contains("MX4")) && (!((String)localObject).contains("MX6")) && (!((String)localObject).contains("MX5")) && (!((String)localObject).contains("M355")) && (!((String)localObject).contains("M571C")))
    {
      if (((String)localObject).contains("M040"))
      {
        localObject = AppConstants.SDCARD_IMG_VIDEO_RUBBISH_MX040;
      }
      else if ((!((String)localObject).contains("VIVO X7")) && (!((String)localObject).contains("VIVO X6A")) && (!((String)localObject).contains("VIVO XPLAY6")) && (!((String)localObject).contains("VIVO X5PRO")) && (!((String)localObject).contains("VIVO X9 PLUS")) && (!((String)localObject).contains("VIVO Y51A")) && (!((String)localObject).contains("VIVO X9I")) && (!((String)localObject).contains("VIVO X9")) && (!((String)localObject).contains("VIVO X6D")))
      {
        localObject = AppConstants.SDCARD_IMG_CAMERA;
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(AppConstants.SDCARD_ROOT);
        ((StringBuilder)localObject).append(HardCodeUtil.a(2131898856));
        localObject = ((StringBuilder)localObject).toString();
      }
    }
    else
    {
      localObject = AppConstants.SDCARD_IMG_VIDEO;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getCameraPath: commonPath=");
      localStringBuilder.append((String)localObject);
      QLog.d("ShortVideoUtils", 2, localStringBuilder.toString());
    }
    return localObject;
  }
  
  public static int[] getDarkModeDPCValues()
  {
    return sDarkModeValues;
  }
  
  public static AtomicInteger getDefaultShortVideoStrategy()
  {
    if (!sPredownloadShortVideoInited)
    {
      initPredownloadParam();
      sPredownloadShortVideoInited = true;
    }
    return mDefaultShortVideoPreDownloadStrategy;
  }
  
  public static int getDisplayProgress(int paramInt1, int paramInt2)
  {
    if (paramInt1 <= 0) {
      return paramInt2;
    }
    if (paramInt1 >= 100) {
      return 100;
    }
    return (int)(paramInt1 * (100 - paramInt2) / 100.0F + paramInt2);
  }
  
  public static String getDownloadTmpPath(MessageForShortVideo paramMessageForShortVideo)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(SVUtils.a(paramMessageForShortVideo, "mp4"));
    localStringBuilder.append(".");
    localStringBuilder.append(MD5.toMD5(paramMessageForShortVideo.uuid));
    localStringBuilder.append(".tmp");
    return localStringBuilder.toString();
  }
  
  /* Error */
  public static long getDuration(String paramString)
  {
    // Byte code:
    //   0: new 362	java/io/File
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 368	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: invokevirtual 371	java/io/File:exists	()Z
    //   11: istore_2
    //   12: ldc2_w 510
    //   15: lstore 5
    //   17: iload_2
    //   18: ifne +58 -> 76
    //   21: invokestatic 191	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   24: ifeq +48 -> 72
    //   27: new 193	java/lang/StringBuilder
    //   30: dup
    //   31: invokespecial 194	java/lang/StringBuilder:<init>	()V
    //   34: astore 7
    //   36: aload 7
    //   38: ldc_w 513
    //   41: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: pop
    //   45: aload 7
    //   47: aload_0
    //   48: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   51: pop
    //   52: aload 7
    //   54: ldc_w 515
    //   57: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: pop
    //   61: ldc 65
    //   63: iconst_2
    //   64: aload 7
    //   66: invokevirtual 217	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   69: invokestatic 240	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   72: ldc2_w 510
    //   75: lreturn
    //   76: new 517	com/tencent/qqlive/module/videoreport/dtreport/audio/playback/ReportMediaPlayer
    //   79: dup
    //   80: invokespecial 518	com/tencent/qqlive/module/videoreport/dtreport/audio/playback/ReportMediaPlayer:<init>	()V
    //   83: astore 7
    //   85: aload 7
    //   87: aload_0
    //   88: invokevirtual 523	android/media/MediaPlayer:setDataSource	(Ljava/lang/String;)V
    //   91: aload 7
    //   93: invokevirtual 526	android/media/MediaPlayer:prepare	()V
    //   96: aload 7
    //   98: invokevirtual 528	android/media/MediaPlayer:getDuration	()I
    //   101: istore_1
    //   102: iload_1
    //   103: i2l
    //   104: lstore_3
    //   105: aload 7
    //   107: invokevirtual 531	android/media/MediaPlayer:release	()V
    //   110: lload_3
    //   111: lreturn
    //   112: astore_0
    //   113: goto +33 -> 146
    //   116: astore_0
    //   117: aload_0
    //   118: invokevirtual 313	java/lang/Exception:printStackTrace	()V
    //   121: lload 5
    //   123: lstore_3
    //   124: invokestatic 191	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   127: ifeq -22 -> 105
    //   130: ldc 65
    //   132: iconst_2
    //   133: ldc_w 532
    //   136: aload_0
    //   137: invokestatic 534	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   140: lload 5
    //   142: lstore_3
    //   143: goto -38 -> 105
    //   146: aload 7
    //   148: invokevirtual 531	android/media/MediaPlayer:release	()V
    //   151: goto +5 -> 156
    //   154: aload_0
    //   155: athrow
    //   156: goto -2 -> 154
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	159	0	paramString	String
    //   101	2	1	i	int
    //   11	7	2	bool	boolean
    //   104	39	3	l1	long
    //   15	126	5	l2	long
    //   34	113	7	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   85	102	112	finally
    //   117	121	112	finally
    //   124	140	112	finally
    //   85	102	116	java/lang/Exception
  }
  
  @TargetApi(14)
  public static long getDurationOfVideo(String paramString)
  {
    if (!FileUtils.fileExists(paramString)) {
      return 0L;
    }
    return VideoCompositeHelper.b(paramString);
  }
  
  public static int getHotPiCRedDotConfigVersion(String paramString)
  {
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("ptv_and_hot_pic_reddot_sp", 4);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("short_video_hotpic_pic_version_");
    localStringBuilder.append(paramString);
    return localSharedPreferences.getInt(localStringBuilder.toString(), 0);
  }
  
  public static boolean getHotPicRedDotStatus(String paramString)
  {
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("ptv_and_hot_pic_reddot_sp", 4);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("short_video_hotpic_show_pic_");
    localStringBuilder.append(paramString);
    return localSharedPreferences.getBoolean(localStringBuilder.toString(), false);
  }
  
  public static String getLocalShortVideoPath()
  {
    String str = getCameraPath();
    StringBuilder localStringBuilder2 = new StringBuilder(str);
    File localFile = new File(localStringBuilder2.toString());
    StringBuilder localStringBuilder1 = localStringBuilder2;
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    for (localStringBuilder1 = localStringBuilder2;; localStringBuilder1 = new StringBuilder(str))
    {
      localStringBuilder1.append(VidUtil.generateVid());
      localStringBuilder1.append(".mp4");
      if (!new File(localStringBuilder1.toString()).exists()) {
        return localStringBuilder1.toString();
      }
    }
  }
  
  public static String getMergeVideoPath(File paramFile)
  {
    if (paramFile == null) {
      return null;
    }
    paramFile = VidUtil.getVidFromSourceDirFile(paramFile);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(QQStoryConstant.g);
    localStringBuilder.append(paramFile);
    localStringBuilder.append(".mp4");
    return localStringBuilder.toString();
  }
  
  public static String getNetTypeStr(int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3)
        {
          if (paramInt != 4) {
            return "Others";
          }
          return "4G";
        }
        return "3G";
      }
      return "2G";
    }
    return "WIFI";
  }
  
  public static int getPreDownloadTime()
  {
    if (!sPredownloadShortVideoInited)
    {
      initPredownloadParam();
      sPredownloadShortVideoInited = true;
    }
    return mDefaultShortVideoPreDownloadTime;
  }
  
  public static int getPtvHotPicConfigVersion(String paramString)
  {
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("ptv_and_hot_pic_reddot_sp", 4);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("short_video_hotpic_cfg_version_");
    localStringBuilder.append(paramString);
    return localSharedPreferences.getInt(localStringBuilder.toString(), 0);
  }
  
  public static int getPtvRedDotConfigVersion(String paramString)
  {
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("ptv_and_hot_pic_reddot_sp", 4);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("short_video_hotpic_ptv_version_");
    localStringBuilder.append(paramString);
    return localSharedPreferences.getInt(localStringBuilder.toString(), 0);
  }
  
  public static boolean getPtvRedDotStatus(String paramString)
  {
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("ptv_and_hot_pic_reddot_sp", 4);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("short_video_hotpic_show_ptv_");
    localStringBuilder.append(paramString);
    return localSharedPreferences.getBoolean(localStringBuilder.toString(), false);
  }
  
  public static SharedPreferences getPtvTemplateSDKPref()
  {
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("short_video_ptu_template_sdk_sp_");
    localStringBuilder.append(BaseApplicationImpl.sProcessId);
    return localBaseApplicationImpl.getSharedPreferences(localStringBuilder.toString(), 0);
  }
  
  public static String getRecentPOI(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      SharedPreferences localSharedPreferences = getSharedPref("sp_user_cache_data");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("recent_poi_");
      localStringBuilder.append(paramString);
      return localSharedPreferences.getString(localStringBuilder.toString(), null);
    }
    return null;
  }
  
  public static SharedPreferences getSharedPref(String paramString)
  {
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append(BaseApplicationImpl.sProcessId);
    return localBaseApplicationImpl.getSharedPreferences(localStringBuilder.toString(), 0);
  }
  
  @TargetApi(9)
  public static String getShortVideoCompressPath(String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString1))
    {
      String str = MD5.toMD5(paramString1);
      StringBuilder localStringBuilder = new StringBuilder(SVUtils.a());
      localStringBuilder.append("shortvideo");
      localStringBuilder.append(File.separator);
      localStringBuilder.append(str);
      localStringBuilder.append(".");
      localStringBuilder.append(paramString2);
      if (QLog.isColorLevel())
      {
        paramString2 = new StringBuilder();
        paramString2.append("getShortVideoCompressPath: sourcePath=");
        paramString2.append(paramString1);
        paramString2.append("/n compressPath=");
        paramString2.append(localStringBuilder.toString());
        QLog.d("ShortVideoUtils", 2, paramString2.toString());
      }
      return localStringBuilder.toString();
    }
    return null;
  }
  
  public static String getShortVideoPath(File paramFile)
  {
    if (paramFile == null) {
      return null;
    }
    Object localObject = VidUtil.getVidFromSourceDirFile(paramFile);
    paramFile = new StringBuilder(AppConstants.SDCARD_IMG_CAMERA);
    paramFile.append((String)localObject);
    paramFile.append(".mp4");
    localObject = new File(AppConstants.SDCARD_IMG_CAMERA);
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdirs();
    }
    return paramFile.toString();
  }
  
  public static String getShortVideoPath(File paramFile, String paramString)
  {
    if ((paramFile != null) && (!TextUtils.isEmpty(paramString)))
    {
      String str = VidUtil.getVidFromSourceDirFile(paramFile);
      paramFile = new StringBuilder(AppConstants.SDCARD_IMG_CAMERA);
      paramFile.append(paramString);
      paramFile.append(str);
      paramFile.append(".mp4");
      paramString = new File(AppConstants.SDCARD_IMG_CAMERA);
      if (!paramString.exists()) {
        paramString.mkdirs();
      }
      return paramFile.toString();
    }
    return null;
  }
  
  public static String getShortVideoPath(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder(SVUtils.c());
    localStringBuilder.append(paramString1);
    localStringBuilder.append(".");
    localStringBuilder.append(paramString2);
    return localStringBuilder.toString();
  }
  
  @TargetApi(9)
  public static String getShortVideoRawCompressPath(String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString1))
    {
      String str = MD5.toMD5(paramString1);
      StringBuilder localStringBuilder = new StringBuilder(SVUtils.a());
      localStringBuilder.append("shortvideo");
      localStringBuilder.append(File.separator);
      localStringBuilder.append(str);
      localStringBuilder.append("_raw");
      localStringBuilder.append(".");
      localStringBuilder.append(paramString2);
      if (QLog.isColorLevel())
      {
        paramString2 = new StringBuilder();
        paramString2.append("getShortVideoCompressPath: sourcePath=");
        paramString2.append(paramString1);
        paramString2.append("/n compressPath=");
        paramString2.append(localStringBuilder.toString());
        QLog.d("ShortVideoUtils", 2, paramString2.toString());
      }
      return localStringBuilder.toString();
    }
    return null;
  }
  
  public static String getShortVideoSaveFileName(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("QQ视频");
    localStringBuilder.append("_");
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  public static String getTempAudioPath(File paramFile)
  {
    if (paramFile == null) {
      return null;
    }
    paramFile = VidUtil.getVidFromSourceDirFile(paramFile);
    StringBuilder localStringBuilder = new StringBuilder(SVUtils.a());
    localStringBuilder.append("shortvideo");
    localStringBuilder.append(File.separator);
    localStringBuilder.append("temp");
    localStringBuilder.append(File.separator);
    localStringBuilder.append("audio");
    localStringBuilder.append(File.separator);
    localStringBuilder.append(paramFile);
    localStringBuilder.append(".mp4");
    return localStringBuilder.toString();
  }
  
  public static String getTempVideoPath(File paramFile)
  {
    if (paramFile == null) {
      return null;
    }
    paramFile = VidUtil.getVidFromSourceDirFile(paramFile);
    StringBuilder localStringBuilder = new StringBuilder(SVUtils.a());
    localStringBuilder.append("shortvideo");
    localStringBuilder.append(File.separator);
    localStringBuilder.append("temp");
    localStringBuilder.append(File.separator);
    localStringBuilder.append("source");
    localStringBuilder.append(File.separator);
    localStringBuilder.append(paramFile);
    localStringBuilder.append(".mp4");
    return localStringBuilder.toString();
  }
  
  public static URL getThumbPicUrl(String paramString)
  {
    try
    {
      paramString = new URL("shortvideoforpicthumb", null, paramString);
      return paramString;
    }
    catch (MalformedURLException paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  public static URL getThumbUrl(String paramString)
  {
    try
    {
      paramString = new URL("shortvideothumb", null, paramString);
      return paramString;
    }
    catch (MalformedURLException paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  /* Error */
  @android.annotation.SuppressLint({"InlinedApi"})
  public static int[] getVideoFileRtAndTime(String paramString)
  {
    // Byte code:
    //   0: iconst_3
    //   1: newarray int
    //   3: astore 4
    //   5: aload 4
    //   7: dup
    //   8: iconst_0
    //   9: iconst_0
    //   10: iastore
    //   11: dup
    //   12: iconst_1
    //   13: iconst_0
    //   14: iastore
    //   15: dup
    //   16: iconst_2
    //   17: iconst_0
    //   18: iastore
    //   19: pop
    //   20: invokestatic 675	com/tencent/util/VersionUtils:d	()Z
    //   23: ifeq +285 -> 308
    //   26: new 677	android/media/MediaMetadataRetriever
    //   29: dup
    //   30: invokespecial 678	android/media/MediaMetadataRetriever:<init>	()V
    //   33: astore_3
    //   34: aload_3
    //   35: aload_0
    //   36: invokevirtual 679	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   39: aload_3
    //   40: bipush 18
    //   42: invokevirtual 682	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   45: astore 5
    //   47: aload_3
    //   48: bipush 19
    //   50: invokevirtual 682	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   53: astore 6
    //   55: aload_3
    //   56: bipush 9
    //   58: invokevirtual 682	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   61: astore 7
    //   63: ldc_w 350
    //   66: astore_2
    //   67: getstatic 687	android/os/Build$VERSION:SDK_INT	I
    //   70: bipush 17
    //   72: if_icmplt +10 -> 82
    //   75: aload_3
    //   76: bipush 24
    //   78: invokevirtual 682	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   81: astore_2
    //   82: aload 4
    //   84: iconst_0
    //   85: aload 5
    //   87: invokestatic 693	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   90: invokevirtual 696	java/lang/Integer:intValue	()I
    //   93: iastore
    //   94: aload 4
    //   96: iconst_1
    //   97: aload 6
    //   99: invokestatic 693	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   102: invokevirtual 696	java/lang/Integer:intValue	()I
    //   105: iastore
    //   106: aload 4
    //   108: iconst_2
    //   109: aload 7
    //   111: invokestatic 693	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   114: invokevirtual 696	java/lang/Integer:intValue	()I
    //   117: i2f
    //   118: ldc_w 697
    //   121: fdiv
    //   122: invokestatic 703	java/lang/Math:round	(F)I
    //   125: iastore
    //   126: aload_2
    //   127: invokestatic 331	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   130: ifne +202 -> 332
    //   133: aload_2
    //   134: invokestatic 706	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   137: istore_1
    //   138: iload_1
    //   139: bipush 90
    //   141: if_icmpeq +170 -> 311
    //   144: iload_1
    //   145: sipush 270
    //   148: if_icmpne +6 -> 154
    //   151: goto +160 -> 311
    //   154: invokestatic 191	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   157: ifeq +138 -> 295
    //   160: new 193	java/lang/StringBuilder
    //   163: dup
    //   164: invokespecial 194	java/lang/StringBuilder:<init>	()V
    //   167: astore 5
    //   169: aload 5
    //   171: ldc_w 708
    //   174: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   177: pop
    //   178: aload 5
    //   180: aload 4
    //   182: iconst_0
    //   183: iaload
    //   184: invokevirtual 205	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   187: pop
    //   188: aload 5
    //   190: ldc_w 710
    //   193: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   196: pop
    //   197: aload 5
    //   199: aload 4
    //   201: iconst_1
    //   202: iaload
    //   203: invokevirtual 205	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   206: pop
    //   207: aload 5
    //   209: ldc_w 712
    //   212: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   215: pop
    //   216: aload 5
    //   218: aload 4
    //   220: iconst_2
    //   221: iaload
    //   222: invokevirtual 205	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   225: pop
    //   226: aload 5
    //   228: ldc_w 714
    //   231: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   234: pop
    //   235: aload 5
    //   237: aload_2
    //   238: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   241: pop
    //   242: aload 5
    //   244: ldc_w 716
    //   247: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   250: pop
    //   251: aload 5
    //   253: aload_0
    //   254: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   257: pop
    //   258: ldc_w 718
    //   261: iconst_2
    //   262: aload 5
    //   264: invokevirtual 217	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   267: invokestatic 221	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   270: goto +25 -> 295
    //   273: astore_0
    //   274: goto +28 -> 302
    //   277: astore_0
    //   278: invokestatic 191	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   281: ifeq +14 -> 295
    //   284: ldc_w 718
    //   287: iconst_2
    //   288: ldc_w 720
    //   291: aload_0
    //   292: invokestatic 318	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   295: aload_3
    //   296: invokevirtual 721	android/media/MediaMetadataRetriever:release	()V
    //   299: aload 4
    //   301: areturn
    //   302: aload_3
    //   303: invokevirtual 721	android/media/MediaMetadataRetriever:release	()V
    //   306: aload_0
    //   307: athrow
    //   308: aload 4
    //   310: areturn
    //   311: aload 4
    //   313: iconst_0
    //   314: iaload
    //   315: istore_1
    //   316: aload 4
    //   318: iconst_0
    //   319: aload 4
    //   321: iconst_1
    //   322: iaload
    //   323: iastore
    //   324: aload 4
    //   326: iconst_1
    //   327: iload_1
    //   328: iastore
    //   329: goto -175 -> 154
    //   332: aload 4
    //   334: iconst_0
    //   335: iconst_0
    //   336: iastore
    //   337: aload 4
    //   339: iconst_1
    //   340: iconst_0
    //   341: iastore
    //   342: goto -188 -> 154
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	345	0	paramString	String
    //   137	191	1	i	int
    //   66	172	2	str1	String
    //   33	270	3	localMediaMetadataRetriever	android.media.MediaMetadataRetriever
    //   3	335	4	arrayOfInt	int[]
    //   45	218	5	localObject	Object
    //   53	45	6	str2	String
    //   61	49	7	str3	String
    // Exception table:
    //   from	to	target	type
    //   34	63	273	finally
    //   67	82	273	finally
    //   82	138	273	finally
    //   154	270	273	finally
    //   278	295	273	finally
    //   34	63	277	java/lang/Exception
    //   67	82	277	java/lang/Exception
    //   82	138	277	java/lang/Exception
    //   154	270	277	java/lang/Exception
  }
  
  public static String getVideoOutputPath(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    try
    {
      paramString = getShortVideoPath(new File(paramString).getParentFile());
      return paramString;
    }
    catch (Exception paramString)
    {
      QZLog.i("ShortVideoUtils", 1, "get target path error encode error", paramString);
    }
    return null;
  }
  
  @TargetApi(10)
  public static Bitmap getVideoThumbnail(Context paramContext, String paramString)
  {
    return getVideoThumbnail(paramContext, paramString, 640);
  }
  
  @TargetApi(10)
  public static Bitmap getVideoThumbnail(Context paramContext, String paramString, int paramInt)
  {
    return getVideoThumbnail(paramContext, paramString, paramInt, -1L);
  }
  
  /* Error */
  @TargetApi(10)
  public static Bitmap getVideoThumbnail(Context paramContext, String paramString, int paramInt, long paramLong)
  {
    // Byte code:
    //   0: iload_2
    //   1: istore 6
    //   3: iload_2
    //   4: ifgt +8 -> 12
    //   7: sipush 640
    //   10: istore 6
    //   12: invokestatic 397	java/lang/System:currentTimeMillis	()J
    //   15: lstore 9
    //   17: new 677	android/media/MediaMetadataRetriever
    //   20: dup
    //   21: invokespecial 678	android/media/MediaMetadataRetriever:<init>	()V
    //   24: astore 12
    //   26: aconst_null
    //   27: astore 11
    //   29: aload 12
    //   31: aload_1
    //   32: invokevirtual 679	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   35: aload 12
    //   37: lload_3
    //   38: invokevirtual 754	android/media/MediaMetadataRetriever:getFrameAtTime	(J)Landroid/graphics/Bitmap;
    //   41: astore_0
    //   42: aload 12
    //   44: invokevirtual 721	android/media/MediaMetadataRetriever:release	()V
    //   47: goto +35 -> 82
    //   50: astore_0
    //   51: goto +22 -> 73
    //   54: astore_0
    //   55: ldc 65
    //   57: iconst_1
    //   58: ldc_w 756
    //   61: aload_0
    //   62: invokestatic 534	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   65: aload 12
    //   67: invokevirtual 721	android/media/MediaMetadataRetriever:release	()V
    //   70: goto +10 -> 80
    //   73: aload 12
    //   75: invokevirtual 721	android/media/MediaMetadataRetriever:release	()V
    //   78: aload_0
    //   79: athrow
    //   80: aconst_null
    //   81: astore_0
    //   82: aload_0
    //   83: ifnonnull +5 -> 88
    //   86: aconst_null
    //   87: areturn
    //   88: aload_0
    //   89: invokevirtual 250	android/graphics/Bitmap:getWidth	()I
    //   92: istore 7
    //   94: aload_0
    //   95: invokevirtual 253	android/graphics/Bitmap:getHeight	()I
    //   98: istore_2
    //   99: iload 7
    //   101: iload_2
    //   102: invokestatic 759	java/lang/Math:max	(II)I
    //   105: istore 8
    //   107: iload 8
    //   109: iload 6
    //   111: if_icmple +55 -> 166
    //   114: iload 6
    //   116: i2f
    //   117: iload 8
    //   119: i2f
    //   120: fdiv
    //   121: fstore 5
    //   123: iload 7
    //   125: i2f
    //   126: fload 5
    //   128: fmul
    //   129: invokestatic 703	java/lang/Math:round	(F)I
    //   132: istore 6
    //   134: fload 5
    //   136: iload_2
    //   137: i2f
    //   138: fmul
    //   139: invokestatic 703	java/lang/Math:round	(F)I
    //   142: istore_2
    //   143: aload_0
    //   144: iload 6
    //   146: iload_2
    //   147: iconst_1
    //   148: invokestatic 763	android/graphics/Bitmap:createScaledBitmap	(Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;
    //   151: astore_0
    //   152: goto +14 -> 166
    //   155: astore_0
    //   156: aload_0
    //   157: invokevirtual 764	java/lang/OutOfMemoryError:printStackTrace	()V
    //   160: aload 11
    //   162: astore_0
    //   163: goto +3 -> 166
    //   166: invokestatic 397	java/lang/System:currentTimeMillis	()J
    //   169: lstore_3
    //   170: aload_0
    //   171: ifnull +113 -> 284
    //   174: invokestatic 191	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   177: ifeq +149 -> 326
    //   180: new 193	java/lang/StringBuilder
    //   183: dup
    //   184: invokespecial 194	java/lang/StringBuilder:<init>	()V
    //   187: astore 11
    //   189: aload 11
    //   191: ldc_w 766
    //   194: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   197: pop
    //   198: aload 11
    //   200: aload_0
    //   201: invokevirtual 250	android/graphics/Bitmap:getWidth	()I
    //   204: invokevirtual 205	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   207: pop
    //   208: aload 11
    //   210: ldc_w 768
    //   213: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   216: pop
    //   217: aload 11
    //   219: aload_0
    //   220: invokevirtual 253	android/graphics/Bitmap:getHeight	()I
    //   223: invokevirtual 205	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   226: pop
    //   227: aload 11
    //   229: ldc_w 770
    //   232: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   235: pop
    //   236: aload 11
    //   238: aload_1
    //   239: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   242: pop
    //   243: aload 11
    //   245: ldc_w 772
    //   248: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   251: pop
    //   252: aload 11
    //   254: lload_3
    //   255: lload 9
    //   257: lsub
    //   258: invokevirtual 775	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   261: pop
    //   262: aload 11
    //   264: ldc_w 777
    //   267: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   270: pop
    //   271: ldc 65
    //   273: iconst_2
    //   274: aload 11
    //   276: invokevirtual 217	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   279: invokestatic 221	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   282: aload_0
    //   283: areturn
    //   284: invokestatic 191	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   287: ifeq +39 -> 326
    //   290: new 193	java/lang/StringBuilder
    //   293: dup
    //   294: invokespecial 194	java/lang/StringBuilder:<init>	()V
    //   297: astore 11
    //   299: aload 11
    //   301: ldc_w 779
    //   304: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   307: pop
    //   308: aload 11
    //   310: aload_1
    //   311: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   314: pop
    //   315: ldc 65
    //   317: iconst_2
    //   318: aload 11
    //   320: invokevirtual 217	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   323: invokestatic 240	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   326: aload_0
    //   327: areturn
    //   328: astore_0
    //   329: goto -264 -> 65
    //   332: astore 12
    //   334: goto -252 -> 82
    //   337: astore_0
    //   338: goto -258 -> 80
    //   341: astore_1
    //   342: goto -264 -> 78
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	345	0	paramContext	Context
    //   0	345	1	paramString	String
    //   0	345	2	paramInt	int
    //   0	345	3	paramLong	long
    //   121	14	5	f	float
    //   1	144	6	i	int
    //   92	32	7	j	int
    //   105	13	8	k	int
    //   15	241	9	l	long
    //   27	292	11	localStringBuilder	StringBuilder
    //   24	50	12	localMediaMetadataRetriever	android.media.MediaMetadataRetriever
    //   332	1	12	localRuntimeException	java.lang.RuntimeException
    // Exception table:
    //   from	to	target	type
    //   29	42	50	finally
    //   55	65	50	finally
    //   29	42	54	java/lang/OutOfMemoryError
    //   143	152	155	java/lang/OutOfMemoryError
    //   29	42	328	java/lang/IllegalArgumentException
    //   29	42	328	java/lang/RuntimeException
    //   42	47	332	java/lang/RuntimeException
    //   65	70	337	java/lang/RuntimeException
    //   73	78	341	java/lang/RuntimeException
  }
  
  public static String getVideoTmpPath(MessageForShortVideo paramMessageForShortVideo)
  {
    if (paramMessageForShortVideo == null) {
      return "";
    }
    if (paramMessageForShortVideo.isSendFromLocal())
    {
      if (paramMessageForShortVideo.sendRawVideo) {
        return getShortVideoRawCompressPath(paramMessageForShortVideo.videoFileName, "tmp");
      }
      return getShortVideoCompressPath(paramMessageForShortVideo.videoFileName, "tmp");
    }
    return getDownloadTmpPath(paramMessageForShortVideo);
  }
  
  private static void initPredownloadParam()
  {
    try
    {
      Object localObject = ((IDPCApi)QRoute.api(IDPCApi.class)).getFeatureValue(DPCNames.aio_config.name(), "-1|1=0,2=0,3=0,4=0,5=1|1|999|4|1|0_2");
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("getDefaultShortVideoStrategy:");
        localStringBuilder.append((String)localObject);
        QLog.d("ShortVideoUtils", 2, localStringBuilder.toString());
      }
      localObject = ((String)localObject).split("\\|");
      if (localObject.length > 6)
      {
        localObject = localObject[6].split("_");
        if (localObject.length >= 2)
        {
          int i = Integer.valueOf(localObject[0]).intValue();
          if ((i >= 0) && (i <= 2)) {
            mDefaultShortVideoPreDownloadStrategy = new AtomicInteger(i);
          }
          i = Integer.valueOf(localObject[1]).intValue();
          if ((i >= 0) && (i <= 60))
          {
            mDefaultShortVideoPreDownloadTime = i;
            return;
          }
        }
      }
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder;
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("needBlockBrokenVideo e:");
        localStringBuilder.append(localException.toString());
        QLog.d("ShortVideoUtils", 2, localStringBuilder.toString());
      }
    }
  }
  
  public static boolean isAEPituTakeSameOpen()
  {
    return BaseApplicationImpl.getApplication().getSharedPreferences("ptv_and_hot_pic_reddot_sp", 4).getBoolean("short_video_ae_pitu_takesame_switch", false);
  }
  
  /* Error */
  @TargetApi(16)
  public static boolean isH265FormatShortVideo(String paramString)
  {
    // Byte code:
    //   0: new 806	android/media/MediaExtractor
    //   3: dup
    //   4: invokespecial 807	android/media/MediaExtractor:<init>	()V
    //   7: astore 4
    //   9: iconst_0
    //   10: istore_3
    //   11: aload 4
    //   13: aload_0
    //   14: invokevirtual 808	android/media/MediaExtractor:setDataSource	(Ljava/lang/String;)V
    //   17: iconst_0
    //   18: istore_1
    //   19: iload_3
    //   20: istore_2
    //   21: iload_1
    //   22: aload 4
    //   24: invokevirtual 811	android/media/MediaExtractor:getTrackCount	()I
    //   27: if_icmpge +69 -> 96
    //   30: aload 4
    //   32: iload_1
    //   33: invokevirtual 815	android/media/MediaExtractor:getTrackFormat	(I)Landroid/media/MediaFormat;
    //   36: ldc_w 817
    //   39: invokevirtual 821	android/media/MediaFormat:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   42: astore_0
    //   43: aload_0
    //   44: ldc_w 823
    //   47: invokevirtual 826	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   50: ifeq +14 -> 64
    //   53: aload_0
    //   54: ldc_w 828
    //   57: invokevirtual 831	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   60: istore_2
    //   61: goto +35 -> 96
    //   64: iload_1
    //   65: iconst_1
    //   66: iadd
    //   67: istore_1
    //   68: goto -49 -> 19
    //   71: astore_0
    //   72: goto +31 -> 103
    //   75: astore_0
    //   76: iload_3
    //   77: istore_2
    //   78: invokestatic 191	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   81: ifeq +15 -> 96
    //   84: ldc 65
    //   86: iconst_2
    //   87: ldc_w 833
    //   90: aload_0
    //   91: invokestatic 318	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   94: iload_3
    //   95: istore_2
    //   96: aload 4
    //   98: invokevirtual 834	android/media/MediaExtractor:release	()V
    //   101: iload_2
    //   102: ireturn
    //   103: aload 4
    //   105: invokevirtual 834	android/media/MediaExtractor:release	()V
    //   108: goto +5 -> 113
    //   111: aload_0
    //   112: athrow
    //   113: goto -2 -> 111
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	116	0	paramString	String
    //   18	50	1	i	int
    //   20	82	2	bool1	boolean
    //   10	85	3	bool2	boolean
    //   7	97	4	localMediaExtractor	android.media.MediaExtractor
    // Exception table:
    //   from	to	target	type
    //   11	17	71	finally
    //   21	61	71	finally
    //   78	94	71	finally
    //   11	17	75	java/lang/Exception
    //   21	61	75	java/lang/Exception
  }
  
  public static boolean isInFullScreenBlackList()
  {
    Object localObject = FULL_SCREEN_BLACK_LIST;
    int j = localObject.length;
    int i = 0;
    boolean bool = false;
    while (i < j)
    {
      String str = localObject[i];
      if (Build.MODEL.equalsIgnoreCase(str)) {
        bool = true;
      }
      i += 1;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("isInFullScreenBlackList(), result=");
      ((StringBuilder)localObject).append(bool);
      QLog.d("ShortVideoUtils", 2, ((StringBuilder)localObject).toString());
    }
    return bool;
  }
  
  public static boolean isSkipClipShutDown()
  {
    if (!sShutdownSkipClipPhotoInited)
    {
      sShutdownSkipClipPhotoInited = true;
      try
      {
        Object localObject = ((IDPCApi)QRoute.api(IDPCApi.class)).getFeatureValue(DPCNames.aio_config.name(), "");
        if (QLog.isColorLevel())
        {
          localStringBuilder2 = new StringBuilder();
          localStringBuilder2.append("isSkipClipShutDown:");
          localStringBuilder2.append((String)localObject);
          QLog.d("ShortVideoUtils", 2, localStringBuilder2.toString());
        }
        localObject = ((String)localObject).split("\\|");
        if (localObject.length > 16) {
          sShutdownSkipClipPhoto = localObject[16].equals("1");
        }
      }
      catch (Exception localException)
      {
        StringBuilder localStringBuilder2;
        if (QLog.isColorLevel())
        {
          localStringBuilder2 = new StringBuilder();
          localStringBuilder2.append("isSkipClipShutDown e:");
          localStringBuilder2.append(localException.toString());
          QLog.d("ShortVideoUtils", 2, localStringBuilder2.toString());
        }
      }
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("isSkipClipShutDown sShutdownSkipClipPhoto ");
      localStringBuilder1.append(sShutdownSkipClipPhoto);
      QLog.d("ShortVideoUtils", 2, localStringBuilder1.toString());
    }
    return sShutdownSkipClipPhoto;
  }
  
  public static boolean isSupportProgressive(File paramFile)
  {
    boolean bool1 = false;
    boolean bool3 = false;
    boolean bool2 = bool1;
    long l1;
    Object localObject;
    int i;
    if (paramFile != null)
    {
      bool2 = bool1;
      if (paramFile.exists())
      {
        if (!paramFile.isFile()) {
          return false;
        }
        l1 = System.currentTimeMillis();
        localObject = SVUtils.a(paramFile);
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("isSupportProgressive(), moovInfoStr: ");
          localStringBuilder.append((String)localObject);
          localStringBuilder.append(", filePath:");
          localStringBuilder.append(paramFile.getAbsolutePath());
          QLog.d("ShortVideoUtils", 2, localStringBuilder.toString());
        }
        bool2 = bool1;
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          localObject = ((String)localObject).split("\\|");
          bool2 = bool1;
          if (!TextUtils.isEmpty(localObject[0])) {
            i = -1;
          }
        }
      }
    }
    try
    {
      int j = Integer.parseInt(localObject[0]);
      i = j;
    }
    catch (Exception localException)
    {
      label155:
      long l2;
      float f;
      break label155;
    }
    bool2 = bool1;
    if (i > 0)
    {
      l2 = paramFile.length();
      f = i / (float)l2;
      bool1 = bool3;
      if (f > 0.0F)
      {
        bool1 = bool3;
        if (f < 0.5F) {
          bool1 = true;
        }
      }
      l2 = System.currentTimeMillis();
      bool2 = bool1;
      if (QLog.isColorLevel())
      {
        paramFile = new StringBuilder();
        paramFile.append("isSupportProgressive(), ratio: ");
        paramFile.append(f);
        paramFile.append(", result: ");
        paramFile.append(bool1);
        paramFile.append(", cost:");
        paramFile.append(l2 - l1);
        QLog.d("ShortVideoUtils", 2, paramFile.toString());
        bool2 = bool1;
      }
    }
    return bool2;
  }
  
  public static boolean isVideoExist(MessageForShortVideo paramMessageForShortVideo)
  {
    if (paramMessageForShortVideo == null) {
      return false;
    }
    if (FileUtils.fileExistsAndNotEmpty(SVUtils.a(paramMessageForShortVideo, "mp4"))) {
      return true;
    }
    return (paramMessageForShortVideo.isSendFromLocal()) && (FileUtils.fileExistsAndNotEmpty(paramMessageForShortVideo.videoFileName));
  }
  
  public static boolean isVideoSoLibLoaded()
  {
    return VideoEnvironment.isShortVideoSoLibLoaded();
  }
  
  public static void loadShortVideoSo(AppInterface paramAppInterface)
  {
    try
    {
      if (VideoEnvironment.supportShortVideoRecordAndPlay())
      {
        VideoEnvironment.loadAVCodecSo();
        return;
      }
    }
    catch (Throwable paramAppInterface)
    {
      if (QLog.isColorLevel()) {
        QLog.e("ShortVideoUtils", 2, "Load libAVCodec.so failure", paramAppInterface);
      }
    }
  }
  
  public static boolean moveMoovAtom(String paramString1, String paramString2)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (mSoLoadState))
    {
      if (TextUtils.isEmpty(paramString2)) {
        return false;
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("moveMoovAtom() srcFilePath = ");
        ((StringBuilder)localObject).append(paramString1);
        ((StringBuilder)localObject).append(" , desFilePath = ");
        ((StringBuilder)localObject).append(paramString2);
        QLog.e("ShortVideoUtils", 2, ((StringBuilder)localObject).toString());
      }
      long l1 = System.currentTimeMillis();
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString2);
      ((StringBuilder)localObject).append(".tmp");
      localObject = ((StringBuilder)localObject).toString();
      int i = adjustMoovPosition(paramString1, (String)localObject);
      if (i != 0)
      {
        if (QLog.isColorLevel())
        {
          paramString1 = new StringBuilder();
          paramString1.append("moveMoovAtom() adjust fail, ret = ");
          paramString1.append(i);
          QLog.e("ShortVideoUtils", 2, paramString1.toString());
        }
        return false;
      }
      if (!FileUtils.rename((String)localObject, paramString2))
      {
        if (QLog.isColorLevel()) {
          QLog.e("ShortVideoUtils", 2, "moveMoovAtom() rename fail");
        }
        return false;
      }
      long l2 = System.currentTimeMillis();
      if (QLog.isColorLevel())
      {
        paramString1 = new StringBuilder();
        paramString1.append("moveMoovAtom() success, cost = ");
        paramString1.append(l2 - l1);
        paramString1.append("ms");
        QLog.d("ShortVideoUtils", 2, paramString1.toString());
      }
      return true;
    }
    return false;
  }
  
  public static boolean needTwoEntrance()
  {
    boolean bool1 = supportShortVideoMergePhoto();
    boolean bool2 = CameraUtils.a();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("supportShortVideoMergePhoto dpc:");
      localStringBuilder.append(mSupportPhotoMerge);
      localStringBuilder.append(" choiceQC:");
      localStringBuilder.append(bool2);
      QLog.d("ShortVideoUtils", 2, localStringBuilder.toString());
    }
    if (bool1) {
      return bool2 ^ true;
    }
    return true;
  }
  
  public static String realGetShortVideoSavePath(String paramString1, String paramString2, long paramLong, String paramString3)
  {
    paramString1 = new StringBuilder(SVUtils.a(paramString1));
    paramString1.append(paramString2);
    paramString1.append(Math.abs(paramLong));
    paramString1.append(".");
    paramString1.append(paramString3);
    return paramString1.toString();
  }
  
  public static void reportCancelSendVideo(String paramString, int paramInt)
  {
    if (paramInt == 0) {
      paramInt = 1;
    } else if (paramInt == 1) {
      paramInt = 2;
    } else if (paramInt == 3000) {
      paramInt = 3;
    } else {
      paramInt = 4;
    }
    ReportController.b(null, "dc00898", "", "", paramString, paramString, paramInt, 0, "", "", "", "");
  }
  
  public static void reportVideoPlay(AppInterface paramAppInterface, String paramString, SessionInfo paramSessionInfo, MessageRecord paramMessageRecord, Context paramContext)
  {
    AVShortVideoReportController.ReportData localReportData = new AVShortVideoReportController.ReportData();
    localReportData.b = paramString;
    int i = paramSessionInfo.a;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i == 3000) {
          localReportData.d = "3";
        }
      }
      else {
        localReportData.d = "2";
      }
    }
    else {
      localReportData.d = "1";
    }
    if (paramString == "0X8008E53") {
      localReportData.c = "2";
    } else {
      localReportData.c = "1";
    }
    if ((paramMessageRecord != null) && ((paramMessageRecord instanceof MessageForShortVideo)))
    {
      paramString = (MessageForShortVideo)paramMessageRecord;
      localReportData.a = String.valueOf(paramString.videoFileTime * 1000);
      i = paramString.busiType;
      if (i != 0)
      {
        if (i == 1) {
          localReportData.e = "2";
        }
      }
      else {
        localReportData.e = "1";
      }
      if (QLog.isColorLevel()) {
        QLog.e("ShortVideoUtils", 1, new Object[] { Long.valueOf(paramMessageRecord.uniseq) });
      }
    }
    else
    {
      localReportData.a = "0";
      localReportData.e = "3";
    }
    if ((!(paramContext instanceof SplashActivity)) && (!(paramContext instanceof ChatActivity))) {
      localReportData.f = "2";
    } else {
      localReportData.f = "1";
    }
    AVShortVideoReportController.a(paramAppInterface.getAccount(), "dc01178", paramSessionInfo.b, localReportData);
  }
  
  public static void reportVideoPlay(String paramString1, String paramString2, String paramString3, int paramInt, String paramString4, String paramString5)
  {
    AVShortVideoReportController.ReportData localReportData = new AVShortVideoReportController.ReportData();
    localReportData.a = paramString3;
    localReportData.b = "0X8008E53";
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt == 3000) {
          localReportData.d = "3";
        }
      }
      else {
        localReportData.d = "2";
      }
    }
    else {
      localReportData.d = "1";
    }
    localReportData.c = "2";
    localReportData.e = paramString4;
    localReportData.f = paramString5;
    AVShortVideoReportController.a(paramString1, "dc01178", paramString2, localReportData);
  }
  
  public static void reportVideoPlayEvent(QQAppInterface paramQQAppInterface, int paramInt1, String paramString, int paramInt2, int paramInt3, long paramLong1, long paramLong2)
  {
    if (paramInt1 != 0)
    {
      if (paramInt1 != 1)
      {
        if ((paramInt1 != 1000) && (paramInt1 != 1025) && (paramInt1 != 7400) && (paramInt1 != 10004) && (paramInt1 != 10008) && (paramInt1 != 10010)) {}
        switch (paramInt1)
        {
        default: 
          switch (paramInt1)
          {
          default: 
            paramInt1 = 4;
          }
          break;
        case 1003: 
        case 1004: 
        case 1005: 
        case 1006: 
          paramInt1 = 3;
          break;
        }
      }
      else
      {
        paramInt1 = 2;
      }
    }
    else {
      paramInt1 = 1;
    }
    double d1 = paramLong1;
    Double.isNaN(d1);
    d1 /= 1000.0D;
    double d2 = paramLong2;
    Double.isNaN(d2);
    d2 /= 1000.0D;
    String str1 = String.format("%.2f", new Object[] { Double.valueOf(d1) });
    String str2 = String.format("%.2f", new Object[] { Double.valueOf(d2) });
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str1);
    localStringBuilder.append(";");
    localStringBuilder.append(str2);
    str2 = localStringBuilder.toString();
    if (paramInt1 == 2) {
      str1 = paramString;
    } else {
      str1 = "";
    }
    ReportController.b(paramQQAppInterface, "dc00898", "", paramString, "0X8009AA6", "0X8009AA6", paramInt1, 0, String.valueOf(paramInt2), String.valueOf(paramInt3), str2, str1);
  }
  
  public static RoundRectBitmap resizeAndClipBitmap(Bitmap paramBitmap, DownloadParams paramDownloadParams, ThumbWidthHeightDP paramThumbWidthHeightDP, boolean paramBoolean)
  {
    label512:
    try
    {
      f3 = BaseApplicationImpl.getApplication().getResources().getDisplayMetrics().density;
      i6 = BaseApplicationImpl.getApplication().getResources().getDisplayMetrics().densityDpi;
      f4 = URLDrawableHelper.getRoundCorner();
      i = CommonImgThumbHelper.getImgThumbMinPx(paramBoolean);
      j = CommonImgThumbHelper.getImgThumbMinPx(paramBoolean);
      k = CommonImgThumbHelper.getImgThumbMaxPx(paramBoolean);
      m = CommonImgThumbHelper.getImgThumbMaxPx(paramBoolean);
      if (paramThumbWidthHeightDP != null)
      {
        i = AIOUtils.b(paramThumbWidthHeightDP.mMinWidth, BaseApplicationImpl.getApplication().getResources());
        j = AIOUtils.b(paramThumbWidthHeightDP.mMinHeight, BaseApplicationImpl.getApplication().getResources());
        k = AIOUtils.b(paramThumbWidthHeightDP.mMaxWidth, BaseApplicationImpl.getApplication().getResources());
        m = AIOUtils.b(paramThumbWidthHeightDP.mMaxHeight, BaseApplicationImpl.getApplication().getResources());
      }
      n = paramBitmap.getWidth();
      i2 = paramBitmap.getHeight();
      paramDownloadParams = new Paint(1);
      paramDownloadParams.setColor(-16777216);
      i1 = CommonImgThumbHelper.getImgThumbMinDp(paramBoolean);
      i3 = CommonImgThumbHelper.getImgThumbMinDp(paramBoolean);
      i4 = CommonImgThumbHelper.getImgThumbMaxDp(paramBoolean);
      i5 = CommonImgThumbHelper.getImgThumbMaxDp(paramBoolean);
      if (paramThumbWidthHeightDP == null) {
        break label421;
      }
      i1 = paramThumbWidthHeightDP.mMinWidth;
      i3 = paramThumbWidthHeightDP.mMinHeight;
      i4 = paramThumbWidthHeightDP.mMaxWidth;
      i5 = paramThumbWidthHeightDP.mMaxHeight;
    }
    catch (OutOfMemoryError paramDownloadParams)
    {
      label421:
      label587:
      label590:
      for (;;)
      {
        float f3;
        int i6;
        float f4;
        int i;
        int j;
        int k;
        int m;
        int n;
        int i2;
        int i1;
        int i3;
        int i4;
        int i5;
        Object localObject1;
        Object localObject2;
        continue;
        float f2 = n;
        float f1 = i2;
        float f5 = f1 * 3.0F;
        if (f2 > f5)
        {
          n = (int)f5;
        }
        else
        {
          f2 *= 3.0F;
          if (f1 > f2) {
            i2 = (int)f2;
          }
        }
        if ((n >= i1) && (i2 >= i3)) {
          if ((n < i4) && (i2 < i5))
          {
            f1 = f3;
            i = (int)(n * f1 + 0.5F);
            j = (int)(i2 * f1 + 0.5F);
          }
          else if (n > i2)
          {
            f1 = k;
            f2 = n;
          }
          else
          {
            f1 = m;
            f2 = i2;
            continue;
            f1 = i;
            f2 = n;
          }
        }
      }
    }
    f5 = localObject1 / localObject2;
    if (n > i2)
    {
      f1 = j;
      f2 = i2;
      f1 /= f2;
      f1 = Math.max(f5, f1);
      break label512;
      if (n < i2)
      {
        f1 = i / n;
        j = (int)(i2 * f1 + 0.5F);
        if (j <= m) {
          break label587;
        }
        j = m;
        break label590;
      }
      f1 = j / i2;
      i = (int)(n * f1 + 0.5F);
      if (i <= k) {
        break label590;
      }
      i = k;
      break label590;
      paramThumbWidthHeightDP = Bitmap.createBitmap(i, j, URLDrawableHelper.mThumbConfig);
      paramThumbWidthHeightDP.setDensity(i6);
      new Canvas(paramThumbWidthHeightDP).drawBitmap(paramBitmap, new Rect(0, 0, n, i2), new Rect(0, 0, i, j), paramDownloadParams);
      paramDownloadParams = new RoundRectBitmap(paramThumbWidthHeightDP, f4 * f3);
      return paramDownloadParams;
      return new RoundRectBitmap(paramBitmap, URLDrawableHelper.getRoundCorner());
    }
  }
  
  public static Bitmap resizeThumb(Bitmap paramBitmap)
  {
    if (paramBitmap == null) {
      return null;
    }
    int i;
    int j;
    int k;
    int m;
    label245:
    label247:
    do
    {
      try
      {
        i = paramBitmap.getWidth();
        j = paramBitmap.getHeight();
        localObject = calculateScaledThumbWH(paramBitmap);
        if (localObject != null) {
          break label247;
        }
        return null;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        Object localObject;
        float f1;
        float f2;
        float f3;
        float f4;
        Canvas localCanvas;
        RectF localRectF;
        Paint localPaint;
        if (!QLog.isColorLevel()) {
          break label245;
        }
        QLog.e("ShortVideoUtils", 2, "resizeThumb, OutOfMemoryError ", localOutOfMemoryError);
        return paramBitmap;
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("resizeThumb ==> dstW:");
        ((StringBuilder)localObject).append(k);
        ((StringBuilder)localObject).append(", dstH:");
        ((StringBuilder)localObject).append(m);
        QLog.d("ShortVideoUtils", 2, ((StringBuilder)localObject).toString());
      }
      f1 = k;
      f2 = f1 / i;
      f3 = m;
      f4 = f3 / j;
      localObject = new Matrix();
      ((Matrix)localObject).postScale(f2, f4);
      localObject = Bitmap.createBitmap(paramBitmap, 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), (Matrix)localObject, true);
      localCanvas = new Canvas((Bitmap)localObject);
      localRectF = new RectF(0.0F, 0.0F, f1, f3);
      localPaint = new Paint(1);
      localPaint.setColor(-16777216);
      localPaint.setAntiAlias(true);
      localCanvas.drawBitmap(paramBitmap, null, localRectF, localPaint);
      if ((paramBitmap != null) && (!paramBitmap.isRecycled())) {
        paramBitmap.recycle();
      }
      return localObject;
      k = localOutOfMemoryError[0];
      m = localOutOfMemoryError[1];
    } while ((i != k) || (j != m));
    return paramBitmap;
  }
  
  public static void setAEPituCameraTaKeSameSwitch(boolean paramBoolean)
  {
    SharedPreferences.Editor localEditor = BaseApplicationImpl.getApplication().getSharedPreferences("ptv_and_hot_pic_reddot_sp", 4).edit();
    localEditor.putBoolean("short_video_ae_pitu_takesame_switch", paramBoolean);
    localEditor.apply();
  }
  
  public static void setHotPiCRedDotConfigVersion(String paramString, int paramInt)
  {
    SharedPreferences.Editor localEditor = BaseApplicationImpl.getApplication().getSharedPreferences("ptv_and_hot_pic_reddot_sp", 4).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("short_video_hotpic_pic_version_");
    localStringBuilder.append(paramString);
    localEditor.putInt(localStringBuilder.toString(), paramInt);
    localEditor.apply();
  }
  
  public static void setHotPicRedDotStatus(String paramString, boolean paramBoolean)
  {
    SharedPreferences.Editor localEditor = BaseApplicationImpl.getApplication().getSharedPreferences("ptv_and_hot_pic_reddot_sp", 4).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("short_video_hotpic_show_pic_");
    localStringBuilder.append(paramString);
    localEditor.putBoolean(localStringBuilder.toString(), paramBoolean);
    localEditor.apply();
  }
  
  public static void setPtvRedDotConfigVersion(String paramString, int paramInt)
  {
    SharedPreferences.Editor localEditor = BaseApplicationImpl.getApplication().getSharedPreferences("ptv_and_hot_pic_reddot_sp", 4).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("short_video_hotpic_ptv_version_");
    localStringBuilder.append(paramString);
    localEditor.putInt(localStringBuilder.toString(), paramInt);
    localEditor.apply();
  }
  
  public static void setPtvRedDotStatus(String paramString, boolean paramBoolean)
  {
    SharedPreferences.Editor localEditor = BaseApplicationImpl.getApplication().getSharedPreferences("ptv_and_hot_pic_reddot_sp", 4).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("short_video_hotpic_show_ptv_");
    localStringBuilder.append(paramString);
    localEditor.putBoolean(localStringBuilder.toString(), paramBoolean);
    localEditor.apply();
  }
  
  public static void setRecentPOI(String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString1))
    {
      SharedPreferences.Editor localEditor = getSharedPref("sp_user_cache_data").edit();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("recent_poi_");
      localStringBuilder.append(paramString1);
      localEditor.putString(localStringBuilder.toString(), paramString2).apply();
    }
  }
  
  public static void startShortVideoPlayActivity(MessageForShortVideo paramMessageForShortVideo, Activity paramActivity, int paramInt1, String paramString, Rect paramRect, int paramInt2)
  {
    String str = SVUtils.a(paramMessageForShortVideo.thumbMD5, "jpg");
    Bundle localBundle = new Bundle();
    localBundle.putInt("uintype", paramMessageForShortVideo.istroop);
    localBundle.putString("from_uin", SVUtils.a(paramMessageForShortVideo));
    localBundle.putInt("from_uin_type", paramInt1);
    localBundle.putString("from_session_uin", paramString);
    localBundle.putInt("from_busi_type", paramMessageForShortVideo.busiType);
    localBundle.putInt("file_send_size", paramMessageForShortVideo.videoFileSize);
    localBundle.putInt("file_send_duration", paramMessageForShortVideo.videoFileTime);
    localBundle.putString("file_name", paramMessageForShortVideo.videoFileName);
    localBundle.putInt("file_format", paramMessageForShortVideo.videoFileFormat);
    localBundle.putString("thumbfile_send_path", str);
    localBundle.putString("file_shortvideo_md5", paramMessageForShortVideo.md5);
    localBundle.putInt("thumbfile_send_width", paramMessageForShortVideo.thumbWidth);
    localBundle.putInt("thumbfile_send_height", paramMessageForShortVideo.thumbHeight);
    localBundle.putString("thumbfile_md5", paramMessageForShortVideo.thumbMD5);
    localBundle.putString("file_source", paramMessageForShortVideo.fileSource);
    localBundle.putString("file_uuid", paramMessageForShortVideo.uuid);
    localBundle.putInt("file_thumb_Size", paramMessageForShortVideo.thumbFileSize);
    localBundle.putBoolean("support_progressive", paramMessageForShortVideo.supportProgressive);
    localBundle.putInt("file_width", paramMessageForShortVideo.fileWidth);
    localBundle.putInt("file_height", paramMessageForShortVideo.fileHeight);
    localBundle.putParcelable("KEY_THUMBNAL_BOUND", paramRect);
    localBundle.putInt("video_play_caller", 0);
    localBundle.putParcelable("key_message_for_shortvideo", paramMessageForShortVideo);
    localBundle.putLong("message_click_start", System.currentTimeMillis());
    localBundle.putInt("extra.EXTRA_ENTRANCE", paramInt2);
    if (paramMessageForShortVideo.checkIsHotVideo())
    {
      localBundle.putBoolean("is_hotVideo", true);
      localBundle.putString("hot_video_icon", paramMessageForShortVideo.hotVideoIconUrl);
      localBundle.putString("hot_video_icon_sub", paramMessageForShortVideo.hotVideoSubIconUrl);
      localBundle.putString("hot_video_title", paramMessageForShortVideo.hotVideoTitle);
      localBundle.putString("hot_video_url", paramMessageForShortVideo.hotVideoUrl);
    }
    localBundle.putInt("special_video_type", paramMessageForShortVideo.specialVideoType);
    localBundle.putInt("short_video_msg_tail_type", paramMessageForShortVideo.msgTailType);
    paramMessageForShortVideo = new Intent(paramActivity, ShortVideoPlayActivity.class);
    paramMessageForShortVideo.putExtras(localBundle);
    paramActivity.startActivityForResult(paramMessageForShortVideo, 13002);
    paramActivity.overridePendingTransition(2130772090, 2130772092);
  }
  
  public static String stringForFileSize(Context paramContext, long paramLong)
  {
    String str = Formatter.formatShortFileSize(paramContext, paramLong);
    int i = str.length();
    paramContext = str;
    if (i > 3) {
      paramContext = str.substring(0, i - 1);
    }
    return paramContext.replace(" ", "");
  }
  
  public static String stringForTime(long paramLong)
  {
    int k = (int)paramLong / 1000;
    int i = k % 60;
    int j = k / 60 % 60;
    k /= 3600;
    if (k > 0) {
      return String.format("%d:%02d:%02d", new Object[] { Integer.valueOf(k), Integer.valueOf(j), Integer.valueOf(i) }).toString();
    }
    return String.format("%02d:%02d", new Object[] { Integer.valueOf(j), Integer.valueOf(i) }).toString();
  }
  
  public static boolean supportShortVideoMergePhoto()
  {
    if (!sSupportPhotoMergeInited)
    {
      sSupportPhotoMergeInited = true;
      try
      {
        Object localObject = ((IDPCApi)QRoute.api(IDPCApi.class)).getFeatureValue(DPCNames.aio_config.name(), "");
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("supportShortVideoMergePhoto:");
          localStringBuilder.append((String)localObject);
          QLog.d("ShortVideoUtils", 2, localStringBuilder.toString());
        }
        localObject = ((String)localObject).split("\\|");
        if (localObject.length > 10)
        {
          int i = Integer.valueOf(localObject[10]).intValue();
          if ((i >= 0) && (i <= 1)) {
            mSupportPhotoMerge = i;
          }
        }
      }
      catch (Exception localException)
      {
        StringBuilder localStringBuilder;
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("supportShortVideoMergePhoto e:");
          localStringBuilder.append(localException.toString());
          QLog.d("ShortVideoUtils", 2, localStringBuilder.toString());
        }
      }
    }
    return mSupportPhotoMerge == 1;
  }
  
  public static boolean verifyFileModifyTime(String paramString, long paramLong)
  {
    boolean bool3 = TextUtils.isEmpty(paramString);
    boolean bool2 = false;
    boolean bool1 = false;
    if ((!bool3) && (0L != paramLong))
    {
      long l1 = System.currentTimeMillis();
      paramString = new File(paramString);
      long l2 = paramString.length();
      if (paramString.isFile())
      {
        if (l2 <= 0L) {
          return false;
        }
        if (paramLong == paramString.lastModified()) {
          bool1 = true;
        }
        paramLong = System.currentTimeMillis();
        bool2 = bool1;
        if (QLog.isColorLevel())
        {
          paramString = new StringBuilder();
          paramString.append(" verifyFileModifyTime(), result = ");
          paramString.append(bool1);
          paramString.append(", cost time: ");
          paramString.append(paramLong - l1);
          paramString.append(" ms");
          QLog.d("ShortVideoUtils", 2, paramString.toString());
          bool2 = bool1;
        }
      }
      return bool2;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoUtils", 2, " verifyFileModifyTime(), filePath or lastModifyTime is vilid.");
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.ShortVideoUtils
 * JD-Core Version:    0.7.0.1
 */