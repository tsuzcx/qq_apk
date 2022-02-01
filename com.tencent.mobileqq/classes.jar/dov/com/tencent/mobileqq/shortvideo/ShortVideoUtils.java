package dov.com.tencent.mobileqq.shortvideo;

import android.annotation.TargetApi;
import android.content.Context;
import android.media.MediaPlayer;
import android.os.Build;
import android.text.format.Formatter;
import com.tencent.biz.qqstory.base.videoupload.VideoCompositeHelper;
import com.tencent.mobileqq.activity.richmedia.PathUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.mobileqq.shortvideo.util.VidUtil;
import java.io.File;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.os.MqqHandler;

public class ShortVideoUtils
  implements ShortVideoConstants
{
  private static int jdField_a_of_type_Int;
  private static AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger;
  public static boolean a;
  private static int[] jdField_a_of_type_ArrayOfInt;
  private static String[] jdField_a_of_type_ArrayOfJavaLangString = { "GT-N7108" };
  private static int b;
  public static boolean b;
  public static boolean c;
  public static boolean d;
  private static volatile boolean e = false;
  private static boolean f;
  
  static
  {
    jdField_a_of_type_Boolean = true;
    jdField_b_of_type_Boolean = true;
    c = false;
    f = true;
    d = false;
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
    jdField_a_of_type_Int = 2;
    jdField_b_of_type_Int = 1;
    jdField_a_of_type_ArrayOfInt = new int[] { 1, 97, 125 };
    ThreadManager.getSubThreadHandler().post(new ShortVideoUtils.1());
  }
  
  public static long a(String paramString)
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
  
  public static String a()
  {
    StringBuilder localStringBuilder = new StringBuilder(b());
    localStringBuilder.append("thumbs");
    localStringBuilder.append(File.separator);
    Object localObject = new File(localStringBuilder.toString());
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdirs();
    }
    localObject = localStringBuilder.toString() + ".nomedia";
    if (!new File((String)localObject).exists()) {
      FileUtils.c((String)localObject);
    }
    return localStringBuilder.toString();
  }
  
  public static String a(int paramInt)
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
  
  public static String a(long paramLong)
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
  
  public static String a(Context paramContext, long paramLong)
  {
    String str = Formatter.formatShortFileSize(paramContext, paramLong);
    int i = str.length();
    paramContext = str;
    if (i > 3) {
      paramContext = str.substring(0, i - 1);
    }
    return paramContext.replace(" ", "");
  }
  
  public static String a(MessageForShortVideo paramMessageForShortVideo, String paramString)
  {
    int i = 0;
    paramString = b(paramMessageForShortVideo, paramString);
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
        if (FileUtils.b(paramString)) {
          bool2 = false;
        }
      }
      paramMessageForShortVideo = c(paramMessageForShortVideo.getMd5());
      localObject = new File(paramMessageForShortVideo);
      if (((File)localObject).exists()) {
        break;
      }
      ((File)localObject).mkdirs();
      FileUtils.c(paramMessageForShortVideo + ".nomedia");
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
          break label379;
        }
        str = localObject[i];
        if ((!str.endsWith(".tmp")) && (!str.equals(".nomedia"))) {
          break;
        }
        i += 1;
      }
    }
    label379:
    for (paramMessageForShortVideo = paramMessageForShortVideo + str;; paramMessageForShortVideo = null)
    {
      if ((bool2) && (paramMessageForShortVideo != null) && (!new File(paramString).exists()))
      {
        long l1 = System.currentTimeMillis();
        if (paramMessageForShortVideo.equals(paramString)) {
          return paramString;
        }
        FileUtils.d(paramMessageForShortVideo, paramString);
        if (QLog.isColorLevel()) {
          QLog.i("ShortVideoUtils", 2, "copy " + paramMessageForShortVideo + " to " + paramString);
        }
        long l2 = System.currentTimeMillis();
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoUtils", 2, "getShortVideoSavePath-----time: = " + (l2 - l1) + ", videoStatus:" + b(j) + ", needCopy=" + bool2);
        }
      }
      return paramString;
    }
  }
  
  public static String a(File paramFile)
  {
    if (paramFile == null) {
      return null;
    }
    paramFile = VidUtil.a(paramFile);
    StringBuilder localStringBuilder = new StringBuilder(PathUtils.d);
    localStringBuilder.append("shortvideo");
    localStringBuilder.append(File.separator);
    localStringBuilder.append("temp");
    localStringBuilder.append(File.separator);
    localStringBuilder.append("source");
    localStringBuilder.append(File.separator);
    localStringBuilder.append(paramFile);
    localStringBuilder.append("_local");
    localStringBuilder.append(".mp4");
    return localStringBuilder.toString();
  }
  
  public static String a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    paramString = VidUtil.a(new File(paramString));
    StringBuilder localStringBuilder = new StringBuilder(PathUtils.d);
    localStringBuilder.append("shortvideo");
    localStringBuilder.append(File.separator);
    localStringBuilder.append("temp");
    localStringBuilder.append(File.separator);
    localStringBuilder.append("source");
    localStringBuilder.append(File.separator);
    localStringBuilder.append(paramString);
    localStringBuilder.append("watermark");
    localStringBuilder.append(".png");
    return localStringBuilder.toString();
  }
  
  public static String a(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder(a());
    localStringBuilder.append(paramString1);
    localStringBuilder.append(".");
    localStringBuilder.append(paramString2);
    return localStringBuilder.toString();
  }
  
  public static boolean a()
  {
    boolean bool = false;
    String[] arrayOfString = jdField_a_of_type_ArrayOfJavaLangString;
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
  
  public static int[] a()
  {
    return jdField_a_of_type_ArrayOfInt;
  }
  
  @TargetApi(14)
  public static long b(String paramString)
  {
    if (!FileUtils.a(paramString)) {
      return 0L;
    }
    return VideoCompositeHelper.a(paramString);
  }
  
  private static String b()
  {
    StringBuilder localStringBuilder = new StringBuilder(PathUtils.d);
    localStringBuilder.append("shortvideo");
    localStringBuilder.append(File.separator);
    return localStringBuilder.toString();
  }
  
  public static String b(int paramInt)
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
  
  public static String b(MessageForShortVideo paramMessageForShortVideo, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder(c(paramMessageForShortVideo.getMd5()));
    localStringBuilder.append(paramMessageForShortVideo.frienduin);
    localStringBuilder.append(Math.abs(paramMessageForShortVideo.uniseq));
    localStringBuilder.append(".");
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  public static String b(File paramFile)
  {
    if (paramFile == null) {
      return null;
    }
    paramFile = VidUtil.a(paramFile);
    StringBuilder localStringBuilder = new StringBuilder(PathUtils.d);
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
  
  public static String b(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("QIM视频");
    localStringBuilder.append("_").append(paramString);
    return localStringBuilder.toString();
  }
  
  public static String c(int paramInt)
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
  
  private static String c(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder(PathUtils.d);
    localStringBuilder.append("shortvideo");
    localStringBuilder.append(File.separator);
    localStringBuilder.append(paramString);
    localStringBuilder.append(File.separator);
    return localStringBuilder.toString();
  }
  
  public static String d(int paramInt)
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.mobileqq.shortvideo.ShortVideoUtils
 * JD-Core Version:    0.7.0.1
 */