package com.tencent.mobileqq.nearby.now.model;

import android.net.Uri;
import android.os.Bundle;
import com.tencent.mobileqq.nearby.now.protocol.INowShortVideoProtoManager;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.pb.now.FeedsProtocol.GetMediaDetailRsp;
import com.tencent.pb.now.FeedsProtocol.MediaInfo;
import com.tencent.pb.now.FeedsProtocol.PicFeedsInfo;
import com.tencent.pb.now.FeedsProtocol.ShortVideoInfo;
import com.tencent.pb.now.FeedsProtocol.TextFeed;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class PlayListDataModel
  extends BasePlayListDataModel
{
  private String f = "PlayListDataModel";
  private String g;
  private int h = 0;
  
  private void a(FeedsProtocol.GetMediaDetailRsp paramGetMediaDetailRsp)
  {
    paramGetMediaDetailRsp = paramGetMediaDetailRsp.media_list.get().iterator();
    while (paramGetMediaDetailRsp.hasNext())
    {
      FeedsProtocol.MediaInfo localMediaInfo = (FeedsProtocol.MediaInfo)paramGetMediaDetailRsp.next();
      if ((localMediaInfo.type.get() != 1) && (localMediaInfo.type.get() != 2)) {
        if (localMediaInfo.type.get() == 3) {
          ((IModelUtil)QRoute.api(IModelUtil.class)).parseShortVideoData(localMediaInfo.is_my_feeds.get(), localMediaInfo.topic_cfg.get(), localMediaInfo.short_video.get(), this.d);
        } else if (localMediaInfo.type.get() == 5) {
          ((IModelUtil)QRoute.api(IModelUtil.class)).parseImageData(localMediaInfo.is_my_feeds.get(), localMediaInfo.topic_cfg.get(), localMediaInfo.pic_info.get(), this.d);
        } else if (localMediaInfo.type.get() == 6) {
          ((IModelUtil)QRoute.api(IModelUtil.class)).parseTextFeeds(localMediaInfo.is_my_feeds.get(), localMediaInfo.topic_cfg.get(), localMediaInfo.text_feed.get(), this.d);
        }
      }
    }
  }
  
  public void a(Bundle paramBundle)
  {
    if ("1".equals(paramBundle.getString("isLocal"))) {
      return;
    }
    paramBundle = paramBundle.getString("raw_url");
    this.g = Uri.parse(paramBundle).getQuery();
    if (QLog.isColorLevel())
    {
      String str = this.f;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("PlayListDataModel, url=");
      localStringBuilder.append(paramBundle);
      QLog.d(str, 2, localStringBuilder.toString());
    }
  }
  
  public void b()
  {
    if (this.b) {
      return;
    }
    INowShortVideoProtoManager localINowShortVideoProtoManager = ((INowShortVideoProtoManager)QRoute.api(INowShortVideoProtoManager.class)).init(this.c);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.g);
    localStringBuilder.append("&start=");
    localStringBuilder.append(this.h);
    localStringBuilder.append("&num=");
    localStringBuilder.append(10);
    localINowShortVideoProtoManager.getMediaDetailInfo(localStringBuilder.toString(), new PlayListDataModel.1(this));
  }
  
  public int d()
  {
    return this.a;
  }
  
  public boolean e()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.model.PlayListDataModel
 * JD-Core Version:    0.7.0.1
 */