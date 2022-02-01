package com.tencent.mobileqq.nearby.now.model;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.nearby.now.protocol.INowShortVideoProtoManager;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.pb.now.FeedsProtocol.GetMediaDetailRsp;
import com.tencent.pb.now.FeedsProtocol.LiveAggregateInfo;
import com.tencent.pb.now.FeedsProtocol.MediaInfo;
import com.tencent.pb.now.FeedsProtocol.PicFeedsInfo;
import com.tencent.pb.now.FeedsProtocol.RichTitleElement;
import com.tencent.pb.now.FeedsProtocol.ShortVideoInfo;
import com.tencent.pb.now.FeedsProtocol.TextFeed;
import com.tencent.pb.now.FeedsProtocol.TopicCfg;
import com.tencent.pb.now.FeedsProtocol.UserInfo;
import com.tencent.pb.now.FeedsProtocol.VideoItem;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class InfinitePlayListDataModel
  extends BasePlayListDataModel
{
  private String f;
  private boolean g = false;
  private String h;
  
  private void a(int paramInt, List<FeedsProtocol.TopicCfg> paramList, FeedsProtocol.VideoItem paramVideoItem, ArrayList<VideoData> paramArrayList)
  {
    if (paramVideoItem == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("paseRecord", 1, "item is null!");
      }
      return;
    }
    VideoData localVideoData = new VideoData();
    localVideoData.b = 1;
    localVideoData.c = paramVideoItem.id.get().toStringUtf8();
    localVideoData.g = paramVideoItem.jump_url.get().toStringUtf8();
    localVideoData.i = paramVideoItem.user_info.uid.get();
    localVideoData.j = paramVideoItem.user_info.tinyid.get();
    localVideoData.k = paramVideoItem.user_info.explicit_uid.get();
    localVideoData.l = paramVideoItem.user_info.id_type.get();
    localVideoData.e = paramVideoItem.video_cover_url.get().toStringUtf8();
    localVideoData.m = ((FeedsProtocol.UserInfo)paramVideoItem.user_info.get()).head_img_url.get().toStringUtf8();
    localVideoData.s = ((FeedsProtocol.UserInfo)paramVideoItem.user_info.get()).anchor_name.get().toStringUtf8();
    localVideoData.y = paramVideoItem.video_start_time.get();
    localVideoData.O = paramInt;
    localVideoData.A = "";
    paramVideoItem = paramVideoItem.rpt_msg_rich_title.get().iterator();
    while (paramVideoItem.hasNext())
    {
      FeedsProtocol.RichTitleElement localRichTitleElement = (FeedsProtocol.RichTitleElement)paramVideoItem.next();
      StringBuilder localStringBuilder;
      if (localRichTitleElement.type.get() == 1)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(localVideoData.A);
        localStringBuilder.append(localRichTitleElement.text.get().toStringUtf8());
        localVideoData.A = localStringBuilder.toString();
      }
      else if (localRichTitleElement.type.get() == 2)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(localVideoData.A);
        localStringBuilder.append("#");
        localStringBuilder.append(localRichTitleElement.text.get().toStringUtf8());
        localStringBuilder.append("#");
        localVideoData.A = localStringBuilder.toString();
      }
    }
    paramArrayList.add(((IModelUtil)QRoute.api(IModelUtil.class)).parseTopicInfoToVideoData(paramList, localVideoData));
    paramArrayList.add(localVideoData);
  }
  
  private void a(FeedsProtocol.GetMediaDetailRsp paramGetMediaDetailRsp)
  {
    paramGetMediaDetailRsp = paramGetMediaDetailRsp.media_list.get();
    this.d.clear();
    paramGetMediaDetailRsp = paramGetMediaDetailRsp.iterator();
    while (paramGetMediaDetailRsp.hasNext())
    {
      FeedsProtocol.MediaInfo localMediaInfo = (FeedsProtocol.MediaInfo)paramGetMediaDetailRsp.next();
      if (localMediaInfo.type.get() == 1) {
        b(localMediaInfo, this.d);
      } else if (localMediaInfo.type.get() == 2) {
        a(localMediaInfo, this.d);
      } else if (localMediaInfo.type.get() == 3) {
        ((IModelUtil)QRoute.api(IModelUtil.class)).parseShortVideoData(localMediaInfo.is_my_feeds.get(), localMediaInfo.topic_cfg.get(), localMediaInfo.short_video.get(), this.d);
      } else if (localMediaInfo.type.get() == 5) {
        ((IModelUtil)QRoute.api(IModelUtil.class)).parseImageData(localMediaInfo.is_my_feeds.get(), localMediaInfo.topic_cfg.get(), localMediaInfo.pic_info.get(), this.d);
      } else if (localMediaInfo.type.get() == 6) {
        ((IModelUtil)QRoute.api(IModelUtil.class)).parseTextFeeds(localMediaInfo.is_my_feeds.get(), localMediaInfo.topic_cfg.get(), localMediaInfo.text_feed.get(), this.d);
      }
    }
  }
  
  private void a(FeedsProtocol.MediaInfo paramMediaInfo, ArrayList<VideoData> paramArrayList)
  {
    FeedsProtocol.VideoItem localVideoItem = (FeedsProtocol.VideoItem)paramMediaInfo.video.get();
    a(paramMediaInfo.is_my_feeds.get(), paramMediaInfo.topic_cfg.get(), localVideoItem, paramArrayList);
  }
  
  private void b(FeedsProtocol.MediaInfo paramMediaInfo, ArrayList<VideoData> paramArrayList)
  {
    Object localObject1 = (FeedsProtocol.LiveAggregateInfo)paramMediaInfo.live_aggregate.get();
    FeedsProtocol.VideoItem localVideoItem = (FeedsProtocol.VideoItem)((FeedsProtocol.LiveAggregateInfo)localObject1).video.get();
    if ((((FeedsProtocol.LiveAggregateInfo)localObject1).total_short_size.get() == 0) && (localVideoItem != null) && (!TextUtils.isEmpty(localVideoItem.jump_url.get().toString())))
    {
      a(paramMediaInfo.is_my_feeds.get(), paramMediaInfo.topic_cfg.get(), localVideoItem, paramArrayList);
      return;
    }
    localObject1 = ((FeedsProtocol.LiveAggregateInfo)localObject1).short_video.get().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (FeedsProtocol.ShortVideoInfo)((Iterator)localObject1).next();
      localObject2 = ((IModelUtil)QRoute.api(IModelUtil.class)).parseShortVideoData(paramMediaInfo.is_my_feeds.get(), paramMediaInfo.topic_cfg.get(), localObject2, paramArrayList);
      ((VideoData)localObject2).g = localVideoItem.jump_url.get().toStringUtf8();
      ((VideoData)localObject2).b = 3;
    }
  }
  
  public void a(Bundle paramBundle)
  {
    paramBundle = paramBundle.getString("raw_url");
    this.f = Uri.parse(paramBundle).getQuery();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("InfinitePlayListDataModel, url=");
      localStringBuilder.append(paramBundle);
      QLog.d("InfinitePlayListDataModel", 2, localStringBuilder.toString());
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    this.h = paramString2;
    if (!TextUtils.isEmpty(paramString1)) {
      this.f = this.f.replace(paramString1, paramString2);
    }
  }
  
  public void b()
  {
    if (this.b) {
      return;
    }
    INowShortVideoProtoManager localINowShortVideoProtoManager = ((INowShortVideoProtoManager)QRoute.api(INowShortVideoProtoManager.class)).init(this.c);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.f);
    localStringBuilder.append("&num=");
    localStringBuilder.append(10);
    localINowShortVideoProtoManager.getMediaDetailInfo(localStringBuilder.toString(), new InfinitePlayListDataModel.2(this));
  }
  
  public void c()
  {
    if (this.g) {
      return;
    }
    INowShortVideoProtoManager localINowShortVideoProtoManager = ((INowShortVideoProtoManager)QRoute.api(INowShortVideoProtoManager.class)).init(this.c);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.f);
    localStringBuilder.append("&num=");
    localStringBuilder.append(10);
    localINowShortVideoProtoManager.getMediaDetailInfo(localStringBuilder.toString(), new InfinitePlayListDataModel.1(this));
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
 * Qualified Name:     com.tencent.mobileqq.nearby.now.model.InfinitePlayListDataModel
 * JD-Core Version:    0.7.0.1
 */