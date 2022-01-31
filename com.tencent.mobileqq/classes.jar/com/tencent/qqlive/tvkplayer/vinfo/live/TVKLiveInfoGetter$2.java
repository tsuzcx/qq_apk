package com.tencent.qqlive.tvkplayer.vinfo.live;

import android.text.TextUtils;
import com.tencent.qqlive.tvkplayer.thirdparties.LocalCache;
import com.tencent.qqlive.tvkplayer.tools.config.TVKConfigField;
import com.tencent.qqlive.tvkplayer.tools.config.TVKMediaPlayerConfig.PlayerConfig;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKHandlerThreadPool;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKLogUtil;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKUtils;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKVcSystemInfo;
import com.tencent.qqlive.tvkplayer.vinfo.TVKLiveVideoInfo;
import com.tencent.qqlive.tvkplayer.vinfo.TVKUserInfo;

class TVKLiveInfoGetter$2
  extends TVKLiveInfoCallback
{
  TVKLiveInfoGetter$2(TVKLiveInfoGetter paramTVKLiveInfoGetter) {}
  
  public void onFailure(int paramInt, TVKLiveVideoInfo paramTVKLiveVideoInfo)
  {
    TVKLogUtil.e(TVKLiveInfoGetter.access$400(), "onFailure, preload, id: " + paramInt + ", progid: " + TVKLiveInfoGetter.access$200(this.this$0) + ", def: " + TVKLiveInfoGetter.access$300(this.this$0));
    if (TVKLiveInfoGetter.access$800(this.this$0) != null)
    {
      TVKHandlerThreadPool.getInstance().recycle(TVKLiveInfoGetter.access$800(this.this$0), TVKLiveInfoGetter.access$500(this.this$0));
      TVKLiveInfoGetter.access$802(this.this$0, null);
    }
    TVKLiveInfoGetter.access$702(this.this$0, null);
  }
  
  public void onSuccess(int paramInt, TVKLiveVideoInfo paramTVKLiveVideoInfo)
  {
    if (paramTVKLiveVideoInfo == null)
    {
      TVKLogUtil.e(TVKLiveInfoGetter.access$400(), "[handleSuccess]  preload failed, progid: " + TVKLiveInfoGetter.access$200(this.this$0) + ", def: " + TVKLiveInfoGetter.access$300(this.this$0));
      return;
    }
    TVKLogUtil.i(TVKLiveInfoGetter.access$400(), "[onSuccess]  id: " + paramInt + ", progid: " + TVKLiveInfoGetter.access$200(this.this$0) + ", def: " + TVKLiveInfoGetter.access$300(this.this$0));
    try
    {
      LocalCache localLocalCache = LocalCache.get(TVKLiveInfoGetter.access$000(this.this$0));
      if ((TVKLiveInfoGetter.access$100(this.this$0) != null) && (!TextUtils.isEmpty(TVKLiveInfoGetter.access$100(this.this$0).getLoginCookie())) && (TVKLiveInfoGetter.access$100(this.this$0).isVip())) {
        localLocalCache.put("live_" + TVKLiveInfoGetter.access$200(this.this$0) + "_" + TVKLiveInfoGetter.access$300(this.this$0) + "_" + TVKUtils.getMd5(TVKLiveInfoGetter.access$100(this.this$0).getLoginCookie()) + "_" + TVKVcSystemInfo.getIP(TVKLiveInfoGetter.access$000(this.this$0)), paramTVKLiveVideoInfo, ((Integer)TVKMediaPlayerConfig.PlayerConfig.cgi_cache_save_time_for_live.getValue()).intValue());
      }
      for (;;)
      {
        if (TVKLiveInfoGetter.access$800(this.this$0) != null)
        {
          TVKHandlerThreadPool.getInstance().recycle(TVKLiveInfoGetter.access$800(this.this$0), TVKLiveInfoGetter.access$500(this.this$0));
          TVKLiveInfoGetter.access$802(this.this$0, null);
        }
        TVKLiveInfoGetter.access$702(this.this$0, null);
        return;
        localLocalCache.put("live_" + TVKLiveInfoGetter.access$200(this.this$0) + "_" + TVKLiveInfoGetter.access$300(this.this$0) + "_" + TVKVcSystemInfo.getIP(TVKLiveInfoGetter.access$000(this.this$0)), paramTVKLiveVideoInfo, ((Integer)TVKMediaPlayerConfig.PlayerConfig.cgi_cache_save_time_for_live.getValue()).intValue());
      }
    }
    catch (Throwable paramTVKLiveVideoInfo)
    {
      for (;;)
      {
        TVKLogUtil.e(TVKLiveInfoGetter.access$400(), paramTVKLiveVideoInfo);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqlive.tvkplayer.vinfo.live.TVKLiveInfoGetter.2
 * JD-Core Version:    0.7.0.1
 */