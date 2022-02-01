package com.tencent.mobileqq.shortvideo;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.avcore.data.AVCoreSystemInfo;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.video.decode.ShortVideoSoLoad;
import java.io.File;
import mqq.app.MobileQQ;

public class VideoEnvironment
{
  private static final int AVCODEC_FEATURE_NUM = 16;
  public static final int AVCODEC_MD_SUPPORT_AUDIO_SYNC = 5;
  private static final int AVCODEC_MD_SUPPORT_PRE_SEND = 2;
  private static final int AVCODEC_MD_SUPPORT_RT_BEAUTY = 1;
  private static final int AVCODEC_MD_VERSION = 0;
  private static final int NEW_JUDGE_SO_NAME_VERSION_OK = 255;
  private static final int NEW_LOAD_ERR_PARSER = -12;
  private static final int NEW_LOAD_ERR_SO_NAME_NULL = -11;
  private static final int NEW_LOAD_ERR_VERSION = -13;
  public static final String SHORT_VIDEO_CONFIG = "sv_config";
  public static final String TAG = "VideoEnvironment";
  public static String debugDecodeFilePath;
  private static final int dymAVCodecVersion = 65;
  private static boolean gAVCodecInitMD = false;
  private static int[] gAVCodecMetadata = new int[16];
  private static final Object mLockLoadStatus;
  
  static
  {
    debugDecodeFilePath = VFSAssistantUtils.getSDKPrivatePath(AppConstants.SDCARD_ROOT + "/Tencent/com/tencent/mobileqq/debugDecodeShortVideo");
    mLockLoadStatus = new Object();
    File localFile = new File(ShortVideoSoLoad.getShortVideoSoPath(getContext()));
    if (!localFile.exists())
    {
      localFile.mkdirs();
      LogDownLoad("VideoEnvironment:[static]loadPathFile not exist");
    }
  }
  
  public static void LogDownLoad(String paramString)
  {
    LogDownLoad("VideoEnvironment", paramString, null);
  }
  
  public static void LogDownLoad(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (QLog.isColorLevel()) {
      QLog.i(paramString1, 2, paramString2, paramThrowable);
    }
  }
  
  public static void LogDownLoad(String paramString, Throwable paramThrowable)
  {
    LogDownLoad("VideoEnvironment", paramString, paramThrowable);
  }
  
  public static boolean checkAndLoadAVCodec()
  {
    loadAVCodecSo();
    return isShortVideoSoLibLoaded();
  }
  
  public static boolean checkShortVideoSoReadyToLoad()
  {
    if (ShortVideoSoLoad.getShortVideoSoLoadStatus() == 0) {
      return true;
    }
    String str = ShortVideoSoLoad.getShortVideoSoPath(getContext());
    String[] arrayOfString = new String[1];
    if (judgeCurrentSpVideoNameValidate(arrayOfString) == 255) {
      return new File(str + arrayOfString[0]).exists();
    }
    return false;
  }
  
  private static native void getAVCodecLibMetadata(int[] paramArrayOfInt);
  
  public static boolean getAVCodecSupportFeature(int paramInt)
  {
    return getAVCodecSupportFeatureKind(paramInt) > 0;
  }
  
  private static int getAVCodecSupportFeatureKind(int paramInt)
  {
    if ((paramInt <= 0) && (paramInt >= 16)) {
      return 0;
    }
    try
    {
      if (!gAVCodecInitMD)
      {
        getAVCodecLibMetadata(gAVCodecMetadata);
        gAVCodecInitMD = true;
      }
      paramInt = gAVCodecMetadata[paramInt];
      return paramInt;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError) {}
    return 0;
  }
  
  public static boolean getAVCodecSupportRTBeauty()
  {
    return getAVCodecSupportFeatureKind(1) > 0;
  }
  
