package com.tencent.qqlive.tvkplayer.tools.utils;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.qqlive.tvkplayer.TVideoMgr;
import com.tencent.qqlive.tvkplayer.playerwrapper.player.tools.TVKCodecUtils;
import com.tencent.qqlive.tvkplayer.tools.config.TVKConfigField;
import com.tencent.qqlive.tvkplayer.tools.config.TVKMediaPlayerConfig.PlayerConfig;
import com.tencent.qqlive.tvkplayer.vinfo.TVKPlayerVideoInfo;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class TVKPlayerUtils
{
  public static final String TAG = "MediaPlayerMgr[TVKPlayerUtils.java]";
  
  public static void addProxyExtraMapCdnPlay(TVKPlayerVideoInfo paramTVKPlayerVideoInfo)
  {
    TVKLogUtil.i("MediaPlayerMgr[TVKPlayerUtils.java]", "useProxy =" + TVKMediaPlayerConfig.PlayerConfig.use_proxy.getValue());
    if ((!((Boolean)TVKMediaPlayerConfig.PlayerConfig.use_proxy.getValue()).booleanValue()) && (!paramTVKPlayerVideoInfo.getExtraRequestParamsMap().containsKey("enableCdnPlay"))) {
      paramTVKPlayerVideoInfo.addProxyExtraMap("enableCdnPlay", String.valueOf(1));
    }
  }
  
  public static void addProxyExtraMapXmlSwitch(TVKPlayerVideoInfo paramTVKPlayerVideoInfo)
  {
    TVKLogUtil.i("MediaPlayerMgr[TVKPlayerUtils.java]", "is_use_p2p_parse_xml=" + TVKMediaPlayerConfig.PlayerConfig.is_use_p2p_parse_xml.getValue());
    if ((!((Boolean)TVKMediaPlayerConfig.PlayerConfig.is_use_p2p_parse_xml.getValue()).booleanValue()) && (!paramTVKPlayerVideoInfo.getExtraRequestParamsMap().containsKey("xmlparse"))) {
      paramTVKPlayerVideoInfo.addProxyExtraMap("xmlparse", String.valueOf(1));
    }
  }
  
  private static void dealHdrEnhanceParams(TVKPlayerVideoInfo paramTVKPlayerVideoInfo)
  {
    if ((((Boolean)TVKMediaPlayerConfig.PlayerConfig.hdr_enable.getValue()).booleanValue()) && (((Boolean)TVKMediaPlayerConfig.PlayerConfig.hdr_enhance_decode_enable.getValue()).booleanValue()))
    {
      if ((TVKCodecUtils.isBlackListForHdr10Enhance()) || (TVKCodecUtils.isBlackListForVidHdr10Enhance(paramTVKPlayerVideoInfo.getVid())) || (Build.VERSION.SDK_INT < 23))
      {
        i = TVKUtils.optInt(paramTVKPlayerVideoInfo.getExtraRequestParamValue("spvideo", String.valueOf(0)), 0) & 0x7F;
        paramTVKPlayerVideoInfo.getExtraRequestParamsMap().remove("spvideo");
        paramTVKPlayerVideoInfo.getExtraRequestParamsMap().put("spvideo", String.valueOf(i));
        TVKLogUtil.i("MediaPlayerMgr[TVKPlayerUtils.java]", "dealHdrEnhanceParams not support: spvideo=" + i);
      }
    }
    else {
      return;
    }
    int i = TVKUtils.optInt(paramTVKPlayerVideoInfo.getExtraRequestParamValue("spvideo", String.valueOf(0)), 0) | 0x80;
    paramTVKPlayerVideoInfo.getExtraRequestParamsMap().remove("spvideo");
    paramTVKPlayerVideoInfo.getExtraRequestParamsMap().put("spvideo", String.valueOf(i));
    TVKLogUtil.i("MediaPlayerMgr[TVKPlayerUtils.java]", "dealHdrEnhanceParams: spvideo=" + i);
  }
  
  public static int dealHevcLv(TVKPlayerVideoInfo paramTVKPlayerVideoInfo, String paramString, boolean paramBoolean)
  {
    if (TVKUtils.optInt(paramTVKPlayerVideoInfo.getExtraRequestParamValue("hevclv", ""), 0) == 31) {
      return dealHevcLv2(paramTVKPlayerVideoInfo, paramString, paramBoolean);
    }
    int j = TVKUtils.optInt(paramTVKPlayerVideoInfo.getConfigMapValue("sysplayer_hevc_cap", ""), 0);
    if (1 == j) {
      i = 28;
    }
    for (;;)
    {
      TVKLogUtil.i("MediaPlayerMgr[TVKPlayerUtils.java]", "[## hevc request], dealHevcLv:" + i);
      if (!paramBoolean) {
        break;
      }
      paramTVKPlayerVideoInfo.getExtraRequestParamsMap().remove("hevclv");
      return 0;
      i = j;
      if (2 == j) {
        i = 33;
      }
    }
    int i = getHevcLevel(paramString, i);
    if (i > 0)
    {
      paramTVKPlayerVideoInfo.addExtraRequestParamsMap("hevclv", String.valueOf(i));
      TVKLogUtil.i("MediaPlayerMgr[TVKPlayerUtils.java]", "[## hevc request], getvinfoHevclv: " + i);
      return i;
    }
    paramTVKPlayerVideoInfo.getExtraRequestParamsMap().remove("hevclv");
    TVKLogUtil.i("MediaPlayerMgr[TVKPlayerUtils.java]", "[## hevc request], getvinfoHevclv: no take");
    return i;
  }
  
  public static int dealHevcLv2(TVKPlayerVideoInfo paramTVKPlayerVideoInfo, String paramString, boolean paramBoolean)
  {
    if (8 == paramTVKPlayerVideoInfo.getPlayType())
    {
      TVKLogUtil.i("MediaPlayerMgr[TVKPlayerUtils.java]", "[## hevc request], loop vod, no take.");
      paramTVKPlayerVideoInfo.getExtraRequestParamsMap().remove("hevclv");
      return 0;
    }
    if (paramBoolean)
    {
      paramTVKPlayerVideoInfo.addExtraRequestParamsMap("hevclv", String.valueOf(31));
      return 0;
    }
    if ((paramString.equalsIgnoreCase("uhd")) || (paramString.equalsIgnoreCase("auto")))
    {
      paramTVKPlayerVideoInfo.addExtraRequestParamsMap("hevclv", String.valueOf(31));
      return 31;
    }
    int j = getDefnHevcLevel(paramString, 0);
    int i;
    if (j > 0)
    {
      i = 4;
      if ((i != 4) || ((TVKUtils.defLevelCompare((String)TVKMediaPlayerConfig.PlayerConfig.self_soft_hevc_definition.getValue(), paramString) >= 0) && (j >= ((Integer)TVKMediaPlayerConfig.PlayerConfig.self_soft_hevc_least_level.getValue()).intValue()))) {
        break label160;
      }
      i = 31;
    }
    label160:
    for (;;)
    {
      paramTVKPlayerVideoInfo.addExtraRequestParamsMap("hevclv", String.valueOf(i));
      if (i == 4)
      {
        return j;
        i = 31;
        break;
      }
      return 0;
    }
  }
  
  public static int dealHevcLvSync(TVKPlayerVideoInfo paramTVKPlayerVideoInfo, String paramString, boolean paramBoolean)
  {
    
    if (TVKUtils.optInt(paramTVKPlayerVideoInfo.getExtraRequestParamValue("hevclv", ""), 0) == 31) {
      return dealHevcLv2(paramTVKPlayerVideoInfo, paramString, paramBoolean);
    }
    int j = TVKUtils.optInt(paramTVKPlayerVideoInfo.getConfigMapValue("sysplayer_hevc_cap", ""), 0);
    if (1 == j) {
      i = 28;
    }
    for (;;)
    {
      TVKLogUtil.i("MediaPlayerMgr[TVKPlayerUtils.java]", "[## hevc request], dealHevcLv:" + i);
      if (!paramBoolean) {
        break;
      }
      paramTVKPlayerVideoInfo.getExtraRequestParamsMap().remove("hevclv");
      return 0;
      i = j;
      if (2 == j) {
        i = 33;
      }
    }
    int i = getHevcLevel(paramString, i);
    if (i > 0)
    {
      paramTVKPlayerVideoInfo.addExtraRequestParamsMap("hevclv", String.valueOf(i));
      TVKLogUtil.i("MediaPlayerMgr[TVKPlayerUtils.java]", "[## hevc request], getvinfoHevclv: " + i);
      return i;
    }
    paramTVKPlayerVideoInfo.getExtraRequestParamsMap().remove("hevclv");
    TVKLogUtil.i("MediaPlayerMgr[TVKPlayerUtils.java]", "[## hevc request], getvinfoHevclv: no take");
    return i;
  }
  
  public static void dealRequestParams(TVKPlayerVideoInfo paramTVKPlayerVideoInfo, String paramString, long paramLong)
  {
    if (paramTVKPlayerVideoInfo == null) {
      return;
    }
    Object localObject = getExtraFixedRequestParam();
    if (localObject != null)
    {
      if (paramTVKPlayerVideoInfo.getExtraRequestParamsMap() == null) {
        break label172;
      }
      paramTVKPlayerVideoInfo.getExtraRequestParamsMap().putAll((Map)localObject);
    }
    for (;;)
    {
      if (((Boolean)TVKMediaPlayerConfig.PlayerConfig.enable_dolby_preview.getValue()).booleanValue()) {
        paramTVKPlayerVideoInfo.addExtraRequestParamsMap("atime", String.valueOf(paramLong / 1000L));
      }
      if (((Boolean)TVKMediaPlayerConfig.PlayerConfig.is_support_mutli_audiotrack.getValue()).booleanValue())
      {
        paramTVKPlayerVideoInfo.addExtraRequestParamsMap("spau", String.valueOf(1));
        if (!TextUtils.isEmpty(paramString))
        {
          paramTVKPlayerVideoInfo.addExtraRequestParamsMap("atime", String.valueOf(paramLong / 1000L));
          paramTVKPlayerVideoInfo.addExtraRequestParamsMap("track", paramString);
        }
      }
      if (paramTVKPlayerVideoInfo.configMapContainsKey("vinfo_key_previd")) {
        paramTVKPlayerVideoInfo.addExtraRequestParamsMap("previd", paramTVKPlayerVideoInfo.getConfigMapValue("vinfo_key_previd", ""));
      }
      addProxyExtraMapCdnPlay(paramTVKPlayerVideoInfo);
      addProxyExtraMapXmlSwitch(paramTVKPlayerVideoInfo);
      if (!((Boolean)TVKMediaPlayerConfig.PlayerConfig.hdcp_capability.getValue()).booleanValue()) {
        break;
      }
      paramTVKPlayerVideoInfo.addExtraRequestParamsMap("hdcp", String.valueOf(1));
      return;
      label172:
      localObject = ((Map)localObject).entrySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
        paramTVKPlayerVideoInfo.addExtraRequestParamsMap(localEntry.getKey().toString(), localEntry.getValue().toString());
      }
    }
  }
  
  public static int getDefnHevcLevel(String paramString, int paramInt)
  {
    paramInt = getHevcLevel(paramInt);
    TVKLogUtil.i("MediaPlayerMgr[TVKPlayerUtils.java]", "[## hevc Level], use hevc:" + TVKMediaPlayerConfig.PlayerConfig.is_use_hevc.getValue() + ", def:" + paramString + ", defLevel:" + TVKCodecUtils.getDefinitionLevel(paramString) + ", maxLevel:" + paramInt);
    if (!((Boolean)TVKMediaPlayerConfig.PlayerConfig.is_use_hevc.getValue()).booleanValue()) {
      return -1;
    }
    if (TextUtils.isEmpty(paramString))
    {
      if (paramInt > 0) {
        return paramInt;
      }
      return -1;
    }
    if (paramInt >= TVKCodecUtils.getDefinitionLevel(paramString)) {
      return paramInt;
    }
    return -1;
  }
  
  public static Map<String, String> getExtraFixedRequestParam()
  {
    HashMap localHashMap = new HashMap();
    if (((Boolean)TVKMediaPlayerConfig.PlayerConfig.is_only_audio_support.getValue()).booleanValue()) {}
    for (int i = 1;; i = 0)
    {
      int j = i;
      if (((Boolean)TVKMediaPlayerConfig.PlayerConfig.is_support_dolby_audio.getValue()).booleanValue()) {
        j = i | 0x2 | 0x4 | 0x8;
      }
      localHashMap.put("spaudio", String.valueOf(j));
      localHashMap.put("spwm", String.valueOf(2));
      try
      {
        Object localObject = TVideoMgr.getPlayerVersion();
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          localObject = ((String)localObject).split("[.]");
          if ((localObject != null) && (localObject.length > 0)) {
            localHashMap.put("incver", localObject[(localObject.length - 1)]);
          }
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          TVKLogUtil.e("MediaPlayerMgr[TVKPlayerUtils.java]", localException.toString());
        }
        localHashMap.put("defnpayver", "1");
      }
      if (((Boolean)TVKMediaPlayerConfig.PlayerConfig.is_use_subtitle.getValue()).booleanValue()) {
        localHashMap.put("spsrt", "1");
      }
      if (!((Boolean)TVKMediaPlayerConfig.PlayerConfig.is_support_dolby_vision.getValue()).booleanValue()) {
        break;
      }
      localHashMap.put("defnpayver", "5");
      return localHashMap;
    }
    return localHashMap;
  }
  
  public static Map<String, String> getExtraRequestParamsMap(String paramString, int paramInt)
  {
    HashMap localHashMap = new HashMap();
    int i = paramInt;
    if (paramInt > 0) {
      i = 28;
    }
    paramInt = getHevcLevel(paramString, i);
    if (paramInt > 0)
    {
      localHashMap.put("hevclv", String.valueOf(paramInt));
      TVKLogUtil.i("MediaPlayerMgr[TVKPlayerUtils.java]", "[## hevc request], getvinfoHevclv: " + paramInt);
    }
    for (;;)
    {
      paramString = getExtraFixedRequestParam();
      if (paramString != null) {
        localHashMap.putAll(paramString);
      }
      return localHashMap;
      localHashMap.remove("hevclv");
    }
  }
  
  /* Error */
  private static int getHevcLevel(int paramInt)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: invokestatic 346	com/tencent/qqlive/tvkplayer/TVideoMgr:getApplicationContext	()Landroid/content/Context;
    //   5: invokestatic 352	com/tencent/qqlive/tvkplayer/playerwrapper/player/TVKPlayerStrategy:isSelfPlayerAvailable	(Landroid/content/Context;)Z
    //   8: ifne +5 -> 13
    //   11: iload_0
    //   12: ireturn
    //   13: invokestatic 346	com/tencent/qqlive/tvkplayer/TVideoMgr:getApplicationContext	()Landroid/content/Context;
    //   16: invokestatic 355	com/tencent/qqlive/tvkplayer/playerwrapper/player/TVKPlayerStrategy:isEnabledHWDec	(Landroid/content/Context;)Z
    //   19: ifeq +99 -> 118
    //   22: getstatic 358	com/tencent/qqlive/tvkplayer/tools/config/TVKMediaPlayerConfig$PlayerConfig:is_use_mediacodec	Lcom/tencent/qqlive/tvkplayer/tools/config/TVKConfigField;
    //   25: invokevirtual 36	com/tencent/qqlive/tvkplayer/tools/config/TVKConfigField:getValue	()Ljava/lang/Object;
    //   28: checkcast 51	java/lang/Boolean
    //   31: invokevirtual 55	java/lang/Boolean:booleanValue	()Z
    //   34: ifeq +84 -> 118
    //   37: invokestatic 361	com/tencent/qqlive/tvkplayer/playerwrapper/player/tools/TVKCodecUtils:getHevcHWDecLevel	()I
    //   40: istore_1
    //   41: invokestatic 364	com/tencent/qqlive/tvkplayer/playerwrapper/player/tools/TVKCodecUtils:getSoftCodecHevcLevel	()I
    //   44: istore_2
    //   45: ldc_w 366
    //   48: getstatic 369	com/tencent/qqlive/tvkplayer/tools/config/TVKMediaPlayerConfig$PlayerConfig:hevc_player	Lcom/tencent/qqlive/tvkplayer/tools/config/TVKConfigField;
    //   51: invokevirtual 36	com/tencent/qqlive/tvkplayer/tools/config/TVKConfigField:getValue	()Ljava/lang/Object;
    //   54: invokevirtual 372	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   57: istore 4
    //   59: iload 4
    //   61: ifeq +5 -> 66
    //   64: iconst_0
    //   65: istore_1
    //   66: ldc 8
    //   68: new 17	java/lang/StringBuilder
    //   71: dup
    //   72: invokespecial 18	java/lang/StringBuilder:<init>	()V
    //   75: ldc_w 374
    //   78: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: iload_2
    //   82: invokevirtual 136	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   85: ldc_w 376
    //   88: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: iload_1
    //   92: invokevirtual 136	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   95: ldc_w 378
    //   98: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: iload_0
    //   102: invokevirtual 136	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   105: invokevirtual 43	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   108: invokestatic 49	com/tencent/qqlive/tvkplayer/tools/utils/TVKLogUtil:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   111: iload_2
    //   112: iload_1
    //   113: iload_0
    //   114: invokestatic 382	com/tencent/qqlive/tvkplayer/tools/utils/TVKPlayerUtils:maxDevLevel	(III)I
    //   117: ireturn
    //   118: iconst_0
    //   119: istore_1
    //   120: goto -79 -> 41
    //   123: astore 5
    //   125: iconst_0
    //   126: istore_1
    //   127: iload_3
    //   128: istore_2
    //   129: ldc 8
    //   131: new 17	java/lang/StringBuilder
    //   134: dup
    //   135: invokespecial 18	java/lang/StringBuilder:<init>	()V
    //   138: ldc_w 384
    //   141: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   144: aload 5
    //   146: invokevirtual 385	java/lang/Throwable:toString	()Ljava/lang/String;
    //   149: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   152: invokevirtual 43	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   155: invokestatic 49	com/tencent/qqlive/tvkplayer/tools/utils/TVKLogUtil:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   158: goto -92 -> 66
    //   161: astore 5
    //   163: iload_3
    //   164: istore_2
    //   165: goto -36 -> 129
    //   168: astore 5
    //   170: goto -41 -> 129
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	173	0	paramInt	int
    //   40	87	1	i	int
    //   44	121	2	j	int
    //   1	163	3	k	int
    //   57	3	4	bool	boolean
    //   123	22	5	localThrowable1	java.lang.Throwable
    //   161	1	5	localThrowable2	java.lang.Throwable
    //   168	1	5	localThrowable3	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   2	11	123	java/lang/Throwable
    //   13	41	123	java/lang/Throwable
    //   41	45	161	java/lang/Throwable
    //   45	59	168	java/lang/Throwable
  }
  
  public static int getHevcLevel(String paramString, int paramInt)
  {
    int i;
    if (((Boolean)TVKMediaPlayerConfig.PlayerConfig.first_use_hevclv_all.getValue()).booleanValue())
    {
      paramInt = getDefnHevcLevel("", paramInt);
      if (!isHevcBlackList()) {
        break label41;
      }
      i = 0;
    }
    label41:
    do
    {
      do
      {
        return i;
        paramInt = getDefnHevcLevel(paramString, paramInt);
        break;
        i = paramInt;
      } while (paramInt <= 0);
      i = paramInt;
    } while (((Integer)TVKMediaPlayerConfig.PlayerConfig.hevclv.getValue()).intValue() <= 0);
    return ((Integer)TVKMediaPlayerConfig.PlayerConfig.hevclv.getValue()).intValue();
  }
  
  private static boolean isHevcBlackList()
  {
    try
    {
      if (((Build.MODEL.equals("H9")) && (Build.MANUFACTURER.equals("BBK"))) || ((Build.MODEL.equals("H8S")) && (Build.MANUFACTURER.equals("BBK"))) || ((Build.MODEL.equals("K1")) && (Build.MANUFACTURER.equals("OKii"))) || ((Build.MODEL.equals("K2")) && (Build.MANUFACTURER.equals("OKii"))) || ((Build.MODEL.equals("Kids")) && (Build.MANUFACTURER.equals("EEBBK"))) || ((Build.MODEL.equals("S1")) && (Build.MANUFACTURER.equals("EEBBK")) && (Build.VERSION.RELEASE.equals("4.2.2")))) {
        return true;
      }
      if (((Build.MODEL.equals("MI PAD")) && (Build.MANUFACTURER.equals("Xiaomi")) && (Build.VERSION.RELEASE.equals("4.4.4"))) || ((Build.MODEL.equals("VPad-A107")) && (Build.MANUFACTURER.equals("KTE")))) {
        break label322;
      }
      if (Build.MANUFACTURER.equals("OPPO"))
      {
        if ((Build.MODEL.equals("OPPO A79")) || (Build.MODEL.equals("OPPO A73")) || (Build.MODEL.equals("OPPO A83")) || (Build.MODEL.equals("OPPO A73t")) || (Build.MODEL.equals("OPPO A79t")) || (Build.MODEL.equals("OPPO A79k"))) {
          break label322;
        }
        boolean bool = Build.MODEL.equals("OPPO A79kt");
        if (bool) {
          break label322;
        }
      }
    }
    catch (Exception localException)
    {
      label316:
      break label316;
    }
    return false;
    label322:
    return true;
  }
  
  public static boolean isValidForInParam(Context paramContext, TVKPlayerVideoInfo paramTVKPlayerVideoInfo)
  {
    if (paramTVKPlayerVideoInfo == null)
    {
      TVKLogUtil.e("MediaPlayerMgr[TVKPlayerUtils.java]", "isValidForInParam ,videoInfo is null");
      return false;
    }
    if (paramContext == null)
    {
      TVKLogUtil.e("MediaPlayerMgr[TVKPlayerUtils.java]", "isValidForInParam ,context is null");
      return false;
    }
    if (((TextUtils.isEmpty(paramTVKPlayerVideoInfo.getVid())) && (TextUtils.isEmpty(paramTVKPlayerVideoInfo.getConfigMapValue("vinfo_key_previd", "")))) || (paramTVKPlayerVideoInfo.getPlayType() < 1) || (paramTVKPlayerVideoInfo.getPlayType() > 8))
    {
      TVKLogUtil.e("MediaPlayerMgr[TVKPlayerUtils.java]", "isValidForInParam , vid is empty or type wrong,vid: " + paramTVKPlayerVideoInfo.getVid() + ", previd: " + paramTVKPlayerVideoInfo.getConfigMapValue("vinfo_key_previd", "") + ",type: " + paramTVKPlayerVideoInfo.getPlayType());
      return false;
    }
    return true;
  }
  
  private static int maxDevLevel(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 > paramInt2) {}
    for (;;)
    {
      paramInt2 = paramInt3;
      if (paramInt1 > paramInt3) {
        paramInt2 = paramInt1;
      }
      return paramInt2;
      paramInt1 = paramInt2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqlive.tvkplayer.tools.utils.TVKPlayerUtils
 * JD-Core Version:    0.7.0.1
 */