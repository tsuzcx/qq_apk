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
import java.util.Map;

public class TPProxyUtils
{
  public static final String PROXY_SO_NAME = "DownloadProxy";
  
  public static TPDownloadParam convertProxyDownloadParams(String paramString, TPDownloadParamData paramTPDownloadParamData)
  {
    if (paramTPDownloadParamData != null)
    {
      Object localObject = new ArrayList();
      if ((paramTPDownloadParamData.getUrlCdnidList() == null) || (paramTPDownloadParamData.getUrlCdnidList().isEmpty()))
      {
        if (!TextUtils.isEmpty(paramString)) {
          ((ArrayList)localObject).add(paramString);
        }
        for (;;)
        {
          paramString = paramTPDownloadParamData.getBakUrl();
          if ((paramString == null) || (paramString.length <= 0)) {
            break;
          }
          int i = 0;
          while (i < paramString.length)
          {
            if (!TextUtils.isEmpty(paramString[i])) {
              ((ArrayList)localObject).add(paramString[i]);
            }
            i += 1;
          }
          ((ArrayList)localObject).add(paramTPDownloadParamData.url);
        }
        paramString = (String)localObject;
        localObject = new HashMap();
        if (!TextUtils.isEmpty(paramTPDownloadParamData.getFlowId()))
        {
          TPLogUtil.i("TPProxyUtils", paramTPDownloadParamData.getFlowId());
          ((Map)localObject).put("dl_param_play_flowid", paramTPDownloadParamData.getFlowId());
        }
        if (!TPCommonUtils.isEmpty(paramTPDownloadParamData.getUrlHostList())) {
          ((Map)localObject).put("dl_param_url_host", paramTPDownloadParamData.getUrlHostList());
        }
        if (!TPCommonUtils.isEmpty(paramTPDownloadParamData.getUrlCookieList())) {
          ((Map)localObject).put("dl_param_url_cookie", paramTPDownloadParamData.getUrlCookieList());
        }
        if (paramTPDownloadParamData.getUrlExpireTime() > 0) {
          ((Map)localObject).put("dl_param_url_expire_time", Integer.valueOf(paramTPDownloadParamData.getUrlExpireTime()));
        }
        if (paramTPDownloadParamData.getFileSize() > 0L) {
          ((Map)localObject).put("dl_param_file_size", Long.valueOf(paramTPDownloadParamData.getFileSize()));
        }
        if (paramTPDownloadParamData.getFileDuration() > 0L) {
          ((Map)localObject).put("dl_param_file_duration", Long.valueOf(paramTPDownloadParamData.getFileDuration()));
        }
        if (!TextUtils.isEmpty(paramTPDownloadParamData.getDownloadFileID())) {
          ((Map)localObject).put("dl_param_play_keyid", paramTPDownloadParamData.getDownloadFileID());
        }
        if (!TextUtils.isEmpty(paramTPDownloadParamData.getVid())) {
          ((Map)localObject).put("dl_param_vid", paramTPDownloadParamData.getVid());
        }
        if (!TextUtils.isEmpty(paramTPDownloadParamData.getPlayDefinition()))
        {
          ((Map)localObject).put("dl_param_play_definition", paramTPDownloadParamData.getPlayDefinition());
          ((Map)localObject).put("dl_param_current_format", paramTPDownloadParamData.getPlayDefinition());
        }
        if (paramTPDownloadParamData.getCurrentFormatID() > 0) {
          ((Map)localObject).put("dl_param_current_formatid", Integer.valueOf(paramTPDownloadParamData.getCurrentFormatID()));
        }
        if (!TPCommonUtils.isEmpty(paramTPDownloadParamData.getFormatInfo())) {
          ((Map)localObject).put("dl_param_format_info", paramTPDownloadParamData.getFormatInfo());
        }
        ((Map)localObject).put("dl_param_source_is_charge", Boolean.valueOf(paramTPDownloadParamData.isCharge()));
        ((Map)localObject).put("dl_param_cache_need_encrypt", Boolean.valueOf(paramTPDownloadParamData.isNeedEncryptCache()));
        ((Map)localObject).put("dl_param_is_offline", Boolean.valueOf(paramTPDownloadParamData.isOffline()));
        ((Map)localObject).put("dl_param_enable_expand_donwload_url", Boolean.valueOf(paramTPDownloadParamData.isExtraParam()));
        if (paramTPDownloadParamData.getPreloadSize() > 0L) {
          ((Map)localObject).put("dl_param_preload_size", Long.valueOf(paramTPDownloadParamData.getPreloadSize()));
        }
        if (paramTPDownloadParamData.getPreloadDuration() > 0L) {
          ((Map)localObject).put("dl_param_preload_duration", Long.valueOf(paramTPDownloadParamData.getPreloadDuration()));
        }
        if (!TextUtils.isEmpty(paramTPDownloadParamData.getSavePath())) {
          ((Map)localObject).put("dl_param_save_path", paramTPDownloadParamData.getSavePath());
        }
        if (paramTPDownloadParamData.getStarTimeMS() > 0) {
          ((Map)localObject).put("dl_param_play_start_time", Integer.valueOf(paramTPDownloadParamData.getStarTimeMS()));
        }
        if (paramTPDownloadParamData.getEndTimeMS() > 0) {
          ((Map)localObject).put("dl_param_play_end_time", Integer.valueOf(paramTPDownloadParamData.getEndTimeMS()));
        }
        if (paramTPDownloadParamData.getClipCount() > 0) {
          ((Map)localObject).put("dl_param_play_clip_count", Integer.valueOf(paramTPDownloadParamData.getClipCount()));
        }
        if (paramTPDownloadParamData.getClipNo() > 0) {
          ((Map)localObject).put("dl_param_play_clip_no", Integer.valueOf(paramTPDownloadParamData.getClipNo()));
        }
        if (!TextUtils.isEmpty(paramTPDownloadParamData.getBase())) {
          ((Map)localObject).put("dl_param_vinfo_base", paramTPDownloadParamData.getBase());
        }
        if (!TextUtils.isEmpty(paramTPDownloadParamData.getLinkVid())) {
          ((Map)localObject).put("dl_param_vinfo_link_vid", paramTPDownloadParamData.getLinkVid());
        }
        if (!TextUtils.isEmpty(paramTPDownloadParamData.getFileMD5())) {
          ((Map)localObject).put("dl_param_file_md5", paramTPDownloadParamData.getFileMD5());
        }
        if (!TextUtils.isEmpty(paramTPDownloadParamData.getM3u8())) {
          ((Map)localObject).put("dl_param_vinfo_m3u8", paramTPDownloadParamData.getM3u8());
        }
        if (paramTPDownloadParamData.getTm() > 0L) {
          ((Map)localObject).put("dl_param_vinfo_tm", Long.valueOf(paramTPDownloadParamData.getTm()));
        }
        if (paramTPDownloadParamData.getFp2p() > 0) {
          ((Map)localObject).put("dl_param_vinfo_fp2p", Integer.valueOf(paramTPDownloadParamData.getFp2p()));
        }
        if (paramTPDownloadParamData.getTestid() > 0) {
          ((Map)localObject).put("dl_param_vinfo_testid", Integer.valueOf(paramTPDownloadParamData.getTestid()));
        }
        if (!TPCommonUtils.isEmpty(paramTPDownloadParamData.getExtInfoMap())) {
          ((Map)localObject).putAll(paramTPDownloadParamData.getExtInfoMap());
        }
        if (!paramTPDownloadParamData.getSelfAdaption()) {
          break label859;
        }
        ((Map)localObject).put("dl_param_adaptive_type", Integer.valueOf(3));
      }
      for (;;)
      {
        ((Map)localObject).put("dl_param_format_nodes", paramTPDownloadParamData.getDefInfoList());
        return new TPDownloadParam(paramString, TPProxyEnumUtils.dlType2Inner(paramTPDownloadParamData.getDlType()), (Map)localObject);
        paramString = paramTPDownloadParamData.getUrlCdnidList();
        break;
        label859:
        ((Map)localObject).put("dl_param_adaptive_type", Integer.valueOf(0));
      }
    }
    paramTPDownloadParamData = new ArrayList(1);
    paramTPDownloadParamData.add(paramString);
    return new TPDownloadParam(paramTPDownloadParamData, 0, null);
  }
  
  static TPDLProxyInitParam getProxyInitParam(Context paramContext, int paramInt)
  {
    return new TPDLProxyInitParam(TPPlayerConfig.getPlatform(), TPPlayerConfig.getAppVersionName(paramContext), TPPlayerConfig.getGuid(), TPPlayerConfig.getProxyCacheDir(paramInt), TPPlayerConfig.getProxyDataDir(paramInt), TPPlayerConfig.getProxyConfigStr(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.thumbplayer.datatransport.TPProxyUtils
 * JD-Core Version:    0.7.0.1
 */