  public static int getAVCodecVersion()
  {
    try
    {
      if (!gAVCodecInitMD)
      {
        loadAVCodecSo();
        getAVCodecLibMetadata(gAVCodecMetadata);
        gAVCodecInitMD = true;
      }
      i = gAVCodecMetadata[0];
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      for (;;)
      {
        int i = -1;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("VideoEnvironment", 2, "getAVCodecVersion: AVCodec_version=" + i);
    }
    return i;
  }
  
  public static Context getContext()
  {
    return MobileQQ.sMobileQQ.getApplicationContext();
  }
  
  public static String getShortVideoSoLibName()
  {
    String[] arrayOfString = new String[1];
    int i = judgeCurrentSpVideoNameValidate(arrayOfString);
    LogDownLoad("getShortVideoSoLibName: errCode=" + i + " soNameValue=" + arrayOfString[0]);
    if (i == 255) {
      return arrayOfString[0];
    }
    return null;
  }
  
  public static boolean isBeautySupported()
  {
    if (isX86Platform()) {}
    boolean bool1;
    boolean bool2;
    do
    {
      return false;
      bool1 = AVCoreSystemInfo.isBeautySupported();
      bool2 = getAVCodecSupportRTBeauty();
      if (QLog.isColorLevel()) {
        QLog.d("VideoEnvironment", 2, "isX86Platform: isBeautySupported=" + bool1 + " isSoSupportBeauty=" + bool2);
      }
    } while ((!bool1) || (!bool2));
    return true;
  }
  
  public static boolean isShortVideoSoLibLoaded()
  {
    return ShortVideoSoLoad.getShortVideoSoLoadStatus() == 0;
  }
  
  public static boolean isX86Platform()
  {
    return DeviceInfoUtil.i();
  }
  
  private static int judgeCurrentSpVideoNameValidate(String[] paramArrayOfString)
  {
    String str = ShortVideoSoManager.a();
    LogDownLoad("LoadPathSo: currentSoName=" + str);
    if (str.equals("d000_1")) {
      return -11;
    }
    Object localObject = ShortVideoSoManager.a(str);
    int i = ((ShortVideoSoManager.CfgParser)localObject).a();
    LogDownLoad("LoadPathSo: CfgParser err=" + i);
    if (i == 0)
    {
      localObject = ((ShortVideoSoManager.CfgParser)localObject).b();
      LogDownLoad("LoadPathSo: currentVersion=" + (String)localObject + " dymAVCodecVersion=" + 65);
      if (Integer.parseInt((String)localObject) >= 65)
      {
        paramArrayOfString[0] = str;
        return 255;
      }
      return -13;
    }
    return -12;
  }
  
  /* Error */
  public static int loadAVCodecSo()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: invokestatic 129	com/tencent/video/decode/ShortVideoSoLoad:getShortVideoSoLoadStatus	()I
    //   6: istore_0
    //   7: iload_0
    //   8: ifne +30 -> 38
    //   11: new 47	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   18: ldc 232
    //   20: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: iload_0
    //   24: invokevirtual 154	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   27: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   30: invokestatic 103	com/tencent/mobileqq/shortvideo/VideoEnvironment:LogDownLoad	(Ljava/lang/String;)V
    //   33: ldc 2
    //   35: monitorexit
    //   36: iload_0
    //   37: ireturn
    //   38: getstatic 76	com/tencent/mobileqq/shortvideo/VideoEnvironment:mLockLoadStatus	Ljava/lang/Object;
    //   41: astore_1
    //   42: aload_1
    //   43: monitorenter
    //   44: invokestatic 235	com/tencent/mobileqq/shortvideo/VideoEnvironment:realDoLoadSo	()I
    //   47: istore_0
    //   48: new 47	java/lang/StringBuilder
    //   51: dup
    //   52: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   55: ldc 237
    //   57: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: iload_0
    //   61: invokevirtual 154	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   64: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   67: invokestatic 103	com/tencent/mobileqq/shortvideo/VideoEnvironment:LogDownLoad	(Ljava/lang/String;)V
    //   70: aload_1
    //   71: monitorexit
    //   72: goto -39 -> 33
    //   75: astore_2
    //   76: aload_1
    //   77: monitorexit
    //   78: aload_2
    //   79: athrow
    //   80: astore_1
    //   81: ldc 2
    //   83: monitorexit
    //   84: aload_1
    //   85: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   6	55	0	i	int
    //   80	5	1	localObject2	Object
    //   75	4	2	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   44	72	75	finally
    //   76	78	75	finally
    //   3	7	80	finally
    //   11	33	80	finally
    //   38	44	80	finally
    //   78	80	80	finally
  }
  
  public static boolean needDownloadCurrentServerVersion(int paramInt)
  {
    if (paramInt >= 65) {}
    for (boolean bool = true;; bool = false)
    {
      if (!bool) {
        LogDownLoad("needDownloadCurrentServerVersion, serverVersion=" + paramInt + " dymAVCodecVersion=" + 65);
      }
      return bool;
    }
  }
  
  private static int realDoLoadSo()
  {
    String str = ShortVideoSoLoad.getShortVideoSoPath(getContext());
    String[] arrayOfString = new String[1];
    int i = judgeCurrentSpVideoNameValidate(arrayOfString);
    if (i == 255)
    {
      str = str + arrayOfString[0];
      LogDownLoad("Before LoadPath so. loadSoPath=" + str + " soNameValue[0]=" + arrayOfString[0]);
      i = ShortVideoSoLoad.LoadExtractedShortVideo(str);
      LogDownLoad("After LoadPath so. errCode=" + i);
      return i;
    }
    LogDownLoad("realDoLoadSo[errCode=" + i + "]");
    return i;
  }
  
  public static boolean supportShortVideoRecordAndPlay()
  {
    if (Build.VERSION.SDK_INT < 18) {
      if (QLog.isColorLevel()) {
        QLog.d("VideoEnvironment", 2, "supportShortVideoRecordAndPlay:SDK_INT=" + Build.VERSION.SDK_INT);
      }
    }
    String str;
    do
    {
      return false;
      str = Build.CPU_ABI;
      if (!isX86Platform()) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("VideoEnvironment", 2, "supportShortVideoRecordAndPlay:isX86Platform, don't support, Build.CPU_ABI=" + str);
    return false;
    if (QLog.isColorLevel()) {
      QLog.d("VideoEnvironment", 2, "supportShortVideoRecordAndPlay: support, Build.CPU_ABI=" + str);
    }
    return true;
  }
  
  public static boolean supportSubmitCallback()
  {
    int i = getAVCodecVersion();
    boolean bool = getAVCodecSupportFeature(2);
    if (QLog.isColorLevel()) {
      QLog.d("VideoEnvironment", 2, "supportSubmitCallback: soVersion =" + i + ", result = " + bool);
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.VideoEnvironment
 * JD-Core Version:    0.7.0.1
 */