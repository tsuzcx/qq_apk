package com.tencent.thumbplayer.core.common;

import android.content.Context;
import android.media.MediaCodecInfo;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaCodecInfo.CodecProfileLevel;
import android.media.MediaCodecInfo.VideoCapabilities;
import android.media.MediaCodecList;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.Range;
import com.tencent.thumbplayer.core.thirdparties.LocalCache;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;

public class TPCodecUtils
{
  public static final int CAP_AUDIO_AAC = 4;
  public static final int CAP_AUDIO_DDP = 8;
  public static final int CAP_VIDEO_AVC = 1;
  public static final int CAP_VIDEO_HEVC = 2;
  public static final int PLAYER_LEVEL_1 = 1;
  public static final int PLAYER_LEVEL_11 = 11;
  public static final int PLAYER_LEVEL_16 = 16;
  public static final int PLAYER_LEVEL_21 = 21;
  public static final int PLAYER_LEVEL_26 = 26;
  public static final int PLAYER_LEVEL_28 = 28;
  public static final int PLAYER_LEVEL_33 = 33;
  public static final int PLAYER_LEVEL_6 = 6;
  private static final String TAG = "TPCodecUtils";
  private static TPCodecCapability.TPVCodecMaxCapability mAVCMediaCodecMaxCapability;
  private static TPCodecCapability.TPVCodecMaxCapability mAVCSWMaxCapability;
  private static TPCodecCapability.TPVCodecMaxCapability mAVS3WMaxCapability = new TPCodecCapability.TPVCodecMaxCapability(0, 0, 0, 30);
  private static Context mApplicationContext;
  private static int mAvs3DeviceLevel;
  private static String mCapabilityVersion;
  private static String mCapabilityVersionKey;
  private static HashMap<String, Integer> mCodecCap;
  private static int mFhdAvs3HisiIndex;
  private static int mFhdAvs3QualcommIndex;
  private static String mHDR10CapabilityKey;
  private static String mHDR10PLUSCapabilityKey;
  private static String mHDRDOLBYVISIONCapabilityKey;
  private static String mHDRHLGCapabilityKey;
  private static TPCodecCapability.TPVCodecMaxCapability mHEVCMediaCodecMaxCapability;
  private static TPCodecCapability.TPVCodecMaxCapability mHEVCSWMaxCapability;
  protected static ArrayList<String> mHWCodecCapList;
  private static String mHWCodecCapListKey;
  private static int mHdHevcHisiIndex;
  private static int mHdHevcMtkIndex;
  private static int mHdHevcQualcommIndex;
  private static int mHdHevcSumsingIndex;
  private static int mHevcDeviceLevel = -1;
  private static boolean mIsFFmpegCapGot;
  private static int mIsInBlackListForHardwareDec;
  private static boolean mIsInitDone;
  private static boolean mIsLocalCacheEnabled;
  private static boolean mIsMediaCodecCapGot;
  private static HashMap<Integer, TPCodecCapability.TPVCodecMaxCapability> mMaxVCodecHwCapabilityMap = new HashMap();
  private static String mMaxVCodecHwCapabilityMapKey;
  private static HashMap<Integer, TPCodecCapability.TPVCodecMaxCapability> mMaxVCodecSwCapabilityMap = new HashMap();
  private static String mMaxVCodecSwCapabilityMapKey;
  private static boolean mNeedToReprobeDecoderCapability;
  private static boolean mNeedToReprobeHDRCapability;
  private static int mShdAvs3QualcommIndex;
  private static int mShdHevcHisiIndex;
  private static int mShdHevcMtkIndex;
  private static int mShdHevcQualcommIndex;
  private static int mShdHevcSumsingIndex;
  protected static ArrayList<String> mSoftCodecCapList;
  private static String mSoftCodecCapListKey;
  private static String mSupportValue;
  private static String mUnsupportValue;
  private static TPCodecCapability.TPVCodecMaxCapability mVP9MediaCodecMaxCapability;
  private static TPCodecCapability.TPVCodecMaxCapability mVP9SWMaxCapability;
  protected static ArrayList<String> mffmpegVCodecCapList;
  private static String mffmpegVCodecCapListKey;
  private static int sDolbyLevel;
  private static boolean sIsDDPInit;
  private static boolean sIsDDPSup;
  private static boolean sIsDDSInit;
  private static boolean sIsDDSSup;
  
  static
  {
    mAvs3DeviceLevel = -1;
    mCodecCap = null;
    mApplicationContext = null;
    mIsLocalCacheEnabled = false;
    mNeedToReprobeDecoderCapability = true;
    mNeedToReprobeHDRCapability = true;
    mCapabilityVersion = "2.10.0.1086.full";
    mHWCodecCapList = new ArrayList();
    mSoftCodecCapList = new ArrayList();
    mffmpegVCodecCapList = new ArrayList();
    mIsInitDone = false;
    mIsInBlackListForHardwareDec = -1;
    sIsDDPInit = false;
    sIsDDPSup = false;
    sIsDDSInit = false;
    sIsDDSSup = false;
    sDolbyLevel = -1;
    mCapabilityVersionKey = "Capability_version_Key";
    mHWCodecCapListKey = "HW_list_Key";
    mSoftCodecCapListKey = "Soft_list_Key";
    mffmpegVCodecCapListKey = "FFmpeg_list_Key";
    mMaxVCodecHwCapabilityMapKey = "HW_CapMap_key";
    mMaxVCodecSwCapabilityMapKey = "SW_CapMap_key";
    mHDR10CapabilityKey = "HDR10_cap_Key";
    mHDR10PLUSCapabilityKey = "HDR10PLUS_cap_Key";
    mHDRDOLBYVISIONCapabilityKey = "HDRDOLBYVISION_cap_Key";
    mHDRHLGCapabilityKey = "HDRHLG_cap_Key";
    mSupportValue = "support";
    mUnsupportValue = "unsupport";
    mShdHevcQualcommIndex = 32;
    mHdHevcQualcommIndex = 20;
    mShdHevcMtkIndex = 12;
    mHdHevcMtkIndex = 8;
    mShdHevcHisiIndex = 8;
    mHdHevcHisiIndex = 3;
    mShdHevcSumsingIndex = 8;
    mHdHevcSumsingIndex = 5;
    mFhdAvs3QualcommIndex = 58;
    mShdAvs3QualcommIndex = 55;
    mFhdAvs3HisiIndex = 14;
    mCodecCap = new HashMap();
    mCodecCap.put("NX511J", Integer.valueOf(7));
    mCodecCap.put("Hi3798MV100", Integer.valueOf(7));
    mCodecCap.put("长虹智能电视", Integer.valueOf(7));
    mCodecCap.put("Android TV on Tcl 901", Integer.valueOf(7));
    mCodecCap.put("xt880b", Integer.valueOf(7));
    TPNativeLog.printLog(2, "TPCodecUtils", "white list init");
    mIsMediaCodecCapGot = false;
    mIsFFmpegCapGot = false;
    mAVCMediaCodecMaxCapability = new TPCodecCapability.TPVCodecMaxCapability(0, 0, 0, 30);
    mHEVCMediaCodecMaxCapability = new TPCodecCapability.TPVCodecMaxCapability(0, 0, 0, 30);
    mVP9MediaCodecMaxCapability = new TPCodecCapability.TPVCodecMaxCapability(0, 0, 0, 30);
    mAVCSWMaxCapability = new TPCodecCapability.TPVCodecMaxCapability(0, 0, 0, 30);
    mHEVCSWMaxCapability = new TPCodecCapability.TPVCodecMaxCapability(0, 0, 0, 30);
    mVP9SWMaxCapability = new TPCodecCapability.TPVCodecMaxCapability(0, 0, 0, 30);
  }
  
  private static void cacheCapList(String paramString, ArrayList<String> paramArrayList)
  {
    if (mApplicationContext != null) {}
    try
    {
      LocalCache localLocalCache = LocalCache.get(mApplicationContext);
      if (localLocalCache != null) {
        localLocalCache.put(paramString, paramArrayList);
      }
      return;
    }
    catch (Throwable paramArrayList)
    {
      TPNativeLog.printLog(4, "TPCodecUtils", "cache " + paramString + "failed");
    }
  }
  
  private static void cacheCapabilityMap(String paramString, HashMap<Integer, TPCodecCapability.TPVCodecMaxCapability> paramHashMap)
  {
    if (mApplicationContext != null) {}
    try
    {
      LocalCache localLocalCache = LocalCache.get(mApplicationContext);
      if (localLocalCache != null) {
        localLocalCache.put(paramString, paramHashMap);
      }
      return;
    }
    catch (Throwable paramHashMap)
    {
      TPNativeLog.printLog(4, "TPCodecUtils", "cache " + paramString + "failed");
    }
  }
  
  private static void cacheStringInfo(String paramString1, String paramString2)
  {
    if (mApplicationContext != null) {}
    try
    {
      LocalCache localLocalCache = LocalCache.get(mApplicationContext);
      if (localLocalCache != null) {
        localLocalCache.put(paramString1, paramString2);
      }
      return;
    }
    catch (Throwable paramString2)
    {
      TPNativeLog.printLog(4, "TPCodecUtils", "cache " + paramString1 + "failed");
    }
  }
  
  public static boolean getAudioMediaCodecPassThroughCap(int paramInt1, int paramInt2, int paramInt3)
  {
    int j = 1;
    if (paramInt1 != 5004) {
      return false;
    }
    int i;
    if (paramInt1 == 5004) {
      if (paramInt2 == 20) {
        i = 7;
      }
    }
    for (;;)
    {
      return TPAudioPassThroughPluginDetector.isAudioPassThroughSupport(i, paramInt3);
      i = j;
      if (paramInt2 == 20)
      {
        i = 8;
        continue;
        i = j;
        if (paramInt1 == 5002) {
          if (paramInt2 == 1)
          {
            i = 10;
          }
          else if (paramInt2 == 4)
          {
            i = 11;
          }
          else
          {
            i = j;
            if (paramInt2 == 28) {
              i = 12;
            }
          }
        }
      }
    }
  }
  
  public static int getAvs3SWDecodeLevel()
  {
    String str = TPSystemInfo.getCpuHarewareName();
    int i = TPSystemInfo.getCpuHWProducter(str);
    int j = TPSystemInfo.getCpuHWProductIndex(str);
    TPNativeLog.printLog(2, "TPCodecUtils", "[getAvs3SWDecodeLevel], mCpuHWProducter = " + i + ", getMaxCpuFreq() = " + TPSystemInfo.getMaxCpuFreq() + ", numCores = " + TPSystemInfo.getNumCores() + ", mCpuHWProductIdx=" + j + ", hardware=" + str);
    if (-1 != mAvs3DeviceLevel) {
      return mAvs3DeviceLevel;
    }
    mAvs3DeviceLevel = 0;
    if (-1 == i) {
      mAvs3DeviceLevel = getDecodeLevelByCoresAndFreq();
    }
    for (;;)
    {
      return mAvs3DeviceLevel;
      switch (i)
      {
      default: 
        break;
      case 0: 
        if (j >= mFhdAvs3QualcommIndex) {
          mAvs3DeviceLevel = 26;
        } else if (j >= mShdAvs3QualcommIndex) {
          mAvs3DeviceLevel = 21;
        } else {
          mAvs3DeviceLevel = getDecodeLevelByCoresAndFreq();
        }
        break;
      case 1: 
        mAvs3DeviceLevel = getDecodeLevelByCoresAndFreq();
        break;
      case 2: 
        if (j >= mFhdAvs3HisiIndex) {
          mAvs3DeviceLevel = 26;
        } else {
          mAvs3DeviceLevel = getDecodeLevelByCoresAndFreq();
        }
        break;
      case 3: 
        mAvs3DeviceLevel = getDecodeLevelByCoresAndFreq();
      }
    }
  }
  
  private static ArrayList<String> getCachedCapList(String paramString)
  {
    if (mApplicationContext != null) {
      try
      {
        Object localObject = LocalCache.get(mApplicationContext);
        if (localObject != null)
        {
          localObject = (ArrayList)((LocalCache)localObject).getAsObject(paramString);
          return localObject;
        }
      }
      catch (Throwable localThrowable)
      {
        TPNativeLog.printLog(4, "TPCodecUtils", "get " + paramString + "failed");
      }
    }
    return null;
  }
  
  private static HashMap<Integer, TPCodecCapability.TPVCodecMaxCapability> getCachedCapabilityMap(String paramString)
  {
    if (mApplicationContext != null) {
      try
      {
        Object localObject = LocalCache.get(mApplicationContext);
        if (localObject != null)
        {
          localObject = (HashMap)((LocalCache)localObject).getAsObject(paramString);
          return localObject;
        }
      }
      catch (Throwable localThrowable)
      {
        TPNativeLog.printLog(4, "TPCodecUtils", "get " + paramString + "failed");
      }
    }
    return null;
  }
  
  private static String getCachedStringInfo(String paramString)
  {
    if (mApplicationContext != null) {
      try
      {
        Object localObject = LocalCache.get(mApplicationContext);
        if (localObject != null)
        {
          localObject = ((LocalCache)localObject).getAsString(paramString);
          return localObject;
        }
      }
      catch (Throwable localThrowable)
      {
        TPNativeLog.printLog(4, "TPCodecUtils", "get " + paramString + "failed");
      }
    }
    return null;
  }
  
  private static int getDecodeLevelByCoresAndFreq()
  {
    if (TPSystemInfo.getNumCores() >= 8) {
      if (TPSystemInfo.getMaxCpuFreq() / 1000L < 1200L) {}
    }
    do
    {
      do
      {
        return 21;
        return 16;
        if (TPSystemInfo.getNumCores() < 6) {
          break;
        }
      } while (TPSystemInfo.getMaxCpuFreq() / 1000L >= 1400L);
      return 16;
      if (TPSystemInfo.getNumCores() < 4) {
        break;
      }
    } while (TPSystemInfo.getMaxCpuFreq() / 1000L >= 1600L);
    return 16;
    return 6;
  }
  
