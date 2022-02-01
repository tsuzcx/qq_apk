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
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(AppConstants.SDCARD_ROOT);
    ((StringBuilder)localObject).append("/Tencent/com/tencent/mobileqq/debugDecodeShortVideo");
    debugDecodeFilePath = VFSAssistantUtils.getSDKPrivatePath(((StringBuilder)localObject).toString());
    mLockLoadStatus = new Object();
    localObject = new File(ShortVideoSoLoad.getShortVideoSoPath(getContext()));
    if (!((File)localObject).exists())
    {
      ((File)localObject).mkdirs();
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
    if (judgeCurrentSpVideoNameValidate(arrayOfString) == 255)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append(arrayOfString[0]);
      return new File(localStringBuilder.toString()).exists();
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
      int i;
      label29:
      StringBuilder localStringBuilder;
      break label29;
    }
    i = -1;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("getAVCodecVersion: AVCodec_version=");
      localStringBuilder.append(i);
      QLog.i("VideoEnvironment", 2, localStringBuilder.toString());
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getShortVideoSoLibName: errCode=");
    localStringBuilder.append(i);
    localStringBuilder.append(" soNameValue=");
    localStringBuilder.append(arrayOfString[0]);
    LogDownLoad(localStringBuilder.toString());
    if (i == 255) {
      return arrayOfString[0];
    }
    return null;
  }
  
  public static boolean isBeautySupported()
  {
    boolean bool1 = isX86Platform();
    boolean bool2 = false;
    if (bool1) {
      return false;
    }
    boolean bool3 = AVCoreSystemInfo.isBeautySupported();
    boolean bool4 = getAVCodecSupportRTBeauty();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isX86Platform: isBeautySupported=");
      localStringBuilder.append(bool3);
      localStringBuilder.append(" isSoSupportBeauty=");
      localStringBuilder.append(bool4);
      QLog.d("VideoEnvironment", 2, localStringBuilder.toString());
    }
    bool1 = bool2;
    if (bool3)
    {
      bool1 = bool2;
      if (bool4) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static boolean isShortVideoSoLibLoaded()
  {
    return ShortVideoSoLoad.getShortVideoSoLoadStatus() == 0;
  }
  
  public static boolean isX86Platform()
  {
    return DeviceInfoUtil.k();
  }
  
  private static int judgeCurrentSpVideoNameValidate(String[] paramArrayOfString)
  {
    String str = ShortVideoSoManager.a();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("LoadPathSo: currentSoName=");
    ((StringBuilder)localObject).append(str);
    LogDownLoad(((StringBuilder)localObject).toString());
    if (str.equals("d000_1")) {
      return -11;
    }
    localObject = ShortVideoSoManager.a(str);
    int i = ((ShortVideoSoManager.CfgParser)localObject).a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("LoadPathSo: CfgParser err=");
    localStringBuilder.append(i);
    LogDownLoad(localStringBuilder.toString());
    if (i == 0)
    {
      localObject = ((ShortVideoSoManager.CfgParser)localObject).b();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("LoadPathSo: currentVersion=");
      localStringBuilder.append((String)localObject);
      localStringBuilder.append(" dymAVCodecVersion=");
      localStringBuilder.append(65);
      LogDownLoad(localStringBuilder.toString());
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
    //   3: invokestatic 127	com/tencent/video/decode/ShortVideoSoLoad:getShortVideoSoLoadStatus	()I
    //   6: istore_0
    //   7: iload_0
    //   8: ifne +36 -> 44
    //   11: new 45	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   18: astore_1
    //   19: aload_1
    //   20: ldc 233
    //   22: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: pop
    //   26: aload_1
    //   27: iload_0
    //   28: invokevirtual 154	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   31: pop
    //   32: aload_1
    //   33: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   36: invokestatic 101	com/tencent/mobileqq/shortvideo/VideoEnvironment:LogDownLoad	(Ljava/lang/String;)V
    //   39: ldc 2
    //   41: monitorexit
    //   42: iload_0
    //   43: ireturn
    //   44: getstatic 74	com/tencent/mobileqq/shortvideo/VideoEnvironment:mLockLoadStatus	Ljava/lang/Object;
    //   47: astore_1
    //   48: aload_1
    //   49: monitorenter
    //   50: invokestatic 236	com/tencent/mobileqq/shortvideo/VideoEnvironment:realDoLoadSo	()I
    //   53: istore_0
    //   54: new 45	java/lang/StringBuilder
    //   57: dup
    //   58: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   61: astore_2
    //   62: aload_2
    //   63: ldc 238
    //   65: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: pop
    //   69: aload_2
    //   70: iload_0
    //   71: invokevirtual 154	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   74: pop
    //   75: aload_2
    //   76: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   79: invokestatic 101	com/tencent/mobileqq/shortvideo/VideoEnvironment:LogDownLoad	(Ljava/lang/String;)V
    //   82: aload_1
    //   83: monitorexit
    //   84: ldc 2
    //   86: monitorexit
    //   87: iload_0
    //   88: ireturn
    //   89: astore_2
    //   90: aload_1
    //   91: monitorexit
    //   92: aload_2
    //   93: athrow
    //   94: astore_1
    //   95: ldc 2
    //   97: monitorexit
    //   98: aload_1
    //   99: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   6	82	0	i	int
    //   94	5	1	localObject2	Object
    //   61	15	2	localStringBuilder	StringBuilder
    //   89	4	2	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   50	84	89	finally
    //   90	92	89	finally
    //   3	7	94	finally
    //   11	39	94	finally
    //   44	50	94	finally
    //   92	94	94	finally
  }
  
  public static boolean needDownloadCurrentServerVersion(int paramInt)
  {
    boolean bool;
    if (paramInt >= 65) {
      bool = true;
    } else {
      bool = false;
    }
    if (!bool)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("needDownloadCurrentServerVersion, serverVersion=");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" dymAVCodecVersion=");
      localStringBuilder.append(65);
      LogDownLoad(localStringBuilder.toString());
    }
    return bool;
  }
  
  private static int realDoLoadSo()
  {
    String str = ShortVideoSoLoad.getShortVideoSoPath(getContext());
    Object localObject = new String[1];
    int i = judgeCurrentSpVideoNameValidate((String[])localObject);
    if (i == 255)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append(localObject[0]);
      str = localStringBuilder.toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("Before LoadPath so. loadSoPath=");
      localStringBuilder.append(str);
      localStringBuilder.append(" soNameValue[0]=");
      localStringBuilder.append(localObject[0]);
      LogDownLoad(localStringBuilder.toString());
      i = ShortVideoSoLoad.LoadExtractedShortVideo(str);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("After LoadPath so. errCode=");
      ((StringBuilder)localObject).append(i);
      LogDownLoad(((StringBuilder)localObject).toString());
      return i;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("realDoLoadSo[errCode=");
    ((StringBuilder)localObject).append(i);
    ((StringBuilder)localObject).append("]");
    LogDownLoad(((StringBuilder)localObject).toString());
    return i;
  }
  
  public static boolean supportShortVideoRecordAndPlay()
  {
    if (Build.VERSION.SDK_INT < 18)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("supportShortVideoRecordAndPlay:SDK_INT=");
        ((StringBuilder)localObject).append(Build.VERSION.SDK_INT);
        QLog.d("VideoEnvironment", 2, ((StringBuilder)localObject).toString());
      }
      return false;
    }
    Object localObject = Build.CPU_ABI;
    StringBuilder localStringBuilder;
    if (isX86Platform())
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("supportShortVideoRecordAndPlay:isX86Platform, don't support, Build.CPU_ABI=");
        localStringBuilder.append((String)localObject);
        QLog.d("VideoEnvironment", 2, localStringBuilder.toString());
      }
      return false;
    }
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("supportShortVideoRecordAndPlay: support, Build.CPU_ABI=");
      localStringBuilder.append((String)localObject);
      QLog.d("VideoEnvironment", 2, localStringBuilder.toString());
    }
    return true;
  }
  
  public static boolean supportSubmitCallback()
  {
    int i = getAVCodecVersion();
    boolean bool = getAVCodecSupportFeature(2);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("supportSubmitCallback: soVersion =");
      localStringBuilder.append(i);
      localStringBuilder.append(", result = ");
      localStringBuilder.append(bool);
      QLog.d("VideoEnvironment", 2, localStringBuilder.toString());
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.VideoEnvironment
 * JD-Core Version:    0.7.0.1
 */