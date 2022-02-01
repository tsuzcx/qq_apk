package com.tencent.mobileqq.shortvideo;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.media.MediaMetadataRetriever;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.format.Formatter;
import android.widget.Toast;
import aqmy;
import bdjr;
import bdjs;
import bdla;
import com.tencent.biz.qqstory.base.videoupload.VideoCompositeHelper;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.shortvideo.ShortVideoPlayActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.shortvideo.util.VidUtil;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.transfile.richmediavfs.RmVFSUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.os.MqqHandler;
import vzh;

public class ShortVideoUtils
  implements ShortVideoConstants
{
  private static final int CLEAN_TEMP_FILE_INTERVAL = 604800000;
  private static String[] FULL_SCREEN_BLACK_LIST = { "GT-N7108" };
  public static final int MERGE_TIPS_SHOW_TIME = 3;
  public static final int MSG_SAVE_DISMISS = 10003;
  public static final int MSG_SAVE_FAILED = 10001;
  public static final int MSG_SAVE_SUCCESS = 10000;
  private static final String PRIVATE_DIR;
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
  public static final String VIDEO_DIR = "shortvideo";
  public static final int VIDEO_THUMBNAIL_MAX_LENGTH_DEFAULT = 640;
  public static boolean isHotPicConfiginitied;
  public static boolean isPtvConfiginitied;
  private static boolean mBlockBrokenVideo;
  private static AtomicInteger mDefaultShortVideoPreDownloadStrategy;
  private static int mDefaultShortVideoPreDownloadTime;
  private static volatile boolean mSoLoadState;
  private static int mSupportPhotoMerge;
  public static boolean sBlockBrokenVideoInited;
  private static boolean sDarkModeInited;
  private static int[] sDarkModeValues;
  public static boolean sPredownloadShortVideoInited;
  private static boolean sShutdownSkipClipPhoto;
  private static boolean sShutdownSkipClipPhotoInited;
  public static boolean sSupportDownloadSo;
  private static boolean sSupportPhotoMergeInited;
  public static boolean sSupportShortVideo = true;
  
  static
  {
    sSupportDownloadSo = true;
    mBlockBrokenVideo = true;
    mDefaultShortVideoPreDownloadStrategy = new AtomicInteger(0);
    mDefaultShortVideoPreDownloadTime = 2;
    mSupportPhotoMerge = 1;
    sDarkModeValues = new int[] { 1, 97, 125 };
    ThreadManager.getSubThreadHandler().post(new ShortVideoUtils.1());
    PRIVATE_DIR = RmVFSUtils.getVFSPath(AppConstants.SDCARD_PATH);
  }
  
  public static native int adjustMoovPosition(String paramString1, String paramString2);
  
  public static int[] adjustSize(int paramInt1, int paramInt2)
  {
    int j;
    int k;
    label13:
    int i;
    int m;
    if (paramInt1 > 0)
    {
      j = paramInt1;
      if (paramInt2 <= 0) {
        break label226;
      }
      k = paramInt2;
      i = (int)(BaseChatItemLayout.f + 0.5D);
      m = URLDrawableHelper.getVideoThumbMaxDp();
      if (m < 135) {
        break label340;
      }
      m = AIOUtils.dp2px(m, BaseApplicationImpl.getApplication().getResources());
      if (m >= i) {
        break label340;
      }
      i = m;
    }
    label81:
    label340:
    for (;;)
    {
      m = AIOUtils.dp2px(305.0F, BaseApplicationImpl.getApplication().getResources());
      label90:
      String str;
      if (i > m)
      {
        i = m;
        if (j < k) {
          break label236;
        }
        m = 1;
        if (m == 0) {
          break label291;
        }
        if (j / k <= 1.555556F) {
          break label242;
        }
        str = "landscape close to 16:9";
        j = (int)(i * 9.0F / 16.0F + 0.5D);
        k = i;
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoUtils", 2, "adjustSize " + str + " maxPixel:" + i + " ow:" + paramInt1 + " oh:" + paramInt2 + " w:" + k + " h:" + j);
        }
        return new int[] { k, j };
        j = 100;
        break;
        label226:
        k = 100;
        break label13;
        break label81;
        label236:
        m = 0;
        break label90;
        label242:
        if (j / k > 1.166667F)
        {
          str = "landscape close to 4:3";
          j = (int)(i * 3.0F / 4.0F + 0.5D);
          k = i;
        }
        else
        {
          str = "landscape close to 1:1";
          j = i;
          k = i;
          continue;
          if (k / j > 1.3F)
          {
            str = "portrait close to 10:16";
            k = (int)(i * 10.0F / 16.0F + 0.5D);
            j = i;
          }
          else
          {
            str = "portrait close to 1:1";
            j = i;
            k = i;
          }
        }
      }
    }
  }
  
  public static int[] calculateScaledThumbWH(Bitmap paramBitmap)
  {
    if (paramBitmap == null) {
      if (QLog.isColorLevel()) {
        QLog.e("ShortVideoUtils", 2, "calculateThumbWH, bitmap == null ！");
      }
    }
    do
    {
      return null;
      if (!paramBitmap.isRecycled()) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e("ShortVideoUtils", 2, "calculateThumbWH, bitmap isRecycled !");
    return null;
    return calculateScaledThumbWH(new int[] { paramBitmap.getWidth(), paramBitmap.getHeight() });
  }
  
  public static int[] calculateScaledThumbWH(int[] paramArrayOfInt)
  {
    float f2 = 2.0F;
    int i = 160;
    int j = 80;
    if (paramArrayOfInt == null) {
      return null;
    }
    int k = paramArrayOfInt[0];
    int m = paramArrayOfInt[1];
    if ((k == 0) || (m == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.e("ShortVideoUtils", 2, "calculateThumbWH, w or h == 0 !");
      }
      return null;
    }
    float f1;
    if (m > k)
    {
      f1 = m / k;
      if (f1 <= 2.0F) {
        break label129;
      }
      f1 = f2;
      label76:
      if (m <= k) {
        break label152;
      }
      if (m <= 160) {
        break label132;
      }
    }
    for (;;)
    {
      label91:
      k = (int)(i / f1);
      if (k < 80) {}
      for (;;)
      {
        return new int[] { j, i };
        f1 = k / m;
        break;
        label129:
        break label76;
        label132:
        if (m >= 100) {
          break label213;
        }
        i = 100;
        break label91;
        j = k;
      }
      label152:
      if (k > 160) {}
      for (;;)
      {
        label160:
        k = (int)(i / f1);
        if (k < 80) {}
        for (;;)
        {
          k = i;
          i = j;
          j = k;
          break;
          if (k >= 100) {
            break label207;
          }
          i = 100;
          break label160;
          j = k;
        }
        label207:
        i = k;
      }
      label213:
      i = m;
    }
  }
  
  public static boolean canRecordShortVideo()
  {
    Object localObject = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.pg_switch.name(), "1|1|1");
    if (QLog.isDevelopLevel()) {
      QLog.d("peak_pgjpeg", 4, "DeviceProfileManager.DpcNames.pg_switch value " + (String)localObject);
    }
    localObject = ((String)localObject).split("\\|");
    if (localObject.length < 3) {
      return false;
    }
    return localObject[2].equals("1");
  }
  
  public static boolean checkEntranceType(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return false;
    }
    return true;
  }
  
  public static boolean checkShortVideoSoReadyToLoad(AppInterface paramAppInterface)
  {
    try
    {
      if (VideoEnvironment.supportShortVideoRecordAndPlay(paramAppInterface))
      {
        if (isVideoSoLibLoaded()) {
          return true;
        }
        boolean bool = VideoEnvironment.checkShortVideoSoReadyToLoad();
        return bool;
      }
    }
    catch (Exception paramAppInterface)
    {
      paramAppInterface.printStackTrace();
      if (QLog.isColorLevel()) {
        QLog.e("ShortVideoUtils", 2, "checkShortVideoSoReadyToLoad failure.", paramAppInterface);
      }
    }
    return false;
  }
  
  public static void deleteCacheFileByMsg(MessageForShortVideo paramMessageForShortVideo)
  {
    if (paramMessageForShortVideo == null) {}
    do
    {
      return;
      if (!TextUtils.isEmpty(paramMessageForShortVideo.getMd5())) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e("ShortVideoUtils", 2, "deleteCacheFileByMessage, md5 == null! ");
    return;
    FileUtils.deleteFile(getShortVideoSavePath(paramMessageForShortVideo, "mp4"));
  }
  
  public static void deleteDownloadTempFile()
  {
    deleteDownloadTempFile("", false);
  }
  
  public static void deleteDownloadTempFile(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoUtils", 2, "deleteDownloadTempFile, exclude :" + paramString + ",compareModifiedTime : " + paramBoolean);
    }
    Object localObject = new File(getShortVideoSaveDir());
    if (!((File)localObject).exists()) {}
    File[] arrayOfFile;
    for (;;)
    {
      return;
      localObject = ((File)localObject).listFiles();
      if (localObject != null)
      {
        int k = localObject.length;
        int i = 0;
        while (i < k)
        {
          arrayOfFile = localObject[i].listFiles();
          if (arrayOfFile != null) {
            break label109;
          }
          i += 1;
        }
      }
    }
    label109:
    int m = arrayOfFile.length;
    int j = 0;
    label116:
    File localFile;
    if (j < m)
    {
      localFile = arrayOfFile[j];
      if (!localFile.getName().equals(paramString)) {
        break label147;
      }
    }
    for (;;)
    {
      j += 1;
      break label116;
      break;
      label147:
      if ((localFile.isFile()) && (localFile.getName().contains(".tmp"))) {
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
    }
  }
  
  public static boolean ensureShortVideoSoLoaded(AppInterface paramAppInterface)
  {
    if (isVideoSoLibLoaded()) {}
    do
    {
      return true;
      loadShortVideoSo(paramAppInterface);
    } while (isVideoSoLibLoaded());
    return false;
  }
  
  @Deprecated
  public static String findVideoPathIfExists(MessageForShortVideo paramMessageForShortVideo)
  {
    if (paramMessageForShortVideo == null) {}
    do
    {
      do
      {
        return null;
        String str = getShortVideoSavePath(paramMessageForShortVideo, "mp4");
        if (FileUtils.fileExistsAndNotEmpty(str)) {
          return str;
        }
      } while (!paramMessageForShortVideo.isSendFromLocal());
      paramMessageForShortVideo = paramMessageForShortVideo.videoFileName;
    } while (!FileUtils.fileExistsAndNotEmpty(paramMessageForShortVideo));
    return paramMessageForShortVideo;
  }
  
  public static String getCameraPath()
  {
    String str = Build.MODEL.toUpperCase();
    if (str.contains("GN9000L")) {
      str = AppConstants.SDCARD_IMG_VIDEO_GN9000L;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoUtils", 2, "getCameraPath: commonPath=" + str);
      }
      return str;
      if ((str.contains("MX4")) || (str.contains("MX6")) || (str.contains("MX5")) || (str.contains("M355")) || (str.contains("M571C"))) {
        str = AppConstants.SDCARD_IMG_VIDEO;
      } else if (str.contains("M040")) {
        str = AppConstants.SDCARD_IMG_VIDEO_RUBBISH_MX040;
      } else if ((str.contains("VIVO X7")) || (str.contains("VIVO X6A")) || (str.contains("VIVO XPLAY6")) || (str.contains("VIVO X5PRO")) || (str.contains("VIVO X9 PLUS")) || (str.contains("VIVO Y51A")) || (str.contains("VIVO X9I")) || (str.contains("VIVO X9")) || (str.contains("VIVO X6D"))) {
        str = AppConstants.SDCARD_IMG_VIDEO_VIVO_X7;
      } else {
        str = AppConstants.SDCARD_IMG_CAMERA;
      }
    }
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
    return (int)((100 - paramInt2) * paramInt1 / 100.0F + paramInt2);
  }
  
  public static String getDownloadTmpPath(MessageForShortVideo paramMessageForShortVideo)
  {
    return getShortVideoSavePath(paramMessageForShortVideo, "mp4") + "." + MD5.toMD5(paramMessageForShortVideo.uuid) + ".tmp";
  }
  
  public static long getDuration(String paramString)
  {
    if (!new File(paramString).exists())
    {
      if (QLog.isColorLevel()) {
        QLog.e("ShortVideoUtils", 2, "Path:" + paramString + ", not exits!");
      }
      return -1L;
    }
    MediaPlayer localMediaPlayer = new MediaPlayer();
    try
    {
      localMediaPlayer.setDataSource(paramString);
      localMediaPlayer.prepare();
      int i = localMediaPlayer.getDuration();
      long l = i;
      return l;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoUtils", 2, "getDuration", paramString);
      }
      return -1L;
    }
    finally
    {
      localMediaPlayer.release();
    }
  }
  
  @TargetApi(14)
  public static long getDurationOfVideo(String paramString)
  {
    if (!FileUtils.fileExists(paramString)) {
      return 0L;
    }
    return VideoCompositeHelper.getDurationOfVideo(paramString);
  }
  
  public static String getFileStatusStr(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return " [STATUS_UNKNOW " + paramInt + "]";
    case 2004: 
      return " [STATUS_RECV_CANCEL] ";
    case 2005: 
      return " [STATUS_RECV_ERROR] ";
    case 2003: 
      return " [STATUS_RECV_FINISHED] ";
    case 2002: 
      return " [STATUS_RECV_PROCESS] ";
    case 2001: 
      return " [STATUS_RECV_START] ";
    case 2008: 
      return " [STATUS_RECV_PREPARED] ";
    case 2000: 
      return " [STATUS_RECV_REQUEST] ";
    case 999: 
      return " [STATUS_SEND_PREPARE] ";
    case 1000: 
      return " [STATUS_SEND_REQUEST] ";
    case 1001: 
      return " [STATUS_SEND_START] ";
    case 1004: 
      return " [STATUS_SEND_CANCEL] ";
    case 1002: 
      return " [STATUS_SEND_PROCESS] ";
    case 1003: 
      return " [STATUS_SEND_FINISHED] ";
    case 1007: 
      return " [STATUS_UPLOAD_FINISHED] ";
    case 1005: 
      return " [STATUS_SEND_ERROR] ";
    case 5001: 
      return " [STATUS_FILE_UNSAFE] ";
    }
    return " [STATUS_FILE_EXPIRED] ";
  }
  
  public static String getFileTypeStr(int paramInt)
  {
    switch (paramInt)
    {
    case 8: 
    case 10: 
    case 11: 
    case 12: 
    case 13: 
    case 14: 
    case 15: 
    case 19: 
    default: 
      return " [TYPE_NONE " + paramInt + " ]";
    case 6: 
      return " [TYPE_VIDEO_C2C] ";
    case 7: 
      return " [TYPE_VIDEO_THUMB_C2C] ";
    case 17: 
      return " [TYPE_VIDEO_DISUSS]";
    case 18: 
      return " [TYPE_VIDEO_THUMB_DISUSS] ";
    case 9: 
      return " [TYPE_VIDEO_TROOP]";
    case 16: 
      return " [TYPE_VIDEO_THUMB_TROOP] ";
    }
    return " [TYPE_VIDEO_FORWARD] ";
  }
  
  public static String getFromUinForForward(MessageForShortVideo paramMessageForShortVideo)
  {
    if (paramMessageForShortVideo.isSend()) {
      return paramMessageForShortVideo.selfuin;
    }
    if ((paramMessageForShortVideo.istroop == 1) || (paramMessageForShortVideo.istroop == 3000)) {
      return paramMessageForShortVideo.senderuin;
    }
    return paramMessageForShortVideo.frienduin;
  }
  
  public static int getHotPiCRedDotConfigVersion(String paramString)
  {
    return BaseApplicationImpl.getApplication().getSharedPreferences("ptv_and_hot_pic_reddot_sp", 4).getInt("short_video_hotpic_pic_version_" + paramString, 0);
  }
  
  public static boolean getHotPicRedDotStatus(String paramString)
  {
    return BaseApplicationImpl.getApplication().getSharedPreferences("ptv_and_hot_pic_reddot_sp", 4).getBoolean("short_video_hotpic_show_pic_" + paramString, false);
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
      localStringBuilder1.append(VidUtil.generateVid()).append(".mp4");
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
    return vzh.e + paramFile + ".mp4";
  }
  
  /* Error */
  public static String getMp4VideoMoovInfo(File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 11
    //   3: iconst_0
    //   4: istore_1
    //   5: iconst_4
    //   6: newarray byte
    //   8: astore 10
    //   10: iconst_4
    //   11: newarray byte
    //   13: astore 12
    //   15: lconst_0
    //   16: lstore 5
    //   18: bipush 8
    //   20: invokestatic 668	java/nio/ByteBuffer:allocate	(I)Ljava/nio/ByteBuffer;
    //   23: astore 13
    //   25: new 670	java/io/FileInputStream
    //   28: dup
    //   29: aload_0
    //   30: invokespecial 673	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   33: astore 9
    //   35: iconst_0
    //   36: istore_2
    //   37: iload_1
    //   38: bipush 100
    //   40: if_icmpge +292 -> 332
    //   43: aload 9
    //   45: astore_0
    //   46: aload 9
    //   48: aload 10
    //   50: invokevirtual 679	java/io/InputStream:read	([B)I
    //   53: istore_3
    //   54: iload_3
    //   55: ifgt +41 -> 96
    //   58: aload 9
    //   60: ifnull +8 -> 68
    //   63: aload 9
    //   65: invokevirtual 682	java/io/InputStream:close	()V
    //   68: new 200	java/lang/StringBuilder
    //   71: dup
    //   72: invokespecial 201	java/lang/StringBuilder:<init>	()V
    //   75: iload_2
    //   76: invokevirtual 212	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   79: ldc_w 684
    //   82: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: lload 5
    //   87: invokevirtual 687	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   90: invokevirtual 224	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   93: astore_0
    //   94: aload_0
    //   95: areturn
    //   96: aload 9
    //   98: astore_0
    //   99: aload 13
    //   101: iconst_4
    //   102: newarray byte
    //   104: invokevirtual 691	java/nio/ByteBuffer:put	([B)Ljava/nio/ByteBuffer;
    //   107: pop
    //   108: aload 9
    //   110: astore_0
    //   111: aload 13
    //   113: aload 10
    //   115: invokevirtual 691	java/nio/ByteBuffer:put	([B)Ljava/nio/ByteBuffer;
    //   118: pop
    //   119: aload 9
    //   121: astore_0
    //   122: aload 13
    //   124: invokevirtual 695	java/nio/ByteBuffer:flip	()Ljava/nio/Buffer;
    //   127: pop
    //   128: aload 9
    //   130: astore_0
    //   131: aload 13
    //   133: invokevirtual 698	java/nio/ByteBuffer:getLong	()J
    //   136: lstore 7
    //   138: aload 9
    //   140: astore_0
    //   141: iload_3
    //   142: aload 9
    //   144: aload 12
    //   146: invokevirtual 679	java/io/InputStream:read	([B)I
    //   149: iadd
    //   150: istore 4
    //   152: iload 4
    //   154: istore_3
    //   155: lload 7
    //   157: lstore 5
    //   159: lload 7
    //   161: lconst_1
    //   162: lcmp
    //   163: ifne +172 -> 335
    //   166: aload 9
    //   168: astore_0
    //   169: bipush 8
    //   171: newarray byte
    //   173: astore 14
    //   175: aload 9
    //   177: astore_0
    //   178: iload 4
    //   180: aload 9
    //   182: aload 14
    //   184: invokevirtual 679	java/io/InputStream:read	([B)I
    //   187: iadd
    //   188: istore_3
    //   189: aload 9
    //   191: astore_0
    //   192: aload 13
    //   194: invokevirtual 701	java/nio/ByteBuffer:clear	()Ljava/nio/Buffer;
    //   197: pop
    //   198: aload 9
    //   200: astore_0
    //   201: aload 13
    //   203: aload 14
    //   205: invokevirtual 691	java/nio/ByteBuffer:put	([B)Ljava/nio/ByteBuffer;
    //   208: pop
    //   209: aload 9
    //   211: astore_0
    //   212: aload 13
    //   214: invokevirtual 695	java/nio/ByteBuffer:flip	()Ljava/nio/Buffer;
    //   217: pop
    //   218: aload 9
    //   220: astore_0
    //   221: aload 13
    //   223: invokevirtual 698	java/nio/ByteBuffer:getLong	()J
    //   226: lstore 5
    //   228: goto +107 -> 335
    //   231: aload 9
    //   233: astore_0
    //   234: aload 9
    //   236: lload 5
    //   238: iload_3
    //   239: i2l
    //   240: lsub
    //   241: invokevirtual 705	java/io/InputStream:skip	(J)J
    //   244: pop2
    //   245: iload_2
    //   246: i2l
    //   247: lload 5
    //   249: ladd
    //   250: l2i
    //   251: istore_2
    //   252: aload 9
    //   254: astore_0
    //   255: aload 13
    //   257: invokevirtual 701	java/nio/ByteBuffer:clear	()Ljava/nio/Buffer;
    //   260: pop
    //   261: iload_1
    //   262: iconst_1
    //   263: iadd
    //   264: istore_1
    //   265: goto -228 -> 37
    //   268: astore 10
    //   270: aconst_null
    //   271: astore 9
    //   273: aload 9
    //   275: astore_0
    //   276: aload 10
    //   278: invokevirtual 325	java/lang/Exception:printStackTrace	()V
    //   281: aload 11
    //   283: astore_0
    //   284: aload 9
    //   286: ifnull -192 -> 94
    //   289: aload 9
    //   291: invokevirtual 682	java/io/InputStream:close	()V
    //   294: aconst_null
    //   295: areturn
    //   296: astore_0
    //   297: aconst_null
    //   298: areturn
    //   299: astore 9
    //   301: aconst_null
    //   302: astore_0
    //   303: aload_0
    //   304: ifnull +7 -> 311
    //   307: aload_0
    //   308: invokevirtual 682	java/io/InputStream:close	()V
    //   311: aload 9
    //   313: athrow
    //   314: astore_0
    //   315: goto -247 -> 68
    //   318: astore_0
    //   319: goto -8 -> 311
    //   322: astore 9
    //   324: goto -21 -> 303
    //   327: astore 10
    //   329: goto -56 -> 273
    //   332: goto -274 -> 58
    //   335: aload 12
    //   337: iconst_0
    //   338: baload
    //   339: i2c
    //   340: bipush 109
    //   342: if_icmpne -111 -> 231
    //   345: aload 12
    //   347: iconst_1
    //   348: baload
    //   349: i2c
    //   350: bipush 111
    //   352: if_icmpne -121 -> 231
    //   355: aload 12
    //   357: iconst_2
    //   358: baload
    //   359: i2c
    //   360: bipush 111
    //   362: if_icmpne -131 -> 231
    //   365: aload 12
    //   367: iconst_3
    //   368: baload
    //   369: i2c
    //   370: bipush 118
    //   372: if_icmpne -141 -> 231
    //   375: goto -317 -> 58
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	378	0	paramFile	File
    //   4	261	1	i	int
    //   36	216	2	j	int
    //   53	186	3	k	int
    //   150	38	4	m	int
    //   16	232	5	l1	long
    //   136	24	7	l2	long
    //   33	257	9	localFileInputStream	java.io.FileInputStream
    //   299	13	9	localObject1	Object
    //   322	1	9	localObject2	Object
    //   8	106	10	arrayOfByte1	byte[]
    //   268	9	10	localException1	Exception
    //   327	1	10	localException2	Exception
    //   1	281	11	localObject3	Object
    //   13	353	12	arrayOfByte2	byte[]
    //   23	233	13	localByteBuffer	java.nio.ByteBuffer
    //   173	31	14	arrayOfByte3	byte[]
    // Exception table:
    //   from	to	target	type
    //   25	35	268	java/lang/Exception
    //   289	294	296	java/lang/Exception
    //   25	35	299	finally
    //   63	68	314	java/lang/Exception
    //   307	311	318	java/lang/Exception
    //   46	54	322	finally
    //   99	108	322	finally
    //   111	119	322	finally
    //   122	128	322	finally
    //   131	138	322	finally
    //   141	152	322	finally
    //   169	175	322	finally
    //   178	189	322	finally
    //   192	198	322	finally
    //   201	209	322	finally
    //   212	218	322	finally
    //   221	228	322	finally
    //   234	245	322	finally
    //   255	261	322	finally
    //   276	281	322	finally
    //   46	54	327	java/lang/Exception
    //   99	108	327	java/lang/Exception
    //   111	119	327	java/lang/Exception
    //   122	128	327	java/lang/Exception
    //   131	138	327	java/lang/Exception
    //   141	152	327	java/lang/Exception
    //   169	175	327	java/lang/Exception
    //   178	189	327	java/lang/Exception
    //   192	198	327	java/lang/Exception
    //   201	209	327	java/lang/Exception
    //   212	218	327	java/lang/Exception
    //   221	228	327	java/lang/Exception
    //   234	245	327	java/lang/Exception
    //   255	261	327	java/lang/Exception
  }
  
  public static String getNetTypeStr(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "Others";
    case 1: 
      return "WIFI";
    case 2: 
      return "2G";
    case 3: 
      return "3G";
    }
    return "4G";
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
    return BaseApplicationImpl.getApplication().getSharedPreferences("ptv_and_hot_pic_reddot_sp", 4).getInt("short_video_hotpic_cfg_version_" + paramString, 0);
  }
  
  public static int getPtvRedDotConfigVersion(String paramString)
  {
    return BaseApplicationImpl.getApplication().getSharedPreferences("ptv_and_hot_pic_reddot_sp", 4).getInt("short_video_hotpic_ptv_version_" + paramString, 0);
  }
  
  public static boolean getPtvRedDotStatus(String paramString)
  {
    return BaseApplicationImpl.getApplication().getSharedPreferences("ptv_and_hot_pic_reddot_sp", 4).getBoolean("short_video_hotpic_show_ptv_" + paramString, false);
  }
  
  public static SharedPreferences getPtvTemplateSDKPref()
  {
    return BaseApplicationImpl.getApplication().getSharedPreferences("short_video_ptu_template_sdk_sp_" + BaseApplicationImpl.sProcessId, 0);
  }
  
  public static String getRecentPOI(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      throw new IllegalArgumentException("uin may be null, uin=" + paramString);
    }
    return getSharedPref("sp_user_cache_data").getString("recent_poi_" + paramString, null);
  }
  
  public static String getReqCmdStr(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return " shortvideo_cmd_unknow ";
    case 2: 
      return " shortvideo_cmd_download ";
    case 0: 
      return " shortvideo_cmd_send ";
    case 1: 
      return " shortvideo_cmd_resend ";
    case 3: 
      return " shortvideo_cmd_forward ";
    }
    return " shortvideo_cmd_reforward ";
  }
  
  public static SharedPreferences getSharedPref(String paramString)
  {
    return BaseApplicationImpl.getApplication().getSharedPreferences(paramString + "_" + BaseApplicationImpl.sProcessId, 0);
  }
  
  @TargetApi(9)
  public static String getShortVideoCompressPath(String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString1))
    {
      String str = MD5.toMD5(paramString1);
      StringBuilder localStringBuilder = new StringBuilder(PRIVATE_DIR);
      localStringBuilder.append("shortvideo");
      localStringBuilder.append(File.separator);
      localStringBuilder.append(str);
      localStringBuilder.append(".");
      localStringBuilder.append(paramString2);
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoUtils", 2, "getShortVideoCompressPath: sourcePath=" + paramString1 + "/n compressPath=" + localStringBuilder.toString());
      }
      return localStringBuilder.toString();
    }
    return null;
  }
  
  public static String getShortVideoFileDir(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder(PRIVATE_DIR);
    localStringBuilder.append("shortvideo");
    localStringBuilder.append(File.separator);
    localStringBuilder.append(paramString);
    localStringBuilder.append(File.separator);
    return localStringBuilder.toString();
  }
  
  @TargetApi(10)
  public static void getShortVideoInfo(Activity paramActivity, File paramFile)
  {
    long l = FileUtils.getFileSizes(paramFile.getAbsolutePath());
    paramActivity = new StringBuilder();
    paramActivity.append("VideoSize:");
    paramActivity.append(l / 1000L);
    paramActivity.append("KB\n");
    if (VersionUtils.isIceScreamSandwich())
    {
      MediaMetadataRetriever localMediaMetadataRetriever = new MediaMetadataRetriever();
      localMediaMetadataRetriever.setDataSource(paramFile.getAbsolutePath());
      paramFile = localMediaMetadataRetriever.extractMetadata(18);
      String str1 = localMediaMetadataRetriever.extractMetadata(19);
      String str2 = localMediaMetadataRetriever.extractMetadata(9);
      paramActivity.append("VideoResolution:" + paramFile + "*" + str1);
      paramActivity.append('\n');
      paramActivity.append("VideoDuration:" + str2 + "ms");
      localMediaMetadataRetriever.release();
    }
    Toast.makeText(BaseApplicationImpl.sApplication, paramActivity.toString(), 1).show();
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
    if ((paramFile == null) || (TextUtils.isEmpty(paramString))) {
      return null;
    }
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
  
  public static String getShortVideoPath(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder(getShortVideoSaveDir());
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
      StringBuilder localStringBuilder = new StringBuilder(PRIVATE_DIR);
      localStringBuilder.append("shortvideo");
      localStringBuilder.append(File.separator);
      localStringBuilder.append(str);
      localStringBuilder.append("_raw");
      localStringBuilder.append(".");
      localStringBuilder.append(paramString2);
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoUtils", 2, "getShortVideoCompressPath: sourcePath=" + paramString1 + "/n compressPath=" + localStringBuilder.toString());
      }
      return localStringBuilder.toString();
    }
    return null;
  }
  
  public static String getShortVideoSaveDir()
  {
    StringBuilder localStringBuilder = new StringBuilder(PRIVATE_DIR);
    localStringBuilder.append("shortvideo");
    localStringBuilder.append(File.separator);
    return localStringBuilder.toString();
  }
  
  public static String getShortVideoSaveFileName(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("QQ视频");
    localStringBuilder.append("_").append(paramString);
    return localStringBuilder.toString();
  }
  
  public static String getShortVideoSavePath(MessageForShortVideo paramMessageForShortVideo, String paramString)
  {
    int i = 0;
    paramString = realGetShortVideoSavePath(paramMessageForShortVideo, paramString);
    int j = paramMessageForShortVideo.videoFileStatus;
    switch (j)
    {
    }
    boolean bool2;
    for (boolean bool1 = true;; bool1 = false)
    {
      bool2 = bool1;
      if (paramMessageForShortVideo.isSendFromLocal())
      {
        bool2 = bool1;
        if (FileUtils.fileExistsAndNotEmpty(paramString)) {
          bool2 = false;
        }
      }
      paramMessageForShortVideo = getShortVideoFileDir(paramMessageForShortVideo.getMd5());
      localObject = new File(paramMessageForShortVideo);
      if (((File)localObject).exists()) {
        break;
      }
      ((File)localObject).mkdirs();
      FileUtils.createFileIfNotExits(paramMessageForShortVideo + ".nomedia");
      return paramString;
    }
    Object localObject = ((File)localObject).list();
    String str;
    if ((localObject != null) && (localObject.length > 0))
    {
      int k = localObject.length;
      for (;;)
      {
        if (i >= k) {
          break label384;
        }
        str = localObject[i];
        if ((!str.endsWith(".tmp")) && (!str.equals(".nomedia"))) {
          break;
        }
        i += 1;
      }
    }
    label384:
    for (paramMessageForShortVideo = paramMessageForShortVideo + str;; paramMessageForShortVideo = null)
    {
      if ((bool2) && (paramMessageForShortVideo != null) && (!new File(paramString).exists()))
      {
        long l1 = System.currentTimeMillis();
        if (paramMessageForShortVideo.equals(paramString)) {
          return paramString;
        }
        FileUtils.copyFile(paramMessageForShortVideo, paramString);
        if (QLog.isColorLevel()) {
          QLog.i("ShortVideoUtils", 2, "copy " + paramMessageForShortVideo + " to " + paramString);
        }
        long l2 = System.currentTimeMillis();
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoUtils", 2, "getShortVideoSavePath-----time: = " + (l2 - l1) + ", videoStatus:" + getFileStatusStr(j) + ", needCopy=" + bool2);
        }
      }
      return paramString;
    }
  }
  
  public static String getShortVideoThumbPicDir()
  {
    StringBuilder localStringBuilder = new StringBuilder(getShortVideoSaveDir());
    localStringBuilder.append("thumbs");
    localStringBuilder.append(File.separator);
    Object localObject = new File(localStringBuilder.toString());
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdirs();
    }
    localObject = localStringBuilder.toString() + ".nomedia";
    if (!new File((String)localObject).exists()) {
      FileUtils.createFileIfNotExits((String)localObject);
    }
    return localStringBuilder.toString();
  }
  
  public static String getShortVideoThumbPicPath(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder(getShortVideoThumbPicDir());
    localStringBuilder.append(paramString1);
    localStringBuilder.append(".");
    localStringBuilder.append(paramString2);
    return localStringBuilder.toString();
  }
  
  public static String getTempAudioPath(File paramFile)
  {
    if (paramFile == null) {
      return null;
    }
    paramFile = VidUtil.getVidFromSourceDirFile(paramFile);
    StringBuilder localStringBuilder = new StringBuilder(PRIVATE_DIR);
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
    StringBuilder localStringBuilder = new StringBuilder(PRIVATE_DIR);
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
  
  @SuppressLint({"InlinedApi"})
  public static int[] getVideoFileRtAndTime(String paramString)
  {
    int[] arrayOfInt = new int[3];
    int[] tmp7_5 = arrayOfInt;
    tmp7_5[0] = 0;
    int[] tmp11_7 = tmp7_5;
    tmp11_7[1] = 0;
    int[] tmp15_11 = tmp11_7;
    tmp15_11[2] = 0;
    tmp15_11;
    MediaMetadataRetriever localMediaMetadataRetriever;
    if (VersionUtils.isIceScreamSandwich()) {
      localMediaMetadataRetriever = new MediaMetadataRetriever();
    }
    for (;;)
    {
      int i;
      try
      {
        localMediaMetadataRetriever.setDataSource(paramString);
        String str2 = localMediaMetadataRetriever.extractMetadata(18);
        String str3 = localMediaMetadataRetriever.extractMetadata(19);
        String str4 = localMediaMetadataRetriever.extractMetadata(9);
        String str1 = "";
        if (Build.VERSION.SDK_INT >= 17) {
          str1 = localMediaMetadataRetriever.extractMetadata(24);
        }
        arrayOfInt[0] = Integer.valueOf(str2).intValue();
        arrayOfInt[1] = Integer.valueOf(str3).intValue();
        arrayOfInt[2] = Math.round(Integer.valueOf(str4).intValue() / 1000.0F);
        if (!TextUtils.isEmpty(str1))
        {
          i = Integer.parseInt(str1);
          if ((i != 90) && (i != 270))
          {
            if (QLog.isColorLevel()) {
              QLog.d(".troop.troop_file_video", 2, "getVideoResolution: w=" + arrayOfInt[0] + ", h=" + arrayOfInt[1] + ", dr=" + arrayOfInt[2] + ", rt=" + str1 + ", p=" + paramString);
            }
            return arrayOfInt;
          }
        }
        else
        {
          arrayOfInt[0] = 0;
          arrayOfInt[1] = 0;
          continue;
        }
        i = arrayOfInt[0];
      }
      catch (Exception paramString)
      {
        if (QLog.isColorLevel()) {
          QLog.e(".troop.troop_file_video", 2, "getVideoResolution exp", paramString);
        }
        return arrayOfInt;
      }
      finally
      {
        localMediaMetadataRetriever.release();
      }
      arrayOfInt[0] = arrayOfInt[1];
      arrayOfInt[1] = i;
    }
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
    //   0: aconst_null
    //   1: astore 11
    //   3: aconst_null
    //   4: astore 12
    //   6: iload_2
    //   7: istore 6
    //   9: iload_2
    //   10: ifgt +8 -> 18
    //   13: sipush 640
    //   16: istore 6
    //   18: invokestatic 407	java/lang/System:currentTimeMillis	()J
    //   21: lstore 9
    //   23: new 791	android/media/MediaMetadataRetriever
    //   26: dup
    //   27: invokespecial 792	android/media/MediaMetadataRetriever:<init>	()V
    //   30: astore 13
    //   32: aload 13
    //   34: aload_1
    //   35: invokevirtual 793	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   38: aload 13
    //   40: lload_3
    //   41: invokevirtual 955	android/media/MediaMetadataRetriever:getFrameAtTime	(J)Landroid/graphics/Bitmap;
    //   44: astore_0
    //   45: aload 13
    //   47: invokevirtual 808	android/media/MediaMetadataRetriever:release	()V
    //   50: aload_0
    //   51: ifnonnull +79 -> 130
    //   54: aload 12
    //   56: astore 11
    //   58: aload 11
    //   60: areturn
    //   61: astore_0
    //   62: aload 13
    //   64: invokevirtual 808	android/media/MediaMetadataRetriever:release	()V
    //   67: aconst_null
    //   68: astore_0
    //   69: goto -19 -> 50
    //   72: astore_0
    //   73: aconst_null
    //   74: astore_0
    //   75: goto -25 -> 50
    //   78: astore_0
    //   79: aload 13
    //   81: invokevirtual 808	android/media/MediaMetadataRetriever:release	()V
    //   84: aconst_null
    //   85: astore_0
    //   86: goto -36 -> 50
    //   89: astore_0
    //   90: aconst_null
    //   91: astore_0
    //   92: goto -42 -> 50
    //   95: astore_0
    //   96: ldc 66
    //   98: iconst_1
    //   99: ldc_w 957
    //   102: aload_0
    //   103: invokestatic 534	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   106: aload 13
    //   108: invokevirtual 808	android/media/MediaMetadataRetriever:release	()V
    //   111: aconst_null
    //   112: astore_0
    //   113: goto -63 -> 50
    //   116: astore_0
    //   117: aconst_null
    //   118: astore_0
    //   119: goto -69 -> 50
    //   122: astore_0
    //   123: aload 13
    //   125: invokevirtual 808	android/media/MediaMetadataRetriever:release	()V
    //   128: aload_0
    //   129: athrow
    //   130: aload_0
    //   131: invokevirtual 258	android/graphics/Bitmap:getWidth	()I
    //   134: istore 7
    //   136: aload_0
    //   137: invokevirtual 261	android/graphics/Bitmap:getHeight	()I
    //   140: istore_2
    //   141: iload 7
    //   143: iload_2
    //   144: invokestatic 960	java/lang/Math:max	(II)I
    //   147: istore 8
    //   149: iload 8
    //   151: iload 6
    //   153: if_icmple +188 -> 341
    //   156: iload 6
    //   158: i2f
    //   159: iload 8
    //   161: i2f
    //   162: fdiv
    //   163: fstore 5
    //   165: iload 7
    //   167: i2f
    //   168: fload 5
    //   170: fmul
    //   171: invokestatic 922	java/lang/Math:round	(F)I
    //   174: istore 6
    //   176: iload_2
    //   177: i2f
    //   178: fload 5
    //   180: fmul
    //   181: invokestatic 922	java/lang/Math:round	(F)I
    //   184: istore_2
    //   185: aload_0
    //   186: iload 6
    //   188: iload_2
    //   189: iconst_1
    //   190: invokestatic 964	android/graphics/Bitmap:createScaledBitmap	(Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;
    //   193: astore_0
    //   194: invokestatic 407	java/lang/System:currentTimeMillis	()J
    //   197: lstore_3
    //   198: aload_0
    //   199: ifnull +96 -> 295
    //   202: aload_0
    //   203: astore 11
    //   205: invokestatic 198	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   208: ifeq -150 -> 58
    //   211: ldc 66
    //   213: iconst_2
    //   214: new 200	java/lang/StringBuilder
    //   217: dup
    //   218: invokespecial 201	java/lang/StringBuilder:<init>	()V
    //   221: ldc_w 966
    //   224: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   227: aload_0
    //   228: invokevirtual 258	android/graphics/Bitmap:getWidth	()I
    //   231: invokevirtual 212	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   234: ldc_w 968
    //   237: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   240: aload_0
    //   241: invokevirtual 261	android/graphics/Bitmap:getHeight	()I
    //   244: invokevirtual 212	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   247: ldc_w 970
    //   250: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   253: aload_1
    //   254: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   257: ldc_w 972
    //   260: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   263: lload_3
    //   264: lload 9
    //   266: lsub
    //   267: invokevirtual 687	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   270: ldc_w 807
    //   273: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   276: invokevirtual 224	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   279: invokestatic 228	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   282: aload_0
    //   283: areturn
    //   284: astore_0
    //   285: aload_0
    //   286: invokevirtual 973	java/lang/OutOfMemoryError:printStackTrace	()V
    //   289: aload 11
    //   291: astore_0
    //   292: goto -98 -> 194
    //   295: aload_0
    //   296: astore 11
    //   298: invokestatic 198	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   301: ifeq -243 -> 58
    //   304: ldc 66
    //   306: iconst_2
    //   307: new 200	java/lang/StringBuilder
    //   310: dup
    //   311: invokespecial 201	java/lang/StringBuilder:<init>	()V
    //   314: ldc_w 975
    //   317: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   320: aload_1
    //   321: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   324: invokevirtual 224	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   327: invokestatic 248	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   330: aload_0
    //   331: areturn
    //   332: astore 13
    //   334: goto -284 -> 50
    //   337: astore_1
    //   338: goto -210 -> 128
    //   341: goto -147 -> 194
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	344	0	paramContext	Context
    //   0	344	1	paramString	String
    //   0	344	2	paramInt	int
    //   0	344	3	paramLong	long
    //   163	16	5	f	float
    //   7	180	6	i	int
    //   134	32	7	j	int
    //   147	13	8	k	int
    //   21	244	9	l	long
    //   1	296	11	localObject1	Object
    //   4	51	12	localObject2	Object
    //   30	94	13	localMediaMetadataRetriever	MediaMetadataRetriever
    //   332	1	13	localRuntimeException	java.lang.RuntimeException
    // Exception table:
    //   from	to	target	type
    //   32	45	61	java/lang/IllegalArgumentException
    //   62	67	72	java/lang/RuntimeException
    //   32	45	78	java/lang/RuntimeException
    //   79	84	89	java/lang/RuntimeException
    //   32	45	95	java/lang/OutOfMemoryError
    //   106	111	116	java/lang/RuntimeException
    //   32	45	122	finally
    //   96	106	122	finally
    //   185	194	284	java/lang/OutOfMemoryError
    //   45	50	332	java/lang/RuntimeException
    //   123	128	337	java/lang/RuntimeException
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
      Object localObject = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.aio_config.name(), "-1|1=0,2=0,3=0,4=0,5=1|1|999|4|1|0_2");
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoUtils", 2, "getDefaultShortVideoStrategy:" + (String)localObject);
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
          if ((i >= 0) && (i <= 60)) {
            mDefaultShortVideoPreDownloadTime = i;
          }
        }
      }
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("ShortVideoUtils", 2, "needBlockBrokenVideo e:" + localException.toString());
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
    //   0: iconst_0
    //   1: istore_3
    //   2: new 1002	android/media/MediaExtractor
    //   5: dup
    //   6: invokespecial 1003	android/media/MediaExtractor:<init>	()V
    //   9: astore 4
    //   11: aload 4
    //   13: aload_0
    //   14: invokevirtual 1004	android/media/MediaExtractor:setDataSource	(Ljava/lang/String;)V
    //   17: iconst_0
    //   18: istore_1
    //   19: iload_3
    //   20: istore_2
    //   21: iload_1
    //   22: aload 4
    //   24: invokevirtual 1007	android/media/MediaExtractor:getTrackCount	()I
    //   27: if_icmpge +34 -> 61
    //   30: aload 4
    //   32: iload_1
    //   33: invokevirtual 1011	android/media/MediaExtractor:getTrackFormat	(I)Landroid/media/MediaFormat;
    //   36: ldc_w 1013
    //   39: invokevirtual 1017	android/media/MediaFormat:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   42: astore_0
    //   43: aload_0
    //   44: ldc_w 1019
    //   47: invokevirtual 1022	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   50: ifeq +18 -> 68
    //   53: aload_0
    //   54: ldc_w 1024
    //   57: invokevirtual 1027	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   60: istore_2
    //   61: aload 4
    //   63: invokevirtual 1028	android/media/MediaExtractor:release	()V
    //   66: iload_2
    //   67: ireturn
    //   68: iload_1
    //   69: iconst_1
    //   70: iadd
    //   71: istore_1
    //   72: goto -53 -> 19
    //   75: astore_0
    //   76: invokestatic 198	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   79: ifeq +13 -> 92
    //   82: ldc 66
    //   84: iconst_2
    //   85: ldc_w 1030
    //   88: aload_0
    //   89: invokestatic 330	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   92: aload 4
    //   94: invokevirtual 1028	android/media/MediaExtractor:release	()V
    //   97: iconst_0
    //   98: ireturn
    //   99: astore_0
    //   100: aload 4
    //   102: invokevirtual 1028	android/media/MediaExtractor:release	()V
    //   105: aload_0
    //   106: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	107	0	paramString	String
    //   18	54	1	i	int
    //   20	47	2	bool1	boolean
    //   1	19	3	bool2	boolean
    //   9	92	4	localMediaExtractor	android.media.MediaExtractor
    // Exception table:
    //   from	to	target	type
    //   11	17	75	java/lang/Exception
    //   21	61	75	java/lang/Exception
    //   11	17	99	finally
    //   21	61	99	finally
    //   76	92	99	finally
  }
  
  public static boolean isInFullScreenBlackList()
  {
    boolean bool = false;
    String[] arrayOfString = FULL_SCREEN_BLACK_LIST;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      String str = arrayOfString[i];
      if (Build.MODEL.equalsIgnoreCase(str)) {
        bool = true;
      }
      i += 1;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoUtils", 2, "isInFullScreenBlackList(), result=" + bool);
    }
    return bool;
  }
  
  public static boolean isSkipClipShutDown()
  {
    if (!sShutdownSkipClipPhotoInited) {
      sShutdownSkipClipPhotoInited = true;
    }
    try
    {
      Object localObject = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.aio_config.name(), "");
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoUtils", 2, "isSkipClipShutDown:" + (String)localObject);
      }
      localObject = ((String)localObject).split("\\|");
      if (localObject.length > 16) {
        sShutdownSkipClipPhoto = localObject[16].equals("1");
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoUtils", 2, "isSkipClipShutDown e:" + localException.toString());
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoUtils", 2, "isSkipClipShutDown sShutdownSkipClipPhoto " + sShutdownSkipClipPhoto);
    }
    return sShutdownSkipClipPhoto;
  }
  
  public static boolean isSupportProgressive(File paramFile)
  {
    boolean bool3 = false;
    boolean bool1 = false;
    boolean bool2 = bool1;
    if (paramFile != null)
    {
      bool2 = bool1;
      if (paramFile.exists())
      {
        if (paramFile.isFile()) {
          break label39;
        }
        bool2 = bool1;
      }
    }
    label39:
    long l1;
    label144:
    do
    {
      int i;
      do
      {
        Object localObject;
        do
        {
          do
          {
            return bool2;
            l1 = System.currentTimeMillis();
            localObject = getMp4VideoMoovInfo(paramFile);
            if (QLog.isColorLevel()) {
              QLog.d("ShortVideoUtils", 2, "isSupportProgressive(), moovInfoStr: " + (String)localObject + ", filePath:" + paramFile.getAbsolutePath());
            }
            bool2 = bool1;
          } while (TextUtils.isEmpty((CharSequence)localObject));
          localObject = ((String)localObject).split("\\|");
          bool2 = bool1;
        } while (TextUtils.isEmpty(localObject[0]));
        i = -1;
        try
        {
          int j = Integer.parseInt(localObject[0]);
          i = j;
        }
        catch (Exception localException)
        {
          long l2;
          float f;
          break label144;
        }
        bool2 = bool1;
      } while (i <= 0);
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
    } while (!QLog.isColorLevel());
    QLog.d("ShortVideoUtils", 2, "isSupportProgressive(), ratio: " + f + ", result: " + bool1 + ", cost:" + (l2 - l1));
    return bool1;
  }
  
  public static boolean isVideoExist(MessageForShortVideo paramMessageForShortVideo)
  {
    if (paramMessageForShortVideo == null) {}
    do
    {
      return false;
      if (FileUtils.fileExistsAndNotEmpty(getShortVideoSavePath(paramMessageForShortVideo, "mp4"))) {
        return true;
      }
    } while ((!paramMessageForShortVideo.isSendFromLocal()) || (!FileUtils.fileExistsAndNotEmpty(paramMessageForShortVideo.videoFileName)));
    return true;
  }
  
  public static boolean isVideoSoLibLoaded()
  {
    return VideoEnvironment.isShortVideoSoLibLoaded();
  }
  
  public static void loadShortVideoSo(AppInterface paramAppInterface)
  {
    try
    {
      if ((VideoEnvironment.supportShortVideoRecordAndPlay(paramAppInterface)) && (!isVideoSoLibLoaded()))
      {
        VideoEnvironment.loadAVCodecSoNotify("AVCodec", null, true);
        if (QLog.isColorLevel()) {
          QLog.i("ShortVideoUtils", 2, "LoadExtractedShortVideoSo:status_end=" + VideoEnvironment.getShortVideoSoLibLoadStatus());
        }
      }
      return;
    }
    catch (Throwable paramAppInterface)
    {
      do
      {
        paramAppInterface.printStackTrace();
      } while (!QLog.isColorLevel());
      QLog.e("ShortVideoUtils", 2, "Load libAVCodec.so failure.", paramAppInterface);
    }
  }
  
  public static boolean moveMoovAtom(String paramString)
  {
    boolean bool3 = false;
    boolean bool1 = false;
    boolean bool2 = bool1;
    if (!TextUtils.isEmpty(paramString))
    {
      if (!mSoLoadState) {
        bool2 = bool1;
      }
    }
    else {
      return bool2;
    }
    long l1 = System.currentTimeMillis();
    String str1 = "";
    String str2 = paramString + ".tmp";
    if (adjustMoovPosition(paramString, str2) != 0)
    {
      paramString = " adjustMoovPosition failure";
      bool1 = bool3;
    }
    for (;;)
    {
      long l2 = System.currentTimeMillis();
      bool2 = bool1;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("ShortVideoUtils", 2, "moveMoovAtom() result = " + bool1 + ", step = " + paramString + ", cost = " + (l2 - l1) + "ms");
      return bool1;
      String str3 = paramString + ".back";
      FileUtils.rename(paramString, str3);
      if (!FileUtils.rename(str2, paramString))
      {
        FileUtils.rename(str3, paramString);
        paramString = " rename failure";
        bool1 = bool3;
      }
      else
      {
        bool1 = true;
        paramString = str1;
      }
    }
  }
  
  public static boolean needBlockBrokenVideo()
  {
    if (!sBlockBrokenVideoInited) {}
    try
    {
      Object localObject = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.aio_config.name(), "-1|1=0,2=0,3=0,4=0,5=1|1|999|4|1");
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoUtils", 2, "needBlockBrokenVideo:" + (String)localObject);
      }
      localObject = ((String)localObject).split("\\|");
      if (localObject.length > 5) {
        mBlockBrokenVideo = localObject[5].equals("1");
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoUtils", 2, "needBlockBrokenVideo e:" + localException.toString());
        }
      }
    }
    sBlockBrokenVideoInited = true;
    return mBlockBrokenVideo;
  }
  
  public static boolean needTwoEntrance()
  {
    boolean bool1 = supportShortVideoMergePhoto();
    boolean bool2 = aqmy.a();
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoUtils", 2, "supportShortVideoMergePhoto dpc:" + mSupportPhotoMerge + " choiceQC:" + bool2);
    }
    return (!bool1) || (!bool2);
  }
  
  public static String realGetShortVideoSavePath(MessageForShortVideo paramMessageForShortVideo, String paramString)
  {
    if (paramMessageForShortVideo != null)
    {
      StringBuilder localStringBuilder = new StringBuilder(getShortVideoFileDir(paramMessageForShortVideo.getMd5()));
      localStringBuilder.append(paramMessageForShortVideo.frienduin);
      localStringBuilder.append(Math.abs(paramMessageForShortVideo.uniseq));
      localStringBuilder.append(".");
      localStringBuilder.append(paramString);
      return localStringBuilder.toString();
    }
    return "";
  }
  
  public static String realGetShortVideoSavePath(String paramString1, String paramString2, long paramLong, String paramString3)
  {
    paramString1 = new StringBuilder(getShortVideoFileDir(paramString1));
    paramString1.append(paramString2);
    paramString1.append(Math.abs(paramLong));
    paramString1.append(".");
    paramString1.append(paramString3);
    return paramString1.toString();
  }
  
  public static void reportCancelSendVideo(String paramString, int paramInt)
  {
    int i = 1;
    if (paramInt == 0) {
      paramInt = i;
    }
    for (;;)
    {
      bdla.b(null, "dc00898", "", "", paramString, paramString, paramInt, 0, "", "", "", "");
      return;
      if (paramInt == 1) {
        paramInt = 2;
      } else if (paramInt == 3000) {
        paramInt = 3;
      } else {
        paramInt = 4;
      }
    }
  }
  
  public static void reportVideoPlay(AppInterface paramAppInterface, String paramString, SessionInfo paramSessionInfo, MessageRecord paramMessageRecord, Context paramContext)
  {
    bdjs localbdjs = new bdjs();
    localbdjs.b = paramString;
    switch (paramSessionInfo.curType)
    {
    default: 
      if (paramString == "0X8008E53")
      {
        localbdjs.c = "2";
        label66:
        if ((paramMessageRecord == null) || (!(paramMessageRecord instanceof MessageForShortVideo))) {
          break label257;
        }
        paramString = (MessageForShortVideo)paramMessageRecord;
        localbdjs.a = String.valueOf(paramString.videoFileTime * 1000);
        switch (paramString.busiType)
        {
        default: 
          label124:
          if (QLog.isColorLevel()) {
            QLog.e("ShortVideoUtils", 1, new Object[] { Long.valueOf(paramMessageRecord.uniseq) });
          }
          label150:
          if ((!(paramContext instanceof SplashActivity)) && (!(paramContext instanceof ChatActivity))) {}
          break;
        }
      }
      break;
    }
    for (localbdjs.f = "1";; localbdjs.f = "2")
    {
      bdjr.a(paramAppInterface.getAccount(), "dc01178", paramSessionInfo.curFriendUin, localbdjs);
      return;
      localbdjs.d = "1";
      break;
      localbdjs.d = "2";
      break;
      localbdjs.d = "3";
      break;
      localbdjs.c = "1";
      break label66;
      localbdjs.e = "1";
      break label124;
      localbdjs.e = "2";
      break label124;
      label257:
      localbdjs.a = "0";
      localbdjs.e = "3";
      break label150;
    }
  }
  
  public static void reportVideoPlay(String paramString1, String paramString2, String paramString3, int paramInt, String paramString4, String paramString5)
  {
    bdjs localbdjs = new bdjs();
    localbdjs.a = paramString3;
    localbdjs.b = "0X8008E53";
    switch (paramInt)
    {
    }
    for (;;)
    {
      localbdjs.c = "2";
      localbdjs.e = paramString4;
      localbdjs.f = paramString5;
      bdjr.a(paramString1, "dc01178", paramString2, localbdjs);
      return;
      localbdjs.d = "1";
      continue;
      localbdjs.d = "2";
      continue;
      localbdjs.d = "3";
    }
  }
  
  public static void reportVideoPlayEvent(QQAppInterface paramQQAppInterface, int paramInt1, String paramString, int paramInt2, int paramInt3, long paramLong1, long paramLong2)
  {
    String str2;
    switch (paramInt1)
    {
    default: 
      paramInt1 = 4;
      double d1 = paramLong1 / 1000.0D;
      double d2 = paramLong2 / 1000.0D;
      str1 = String.format("%.2f", new Object[] { Double.valueOf(d1) });
      str2 = String.format("%.2f", new Object[] { Double.valueOf(d2) });
      str2 = str1 + ";" + str2;
      if (paramInt1 != 2) {
        break;
      }
    }
    for (String str1 = paramString;; str1 = "")
    {
      bdla.b(paramQQAppInterface, "dc00898", "", paramString, "0X8009AA6", "0X8009AA6", paramInt1, 0, String.valueOf(paramInt2), String.valueOf(paramInt3), str2, str1);
      return;
      paramInt1 = 1;
      break;
      paramInt1 = 2;
      break;
      paramInt1 = 3;
      break;
    }
  }
  
  public static Bitmap resizeThumb(Bitmap paramBitmap)
  {
    Object localObject;
    if (paramBitmap == null)
    {
      localObject = null;
      return localObject;
    }
    for (;;)
    {
      int i;
      int j;
      try
      {
        i = paramBitmap.getWidth();
        j = paramBitmap.getHeight();
        localObject = calculateScaledThumbWH(paramBitmap);
        if (localObject != null) {
          break label234;
        }
        return null;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        float f1;
        float f2;
        Canvas localCanvas;
        RectF localRectF;
        Paint localPaint;
        localObject = paramBitmap;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoUtils", 2, "resizeThumb ==> dstW:" + k + ", dstH:" + m);
      }
      f1 = k / i;
      f2 = m / j;
      localObject = new Matrix();
      ((Matrix)localObject).postScale(f1, f2);
      localObject = Bitmap.createBitmap(paramBitmap, 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), (Matrix)localObject, true);
      localCanvas = new Canvas((Bitmap)localObject);
      localRectF = new RectF(0.0F, 0.0F, k, m);
      localPaint = new Paint(1);
      localPaint.setColor(-16777216);
      localPaint.setAntiAlias(true);
      localCanvas.drawBitmap(paramBitmap, null, localRectF, localPaint);
      if ((paramBitmap != null) && (!paramBitmap.isRecycled())) {
        paramBitmap.recycle();
      }
      return localObject;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e("ShortVideoUtils", 2, "resizeThumb, OutOfMemoryError ", localOutOfMemoryError);
      return paramBitmap;
      label234:
      int k = localObject[0];
      int m = localObject[1];
      if (i == k)
      {
        localObject = paramBitmap;
        if (j == m) {
          break;
        }
      }
    }
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
    localEditor.putInt("short_video_hotpic_pic_version_" + paramString, paramInt);
    localEditor.apply();
  }
  
  public static void setHotPicRedDotStatus(String paramString, boolean paramBoolean)
  {
    SharedPreferences.Editor localEditor = BaseApplicationImpl.getApplication().getSharedPreferences("ptv_and_hot_pic_reddot_sp", 4).edit();
    localEditor.putBoolean("short_video_hotpic_show_pic_" + paramString, paramBoolean);
    localEditor.apply();
  }
  
  public static void setPtvRedDotConfigVersion(String paramString, int paramInt)
  {
    SharedPreferences.Editor localEditor = BaseApplicationImpl.getApplication().getSharedPreferences("ptv_and_hot_pic_reddot_sp", 4).edit();
    localEditor.putInt("short_video_hotpic_ptv_version_" + paramString, paramInt);
    localEditor.apply();
  }
  
  public static void setPtvRedDotStatus(String paramString, boolean paramBoolean)
  {
    SharedPreferences.Editor localEditor = BaseApplicationImpl.getApplication().getSharedPreferences("ptv_and_hot_pic_reddot_sp", 4).edit();
    localEditor.putBoolean("short_video_hotpic_show_ptv_" + paramString, paramBoolean);
    localEditor.apply();
  }
  
  public static void setRecentPOI(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      throw new IllegalArgumentException("uin may be null, uin=" + paramString1);
    }
    getSharedPref("sp_user_cache_data").edit().putString("recent_poi_" + paramString1, paramString2).apply();
  }
  
  public static void startShortVideoPlayActivity(MessageForShortVideo paramMessageForShortVideo, Activity paramActivity, int paramInt1, String paramString, Rect paramRect, int paramInt2)
  {
    String str = getShortVideoThumbPicPath(paramMessageForShortVideo.thumbMD5, "jpg");
    Bundle localBundle = new Bundle();
    localBundle.putInt("uintype", paramMessageForShortVideo.istroop);
    localBundle.putString("from_uin", getFromUinForForward(paramMessageForShortVideo));
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
    if (paramMessageForShortVideo.CheckIsHotVideo())
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
    paramActivity.overridePendingTransition(2130772039, 2130772041);
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
    if (!sSupportPhotoMergeInited) {
      sSupportPhotoMergeInited = true;
    }
    try
    {
      Object localObject = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.aio_config.name(), "");
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoUtils", 2, "supportShortVideoMergePhoto:" + (String)localObject);
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
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoUtils", 2, "supportShortVideoMergePhoto e:" + localException.toString());
        }
      }
    }
    return mSupportPhotoMerge == 1;
  }
  
  public static boolean verifyFileModifyTime(String paramString, long paramLong)
  {
    boolean bool3 = false;
    boolean bool1 = false;
    boolean bool2;
    if ((TextUtils.isEmpty(paramString)) || (0L == paramLong))
    {
      bool2 = bool1;
      if (QLog.isColorLevel())
      {
        QLog.d("ShortVideoUtils", 2, " verifyFileModifyTime(), filePath or lastModifyTime is vilid.");
        bool2 = bool1;
      }
    }
    long l1;
    do
    {
      long l2;
      do
      {
        do
        {
          return bool2;
          l1 = System.currentTimeMillis();
          paramString = new File(paramString);
          l2 = paramString.length();
          bool2 = bool1;
        } while (!paramString.isFile());
        bool2 = bool1;
      } while (l2 <= 0L);
      bool1 = bool3;
      if (paramLong == paramString.lastModified()) {
        bool1 = true;
      }
      paramLong = System.currentTimeMillis();
      bool2 = bool1;
    } while (!QLog.isColorLevel());
    QLog.d("ShortVideoUtils", 2, " verifyFileModifyTime(), result = " + bool1 + ", cost time: " + (paramLong - l1) + " ms");
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.ShortVideoUtils
 * JD-Core Version:    0.7.0.1
 */