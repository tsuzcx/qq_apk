package com.tencent.thumbplayer.datatransport;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.thumbplayer.api.proxy.TPDownloadParamData;
import com.tencent.thumbplayer.config.TPPlayerConfig;
import com.tencent.thumbplayer.core.downloadproxy.api.TPDLProxyInitParam;
import com.tencent.thumbplayer.core.downloadproxy.api.TPDownloadParam;
import com.tencent.thumbplayer.utils.TPCommonUtils;
import com.tencent.thumbplayer.utils.TPLogUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class TPProxyUtils
{
  public static final String PROXY_SO_NAME = "DownloadProxy";
  public static final String TAG = "TPProxyUtils";
  
  public static TPDownloadParam convertProxyDownloadParams(String paramString, TPDownloadParamData paramTPDownloadParamData, Map<String, String> paramMap)
  {
    if (paramTPDownloadParamData != null)
    {
      Object localObject1 = new ArrayList();
      Object localObject2;
      if ((paramTPDownloadParamData.getUrlCdnidList() != null) && (!paramTPDownloadParamData.getUrlCdnidList().isEmpty()))
      {
        paramString = paramTPDownloadParamData.getUrlCdnidList();
      }
      else
      {
        if (!TextUtils.isEmpty(paramString)) {
          ((ArrayList)localObject1).add(paramString);
        } else {
          ((ArrayList)localObject1).add(paramTPDownloadParamData.url);
        }
        localObject2 = paramTPDownloadParamData.getBakUrl();
        paramString = (String)localObject1;
        if (localObject2 != null)
        {
          paramString = (String)localObject1;
          if (localObject2.length > 0)
          {
            int i = 0;
            for (;;)
            {
              paramString = (String)localObject1;
              if (i >= localObject2.length) {
                break;
              }
              if (!TextUtils.isEmpty(localObject2[i])) {
                ((ArrayList)localObject1).add(localObject2[i]);
              }
              i += 1;
            }
          }
        }
      }
      localObject1 = new HashMap();
      if (!TextUtils.isEmpty(paramTPDownloadParamData.getFlowId()))
      {
        TPLogUtil.i("TPProxyUtils", paramTPDownloadParamData.getFlowId());
        ((Map)localObject1).put("dl_param_play_flowid", paramTPDownloadParamData.getFlowId());
      }
      if (!TPCommonUtils.isEmpty(paramTPDownloadParamData.getUrlHostList())) {
        ((Map)localObject1).put("dl_param_url_host", paramTPDownloadParamData.getUrlHostList());
      }
      if (!TPCommonUtils.isEmpty(paramTPDownloadParamData.getUrlCookieList())) {
        ((Map)localObject1).put("dl_param_url_cookie", paramTPDownloadParamData.getUrlCookieList());
      }
      if (paramTPDownloadParamData.getUrlExpireTime() > 0) {
        ((Map)localObject1).put("dl_param_url_expire_time", Integer.valueOf(paramTPDownloadParamData.getUrlExpireTime()));
      }
      if (paramTPDownloadParamData.getFileSize() > 0L) {
        ((Map)localObject1).put("dl_param_file_size", Long.valueOf(paramTPDownloadParamData.getFileSize()));
      }
      if (paramTPDownloadParamData.getFileDuration() > 0L) {
        ((Map)localObject1).put("dl_param_file_duration", Long.valueOf(paramTPDownloadParamData.getFileDuration()));
      }
      if (!TextUtils.isEmpty(paramTPDownloadParamData.getDownloadFileID())) {
        ((Map)localObject1).put("dl_param_play_keyid", paramTPDownloadParamData.getDownloadFileID());
      }
      if (!TextUtils.isEmpty(paramTPDownloadParamData.getVid())) {
        ((Map)localObject1).put("dl_param_vid", paramTPDownloadParamData.getVid());
      }
      if (!TextUtils.isEmpty(paramTPDownloadParamData.getPlayDefinition()))
      {
        ((Map)localObject1).put("dl_param_play_definition", paramTPDownloadParamData.getPlayDefinition());
        ((Map)localObject1).put("dl_param_current_format", paramTPDownloadParamData.getPlayDefinition());
      }
      if (paramTPDownloadParamData.getCurrentFormatID() > 0) {
        ((Map)localObject1).put("dl_param_current_formatid", Integer.valueOf(paramTPDownloadParamData.getCurrentFormatID()));
      }
      if (!TPCommonUtils.isEmpty(paramTPDownloadParamData.getFormatInfo())) {
        ((Map)localObject1).put("dl_param_format_info", paramTPDownloadParamData.getFormatInfo());
      }
      ((Map)localObject1).put("dl_param_source_is_charge", Boolean.valueOf(paramTPDownloadParamData.isCharge()));
      ((Map)localObject1).put("dl_param_cache_need_encrypt", Boolean.valueOf(paramTPDownloadParamData.isNeedEncryptCache()));
      ((Map)localObject1).put("dl_param_is_offline", Boolean.valueOf(paramTPDownloadParamData.isOffline()));
      ((Map)localObject1).put("dl_param_enable_expand_donwload_url", Boolean.valueOf(paramTPDownloadParamData.isExtraParam()));
      if (paramMap != null)
      {
        localObject2 = new ArrayList();
        ((ArrayList)localObject2).add(paramMap);
        ((Map)localObject1).put("dl_param_url_header", localObject2);
      }
      if (paramTPDownloadParamData.getPreloadSize() > 0L) {
        ((Map)localObject1).put("dl_param_preload_size", Long.valueOf(paramTPDownloadParamData.getPreloadSize()));
      }
      if (paramTPDownloadParamData.getPreloadDuration() > 0L) {
        ((Map)localObject1).put("dl_param_preload_duration", Long.valueOf(paramTPDownloadParamData.getPreloadDuration()));
      }
      if (!TextUtils.isEmpty(paramTPDownloadParamData.getSavePath())) {
        ((Map)localObject1).put("dl_param_save_path", paramTPDownloadParamData.getSavePath());
      }
      if (paramTPDownloadParamData.getStarTimeMS() > 0) {
        ((Map)localObject1).put("dl_param_play_start_time", Integer.valueOf(paramTPDownloadParamData.getStarTimeMS()));
      }
      if (paramTPDownloadParamData.getEndTimeMS() > 0) {
        ((Map)localObject1).put("dl_param_play_end_time", Integer.valueOf(paramTPDownloadParamData.getEndTimeMS()));
      }
      if (paramTPDownloadParamData.getClipCount() > 0) {
        ((Map)localObject1).put("dl_param_play_clip_count", Integer.valueOf(paramTPDownloadParamData.getClipCount()));
      }
      if (paramTPDownloadParamData.getClipNo() > 0) {
        ((Map)localObject1).put("dl_param_play_clip_no", Integer.valueOf(paramTPDownloadParamData.getClipNo()));
      }
      if (!TextUtils.isEmpty(paramTPDownloadParamData.getBase())) {
        ((Map)localObject1).put("dl_param_vinfo_base", paramTPDownloadParamData.getBase());
      }
      if (!TextUtils.isEmpty(paramTPDownloadParamData.getLinkVid())) {
        ((Map)localObject1).put("dl_param_vinfo_link_vid", paramTPDownloadParamData.getLinkVid());
      }
      if (!TextUtils.isEmpty(paramTPDownloadParamData.getFileMD5())) {
        ((Map)localObject1).put("dl_param_file_md5", paramTPDownloadParamData.getFileMD5());
      }
      if (!TextUtils.isEmpty(paramTPDownloadParamData.getM3u8())) {
        ((Map)localObject1).put("dl_param_vinfo_m3u8", paramTPDownloadParamData.getM3u8());
      }
      if (paramTPDownloadParamData.getTm() > 0L) {
        ((Map)localObject1).put("dl_param_vinfo_tm", Long.valueOf(paramTPDownloadParamData.getTm()));
      }
      if (!TextUtils.isEmpty(paramTPDownloadParamData.getNonce()))
      {
        paramMap = new StringBuilder();
        paramMap.append("nonce:");
        paramMap.append(paramTPDownloadParamData.getNonce());
        TPLogUtil.i("TPProxyUtils", paramMap.toString());
        ((Map)localObject1).put("dl_param_nonce", paramTPDownloadParamData.getNonce());
      }
      if (!TextUtils.isEmpty(paramTPDownloadParamData.getDecKey()))
      {
        paramMap = new StringBuilder();
        paramMap.append("encrypt stream key:");
        paramMap.append(paramTPDownloadParamData.getDecKey());
        TPLogUtil.i("TPProxyUtils", paramMap.toString());
        ((Map)localObject1).put("dl_param_encrypt_stream_key", paramTPDownloadParamData.getDecKey());
      }
      if (!TextUtils.isEmpty(paramTPDownloadParamData.getRandoms()))
      {
        paramMap = new StringBuilder();
        paramMap.append("encrypt randoms:");
        paramMap.append(paramTPDownloadParamData.getRandoms());
        TPLogUtil.i("TPProxyUtils", paramMap.toString());
        ((Map)localObject1).put("dl_param_encrypt_stream_randoms", paramTPDownloadParamData.getRandoms());
      }
      if (paramTPDownloadParamData.getFp2p() > 0) {
        ((Map)localObject1).put("dl_param_vinfo_fp2p", Integer.valueOf(paramTPDownloadParamData.getFp2p()));
      }
      if (paramTPDownloadParamData.getTestid() > 0) {
        ((Map)localObject1).put("dl_param_vinfo_testid", Integer.valueOf(paramTPDownloadParamData.getTestid()));
      }
      if (paramTPDownloadParamData.getExceptDelay() > 0) {
        ((Map)localObject1).put("dl_param_expect_delay_time", Integer.valueOf(paramTPDownloadParamData.getExceptDelay()));
      }
      if (!TPCommonUtils.isEmpty(paramTPDownloadParamData.getExtInfoMap())) {
        ((Map)localObject1).putAll(paramTPDownloadParamData.getExtInfoMap());
      }
      if (paramTPDownloadParamData.getSelfAdaption()) {
        ((Map)localObject1).put("dl_param_adaptive_type", Integer.valueOf(3));
      } else {
        ((Map)localObject1).put("dl_param_adaptive_type", Integer.valueOf(0));
      }
      ((Map)localObject1).put("dl_param_format_nodes", paramTPDownloadParamData.getDefInfoList());
      if ((paramTPDownloadParamData.getPcdnUrlList() != null) && (!paramTPDownloadParamData.getPcdnUrlList().isEmpty()))
      {
        paramMap = new StringBuilder("");
        localObject2 = paramTPDownloadParamData.getPcdnUrlList().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          paramMap.append((String)((Iterator)localObject2).next());
          paramMap.append(";");
        }
        if (paramMap.length() > 0) {
          paramMap.deleteCharAt(paramMap.length() - 1);
        }
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("pcdn url list: ");
        ((StringBuilder)localObject2).append(paramMap.toString());
        TPLogUtil.i("TPProxyUtils", ((StringBuilder)localObject2).toString());
        ((Map)localObject1).put("dl_param_pcdn_urls", paramMap.toString());
      }
      if ((paramTPDownloadParamData.getPcdnVtList() != null) && (!paramTPDownloadParamData.getPcdnVtList().isEmpty()))
      {
        paramMap = new StringBuilder("");
        localObject2 = paramTPDownloadParamData.getPcdnVtList().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          paramMap.append(((Integer)((Iterator)localObject2).next()).intValue());
          paramMap.append(";");
        }
        if (paramMap.length() > 0) {
          paramMap.deleteCharAt(paramMap.length() - 1);
        }
        ((Map)localObject1).put("dl_param_pcdn_vts", paramMap.toString());
      }
      return new TPDownloadParam(paramString, TPProxyEnumUtils.dlType2Inner(paramTPDownloadParamData.getDlType()), (Map)localObject1);
    }
    paramTPDownloadParamData = new ArrayList(1);
    paramTPDownloadParamData.add(paramString);
    return new TPDownloadParam(paramTPDownloadParamData, 0, null);
  }
  
  static TPDLProxyInitParam getProxyInitParam(Context paramContext, int paramInt)
  {
    return new TPDLProxyInitParam(TPPlayerConfig.getPlatform(), TPPlayerConfig.getAppVersionName(paramContext), TPPlayerConfig.getGuid(), TPPlayerConfig.getProxyCacheDir(paramInt), TPPlayerConfig.getProxyDataDir(paramInt), TPPlayerConfig.getProxyConfigStr());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.thumbplayer.datatransport.TPProxyUtils
 * JD-Core Version:    0.7.0.1
 */