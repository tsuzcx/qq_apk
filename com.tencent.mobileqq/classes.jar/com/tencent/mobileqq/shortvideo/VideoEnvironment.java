package com.tencent.mobileqq.shortvideo;

import akur;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.SparseArray;
import bbrm;
import bbrn;
import bbsu;
import bbub;
import bbxj;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.AccountDpcManager.DpcAccountNames;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.shortvideo.mediadevice.CodecParam;
import com.tencent.mobileqq.shortvideo.util.ShortVideoTrimmer;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;
import com.tencent.video.decode.ShortVideoSoLoad;
import java.io.File;
import java.lang.reflect.Method;
import java.util.ArrayList;
import lld;

public class VideoEnvironment
{
  private static final int AVCODEC_FEATURE_NUM = 16;
  public static final int AVCODEC_MD_SURPPORT_AUDIO_SYNC = 5;
  public static final int AVCODEC_MD_SURPPORT_IMAGE_PAYER = 4;
  public static final int AVCODEC_MD_SURPPORT_MIX_AUDIO = 3;
  public static final int AVCODEC_MD_SURPPORT_MULTI_BLOCK = 7;
  public static final int AVCODEC_MD_SURPPORT_PRE_SEND = 2;
  private static final int AVCODEC_MD_SURPPORT_PTV_FEATURE = 6;
  private static final int AVCODEC_MD_SURPPORT_RT_BEAUTY = 1;
  private static final int AVCODEC_MD_VERSION = 0;
  private static final String BK_PATH_NAME = "backup";
  private static final int BUILTIN_CLEAR_VERSION = 1;
  public static final String[] DEBUG_BITRATES = { "1000", "2000", "4000", "8000" };
  public static final String[] DEBUG_CONFIGS = { "30|6|1|640*480|450000|50000|1|35|3|1|800|1150|0|key=1920*1080#2000#3000;640*480#450#750|c2x=0|discussion=0|group=0|C2CNetworkConfigs=1;1;0|DiscussionNetworkConfigs=1;1;0|GroupNetworkConfigs=1;1;0|Duration=6;10|whiteList= |blackList= |useDPCResolution=0|ratio=1;1|450#6500#3#3#35;750#6500#3#5#45;1500#6500#3#9#55;2000#6500#3#9#55;3000#6500#3#9#55|1|dynamic=1", "30|6|1|640*480|450000|50000|1|35|3|1|800|1150|0|key=1280*720#1500#2000;640*480#450#750|c2x=0|discussion=0|group=0|C2CNetworkConfigs=1;1;0|DiscussionNetworkConfigs=1;1;0|GroupNetworkConfigs=1;1;0|Duration=6;10|whiteList= |blackList= |useDPCResolution=0|ratio=1;1|450#6500#3#3#35;750#6500#3#5#45;1500#6500#3#9#55;2000#6500#3#9#55|1|dynamic=1", "30|6|1|640*480|450000|50000|1|35|3|1|800|1150|0|key=960*720#1500#2000;640*480#450#750|c2x=0|discussion=0|group=0|C2CNetworkConfigs=1;1;0|DiscussionNetworkConfigs=1;1;0|GroupNetworkConfigs=1;1;0|Duration=6;10|whiteList= |blackList= |useDPCResolution=0|ratio=1;1|450#6500#3#3#35;750#6500#3#5#45;1500#6500#3#9#55;2000#6500#3#9#55|1|dynamic=1", "30|6|1|640*480|450000|50000|1|35|3|1|800|1150|0|key=640*480#450#750;640*480#450#750|c2x=0|discussion=0|group=0|C2CNetworkConfigs=1;1;0|DiscussionNetworkConfigs=1;1;0|GroupNetworkConfigs=1;1;0|Duration=6;10|whiteList= |blackList= |useDPCResolution=0|ratio=1;1|450#6500#3#3#35;750#6500#3#5#45;1500#6500#3#9#55;2000#6500#3#9#55|1|dynamic=1" };
  public static final String[] DEBUG_RESOLUTIONS;
  public static final int[] DEBUG_RESOLUTIONS_WIDTH;
  private static final String FLOW_FILTER_CLEAR_KEY = "flow_filter_clear_key";
  private static final String FLOW_FILTER_CLEAR_VERSION = "flow_filter_clear_sp";
  private static final boolean LOCAL_TEST_ENV_CONFIG = false;
  private static final int MAX_LIMIT_SO_NUM = 3;
  private static final int NEW_JUDGE_SO_NAMEVERSION_OK = 255;
  private static final int NEW_LOAD_ERR_PARSER = -12;
  private static final int NEW_LOAD_ERR_SO_NAME_NULL = -11;
  private static final int NEW_LOAD_ERR_VERSION = -13;
  private static final String PROPERTY_HARDWARE_UI = "persist.sys.ui.hw";
  public static final int PTV_FEATURE_SURPPORT_FILTER = 0;
  public static boolean RECEIVE_NOTIFY = false;
  public static final String SHORT_VIDEO_CONFIG = "sv_config";
  public static final String SHORT_VIDEO_DPC_WHITELIST = "sv_whitelist";
  private static final boolean SHORT_VIDEO_HOOK_SO_LOAD = false;
  private static final String SO_AVCODEC_NAME = "AVCodec";
  private static final String SO_SECURITY_DIR;
  public static final int SV_CONFIG_UPDATE_ENCODE = 2;
  public static final int SV_CONFIG_UPDATE_FAILED = -1;
  public static final int SV_CONFIG_UPDATE_MAXTIME = 4;
  public static final int SV_CONFIG_UPDATE_RECORDER = 1;
  public static final int SV_CONFIG_UPDATE_SUCCESS = 0;
  private static final boolean SV_DISABLE_DOWNLOAD_SO = false;
  public static int SV_FONFIG_STATUS = 0;
  public static boolean SV_SUPPORT_LOAD_X86_SO = false;
  private static final String[] S_PRESERVED_NAME;
  public static final String TAG = "VideoEnvironment";
  private static ArrayList<VideoEnvironment.ShortVideoDownload> clientArray = new ArrayList(2);
  public static VideoEnvironment.ShortVideoConfig configParam;
  public static String debugDecodeFilePath;
  public static final String defaultConfig = "30|6|1|640*480|450000|50000|1|35|3|1|800|1150|0|key=960*720#1500#2000;640*480#450#750|c2x=0|discussion=0|group=0|C2CNetworkConfigs=1;1;0|DiscussionNetworkConfigs=1;1;0|GroupNetworkConfigs=1;1;0|Duration=6;10|whiteList= |blackList= |useDPCResolution=0|ratio=1;1|450#6500#3#3#35;750#6500#3#5#45;1500#6500#3#9#55;2000#6500#3#9#55|1|dynamic=0";
  public static final int dymAVCodecVersion = 65;
  private static boolean gAVCodecInitMD = false;
  private static int[] gAVCodecMetadata = new int[16];
  private static Object lockConfig;
  private static Object mLockLoadStatus;
  private static Object mLockunzip;
  private static final String sBuiltInAVCodecMd5 = "";
  public static Handler sMainHandler = new Handler(Looper.getMainLooper());
  private static boolean sSoNotSupport;
  private static final boolean sUseBuiltInAVCodec = false;
  
  static
  {
    debugDecodeFilePath = VFSAssistantUtils.getSDKPrivatePath(AppConstants.SDCARD_ROOT + "/Tencent/com/tencent/mobileqq/debugDecodeShortVideo");
    File localFile = new File(ShortVideoSoLoad.getShortVideoSoPath(getContext()));
    if (!localFile.exists())
    {
      localFile.mkdirs();
      LogDownLoad("VideoEnvironment:[static]loadPathFile not exist...", null);
    }
    S_PRESERVED_NAME = new String[] { "backup", "trim_process_pic", "trim_process_pie" };
    mLockLoadStatus = new Object();
    mLockunzip = new Object();
    SO_SECURITY_DIR = "backup" + File.separatorChar;
    SV_FONFIG_STATUS = -1;
    configParam = new VideoEnvironment.ShortVideoConfig();
    lockConfig = new Object();
    DEBUG_RESOLUTIONS = new String[] { "1920*1080", "1280*720", "960*720", "640*480" };
    DEBUG_RESOLUTIONS_WIDTH = new int[] { 1920, 1280, 960, 640 };
  }
  
  public static void LogDownLoad(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (QLog.isColorLevel())
    {
      if (paramThrowable != null) {
        QLog.i(paramString1, 2, paramString2, paramThrowable);
      }
    }
    else {
      return;
    }
    QLog.i(paramString1, 2, paramString2);
  }
  
  public static void LogDownLoad(String paramString, Throwable paramThrowable)
  {
    LogDownLoad("VideoEnvironment", paramString, paramThrowable);
  }
  
  public static void ModifyConfig(VideoEnvironment.ShortVideoConfig paramShortVideoConfig)
  {
    synchronized (lockConfig)
    {
      configParam = paramShortVideoConfig;
      SV_FONFIG_STATUS = 0;
      return;
    }
  }
  
