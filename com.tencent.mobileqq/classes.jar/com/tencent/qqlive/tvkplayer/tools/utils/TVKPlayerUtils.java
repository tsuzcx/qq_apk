package com.tencent.qqlive.tvkplayer.tools.utils;

import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.qqlive.tvkplayer.playerwrapper.player.tools.TVKCodecUtils;
import com.tencent.qqlive.tvkplayer.tools.config.TVKConfigField;
import com.tencent.qqlive.tvkplayer.tools.config.TVKMediaPlayerConfig.PlayerConfig;
import com.tencent.qqlive.tvkplayer.vinfo.TVKPlayerVideoInfo;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class TVKPlayerUtils
{
  public static final String TAG = "MediaPlayerMgr[TVKPlayerUtils.java]";
  private static final List<String> oppoHevcBlackArrayList = Arrays.asList(new String[] { "OPPO A79", "OPPO A73", "OPPO A83", "OPPO A73t", "OPPO A79t", "OPPO A79k", "OPPO A79kt" });
  
  public static void addProxyExtraMapCdnPlay(TVKPlayerVideoInfo paramTVKPlayerVideoInfo)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("useProxy =");
    localStringBuilder.append(TVKMediaPlayerConfig.PlayerConfig.use_proxy.getValue());
    TVKLogUtil.i("MediaPlayerMgr[TVKPlayerUtils.java]", localStringBuilder.toString());
    if ((!((Boolean)TVKMediaPlayerConfig.PlayerConfig.use_proxy.getValue()).booleanValue()) && (!paramTVKPlayerVideoInfo.getExtraRequestParamsMap().containsKey("enableCdnPlay"))) {
      paramTVKPlayerVideoInfo.addProxyExtraMap("enableCdnPlay", String.valueOf(1));
    }
  }
  
  public static void addProxyExtraMapXmlSwitch(TVKPlayerVideoInfo paramTVKPlayerVideoInfo)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("is_use_p2p_parse_xml=");
    localStringBuilder.append(TVKMediaPlayerConfig.PlayerConfig.is_use_p2p_parse_xml.getValue());
    TVKLogUtil.i("MediaPlayerMgr[TVKPlayerUtils.java]", localStringBuilder.toString());
    if ((!((Boolean)TVKMediaPlayerConfig.PlayerConfig.is_use_p2p_parse_xml.getValue()).booleanValue()) && (!paramTVKPlayerVideoInfo.getExtraRequestParamsMap().containsKey("xmlparse"))) {
      paramTVKPlayerVideoInfo.addProxyExtraMap("xmlparse", String.valueOf(1));
    }
  }
  
  public static int dealHevcLv(TVKPlayerVideoInfo paramTVKPlayerVideoInfo, String paramString, boolean paramBoolean)
  {
    if (TVKUtils.optInt(paramTVKPlayerVideoInfo.getExtraRequestParamValue("hevclv", ""), 0) == 31) {
      return dealHevcLv2(paramTVKPlayerVideoInfo, paramString, paramBoolean);
    }
    int j = TVKUtils.optInt(paramTVKPlayerVideoInfo.getConfigMapValue("sysplayer_hevc_cap", ""), 0);
    if (1 == j)
    {
      i = 28;
    }
    else
    {
      i = j;
      if (2 == j) {
        i = 33;
      }
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[## hevc request], dealHevcLv:");
    localStringBuilder.append(i);
    TVKLogUtil.i("MediaPlayerMgr[TVKPlayerUtils.java]", localStringBuilder.toString());
    if (paramBoolean)
    {
      paramTVKPlayerVideoInfo.getExtraRequestParamsMap().remove("hevclv");
      return 0;
    }
    int i = getHevcLevel(paramString, i);
    if (i > 0)
    {
      paramTVKPlayerVideoInfo.addExtraRequestParamsMap("hevclv", String.valueOf(i));
      paramTVKPlayerVideoInfo = new StringBuilder();
      paramTVKPlayerVideoInfo.append("[## hevc request], getvinfoHevclv: ");
      paramTVKPlayerVideoInfo.append(i);
      TVKLogUtil.i("MediaPlayerMgr[TVKPlayerUtils.java]", paramTVKPlayerVideoInfo.toString());
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
    int k = 31;
    if (paramBoolean)
    {
      paramTVKPlayerVideoInfo.addExtraRequestParamsMap("hevclv", String.valueOf(31));
      return 0;
    }
    if ((!paramString.equalsIgnoreCase("uhd")) && (!paramString.equalsIgnoreCase("auto")))
    {
      int m = getDefnHevcLevel(paramString, 0);
      int i;
      if (m > 0) {
        i = 4;
      } else {
        i = 31;
      }
      if (i == 4)
      {
        j = k;
        if (TVKUtils.defLevelCompare((String)TVKMediaPlayerConfig.PlayerConfig.self_soft_hevc_definition.getValue(), paramString) < 0) {
          break label144;
        }
        if (m < ((Integer)TVKMediaPlayerConfig.PlayerConfig.self_soft_hevc_least_level.getValue()).intValue())
        {
          j = k;
          break label144;
        }
      }
      int j = i;
      label144:
      paramTVKPlayerVideoInfo.addExtraRequestParamsMap("hevclv", String.valueOf(j));
      if (j == 4) {
        return m;
      }
      return 0;
    }
    paramTVKPlayerVideoInfo.addExtraRequestParamsMap("hevclv", String.valueOf(31));
    return 31;
  }
  
  public static int dealHevcLvSync(TVKPlayerVideoInfo paramTVKPlayerVideoInfo, String paramString, boolean paramBoolean)
  {
    
    if (TVKUtils.optInt(paramTVKPlayerVideoInfo.getExtraRequestParamValue("hevclv", ""), 0) == 31) {
      return dealHevcLv2(paramTVKPlayerVideoInfo, paramString, paramBoolean);
    }
    int j = TVKUtils.optInt(paramTVKPlayerVideoInfo.getConfigMapValue("sysplayer_hevc_cap", ""), 0);
    if (1 == j)
    {
      i = 28;
    }
    else
    {
      i = j;
      if (2 == j) {
        i = 33;
      }
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[## hevc request], dealHevcLv:");
    localStringBuilder.append(i);
    TVKLogUtil.i("MediaPlayerMgr[TVKPlayerUtils.java]", localStringBuilder.toString());
    if (paramBoolean)
    {
      paramTVKPlayerVideoInfo.getExtraRequestParamsMap().remove("hevclv");
      return 0;
    }
    int i = getHevcLevel(paramString, i);
    if (i > 0)
    {
      paramTVKPlayerVideoInfo.addExtraRequestParamsMap("hevclv", String.valueOf(i));
      paramTVKPlayerVideoInfo = new StringBuilder();
      paramTVKPlayerVideoInfo.append("[## hevc request], getvinfoHevclv: ");
      paramTVKPlayerVideoInfo.append(i);
      TVKLogUtil.i("MediaPlayerMgr[TVKPlayerUtils.java]", paramTVKPlayerVideoInfo.toString());
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
      if (paramTVKPlayerVideoInfo.getExtraRequestParamsMap() != null)
      {
        paramTVKPlayerVideoInfo.getExtraRequestParamsMap().putAll((Map)localObject);
      }
      else
      {
        localObject = ((Map)localObject).entrySet().iterator();
        while (((Iterator)localObject).hasNext())
        {
          Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
          paramTVKPlayerVideoInfo.addExtraRequestParamsMap(localEntry.getKey().toString(), localEntry.getValue().toString());
        }
      }
      if (((Boolean)TVKMediaPlayerConfig.PlayerConfig.enable_dolby_preview.getValue()).booleanValue()) {
        paramTVKPlayerVideoInfo.addExtraRequestParamsMap("atime", String.valueOf(paramLong / 1000L));
      }
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
    if (((Boolean)TVKMediaPlayerConfig.PlayerConfig.hdcp_capability.getValue()).booleanValue()) {
      paramTVKPlayerVideoInfo.addExtraRequestParamsMap("hdcp", String.valueOf(1));
    }
  }
  
  public static int getDefnHevcLevel(String paramString, int paramInt)
  {
    paramInt = getHevcLevel(paramInt);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[## hevc Level], use hevc:");
    localStringBuilder.append(TVKMediaPlayerConfig.PlayerConfig.is_use_hevc.getValue());
    localStringBuilder.append(", def:");
    localStringBuilder.append(paramString);
    localStringBuilder.append(", defLevel:");
    localStringBuilder.append(TVKCodecUtils.getDefinitionLevel(paramString));
    localStringBuilder.append(", maxLevel:");
    localStringBuilder.append(paramInt);
    TVKLogUtil.i("MediaPlayerMgr[TVKPlayerUtils.java]", localStringBuilder.toString());
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
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
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
      paramString = new StringBuilder();
      paramString.append("[## hevc request], getvinfoHevclv: ");
      paramString.append(paramInt);
      TVKLogUtil.i("MediaPlayerMgr[TVKPlayerUtils.java]", paramString.toString());
    }
    else
    {
      localHashMap.remove("hevclv");
    }
    paramString = getExtraFixedRequestParam();
    if (paramString != null) {
      localHashMap.putAll(paramString);
    }
    return localHashMap;
  }
  
  /* Error */
  private static int getHevcLevel(int paramInt)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: iconst_0
    //   3: istore_1
    //   4: invokestatic 312	com/tencent/qqlive/tvkplayer/TVideoMgr:getApplicationContext	()Landroid/content/Context;
    //   7: invokestatic 318	com/tencent/qqlive/tvkplayer/playerwrapper/player/TVKPlayerStrategy:isSelfPlayerAvailable	(Landroid/content/Context;)Z
    //   10: ifne +5 -> 15
    //   13: iload_0
    //   14: ireturn
    //   15: invokestatic 312	com/tencent/qqlive/tvkplayer/TVideoMgr:getApplicationContext	()Landroid/content/Context;
    //   18: invokestatic 321	com/tencent/qqlive/tvkplayer/playerwrapper/player/TVKPlayerStrategy:isEnabledHWDec	(Landroid/content/Context;)Z
    //   21: ifeq +27 -> 48
    //   24: getstatic 324	com/tencent/qqlive/tvkplayer/tools/config/TVKMediaPlayerConfig$PlayerConfig:is_use_mediacodec	Lcom/tencent/qqlive/tvkplayer/tools/config/TVKConfigField;
    //   27: invokevirtual 64	com/tencent/qqlive/tvkplayer/tools/config/TVKConfigField:getValue	()Ljava/lang/Object;
    //   30: checkcast 79	java/lang/Boolean
    //   33: invokevirtual 83	java/lang/Boolean:booleanValue	()Z
    //   36: ifeq +12 -> 48
    //   39: invokestatic 327	com/tencent/qqlive/tvkplayer/playerwrapper/player/tools/TVKCodecUtils:getHevcHWDecLevel	()I
    //   42: istore_2
    //   43: iload_2
    //   44: istore_1
    //   45: goto +5 -> 50
    //   48: iconst_0
    //   49: istore_1
    //   50: invokestatic 330	com/tencent/qqlive/tvkplayer/playerwrapper/player/tools/TVKCodecUtils:getSoftCodecHevcLevel	()I
    //   53: istore_2
    //   54: ldc_w 332
    //   57: getstatic 335	com/tencent/qqlive/tvkplayer/tools/config/TVKMediaPlayerConfig$PlayerConfig:hevc_player	Lcom/tencent/qqlive/tvkplayer/tools/config/TVKConfigField;
    //   60: invokevirtual 64	com/tencent/qqlive/tvkplayer/tools/config/TVKConfigField:getValue	()Ljava/lang/Object;
    //   63: invokevirtual 338	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   66: istore 4
    //   68: iload 4
    //   70: ifeq +8 -> 78
    //   73: iload_3
    //   74: istore_1
    //   75: goto +59 -> 134
    //   78: goto +56 -> 134
    //   81: astore 5
    //   83: goto +12 -> 95
    //   86: astore 5
    //   88: goto +5 -> 93
    //   91: astore 5
    //   93: iconst_0
    //   94: istore_2
    //   95: new 45	java/lang/StringBuilder
    //   98: dup
    //   99: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   102: astore 6
    //   104: aload 6
    //   106: ldc_w 340
    //   109: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: pop
    //   113: aload 6
    //   115: aload 5
    //   117: invokevirtual 341	java/lang/Throwable:toString	()Ljava/lang/String;
    //   120: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   123: pop
    //   124: ldc 8
    //   126: aload 6
    //   128: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   131: invokestatic 77	com/tencent/qqlive/tvkplayer/tools/utils/TVKLogUtil:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   134: new 45	java/lang/StringBuilder
    //   137: dup
    //   138: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   141: astore 5
    //   143: aload 5
    //   145: ldc_w 343
    //   148: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   151: pop
    //   152: aload 5
    //   154: iload_2
    //   155: invokevirtual 141	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   158: pop
    //   159: aload 5
    //   161: ldc_w 345
    //   164: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   167: pop
    //   168: aload 5
    //   170: iload_1
    //   171: invokevirtual 141	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   174: pop
    //   175: aload 5
    //   177: ldc_w 347
    //   180: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   183: pop
    //   184: aload 5
    //   186: iload_0
    //   187: invokevirtual 141	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   190: pop
    //   191: ldc 8
    //   193: aload 5
    //   195: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   198: invokestatic 77	com/tencent/qqlive/tvkplayer/tools/utils/TVKLogUtil:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   201: iload_2
    //   202: iload_1
    //   203: iload_0
    //   204: invokestatic 351	com/tencent/qqlive/tvkplayer/tools/utils/TVKPlayerUtils:maxDevLevel	(III)I
    //   207: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	208	0	paramInt	int
    //   3	200	1	i	int
    //   42	160	2	j	int
    //   1	73	3	k	int
    //   66	3	4	bool	boolean
    //   81	1	5	localThrowable1	java.lang.Throwable
    //   86	1	5	localThrowable2	java.lang.Throwable
    //   91	25	5	localThrowable3	java.lang.Throwable
    //   141	53	5	localStringBuilder1	StringBuilder
    //   102	25	6	localStringBuilder2	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   54	68	81	java/lang/Throwable
    //   50	54	86	java/lang/Throwable
    //   4	13	91	java/lang/Throwable
    //   15	43	91	java/lang/Throwable
  }
  
  public static int getHevcLevel(String paramString, int paramInt)
  {
    if (((Boolean)TVKMediaPlayerConfig.PlayerConfig.first_use_hevclv_all.getValue()).booleanValue()) {
      paramInt = getDefnHevcLevel("", paramInt);
    } else {
      paramInt = getDefnHevcLevel(paramString, paramInt);
    }
    if (isHevcBlackList()) {
      return 0;
    }
    int i = paramInt;
    if (paramInt > 0)
    {
      i = paramInt;
      if (((Integer)TVKMediaPlayerConfig.PlayerConfig.hevclv.getValue()).intValue() > 0) {
        i = ((Integer)TVKMediaPlayerConfig.PlayerConfig.hevclv.getValue()).intValue();
      }
    }
    return i;
  }
  
  private static boolean isHevcBlackList()
  {
    try
    {
      boolean bool = Build.MODEL.equals("H9");
      if (((!bool) || (!Build.MANUFACTURER.equals("BBK"))) && ((!Build.MODEL.equals("H8S")) || (!Build.MANUFACTURER.equals("BBK"))))
      {
        bool = Build.MODEL.equals("K1");
        if (((!bool) || (!Build.MANUFACTURER.equals("OKii"))) && ((!Build.MODEL.equals("K2")) || (!Build.MANUFACTURER.equals("OKii"))))
        {
          bool = Build.MODEL.equals("Kids");
          if (((!bool) || (!Build.MANUFACTURER.equals("EEBBK"))) && ((!Build.MODEL.equals("S1")) || (!Build.MANUFACTURER.equals("EEBBK")))) {
            break label164;
          }
        }
      }
      if (Build.VERSION.RELEASE.equals("4.2.2")) {
        return true;
      }
      label164:
      if ((Build.MODEL.equals("MI PAD")) && (Build.MANUFACTURER.equals("Xiaomi")) && (Build.VERSION.RELEASE.equals("4.4.4"))) {
        return true;
      }
      if ((Build.MODEL.equals("VPad-A107")) && (Build.MANUFACTURER.equals("KTE"))) {
        return true;
      }
      if (Build.MANUFACTURER.equals("OPPO"))
      {
        bool = oppoHevcBlackArrayList.contains(Build.MODEL);
        if (bool) {
          return true;
        }
      }
    }
    catch (Exception localException)
    {
      TVKLogUtil.e("MediaPlayerMgr[TVKPlayerUtils.java]", localException);
    }
    return false;
  }
  
  private static int maxDevLevel(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 <= paramInt2) {
      paramInt1 = paramInt2;
    }
    if (paramInt1 > paramInt3) {
      return paramInt1;
    }
    return paramInt3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqlive.tvkplayer.tools.utils.TVKPlayerUtils
 * JD-Core Version:    0.7.0.1
 */