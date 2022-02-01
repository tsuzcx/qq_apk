package com.tencent.qqlive.tvkplayer.playerwrapper.player.tools;

import android.content.Context;
import android.media.MediaCodecInfo;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaCodecInfo.CodecProfileLevel;
import android.media.MediaCodecList;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.qqlive.tvkplayer.TVideoMgr;
import com.tencent.qqlive.tvkplayer.thirdparties.LocalCache;
import com.tencent.qqlive.tvkplayer.tools.config.TVKConfigField;
import com.tencent.qqlive.tvkplayer.tools.config.TVKMediaPlayerConfig.PlayerConfig;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKLogUtil;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKUtils;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKVcSystemInfo;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;

public class TVKCodecUtils
{
  public static final int CAP_AUDIO_AAC = 4;
  public static final int CAP_AUDIO_DDP = 8;
  public static final int CAP_COMMON_NULL = 0;
  public static final int CAP_VIDEO_AVC = 1;
  public static final int CAP_VIDEO_HEVC = 2;
  private static final int HDR10_CODEC_CAP_NOT_SUPPORT = 0;
  private static final int HDR10_CODEC_CAP_SUPPORT = 1;
  private static final int HDR10_CODEC_CAP_UNKNOWN = -1;
  public static final String TAG = "MediaPlayerMgr[TVKCodecUtils.java]";
  private static HashMap<String, Integer> mCodecCap;
  private static int mHDR10CodecSupport;
  private static String mHDRVideoLevelKey;
  protected static ArrayList<String> mHWCodecCapList = new ArrayList();
  protected static int mHWVideoAVCLevel;
  protected static int mHWVideoAVCMaxCap;
  protected static int mHWVideoAVCProfile;
  protected static int mHWVideoHEVCLevel;
  protected static int mHWVideoHEVCMaxCap;
  protected static int mHWVideoHEVCProfile;
  private static String mHWVideoLevelKey;
  private static String mHWconfigKey;
  private static int mIsInBlackListForHardwareDec;
  private static boolean mIsInitDone;
  private static int mPlayerHevcLevel;
  protected static ArrayList<String> mSoftCodecCapList = new ArrayList();
  private static String mSoftconfigKey;
  private static int sDolbyLevel;
  private static boolean sIsDDPInit;
  private static boolean sIsDDPSup;
  private static boolean sIsDDSInit;
  private static boolean sIsDDSSup;
  
  static
  {
    mHWVideoAVCMaxCap = 0;
    mHWVideoAVCLevel = 0;
    mHWVideoAVCProfile = 0;
    mHWVideoHEVCMaxCap = 0;
    mHWVideoHEVCLevel = 0;
    mHWVideoHEVCProfile = 0;
    mCodecCap = null;
    mIsInitDone = false;
    mPlayerHevcLevel = -1;
    mIsInBlackListForHardwareDec = -1;
    sIsDDPInit = false;
    sIsDDPSup = false;
    sIsDDSInit = false;
    sIsDDSSup = false;
    sDolbyLevel = -1;
    mHDR10CodecSupport = -1;
    mHWconfigKey = "Config_HW_Capability_V4";
    mSoftconfigKey = "Config_Soft_Capability_V4";
    mHWVideoLevelKey = "Config_HW_Level_V4";
    mHDRVideoLevelKey = "Config_HDR_Codec_Level";
    mCodecCap = new HashMap();
    HashMap localHashMap = mCodecCap;
    Integer localInteger = Integer.valueOf(7);
    localHashMap.put("NX511J", localInteger);
    mCodecCap.put("Hi3798MV100", localInteger);
    mCodecCap.put("长虹智能电视", localInteger);
    mCodecCap.put("Android TV on Tcl 901", localInteger);
    mCodecCap.put("xt880b", localInteger);
    acquireCodecParamsSync();
  }
  
  public static void acquireCodecParamsAsync()
  {
    try
    {
      if (mIsInitDone)
      {
        TVKLogUtil.i("MediaPlayerMgr[TVKCodecUtils.java]", "codec params already init , return directly !");
        return;
      }
      TVKLogUtil.i("MediaPlayerMgr[TVKCodecUtils.java]", "codec params not init , acquire async with create thread !");
      Thread localThread = new Thread(new TVKCodecUtils.1());
      localThread.setName("TVK_codec_init_thread");
      localThread.start();
      return;
    }
    finally {}
  }
  
