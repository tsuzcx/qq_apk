package com.tencent.thumbplayer.core.common;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.thumbplayer.core.thirdparties.LocalCache;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

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
  private static TPCodecCapability.TPVCodecMaxCapability mAVCSWMaxCapability;
  private static TPCodecCapability.TPVCodecMaxCapability mAVS3WMaxCapability;
  private static int mAvs3DeviceLevel = -1;
  private static ArrayList<String> mBlackListModel;
  private static HashMap<String, Integer> mCodecCap;
  protected static ArrayList<String> mCodecCapList = new ArrayList();
  private static Context mContext;
  private static HashMap<String, TPCodecCapability.TPHdrSupportVersionRange> mCuvaSupportVersionMap;
  private static HashMap<String, TPMediaDecoderInfo> mDecoderInfoMap = new HashMap();
  private static HashMap<Integer, ArrayList<String>> mDrmL1BlackList;
  private static int mFhdAvs3HisiIndex = 0;
  private static int mFhdAvs3QualcommIndex = 0;
  private static TPCodecCapability.TPVCodecMaxCapability mHEVCSWMaxCapability;
  private static int mHdHevcHisiIndex = 0;
  private static int mHdHevcMtkIndex = 0;
  private static int mHdHevcQualcommIndex = 0;
  private static int mHdHevcSumsingIndex = 0;
  private static HashMap<Integer, HashMap<String, TPCodecCapability.TPHdrSupportVersionRange>> mHdrBlackMap;
  private static HashMap<Integer, HashMap<String, TPCodecCapability.TPHdrSupportVersionRange>> mHdrWhiteMap;
  private static int mHevcDeviceLevel = -1;
  private static boolean mIsFFmpegCapGot;
  private static boolean mIsInitDone;
  private static boolean mIsMediaCodecCapGot;
  private static LocalCache mLocalCache;
  private static HashMap<Integer, TPCodecCapability.TPVCodecMaxCapability> mMaxVCodecHwCapabilityMap;
  private static HashMap<Integer, TPCodecCapability.TPVCodecMaxCapability> mMaxVCodecSwCapabilityMap;
  private static int mShdAvs3QualcommIndex;
  private static int mShdHevcHisiIndex;
  private static int mShdHevcMtkIndex;
  private static int mShdHevcQualcommIndex;
  private static int mShdHevcSumsingIndex;
  protected static ArrayList<String> mSoftCodecCapList = new ArrayList();
  private static ArrayList<String> mSupportedHWCodec;
  private static TPCodecCapability.TPVCodecMaxCapability mVP9SWMaxCapability;
  private static ArrayList<String> mWideVineBlackListModel;
  protected static ArrayList<String> mffmpegVCodecCapList = new ArrayList();
  
  static
  {
    mBlackListModel = new ArrayList();
    mSupportedHWCodec = new ArrayList();
    mHdrWhiteMap = new HashMap();
    mHdrBlackMap = new HashMap();
    mCuvaSupportVersionMap = new HashMap();
    mWideVineBlackListModel = new ArrayList();
    mDrmL1BlackList = new HashMap();
    mIsInitDone = false;
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
    HashMap localHashMap = mCodecCap;
    Integer localInteger = Integer.valueOf(7);
    localHashMap.put("NX511J", localInteger);
    mCodecCap.put("Hi3798MV100", localInteger);
    mCodecCap.put("长虹智能电视", localInteger);
    mCodecCap.put("Android TV on Tcl 901", localInteger);
    mCodecCap.put("xt880b", localInteger);
    TPNativeLog.printLog(2, "TPCodecUtils", "white list init");
    mSupportedHWCodec.add("video/avc");
    mSupportedHWCodec.add("video/hevc");
    mSupportedHWCodec.add("video/x-vnd.on2.vp9");
    mBlackListModel.add("SM-J7008");
    mBlackListModel.add("SM-J5008");
    mBlackListModel.add("TCL i806");
    mBlackListModel.add("NX511J");
    mBlackListModel.add("vivo Y11i T");
    mBlackListModel.add("长虹智能电视");
    mBlackListModel.add("MI 1S");
    mBlackListModel.add("SP9832A");
    mBlackListModel.add("SP9830A");
    mBlackListModel.add("VOTO GT17");
    mBlackListModel.add("EVA-AL10");
    mCuvaSupportVersionMap.put("TAS-AL00", new TPCodecCapability.TPHdrSupportVersionRange(9999999, 1100165, 99, 3));
    mCuvaSupportVersionMap.put("TAS-TL00", new TPCodecCapability.TPHdrSupportVersionRange(9999999, 1100165, 99, 3));
    mCuvaSupportVersionMap.put("TAS-AN00", new TPCodecCapability.TPHdrSupportVersionRange(9999999, 1100165, 99, 3));
    mCuvaSupportVersionMap.put("LIO-AN00", new TPCodecCapability.TPHdrSupportVersionRange(9999999, 1100165, 99, 3));
    mCuvaSupportVersionMap.put("LIO-AN00P", new TPCodecCapability.TPHdrSupportVersionRange(9999999, 1100165, 99, 3));
    mCuvaSupportVersionMap.put("LIO-TL00", new TPCodecCapability.TPHdrSupportVersionRange(9999999, 1100165, 99, 3));
    mCuvaSupportVersionMap.put("LIO-AL00", new TPCodecCapability.TPHdrSupportVersionRange(9999999, 1100165, 99, 3));
    mCuvaSupportVersionMap.put("ANA-AN00", new TPCodecCapability.TPHdrSupportVersionRange(9999999, 1100165, 99, 3));
    mCuvaSupportVersionMap.put("ANA-TN00", new TPCodecCapability.TPHdrSupportVersionRange(9999999, 1100165, 99, 3));
    mCuvaSupportVersionMap.put("ELS-AN00", new TPCodecCapability.TPHdrSupportVersionRange(9999999, 1100165, 99, 3));
    mCuvaSupportVersionMap.put("ELS-TN00", new TPCodecCapability.TPHdrSupportVersionRange(9999999, 1100165, 99, 3));
    mCuvaSupportVersionMap.put("ELS-AN10", new TPCodecCapability.TPHdrSupportVersionRange(9999999, 1100166, 99, 3));
    mCuvaSupportVersionMap.put("MRX-AL09", new TPCodecCapability.TPHdrSupportVersionRange(9999999, 1100150, 99, 5));
    mCuvaSupportVersionMap.put("MRX-AL19", new TPCodecCapability.TPHdrSupportVersionRange(9999999, 1100150, 99, 5));
    mCuvaSupportVersionMap.put("MRX-W09", new TPCodecCapability.TPHdrSupportVersionRange(9999999, 1100150, 99, 5));
    mCuvaSupportVersionMap.put("MRX-W19", new TPCodecCapability.TPHdrSupportVersionRange(9999999, 1100150, 99, 5));
    mCuvaSupportVersionMap.put("MRX-AN19", new TPCodecCapability.TPHdrSupportVersionRange(9999999, 1100150, 99, 5));
    mCuvaSupportVersionMap.put("MRX-W29", new TPCodecCapability.TPHdrSupportVersionRange(9999999, 1100150, 99, 5));
    mCuvaSupportVersionMap.put("MRX-W39", new TPCodecCapability.TPHdrSupportVersionRange(9999999, 1100150, 99, 5));
    mCuvaSupportVersionMap.put("OCE-AN00", new TPCodecCapability.TPHdrSupportVersionRange(9999999, 0, 99, 0));
    mCuvaSupportVersionMap.put("NOH-NX9", new TPCodecCapability.TPHdrSupportVersionRange(9999999, 0, 99, 0));
    mCuvaSupportVersionMap.put("NOH-AN00", new TPCodecCapability.TPHdrSupportVersionRange(9999999, 0, 99, 0));
    mCuvaSupportVersionMap.put("NOP-AN00", new TPCodecCapability.TPHdrSupportVersionRange(9999999, 0, 99, 0));
    mWideVineBlackListModel.add("RVL-AL09");
    mWideVineBlackListModel.add("CLT-L29");
    mWideVineBlackListModel.add("ASUS_Z00AD");
    mWideVineBlackListModel.add(Build.MODEL);
    mDrmL1BlackList.put(Integer.valueOf(0), mWideVineBlackListModel);
    mIsMediaCodecCapGot = false;
    mIsFFmpegCapGot = false;
    mAVCSWMaxCapability = new TPCodecCapability.TPVCodecMaxCapability(0, 0, 0, 30);
    mHEVCSWMaxCapability = new TPCodecCapability.TPVCodecMaxCapability(0, 0, 0, 30);
    mVP9SWMaxCapability = new TPCodecCapability.TPVCodecMaxCapability(0, 0, 0, 30);
    mAVS3WMaxCapability = new TPCodecCapability.TPVCodecMaxCapability(0, 0, 0, 30);
    mMaxVCodecHwCapabilityMap = new HashMap();
    mMaxVCodecSwCapabilityMap = new HashMap();
  }
  
  public static boolean addDRMLevel1Blacklist(int paramInt)
  {
    if (mDrmL1BlackList.containsKey(Integer.valueOf(paramInt)))
    {
      ArrayList localArrayList = (ArrayList)mDrmL1BlackList.get(Integer.valueOf(paramInt));
      if (!localArrayList.contains(Build.MODEL)) {
        localArrayList.add(Build.MODEL);
      }
      mDrmL1BlackList.remove(Integer.valueOf(paramInt));
      mDrmL1BlackList.put(Integer.valueOf(paramInt), localArrayList);
    }
    return true;
  }
  
  public static boolean addHDRBlackList(int paramInt, String paramString, TPCodecCapability.TPHdrSupportVersionRange paramTPHdrSupportVersionRange)
  {
    if (paramTPHdrSupportVersionRange == null) {
      return false;
    }
    HashMap localHashMap;
    if (mHdrBlackMap.containsKey(Integer.valueOf(paramInt)))
    {
      localHashMap = (HashMap)mHdrBlackMap.get(Integer.valueOf(paramInt));
      mHdrBlackMap.remove(Integer.valueOf(paramInt));
      if (!localHashMap.containsKey(paramString)) {
        localHashMap.put(paramString, paramTPHdrSupportVersionRange);
      }
      localHashMap.remove(paramString);
      localHashMap.put(paramString, paramTPHdrSupportVersionRange);
      mHdrBlackMap.put(Integer.valueOf(paramInt), localHashMap);
    }
    else
    {
      localHashMap = new HashMap();
      localHashMap.put(paramString, paramTPHdrSupportVersionRange);
      mHdrBlackMap.put(Integer.valueOf(paramInt), localHashMap);
    }
    return true;
  }
  
  public static boolean addHDRWhiteList(int paramInt, String paramString, TPCodecCapability.TPHdrSupportVersionRange paramTPHdrSupportVersionRange)
  {
    if (paramTPHdrSupportVersionRange == null) {
      return false;
    }
    HashMap localHashMap;
    if (mHdrWhiteMap.containsKey(Integer.valueOf(paramInt)))
    {
      localHashMap = (HashMap)mHdrWhiteMap.get(Integer.valueOf(paramInt));
      mHdrWhiteMap.remove(Integer.valueOf(paramInt));
      if (!localHashMap.containsKey(paramString)) {
        localHashMap.put(paramString, paramTPHdrSupportVersionRange);
      }
      localHashMap.remove(paramString);
      localHashMap.put(paramString, paramTPHdrSupportVersionRange);
      mHdrWhiteMap.put(Integer.valueOf(paramInt), localHashMap);
    }
    else
    {
      localHashMap = new HashMap();
      localHashMap.put(paramString, paramTPHdrSupportVersionRange);
      mHdrWhiteMap.put(Integer.valueOf(paramInt), localHashMap);
    }
    return true;
  }
  
  /* Error */
  public static boolean checkCuvaSupportByVersion(String paramString1, String paramString2, String paramString3)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +241 -> 242
    //   4: aload_1
    //   5: ldc_w 310
    //   8: if_acmpeq +234 -> 242
    //   11: aload_1
    //   12: ldc_w 312
    //   15: invokevirtual 318	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   18: istore 4
    //   20: iload 4
    //   22: iconst_m1
    //   23: if_icmpeq +20 -> 43
    //   26: aload_1
    //   27: iload 4
    //   29: iconst_2
    //   30: isub
    //   31: iload 4
    //   33: invokevirtual 322	java/lang/String:substring	(II)Ljava/lang/String;
    //   36: invokestatic 325	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   39: istore_3
    //   40: goto +5 -> 45
    //   43: iconst_0
    //   44: istore_3
    //   45: aload_1
    //   46: ldc_w 312
    //   49: iload 4
    //   51: iconst_1
    //   52: iadd
    //   53: invokevirtual 328	java/lang/String:indexOf	(Ljava/lang/String;I)I
    //   56: istore 5
    //   58: iload 5
    //   60: iconst_m1
    //   61: if_icmpeq +21 -> 82
    //   64: aload_1
    //   65: iload 5
    //   67: iconst_1
    //   68: isub
    //   69: iload 5
    //   71: invokevirtual 322	java/lang/String:substring	(II)Ljava/lang/String;
    //   74: invokestatic 325	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   77: istore 4
    //   79: goto +6 -> 85
    //   82: iconst_0
    //   83: istore 4
    //   85: aload_1
    //   86: ldc_w 312
    //   89: iload 5
    //   91: iconst_1
    //   92: iadd
    //   93: invokevirtual 328	java/lang/String:indexOf	(Ljava/lang/String;I)I
    //   96: istore 6
    //   98: iload 6
    //   100: iconst_m1
    //   101: if_icmpeq +21 -> 122
    //   104: aload_1
    //   105: iload 6
    //   107: iconst_1
    //   108: isub
    //   109: iload 6
    //   111: invokevirtual 322	java/lang/String:substring	(II)Ljava/lang/String;
    //   114: invokestatic 325	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   117: istore 5
    //   119: goto +6 -> 125
    //   122: iconst_0
    //   123: istore 5
    //   125: aload_1
    //   126: iload 6
    //   128: iconst_1
    //   129: iadd
    //   130: iload 6
    //   132: iconst_4
    //   133: iadd
    //   134: invokevirtual 322	java/lang/String:substring	(II)Ljava/lang/String;
    //   137: invokestatic 325	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   140: istore 6
    //   142: goto +74 -> 216
    //   145: astore 7
    //   147: goto +26 -> 173
    //   150: astore 7
    //   152: iconst_0
    //   153: istore 5
    //   155: goto +18 -> 173
    //   158: astore 7
    //   160: goto +7 -> 167
    //   163: astore 7
    //   165: iconst_0
    //   166: istore_3
    //   167: iconst_0
    //   168: istore 5
    //   170: iconst_0
    //   171: istore 4
    //   173: new 330	java/lang/StringBuilder
    //   176: dup
    //   177: invokespecial 331	java/lang/StringBuilder:<init>	()V
    //   180: astore 8
    //   182: aload 8
    //   184: ldc_w 333
    //   187: invokevirtual 337	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   190: pop
    //   191: aload 8
    //   193: aload 7
    //   195: invokevirtual 341	java/lang/NumberFormatException:getMessage	()Ljava/lang/String;
    //   198: invokevirtual 337	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   201: pop
    //   202: iconst_4
    //   203: ldc 32
    //   205: aload 8
    //   207: invokevirtual 344	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   210: invokestatic 167	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;Ljava/lang/String;)V
    //   213: iconst_0
    //   214: istore 6
    //   216: iload 6
    //   218: iload_3
    //   219: ldc_w 345
    //   222: imul
    //   223: iload 4
    //   225: sipush 10000
    //   228: imul
    //   229: iadd
    //   230: iload 5
    //   232: sipush 1000
    //   235: imul
    //   236: iadd
    //   237: iadd
    //   238: istore_3
    //   239: goto +5 -> 244
    //   242: iconst_0
    //   243: istore_3
    //   244: aload_2
    //   245: ifnull +86 -> 331
    //   248: aload_1
    //   249: ldc_w 310
    //   252: if_acmpeq +79 -> 331
    //   255: aload_2
    //   256: ldc_w 347
    //   259: invokevirtual 318	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   262: istore 4
    //   264: iload 4
    //   266: iconst_m1
    //   267: if_icmpeq +64 -> 331
    //   270: aload_2
    //   271: iload 4
    //   273: iconst_5
    //   274: iadd
    //   275: iload 4
    //   277: bipush 7
    //   279: iadd
    //   280: invokevirtual 322	java/lang/String:substring	(II)Ljava/lang/String;
    //   283: invokestatic 325	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   286: istore 4
    //   288: goto +46 -> 334
    //   291: astore_1
    //   292: new 330	java/lang/StringBuilder
    //   295: dup
    //   296: invokespecial 331	java/lang/StringBuilder:<init>	()V
    //   299: astore 7
    //   301: aload 7
    //   303: ldc_w 349
    //   306: invokevirtual 337	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   309: pop
    //   310: aload 7
    //   312: aload_1
    //   313: invokevirtual 341	java/lang/NumberFormatException:getMessage	()Ljava/lang/String;
    //   316: invokevirtual 337	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   319: pop
    //   320: iconst_4
    //   321: ldc 32
    //   323: aload 7
    //   325: invokevirtual 344	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   328: invokestatic 167	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;Ljava/lang/String;)V
    //   331: iconst_0
    //   332: istore 4
    //   334: aload_0
    //   335: iload_3
    //   336: iload 4
    //   338: invokestatic 353	com/tencent/thumbplayer/core/common/TPCodecUtils:isInCuvaHDRWhiteList	(Ljava/lang/String;II)Z
    //   341: ifeq +65 -> 406
    //   344: new 330	java/lang/StringBuilder
    //   347: dup
    //   348: invokespecial 331	java/lang/StringBuilder:<init>	()V
    //   351: astore_1
    //   352: aload_1
    //   353: ldc_w 355
    //   356: invokevirtual 337	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   359: pop
    //   360: aload_1
    //   361: aload_0
    //   362: invokevirtual 337	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   365: pop
    //   366: aload_1
    //   367: ldc_w 357
    //   370: invokevirtual 337	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   373: pop
    //   374: aload_1
    //   375: iload_3
    //   376: invokevirtual 360	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   379: pop
    //   380: aload_1
    //   381: ldc_w 362
    //   384: invokevirtual 337	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   387: pop
    //   388: aload_1
    //   389: aload_2
    //   390: invokevirtual 337	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   393: pop
    //   394: iconst_2
    //   395: ldc 32
    //   397: aload_1
    //   398: invokevirtual 344	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   401: invokestatic 167	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;Ljava/lang/String;)V
    //   404: iconst_1
    //   405: ireturn
    //   406: aload_0
    //   407: iload_3
    //   408: iload 4
    //   410: invokestatic 365	com/tencent/thumbplayer/core/common/TPCodecUtils:isInCuvaHDRBlackList	(Ljava/lang/String;II)Z
    //   413: ifeq +65 -> 478
    //   416: new 330	java/lang/StringBuilder
    //   419: dup
    //   420: invokespecial 331	java/lang/StringBuilder:<init>	()V
    //   423: astore_1
    //   424: aload_1
    //   425: ldc_w 367
    //   428: invokevirtual 337	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   431: pop
    //   432: aload_1
    //   433: aload_0
    //   434: invokevirtual 337	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   437: pop
    //   438: aload_1
    //   439: ldc_w 357
    //   442: invokevirtual 337	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   445: pop
    //   446: aload_1
    //   447: iload_3
    //   448: invokevirtual 360	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   451: pop
    //   452: aload_1
    //   453: ldc_w 362
    //   456: invokevirtual 337	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   459: pop
    //   460: aload_1
    //   461: aload_2
    //   462: invokevirtual 337	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   465: pop
    //   466: iconst_2
    //   467: ldc 32
    //   469: aload_1
    //   470: invokevirtual 344	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   473: invokestatic 167	com/tencent/thumbplayer/core/common/TPNativeLog:printLog	(ILjava/lang/String;Ljava/lang/String;)V
    //   476: iconst_0
    //   477: ireturn
    //   478: getstatic 109	com/tencent/thumbplayer/core/common/TPCodecUtils:mCuvaSupportVersionMap	Ljava/util/HashMap;
    //   481: aload_0
    //   482: invokevirtual 291	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   485: ifeq +60 -> 545
    //   488: getstatic 109	com/tencent/thumbplayer/core/common/TPCodecUtils:mCuvaSupportVersionMap	Ljava/util/HashMap;
    //   491: aload_0
    //   492: invokevirtual 295	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   495: checkcast 199	com/tencent/thumbplayer/core/common/TPCodecCapability$TPHdrSupportVersionRange
    //   498: astore_0
    //   499: iload_3
    //   500: aload_0
    //   501: getfield 370	com/tencent/thumbplayer/core/common/TPCodecCapability$TPHdrSupportVersionRange:upperboundSystemVersion	I
    //   504: if_icmpgt +41 -> 545
    //   507: iload_3
    //   508: aload_0
    //   509: getfield 373	com/tencent/thumbplayer/core/common/TPCodecCapability$TPHdrSupportVersionRange:lowerboundSystemVersion	I
    //   512: if_icmple +5 -> 517
    //   515: iconst_1
    //   516: ireturn
    //   517: iload_3
    //   518: aload_0
    //   519: getfield 373	com/tencent/thumbplayer/core/common/TPCodecCapability$TPHdrSupportVersionRange:lowerboundSystemVersion	I
    //   522: if_icmpne +23 -> 545
    //   525: iload 4
    //   527: aload_0
    //   528: getfield 376	com/tencent/thumbplayer/core/common/TPCodecCapability$TPHdrSupportVersionRange:upperboundPatchVersion	I
    //   531: if_icmpgt +14 -> 545
    //   534: iload 4
    //   536: aload_0
    //   537: getfield 379	com/tencent/thumbplayer/core/common/TPCodecCapability$TPHdrSupportVersionRange:lowerboundPatchVersion	I
    //   540: if_icmplt +5 -> 545
    //   543: iconst_1
    //   544: ireturn
    //   545: iconst_0
    //   546: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	547	0	paramString1	String
    //   0	547	1	paramString2	String
    //   0	547	2	paramString3	String
    //   39	484	3	i	int
    //   18	523	4	j	int
    //   56	180	5	k	int
    //   96	142	6	m	int
    //   145	1	7	localNumberFormatException1	java.lang.NumberFormatException
    //   150	1	7	localNumberFormatException2	java.lang.NumberFormatException
    //   158	1	7	localNumberFormatException3	java.lang.NumberFormatException
    //   163	31	7	localNumberFormatException4	java.lang.NumberFormatException
    //   299	25	7	localStringBuilder1	StringBuilder
    //   180	26	8	localStringBuilder2	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   125	142	145	java/lang/NumberFormatException
    //   85	98	150	java/lang/NumberFormatException
    //   104	119	150	java/lang/NumberFormatException
    //   45	58	158	java/lang/NumberFormatException
    //   64	79	158	java/lang/NumberFormatException
    //   11	20	163	java/lang/NumberFormatException
    //   26	40	163	java/lang/NumberFormatException
    //   255	264	291	java/lang/NumberFormatException
    //   270	288	291	java/lang/NumberFormatException
  }
  
  public static int convertDolbyVisionToOmxLevel(int paramInt)
  {
    int i = 1 << paramInt;
    if ((i >= 1) && (i <= 256))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("convertDolbyVisionToOmxLevel dolbyVisionLevel:");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" omxLevel:");
      localStringBuilder.append(i);
      TPNativeLog.printLog(2, "TPCodecUtils", localStringBuilder.toString());
      return i;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("convertDolbyVisionToOmxLevel Unsupported level");
    localStringBuilder.append(paramInt);
    TPNativeLog.printLog(2, "TPCodecUtils", localStringBuilder.toString());
    return paramInt;
  }
  
  public static int convertDolbyVisionToOmxProfile(int paramInt)
  {
    int i = 1 << paramInt;
    if ((paramInt >= 1) && (paramInt <= 512))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("convertDolbyVisionToOmxProfile dolbyVisionProfile:");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" omxProfile:");
      localStringBuilder.append(i);
      TPNativeLog.printLog(2, "TPCodecUtils", localStringBuilder.toString());
      return i;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("convertDolbyVisionToOmxProfile Unsupported profile");
    localStringBuilder.append(paramInt);
    TPNativeLog.printLog(2, "TPCodecUtils", localStringBuilder.toString());
    return paramInt;
  }
  
  public static boolean getAudioMediaCodecPassThroughCap(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 != 5004) {
      return false;
    }
    paramInt1 = 1;
    if (paramInt2 == 20) {
      paramInt1 = 7;
    } else if ((paramInt2 == 50) || (paramInt2 == 60)) {
      paramInt1 = 8;
    }
    return TPAudioPassThroughPluginDetector.isAudioPassThroughSupport(paramInt1, paramInt3);
  }
  
  public static int getAvs3SWDecodeLevel()
  {
    String str = TPSystemInfo.getCpuHarewareName();
    int i = TPSystemInfo.getCpuHWProducter(str);
    int j = TPSystemInfo.getCpuHWProductIndex(str);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[getAvs3SWDecodeLevel], mCpuHWProducter = ");
    localStringBuilder.append(i);
    localStringBuilder.append(", getMaxCpuFreq() = ");
    localStringBuilder.append(TPSystemInfo.getMaxCpuFreq());
    localStringBuilder.append(", numCores = ");
    localStringBuilder.append(TPSystemInfo.getNumCores());
    localStringBuilder.append(", mCpuHWProductIdx=");
    localStringBuilder.append(j);
    localStringBuilder.append(", hardware=");
    localStringBuilder.append(str);
    TPNativeLog.printLog(2, "TPCodecUtils", localStringBuilder.toString());
    int k = mAvs3DeviceLevel;
    if (-1 != k) {
      return k;
    }
    mAvs3DeviceLevel = 0;
    if (-1 == i) {
      mAvs3DeviceLevel = getDecodeLevelByCoresAndFreq();
    } else if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i == 3) {
            mAvs3DeviceLevel = getDecodeLevelByCoresAndFreq();
          }
        }
        else if (j >= mFhdAvs3HisiIndex) {
          mAvs3DeviceLevel = 26;
        } else {
          mAvs3DeviceLevel = getDecodeLevelByCoresAndFreq();
        }
      }
      else {
        mAvs3DeviceLevel = getDecodeLevelByCoresAndFreq();
      }
    }
    else if (j >= mFhdAvs3QualcommIndex) {
      mAvs3DeviceLevel = 26;
    } else if (j >= mShdAvs3QualcommIndex) {
      mAvs3DeviceLevel = 21;
    } else {
      mAvs3DeviceLevel = getDecodeLevelByCoresAndFreq();
    }
    return mAvs3DeviceLevel;
  }
  
  private static int getDecodeLevelByCoresAndFreq()
  {
    if (TPSystemInfo.getNumCores() >= 8) {
      if (TPSystemInfo.getMaxCpuFreq() / 1000L >= 1200L) {
        return 21;
      }
    }
    do
    {
      do
      {
        return 16;
        if (TPSystemInfo.getNumCores() < 6) {
          break;
        }
      } while (TPSystemInfo.getMaxCpuFreq() / 1000L < 1400L);
      return 21;
      if (TPSystemInfo.getNumCores() < 4) {
        break;
      }
    } while (TPSystemInfo.getMaxCpuFreq() / 1000L < 1600L);
    return 21;
    return 6;
  }
  
  public static void getDecoderMaxCapabilityMapAsync()
  {
    try
    {
      if (mIsInitDone)
      {
        TPNativeLog.printLog(2, "TPCodecUtils", "decoder capability already init,return directly!");
        return;
      }
      TPNativeLog.printLog(2, "TPCodecUtils", "decoder capability not init,acquire async with create thread!");
      Thread localThread = new Thread(new TPCodecUtils.1());
      localThread.setName("TP_codec_init_thread");
      localThread.start();
      return;
    }
    finally {}
  }
  
  public static String getDecoderName(String paramString, boolean paramBoolean)
  {
    TPMediaDecoderInfo[] arrayOfTPMediaDecoderInfo = TPMediaDecoderList.getTPMediaDecoderInfos(mLocalCache);
    int j = arrayOfTPMediaDecoderInfo.length;
    int i = 0;
    while (i < j)
    {
      TPMediaDecoderInfo localTPMediaDecoderInfo = arrayOfTPMediaDecoderInfo[i];
      if ((TextUtils.equals(paramString, localTPMediaDecoderInfo.getDecoderMimeType())) && (localTPMediaDecoderInfo.isSecureDecoder() == paramBoolean))
      {
        paramString = new StringBuilder();
        paramString.append("getDecoderName:");
        paramString.append(localTPMediaDecoderInfo.getDecoderName());
        TPNativeLog.printLog(2, "TPCodecUtils", paramString.toString());
        return localTPMediaDecoderInfo.getDecoderName();
      }
      i += 1;
    }
    return null;
  }
  
  public static String getDisplayVersion()
  {
    if (!Build.BRAND.equals("HUAWEI")) {
      return null;
    }
    try
    {
      Object localObject = Class.forName("android.os.SystemProperties");
      localObject = (String)((Class)localObject).getDeclaredMethod("get", new Class[] { String.class }).invoke(localObject, new Object[] { "ro.build.display.id" });
      return localObject;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("get huawei display version failed:");
      localStringBuilder.append(localException.getMessage());
      TPNativeLog.printLog(4, "TPCodecUtils", localStringBuilder.toString());
    }
    return null;
  }
  
  public static String getDolbyVisionDecoderName(String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      if (!TextUtils.equals("video/dolby-vision", paramString)) {
        return null;
      }
      int j = convertDolbyVisionToOmxProfile(paramInt1);
      TPMediaDecoderInfo[] arrayOfTPMediaDecoderInfo = TPMediaDecoderList.getTPMediaDecoderInfos(mLocalCache);
      int k = arrayOfTPMediaDecoderInfo.length;
      paramInt2 = 0;
      while (paramInt2 < k)
      {
        TPMediaDecoderInfo localTPMediaDecoderInfo = arrayOfTPMediaDecoderInfo[paramInt2];
        TPMediaDecoderInfo.DecoderProfileLevel[] arrayOfDecoderProfileLevel = localTPMediaDecoderInfo.getProfileLevels();
        if (TextUtils.equals(localTPMediaDecoderInfo.getDecoderMimeType(), paramString)) {
          for (;;)
          {
            int m = arrayOfDecoderProfileLevel.length;
            int i = 0;
            while (i < m)
            {
              TPMediaDecoderInfo.DecoderProfileLevel localDecoderProfileLevel = arrayOfDecoderProfileLevel[i];
              if (localDecoderProfileLevel.profile == j)
              {
                StringBuilder localStringBuilder = new StringBuilder();
                localStringBuilder.append("getDolbyVisionDecoderName  profile:");
                localStringBuilder.append(localDecoderProfileLevel.profile);
                localStringBuilder.append(" dvProfile:");
                localStringBuilder.append(paramInt1);
                localStringBuilder.append(" bSecure:");
                localStringBuilder.append(paramBoolean);
                localStringBuilder.append(" name:");
                localStringBuilder.append(localTPMediaDecoderInfo.getDecoderName());
                TPNativeLog.printLog(2, "TPCodecUtils", localStringBuilder.toString());
                if (localTPMediaDecoderInfo.isSecureDecoder() == paramBoolean) {
                  return localTPMediaDecoderInfo.getDecoderName();
                }
              }
              i += 1;
            }
          }
        }
        paramInt2 += 1;
      }
    }
    return null;
  }
  
  public static int getHevcSWDecodeLevel()
  {
    String str = TPSystemInfo.getCpuHarewareName();
    int i = TPSystemInfo.getCpuHWProducter(str);
    int j = TPSystemInfo.getCpuHWProductIndex(str);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[getHevcSWDecodeLevel], mCpuHWProducter = ");
    localStringBuilder.append(i);
    localStringBuilder.append(", getMaxCpuFreq() = ");
    localStringBuilder.append(TPSystemInfo.getMaxCpuFreq());
    localStringBuilder.append(", numCores = ");
    localStringBuilder.append(TPSystemInfo.getNumCores());
    localStringBuilder.append(", mCpuHWProductIdx=");
    localStringBuilder.append(j);
    localStringBuilder.append(", hardware=");
    localStringBuilder.append(str);
    TPNativeLog.printLog(2, "TPCodecUtils", localStringBuilder.toString());
    int k = mHevcDeviceLevel;
    if (-1 != k) {
      return k;
    }
    mHevcDeviceLevel = 0;
    if (-1 == i) {
      mHevcDeviceLevel = getDecodeLevelByCoresAndFreq();
    } else if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i == 3) {
            if (j >= mShdHevcSumsingIndex) {
              mHevcDeviceLevel = 21;
            } else if (j >= mHdHevcSumsingIndex) {
              mHevcDeviceLevel = 16;
            } else {
              mHevcDeviceLevel = getDecodeLevelByCoresAndFreq();
            }
          }
        }
        else if (j >= mShdHevcHisiIndex) {
          mHevcDeviceLevel = 21;
        } else if (j >= mHdHevcHisiIndex) {
          mHevcDeviceLevel = 16;
        } else {
          mHevcDeviceLevel = getDecodeLevelByCoresAndFreq();
        }
      }
      else if (j >= mShdHevcMtkIndex) {
        mHevcDeviceLevel = 21;
      } else if (j >= mHdHevcMtkIndex) {
        mHevcDeviceLevel = 16;
      } else {
        mHevcDeviceLevel = getDecodeLevelByCoresAndFreq();
      }
    }
    else if (j >= mShdHevcQualcommIndex) {
      mHevcDeviceLevel = 21;
    } else if (j >= mHdHevcQualcommIndex) {
      mHevcDeviceLevel = 16;
    } else {
      mHevcDeviceLevel = getDecodeLevelByCoresAndFreq();
    }
    return mHevcDeviceLevel;
  }
  
  public static int getMaxLumaSample(String paramString, int paramInt)
  {
    if (TextUtils.equals(paramString, "video/avc")) {
      return TPMediaCodecProfileLevel.getAVCMaxLumaSample(paramInt);
    }
    if (TextUtils.equals(paramString, "video/hevc")) {
      return TPMediaCodecProfileLevel.getHEVCMaxLumaSample(paramInt);
    }
    if (TextUtils.equals(paramString, "video/x-vnd.on2.vp9")) {
      return TPMediaCodecProfileLevel.getVP9MaxLumaSample(paramInt);
    }
    return 0;
  }
  
  public static int getMaxSupportedFrameRatesFor(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    for (;;)
    {
      try
      {
        if ((Build.VERSION.SDK_INT < 21) || (paramInt1 == 101) || (paramInt1 == -1)) {
          continue;
        }
        localObject2 = getSupportedHWMimeType(paramInt2);
        boolean bool = ((String)localObject2).isEmpty();
        if (bool) {
          return 30;
        }
        localInteger2 = Integer.valueOf(30);
        localInteger1 = localInteger2;
      }
      finally
      {
        Object localObject2;
        Integer localInteger2;
        Integer localInteger1;
        TPMediaDecoderInfo[] arrayOfTPMediaDecoderInfo;
        int i;
        continue;
        throw localObject1;
        continue;
        if (paramInt3 >= paramInt4) {
          continue;
        }
        if (paramInt3 > i) {
          continue;
        }
        if (paramInt4 <= paramInt2) {
          continue;
        }
        continue;
      }
      try
      {
        arrayOfTPMediaDecoderInfo = TPMediaDecoderList.getTPMediaDecoderInfos(mLocalCache);
        localInteger1 = localInteger2;
        paramInt2 = arrayOfTPMediaDecoderInfo.length;
        paramInt1 = 0;
        localInteger1 = localInteger2;
        if (paramInt1 < paramInt2)
        {
          TPMediaDecoderInfo localTPMediaDecoderInfo = arrayOfTPMediaDecoderInfo[paramInt1];
          localInteger1 = localInteger2;
          if (((String)localObject2).equals(localTPMediaDecoderInfo.getDecoderMimeType()))
          {
            localInteger1 = localInteger2;
            paramInt1 = localTPMediaDecoderInfo.getDecoderMaxWidth();
            localInteger1 = localInteger2;
            paramInt2 = localTPMediaDecoderInfo.getDecoderMaxHeight();
            localInteger1 = localInteger2;
            i = localTPMediaDecoderInfo.getDecoderLumaWidth();
            localInteger1 = localInteger2;
            int j = localTPMediaDecoderInfo.getDecoderLumaHeight();
            localInteger1 = localInteger2;
            int k = localTPMediaDecoderInfo.getDecoderMaxFrameRateForMaxLuma();
            localInteger1 = localInteger2;
            int m = localTPMediaDecoderInfo.getDecoderMaxFrameRate();
            if ((paramInt3 <= paramInt4) || ((paramInt3 <= paramInt1) && (paramInt4 <= j))) {
              continue;
            }
            localInteger1 = localInteger2;
            localObject2 = new StringBuilder();
            localInteger1 = localInteger2;
            ((StringBuilder)localObject2).append("width:");
            localInteger1 = localInteger2;
            ((StringBuilder)localObject2).append(paramInt3);
            localInteger1 = localInteger2;
            ((StringBuilder)localObject2).append(" height:");
            localInteger1 = localInteger2;
            ((StringBuilder)localObject2).append(paramInt4);
            localInteger1 = localInteger2;
            ((StringBuilder)localObject2).append(" do not support! maxWidth:");
            localInteger1 = localInteger2;
            ((StringBuilder)localObject2).append(paramInt1);
            localInteger1 = localInteger2;
            ((StringBuilder)localObject2).append(" maxHeight:");
            localInteger1 = localInteger2;
            ((StringBuilder)localObject2).append(paramInt2);
            localInteger1 = localInteger2;
            TPNativeLog.printLog(4, "TPCodecUtils", ((StringBuilder)localObject2).toString());
            return 0;
            long l1 = paramInt1 * j;
            long l2 = paramInt3 * paramInt4;
            localInteger1 = localInteger2;
            localInteger2 = Integer.valueOf(Math.min(m, Math.max(1, (int)(l1 * 1L / Math.max(l2 * 1L, 1L)) * k)));
            localInteger1 = localInteger2;
            localObject2 = new StringBuilder();
            localInteger1 = localInteger2;
            ((StringBuilder)localObject2).append("getSupportedFrameRatesFor max width:");
            localInteger1 = localInteger2;
            ((StringBuilder)localObject2).append(paramInt1);
            localInteger1 = localInteger2;
            ((StringBuilder)localObject2).append(" max height:");
            localInteger1 = localInteger2;
            ((StringBuilder)localObject2).append(j);
            localInteger1 = localInteger2;
            ((StringBuilder)localObject2).append(" max framerate for max resolution:");
            localInteger1 = localInteger2;
            ((StringBuilder)localObject2).append(k);
            localInteger1 = localInteger2;
            ((StringBuilder)localObject2).append(" current width:");
            localInteger1 = localInteger2;
            ((StringBuilder)localObject2).append(paramInt3);
            localInteger1 = localInteger2;
            ((StringBuilder)localObject2).append(" height:");
            localInteger1 = localInteger2;
            ((StringBuilder)localObject2).append(paramInt4);
            localInteger1 = localInteger2;
            ((StringBuilder)localObject2).append(" max support framerate:");
            localInteger1 = localInteger2;
            ((StringBuilder)localObject2).append(localInteger2);
            localInteger1 = localInteger2;
            TPNativeLog.printLog(2, "TPCodecUtils", ((StringBuilder)localObject2).toString());
            localInteger1 = localInteger2;
          }
          else
          {
            paramInt1 += 1;
            continue;
          }
        }
      }
      catch (Exception localException)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("getMaxSupportedFrameRatesFor failed:");
        ((StringBuilder)localObject2).append(localException.getMessage());
        TPNativeLog.printLog(4, "TPCodecUtils", ((StringBuilder)localObject2).toString());
        paramInt1 = localInteger1.intValue();
        return paramInt1;
      }
    }
    return 30;
  }
  
  public static HashMap<Integer, TPCodecCapability.TPVCodecMaxCapability> getMediaCodecMaxCapabilityMap()
  {
    try
    {
      TPNativeLog.printLog(2, "TPCodecUtils", "getMediaCodecMaxCapabilityMap func in");
      Object localObject1;
      if (!mMaxVCodecHwCapabilityMap.isEmpty())
      {
        TPNativeLog.printLog(2, "TPCodecUtils", "return memory stored map");
        localObject1 = mMaxVCodecHwCapabilityMap;
        return localObject1;
      }
      try
      {
        localObject1 = TPMediaDecoderList.getTPMediaDecoderInfos(mLocalCache);
        int j = localObject1.length;
        int i = 0;
        StringBuilder localStringBuilder1;
        while (i < j)
        {
          localStringBuilder1 = localObject1[i];
          String str = localStringBuilder1.getDecoderMimeType();
          mCodecCapList.add(str);
          Object localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("MimeType: ");
          ((StringBuilder)localObject3).append(str);
          ((StringBuilder)localObject3).append(" codecName: ");
          ((StringBuilder)localObject3).append(localStringBuilder1.getDecoderName());
          TPNativeLog.printLog(2, "TPCodecUtils", ((StringBuilder)localObject3).toString());
          if ((isSupportedHWCodec(str)) && (!localStringBuilder1.isSecureDecoder()))
          {
            localObject3 = localStringBuilder1.getMaxProfileLevel();
            TPCodecCapability.TPVCodecMaxCapability localTPVCodecMaxCapability = new TPCodecCapability.TPVCodecMaxCapability(getMaxLumaSample(str, ((TPMediaDecoderInfo.DecoderProfileLevel)localObject3).level), ((TPMediaDecoderInfo.DecoderProfileLevel)localObject3).profile, ((TPMediaDecoderInfo.DecoderProfileLevel)localObject3).level, localStringBuilder1.getDecoderMaxFrameRateForMaxLuma());
            StringBuilder localStringBuilder2 = new StringBuilder();
            localStringBuilder2.append(" codecName: ");
            localStringBuilder2.append(localStringBuilder1.getDecoderName());
            localStringBuilder2.append(" lumasample: ");
            localStringBuilder2.append(getMaxLumaSample(str, ((TPMediaDecoderInfo.DecoderProfileLevel)localObject3).level));
            localStringBuilder2.append(" framerate: ");
            localStringBuilder2.append(localStringBuilder1.getDecoderMaxFrameRateForMaxLuma());
            TPNativeLog.printLog(2, "TPCodecUtils", localStringBuilder2.toString());
            replace(Integer.valueOf(getSupportedCodecId(str)), localTPVCodecMaxCapability, mMaxVCodecHwCapabilityMap);
          }
          i += 1;
        }
        HashMap localHashMap;
        localObject2 = finally;
      }
      catch (Exception localException)
      {
        localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append("getTPMediaDecoderInfos failed:");
        localStringBuilder1.append(localException.getMessage());
        TPNativeLog.printLog(4, "TPCodecUtils", localStringBuilder1.toString());
        localHashMap = mMaxVCodecHwCapabilityMap;
        return localHashMap;
      }
      throw localObject2;
    }
    finally {}
    for (;;) {}
  }
  
  private static int getSoftMaxSamples(int paramInt)
  {
    int i = 407040;
    if (paramInt != 1)
    {
      if (paramInt != 6)
      {
        if (paramInt != 11)
        {
          if (paramInt != 16)
          {
            if (paramInt != 21)
            {
              if (paramInt != 26)
              {
                if (paramInt != 28)
                {
                  if (paramInt != 33) {
                    return 407040;
                  }
                  return 8847360;
                }
                return 8294400;
              }
              return 2073600;
            }
            return 921600;
          }
          return 480000;
        }
      }
      else {
        return 307200;
      }
    }
    else {
      i = 129600;
    }
    return i;
  }
  
  private static int getSupportedCodecId(String paramString)
  {
    if (TextUtils.equals(paramString, "video/avc")) {
      return 26;
    }
    if (TextUtils.equals(paramString, "video/hevc")) {
      return 172;
    }
    if (TextUtils.equals(paramString, "video/x-vnd.on2.vp9")) {
      return 166;
    }
    return -1;
  }
  
  private static String getSupportedHWMimeType(int paramInt)
  {
    if (paramInt != 26)
    {
      if (paramInt != 166)
      {
        if (paramInt != 172) {
          return "";
        }
        return "video/hevc";
      }
      return "video/x-vnd.on2.vp9";
    }
    return "video/avc";
  }
  
  public static String getSystemPatchVersion()
  {
    if (!Build.BRAND.equals("HUAWEI")) {
      return null;
    }
    try
    {
      Object localObject = Class.forName("android.os.SystemProperties");
      localObject = (String)((Class)localObject).getDeclaredMethod("get", new Class[] { String.class }).invoke(localObject, new Object[] { "hwouc.hwpatch.version" });
      return localObject;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("get huawei system patch version failed:");
      localStringBuilder.append(localException.getMessage());
      TPNativeLog.printLog(4, "TPCodecUtils", localStringBuilder.toString());
    }
    return null;
  }
  
  public static HashMap<Integer, TPCodecCapability.TPVCodecMaxCapability> getVCodecSWMaxCapabilityMap()
  {
    Object localObject1;
    int i;
    int j;
    int k;
    int m;
    label344:
    try
    {
      TPNativeLog.printLog(2, "TPCodecUtils", "getVCodecSWMaxCapabilityMap func in");
      if (mIsFFmpegCapGot)
      {
        localObject1 = mMaxVCodecSwCapabilityMap;
        return localObject1;
      }
    }
    finally {}
    try
    {
      i = getHevcSWDecodeLevel();
      j = getSoftMaxSamples(i);
      k = getAvs3SWDecodeLevel();
      m = getSoftMaxSamples(k);
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("getVCodecSWMaxCapabilityMaphevcDecodeLevel:");
      ((StringBuilder)localObject1).append(i);
      ((StringBuilder)localObject1).append(" avs3DecodeLevel:");
      ((StringBuilder)localObject1).append(k);
      TPNativeLog.printLog(2, ((StringBuilder)localObject1).toString());
      mAVCSWMaxCapability.maxLumaSamples = j;
      mAVCSWMaxCapability.maxProfile = 64;
      mAVCSWMaxCapability.maxLevel = 65536;
      mMaxVCodecSwCapabilityMap.put(Integer.valueOf(26), mAVCSWMaxCapability);
      mffmpegVCodecCapList.add("video/avc");
      mHEVCSWMaxCapability.maxLumaSamples = j;
      mHEVCSWMaxCapability.maxProfile = 2;
      mHEVCSWMaxCapability.maxLevel = 33554432;
      mMaxVCodecSwCapabilityMap.put(Integer.valueOf(172), mHEVCSWMaxCapability);
      mffmpegVCodecCapList.add("video/hevc");
      mVP9SWMaxCapability.maxLumaSamples = j;
      mVP9SWMaxCapability.maxProfile = 8;
      mVP9SWMaxCapability.maxLevel = 8192;
      mMaxVCodecSwCapabilityMap.put(Integer.valueOf(166), mVP9SWMaxCapability);
      mffmpegVCodecCapList.add("video/x-vnd.on2.vp9");
      mAVS3WMaxCapability.maxLumaSamples = m;
      mAVS3WMaxCapability.maxProfile = 0;
      mAVS3WMaxCapability.maxLevel = 0;
      mMaxVCodecSwCapabilityMap.put(Integer.valueOf(192), mAVS3WMaxCapability);
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("getVCodecSWMaxCapabilityMap success, maxHevcLumaSamples:");
      ((StringBuilder)localObject1).append(j);
      ((StringBuilder)localObject1).append(" maxAvs3LumaSamples:");
      ((StringBuilder)localObject1).append(m);
      TPNativeLog.printLog(2, ((StringBuilder)localObject1).toString());
      mIsFFmpegCapGot = true;
      localObject1 = mMaxVCodecSwCapabilityMap;
      return localObject1;
    }
    catch (Exception localException)
    {
      break label344;
    }
    TPNativeLog.printLog(4, "TPCodecUtils", "getVCodecSWMaxCapabilityMap exception");
    return null;
  }
  
  public static void init(Context paramContext, boolean paramBoolean)
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("is local cache enabled:");
      localStringBuilder.append(paramBoolean);
      TPNativeLog.printLog(2, "TPCodecUtils", localStringBuilder.toString());
      mContext = paramContext.getApplicationContext();
      if (paramBoolean) {
        mLocalCache = LocalCache.get(mContext);
      }
      getDecoderMaxCapabilityMapAsync();
      return;
    }
    finally {}
  }
  
  public static boolean isBlackListModel()
  {
    return mBlackListModel.contains(Build.MODEL);
  }
  
  public static boolean isBlackListType(String paramString)
  {
    return (Arrays.asList(new String[] { "PRO 7 Plus", "PRO 7-H", "PRO+7+Plus" }).contains(Build.MODEL)) && (TextUtils.equals(paramString, "video/hevc")) && (Build.VERSION.SDK_INT >= 14);
  }
  
  private static boolean isHDR10Support(int paramInt)
  {
    try
    {
      Object localObject1 = TPMediaDecoderList.getTPMediaDecoderInfos(mLocalCache);
      int k = localObject1.length;
      int i = 0;
      while (i < k)
      {
        TPMediaDecoderInfo.DecoderProfileLevel[] arrayOfDecoderProfileLevel = localObject1[i];
        if (TextUtils.equals(arrayOfDecoderProfileLevel.getDecoderMimeType(), "video/hevc"))
        {
          arrayOfDecoderProfileLevel = arrayOfDecoderProfileLevel.getProfileLevels();
          int m = arrayOfDecoderProfileLevel.length;
          int j = 0;
          while (j < m)
          {
            if (arrayOfDecoderProfileLevel[j].profile == paramInt)
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("support hdr10 ");
              ((StringBuilder)localObject1).append(paramInt);
              TPNativeLog.printLog(2, "TPCodecUtils", ((StringBuilder)localObject1).toString());
              return true;
            }
            j += 1;
          }
        }
        i += 1;
      }
      return false;
    }
    finally {}
    for (;;)
    {
      throw localObject2;
    }
  }
  
  private static boolean isHDRDVSupport(int paramInt1, int paramInt2)
  {
    if ((paramInt1 == 0) && (paramInt2 == 0)) {}
    try
    {
      boolean bool = mCodecCapList.contains("video/dolby-vision");
      return bool;
    }
    finally
    {
      TPMediaDecoderInfo[] arrayOfTPMediaDecoderInfo;
      int k;
      int i;
      break label160;
    }
    arrayOfTPMediaDecoderInfo = TPMediaDecoderList.getTPMediaDecoderInfos(mLocalCache);
    k = arrayOfTPMediaDecoderInfo.length;
    i = 0;
    while (i < k)
    {
      Object localObject2 = arrayOfTPMediaDecoderInfo[i];
      if (TextUtils.equals(((TPMediaDecoderInfo)localObject2).getDecoderMimeType(), "video/dolby-vision"))
      {
        localObject2 = ((TPMediaDecoderInfo)localObject2).getProfileLevels();
        int m = localObject2.length;
        int j = 0;
        while (j < m)
        {
          Object localObject3 = localObject2[j];
          if ((localObject3.profile == paramInt1) && (localObject3.level == paramInt2))
          {
            TPNativeLog.printLog(2, "TPCodecUtils", "support dolbyvision");
            return true;
          }
          j += 1;
        }
      }
      i += 1;
    }
    return false;
    label160:
    for (;;)
    {
      throw localObject1;
    }
  }
  
  public static boolean isHDRsupport(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 == 2) {
      return isHDRDVSupport(paramInt2, paramInt3);
    }
    if (paramInt1 == 0) {
      return isHDR10Support(4096);
    }
    if (paramInt1 == 1) {
      return isHDR10Support(8192);
    }
    if (paramInt1 == 4)
    {
      if (!Build.BRAND.equals("HUAWEI")) {
        return false;
      }
      String str1 = getDisplayVersion();
      String str2 = getSystemPatchVersion();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isHDRsupport(cuva):display version:");
      localStringBuilder.append(str1);
      TPNativeLog.printLog(2, "TPCodecUtils", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("isHDRsupport(cuva):patch version:");
      localStringBuilder.append(str2);
      TPNativeLog.printLog(2, "TPCodecUtils", localStringBuilder.toString());
      return checkCuvaSupportByVersion(Build.MODEL, str1, str2);
    }
    return false;
  }
  
  public static boolean isHwDDPlusSupported()
  {
    try
    {
      boolean bool = isBlackListModel();
      if (bool) {
        return false;
      }
      bool = mCodecCapList.contains("audio/eac3");
      return bool;
    }
    finally {}
  }
  
  public static boolean isHwDolbyDSSupported()
  {
    try
    {
      boolean bool = mCodecCapList.contains("audio/ac3");
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static boolean isInCuvaHDRBlackList(String paramString, int paramInt1, int paramInt2)
  {
    HashMap localHashMap = mHdrBlackMap;
    Integer localInteger = Integer.valueOf(4);
    if (localHashMap.containsKey(localInteger))
    {
      localHashMap = (HashMap)mHdrBlackMap.get(localInteger);
      if (localHashMap.containsKey(paramString))
      {
        paramString = (TPCodecCapability.TPHdrSupportVersionRange)localHashMap.get(paramString);
        if ((paramInt1 <= paramString.upperboundSystemVersion) && (paramInt1 >= paramString.lowerboundSystemVersion) && (paramInt2 <= paramString.upperboundPatchVersion) && (paramInt2 >= paramString.lowerboundPatchVersion)) {
          return true;
        }
      }
    }
    return false;
  }
  
  public static boolean isInCuvaHDRWhiteList(String paramString, int paramInt1, int paramInt2)
  {
    HashMap localHashMap = mHdrWhiteMap;
    Integer localInteger = Integer.valueOf(4);
    if (localHashMap.containsKey(localInteger))
    {
      localHashMap = (HashMap)mHdrWhiteMap.get(localInteger);
      if (localHashMap.containsKey(paramString))
      {
        paramString = (TPCodecCapability.TPHdrSupportVersionRange)localHashMap.get(paramString);
        if ((paramInt1 <= paramString.upperboundSystemVersion) && (paramInt1 >= paramString.lowerboundSystemVersion) && (paramInt2 <= paramString.upperboundPatchVersion) && (paramInt2 >= paramString.lowerboundPatchVersion)) {
          return true;
        }
      }
    }
    return false;
  }
  
  public static boolean isInDRMLevel1Blacklist(int paramInt)
  {
    if (mDrmL1BlackList.containsKey(Integer.valueOf(paramInt))) {
      return ((ArrayList)mDrmL1BlackList.get(Integer.valueOf(paramInt))).contains(Build.MODEL);
    }
    return false;
  }
  
  public static boolean isInMediaCodecWhiteList(String paramString, int paramInt1, int paramInt2)
  {
    Object localObject = Build.MODEL;
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      HashMap localHashMap = mCodecCap;
      if ((localHashMap != null) && (localHashMap.containsKey(localObject)))
      {
        localObject = (Integer)mCodecCap.get(localObject);
        if (TextUtils.equals(paramString, "video/avc"))
        {
          if ((((Integer)localObject).intValue() & 0x1) == 0) {}
        }
        else {
          while (TextUtils.equals(paramString, "video/hevc") ? (((Integer)localObject).intValue() & 0x2) != 0 : TextUtils.equals(paramString, "audio/mp4a-latm") ? (((Integer)localObject).intValue() & 0x4) != 0 : ((TextUtils.equals(paramString, "audio/ac3")) || (TextUtils.equals(paramString, "audio/eac3"))) && ((((Integer)localObject).intValue() & 0x8) != 0)) {
            return true;
          }
        }
      }
    }
    return false;
  }
  
  private static boolean isSupportedHWCodec(String paramString)
  {
    return mSupportedHWCodec.contains(paramString);
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