  public static void Notify(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("VideoEnvironment", 2, "VideoEnvironment|progress=" + paramInt);
    }
    for (;;)
    {
      try
      {
        Object[] arrayOfObject = clientArray.toArray();
        if ((arrayOfObject == null) || (arrayOfObject.length <= 0)) {
          return;
        }
      }
      finally {}
      int i = 0;
      while (i < localObject.length)
      {
        VideoEnvironment.ShortVideoDownload localShortVideoDownload = (VideoEnvironment.ShortVideoDownload)localObject[i];
        sMainHandler.post(new VideoEnvironment.2(localShortVideoDownload, paramInt));
        i += 1;
      }
    }
  }
  
  public static void Notify(boolean paramBoolean, AppInterface paramAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.i("VideoEnvironment", 2, "VideoEnvironment[success=" + paramBoolean + "][Video so download success...]");
    }
    if ((paramBoolean) && (supportShortVideoRecordAndPlay(paramAppInterface))) {
      loadAVCodecPreDownload();
    }
    for (;;)
    {
      try
      {
        RECEIVE_NOTIFY = true;
        paramAppInterface = clientArray.toArray();
        if (paramBoolean) {
          clientArray.clear();
        }
        if ((paramAppInterface == null) || (paramAppInterface.length <= 0)) {
          return;
        }
      }
      finally {}
      int i = 0;
      while (i < paramAppInterface.length)
      {
        VideoEnvironment.ShortVideoDownload localShortVideoDownload = (VideoEnvironment.ShortVideoDownload)paramAppInterface[i];
        sMainHandler.post(new VideoEnvironment.3(localShortVideoDownload, paramBoolean));
        i += 1;
      }
    }
  }
  
  private static void PrintPreDownloadInfo(String paramString)
  {
    LogDownLoad("PrintPreDownloadInfo:[" + paramString + "]-------------***-------------", null);
  }
  
  public static void RegisterNotify(VideoEnvironment.ShortVideoDownload paramShortVideoDownload)
  {
    if (paramShortVideoDownload != null) {}
    try
    {
      if (!clientArray.contains(paramShortVideoDownload))
      {
        if (QLog.isColorLevel()) {
          QLog.i("VideoEnvironment", 2, "VideoEnvironment:RegisterNotify");
        }
        clientArray.add(paramShortVideoDownload);
      }
      return;
    }
    finally {}
  }
  
  public static void UnregisterNotify(VideoEnvironment.ShortVideoDownload paramShortVideoDownload)
  {
    if (paramShortVideoDownload != null) {}
    try
    {
      if (clientArray.contains(paramShortVideoDownload))
      {
        if (QLog.isColorLevel()) {
          QLog.i("VideoEnvironment", 2, "VideoEnvironment:UnregisterNotify");
        }
        clientArray.remove(paramShortVideoDownload);
      }
      return;
    }
    finally {}
  }
  
  public static void UpdateEncodeParam(int paramInt)
  {
    if (SV_FONFIG_STATUS != -1) {
      synchronized (lockConfig)
      {
        VideoEnvironment.SVFileSizeCtrlFactor localSVFileSizeCtrlFactor = (VideoEnvironment.SVFileSizeCtrlFactor)configParam.sizeFactor.get(paramInt);
        if (localSVFileSizeCtrlFactor != null)
        {
          CodecParam.mQmax = localSVFileSizeCtrlFactor.qmax;
          CodecParam.mQmin = localSVFileSizeCtrlFactor.qmin;
          CodecParam.mMaxQdiff = localSVFileSizeCtrlFactor.qmaxdiff;
          CodecParam.mMaxrate = configParam.mMaxrate;
          CodecParam.mMinrate = configParam.mMinrate;
          CodecParam.mRefframe = configParam.mRefframe;
          CodecParam.mIsSmooth = configParam.mIsSmooth;
          SV_FONFIG_STATUS |= 0x2;
          return;
        }
        CodecParam.mQmax = configParam.mQmax;
        CodecParam.mQmin = configParam.mQmin;
        CodecParam.mMaxQdiff = configParam.mMaxQdiff;
      }
    }
  }
  
  public static void UpdateMaxTimeParam(int paramInt)
  {
    if (SV_FONFIG_STATUS != -1) {
      synchronized (lockConfig)
      {
        VideoEnvironment.SVFileSizeCtrlFactor localSVFileSizeCtrlFactor = (VideoEnvironment.SVFileSizeCtrlFactor)configParam.sizeFactor.get(paramInt);
        if (localSVFileSizeCtrlFactor != null)
        {
          CodecParam.RECORD_MAX_TIME = localSVFileSizeCtrlFactor.time;
          SV_FONFIG_STATUS |= 0x4;
          return;
        }
        if (configParam.mMaxTime > 600) {
          configParam.mMaxTime = 8;
        }
        CodecParam.RECORD_MAX_TIME = configParam.mMaxTime * 1000;
      }
    }
  }
  
  public static int[] UpdateQualitySelector(int paramInt)
  {
    localObject4 = lockConfig;
    switch (paramInt)
    {
    }
    for (;;)
    {
      try
      {
        localObject1 = bbsu.d;
        localObject3 = localObject1;
        if (localObject1.length != bbsu.d.length) {
          localObject3 = bbsu.d;
        }
        return localObject3;
      }
      finally {}
      Object localObject3 = configParam.mDiscussionNetworkConfigs;
      Object localObject1 = localObject3;
      if (localObject3 == null)
      {
        localObject1 = bbsu.f;
        continue;
        localObject3 = configParam.mGroupNetworkConfigs;
        localObject1 = localObject3;
        if (localObject3 == null)
        {
          localObject1 = bbsu.e;
          continue;
          localObject3 = configParam.mC2CNetworkConfigs;
          localObject1 = localObject3;
          if (localObject3 == null) {
            localObject1 = bbsu.d;
          }
        }
      }
    }
  }
  
  public static void UpdateRecorderParam()
  {
    if ((SV_FONFIG_STATUS & 0x1) == 0) {
      synchronized (lockConfig)
      {
        CodecParam.VIDEO_FPS = configParam.mFps;
        CodecParam.VIDEO_RATIO_MOL = configParam.mRatioMolecule;
        CodecParam.VIDEO_RATIO_DEN = configParam.mRatioDenominator;
        SV_FONFIG_STATUS |= 0x1;
        return;
      }
    }
  }
  
  public static int[] UpdateRecorderResolution(int paramInt, boolean paramBoolean)
  {
    Object localObject1 = null;
    int i = -1;
    int k = -1;
    int m = k;
    int j = i;
    int[] arrayOfInt;
    if (SV_FONFIG_STATUS != -1) {
      arrayOfInt = new int[4];
    }
    for (;;)
    {
      synchronized (lockConfig)
      {
        if ((configParam.mWidths == null) || (configParam.mHeights == null) || (configParam.mMinSize == null) || (configParam.mMaxSize == null)) {
          return null;
        }
        if (configParam.mUseDPCResolution)
        {
          arrayOfInt[0] = configParam.mWidth;
          arrayOfInt[1] = configParam.mHeight;
          arrayOfInt[2] = configParam.mMinSize[1];
          arrayOfInt[3] = configParam.mMaxSize[1];
          i = configParam.mWidth;
          paramInt = configParam.mHeight;
          localObject1 = arrayOfInt;
          j = i;
          m = paramInt;
          aktv.a = j + "*" + m;
          if ((localObject1 == null) || (localObject1.length < 2)) {
            break label672;
          }
          QLog.d("DynamicAdjustment", 2, "预览分辨率 : " + localObject1[0] + " * " + localObject1[1]);
          return localObject1;
        }
        if ((configParam.mWidths != null) && (configParam.mHeights != null))
        {
          if (!configParam.mIsWhiteList) {
            break label675;
          }
          if (paramBoolean)
          {
            break label675;
            label274:
            i = configParam.mWidths[paramInt];
            j = configParam.mHeights[paramInt];
            if (configParam.mIsDynamic)
            {
              if (QLog.isColorLevel()) {
                QLog.d("VideoEnvironment", 2, "dynamic adjust is enable");
              }
              k = paramInt;
            }
          }
        }
      }
      for (;;)
      {
        akur localakur;
        try
        {
          localObject1 = BaseApplicationImpl.getApplication().getSharedPreferences("DynamicAdjustment", 4).getString("SVDNAdjustment_quality_resolution", null);
          k = paramInt;
          localakur = akur.a((String)localObject1);
          k = paramInt;
          paramInt = 0;
          if (localakur == null) {
            break label717;
          }
        }
        catch (NumberFormatException localNumberFormatException1) {}
        try
        {
          if (paramInt >= configParam.mWidths.length) {
            break label717;
          }
          m = k;
          if (configParam.mWidths[paramInt] == localakur.a)
          {
            int n = configParam.mHeights[paramInt];
            int i1 = localakur.b;
            m = k;
            if (n == i1)
            {
              k = paramInt;
              QLog.d("DynamicAdjustment", 2, "应用动态调整分辨率" + (String)localObject1);
              m = paramInt;
            }
          }
          paramInt += 1;
          k = m;
        }
        catch (NumberFormatException localNumberFormatException2)
        {
          break label559;
          k = j;
          j = paramInt;
          paramInt = k;
        }
      }
      paramInt = configParam.mDiscussionIndex;
      continue;
      paramInt = configParam.mGroupIndex;
      continue;
      paramInt = configParam.mC2CIndex;
    }
    for (;;)
    {
      arrayOfInt[0] = configParam.mWidths[j];
      arrayOfInt[1] = configParam.mHeights[j];
      arrayOfInt[2] = configParam.mMinSize[j];
      arrayOfInt[3] = configParam.mMaxSize[j];
      localObject1 = arrayOfInt;
      break;
      localObject2 = finally;
      throw localObject2;
      label559:
      if (QLog.isColorLevel())
      {
        QLog.e("VideoEnvironment", 2, "parseSize(): " + localNumberFormatException1.getMessage());
        break label725;
        if (QLog.isColorLevel())
        {
          QLog.d("VideoEnvironment", 2, "dynamic adjust is disable");
          k = j;
          j = paramInt;
          paramInt = k;
          continue;
          i = configParam.mWidths[0];
          paramInt = configParam.mHeights[0];
          j = 0;
          continue;
          Object localObject3 = null;
          paramInt = k;
          break;
        }
        return localNumberFormatException2;
        switch (paramInt)
        {
        }
        paramInt = 1;
        break label274;
        label717:
        paramInt = j;
        j = k;
        continue;
      }
      label672:
      label675:
      label725:
      paramInt = j;
      j = k;
    }
  }
  
  public static void adjustFullVideoEncodeBitrate(int paramInt, boolean paramBoolean)
  {
    if (paramBoolean) {
      CodecParam.mMaxrate = paramInt * 1000;
    }
    for (CodecParam.mMaxrate += 100000;; CodecParam.mMaxrate += 350000)
    {
      CodecParam.mMinrate *= 4;
      return;
    }
  }
  
  public static boolean checkAVCodecLoadIsOK(AppInterface paramAppInterface)
  {
    if (ShortVideoUtils.isVideoSoLibLoaded()) {}
    do
    {
      return true;
      ShortVideoUtils.loadShortVideoSo(paramAppInterface);
    } while (ShortVideoUtils.isVideoSoLibLoaded());
    return false;
  }
  
  private static boolean checkIsBlackModel(String paramString)
  {
    if (paramString == null) {}
    for (;;)
    {
      return false;
      String str = Build.MODEL.toLowerCase();
      paramString = paramString.split("\\;");
      if ((paramString != null) && (paramString.length > 0))
      {
        int j = paramString.length;
        int i = 0;
        while (i < j)
        {
          if (paramString[i].equalsIgnoreCase(str)) {
            return true;
          }
          i += 1;
        }
      }
    }
  }
  
  private static boolean checkUncompressedResourceIsOK(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    paramString = new File(paramString + "config_version");
    if (!paramString.exists()) {}
    do
    {
      do
      {
        String str;
        do
        {
          do
          {
            return false;
            paramString = bbrm.a(paramString);
          } while (TextUtils.isEmpty(paramString));
          paramString = paramString.trim();
          str = getShortVideoSoLibName();
        } while ((TextUtils.isEmpty(str)) || (!str.equalsIgnoreCase(paramString)));
        paramString = bbrm.a(str);
      } while (paramString.a() != 0);
      paramString = paramString.b().trim();
    } while ((TextUtils.isEmpty(paramString)) || (!paramString.equalsIgnoreCase("" + paramInt)));
    return checkAVCodecLoadIsOK(paramQQAppInterface);
  }
  
  private static void copyBuiltInPieAndPic_HookMode(int paramInt1, int paramInt2)
  {
    String str1 = ShortVideoSoLoad.getShortVideoSoPath(getContext());
    str1 = str1 + SO_SECURITY_DIR;
    String str2 = str1 + "trim_process_pic";
    LogDownLoad("copyBuiltInPieAndPic_HookMode:[copy Pic]picPath=" + str2, null);
    boolean bool = ShortVideoTrimmer.copyResPieAndPicBuildInMode(paramInt1, str2);
    LogDownLoad("copyBuiltInPieAndPic_HookMode:[copy Pic]status=" + bool, null);
    str1 = str1 + "trim_process_pie";
    LogDownLoad("copyBuiltInPieAndPic_HookMode:[copy Pie]piePath=" + str1, null);
    bool = ShortVideoTrimmer.copyResPieAndPicBuildInMode(paramInt2, str1);
    LogDownLoad("copyBuiltInPieAndPic_HookMode:[copy Pie]status=" + bool, null);
    copyPieAndPicFile();
  }
  
  private static void copyPieAndPicFile()
  {
    Object localObject1 = ShortVideoSoLoad.getShortVideoSoPath(BaseApplicationImpl.getContext());
    Object localObject2 = (String)localObject1 + SO_SECURITY_DIR;
    File localFile1 = new File((String)localObject2 + "trim_process_pie");
    File localFile2 = new File((String)localObject1 + "trim_process_pie");
    boolean bool = localFile1.exists();
    LogDownLoad("copyPieAndPicFile:[VIDEO_TRIM_PIE]unzipExists=" + bool, null);
    if (bool) {
      copySoToFilesDir(localFile1, localFile2);
    }
    localObject2 = new File((String)localObject2 + "trim_process_pic");
    localObject1 = new File((String)localObject1 + "trim_process_pic");
    bool = ((File)localObject2).exists();
    LogDownLoad("copyPieAndPicFile:[VIDEO_TRIM_PIC]unzipExists=" + bool, null);
    if (bool) {
      copySoToFilesDir((File)localObject2, (File)localObject1);
    }
  }
  
  private static boolean copySoToFilesDir(File paramFile1, File paramFile2)
  {
    if (!paramFile1.exists()) {
      LogDownLoad("copySoToFilesDir: filesource not exist", null);
    }
    long l1;
    long l2;
    do
    {
      return false;
      String str3 = paramFile1.getAbsolutePath();
      String str1 = paramFile2.getAbsolutePath();
      boolean bool = paramFile2.exists();
      LogDownLoad("copySoToFilesDir: srcPath=" + str3 + " dstPath=" + str1 + " dstExists=" + bool, null);
      if (bool)
      {
        String str2 = bbrm.a(str3);
        LogDownLoad("copySoToFilesDir:[destFile exists] srcMd5=" + str2 + " srcPath=" + str3, null);
        str3 = bbrm.a(str1);
        LogDownLoad("copySoToFilesDir:[destFile exists] dstMd5=" + str3 + " dstPath=" + str1, null);
        if ((str2 != null) && (!"".equals(str2)) && (str2.equalsIgnoreCase(str3))) {
          return true;
        }
        paramFile2.delete();
      }
      l1 = paramFile1.length();
      FileUtils.renameFile(paramFile1, paramFile2);
      l2 = paramFile2.length();
      LogDownLoad("copySoToFilesDir: soSize=" + l1 + " deSize=" + l2, null);
    } while (l1 != l2);
    return true;
  }
  
  private static void doCopySystemLibBuiltInMode()
  {
    String str3 = getBuiltInSoLibPath();
    File localFile2;
    String str1;
    String str2;
    File localFile1;
    if (str3 != null)
    {
      localFile2 = new File(str3);
      str1 = getCopySystemLibSoNameBuiltIn();
      str2 = ShortVideoSoLoad.getShortVideoSoPath(getContext()) + str1;
      localFile1 = new File(str2);
      if (!localFile1.exists()) {
        break label186;
      }
      LogDownLoad("doCopySystemLibBuiltInMode:[already exists]loadFilePath=" + str2, null);
      String str4 = bbrm.a(str2);
      LogDownLoad("doCopySystemLibBuiltInMode:[already exists]md5Cmp=" + str4 + " sBuiltInAVCodecMd5=" + "", null);
      if ("".equalsIgnoreCase(str4))
      {
        bbrm.a(str1);
        LogDownLoad("doCopySystemLibBuiltInMode:[already exists]success loadFilePath=" + str2, null);
      }
    }
    else
    {
      return;
    }
    localFile1.delete();
    LogDownLoad("doCopySystemLibBuiltInMode:[already exists] md5 not equal delete files", null);
    label186:
    LogDownLoad("doCopySystemLibBuiltInMode:[before copyFile] loadFilePath=" + str2, null);
    boolean bool1 = FileUtils.copyFile(localFile2, localFile1);
    boolean bool2 = localFile1.exists();
    LogDownLoad("doCopySystemLibBuiltInMode[after copyFile]: success=" + bool1 + "  existsSoLib=" + bool2, null);
    if (bool2)
    {
      str3 = bbrm.a(str2);
      if ("".equalsIgnoreCase(str3))
      {
        bbrm.a(str1);
        LogDownLoad("doCopySystemLibBuiltInMode:[success copyFile]loadFilePath=" + str2, null);
        return;
      }
      localFile1.delete();
      LogDownLoad("doCopySystemLibBuiltInMode:[md5 error] md5Cmp=" + str3 + "  builtIn=" + "", null);
      return;
    }
    LogDownLoad("doCopySystemLib[copy]:copyFile error loadFilePath=" + str2, null);
    throw new Error("[doCopySystemLibBuiltInMode]copy error success=" + bool1 + " loadFilePath=" + str2 + " sysSoPath=" + str3);
  }
  
  private static void doCopySystemLibHookTestMode()
  {
    Object localObject = getBuiltInSoLibPath();
    String str2;
    if (localObject != null)
    {
      localObject = new File((String)localObject);
      String str1 = getCopySystemLibSoNameHookTestEnv();
      str2 = ShortVideoSoLoad.getShortVideoSoPath(getContext()) + str1;
      File localFile = new File(str2);
      if (localFile.exists()) {
        localFile.delete();
      }
      LogDownLoad("doCopySystemLibHookTestMode:[do copyFile] loadFilePath=" + str2, null);
      boolean bool1 = FileUtils.copyFile((File)localObject, localFile);
      boolean bool2 = localFile.exists();
      LogDownLoad("doCopySystemLibHookTestMode:[end copyFile]  success=" + bool1 + "  existsSoLib=" + bool2, null);
      if (bool2)
      {
        bbrm.a(str1);
        LogDownLoad("doCopySystemLibHookTestMode[storeSoNewVersion]:[success]loadFilePath=" + str2, null);
      }
    }
    else
    {
      return;
    }
    LogDownLoad("doCopySystemLibHookTestMode:copyFile error loadFilePath=" + str2, null);
  }
  
  private static void executeClearHistorySOLibFile()
  {
    ThreadManager.post(new VideoEnvironment.1(), 5, null, false);
  }
  
  private static native void getAVCodecLibMetadata(int[] paramArrayOfInt);
  
  public static boolean getAVCodecSurpportFeature(int paramInt)
  {
    return getAVCodecSurpportFeatureKind(paramInt) > 0;
  }
  
  private static int getAVCodecSurpportFeatureKind(int paramInt)
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
  
  public static boolean getAVCodecSurpportKindSubFeature(int paramInt1, int paramInt2)
  {
    boolean bool = true;
    if ((paramInt2 < 0) || (paramInt2 >= 32)) {
      bool = false;
    }
    while ((getAVCodecSurpportFeatureKind(paramInt1) & 0xFFFFFFFF & 1 << paramInt2) != 0) {
      return bool;
    }
    return false;
  }
  
  public static boolean getAVCodecSurpportRTBeauty()
  {
    return getAVCodecSurpportFeatureKind(1) > 0;
  }
  
  public static int getAVCodecVersion()
  {
    try
    {
      if (!gAVCodecInitMD)
      {
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
  
  private static String getBuiltInSoLibPath()
  {
    String str = getSystemSolibPath();
    if ((str != null) && (!"".equals(str)))
    {
      str = str + File.separatorChar;
      str = str + getUnzipTempLibActualName("AVCodec");
      LogDownLoad("doCopySystemLib[copy]: sysSoPath=" + str, null);
      if (!new File(str).exists()) {
        LogDownLoad("doCopySystemLib[copy]: sysSoFile not exists...", null);
      }
    }
    else
    {
      return null;
    }
    return str;
  }
  
  public static Context getContext()
  {
    return BaseApplicationImpl.getContext();
  }
  
  private static String getCopySdcardSoNameHookTestEnv()
  {
    return bbrm.a("HookTestAVCodecSdcard002", "65");
  }
  
  private static String getCopySystemLibSoNameBuiltIn()
  {
    return bbrm.a("", "65");
  }
  
  private static String getCopySystemLibSoNameHookTestEnv()
  {
    return bbrm.a("HookTestAVCodec001", "65");
  }
  
  public static boolean getIsC2c(int paramInt)
  {
    return paramInt == 0;
  }
  
  public static int getShortVideoSoLibLoadStatus()
  {
    return ShortVideoSoLoad.getShortVideoSoLoadStatus();
  }
  
  public static String getShortVideoSoLibName()
  {
    String[] arrayOfString = new String[1];
    int i = judgeCurrentSpVideoNameValidate(arrayOfString);
    LogDownLoad("getShortVideoSoLibName: errcode=" + i + " soNameValue=" + arrayOfString[0], null);
    if (i == 255) {
      return arrayOfString[0];
    }
    PrintPreDownloadInfo("getShortVideoSoLibName[err=" + i + "]");
    LogDownLoad("getShortVideoSoLibName[get End],errcode=" + i, null);
    return null;
  }
  
  private static String getSystemSolibPath()
  {
    Context localContext = getContext();
    PackageManager localPackageManager = localContext.getPackageManager();
    String str = localContext.getPackageName();
    Object localObject1 = str;
    if (str == null) {
      localObject1 = "com.tencent.mobileqq";
    }
    try
    {
      localObject1 = localPackageManager.getPackageInfo((String)localObject1, 1024);
      if ((localObject1 != null) && (((PackageInfo)localObject1).applicationInfo != null))
      {
        localObject1 = ((PackageInfo)localObject1).applicationInfo.nativeLibraryDir;
        LogDownLoad("doCopySystemLib[PackageInfo]: sysLibDir=" + (String)localObject1, null);
        LogDownLoad("doCopySystemLib[before copy]: sysLibDir=" + (String)localObject1, null);
        return localObject1;
      }
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      for (;;)
      {
        LogDownLoad("doCopySystemLib: exp=", localNameNotFoundException);
        Object localObject2 = null;
        continue;
        localObject2 = localContext.getFilesDir();
        if (localObject2 != null)
        {
          localObject2 = ((File)localObject2).getParent();
          localObject2 = (String)localObject2 + "/lib";
          LogDownLoad("doCopySystemLib[getFilesDir]: sysLibDir=" + (String)localObject2, null);
        }
        else
        {
          localObject2 = null;
        }
      }
    }
  }
  
  private static String getUnzipTempLibActualName(String paramString)
  {
    return "lib" + paramString + ".so";
  }
  
  private static String getValue(String paramString1, String paramString2)
  {
    int i = paramString1.indexOf("=");
    if (i == -1) {
      return paramString2;
    }
    return paramString1.substring(i + 1);
  }
  
  public static void initBuiltInDoCopyEnvStep(int paramInt1, int paramInt2)
  {
    Object localObject = ShortVideoSoLoad.getShortVideoSoPath(getContext());
    localObject = new File((String)localObject + SO_SECURITY_DIR);
    boolean bool = ((File)localObject).exists();
    LogDownLoad("initBuiltInDoCopyEnvStep:[begin] backupDirExists=" + bool, null);
    if (!bool) {
      ((File)localObject).mkdirs();
    }
    localObject = BaseApplicationImpl.getApplication().getSharedPreferences("flow_filter_clear_sp", 4);
    if (((SharedPreferences)localObject).getInt("flow_filter_clear_key", -1) < 1) {
      ((SharedPreferences)localObject).edit().putInt("flow_filter_clear_key", 1).commit();
    }
    LogDownLoad("initBuiltInDoCopyEnvStep:clear earlyDownload cache data...", null);
    bbxj.a();
    LogDownLoad("initBuiltInDoCopyEnvStep:[end]...", null);
  }
  
  public static void initConfig(AppInterface paramAppInterface, String paramString, boolean paramBoolean)
  {
    if ((paramAppInterface == null) && (QLog.isColorLevel())) {
      QLog.d("VideoEnvironment", 2, "initConfig()[use default index]: app is null");
    }
    long l1 = System.currentTimeMillis();
    paramAppInterface = paramString;
    if (paramString == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoEnvironment", 2, "initConfig()[use user passed config]: config is null");
      }
      paramAppInterface = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.SV658Cfg.name(), null);
    }
    if (QLog.isColorLevel()) {
      QLog.d("VideoEnvironment", 2, "initConfig(): DPConfig = " + paramAppInterface);
    }
    paramString = paramAppInterface;
    if (paramAppInterface == null) {
      paramString = "30|6|1|640*480|450000|50000|1|35|3|1|800|1150|0|key=960*720#1500#2000;640*480#450#750|c2x=0|discussion=0|group=0|C2CNetworkConfigs=1;1;0|DiscussionNetworkConfigs=1;1;0|GroupNetworkConfigs=1;1;0|Duration=6;10|whiteList= |blackList= |useDPCResolution=0|ratio=1;1|450#6500#3#3#35;750#6500#3#5#45;1500#6500#3#9#55;2000#6500#3#9#55|1|dynamic=0";
    }
    if (QLog.isColorLevel()) {
      QLog.d("VideoEnvironment", 2, "initConfig(): config=" + paramString);
    }
    VideoEnvironment.ShortVideoConfig localShortVideoConfig = new VideoEnvironment.ShortVideoConfig();
    try
    {
      paramAppInterface = paramString.split(",");
      if ((paramAppInterface == null) || (paramAppInterface.length == 0))
      {
        if (!QLog.isColorLevel()) {
          break label1705;
        }
        QLog.d("VideoEnvironment", 2, "initConfig(): configs is null or its length is 0");
        return;
      }
      boolean bool = paramBoolean;
      if (!paramBoolean) {
        bool = DeviceProfileManager.a().a(DeviceProfileManager.AccountDpcManager.DpcAccountNames.picpredownload_whitelist.name());
      }
      if (QLog.isColorLevel()) {
        QLog.d("VideoEnvironment", 2, "initConfig(): isInDPCWhiteList=" + bool);
      }
      paramString = paramAppInterface[0].split("\\|");
      if ((paramString == null) || (paramString.length < 13))
      {
        if (!QLog.isColorLevel()) {
          break label1705;
        }
        QLog.d("VideoEnvironment", 2, "initConfig(): configs is null or length less than 13");
        return;
      }
    }
    catch (Exception paramAppInterface)
    {
      if (QLog.isColorLevel()) {
        QLog.e("VideoEnvironment", 2, "initConfig(): " + paramAppInterface.getMessage());
      }
    }
    label610:
    Object localObject2;
    label828:
    label1008:
    label1138:
    for (;;)
    {
      long l2 = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d("VideoEnvironment", 2, "initConfig(): time cost " + (l2 - l1) + "ms");
      }
      ModifyConfig(localShortVideoConfig);
      return;
      paramAppInterface = paramString[3].split("\\*");
      if ((paramAppInterface == null) || (paramAppInterface.length != 2))
      {
        if (!QLog.isColorLevel()) {
          break label1705;
        }
        QLog.d("VideoEnvironment", 2, "initConfig(): resolution is null or length is not 2");
        return;
      }
      localShortVideoConfig.mIndex = 0;
      localShortVideoConfig.mWidth = Integer.valueOf(paramAppInterface[0]).intValue();
      localShortVideoConfig.mHeight = Integer.valueOf(paramAppInterface[1]).intValue();
      localShortVideoConfig.mFps = Integer.valueOf(paramString[0]).intValue();
      localShortVideoConfig.mMaxTime = Integer.valueOf(paramString[1]).intValue();
      localShortVideoConfig.mIsSmooth = Integer.valueOf(paramString[2]).intValue();
      localShortVideoConfig.mMaxrate = Integer.valueOf(paramString[4]).intValue();
      localShortVideoConfig.mMinrate = Integer.valueOf(paramString[5]).intValue();
      localShortVideoConfig.mQmin = Integer.valueOf(paramString[6]).intValue();
      localShortVideoConfig.mQmax = Integer.valueOf(paramString[7]).intValue();
      localShortVideoConfig.mMaxQdiff = Integer.valueOf(paramString[8]).intValue();
      localShortVideoConfig.mRefframe = Integer.valueOf(paramString[9]).intValue();
      localShortVideoConfig.mMemory = Integer.valueOf(paramString[10]).intValue();
      localShortVideoConfig.mCpu = Integer.valueOf(paramString[11]).intValue();
      localShortVideoConfig.mIsArmv7a = Integer.valueOf(paramString[12]).intValue();
      if (paramString.length < 17)
      {
        i = 1;
        paramAppInterface = null;
        if (i == 0) {
          break label1008;
        }
        if (QLog.isColorLevel()) {
          QLog.d("VideoEnvironment", 2, "initConfig(): (resolutions == null) || (resolutions.length == 0) || (indexs.length != 3)");
        }
        localShortVideoConfig.mWidths = new int[] { localShortVideoConfig.mWidth };
        localShortVideoConfig.mHeights = new int[] { localShortVideoConfig.mHeight };
        localShortVideoConfig.mC2CIndex = 0;
        localShortVideoConfig.mDiscussionIndex = 0;
      }
      for (localShortVideoConfig.mGroupIndex = 0;; localShortVideoConfig.mGroupIndex = i)
      {
        if (paramString.length <= 25) {
          break label1138;
        }
        paramAppInterface = getValue(paramString[17], "").split(";");
        localShortVideoConfig.mC2CNetworkConfigs = new int[paramAppInterface.length];
        i = 0;
        while (i < paramAppInterface.length)
        {
          localObject1 = paramAppInterface[i];
          localShortVideoConfig.mC2CNetworkConfigs[i] = Integer.valueOf((String)localObject1).intValue();
          i += 1;
        }
        paramAppInterface = getValue(paramString[13], "");
        if (TextUtils.isEmpty(paramAppInterface))
        {
          i = 1;
          paramAppInterface = null;
          break;
        }
        paramAppInterface = paramAppInterface.split(";");
        if ((paramAppInterface == null) || (paramAppInterface.length == 0)) {
          break label1706;
        }
        localShortVideoConfig.mWidths = new int[paramAppInterface.length];
        localShortVideoConfig.mHeights = new int[paramAppInterface.length];
        localShortVideoConfig.mMinSize = new int[paramAppInterface.length];
        localShortVideoConfig.mMaxSize = new int[paramAppInterface.length];
        i = 0;
        if (i >= paramAppInterface.length) {
          break label1700;
        }
        localObject1 = paramAppInterface[i].split("#");
        if ((localObject1 == null) || (localObject1.length < 3)) {
          break label1711;
        }
        localObject2 = localObject1[0].split("\\*");
        if ((localObject2 == null) || (localObject2.length != 2))
        {
          if (QLog.isColorLevel()) {
            QLog.d("VideoEnvironment", 2, "initConfig(): res is null or length is not 2");
          }
          localShortVideoConfig.mWidths[i] = localShortVideoConfig.mWidth;
          localShortVideoConfig.mHeights[i] = localShortVideoConfig.mHeight;
        }
        while ((localObject1[1] != null) && (localObject1[2] != null))
        {
          localShortVideoConfig.mMinSize[i] = Integer.valueOf(localObject1[1]).intValue();
          localShortVideoConfig.mMaxSize[i] = Integer.valueOf(localObject1[2]).intValue();
          break;
          localShortVideoConfig.mWidths[i] = Integer.valueOf(localObject2[0]).intValue();
          localShortVideoConfig.mHeights[i] = Integer.valueOf(localObject2[1]).intValue();
        }
        localShortVideoConfig.mC2CIndex = Integer.valueOf(getValue(paramString[14], "0")).intValue();
        localShortVideoConfig.mDiscussionIndex = Integer.valueOf(getValue(paramString[15], "0")).intValue();
        localShortVideoConfig.mGroupIndex = Integer.valueOf(getValue(paramString[16], "0")).intValue();
        if (localShortVideoConfig.mC2CIndex >= paramAppInterface.length) {
          break label1718;
        }
        i = localShortVideoConfig.mC2CIndex;
        localShortVideoConfig.mC2CIndex = i;
        if (localShortVideoConfig.mDiscussionIndex >= paramAppInterface.length) {
          break label1723;
        }
        i = localShortVideoConfig.mDiscussionIndex;
        localShortVideoConfig.mDiscussionIndex = i;
        if (localShortVideoConfig.mGroupIndex >= paramAppInterface.length) {
          break label1728;
        }
        i = localShortVideoConfig.mGroupIndex;
      }
    }
    label1087:
    label1109:
    label1131:
    paramAppInterface = getValue(paramString[18], "").split(";");
    localShortVideoConfig.mDiscussionNetworkConfigs = new int[paramAppInterface.length];
    int i = 0;
    while (i < paramAppInterface.length)
    {
      localObject1 = paramAppInterface[i];
      localShortVideoConfig.mDiscussionNetworkConfigs[i] = Integer.valueOf((String)localObject1).intValue();
      i += 1;
    }
    Object localObject1 = getValue(paramString[19], "").split(";");
    localShortVideoConfig.mGroupNetworkConfigs = new int[paramAppInterface.length];
    i = 0;
    while (i < localObject1.length)
    {
      paramAppInterface = localObject1[i];
      localShortVideoConfig.mGroupNetworkConfigs[i] = Integer.valueOf(paramAppInterface).intValue();
      i += 1;
    }
    paramAppInterface = getValue(paramString[20], "").split(";");
    if ((paramAppInterface != null) && (paramAppInterface.length == 2))
    {
      localShortVideoConfig.mDurationLowerLimit = Integer.valueOf(paramAppInterface[0]).intValue();
      localShortVideoConfig.mDurationUpperLimit = Integer.valueOf(paramAppInterface[1]).intValue();
    }
    localShortVideoConfig.mIsWhiteList = getValue(paramString[21], "").toLowerCase().contains(Build.MODEL.toLowerCase());
    if (!bbub.d(bbub.i)) {
      if (!bbub.b(bbub.G)) {
        break label1745;
      }
    }
    for (;;)
    {
      label1362:
      localShortVideoConfig.mIsBlackList = paramBoolean;
      if (!localShortVideoConfig.mIsBlackList) {
        localShortVideoConfig.mIsBlackList = checkIsBlackModel(getValue(paramString[22], ""));
      }
      localShortVideoConfig.mUseDPCResolution = getValue(paramString[23], "").equals("1");
      paramAppInterface = getValue(paramString[24], "").split(";");
      if ((paramAppInterface != null) && (paramAppInterface.length == 2))
      {
        localShortVideoConfig.mRatioMolecule = Integer.valueOf(paramAppInterface[0]).intValue();
        localShortVideoConfig.mRatioDenominator = Integer.valueOf(paramAppInterface[1]).intValue();
      }
      paramAppInterface = paramString[25].split(";");
      if ((paramAppInterface != null) && (paramAppInterface.length > 0)) {
        i = 0;
      }
      for (;;)
      {
        for (;;)
        {
          if (i < paramAppInterface.length)
          {
            localObject1 = paramAppInterface[i].split("#");
            if ((localObject1 == null) || (localObject1.length != 5)) {
              break label1738;
            }
            int j = Integer.valueOf(localObject1[0]).intValue();
            localObject2 = new VideoEnvironment.SVFileSizeCtrlFactor();
            ((VideoEnvironment.SVFileSizeCtrlFactor)localObject2).time = Integer.valueOf(localObject1[1]).intValue();
            ((VideoEnvironment.SVFileSizeCtrlFactor)localObject2).qmin = Integer.valueOf(localObject1[2]).intValue();
            ((VideoEnvironment.SVFileSizeCtrlFactor)localObject2).qmaxdiff = Integer.valueOf(localObject1[3]).intValue();
            ((VideoEnvironment.SVFileSizeCtrlFactor)localObject2).qmax = Integer.valueOf(localObject1[4]).intValue();
            localShortVideoConfig.sizeFactor.put(j, localObject2);
            break label1738;
          }
          i = paramString.length;
          if (i > 26) {}
          try
          {
            localShortVideoConfig.mTextureScale = Float.parseFloat(paramString[26]);
            if ((localShortVideoConfig.mTextureScale < 0.0F) || (localShortVideoConfig.mTextureScale > 1.0F)) {
              localShortVideoConfig.mTextureScale = 1.0F;
            }
            if (paramString.length <= 27) {
              break;
            }
            localShortVideoConfig.mIsDynamic = getValue(paramString[27], "0").equals("1");
          }
          catch (NumberFormatException paramAppInterface)
          {
            for (;;)
            {
              paramAppInterface.printStackTrace();
            }
          }
        }
        label1700:
        i = 0;
        break label610;
        label1705:
        return;
        label1706:
        i = 1;
        break label610;
        label1711:
        i += 1;
        break label828;
        label1718:
        i = 0;
        break label1087;
        label1723:
        i = 0;
        break label1109;
        label1728:
        i = 0;
        break label1131;
        paramBoolean = true;
        break label1362;
        label1738:
        i += 1;
      }
      label1745:
      paramBoolean = false;
    }
  }
  
  public static void initPtvEncodeQualityParam()
  {
    CodecParam.mMaxrate = 450000;
    CodecParam.mMinrate = 100000;
    CodecParam.mQmax = 38;
    CodecParam.mQmin = 3;
    CodecParam.mMaxQdiff = 5;
  }
  
  public static boolean isBeautySupported()
  {
    if (isX86Platform()) {}
    boolean bool1;
    boolean bool2;
    do
    {
      return false;
      bool1 = lld.d();
      bool2 = getAVCodecSurpportRTBeauty();
      if (QLog.isColorLevel()) {
        QLog.d("VideoEnvironment", 2, "isX86Platform: isBeautySupported=" + bool1 + " isSoSupportBeauty=" + bool2);
      }
    } while ((!bool1) || (!bool2));
    return true;
  }
  
  public static boolean isForceGpuRender()
  {
    if (Build.VERSION.SDK_INT < 14) {
      return false;
    }
    try
    {
      Class localClass = VideoEnvironment.class.getClassLoader().loadClass("android.os.SystemProperties");
      if (localClass == null) {
        break label89;
      }
      Method localMethod = localClass.getMethod("getBoolean", new Class[] { String.class, Boolean.TYPE });
      if (localMethod == null) {
        break label89;
      }
      bool = ((Boolean)localMethod.invoke(localClass, new Object[] { "persist.sys.ui.hw", Boolean.valueOf(false) })).booleanValue();
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        boolean bool = false;
        continue;
        bool = false;
      }
    }
    return bool;
  }
  
  private static boolean isPreservedName(String paramString)
  {
    boolean bool2 = false;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < S_PRESERVED_NAME.length)
      {
        if (paramString.equals(S_PRESERVED_NAME[i])) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  public static boolean isPtvFilterSupported()
  {
    if (isX86Platform()) {}
    while (!getAVCodecSurpportKindSubFeature(6, 0)) {
      return false;
    }
    return true;
  }
  
  public static boolean isShortVideoSoLibLoaded()
  {
    return ShortVideoSoLoad.getShortVideoSoLoadStatus() == 0;
  }
  
  public static boolean isSoNotSupport()
  {
    return sSoNotSupport;
  }
  
  private static boolean isTestEnvSurpportVideoSo()
  {
    String str = Build.CPU_ABI;
    boolean bool1 = VersionUtils.isIceScreamSandwich();
    boolean bool2 = lld.a("neon");
    return (bool1) && (str != null) && (!"".equals(str)) && ("armeabi-v7a".equalsIgnoreCase(str)) && (bool2);
  }
  
  public static boolean isX86Platform()
  {
    String str1 = Build.CPU_ABI;
    String str2 = Build.CPU_ABI2;
    if (QLog.isColorLevel()) {
      QLog.d("VideoEnvironment", 2, "isX86Platform: Build.CPU_ABI=" + str1 + " Build.CPU_ABI2=" + str2);
    }
    if ((str1 != null) && (!"".equals(str1)) && ("x86".equalsIgnoreCase(str1))) {}
    do
    {
      return true;
      if (lld.f() != 7) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("VideoEnvironment", 2, "isX86Platform: VcSystemInfo.getCpuArchitecture()=x86");
    return true;
    return false;
  }
  
  private static int judgeCurrentSpVideoNameValidate(String[] paramArrayOfString)
  {
    String str = bbrm.a();
    LogDownLoad("LoadPathso: currentSoName=" + str, null);
    if (str.equals("d000_1")) {
      return -11;
    }
    Object localObject = bbrm.a(str);
    int i = ((bbrn)localObject).a();
    LogDownLoad("LoadPathso: CfgParser err=" + i, null);
    if (i == 0)
    {
      localObject = ((bbrn)localObject).b();
      LogDownLoad("LoadPathso: currentVersion=" + (String)localObject + " dymAVCodecVersion=" + 65, null);
      if (Integer.parseInt((String)localObject) >= 65)
      {
        paramArrayOfString[0] = str;
        return 255;
      }
      return -13;
    }
    return -12;
  }
  
  private static int loadAVCodecPreDownload()
  {
    int j = ShortVideoSoLoad.getShortVideoSoLoadStatus();
    Object localObject1 = mLockLoadStatus;
    int i = j;
    if (j != 0) {}
    try
    {
      LogDownLoad("loadAVCodecPreDownload[realDoLoadSo begin] loadcode=" + j, null);
      i = realDoLoadSo();
      LogDownLoad("loadAVCodecPreDownload[realDoLoadSo end]loadcode=" + i, null);
      LogDownLoad("loadAVCodecPreDownload[After realDoLoadSo]...", null);
      PrintPreDownloadInfo("loadAVCodecPreDownload[loadcode=" + i + "]");
      LogDownLoad("loadAVCodecPreDownload[End all] loadcode=" + i, null);
      return i;
    }
    finally {}
  }
  
  /* Error */
  public static int loadAVCodecSo(String arg0, Context paramContext)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: invokestatic 789	com/tencent/video/decode/ShortVideoSoLoad:getShortVideoSoLoadStatus	()I
    //   6: istore_2
    //   7: iload_2
    //   8: ifne +32 -> 40
    //   11: new 129	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 131	java/lang/StringBuilder:<init>	()V
    //   18: ldc_w 1163
    //   21: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: iload_2
    //   25: invokevirtual 271	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   28: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   31: aconst_null
    //   32: invokestatic 182	com/tencent/mobileqq/shortvideo/VideoEnvironment:LogDownLoad	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   35: ldc 2
    //   37: monitorexit
    //   38: iload_2
    //   39: ireturn
    //   40: getstatic 193	com/tencent/mobileqq/shortvideo/VideoEnvironment:mLockLoadStatus	Ljava/lang/Object;
    //   43: astore_0
    //   44: aload_0
    //   45: monitorenter
    //   46: invokestatic 1151	com/tencent/mobileqq/shortvideo/VideoEnvironment:realDoLoadSo	()I
    //   49: istore_2
    //   50: new 129	java/lang/StringBuilder
    //   53: dup
    //   54: invokespecial 131	java/lang/StringBuilder:<init>	()V
    //   57: ldc_w 1165
    //   60: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: iload_2
    //   64: invokevirtual 271	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   67: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   70: aconst_null
    //   71: invokestatic 182	com/tencent/mobileqq/shortvideo/VideoEnvironment:LogDownLoad	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   74: aload_0
    //   75: monitorexit
    //   76: goto -41 -> 35
    //   79: astore_1
    //   80: aload_0
    //   81: monitorexit
    //   82: aload_1
    //   83: athrow
    //   84: astore_0
    //   85: ldc 2
    //   87: monitorexit
    //   88: aload_0
    //   89: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	90	1	paramContext	Context
    //   6	58	2	i	int
    // Exception table:
    //   from	to	target	type
    //   46	76	79	finally
    //   80	82	79	finally
    //   3	7	84	finally
    //   11	35	84	finally
    //   40	46	84	finally
    //   82	84	84	finally
  }
  
  public static int loadAVCodecSoNotify(String paramString, Context paramContext, boolean paramBoolean)
  {
    return loadAVCodecSo(paramString, paramContext);
  }
  
  private static void loadSdcardTestSoLib()
  {
    Object localObject1 = ShortVideoSoLoad.getShortVideoSoPath(getContext());
    String str = getCopySdcardSoNameHookTestEnv();
    Object localObject2 = (String)localObject1 + str;
    localObject1 = new File(Environment.getExternalStorageDirectory() + "/pc/libAVCodec.so");
    localObject2 = new File((String)localObject2);
    boolean bool = ((File)localObject1).exists();
    LogDownLoad("loadSdcardTestSoLib:srcExists=" + bool, null);
    if (bool)
    {
      bool = copySoToFilesDir((File)localObject1, (File)localObject2);
      LogDownLoad("loadSdcardTestSoLib[copySoToFilesDir]: success=" + bool, null);
      if (bool)
      {
        bbrm.a(str);
        LogDownLoad("loadSdcardTestSoLib[storeSoNewVersion]: success", null);
      }
    }
  }
  
  public static int loadTestEnvSolib(String paramString)
  {
    try
    {
      boolean bool = isTestEnvSurpportVideoSo();
      if (bool)
      {
        System.loadLibrary(paramString);
        return 0;
      }
      LogDownLoad("loadTestEnvSolib:isTestEnvSurpportVideoSo=" + bool, null);
      return -4;
    }
    catch (Throwable paramString)
    {
      paramString.printStackTrace();
      LogDownLoad("loadTestEnvSolib:loaderr e=", paramString);
    }
    return -3;
  }
  
  public static boolean needDownloadCurrentServerVersion(int paramInt)
  {
    if (paramInt > 65) {}
    while (paramInt == 65) {
      return true;
    }
    return false;
  }
  
  private static boolean nonsupportPtvRecordBlack()
  {
    return bbub.a(bbub.n);
  }
  
  private static int realDoLoadSo()
  {
    String str = ShortVideoSoLoad.getShortVideoSoPath(getContext());
    String[] arrayOfString = new String[1];
    int i = judgeCurrentSpVideoNameValidate(arrayOfString);
    if (i == 255)
    {
      str = str + arrayOfString[0];
      LogDownLoad("Before LoadPath so. loadSoPath=" + str + "  soNameValue[0]=" + arrayOfString[0], null);
      i = ShortVideoSoLoad.LoadExtractedShortVideo(str);
      LogDownLoad("After LoadPath so. errCode=" + i, null);
      return i;
    }
    PrintPreDownloadInfo("realDoLoadSo[errcode=" + i + "]");
    return i;
  }
  
  public static void resetShortVideoSoLibLoadStatus()
  {
    ShortVideoSoLoad.setShortVideoSoLoadStatus(-4);
  }
  
  private static boolean saveAVCodecSoNameWithRollBack(String paramString1, String paramString2)
  {
    boolean bool2 = false;
    boolean bool3 = bbrm.a(paramString2);
    LogDownLoad(paramString1 + " saveSuccess=" + bool3, null);
    boolean bool1 = bool2;
    if (!bool3)
    {
      bool3 = bbrm.a(paramString2);
      LogDownLoad(paramString1 + " saveSuccessTwo=" + bool3, null);
      bool1 = bool2;
      if (!bool3)
      {
        bool1 = true;
        bool2 = bbrm.a("d000_1");
        LogDownLoad("VideoEnvironment", paramString1 + "clearMemoryOK=" + bool2 + ",signature=" + paramString2, null);
      }
    }
    return bool1;
  }
  
  public static void setMaxTimeParam(int paramInt)
  {
    Object localObject1;
    if (SV_FONFIG_STATUS != -1)
    {
      localObject1 = lockConfig;
      if (paramInt > 0) {}
      for (;;)
      {
        try
        {
          CodecParam.RECORD_MAX_TIME = paramInt * 1000;
          configParam.mMaxTime = paramInt;
          SV_FONFIG_STATUS |= 0x4;
          return;
        }
        finally {}
        configParam.mMaxTime = 8;
        CodecParam.RECORD_MAX_TIME = configParam.mMaxTime * 1000;
      }
    }
  }
  
  public static void setSoNotSupport()
  {
    sSoNotSupport = true;
  }
  
  public static boolean supportPtvRecord(AppInterface paramAppInterface)
  {
    return (VersionUtils.isIceScreamSandwich()) && (supportShortVideoRecordAndPlay(paramAppInterface)) && (!nonsupportPtvRecordBlack());
  }
  
  public static boolean supportShortVideoDownloadSo(AppInterface paramAppInterface)
  {
    return supportShortVideoRecordAndPlay(paramAppInterface);
  }
  
  public static boolean supportShortVideoRecord(AppInterface paramAppInterface)
  {
    return (VersionUtils.isIceScreamSandwich()) && (supportShortVideoRecordAndPlay(paramAppInterface));
  }
  
  /* Error */
  public static boolean supportShortVideoRecordAndPlay(AppInterface arg0)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 5
    //   3: iconst_0
    //   4: istore 6
    //   6: getstatic 1238	com/tencent/mobileqq/shortvideo/ShortVideoUtils:sSupportDownloadSo	Z
    //   9: ifne +11 -> 20
    //   12: getstatic 1238	com/tencent/mobileqq/shortvideo/ShortVideoUtils:sSupportDownloadSo	Z
    //   15: istore 4
    //   17: iload 4
    //   19: ireturn
    //   20: invokestatic 254	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   23: ifeq +43 -> 66
    //   26: ldc 80
    //   28: iconst_2
    //   29: new 129	java/lang/StringBuilder
    //   32: dup
    //   33: invokespecial 131	java/lang/StringBuilder:<init>	()V
    //   36: ldc_w 1240
    //   39: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: getstatic 1059	android/os/Build$VERSION:SDK_INT	I
    //   45: invokevirtual 271	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   48: ldc_w 1242
    //   51: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: getstatic 568	android/os/Build:MODEL	Ljava/lang/String;
    //   57: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   63: invokestatic 477	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   66: iload 6
    //   68: istore 4
    //   70: getstatic 1059	android/os/Build$VERSION:SDK_INT	I
    //   73: bipush 10
    //   75: if_icmplt -58 -> 17
    //   78: getstatic 206	com/tencent/mobileqq/shortvideo/VideoEnvironment:SV_FONFIG_STATUS	I
    //   81: iconst_m1
    //   82: if_icmpne +86 -> 168
    //   85: aload_0
    //   86: aconst_null
    //   87: iconst_0
    //   88: invokestatic 1244	com/tencent/mobileqq/shortvideo/VideoEnvironment:initConfig	(Lcom/tencent/common/app/AppInterface;Ljava/lang/String;Z)V
    //   91: invokestatic 254	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   94: ifeq +74 -> 168
    //   97: ldc 80
    //   99: iconst_2
    //   100: ldc_w 1246
    //   103: invokestatic 477	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   106: ldc 80
    //   108: iconst_2
    //   109: new 129	java/lang/StringBuilder
    //   112: dup
    //   113: invokespecial 131	java/lang/StringBuilder:<init>	()V
    //   116: ldc_w 1248
    //   119: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: getstatic 211	com/tencent/mobileqq/shortvideo/VideoEnvironment:configParam	Lcom/tencent/mobileqq/shortvideo/VideoEnvironment$ShortVideoConfig;
    //   125: getfield 973	com/tencent/mobileqq/shortvideo/VideoEnvironment$ShortVideoConfig:mMemory	I
    //   128: invokevirtual 271	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   131: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   134: invokestatic 477	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   137: ldc 80
    //   139: iconst_2
    //   140: new 129	java/lang/StringBuilder
    //   143: dup
    //   144: invokespecial 131	java/lang/StringBuilder:<init>	()V
    //   147: ldc_w 1250
    //   150: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: getstatic 211	com/tencent/mobileqq/shortvideo/VideoEnvironment:configParam	Lcom/tencent/mobileqq/shortvideo/VideoEnvironment$ShortVideoConfig;
    //   156: getfield 976	com/tencent/mobileqq/shortvideo/VideoEnvironment$ShortVideoConfig:mCpu	I
    //   159: invokevirtual 271	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   162: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   165: invokestatic 477	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   168: getstatic 213	com/tencent/mobileqq/shortvideo/VideoEnvironment:lockConfig	Ljava/lang/Object;
    //   171: astore_0
    //   172: aload_0
    //   173: monitorenter
    //   174: getstatic 211	com/tencent/mobileqq/shortvideo/VideoEnvironment:configParam	Lcom/tencent/mobileqq/shortvideo/VideoEnvironment$ShortVideoConfig;
    //   177: getfield 979	com/tencent/mobileqq/shortvideo/VideoEnvironment$ShortVideoConfig:mIsArmv7a	I
    //   180: istore_1
    //   181: getstatic 211	com/tencent/mobileqq/shortvideo/VideoEnvironment:configParam	Lcom/tencent/mobileqq/shortvideo/VideoEnvironment$ShortVideoConfig;
    //   184: getfield 973	com/tencent/mobileqq/shortvideo/VideoEnvironment$ShortVideoConfig:mMemory	I
    //   187: istore_2
    //   188: getstatic 211	com/tencent/mobileqq/shortvideo/VideoEnvironment:configParam	Lcom/tencent/mobileqq/shortvideo/VideoEnvironment$ShortVideoConfig;
    //   191: getfield 976	com/tencent/mobileqq/shortvideo/VideoEnvironment$ShortVideoConfig:mCpu	I
    //   194: istore_3
    //   195: getstatic 211	com/tencent/mobileqq/shortvideo/VideoEnvironment:configParam	Lcom/tencent/mobileqq/shortvideo/VideoEnvironment$ShortVideoConfig;
    //   198: getfield 1013	com/tencent/mobileqq/shortvideo/VideoEnvironment$ShortVideoConfig:mIsBlackList	Z
    //   201: istore 7
    //   203: aload_0
    //   204: monitorexit
    //   205: invokestatic 254	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   208: ifeq +92 -> 300
    //   211: ldc 80
    //   213: iconst_2
    //   214: new 129	java/lang/StringBuilder
    //   217: dup
    //   218: invokespecial 131	java/lang/StringBuilder:<init>	()V
    //   221: ldc_w 1252
    //   224: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   227: iload_1
    //   228: invokevirtual 271	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   231: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   234: invokestatic 477	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   237: ldc 80
    //   239: iconst_2
    //   240: new 129	java/lang/StringBuilder
    //   243: dup
    //   244: invokespecial 131	java/lang/StringBuilder:<init>	()V
    //   247: ldc_w 1254
    //   250: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   253: iload_2
    //   254: invokevirtual 271	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   257: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   260: invokestatic 477	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   263: ldc 80
    //   265: iconst_2
    //   266: new 129	java/lang/StringBuilder
    //   269: dup
    //   270: invokespecial 131	java/lang/StringBuilder:<init>	()V
    //   273: ldc_w 1256
    //   276: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   279: iload_3
    //   280: invokevirtual 271	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   283: ldc_w 1258
    //   286: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   289: iload 7
    //   291: invokevirtual 292	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   294: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   297: invokestatic 477	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   300: iload 7
    //   302: ifeq +68 -> 370
    //   305: iload 6
    //   307: istore 4
    //   309: invokestatic 254	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   312: ifeq -295 -> 17
    //   315: ldc 80
    //   317: iconst_2
    //   318: new 129	java/lang/StringBuilder
    //   321: dup
    //   322: invokespecial 131	java/lang/StringBuilder:<init>	()V
    //   325: ldc_w 1260
    //   328: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   331: iload 7
    //   333: invokevirtual 292	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   336: ldc_w 1242
    //   339: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   342: getstatic 568	android/os/Build:MODEL	Ljava/lang/String;
    //   345: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   348: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   351: invokestatic 477	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   354: iconst_0
    //   355: ireturn
    //   356: astore_0
    //   357: aload_0
    //   358: invokevirtual 1195	java/lang/Throwable:printStackTrace	()V
    //   361: iconst_0
    //   362: ireturn
    //   363: astore 8
    //   365: aload_0
    //   366: monitorexit
    //   367: aload 8
    //   369: athrow
    //   370: getstatic 1108	android/os/Build:CPU_ABI	Ljava/lang/String;
    //   373: astore_0
    //   374: invokestatic 254	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   377: ifeq +29 -> 406
    //   380: ldc 80
    //   382: iconst_2
    //   383: new 129	java/lang/StringBuilder
    //   386: dup
    //   387: invokespecial 131	java/lang/StringBuilder:<init>	()V
    //   390: ldc_w 1262
    //   393: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   396: aload_0
    //   397: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   400: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   403: invokestatic 477	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   406: invokestatic 1041	com/tencent/mobileqq/shortvideo/VideoEnvironment:isX86Platform	()Z
    //   409: ifeq +48 -> 457
    //   412: getstatic 1264	com/tencent/mobileqq/shortvideo/VideoEnvironment:SV_SUPPORT_LOAD_X86_SO	Z
    //   415: istore 5
    //   417: iload 5
    //   419: istore 4
    //   421: invokestatic 254	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   424: ifeq -407 -> 17
    //   427: ldc 80
    //   429: iconst_2
    //   430: new 129	java/lang/StringBuilder
    //   433: dup
    //   434: invokespecial 131	java/lang/StringBuilder:<init>	()V
    //   437: ldc_w 1266
    //   440: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   443: iload 5
    //   445: invokevirtual 292	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   448: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   451: invokestatic 477	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   454: iload 5
    //   456: ireturn
    //   457: iload_1
    //   458: iconst_1
    //   459: if_icmpne +76 -> 535
    //   462: aload_0
    //   463: ifnull +115 -> 578
    //   466: ldc 100
    //   468: aload_0
    //   469: invokevirtual 664	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   472: ifne +106 -> 578
    //   475: ldc_w 1118
    //   478: aload_0
    //   479: invokevirtual 580	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   482: ifeq +96 -> 578
    //   485: iload 5
    //   487: istore 4
    //   489: invokestatic 254	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   492: ifeq +40 -> 532
    //   495: ldc 80
    //   497: iconst_2
    //   498: new 129	java/lang/StringBuilder
    //   501: dup
    //   502: invokespecial 131	java/lang/StringBuilder:<init>	()V
    //   505: ldc_w 1268
    //   508: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   511: aload_0
    //   512: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   515: ldc_w 1270
    //   518: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   521: iload 4
    //   523: invokevirtual 292	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   526: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   529: invokestatic 477	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   532: iload 4
    //   534: ireturn
    //   535: iload 5
    //   537: istore 4
    //   539: invokestatic 254	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   542: ifeq -53 -> 489
    //   545: ldc 80
    //   547: iconst_2
    //   548: new 129	java/lang/StringBuilder
    //   551: dup
    //   552: invokespecial 131	java/lang/StringBuilder:<init>	()V
    //   555: ldc_w 1272
    //   558: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   561: iconst_1
    //   562: invokevirtual 292	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   565: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   568: invokestatic 477	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   571: iload 5
    //   573: istore 4
    //   575: goto -86 -> 489
    //   578: iconst_0
    //   579: istore 4
    //   581: goto -92 -> 489
    // Local variable table:
    //   start	length	slot	name	signature
    //   180	280	1	i	int
    //   187	67	2	j	int
    //   194	86	3	k	int
    //   15	565	4	bool1	boolean
    //   1	571	5	bool2	boolean
    //   4	302	6	bool3	boolean
    //   201	131	7	bool4	boolean
    //   363	5	8	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   85	91	356	java/lang/Throwable
    //   174	205	363	finally
    //   365	367	363	finally
  }
  
  public static boolean supportSubmitCallback()
  {
    int i = getAVCodecVersion();
    boolean bool = getAVCodecSurpportFeature(2);
    if (QLog.isColorLevel()) {
      QLog.d("VideoEnvironment", 2, "supportSubmitCallback: soVersion =" + i + ", result = " + bool);
    }
    return bool;
  }
  
  public static boolean uncompressZipSo(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    boolean bool2 = false;
    String str1 = ShortVideoSoLoad.getShortVideoSoPath(getContext());
    Object localObject2 = str1 + SO_SECURITY_DIR;
    LogDownLoad("VideoEnvironment:[uncompressZipSo]destDir=" + (String)localObject2, null);
    File localFile;
    boolean bool1;
    for (;;)
    {
      try
      {
        synchronized (mLockunzip)
        {
          localFile = new File((String)localObject2);
          if (!localFile.exists())
          {
            localFile.mkdirs();
            paramQQAppInterface = (String)localObject2 + getUnzipTempLibActualName("AVCodec");
            localFile = new File(paramQQAppInterface);
            if (localFile.exists())
            {
              LogDownLoad("VideoEnvironment:[uncompressZipSo][has back file] path=" + paramQQAppInterface, null);
              localFile.delete();
            }
            FileUtils.uncompressZip(paramString, (String)localObject2, false);
            bool1 = localFile.exists();
            LogDownLoad("VideoEnvironment:[end uncompressZipSo] existsFile=" + bool1, null);
            if (bool1) {
              break;
            }
            throw new RuntimeException("After uncompressZip,AVCodec file not exist...");
          }
        }
        bool1 = checkUncompressedResourceIsOK(paramQQAppInterface, (String)localObject2, paramInt);
      }
      catch (Exception paramQQAppInterface)
      {
        paramQQAppInterface.printStackTrace();
        LogDownLoad("VideoEnvironment:exp=", paramQQAppInterface);
        return true;
      }
      LogDownLoad("VideoEnvironment:[checkUncompressedResourceIsOK] checkOK=" + bool1, null);
      if (bool1) {
        return false;
      }
    }
    paramString = new File((String)localObject2 + "config_version");
    if (!paramString.exists()) {
      throw new RuntimeException("After uncompressZip,config_version file not exist...");
    }
    localObject2 = bbrm.a(bbrm.a(paramString));
    paramInt = ((bbrn)localObject2).a();
    if (paramInt != 0)
    {
      LogDownLoad("VideoEnvironment:[uncompressZipSo][createParser] errorCodec=" + paramInt, null);
      throw new RuntimeException("createParser err=" + paramInt);
    }
    Object localObject3 = bbrm.a(paramQQAppInterface);
    paramString = ((bbrn)localObject2).a();
    LogDownLoad("VideoEnvironment:[uncompressZipSo][Md5] md5Cfg=" + paramString + " md5Cmp=" + (String)localObject3, null);
    if (!paramString.equalsIgnoreCase((String)localObject3)) {
      throw new RuntimeException("[Md5 error] md5Cfg=" + paramString + " md5Cmp=" + (String)localObject3);
    }
    long l1 = localFile.length();
    localObject3 = ((bbrn)localObject2).b().trim();
    localObject2 = bbrm.a(paramString, (String)localObject3);
    LogDownLoad("VideoEnvironment:[uncompressZipSo][trim] versionvalid=" + (String)localObject3 + " soNewName=" + (String)localObject2, null);
    str1 = str1 + (String)localObject2;
    localObject3 = new File(str1);
    paramInt = 0;
    long l2;
    String str2;
    if (((File)localObject3).exists())
    {
      l2 = ((File)localObject3).length();
      str2 = bbrm.a(str1);
      if (!paramString.equalsIgnoreCase(str2))
      {
        bool1 = true;
        LogDownLoad("VideoEnvironment:[uncompressZipSo] md5NoEqualsAlready=" + bool1 + " fileSize=" + l2 + " alreadySoMd5=" + str2, null);
        if (bool1)
        {
          ((File)localObject3).delete();
          paramInt = 1;
          bool1 = bool2;
        }
      }
    }
    for (;;)
    {
      if (paramInt != 0)
      {
        if (!localFile.renameTo((File)localObject3))
        {
          throw new RuntimeException("[renameTo error] destFilePath=" + paramQQAppInterface + "  loadFilePath=" + str1);
          LogDownLoad("VideoEnvironment:[uncompressZipSo] Restore SP md5NoEqualsAlready=" + bool1 + " fileSize=" + l2 + " alreadySoMd5=" + str2 + ",md5Cfg=" + paramString, null);
          bool1 = saveAVCodecSoNameWithRollBack("VideoEnvironment:[uncompressZipSo Restore SP ]storeSoNewVersion", (String)localObject2);
          break label915;
        }
        l2 = ((File)localObject3).length();
        if (l1 == l2)
        {
          LogDownLoad("VideoEnvironment:[uncompressZipSo success]storeSoNewVersion loadLength=" + l2 + "  soNewName=" + (String)localObject2, null);
          bool1 = saveAVCodecSoNameWithRollBack("VideoEnvironment:[uncompressZipSo success]storeSoNewVersion", (String)localObject2);
        }
      }
      else
      {
        copyPieAndPicFile();
        executeClearHistorySOLibFile();
        return bool1;
      }
      throw new RuntimeException("[length error] destLength=" + l1 + " loadLength=" + l2);
      label915:
      continue;
      bool1 = false;
      break;
      bool1 = false;
      paramInt = 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.VideoEnvironment
 * JD-Core Version:    0.7.0.1
 */