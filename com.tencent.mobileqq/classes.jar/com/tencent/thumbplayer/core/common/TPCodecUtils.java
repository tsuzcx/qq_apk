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
  private static Context mApplicationContext;
  private static String mCapabilityVersion;
  private static String mCapabilityVersionKey;
  private static HashMap<String, Integer> mCodecCap;
  private static int mDeviceLevel = -1;
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
    mCodecCap = null;
    mApplicationContext = null;
    mIsLocalCacheEnabled = false;
    mNeedToReprobeDecoderCapability = true;
    mNeedToReprobeHDRCapability = true;
    mCapabilityVersion = "2.5.0.1086.full";
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
  
  /* Error */
  public static void getDecoderMaxCapabilityMapAsync()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 118	com/tencent/thumbplayer/core/common/TPCodecUtils:mIsInitDone	Z
    //   6: ifeq +16 -> 22
    //   9: iconst_2
    //   10: ldc 32
    //   12: ldc_w 320
    //   15: invokestatic 225	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;Ljava/lang/String;)V
    //   18: ldc 2
    //   20: monitorexit
    //   21: return
    //   22: iconst_2
    //   23: ldc 32
    //   25: ldc_w 322
    //   28: invokestatic 225	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;Ljava/lang/String;)V
    //   31: new 324	java/lang/Thread
    //   34: dup
    //   35: new 326	com/tencent/thumbplayer/core/common/TPCodecUtils$1
    //   38: dup
    //   39: invokespecial 327	com/tencent/thumbplayer/core/common/TPCodecUtils$1:<init>	()V
    //   42: invokespecial 330	java/lang/Thread:<init>	(Ljava/lang/Runnable;)V
    //   45: astore_0
    //   46: aload_0
    //   47: ldc_w 332
    //   50: invokevirtual 336	java/lang/Thread:setName	(Ljava/lang/String;)V
    //   53: aload_0
    //   54: invokevirtual 339	java/lang/Thread:start	()V
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
  
  private static int getHevcLvByCoresAndFreq()
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
    if (paramInt1 == TPDecoderType.TP_VIDEO_DECODER_FFMPEG) {
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
    //   6: ldc_w 451
    //   9: invokestatic 225	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;Ljava/lang/String;)V
    //   12: getstatic 227	com/tencent/thumbplayer/core/common/TPCodecUtils:mIsMediaCodecCapGot	Z
    //   15: ifeq +23 -> 38
    //   18: iconst_2
    //   19: ldc 32
    //   21: ldc_w 453
    //   24: invokestatic 225	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;Ljava/lang/String;)V
    //   27: getstatic 248	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMap	Ljava/util/HashMap;
    //   30: astore 12
    //   32: ldc 2
    //   34: monitorexit
    //   35: aload 12
    //   37: areturn
    //   38: getstatic 97	com/tencent/thumbplayer/core/common/TPCodecUtils:mIsLocalCacheEnabled	Z
    //   41: ifeq +168 -> 209
    //   44: getstatic 99	com/tencent/thumbplayer/core/common/TPCodecUtils:mNeedToReprobeDecoderCapability	Z
    //   47: ifne +162 -> 209
    //   50: iconst_2
    //   51: ldc 32
    //   53: ldc_w 455
    //   56: invokestatic 225	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;Ljava/lang/String;)V
    //   59: getstatic 112	com/tencent/thumbplayer/core/common/TPCodecUtils:mHWCodecCapList	Ljava/util/ArrayList;
    //   62: ifnull +12 -> 74
    //   65: getstatic 112	com/tencent/thumbplayer/core/common/TPCodecUtils:mHWCodecCapList	Ljava/util/ArrayList;
    //   68: invokevirtual 458	java/util/ArrayList:size	()I
    //   71: ifne +21 -> 92
    //   74: getstatic 138	com/tencent/thumbplayer/core/common/TPCodecUtils:mHWCodecCapListKey	Ljava/lang/String;
    //   77: invokestatic 460	com/tencent/thumbplayer/core/common/TPCodecUtils:getCachedCapList	(Ljava/lang/String;)Ljava/util/ArrayList;
    //   80: astore 12
    //   82: aload 12
    //   84: ifnull +8 -> 92
    //   87: aload 12
    //   89: putstatic 112	com/tencent/thumbplayer/core/common/TPCodecUtils:mHWCodecCapList	Ljava/util/ArrayList;
    //   92: getstatic 112	com/tencent/thumbplayer/core/common/TPCodecUtils:mHWCodecCapList	Ljava/util/ArrayList;
    //   95: ifnull +114 -> 209
    //   98: getstatic 112	com/tencent/thumbplayer/core/common/TPCodecUtils:mHWCodecCapList	Ljava/util/ArrayList;
    //   101: invokevirtual 458	java/util/ArrayList:size	()I
    //   104: ifle +105 -> 209
    //   107: getstatic 150	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMapKey	Ljava/lang/String;
    //   110: invokestatic 462	com/tencent/thumbplayer/core/common/TPCodecUtils:getCachedCapabilityMap	(Ljava/lang/String;)Ljava/util/HashMap;
    //   113: astore 12
    //   115: aload 12
    //   117: ifnull +92 -> 209
    //   120: aload 12
    //   122: putstatic 248	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMap	Ljava/util/HashMap;
    //   125: getstatic 248	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMap	Ljava/util/HashMap;
    //   128: invokevirtual 463	java/util/HashMap:size	()I
    //   131: ifle +78 -> 209
    //   134: iconst_2
    //   135: ldc 32
    //   137: new 270	java/lang/StringBuilder
    //   140: dup
    //   141: invokespecial 271	java/lang/StringBuilder:<init>	()V
    //   144: ldc_w 465
    //   147: invokevirtual 277	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   150: getstatic 248	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMap	Ljava/util/HashMap;
    //   153: invokevirtual 463	java/util/HashMap:size	()I
    //   156: invokevirtual 468	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   159: invokevirtual 283	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   162: invokestatic 225	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;Ljava/lang/String;)V
    //   165: iconst_1
    //   166: putstatic 227	com/tencent/thumbplayer/core/common/TPCodecUtils:mIsMediaCodecCapGot	Z
    //   169: getstatic 248	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMap	Ljava/util/HashMap;
    //   172: astore 12
    //   174: goto -142 -> 32
    //   177: astore 12
    //   179: iconst_4
    //   180: ldc 32
    //   182: new 270	java/lang/StringBuilder
    //   185: dup
    //   186: invokespecial 271	java/lang/StringBuilder:<init>	()V
    //   189: ldc_w 470
    //   192: invokevirtual 277	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   195: aload 12
    //   197: invokevirtual 473	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   200: invokevirtual 277	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   203: invokevirtual 283	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   206: invokestatic 225	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;Ljava/lang/String;)V
    //   209: iconst_0
    //   210: istore_2
    //   211: iconst_0
    //   212: istore_1
    //   213: iconst_0
    //   214: istore_0
    //   215: ldc_w 475
    //   218: invokestatic 481	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   221: astore 12
    //   223: aload 12
    //   225: ldc_w 482
    //   228: iconst_0
    //   229: anewarray 477	java/lang/Class
    //   232: invokevirtual 486	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   235: astore 20
    //   237: aload 12
    //   239: ldc_w 487
    //   242: iconst_1
    //   243: anewarray 477	java/lang/Class
    //   246: dup
    //   247: iconst_0
    //   248: getstatic 491	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   251: aastore
    //   252: invokevirtual 486	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   255: astore 12
    //   257: ldc_w 493
    //   260: invokestatic 481	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   263: astore 16
    //   265: aload 16
    //   267: ldc_w 494
    //   270: iconst_0
    //   271: anewarray 477	java/lang/Class
    //   274: invokevirtual 486	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   277: astore 13
    //   279: aload 16
    //   281: ldc_w 496
    //   284: iconst_0
    //   285: anewarray 477	java/lang/Class
    //   288: invokevirtual 486	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   291: astore 14
    //   293: aload 16
    //   295: ldc_w 497
    //   298: iconst_0
    //   299: anewarray 477	java/lang/Class
    //   302: invokevirtual 486	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   305: astore 15
    //   307: aload 16
    //   309: ldc_w 498
    //   312: iconst_1
    //   313: anewarray 477	java/lang/Class
    //   316: dup
    //   317: iconst_0
    //   318: ldc_w 397
    //   321: aastore
    //   322: invokevirtual 486	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   325: astore 16
    //   327: ldc_w 500
    //   330: invokestatic 481	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   333: ldc_w 502
    //   336: invokevirtual 506	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   339: astore 17
    //   341: ldc_w 508
    //   344: invokestatic 481	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   347: astore 19
    //   349: aload 19
    //   351: ldc_w 510
    //   354: invokevirtual 506	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   357: astore 18
    //   359: aload 19
    //   361: ldc_w 512
    //   364: invokevirtual 506	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   367: astore 19
    //   369: aload 20
    //   371: aconst_null
    //   372: iconst_0
    //   373: anewarray 4	java/lang/Object
    //   376: invokevirtual 518	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   379: checkcast 201	java/lang/Integer
    //   382: invokevirtual 519	java/lang/Integer:intValue	()I
    //   385: istore 8
    //   387: iconst_2
    //   388: new 270	java/lang/StringBuilder
    //   391: dup
    //   392: invokespecial 271	java/lang/StringBuilder:<init>	()V
    //   395: ldc_w 521
    //   398: invokevirtual 277	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   401: iload 8
    //   403: invokevirtual 468	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   406: invokevirtual 283	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   409: invokestatic 524	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   412: iconst_0
    //   413: istore 4
    //   415: iload 4
    //   417: iload 8
    //   419: if_icmpge +1967 -> 2386
    //   422: aload 12
    //   424: aconst_null
    //   425: iconst_1
    //   426: anewarray 4	java/lang/Object
    //   429: dup
    //   430: iconst_0
    //   431: iload 4
    //   433: invokestatic 205	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   436: aastore
    //   437: invokevirtual 518	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   440: astore 20
    //   442: aload 15
    //   444: aload 20
    //   446: iconst_0
    //   447: anewarray 4	java/lang/Object
    //   450: invokevirtual 518	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   453: checkcast 526	java/lang/Boolean
    //   456: invokevirtual 529	java/lang/Boolean:booleanValue	()Z
    //   459: ifeq +14 -> 473
    //   462: iload_2
    //   463: istore_3
    //   464: iload_0
    //   465: istore 6
    //   467: iload_1
    //   468: istore 7
    //   470: goto +2061 -> 2531
    //   473: aload 14
    //   475: aload 20
    //   477: iconst_0
    //   478: anewarray 4	java/lang/Object
    //   481: invokevirtual 518	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   484: checkcast 397	java/lang/String
    //   487: invokevirtual 532	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   490: astore 21
    //   492: aload 13
    //   494: aload 20
    //   496: iconst_0
    //   497: anewarray 4	java/lang/Object
    //   500: invokevirtual 518	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   503: checkcast 534	[Ljava/lang/String;
    //   506: checkcast 534	[Ljava/lang/String;
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
    //   531: if_icmpge +2000 -> 2531
    //   534: aload 22
    //   536: iload 5
    //   538: aaload
    //   539: astore 23
    //   541: iconst_2
    //   542: new 270	java/lang/StringBuilder
    //   545: dup
    //   546: invokespecial 271	java/lang/StringBuilder:<init>	()V
    //   549: ldc_w 536
    //   552: invokevirtual 277	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   555: aload 23
    //   557: invokevirtual 277	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   560: invokevirtual 283	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   563: invokestatic 524	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   566: aload 21
    //   568: ldc_w 538
    //   571: invokevirtual 542	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   574: ifne +36 -> 610
    //   577: aload 21
    //   579: ldc_w 544
    //   582: invokevirtual 542	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   585: ifne +25 -> 610
    //   588: aload 21
    //   590: ldc_w 546
    //   593: invokevirtual 542	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   596: ifne +14 -> 610
    //   599: aload 21
    //   601: ldc_w 548
    //   604: invokevirtual 542	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   607: ifeq +15 -> 622
    //   610: getstatic 114	com/tencent/thumbplayer/core/common/TPCodecUtils:mSoftCodecCapList	Ljava/util/ArrayList;
    //   613: aload 23
    //   615: invokevirtual 552	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   618: pop
    //   619: goto +1929 -> 2548
    //   622: getstatic 112	com/tencent/thumbplayer/core/common/TPCodecUtils:mHWCodecCapList	Ljava/util/ArrayList;
    //   625: aload 23
    //   627: invokevirtual 552	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   630: pop
    //   631: getstatic 112	com/tencent/thumbplayer/core/common/TPCodecUtils:mHWCodecCapList	Ljava/util/ArrayList;
    //   634: ldc_w 430
    //   637: invokevirtual 554	java/util/ArrayList:contains	(Ljava/lang/Object;)Z
    //   640: istore 11
    //   642: iload 11
    //   644: ifeq +1884 -> 2528
    //   647: iload_2
    //   648: ifne +1880 -> 2528
    //   651: aload 17
    //   653: aload 16
    //   655: aload 20
    //   657: iconst_1
    //   658: anewarray 4	java/lang/Object
    //   661: dup
    //   662: iconst_0
    //   663: ldc_w 430
    //   666: aastore
    //   667: invokevirtual 518	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   670: invokevirtual 559	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   673: checkcast 561	[Ljava/lang/Object;
    //   676: checkcast 561	[Ljava/lang/Object;
    //   679: astore 23
    //   681: aload 23
    //   683: arraylength
    //   684: istore_3
    //   685: iconst_0
    //   686: istore_2
    //   687: iload_2
    //   688: iload_3
    //   689: if_icmpge +726 -> 1415
    //   692: aload 23
    //   694: iload_2
    //   695: aaload
    //   696: astore 24
    //   698: aload 18
    //   700: aload 24
    //   702: invokevirtual 559	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   705: checkcast 201	java/lang/Integer
    //   708: invokevirtual 519	java/lang/Integer:intValue	()I
    //   711: istore 6
    //   713: aload 19
    //   715: aload 24
    //   717: invokevirtual 559	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   720: checkcast 201	java/lang/Integer
    //   723: invokevirtual 519	java/lang/Integer:intValue	()I
    //   726: istore 7
    //   728: iload 7
    //   730: iload 6
    //   732: invokestatic 565	com/tencent/thumbplayer/core/common/TPCodecUtils:maxLumaSamplesForAVCProfileLevel	(II)I
    //   735: istore 10
    //   737: iload 10
    //   739: getstatic 236	com/tencent/thumbplayer/core/common/TPCodecUtils:mAVCMediaCodecMaxCapability	Lcom/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability;
    //   742: getfield 568	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability:maxLumaSamples	I
    //   745: if_icmplt +1812 -> 2557
    //   748: getstatic 236	com/tencent/thumbplayer/core/common/TPCodecUtils:mAVCMediaCodecMaxCapability	Lcom/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability;
    //   751: iload 10
    //   753: putfield 568	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability:maxLumaSamples	I
    //   756: getstatic 236	com/tencent/thumbplayer/core/common/TPCodecUtils:mAVCMediaCodecMaxCapability	Lcom/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability;
    //   759: iload 7
    //   761: putfield 571	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability:maxProfile	I
    //   764: getstatic 236	com/tencent/thumbplayer/core/common/TPCodecUtils:mAVCMediaCodecMaxCapability	Lcom/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability;
    //   767: iload 6
    //   769: putfield 574	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability:maxLevel	I
    //   772: getstatic 236	com/tencent/thumbplayer/core/common/TPCodecUtils:mAVCMediaCodecMaxCapability	Lcom/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability;
    //   775: getfield 568	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability:maxLumaSamples	I
    //   778: ldc_w 575
    //   781: if_icmplt +40 -> 821
    //   784: getstatic 236	com/tencent/thumbplayer/core/common/TPCodecUtils:mAVCMediaCodecMaxCapability	Lcom/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability;
    //   787: getstatic 578	com/tencent/thumbplayer/core/common/TPDecoderType:TP_VIDEO_DECODER_MEDIACODEC	I
    //   790: bipush 26
    //   792: sipush 7680
    //   795: sipush 4320
    //   798: invokestatic 580	com/tencent/thumbplayer/core/common/TPCodecUtils:getMaxSupportedFrameRatesFor	(IIII)I
    //   801: putfield 583	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability:maxFramerateFormaxLumaSamples	I
    //   804: bipush 26
    //   806: invokestatic 205	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   809: getstatic 236	com/tencent/thumbplayer/core/common/TPCodecUtils:mAVCMediaCodecMaxCapability	Lcom/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability;
    //   812: getstatic 248	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMap	Ljava/util/HashMap;
    //   815: invokestatic 587	com/tencent/thumbplayer/core/common/TPCodecUtils:replace	(Ljava/lang/Object;Ljava/lang/Object;Ljava/util/HashMap;)V
    //   818: goto +1739 -> 2557
    //   821: getstatic 236	com/tencent/thumbplayer/core/common/TPCodecUtils:mAVCMediaCodecMaxCapability	Lcom/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability;
    //   824: getfield 568	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability:maxLumaSamples	I
    //   827: ldc_w 588
    //   830: if_icmplt +258 -> 1088
    //   833: getstatic 236	com/tencent/thumbplayer/core/common/TPCodecUtils:mAVCMediaCodecMaxCapability	Lcom/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability;
    //   836: getstatic 578	com/tencent/thumbplayer/core/common/TPDecoderType:TP_VIDEO_DECODER_MEDIACODEC	I
    //   839: bipush 26
    //   841: sipush 4096
    //   844: sipush 2160
    //   847: invokestatic 580	com/tencent/thumbplayer/core/common/TPCodecUtils:getMaxSupportedFrameRatesFor	(IIII)I
    //   850: putfield 583	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability:maxFramerateFormaxLumaSamples	I
    //   853: goto -49 -> 804
    //   856: astore 23
    //   858: iconst_1
    //   859: istore_2
    //   860: iconst_4
    //   861: new 270	java/lang/StringBuilder
    //   864: dup
    //   865: invokespecial 271	java/lang/StringBuilder:<init>	()V
    //   868: ldc_w 590
    //   871: invokevirtual 277	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   874: aload 23
    //   876: invokevirtual 591	java/lang/RuntimeException:getMessage	()Ljava/lang/String;
    //   879: invokevirtual 277	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   882: invokevirtual 283	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   885: invokestatic 524	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   888: getstatic 112	com/tencent/thumbplayer/core/common/TPCodecUtils:mHWCodecCapList	Ljava/util/ArrayList;
    //   891: ldc_w 395
    //   894: invokevirtual 554	java/util/ArrayList:contains	(Ljava/lang/Object;)Z
    //   897: istore 11
    //   899: iload_1
    //   900: istore_3
    //   901: iload 11
    //   903: ifeq +781 -> 1684
    //   906: iload_1
    //   907: istore_3
    //   908: iload_1
    //   909: ifne +775 -> 1684
    //   912: aload 17
    //   914: aload 16
    //   916: aload 20
    //   918: iconst_1
    //   919: anewarray 4	java/lang/Object
    //   922: dup
    //   923: iconst_0
    //   924: ldc_w 395
    //   927: aastore
    //   928: invokevirtual 518	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   931: invokevirtual 559	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   934: checkcast 561	[Ljava/lang/Object;
    //   937: checkcast 561	[Ljava/lang/Object;
    //   940: astore 23
    //   942: aload 23
    //   944: arraylength
    //   945: istore_3
    //   946: iconst_0
    //   947: istore_1
    //   948: iload_1
    //   949: iload_3
    //   950: if_icmpge +1120 -> 2070
    //   953: aload 23
    //   955: iload_1
    //   956: aaload
    //   957: astore 24
    //   959: aload 18
    //   961: aload 24
    //   963: invokevirtual 559	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   966: checkcast 201	java/lang/Integer
    //   969: invokevirtual 519	java/lang/Integer:intValue	()I
    //   972: istore 6
    //   974: aload 19
    //   976: aload 24
    //   978: invokevirtual 559	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   981: checkcast 201	java/lang/Integer
    //   984: invokevirtual 519	java/lang/Integer:intValue	()I
    //   987: istore 7
    //   989: iload 7
    //   991: iload 6
    //   993: invokestatic 594	com/tencent/thumbplayer/core/common/TPCodecUtils:maxLumaSamplesForHEVCProfileLevel	(II)I
    //   996: istore 10
    //   998: iload 10
    //   1000: getstatic 238	com/tencent/thumbplayer/core/common/TPCodecUtils:mHEVCMediaCodecMaxCapability	Lcom/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability;
    //   1003: getfield 568	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability:maxLumaSamples	I
    //   1006: if_icmplt +75 -> 1081
    //   1009: getstatic 238	com/tencent/thumbplayer/core/common/TPCodecUtils:mHEVCMediaCodecMaxCapability	Lcom/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability;
    //   1012: iload 10
    //   1014: putfield 568	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability:maxLumaSamples	I
    //   1017: getstatic 238	com/tencent/thumbplayer/core/common/TPCodecUtils:mHEVCMediaCodecMaxCapability	Lcom/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability;
    //   1020: iload 7
    //   1022: putfield 571	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability:maxProfile	I
    //   1025: getstatic 238	com/tencent/thumbplayer/core/common/TPCodecUtils:mHEVCMediaCodecMaxCapability	Lcom/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability;
    //   1028: iload 6
    //   1030: putfield 574	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability:maxLevel	I
    //   1033: getstatic 238	com/tencent/thumbplayer/core/common/TPCodecUtils:mHEVCMediaCodecMaxCapability	Lcom/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability;
    //   1036: getfield 568	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability:maxLumaSamples	I
    //   1039: ldc_w 575
    //   1042: if_icmplt +574 -> 1616
    //   1045: getstatic 238	com/tencent/thumbplayer/core/common/TPCodecUtils:mHEVCMediaCodecMaxCapability	Lcom/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability;
    //   1048: getstatic 578	com/tencent/thumbplayer/core/common/TPDecoderType:TP_VIDEO_DECODER_MEDIACODEC	I
    //   1051: sipush 172
    //   1054: sipush 7680
    //   1057: sipush 4320
    //   1060: invokestatic 580	com/tencent/thumbplayer/core/common/TPCodecUtils:getMaxSupportedFrameRatesFor	(IIII)I
    //   1063: putfield 583	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability:maxFramerateFormaxLumaSamples	I
    //   1066: sipush 172
    //   1069: invokestatic 205	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1072: getstatic 238	com/tencent/thumbplayer/core/common/TPCodecUtils:mHEVCMediaCodecMaxCapability	Lcom/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability;
    //   1075: getstatic 248	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMap	Ljava/util/HashMap;
    //   1078: invokestatic 587	com/tencent/thumbplayer/core/common/TPCodecUtils:replace	(Ljava/lang/Object;Ljava/lang/Object;Ljava/util/HashMap;)V
    //   1081: iload_1
    //   1082: iconst_1
    //   1083: iadd
    //   1084: istore_1
    //   1085: goto -137 -> 948
    //   1088: getstatic 236	com/tencent/thumbplayer/core/common/TPCodecUtils:mAVCMediaCodecMaxCapability	Lcom/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability;
    //   1091: getfield 568	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability:maxLumaSamples	I
    //   1094: ldc_w 595
    //   1097: if_icmplt +108 -> 1205
    //   1100: getstatic 236	com/tencent/thumbplayer/core/common/TPCodecUtils:mAVCMediaCodecMaxCapability	Lcom/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability;
    //   1103: getstatic 578	com/tencent/thumbplayer/core/common/TPDecoderType:TP_VIDEO_DECODER_MEDIACODEC	I
    //   1106: bipush 26
    //   1108: sipush 1920
    //   1111: sipush 1080
    //   1114: invokestatic 580	com/tencent/thumbplayer/core/common/TPCodecUtils:getMaxSupportedFrameRatesFor	(IIII)I
    //   1117: putfield 583	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability:maxFramerateFormaxLumaSamples	I
    //   1120: goto -316 -> 804
    //   1123: astore 12
    //   1125: iconst_4
    //   1126: new 270	java/lang/StringBuilder
    //   1129: dup
    //   1130: invokespecial 271	java/lang/StringBuilder:<init>	()V
    //   1133: ldc_w 597
    //   1136: invokevirtual 277	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1139: aload 12
    //   1141: invokevirtual 598	java/lang/reflect/InvocationTargetException:getMessage	()Ljava/lang/String;
    //   1144: invokevirtual 277	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1147: invokevirtual 283	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1150: invokestatic 524	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   1153: iconst_2
    //   1154: ldc_w 600
    //   1157: invokestatic 524	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   1160: getstatic 97	com/tencent/thumbplayer/core/common/TPCodecUtils:mIsLocalCacheEnabled	Z
    //   1163: ifeq +30 -> 1193
    //   1166: getstatic 138	com/tencent/thumbplayer/core/common/TPCodecUtils:mHWCodecCapListKey	Ljava/lang/String;
    //   1169: getstatic 112	com/tencent/thumbplayer/core/common/TPCodecUtils:mHWCodecCapList	Ljava/util/ArrayList;
    //   1172: invokestatic 602	com/tencent/thumbplayer/core/common/TPCodecUtils:cacheCapList	(Ljava/lang/String;Ljava/util/ArrayList;)V
    //   1175: getstatic 150	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMapKey	Ljava/lang/String;
    //   1178: getstatic 248	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMap	Ljava/util/HashMap;
    //   1181: invokestatic 604	com/tencent/thumbplayer/core/common/TPCodecUtils:cacheCapabilityMap	(Ljava/lang/String;Ljava/util/HashMap;)V
    //   1184: iconst_2
    //   1185: ldc 32
    //   1187: ldc_w 606
    //   1190: invokestatic 225	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;Ljava/lang/String;)V
    //   1193: iconst_1
    //   1194: putstatic 227	com/tencent/thumbplayer/core/common/TPCodecUtils:mIsMediaCodecCapGot	Z
    //   1197: getstatic 248	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMap	Ljava/util/HashMap;
    //   1200: astore 12
    //   1202: goto -1170 -> 32
    //   1205: getstatic 236	com/tencent/thumbplayer/core/common/TPCodecUtils:mAVCMediaCodecMaxCapability	Lcom/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability;
    //   1208: getfield 568	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability:maxLumaSamples	I
    //   1211: ldc_w 607
    //   1214: if_icmplt +108 -> 1322
    //   1217: getstatic 236	com/tencent/thumbplayer/core/common/TPCodecUtils:mAVCMediaCodecMaxCapability	Lcom/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability;
    //   1220: getstatic 578	com/tencent/thumbplayer/core/common/TPDecoderType:TP_VIDEO_DECODER_MEDIACODEC	I
    //   1223: bipush 26
    //   1225: sipush 1280
    //   1228: sipush 720
    //   1231: invokestatic 580	com/tencent/thumbplayer/core/common/TPCodecUtils:getMaxSupportedFrameRatesFor	(IIII)I
    //   1234: putfield 583	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability:maxFramerateFormaxLumaSamples	I
    //   1237: goto -433 -> 804
    //   1240: astore 12
    //   1242: iconst_4
    //   1243: new 270	java/lang/StringBuilder
    //   1246: dup
    //   1247: invokespecial 271	java/lang/StringBuilder:<init>	()V
    //   1250: ldc_w 597
    //   1253: invokevirtual 277	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1256: aload 12
    //   1258: invokevirtual 608	java/lang/NoSuchMethodException:getMessage	()Ljava/lang/String;
    //   1261: invokevirtual 277	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1264: invokevirtual 283	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1267: invokestatic 524	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   1270: iconst_2
    //   1271: ldc_w 600
    //   1274: invokestatic 524	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   1277: getstatic 97	com/tencent/thumbplayer/core/common/TPCodecUtils:mIsLocalCacheEnabled	Z
    //   1280: ifeq +30 -> 1310
    //   1283: getstatic 138	com/tencent/thumbplayer/core/common/TPCodecUtils:mHWCodecCapListKey	Ljava/lang/String;
    //   1286: getstatic 112	com/tencent/thumbplayer/core/common/TPCodecUtils:mHWCodecCapList	Ljava/util/ArrayList;
    //   1289: invokestatic 602	com/tencent/thumbplayer/core/common/TPCodecUtils:cacheCapList	(Ljava/lang/String;Ljava/util/ArrayList;)V
    //   1292: getstatic 150	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMapKey	Ljava/lang/String;
    //   1295: getstatic 248	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMap	Ljava/util/HashMap;
    //   1298: invokestatic 604	com/tencent/thumbplayer/core/common/TPCodecUtils:cacheCapabilityMap	(Ljava/lang/String;Ljava/util/HashMap;)V
    //   1301: iconst_2
    //   1302: ldc 32
    //   1304: ldc_w 606
    //   1307: invokestatic 225	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;Ljava/lang/String;)V
    //   1310: iconst_1
    //   1311: putstatic 227	com/tencent/thumbplayer/core/common/TPCodecUtils:mIsMediaCodecCapGot	Z
    //   1314: getstatic 248	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMap	Ljava/util/HashMap;
    //   1317: astore 12
    //   1319: goto -1287 -> 32
    //   1322: getstatic 236	com/tencent/thumbplayer/core/common/TPCodecUtils:mAVCMediaCodecMaxCapability	Lcom/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability;
    //   1325: bipush 30
    //   1327: putfield 583	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability:maxFramerateFormaxLumaSamples	I
    //   1330: goto -526 -> 804
    //   1333: astore 12
    //   1335: iconst_4
    //   1336: new 270	java/lang/StringBuilder
    //   1339: dup
    //   1340: invokespecial 271	java/lang/StringBuilder:<init>	()V
    //   1343: ldc_w 597
    //   1346: invokevirtual 277	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1349: aload 12
    //   1351: invokevirtual 609	java/lang/IllegalAccessException:getMessage	()Ljava/lang/String;
    //   1354: invokevirtual 277	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1357: invokevirtual 283	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1360: invokestatic 524	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   1363: iconst_2
    //   1364: ldc_w 600
    //   1367: invokestatic 524	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   1370: getstatic 97	com/tencent/thumbplayer/core/common/TPCodecUtils:mIsLocalCacheEnabled	Z
    //   1373: ifeq +30 -> 1403
    //   1376: getstatic 138	com/tencent/thumbplayer/core/common/TPCodecUtils:mHWCodecCapListKey	Ljava/lang/String;
    //   1379: getstatic 112	com/tencent/thumbplayer/core/common/TPCodecUtils:mHWCodecCapList	Ljava/util/ArrayList;
    //   1382: invokestatic 602	com/tencent/thumbplayer/core/common/TPCodecUtils:cacheCapList	(Ljava/lang/String;Ljava/util/ArrayList;)V
    //   1385: getstatic 150	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMapKey	Ljava/lang/String;
    //   1388: getstatic 248	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMap	Ljava/util/HashMap;
    //   1391: invokestatic 604	com/tencent/thumbplayer/core/common/TPCodecUtils:cacheCapabilityMap	(Ljava/lang/String;Ljava/util/HashMap;)V
    //   1394: iconst_2
    //   1395: ldc 32
    //   1397: ldc_w 606
    //   1400: invokestatic 225	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;Ljava/lang/String;)V
    //   1403: iconst_1
    //   1404: putstatic 227	com/tencent/thumbplayer/core/common/TPCodecUtils:mIsMediaCodecCapGot	Z
    //   1407: getstatic 248	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMap	Ljava/util/HashMap;
    //   1410: astore 12
    //   1412: goto -1380 -> 32
    //   1415: getstatic 248	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMap	Ljava/util/HashMap;
    //   1418: bipush 26
    //   1420: invokestatic 205	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1423: invokevirtual 612	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   1426: ifeq +98 -> 1524
    //   1429: iconst_2
    //   1430: new 270	java/lang/StringBuilder
    //   1433: dup
    //   1434: invokespecial 271	java/lang/StringBuilder:<init>	()V
    //   1437: ldc_w 614
    //   1440: invokevirtual 277	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1443: getstatic 248	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMap	Ljava/util/HashMap;
    //   1446: bipush 26
    //   1448: invokestatic 205	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1451: invokevirtual 615	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1454: checkcast 231	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability
    //   1457: getfield 571	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability:maxProfile	I
    //   1460: invokevirtual 468	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1463: ldc_w 617
    //   1466: invokevirtual 277	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1469: getstatic 248	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMap	Ljava/util/HashMap;
    //   1472: bipush 26
    //   1474: invokestatic 205	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1477: invokevirtual 615	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1480: checkcast 231	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability
    //   1483: getfield 574	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability:maxLevel	I
    //   1486: invokevirtual 468	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1489: ldc_w 619
    //   1492: invokevirtual 277	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1495: getstatic 248	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMap	Ljava/util/HashMap;
    //   1498: bipush 26
    //   1500: invokestatic 205	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1503: invokevirtual 615	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1506: checkcast 231	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability
    //   1509: getfield 568	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability:maxLumaSamples	I
    //   1512: invokevirtual 468	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1515: invokevirtual 283	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1518: invokestatic 524	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   1521: goto +1043 -> 2564
    //   1524: iconst_2
    //   1525: ldc_w 621
    //   1528: invokestatic 524	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   1531: goto +1033 -> 2564
    //   1534: astore 12
    //   1536: iconst_4
    //   1537: new 270	java/lang/StringBuilder
    //   1540: dup
    //   1541: invokespecial 271	java/lang/StringBuilder:<init>	()V
    //   1544: ldc_w 597
    //   1547: invokevirtual 277	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1550: aload 12
    //   1552: invokevirtual 622	java/lang/NoSuchFieldException:getMessage	()Ljava/lang/String;
    //   1555: invokevirtual 277	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1558: invokevirtual 283	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1561: invokestatic 524	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   1564: iconst_2
    //   1565: ldc_w 600
    //   1568: invokestatic 524	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   1571: getstatic 97	com/tencent/thumbplayer/core/common/TPCodecUtils:mIsLocalCacheEnabled	Z
    //   1574: ifeq +30 -> 1604
    //   1577: getstatic 138	com/tencent/thumbplayer/core/common/TPCodecUtils:mHWCodecCapListKey	Ljava/lang/String;
    //   1580: getstatic 112	com/tencent/thumbplayer/core/common/TPCodecUtils:mHWCodecCapList	Ljava/util/ArrayList;
    //   1583: invokestatic 602	com/tencent/thumbplayer/core/common/TPCodecUtils:cacheCapList	(Ljava/lang/String;Ljava/util/ArrayList;)V
    //   1586: getstatic 150	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMapKey	Ljava/lang/String;
    //   1589: getstatic 248	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMap	Ljava/util/HashMap;
    //   1592: invokestatic 604	com/tencent/thumbplayer/core/common/TPCodecUtils:cacheCapabilityMap	(Ljava/lang/String;Ljava/util/HashMap;)V
    //   1595: iconst_2
    //   1596: ldc 32
    //   1598: ldc_w 606
    //   1601: invokestatic 225	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;Ljava/lang/String;)V
    //   1604: iconst_1
    //   1605: putstatic 227	com/tencent/thumbplayer/core/common/TPCodecUtils:mIsMediaCodecCapGot	Z
    //   1608: getstatic 248	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMap	Ljava/util/HashMap;
    //   1611: astore 12
    //   1613: goto -1581 -> 32
    //   1616: getstatic 238	com/tencent/thumbplayer/core/common/TPCodecUtils:mHEVCMediaCodecMaxCapability	Lcom/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability;
    //   1619: getfield 568	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability:maxLumaSamples	I
    //   1622: ldc_w 588
    //   1625: if_icmplt +226 -> 1851
    //   1628: getstatic 238	com/tencent/thumbplayer/core/common/TPCodecUtils:mHEVCMediaCodecMaxCapability	Lcom/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability;
    //   1631: getstatic 578	com/tencent/thumbplayer/core/common/TPDecoderType:TP_VIDEO_DECODER_MEDIACODEC	I
    //   1634: sipush 172
    //   1637: sipush 4096
    //   1640: sipush 2160
    //   1643: invokestatic 580	com/tencent/thumbplayer/core/common/TPCodecUtils:getMaxSupportedFrameRatesFor	(IIII)I
    //   1646: putfield 583	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability:maxFramerateFormaxLumaSamples	I
    //   1649: goto -583 -> 1066
    //   1652: astore 23
    //   1654: iconst_1
    //   1655: istore_3
    //   1656: iconst_4
    //   1657: new 270	java/lang/StringBuilder
    //   1660: dup
    //   1661: invokespecial 271	java/lang/StringBuilder:<init>	()V
    //   1664: ldc_w 624
    //   1667: invokevirtual 277	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1670: aload 23
    //   1672: invokevirtual 591	java/lang/RuntimeException:getMessage	()Ljava/lang/String;
    //   1675: invokevirtual 277	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1678: invokevirtual 283	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1681: invokestatic 524	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   1684: getstatic 112	com/tencent/thumbplayer/core/common/TPCodecUtils:mHWCodecCapList	Ljava/util/ArrayList;
    //   1687: ldc_w 626
    //   1690: invokevirtual 554	java/util/ArrayList:contains	(Ljava/lang/Object;)Z
    //   1693: istore 11
    //   1695: iload_0
    //   1696: istore_1
    //   1697: iload 11
    //   1699: ifeq +682 -> 2381
    //   1702: iload_0
    //   1703: istore_1
    //   1704: iload_0
    //   1705: ifne +676 -> 2381
    //   1708: aload 17
    //   1710: aload 16
    //   1712: aload 20
    //   1714: iconst_1
    //   1715: anewarray 4	java/lang/Object
    //   1718: dup
    //   1719: iconst_0
    //   1720: ldc_w 626
    //   1723: aastore
    //   1724: invokevirtual 518	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   1727: invokevirtual 559	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1730: checkcast 561	[Ljava/lang/Object;
    //   1733: checkcast 561	[Ljava/lang/Object;
    //   1736: astore 23
    //   1738: aload 23
    //   1740: arraylength
    //   1741: istore_1
    //   1742: iconst_0
    //   1743: istore_0
    //   1744: iload_0
    //   1745: iload_1
    //   1746: if_icmpge +447 -> 2193
    //   1749: aload 23
    //   1751: iload_0
    //   1752: aaload
    //   1753: astore 24
    //   1755: aload 18
    //   1757: aload 24
    //   1759: invokevirtual 559	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1762: checkcast 201	java/lang/Integer
    //   1765: invokevirtual 519	java/lang/Integer:intValue	()I
    //   1768: istore 6
    //   1770: aload 19
    //   1772: aload 24
    //   1774: invokevirtual 559	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1777: checkcast 201	java/lang/Integer
    //   1780: invokevirtual 519	java/lang/Integer:intValue	()I
    //   1783: istore 7
    //   1785: iload 7
    //   1787: iload 6
    //   1789: invokestatic 629	com/tencent/thumbplayer/core/common/TPCodecUtils:maxLumaSamplesForVP9ProfileLevel	(II)I
    //   1792: istore 10
    //   1794: iload 10
    //   1796: getstatic 240	com/tencent/thumbplayer/core/common/TPCodecUtils:mVP9MediaCodecMaxCapability	Lcom/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability;
    //   1799: getfield 568	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability:maxLumaSamples	I
    //   1802: if_icmplt +42 -> 1844
    //   1805: getstatic 240	com/tencent/thumbplayer/core/common/TPCodecUtils:mVP9MediaCodecMaxCapability	Lcom/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability;
    //   1808: iload 10
    //   1810: putfield 568	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability:maxLumaSamples	I
    //   1813: getstatic 240	com/tencent/thumbplayer/core/common/TPCodecUtils:mVP9MediaCodecMaxCapability	Lcom/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability;
    //   1816: iload 7
    //   1818: putfield 571	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability:maxProfile	I
    //   1821: getstatic 240	com/tencent/thumbplayer/core/common/TPCodecUtils:mVP9MediaCodecMaxCapability	Lcom/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability;
    //   1824: iload 6
    //   1826: putfield 574	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability:maxLevel	I
    //   1829: sipush 166
    //   1832: invokestatic 205	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1835: getstatic 240	com/tencent/thumbplayer/core/common/TPCodecUtils:mVP9MediaCodecMaxCapability	Lcom/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability;
    //   1838: getstatic 248	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMap	Ljava/util/HashMap;
    //   1841: invokestatic 587	com/tencent/thumbplayer/core/common/TPCodecUtils:replace	(Ljava/lang/Object;Ljava/lang/Object;Ljava/util/HashMap;)V
    //   1844: iload_0
    //   1845: iconst_1
    //   1846: iadd
    //   1847: istore_0
    //   1848: goto -104 -> 1744
    //   1851: getstatic 238	com/tencent/thumbplayer/core/common/TPCodecUtils:mHEVCMediaCodecMaxCapability	Lcom/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability;
    //   1854: getfield 568	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability:maxLumaSamples	I
    //   1857: ldc_w 595
    //   1860: if_icmplt +109 -> 1969
    //   1863: getstatic 238	com/tencent/thumbplayer/core/common/TPCodecUtils:mHEVCMediaCodecMaxCapability	Lcom/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability;
    //   1866: getstatic 578	com/tencent/thumbplayer/core/common/TPDecoderType:TP_VIDEO_DECODER_MEDIACODEC	I
    //   1869: sipush 172
    //   1872: sipush 1920
    //   1875: sipush 1080
    //   1878: invokestatic 580	com/tencent/thumbplayer/core/common/TPCodecUtils:getMaxSupportedFrameRatesFor	(IIII)I
    //   1881: putfield 583	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability:maxFramerateFormaxLumaSamples	I
    //   1884: goto -818 -> 1066
    //   1887: astore 12
    //   1889: iconst_4
    //   1890: new 270	java/lang/StringBuilder
    //   1893: dup
    //   1894: invokespecial 271	java/lang/StringBuilder:<init>	()V
    //   1897: ldc_w 597
    //   1900: invokevirtual 277	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1903: aload 12
    //   1905: invokevirtual 630	java/lang/ClassNotFoundException:getMessage	()Ljava/lang/String;
    //   1908: invokevirtual 277	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1911: invokevirtual 283	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1914: invokestatic 524	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   1917: iconst_2
    //   1918: ldc_w 600
    //   1921: invokestatic 524	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   1924: getstatic 97	com/tencent/thumbplayer/core/common/TPCodecUtils:mIsLocalCacheEnabled	Z
    //   1927: ifeq +30 -> 1957
    //   1930: getstatic 138	com/tencent/thumbplayer/core/common/TPCodecUtils:mHWCodecCapListKey	Ljava/lang/String;
    //   1933: getstatic 112	com/tencent/thumbplayer/core/common/TPCodecUtils:mHWCodecCapList	Ljava/util/ArrayList;
    //   1936: invokestatic 602	com/tencent/thumbplayer/core/common/TPCodecUtils:cacheCapList	(Ljava/lang/String;Ljava/util/ArrayList;)V
    //   1939: getstatic 150	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMapKey	Ljava/lang/String;
    //   1942: getstatic 248	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMap	Ljava/util/HashMap;
    //   1945: invokestatic 604	com/tencent/thumbplayer/core/common/TPCodecUtils:cacheCapabilityMap	(Ljava/lang/String;Ljava/util/HashMap;)V
    //   1948: iconst_2
    //   1949: ldc 32
    //   1951: ldc_w 606
    //   1954: invokestatic 225	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;Ljava/lang/String;)V
    //   1957: iconst_1
    //   1958: putstatic 227	com/tencent/thumbplayer/core/common/TPCodecUtils:mIsMediaCodecCapGot	Z
    //   1961: getstatic 248	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMap	Ljava/util/HashMap;
    //   1964: astore 12
    //   1966: goto -1934 -> 32
    //   1969: getstatic 238	com/tencent/thumbplayer/core/common/TPCodecUtils:mHEVCMediaCodecMaxCapability	Lcom/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability;
    //   1972: getfield 568	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability:maxLumaSamples	I
    //   1975: ldc_w 607
    //   1978: if_icmplt +81 -> 2059
    //   1981: getstatic 238	com/tencent/thumbplayer/core/common/TPCodecUtils:mHEVCMediaCodecMaxCapability	Lcom/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability;
    //   1984: getstatic 578	com/tencent/thumbplayer/core/common/TPDecoderType:TP_VIDEO_DECODER_MEDIACODEC	I
    //   1987: sipush 172
    //   1990: sipush 1280
    //   1993: sipush 720
    //   1996: invokestatic 580	com/tencent/thumbplayer/core/common/TPCodecUtils:getMaxSupportedFrameRatesFor	(IIII)I
    //   1999: putfield 583	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability:maxFramerateFormaxLumaSamples	I
    //   2002: goto -936 -> 1066
    //   2005: astore 12
    //   2007: iconst_2
    //   2008: ldc_w 600
    //   2011: invokestatic 524	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   2014: getstatic 97	com/tencent/thumbplayer/core/common/TPCodecUtils:mIsLocalCacheEnabled	Z
    //   2017: ifeq +30 -> 2047
    //   2020: getstatic 138	com/tencent/thumbplayer/core/common/TPCodecUtils:mHWCodecCapListKey	Ljava/lang/String;
    //   2023: getstatic 112	com/tencent/thumbplayer/core/common/TPCodecUtils:mHWCodecCapList	Ljava/util/ArrayList;
    //   2026: invokestatic 602	com/tencent/thumbplayer/core/common/TPCodecUtils:cacheCapList	(Ljava/lang/String;Ljava/util/ArrayList;)V
    //   2029: getstatic 150	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMapKey	Ljava/lang/String;
    //   2032: getstatic 248	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMap	Ljava/util/HashMap;
    //   2035: invokestatic 604	com/tencent/thumbplayer/core/common/TPCodecUtils:cacheCapabilityMap	(Ljava/lang/String;Ljava/util/HashMap;)V
    //   2038: iconst_2
    //   2039: ldc 32
    //   2041: ldc_w 606
    //   2044: invokestatic 225	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;Ljava/lang/String;)V
    //   2047: iconst_1
    //   2048: putstatic 227	com/tencent/thumbplayer/core/common/TPCodecUtils:mIsMediaCodecCapGot	Z
    //   2051: getstatic 248	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMap	Ljava/util/HashMap;
    //   2054: astore 12
    //   2056: goto -2024 -> 32
    //   2059: getstatic 238	com/tencent/thumbplayer/core/common/TPCodecUtils:mHEVCMediaCodecMaxCapability	Lcom/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability;
    //   2062: bipush 30
    //   2064: putfield 583	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability:maxFramerateFormaxLumaSamples	I
    //   2067: goto -1001 -> 1066
    //   2070: getstatic 248	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMap	Ljava/util/HashMap;
    //   2073: sipush 172
    //   2076: invokestatic 205	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2079: invokevirtual 612	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   2082: ifeq +101 -> 2183
    //   2085: iconst_2
    //   2086: new 270	java/lang/StringBuilder
    //   2089: dup
    //   2090: invokespecial 271	java/lang/StringBuilder:<init>	()V
    //   2093: ldc_w 632
    //   2096: invokevirtual 277	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2099: getstatic 248	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMap	Ljava/util/HashMap;
    //   2102: sipush 172
    //   2105: invokestatic 205	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2108: invokevirtual 615	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   2111: checkcast 231	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability
    //   2114: getfield 571	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability:maxProfile	I
    //   2117: invokevirtual 468	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2120: ldc_w 617
    //   2123: invokevirtual 277	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2126: getstatic 248	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMap	Ljava/util/HashMap;
    //   2129: sipush 172
    //   2132: invokestatic 205	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2135: invokevirtual 615	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   2138: checkcast 231	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability
    //   2141: getfield 574	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability:maxLevel	I
    //   2144: invokevirtual 468	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2147: ldc_w 619
    //   2150: invokevirtual 277	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2153: getstatic 248	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMap	Ljava/util/HashMap;
    //   2156: sipush 172
    //   2159: invokestatic 205	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2162: invokevirtual 615	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   2165: checkcast 231	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability
    //   2168: getfield 568	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability:maxLumaSamples	I
    //   2171: invokevirtual 468	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2174: invokevirtual 283	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2177: invokestatic 524	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   2180: goto +389 -> 2569
    //   2183: iconst_2
    //   2184: ldc_w 634
    //   2187: invokestatic 524	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   2190: goto +379 -> 2569
    //   2193: getstatic 248	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMap	Ljava/util/HashMap;
    //   2196: sipush 166
    //   2199: invokestatic 205	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2202: invokevirtual 612	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   2205: ifeq +134 -> 2339
    //   2208: iconst_2
    //   2209: new 270	java/lang/StringBuilder
    //   2212: dup
    //   2213: invokespecial 271	java/lang/StringBuilder:<init>	()V
    //   2216: ldc_w 636
    //   2219: invokevirtual 277	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2222: getstatic 248	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMap	Ljava/util/HashMap;
    //   2225: sipush 166
    //   2228: invokestatic 205	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2231: invokevirtual 615	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   2234: checkcast 231	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability
    //   2237: getfield 571	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability:maxProfile	I
    //   2240: invokevirtual 468	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2243: ldc_w 617
    //   2246: invokevirtual 277	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2249: getstatic 248	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMap	Ljava/util/HashMap;
    //   2252: sipush 166
    //   2255: invokestatic 205	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2258: invokevirtual 615	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   2261: checkcast 231	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability
    //   2264: getfield 574	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability:maxLevel	I
    //   2267: invokevirtual 468	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2270: ldc_w 619
    //   2273: invokevirtual 277	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2276: getstatic 248	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMap	Ljava/util/HashMap;
    //   2279: sipush 166
    //   2282: invokestatic 205	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2285: invokevirtual 615	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   2288: checkcast 231	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability
    //   2291: getfield 568	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability:maxLumaSamples	I
    //   2294: invokevirtual 468	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2297: invokevirtual 283	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2300: invokestatic 524	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   2303: iconst_1
    //   2304: istore_0
    //   2305: iconst_2
    //   2306: new 270	java/lang/StringBuilder
    //   2309: dup
    //   2310: invokespecial 271	java/lang/StringBuilder:<init>	()V
    //   2313: ldc_w 638
    //   2316: invokevirtual 277	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2319: getstatic 248	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMap	Ljava/util/HashMap;
    //   2322: invokevirtual 463	java/util/HashMap:size	()I
    //   2325: invokevirtual 468	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2328: invokevirtual 283	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2331: invokestatic 524	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   2334: iload_3
    //   2335: istore_1
    //   2336: goto +212 -> 2548
    //   2339: iconst_2
    //   2340: ldc_w 640
    //   2343: invokestatic 524	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   2346: goto -43 -> 2303
    //   2349: astore 23
    //   2351: iconst_1
    //   2352: istore_1
    //   2353: iconst_4
    //   2354: new 270	java/lang/StringBuilder
    //   2357: dup
    //   2358: invokespecial 271	java/lang/StringBuilder:<init>	()V
    //   2361: ldc_w 642
    //   2364: invokevirtual 277	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2367: aload 23
    //   2369: invokevirtual 591	java/lang/RuntimeException:getMessage	()Ljava/lang/String;
    //   2372: invokevirtual 277	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2375: invokevirtual 283	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2378: invokestatic 524	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   2381: iload_1
    //   2382: istore_0
    //   2383: goto -78 -> 2305
    //   2386: iconst_2
    //   2387: ldc_w 600
    //   2390: invokestatic 524	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   2393: getstatic 97	com/tencent/thumbplayer/core/common/TPCodecUtils:mIsLocalCacheEnabled	Z
    //   2396: ifeq +30 -> 2426
    //   2399: getstatic 138	com/tencent/thumbplayer/core/common/TPCodecUtils:mHWCodecCapListKey	Ljava/lang/String;
    //   2402: getstatic 112	com/tencent/thumbplayer/core/common/TPCodecUtils:mHWCodecCapList	Ljava/util/ArrayList;
    //   2405: invokestatic 602	com/tencent/thumbplayer/core/common/TPCodecUtils:cacheCapList	(Ljava/lang/String;Ljava/util/ArrayList;)V
    //   2408: getstatic 150	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMapKey	Ljava/lang/String;
    //   2411: getstatic 248	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMap	Ljava/util/HashMap;
    //   2414: invokestatic 604	com/tencent/thumbplayer/core/common/TPCodecUtils:cacheCapabilityMap	(Ljava/lang/String;Ljava/util/HashMap;)V
    //   2417: iconst_2
    //   2418: ldc 32
    //   2420: ldc_w 606
    //   2423: invokestatic 225	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;Ljava/lang/String;)V
    //   2426: iconst_1
    //   2427: putstatic 227	com/tencent/thumbplayer/core/common/TPCodecUtils:mIsMediaCodecCapGot	Z
    //   2430: getstatic 248	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMap	Ljava/util/HashMap;
    //   2433: astore 12
    //   2435: goto -2403 -> 32
    //   2438: astore 12
    //   2440: iconst_4
    //   2441: new 270	java/lang/StringBuilder
    //   2444: dup
    //   2445: invokespecial 271	java/lang/StringBuilder:<init>	()V
    //   2448: ldc_w 597
    //   2451: invokevirtual 277	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2454: aload 12
    //   2456: invokevirtual 591	java/lang/RuntimeException:getMessage	()Ljava/lang/String;
    //   2459: invokevirtual 277	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2462: invokevirtual 283	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2465: invokestatic 524	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   2468: iconst_2
    //   2469: ldc_w 600
    //   2472: invokestatic 524	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   2475: getstatic 97	com/tencent/thumbplayer/core/common/TPCodecUtils:mIsLocalCacheEnabled	Z
    //   2478: ifeq +30 -> 2508
    //   2481: getstatic 138	com/tencent/thumbplayer/core/common/TPCodecUtils:mHWCodecCapListKey	Ljava/lang/String;
    //   2484: getstatic 112	com/tencent/thumbplayer/core/common/TPCodecUtils:mHWCodecCapList	Ljava/util/ArrayList;
    //   2487: invokestatic 602	com/tencent/thumbplayer/core/common/TPCodecUtils:cacheCapList	(Ljava/lang/String;Ljava/util/ArrayList;)V
    //   2490: getstatic 150	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMapKey	Ljava/lang/String;
    //   2493: getstatic 248	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMap	Ljava/util/HashMap;
    //   2496: invokestatic 604	com/tencent/thumbplayer/core/common/TPCodecUtils:cacheCapabilityMap	(Ljava/lang/String;Ljava/util/HashMap;)V
    //   2499: iconst_2
    //   2500: ldc 32
    //   2502: ldc_w 606
    //   2505: invokestatic 225	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;Ljava/lang/String;)V
    //   2508: iconst_1
    //   2509: putstatic 227	com/tencent/thumbplayer/core/common/TPCodecUtils:mIsMediaCodecCapGot	Z
    //   2512: getstatic 248	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMap	Ljava/util/HashMap;
    //   2515: astore 12
    //   2517: goto -2485 -> 32
    //   2520: astore 12
    //   2522: ldc 2
    //   2524: monitorexit
    //   2525: aload 12
    //   2527: athrow
    //   2528: goto -1640 -> 888
    //   2531: iload 4
    //   2533: iconst_1
    //   2534: iadd
    //   2535: istore 4
    //   2537: iload_3
    //   2538: istore_2
    //   2539: iload 6
    //   2541: istore_0
    //   2542: iload 7
    //   2544: istore_1
    //   2545: goto -2130 -> 415
    //   2548: iload 5
    //   2550: iconst_1
    //   2551: iadd
    //   2552: istore 5
    //   2554: goto -2035 -> 519
    //   2557: iload_2
    //   2558: iconst_1
    //   2559: iadd
    //   2560: istore_2
    //   2561: goto -1874 -> 687
    //   2564: iconst_1
    //   2565: istore_2
    //   2566: goto -1678 -> 888
    //   2569: iconst_1
    //   2570: istore_3
    //   2571: goto -887 -> 1684
    // Local variable table:
    //   start	length	slot	name	signature
    //   214	2328	0	i	int
    //   212	2333	1	j	int
    //   210	2356	2	k	int
    //   463	2108	3	m	int
    //   413	2123	4	n	int
    //   517	2036	5	i1	int
    //   465	2075	6	i2	int
    //   468	2075	7	i3	int
    //   385	35	8	i4	int
    //   514	18	9	i5	int
    //   735	1074	10	i6	int
    //   640	1058	11	bool	boolean
    //   30	143	12	localObject1	Object
    //   177	19	12	localException	Exception
    //   221	202	12	localObject2	Object
    //   1123	17	12	localInvocationTargetException	java.lang.reflect.InvocationTargetException
    //   1200	1	12	localHashMap1	HashMap
    //   1240	17	12	localNoSuchMethodException	java.lang.NoSuchMethodException
    //   1317	1	12	localHashMap2	HashMap
    //   1333	17	12	localIllegalAccessException	java.lang.IllegalAccessException
    //   1410	1	12	localHashMap3	HashMap
    //   1534	17	12	localNoSuchFieldException	java.lang.NoSuchFieldException
    //   1611	1	12	localHashMap4	HashMap
    //   1887	17	12	localClassNotFoundException	java.lang.ClassNotFoundException
    //   1964	1	12	localHashMap5	HashMap
    //   2005	1	12	localObject3	Object
    //   2054	380	12	localHashMap6	HashMap
    //   2438	17	12	localRuntimeException1	java.lang.RuntimeException
    //   2515	1	12	localHashMap7	HashMap
    //   2520	6	12	localObject4	Object
    //   277	216	13	localMethod1	Method
    //   291	183	14	localMethod2	Method
    //   305	138	15	localMethod3	Method
    //   263	1448	16	localObject5	Object
    //   339	1370	17	localField1	Field
    //   357	1399	18	localField2	Field
    //   347	1424	19	localObject6	Object
    //   235	1478	20	localObject7	Object
    //   490	110	21	str	String
    //   509	26	22	arrayOfString	String[]
    //   539	154	23	localObject8	Object
    //   856	19	23	localRuntimeException2	java.lang.RuntimeException
    //   940	14	23	arrayOfObject1	Object[]
    //   1652	19	23	localRuntimeException3	java.lang.RuntimeException
    //   1736	14	23	arrayOfObject2	Object[]
    //   2349	19	23	localRuntimeException4	java.lang.RuntimeException
    //   696	1077	24	localObject9	Object
    // Exception table:
    //   from	to	target	type
    //   38	74	177	java/lang/Exception
    //   74	82	177	java/lang/Exception
    //   87	92	177	java/lang/Exception
    //   92	115	177	java/lang/Exception
    //   120	174	177	java/lang/Exception
    //   651	685	856	java/lang/RuntimeException
    //   698	804	856	java/lang/RuntimeException
    //   804	818	856	java/lang/RuntimeException
    //   821	853	856	java/lang/RuntimeException
    //   1088	1120	856	java/lang/RuntimeException
    //   1205	1237	856	java/lang/RuntimeException
    //   1322	1330	856	java/lang/RuntimeException
    //   1415	1521	856	java/lang/RuntimeException
    //   1524	1531	856	java/lang/RuntimeException
    //   215	412	1123	java/lang/reflect/InvocationTargetException
    //   422	462	1123	java/lang/reflect/InvocationTargetException
    //   473	516	1123	java/lang/reflect/InvocationTargetException
    //   541	610	1123	java/lang/reflect/InvocationTargetException
    //   610	619	1123	java/lang/reflect/InvocationTargetException
    //   622	642	1123	java/lang/reflect/InvocationTargetException
    //   651	685	1123	java/lang/reflect/InvocationTargetException
    //   698	804	1123	java/lang/reflect/InvocationTargetException
    //   804	818	1123	java/lang/reflect/InvocationTargetException
    //   821	853	1123	java/lang/reflect/InvocationTargetException
    //   860	888	1123	java/lang/reflect/InvocationTargetException
    //   888	899	1123	java/lang/reflect/InvocationTargetException
    //   912	946	1123	java/lang/reflect/InvocationTargetException
    //   959	1066	1123	java/lang/reflect/InvocationTargetException
    //   1066	1081	1123	java/lang/reflect/InvocationTargetException
    //   1088	1120	1123	java/lang/reflect/InvocationTargetException
    //   1205	1237	1123	java/lang/reflect/InvocationTargetException
    //   1322	1330	1123	java/lang/reflect/InvocationTargetException
    //   1415	1521	1123	java/lang/reflect/InvocationTargetException
    //   1524	1531	1123	java/lang/reflect/InvocationTargetException
    //   1616	1649	1123	java/lang/reflect/InvocationTargetException
    //   1656	1684	1123	java/lang/reflect/InvocationTargetException
    //   1684	1695	1123	java/lang/reflect/InvocationTargetException
    //   1708	1742	1123	java/lang/reflect/InvocationTargetException
    //   1755	1844	1123	java/lang/reflect/InvocationTargetException
    //   1851	1884	1123	java/lang/reflect/InvocationTargetException
    //   1969	2002	1123	java/lang/reflect/InvocationTargetException
    //   2059	2067	1123	java/lang/reflect/InvocationTargetException
    //   2070	2180	1123	java/lang/reflect/InvocationTargetException
    //   2183	2190	1123	java/lang/reflect/InvocationTargetException
    //   2193	2303	1123	java/lang/reflect/InvocationTargetException
    //   2305	2334	1123	java/lang/reflect/InvocationTargetException
    //   2339	2346	1123	java/lang/reflect/InvocationTargetException
    //   2353	2381	1123	java/lang/reflect/InvocationTargetException
    //   215	412	1240	java/lang/NoSuchMethodException
    //   422	462	1240	java/lang/NoSuchMethodException
    //   473	516	1240	java/lang/NoSuchMethodException
    //   541	610	1240	java/lang/NoSuchMethodException
    //   610	619	1240	java/lang/NoSuchMethodException
    //   622	642	1240	java/lang/NoSuchMethodException
    //   651	685	1240	java/lang/NoSuchMethodException
    //   698	804	1240	java/lang/NoSuchMethodException
    //   804	818	1240	java/lang/NoSuchMethodException
    //   821	853	1240	java/lang/NoSuchMethodException
    //   860	888	1240	java/lang/NoSuchMethodException
    //   888	899	1240	java/lang/NoSuchMethodException
    //   912	946	1240	java/lang/NoSuchMethodException
    //   959	1066	1240	java/lang/NoSuchMethodException
    //   1066	1081	1240	java/lang/NoSuchMethodException
    //   1088	1120	1240	java/lang/NoSuchMethodException
    //   1205	1237	1240	java/lang/NoSuchMethodException
    //   1322	1330	1240	java/lang/NoSuchMethodException
    //   1415	1521	1240	java/lang/NoSuchMethodException
    //   1524	1531	1240	java/lang/NoSuchMethodException
    //   1616	1649	1240	java/lang/NoSuchMethodException
    //   1656	1684	1240	java/lang/NoSuchMethodException
    //   1684	1695	1240	java/lang/NoSuchMethodException
    //   1708	1742	1240	java/lang/NoSuchMethodException
    //   1755	1844	1240	java/lang/NoSuchMethodException
    //   1851	1884	1240	java/lang/NoSuchMethodException
    //   1969	2002	1240	java/lang/NoSuchMethodException
    //   2059	2067	1240	java/lang/NoSuchMethodException
    //   2070	2180	1240	java/lang/NoSuchMethodException
    //   2183	2190	1240	java/lang/NoSuchMethodException
    //   2193	2303	1240	java/lang/NoSuchMethodException
    //   2305	2334	1240	java/lang/NoSuchMethodException
    //   2339	2346	1240	java/lang/NoSuchMethodException
    //   2353	2381	1240	java/lang/NoSuchMethodException
    //   215	412	1333	java/lang/IllegalAccessException
    //   422	462	1333	java/lang/IllegalAccessException
    //   473	516	1333	java/lang/IllegalAccessException
    //   541	610	1333	java/lang/IllegalAccessException
    //   610	619	1333	java/lang/IllegalAccessException
    //   622	642	1333	java/lang/IllegalAccessException
    //   651	685	1333	java/lang/IllegalAccessException
    //   698	804	1333	java/lang/IllegalAccessException
    //   804	818	1333	java/lang/IllegalAccessException
    //   821	853	1333	java/lang/IllegalAccessException
    //   860	888	1333	java/lang/IllegalAccessException
    //   888	899	1333	java/lang/IllegalAccessException
    //   912	946	1333	java/lang/IllegalAccessException
    //   959	1066	1333	java/lang/IllegalAccessException
    //   1066	1081	1333	java/lang/IllegalAccessException
    //   1088	1120	1333	java/lang/IllegalAccessException
    //   1205	1237	1333	java/lang/IllegalAccessException
    //   1322	1330	1333	java/lang/IllegalAccessException
    //   1415	1521	1333	java/lang/IllegalAccessException
    //   1524	1531	1333	java/lang/IllegalAccessException
    //   1616	1649	1333	java/lang/IllegalAccessException
    //   1656	1684	1333	java/lang/IllegalAccessException
    //   1684	1695	1333	java/lang/IllegalAccessException
    //   1708	1742	1333	java/lang/IllegalAccessException
    //   1755	1844	1333	java/lang/IllegalAccessException
    //   1851	1884	1333	java/lang/IllegalAccessException
    //   1969	2002	1333	java/lang/IllegalAccessException
    //   2059	2067	1333	java/lang/IllegalAccessException
    //   2070	2180	1333	java/lang/IllegalAccessException
    //   2183	2190	1333	java/lang/IllegalAccessException
    //   2193	2303	1333	java/lang/IllegalAccessException
    //   2305	2334	1333	java/lang/IllegalAccessException
    //   2339	2346	1333	java/lang/IllegalAccessException
    //   2353	2381	1333	java/lang/IllegalAccessException
    //   215	412	1534	java/lang/NoSuchFieldException
    //   422	462	1534	java/lang/NoSuchFieldException
    //   473	516	1534	java/lang/NoSuchFieldException
    //   541	610	1534	java/lang/NoSuchFieldException
    //   610	619	1534	java/lang/NoSuchFieldException
    //   622	642	1534	java/lang/NoSuchFieldException
    //   651	685	1534	java/lang/NoSuchFieldException
    //   698	804	1534	java/lang/NoSuchFieldException
    //   804	818	1534	java/lang/NoSuchFieldException
    //   821	853	1534	java/lang/NoSuchFieldException
    //   860	888	1534	java/lang/NoSuchFieldException
    //   888	899	1534	java/lang/NoSuchFieldException
    //   912	946	1534	java/lang/NoSuchFieldException
    //   959	1066	1534	java/lang/NoSuchFieldException
    //   1066	1081	1534	java/lang/NoSuchFieldException
    //   1088	1120	1534	java/lang/NoSuchFieldException
    //   1205	1237	1534	java/lang/NoSuchFieldException
    //   1322	1330	1534	java/lang/NoSuchFieldException
    //   1415	1521	1534	java/lang/NoSuchFieldException
    //   1524	1531	1534	java/lang/NoSuchFieldException
    //   1616	1649	1534	java/lang/NoSuchFieldException
    //   1656	1684	1534	java/lang/NoSuchFieldException
    //   1684	1695	1534	java/lang/NoSuchFieldException
    //   1708	1742	1534	java/lang/NoSuchFieldException
    //   1755	1844	1534	java/lang/NoSuchFieldException
    //   1851	1884	1534	java/lang/NoSuchFieldException
    //   1969	2002	1534	java/lang/NoSuchFieldException
    //   2059	2067	1534	java/lang/NoSuchFieldException
    //   2070	2180	1534	java/lang/NoSuchFieldException
    //   2183	2190	1534	java/lang/NoSuchFieldException
    //   2193	2303	1534	java/lang/NoSuchFieldException
    //   2305	2334	1534	java/lang/NoSuchFieldException
    //   2339	2346	1534	java/lang/NoSuchFieldException
    //   2353	2381	1534	java/lang/NoSuchFieldException
    //   912	946	1652	java/lang/RuntimeException
    //   959	1066	1652	java/lang/RuntimeException
    //   1066	1081	1652	java/lang/RuntimeException
    //   1616	1649	1652	java/lang/RuntimeException
    //   1851	1884	1652	java/lang/RuntimeException
    //   1969	2002	1652	java/lang/RuntimeException
    //   2059	2067	1652	java/lang/RuntimeException
    //   2070	2180	1652	java/lang/RuntimeException
    //   2183	2190	1652	java/lang/RuntimeException
    //   215	412	1887	java/lang/ClassNotFoundException
    //   422	462	1887	java/lang/ClassNotFoundException
    //   473	516	1887	java/lang/ClassNotFoundException
    //   541	610	1887	java/lang/ClassNotFoundException
    //   610	619	1887	java/lang/ClassNotFoundException
    //   622	642	1887	java/lang/ClassNotFoundException
    //   651	685	1887	java/lang/ClassNotFoundException
    //   698	804	1887	java/lang/ClassNotFoundException
    //   804	818	1887	java/lang/ClassNotFoundException
    //   821	853	1887	java/lang/ClassNotFoundException
    //   860	888	1887	java/lang/ClassNotFoundException
    //   888	899	1887	java/lang/ClassNotFoundException
    //   912	946	1887	java/lang/ClassNotFoundException
    //   959	1066	1887	java/lang/ClassNotFoundException
    //   1066	1081	1887	java/lang/ClassNotFoundException
    //   1088	1120	1887	java/lang/ClassNotFoundException
    //   1205	1237	1887	java/lang/ClassNotFoundException
    //   1322	1330	1887	java/lang/ClassNotFoundException
    //   1415	1521	1887	java/lang/ClassNotFoundException
    //   1524	1531	1887	java/lang/ClassNotFoundException
    //   1616	1649	1887	java/lang/ClassNotFoundException
    //   1656	1684	1887	java/lang/ClassNotFoundException
    //   1684	1695	1887	java/lang/ClassNotFoundException
    //   1708	1742	1887	java/lang/ClassNotFoundException
    //   1755	1844	1887	java/lang/ClassNotFoundException
    //   1851	1884	1887	java/lang/ClassNotFoundException
    //   1969	2002	1887	java/lang/ClassNotFoundException
    //   2059	2067	1887	java/lang/ClassNotFoundException
    //   2070	2180	1887	java/lang/ClassNotFoundException
    //   2183	2190	1887	java/lang/ClassNotFoundException
    //   2193	2303	1887	java/lang/ClassNotFoundException
    //   2305	2334	1887	java/lang/ClassNotFoundException
    //   2339	2346	1887	java/lang/ClassNotFoundException
    //   2353	2381	1887	java/lang/ClassNotFoundException
    //   215	412	2005	finally
    //   422	462	2005	finally
    //   473	516	2005	finally
    //   541	610	2005	finally
    //   610	619	2005	finally
    //   622	642	2005	finally
    //   651	685	2005	finally
    //   698	804	2005	finally
    //   804	818	2005	finally
    //   821	853	2005	finally
    //   860	888	2005	finally
    //   888	899	2005	finally
    //   912	946	2005	finally
    //   959	1066	2005	finally
    //   1066	1081	2005	finally
    //   1088	1120	2005	finally
    //   1125	1153	2005	finally
    //   1205	1237	2005	finally
    //   1242	1270	2005	finally
    //   1322	1330	2005	finally
    //   1335	1363	2005	finally
    //   1415	1521	2005	finally
    //   1524	1531	2005	finally
    //   1536	1564	2005	finally
    //   1616	1649	2005	finally
    //   1656	1684	2005	finally
    //   1684	1695	2005	finally
    //   1708	1742	2005	finally
    //   1755	1844	2005	finally
    //   1851	1884	2005	finally
    //   1889	1917	2005	finally
    //   1969	2002	2005	finally
    //   2059	2067	2005	finally
    //   2070	2180	2005	finally
    //   2183	2190	2005	finally
    //   2193	2303	2005	finally
    //   2305	2334	2005	finally
    //   2339	2346	2005	finally
    //   2353	2381	2005	finally
    //   2440	2468	2005	finally
    //   1708	1742	2349	java/lang/RuntimeException
    //   1755	1844	2349	java/lang/RuntimeException
    //   2193	2303	2349	java/lang/RuntimeException
    //   2339	2346	2349	java/lang/RuntimeException
    //   215	412	2438	java/lang/RuntimeException
    //   422	462	2438	java/lang/RuntimeException
    //   473	516	2438	java/lang/RuntimeException
    //   541	610	2438	java/lang/RuntimeException
    //   610	619	2438	java/lang/RuntimeException
    //   622	642	2438	java/lang/RuntimeException
    //   860	888	2438	java/lang/RuntimeException
    //   888	899	2438	java/lang/RuntimeException
    //   1656	1684	2438	java/lang/RuntimeException
    //   1684	1695	2438	java/lang/RuntimeException
    //   2305	2334	2438	java/lang/RuntimeException
    //   2353	2381	2438	java/lang/RuntimeException
    //   3	32	2520	finally
    //   38	74	2520	finally
    //   74	82	2520	finally
    //   87	92	2520	finally
    //   92	115	2520	finally
    //   120	174	2520	finally
    //   179	209	2520	finally
    //   1153	1193	2520	finally
    //   1193	1202	2520	finally
    //   1270	1310	2520	finally
    //   1310	1319	2520	finally
    //   1363	1403	2520	finally
    //   1403	1412	2520	finally
    //   1564	1604	2520	finally
    //   1604	1613	2520	finally
    //   1917	1957	2520	finally
    //   1957	1966	2520	finally
    //   2007	2047	2520	finally
    //   2047	2056	2520	finally
    //   2386	2426	2520	finally
    //   2426	2435	2520	finally
    //   2468	2508	2520	finally
    //   2508	2517	2520	finally
  }
  
  public static int getSWDecodeLevel()
  {
    String str = TPSystemInfo.getCpuHarewareName();
    int i = TPSystemInfo.getCpuHWProducter(str);
    int j = TPSystemInfo.getCpuHWProductIndex(str);
    TPNativeLog.printLog(2, "TPCodecUtils", "[getSWDecodeLevel], mCpuHWProducter = " + i + ", getMaxCpuFreq() = " + TPSystemInfo.getMaxCpuFreq() + ", numCores = " + TPSystemInfo.getNumCores() + ", mCpuHWProductIdx=" + j);
    if (-1 != mDeviceLevel) {
      return mDeviceLevel;
    }
    mDeviceLevel = 0;
    if (-1 == i) {
      mDeviceLevel = getHevcLvByCoresAndFreq();
    }
    for (;;)
    {
      return mDeviceLevel;
      switch (i)
      {
      default: 
        break;
      case 0: 
        if (j >= mShdHevcQualcommIndex) {
          mDeviceLevel = 21;
        } else if (j >= mHdHevcQualcommIndex) {
          mDeviceLevel = 16;
        } else {
          mDeviceLevel = getHevcLvByCoresAndFreq();
        }
        break;
      case 1: 
        if (j >= mShdHevcMtkIndex) {
          mDeviceLevel = 21;
        } else if (j >= mHdHevcMtkIndex) {
          mDeviceLevel = 16;
        } else {
          mDeviceLevel = getHevcLvByCoresAndFreq();
        }
        break;
      case 2: 
        if (j >= mShdHevcHisiIndex) {
          mDeviceLevel = 21;
        } else if (j >= mHdHevcHisiIndex) {
          mDeviceLevel = 16;
        } else {
          mDeviceLevel = getHevcLvByCoresAndFreq();
        }
        break;
      case 3: 
        if (j >= mShdHevcSumsingIndex) {
          mDeviceLevel = 21;
        } else if (j >= mHdHevcSumsingIndex) {
          mDeviceLevel = 16;
        } else {
          mDeviceLevel = getHevcLvByCoresAndFreq();
        }
        break;
      }
    }
  }
  
  public static HashMap<Integer, TPCodecCapability.TPVCodecMaxCapability> getVCodecSWMaxCapabilityMap()
  {
    int j = 407040;
    for (;;)
    {
      try
      {
        TPNativeLog.printLog(2, "TPCodecUtils", "getVCodecSWMaxCapabilityMap func in");
        HashMap localHashMap;
        if (mIsFFmpegCapGot)
        {
          localHashMap = mMaxVCodecSwCapabilityMap;
          return localHashMap;
        }
        int i = j;
        try
        {
          switch (getSWDecodeLevel())
          {
          case 11: 
            mAVCSWMaxCapability.maxLumaSamples = i;
            mAVCSWMaxCapability.maxProfile = 64;
            mAVCSWMaxCapability.maxLevel = 65536;
            mMaxVCodecSwCapabilityMap.put(Integer.valueOf(26), mAVCSWMaxCapability);
            mffmpegVCodecCapList.add("video/avc");
            mHEVCSWMaxCapability.maxLumaSamples = i;
            mHEVCSWMaxCapability.maxProfile = 2;
            mHEVCSWMaxCapability.maxLevel = 33554432;
            mMaxVCodecSwCapabilityMap.put(Integer.valueOf(172), mHEVCSWMaxCapability);
            mffmpegVCodecCapList.add("video/hevc");
            mVP9SWMaxCapability.maxLumaSamples = i;
            mVP9SWMaxCapability.maxProfile = 8;
            mVP9SWMaxCapability.maxLevel = 8192;
            mMaxVCodecSwCapabilityMap.put(Integer.valueOf(166), mVP9SWMaxCapability);
            mffmpegVCodecCapList.add("video/x-vnd.on2.vp9");
            TPNativeLog.printLog(2, "getVCodecSWMaxCapabilityMap success, maxLumaSamples:" + i);
            mIsFFmpegCapGot = true;
            localHashMap = mMaxVCodecSwCapabilityMap;
          }
        }
        catch (Exception localException)
        {
          TPNativeLog.printLog(4, "TPCodecUtils", "getVCodecSWMaxCapabilityMap exception");
          Object localObject1 = null;
        }
        i = 129600;
        continue;
        i = 307200;
        continue;
        i = 480000;
        continue;
        i = 921600;
        continue;
        i = 2073600;
        continue;
        i = 8294400;
        continue;
        i = 8847360;
        continue;
        continue;
        i = j;
      }
      finally {}
    }
  }
  
  /* Error */
  public static void init(Context paramContext, boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: iconst_2
    //   4: ldc 32
    //   6: new 270	java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial 271	java/lang/StringBuilder:<init>	()V
    //   13: ldc_w 687
    //   16: invokevirtual 277	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   19: iload_1
    //   20: invokevirtual 690	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   23: invokevirtual 283	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   26: invokestatic 225	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;Ljava/lang/String;)V
    //   29: aload_0
    //   30: invokevirtual 696	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   33: putstatic 95	com/tencent/thumbplayer/core/common/TPCodecUtils:mApplicationContext	Landroid/content/Context;
    //   36: iload_1
    //   37: putstatic 97	com/tencent/thumbplayer/core/common/TPCodecUtils:mIsLocalCacheEnabled	Z
    //   40: iload_1
    //   41: ifeq +37 -> 78
    //   44: getstatic 134	com/tencent/thumbplayer/core/common/TPCodecUtils:mCapabilityVersionKey	Ljava/lang/String;
    //   47: invokestatic 698	com/tencent/thumbplayer/core/common/TPCodecUtils:getCachedStringInfo	(Ljava/lang/String;)Ljava/lang/String;
    //   50: astore_0
    //   51: getstatic 105	com/tencent/thumbplayer/core/common/TPCodecUtils:mCapabilityVersion	Ljava/lang/String;
    //   54: aload_0
    //   55: invokevirtual 701	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   58: ifne +42 -> 100
    //   61: iconst_1
    //   62: putstatic 99	com/tencent/thumbplayer/core/common/TPCodecUtils:mNeedToReprobeDecoderCapability	Z
    //   65: iconst_1
    //   66: putstatic 101	com/tencent/thumbplayer/core/common/TPCodecUtils:mNeedToReprobeHDRCapability	Z
    //   69: iconst_2
    //   70: ldc 32
    //   72: ldc_w 703
    //   75: invokestatic 225	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;Ljava/lang/String;)V
    //   78: invokestatic 705	com/tencent/thumbplayer/core/common/TPCodecUtils:getDecoderMaxCapabilityMapAsync	()V
    //   81: getstatic 97	com/tencent/thumbplayer/core/common/TPCodecUtils:mIsLocalCacheEnabled	Z
    //   84: ifeq +12 -> 96
    //   87: getstatic 134	com/tencent/thumbplayer/core/common/TPCodecUtils:mCapabilityVersionKey	Ljava/lang/String;
    //   90: getstatic 105	com/tencent/thumbplayer/core/common/TPCodecUtils:mCapabilityVersion	Ljava/lang/String;
    //   93: invokestatic 707	com/tencent/thumbplayer/core/common/TPCodecUtils:cacheStringInfo	(Ljava/lang/String;Ljava/lang/String;)V
    //   96: ldc 2
    //   98: monitorexit
    //   99: return
    //   100: iconst_0
    //   101: putstatic 99	com/tencent/thumbplayer/core/common/TPCodecUtils:mNeedToReprobeDecoderCapability	Z
    //   104: iconst_0
    //   105: putstatic 101	com/tencent/thumbplayer/core/common/TPCodecUtils:mNeedToReprobeHDRCapability	Z
    //   108: iconst_2
    //   109: ldc 32
    //   111: ldc_w 709
    //   114: invokestatic 225	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;Ljava/lang/String;)V
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.thumbplayer.core.common.TPCodecUtils
 * JD-Core Version:    0.7.0.1
 */