  /* Error */
  public static void getDecoderMaxCapabilityMapAsync()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 125	com/tencent/thumbplayer/core/common/TPCodecUtils:mIsInitDone	Z
    //   6: ifeq +16 -> 22
    //   9: iconst_2
    //   10: ldc 32
    //   12: ldc_w 383
    //   15: invokestatic 238	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;Ljava/lang/String;)V
    //   18: ldc 2
    //   20: monitorexit
    //   21: return
    //   22: iconst_2
    //   23: ldc 32
    //   25: ldc_w 385
    //   28: invokestatic 238	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;Ljava/lang/String;)V
    //   31: new 387	java/lang/Thread
    //   34: dup
    //   35: new 389	com/tencent/thumbplayer/core/common/TPCodecUtils$1
    //   38: dup
    //   39: invokespecial 390	com/tencent/thumbplayer/core/common/TPCodecUtils$1:<init>	()V
    //   42: invokespecial 393	java/lang/Thread:<init>	(Ljava/lang/Runnable;)V
    //   45: astore_0
    //   46: aload_0
    //   47: ldc_w 395
    //   50: invokevirtual 399	java/lang/Thread:setName	(Ljava/lang/String;)V
    //   53: aload_0
    //   54: invokevirtual 402	java/lang/Thread:start	()V
    //   57: goto -39 -> 18
    //   60: astore_0
    //   61: ldc 2
    //   63: monitorexit
    //   64: aload_0
    //   65: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   45	9	0	localThread	java.lang.Thread
    //   60	5	0	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	18	60	finally
    //   22	57	60	finally
  }
  
  public static int getHevcSWDecodeLevel()
  {
    String str = TPSystemInfo.getCpuHarewareName();
    int i = TPSystemInfo.getCpuHWProducter(str);
    int j = TPSystemInfo.getCpuHWProductIndex(str);
    TPNativeLog.printLog(2, "TPCodecUtils", "[getHevcSWDecodeLevel], mCpuHWProducter = " + i + ", getMaxCpuFreq() = " + TPSystemInfo.getMaxCpuFreq() + ", numCores = " + TPSystemInfo.getNumCores() + ", mCpuHWProductIdx=" + j + ", hardware=" + str);
    if (-1 != mHevcDeviceLevel) {
      return mHevcDeviceLevel;
    }
    mHevcDeviceLevel = 0;
    if (-1 == i) {
      mHevcDeviceLevel = getDecodeLevelByCoresAndFreq();
    }
    for (;;)
    {
      return mHevcDeviceLevel;
      switch (i)
      {
      default: 
        break;
      case 0: 
        if (j >= mShdHevcQualcommIndex) {
          mHevcDeviceLevel = 21;
        } else if (j >= mHdHevcQualcommIndex) {
          mHevcDeviceLevel = 16;
        } else {
          mHevcDeviceLevel = getDecodeLevelByCoresAndFreq();
        }
        break;
      case 1: 
        if (j >= mShdHevcMtkIndex) {
          mHevcDeviceLevel = 21;
        } else if (j >= mHdHevcMtkIndex) {
          mHevcDeviceLevel = 16;
        } else {
          mHevcDeviceLevel = getDecodeLevelByCoresAndFreq();
        }
        break;
      case 2: 
        if (j >= mShdHevcHisiIndex) {
          mHevcDeviceLevel = 21;
        } else if (j >= mHdHevcHisiIndex) {
          mHevcDeviceLevel = 16;
        } else {
          mHevcDeviceLevel = getDecodeLevelByCoresAndFreq();
        }
        break;
      case 3: 
        if (j >= mShdHevcSumsingIndex) {
          mHevcDeviceLevel = 21;
        } else if (j >= mHdHevcSumsingIndex) {
          mHevcDeviceLevel = 16;
        } else {
          mHevcDeviceLevel = getDecodeLevelByCoresAndFreq();
        }
        break;
      }
    }
  }
  
  public static int getHwDolbyLevel()
  {
    if (sDolbyLevel == -1) {
      initDolbyInvariableParams();
    }
    return sDolbyLevel;
  }
  
  public static int getMaxSupportedFrameRatesFor(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (Build.VERSION.SDK_INT < 21) {
      return 30;
    }
    if (paramInt1 == 101) {
      return 30;
    }
    for (;;)
    {
      try
      {
        int j = MediaCodecList.getCodecCount();
        paramInt1 = 0;
        if (paramInt1 < j)
        {
          MediaCodecInfo localMediaCodecInfo = MediaCodecList.getCodecInfoAt(paramInt1);
          if (!localMediaCodecInfo.isEncoder())
          {
            String[] arrayOfString = localMediaCodecInfo.getSupportedTypes();
            int k = arrayOfString.length;
            int i = 0;
            if (i < k)
            {
              Object localObject = arrayOfString[i];
              if (((String)localObject).equalsIgnoreCase("video/hevc"))
              {
                localObject = localMediaCodecInfo.getCapabilitiesForType("video/hevc").getVideoCapabilities().getSupportedFrameRatesFor(paramInt3, paramInt4);
                if (paramInt2 == 172)
                {
                  if (((Double)((Range)localObject).getUpper()).intValue() % 10 == 0) {
                    return ((Double)((Range)localObject).getUpper()).intValue();
                  }
                  return ((Double)((Range)localObject).getUpper()).intValue() + 1;
                }
              }
              else if (((String)localObject).equalsIgnoreCase("video/avc"))
              {
                localObject = localMediaCodecInfo.getCapabilitiesForType("video/avc").getVideoCapabilities().getSupportedFrameRatesFor(paramInt3, paramInt4);
                if (paramInt2 == 26)
                {
                  if (((Double)((Range)localObject).getUpper()).intValue() % 10 == 0) {
                    return ((Double)((Range)localObject).getUpper()).intValue();
                  }
                  paramInt1 = ((Double)((Range)localObject).getUpper()).intValue();
                  return paramInt1 + 1;
                }
              }
              i += 1;
              continue;
            }
          }
        }
        else
        {
          return 30;
        }
      }
      catch (Throwable localThrowable)
      {
        TPNativeLog.printLog(4, "TPCodecUtils", "getSupportedFrameRatesFor func failed:" + localThrowable.toString());
      }
      paramInt1 += 1;
    }
  }
  
  /* Error */
  public static HashMap<Integer, TPCodecCapability.TPVCodecMaxCapability> getMediaCodecMaxCapabilityMap()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: iconst_2
    //   4: ldc 32
    //   6: ldc_w 493
    //   9: invokestatic 238	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;Ljava/lang/String;)V
    //   12: getstatic 240	com/tencent/thumbplayer/core/common/TPCodecUtils:mIsMediaCodecCapGot	Z
    //   15: ifeq +23 -> 38
    //   18: iconst_2
    //   19: ldc 32
    //   21: ldc_w 495
    //   24: invokestatic 238	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;Ljava/lang/String;)V
    //   27: getstatic 263	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMap	Ljava/util/HashMap;
    //   30: astore 12
    //   32: ldc 2
    //   34: monitorexit
    //   35: aload 12
    //   37: areturn
    //   38: getstatic 104	com/tencent/thumbplayer/core/common/TPCodecUtils:mIsLocalCacheEnabled	Z
    //   41: ifeq +168 -> 209
    //   44: getstatic 106	com/tencent/thumbplayer/core/common/TPCodecUtils:mNeedToReprobeDecoderCapability	Z
    //   47: ifne +162 -> 209
    //   50: iconst_2
    //   51: ldc 32
    //   53: ldc_w 497
    //   56: invokestatic 238	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;Ljava/lang/String;)V
    //   59: getstatic 119	com/tencent/thumbplayer/core/common/TPCodecUtils:mHWCodecCapList	Ljava/util/ArrayList;
    //   62: ifnull +12 -> 74
    //   65: getstatic 119	com/tencent/thumbplayer/core/common/TPCodecUtils:mHWCodecCapList	Ljava/util/ArrayList;
    //   68: invokevirtual 500	java/util/ArrayList:size	()I
    //   71: ifne +21 -> 92
    //   74: getstatic 145	com/tencent/thumbplayer/core/common/TPCodecUtils:mHWCodecCapListKey	Ljava/lang/String;
    //   77: invokestatic 502	com/tencent/thumbplayer/core/common/TPCodecUtils:getCachedCapList	(Ljava/lang/String;)Ljava/util/ArrayList;
    //   80: astore 12
    //   82: aload 12
    //   84: ifnull +8 -> 92
    //   87: aload 12
    //   89: putstatic 119	com/tencent/thumbplayer/core/common/TPCodecUtils:mHWCodecCapList	Ljava/util/ArrayList;
    //   92: getstatic 119	com/tencent/thumbplayer/core/common/TPCodecUtils:mHWCodecCapList	Ljava/util/ArrayList;
    //   95: ifnull +114 -> 209
    //   98: getstatic 119	com/tencent/thumbplayer/core/common/TPCodecUtils:mHWCodecCapList	Ljava/util/ArrayList;
    //   101: invokevirtual 500	java/util/ArrayList:size	()I
    //   104: ifle +105 -> 209
    //   107: getstatic 157	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMapKey	Ljava/lang/String;
    //   110: invokestatic 504	com/tencent/thumbplayer/core/common/TPCodecUtils:getCachedCapabilityMap	(Ljava/lang/String;)Ljava/util/HashMap;
    //   113: astore 12
    //   115: aload 12
    //   117: ifnull +92 -> 209
    //   120: aload 12
    //   122: putstatic 263	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMap	Ljava/util/HashMap;
    //   125: getstatic 263	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMap	Ljava/util/HashMap;
    //   128: invokevirtual 505	java/util/HashMap:size	()I
    //   131: ifle +78 -> 209
    //   134: iconst_2
    //   135: ldc 32
    //   137: new 285	java/lang/StringBuilder
    //   140: dup
    //   141: invokespecial 286	java/lang/StringBuilder:<init>	()V
    //   144: ldc_w 507
    //   147: invokevirtual 292	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   150: getstatic 263	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMap	Ljava/util/HashMap;
    //   153: invokevirtual 505	java/util/HashMap:size	()I
    //   156: invokevirtual 334	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   159: invokevirtual 298	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   162: invokestatic 238	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;Ljava/lang/String;)V
    //   165: iconst_1
    //   166: putstatic 240	com/tencent/thumbplayer/core/common/TPCodecUtils:mIsMediaCodecCapGot	Z
    //   169: getstatic 263	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMap	Ljava/util/HashMap;
    //   172: astore 12
    //   174: goto -142 -> 32
    //   177: astore 12
    //   179: iconst_4
    //   180: ldc 32
    //   182: new 285	java/lang/StringBuilder
    //   185: dup
    //   186: invokespecial 286	java/lang/StringBuilder:<init>	()V
    //   189: ldc_w 509
    //   192: invokevirtual 292	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   195: aload 12
    //   197: invokevirtual 512	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   200: invokevirtual 292	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   203: invokevirtual 298	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   206: invokestatic 238	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;Ljava/lang/String;)V
    //   209: iconst_0
    //   210: istore_2
    //   211: iconst_0
    //   212: istore_1
    //   213: iconst_0
    //   214: istore_0
    //   215: ldc_w 514
    //   218: invokestatic 520	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   221: astore 12
    //   223: aload 12
    //   225: ldc_w 521
    //   228: iconst_0
    //   229: anewarray 516	java/lang/Class
    //   232: invokevirtual 525	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   235: astore 20
    //   237: aload 12
    //   239: ldc_w 526
    //   242: iconst_1
    //   243: anewarray 516	java/lang/Class
    //   246: dup
    //   247: iconst_0
    //   248: getstatic 530	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   251: aastore
    //   252: invokevirtual 525	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   255: astore 12
    //   257: ldc_w 532
    //   260: invokestatic 520	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   263: astore 16
    //   265: aload 16
    //   267: ldc_w 533
    //   270: iconst_0
    //   271: anewarray 516	java/lang/Class
    //   274: invokevirtual 525	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   277: astore 13
    //   279: aload 16
    //   281: ldc_w 535
    //   284: iconst_0
    //   285: anewarray 516	java/lang/Class
    //   288: invokevirtual 525	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   291: astore 14
    //   293: aload 16
    //   295: ldc_w 536
    //   298: iconst_0
    //   299: anewarray 516	java/lang/Class
    //   302: invokevirtual 525	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   305: astore 15
    //   307: aload 16
    //   309: ldc_w 537
    //   312: iconst_1
    //   313: anewarray 516	java/lang/Class
    //   316: dup
    //   317: iconst_0
    //   318: ldc_w 439
    //   321: aastore
    //   322: invokevirtual 525	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   325: astore 16
    //   327: ldc_w 539
    //   330: invokestatic 520	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   333: ldc_w 541
    //   336: invokevirtual 545	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   339: astore 17
    //   341: ldc_w 547
    //   344: invokestatic 520	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   347: astore 19
    //   349: aload 19
    //   351: ldc_w 549
    //   354: invokevirtual 545	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   357: astore 18
    //   359: aload 19
    //   361: ldc_w 551
    //   364: invokevirtual 545	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   367: astore 19
    //   369: aload 20
    //   371: aconst_null
    //   372: iconst_0
    //   373: anewarray 4	java/lang/Object
    //   376: invokevirtual 557	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   379: checkcast 214	java/lang/Integer
    //   382: invokevirtual 558	java/lang/Integer:intValue	()I
    //   385: istore 8
    //   387: iconst_2
    //   388: new 285	java/lang/StringBuilder
    //   391: dup
    //   392: invokespecial 286	java/lang/StringBuilder:<init>	()V
    //   395: ldc_w 560
    //   398: invokevirtual 292	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   401: iload 8
    //   403: invokevirtual 334	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   406: invokevirtual 298	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   409: invokestatic 563	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   412: iconst_0
    //   413: istore 4
    //   415: iload 4
    //   417: iload 8
    //   419: if_icmpge +1959 -> 2378
    //   422: aload 12
    //   424: aconst_null
    //   425: iconst_1
    //   426: anewarray 4	java/lang/Object
    //   429: dup
    //   430: iconst_0
    //   431: iload 4
    //   433: invokestatic 218	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   436: aastore
    //   437: invokevirtual 557	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   440: astore 20
    //   442: aload 15
    //   444: aload 20
    //   446: iconst_0
    //   447: anewarray 4	java/lang/Object
    //   450: invokevirtual 557	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   453: checkcast 565	java/lang/Boolean
    //   456: invokevirtual 568	java/lang/Boolean:booleanValue	()Z
    //   459: ifeq +14 -> 473
    //   462: iload_2
    //   463: istore_3
    //   464: iload_0
    //   465: istore 6
    //   467: iload_1
    //   468: istore 7
    //   470: goto +2053 -> 2523
    //   473: aload 14
    //   475: aload 20
    //   477: iconst_0
    //   478: anewarray 4	java/lang/Object
    //   481: invokevirtual 557	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   484: checkcast 439	java/lang/String
    //   487: invokevirtual 571	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   490: astore 21
    //   492: aload 13
    //   494: aload 20
    //   496: iconst_0
    //   497: anewarray 4	java/lang/Object
    //   500: invokevirtual 557	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   503: checkcast 573	[Ljava/lang/String;
    //   506: checkcast 573	[Ljava/lang/String;
    //   509: astore 22
    //   511: aload 22
    //   513: arraylength
    //   514: istore 9
    //   516: iconst_0
    //   517: istore 5
    //   519: iload_2
    //   520: istore_3
    //   521: iload_0
    //   522: istore 6
    //   524: iload_1
    //   525: istore 7
    //   527: iload 5
    //   529: iload 9
    //   531: if_icmpge +1992 -> 2523
    //   534: aload 22
    //   536: iload 5
    //   538: aaload
    //   539: astore 23
    //   541: iconst_2
    //   542: new 285	java/lang/StringBuilder
    //   545: dup
    //   546: invokespecial 286	java/lang/StringBuilder:<init>	()V
    //   549: ldc_w 575
    //   552: invokevirtual 292	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   555: aload 23
    //   557: invokevirtual 292	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   560: invokevirtual 298	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   563: invokestatic 563	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   566: aload 21
    //   568: ldc_w 577
    //   571: invokevirtual 581	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   574: ifne +36 -> 610
    //   577: aload 21
    //   579: ldc_w 583
    //   582: invokevirtual 581	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   585: ifne +25 -> 610
    //   588: aload 21
    //   590: ldc_w 585
    //   593: invokevirtual 581	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   596: ifne +14 -> 610
    //   599: aload 21
    //   601: ldc_w 587
    //   604: invokevirtual 581	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   607: ifeq +15 -> 622
    //   610: getstatic 121	com/tencent/thumbplayer/core/common/TPCodecUtils:mSoftCodecCapList	Ljava/util/ArrayList;
    //   613: aload 23
    //   615: invokevirtual 591	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   618: pop
    //   619: goto +1921 -> 2540
    //   622: getstatic 119	com/tencent/thumbplayer/core/common/TPCodecUtils:mHWCodecCapList	Ljava/util/ArrayList;
    //   625: aload 23
    //   627: invokevirtual 591	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   630: pop
    //   631: getstatic 119	com/tencent/thumbplayer/core/common/TPCodecUtils:mHWCodecCapList	Ljava/util/ArrayList;
    //   634: ldc_w 472
    //   637: invokevirtual 593	java/util/ArrayList:contains	(Ljava/lang/Object;)Z
    //   640: istore 11
    //   642: iload 11
    //   644: ifeq +1876 -> 2520
    //   647: iload_2
    //   648: ifne +1872 -> 2520
    //   651: aload 17
    //   653: aload 16
    //   655: aload 20
    //   657: iconst_1
    //   658: anewarray 4	java/lang/Object
    //   661: dup
    //   662: iconst_0
    //   663: ldc_w 472
    //   666: aastore
    //   667: invokevirtual 557	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   670: invokevirtual 598	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   673: checkcast 600	[Ljava/lang/Object;
    //   676: checkcast 600	[Ljava/lang/Object;
    //   679: astore 23
    //   681: aload 23
    //   683: arraylength
    //   684: istore_3
    //   685: iconst_0
    //   686: istore_2
    //   687: iload_2
    //   688: iload_3
    //   689: if_icmpge +721 -> 1410
    //   692: aload 23
    //   694: iload_2
    //   695: aaload
    //   696: astore 24
    //   698: aload 18
    //   700: aload 24
    //   702: invokevirtual 598	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   705: checkcast 214	java/lang/Integer
    //   708: invokevirtual 558	java/lang/Integer:intValue	()I
    //   711: istore 6
    //   713: aload 19
    //   715: aload 24
    //   717: invokevirtual 598	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   720: checkcast 214	java/lang/Integer
    //   723: invokevirtual 558	java/lang/Integer:intValue	()I
    //   726: istore 7
    //   728: iload 7
    //   730: iload 6
    //   732: invokestatic 604	com/tencent/thumbplayer/core/common/TPCodecUtils:maxLumaSamplesForAVCProfileLevel	(II)I
    //   735: istore 10
    //   737: iload 10
    //   739: getstatic 249	com/tencent/thumbplayer/core/common/TPCodecUtils:mAVCMediaCodecMaxCapability	Lcom/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability;
    //   742: getfield 607	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability:maxLumaSamples	I
    //   745: if_icmplt +1804 -> 2549
    //   748: getstatic 249	com/tencent/thumbplayer/core/common/TPCodecUtils:mAVCMediaCodecMaxCapability	Lcom/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability;
    //   751: iload 10
    //   753: putfield 607	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability:maxLumaSamples	I
    //   756: getstatic 249	com/tencent/thumbplayer/core/common/TPCodecUtils:mAVCMediaCodecMaxCapability	Lcom/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability;
    //   759: iload 7
    //   761: putfield 610	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability:maxProfile	I
    //   764: getstatic 249	com/tencent/thumbplayer/core/common/TPCodecUtils:mAVCMediaCodecMaxCapability	Lcom/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability;
    //   767: iload 6
    //   769: putfield 613	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability:maxLevel	I
    //   772: getstatic 249	com/tencent/thumbplayer/core/common/TPCodecUtils:mAVCMediaCodecMaxCapability	Lcom/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability;
    //   775: getfield 607	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability:maxLumaSamples	I
    //   778: ldc_w 614
    //   781: if_icmplt +39 -> 820
    //   784: getstatic 249	com/tencent/thumbplayer/core/common/TPCodecUtils:mAVCMediaCodecMaxCapability	Lcom/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability;
    //   787: bipush 102
    //   789: bipush 26
    //   791: sipush 7680
    //   794: sipush 4320
    //   797: invokestatic 616	com/tencent/thumbplayer/core/common/TPCodecUtils:getMaxSupportedFrameRatesFor	(IIII)I
    //   800: putfield 619	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability:maxFramerateFormaxLumaSamples	I
    //   803: bipush 26
    //   805: invokestatic 218	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   808: getstatic 249	com/tencent/thumbplayer/core/common/TPCodecUtils:mAVCMediaCodecMaxCapability	Lcom/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability;
    //   811: getstatic 263	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMap	Ljava/util/HashMap;
    //   814: invokestatic 623	com/tencent/thumbplayer/core/common/TPCodecUtils:replace	(Ljava/lang/Object;Ljava/lang/Object;Ljava/util/HashMap;)V
    //   817: goto +1732 -> 2549
    //   820: getstatic 249	com/tencent/thumbplayer/core/common/TPCodecUtils:mAVCMediaCodecMaxCapability	Lcom/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability;
    //   823: getfield 607	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability:maxLumaSamples	I
    //   826: ldc_w 624
    //   829: if_icmplt +256 -> 1085
    //   832: getstatic 249	com/tencent/thumbplayer/core/common/TPCodecUtils:mAVCMediaCodecMaxCapability	Lcom/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability;
    //   835: bipush 102
    //   837: bipush 26
    //   839: sipush 4096
    //   842: sipush 2160
    //   845: invokestatic 616	com/tencent/thumbplayer/core/common/TPCodecUtils:getMaxSupportedFrameRatesFor	(IIII)I
    //   848: putfield 619	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability:maxFramerateFormaxLumaSamples	I
    //   851: goto -48 -> 803
    //   854: astore 23
    //   856: iconst_1
    //   857: istore_2
    //   858: iconst_4
    //   859: new 285	java/lang/StringBuilder
    //   862: dup
    //   863: invokespecial 286	java/lang/StringBuilder:<init>	()V
    //   866: ldc_w 626
    //   869: invokevirtual 292	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   872: aload 23
    //   874: invokevirtual 627	java/lang/RuntimeException:getMessage	()Ljava/lang/String;
    //   877: invokevirtual 292	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   880: invokevirtual 298	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   883: invokestatic 563	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   886: getstatic 119	com/tencent/thumbplayer/core/common/TPCodecUtils:mHWCodecCapList	Ljava/util/ArrayList;
    //   889: ldc_w 437
    //   892: invokevirtual 593	java/util/ArrayList:contains	(Ljava/lang/Object;)Z
    //   895: istore 11
    //   897: iload_1
    //   898: istore_3
    //   899: iload 11
    //   901: ifeq +777 -> 1678
    //   904: iload_1
    //   905: istore_3
    //   906: iload_1
    //   907: ifne +771 -> 1678
    //   910: aload 17
    //   912: aload 16
    //   914: aload 20
    //   916: iconst_1
    //   917: anewarray 4	java/lang/Object
    //   920: dup
    //   921: iconst_0
    //   922: ldc_w 437
    //   925: aastore
    //   926: invokevirtual 557	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   929: invokevirtual 598	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   932: checkcast 600	[Ljava/lang/Object;
    //   935: checkcast 600	[Ljava/lang/Object;
    //   938: astore 23
    //   940: aload 23
    //   942: arraylength
    //   943: istore_3
    //   944: iconst_0
    //   945: istore_1
    //   946: iload_1
    //   947: iload_3
    //   948: if_icmpge +1114 -> 2062
    //   951: aload 23
    //   953: iload_1
    //   954: aaload
    //   955: astore 24
    //   957: aload 18
    //   959: aload 24
    //   961: invokevirtual 598	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   964: checkcast 214	java/lang/Integer
    //   967: invokevirtual 558	java/lang/Integer:intValue	()I
    //   970: istore 6
    //   972: aload 19
    //   974: aload 24
    //   976: invokevirtual 598	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   979: checkcast 214	java/lang/Integer
    //   982: invokevirtual 558	java/lang/Integer:intValue	()I
    //   985: istore 7
    //   987: iload 7
    //   989: iload 6
    //   991: invokestatic 630	com/tencent/thumbplayer/core/common/TPCodecUtils:maxLumaSamplesForHEVCProfileLevel	(II)I
    //   994: istore 10
    //   996: iload 10
    //   998: getstatic 251	com/tencent/thumbplayer/core/common/TPCodecUtils:mHEVCMediaCodecMaxCapability	Lcom/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability;
    //   1001: getfield 607	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability:maxLumaSamples	I
    //   1004: if_icmplt +74 -> 1078
    //   1007: getstatic 251	com/tencent/thumbplayer/core/common/TPCodecUtils:mHEVCMediaCodecMaxCapability	Lcom/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability;
    //   1010: iload 10
    //   1012: putfield 607	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability:maxLumaSamples	I
    //   1015: getstatic 251	com/tencent/thumbplayer/core/common/TPCodecUtils:mHEVCMediaCodecMaxCapability	Lcom/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability;
    //   1018: iload 7
    //   1020: putfield 610	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability:maxProfile	I
    //   1023: getstatic 251	com/tencent/thumbplayer/core/common/TPCodecUtils:mHEVCMediaCodecMaxCapability	Lcom/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability;
    //   1026: iload 6
    //   1028: putfield 613	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability:maxLevel	I
    //   1031: getstatic 251	com/tencent/thumbplayer/core/common/TPCodecUtils:mHEVCMediaCodecMaxCapability	Lcom/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability;
    //   1034: getfield 607	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability:maxLumaSamples	I
    //   1037: ldc_w 614
    //   1040: if_icmplt +571 -> 1611
    //   1043: getstatic 251	com/tencent/thumbplayer/core/common/TPCodecUtils:mHEVCMediaCodecMaxCapability	Lcom/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability;
    //   1046: bipush 102
    //   1048: sipush 172
    //   1051: sipush 7680
    //   1054: sipush 4320
    //   1057: invokestatic 616	com/tencent/thumbplayer/core/common/TPCodecUtils:getMaxSupportedFrameRatesFor	(IIII)I
    //   1060: putfield 619	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability:maxFramerateFormaxLumaSamples	I
    //   1063: sipush 172
    //   1066: invokestatic 218	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1069: getstatic 251	com/tencent/thumbplayer/core/common/TPCodecUtils:mHEVCMediaCodecMaxCapability	Lcom/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability;
    //   1072: getstatic 263	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMap	Ljava/util/HashMap;
    //   1075: invokestatic 623	com/tencent/thumbplayer/core/common/TPCodecUtils:replace	(Ljava/lang/Object;Ljava/lang/Object;Ljava/util/HashMap;)V
    //   1078: iload_1
    //   1079: iconst_1
    //   1080: iadd
    //   1081: istore_1
    //   1082: goto -136 -> 946
    //   1085: getstatic 249	com/tencent/thumbplayer/core/common/TPCodecUtils:mAVCMediaCodecMaxCapability	Lcom/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability;
    //   1088: getfield 607	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability:maxLumaSamples	I
    //   1091: ldc_w 631
    //   1094: if_icmplt +107 -> 1201
    //   1097: getstatic 249	com/tencent/thumbplayer/core/common/TPCodecUtils:mAVCMediaCodecMaxCapability	Lcom/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability;
    //   1100: bipush 102
    //   1102: bipush 26
    //   1104: sipush 1920
    //   1107: sipush 1080
    //   1110: invokestatic 616	com/tencent/thumbplayer/core/common/TPCodecUtils:getMaxSupportedFrameRatesFor	(IIII)I
    //   1113: putfield 619	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability:maxFramerateFormaxLumaSamples	I
    //   1116: goto -313 -> 803
    //   1119: astore 12
    //   1121: iconst_4
    //   1122: new 285	java/lang/StringBuilder
    //   1125: dup
    //   1126: invokespecial 286	java/lang/StringBuilder:<init>	()V
    //   1129: ldc_w 633
    //   1132: invokevirtual 292	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1135: aload 12
    //   1137: invokevirtual 634	java/lang/reflect/InvocationTargetException:getMessage	()Ljava/lang/String;
    //   1140: invokevirtual 292	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1143: invokevirtual 298	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1146: invokestatic 563	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   1149: iconst_2
    //   1150: ldc_w 636
    //   1153: invokestatic 563	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   1156: getstatic 104	com/tencent/thumbplayer/core/common/TPCodecUtils:mIsLocalCacheEnabled	Z
    //   1159: ifeq +30 -> 1189
    //   1162: getstatic 145	com/tencent/thumbplayer/core/common/TPCodecUtils:mHWCodecCapListKey	Ljava/lang/String;
    //   1165: getstatic 119	com/tencent/thumbplayer/core/common/TPCodecUtils:mHWCodecCapList	Ljava/util/ArrayList;
    //   1168: invokestatic 638	com/tencent/thumbplayer/core/common/TPCodecUtils:cacheCapList	(Ljava/lang/String;Ljava/util/ArrayList;)V
    //   1171: getstatic 157	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMapKey	Ljava/lang/String;
    //   1174: getstatic 263	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMap	Ljava/util/HashMap;
    //   1177: invokestatic 640	com/tencent/thumbplayer/core/common/TPCodecUtils:cacheCapabilityMap	(Ljava/lang/String;Ljava/util/HashMap;)V
    //   1180: iconst_2
    //   1181: ldc 32
    //   1183: ldc_w 642
    //   1186: invokestatic 238	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;Ljava/lang/String;)V
    //   1189: iconst_1
    //   1190: putstatic 240	com/tencent/thumbplayer/core/common/TPCodecUtils:mIsMediaCodecCapGot	Z
    //   1193: getstatic 263	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMap	Ljava/util/HashMap;
    //   1196: astore 12
    //   1198: goto -1166 -> 32
    //   1201: getstatic 249	com/tencent/thumbplayer/core/common/TPCodecUtils:mAVCMediaCodecMaxCapability	Lcom/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability;
    //   1204: getfield 607	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability:maxLumaSamples	I
    //   1207: ldc_w 643
    //   1210: if_icmplt +107 -> 1317
    //   1213: getstatic 249	com/tencent/thumbplayer/core/common/TPCodecUtils:mAVCMediaCodecMaxCapability	Lcom/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability;
    //   1216: bipush 102
    //   1218: bipush 26
    //   1220: sipush 1280
    //   1223: sipush 720
    //   1226: invokestatic 616	com/tencent/thumbplayer/core/common/TPCodecUtils:getMaxSupportedFrameRatesFor	(IIII)I
    //   1229: putfield 619	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability:maxFramerateFormaxLumaSamples	I
    //   1232: goto -429 -> 803
    //   1235: astore 12
    //   1237: iconst_4
    //   1238: new 285	java/lang/StringBuilder
    //   1241: dup
    //   1242: invokespecial 286	java/lang/StringBuilder:<init>	()V
    //   1245: ldc_w 633
    //   1248: invokevirtual 292	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1251: aload 12
    //   1253: invokevirtual 644	java/lang/NoSuchMethodException:getMessage	()Ljava/lang/String;
    //   1256: invokevirtual 292	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1259: invokevirtual 298	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1262: invokestatic 563	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   1265: iconst_2
    //   1266: ldc_w 636
    //   1269: invokestatic 563	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   1272: getstatic 104	com/tencent/thumbplayer/core/common/TPCodecUtils:mIsLocalCacheEnabled	Z
    //   1275: ifeq +30 -> 1305
    //   1278: getstatic 145	com/tencent/thumbplayer/core/common/TPCodecUtils:mHWCodecCapListKey	Ljava/lang/String;
    //   1281: getstatic 119	com/tencent/thumbplayer/core/common/TPCodecUtils:mHWCodecCapList	Ljava/util/ArrayList;
    //   1284: invokestatic 638	com/tencent/thumbplayer/core/common/TPCodecUtils:cacheCapList	(Ljava/lang/String;Ljava/util/ArrayList;)V
    //   1287: getstatic 157	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMapKey	Ljava/lang/String;
    //   1290: getstatic 263	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMap	Ljava/util/HashMap;
    //   1293: invokestatic 640	com/tencent/thumbplayer/core/common/TPCodecUtils:cacheCapabilityMap	(Ljava/lang/String;Ljava/util/HashMap;)V
    //   1296: iconst_2
    //   1297: ldc 32
    //   1299: ldc_w 642
    //   1302: invokestatic 238	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;Ljava/lang/String;)V
    //   1305: iconst_1
    //   1306: putstatic 240	com/tencent/thumbplayer/core/common/TPCodecUtils:mIsMediaCodecCapGot	Z
    //   1309: getstatic 263	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMap	Ljava/util/HashMap;
    //   1312: astore 12
    //   1314: goto -1282 -> 32
    //   1317: getstatic 249	com/tencent/thumbplayer/core/common/TPCodecUtils:mAVCMediaCodecMaxCapability	Lcom/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability;
    //   1320: bipush 30
    //   1322: putfield 619	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability:maxFramerateFormaxLumaSamples	I
    //   1325: goto -522 -> 803
    //   1328: astore 12
    //   1330: iconst_4
    //   1331: new 285	java/lang/StringBuilder
    //   1334: dup
    //   1335: invokespecial 286	java/lang/StringBuilder:<init>	()V
    //   1338: ldc_w 633
    //   1341: invokevirtual 292	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1344: aload 12
    //   1346: invokevirtual 645	java/lang/IllegalAccessException:getMessage	()Ljava/lang/String;
    //   1349: invokevirtual 292	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1352: invokevirtual 298	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1355: invokestatic 563	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   1358: iconst_2
    //   1359: ldc_w 636
    //   1362: invokestatic 563	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   1365: getstatic 104	com/tencent/thumbplayer/core/common/TPCodecUtils:mIsLocalCacheEnabled	Z
    //   1368: ifeq +30 -> 1398
    //   1371: getstatic 145	com/tencent/thumbplayer/core/common/TPCodecUtils:mHWCodecCapListKey	Ljava/lang/String;
    //   1374: getstatic 119	com/tencent/thumbplayer/core/common/TPCodecUtils:mHWCodecCapList	Ljava/util/ArrayList;
    //   1377: invokestatic 638	com/tencent/thumbplayer/core/common/TPCodecUtils:cacheCapList	(Ljava/lang/String;Ljava/util/ArrayList;)V
    //   1380: getstatic 157	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMapKey	Ljava/lang/String;
    //   1383: getstatic 263	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMap	Ljava/util/HashMap;
    //   1386: invokestatic 640	com/tencent/thumbplayer/core/common/TPCodecUtils:cacheCapabilityMap	(Ljava/lang/String;Ljava/util/HashMap;)V
    //   1389: iconst_2
    //   1390: ldc 32
    //   1392: ldc_w 642
    //   1395: invokestatic 238	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;Ljava/lang/String;)V
    //   1398: iconst_1
    //   1399: putstatic 240	com/tencent/thumbplayer/core/common/TPCodecUtils:mIsMediaCodecCapGot	Z
    //   1402: getstatic 263	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMap	Ljava/util/HashMap;
    //   1405: astore 12
    //   1407: goto -1375 -> 32
    //   1410: getstatic 263	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMap	Ljava/util/HashMap;
    //   1413: bipush 26
    //   1415: invokestatic 218	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1418: invokevirtual 648	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   1421: ifeq +98 -> 1519
    //   1424: iconst_2
    //   1425: new 285	java/lang/StringBuilder
    //   1428: dup
    //   1429: invokespecial 286	java/lang/StringBuilder:<init>	()V
    //   1432: ldc_w 650
    //   1435: invokevirtual 292	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1438: getstatic 263	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMap	Ljava/util/HashMap;
    //   1441: bipush 26
    //   1443: invokestatic 218	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1446: invokevirtual 651	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1449: checkcast 244	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability
    //   1452: getfield 610	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability:maxProfile	I
    //   1455: invokevirtual 334	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1458: ldc_w 653
    //   1461: invokevirtual 292	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1464: getstatic 263	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMap	Ljava/util/HashMap;
    //   1467: bipush 26
    //   1469: invokestatic 218	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1472: invokevirtual 651	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1475: checkcast 244	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability
    //   1478: getfield 613	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability:maxLevel	I
    //   1481: invokevirtual 334	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1484: ldc_w 655
    //   1487: invokevirtual 292	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1490: getstatic 263	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMap	Ljava/util/HashMap;
    //   1493: bipush 26
    //   1495: invokestatic 218	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1498: invokevirtual 651	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1501: checkcast 244	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability
    //   1504: getfield 607	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability:maxLumaSamples	I
    //   1507: invokevirtual 334	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1510: invokevirtual 298	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1513: invokestatic 563	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   1516: goto +1040 -> 2556
    //   1519: iconst_2
    //   1520: ldc_w 657
    //   1523: invokestatic 563	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   1526: goto +1030 -> 2556
    //   1529: astore 12
    //   1531: iconst_4
    //   1532: new 285	java/lang/StringBuilder
    //   1535: dup
    //   1536: invokespecial 286	java/lang/StringBuilder:<init>	()V
    //   1539: ldc_w 633
    //   1542: invokevirtual 292	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1545: aload 12
    //   1547: invokevirtual 658	java/lang/NoSuchFieldException:getMessage	()Ljava/lang/String;
    //   1550: invokevirtual 292	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1553: invokevirtual 298	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1556: invokestatic 563	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   1559: iconst_2
    //   1560: ldc_w 636
    //   1563: invokestatic 563	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   1566: getstatic 104	com/tencent/thumbplayer/core/common/TPCodecUtils:mIsLocalCacheEnabled	Z
    //   1569: ifeq +30 -> 1599
    //   1572: getstatic 145	com/tencent/thumbplayer/core/common/TPCodecUtils:mHWCodecCapListKey	Ljava/lang/String;
    //   1575: getstatic 119	com/tencent/thumbplayer/core/common/TPCodecUtils:mHWCodecCapList	Ljava/util/ArrayList;
    //   1578: invokestatic 638	com/tencent/thumbplayer/core/common/TPCodecUtils:cacheCapList	(Ljava/lang/String;Ljava/util/ArrayList;)V
    //   1581: getstatic 157	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMapKey	Ljava/lang/String;
    //   1584: getstatic 263	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMap	Ljava/util/HashMap;
    //   1587: invokestatic 640	com/tencent/thumbplayer/core/common/TPCodecUtils:cacheCapabilityMap	(Ljava/lang/String;Ljava/util/HashMap;)V
    //   1590: iconst_2
    //   1591: ldc 32
    //   1593: ldc_w 642
    //   1596: invokestatic 238	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;Ljava/lang/String;)V
    //   1599: iconst_1
    //   1600: putstatic 240	com/tencent/thumbplayer/core/common/TPCodecUtils:mIsMediaCodecCapGot	Z
    //   1603: getstatic 263	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMap	Ljava/util/HashMap;
    //   1606: astore 12
    //   1608: goto -1576 -> 32
    //   1611: getstatic 251	com/tencent/thumbplayer/core/common/TPCodecUtils:mHEVCMediaCodecMaxCapability	Lcom/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability;
    //   1614: getfield 607	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability:maxLumaSamples	I
    //   1617: ldc_w 624
    //   1620: if_icmplt +225 -> 1845
    //   1623: getstatic 251	com/tencent/thumbplayer/core/common/TPCodecUtils:mHEVCMediaCodecMaxCapability	Lcom/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability;
    //   1626: bipush 102
    //   1628: sipush 172
    //   1631: sipush 4096
    //   1634: sipush 2160
    //   1637: invokestatic 616	com/tencent/thumbplayer/core/common/TPCodecUtils:getMaxSupportedFrameRatesFor	(IIII)I
    //   1640: putfield 619	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability:maxFramerateFormaxLumaSamples	I
    //   1643: goto -580 -> 1063
    //   1646: astore 23
    //   1648: iconst_1
    //   1649: istore_3
    //   1650: iconst_4
    //   1651: new 285	java/lang/StringBuilder
    //   1654: dup
    //   1655: invokespecial 286	java/lang/StringBuilder:<init>	()V
    //   1658: ldc_w 660
    //   1661: invokevirtual 292	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1664: aload 23
    //   1666: invokevirtual 627	java/lang/RuntimeException:getMessage	()Ljava/lang/String;
    //   1669: invokevirtual 292	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1672: invokevirtual 298	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1675: invokestatic 563	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   1678: getstatic 119	com/tencent/thumbplayer/core/common/TPCodecUtils:mHWCodecCapList	Ljava/util/ArrayList;
    //   1681: ldc_w 662
    //   1684: invokevirtual 593	java/util/ArrayList:contains	(Ljava/lang/Object;)Z
    //   1687: istore 11
    //   1689: iload_0
    //   1690: istore_1
    //   1691: iload 11
    //   1693: ifeq +680 -> 2373
    //   1696: iload_0
    //   1697: istore_1
    //   1698: iload_0
    //   1699: ifne +674 -> 2373
    //   1702: aload 17
    //   1704: aload 16
    //   1706: aload 20
    //   1708: iconst_1
    //   1709: anewarray 4	java/lang/Object
    //   1712: dup
    //   1713: iconst_0
    //   1714: ldc_w 662
    //   1717: aastore
    //   1718: invokevirtual 557	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   1721: invokevirtual 598	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1724: checkcast 600	[Ljava/lang/Object;
    //   1727: checkcast 600	[Ljava/lang/Object;
    //   1730: astore 23
    //   1732: aload 23
    //   1734: arraylength
    //   1735: istore_1
    //   1736: iconst_0
    //   1737: istore_0
    //   1738: iload_0
    //   1739: iload_1
    //   1740: if_icmpge +445 -> 2185
    //   1743: aload 23
    //   1745: iload_0
    //   1746: aaload
    //   1747: astore 24
    //   1749: aload 18
    //   1751: aload 24
    //   1753: invokevirtual 598	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1756: checkcast 214	java/lang/Integer
    //   1759: invokevirtual 558	java/lang/Integer:intValue	()I
    //   1762: istore 6
    //   1764: aload 19
    //   1766: aload 24
    //   1768: invokevirtual 598	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1771: checkcast 214	java/lang/Integer
    //   1774: invokevirtual 558	java/lang/Integer:intValue	()I
    //   1777: istore 7
    //   1779: iload 7
    //   1781: iload 6
    //   1783: invokestatic 665	com/tencent/thumbplayer/core/common/TPCodecUtils:maxLumaSamplesForVP9ProfileLevel	(II)I
    //   1786: istore 10
    //   1788: iload 10
    //   1790: getstatic 253	com/tencent/thumbplayer/core/common/TPCodecUtils:mVP9MediaCodecMaxCapability	Lcom/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability;
    //   1793: getfield 607	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability:maxLumaSamples	I
    //   1796: if_icmplt +42 -> 1838
    //   1799: getstatic 253	com/tencent/thumbplayer/core/common/TPCodecUtils:mVP9MediaCodecMaxCapability	Lcom/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability;
    //   1802: iload 10
    //   1804: putfield 607	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability:maxLumaSamples	I
    //   1807: getstatic 253	com/tencent/thumbplayer/core/common/TPCodecUtils:mVP9MediaCodecMaxCapability	Lcom/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability;
    //   1810: iload 7
    //   1812: putfield 610	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability:maxProfile	I
    //   1815: getstatic 253	com/tencent/thumbplayer/core/common/TPCodecUtils:mVP9MediaCodecMaxCapability	Lcom/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability;
    //   1818: iload 6
    //   1820: putfield 613	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability:maxLevel	I
    //   1823: sipush 166
    //   1826: invokestatic 218	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1829: getstatic 253	com/tencent/thumbplayer/core/common/TPCodecUtils:mVP9MediaCodecMaxCapability	Lcom/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability;
    //   1832: getstatic 263	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMap	Ljava/util/HashMap;
    //   1835: invokestatic 623	com/tencent/thumbplayer/core/common/TPCodecUtils:replace	(Ljava/lang/Object;Ljava/lang/Object;Ljava/util/HashMap;)V
    //   1838: iload_0
    //   1839: iconst_1
    //   1840: iadd
    //   1841: istore_0
    //   1842: goto -104 -> 1738
    //   1845: getstatic 251	com/tencent/thumbplayer/core/common/TPCodecUtils:mHEVCMediaCodecMaxCapability	Lcom/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability;
    //   1848: getfield 607	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability:maxLumaSamples	I
    //   1851: ldc_w 631
    //   1854: if_icmplt +108 -> 1962
    //   1857: getstatic 251	com/tencent/thumbplayer/core/common/TPCodecUtils:mHEVCMediaCodecMaxCapability	Lcom/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability;
    //   1860: bipush 102
    //   1862: sipush 172
    //   1865: sipush 1920
    //   1868: sipush 1080
    //   1871: invokestatic 616	com/tencent/thumbplayer/core/common/TPCodecUtils:getMaxSupportedFrameRatesFor	(IIII)I
    //   1874: putfield 619	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability:maxFramerateFormaxLumaSamples	I
    //   1877: goto -814 -> 1063
    //   1880: astore 12
    //   1882: iconst_4
    //   1883: new 285	java/lang/StringBuilder
    //   1886: dup
    //   1887: invokespecial 286	java/lang/StringBuilder:<init>	()V
    //   1890: ldc_w 633
    //   1893: invokevirtual 292	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1896: aload 12
    //   1898: invokevirtual 666	java/lang/ClassNotFoundException:getMessage	()Ljava/lang/String;
    //   1901: invokevirtual 292	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1904: invokevirtual 298	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1907: invokestatic 563	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   1910: iconst_2
    //   1911: ldc_w 636
    //   1914: invokestatic 563	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   1917: getstatic 104	com/tencent/thumbplayer/core/common/TPCodecUtils:mIsLocalCacheEnabled	Z
    //   1920: ifeq +30 -> 1950
    //   1923: getstatic 145	com/tencent/thumbplayer/core/common/TPCodecUtils:mHWCodecCapListKey	Ljava/lang/String;
    //   1926: getstatic 119	com/tencent/thumbplayer/core/common/TPCodecUtils:mHWCodecCapList	Ljava/util/ArrayList;
    //   1929: invokestatic 638	com/tencent/thumbplayer/core/common/TPCodecUtils:cacheCapList	(Ljava/lang/String;Ljava/util/ArrayList;)V
    //   1932: getstatic 157	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMapKey	Ljava/lang/String;
    //   1935: getstatic 263	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMap	Ljava/util/HashMap;
    //   1938: invokestatic 640	com/tencent/thumbplayer/core/common/TPCodecUtils:cacheCapabilityMap	(Ljava/lang/String;Ljava/util/HashMap;)V
    //   1941: iconst_2
    //   1942: ldc 32
    //   1944: ldc_w 642
    //   1947: invokestatic 238	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;Ljava/lang/String;)V
    //   1950: iconst_1
    //   1951: putstatic 240	com/tencent/thumbplayer/core/common/TPCodecUtils:mIsMediaCodecCapGot	Z
    //   1954: getstatic 263	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMap	Ljava/util/HashMap;
    //   1957: astore 12
    //   1959: goto -1927 -> 32
    //   1962: getstatic 251	com/tencent/thumbplayer/core/common/TPCodecUtils:mHEVCMediaCodecMaxCapability	Lcom/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability;
    //   1965: getfield 607	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability:maxLumaSamples	I
    //   1968: ldc_w 643
    //   1971: if_icmplt +80 -> 2051
    //   1974: getstatic 251	com/tencent/thumbplayer/core/common/TPCodecUtils:mHEVCMediaCodecMaxCapability	Lcom/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability;
    //   1977: bipush 102
    //   1979: sipush 172
    //   1982: sipush 1280
    //   1985: sipush 720
    //   1988: invokestatic 616	com/tencent/thumbplayer/core/common/TPCodecUtils:getMaxSupportedFrameRatesFor	(IIII)I
    //   1991: putfield 619	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability:maxFramerateFormaxLumaSamples	I
    //   1994: goto -931 -> 1063
    //   1997: astore 12
    //   1999: iconst_2
    //   2000: ldc_w 636
    //   2003: invokestatic 563	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   2006: getstatic 104	com/tencent/thumbplayer/core/common/TPCodecUtils:mIsLocalCacheEnabled	Z
    //   2009: ifeq +30 -> 2039
    //   2012: getstatic 145	com/tencent/thumbplayer/core/common/TPCodecUtils:mHWCodecCapListKey	Ljava/lang/String;
    //   2015: getstatic 119	com/tencent/thumbplayer/core/common/TPCodecUtils:mHWCodecCapList	Ljava/util/ArrayList;
    //   2018: invokestatic 638	com/tencent/thumbplayer/core/common/TPCodecUtils:cacheCapList	(Ljava/lang/String;Ljava/util/ArrayList;)V
    //   2021: getstatic 157	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMapKey	Ljava/lang/String;
    //   2024: getstatic 263	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMap	Ljava/util/HashMap;
    //   2027: invokestatic 640	com/tencent/thumbplayer/core/common/TPCodecUtils:cacheCapabilityMap	(Ljava/lang/String;Ljava/util/HashMap;)V
    //   2030: iconst_2
    //   2031: ldc 32
    //   2033: ldc_w 642
    //   2036: invokestatic 238	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;Ljava/lang/String;)V
    //   2039: iconst_1
    //   2040: putstatic 240	com/tencent/thumbplayer/core/common/TPCodecUtils:mIsMediaCodecCapGot	Z
    //   2043: getstatic 263	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMap	Ljava/util/HashMap;
    //   2046: astore 12
    //   2048: goto -2016 -> 32
    //   2051: getstatic 251	com/tencent/thumbplayer/core/common/TPCodecUtils:mHEVCMediaCodecMaxCapability	Lcom/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability;
    //   2054: bipush 30
    //   2056: putfield 619	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability:maxFramerateFormaxLumaSamples	I
    //   2059: goto -996 -> 1063
    //   2062: getstatic 263	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMap	Ljava/util/HashMap;
    //   2065: sipush 172
    //   2068: invokestatic 218	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2071: invokevirtual 648	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   2074: ifeq +101 -> 2175
    //   2077: iconst_2
    //   2078: new 285	java/lang/StringBuilder
    //   2081: dup
    //   2082: invokespecial 286	java/lang/StringBuilder:<init>	()V
    //   2085: ldc_w 668
    //   2088: invokevirtual 292	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2091: getstatic 263	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMap	Ljava/util/HashMap;
    //   2094: sipush 172
    //   2097: invokestatic 218	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2100: invokevirtual 651	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   2103: checkcast 244	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability
    //   2106: getfield 610	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability:maxProfile	I
    //   2109: invokevirtual 334	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2112: ldc_w 653
    //   2115: invokevirtual 292	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2118: getstatic 263	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMap	Ljava/util/HashMap;
    //   2121: sipush 172
    //   2124: invokestatic 218	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2127: invokevirtual 651	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   2130: checkcast 244	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability
    //   2133: getfield 613	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability:maxLevel	I
    //   2136: invokevirtual 334	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2139: ldc_w 655
    //   2142: invokevirtual 292	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2145: getstatic 263	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMap	Ljava/util/HashMap;
    //   2148: sipush 172
    //   2151: invokestatic 218	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2154: invokevirtual 651	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   2157: checkcast 244	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability
    //   2160: getfield 607	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability:maxLumaSamples	I
    //   2163: invokevirtual 334	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2166: invokevirtual 298	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2169: invokestatic 563	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   2172: goto +389 -> 2561
    //   2175: iconst_2
    //   2176: ldc_w 670
    //   2179: invokestatic 563	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   2182: goto +379 -> 2561
    //   2185: getstatic 263	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMap	Ljava/util/HashMap;
    //   2188: sipush 166
    //   2191: invokestatic 218	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2194: invokevirtual 648	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   2197: ifeq +134 -> 2331
    //   2200: iconst_2
    //   2201: new 285	java/lang/StringBuilder
    //   2204: dup
    //   2205: invokespecial 286	java/lang/StringBuilder:<init>	()V
    //   2208: ldc_w 672
    //   2211: invokevirtual 292	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2214: getstatic 263	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMap	Ljava/util/HashMap;
    //   2217: sipush 166
    //   2220: invokestatic 218	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2223: invokevirtual 651	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   2226: checkcast 244	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability
    //   2229: getfield 610	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability:maxProfile	I
    //   2232: invokevirtual 334	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2235: ldc_w 653
    //   2238: invokevirtual 292	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2241: getstatic 263	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMap	Ljava/util/HashMap;
    //   2244: sipush 166
    //   2247: invokestatic 218	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2250: invokevirtual 651	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   2253: checkcast 244	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability
    //   2256: getfield 613	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability:maxLevel	I
    //   2259: invokevirtual 334	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2262: ldc_w 655
    //   2265: invokevirtual 292	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2268: getstatic 263	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMap	Ljava/util/HashMap;
    //   2271: sipush 166
    //   2274: invokestatic 218	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2277: invokevirtual 651	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   2280: checkcast 244	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability
    //   2283: getfield 607	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability:maxLumaSamples	I
    //   2286: invokevirtual 334	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2289: invokevirtual 298	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2292: invokestatic 563	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   2295: iconst_1
    //   2296: istore_0
    //   2297: iconst_2
    //   2298: new 285	java/lang/StringBuilder
    //   2301: dup
    //   2302: invokespecial 286	java/lang/StringBuilder:<init>	()V
    //   2305: ldc_w 674
    //   2308: invokevirtual 292	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2311: getstatic 263	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMap	Ljava/util/HashMap;
    //   2314: invokevirtual 505	java/util/HashMap:size	()I
    //   2317: invokevirtual 334	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2320: invokevirtual 298	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2323: invokestatic 563	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   2326: iload_3
    //   2327: istore_1
    //   2328: goto +212 -> 2540
    //   2331: iconst_2
    //   2332: ldc_w 676
    //   2335: invokestatic 563	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   2338: goto -43 -> 2295
    //   2341: astore 23
    //   2343: iconst_1
    //   2344: istore_1
    //   2345: iconst_4
    //   2346: new 285	java/lang/StringBuilder
    //   2349: dup
    //   2350: invokespecial 286	java/lang/StringBuilder:<init>	()V
    //   2353: ldc_w 678
    //   2356: invokevirtual 292	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2359: aload 23
    //   2361: invokevirtual 627	java/lang/RuntimeException:getMessage	()Ljava/lang/String;
    //   2364: invokevirtual 292	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2367: invokevirtual 298	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2370: invokestatic 563	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   2373: iload_1
    //   2374: istore_0
    //   2375: goto -78 -> 2297
    //   2378: iconst_2
    //   2379: ldc_w 636
    //   2382: invokestatic 563	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   2385: getstatic 104	com/tencent/thumbplayer/core/common/TPCodecUtils:mIsLocalCacheEnabled	Z
    //   2388: ifeq +30 -> 2418
    //   2391: getstatic 145	com/tencent/thumbplayer/core/common/TPCodecUtils:mHWCodecCapListKey	Ljava/lang/String;
    //   2394: getstatic 119	com/tencent/thumbplayer/core/common/TPCodecUtils:mHWCodecCapList	Ljava/util/ArrayList;
    //   2397: invokestatic 638	com/tencent/thumbplayer/core/common/TPCodecUtils:cacheCapList	(Ljava/lang/String;Ljava/util/ArrayList;)V
    //   2400: getstatic 157	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMapKey	Ljava/lang/String;
    //   2403: getstatic 263	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMap	Ljava/util/HashMap;
    //   2406: invokestatic 640	com/tencent/thumbplayer/core/common/TPCodecUtils:cacheCapabilityMap	(Ljava/lang/String;Ljava/util/HashMap;)V
    //   2409: iconst_2
    //   2410: ldc 32
    //   2412: ldc_w 642
    //   2415: invokestatic 238	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;Ljava/lang/String;)V
    //   2418: iconst_1
    //   2419: putstatic 240	com/tencent/thumbplayer/core/common/TPCodecUtils:mIsMediaCodecCapGot	Z
    //   2422: getstatic 263	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMap	Ljava/util/HashMap;
    //   2425: astore 12
    //   2427: goto -2395 -> 32
    //   2430: astore 12
    //   2432: iconst_4
    //   2433: new 285	java/lang/StringBuilder
    //   2436: dup
    //   2437: invokespecial 286	java/lang/StringBuilder:<init>	()V
    //   2440: ldc_w 633
    //   2443: invokevirtual 292	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2446: aload 12
    //   2448: invokevirtual 627	java/lang/RuntimeException:getMessage	()Ljava/lang/String;
    //   2451: invokevirtual 292	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2454: invokevirtual 298	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2457: invokestatic 563	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   2460: iconst_2
    //   2461: ldc_w 636
    //   2464: invokestatic 563	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   2467: getstatic 104	com/tencent/thumbplayer/core/common/TPCodecUtils:mIsLocalCacheEnabled	Z
    //   2470: ifeq +30 -> 2500
    //   2473: getstatic 145	com/tencent/thumbplayer/core/common/TPCodecUtils:mHWCodecCapListKey	Ljava/lang/String;
    //   2476: getstatic 119	com/tencent/thumbplayer/core/common/TPCodecUtils:mHWCodecCapList	Ljava/util/ArrayList;
    //   2479: invokestatic 638	com/tencent/thumbplayer/core/common/TPCodecUtils:cacheCapList	(Ljava/lang/String;Ljava/util/ArrayList;)V
    //   2482: getstatic 157	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMapKey	Ljava/lang/String;
    //   2485: getstatic 263	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMap	Ljava/util/HashMap;
    //   2488: invokestatic 640	com/tencent/thumbplayer/core/common/TPCodecUtils:cacheCapabilityMap	(Ljava/lang/String;Ljava/util/HashMap;)V
    //   2491: iconst_2
    //   2492: ldc 32
    //   2494: ldc_w 642
    //   2497: invokestatic 238	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;Ljava/lang/String;)V
    //   2500: iconst_1
    //   2501: putstatic 240	com/tencent/thumbplayer/core/common/TPCodecUtils:mIsMediaCodecCapGot	Z
    //   2504: getstatic 263	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMap	Ljava/util/HashMap;
    //   2507: astore 12
    //   2509: goto -2477 -> 32
    //   2512: astore 12
    //   2514: ldc 2
    //   2516: monitorexit
    //   2517: aload 12
    //   2519: athrow
    //   2520: goto -1634 -> 886
    //   2523: iload 4
    //   2525: iconst_1
    //   2526: iadd
    //   2527: istore 4
    //   2529: iload_3
    //   2530: istore_2
    //   2531: iload 6
    //   2533: istore_0
    //   2534: iload 7
    //   2536: istore_1
    //   2537: goto -2122 -> 415
    //   2540: iload 5
    //   2542: iconst_1
    //   2543: iadd
    //   2544: istore 5
    //   2546: goto -2027 -> 519
    //   2549: iload_2
    //   2550: iconst_1
    //   2551: iadd
    //   2552: istore_2
    //   2553: goto -1866 -> 687
    //   2556: iconst_1
    //   2557: istore_2
    //   2558: goto -1672 -> 886
    //   2561: iconst_1
    //   2562: istore_3
    //   2563: goto -885 -> 1678
    // Local variable table:
    //   start	length	slot	name	signature
    //   214	2320	0	i	int
    //   212	2325	1	j	int
    //   210	2348	2	k	int
    //   463	2100	3	m	int
    //   413	2115	4	n	int
    //   517	2028	5	i1	int
    //   465	2067	6	i2	int
    //   468	2067	7	i3	int
    //   385	35	8	i4	int
    //   514	18	9	i5	int
    //   735	1068	10	i6	int
    //   640	1052	11	bool	boolean
    //   30	143	12	localObject1	Object
    //   177	19	12	localException	Exception
    //   221	202	12	localObject2	Object
    //   1119	17	12	localInvocationTargetException	java.lang.reflect.InvocationTargetException
    //   1196	1	12	localHashMap1	HashMap
    //   1235	17	12	localNoSuchMethodException	java.lang.NoSuchMethodException
    //   1312	1	12	localHashMap2	HashMap
    //   1328	17	12	localIllegalAccessException	java.lang.IllegalAccessException
    //   1405	1	12	localHashMap3	HashMap
    //   1529	17	12	localNoSuchFieldException	java.lang.NoSuchFieldException
    //   1606	1	12	localHashMap4	HashMap
    //   1880	17	12	localClassNotFoundException	java.lang.ClassNotFoundException
    //   1957	1	12	localHashMap5	HashMap
    //   1997	1	12	localObject3	Object
    //   2046	380	12	localHashMap6	HashMap
    //   2430	17	12	localRuntimeException1	java.lang.RuntimeException
    //   2507	1	12	localHashMap7	HashMap
    //   2512	6	12	localObject4	Object
    //   277	216	13	localMethod1	Method
    //   291	183	14	localMethod2	Method
    //   305	138	15	localMethod3	Method
    //   263	1442	16	localObject5	Object
    //   339	1364	17	localField1	Field
    //   357	1393	18	localField2	Field
    //   347	1418	19	localObject6	Object
    //   235	1472	20	localObject7	Object
    //   490	110	21	str	String
    //   509	26	22	arrayOfString	String[]
    //   539	154	23	localObject8	Object
    //   854	19	23	localRuntimeException2	java.lang.RuntimeException
    //   938	14	23	arrayOfObject1	Object[]
    //   1646	19	23	localRuntimeException3	java.lang.RuntimeException
    //   1730	14	23	arrayOfObject2	Object[]
    //   2341	19	23	localRuntimeException4	java.lang.RuntimeException
    //   696	1071	24	localObject9	Object
    // Exception table:
    //   from	to	target	type
    //   38	74	177	java/lang/Exception
    //   74	82	177	java/lang/Exception
    //   87	92	177	java/lang/Exception
    //   92	115	177	java/lang/Exception
    //   120	174	177	java/lang/Exception
    //   651	685	854	java/lang/RuntimeException
    //   698	803	854	java/lang/RuntimeException
    //   803	817	854	java/lang/RuntimeException
    //   820	851	854	java/lang/RuntimeException
    //   1085	1116	854	java/lang/RuntimeException
    //   1201	1232	854	java/lang/RuntimeException
    //   1317	1325	854	java/lang/RuntimeException
    //   1410	1516	854	java/lang/RuntimeException
    //   1519	1526	854	java/lang/RuntimeException
    //   215	412	1119	java/lang/reflect/InvocationTargetException
    //   422	462	1119	java/lang/reflect/InvocationTargetException
    //   473	516	1119	java/lang/reflect/InvocationTargetException
    //   541	610	1119	java/lang/reflect/InvocationTargetException
    //   610	619	1119	java/lang/reflect/InvocationTargetException
    //   622	642	1119	java/lang/reflect/InvocationTargetException
    //   651	685	1119	java/lang/reflect/InvocationTargetException
    //   698	803	1119	java/lang/reflect/InvocationTargetException
    //   803	817	1119	java/lang/reflect/InvocationTargetException
    //   820	851	1119	java/lang/reflect/InvocationTargetException
    //   858	886	1119	java/lang/reflect/InvocationTargetException
    //   886	897	1119	java/lang/reflect/InvocationTargetException
    //   910	944	1119	java/lang/reflect/InvocationTargetException
    //   957	1063	1119	java/lang/reflect/InvocationTargetException
    //   1063	1078	1119	java/lang/reflect/InvocationTargetException
    //   1085	1116	1119	java/lang/reflect/InvocationTargetException
    //   1201	1232	1119	java/lang/reflect/InvocationTargetException
    //   1317	1325	1119	java/lang/reflect/InvocationTargetException
    //   1410	1516	1119	java/lang/reflect/InvocationTargetException
    //   1519	1526	1119	java/lang/reflect/InvocationTargetException
    //   1611	1643	1119	java/lang/reflect/InvocationTargetException
    //   1650	1678	1119	java/lang/reflect/InvocationTargetException
    //   1678	1689	1119	java/lang/reflect/InvocationTargetException
    //   1702	1736	1119	java/lang/reflect/InvocationTargetException
    //   1749	1838	1119	java/lang/reflect/InvocationTargetException
    //   1845	1877	1119	java/lang/reflect/InvocationTargetException
    //   1962	1994	1119	java/lang/reflect/InvocationTargetException
    //   2051	2059	1119	java/lang/reflect/InvocationTargetException
    //   2062	2172	1119	java/lang/reflect/InvocationTargetException
    //   2175	2182	1119	java/lang/reflect/InvocationTargetException
    //   2185	2295	1119	java/lang/reflect/InvocationTargetException
    //   2297	2326	1119	java/lang/reflect/InvocationTargetException
    //   2331	2338	1119	java/lang/reflect/InvocationTargetException
    //   2345	2373	1119	java/lang/reflect/InvocationTargetException
    //   215	412	1235	java/lang/NoSuchMethodException
    //   422	462	1235	java/lang/NoSuchMethodException
    //   473	516	1235	java/lang/NoSuchMethodException
    //   541	610	1235	java/lang/NoSuchMethodException
    //   610	619	1235	java/lang/NoSuchMethodException
    //   622	642	1235	java/lang/NoSuchMethodException
    //   651	685	1235	java/lang/NoSuchMethodException
    //   698	803	1235	java/lang/NoSuchMethodException
    //   803	817	1235	java/lang/NoSuchMethodException
    //   820	851	1235	java/lang/NoSuchMethodException
    //   858	886	1235	java/lang/NoSuchMethodException
    //   886	897	1235	java/lang/NoSuchMethodException
    //   910	944	1235	java/lang/NoSuchMethodException
    //   957	1063	1235	java/lang/NoSuchMethodException
    //   1063	1078	1235	java/lang/NoSuchMethodException
    //   1085	1116	1235	java/lang/NoSuchMethodException
    //   1201	1232	1235	java/lang/NoSuchMethodException
    //   1317	1325	1235	java/lang/NoSuchMethodException
    //   1410	1516	1235	java/lang/NoSuchMethodException
    //   1519	1526	1235	java/lang/NoSuchMethodException
    //   1611	1643	1235	java/lang/NoSuchMethodException
    //   1650	1678	1235	java/lang/NoSuchMethodException
    //   1678	1689	1235	java/lang/NoSuchMethodException
    //   1702	1736	1235	java/lang/NoSuchMethodException
    //   1749	1838	1235	java/lang/NoSuchMethodException
    //   1845	1877	1235	java/lang/NoSuchMethodException
    //   1962	1994	1235	java/lang/NoSuchMethodException
    //   2051	2059	1235	java/lang/NoSuchMethodException
    //   2062	2172	1235	java/lang/NoSuchMethodException
    //   2175	2182	1235	java/lang/NoSuchMethodException
    //   2185	2295	1235	java/lang/NoSuchMethodException
    //   2297	2326	1235	java/lang/NoSuchMethodException
    //   2331	2338	1235	java/lang/NoSuchMethodException
    //   2345	2373	1235	java/lang/NoSuchMethodException
    //   215	412	1328	java/lang/IllegalAccessException
    //   422	462	1328	java/lang/IllegalAccessException
    //   473	516	1328	java/lang/IllegalAccessException
    //   541	610	1328	java/lang/IllegalAccessException
    //   610	619	1328	java/lang/IllegalAccessException
    //   622	642	1328	java/lang/IllegalAccessException
    //   651	685	1328	java/lang/IllegalAccessException
    //   698	803	1328	java/lang/IllegalAccessException
    //   803	817	1328	java/lang/IllegalAccessException
    //   820	851	1328	java/lang/IllegalAccessException
    //   858	886	1328	java/lang/IllegalAccessException
    //   886	897	1328	java/lang/IllegalAccessException
    //   910	944	1328	java/lang/IllegalAccessException
    //   957	1063	1328	java/lang/IllegalAccessException
    //   1063	1078	1328	java/lang/IllegalAccessException
    //   1085	1116	1328	java/lang/IllegalAccessException
    //   1201	1232	1328	java/lang/IllegalAccessException
    //   1317	1325	1328	java/lang/IllegalAccessException
    //   1410	1516	1328	java/lang/IllegalAccessException
    //   1519	1526	1328	java/lang/IllegalAccessException
    //   1611	1643	1328	java/lang/IllegalAccessException
    //   1650	1678	1328	java/lang/IllegalAccessException
    //   1678	1689	1328	java/lang/IllegalAccessException
    //   1702	1736	1328	java/lang/IllegalAccessException
    //   1749	1838	1328	java/lang/IllegalAccessException
    //   1845	1877	1328	java/lang/IllegalAccessException
    //   1962	1994	1328	java/lang/IllegalAccessException
    //   2051	2059	1328	java/lang/IllegalAccessException
    //   2062	2172	1328	java/lang/IllegalAccessException
    //   2175	2182	1328	java/lang/IllegalAccessException
    //   2185	2295	1328	java/lang/IllegalAccessException
    //   2297	2326	1328	java/lang/IllegalAccessException
    //   2331	2338	1328	java/lang/IllegalAccessException
    //   2345	2373	1328	java/lang/IllegalAccessException
    //   215	412	1529	java/lang/NoSuchFieldException
    //   422	462	1529	java/lang/NoSuchFieldException
    //   473	516	1529	java/lang/NoSuchFieldException
    //   541	610	1529	java/lang/NoSuchFieldException
    //   610	619	1529	java/lang/NoSuchFieldException
    //   622	642	1529	java/lang/NoSuchFieldException
    //   651	685	1529	java/lang/NoSuchFieldException
    //   698	803	1529	java/lang/NoSuchFieldException
    //   803	817	1529	java/lang/NoSuchFieldException
    //   820	851	1529	java/lang/NoSuchFieldException
    //   858	886	1529	java/lang/NoSuchFieldException
    //   886	897	1529	java/lang/NoSuchFieldException
    //   910	944	1529	java/lang/NoSuchFieldException
    //   957	1063	1529	java/lang/NoSuchFieldException
    //   1063	1078	1529	java/lang/NoSuchFieldException
    //   1085	1116	1529	java/lang/NoSuchFieldException
    //   1201	1232	1529	java/lang/NoSuchFieldException
    //   1317	1325	1529	java/lang/NoSuchFieldException
    //   1410	1516	1529	java/lang/NoSuchFieldException
    //   1519	1526	1529	java/lang/NoSuchFieldException
    //   1611	1643	1529	java/lang/NoSuchFieldException
    //   1650	1678	1529	java/lang/NoSuchFieldException
    //   1678	1689	1529	java/lang/NoSuchFieldException
    //   1702	1736	1529	java/lang/NoSuchFieldException
    //   1749	1838	1529	java/lang/NoSuchFieldException
    //   1845	1877	1529	java/lang/NoSuchFieldException
    //   1962	1994	1529	java/lang/NoSuchFieldException
    //   2051	2059	1529	java/lang/NoSuchFieldException
    //   2062	2172	1529	java/lang/NoSuchFieldException
    //   2175	2182	1529	java/lang/NoSuchFieldException
    //   2185	2295	1529	java/lang/NoSuchFieldException
    //   2297	2326	1529	java/lang/NoSuchFieldException
    //   2331	2338	1529	java/lang/NoSuchFieldException
    //   2345	2373	1529	java/lang/NoSuchFieldException
    //   910	944	1646	java/lang/RuntimeException
    //   957	1063	1646	java/lang/RuntimeException
    //   1063	1078	1646	java/lang/RuntimeException
    //   1611	1643	1646	java/lang/RuntimeException
    //   1845	1877	1646	java/lang/RuntimeException
    //   1962	1994	1646	java/lang/RuntimeException
    //   2051	2059	1646	java/lang/RuntimeException
    //   2062	2172	1646	java/lang/RuntimeException
    //   2175	2182	1646	java/lang/RuntimeException
    //   215	412	1880	java/lang/ClassNotFoundException
    //   422	462	1880	java/lang/ClassNotFoundException
    //   473	516	1880	java/lang/ClassNotFoundException
    //   541	610	1880	java/lang/ClassNotFoundException
    //   610	619	1880	java/lang/ClassNotFoundException
    //   622	642	1880	java/lang/ClassNotFoundException
    //   651	685	1880	java/lang/ClassNotFoundException
    //   698	803	1880	java/lang/ClassNotFoundException
    //   803	817	1880	java/lang/ClassNotFoundException
    //   820	851	1880	java/lang/ClassNotFoundException
    //   858	886	1880	java/lang/ClassNotFoundException
    //   886	897	1880	java/lang/ClassNotFoundException
    //   910	944	1880	java/lang/ClassNotFoundException
    //   957	1063	1880	java/lang/ClassNotFoundException
    //   1063	1078	1880	java/lang/ClassNotFoundException
    //   1085	1116	1880	java/lang/ClassNotFoundException
    //   1201	1232	1880	java/lang/ClassNotFoundException
    //   1317	1325	1880	java/lang/ClassNotFoundException
    //   1410	1516	1880	java/lang/ClassNotFoundException
    //   1519	1526	1880	java/lang/ClassNotFoundException
    //   1611	1643	1880	java/lang/ClassNotFoundException
    //   1650	1678	1880	java/lang/ClassNotFoundException
    //   1678	1689	1880	java/lang/ClassNotFoundException
    //   1702	1736	1880	java/lang/ClassNotFoundException
    //   1749	1838	1880	java/lang/ClassNotFoundException
    //   1845	1877	1880	java/lang/ClassNotFoundException
    //   1962	1994	1880	java/lang/ClassNotFoundException
    //   2051	2059	1880	java/lang/ClassNotFoundException
    //   2062	2172	1880	java/lang/ClassNotFoundException
    //   2175	2182	1880	java/lang/ClassNotFoundException
    //   2185	2295	1880	java/lang/ClassNotFoundException
    //   2297	2326	1880	java/lang/ClassNotFoundException
    //   2331	2338	1880	java/lang/ClassNotFoundException
    //   2345	2373	1880	java/lang/ClassNotFoundException
    //   215	412	1997	finally
    //   422	462	1997	finally
    //   473	516	1997	finally
    //   541	610	1997	finally
    //   610	619	1997	finally
    //   622	642	1997	finally
    //   651	685	1997	finally
    //   698	803	1997	finally
    //   803	817	1997	finally
    //   820	851	1997	finally
    //   858	886	1997	finally
    //   886	897	1997	finally
    //   910	944	1997	finally
    //   957	1063	1997	finally
    //   1063	1078	1997	finally
    //   1085	1116	1997	finally
    //   1121	1149	1997	finally
    //   1201	1232	1997	finally
    //   1237	1265	1997	finally
    //   1317	1325	1997	finally
    //   1330	1358	1997	finally
    //   1410	1516	1997	finally
    //   1519	1526	1997	finally
    //   1531	1559	1997	finally
    //   1611	1643	1997	finally
    //   1650	1678	1997	finally
    //   1678	1689	1997	finally
    //   1702	1736	1997	finally
    //   1749	1838	1997	finally
    //   1845	1877	1997	finally
    //   1882	1910	1997	finally
    //   1962	1994	1997	finally
    //   2051	2059	1997	finally
    //   2062	2172	1997	finally
    //   2175	2182	1997	finally
    //   2185	2295	1997	finally
    //   2297	2326	1997	finally
    //   2331	2338	1997	finally
    //   2345	2373	1997	finally
    //   2432	2460	1997	finally
    //   1702	1736	2341	java/lang/RuntimeException
    //   1749	1838	2341	java/lang/RuntimeException
    //   2185	2295	2341	java/lang/RuntimeException
    //   2331	2338	2341	java/lang/RuntimeException
    //   215	412	2430	java/lang/RuntimeException
    //   422	462	2430	java/lang/RuntimeException
    //   473	516	2430	java/lang/RuntimeException
    //   541	610	2430	java/lang/RuntimeException
    //   610	619	2430	java/lang/RuntimeException
    //   622	642	2430	java/lang/RuntimeException
    //   858	886	2430	java/lang/RuntimeException
    //   886	897	2430	java/lang/RuntimeException
    //   1650	1678	2430	java/lang/RuntimeException
    //   1678	1689	2430	java/lang/RuntimeException
    //   2297	2326	2430	java/lang/RuntimeException
    //   2345	2373	2430	java/lang/RuntimeException
    //   3	32	2512	finally
    //   38	74	2512	finally
    //   74	82	2512	finally
    //   87	92	2512	finally
    //   92	115	2512	finally
    //   120	174	2512	finally
    //   179	209	2512	finally
    //   1149	1189	2512	finally
    //   1189	1198	2512	finally
    //   1265	1305	2512	finally
    //   1305	1314	2512	finally
    //   1358	1398	2512	finally
    //   1398	1407	2512	finally
    //   1559	1599	2512	finally
    //   1599	1608	2512	finally
    //   1910	1950	2512	finally
    //   1950	1959	2512	finally
    //   1999	2039	2512	finally
    //   2039	2048	2512	finally
    //   2378	2418	2512	finally
    //   2418	2427	2512	finally
    //   2460	2500	2512	finally
    //   2500	2509	2512	finally
  }
  
  private static int getSoftMaxSamples(int paramInt)
  {
    switch (paramInt)
    {
    case 11: 
    default: 
      return 407040;
    case 1: 
      return 129600;
    case 6: 
      return 307200;
    case 16: 
      return 480000;
    case 21: 
      return 921600;
    case 26: 
      return 2073600;
    case 28: 
      return 8294400;
    }
    return 8847360;
  }
  
  /* Error */
  public static HashMap<Integer, TPCodecCapability.TPVCodecMaxCapability> getVCodecSWMaxCapabilityMap()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: iconst_2
    //   4: ldc 32
    //   6: ldc_w 689
    //   9: invokestatic 238	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;Ljava/lang/String;)V
    //   12: getstatic 242	com/tencent/thumbplayer/core/common/TPCodecUtils:mIsFFmpegCapGot	Z
    //   15: ifeq +14 -> 29
    //   18: getstatic 265	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecSwCapabilityMap	Ljava/util/HashMap;
    //   21: astore 4
    //   23: ldc 2
    //   25: monitorexit
    //   26: aload 4
    //   28: areturn
    //   29: invokestatic 691	com/tencent/thumbplayer/core/common/TPCodecUtils:getHevcSWDecodeLevel	()I
    //   32: istore_0
    //   33: iload_0
    //   34: invokestatic 693	com/tencent/thumbplayer/core/common/TPCodecUtils:getSoftMaxSamples	(I)I
    //   37: istore_1
    //   38: invokestatic 695	com/tencent/thumbplayer/core/common/TPCodecUtils:getAvs3SWDecodeLevel	()I
    //   41: istore_2
    //   42: iload_2
    //   43: invokestatic 693	com/tencent/thumbplayer/core/common/TPCodecUtils:getSoftMaxSamples	(I)I
    //   46: istore_3
    //   47: iconst_2
    //   48: new 285	java/lang/StringBuilder
    //   51: dup
    //   52: invokespecial 286	java/lang/StringBuilder:<init>	()V
    //   55: ldc_w 697
    //   58: invokevirtual 292	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: iload_0
    //   62: invokevirtual 334	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   65: ldc_w 699
    //   68: invokevirtual 292	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: iload_2
    //   72: invokevirtual 334	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   75: invokevirtual 298	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   78: invokestatic 563	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   81: getstatic 255	com/tencent/thumbplayer/core/common/TPCodecUtils:mAVCSWMaxCapability	Lcom/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability;
    //   84: iload_1
    //   85: putfield 607	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability:maxLumaSamples	I
    //   88: getstatic 255	com/tencent/thumbplayer/core/common/TPCodecUtils:mAVCSWMaxCapability	Lcom/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability;
    //   91: bipush 64
    //   93: putfield 610	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability:maxProfile	I
    //   96: getstatic 255	com/tencent/thumbplayer/core/common/TPCodecUtils:mAVCSWMaxCapability	Lcom/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability;
    //   99: ldc_w 700
    //   102: putfield 613	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability:maxLevel	I
    //   105: getstatic 265	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecSwCapabilityMap	Ljava/util/HashMap;
    //   108: bipush 26
    //   110: invokestatic 218	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   113: getstatic 255	com/tencent/thumbplayer/core/common/TPCodecUtils:mAVCSWMaxCapability	Lcom/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability;
    //   116: invokevirtual 222	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   119: pop
    //   120: getstatic 123	com/tencent/thumbplayer/core/common/TPCodecUtils:mffmpegVCodecCapList	Ljava/util/ArrayList;
    //   123: ldc_w 472
    //   126: invokevirtual 591	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   129: pop
    //   130: getstatic 257	com/tencent/thumbplayer/core/common/TPCodecUtils:mHEVCSWMaxCapability	Lcom/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability;
    //   133: iload_1
    //   134: putfield 607	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability:maxLumaSamples	I
    //   137: getstatic 257	com/tencent/thumbplayer/core/common/TPCodecUtils:mHEVCSWMaxCapability	Lcom/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability;
    //   140: iconst_2
    //   141: putfield 610	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability:maxProfile	I
    //   144: getstatic 257	com/tencent/thumbplayer/core/common/TPCodecUtils:mHEVCSWMaxCapability	Lcom/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability;
    //   147: ldc_w 701
    //   150: putfield 613	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability:maxLevel	I
    //   153: getstatic 265	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecSwCapabilityMap	Ljava/util/HashMap;
    //   156: sipush 172
    //   159: invokestatic 218	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   162: getstatic 257	com/tencent/thumbplayer/core/common/TPCodecUtils:mHEVCSWMaxCapability	Lcom/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability;
    //   165: invokevirtual 222	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   168: pop
    //   169: getstatic 123	com/tencent/thumbplayer/core/common/TPCodecUtils:mffmpegVCodecCapList	Ljava/util/ArrayList;
    //   172: ldc_w 437
    //   175: invokevirtual 591	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   178: pop
    //   179: getstatic 259	com/tencent/thumbplayer/core/common/TPCodecUtils:mVP9SWMaxCapability	Lcom/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability;
    //   182: iload_1
    //   183: putfield 607	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability:maxLumaSamples	I
    //   186: getstatic 259	com/tencent/thumbplayer/core/common/TPCodecUtils:mVP9SWMaxCapability	Lcom/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability;
    //   189: bipush 8
    //   191: putfield 610	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability:maxProfile	I
    //   194: getstatic 259	com/tencent/thumbplayer/core/common/TPCodecUtils:mVP9SWMaxCapability	Lcom/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability;
    //   197: sipush 8192
    //   200: putfield 613	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability:maxLevel	I
    //   203: getstatic 265	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecSwCapabilityMap	Ljava/util/HashMap;
    //   206: sipush 166
    //   209: invokestatic 218	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   212: getstatic 259	com/tencent/thumbplayer/core/common/TPCodecUtils:mVP9SWMaxCapability	Lcom/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability;
    //   215: invokevirtual 222	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   218: pop
    //   219: getstatic 123	com/tencent/thumbplayer/core/common/TPCodecUtils:mffmpegVCodecCapList	Ljava/util/ArrayList;
    //   222: ldc_w 662
    //   225: invokevirtual 591	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   228: pop
    //   229: getstatic 261	com/tencent/thumbplayer/core/common/TPCodecUtils:mAVS3WMaxCapability	Lcom/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability;
    //   232: iload_3
    //   233: putfield 607	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability:maxLumaSamples	I
    //   236: getstatic 261	com/tencent/thumbplayer/core/common/TPCodecUtils:mAVS3WMaxCapability	Lcom/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability;
    //   239: iconst_0
    //   240: putfield 610	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability:maxProfile	I
    //   243: getstatic 261	com/tencent/thumbplayer/core/common/TPCodecUtils:mAVS3WMaxCapability	Lcom/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability;
    //   246: iconst_0
    //   247: putfield 613	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability:maxLevel	I
    //   250: getstatic 265	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecSwCapabilityMap	Ljava/util/HashMap;
    //   253: sipush 192
    //   256: invokestatic 218	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   259: getstatic 261	com/tencent/thumbplayer/core/common/TPCodecUtils:mAVS3WMaxCapability	Lcom/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability;
    //   262: invokevirtual 222	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   265: pop
    //   266: iconst_2
    //   267: new 285	java/lang/StringBuilder
    //   270: dup
    //   271: invokespecial 286	java/lang/StringBuilder:<init>	()V
    //   274: ldc_w 703
    //   277: invokevirtual 292	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   280: iload_1
    //   281: invokevirtual 334	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   284: ldc_w 705
    //   287: invokevirtual 292	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   290: iload_3
    //   291: invokevirtual 334	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   294: invokevirtual 298	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   297: invokestatic 563	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   300: iconst_1
    //   301: putstatic 242	com/tencent/thumbplayer/core/common/TPCodecUtils:mIsFFmpegCapGot	Z
    //   304: getstatic 265	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecSwCapabilityMap	Ljava/util/HashMap;
    //   307: astore 4
    //   309: goto -286 -> 23
    //   312: astore 4
    //   314: iconst_4
    //   315: ldc 32
    //   317: ldc_w 707
    //   320: invokestatic 238	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;Ljava/lang/String;)V
    //   323: aconst_null
    //   324: astore 4
    //   326: goto -303 -> 23
    //   329: astore 4
    //   331: ldc 2
    //   333: monitorexit
    //   334: aload 4
    //   336: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   32	30	0	i	int
    //   37	244	1	j	int
    //   41	31	2	k	int
    //   46	245	3	m	int
    //   21	287	4	localHashMap	HashMap
    //   312	1	4	localException	Exception
    //   324	1	4	localObject1	Object
    //   329	6	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   29	309	312	java/lang/Exception
    //   3	23	329	finally
    //   29	309	329	finally
    //   314	323	329	finally
  }
  
  /* Error */
  public static void init(Context paramContext, boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: iconst_2
    //   4: ldc 32
    //   6: new 285	java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial 286	java/lang/StringBuilder:<init>	()V
    //   13: ldc_w 711
    //   16: invokevirtual 292	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   19: iload_1
    //   20: invokevirtual 714	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   23: invokevirtual 298	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   26: invokestatic 238	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;Ljava/lang/String;)V
    //   29: aload_0
    //   30: invokevirtual 720	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   33: putstatic 102	com/tencent/thumbplayer/core/common/TPCodecUtils:mApplicationContext	Landroid/content/Context;
    //   36: iload_1
    //   37: putstatic 104	com/tencent/thumbplayer/core/common/TPCodecUtils:mIsLocalCacheEnabled	Z
    //   40: iload_1
    //   41: ifeq +37 -> 78
    //   44: getstatic 141	com/tencent/thumbplayer/core/common/TPCodecUtils:mCapabilityVersionKey	Ljava/lang/String;
    //   47: invokestatic 722	com/tencent/thumbplayer/core/common/TPCodecUtils:getCachedStringInfo	(Ljava/lang/String;)Ljava/lang/String;
    //   50: astore_0
    //   51: getstatic 112	com/tencent/thumbplayer/core/common/TPCodecUtils:mCapabilityVersion	Ljava/lang/String;
    //   54: aload_0
    //   55: invokevirtual 725	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   58: ifne +42 -> 100
    //   61: iconst_1
    //   62: putstatic 106	com/tencent/thumbplayer/core/common/TPCodecUtils:mNeedToReprobeDecoderCapability	Z
    //   65: iconst_1
    //   66: putstatic 108	com/tencent/thumbplayer/core/common/TPCodecUtils:mNeedToReprobeHDRCapability	Z
    //   69: iconst_2
    //   70: ldc 32
    //   72: ldc_w 727
    //   75: invokestatic 238	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;Ljava/lang/String;)V
    //   78: invokestatic 729	com/tencent/thumbplayer/core/common/TPCodecUtils:getDecoderMaxCapabilityMapAsync	()V
    //   81: getstatic 104	com/tencent/thumbplayer/core/common/TPCodecUtils:mIsLocalCacheEnabled	Z
    //   84: ifeq +12 -> 96
    //   87: getstatic 141	com/tencent/thumbplayer/core/common/TPCodecUtils:mCapabilityVersionKey	Ljava/lang/String;
    //   90: getstatic 112	com/tencent/thumbplayer/core/common/TPCodecUtils:mCapabilityVersion	Ljava/lang/String;
    //   93: invokestatic 731	com/tencent/thumbplayer/core/common/TPCodecUtils:cacheStringInfo	(Ljava/lang/String;Ljava/lang/String;)V
    //   96: ldc 2
    //   98: monitorexit
    //   99: return
    //   100: iconst_0
    //   101: putstatic 106	com/tencent/thumbplayer/core/common/TPCodecUtils:mNeedToReprobeDecoderCapability	Z
    //   104: iconst_0
    //   105: putstatic 108	com/tencent/thumbplayer/core/common/TPCodecUtils:mNeedToReprobeHDRCapability	Z
    //   108: iconst_2
    //   109: ldc 32
    //   111: ldc_w 733
    //   114: invokestatic 238	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;Ljava/lang/String;)V
    //   117: goto -39 -> 78
    //   120: astore_0
    //   121: ldc 2
    //   123: monitorexit
    //   124: aload_0
    //   125: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	126	0	paramContext	Context
    //   0	126	1	paramBoolean	boolean
    // Exception table:
    //   from	to	target	type
    //   3	40	120	finally
    //   44	78	120	finally
    //   78	96	120	finally
    //   100	117	120	finally
  }
  
  private static void initDolbyInvariableParams()
  {
    boolean bool1 = isHwDDPlusSupported_V2();
    boolean bool2 = isHwDolbyDSSupported();
    if ((!bool2) && (!bool1)) {
      sDolbyLevel = 0;
    }
    do
    {
      return;
      if ((bool1) && (!bool2))
      {
        sDolbyLevel = 1;
        return;
      }
      if ((!bool1) && (bool2))
      {
        sDolbyLevel = 10;
        return;
      }
    } while ((!bool2) || (!bool1));
    sDolbyLevel = 11;
  }
  
  public static boolean isBlackListForHardwareDec(String paramString)
  {
    if (mIsInBlackListForHardwareDec != -1) {
      return mIsInBlackListForHardwareDec != 0;
    }
    String[] arrayOfString = new String[11];
    arrayOfString[0] = "SM-J7008";
    arrayOfString[1] = "SM-J5008";
    arrayOfString[2] = "TCL i806";
    arrayOfString[3] = "NX511J";
    arrayOfString[4] = "vivo Y11i T";
    arrayOfString[5] = "长虹智能电视";
    arrayOfString[6] = "MI 1S";
    arrayOfString[7] = "SP9832A";
    arrayOfString[8] = "SP9830A";
    arrayOfString[9] = "VOTO GT17";
    arrayOfString[10] = "EVA-AL10";
    mIsInBlackListForHardwareDec = 0;
    for (;;)
    {
      int i;
      try
      {
        String str = Build.MODEL;
        if (!TextUtils.isEmpty(str))
        {
          int j = arrayOfString.length;
          i = 0;
          if (i < j)
          {
            if (!arrayOfString[i].equals(str)) {
              break label247;
            }
            TPNativeLog.printLog(2, "TPCodecUtils", "isBlackListForHardwareDec, deviceName: " + str);
            mIsInBlackListForHardwareDec = 1;
            return true;
          }
        }
        if ((TextUtils.isEmpty(paramString)) || (!"video/hevc".equals(paramString)) || (Build.VERSION.SDK_INT < 14) || (TextUtils.isEmpty(str)) || ((!"PRO 7 Plus".equals(str)) && (!"PRO 7-H".equals(str)) && (!"PRO+7+Plus".equals(str)))) {
          break;
        }
        mIsInBlackListForHardwareDec = 1;
        return true;
      }
      catch (Exception paramString)
      {
        TPNativeLog.printLog(4, "TPCodecUtils", "isBlackListForHardwareDec exception");
        return false;
      }
      label247:
      i += 1;
    }
  }
  
  public static boolean isBlackListForHdr10(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    try
    {
      String[] arrayOfString;
      String str;
      int i;
      if (!TextUtils.isEmpty(paramString))
      {
        arrayOfString = paramString.split(",");
        str = Build.MODEL;
        TPNativeLog.printLog(4, "TPCodecUtils", "hdr10 黑名单：" + paramString);
        i = 0;
      }
      for (;;)
      {
        bool1 = bool2;
        if (i < arrayOfString.length)
        {
          bool1 = str.equalsIgnoreCase(arrayOfString[i]);
          if (bool1) {
            bool1 = true;
          }
        }
        else
        {
          return bool1;
        }
        i += 1;
      }
      return false;
    }
    catch (Exception paramString)
    {
      TPNativeLog.printLog(4, "TPCodecUtils", "isBlackListForHdr10：" + paramString.toString());
    }
  }
  
  public static boolean isBlackListForHdr10Enhance(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    try
    {
      String[] arrayOfString;
      String str;
      int i;
      if (!TextUtils.isEmpty(paramString))
      {
        arrayOfString = paramString.split(",");
        str = Build.MODEL;
        TPNativeLog.printLog(2, "TPCodecUtils", "hdr10 黑名单：" + paramString);
        i = 0;
      }
      for (;;)
      {
        bool1 = bool2;
        if (i < arrayOfString.length)
        {
          bool1 = str.equalsIgnoreCase(arrayOfString[i]);
          if (bool1) {
            bool1 = true;
          }
        }
        else
        {
          return bool1;
        }
        i += 1;
      }
      return false;
    }
    catch (Exception paramString)
    {
      TPNativeLog.printLog(4, "TPCodecUtils", "isBlackListForHdr10：" + paramString.toString());
    }
  }
  
  public static boolean isBlackListForVidHdr10Enhance(String paramString1, String paramString2)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    try
    {
      String[] arrayOfString;
      int i;
      if (!TextUtils.isEmpty(paramString1))
      {
        bool1 = bool2;
        if (!TextUtils.isEmpty(paramString2))
        {
          arrayOfString = paramString2.split(",");
          TPNativeLog.printLog(2, "TPCodecUtils", "hdr10 vid：" + paramString2);
          i = 0;
        }
      }
      for (;;)
      {
        bool1 = bool2;
        if (i < arrayOfString.length)
        {
          bool1 = paramString1.equalsIgnoreCase(arrayOfString[i]);
          if (bool1) {
            bool1 = true;
          }
        }
        else
        {
          return bool1;
        }
        i += 1;
      }
      return false;
    }
    catch (Exception paramString1)
    {
      TPNativeLog.printLog(4, "TPCodecUtils", "isBlackListForHdr10：" + paramString1.getMessage());
    }
  }
  
  public static boolean isHDR10PLUSSupport()
  {
    if (Build.VERSION.SDK_INT < 29) {
      return false;
    }
    for (;;)
    {
      int i;
      try
      {
        int m = MediaCodecList.getCodecCount();
        i = 0;
        if (i < m)
        {
          MediaCodecInfo localMediaCodecInfo = MediaCodecList.getCodecInfoAt(i);
          if (localMediaCodecInfo.isEncoder()) {
            break label180;
          }
          String[] arrayOfString = localMediaCodecInfo.getSupportedTypes();
          int n = arrayOfString.length;
          int j = 0;
          if (j >= n) {
            break label180;
          }
          if (arrayOfString[j].equalsIgnoreCase("video/hevc"))
          {
            MediaCodecInfo.CodecProfileLevel[] arrayOfCodecProfileLevel = localMediaCodecInfo.getCapabilitiesForType("video/hevc").profileLevels;
            int i1 = arrayOfCodecProfileLevel.length;
            int k = 0;
            if (k < i1)
            {
              if (arrayOfCodecProfileLevel[k].profile == 8192)
              {
                TPNativeLog.printLog(2, "TPCodecUtils", "isHDR10PLUSSupport support HDR10PLUS");
                return true;
              }
              k += 1;
              continue;
            }
          }
          j += 1;
          continue;
        }
        TPNativeLog.printLog(2, "TPCodecUtils", "isHDR10PLUSSupport not support");
      }
      catch (Throwable localThrowable)
      {
        TPNativeLog.printLog(4, "TPCodecUtils", "isHDR10PLUSSupport " + localThrowable.toString());
        return false;
      }
      return false;
      label180:
      i += 1;
    }
  }
  
  public static boolean isHDR10Support()
  {
    if (Build.VERSION.SDK_INT < 24) {
      return false;
    }
    for (;;)
    {
      int i;
      try
      {
        int m = MediaCodecList.getCodecCount();
        i = 0;
        if (i < m)
        {
          MediaCodecInfo localMediaCodecInfo = MediaCodecList.getCodecInfoAt(i);
          if (localMediaCodecInfo.isEncoder()) {
            break label180;
          }
          String[] arrayOfString = localMediaCodecInfo.getSupportedTypes();
          int n = arrayOfString.length;
          int j = 0;
          if (j >= n) {
            break label180;
          }
          if (arrayOfString[j].equalsIgnoreCase("video/hevc"))
          {
            MediaCodecInfo.CodecProfileLevel[] arrayOfCodecProfileLevel = localMediaCodecInfo.getCapabilitiesForType("video/hevc").profileLevels;
            int i1 = arrayOfCodecProfileLevel.length;
            int k = 0;
            if (k < i1)
            {
              if (arrayOfCodecProfileLevel[k].profile == 4096)
              {
                TPNativeLog.printLog(2, "TPCodecUtils", "isHDR10Support support HDR10");
                return true;
              }
              k += 1;
              continue;
            }
          }
          j += 1;
          continue;
        }
        TPNativeLog.printLog(2, "TPCodecUtils", "isHDR10Support not support");
      }
      catch (Throwable localThrowable)
      {
        TPNativeLog.printLog(4, "TPCodecUtils", "isHDR10Support " + localThrowable.toString());
        return false;
      }
      return false;
      label180:
      i += 1;
    }
  }
  
  public static boolean isHDRDolbyVisionSupport(int paramInt1, int paramInt2)
  {
    if (Build.VERSION.SDK_INT < 24) {
      return false;
    }
    for (;;)
    {
      int i;
      try
      {
        int m = MediaCodecList.getCodecCount();
        i = 0;
        if (i < m)
        {
          MediaCodecInfo localMediaCodecInfo = MediaCodecList.getCodecInfoAt(i);
          if (localMediaCodecInfo.isEncoder()) {
            break label216;
          }
          String[] arrayOfString = localMediaCodecInfo.getSupportedTypes();
          int n = arrayOfString.length;
          int j = 0;
          if (j >= n) {
            break label216;
          }
          if (arrayOfString[j].equalsIgnoreCase("video/dolby-vision"))
          {
            MediaCodecInfo.CodecProfileLevel[] arrayOfCodecProfileLevel = localMediaCodecInfo.getCapabilitiesForType("video/dolby-vision").profileLevels;
            int i1 = arrayOfCodecProfileLevel.length;
            int k = 0;
            if (k < i1)
            {
              MediaCodecInfo.CodecProfileLevel localCodecProfileLevel = arrayOfCodecProfileLevel[k];
              if ((localCodecProfileLevel.profile >= 1) && (localCodecProfileLevel.profile >= paramInt1) && (localCodecProfileLevel.level >= 1) && (localCodecProfileLevel.level >= paramInt2))
              {
                TPNativeLog.printLog(2, "TPCodecUtils", "isHDRDolbyVisionSupport support dolbyvision");
                return true;
              }
              k += 1;
              continue;
            }
          }
          j += 1;
          continue;
        }
        TPNativeLog.printLog(2, "TPCodecUtils", "isHDRDolbyVisionSupport not support");
      }
      catch (Throwable localThrowable)
      {
        TPNativeLog.printLog(4, "TPCodecUtils", "isHDRDolbyVisionSupport " + localThrowable.toString());
        return false;
      }
      return false;
      label216:
      i += 1;
    }
  }
  
  public static boolean isHDRHLGSupport(int paramInt1, int paramInt2)
  {
    return false;
  }
  
  public static boolean isHDRsupport(int paramInt1, int paramInt2, int paramInt3)
  {
    boolean bool6 = false;
    boolean bool2 = false;
    boolean bool4 = false;
    boolean bool3 = false;
    boolean bool5 = false;
    boolean bool1 = false;
    switch (paramInt1)
    {
    default: 
      bool4 = false;
      return bool4;
    case 0: 
      if (Build.VERSION.SDK_INT < 24) {
        return false;
      }
      break;
    case 1: 
      if (Build.VERSION.SDK_INT < 29) {
        return false;
      }
      break;
    case 2: 
      if (Build.VERSION.SDK_INT < 24) {
        return false;
      }
      break;
    case 3: 
      return false;
    }
    Object localObject;
    try
    {
      if ((mIsLocalCacheEnabled) && (!mNeedToReprobeHDRCapability))
      {
        String str = "";
        switch (paramInt1)
        {
        case 0: 
        case 1: 
        case 2: 
        case 3: 
          for (;;)
          {
            localObject = getCachedStringInfo(str);
            TPNativeLog.printLog(2, "TPCodecUtils", "get local cached hdrtype key:" + str + " hdr cap:" + (String)localObject);
            if (localObject == null) {
              break label244;
            }
            if (!((String)localObject).equals(mSupportValue)) {
              break;
            }
            return true;
            str = mHDR10CapabilityKey;
            continue;
            str = mHDR10PLUSCapabilityKey;
            continue;
            str = mHDRDOLBYVISIONCapabilityKey;
            continue;
            str = mHDRHLGCapabilityKey;
          }
          return false;
        }
      }
    }
    catch (Exception localException)
    {
      TPNativeLog.printLog(4, "TPCodecUtils", "get local cached hdr capability failed");
    }
    for (;;)
    {
      label244:
      int i;
      int k;
      try
      {
        int m = MediaCodecList.getCodecCount();
        i = 0;
        bool6 = bool3;
        bool5 = bool1;
        bool4 = bool2;
        if (i < m)
        {
          bool4 = bool3;
          bool5 = bool1;
          bool6 = bool2;
          localMediaCodecInfo = MediaCodecList.getCodecInfoAt(i);
          bool4 = bool3;
          bool5 = bool1;
          bool6 = bool2;
          if (localMediaCodecInfo.isEncoder())
          {
            bool4 = bool3;
            bool5 = bool1;
            bool6 = bool2;
            break label1013;
          }
          bool4 = bool3;
          bool5 = bool1;
          bool6 = bool2;
          localObject = localMediaCodecInfo.getSupportedTypes();
          bool4 = bool3;
          bool5 = bool1;
          bool6 = bool2;
          int n = localObject.length;
          j = 0;
          bool4 = bool3;
          bool5 = bool1;
          bool6 = bool2;
          if (j >= n) {
            break label1013;
          }
          arrayOfCodecProfileLevel = localObject[j];
          bool4 = bool3;
          bool5 = bool1;
          bool6 = bool2;
          if (arrayOfCodecProfileLevel.equalsIgnoreCase("video/hevc"))
          {
            bool4 = bool3;
            bool5 = bool1;
            bool6 = bool2;
            arrayOfCodecProfileLevel = localMediaCodecInfo.getCapabilitiesForType("video/hevc").profileLevels;
            bool4 = bool3;
            bool5 = bool1;
            bool6 = bool2;
            i1 = arrayOfCodecProfileLevel.length;
            bool4 = bool3;
            k = 0;
            bool3 = bool2;
            bool2 = bool4;
            if (k < i1) {
              localCodecProfileLevel = arrayOfCodecProfileLevel[k];
            }
          }
        }
      }
      catch (Throwable localThrowable1)
      {
        try
        {
          MediaCodecInfo localMediaCodecInfo;
          int j;
          MediaCodecInfo.CodecProfileLevel[] arrayOfCodecProfileLevel;
          int i1;
          MediaCodecInfo.CodecProfileLevel localCodecProfileLevel;
          if (localCodecProfileLevel.profile >= 1)
          {
            bool4 = bool1;
            if (localCodecProfileLevel.profile >= paramInt2)
            {
              bool4 = bool1;
              if (localCodecProfileLevel.level >= 1)
              {
                bool4 = bool1;
                if (localCodecProfileLevel.level >= paramInt3)
                {
                  TPNativeLog.printLog(2, "TPCodecUtils", "support dolbyvision");
                  bool4 = true;
                }
              }
            }
          }
          k += 1;
          bool1 = bool4;
        }
        catch (Throwable localThrowable3)
        {
          continue;
        }
        localThrowable1 = localThrowable1;
        bool2 = bool6;
        bool1 = bool5;
        bool3 = bool4;
        TPNativeLog.printLog(4, "TPCodecUtils", "isHDR10Support " + localThrowable1.toString());
        bool4 = bool2;
        bool5 = bool1;
        bool6 = bool3;
        if (mIsLocalCacheEnabled)
        {
          if (bool4)
          {
            cacheStringInfo(mHDR10CapabilityKey, mSupportValue);
            if (!bool6) {
              break label950;
            }
            cacheStringInfo(mHDR10PLUSCapabilityKey, mSupportValue);
            if (!bool5) {
              break label962;
            }
            cacheStringInfo(mHDRDOLBYVISIONCapabilityKey, mSupportValue);
            cacheStringInfo(mHDRHLGCapabilityKey, mUnsupportValue);
            TPNativeLog.printLog(2, "TPCodecUtils", "cached hdr cap done isHDR10Support:" + bool4 + " isHDR10PLUSSupport:" + bool6 + " isHDRDOLBYVISIONSupport:" + bool5 + " isHDRHLGSupport:" + false);
          }
        }
        else
        {
          mNeedToReprobeHDRCapability = false;
          switch (paramInt1)
          {
          }
        }
      }
      try
      {
        if (localCodecProfileLevel.profile == 4096)
        {
          TPNativeLog.printLog(2, "TPCodecUtils", "support HDR10");
          bool5 = true;
          bool4 = bool2;
        }
        else
        {
          bool4 = bool2;
          bool5 = bool3;
          if (localCodecProfileLevel.profile == 8192)
          {
            TPNativeLog.printLog(2, "TPCodecUtils", "support HDR10PLUS");
            bool4 = true;
            bool5 = bool3;
          }
        }
      }
      catch (Throwable localThrowable2)
      {
        bool4 = bool3;
        bool3 = bool2;
        bool2 = bool4;
        continue;
        continue;
        continue;
      }
      bool4 = bool2;
      bool2 = bool3;
      bool3 = bool4;
      j += 1;
      continue;
      bool4 = bool3;
      bool5 = bool1;
      bool6 = bool2;
      if (arrayOfCodecProfileLevel.equalsIgnoreCase("video/dolby-vision"))
      {
        bool4 = bool3;
        bool5 = bool1;
        bool6 = bool2;
        arrayOfCodecProfileLevel = localMediaCodecInfo.getCapabilitiesForType("video/dolby-vision").profileLevels;
        bool4 = bool3;
        bool5 = bool1;
        bool6 = bool2;
        i1 = arrayOfCodecProfileLevel.length;
        k = 0;
        if (k < i1)
        {
          localCodecProfileLevel = arrayOfCodecProfileLevel[k];
          bool4 = bool1;
          return false;
          cacheStringInfo(mHDR10CapabilityKey, mUnsupportValue);
          continue;
          label950:
          cacheStringInfo(mHDR10PLUSCapabilityKey, mUnsupportValue);
          continue;
          label962:
          cacheStringInfo(mHDRDOLBYVISIONCapabilityKey, mUnsupportValue);
          continue;
          return bool6;
          return bool5;
          return false;
        }
      }
      break;
      label1013:
      i += 1;
      bool3 = bool4;
      bool1 = bool5;
      bool2 = bool6;
      continue;
      k += 1;
      bool2 = bool4;
      bool3 = bool5;
    }
  }
  
  public static boolean isHwDDPlusSupported()
  {
    if (sIsDDPInit) {
      return sIsDDPSup;
    }
    if (isBlackListForHardwareDec(null))
    {
      sIsDDPInit = true;
      sIsDDPSup = false;
      return sIsDDPSup;
    }
    for (;;)
    {
      try
      {
        localObject1 = Class.forName("android.media.MediaCodecList");
        localObject2 = ((Class)localObject1).getDeclaredMethod("getCodecCount", new Class[0]);
        localObject1 = ((Class)localObject1).getDeclaredMethod("getCodecInfoAt", new Class[] { Integer.TYPE });
        localMethod = Class.forName("android.media.MediaCodecInfo").getDeclaredMethod("getSupportedTypes", new Class[0]);
        int k = ((Integer)((Method)localObject2).invoke(null, new Object[0])).intValue();
        i = 0;
        bool1 = false;
        if (i >= k) {
          continue;
        }
      }
      catch (Exception localException1)
      {
        Object localObject1;
        Object localObject2;
        Method localMethod;
        int i;
        int m;
        int j;
        Object localObject3;
        boolean bool1 = false;
        localException1.printStackTrace();
        continue;
        continue;
      }
      try
      {
        localObject2 = (String[])localMethod.invoke(((Method)localObject1).invoke(null, new Object[] { Integer.valueOf(i) }), new Object[0]);
        m = localObject2.length;
        j = 0;
        if (j >= m) {
          continue;
        }
        localObject3 = localObject2[j];
        if (!"audio/eac3".equals(localObject3))
        {
          boolean bool2 = "audio/ac3".equals(localObject3);
          if (!bool2) {
            continue;
          }
        }
        bool1 = true;
      }
      catch (Exception localException2)
      {
        continue;
        continue;
      }
      if (bool1)
      {
        sIsDDPSup = bool1;
        sIsDDPInit = true;
        return sIsDDPSup;
        j += 1;
      }
      else
      {
        i += 1;
      }
    }
  }
  
  public static boolean isHwDDPlusSupported_V2()
  {
    boolean bool1 = false;
    if (isBlackListForHardwareDec(null))
    {
      sIsDDPSup = false;
      return sIsDDPSup;
    }
    try
    {
      boolean bool2 = isHwSupportDDPlus();
      bool1 = bool2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
    sIsDDPSup = bool1;
    return sIsDDPSup;
  }
  
  public static boolean isHwDolbyDSSupported()
  {
    if (sIsDDSInit)
    {
      if (sIsDDSSup) {
        TPNativeLog.printLog(2, "TPCodecUtils", "dds ha suported " + sIsDDSSup);
      }
      return sIsDDSSup;
    }
    try
    {
      Object localObject1 = Class.forName("android.os.SystemProperties");
      localObject1 = (String)((Class)localObject1).getMethod("get", new Class[] { String.class }).invoke(localObject1, new Object[] { "dolby.ds.state" });
      if ((localObject1 == null) || ((localObject1 != null) && (((String)localObject1).trim().equals(""))))
      {
        bool = false;
        sIsDDSSup = bool;
        sIsDDSInit = true;
        if (sIsDDSSup) {
          TPNativeLog.printLog(2, "TPCodecUtils", "dds ha suported " + sIsDDSSup);
        }
        return sIsDDSSup;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        TPNativeLog.printLog(4, "TPCodecUtils", localException.getMessage());
        Object localObject2 = null;
        continue;
        boolean bool = true;
      }
    }
  }
  
  public static boolean isHwSupportDDPlus()
  {
    if ((mHWCodecCapList != null) && (mHWCodecCapList.size() > 0) && ((mHWCodecCapList.contains("audio/eac3")) || (mHWCodecCapList.contains("audio/ac3")))) {}
    while ((mSoftCodecCapList != null) && (mSoftCodecCapList.size() > 0) && ((mSoftCodecCapList.contains("audio/eac3")) || (mSoftCodecCapList.contains("audio/ac3")))) {
      return true;
    }
    return false;
  }
  
  public static boolean isInMediaCodecWhiteList(String paramString, int paramInt1, int paramInt2)
  {
    boolean bool = true;
    Object localObject = Build.MODEL;
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && (mCodecCap != null) && (mCodecCap.containsKey(localObject)))
    {
      localObject = (Integer)mCodecCap.get(localObject);
      if (TextUtils.equals(paramString, "video/avc")) {
        if ((((Integer)localObject).intValue() & 0x1) != 0) {
          bool = true;
        }
      }
      do
      {
        do
        {
          do
          {
            for (;;)
            {
              return bool;
              bool = false;
            }
            if (!TextUtils.equals(paramString, "video/hevc")) {
              break;
            }
          } while ((((Integer)localObject).intValue() & 0x2) != 0);
          return false;
          if (!TextUtils.equals(paramString, "audio/mp4a-latm")) {
            break;
          }
        } while ((((Integer)localObject).intValue() & 0x4) != 0);
        return false;
        if ((!TextUtils.equals(paramString, "audio/eac3")) && (!TextUtils.equals(paramString, "audio/ac3"))) {
          break;
        }
      } while ((((Integer)localObject).intValue() & 0x8) != 0);
      return false;
    }
    return false;
    return false;
  }
  
  public static boolean isWhiteListForHdr10(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    try
    {
      String[] arrayOfString;
      String str;
      int i;
      if (!TextUtils.isEmpty(paramString))
      {
        arrayOfString = paramString.split(",");
        str = Build.MODEL;
        TPNativeLog.printLog(2, "TPCodecUtils", "hdr10 白名单：" + paramString);
        i = 0;
      }
      for (;;)
      {
        bool1 = bool2;
        if (i < arrayOfString.length)
        {
          bool1 = str.equalsIgnoreCase(arrayOfString[i]);
          if (bool1) {
            bool1 = true;
          }
        }
        else
        {
          return bool1;
        }
        i += 1;
      }
      return false;
    }
    catch (Exception paramString)
    {
      TPNativeLog.printLog(4, "TPCodecUtils", "isWhiteListForHdr10：" + paramString.toString());
    }
  }
  
  public static boolean isWhiteListForHdr10Enhance(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    try
    {
      String[] arrayOfString;
      String str;
      int i;
      if (!TextUtils.isEmpty(paramString))
      {
        arrayOfString = paramString.split(",");
        str = Build.MODEL;
        TPNativeLog.printLog(2, "TPCodecUtils", "hdr10 白名单：" + paramString);
        i = 0;
      }
      for (;;)
      {
        bool1 = bool2;
        if (i < arrayOfString.length)
        {
          bool1 = str.equalsIgnoreCase(arrayOfString[i]);
          if (bool1) {
            bool1 = true;
          }
        }
        else
        {
          return bool1;
        }
        i += 1;
      }
      return false;
    }
    catch (Exception paramString)
    {
      TPNativeLog.printLog(4, "TPCodecUtils", "isWhiteListForHdr10：" + paramString.toString());
    }
  }
  
  private static int maxLumaSamplesForAVCProfileLevel(int paramInt1, int paramInt2)
  {
    for (;;)
    {
      try
      {
        Class localClass = Class.forName("android.media.MediaCodecInfo$CodecProfileLevel");
        i = ((Integer)localClass.getField("AVCLevel1").get(null)).intValue();
        j = ((Integer)localClass.getField("AVCLevel1b").get(null)).intValue();
        k = ((Integer)localClass.getField("AVCLevel11").get(null)).intValue();
        m = ((Integer)localClass.getField("AVCLevel12").get(null)).intValue();
        n = ((Integer)localClass.getField("AVCLevel13").get(null)).intValue();
        i1 = ((Integer)localClass.getField("AVCLevel2").get(null)).intValue();
        i2 = ((Integer)localClass.getField("AVCLevel21").get(null)).intValue();
        i3 = ((Integer)localClass.getField("AVCLevel22").get(null)).intValue();
        i4 = ((Integer)localClass.getField("AVCLevel3").get(null)).intValue();
        i5 = ((Integer)localClass.getField("AVCLevel31").get(null)).intValue();
        i6 = ((Integer)localClass.getField("AVCLevel32").get(null)).intValue();
        i7 = ((Integer)localClass.getField("AVCLevel4").get(null)).intValue();
        i8 = ((Integer)localClass.getField("AVCLevel41").get(null)).intValue();
        i9 = ((Integer)localClass.getField("AVCLevel42").get(null)).intValue();
        i10 = ((Integer)localClass.getField("AVCLevel5").get(null)).intValue();
        i11 = ((Integer)localClass.getField("AVCLevel51").get(null)).intValue();
        if (paramInt2 != i) {
          continue;
        }
        i = 25344;
      }
      catch (Exception localException)
      {
        int j;
        int k;
        int m;
        int n;
        int i1;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        TPNativeLog.printLog(4, "failed to get avc maxLumaSamples");
        TPNativeLog.printLog(4, localException.getMessage());
        localException.printStackTrace();
        int i = 414720;
        continue;
      }
      TPNativeLog.printLog(2, "AVC: maxprofile :" + paramInt1 + " , maxlevel :" + paramInt2 + " , maxSample : " + i);
      return i;
      if (paramInt2 == j)
      {
        i = 25344;
      }
      else if (paramInt2 == k)
      {
        i = 101376;
      }
      else if (paramInt2 == m)
      {
        i = 101376;
      }
      else if (paramInt2 == n)
      {
        i = 101376;
      }
      else if (paramInt2 == i1)
      {
        i = 101376;
      }
      else if (paramInt2 == i2)
      {
        i = 202752;
      }
      else if (paramInt2 == i3)
      {
        i = 414720;
      }
      else if (paramInt2 == i4)
      {
        i = 414720;
      }
      else if (paramInt2 == i5)
      {
        i = 921600;
      }
      else if (paramInt2 == i6)
      {
        i = 1310720;
      }
      else if (paramInt2 == i7)
      {
        i = 2097152;
      }
      else if (paramInt2 == i8)
      {
        i = 2097152;
      }
      else if (paramInt2 == i9)
      {
        i = 2228224;
      }
      else if (paramInt2 == i10)
      {
        i = 5652480;
      }
      else
      {
        if (paramInt2 < i11) {
          continue;
        }
        i = 9437184;
      }
    }
  }
  
  private static int maxLumaSamplesForHEVCProfileLevel(int paramInt1, int paramInt2)
  {
    for (;;)
    {
      try
      {
        Class localClass = Class.forName("android.media.MediaCodecInfo$CodecProfileLevel");
        i = ((Integer)localClass.getField("HEVCHighTierLevel1").get(null)).intValue();
        j = ((Integer)localClass.getField("HEVCHighTierLevel2").get(null)).intValue();
        k = ((Integer)localClass.getField("HEVCHighTierLevel21").get(null)).intValue();
        m = ((Integer)localClass.getField("HEVCHighTierLevel3").get(null)).intValue();
        n = ((Integer)localClass.getField("HEVCHighTierLevel31").get(null)).intValue();
        i1 = ((Integer)localClass.getField("HEVCHighTierLevel4").get(null)).intValue();
        i2 = ((Integer)localClass.getField("HEVCHighTierLevel41").get(null)).intValue();
        i3 = ((Integer)localClass.getField("HEVCHighTierLevel5").get(null)).intValue();
        i4 = ((Integer)localClass.getField("HEVCHighTierLevel51").get(null)).intValue();
        i5 = ((Integer)localClass.getField("HEVCHighTierLevel52").get(null)).intValue();
        i6 = ((Integer)localClass.getField("HEVCHighTierLevel6").get(null)).intValue();
        i7 = ((Integer)localClass.getField("HEVCHighTierLevel61").get(null)).intValue();
        i8 = ((Integer)localClass.getField("HEVCHighTierLevel62").get(null)).intValue();
        int i9 = ((Integer)localClass.getField("HEVCMainTierLevel1").get(null)).intValue();
        i10 = ((Integer)localClass.getField("HEVCMainTierLevel2").get(null)).intValue();
        i11 = ((Integer)localClass.getField("HEVCMainTierLevel21").get(null)).intValue();
        i12 = ((Integer)localClass.getField("HEVCMainTierLevel3").get(null)).intValue();
        i13 = ((Integer)localClass.getField("HEVCMainTierLevel31").get(null)).intValue();
        i14 = ((Integer)localClass.getField("HEVCMainTierLevel4").get(null)).intValue();
        i15 = ((Integer)localClass.getField("HEVCMainTierLevel41").get(null)).intValue();
        i16 = ((Integer)localClass.getField("HEVCMainTierLevel5").get(null)).intValue();
        i17 = ((Integer)localClass.getField("HEVCMainTierLevel51").get(null)).intValue();
        i18 = ((Integer)localClass.getField("HEVCMainTierLevel52").get(null)).intValue();
        i19 = ((Integer)localClass.getField("HEVCMainTierLevel6").get(null)).intValue();
        i20 = ((Integer)localClass.getField("HEVCMainTierLevel61").get(null)).intValue();
        i21 = ((Integer)localClass.getField("HEVCMainTierLevel62").get(null)).intValue();
        if ((paramInt2 != i) && (paramInt2 != i9)) {
          continue;
        }
        i = 36864;
      }
      catch (Exception localException)
      {
        int j;
        int k;
        int m;
        int n;
        int i1;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        int i21;
        TPNativeLog.printLog(4, "failed to get hevc maxLumaSamples");
        TPNativeLog.printLog(4, localException.getMessage());
        localException.printStackTrace();
        int i = 552960;
        continue;
      }
      TPNativeLog.printLog(2, "HEVC: maxprofile :" + paramInt1 + " , maxlevel :" + paramInt2 + " , maxSample : " + i);
      return i;
      if ((paramInt2 == j) || (paramInt2 == i10))
      {
        i = 122880;
      }
      else if ((paramInt2 == k) || (paramInt2 == i11))
      {
        i = 245760;
      }
      else if ((paramInt2 == m) || (paramInt2 == i12))
      {
        i = 552960;
      }
      else if ((paramInt2 == n) || (paramInt2 == i13))
      {
        i = 983040;
      }
      else if ((paramInt2 == i1) || (paramInt2 == i14))
      {
        i = 2228224;
      }
      else if ((paramInt2 == i2) || (paramInt2 == i15))
      {
        i = 2228224;
      }
      else if ((paramInt2 == i3) || (paramInt2 == i16))
      {
        i = 8912896;
      }
      else if ((paramInt2 == i4) || (paramInt2 == i17))
      {
        i = 8912896;
      }
      else if ((paramInt2 == i5) || (paramInt2 == i18))
      {
        i = 8912896;
      }
      else if ((paramInt2 == i6) || (paramInt2 == i19))
      {
        i = 35651584;
      }
      else if ((paramInt2 >= i7) || (paramInt2 == i20))
      {
        i = 35651584;
      }
      else
      {
        if ((paramInt2 < i8) && (paramInt2 != i21)) {
          continue;
        }
        i = 35651584;
      }
    }
  }
  
  private static int maxLumaSamplesForVP9ProfileLevel(int paramInt1, int paramInt2)
  {
    for (;;)
    {
      try
      {
        Class localClass = Class.forName("android.media.MediaCodecInfo$CodecProfileLevel");
        i = ((Integer)localClass.getField("VP9Level1").get(null)).intValue();
        j = ((Integer)localClass.getField("VP9Level11").get(null)).intValue();
        k = ((Integer)localClass.getField("VP9Level2").get(null)).intValue();
        m = ((Integer)localClass.getField("VP9Level21").get(null)).intValue();
        n = ((Integer)localClass.getField("VP9Level3").get(null)).intValue();
        i1 = ((Integer)localClass.getField("VP9Level31").get(null)).intValue();
        i2 = ((Integer)localClass.getField("VP9Level4").get(null)).intValue();
        i3 = ((Integer)localClass.getField("VP9Level41").get(null)).intValue();
        i4 = ((Integer)localClass.getField("VP9Level5").get(null)).intValue();
        i5 = ((Integer)localClass.getField("VP9Level51").get(null)).intValue();
        i6 = ((Integer)localClass.getField("VP9Level52").get(null)).intValue();
        i7 = ((Integer)localClass.getField("VP9Level6").get(null)).intValue();
        i8 = ((Integer)localClass.getField("VP9Level61").get(null)).intValue();
        i9 = ((Integer)localClass.getField("VP9Level62").get(null)).intValue();
        if (paramInt2 != i) {
          continue;
        }
        i = 36864;
      }
      catch (Exception localException)
      {
        int j;
        int k;
        int m;
        int n;
        int i1;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        TPNativeLog.printLog(4, "failed to get vp9 maxLumaSamples");
        TPNativeLog.printLog(4, localException.getMessage());
        localException.printStackTrace();
        int i = 552960;
        continue;
      }
      TPNativeLog.printLog(2, "VP9: maxprofile :" + paramInt1 + " , maxlevel :" + paramInt2 + " , maxSample : " + i);
      return i;
      if (paramInt2 == j)
      {
        i = 73728;
      }
      else if (paramInt2 == k)
      {
        i = 122880;
      }
      else if (paramInt2 == m)
      {
        i = 245760;
      }
      else if (paramInt2 == n)
      {
        i = 552960;
      }
      else if (paramInt2 == i1)
      {
        i = 983040;
      }
      else if (paramInt2 == i2)
      {
        i = 2228224;
      }
      else if (paramInt2 == i3)
      {
        i = 2228224;
      }
      else if (paramInt2 == i4)
      {
        i = 8912896;
      }
      else if (paramInt2 == i5)
      {
        i = 8912896;
      }
      else if (paramInt2 == i6)
      {
        i = 8912896;
      }
      else if (paramInt2 == i7)
      {
        i = 35651584;
      }
      else if (paramInt2 == i8)
      {
        i = 35651584;
      }
      else
      {
        if (paramInt2 != i9) {
          continue;
        }
        i = 35651584;
      }
    }
  }
  
  private static <K, T> void replace(K paramK, T paramT, HashMap<K, T> paramHashMap)
  {
    if (paramHashMap.containsKey(paramK))
    {
      paramHashMap.remove(paramK);
      paramHashMap.put(paramK, paramT);
      return;
    }
    paramHashMap.put(paramK, paramT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.thumbplayer.core.common.TPCodecUtils
 * JD-Core Version:    0.7.0.1
 */