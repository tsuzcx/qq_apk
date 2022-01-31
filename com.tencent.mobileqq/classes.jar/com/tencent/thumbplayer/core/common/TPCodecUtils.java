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
  private static TPCodecCapability.TPVCodecMaxCapability mAVCSWMaxCapability = new TPCodecCapability.TPVCodecMaxCapability(0, 0, 0);
  private static String mAppVersion;
  private static String mAppVersionKey;
  private static Context mApplicationContext;
  private static HashMap<String, Integer> mCodecCap;
  private static int mDeviceLevel = -1;
  private static String mHDR10CapabilityKey;
  private static String mHDR10PLUSCapabilityKey;
  private static String mHDRDOLBYVISIONCapabilityKey;
  private static String mHDRHLGCapabilityKey;
  private static TPCodecCapability.TPVCodecMaxCapability mHEVCMediaCodecMaxCapability;
  private static TPCodecCapability.TPVCodecMaxCapability mHEVCSWMaxCapability = new TPCodecCapability.TPVCodecMaxCapability(0, 0, 0);
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
    mAppVersion = "initversion";
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
    mAppVersionKey = "App_version_Key";
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
    //   3: getstatic 116	com/tencent/thumbplayer/core/common/TPCodecUtils:mIsInitDone	Z
    //   6: ifeq +16 -> 22
    //   9: iconst_2
    //   10: ldc 32
    //   12: ldc_w 306
    //   15: invokestatic 223	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;Ljava/lang/String;)V
    //   18: ldc 2
    //   20: monitorexit
    //   21: return
    //   22: iconst_2
    //   23: ldc 32
    //   25: ldc_w 308
    //   28: invokestatic 223	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;Ljava/lang/String;)V
    //   31: new 310	java/lang/Thread
    //   34: dup
    //   35: new 312	com/tencent/thumbplayer/core/common/TPCodecUtils$1
    //   38: dup
    //   39: invokespecial 313	com/tencent/thumbplayer/core/common/TPCodecUtils$1:<init>	()V
    //   42: invokespecial 316	java/lang/Thread:<init>	(Ljava/lang/Runnable;)V
    //   45: astore_0
    //   46: aload_0
    //   47: ldc_w 318
    //   50: invokevirtual 322	java/lang/Thread:setName	(Ljava/lang/String;)V
    //   53: aload_0
    //   54: invokevirtual 325	java/lang/Thread:start	()V
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
    //   6: ldc_w 366
    //   9: invokestatic 223	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;Ljava/lang/String;)V
    //   12: iconst_1
    //   13: getstatic 225	com/tencent/thumbplayer/core/common/TPCodecUtils:mIsMediaCodecCapGot	Z
    //   16: if_icmpne +23 -> 39
    //   19: iconst_2
    //   20: ldc 32
    //   22: ldc_w 368
    //   25: invokestatic 223	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;Ljava/lang/String;)V
    //   28: getstatic 242	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMap	Ljava/util/HashMap;
    //   31: astore 11
    //   33: ldc 2
    //   35: monitorexit
    //   36: aload 11
    //   38: areturn
    //   39: getstatic 95	com/tencent/thumbplayer/core/common/TPCodecUtils:mIsLocalCacheEnabled	Z
    //   42: ifeq +168 -> 210
    //   45: getstatic 97	com/tencent/thumbplayer/core/common/TPCodecUtils:mNeedToReprobeDecoderCapability	Z
    //   48: ifne +162 -> 210
    //   51: iconst_2
    //   52: ldc 32
    //   54: ldc_w 370
    //   57: invokestatic 223	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;Ljava/lang/String;)V
    //   60: getstatic 110	com/tencent/thumbplayer/core/common/TPCodecUtils:mHWCodecCapList	Ljava/util/ArrayList;
    //   63: ifnull +12 -> 75
    //   66: getstatic 110	com/tencent/thumbplayer/core/common/TPCodecUtils:mHWCodecCapList	Ljava/util/ArrayList;
    //   69: invokevirtual 373	java/util/ArrayList:size	()I
    //   72: ifne +21 -> 93
    //   75: getstatic 136	com/tencent/thumbplayer/core/common/TPCodecUtils:mHWCodecCapListKey	Ljava/lang/String;
    //   78: invokestatic 375	com/tencent/thumbplayer/core/common/TPCodecUtils:getCachedCapList	(Ljava/lang/String;)Ljava/util/ArrayList;
    //   81: astore 11
    //   83: aload 11
    //   85: ifnull +8 -> 93
    //   88: aload 11
    //   90: putstatic 110	com/tencent/thumbplayer/core/common/TPCodecUtils:mHWCodecCapList	Ljava/util/ArrayList;
    //   93: getstatic 110	com/tencent/thumbplayer/core/common/TPCodecUtils:mHWCodecCapList	Ljava/util/ArrayList;
    //   96: ifnull +114 -> 210
    //   99: getstatic 110	com/tencent/thumbplayer/core/common/TPCodecUtils:mHWCodecCapList	Ljava/util/ArrayList;
    //   102: invokevirtual 373	java/util/ArrayList:size	()I
    //   105: ifle +105 -> 210
    //   108: getstatic 148	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMapKey	Ljava/lang/String;
    //   111: invokestatic 377	com/tencent/thumbplayer/core/common/TPCodecUtils:getCachedCapabilityMap	(Ljava/lang/String;)Ljava/util/HashMap;
    //   114: astore 11
    //   116: aload 11
    //   118: ifnull +92 -> 210
    //   121: aload 11
    //   123: putstatic 242	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMap	Ljava/util/HashMap;
    //   126: getstatic 242	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMap	Ljava/util/HashMap;
    //   129: invokevirtual 378	java/util/HashMap:size	()I
    //   132: ifle +78 -> 210
    //   135: iconst_2
    //   136: ldc 32
    //   138: new 264	java/lang/StringBuilder
    //   141: dup
    //   142: invokespecial 265	java/lang/StringBuilder:<init>	()V
    //   145: ldc_w 380
    //   148: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   151: getstatic 242	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMap	Ljava/util/HashMap;
    //   154: invokevirtual 378	java/util/HashMap:size	()I
    //   157: invokevirtual 383	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   160: invokevirtual 277	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   163: invokestatic 223	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;Ljava/lang/String;)V
    //   166: iconst_1
    //   167: putstatic 225	com/tencent/thumbplayer/core/common/TPCodecUtils:mIsMediaCodecCapGot	Z
    //   170: getstatic 242	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMap	Ljava/util/HashMap;
    //   173: astore 11
    //   175: goto -142 -> 33
    //   178: astore 11
    //   180: iconst_4
    //   181: ldc 32
    //   183: new 264	java/lang/StringBuilder
    //   186: dup
    //   187: invokespecial 265	java/lang/StringBuilder:<init>	()V
    //   190: ldc_w 385
    //   193: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   196: aload 11
    //   198: invokevirtual 388	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   201: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   204: invokevirtual 277	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   207: invokestatic 223	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;Ljava/lang/String;)V
    //   210: iconst_0
    //   211: istore_1
    //   212: iconst_0
    //   213: istore_0
    //   214: ldc_w 390
    //   217: invokestatic 396	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   220: astore 11
    //   222: aload 11
    //   224: ldc_w 398
    //   227: iconst_0
    //   228: anewarray 392	java/lang/Class
    //   231: invokevirtual 402	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   234: astore 19
    //   236: aload 11
    //   238: ldc_w 404
    //   241: iconst_1
    //   242: anewarray 392	java/lang/Class
    //   245: dup
    //   246: iconst_0
    //   247: getstatic 408	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   250: aastore
    //   251: invokevirtual 402	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   254: astore 11
    //   256: ldc_w 410
    //   259: invokestatic 396	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   262: astore 15
    //   264: aload 15
    //   266: ldc_w 412
    //   269: iconst_0
    //   270: anewarray 392	java/lang/Class
    //   273: invokevirtual 402	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   276: astore 12
    //   278: aload 15
    //   280: ldc_w 414
    //   283: iconst_0
    //   284: anewarray 392	java/lang/Class
    //   287: invokevirtual 402	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   290: astore 13
    //   292: aload 15
    //   294: ldc_w 416
    //   297: iconst_0
    //   298: anewarray 392	java/lang/Class
    //   301: invokevirtual 402	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   304: astore 14
    //   306: aload 15
    //   308: ldc_w 418
    //   311: iconst_1
    //   312: anewarray 392	java/lang/Class
    //   315: dup
    //   316: iconst_0
    //   317: ldc_w 420
    //   320: aastore
    //   321: invokevirtual 402	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   324: astore 15
    //   326: ldc_w 422
    //   329: invokestatic 396	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   332: ldc_w 424
    //   335: invokevirtual 428	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   338: astore 16
    //   340: ldc_w 430
    //   343: invokestatic 396	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   346: astore 18
    //   348: aload 18
    //   350: ldc_w 432
    //   353: invokevirtual 428	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   356: astore 17
    //   358: aload 18
    //   360: ldc_w 434
    //   363: invokevirtual 428	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   366: astore 18
    //   368: aload 19
    //   370: aconst_null
    //   371: iconst_0
    //   372: anewarray 4	java/lang/Object
    //   375: invokevirtual 440	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   378: checkcast 199	java/lang/Integer
    //   381: invokevirtual 443	java/lang/Integer:intValue	()I
    //   384: istore 6
    //   386: iconst_2
    //   387: new 264	java/lang/StringBuilder
    //   390: dup
    //   391: invokespecial 265	java/lang/StringBuilder:<init>	()V
    //   394: ldc_w 445
    //   397: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   400: iload 6
    //   402: invokevirtual 383	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   405: invokevirtual 277	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   408: invokestatic 448	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   411: iconst_0
    //   412: istore_3
    //   413: iload_3
    //   414: iload 6
    //   416: if_icmpge +907 -> 1323
    //   419: aload 11
    //   421: aconst_null
    //   422: iconst_1
    //   423: anewarray 4	java/lang/Object
    //   426: dup
    //   427: iconst_0
    //   428: iload_3
    //   429: invokestatic 203	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   432: aastore
    //   433: invokevirtual 440	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   436: astore 19
    //   438: aload 14
    //   440: aload 19
    //   442: iconst_0
    //   443: anewarray 4	java/lang/Object
    //   446: invokevirtual 440	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   449: checkcast 450	java/lang/Boolean
    //   452: invokevirtual 454	java/lang/Boolean:booleanValue	()Z
    //   455: ifeq +11 -> 466
    //   458: iload_1
    //   459: istore_2
    //   460: iload_0
    //   461: istore 5
    //   463: goto +1387 -> 1850
    //   466: aload 13
    //   468: aload 19
    //   470: iconst_0
    //   471: anewarray 4	java/lang/Object
    //   474: invokevirtual 440	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   477: checkcast 420	java/lang/String
    //   480: invokevirtual 457	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   483: astore 20
    //   485: aload 12
    //   487: aload 19
    //   489: iconst_0
    //   490: anewarray 4	java/lang/Object
    //   493: invokevirtual 440	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   496: checkcast 459	[Ljava/lang/String;
    //   499: checkcast 459	[Ljava/lang/String;
    //   502: astore 21
    //   504: aload 21
    //   506: arraylength
    //   507: istore 7
    //   509: iconst_0
    //   510: istore 4
    //   512: iload_1
    //   513: istore_2
    //   514: iload_0
    //   515: istore 5
    //   517: iload 4
    //   519: iload 7
    //   521: if_icmpge +1329 -> 1850
    //   524: aload 21
    //   526: iload 4
    //   528: aaload
    //   529: astore 22
    //   531: iconst_2
    //   532: new 264	java/lang/StringBuilder
    //   535: dup
    //   536: invokespecial 265	java/lang/StringBuilder:<init>	()V
    //   539: ldc_w 461
    //   542: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   545: aload 22
    //   547: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   550: invokevirtual 277	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   553: invokestatic 448	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   556: aload 20
    //   558: ldc_w 463
    //   561: invokevirtual 467	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   564: ifne +36 -> 600
    //   567: aload 20
    //   569: ldc_w 469
    //   572: invokevirtual 467	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   575: ifne +25 -> 600
    //   578: aload 20
    //   580: ldc_w 471
    //   583: invokevirtual 467	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   586: ifne +14 -> 600
    //   589: aload 20
    //   591: ldc_w 473
    //   594: invokevirtual 467	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   597: ifeq +15 -> 612
    //   600: getstatic 112	com/tencent/thumbplayer/core/common/TPCodecUtils:mSoftCodecCapList	Ljava/util/ArrayList;
    //   603: aload 22
    //   605: invokevirtual 477	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   608: pop
    //   609: goto +1253 -> 1862
    //   612: getstatic 110	com/tencent/thumbplayer/core/common/TPCodecUtils:mHWCodecCapList	Ljava/util/ArrayList;
    //   615: aload 22
    //   617: invokevirtual 477	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   620: pop
    //   621: getstatic 110	com/tencent/thumbplayer/core/common/TPCodecUtils:mHWCodecCapList	Ljava/util/ArrayList;
    //   624: ldc_w 479
    //   627: invokevirtual 481	java/util/ArrayList:contains	(Ljava/lang/Object;)Z
    //   630: istore 10
    //   632: iload 10
    //   634: ifeq +1213 -> 1847
    //   637: iload_1
    //   638: ifne +1209 -> 1847
    //   641: aload 16
    //   643: aload 15
    //   645: aload 19
    //   647: iconst_1
    //   648: anewarray 4	java/lang/Object
    //   651: dup
    //   652: iconst_0
    //   653: ldc_w 479
    //   656: aastore
    //   657: invokevirtual 440	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   660: invokevirtual 486	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   663: checkcast 488	[Ljava/lang/Object;
    //   666: checkcast 488	[Ljava/lang/Object;
    //   669: astore 22
    //   671: aload 22
    //   673: arraylength
    //   674: istore_2
    //   675: iconst_0
    //   676: istore_1
    //   677: iload_1
    //   678: iload_2
    //   679: if_icmpge +100 -> 779
    //   682: aload 22
    //   684: iload_1
    //   685: aaload
    //   686: astore 23
    //   688: aload 17
    //   690: aload 23
    //   692: invokevirtual 486	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   695: checkcast 199	java/lang/Integer
    //   698: invokevirtual 443	java/lang/Integer:intValue	()I
    //   701: istore 5
    //   703: aload 18
    //   705: aload 23
    //   707: invokevirtual 486	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   710: checkcast 199	java/lang/Integer
    //   713: invokevirtual 443	java/lang/Integer:intValue	()I
    //   716: istore 8
    //   718: iload 8
    //   720: iload 5
    //   722: invokestatic 492	com/tencent/thumbplayer/core/common/TPCodecUtils:maxLumaSamplesForAVCProfileLevel	(II)I
    //   725: istore 9
    //   727: iload 9
    //   729: getstatic 234	com/tencent/thumbplayer/core/common/TPCodecUtils:mAVCMediaCodecMaxCapability	Lcom/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability;
    //   732: getfield 495	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability:maxLumaSamples	I
    //   735: if_icmplt +1136 -> 1871
    //   738: getstatic 234	com/tencent/thumbplayer/core/common/TPCodecUtils:mAVCMediaCodecMaxCapability	Lcom/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability;
    //   741: iload 9
    //   743: putfield 495	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability:maxLumaSamples	I
    //   746: getstatic 234	com/tencent/thumbplayer/core/common/TPCodecUtils:mAVCMediaCodecMaxCapability	Lcom/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability;
    //   749: iload 8
    //   751: putfield 498	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability:maxProfile	I
    //   754: getstatic 234	com/tencent/thumbplayer/core/common/TPCodecUtils:mAVCMediaCodecMaxCapability	Lcom/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability;
    //   757: iload 5
    //   759: putfield 501	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability:maxLevel	I
    //   762: bipush 26
    //   764: invokestatic 203	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   767: getstatic 234	com/tencent/thumbplayer/core/common/TPCodecUtils:mAVCMediaCodecMaxCapability	Lcom/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability;
    //   770: getstatic 242	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMap	Ljava/util/HashMap;
    //   773: invokestatic 505	com/tencent/thumbplayer/core/common/TPCodecUtils:replace	(Ljava/lang/Object;Ljava/lang/Object;Ljava/util/HashMap;)V
    //   776: goto +1095 -> 1871
    //   779: iconst_2
    //   780: new 264	java/lang/StringBuilder
    //   783: dup
    //   784: invokespecial 265	java/lang/StringBuilder:<init>	()V
    //   787: ldc_w 507
    //   790: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   793: getstatic 242	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMap	Ljava/util/HashMap;
    //   796: bipush 26
    //   798: invokestatic 203	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   801: invokevirtual 508	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   804: checkcast 229	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability
    //   807: getfield 498	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability:maxProfile	I
    //   810: invokevirtual 383	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   813: ldc_w 510
    //   816: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   819: getstatic 242	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMap	Ljava/util/HashMap;
    //   822: bipush 26
    //   824: invokestatic 203	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   827: invokevirtual 508	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   830: checkcast 229	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability
    //   833: getfield 501	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability:maxLevel	I
    //   836: invokevirtual 383	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   839: ldc_w 512
    //   842: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   845: getstatic 242	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMap	Ljava/util/HashMap;
    //   848: bipush 26
    //   850: invokestatic 203	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   853: invokevirtual 508	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   856: checkcast 229	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability
    //   859: getfield 495	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability:maxLumaSamples	I
    //   862: invokevirtual 383	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   865: invokevirtual 277	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   868: invokestatic 448	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   871: iconst_1
    //   872: istore_1
    //   873: getstatic 110	com/tencent/thumbplayer/core/common/TPCodecUtils:mHWCodecCapList	Ljava/util/ArrayList;
    //   876: ldc_w 514
    //   879: invokevirtual 481	java/util/ArrayList:contains	(Ljava/lang/Object;)Z
    //   882: istore 10
    //   884: iload_0
    //   885: istore_2
    //   886: iload 10
    //   888: ifeq +430 -> 1318
    //   891: iload_0
    //   892: istore_2
    //   893: iload_0
    //   894: ifne +424 -> 1318
    //   897: aload 16
    //   899: aload 15
    //   901: aload 19
    //   903: iconst_1
    //   904: anewarray 4	java/lang/Object
    //   907: dup
    //   908: iconst_0
    //   909: ldc_w 514
    //   912: aastore
    //   913: invokevirtual 440	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   916: invokevirtual 486	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   919: checkcast 488	[Ljava/lang/Object;
    //   922: checkcast 488	[Ljava/lang/Object;
    //   925: astore 22
    //   927: aload 22
    //   929: arraylength
    //   930: istore_2
    //   931: iconst_0
    //   932: istore_0
    //   933: iload_0
    //   934: iload_2
    //   935: if_icmpge +222 -> 1157
    //   938: aload 22
    //   940: iload_0
    //   941: aaload
    //   942: astore 23
    //   944: aload 17
    //   946: aload 23
    //   948: invokevirtual 486	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   951: checkcast 199	java/lang/Integer
    //   954: invokevirtual 443	java/lang/Integer:intValue	()I
    //   957: istore 5
    //   959: aload 18
    //   961: aload 23
    //   963: invokevirtual 486	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   966: checkcast 199	java/lang/Integer
    //   969: invokevirtual 443	java/lang/Integer:intValue	()I
    //   972: istore 8
    //   974: iload 8
    //   976: iload 5
    //   978: invokestatic 517	com/tencent/thumbplayer/core/common/TPCodecUtils:maxLumaSamplesForHEVCProfileLevel	(II)I
    //   981: istore 9
    //   983: iload 9
    //   985: getstatic 236	com/tencent/thumbplayer/core/common/TPCodecUtils:mHEVCMediaCodecMaxCapability	Lcom/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability;
    //   988: getfield 495	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability:maxLumaSamples	I
    //   991: if_icmplt +42 -> 1033
    //   994: getstatic 236	com/tencent/thumbplayer/core/common/TPCodecUtils:mHEVCMediaCodecMaxCapability	Lcom/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability;
    //   997: iload 9
    //   999: putfield 495	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability:maxLumaSamples	I
    //   1002: getstatic 236	com/tencent/thumbplayer/core/common/TPCodecUtils:mHEVCMediaCodecMaxCapability	Lcom/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability;
    //   1005: iload 8
    //   1007: putfield 498	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability:maxProfile	I
    //   1010: getstatic 236	com/tencent/thumbplayer/core/common/TPCodecUtils:mHEVCMediaCodecMaxCapability	Lcom/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability;
    //   1013: iload 5
    //   1015: putfield 501	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability:maxLevel	I
    //   1018: sipush 172
    //   1021: invokestatic 203	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1024: getstatic 236	com/tencent/thumbplayer/core/common/TPCodecUtils:mHEVCMediaCodecMaxCapability	Lcom/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability;
    //   1027: getstatic 242	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMap	Ljava/util/HashMap;
    //   1030: invokestatic 505	com/tencent/thumbplayer/core/common/TPCodecUtils:replace	(Ljava/lang/Object;Ljava/lang/Object;Ljava/util/HashMap;)V
    //   1033: iload_0
    //   1034: iconst_1
    //   1035: iadd
    //   1036: istore_0
    //   1037: goto -104 -> 933
    //   1040: astore 22
    //   1042: iconst_1
    //   1043: istore_1
    //   1044: iconst_4
    //   1045: new 264	java/lang/StringBuilder
    //   1048: dup
    //   1049: invokespecial 265	java/lang/StringBuilder:<init>	()V
    //   1052: ldc_w 519
    //   1055: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1058: aload 22
    //   1060: invokevirtual 520	java/lang/RuntimeException:getMessage	()Ljava/lang/String;
    //   1063: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1066: invokevirtual 277	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1069: invokestatic 448	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   1072: goto -199 -> 873
    //   1075: astore 11
    //   1077: iconst_4
    //   1078: new 264	java/lang/StringBuilder
    //   1081: dup
    //   1082: invokespecial 265	java/lang/StringBuilder:<init>	()V
    //   1085: ldc_w 522
    //   1088: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1091: aload 11
    //   1093: invokevirtual 523	java/lang/reflect/InvocationTargetException:getMessage	()Ljava/lang/String;
    //   1096: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1099: invokevirtual 277	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1102: invokestatic 448	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   1105: iconst_2
    //   1106: ldc_w 525
    //   1109: invokestatic 448	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   1112: getstatic 95	com/tencent/thumbplayer/core/common/TPCodecUtils:mIsLocalCacheEnabled	Z
    //   1115: ifeq +30 -> 1145
    //   1118: getstatic 136	com/tencent/thumbplayer/core/common/TPCodecUtils:mHWCodecCapListKey	Ljava/lang/String;
    //   1121: getstatic 110	com/tencent/thumbplayer/core/common/TPCodecUtils:mHWCodecCapList	Ljava/util/ArrayList;
    //   1124: invokestatic 527	com/tencent/thumbplayer/core/common/TPCodecUtils:cacheCapList	(Ljava/lang/String;Ljava/util/ArrayList;)V
    //   1127: getstatic 148	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMapKey	Ljava/lang/String;
    //   1130: getstatic 242	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMap	Ljava/util/HashMap;
    //   1133: invokestatic 529	com/tencent/thumbplayer/core/common/TPCodecUtils:cacheCapabilityMap	(Ljava/lang/String;Ljava/util/HashMap;)V
    //   1136: iconst_2
    //   1137: ldc 32
    //   1139: ldc_w 531
    //   1142: invokestatic 223	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;Ljava/lang/String;)V
    //   1145: iconst_1
    //   1146: putstatic 225	com/tencent/thumbplayer/core/common/TPCodecUtils:mIsMediaCodecCapGot	Z
    //   1149: getstatic 242	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMap	Ljava/util/HashMap;
    //   1152: astore 11
    //   1154: goto -1121 -> 33
    //   1157: iconst_2
    //   1158: new 264	java/lang/StringBuilder
    //   1161: dup
    //   1162: invokespecial 265	java/lang/StringBuilder:<init>	()V
    //   1165: ldc_w 533
    //   1168: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1171: getstatic 242	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMap	Ljava/util/HashMap;
    //   1174: sipush 172
    //   1177: invokestatic 203	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1180: invokevirtual 508	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1183: checkcast 229	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability
    //   1186: getfield 498	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability:maxProfile	I
    //   1189: invokevirtual 383	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1192: ldc_w 510
    //   1195: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1198: getstatic 242	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMap	Ljava/util/HashMap;
    //   1201: sipush 172
    //   1204: invokestatic 203	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1207: invokevirtual 508	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1210: checkcast 229	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability
    //   1213: getfield 501	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability:maxLevel	I
    //   1216: invokevirtual 383	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1219: ldc_w 512
    //   1222: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1225: getstatic 242	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMap	Ljava/util/HashMap;
    //   1228: sipush 172
    //   1231: invokestatic 203	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1234: invokevirtual 508	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1237: checkcast 229	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability
    //   1240: getfield 495	com/tencent/thumbplayer/core/common/TPCodecCapability$TPVCodecMaxCapability:maxLumaSamples	I
    //   1243: invokevirtual 383	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1246: invokevirtual 277	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1249: invokestatic 448	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   1252: iconst_1
    //   1253: istore_0
    //   1254: iconst_2
    //   1255: new 264	java/lang/StringBuilder
    //   1258: dup
    //   1259: invokespecial 265	java/lang/StringBuilder:<init>	()V
    //   1262: ldc_w 535
    //   1265: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1268: getstatic 242	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMap	Ljava/util/HashMap;
    //   1271: invokevirtual 378	java/util/HashMap:size	()I
    //   1274: invokevirtual 383	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1277: invokevirtual 277	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1280: invokestatic 448	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   1283: goto +579 -> 1862
    //   1286: astore 22
    //   1288: iconst_1
    //   1289: istore_2
    //   1290: iconst_4
    //   1291: new 264	java/lang/StringBuilder
    //   1294: dup
    //   1295: invokespecial 265	java/lang/StringBuilder:<init>	()V
    //   1298: ldc_w 537
    //   1301: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1304: aload 22
    //   1306: invokevirtual 520	java/lang/RuntimeException:getMessage	()Ljava/lang/String;
    //   1309: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1312: invokevirtual 277	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1315: invokestatic 448	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   1318: iload_2
    //   1319: istore_0
    //   1320: goto -66 -> 1254
    //   1323: iconst_2
    //   1324: ldc_w 525
    //   1327: invokestatic 448	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   1330: getstatic 95	com/tencent/thumbplayer/core/common/TPCodecUtils:mIsLocalCacheEnabled	Z
    //   1333: ifeq +30 -> 1363
    //   1336: getstatic 136	com/tencent/thumbplayer/core/common/TPCodecUtils:mHWCodecCapListKey	Ljava/lang/String;
    //   1339: getstatic 110	com/tencent/thumbplayer/core/common/TPCodecUtils:mHWCodecCapList	Ljava/util/ArrayList;
    //   1342: invokestatic 527	com/tencent/thumbplayer/core/common/TPCodecUtils:cacheCapList	(Ljava/lang/String;Ljava/util/ArrayList;)V
    //   1345: getstatic 148	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMapKey	Ljava/lang/String;
    //   1348: getstatic 242	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMap	Ljava/util/HashMap;
    //   1351: invokestatic 529	com/tencent/thumbplayer/core/common/TPCodecUtils:cacheCapabilityMap	(Ljava/lang/String;Ljava/util/HashMap;)V
    //   1354: iconst_2
    //   1355: ldc 32
    //   1357: ldc_w 531
    //   1360: invokestatic 223	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;Ljava/lang/String;)V
    //   1363: iconst_1
    //   1364: putstatic 225	com/tencent/thumbplayer/core/common/TPCodecUtils:mIsMediaCodecCapGot	Z
    //   1367: getstatic 242	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMap	Ljava/util/HashMap;
    //   1370: astore 11
    //   1372: goto -1339 -> 33
    //   1375: astore 11
    //   1377: iconst_4
    //   1378: new 264	java/lang/StringBuilder
    //   1381: dup
    //   1382: invokespecial 265	java/lang/StringBuilder:<init>	()V
    //   1385: ldc_w 522
    //   1388: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1391: aload 11
    //   1393: invokevirtual 538	java/lang/NoSuchMethodException:getMessage	()Ljava/lang/String;
    //   1396: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1399: invokevirtual 277	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1402: invokestatic 448	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   1405: iconst_2
    //   1406: ldc_w 525
    //   1409: invokestatic 448	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   1412: getstatic 95	com/tencent/thumbplayer/core/common/TPCodecUtils:mIsLocalCacheEnabled	Z
    //   1415: ifeq +30 -> 1445
    //   1418: getstatic 136	com/tencent/thumbplayer/core/common/TPCodecUtils:mHWCodecCapListKey	Ljava/lang/String;
    //   1421: getstatic 110	com/tencent/thumbplayer/core/common/TPCodecUtils:mHWCodecCapList	Ljava/util/ArrayList;
    //   1424: invokestatic 527	com/tencent/thumbplayer/core/common/TPCodecUtils:cacheCapList	(Ljava/lang/String;Ljava/util/ArrayList;)V
    //   1427: getstatic 148	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMapKey	Ljava/lang/String;
    //   1430: getstatic 242	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMap	Ljava/util/HashMap;
    //   1433: invokestatic 529	com/tencent/thumbplayer/core/common/TPCodecUtils:cacheCapabilityMap	(Ljava/lang/String;Ljava/util/HashMap;)V
    //   1436: iconst_2
    //   1437: ldc 32
    //   1439: ldc_w 531
    //   1442: invokestatic 223	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;Ljava/lang/String;)V
    //   1445: iconst_1
    //   1446: putstatic 225	com/tencent/thumbplayer/core/common/TPCodecUtils:mIsMediaCodecCapGot	Z
    //   1449: getstatic 242	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMap	Ljava/util/HashMap;
    //   1452: astore 11
    //   1454: goto -1421 -> 33
    //   1457: astore 11
    //   1459: iconst_4
    //   1460: new 264	java/lang/StringBuilder
    //   1463: dup
    //   1464: invokespecial 265	java/lang/StringBuilder:<init>	()V
    //   1467: ldc_w 522
    //   1470: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1473: aload 11
    //   1475: invokevirtual 539	java/lang/IllegalAccessException:getMessage	()Ljava/lang/String;
    //   1478: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1481: invokevirtual 277	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1484: invokestatic 448	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   1487: iconst_2
    //   1488: ldc_w 525
    //   1491: invokestatic 448	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   1494: getstatic 95	com/tencent/thumbplayer/core/common/TPCodecUtils:mIsLocalCacheEnabled	Z
    //   1497: ifeq +30 -> 1527
    //   1500: getstatic 136	com/tencent/thumbplayer/core/common/TPCodecUtils:mHWCodecCapListKey	Ljava/lang/String;
    //   1503: getstatic 110	com/tencent/thumbplayer/core/common/TPCodecUtils:mHWCodecCapList	Ljava/util/ArrayList;
    //   1506: invokestatic 527	com/tencent/thumbplayer/core/common/TPCodecUtils:cacheCapList	(Ljava/lang/String;Ljava/util/ArrayList;)V
    //   1509: getstatic 148	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMapKey	Ljava/lang/String;
    //   1512: getstatic 242	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMap	Ljava/util/HashMap;
    //   1515: invokestatic 529	com/tencent/thumbplayer/core/common/TPCodecUtils:cacheCapabilityMap	(Ljava/lang/String;Ljava/util/HashMap;)V
    //   1518: iconst_2
    //   1519: ldc 32
    //   1521: ldc_w 531
    //   1524: invokestatic 223	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;Ljava/lang/String;)V
    //   1527: iconst_1
    //   1528: putstatic 225	com/tencent/thumbplayer/core/common/TPCodecUtils:mIsMediaCodecCapGot	Z
    //   1531: getstatic 242	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMap	Ljava/util/HashMap;
    //   1534: astore 11
    //   1536: goto -1503 -> 33
    //   1539: astore 11
    //   1541: iconst_4
    //   1542: new 264	java/lang/StringBuilder
    //   1545: dup
    //   1546: invokespecial 265	java/lang/StringBuilder:<init>	()V
    //   1549: ldc_w 522
    //   1552: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1555: aload 11
    //   1557: invokevirtual 540	java/lang/NoSuchFieldException:getMessage	()Ljava/lang/String;
    //   1560: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1563: invokevirtual 277	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1566: invokestatic 448	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   1569: iconst_2
    //   1570: ldc_w 525
    //   1573: invokestatic 448	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   1576: getstatic 95	com/tencent/thumbplayer/core/common/TPCodecUtils:mIsLocalCacheEnabled	Z
    //   1579: ifeq +30 -> 1609
    //   1582: getstatic 136	com/tencent/thumbplayer/core/common/TPCodecUtils:mHWCodecCapListKey	Ljava/lang/String;
    //   1585: getstatic 110	com/tencent/thumbplayer/core/common/TPCodecUtils:mHWCodecCapList	Ljava/util/ArrayList;
    //   1588: invokestatic 527	com/tencent/thumbplayer/core/common/TPCodecUtils:cacheCapList	(Ljava/lang/String;Ljava/util/ArrayList;)V
    //   1591: getstatic 148	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMapKey	Ljava/lang/String;
    //   1594: getstatic 242	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMap	Ljava/util/HashMap;
    //   1597: invokestatic 529	com/tencent/thumbplayer/core/common/TPCodecUtils:cacheCapabilityMap	(Ljava/lang/String;Ljava/util/HashMap;)V
    //   1600: iconst_2
    //   1601: ldc 32
    //   1603: ldc_w 531
    //   1606: invokestatic 223	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;Ljava/lang/String;)V
    //   1609: iconst_1
    //   1610: putstatic 225	com/tencent/thumbplayer/core/common/TPCodecUtils:mIsMediaCodecCapGot	Z
    //   1613: getstatic 242	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMap	Ljava/util/HashMap;
    //   1616: astore 11
    //   1618: goto -1585 -> 33
    //   1621: astore 11
    //   1623: iconst_4
    //   1624: new 264	java/lang/StringBuilder
    //   1627: dup
    //   1628: invokespecial 265	java/lang/StringBuilder:<init>	()V
    //   1631: ldc_w 522
    //   1634: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1637: aload 11
    //   1639: invokevirtual 541	java/lang/ClassNotFoundException:getMessage	()Ljava/lang/String;
    //   1642: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1645: invokevirtual 277	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1648: invokestatic 448	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   1651: iconst_2
    //   1652: ldc_w 525
    //   1655: invokestatic 448	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   1658: getstatic 95	com/tencent/thumbplayer/core/common/TPCodecUtils:mIsLocalCacheEnabled	Z
    //   1661: ifeq +30 -> 1691
    //   1664: getstatic 136	com/tencent/thumbplayer/core/common/TPCodecUtils:mHWCodecCapListKey	Ljava/lang/String;
    //   1667: getstatic 110	com/tencent/thumbplayer/core/common/TPCodecUtils:mHWCodecCapList	Ljava/util/ArrayList;
    //   1670: invokestatic 527	com/tencent/thumbplayer/core/common/TPCodecUtils:cacheCapList	(Ljava/lang/String;Ljava/util/ArrayList;)V
    //   1673: getstatic 148	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMapKey	Ljava/lang/String;
    //   1676: getstatic 242	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMap	Ljava/util/HashMap;
    //   1679: invokestatic 529	com/tencent/thumbplayer/core/common/TPCodecUtils:cacheCapabilityMap	(Ljava/lang/String;Ljava/util/HashMap;)V
    //   1682: iconst_2
    //   1683: ldc 32
    //   1685: ldc_w 531
    //   1688: invokestatic 223	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;Ljava/lang/String;)V
    //   1691: iconst_1
    //   1692: putstatic 225	com/tencent/thumbplayer/core/common/TPCodecUtils:mIsMediaCodecCapGot	Z
    //   1695: getstatic 242	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMap	Ljava/util/HashMap;
    //   1698: astore 11
    //   1700: goto -1667 -> 33
    //   1703: astore 11
    //   1705: iconst_4
    //   1706: new 264	java/lang/StringBuilder
    //   1709: dup
    //   1710: invokespecial 265	java/lang/StringBuilder:<init>	()V
    //   1713: ldc_w 522
    //   1716: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1719: aload 11
    //   1721: invokevirtual 520	java/lang/RuntimeException:getMessage	()Ljava/lang/String;
    //   1724: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1727: invokevirtual 277	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1730: invokestatic 448	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   1733: iconst_2
    //   1734: ldc_w 525
    //   1737: invokestatic 448	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   1740: getstatic 95	com/tencent/thumbplayer/core/common/TPCodecUtils:mIsLocalCacheEnabled	Z
    //   1743: ifeq +30 -> 1773
    //   1746: getstatic 136	com/tencent/thumbplayer/core/common/TPCodecUtils:mHWCodecCapListKey	Ljava/lang/String;
    //   1749: getstatic 110	com/tencent/thumbplayer/core/common/TPCodecUtils:mHWCodecCapList	Ljava/util/ArrayList;
    //   1752: invokestatic 527	com/tencent/thumbplayer/core/common/TPCodecUtils:cacheCapList	(Ljava/lang/String;Ljava/util/ArrayList;)V
    //   1755: getstatic 148	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMapKey	Ljava/lang/String;
    //   1758: getstatic 242	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMap	Ljava/util/HashMap;
    //   1761: invokestatic 529	com/tencent/thumbplayer/core/common/TPCodecUtils:cacheCapabilityMap	(Ljava/lang/String;Ljava/util/HashMap;)V
    //   1764: iconst_2
    //   1765: ldc 32
    //   1767: ldc_w 531
    //   1770: invokestatic 223	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;Ljava/lang/String;)V
    //   1773: iconst_1
    //   1774: putstatic 225	com/tencent/thumbplayer/core/common/TPCodecUtils:mIsMediaCodecCapGot	Z
    //   1777: getstatic 242	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMap	Ljava/util/HashMap;
    //   1780: astore 11
    //   1782: goto -1749 -> 33
    //   1785: astore 11
    //   1787: iconst_2
    //   1788: ldc_w 525
    //   1791: invokestatic 448	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;)V
    //   1794: getstatic 95	com/tencent/thumbplayer/core/common/TPCodecUtils:mIsLocalCacheEnabled	Z
    //   1797: ifeq +30 -> 1827
    //   1800: getstatic 136	com/tencent/thumbplayer/core/common/TPCodecUtils:mHWCodecCapListKey	Ljava/lang/String;
    //   1803: getstatic 110	com/tencent/thumbplayer/core/common/TPCodecUtils:mHWCodecCapList	Ljava/util/ArrayList;
    //   1806: invokestatic 527	com/tencent/thumbplayer/core/common/TPCodecUtils:cacheCapList	(Ljava/lang/String;Ljava/util/ArrayList;)V
    //   1809: getstatic 148	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMapKey	Ljava/lang/String;
    //   1812: getstatic 242	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMap	Ljava/util/HashMap;
    //   1815: invokestatic 529	com/tencent/thumbplayer/core/common/TPCodecUtils:cacheCapabilityMap	(Ljava/lang/String;Ljava/util/HashMap;)V
    //   1818: iconst_2
    //   1819: ldc 32
    //   1821: ldc_w 531
    //   1824: invokestatic 223	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;Ljava/lang/String;)V
    //   1827: iconst_1
    //   1828: putstatic 225	com/tencent/thumbplayer/core/common/TPCodecUtils:mIsMediaCodecCapGot	Z
    //   1831: getstatic 242	com/tencent/thumbplayer/core/common/TPCodecUtils:mMaxVCodecHwCapabilityMap	Ljava/util/HashMap;
    //   1834: astore 11
    //   1836: goto -1803 -> 33
    //   1839: astore 11
    //   1841: ldc 2
    //   1843: monitorexit
    //   1844: aload 11
    //   1846: athrow
    //   1847: goto -974 -> 873
    //   1850: iload_3
    //   1851: iconst_1
    //   1852: iadd
    //   1853: istore_3
    //   1854: iload_2
    //   1855: istore_1
    //   1856: iload 5
    //   1858: istore_0
    //   1859: goto -1446 -> 413
    //   1862: iload 4
    //   1864: iconst_1
    //   1865: iadd
    //   1866: istore 4
    //   1868: goto -1356 -> 512
    //   1871: iload_1
    //   1872: iconst_1
    //   1873: iadd
    //   1874: istore_1
    //   1875: goto -1198 -> 677
    // Local variable table:
    //   start	length	slot	name	signature
    //   213	1646	0	i	int
    //   211	1664	1	j	int
    //   459	1396	2	k	int
    //   412	1442	3	m	int
    //   510	1357	4	n	int
    //   461	1396	5	i1	int
    //   384	33	6	i2	int
    //   507	15	7	i3	int
    //   716	290	8	i4	int
    //   725	273	9	i5	int
    //   630	257	10	bool	boolean
    //   31	143	11	localObject1	Object
    //   178	19	11	localException	Exception
    //   220	200	11	localObject2	Object
    //   1075	17	11	localInvocationTargetException	java.lang.reflect.InvocationTargetException
    //   1152	219	11	localHashMap1	HashMap
    //   1375	17	11	localNoSuchMethodException	java.lang.NoSuchMethodException
    //   1452	1	11	localHashMap2	HashMap
    //   1457	17	11	localIllegalAccessException	java.lang.IllegalAccessException
    //   1534	1	11	localHashMap3	HashMap
    //   1539	17	11	localNoSuchFieldException	java.lang.NoSuchFieldException
    //   1616	1	11	localHashMap4	HashMap
    //   1621	17	11	localClassNotFoundException	java.lang.ClassNotFoundException
    //   1698	1	11	localHashMap5	HashMap
    //   1703	17	11	localRuntimeException1	java.lang.RuntimeException
    //   1780	1	11	localHashMap6	HashMap
    //   1785	1	11	localObject3	Object
    //   1834	1	11	localHashMap7	HashMap
    //   1839	6	11	localObject4	Object
    //   276	210	12	localMethod1	Method
    //   290	177	13	localMethod2	Method
    //   304	135	14	localMethod3	Method
    //   262	638	15	localObject5	Object
    //   338	560	16	localField1	Field
    //   356	589	17	localField2	Field
    //   346	614	18	localObject6	Object
    //   234	668	19	localObject7	Object
    //   483	107	20	str	String
    //   502	23	21	arrayOfString	String[]
    //   529	410	22	localObject8	Object
    //   1040	19	22	localRuntimeException2	java.lang.RuntimeException
    //   1286	19	22	localRuntimeException3	java.lang.RuntimeException
    //   686	276	23	localObject9	Object
    // Exception table:
    //   from	to	target	type
    //   39	75	178	java/lang/Exception
    //   75	83	178	java/lang/Exception
    //   88	93	178	java/lang/Exception
    //   93	116	178	java/lang/Exception
    //   121	175	178	java/lang/Exception
    //   641	675	1040	java/lang/RuntimeException
    //   688	776	1040	java/lang/RuntimeException
    //   779	871	1040	java/lang/RuntimeException
    //   214	411	1075	java/lang/reflect/InvocationTargetException
    //   419	458	1075	java/lang/reflect/InvocationTargetException
    //   466	509	1075	java/lang/reflect/InvocationTargetException
    //   531	600	1075	java/lang/reflect/InvocationTargetException
    //   600	609	1075	java/lang/reflect/InvocationTargetException
    //   612	632	1075	java/lang/reflect/InvocationTargetException
    //   641	675	1075	java/lang/reflect/InvocationTargetException
    //   688	776	1075	java/lang/reflect/InvocationTargetException
    //   779	871	1075	java/lang/reflect/InvocationTargetException
    //   873	884	1075	java/lang/reflect/InvocationTargetException
    //   897	931	1075	java/lang/reflect/InvocationTargetException
    //   944	1033	1075	java/lang/reflect/InvocationTargetException
    //   1044	1072	1075	java/lang/reflect/InvocationTargetException
    //   1157	1252	1075	java/lang/reflect/InvocationTargetException
    //   1254	1283	1075	java/lang/reflect/InvocationTargetException
    //   1290	1318	1075	java/lang/reflect/InvocationTargetException
    //   897	931	1286	java/lang/RuntimeException
    //   944	1033	1286	java/lang/RuntimeException
    //   1157	1252	1286	java/lang/RuntimeException
    //   214	411	1375	java/lang/NoSuchMethodException
    //   419	458	1375	java/lang/NoSuchMethodException
    //   466	509	1375	java/lang/NoSuchMethodException
    //   531	600	1375	java/lang/NoSuchMethodException
    //   600	609	1375	java/lang/NoSuchMethodException
    //   612	632	1375	java/lang/NoSuchMethodException
    //   641	675	1375	java/lang/NoSuchMethodException
    //   688	776	1375	java/lang/NoSuchMethodException
    //   779	871	1375	java/lang/NoSuchMethodException
    //   873	884	1375	java/lang/NoSuchMethodException
    //   897	931	1375	java/lang/NoSuchMethodException
    //   944	1033	1375	java/lang/NoSuchMethodException
    //   1044	1072	1375	java/lang/NoSuchMethodException
    //   1157	1252	1375	java/lang/NoSuchMethodException
    //   1254	1283	1375	java/lang/NoSuchMethodException
    //   1290	1318	1375	java/lang/NoSuchMethodException
    //   214	411	1457	java/lang/IllegalAccessException
    //   419	458	1457	java/lang/IllegalAccessException
    //   466	509	1457	java/lang/IllegalAccessException
    //   531	600	1457	java/lang/IllegalAccessException
    //   600	609	1457	java/lang/IllegalAccessException
    //   612	632	1457	java/lang/IllegalAccessException
    //   641	675	1457	java/lang/IllegalAccessException
    //   688	776	1457	java/lang/IllegalAccessException
    //   779	871	1457	java/lang/IllegalAccessException
    //   873	884	1457	java/lang/IllegalAccessException
    //   897	931	1457	java/lang/IllegalAccessException
    //   944	1033	1457	java/lang/IllegalAccessException
    //   1044	1072	1457	java/lang/IllegalAccessException
    //   1157	1252	1457	java/lang/IllegalAccessException
    //   1254	1283	1457	java/lang/IllegalAccessException
    //   1290	1318	1457	java/lang/IllegalAccessException
    //   214	411	1539	java/lang/NoSuchFieldException
    //   419	458	1539	java/lang/NoSuchFieldException
    //   466	509	1539	java/lang/NoSuchFieldException
    //   531	600	1539	java/lang/NoSuchFieldException
    //   600	609	1539	java/lang/NoSuchFieldException
    //   612	632	1539	java/lang/NoSuchFieldException
    //   641	675	1539	java/lang/NoSuchFieldException
    //   688	776	1539	java/lang/NoSuchFieldException
    //   779	871	1539	java/lang/NoSuchFieldException
    //   873	884	1539	java/lang/NoSuchFieldException
    //   897	931	1539	java/lang/NoSuchFieldException
    //   944	1033	1539	java/lang/NoSuchFieldException
    //   1044	1072	1539	java/lang/NoSuchFieldException
    //   1157	1252	1539	java/lang/NoSuchFieldException
    //   1254	1283	1539	java/lang/NoSuchFieldException
    //   1290	1318	1539	java/lang/NoSuchFieldException
    //   214	411	1621	java/lang/ClassNotFoundException
    //   419	458	1621	java/lang/ClassNotFoundException
    //   466	509	1621	java/lang/ClassNotFoundException
    //   531	600	1621	java/lang/ClassNotFoundException
    //   600	609	1621	java/lang/ClassNotFoundException
    //   612	632	1621	java/lang/ClassNotFoundException
    //   641	675	1621	java/lang/ClassNotFoundException
    //   688	776	1621	java/lang/ClassNotFoundException
    //   779	871	1621	java/lang/ClassNotFoundException
    //   873	884	1621	java/lang/ClassNotFoundException
    //   897	931	1621	java/lang/ClassNotFoundException
    //   944	1033	1621	java/lang/ClassNotFoundException
    //   1044	1072	1621	java/lang/ClassNotFoundException
    //   1157	1252	1621	java/lang/ClassNotFoundException
    //   1254	1283	1621	java/lang/ClassNotFoundException
    //   1290	1318	1621	java/lang/ClassNotFoundException
    //   214	411	1703	java/lang/RuntimeException
    //   419	458	1703	java/lang/RuntimeException
    //   466	509	1703	java/lang/RuntimeException
    //   531	600	1703	java/lang/RuntimeException
    //   600	609	1703	java/lang/RuntimeException
    //   612	632	1703	java/lang/RuntimeException
    //   873	884	1703	java/lang/RuntimeException
    //   1044	1072	1703	java/lang/RuntimeException
    //   1254	1283	1703	java/lang/RuntimeException
    //   1290	1318	1703	java/lang/RuntimeException
    //   214	411	1785	finally
    //   419	458	1785	finally
    //   466	509	1785	finally
    //   531	600	1785	finally
    //   600	609	1785	finally
    //   612	632	1785	finally
    //   641	675	1785	finally
    //   688	776	1785	finally
    //   779	871	1785	finally
    //   873	884	1785	finally
    //   897	931	1785	finally
    //   944	1033	1785	finally
    //   1044	1072	1785	finally
    //   1077	1105	1785	finally
    //   1157	1252	1785	finally
    //   1254	1283	1785	finally
    //   1290	1318	1785	finally
    //   1377	1405	1785	finally
    //   1459	1487	1785	finally
    //   1541	1569	1785	finally
    //   1623	1651	1785	finally
    //   1705	1733	1785	finally
    //   3	33	1839	finally
    //   39	75	1839	finally
    //   75	83	1839	finally
    //   88	93	1839	finally
    //   93	116	1839	finally
    //   121	175	1839	finally
    //   180	210	1839	finally
    //   1105	1145	1839	finally
    //   1145	1154	1839	finally
    //   1323	1363	1839	finally
    //   1363	1372	1839	finally
    //   1405	1445	1839	finally
    //   1445	1454	1839	finally
    //   1487	1527	1839	finally
    //   1527	1536	1839	finally
    //   1569	1609	1839	finally
    //   1609	1618	1839	finally
    //   1651	1691	1839	finally
    //   1691	1700	1839	finally
    //   1733	1773	1839	finally
    //   1773	1782	1839	finally
    //   1787	1827	1839	finally
    //   1827	1836	1839	finally
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
    //   6: new 264	java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial 265	java/lang/StringBuilder:<init>	()V
    //   13: ldc_w 589
    //   16: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   19: iload_1
    //   20: invokevirtual 592	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   23: invokevirtual 277	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   26: invokestatic 223	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;Ljava/lang/String;)V
    //   29: aload_0
    //   30: invokevirtual 598	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   33: putstatic 93	com/tencent/thumbplayer/core/common/TPCodecUtils:mApplicationContext	Landroid/content/Context;
    //   36: iload_1
    //   37: putstatic 95	com/tencent/thumbplayer/core/common/TPCodecUtils:mIsLocalCacheEnabled	Z
    //   40: iload_1
    //   41: ifeq +37 -> 78
    //   44: getstatic 132	com/tencent/thumbplayer/core/common/TPCodecUtils:mAppVersionKey	Ljava/lang/String;
    //   47: invokestatic 600	com/tencent/thumbplayer/core/common/TPCodecUtils:getCachedStringInfo	(Ljava/lang/String;)Ljava/lang/String;
    //   50: astore_0
    //   51: getstatic 103	com/tencent/thumbplayer/core/common/TPCodecUtils:mAppVersion	Ljava/lang/String;
    //   54: aload_0
    //   55: invokevirtual 603	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   58: ifne +42 -> 100
    //   61: iconst_1
    //   62: putstatic 97	com/tencent/thumbplayer/core/common/TPCodecUtils:mNeedToReprobeDecoderCapability	Z
    //   65: iconst_1
    //   66: putstatic 99	com/tencent/thumbplayer/core/common/TPCodecUtils:mNeedToReprobeHDRCapability	Z
    //   69: iconst_2
    //   70: ldc 32
    //   72: ldc_w 605
    //   75: invokestatic 223	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;Ljava/lang/String;)V
    //   78: invokestatic 607	com/tencent/thumbplayer/core/common/TPCodecUtils:getDecoderMaxCapabilityMapAsync	()V
    //   81: getstatic 95	com/tencent/thumbplayer/core/common/TPCodecUtils:mIsLocalCacheEnabled	Z
    //   84: ifeq +12 -> 96
    //   87: getstatic 132	com/tencent/thumbplayer/core/common/TPCodecUtils:mAppVersionKey	Ljava/lang/String;
    //   90: getstatic 103	com/tencent/thumbplayer/core/common/TPCodecUtils:mAppVersion	Ljava/lang/String;
    //   93: invokestatic 609	com/tencent/thumbplayer/core/common/TPCodecUtils:cacheStringInfo	(Ljava/lang/String;Ljava/lang/String;)V
    //   96: ldc 2
    //   98: monitorexit
    //   99: return
    //   100: iconst_0
    //   101: putstatic 97	com/tencent/thumbplayer/core/common/TPCodecUtils:mNeedToReprobeDecoderCapability	Z
    //   104: iconst_0
    //   105: putstatic 99	com/tencent/thumbplayer/core/common/TPCodecUtils:mNeedToReprobeHDRCapability	Z
    //   108: iconst_2
    //   109: ldc 32
    //   111: ldc_w 611
    //   114: invokestatic 223	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;Ljava/lang/String;)V
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
      if (mIsInBlackListForHardwareDec != 0) {}
    }
    for (;;)
    {
      return false;
      return true;
      mIsInBlackListForHardwareDec = 0;
      try
      {
        String str = Build.MODEL;
        if ((!TextUtils.isEmpty(str)) && ((str.equals("SM-J7008")) || (str.equals("SM-J5008")) || (str.equals("TCL i806")) || (str.equals("NX511J")) || (str.equals("vivo Y11i T")) || (str.equals("长虹智能电视")) || (str.equals("MI 1S")) || (str.equals("SP9832A")) || (str.equals("SP9830A")) || (str.equals("VOTO GT17")) || (str.equals("EVA-AL10"))))
        {
          TPNativeLog.printLog(2, "TPCodecUtils", "isBlackListForHardwareDec, deviceName: " + str);
          mIsInBlackListForHardwareDec = 1;
          return true;
        }
        if ((!TextUtils.isEmpty(paramString)) && (paramString.equals("video/hevc")) && (Build.VERSION.SDK_INT >= 14) && (!TextUtils.isEmpty(str)) && (("PRO 7 Plus".equals(str)) || ("PRO 7-H".equals(str)) || ("PRO+7+Plus".equals(str))))
        {
          mIsInBlackListForHardwareDec = 1;
          return true;
        }
      }
      catch (Exception paramString)
      {
        TPNativeLog.printLog(4, "TPCodecUtils", "isBlackListForHardwareDec exception");
      }
    }
    return false;
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
        bool2 = bool1;
        if (i < k)
        {
          bool2 = bool1;
          if (bool1) {
            break;
          }
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
        bool2 = false;
        sIsDDPSup = bool2;
        sIsDDPInit = true;
        return sIsDDPSup;
      }
      try
      {
        localObject2 = (String[])localMethod.invoke(((Method)localObject1).invoke(null, new Object[] { Integer.valueOf(i) }), new Object[0]);
        m = localObject2.length;
        j = 0;
        if (j >= m) {
          break label250;
        }
        localObject3 = localObject2[j];
        if (!localObject3.equals("audio/eac3"))
        {
          bool2 = localObject3.equals("audio/ec3");
          if (!bool2) {
            continue;
          }
        }
        bool1 = true;
      }
      catch (Exception localException2)
      {
        bool2 = bool1;
        continue;
        continue;
      }
      i += 1;
      continue;
      j += 1;
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
      label23:
      break label23;
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
    if ((mHWCodecCapList != null) && (mHWCodecCapList.size() > 0) && ((mHWCodecCapList.contains("audio/eac3")) || (mHWCodecCapList.contains("audio/ec3")))) {}
    while ((mSoftCodecCapList != null) && (mSoftCodecCapList.size() > 0) && ((mSoftCodecCapList.contains("audio/eac3")) || (mSoftCodecCapList.contains("audio/ec3")))) {
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
        if ((!TextUtils.equals(paramString, "audio/eac3")) && (!TextUtils.equals(paramString, "audio/ec3"))) {
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