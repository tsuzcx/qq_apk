package com.tencent.qqlive.tvkplayer.vinfo;

import android.text.TextUtils;
import com.tencent.qqlive.tvkplayer.TVideoMgr;
import com.tencent.qqlive.tvkplayer.tools.config.TVKConfigField;
import com.tencent.qqlive.tvkplayer.tools.config.TVKMediaPlayerConfig.PlayerConfig;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKLogUtil;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKPlayerUtils;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class TVKPlayerWrapperHelper$PlayerVideoInfoHelper
{
  private static Map<String, String> mGetVInfoKeyMap;
  
  static
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("vinfo_key_previd", "previd");
    localHashMap.put("vinfo_key_toushe", "toushe");
    localHashMap.put("vinfo_key_from_platform", "from_platform");
    localHashMap.put("vinfo_key_sptest", "sptest");
    localHashMap.put("vinfo_key_drm", "drm");
    localHashMap.put("vinfo_key_spvideo", "spvideo");
    localHashMap.put("vinfo_key_spaudio", "spaudio");
    mGetVInfoKeyMap = Collections.unmodifiableMap(localHashMap);
  }
  
  static void configVideoInfoHEVCLevel(TVKPlayerVideoInfo paramTVKPlayerVideoInfo, String paramString, boolean paramBoolean)
  {
    TVKPlayerUtils.dealHevcLv(paramTVKPlayerVideoInfo, paramString, paramBoolean ^ true);
  }
  
  static void configVideoInfoMapToExtralMap(TVKPlayerVideoInfo paramTVKPlayerVideoInfo)
  {
    if (paramTVKPlayerVideoInfo == null) {
      return;
    }
    Map localMap = paramTVKPlayerVideoInfo.getConfigMap();
    Object localObject = paramTVKPlayerVideoInfo.getExtraRequestParamsMap();
    if (localMap != null)
    {
      if (localMap.isEmpty()) {
        return;
      }
      paramTVKPlayerVideoInfo = (TVKPlayerVideoInfo)localObject;
      if (localObject == null) {
        paramTVKPlayerVideoInfo = new HashMap();
      }
      localObject = new HashSet();
      ((Set)localObject).addAll(mGetVInfoKeyMap.keySet());
      ((Set)localObject).retainAll(localMap.keySet());
      localObject = ((Set)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        paramTVKPlayerVideoInfo.put(mGetVInfoKeyMap.get(str), localMap.get(str));
      }
    }
  }
  
  static void configVideoInfoVersion(TVKPlayerVideoInfo paramTVKPlayerVideoInfo)
  {
    Object localObject = TVideoMgr.getPlayerVersion();
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = ((String)localObject).split("[.]");
      if (localObject.length > 0) {
        paramTVKPlayerVideoInfo.addExtraRequestParamsMap("incver", localObject[(localObject.length - 1)]);
      }
    }
  }
  
  private static void dumpMap(String paramString, Map<String, String> paramMap)
  {
    paramString = new StringBuilder(paramString);
    paramString.append("(");
    if (paramMap != null)
    {
      paramMap = paramMap.entrySet().iterator();
      while (paramMap.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramMap.next();
        paramString.append("[");
        paramString.append((String)localEntry.getKey());
        paramString.append("]");
        paramString.append("=");
        paramString.append("[");
        paramString.append((String)localEntry.getValue());
        paramString.append("]&");
      }
    }
    paramString.append("null");
    paramString.append(")");
    int m = paramString.length();
    int i = 0;
    while (i < m / 1024 + 1)
    {
      int n = i * 1024;
      int k = m - n;
      int j = k;
      if (k >= 1024) {
        j = 1024;
      }
      TVKLogUtil.i("TVKPlayer[TVKPlayerWrapper]", paramString.substring(n, j + n));
      i += 1;
    }
  }
  
  static void dumpVideoInfo(TVKPlayerVideoInfo paramTVKPlayerVideoInfo)
  {
    if (paramTVKPlayerVideoInfo == null) {
      return;
    }
    dumpMap("### ConfigMap:", paramTVKPlayerVideoInfo.getConfigMap());
    dumpMap("### ExtraRequestParamsMap:", paramTVKPlayerVideoInfo.getExtraRequestParamsMap());
    dumpMap("### ReportInfoMap:", paramTVKPlayerVideoInfo.getReportInfoMap());
    dumpMap("### AdReportInfo:", paramTVKPlayerVideoInfo.getAdReportInfoMap());
    dumpMap("### ProxyExtra:", paramTVKPlayerVideoInfo.getProxyExtraMap());
    dumpMap("### AdRequestParamMap:", paramTVKPlayerVideoInfo.getAdRequestParamMap());
  }
  
  static void videoInfoConfigDefinition(TVKPlaybackParam paramTVKPlaybackParam, TVKPlaybackInfo paramTVKPlaybackInfo)
  {
    if (paramTVKPlaybackParam == null) {
      return;
    }
    if (paramTVKPlaybackInfo == null) {
      return;
    }
    if (paramTVKPlaybackParam.videoInfo() == null) {
      return;
    }
    String str2 = (String)TVKMediaPlayerConfig.PlayerConfig.force_definition.getValue();
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    str2 = paramTVKPlaybackInfo.requestInfo().definition();
    if ((!TextUtils.isEmpty(str1)) && (TVKUtils.defLevelCompare(str2, str1) > 0))
    {
      paramTVKPlaybackInfo.requestInfo().definition(str1);
      paramTVKPlaybackParam.definition(str1);
      return;
    }
    if (TextUtils.isEmpty(str2))
    {
      paramTVKPlaybackParam.definition(str2);
      return;
    }
    int i = paramTVKPlaybackParam.videoInfo().getPlayType();
    int j = 0;
    if (i == 2) {
      i = 1;
    } else {
      i = 0;
    }
    if (i == 0)
    {
      i = j;
      if (paramTVKPlaybackParam.videoInfo().getPlayType() != 3) {}
    }
    else
    {
      i = 1;
    }
    if ((i != 0) && (str2.equalsIgnoreCase("hd")) && (paramTVKPlaybackInfo.requestInfo().formatId() == 1))
    {
      paramTVKPlaybackInfo.requestInfo().definition("mp4");
      paramTVKPlaybackParam.definition("mp4");
    }
  }
  
  static void videoInfoConfigSubtitle(TVKPlayerVideoInfo paramTVKPlayerVideoInfo)
  {
    if (((Boolean)TVKMediaPlayerConfig.PlayerConfig.is_use_subtitle.getValue()).booleanValue()) {
      paramTVKPlayerVideoInfo.addExtraRequestParamsMap("spsrt", "1");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqlive.tvkplayer.vinfo.TVKPlayerWrapperHelper.PlayerVideoInfoHelper
 * JD-Core Version:    0.7.0.1
 */