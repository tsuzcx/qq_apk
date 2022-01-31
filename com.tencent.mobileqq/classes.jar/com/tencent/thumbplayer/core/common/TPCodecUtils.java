package com.tencent.thumbplayer.core.common;

import android.content.Context;
import android.media.MediaCodecInfo;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaCodecInfo.CodecProfileLevel;
import android.media.MediaCodecList;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
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
  private static String mPlayerCoreVersion;
  private static int mShdHevcHisiIndex;
  private static int mShdHevcMtkIndex;
  private static int mShdHevcQualcommIndex;
  private static int mShdHevcSumsingIndex;
  protected static ArrayList<String> mSoftCodecCapList;
  private static String mSoftCodecCapListKey;
  private static String mStoredPlayerCoreVersionKey;
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
    mPlayerCoreVersion = "2.3.1.1013.min";
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
    mStoredPlayerCoreVersionKey = "Playercore_version_Key";
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
    mAVCMediaCodecMaxCapability = new TPCodecCapability.TPVCodecMaxCapability(0, 0, 0);
    mHEVCMediaCodecMaxCapability = new TPCodecCapability.TPVCodecMaxCapability(0, 0, 0);
    mVP9MediaCodecMaxCapability = new TPCodecCapability.TPVCodecMaxCapability(0, 0, 0);
    mAVCSWMaxCapability = new TPCodecCapability.TPVCodecMaxCapability(0, 0, 0);
    mHEVCSWMaxCapability = new TPCodecCapability.TPVCodecMaxCapability(0, 0, 0);
    mVP9SWMaxCapability = new TPCodecCapability.TPVCodecMaxCapability(0, 0, 0);
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
  
  /* Error */
  public static HashMap<Integer, TPCodecCapability.TPVCodecMaxCapability> getMediaCodecMaxCapabilityMap()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: iconst_2
    //   4: ldc 32
    //   6: ldc_w 380
    //   9: invokestatic 225	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;Ljava/lang/String;)V
    //   12: getstatic 227	com/tencent/thumbplayer/core/common/TPCodecUtils:mIsMediaCodecCapGot	Z
    //   15: ifeq +23 -> 38
    //   18: iconst_2
    //   19: ldc 32
    //   21: ldc_w 382
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
    //   53: ldc_w 384
    //   56: invokestatic 225	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;Ljava/lang/String;)V
    //   59: getstatic 112	com/tencent/thumbplayer/core/common/TPCodecUtils:mHWCodecCapList	Ljava/util/ArrayList;
    //   62: ifnull +12 -> 74
    //   65: getstatic 112	com/tencent/thumbplayer/core/common/TPCodecUtils:mHWCodecCapList	Ljava/util/ArrayList;
    //   68: invokevirtual 387	java/util/ArrayList:size	()I
    //   71: ifne +21 -> 92
    //   74: getstatic 138	com/tencent/thumbplayer/core/common/TPCodecUtils:mHWCodecCapListKey	Ljava/lang/String;
    //   77: invokestatic 389	com/tencent/thumbplayer/core/common/TPCodecUtils:getCachedCapList	(Ljava/lang/String;)Ljava/util/ArrayList;
    //   80: astore 12
    //   82: aload 12
    //   84: ifnull +8 -> 92
    //   87: aload 12
    //   89: putstatic 112	com/tencent/thumbplayer/core/common/TPCodecUtils:mHWCodecCapList	Ljava/util/ArrayList;
    //   92: getstatic 112	com/tencent/thumbplayer/core/common/TPCodecUtils:mHWCodecCapList	Ljava/util/ArrayList;
    //   95: ifnull +114 -> 209
    //   98: getstatic 112	com/tencent/thumbplayer/core/common/TPCodecUtils:mHWCodecCapList	Ljava/util/ArrayList;
    //   101: invokevirtual 387	java/util/ArrayList:size	()I
    //   104: ifle +105 -> 209
    //   107: getstatic 150	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMapKey	Ljava/lang/String;
    //   110: invokestatic 391	com/tencent/thumbplayer/core/common/TPCodecUtils:getCachedCapabilityMap	(Ljava/lang/String;)Ljava/util/HashMap;
    //   113: astore 12
    //   115: aload 12
    //   117: ifnull +92 -> 209
    //   120: aload 12
    //   122: putstatic 248	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMap	Ljava/util/HashMap;
    //   125: getstatic 248	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMap	Ljava/util/HashMap;
    //   128: invokevirtual 392	java/util/HashMap:size	()I
    //   131: ifle +78 -> 209
    //   134: iconst_2
    //   135: ldc 32
    //   137: new 270	java/lang/StringBuilder
    //   140: dup
    //   141: invokespecial 271	java/lang/StringBuilder:<init>	()V
    //   144: ldc_w 394
    //   147: invokevirtual 277	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   150: getstatic 248	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMap	Ljava/util/HashMap;
    //   153: invokevirtual 392	java/util/HashMap:size	()I
    //   156: invokevirtual 397	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
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
    //   189: ldc_w 399
    //   192: invokevirtual 277	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   195: aload 12
    //   197: invokevirtual 402	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   200: invokevirtual 277	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   203: invokevirtual 283	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   206: invokestatic 225	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;Ljava/lang/String;)V
    //   209: iconst_0
    //   210: istore_2
    //   211: iconst_0
    //   212: istore_1
    //   213: iconst_0
    //   214: istore_0
    //   215: ldc_w 404
    //   218: invokestatic 410	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   221: astore 12
    //   223: aload 12
    //   225: ldc_w 412
    //   228: iconst_0
    //   229: anewarray 406	java/lang/Class
    //   232: invokevirtual 416	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   235: astore 20
    //   237: aload 12
    //   239: ldc_w 418
    //   242: iconst_1
    //   243: anewarray 406	java/lang/Class
    //   246: dup
    //   247: iconst_0
    //   248: getstatic 422	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   251: aastore
    //   252: invokevirtual 416	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   255: astore 12
    //   257: ldc_w 424
    //   260: invokestatic 410	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   263: astore 16
    //   265: aload 16
    //   267: ldc_w 426
    //   270: iconst_0
    //   271: anewarray 406	java/lang/Class
    //   274: invokevirtual 416	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   277: astore 13
    //   279: aload 16
    //   281: ldc_w 428
    //   284: iconst_0
    //   285: anewarray 406	java/lang/Class
    //   288: invokevirtual 416	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   291: astore 14
    //   293: aload 16
    //   295: ldc_w 430
    //   298: iconst_0
    //   299: anewarray 406	java/lang/Class
    //   302: invokevirtual 416	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   305: astore 15
    //   307: aload 16
    //   309: ldc_w 432
    //   312: iconst_1
    //   313: anewarray 406	java/lang/Class
    //   316: dup
    //   317: iconst_0
    //   318: ldc_w 434
    //   321: aastore
    //   322: invokevirtual 416	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   325: astore 16
    //   327: ldc_w 436
    //   330: invokestatic 410	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   333: ldc_w 438
    //   336: invokevirtual 442	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   339: astore 17
    //   341: ldc_w 444
    //   344: invokestatic 410	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   347: astore 19
    //   349: aload 19
    //   351: ldc_w 446
    //   354: invokevirtual 442	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   357: astore 18
    //   359: aload 19
    //   361: ldc_w 448
    //   364: invokevirtual 442	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   367: astore 19
    //   369: aload 20
    //   371: aconst_null
    //   372: iconst_0
    //   373: anewarray 4	java/lang/Object
    //   376: invokevirtual 454	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   379: checkcast 201	java/lang/Integer
    //   382: invokevirtual 457	java/lang/Integer:intValue	()I
    //   385: istore 8
    //   387: iconst_2
    //   388: new 270	java/lang/StringBuilder
    //   391: dup
    //   392: invokespecial 271	java/lang/StringBuilder:<init>	()V
    //   395: ldc_w 459
    //   398: invokevirtual 277	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   401: iload 8
    //   403: invokevirtual 397	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   406: invokevirtual 283	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   409: invokestatic 462	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   412: iconst_0
    //   413: istore 4
    //   415: iload 4
    //   417: iload 8
    //   419: if_icmpge +1297 -> 1716
    //   422: aload 12
    //   424: aconst_null
    //   425: iconst_1
    //   426: anewarray 4	java/lang/Object
    //   429: dup
    //   430: iconst_0
    //   431: iload 4
    //   433: invokestatic 205	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   436: aastore
    //   437: invokevirtual 454	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   440: astore 20
    //   442: aload 15
    //   444: aload 20
    //   446: iconst_0
    //   447: anewarray 4	java/lang/Object
    //   450: invokevirtual 454	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   453: checkcast 464	java/lang/Boolean
    //   456: invokevirtual 468	java/lang/Boolean:booleanValue	()Z
    //   459: ifeq +14 -> 473
    //   462: iload_2
    //   463: istore_3
    //   464: iload_0
    //   465: istore 6
    //   467: iload_1
    //   468: istore 7
    //   470: goto +1691 -> 2161
    //   473: aload 14
    //   475: aload 20
    //   477: iconst_0
    //   478: anewarray 4	java/lang/Object
    //   481: invokevirtual 454	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   484: checkcast 434	java/lang/String
    //   487: invokevirtual 471	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   490: astore 21
    //   492: aload 13
    //   494: aload 20
    //   496: iconst_0
    //   497: anewarray 4	java/lang/Object
    //   500: invokevirtual 454	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   503: checkcast 473	[Ljava/lang/String;
    //   506: checkcast 473	[Ljava/lang/String;
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
    //   531: if_icmpge +1630 -> 2161
    //   534: aload 22
    //   536: iload 5
    //   538: aaload
    //   539: astore 23
    //   541: iconst_2
    //   542: new 270	java/lang/StringBuilder
    //   545: dup
    //   546: invokespecial 271	java/lang/StringBuilder:<init>	()V
    //   549: ldc_w 475
    //   552: invokevirtual 277	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   555: aload 23
    //   557: invokevirtual 277	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   560: invokevirtual 283	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   563: invokestatic 462	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   566: aload 21
    //   568: ldc_w 477
    //   571: invokevirtual 481	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   574: ifne +36 -> 610
    //   577: aload 21
    //   579: ldc_w 483
    //   582: invokevirtual 481	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   585: ifne +25 -> 610
    //   588: aload 21
    //   590: ldc_w 485
    //   593: invokevirtual 481	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   596: ifne +14 -> 610
    //   599: aload 21
    //   601: ldc_w 487
    //   604: invokevirtual 481	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   607: ifeq +15 -> 622
    //   610: getstatic 114	com/tencent/thumbplayer/core/common/TPCodecUtils:mSoftCodecCapList	Ljava/util/ArrayList;
    //   613: aload 23
    //   615: invokevirtual 491	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   618: pop
    //   619: goto +1559 -> 2178
    //   622: getstatic 112	com/tencent/thumbplayer/core/common/TPCodecUtils:mHWCodecCapList	Ljava/util/ArrayList;
    //   625: aload 23
    //   627: invokevirtual 491	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   630: pop
    //   631: getstatic 112	com/tencent/thumbplayer/core/common/TPCodecUtils:mHWCodecCapList	Ljava/util/ArrayList;
    //   634: ldc_w 493
    //   637: invokevirtual 495	java/util/ArrayList:contains	(Ljava/lang/Object;)Z
    //   640: istore 11
    //   642: iload 11
    //   644: ifeq +1514 -> 2158
    //   647: iload_2
    //   648: ifne +1510 -> 2158
    //   651: aload 17
    //   653: aload 16
    //   655: aload 20
    //   657: iconst_1
    //   658: anewarray 4	java/lang/Object
    //   661: dup
    //   662: iconst_0
    //   663: ldc_w 493
    //   666: aastore
    //   667: invokevirtual 454	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   670: invokevirtual 500	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   673: checkcast 502	[Ljava/lang/Object;
    //   676: checkcast 502	[Ljava/lang/Object;
    //   679: astore 23
    //   681: aload 23
    //   683: arraylength
    //   684: istore_3
    //   685: iconst_0
    //   686: istore_2
    //   687: iload_2
    //   688: iload_3
    //   689: if_icmpge +100 -> 789
    //   692: aload 23
    //   694: iload_2
    //   695: aaload
    //   696: astore 24
    //   698: aload 18
    //   700: aload 24
    //   702: invokevirtual 500	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   705: checkcast 201	java/lang/Integer
    //   708: invokevirtual 457	java/lang/Integer:intValue	()I
    //   711: istore 6
    //   713: aload 19
    //   715: aload 24
    //   717: invokevirtual 500	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   720: checkcast 201	java/lang/Integer
    //   723: invokevirtual 457	java/lang/Integer:intValue	()I
    //   726: istore 7
    //   728: iload 7
    //   730: iload 6
    //   732: invokestatic 506	com/tencent/thumbplayer/core/common/TPCodecUtils:maxLumaSamplesForAVCProfileLevel	(II)I
    //   735: istore 10
    //   737: iload 10
    //   739: getstatic 236	com/tencent/thumbplayer/core/common/TPCodecUtils:mAVCMediaCodecMaxCapability	Lcom/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability;
    //   742: getfield 509	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability:maxLumaSamples	I
    //   745: if_icmplt +1442 -> 2187
    //   748: getstatic 236	com/tencent/thumbplayer/core/common/TPCodecUtils:mAVCMediaCodecMaxCapability	Lcom/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability;
    //   751: iload 10
    //   753: putfield 509	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability:maxLumaSamples	I
    //   756: getstatic 236	com/tencent/thumbplayer/core/common/TPCodecUtils:mAVCMediaCodecMaxCapability	Lcom/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability;
    //   759: iload 7
    //   761: putfield 512	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability:maxProfile	I
    //   764: getstatic 236	com/tencent/thumbplayer/core/common/TPCodecUtils:mAVCMediaCodecMaxCapability	Lcom/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability;
    //   767: iload 6
    //   769: putfield 515	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability:maxLevel	I
    //   772: bipush 26
    //   774: invokestatic 205	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   777: getstatic 236	com/tencent/thumbplayer/core/common/TPCodecUtils:mAVCMediaCodecMaxCapability	Lcom/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability;
    //   780: getstatic 248	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMap	Ljava/util/HashMap;
    //   783: invokestatic 519	com/tencent/thumbplayer/core/common/TPCodecUtils:replace	(Ljava/lang/Object;Ljava/lang/Object;Ljava/util/HashMap;)V
    //   786: goto +1401 -> 2187
    //   789: iconst_2
    //   790: new 270	java/lang/StringBuilder
    //   793: dup
    //   794: invokespecial 271	java/lang/StringBuilder:<init>	()V
    //   797: ldc_w 521
    //   800: invokevirtual 277	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   803: getstatic 248	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMap	Ljava/util/HashMap;
    //   806: bipush 26
    //   808: invokestatic 205	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   811: invokevirtual 522	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   814: checkcast 231	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability
    //   817: getfield 512	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability:maxProfile	I
    //   820: invokevirtual 397	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   823: ldc_w 524
    //   826: invokevirtual 277	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   829: getstatic 248	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMap	Ljava/util/HashMap;
    //   832: bipush 26
    //   834: invokestatic 205	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   837: invokevirtual 522	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   840: checkcast 231	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability
    //   843: getfield 515	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability:maxLevel	I
    //   846: invokevirtual 397	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   849: ldc_w 526
    //   852: invokevirtual 277	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   855: getstatic 248	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMap	Ljava/util/HashMap;
    //   858: bipush 26
    //   860: invokestatic 205	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   863: invokevirtual 522	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   866: checkcast 231	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability
    //   869: getfield 509	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability:maxLumaSamples	I
    //   872: invokevirtual 397	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   875: invokevirtual 283	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   878: invokestatic 462	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   881: iconst_1
    //   882: istore_2
    //   883: getstatic 112	com/tencent/thumbplayer/core/common/TPCodecUtils:mHWCodecCapList	Ljava/util/ArrayList;
    //   886: ldc_w 528
    //   889: invokevirtual 495	java/util/ArrayList:contains	(Ljava/lang/Object;)Z
    //   892: istore 11
    //   894: iload_1
    //   895: istore_3
    //   896: iload 11
    //   898: ifeq +366 -> 1264
    //   901: iload_1
    //   902: istore_3
    //   903: iload_1
    //   904: ifne +360 -> 1264
    //   907: aload 17
    //   909: aload 16
    //   911: aload 20
    //   913: iconst_1
    //   914: anewarray 4	java/lang/Object
    //   917: dup
    //   918: iconst_0
    //   919: ldc_w 528
    //   922: aastore
    //   923: invokevirtual 454	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   926: invokevirtual 500	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   929: checkcast 502	[Ljava/lang/Object;
    //   932: checkcast 502	[Ljava/lang/Object;
    //   935: astore 23
    //   937: aload 23
    //   939: arraylength
    //   940: istore_3
    //   941: iconst_0
    //   942: istore_1
    //   943: iload_1
    //   944: iload_3
    //   945: if_icmpge +222 -> 1167
    //   948: aload 23
    //   950: iload_1
    //   951: aaload
    //   952: astore 24
    //   954: aload 18
    //   956: aload 24
    //   958: invokevirtual 500	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   961: checkcast 201	java/lang/Integer
    //   964: invokevirtual 457	java/lang/Integer:intValue	()I
    //   967: istore 6
    //   969: aload 19
    //   971: aload 24
    //   973: invokevirtual 500	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   976: checkcast 201	java/lang/Integer
    //   979: invokevirtual 457	java/lang/Integer:intValue	()I
    //   982: istore 7
    //   984: iload 7
    //   986: iload 6
    //   988: invokestatic 531	com/tencent/thumbplayer/core/common/TPCodecUtils:maxLumaSamplesForHEVCProfileLevel	(II)I
    //   991: istore 10
    //   993: iload 10
    //   995: getstatic 238	com/tencent/thumbplayer/core/common/TPCodecUtils:mHEVCMediaCodecMaxCapability	Lcom/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability;
    //   998: getfield 509	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability:maxLumaSamples	I
    //   1001: if_icmplt +42 -> 1043
    //   1004: getstatic 238	com/tencent/thumbplayer/core/common/TPCodecUtils:mHEVCMediaCodecMaxCapability	Lcom/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability;
    //   1007: iload 10
    //   1009: putfield 509	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability:maxLumaSamples	I
    //   1012: getstatic 238	com/tencent/thumbplayer/core/common/TPCodecUtils:mHEVCMediaCodecMaxCapability	Lcom/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability;
    //   1015: iload 7
    //   1017: putfield 512	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability:maxProfile	I
    //   1020: getstatic 238	com/tencent/thumbplayer/core/common/TPCodecUtils:mHEVCMediaCodecMaxCapability	Lcom/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability;
    //   1023: iload 6
    //   1025: putfield 515	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability:maxLevel	I
    //   1028: sipush 172
    //   1031: invokestatic 205	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1034: getstatic 238	com/tencent/thumbplayer/core/common/TPCodecUtils:mHEVCMediaCodecMaxCapability	Lcom/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability;
    //   1037: getstatic 248	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMap	Ljava/util/HashMap;
    //   1040: invokestatic 519	com/tencent/thumbplayer/core/common/TPCodecUtils:replace	(Ljava/lang/Object;Ljava/lang/Object;Ljava/util/HashMap;)V
    //   1043: iload_1
    //   1044: iconst_1
    //   1045: iadd
    //   1046: istore_1
    //   1047: goto -104 -> 943
    //   1050: astore 23
    //   1052: iconst_1
    //   1053: istore_2
    //   1054: iconst_4
    //   1055: new 270	java/lang/StringBuilder
    //   1058: dup
    //   1059: invokespecial 271	java/lang/StringBuilder:<init>	()V
    //   1062: ldc_w 533
    //   1065: invokevirtual 277	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1068: aload 23
    //   1070: invokevirtual 534	java/lang/RuntimeException:getMessage	()Ljava/lang/String;
    //   1073: invokevirtual 277	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1076: invokevirtual 283	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1079: invokestatic 462	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   1082: goto -199 -> 883
    //   1085: astore 12
    //   1087: iconst_4
    //   1088: new 270	java/lang/StringBuilder
    //   1091: dup
    //   1092: invokespecial 271	java/lang/StringBuilder:<init>	()V
    //   1095: ldc_w 536
    //   1098: invokevirtual 277	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1101: aload 12
    //   1103: invokevirtual 537	java/lang/reflect/InvocationTargetException:getMessage	()Ljava/lang/String;
    //   1106: invokevirtual 277	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1109: invokevirtual 283	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1112: invokestatic 462	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   1115: iconst_2
    //   1116: ldc_w 539
    //   1119: invokestatic 462	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   1122: getstatic 97	com/tencent/thumbplayer/core/common/TPCodecUtils:mIsLocalCacheEnabled	Z
    //   1125: ifeq +30 -> 1155
    //   1128: getstatic 138	com/tencent/thumbplayer/core/common/TPCodecUtils:mHWCodecCapListKey	Ljava/lang/String;
    //   1131: getstatic 112	com/tencent/thumbplayer/core/common/TPCodecUtils:mHWCodecCapList	Ljava/util/ArrayList;
    //   1134: invokestatic 541	com/tencent/thumbplayer/core/common/TPCodecUtils:cacheCapList	(Ljava/lang/String;Ljava/util/ArrayList;)V
    //   1137: getstatic 150	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMapKey	Ljava/lang/String;
    //   1140: getstatic 248	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMap	Ljava/util/HashMap;
    //   1143: invokestatic 543	com/tencent/thumbplayer/core/common/TPCodecUtils:cacheCapabilityMap	(Ljava/lang/String;Ljava/util/HashMap;)V
    //   1146: iconst_2
    //   1147: ldc 32
    //   1149: ldc_w 545
    //   1152: invokestatic 225	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;Ljava/lang/String;)V
    //   1155: iconst_1
    //   1156: putstatic 227	com/tencent/thumbplayer/core/common/TPCodecUtils:mIsMediaCodecCapGot	Z
    //   1159: getstatic 248	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMap	Ljava/util/HashMap;
    //   1162: astore 12
    //   1164: goto -1132 -> 32
    //   1167: iconst_2
    //   1168: new 270	java/lang/StringBuilder
    //   1171: dup
    //   1172: invokespecial 271	java/lang/StringBuilder:<init>	()V
    //   1175: ldc_w 547
    //   1178: invokevirtual 277	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1181: getstatic 248	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMap	Ljava/util/HashMap;
    //   1184: sipush 172
    //   1187: invokestatic 205	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1190: invokevirtual 522	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1193: checkcast 231	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability
    //   1196: getfield 512	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability:maxProfile	I
    //   1199: invokevirtual 397	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1202: ldc_w 524
    //   1205: invokevirtual 277	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1208: getstatic 248	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMap	Ljava/util/HashMap;
    //   1211: sipush 172
    //   1214: invokestatic 205	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1217: invokevirtual 522	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1220: checkcast 231	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability
    //   1223: getfield 515	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability:maxLevel	I
    //   1226: invokevirtual 397	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1229: ldc_w 526
    //   1232: invokevirtual 277	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1235: getstatic 248	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMap	Ljava/util/HashMap;
    //   1238: sipush 172
    //   1241: invokestatic 205	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1244: invokevirtual 522	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1247: checkcast 231	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability
    //   1250: getfield 509	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability:maxLumaSamples	I
    //   1253: invokevirtual 397	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1256: invokevirtual 283	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1259: invokestatic 462	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   1262: iconst_1
    //   1263: istore_3
    //   1264: getstatic 112	com/tencent/thumbplayer/core/common/TPCodecUtils:mHWCodecCapList	Ljava/util/ArrayList;
    //   1267: ldc_w 549
    //   1270: invokevirtual 495	java/util/ArrayList:contains	(Ljava/lang/Object;)Z
    //   1273: istore 11
    //   1275: iload_0
    //   1276: istore_1
    //   1277: iload 11
    //   1279: ifeq +432 -> 1711
    //   1282: iload_0
    //   1283: istore_1
    //   1284: iload_0
    //   1285: ifne +426 -> 1711
    //   1288: aload 17
    //   1290: aload 16
    //   1292: aload 20
    //   1294: iconst_1
    //   1295: anewarray 4	java/lang/Object
    //   1298: dup
    //   1299: iconst_0
    //   1300: ldc_w 549
    //   1303: aastore
    //   1304: invokevirtual 454	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   1307: invokevirtual 500	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1310: checkcast 502	[Ljava/lang/Object;
    //   1313: checkcast 502	[Ljava/lang/Object;
    //   1316: astore 23
    //   1318: aload 23
    //   1320: arraylength
    //   1321: istore_1
    //   1322: iconst_0
    //   1323: istore_0
    //   1324: iload_0
    //   1325: iload_1
    //   1326: if_icmpge +222 -> 1548
    //   1329: aload 23
    //   1331: iload_0
    //   1332: aaload
    //   1333: astore 24
    //   1335: aload 18
    //   1337: aload 24
    //   1339: invokevirtual 500	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1342: checkcast 201	java/lang/Integer
    //   1345: invokevirtual 457	java/lang/Integer:intValue	()I
    //   1348: istore 6
    //   1350: aload 19
    //   1352: aload 24
    //   1354: invokevirtual 500	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1357: checkcast 201	java/lang/Integer
    //   1360: invokevirtual 457	java/lang/Integer:intValue	()I
    //   1363: istore 7
    //   1365: iload 7
    //   1367: iload 6
    //   1369: invokestatic 552	com/tencent/thumbplayer/core/common/TPCodecUtils:maxLumaSamplesForVP9ProfileLevel	(II)I
    //   1372: istore 10
    //   1374: iload 10
    //   1376: getstatic 240	com/tencent/thumbplayer/core/common/TPCodecUtils:mVP9MediaCodecMaxCapability	Lcom/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability;
    //   1379: getfield 509	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability:maxLumaSamples	I
    //   1382: if_icmplt +42 -> 1424
    //   1385: getstatic 240	com/tencent/thumbplayer/core/common/TPCodecUtils:mVP9MediaCodecMaxCapability	Lcom/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability;
    //   1388: iload 10
    //   1390: putfield 509	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability:maxLumaSamples	I
    //   1393: getstatic 240	com/tencent/thumbplayer/core/common/TPCodecUtils:mVP9MediaCodecMaxCapability	Lcom/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability;
    //   1396: iload 7
    //   1398: putfield 512	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability:maxProfile	I
    //   1401: getstatic 240	com/tencent/thumbplayer/core/common/TPCodecUtils:mVP9MediaCodecMaxCapability	Lcom/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability;
    //   1404: iload 6
    //   1406: putfield 515	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability:maxLevel	I
    //   1409: sipush 166
    //   1412: invokestatic 205	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1415: getstatic 240	com/tencent/thumbplayer/core/common/TPCodecUtils:mVP9MediaCodecMaxCapability	Lcom/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability;
    //   1418: getstatic 248	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMap	Ljava/util/HashMap;
    //   1421: invokestatic 519	com/tencent/thumbplayer/core/common/TPCodecUtils:replace	(Ljava/lang/Object;Ljava/lang/Object;Ljava/util/HashMap;)V
    //   1424: iload_0
    //   1425: iconst_1
    //   1426: iadd
    //   1427: istore_0
    //   1428: goto -104 -> 1324
    //   1431: astore 23
    //   1433: iconst_1
    //   1434: istore_3
    //   1435: iconst_4
    //   1436: new 270	java/lang/StringBuilder
    //   1439: dup
    //   1440: invokespecial 271	java/lang/StringBuilder:<init>	()V
    //   1443: ldc_w 554
    //   1446: invokevirtual 277	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1449: aload 23
    //   1451: invokevirtual 534	java/lang/RuntimeException:getMessage	()Ljava/lang/String;
    //   1454: invokevirtual 277	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1457: invokevirtual 283	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1460: invokestatic 462	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   1463: goto -199 -> 1264
    //   1466: astore 12
    //   1468: iconst_4
    //   1469: new 270	java/lang/StringBuilder
    //   1472: dup
    //   1473: invokespecial 271	java/lang/StringBuilder:<init>	()V
    //   1476: ldc_w 536
    //   1479: invokevirtual 277	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1482: aload 12
    //   1484: invokevirtual 555	java/lang/NoSuchMethodException:getMessage	()Ljava/lang/String;
    //   1487: invokevirtual 277	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1490: invokevirtual 283	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1493: invokestatic 462	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   1496: iconst_2
    //   1497: ldc_w 539
    //   1500: invokestatic 462	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   1503: getstatic 97	com/tencent/thumbplayer/core/common/TPCodecUtils:mIsLocalCacheEnabled	Z
    //   1506: ifeq +30 -> 1536
    //   1509: getstatic 138	com/tencent/thumbplayer/core/common/TPCodecUtils:mHWCodecCapListKey	Ljava/lang/String;
    //   1512: getstatic 112	com/tencent/thumbplayer/core/common/TPCodecUtils:mHWCodecCapList	Ljava/util/ArrayList;
    //   1515: invokestatic 541	com/tencent/thumbplayer/core/common/TPCodecUtils:cacheCapList	(Ljava/lang/String;Ljava/util/ArrayList;)V
    //   1518: getstatic 150	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMapKey	Ljava/lang/String;
    //   1521: getstatic 248	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMap	Ljava/util/HashMap;
    //   1524: invokestatic 543	com/tencent/thumbplayer/core/common/TPCodecUtils:cacheCapabilityMap	(Ljava/lang/String;Ljava/util/HashMap;)V
    //   1527: iconst_2
    //   1528: ldc 32
    //   1530: ldc_w 545
    //   1533: invokestatic 225	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;Ljava/lang/String;)V
    //   1536: iconst_1
    //   1537: putstatic 227	com/tencent/thumbplayer/core/common/TPCodecUtils:mIsMediaCodecCapGot	Z
    //   1540: getstatic 248	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMap	Ljava/util/HashMap;
    //   1543: astore 12
    //   1545: goto -1513 -> 32
    //   1548: iconst_2
    //   1549: new 270	java/lang/StringBuilder
    //   1552: dup
    //   1553: invokespecial 271	java/lang/StringBuilder:<init>	()V
    //   1556: ldc_w 557
    //   1559: invokevirtual 277	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1562: getstatic 248	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMap	Ljava/util/HashMap;
    //   1565: sipush 166
    //   1568: invokestatic 205	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1571: invokevirtual 522	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1574: checkcast 231	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability
    //   1577: getfield 512	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability:maxProfile	I
    //   1580: invokevirtual 397	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1583: ldc_w 524
    //   1586: invokevirtual 277	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1589: getstatic 248	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMap	Ljava/util/HashMap;
    //   1592: sipush 166
    //   1595: invokestatic 205	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1598: invokevirtual 522	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1601: checkcast 231	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability
    //   1604: getfield 515	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability:maxLevel	I
    //   1607: invokevirtual 397	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1610: ldc_w 526
    //   1613: invokevirtual 277	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1616: getstatic 248	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMap	Ljava/util/HashMap;
    //   1619: sipush 166
    //   1622: invokestatic 205	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1625: invokevirtual 522	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1628: checkcast 231	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability
    //   1631: getfield 509	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability:maxLumaSamples	I
    //   1634: invokevirtual 397	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1637: invokevirtual 283	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1640: invokestatic 462	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   1643: iconst_1
    //   1644: istore_0
    //   1645: iconst_2
    //   1646: new 270	java/lang/StringBuilder
    //   1649: dup
    //   1650: invokespecial 271	java/lang/StringBuilder:<init>	()V
    //   1653: ldc_w 559
    //   1656: invokevirtual 277	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1659: getstatic 248	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMap	Ljava/util/HashMap;
    //   1662: invokevirtual 392	java/util/HashMap:size	()I
    //   1665: invokevirtual 397	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1668: invokevirtual 283	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1671: invokestatic 462	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   1674: iload_3
    //   1675: istore_1
    //   1676: goto +502 -> 2178
    //   1679: astore 23
    //   1681: iconst_1
    //   1682: istore_1
    //   1683: iconst_4
    //   1684: new 270	java/lang/StringBuilder
    //   1687: dup
    //   1688: invokespecial 271	java/lang/StringBuilder:<init>	()V
    //   1691: ldc_w 561
    //   1694: invokevirtual 277	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1697: aload 23
    //   1699: invokevirtual 534	java/lang/RuntimeException:getMessage	()Ljava/lang/String;
    //   1702: invokevirtual 277	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1705: invokevirtual 283	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1708: invokestatic 462	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   1711: iload_1
    //   1712: istore_0
    //   1713: goto -68 -> 1645
    //   1716: iconst_2
    //   1717: ldc_w 539
    //   1720: invokestatic 462	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   1723: getstatic 97	com/tencent/thumbplayer/core/common/TPCodecUtils:mIsLocalCacheEnabled	Z
    //   1726: ifeq +30 -> 1756
    //   1729: getstatic 138	com/tencent/thumbplayer/core/common/TPCodecUtils:mHWCodecCapListKey	Ljava/lang/String;
    //   1732: getstatic 112	com/tencent/thumbplayer/core/common/TPCodecUtils:mHWCodecCapList	Ljava/util/ArrayList;
    //   1735: invokestatic 541	com/tencent/thumbplayer/core/common/TPCodecUtils:cacheCapList	(Ljava/lang/String;Ljava/util/ArrayList;)V
    //   1738: getstatic 150	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMapKey	Ljava/lang/String;
    //   1741: getstatic 248	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMap	Ljava/util/HashMap;
    //   1744: invokestatic 543	com/tencent/thumbplayer/core/common/TPCodecUtils:cacheCapabilityMap	(Ljava/lang/String;Ljava/util/HashMap;)V
    //   1747: iconst_2
    //   1748: ldc 32
    //   1750: ldc_w 545
    //   1753: invokestatic 225	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;Ljava/lang/String;)V
    //   1756: iconst_1
    //   1757: putstatic 227	com/tencent/thumbplayer/core/common/TPCodecUtils:mIsMediaCodecCapGot	Z
    //   1760: getstatic 248	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMap	Ljava/util/HashMap;
    //   1763: astore 12
    //   1765: goto -1733 -> 32
    //   1768: astore 12
    //   1770: iconst_4
    //   1771: new 270	java/lang/StringBuilder
    //   1774: dup
    //   1775: invokespecial 271	java/lang/StringBuilder:<init>	()V
    //   1778: ldc_w 536
    //   1781: invokevirtual 277	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1784: aload 12
    //   1786: invokevirtual 562	java/lang/IllegalAccessException:getMessage	()Ljava/lang/String;
    //   1789: invokevirtual 277	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1792: invokevirtual 283	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1795: invokestatic 462	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   1798: iconst_2
    //   1799: ldc_w 539
    //   1802: invokestatic 462	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   1805: getstatic 97	com/tencent/thumbplayer/core/common/TPCodecUtils:mIsLocalCacheEnabled	Z
    //   1808: ifeq +30 -> 1838
    //   1811: getstatic 138	com/tencent/thumbplayer/core/common/TPCodecUtils:mHWCodecCapListKey	Ljava/lang/String;
    //   1814: getstatic 112	com/tencent/thumbplayer/core/common/TPCodecUtils:mHWCodecCapList	Ljava/util/ArrayList;
    //   1817: invokestatic 541	com/tencent/thumbplayer/core/common/TPCodecUtils:cacheCapList	(Ljava/lang/String;Ljava/util/ArrayList;)V
    //   1820: getstatic 150	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMapKey	Ljava/lang/String;
    //   1823: getstatic 248	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMap	Ljava/util/HashMap;
    //   1826: invokestatic 543	com/tencent/thumbplayer/core/common/TPCodecUtils:cacheCapabilityMap	(Ljava/lang/String;Ljava/util/HashMap;)V
    //   1829: iconst_2
    //   1830: ldc 32
    //   1832: ldc_w 545
    //   1835: invokestatic 225	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;Ljava/lang/String;)V
    //   1838: iconst_1
    //   1839: putstatic 227	com/tencent/thumbplayer/core/common/TPCodecUtils:mIsMediaCodecCapGot	Z
    //   1842: getstatic 248	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMap	Ljava/util/HashMap;
    //   1845: astore 12
    //   1847: goto -1815 -> 32
    //   1850: astore 12
    //   1852: iconst_4
    //   1853: new 270	java/lang/StringBuilder
    //   1856: dup
    //   1857: invokespecial 271	java/lang/StringBuilder:<init>	()V
    //   1860: ldc_w 536
    //   1863: invokevirtual 277	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1866: aload 12
    //   1868: invokevirtual 563	java/lang/NoSuchFieldException:getMessage	()Ljava/lang/String;
    //   1871: invokevirtual 277	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1874: invokevirtual 283	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1877: invokestatic 462	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   1880: iconst_2
    //   1881: ldc_w 539
    //   1884: invokestatic 462	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   1887: getstatic 97	com/tencent/thumbplayer/core/common/TPCodecUtils:mIsLocalCacheEnabled	Z
    //   1890: ifeq +30 -> 1920
    //   1893: getstatic 138	com/tencent/thumbplayer/core/common/TPCodecUtils:mHWCodecCapListKey	Ljava/lang/String;
    //   1896: getstatic 112	com/tencent/thumbplayer/core/common/TPCodecUtils:mHWCodecCapList	Ljava/util/ArrayList;
    //   1899: invokestatic 541	com/tencent/thumbplayer/core/common/TPCodecUtils:cacheCapList	(Ljava/lang/String;Ljava/util/ArrayList;)V
    //   1902: getstatic 150	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMapKey	Ljava/lang/String;
    //   1905: getstatic 248	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMap	Ljava/util/HashMap;
    //   1908: invokestatic 543	com/tencent/thumbplayer/core/common/TPCodecUtils:cacheCapabilityMap	(Ljava/lang/String;Ljava/util/HashMap;)V
    //   1911: iconst_2
    //   1912: ldc 32
    //   1914: ldc_w 545
    //   1917: invokestatic 225	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;Ljava/lang/String;)V
    //   1920: iconst_1
    //   1921: putstatic 227	com/tencent/thumbplayer/core/common/TPCodecUtils:mIsMediaCodecCapGot	Z
    //   1924: getstatic 248	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMap	Ljava/util/HashMap;
    //   1927: astore 12
    //   1929: goto -1897 -> 32
    //   1932: astore 12
    //   1934: iconst_4
    //   1935: new 270	java/lang/StringBuilder
    //   1938: dup
    //   1939: invokespecial 271	java/lang/StringBuilder:<init>	()V
    //   1942: ldc_w 536
    //   1945: invokevirtual 277	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1948: aload 12
    //   1950: invokevirtual 564	java/lang/ClassNotFoundException:getMessage	()Ljava/lang/String;
    //   1953: invokevirtual 277	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1956: invokevirtual 283	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1959: invokestatic 462	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   1962: iconst_2
    //   1963: ldc_w 539
    //   1966: invokestatic 462	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   1969: getstatic 97	com/tencent/thumbplayer/core/common/TPCodecUtils:mIsLocalCacheEnabled	Z
    //   1972: ifeq +30 -> 2002
    //   1975: getstatic 138	com/tencent/thumbplayer/core/common/TPCodecUtils:mHWCodecCapListKey	Ljava/lang/String;
    //   1978: getstatic 112	com/tencent/thumbplayer/core/common/TPCodecUtils:mHWCodecCapList	Ljava/util/ArrayList;
    //   1981: invokestatic 541	com/tencent/thumbplayer/core/common/TPCodecUtils:cacheCapList	(Ljava/lang/String;Ljava/util/ArrayList;)V
    //   1984: getstatic 150	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMapKey	Ljava/lang/String;
    //   1987: getstatic 248	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMap	Ljava/util/HashMap;
    //   1990: invokestatic 543	com/tencent/thumbplayer/core/common/TPCodecUtils:cacheCapabilityMap	(Ljava/lang/String;Ljava/util/HashMap;)V
    //   1993: iconst_2
    //   1994: ldc 32
    //   1996: ldc_w 545
    //   1999: invokestatic 225	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;Ljava/lang/String;)V
    //   2002: iconst_1
    //   2003: putstatic 227	com/tencent/thumbplayer/core/common/TPCodecUtils:mIsMediaCodecCapGot	Z
    //   2006: getstatic 248	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMap	Ljava/util/HashMap;
    //   2009: astore 12
    //   2011: goto -1979 -> 32
    //   2014: astore 12
    //   2016: iconst_4
    //   2017: new 270	java/lang/StringBuilder
    //   2020: dup
    //   2021: invokespecial 271	java/lang/StringBuilder:<init>	()V
    //   2024: ldc_w 536
    //   2027: invokevirtual 277	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2030: aload 12
    //   2032: invokevirtual 534	java/lang/RuntimeException:getMessage	()Ljava/lang/String;
    //   2035: invokevirtual 277	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2038: invokevirtual 283	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2041: invokestatic 462	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   2044: iconst_2
    //   2045: ldc_w 539
    //   2048: invokestatic 462	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   2051: getstatic 97	com/tencent/thumbplayer/core/common/TPCodecUtils:mIsLocalCacheEnabled	Z
    //   2054: ifeq +30 -> 2084
    //   2057: getstatic 138	com/tencent/thumbplayer/core/common/TPCodecUtils:mHWCodecCapListKey	Ljava/lang/String;
    //   2060: getstatic 112	com/tencent/thumbplayer/core/common/TPCodecUtils:mHWCodecCapList	Ljava/util/ArrayList;
    //   2063: invokestatic 541	com/tencent/thumbplayer/core/common/TPCodecUtils:cacheCapList	(Ljava/lang/String;Ljava/util/ArrayList;)V
    //   2066: getstatic 150	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMapKey	Ljava/lang/String;
    //   2069: getstatic 248	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMap	Ljava/util/HashMap;
    //   2072: invokestatic 543	com/tencent/thumbplayer/core/common/TPCodecUtils:cacheCapabilityMap	(Ljava/lang/String;Ljava/util/HashMap;)V
    //   2075: iconst_2
    //   2076: ldc 32
    //   2078: ldc_w 545
    //   2081: invokestatic 225	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;Ljava/lang/String;)V
    //   2084: iconst_1
    //   2085: putstatic 227	com/tencent/thumbplayer/core/common/TPCodecUtils:mIsMediaCodecCapGot	Z
    //   2088: getstatic 248	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMap	Ljava/util/HashMap;
    //   2091: astore 12
    //   2093: goto -2061 -> 32
    //   2096: astore 12
    //   2098: iconst_2
    //   2099: ldc_w 539
    //   2102: invokestatic 462	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   2105: getstatic 97	com/tencent/thumbplayer/core/common/TPCodecUtils:mIsLocalCacheEnabled	Z
    //   2108: ifeq +30 -> 2138
    //   2111: getstatic 138	com/tencent/thumbplayer/core/common/TPCodecUtils:mHWCodecCapListKey	Ljava/lang/String;
    //   2114: getstatic 112	com/tencent/thumbplayer/core/common/TPCodecUtils:mHWCodecCapList	Ljava/util/ArrayList;
    //   2117: invokestatic 541	com/tencent/thumbplayer/core/common/TPCodecUtils:cacheCapList	(Ljava/lang/String;Ljava/util/ArrayList;)V
    //   2120: getstatic 150	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMapKey	Ljava/lang/String;
    //   2123: getstatic 248	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMap	Ljava/util/HashMap;
    //   2126: invokestatic 543	com/tencent/thumbplayer/core/common/TPCodecUtils:cacheCapabilityMap	(Ljava/lang/String;Ljava/util/HashMap;)V
    //   2129: iconst_2
    //   2130: ldc 32
    //   2132: ldc_w 545
    //   2135: invokestatic 225	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;Ljava/lang/String;)V
    //   2138: iconst_1
    //   2139: putstatic 227	com/tencent/thumbplayer/core/common/TPCodecUtils:mIsMediaCodecCapGot	Z
    //   2142: getstatic 248	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMap	Ljava/util/HashMap;
    //   2145: astore 12
    //   2147: goto -2115 -> 32
    //   2150: astore 12
    //   2152: ldc 2
    //   2154: monitorexit
    //   2155: aload 12
    //   2157: athrow
    //   2158: goto -1275 -> 883
    //   2161: iload 4
    //   2163: iconst_1
    //   2164: iadd
    //   2165: istore 4
    //   2167: iload_3
    //   2168: istore_2
    //   2169: iload 6
    //   2171: istore_0
    //   2172: iload 7
    //   2174: istore_1
    //   2175: goto -1760 -> 415
    //   2178: iload 5
    //   2180: iconst_1
    //   2181: iadd
    //   2182: istore 5
    //   2184: goto -1665 -> 519
    //   2187: iload_2
    //   2188: iconst_1
    //   2189: iadd
    //   2190: istore_2
    //   2191: goto -1504 -> 687
    // Local variable table:
    //   start	length	slot	name	signature
    //   214	1958	0	i	int
    //   212	1963	1	j	int
    //   210	1981	2	k	int
    //   463	1705	3	m	int
    //   413	1753	4	n	int
    //   517	1666	5	i1	int
    //   465	1705	6	i2	int
    //   468	1705	7	i3	int
    //   385	35	8	i4	int
    //   514	18	9	i5	int
    //   735	654	10	i6	int
    //   640	638	11	bool	boolean
    //   30	143	12	localObject1	Object
    //   177	19	12	localException	Exception
    //   221	202	12	localObject2	Object
    //   1085	17	12	localInvocationTargetException	java.lang.reflect.InvocationTargetException
    //   1162	1	12	localHashMap1	HashMap
    //   1466	17	12	localNoSuchMethodException	java.lang.NoSuchMethodException
    //   1543	221	12	localHashMap2	HashMap
    //   1768	17	12	localIllegalAccessException	java.lang.IllegalAccessException
    //   1845	1	12	localHashMap3	HashMap
    //   1850	17	12	localNoSuchFieldException	java.lang.NoSuchFieldException
    //   1927	1	12	localHashMap4	HashMap
    //   1932	17	12	localClassNotFoundException	java.lang.ClassNotFoundException
    //   2009	1	12	localHashMap5	HashMap
    //   2014	17	12	localRuntimeException1	java.lang.RuntimeException
    //   2091	1	12	localHashMap6	HashMap
    //   2096	1	12	localObject3	Object
    //   2145	1	12	localHashMap7	HashMap
    //   2150	6	12	localObject4	Object
    //   277	216	13	localMethod1	Method
    //   291	183	14	localMethod2	Method
    //   305	138	15	localMethod3	Method
    //   263	1028	16	localObject5	Object
    //   339	950	17	localField1	Field
    //   357	979	18	localField2	Field
    //   347	1004	19	localObject6	Object
    //   235	1058	20	localObject7	Object
    //   490	110	21	str	String
    //   509	26	22	arrayOfString	String[]
    //   539	410	23	localObject8	Object
    //   1050	19	23	localRuntimeException2	java.lang.RuntimeException
    //   1316	14	23	arrayOfObject	Object[]
    //   1431	19	23	localRuntimeException3	java.lang.RuntimeException
    //   1679	19	23	localRuntimeException4	java.lang.RuntimeException
    //   696	657	24	localObject9	Object
    // Exception table:
    //   from	to	target	type
    //   38	74	177	java/lang/Exception
    //   74	82	177	java/lang/Exception
    //   87	92	177	java/lang/Exception
    //   92	115	177	java/lang/Exception
    //   120	174	177	java/lang/Exception
    //   651	685	1050	java/lang/RuntimeException
    //   698	786	1050	java/lang/RuntimeException
    //   789	881	1050	java/lang/RuntimeException
    //   215	412	1085	java/lang/reflect/InvocationTargetException
    //   422	462	1085	java/lang/reflect/InvocationTargetException
    //   473	516	1085	java/lang/reflect/InvocationTargetException
    //   541	610	1085	java/lang/reflect/InvocationTargetException
    //   610	619	1085	java/lang/reflect/InvocationTargetException
    //   622	642	1085	java/lang/reflect/InvocationTargetException
    //   651	685	1085	java/lang/reflect/InvocationTargetException
    //   698	786	1085	java/lang/reflect/InvocationTargetException
    //   789	881	1085	java/lang/reflect/InvocationTargetException
    //   883	894	1085	java/lang/reflect/InvocationTargetException
    //   907	941	1085	java/lang/reflect/InvocationTargetException
    //   954	1043	1085	java/lang/reflect/InvocationTargetException
    //   1054	1082	1085	java/lang/reflect/InvocationTargetException
    //   1167	1262	1085	java/lang/reflect/InvocationTargetException
    //   1264	1275	1085	java/lang/reflect/InvocationTargetException
    //   1288	1322	1085	java/lang/reflect/InvocationTargetException
    //   1335	1424	1085	java/lang/reflect/InvocationTargetException
    //   1435	1463	1085	java/lang/reflect/InvocationTargetException
    //   1548	1643	1085	java/lang/reflect/InvocationTargetException
    //   1645	1674	1085	java/lang/reflect/InvocationTargetException
    //   1683	1711	1085	java/lang/reflect/InvocationTargetException
    //   907	941	1431	java/lang/RuntimeException
    //   954	1043	1431	java/lang/RuntimeException
    //   1167	1262	1431	java/lang/RuntimeException
    //   215	412	1466	java/lang/NoSuchMethodException
    //   422	462	1466	java/lang/NoSuchMethodException
    //   473	516	1466	java/lang/NoSuchMethodException
    //   541	610	1466	java/lang/NoSuchMethodException
    //   610	619	1466	java/lang/NoSuchMethodException
    //   622	642	1466	java/lang/NoSuchMethodException
    //   651	685	1466	java/lang/NoSuchMethodException
    //   698	786	1466	java/lang/NoSuchMethodException
    //   789	881	1466	java/lang/NoSuchMethodException
    //   883	894	1466	java/lang/NoSuchMethodException
    //   907	941	1466	java/lang/NoSuchMethodException
    //   954	1043	1466	java/lang/NoSuchMethodException
    //   1054	1082	1466	java/lang/NoSuchMethodException
    //   1167	1262	1466	java/lang/NoSuchMethodException
    //   1264	1275	1466	java/lang/NoSuchMethodException
    //   1288	1322	1466	java/lang/NoSuchMethodException
    //   1335	1424	1466	java/lang/NoSuchMethodException
    //   1435	1463	1466	java/lang/NoSuchMethodException
    //   1548	1643	1466	java/lang/NoSuchMethodException
    //   1645	1674	1466	java/lang/NoSuchMethodException
    //   1683	1711	1466	java/lang/NoSuchMethodException
    //   1288	1322	1679	java/lang/RuntimeException
    //   1335	1424	1679	java/lang/RuntimeException
    //   1548	1643	1679	java/lang/RuntimeException
    //   215	412	1768	java/lang/IllegalAccessException
    //   422	462	1768	java/lang/IllegalAccessException
    //   473	516	1768	java/lang/IllegalAccessException
    //   541	610	1768	java/lang/IllegalAccessException
    //   610	619	1768	java/lang/IllegalAccessException
    //   622	642	1768	java/lang/IllegalAccessException
    //   651	685	1768	java/lang/IllegalAccessException
    //   698	786	1768	java/lang/IllegalAccessException
    //   789	881	1768	java/lang/IllegalAccessException
    //   883	894	1768	java/lang/IllegalAccessException
    //   907	941	1768	java/lang/IllegalAccessException
    //   954	1043	1768	java/lang/IllegalAccessException
    //   1054	1082	1768	java/lang/IllegalAccessException
    //   1167	1262	1768	java/lang/IllegalAccessException
    //   1264	1275	1768	java/lang/IllegalAccessException
    //   1288	1322	1768	java/lang/IllegalAccessException
    //   1335	1424	1768	java/lang/IllegalAccessException
    //   1435	1463	1768	java/lang/IllegalAccessException
    //   1548	1643	1768	java/lang/IllegalAccessException
    //   1645	1674	1768	java/lang/IllegalAccessException
    //   1683	1711	1768	java/lang/IllegalAccessException
    //   215	412	1850	java/lang/NoSuchFieldException
    //   422	462	1850	java/lang/NoSuchFieldException
    //   473	516	1850	java/lang/NoSuchFieldException
    //   541	610	1850	java/lang/NoSuchFieldException
    //   610	619	1850	java/lang/NoSuchFieldException
    //   622	642	1850	java/lang/NoSuchFieldException
    //   651	685	1850	java/lang/NoSuchFieldException
    //   698	786	1850	java/lang/NoSuchFieldException
    //   789	881	1850	java/lang/NoSuchFieldException
    //   883	894	1850	java/lang/NoSuchFieldException
    //   907	941	1850	java/lang/NoSuchFieldException
    //   954	1043	1850	java/lang/NoSuchFieldException
    //   1054	1082	1850	java/lang/NoSuchFieldException
    //   1167	1262	1850	java/lang/NoSuchFieldException
    //   1264	1275	1850	java/lang/NoSuchFieldException
    //   1288	1322	1850	java/lang/NoSuchFieldException
    //   1335	1424	1850	java/lang/NoSuchFieldException
    //   1435	1463	1850	java/lang/NoSuchFieldException
    //   1548	1643	1850	java/lang/NoSuchFieldException
    //   1645	1674	1850	java/lang/NoSuchFieldException
    //   1683	1711	1850	java/lang/NoSuchFieldException
    //   215	412	1932	java/lang/ClassNotFoundException
    //   422	462	1932	java/lang/ClassNotFoundException
    //   473	516	1932	java/lang/ClassNotFoundException
    //   541	610	1932	java/lang/ClassNotFoundException
    //   610	619	1932	java/lang/ClassNotFoundException
    //   622	642	1932	java/lang/ClassNotFoundException
    //   651	685	1932	java/lang/ClassNotFoundException
    //   698	786	1932	java/lang/ClassNotFoundException
    //   789	881	1932	java/lang/ClassNotFoundException
    //   883	894	1932	java/lang/ClassNotFoundException
    //   907	941	1932	java/lang/ClassNotFoundException
    //   954	1043	1932	java/lang/ClassNotFoundException
    //   1054	1082	1932	java/lang/ClassNotFoundException
    //   1167	1262	1932	java/lang/ClassNotFoundException
    //   1264	1275	1932	java/lang/ClassNotFoundException
    //   1288	1322	1932	java/lang/ClassNotFoundException
    //   1335	1424	1932	java/lang/ClassNotFoundException
    //   1435	1463	1932	java/lang/ClassNotFoundException
    //   1548	1643	1932	java/lang/ClassNotFoundException
    //   1645	1674	1932	java/lang/ClassNotFoundException
    //   1683	1711	1932	java/lang/ClassNotFoundException
    //   215	412	2014	java/lang/RuntimeException
    //   422	462	2014	java/lang/RuntimeException
    //   473	516	2014	java/lang/RuntimeException
    //   541	610	2014	java/lang/RuntimeException
    //   610	619	2014	java/lang/RuntimeException
    //   622	642	2014	java/lang/RuntimeException
    //   883	894	2014	java/lang/RuntimeException
    //   1054	1082	2014	java/lang/RuntimeException
    //   1264	1275	2014	java/lang/RuntimeException
    //   1435	1463	2014	java/lang/RuntimeException
    //   1645	1674	2014	java/lang/RuntimeException
    //   1683	1711	2014	java/lang/RuntimeException
    //   215	412	2096	finally
    //   422	462	2096	finally
    //   473	516	2096	finally
    //   541	610	2096	finally
    //   610	619	2096	finally
    //   622	642	2096	finally
    //   651	685	2096	finally
    //   698	786	2096	finally
    //   789	881	2096	finally
    //   883	894	2096	finally
    //   907	941	2096	finally
    //   954	1043	2096	finally
    //   1054	1082	2096	finally
    //   1087	1115	2096	finally
    //   1167	1262	2096	finally
    //   1264	1275	2096	finally
    //   1288	1322	2096	finally
    //   1335	1424	2096	finally
    //   1435	1463	2096	finally
    //   1468	1496	2096	finally
    //   1548	1643	2096	finally
    //   1645	1674	2096	finally
    //   1683	1711	2096	finally
    //   1770	1798	2096	finally
    //   1852	1880	2096	finally
    //   1934	1962	2096	finally
    //   2016	2044	2096	finally
    //   3	32	2150	finally
    //   38	74	2150	finally
    //   74	82	2150	finally
    //   87	92	2150	finally
    //   92	115	2150	finally
    //   120	174	2150	finally
    //   179	209	2150	finally
    //   1115	1155	2150	finally
    //   1155	1164	2150	finally
    //   1496	1536	2150	finally
    //   1536	1545	2150	finally
    //   1716	1756	2150	finally
    //   1756	1765	2150	finally
    //   1798	1838	2150	finally
    //   1838	1847	2150	finally
    //   1880	1920	2150	finally
    //   1920	1929	2150	finally
    //   1962	2002	2150	finally
    //   2002	2011	2150	finally
    //   2044	2084	2150	finally
    //   2084	2093	2150	finally
    //   2098	2138	2150	finally
    //   2138	2147	2150	finally
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
    //   13: ldc_w 612
    //   16: invokevirtual 277	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   19: iload_1
    //   20: invokevirtual 615	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   23: invokevirtual 283	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   26: invokestatic 225	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;Ljava/lang/String;)V
    //   29: aload_0
    //   30: invokevirtual 621	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   33: putstatic 95	com/tencent/thumbplayer/core/common/TPCodecUtils:mApplicationContext	Landroid/content/Context;
    //   36: iload_1
    //   37: putstatic 97	com/tencent/thumbplayer/core/common/TPCodecUtils:mIsLocalCacheEnabled	Z
    //   40: iload_1
    //   41: ifeq +37 -> 78
    //   44: getstatic 134	com/tencent/thumbplayer/core/common/TPCodecUtils:mStoredPlayerCoreVersionKey	Ljava/lang/String;
    //   47: invokestatic 623	com/tencent/thumbplayer/core/common/TPCodecUtils:getCachedStringInfo	(Ljava/lang/String;)Ljava/lang/String;
    //   50: astore_0
    //   51: getstatic 105	com/tencent/thumbplayer/core/common/TPCodecUtils:mPlayerCoreVersion	Ljava/lang/String;
    //   54: aload_0
    //   55: invokevirtual 626	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   58: ifne +42 -> 100
    //   61: iconst_1
    //   62: putstatic 99	com/tencent/thumbplayer/core/common/TPCodecUtils:mNeedToReprobeDecoderCapability	Z
    //   65: iconst_1
    //   66: putstatic 101	com/tencent/thumbplayer/core/common/TPCodecUtils:mNeedToReprobeHDRCapability	Z
    //   69: iconst_2
    //   70: ldc 32
    //   72: ldc_w 628
    //   75: invokestatic 225	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;Ljava/lang/String;)V
    //   78: invokestatic 630	com/tencent/thumbplayer/core/common/TPCodecUtils:getDecoderMaxCapabilityMapAsync	()V
    //   81: getstatic 97	com/tencent/thumbplayer/core/common/TPCodecUtils:mIsLocalCacheEnabled	Z
    //   84: ifeq +12 -> 96
    //   87: getstatic 134	com/tencent/thumbplayer/core/common/TPCodecUtils:mStoredPlayerCoreVersionKey	Ljava/lang/String;
    //   90: getstatic 105	com/tencent/thumbplayer/core/common/TPCodecUtils:mPlayerCoreVersion	Ljava/lang/String;
    //   93: invokestatic 632	com/tencent/thumbplayer/core/common/TPCodecUtils:cacheStringInfo	(Ljava/lang/String;Ljava/lang/String;)V
    //   96: ldc 2
    //   98: monitorexit
    //   99: return
    //   100: iconst_0
    //   101: putstatic 99	com/tencent/thumbplayer/core/common/TPCodecUtils:mNeedToReprobeDecoderCapability	Z
    //   104: iconst_0
    //   105: putstatic 101	com/tencent/thumbplayer/core/common/TPCodecUtils:mNeedToReprobeHDRCapability	Z
    //   108: iconst_2
    //   109: ldc 32
    //   111: ldc_w 634
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.thumbplayer.core.common.TPCodecUtils
 * JD-Core Version:    0.7.0.1
 */