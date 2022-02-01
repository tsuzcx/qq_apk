package com.tencent.qqlive.tvkplayer.vinfo.live;

import android.os.Message;
import android.text.TextUtils;
import com.tencent.qqlive.tvkplayer.thirdparties.LocalCache;
import com.tencent.qqlive.tvkplayer.tools.config.TVKConfigField;
import com.tencent.qqlive.tvkplayer.tools.config.TVKMediaPlayerConfig.PlayerConfig;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKLogUtil;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKUtils;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKVcSystemInfo;
import com.tencent.qqlive.tvkplayer.vinfo.TVKLiveVideoInfo;
import com.tencent.qqlive.tvkplayer.vinfo.TVKUserInfo;
import com.tencent.qqlive.tvkplayer.vinfo.api.ITVKLiveInfoGetter.OnGetLiveInfoListener;

class TVKLiveInfoGetter$1
  extends TVKLiveInfoCallback
{
  TVKLiveInfoGetter$1(TVKLiveInfoGetter paramTVKLiveInfoGetter) {}
  
  public void onFailure(int paramInt, TVKLiveVideoInfo paramTVKLiveVideoInfo)
  {
    TVKLogUtil.e(TVKLiveInfoGetter.access$400(), "onFailure, id: " + paramInt + ", errInfo: " + paramTVKLiveVideoInfo.getErrInfo());
    paramTVKLiveVideoInfo.setErrModule(10000);
    if (TVKLiveInfoGetter.access$700(this.this$0) != null) {
      TVKLiveInfoGetter.access$700(this.this$0).onGetLiveInfoFailed(paramInt, paramTVKLiveVideoInfo);
    }
  }
  
  public void onSuccess(int paramInt, TVKLiveVideoInfo paramTVKLiveVideoInfo)
  {
    if (((Boolean)TVKMediaPlayerConfig.PlayerConfig.is_use_cgi_cache_for_live.getValue()).booleanValue()) {}
    try
    {
      LocalCache localLocalCache = LocalCache.get(TVKLiveInfoGetter.access$000(this.this$0));
      if ((TVKLiveInfoGetter.access$100(this.this$0) != null) && (!TextUtils.isEmpty(TVKLiveInfoGetter.access$100(this.this$0).getLoginCookie())) && (TVKLiveInfoGetter.access$100(this.this$0).isVip())) {
        localLocalCache.put("live_" + TVKLiveInfoGetter.access$200(this.this$0) + "_" + TVKLiveInfoGetter.access$300(this.this$0) + "_" + TVKUtils.getMd5(TVKLiveInfoGetter.access$100(this.this$0).getLoginCookie()) + "_" + TVKVcSystemInfo.getIP(TVKLiveInfoGetter.access$000(this.this$0)), paramTVKLiveVideoInfo, ((Integer)TVKMediaPlayerConfig.PlayerConfig.cgi_cache_save_time_for_live.getValue()).intValue());
      }
      for (;;)
      {
        TVKLogUtil.i(TVKLiveInfoGetter.access$400(), "[onSuccess] save cache id: " + paramInt + ", progid: " + TVKLiveInfoGetter.access$200(this.this$0) + ", def: " + TVKLiveInfoGetter.access$300(this.this$0));
        if (TVKLiveInfoGetter.access$500(this.this$0) != null) {
          break;
        }
        TVKLogUtil.e(TVKLiveInfoGetter.access$400(), "[handleSuccess]  mEventHandler is null ");
        TVKLiveInfoGetter.access$600(this.this$0, paramInt, paramTVKLiveVideoInfo);
        return;
        localLocalCache.put("live_" + TVKLiveInfoGetter.access$200(this.this$0) + "_" + TVKLiveInfoGetter.access$300(this.this$0) + "_" + TVKVcSystemInfo.getIP(TVKLiveInfoGetter.access$000(this.this$0)), paramTVKLiveVideoInfo, ((Integer)TVKMediaPlayerConfig.PlayerConfig.cgi_cache_save_time_for_live.getValue()).intValue());
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        TVKLogUtil.e(TVKLiveInfoGetter.access$400(), localThrowable);
      }
      Message localMessage = TVKLiveInfoGetter.access$500(this.this$0).obtainMessage(100);
      localMessage.arg1 = paramInt;
      localMessage.obj = paramTVKLiveVideoInfo;
      TVKLiveInfoGetter.access$500(this.this$0).sendMessage(localMessage);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqlive.tvkplayer.vinfo.live.TVKLiveInfoGetter.1
 * JD-Core Version:    0.7.0.1
 */