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
    String str = TVKLiveInfoGetter.access$400();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onFailure, id: ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(", errInfo: ");
    localStringBuilder.append(paramTVKLiveVideoInfo.getErrInfo());
    TVKLogUtil.e(str, localStringBuilder.toString());
    paramTVKLiveVideoInfo.setErrModule(10000);
    if (TVKLiveInfoGetter.access$700(this.this$0) != null) {
      TVKLiveInfoGetter.access$700(this.this$0).onGetLiveInfoFailed(paramInt, paramTVKLiveVideoInfo);
    }
  }
  
  public void onSuccess(int paramInt, TVKLiveVideoInfo paramTVKLiveVideoInfo)
  {
    if (((Boolean)TVKMediaPlayerConfig.PlayerConfig.is_use_cgi_cache_for_live.getValue()).booleanValue()) {
      try
      {
        LocalCache localLocalCache = LocalCache.get(TVKLiveInfoGetter.access$000(this.this$0));
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
          localLocalCache.put(((StringBuilder)localObject2).toString(), paramTVKLiveVideoInfo, ((Integer)TVKMediaPlayerConfig.PlayerConfig.cgi_cache_save_time_for_live.getValue()).intValue());
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
          localLocalCache.put(((StringBuilder)localObject2).toString(), paramTVKLiveVideoInfo, ((Integer)TVKMediaPlayerConfig.PlayerConfig.cgi_cache_save_time_for_live.getValue()).intValue());
        }
      }
      catch (Throwable localThrowable)
      {
        TVKLogUtil.e(TVKLiveInfoGetter.access$400(), localThrowable);
      }
    }
    Object localObject1 = TVKLiveInfoGetter.access$400();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("[onSuccess] save cache id: ");
    ((StringBuilder)localObject2).append(paramInt);
    ((StringBuilder)localObject2).append(", progid: ");
    ((StringBuilder)localObject2).append(TVKLiveInfoGetter.access$200(this.this$0));
    ((StringBuilder)localObject2).append(", def: ");
    ((StringBuilder)localObject2).append(TVKLiveInfoGetter.access$300(this.this$0));
    TVKLogUtil.i((String)localObject1, ((StringBuilder)localObject2).toString());
    if (TVKLiveInfoGetter.access$500(this.this$0) == null)
    {
      TVKLogUtil.e(TVKLiveInfoGetter.access$400(), "[handleSuccess]  mEventHandler is null ");
      TVKLiveInfoGetter.access$600(this.this$0, paramInt, paramTVKLiveVideoInfo);
      return;
    }
    localObject1 = TVKLiveInfoGetter.access$500(this.this$0).obtainMessage(100);
    ((Message)localObject1).arg1 = paramInt;
    ((Message)localObject1).obj = paramTVKLiveVideoInfo;
    TVKLiveInfoGetter.access$500(this.this$0).sendMessage((Message)localObject1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqlive.tvkplayer.vinfo.live.TVKLiveInfoGetter.1
 * JD-Core Version:    0.7.0.1
 */