  /* Error */
  public static void acquireCodecParamsSync()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 77	com/tencent/qqlive/tvkplayer/playerwrapper/player/tools/TVKCodecUtils:mIsInitDone	Z
    //   6: ifeq +14 -> 20
    //   9: ldc 23
    //   11: ldc 140
    //   13: invokestatic 146	com/tencent/qqlive/tvkplayer/tools/utils/TVKLogUtil:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   16: ldc 2
    //   18: monitorexit
    //   19: return
    //   20: getstatic 181	com/tencent/qqlive/tvkplayer/tools/config/TVKMediaPlayerConfig$PlayerConfig:is_use_cache_hwlevel	Lcom/tencent/qqlive/tvkplayer/tools/config/TVKConfigField;
    //   23: invokevirtual 187	com/tencent/qqlive/tvkplayer/tools/config/TVKConfigField:getValue	()Ljava/lang/Object;
    //   26: checkcast 189	java/lang/Boolean
    //   29: invokevirtual 193	java/lang/Boolean:booleanValue	()Z
    //   32: ifeq +120 -> 152
    //   35: ldc 23
    //   37: ldc 195
    //   39: invokestatic 146	com/tencent/qqlive/tvkplayer/tools/utils/TVKLogUtil:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   42: getstatic 59	com/tencent/qqlive/tvkplayer/playerwrapper/player/tools/TVKCodecUtils:mHWCodecCapList	Ljava/util/ArrayList;
    //   45: ifnull +12 -> 57
    //   48: getstatic 59	com/tencent/qqlive/tvkplayer/playerwrapper/player/tools/TVKCodecUtils:mHWCodecCapList	Ljava/util/ArrayList;
    //   51: invokevirtual 199	java/util/ArrayList:size	()I
    //   54: ifne +21 -> 75
    //   57: getstatic 97	com/tencent/qqlive/tvkplayer/playerwrapper/player/tools/TVKCodecUtils:mHWconfigKey	Ljava/lang/String;
    //   60: invokestatic 203	com/tencent/qqlive/tvkplayer/playerwrapper/player/tools/TVKCodecUtils:getConfig_V2	(Ljava/lang/String;)Ljava/util/ArrayList;
    //   63: astore 11
    //   65: aload 11
    //   67: ifnull +8 -> 75
    //   70: aload 11
    //   72: putstatic 59	com/tencent/qqlive/tvkplayer/playerwrapper/player/tools/TVKCodecUtils:mHWCodecCapList	Ljava/util/ArrayList;
    //   75: getstatic 61	com/tencent/qqlive/tvkplayer/playerwrapper/player/tools/TVKCodecUtils:mSoftCodecCapList	Ljava/util/ArrayList;
    //   78: ifnull +12 -> 90
    //   81: getstatic 61	com/tencent/qqlive/tvkplayer/playerwrapper/player/tools/TVKCodecUtils:mSoftCodecCapList	Ljava/util/ArrayList;
    //   84: invokevirtual 199	java/util/ArrayList:size	()I
    //   87: ifne +21 -> 108
    //   90: getstatic 101	com/tencent/qqlive/tvkplayer/playerwrapper/player/tools/TVKCodecUtils:mSoftconfigKey	Ljava/lang/String;
    //   93: invokestatic 203	com/tencent/qqlive/tvkplayer/playerwrapper/player/tools/TVKCodecUtils:getConfig_V2	(Ljava/lang/String;)Ljava/util/ArrayList;
    //   96: astore 11
    //   98: aload 11
    //   100: ifnull +8 -> 108
    //   103: aload 11
    //   105: putstatic 61	com/tencent/qqlive/tvkplayer/playerwrapper/player/tools/TVKCodecUtils:mSoftCodecCapList	Ljava/util/ArrayList;
    //   108: getstatic 59	com/tencent/qqlive/tvkplayer/playerwrapper/player/tools/TVKCodecUtils:mHWCodecCapList	Ljava/util/ArrayList;
    //   111: ifnull +41 -> 152
    //   114: getstatic 61	com/tencent/qqlive/tvkplayer/playerwrapper/player/tools/TVKCodecUtils:mSoftCodecCapList	Ljava/util/ArrayList;
    //   117: ifnull +35 -> 152
    //   120: getstatic 59	com/tencent/qqlive/tvkplayer/playerwrapper/player/tools/TVKCodecUtils:mHWCodecCapList	Ljava/util/ArrayList;
    //   123: invokevirtual 199	java/util/ArrayList:size	()I
    //   126: ifle +26 -> 152
    //   129: getstatic 61	com/tencent/qqlive/tvkplayer/playerwrapper/player/tools/TVKCodecUtils:mSoftCodecCapList	Ljava/util/ArrayList;
    //   132: invokevirtual 199	java/util/ArrayList:size	()I
    //   135: ifle +17 -> 152
    //   138: invokestatic 206	com/tencent/qqlive/tvkplayer/playerwrapper/player/tools/TVKCodecUtils:dealHwLevel	()Z
    //   141: ifeq +11 -> 152
    //   144: iconst_1
    //   145: putstatic 77	com/tencent/qqlive/tvkplayer/playerwrapper/player/tools/TVKCodecUtils:mIsInitDone	Z
    //   148: ldc 2
    //   150: monitorexit
    //   151: return
    //   152: ldc 23
    //   154: ldc 208
    //   156: invokestatic 146	com/tencent/qqlive/tvkplayer/tools/utils/TVKLogUtil:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   159: ldc 210
    //   161: invokestatic 216	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   164: astore 11
    //   166: aload 11
    //   168: ldc 218
    //   170: iconst_0
    //   171: anewarray 212	java/lang/Class
    //   174: invokevirtual 222	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   177: astore 12
    //   179: aload 11
    //   181: ldc 224
    //   183: iconst_1
    //   184: anewarray 212	java/lang/Class
    //   187: dup
    //   188: iconst_0
    //   189: getstatic 228	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   192: aastore
    //   193: invokevirtual 222	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   196: astore 13
    //   198: ldc 230
    //   200: invokestatic 216	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   203: astore 14
    //   205: aload 14
    //   207: ldc 232
    //   209: iconst_0
    //   210: anewarray 212	java/lang/Class
    //   213: invokevirtual 222	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   216: astore 11
    //   218: aload 14
    //   220: ldc 234
    //   222: iconst_0
    //   223: anewarray 212	java/lang/Class
    //   226: invokevirtual 222	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   229: astore 16
    //   231: aload 14
    //   233: ldc 236
    //   235: iconst_0
    //   236: anewarray 212	java/lang/Class
    //   239: invokevirtual 222	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   242: astore 17
    //   244: aload 14
    //   246: ldc 238
    //   248: iconst_1
    //   249: anewarray 212	java/lang/Class
    //   252: dup
    //   253: iconst_0
    //   254: ldc 240
    //   256: aastore
    //   257: invokevirtual 222	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   260: astore 18
    //   262: ldc 242
    //   264: invokestatic 216	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   267: ldc 244
    //   269: invokevirtual 248	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   272: astore 19
    //   274: ldc 250
    //   276: invokestatic 216	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   279: astore 14
    //   281: aload 14
    //   283: ldc 252
    //   285: invokevirtual 248	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   288: astore 20
    //   290: aload 14
    //   292: ldc 254
    //   294: invokevirtual 248	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   297: astore 21
    //   299: aload 12
    //   301: aconst_null
    //   302: iconst_0
    //   303: anewarray 4	java/lang/Object
    //   306: invokevirtual 260	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   309: checkcast 114	java/lang/Integer
    //   312: invokevirtual 263	java/lang/Integer:intValue	()I
    //   315: istore_1
    //   316: iconst_0
    //   317: istore 5
    //   319: iconst_0
    //   320: istore_0
    //   321: iconst_0
    //   322: istore_2
    //   323: iload 5
    //   325: iload_1
    //   326: if_icmpge +660 -> 986
    //   329: aload 13
    //   331: aconst_null
    //   332: iconst_1
    //   333: anewarray 4	java/lang/Object
    //   336: dup
    //   337: iconst_0
    //   338: iload 5
    //   340: invokestatic 118	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   343: aastore
    //   344: invokevirtual 260	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   347: astore 22
    //   349: aload 17
    //   351: aload 22
    //   353: iconst_0
    //   354: anewarray 4	java/lang/Object
    //   357: invokevirtual 260	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   360: checkcast 189	java/lang/Boolean
    //   363: invokevirtual 193	java/lang/Boolean:booleanValue	()Z
    //   366: ifeq +10 -> 376
    //   369: iload_0
    //   370: istore_3
    //   371: iload_1
    //   372: istore_0
    //   373: goto +923 -> 1296
    //   376: aload 16
    //   378: aload 22
    //   380: iconst_0
    //   381: anewarray 4	java/lang/Object
    //   384: invokevirtual 260	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   387: checkcast 240	java/lang/String
    //   390: invokevirtual 267	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   393: astore 14
    //   395: aload 11
    //   397: aload 22
    //   399: iconst_0
    //   400: anewarray 4	java/lang/Object
    //   403: invokevirtual 260	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   406: checkcast 269	[Ljava/lang/String;
    //   409: checkcast 269	[Ljava/lang/String;
    //   412: astore 15
    //   414: aload 15
    //   416: arraylength
    //   417: istore 4
    //   419: iconst_0
    //   420: istore 6
    //   422: iload_2
    //   423: istore_3
    //   424: iload_0
    //   425: istore_2
    //   426: iload 4
    //   428: istore_0
    //   429: iload 6
    //   431: iload_0
    //   432: if_icmpge +856 -> 1288
    //   435: aload 15
    //   437: iload 6
    //   439: aaload
    //   440: astore 12
    //   442: aload 14
    //   444: ldc_w 271
    //   447: invokevirtual 275	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   450: ifne +511 -> 961
    //   453: aload 14
    //   455: ldc_w 277
    //   458: invokevirtual 275	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   461: ifne +500 -> 961
    //   464: aload 14
    //   466: ldc_w 279
    //   469: invokevirtual 275	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   472: ifne +489 -> 961
    //   475: aload 14
    //   477: ldc_w 281
    //   480: invokevirtual 275	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   483: ifeq +6 -> 489
    //   486: goto +475 -> 961
    //   489: getstatic 59	com/tencent/qqlive/tvkplayer/playerwrapper/player/tools/TVKCodecUtils:mHWCodecCapList	Ljava/util/ArrayList;
    //   492: aload 12
    //   494: invokevirtual 285	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   497: pop
    //   498: getstatic 59	com/tencent/qqlive/tvkplayer/playerwrapper/player/tools/TVKCodecUtils:mHWCodecCapList	Ljava/util/ArrayList;
    //   501: ldc_w 287
    //   504: invokevirtual 289	java/util/ArrayList:contains	(Ljava/lang/Object;)Z
    //   507: istore 10
    //   509: iload 10
    //   511: ifeq +743 -> 1254
    //   514: iload_2
    //   515: ifne +739 -> 1254
    //   518: aload 19
    //   520: aload 18
    //   522: aload 22
    //   524: iconst_1
    //   525: anewarray 4	java/lang/Object
    //   528: dup
    //   529: iconst_0
    //   530: ldc_w 287
    //   533: aastore
    //   534: invokevirtual 260	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   537: invokevirtual 295	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   540: checkcast 297	[Ljava/lang/Object;
    //   543: checkcast 297	[Ljava/lang/Object;
    //   546: astore 12
    //   548: aload 12
    //   550: arraylength
    //   551: istore_2
    //   552: iconst_0
    //   553: istore 4
    //   555: iload 4
    //   557: iload_2
    //   558: if_icmpge +75 -> 633
    //   561: aload 12
    //   563: iload 4
    //   565: aaload
    //   566: astore 23
    //   568: aload 20
    //   570: aload 23
    //   572: invokevirtual 295	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   575: checkcast 114	java/lang/Integer
    //   578: invokevirtual 263	java/lang/Integer:intValue	()I
    //   581: istore 7
    //   583: aload 21
    //   585: aload 23
    //   587: invokevirtual 295	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   590: checkcast 114	java/lang/Integer
    //   593: invokevirtual 263	java/lang/Integer:intValue	()I
    //   596: istore 8
    //   598: iload 8
    //   600: iload 7
    //   602: invokestatic 301	com/tencent/qqlive/tvkplayer/playerwrapper/player/tools/TVKCodecUtils:maxLumaSamplesForAVCProfileLevel	(II)I
    //   605: istore 9
    //   607: iload 9
    //   609: getstatic 63	com/tencent/qqlive/tvkplayer/playerwrapper/player/tools/TVKCodecUtils:mHWVideoAVCMaxCap	I
    //   612: if_icmplt +628 -> 1240
    //   615: iload 9
    //   617: putstatic 63	com/tencent/qqlive/tvkplayer/playerwrapper/player/tools/TVKCodecUtils:mHWVideoAVCMaxCap	I
    //   620: iload 8
    //   622: putstatic 67	com/tencent/qqlive/tvkplayer/playerwrapper/player/tools/TVKCodecUtils:mHWVideoAVCProfile	I
    //   625: iload 7
    //   627: putstatic 65	com/tencent/qqlive/tvkplayer/playerwrapper/player/tools/TVKCodecUtils:mHWVideoAVCLevel	I
    //   630: goto +610 -> 1240
    //   633: new 303	java/lang/StringBuilder
    //   636: dup
    //   637: invokespecial 304	java/lang/StringBuilder:<init>	()V
    //   640: astore 12
    //   642: aload 12
    //   644: ldc_w 306
    //   647: invokevirtual 310	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   650: pop
    //   651: aload 12
    //   653: getstatic 67	com/tencent/qqlive/tvkplayer/playerwrapper/player/tools/TVKCodecUtils:mHWVideoAVCProfile	I
    //   656: invokevirtual 313	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   659: pop
    //   660: aload 12
    //   662: ldc_w 315
    //   665: invokevirtual 310	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   668: pop
    //   669: aload 12
    //   671: getstatic 65	com/tencent/qqlive/tvkplayer/playerwrapper/player/tools/TVKCodecUtils:mHWVideoAVCLevel	I
    //   674: invokevirtual 313	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   677: pop
    //   678: aload 12
    //   680: ldc_w 317
    //   683: invokevirtual 310	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   686: pop
    //   687: aload 12
    //   689: getstatic 63	com/tencent/qqlive/tvkplayer/playerwrapper/player/tools/TVKCodecUtils:mHWVideoAVCMaxCap	I
    //   692: invokevirtual 313	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   695: pop
    //   696: ldc 23
    //   698: aload 12
    //   700: invokevirtual 320	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   703: invokestatic 146	com/tencent/qqlive/tvkplayer/tools/utils/TVKLogUtil:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   706: iconst_1
    //   707: istore_2
    //   708: goto +3 -> 711
    //   711: getstatic 59	com/tencent/qqlive/tvkplayer/playerwrapper/player/tools/TVKCodecUtils:mHWCodecCapList	Ljava/util/ArrayList;
    //   714: ldc_w 322
    //   717: invokevirtual 289	java/util/ArrayList:contains	(Ljava/lang/Object;)Z
    //   720: istore 10
    //   722: iload_2
    //   723: istore 7
    //   725: iload_3
    //   726: istore 8
    //   728: iload_0
    //   729: istore 4
    //   731: aload 11
    //   733: astore 12
    //   735: iload 10
    //   737: ifeq +529 -> 1266
    //   740: iload_2
    //   741: istore 7
    //   743: iload_3
    //   744: istore 8
    //   746: iload_0
    //   747: istore 4
    //   749: aload 11
    //   751: astore 12
    //   753: iload_3
    //   754: ifne +512 -> 1266
    //   757: aload 19
    //   759: aload 18
    //   761: aload 22
    //   763: iconst_1
    //   764: anewarray 4	java/lang/Object
    //   767: dup
    //   768: iconst_0
    //   769: ldc_w 322
    //   772: aastore
    //   773: invokevirtual 260	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   776: invokevirtual 295	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   779: checkcast 297	[Ljava/lang/Object;
    //   782: checkcast 297	[Ljava/lang/Object;
    //   785: astore 12
    //   787: aload 12
    //   789: arraylength
    //   790: istore_3
    //   791: iconst_0
    //   792: istore 4
    //   794: iload 4
    //   796: iload_3
    //   797: if_icmpge +75 -> 872
    //   800: aload 12
    //   802: iload 4
    //   804: aaload
    //   805: astore 23
    //   807: aload 20
    //   809: aload 23
    //   811: invokevirtual 295	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   814: checkcast 114	java/lang/Integer
    //   817: invokevirtual 263	java/lang/Integer:intValue	()I
    //   820: istore 7
    //   822: aload 21
    //   824: aload 23
    //   826: invokevirtual 295	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   829: checkcast 114	java/lang/Integer
    //   832: invokevirtual 263	java/lang/Integer:intValue	()I
    //   835: istore 8
    //   837: iload 8
    //   839: iload 7
    //   841: invokestatic 325	com/tencent/qqlive/tvkplayer/playerwrapper/player/tools/TVKCodecUtils:maxLumaSamplesForHEVCProfileLevel	(II)I
    //   844: istore 9
    //   846: iload 9
    //   848: getstatic 69	com/tencent/qqlive/tvkplayer/playerwrapper/player/tools/TVKCodecUtils:mHWVideoHEVCMaxCap	I
    //   851: if_icmplt +406 -> 1257
    //   854: iload 9
    //   856: putstatic 69	com/tencent/qqlive/tvkplayer/playerwrapper/player/tools/TVKCodecUtils:mHWVideoHEVCMaxCap	I
    //   859: iload 8
    //   861: putstatic 73	com/tencent/qqlive/tvkplayer/playerwrapper/player/tools/TVKCodecUtils:mHWVideoHEVCProfile	I
    //   864: iload 7
    //   866: putstatic 71	com/tencent/qqlive/tvkplayer/playerwrapper/player/tools/TVKCodecUtils:mHWVideoHEVCLevel	I
    //   869: goto +388 -> 1257
    //   872: new 303	java/lang/StringBuilder
    //   875: dup
    //   876: invokespecial 304	java/lang/StringBuilder:<init>	()V
    //   879: astore 12
    //   881: aload 12
    //   883: ldc_w 306
    //   886: invokevirtual 310	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   889: pop
    //   890: aload 12
    //   892: getstatic 73	com/tencent/qqlive/tvkplayer/playerwrapper/player/tools/TVKCodecUtils:mHWVideoHEVCProfile	I
    //   895: invokevirtual 313	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   898: pop
    //   899: aload 12
    //   901: ldc_w 315
    //   904: invokevirtual 310	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   907: pop
    //   908: aload 12
    //   910: getstatic 71	com/tencent/qqlive/tvkplayer/playerwrapper/player/tools/TVKCodecUtils:mHWVideoHEVCLevel	I
    //   913: invokevirtual 313	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   916: pop
    //   917: aload 12
    //   919: ldc_w 317
    //   922: invokevirtual 310	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   925: pop
    //   926: aload 12
    //   928: getstatic 69	com/tencent/qqlive/tvkplayer/playerwrapper/player/tools/TVKCodecUtils:mHWVideoHEVCMaxCap	I
    //   931: invokevirtual 313	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   934: pop
    //   935: ldc 23
    //   937: aload 12
    //   939: invokevirtual 320	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   942: invokestatic 146	com/tencent/qqlive/tvkplayer/tools/utils/TVKLogUtil:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   945: iconst_1
    //   946: istore 8
    //   948: iload_2
    //   949: istore 7
    //   951: iload_0
    //   952: istore 4
    //   954: aload 11
    //   956: astore 12
    //   958: goto +308 -> 1266
    //   961: getstatic 61	com/tencent/qqlive/tvkplayer/playerwrapper/player/tools/TVKCodecUtils:mSoftCodecCapList	Ljava/util/ArrayList;
    //   964: aload 12
    //   966: invokevirtual 285	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   969: pop
    //   970: iload_2
    //   971: istore 7
    //   973: iload_3
    //   974: istore 8
    //   976: iload_0
    //   977: istore 4
    //   979: aload 11
    //   981: astore 12
    //   983: goto +283 -> 1266
    //   986: getstatic 181	com/tencent/qqlive/tvkplayer/tools/config/TVKMediaPlayerConfig$PlayerConfig:is_use_cache_hwlevel	Lcom/tencent/qqlive/tvkplayer/tools/config/TVKConfigField;
    //   989: invokevirtual 187	com/tencent/qqlive/tvkplayer/tools/config/TVKConfigField:getValue	()Ljava/lang/Object;
    //   992: checkcast 189	java/lang/Boolean
    //   995: invokevirtual 193	java/lang/Boolean:booleanValue	()Z
    //   998: ifeq +143 -> 1141
    //   1001: getstatic 97	com/tencent/qqlive/tvkplayer/playerwrapper/player/tools/TVKCodecUtils:mHWconfigKey	Ljava/lang/String;
    //   1004: getstatic 59	com/tencent/qqlive/tvkplayer/playerwrapper/player/tools/TVKCodecUtils:mHWCodecCapList	Ljava/util/ArrayList;
    //   1007: invokestatic 329	com/tencent/qqlive/tvkplayer/playerwrapper/player/tools/TVKCodecUtils:cacheConfig_V2	(Ljava/lang/String;Ljava/util/ArrayList;)V
    //   1010: getstatic 101	com/tencent/qqlive/tvkplayer/playerwrapper/player/tools/TVKCodecUtils:mSoftconfigKey	Ljava/lang/String;
    //   1013: getstatic 61	com/tencent/qqlive/tvkplayer/playerwrapper/player/tools/TVKCodecUtils:mSoftCodecCapList	Ljava/util/ArrayList;
    //   1016: invokestatic 329	com/tencent/qqlive/tvkplayer/playerwrapper/player/tools/TVKCodecUtils:cacheConfig_V2	(Ljava/lang/String;Ljava/util/ArrayList;)V
    //   1019: new 111	java/util/HashMap
    //   1022: dup
    //   1023: invokespecial 112	java/util/HashMap:<init>	()V
    //   1026: astore 11
    //   1028: aload 11
    //   1030: ldc_w 330
    //   1033: getstatic 63	com/tencent/qqlive/tvkplayer/playerwrapper/player/tools/TVKCodecUtils:mHWVideoAVCMaxCap	I
    //   1036: invokestatic 333	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1039: invokevirtual 124	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1042: pop
    //   1043: aload 11
    //   1045: ldc_w 330
    //   1048: getstatic 63	com/tencent/qqlive/tvkplayer/playerwrapper/player/tools/TVKCodecUtils:mHWVideoAVCMaxCap	I
    //   1051: invokestatic 333	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1054: invokevirtual 124	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1057: pop
    //   1058: aload 11
    //   1060: ldc_w 334
    //   1063: getstatic 65	com/tencent/qqlive/tvkplayer/playerwrapper/player/tools/TVKCodecUtils:mHWVideoAVCLevel	I
    //   1066: invokestatic 333	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1069: invokevirtual 124	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1072: pop
    //   1073: aload 11
    //   1075: ldc_w 335
    //   1078: getstatic 67	com/tencent/qqlive/tvkplayer/playerwrapper/player/tools/TVKCodecUtils:mHWVideoAVCProfile	I
    //   1081: invokestatic 333	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1084: invokevirtual 124	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1087: pop
    //   1088: aload 11
    //   1090: ldc_w 336
    //   1093: getstatic 69	com/tencent/qqlive/tvkplayer/playerwrapper/player/tools/TVKCodecUtils:mHWVideoHEVCMaxCap	I
    //   1096: invokestatic 333	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1099: invokevirtual 124	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1102: pop
    //   1103: aload 11
    //   1105: ldc_w 337
    //   1108: getstatic 71	com/tencent/qqlive/tvkplayer/playerwrapper/player/tools/TVKCodecUtils:mHWVideoHEVCLevel	I
    //   1111: invokestatic 333	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1114: invokevirtual 124	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1117: pop
    //   1118: aload 11
    //   1120: ldc_w 338
    //   1123: getstatic 73	com/tencent/qqlive/tvkplayer/playerwrapper/player/tools/TVKCodecUtils:mHWVideoHEVCProfile	I
    //   1126: invokestatic 333	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1129: invokevirtual 124	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1132: pop
    //   1133: getstatic 105	com/tencent/qqlive/tvkplayer/playerwrapper/player/tools/TVKCodecUtils:mHWVideoLevelKey	Ljava/lang/String;
    //   1136: aload 11
    //   1138: invokestatic 342	com/tencent/qqlive/tvkplayer/playerwrapper/player/tools/TVKCodecUtils:cacheConfigWithMap	(Ljava/lang/String;Ljava/util/HashMap;)V
    //   1141: iconst_1
    //   1142: putstatic 77	com/tencent/qqlive/tvkplayer/playerwrapper/player/tools/TVKCodecUtils:mIsInitDone	Z
    //   1145: goto +68 -> 1213
    //   1148: astore 11
    //   1150: goto +69 -> 1219
    //   1153: astore 11
    //   1155: ldc 23
    //   1157: aload 11
    //   1159: invokestatic 346	com/tencent/qqlive/tvkplayer/tools/utils/TVKLogUtil:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1162: goto -21 -> 1141
    //   1165: astore 11
    //   1167: ldc 23
    //   1169: aload 11
    //   1171: invokestatic 346	com/tencent/qqlive/tvkplayer/tools/utils/TVKLogUtil:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1174: goto -33 -> 1141
    //   1177: astore 11
    //   1179: ldc 23
    //   1181: aload 11
    //   1183: invokestatic 346	com/tencent/qqlive/tvkplayer/tools/utils/TVKLogUtil:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1186: goto -45 -> 1141
    //   1189: astore 11
    //   1191: ldc 23
    //   1193: aload 11
    //   1195: invokestatic 346	com/tencent/qqlive/tvkplayer/tools/utils/TVKLogUtil:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1198: goto -57 -> 1141
    //   1201: astore 11
    //   1203: ldc 23
    //   1205: aload 11
    //   1207: invokestatic 346	com/tencent/qqlive/tvkplayer/tools/utils/TVKLogUtil:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1210: goto -69 -> 1141
    //   1213: ldc 2
    //   1215: monitorexit
    //   1216: return
    //   1217: astore 11
    //   1219: iconst_1
    //   1220: putstatic 77	com/tencent/qqlive/tvkplayer/playerwrapper/player/tools/TVKCodecUtils:mIsInitDone	Z
    //   1223: aload 11
    //   1225: athrow
    //   1226: astore 11
    //   1228: ldc 2
    //   1230: monitorexit
    //   1231: goto +6 -> 1237
    //   1234: aload 11
    //   1236: athrow
    //   1237: goto -3 -> 1234
    //   1240: iload 4
    //   1242: iconst_1
    //   1243: iadd
    //   1244: istore 4
    //   1246: goto -691 -> 555
    //   1249: astore 11
    //   1251: goto -32 -> 1219
    //   1254: goto -543 -> 711
    //   1257: iload 4
    //   1259: iconst_1
    //   1260: iadd
    //   1261: istore 4
    //   1263: goto -469 -> 794
    //   1266: iload 6
    //   1268: iconst_1
    //   1269: iadd
    //   1270: istore 6
    //   1272: iload 4
    //   1274: istore_0
    //   1275: aload 12
    //   1277: astore 11
    //   1279: iload 7
    //   1281: istore_2
    //   1282: iload 8
    //   1284: istore_3
    //   1285: goto -856 -> 429
    //   1288: iload_1
    //   1289: istore_0
    //   1290: iload_2
    //   1291: istore_1
    //   1292: iload_3
    //   1293: istore_2
    //   1294: iload_1
    //   1295: istore_3
    //   1296: iload 5
    //   1298: iconst_1
    //   1299: iadd
    //   1300: istore 5
    //   1302: iload_0
    //   1303: istore_1
    //   1304: iload_3
    //   1305: istore_0
    //   1306: goto -983 -> 323
    // Local variable table:
    //   start	length	slot	name	signature
    //   320	657	0	i	int
    //   315	57	1	j	int
    //   322	649	2	k	int
    //   370	604	3	m	int
    //   417	828	4	n	int
    //   317	22	5	i1	int
    //   420	18	6	i2	int
    //   581	391	7	i3	int
    //   596	379	8	i4	int
    //   605	250	9	i5	int
    //   507	229	10	bool	boolean
    //   63	1074	11	localObject1	Object
    //   1148	1	11	localObject2	Object
    //   1153	5	11	localClassNotFoundException	java.lang.ClassNotFoundException
    //   1165	5	11	localNoSuchFieldException	java.lang.NoSuchFieldException
    //   1177	5	11	localIllegalAccessException	java.lang.IllegalAccessException
    //   1189	5	11	localNoSuchMethodException	java.lang.NoSuchMethodException
    //   1201	5	11	localInvocationTargetException	java.lang.reflect.InvocationTargetException
    //   1217	7	11	localObject3	Object
    //   1226	9	11	localObject4	Object
    //   177	805	12	localObject5	Object
    //   196	134	13	localMethod1	Method
    //   203	273	14	localObject6	Object
    //   412	24	15	arrayOfString	String[]
    //   229	148	16	localMethod2	Method
    //   242	108	17	localMethod3	Method
    //   260	500	18	localMethod4	Method
    //   272	486	19	localField1	Field
    //   288	520	20	localField2	Field
    //   297	526	21	localField3	Field
    //   347	415	22	localObject7	Object
    //   566	259	23	localObject8	Object
    // Exception table:
    //   from	to	target	type
    //   152	316	1148	finally
    //   329	369	1148	finally
    //   376	419	1148	finally
    //   442	486	1148	finally
    //   489	509	1148	finally
    //   518	552	1148	finally
    //   568	630	1148	finally
    //   633	706	1148	finally
    //   711	722	1148	finally
    //   757	791	1148	finally
    //   807	869	1148	finally
    //   872	945	1148	finally
    //   961	970	1148	finally
    //   986	1141	1148	finally
    //   1155	1162	1148	finally
    //   1167	1174	1148	finally
    //   1179	1186	1148	finally
    //   1191	1198	1148	finally
    //   152	316	1153	java/lang/ClassNotFoundException
    //   329	369	1153	java/lang/ClassNotFoundException
    //   376	419	1153	java/lang/ClassNotFoundException
    //   442	486	1153	java/lang/ClassNotFoundException
    //   489	509	1153	java/lang/ClassNotFoundException
    //   518	552	1153	java/lang/ClassNotFoundException
    //   568	630	1153	java/lang/ClassNotFoundException
    //   633	706	1153	java/lang/ClassNotFoundException
    //   711	722	1153	java/lang/ClassNotFoundException
    //   757	791	1153	java/lang/ClassNotFoundException
    //   807	869	1153	java/lang/ClassNotFoundException
    //   872	945	1153	java/lang/ClassNotFoundException
    //   961	970	1153	java/lang/ClassNotFoundException
    //   986	1141	1153	java/lang/ClassNotFoundException
    //   152	316	1165	java/lang/NoSuchFieldException
    //   329	369	1165	java/lang/NoSuchFieldException
    //   376	419	1165	java/lang/NoSuchFieldException
    //   442	486	1165	java/lang/NoSuchFieldException
    //   489	509	1165	java/lang/NoSuchFieldException
    //   518	552	1165	java/lang/NoSuchFieldException
    //   568	630	1165	java/lang/NoSuchFieldException
    //   633	706	1165	java/lang/NoSuchFieldException
    //   711	722	1165	java/lang/NoSuchFieldException
    //   757	791	1165	java/lang/NoSuchFieldException
    //   807	869	1165	java/lang/NoSuchFieldException
    //   872	945	1165	java/lang/NoSuchFieldException
    //   961	970	1165	java/lang/NoSuchFieldException
    //   986	1141	1165	java/lang/NoSuchFieldException
    //   152	316	1177	java/lang/IllegalAccessException
    //   329	369	1177	java/lang/IllegalAccessException
    //   376	419	1177	java/lang/IllegalAccessException
    //   442	486	1177	java/lang/IllegalAccessException
    //   489	509	1177	java/lang/IllegalAccessException
    //   518	552	1177	java/lang/IllegalAccessException
    //   568	630	1177	java/lang/IllegalAccessException
    //   633	706	1177	java/lang/IllegalAccessException
    //   711	722	1177	java/lang/IllegalAccessException
    //   757	791	1177	java/lang/IllegalAccessException
    //   807	869	1177	java/lang/IllegalAccessException
    //   872	945	1177	java/lang/IllegalAccessException
    //   961	970	1177	java/lang/IllegalAccessException
    //   986	1141	1177	java/lang/IllegalAccessException
    //   152	316	1189	java/lang/NoSuchMethodException
    //   329	369	1189	java/lang/NoSuchMethodException
    //   376	419	1189	java/lang/NoSuchMethodException
    //   442	486	1189	java/lang/NoSuchMethodException
    //   489	509	1189	java/lang/NoSuchMethodException
    //   518	552	1189	java/lang/NoSuchMethodException
    //   568	630	1189	java/lang/NoSuchMethodException
    //   633	706	1189	java/lang/NoSuchMethodException
    //   711	722	1189	java/lang/NoSuchMethodException
    //   757	791	1189	java/lang/NoSuchMethodException
    //   807	869	1189	java/lang/NoSuchMethodException
    //   872	945	1189	java/lang/NoSuchMethodException
    //   961	970	1189	java/lang/NoSuchMethodException
    //   986	1141	1189	java/lang/NoSuchMethodException
    //   152	316	1201	java/lang/reflect/InvocationTargetException
    //   329	369	1201	java/lang/reflect/InvocationTargetException
    //   376	419	1201	java/lang/reflect/InvocationTargetException
    //   442	486	1201	java/lang/reflect/InvocationTargetException
    //   489	509	1201	java/lang/reflect/InvocationTargetException
    //   518	552	1201	java/lang/reflect/InvocationTargetException
    //   568	630	1201	java/lang/reflect/InvocationTargetException
    //   633	706	1201	java/lang/reflect/InvocationTargetException
    //   711	722	1201	java/lang/reflect/InvocationTargetException
    //   757	791	1201	java/lang/reflect/InvocationTargetException
    //   807	869	1201	java/lang/reflect/InvocationTargetException
    //   872	945	1201	java/lang/reflect/InvocationTargetException
    //   961	970	1201	java/lang/reflect/InvocationTargetException
    //   986	1141	1201	java/lang/reflect/InvocationTargetException
    //   1203	1210	1217	finally
    //   3	16	1226	finally
    //   20	57	1226	finally
    //   57	65	1226	finally
    //   70	75	1226	finally
    //   75	90	1226	finally
    //   90	98	1226	finally
    //   103	108	1226	finally
    //   108	148	1226	finally
    //   1141	1145	1226	finally
    //   1219	1226	1226	finally
  }
  
  private static void cacheConfigWithMap(String paramString, HashMap<String, String> paramHashMap)
  {
    if (TVideoMgr.getApplicationContext() != null) {}
    try
    {
      LocalCache localLocalCache = LocalCache.get(TVideoMgr.getApplicationContext());
      if (localLocalCache == null) {
        break label63;
      }
      localLocalCache.put(paramString, paramHashMap);
      return;
    }
    catch (Throwable paramHashMap)
    {
      label24:
      break label24;
    }
    paramHashMap = new StringBuilder();
    paramHashMap.append("cache ");
    paramHashMap.append(paramString);
    paramHashMap.append("failed");
    TVKLogUtil.e("MediaPlayerMgr[TVKCodecUtils.java]", paramHashMap.toString());
    label63:
  }
  
  private static void cacheConfig_V2(String paramString, ArrayList<String> paramArrayList)
  {
    if (TVideoMgr.getApplicationContext() != null) {}
    try
    {
      LocalCache localLocalCache = LocalCache.get(TVideoMgr.getApplicationContext());
      if (localLocalCache == null) {
        break label63;
      }
      localLocalCache.put(paramString, paramArrayList);
      return;
    }
    catch (Throwable paramArrayList)
    {
      label24:
      break label24;
    }
    paramArrayList = new StringBuilder();
    paramArrayList.append("cache ");
    paramArrayList.append(paramString);
    paramArrayList.append("failed");
    TVKLogUtil.e("MediaPlayerMgr[TVKCodecUtils.java]", paramArrayList.toString());
    label63:
  }
  
  private static boolean dealHwLevel()
  {
    Object localObject = getConfigWithMap(mHWVideoLevelKey);
    if (localObject != null) {}
    try
    {
      if (((HashMap)localObject).size() > 0)
      {
        mHWVideoAVCMaxCap = TVKUtils.optInt((String)((HashMap)localObject).get("mHWVideoAVCMaxCap"), 0);
        mHWVideoAVCLevel = TVKUtils.optInt((String)((HashMap)localObject).get("mHWVideoAVCLevel"), 0);
        mHWVideoAVCProfile = TVKUtils.optInt((String)((HashMap)localObject).get("mHWVideoAVCProfile"), 0);
        mHWVideoHEVCMaxCap = TVKUtils.optInt((String)((HashMap)localObject).get("mHWVideoHEVCMaxCap"), 0);
        mHWVideoHEVCProfile = TVKUtils.optInt((String)((HashMap)localObject).get("mHWVideoHEVCProfile"), 0);
        mHWVideoHEVCLevel = TVKUtils.optInt((String)((HashMap)localObject).get("mHWVideoHEVCLevel"), 0);
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("mHWVideoAVCMaxCap=");
      ((StringBuilder)localObject).append(mHWVideoAVCMaxCap);
      ((StringBuilder)localObject).append("mHWVideoAVCLevel=");
      ((StringBuilder)localObject).append(mHWVideoAVCLevel);
      ((StringBuilder)localObject).append("mHWVideoAVCProfile=");
      ((StringBuilder)localObject).append(mHWVideoAVCProfile);
      ((StringBuilder)localObject).append("mHWVideoHEVCMaxCap=");
      ((StringBuilder)localObject).append(mHWVideoHEVCMaxCap);
      ((StringBuilder)localObject).append("mHWVideoHEVCProfile=");
      ((StringBuilder)localObject).append(mHWVideoHEVCProfile);
      ((StringBuilder)localObject).append("mHWVideoHEVCLevel=");
      ((StringBuilder)localObject).append(mHWVideoHEVCLevel);
      TVKLogUtil.i("MediaPlayerMgr[TVKCodecUtils.java]", ((StringBuilder)localObject).toString());
      return true;
    }
    catch (Throwable localThrowable) {}
    return false;
  }
  
  private static HashMap<String, String> getConfigWithMap(String paramString)
  {
    if (TVideoMgr.getApplicationContext() != null) {}
    try
    {
      localObject = LocalCache.get(TVideoMgr.getApplicationContext());
      if (localObject == null) {
        break label70;
      }
      localObject = (HashMap)((LocalCache)localObject).getAsObject(paramString);
      return localObject;
    }
    catch (Throwable localThrowable)
    {
      Object localObject;
      label31:
      break label31;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("get ");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append("failed");
    TVKLogUtil.e("MediaPlayerMgr[TVKCodecUtils.java]", ((StringBuilder)localObject).toString());
    label70:
    return null;
  }
  
  private static ArrayList<String> getConfig_V2(String paramString)
  {
    if (TVideoMgr.getApplicationContext() != null) {}
    try
    {
      localObject = LocalCache.get(TVideoMgr.getApplicationContext());
      if (localObject == null) {
        break label70;
      }
      localObject = (ArrayList)((LocalCache)localObject).getAsObject(paramString);
      return localObject;
    }
    catch (Throwable localThrowable)
    {
      Object localObject;
      label31:
      break label31;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("get ");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append("failed");
    TVKLogUtil.e("MediaPlayerMgr[TVKCodecUtils.java]", ((StringBuilder)localObject).toString());
    label70:
    return null;
  }
  
  public static int getDefinitionLevel(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return 0;
    }
    if (paramString.equals("uhd")) {
      return 28;
    }
    if (paramString.equals("fhd")) {
      return 26;
    }
    if (paramString.equals("shd")) {
      return 21;
    }
    if ((!paramString.equals("hd")) && (!paramString.equals("mp4")))
    {
      if (paramString.equals("sd")) {
        return 11;
      }
      if (paramString.equals("msd")) {
        return 6;
      }
      return 1;
    }
    return 16;
  }
  
  public static int getDefnLevelByWidthHeight(int paramInt1, int paramInt2)
  {
    paramInt1 *= paramInt2;
    if (paramInt1 < 129600) {
      return 1;
    }
    if (paramInt1 < 407040) {
      return 11;
    }
    if (paramInt1 < 921600) {
      return 16;
    }
    if (paramInt1 < 2073600) {
      return 21;
    }
    if (paramInt1 < 8294400) {
      return 28;
    }
    return 33;
  }
  
  public static int getDolbyLevel()
  {
    if (sDolbyLevel == -1) {
      initInvariableParams();
    }
    return sDolbyLevel;
  }
  
  private static int getHdrCodecLevel()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public static int getHevcHWDecLevel()
  {
    int j = mHWVideoHEVCMaxCap;
    int i = 33;
    if (j < 129600) {
      i = 1;
    } else if (j < 407040) {
      i = 11;
    } else if (j < 921600) {
      i = 16;
    } else if (j < 2073600) {
      i = 21;
    } else if (j < 8294400) {
      i = 28;
    }
    if (((Boolean)TVKMediaPlayerConfig.PlayerConfig.mediacodec_support_hardwared.getValue()).booleanValue()) {
      i = 28;
    }
    return i;
  }
  
  private static int getHevcLvByCoresAndFreq()
  {
    if (TVKVcSystemInfo.getNumCores() >= 8) {
      if (TVKVcSystemInfo.getMaxCpuFreq() / 1000L >= 1200L) {
        return 21;
      }
    }
    do
    {
      do
      {
        return 16;
        if (TVKVcSystemInfo.getNumCores() < 6) {
          break;
        }
      } while (TVKVcSystemInfo.getMaxCpuFreq() / 1000L < 1400L);
      return 21;
      if (TVKVcSystemInfo.getNumCores() < 4) {
        break;
      }
    } while (TVKVcSystemInfo.getMaxCpuFreq() / 1000L < 1600L);
    return 21;
    return 6;
  }
  
  public static int getHevcMaxDecCap()
  {
    return mHWVideoHEVCMaxCap;
  }
  
  public static int getSoftCodecHevcLevel()
  {
    Object localObject = TVKVcSystemInfo.getCpuHarewareName();
    int i = TVKVcSystemInfo.getCpuHWProducter((String)localObject);
    int j = TVKVcSystemInfo.getCpuHWProductIndex((String)localObject);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[getSoftCodecHevcLevel], numCores = ");
    ((StringBuilder)localObject).append(TVKVcSystemInfo.getNumCores());
    ((StringBuilder)localObject).append(", totalMem = ");
    ((StringBuilder)localObject).append(TVKVcSystemInfo.getTotalMem(TVideoMgr.getApplicationContext()));
    TVKLogUtil.i("MediaPlayerMgr[TVKCodecUtils.java]", ((StringBuilder)localObject).toString());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[getSoftCodecHevcLevel], hd_hevc_least_cores = ");
    ((StringBuilder)localObject).append(TVKMediaPlayerConfig.PlayerConfig.hd_hevc_least_cores.getValue());
    ((StringBuilder)localObject).append(", hd_hevc_least_mem = ");
    ((StringBuilder)localObject).append(TVKMediaPlayerConfig.PlayerConfig.hd_hevc_least_mem.getValue());
    TVKLogUtil.i("MediaPlayerMgr[TVKCodecUtils.java]", ((StringBuilder)localObject).toString());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[getSoftCodecHevcLevel], mCpuHWProducter = ");
    ((StringBuilder)localObject).append(i);
    ((StringBuilder)localObject).append(", getMaxCpuFreq() = ");
    ((StringBuilder)localObject).append(TVKVcSystemInfo.getMaxCpuFreq());
    ((StringBuilder)localObject).append(" mCpuHWProductIdx=");
    ((StringBuilder)localObject).append(j);
    TVKLogUtil.i("MediaPlayerMgr[TVKCodecUtils.java]", ((StringBuilder)localObject).toString());
    int k = mPlayerHevcLevel;
    if (-1 != k) {
      return k;
    }
    mPlayerHevcLevel = 0;
    if (-1 == i) {
      mPlayerHevcLevel = getHevcLvByCoresAndFreq();
    } else if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i == 3) {
            if (j >= ((Integer)TVKMediaPlayerConfig.PlayerConfig.shd_hevc_sumsing_index.getValue()).intValue()) {
              mPlayerHevcLevel = 21;
            } else if (j >= ((Integer)TVKMediaPlayerConfig.PlayerConfig.hd_hevc_sumsing_index.getValue()).intValue()) {
              mPlayerHevcLevel = 16;
            } else {
              mPlayerHevcLevel = getHevcLvByCoresAndFreq();
            }
          }
        }
        else if (j >= ((Integer)TVKMediaPlayerConfig.PlayerConfig.shd_hevc_hisi_index.getValue()).intValue()) {
          mPlayerHevcLevel = 21;
        } else if (j >= ((Integer)TVKMediaPlayerConfig.PlayerConfig.hd_hevc_hisi_index.getValue()).intValue()) {
          mPlayerHevcLevel = 16;
        } else {
          mPlayerHevcLevel = getHevcLvByCoresAndFreq();
        }
      }
      else if (j >= ((Integer)TVKMediaPlayerConfig.PlayerConfig.shd_hevc_mtk_index.getValue()).intValue()) {
        mPlayerHevcLevel = 21;
      } else if (j >= ((Integer)TVKMediaPlayerConfig.PlayerConfig.hd_hevc_mtk_index.getValue()).intValue()) {
        mPlayerHevcLevel = 16;
      } else {
        mPlayerHevcLevel = getHevcLvByCoresAndFreq();
      }
    }
    else if (j >= ((Integer)TVKMediaPlayerConfig.PlayerConfig.shd_hevc_qualcomm_index.getValue()).intValue()) {
      mPlayerHevcLevel = 21;
    } else if (j >= ((Integer)TVKMediaPlayerConfig.PlayerConfig.hd_hevc_qualcomm_index.getValue()).intValue()) {
      mPlayerHevcLevel = 16;
    } else {
      mPlayerHevcLevel = getHevcLvByCoresAndFreq();
    }
    return mPlayerHevcLevel;
  }
  
  private static boolean hdrCodecCapabilitiesDetect()
  {
    if (Build.VERSION.SDK_INT < 24) {
      return false;
    }
    try
    {
      int m = MediaCodecList.getCodecCount();
      int i = 0;
      Object localObject;
      while (i < m)
      {
        MediaCodecInfo localMediaCodecInfo = MediaCodecList.getCodecInfoAt(i);
        if (!localMediaCodecInfo.isEncoder())
        {
          localObject = localMediaCodecInfo.getSupportedTypes();
          int n = localObject.length;
          int j = 0;
          while (j < n)
          {
            if (localObject[j].equalsIgnoreCase("video/hevc"))
            {
              MediaCodecInfo.CodecProfileLevel[] arrayOfCodecProfileLevel = localMediaCodecInfo.getCapabilitiesForType("video/hevc").profileLevels;
              int i1 = arrayOfCodecProfileLevel.length;
              int k = 0;
              while (k < i1)
              {
                if (arrayOfCodecProfileLevel[k].profile == 4096)
                {
                  TVKLogUtil.i("MediaPlayerMgr[TVKCodecUtils.java]", "isHDR10CodecSupport support HDR10");
                  return true;
                }
                k += 1;
              }
            }
            j += 1;
          }
        }
        i += 1;
      }
      return false;
    }
    catch (Throwable localThrowable)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("isHDR10CodecSupport ");
      ((StringBuilder)localObject).append(localThrowable.toString());
      TVKLogUtil.e("MediaPlayerMgr[TVKCodecUtils.java]", ((StringBuilder)localObject).toString());
      TVKLogUtil.i("MediaPlayerMgr[TVKCodecUtils.java]", "isHDR10CodecSupport not support");
    }
  }
  
  private static void initInvariableParams()
  {
    boolean bool1 = isDDPlusSupported_V2(TVideoMgr.getApplicationContext());
    boolean bool2 = isDolbyDSSupported();
    if ((!bool2) && (!bool1))
    {
      sDolbyLevel = 0;
      return;
    }
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
    if ((bool2) && (bool1)) {
      sDolbyLevel = 11;
    }
  }
  
  public static boolean isBlackListForHardwareDec(Context paramContext, String paramString)
  {
    int i = mIsInBlackListForHardwareDec;
    if (i != -1) {
      return i != 0;
    }
    mIsInBlackListForHardwareDec = 0;
    try
    {
      paramContext = TVKVcSystemInfo.getDeviceIMEI(paramContext);
      if ((!TextUtils.isEmpty(paramContext)) && ((paramContext.equals("862374021679556")) || (paramContext.equals("352107063035304")) || (paramContext.equals("359950061442003")) || (paramContext.equals("352514063538981")) || (paramContext.equals("864052022167536")) || (paramContext.equals("864821021284769")) || (paramContext.equals("863738029867885")) || (paramContext.equals("359950063519113")) || (paramContext.equals("353360060459642")) || (paramContext.equals("354765050577808"))))
      {
        paramString = new StringBuilder();
        paramString.append("isBlackListForHardwareDec, deviceIMEI: ");
        paramString.append(paramContext);
        TVKLogUtil.i("MediaPlayerMgr[TVKCodecUtils.java]", paramString.toString());
        mIsInBlackListForHardwareDec = 1;
        return true;
      }
      paramContext = Build.MODEL;
      if ((!TextUtils.isEmpty(paramContext)) && ((paramContext.equals("SM-J7008")) || (paramContext.equals("SM-J5008")) || (paramContext.equals("TCL i806")) || (paramContext.equals("NX511J")) || (paramContext.equals("vivo Y11i T")) || (paramContext.equals("长虹智能电视")) || (paramContext.equals("MI 1S")) || (paramContext.equals("SP9832A")) || (paramContext.equals("SP9830A")) || (paramContext.equals("VOTO GT17")) || (paramContext.equals("EVA-AL10"))))
      {
        paramString = new StringBuilder();
        paramString.append("isBlackListForHardwareDec, deviceName: ");
        paramString.append(paramContext);
        TVKLogUtil.i("MediaPlayerMgr[TVKCodecUtils.java]", paramString.toString());
        mIsInBlackListForHardwareDec = 1;
        return true;
      }
      if ((TextUtils.isEmpty(paramString)) || (!paramString.equals("video/hevc")) || (Build.VERSION.SDK_INT < 14) || (TextUtils.isEmpty(paramContext)) || ((!"PRO 7 Plus".equals(paramContext)) && (!"PRO 7-H".equals(paramContext)) && (!"PRO+7+Plus".equals(paramContext)))) {
        break label402;
      }
      mIsInBlackListForHardwareDec = 1;
      return true;
    }
    catch (Exception paramContext)
    {
      label394:
      break label394;
    }
    TVKLogUtil.e("MediaPlayerMgr[TVKCodecUtils.java]", "isBlackListForHardwareDec exception");
    label402:
    return false;
  }
  
  public static boolean isBlackListForHdr10()
  {
    try
    {
      Object localObject;
      if (!TextUtils.isEmpty((CharSequence)TVKMediaPlayerConfig.PlayerConfig.hdr_video_decode_black_list.getValue()))
      {
        String str1 = (String)TVKMediaPlayerConfig.PlayerConfig.hdr_video_decode_black_list.getValue();
        localObject = str1.split(",");
        String str2 = Build.MODEL;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("hdr10 黑名单：");
        localStringBuilder.append(str1);
        TVKLogUtil.i("MediaPlayerMgr[TVKCodecUtils.java]", localStringBuilder.toString());
        int i = 0;
        while (i < localObject.length)
        {
          boolean bool = str2.equalsIgnoreCase(localObject[i]);
          if (bool) {
            return true;
          }
          i += 1;
        }
      }
      return false;
    }
    catch (Exception localException)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("isBlackListForHdr10：");
      ((StringBuilder)localObject).append(localException.toString());
      TVKLogUtil.i("MediaPlayerMgr[TVKCodecUtils.java]", ((StringBuilder)localObject).toString());
    }
  }
  
  public static boolean isBlackListForHdr10Enhance()
  {
    try
    {
      Object localObject;
      if (!TextUtils.isEmpty((CharSequence)TVKMediaPlayerConfig.PlayerConfig.hdr_enhance_video_decode_black_list.getValue()))
      {
        String str1 = (String)TVKMediaPlayerConfig.PlayerConfig.hdr_enhance_video_decode_black_list.getValue();
        localObject = str1.split(",");
        String str2 = Build.MODEL;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("hdr10 黑名单：");
        localStringBuilder.append(str1);
        TVKLogUtil.i("MediaPlayerMgr[TVKCodecUtils.java]", localStringBuilder.toString());
        int i = 0;
        while (i < localObject.length)
        {
          boolean bool = str2.equalsIgnoreCase(localObject[i]);
          if (bool) {
            return true;
          }
          i += 1;
        }
      }
      return false;
    }
    catch (Exception localException)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("isBlackListForHdr10：");
      ((StringBuilder)localObject).append(localException.toString());
      TVKLogUtil.i("MediaPlayerMgr[TVKCodecUtils.java]", ((StringBuilder)localObject).toString());
    }
  }
  
  public static boolean isBlackListForVidHdr10Enhance(String paramString)
  {
    try
    {
      Object localObject;
      if ((!TextUtils.isEmpty(paramString)) && (!TextUtils.isEmpty((CharSequence)TVKMediaPlayerConfig.PlayerConfig.hdr_enhance_video_vid_black_list.getValue())))
      {
        localObject = (String)TVKMediaPlayerConfig.PlayerConfig.hdr_enhance_video_vid_black_list.getValue();
        String[] arrayOfString = ((String)localObject).split(",");
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("hdr10 vid：");
        localStringBuilder.append((String)localObject);
        TVKLogUtil.i("MediaPlayerMgr[TVKCodecUtils.java]", localStringBuilder.toString());
        int i = 0;
        while (i < arrayOfString.length)
        {
          boolean bool = paramString.equalsIgnoreCase(arrayOfString[i]);
          if (bool) {
            return true;
          }
          i += 1;
        }
      }
      return false;
    }
    catch (Exception paramString)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("isBlackListForHdr10：");
      ((StringBuilder)localObject).append(paramString.toString());
      TVKLogUtil.i("MediaPlayerMgr[TVKCodecUtils.java]", ((StringBuilder)localObject).toString());
    }
  }
  
  public static boolean isCodecSupported(String paramString, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    boolean bool2 = ((Boolean)TVKMediaPlayerConfig.PlayerConfig.mediacodec_support_hardwared.getValue()).booleanValue();
    boolean bool1 = true;
    if (bool2) {
      return true;
    }
    bool2 = false;
    try
    {
      Object localObject = Build.MODEL;
      boolean bool3 = TextUtils.isEmpty((CharSequence)localObject);
      if ((!bool3) && (mCodecCap != null) && (mCodecCap.containsKey(localObject)))
      {
        localObject = (Integer)mCodecCap.get(localObject);
        if (TextUtils.equals(paramString, "video/avc"))
        {
          paramBoolean = bool2;
          if ((((Integer)localObject).intValue() & 0x1) == 0) {
            break label591;
          }
          break label589;
        }
        if (TextUtils.equals(paramString, "video/hevc"))
        {
          paramBoolean = bool2;
          if ((((Integer)localObject).intValue() & 0x2) == 0) {
            break label591;
          }
          break label589;
        }
        if (TextUtils.equals(paramString, "audio/mp4a-latm"))
        {
          paramBoolean = bool2;
          if ((((Integer)localObject).intValue() & 0x4) == 0) {
            break label591;
          }
          break label589;
        }
        if (!TextUtils.equals(paramString, "audio/eac3"))
        {
          paramBoolean = bool2;
          if (!TextUtils.equals(paramString, "audio/ec3")) {
            break label591;
          }
        }
        paramBoolean = bool2;
        if ((((Integer)localObject).intValue() & 0x8) == 0) {
          break label591;
        }
        break label589;
      }
      if (!mIsInitDone)
      {
        acquireCodecParamsAsync();
        return false;
      }
      if (!paramBoolean)
      {
        if (mHWCodecCapList.contains(paramString)) {
          break label593;
        }
        if (mSoftCodecCapList.contains(paramString)) {
          break label593;
        }
      }
      else if (mHWCodecCapList.contains(paramString))
      {
        paramBoolean = paramString.equalsIgnoreCase("video/avc");
        if (paramBoolean)
        {
          if (mHWVideoAVCMaxCap >= paramInt1 * paramInt2)
          {
            paramString = new StringBuilder();
            paramString.append("h264 profile:");
            paramString.append(mHWVideoAVCProfile);
            paramString.append(",level:");
            paramString.append(mHWVideoAVCLevel);
            paramString.append(" support ");
            paramString.append(paramInt1);
            paramString.append("x");
            paramString.append(paramInt2);
            TVKLogUtil.i("MediaPlayerMgr[TVKCodecUtils.java]", paramString.toString());
            return bool1;
          }
          paramString = new StringBuilder();
          paramString.append("isCodecExists true ,but HWVideoAVCMaxCap ");
          paramString.append(mHWVideoAVCMaxCap);
          paramString.append(" is not support ");
          paramString.append(paramInt1);
          paramString.append("x");
          paramString.append(paramInt2);
          TVKLogUtil.w("MediaPlayerMgr[TVKCodecUtils.java]", paramString.toString());
        }
        else if (paramString.equalsIgnoreCase("video/hevc"))
        {
          if ((mHWVideoHEVCMaxCap > 0) && (mHWVideoHEVCMaxCap >= paramInt1 * paramInt2))
          {
            paramString = new StringBuilder();
            paramString.append("hevc profile:");
            paramString.append(mHWVideoHEVCProfile);
            paramString.append(",level:");
            paramString.append(mHWVideoHEVCLevel);
            paramString.append(" support ");
            paramString.append(paramInt1);
            paramString.append("x");
            paramString.append(paramInt2);
            TVKLogUtil.i("MediaPlayerMgr[TVKCodecUtils.java]", paramString.toString());
            return bool1;
          }
          paramString = new StringBuilder();
          paramString.append("isCodecExists true ,but mHWVideoHEVCMaxCap ");
          paramString.append(mHWVideoHEVCMaxCap);
          paramString.append(" is not support ");
          paramString.append(paramInt1);
          paramString.append("x");
          paramString.append(paramInt2);
          TVKLogUtil.w("MediaPlayerMgr[TVKCodecUtils.java]", paramString.toString());
        }
      }
    }
    catch (Exception paramString)
    {
      TVKLogUtil.e("MediaPlayerMgr[TVKCodecUtils.java]", paramString);
    }
    return false;
    label589:
    paramBoolean = true;
    label591:
    return paramBoolean;
    label593:
    return true;
    paramBoolean = false;
    return paramBoolean;
  }
  
  public static boolean isDDPlusSupported(Context paramContext)
  {
    if (sIsDDPInit) {
      return sIsDDPSup;
    }
    if (isBlackListForHardwareDec(paramContext, null))
    {
      sIsDDPInit = true;
      sIsDDPSup = false;
      return sIsDDPSup;
    }
    for (;;)
    {
      boolean bool1;
      boolean bool2;
      try
      {
        paramContext = Class.forName("android.media.MediaCodecList");
        localObject1 = paramContext.getDeclaredMethod("getCodecCount", new Class[0]);
        paramContext = paramContext.getDeclaredMethod("getCodecInfoAt", new Class[] { Integer.TYPE });
        localMethod = Class.forName("android.media.MediaCodecInfo").getDeclaredMethod("getSupportedTypes", new Class[0]);
        int k = ((Integer)((Method)localObject1).invoke(null, new Object[0])).intValue();
        i = 0;
        bool1 = false;
        bool2 = bool1;
        if (i < k)
        {
          bool2 = bool1;
          if (bool1) {}
        }
      }
      catch (Exception paramContext)
      {
        Object localObject1;
        Method localMethod;
        int i;
        int m;
        int j;
        continue;
      }
      try
      {
        localObject1 = (String[])localMethod.invoke(paramContext.invoke(null, new Object[] { Integer.valueOf(i) }), new Object[0]);
        m = localObject1.length;
        j = 0;
        bool2 = bool1;
        if (j < m)
        {
          Object localObject2 = localObject1[j];
          if (!localObject2.equals("audio/eac3"))
          {
            bool2 = localObject2.equals("audio/ec3");
            if (!bool2)
            {
              j += 1;
              continue;
            }
          }
          bool2 = true;
        }
        else
        {
          i += 1;
          bool1 = bool2;
        }
      }
      catch (Exception paramContext)
      {
        bool2 = bool1;
      }
    }
    bool2 = false;
    sIsDDPSup = bool2;
    sIsDDPInit = true;
    return sIsDDPSup;
  }
  
  public static boolean isDDPlusSupported_V2(Context paramContext)
  {
    boolean bool2 = isBlackListForHardwareDec(paramContext, null);
    boolean bool1 = false;
    if (bool2)
    {
      sIsDDPSup = false;
      return sIsDDPSup;
    }
    try
    {
      bool2 = isSupportDDPlus();
      bool1 = bool2;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    sIsDDPSup = bool1;
    return sIsDDPSup;
  }
  
  public static boolean isDolbyDSSupported()
  {
    if (sIsDDSInit)
    {
      if (sIsDDSSup)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("dds ha suported ");
        ((StringBuilder)localObject1).append(sIsDDSSup);
        TVKLogUtil.i("MediaPlayerMgr", ((StringBuilder)localObject1).toString());
      }
      return sIsDDSSup;
    }
    Object localObject1 = null;
    boolean bool2 = false;
    try
    {
      Object localObject2 = Class.forName("android.os.SystemProperties");
      localObject2 = (String)((Class)localObject2).getMethod("get", new Class[] { String.class }).invoke(localObject2, new Object[] { "dolby.ds.state" });
      localObject1 = localObject2;
    }
    catch (Exception localException)
    {
      TVKLogUtil.e("MediaPlayerMgr[TVKCodecUtils.java]", localException);
    }
    boolean bool1 = bool2;
    if (localObject1 != null) {
      if ((localObject1 != null) && (((String)localObject1).trim().equals(""))) {
        bool1 = bool2;
      } else {
        bool1 = true;
      }
    }
    sIsDDSSup = bool1;
    sIsDDSInit = true;
    if (sIsDDSSup)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("dds ha suported ");
      ((StringBuilder)localObject1).append(sIsDDSSup);
      TVKLogUtil.i("MediaPlayerMgr", ((StringBuilder)localObject1).toString());
    }
    return sIsDDSSup;
  }
  
  public static boolean isHDR10CodecSupport()
  {
    if (mHDR10CodecSupport == -1) {
      mHDR10CodecSupport = getHdrCodecLevel();
    }
    int i = mHDR10CodecSupport;
    if (i == 0) {
      return false;
    }
    return i == 1;
  }
  
  public static boolean isSupportDDPlus()
  {
    ArrayList localArrayList = mHWCodecCapList;
    if ((localArrayList != null) && (localArrayList.size() > 0) && ((mHWCodecCapList.contains("audio/eac3")) || (mHWCodecCapList.contains("audio/ec3")))) {
      return true;
    }
    localArrayList = mSoftCodecCapList;
    return (localArrayList != null) && (localArrayList.size() > 0) && ((mSoftCodecCapList.contains("audio/eac3")) || (mSoftCodecCapList.contains("audio/ec3")));
  }
  
  public static boolean isWhiteListForHdr10()
  {
    try
    {
      Object localObject;
      if (!TextUtils.isEmpty((CharSequence)TVKMediaPlayerConfig.PlayerConfig.hdr_video_decode_white_list.getValue()))
      {
        String str1 = (String)TVKMediaPlayerConfig.PlayerConfig.hdr_video_decode_white_list.getValue();
        localObject = str1.split(",");
        String str2 = Build.MODEL;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("hdr10 白名单：");
        localStringBuilder.append(str1);
        TVKLogUtil.i("MediaPlayerMgr[TVKCodecUtils.java]", localStringBuilder.toString());
        int i = 0;
        while (i < localObject.length)
        {
          boolean bool = str2.equalsIgnoreCase(localObject[i]);
          if (bool) {
            return true;
          }
          i += 1;
        }
      }
      return false;
    }
    catch (Exception localException)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("isWhiteListForHdr10：");
      ((StringBuilder)localObject).append(localException.toString());
      TVKLogUtil.i("MediaPlayerMgr[TVKCodecUtils.java]", ((StringBuilder)localObject).toString());
    }
  }
  
  public static boolean isWhiteListForHdr10Enhance()
  {
    try
    {
      Object localObject;
      if (!TextUtils.isEmpty((CharSequence)TVKMediaPlayerConfig.PlayerConfig.hdr_enhance_video_decode_white_list.getValue()))
      {
        String str1 = (String)TVKMediaPlayerConfig.PlayerConfig.hdr_enhance_video_decode_white_list.getValue();
        localObject = str1.split(",");
        String str2 = Build.MODEL;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("hdr10 白名单：");
        localStringBuilder.append(str1);
        TVKLogUtil.i("MediaPlayerMgr[TVKCodecUtils.java]", localStringBuilder.toString());
        int i = 0;
        while (i < localObject.length)
        {
          boolean bool = str2.equalsIgnoreCase(localObject[i]);
          if (bool) {
            return true;
          }
          i += 1;
        }
      }
      return false;
    }
    catch (Exception localException)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("isWhiteListForHdr10：");
      ((StringBuilder)localObject).append(localException.toString());
      TVKLogUtil.i("MediaPlayerMgr[TVKCodecUtils.java]", ((StringBuilder)localObject).toString());
    }
  }
  
  private static int maxLumaSamplesForAVCProfileLevel(int paramInt1, int paramInt2)
  {
    try
    {
      Object localObject1 = Class.forName("android.media.MediaCodecInfo$CodecProfileLevel");
      i = ((Integer)((Class)localObject1).getField("AVCLevel1").get(null)).intValue();
      int j = ((Integer)((Class)localObject1).getField("AVCLevel1b").get(null)).intValue();
      int k = ((Integer)((Class)localObject1).getField("AVCLevel11").get(null)).intValue();
      int m = ((Integer)((Class)localObject1).getField("AVCLevel12").get(null)).intValue();
      int n = ((Integer)((Class)localObject1).getField("AVCLevel13").get(null)).intValue();
      int i1 = ((Integer)((Class)localObject1).getField("AVCLevel2").get(null)).intValue();
      int i2 = ((Integer)((Class)localObject1).getField("AVCLevel21").get(null)).intValue();
      int i3 = ((Integer)((Class)localObject1).getField("AVCLevel22").get(null)).intValue();
      int i4 = ((Integer)((Class)localObject1).getField("AVCLevel3").get(null)).intValue();
      int i5 = ((Integer)((Class)localObject1).getField("AVCLevel31").get(null)).intValue();
      int i6 = ((Integer)((Class)localObject1).getField("AVCLevel32").get(null)).intValue();
      int i7 = ((Integer)((Class)localObject1).getField("AVCLevel4").get(null)).intValue();
      localObject3 = ((Class)localObject1).getField("AVCLevel41");
      try
      {
        int i8 = ((Integer)((Field)localObject3).get(null)).intValue();
        int i9 = ((Integer)((Class)localObject1).getField("AVCLevel42").get(null)).intValue();
        int i10 = ((Integer)((Class)localObject1).getField("AVCLevel5").get(null)).intValue();
        int i11 = ((Integer)((Class)localObject1).getField("AVCLevel51").get(null)).intValue();
        if (paramInt2 == i) {}
        while (paramInt2 == j)
        {
          i = 25344;
          break;
        }
        if (paramInt2 == k) {}
        do
        {
          do
          {
            i = 101376;
            break;
          } while (paramInt2 == m);
          while (paramInt2 == n) {}
        } while (paramInt2 == i1);
        if (paramInt2 == i2)
        {
          i = 202752;
        }
        else
        {
          if (paramInt2 == i3) {}
          do
          {
            do
            {
              i = 414720;
              break;
            } while (paramInt2 == i4);
            if (paramInt2 == i5)
            {
              i = 921600;
              break;
            }
            if (paramInt2 == i6)
            {
              i = 1310720;
              break;
            }
            if (paramInt2 == i7) {}
            while (paramInt2 == i8)
            {
              i = 2097152;
              break;
            }
            if (paramInt2 == i9)
            {
              i = 2228224;
              break;
            }
            if (paramInt2 == i10)
            {
              i = 5652480;
              break;
            }
          } while (paramInt2 < i11);
          i = 9437184;
        }
        localObject1 = "MediaPlayerMgr[TVKCodecUtils.java]";
      }
      catch (Exception localException1) {}
      localObject3 = "MediaPlayerMgr[TVKCodecUtils.java]";
    }
    catch (Exception localException2) {}
    TVKLogUtil.i((String)localObject3, "failed to get maxLumaSamples");
    TVKLogUtil.e((String)localObject3, localException2);
    int i = 414720;
    Object localObject2 = localObject3;
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("MaxLumaSamples : profile :");
    ((StringBuilder)localObject3).append(paramInt1);
    ((StringBuilder)localObject3).append(" , level :");
    ((StringBuilder)localObject3).append(paramInt2);
    ((StringBuilder)localObject3).append(" , maxSample : ");
    ((StringBuilder)localObject3).append(i);
    TVKLogUtil.i(localObject2, ((StringBuilder)localObject3).toString());
    return i;
  }
  
  private static int maxLumaSamplesForHEVCProfileLevel(int paramInt1, int paramInt2)
  {
    try
    {
      Object localObject1 = Class.forName("android.media.MediaCodecInfo$CodecProfileLevel");
      i = ((Integer)((Class)localObject1).getField("HEVCHighTierLevel1").get(null)).intValue();
      int j = ((Integer)((Class)localObject1).getField("HEVCHighTierLevel2").get(null)).intValue();
      int k = ((Integer)((Class)localObject1).getField("HEVCHighTierLevel21").get(null)).intValue();
      int m = ((Integer)((Class)localObject1).getField("HEVCHighTierLevel3").get(null)).intValue();
      int n = ((Integer)((Class)localObject1).getField("HEVCHighTierLevel31").get(null)).intValue();
      int i1 = ((Integer)((Class)localObject1).getField("HEVCHighTierLevel4").get(null)).intValue();
      int i2 = ((Integer)((Class)localObject1).getField("HEVCHighTierLevel41").get(null)).intValue();
      int i3 = ((Integer)((Class)localObject1).getField("HEVCHighTierLevel5").get(null)).intValue();
      int i4 = ((Integer)((Class)localObject1).getField("HEVCHighTierLevel51").get(null)).intValue();
      int i5 = ((Integer)((Class)localObject1).getField("HEVCHighTierLevel52").get(null)).intValue();
      int i6 = ((Integer)((Class)localObject1).getField("HEVCHighTierLevel6").get(null)).intValue();
      int i7 = ((Integer)((Class)localObject1).getField("HEVCHighTierLevel61").get(null)).intValue();
      localObject3 = ((Class)localObject1).getField("HEVCHighTierLevel62");
      try
      {
        int i8 = ((Integer)((Field)localObject3).get(null)).intValue();
        int i9 = ((Integer)((Class)localObject1).getField("HEVCMainTierLevel1").get(null)).intValue();
        int i10 = ((Integer)((Class)localObject1).getField("HEVCMainTierLevel2").get(null)).intValue();
        int i11 = ((Integer)((Class)localObject1).getField("HEVCMainTierLevel21").get(null)).intValue();
        int i12 = ((Integer)((Class)localObject1).getField("HEVCMainTierLevel3").get(null)).intValue();
        int i13 = ((Integer)((Class)localObject1).getField("HEVCMainTierLevel31").get(null)).intValue();
        int i14 = ((Integer)((Class)localObject1).getField("HEVCMainTierLevel4").get(null)).intValue();
        int i15 = ((Integer)((Class)localObject1).getField("HEVCMainTierLevel41").get(null)).intValue();
        int i16 = ((Integer)((Class)localObject1).getField("HEVCMainTierLevel5").get(null)).intValue();
        int i17 = ((Integer)((Class)localObject1).getField("HEVCMainTierLevel51").get(null)).intValue();
        int i18 = ((Integer)((Class)localObject1).getField("HEVCMainTierLevel52").get(null)).intValue();
        int i19 = ((Integer)((Class)localObject1).getField("HEVCMainTierLevel6").get(null)).intValue();
        int i20 = ((Integer)((Class)localObject1).getField("HEVCMainTierLevel61").get(null)).intValue();
        int i21 = ((Integer)((Class)localObject1).getField("HEVCMainTierLevel62").get(null)).intValue();
        if ((paramInt2 != i) && (paramInt2 != i9))
        {
          if ((paramInt2 != j) && (paramInt2 != i10))
          {
            if ((paramInt2 != k) && (paramInt2 != i11))
            {
              if ((paramInt2 != m) && (paramInt2 != i12)) {
                if ((paramInt2 != n) && (paramInt2 != i13))
                {
                  if ((paramInt2 != i1) && (paramInt2 != i14) && (paramInt2 != i2) && (paramInt2 != i15))
                  {
                    if ((paramInt2 != i3) && (paramInt2 != i16) && (paramInt2 != i4) && (paramInt2 != i17) && (paramInt2 != i5) && (paramInt2 != i18))
                    {
                      if ((paramInt2 == i6) || (paramInt2 == i19) || (paramInt2 >= i7) || (paramInt2 == i20) || (paramInt2 >= i8) || (paramInt2 == i21))
                      {
                        i = 35651584;
                        break label772;
                      }
                    }
                    else
                    {
                      i = 8912896;
                      break label772;
                    }
                  }
                  else
                  {
                    i = 2228224;
                    break label772;
                  }
                }
                else
                {
                  i = 983040;
                  break label772;
                }
              }
              i = 552960;
            }
            else
            {
              i = 245760;
            }
          }
          else {
            i = 122880;
          }
        }
        else {
          i = 36864;
        }
        label772:
        localObject1 = "MediaPlayerMgr[TVKCodecUtils.java]";
      }
      catch (Exception localException1) {}
      localObject3 = "MediaPlayerMgr[TVKCodecUtils.java]";
    }
    catch (Exception localException2) {}
    TVKLogUtil.i((String)localObject3, "failed to get maxLumaSamples");
    TVKLogUtil.e((String)localObject3, localException2);
    int i = 552960;
    Object localObject2 = localObject3;
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("HEVC MaxLumaSamples : profile :");
    ((StringBuilder)localObject3).append(paramInt1);
    ((StringBuilder)localObject3).append(" , level :");
    ((StringBuilder)localObject3).append(paramInt2);
    ((StringBuilder)localObject3).append(" , maxSample : ");
    ((StringBuilder)localObject3).append(i);
    TVKLogUtil.i(localObject2, ((StringBuilder)localObject3).toString());
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqlive.tvkplayer.playerwrapper.player.tools.TVKCodecUtils
 * JD-Core Version:    0.7.0.1
 */