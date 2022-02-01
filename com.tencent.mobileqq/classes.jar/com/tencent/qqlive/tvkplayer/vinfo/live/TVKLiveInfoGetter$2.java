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
    paramTVKLiveVideoInfo = TVKLiveInfoGetter.access$400();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onFailure, preload, id: ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(", progid: ");
    localStringBuilder.append(TVKLiveInfoGetter.access$200(this.this$0));
    localStringBuilder.append(", def: ");
    localStringBuilder.append(TVKLiveInfoGetter.access$300(this.this$0));
    TVKLogUtil.e(paramTVKLiveVideoInfo, localStringBuilder.toString());
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
      paramTVKLiveVideoInfo = TVKLiveInfoGetter.access$400();
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("[handleSuccess]  preload failed, progid: ");
      ((StringBuilder)localObject1).append(TVKLiveInfoGetter.access$200(this.this$0));
      ((StringBuilder)localObject1).append(", def: ");
      ((StringBuilder)localObject1).append(TVKLiveInfoGetter.access$300(this.this$0));
      TVKLogUtil.e(paramTVKLiveVideoInfo, ((StringBuilder)localObject1).toString());
      return;
    }
    Object localObject1 = TVKLiveInfoGetter.access$400();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("[onSuccess]  id: ");
    ((StringBuilder)localObject2).append(paramInt);
    ((StringBuilder)localObject2).append(", progid: ");
    ((StringBuilder)localObject2).append(TVKLiveInfoGetter.access$200(this.this$0));
    ((StringBuilder)localObject2).append(", def: ");
    ((StringBuilder)localObject2).append(TVKLiveInfoGetter.access$300(this.this$0));
    TVKLogUtil.i((String)localObject1, ((StringBuilder)localObject2).toString());
    try
    {
      localObject1 = LocalCache.get(TVKLiveInfoGetter.access$000(this.this$0));
      localObject2 = TVKLiveInfoGetter.access$100(this.this$0);
      if ((localObject2 != null) && (!TextUtils.isEmpty(TVKLiveInfoGetter.access$100(this.this$0).getLoginCookie())) && (TVKLiveInfoGetter.access$100(this.this$0).isVip()))
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("live_");
        ((StringBuilder)localObject2).append(TVKLiveInfoGetter.access$200(this.this$0));
        ((StringBuilder)localObject2).append("_");
        ((StringBuilder)localObject2).append(TVKLiveInfoGetter.access$300(this.this$0));
        ((StringBuilder)localObject2).append("_");
        ((StringBuilder)localObject2).append(TVKUtils.getMd5(TVKLiveInfoGetter.access$100(this.this$0).getLoginCookie()));
        ((StringBuilder)localObject2).append("_");
        ((StringBuilder)localObject2).append(TVKVcSystemInfo.getIP(TVKLiveInfoGetter.access$000(this.this$0)));
        ((LocalCache)localObject1).put(((StringBuilder)localObject2).toString(), paramTVKLiveVideoInfo, ((Integer)TVKMediaPlayerConfig.PlayerConfig.cgi_cache_save_time_for_live.getValue()).intValue());
      }
      else
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("live_");
        ((StringBuilder)localObject2).append(TVKLiveInfoGetter.access$200(this.this$0));
        ((StringBuilder)localObject2).append("_");
        ((StringBuilder)localObject2).append(TVKLiveInfoGetter.access$300(this.this$0));
        ((StringBuilder)localObject2).append("_");
        ((StringBuilder)localObject2).append(TVKVcSystemInfo.getIP(TVKLiveInfoGetter.access$000(this.this$0)));
        ((LocalCache)localObject1).put(((StringBuilder)localObject2).toString(), paramTVKLiveVideoInfo, ((Integer)TVKMediaPlayerConfig.PlayerConfig.cgi_cache_save_time_for_live.getValue()).intValue());
      }
    }
    catch (Throwable paramTVKLiveVideoInfo)
    {
      TVKLogUtil.e(TVKLiveInfoGetter.access$400(), paramTVKLiveVideoInfo);
    }
    if (TVKLiveInfoGetter.access$800(this.this$0) != null)
    {
      TVKHandlerThreadPool.getInstance().recycle(TVKLiveInfoGetter.access$800(this.this$0), TVKLiveInfoGetter.access$500(this.this$0));
      TVKLiveInfoGetter.access$802(this.this$0, null);
    }
    TVKLiveInfoGetter.access$702(this.this$0, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqlive.tvkplayer.vinfo.live.TVKLiveInfoGetter.2
 * JD-Core Version:    0.7.0.1
 */