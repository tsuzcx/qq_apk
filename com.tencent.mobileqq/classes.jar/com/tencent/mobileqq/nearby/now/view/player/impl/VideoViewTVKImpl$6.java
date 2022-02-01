package com.tencent.mobileqq.nearby.now.view.player.impl;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.VideoServerInfoManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.transfile.dns.InnerDns;
import com.tencent.qqlive.mediaplayer.api.TVK_PlayerVideoInfo;
import com.tencent.util.URLUtil;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.SimpleJob;
import mqq.os.MqqHandler;

class VideoViewTVKImpl$6
  extends SimpleJob<Object>
{
  VideoViewTVKImpl$6(VideoViewTVKImpl paramVideoViewTVKImpl, String paramString1, String paramString2, TVK_PlayerVideoInfo paramTVK_PlayerVideoInfo)
  {
    super(paramString1);
  }
  
  protected Object a(@NonNull JobContext paramJobContext, @Nullable Void... paramVarArgs)
  {
    if (TextUtils.isEmpty(this.a)) {
      return null;
    }
    if (this.a.contains("qqstocdnd"))
    {
      paramJobContext = ((VideoServerInfoManager)SuperManager.a(4)).e();
      SLog.a("VideoViewTVKImpl", "get url key:%s", paramJobContext);
      if (!TextUtils.isEmpty(paramJobContext)) {
        this.c.f = URLUtil.a(this.a, "authkey", paramJobContext);
      } else {
        ThreadManager.getUIHandler().post(new VideoViewTVKImpl.6.1(this));
      }
    }
    paramJobContext = this.c;
    paramJobContext.f = InnerDns.replaceDomainWithIp(paramJobContext.f.replace("https://", "http://"), 1012);
    ThreadManager.getUIHandler().post(new VideoViewTVKImpl.6.2(this));
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.view.player.impl.VideoViewTVKImpl.6
 * JD-Core Version:    0.7.0.1
 */