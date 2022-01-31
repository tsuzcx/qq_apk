package com.tencent.qqlive.tvkplayer.vinfo.vod;

import android.content.Context;
import android.support.annotation.NonNull;
import com.tencent.qqlive.tvkplayer.TVideoMgr;
import com.tencent.qqlive.tvkplayer.tools.config.TVKConfigField;
import com.tencent.qqlive.tvkplayer.tools.config.TVKMediaPlayerConfig.PlayerConfig;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKVcSystemInfo;
import com.tencent.qqlive.tvkplayer.vinfo.TVKPlayerVideoInfo;
import com.tencent.qqlive.tvkplayer.vinfo.TVKUserInfo;
import com.tencent.qqlive.tvkplayer.vinfo.api.ITVKVodInfoGetter;
import com.tencent.qqlive.tvkplayer.vinfo.api.ITVKVodInfoGetter.ITVKVodInfoGetterCallback;
import java.util.HashMap;
import java.util.Map;

public class TVKVodInfoGetter
  implements ITVKVodInfoGetter
{
  private ITVKVodInfoGetter.ITVKVodInfoGetterCallback mCallback;
  private Context mContext;
  
  public TVKVodInfoGetter(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  public int getDlnaUrl(@NonNull TVKUserInfo paramTVKUserInfo, @NonNull TVKPlayerVideoInfo paramTVKPlayerVideoInfo, @NonNull String paramString, int paramInt)
  {
    Object localObject;
    if (paramTVKPlayerVideoInfo.getExtraRequestParamsMap() == null)
    {
      localObject = new HashMap(1);
      ((Map)localObject).put("dlna", "dlna");
      localObject = new TVKVideoInfoParams.TVKVInfoRequestParasBuilder(paramTVKPlayerVideoInfo.getVid()).uin(paramTVKUserInfo.getUin()).ipstack(0).dlType(paramInt);
      if (!paramTVKPlayerVideoInfo.isNeedCharge()) {
        break label205;
      }
    }
    label205:
    for (paramInt = 1;; paramInt = 0)
    {
      paramTVKUserInfo = ((TVKVideoInfoParams.TVKVInfoRequestParasBuilder)localObject).isCharge(paramInt).ckeyExtraParamsMap(paramTVKPlayerVideoInfo.getProxyExtraMap()).extraParamsMap(paramTVKPlayerVideoInfo.getExtraRequestParamsMap()).format(paramString).loginCookie(paramTVKUserInfo.getLoginCookie()).sdtFrom(TVideoMgr.getVinfoSdtfrom()).requestType(0).upc(TVideoMgr.mOriginalUpc).platForm(TVideoMgr.getVinfoPlatform()).playerCapacity(TVKVcSystemInfo.getPlayerLevel()).appVer(TVideoMgr.getPlayerVersion()).encryptVer(((Integer)TVKMediaPlayerConfig.PlayerConfig.encrypt_ver.getValue()).intValue()).networkType(TVKVcSystemInfo.getNetWorkType(this.mContext)).wxOpenId(paramTVKUserInfo.getWxOpenID()).guid(TVideoMgr.getStaGuid()).build();
      return new TVKVideoInfoRequest().startRequest(paramTVKUserInfo, new TVKVodInfoGetter.2(this));
      localObject = paramTVKPlayerVideoInfo.getProxyExtraMap();
      break;
    }
  }
  
  public int getPlayInfo(@NonNull TVKUserInfo paramTVKUserInfo, @NonNull TVKPlayerVideoInfo paramTVKPlayerVideoInfo, @NonNull String paramString, int paramInt1, int paramInt2)
  {
    int i = 0;
    TVKVideoInfoParams.TVKVInfoRequestParasBuilder localTVKVInfoRequestParasBuilder = new TVKVideoInfoParams.TVKVInfoRequestParasBuilder(paramTVKPlayerVideoInfo.getVid()).uin(paramTVKUserInfo.getUin()).ipstack(0).dlType(paramInt1);
    paramInt1 = i;
    if (paramTVKPlayerVideoInfo.isNeedCharge()) {
      paramInt1 = 1;
    }
    paramTVKUserInfo = localTVKVInfoRequestParasBuilder.isCharge(paramInt1).ckeyExtraParamsMap(paramTVKPlayerVideoInfo.getProxyExtraMap()).extraParamsMap(paramTVKPlayerVideoInfo.getExtraRequestParamsMap()).format(paramString).loginCookie(paramTVKUserInfo.getLoginCookie()).sdtFrom(TVideoMgr.getVinfoSdtfrom()).requestType(paramInt2).upc(TVideoMgr.mOriginalUpc).platForm(TVideoMgr.getVinfoPlatform()).playerCapacity(TVKVcSystemInfo.getPlayerLevel()).appVer(TVideoMgr.getPlayerVersion()).encryptVer(((Integer)TVKMediaPlayerConfig.PlayerConfig.encrypt_ver.getValue()).intValue()).networkType(TVKVcSystemInfo.getNetWorkType(this.mContext)).wxOpenId(paramTVKUserInfo.getWxOpenID()).guid(TVideoMgr.getStaGuid()).build();
    return new TVKVideoInfoRequest().startRequest(paramTVKUserInfo, new TVKVodInfoGetter.1(this));
  }
  
  public void setOnInfoGetListener(ITVKVodInfoGetter.ITVKVodInfoGetterCallback paramITVKVodInfoGetterCallback)
  {
    this.mCallback = paramITVKVodInfoGetterCallback;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqlive.tvkplayer.vinfo.vod.TVKVodInfoGetter
 * JD-Core Version:    0.7.0.1
 */