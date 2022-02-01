package com.tencent.mobileqq.nearby.now.model.impl;

import com.tencent.mobileqq.nearby.now.model.IModelUtil;
import com.tencent.mobileqq.nearby.now.model.ImageData;
import com.tencent.mobileqq.nearby.now.model.LocationInfo;
import com.tencent.mobileqq.nearby.now.model.TopicInfo;
import com.tencent.mobileqq.nearby.now.model.VideoData;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.pb.now.FeedsProtocol.LbsInfo;
import com.tencent.pb.now.FeedsProtocol.PicFeedsInfo;
import com.tencent.pb.now.FeedsProtocol.PicInfo;
import com.tencent.pb.now.FeedsProtocol.RichTitleElement;
import com.tencent.pb.now.FeedsProtocol.ShortVideoInfo;
import com.tencent.pb.now.FeedsProtocol.TextFeed;
import com.tencent.pb.now.FeedsProtocol.TopicCfg;
import com.tencent.pb.now.FeedsProtocol.UserInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ModelUtilImpl
  implements IModelUtil
{
  public int getFeedsProtocolMediaInfoTextFeeds()
  {
    return 6;
  }
  
  public VideoData parseImageData(int paramInt, List<Object> paramList, Object paramObject, ArrayList<VideoData> paramArrayList)
  {
    Object localObject1 = (FeedsProtocol.PicFeedsInfo)paramObject;
    paramObject = new VideoData();
    paramObject.c = ((FeedsProtocol.PicFeedsInfo)localObject1).feeds_id.get().toStringUtf8();
    paramObject.y = ((FeedsProtocol.PicFeedsInfo)localObject1).create_time.get();
    paramObject.B = ((FeedsProtocol.PicFeedsInfo)localObject1).share_url.get().toStringUtf8();
    paramObject.s = ((FeedsProtocol.PicFeedsInfo)localObject1).user_info.anchor_name.get().toStringUtf8();
    paramObject.i = ((FeedsProtocol.PicFeedsInfo)localObject1).user_info.uid.get();
    paramObject.k = ((FeedsProtocol.PicFeedsInfo)localObject1).user_info.explicit_uid.get();
    paramObject.j = ((FeedsProtocol.PicFeedsInfo)localObject1).user_info.tinyid.get();
    paramObject.l = ((FeedsProtocol.PicFeedsInfo)localObject1).user_info.id_type.get();
    paramObject.t = ((FeedsProtocol.PicFeedsInfo)localObject1).user_info.anchor_name.get().toStringUtf8();
    paramObject.u = ((FeedsProtocol.PicFeedsInfo)localObject1).user_info.uid.get();
    paramObject.v = ((FeedsProtocol.PicFeedsInfo)localObject1).user_info.explicit_uid.get();
    paramObject.w = ((FeedsProtocol.PicFeedsInfo)localObject1).user_info.id_type.get();
    paramObject.x = ((FeedsProtocol.PicFeedsInfo)localObject1).user_info.head_img_url.get().toStringUtf8();
    int i = ((FeedsProtocol.PicFeedsInfo)localObject1).is_listen.get();
    boolean bool2 = false;
    if (i != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    paramObject.n = bool1;
    boolean bool1 = bool2;
    if (((FeedsProtocol.PicFeedsInfo)localObject1).is_like.get() != 0) {
      bool1 = true;
    }
    paramObject.o = bool1;
    paramObject.h = ((FeedsProtocol.PicFeedsInfo)localObject1).like_num.get();
    paramObject.m = ((FeedsProtocol.PicFeedsInfo)localObject1).user_info.head_img_url.get().toStringUtf8();
    paramObject.p = ((FeedsProtocol.PicFeedsInfo)localObject1).view_times.get();
    paramObject.q = ((FeedsProtocol.PicFeedsInfo)localObject1).user_info.age.get();
    paramObject.r = ((FeedsProtocol.PicFeedsInfo)localObject1).user_info.user_gender.get();
    paramObject.C = ((FeedsProtocol.PicFeedsInfo)localObject1).user_info.uid.get();
    paramObject.D = ((FeedsProtocol.PicFeedsInfo)localObject1).user_info.explicit_uid.get();
    paramObject.E = ((FeedsProtocol.PicFeedsInfo)localObject1).user_info.id_type.get();
    paramObject.A = "";
    paramObject.G = ((FeedsProtocol.PicFeedsInfo)localObject1).feed_type.get();
    paramObject.O = paramInt;
    Iterator localIterator = ((FeedsProtocol.PicFeedsInfo)localObject1).pic_infos.get().iterator();
    Object localObject2;
    while (localIterator.hasNext())
    {
      localObject2 = (FeedsProtocol.PicInfo)localIterator.next();
      paramObject.M.add(new ImageData(((FeedsProtocol.PicInfo)localObject2).url.get().toStringUtf8(), ((FeedsProtocol.PicInfo)localObject2).width.get(), ((FeedsProtocol.PicInfo)localObject2).hight.get()));
    }
    localIterator = ((FeedsProtocol.PicFeedsInfo)localObject1).rpt_msg_rich_title.get().iterator();
    while (localIterator.hasNext())
    {
      localObject2 = (FeedsProtocol.RichTitleElement)localIterator.next();
      StringBuilder localStringBuilder;
      if (((FeedsProtocol.RichTitleElement)localObject2).type.get() == 1)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramObject.A);
        localStringBuilder.append(((FeedsProtocol.RichTitleElement)localObject2).text.get().toStringUtf8());
        paramObject.A = localStringBuilder.toString();
      }
      else if (((FeedsProtocol.RichTitleElement)localObject2).type.get() == 2)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramObject.A);
        localStringBuilder.append("#");
        localStringBuilder.append(((FeedsProtocol.RichTitleElement)localObject2).text.get().toStringUtf8());
        localStringBuilder.append("#");
        paramObject.A = localStringBuilder.toString();
      }
    }
    if (((FeedsProtocol.PicFeedsInfo)localObject1).lbs_info != null)
    {
      localObject1 = (FeedsProtocol.LbsInfo)((FeedsProtocol.PicFeedsInfo)localObject1).lbs_info.get();
      paramObject.J = new LocationInfo();
      paramObject.J.init(((FeedsProtocol.LbsInfo)localObject1).lng.get().toStringUtf8(), ((FeedsProtocol.LbsInfo)localObject1).lat.get().toStringUtf8(), ((FeedsProtocol.LbsInfo)localObject1).city.get().toStringUtf8(), ((FeedsProtocol.LbsInfo)localObject1).name.get().toStringUtf8());
    }
    else
    {
      paramObject.J = new LocationInfo();
    }
    paramArrayList.add(((IModelUtil)QRoute.api(IModelUtil.class)).parseTopicInfoToVideoData(paramList, paramObject));
    return paramObject;
  }
  
  public VideoData parseShortVideoData(int paramInt, List<Object> paramList, Object paramObject, ArrayList<VideoData> paramArrayList)
  {
    Object localObject = (FeedsProtocol.ShortVideoInfo)paramObject;
    paramObject = new VideoData();
    paramObject.c = ((FeedsProtocol.ShortVideoInfo)localObject).feeds_id.get().toStringUtf8();
    paramObject.b = 2;
    paramObject.y = ((FeedsProtocol.ShortVideoInfo)localObject).create_time.get();
    paramObject.f = ((FeedsProtocol.ShortVideoInfo)localObject).doodle_pic_url.get().toStringUtf8();
    paramObject.B = ((FeedsProtocol.ShortVideoInfo)localObject).share_url.get().toStringUtf8();
    paramObject.e = ((FeedsProtocol.ShortVideoInfo)localObject).pic_url.get().toStringUtf8();
    paramObject.d = ((FeedsProtocol.ShortVideoInfo)localObject).video_url.get().toStringUtf8();
    paramObject.s = ((FeedsProtocol.UserInfo)((FeedsProtocol.ShortVideoInfo)localObject).anchor_info.get()).anchor_name.get().toStringUtf8();
    paramObject.i = ((FeedsProtocol.UserInfo)((FeedsProtocol.ShortVideoInfo)localObject).anchor_info.get()).uid.get();
    paramObject.k = ((FeedsProtocol.ShortVideoInfo)localObject).anchor_info.explicit_uid.get();
    paramObject.j = ((FeedsProtocol.ShortVideoInfo)localObject).anchor_info.tinyid.get();
    paramObject.l = ((FeedsProtocol.ShortVideoInfo)localObject).anchor_info.id_type.get();
    paramObject.t = ((FeedsProtocol.ShortVideoInfo)localObject).user_info.anchor_name.get().toStringUtf8();
    paramObject.u = ((FeedsProtocol.ShortVideoInfo)localObject).user_info.uid.get();
    paramObject.v = ((FeedsProtocol.ShortVideoInfo)localObject).user_info.explicit_uid.get();
    paramObject.w = ((FeedsProtocol.ShortVideoInfo)localObject).user_info.id_type.get();
    paramObject.x = ((FeedsProtocol.ShortVideoInfo)localObject).user_info.head_img_url.get().toStringUtf8();
    int i = ((FeedsProtocol.ShortVideoInfo)localObject).is_listen.get();
    boolean bool2 = false;
    if (i != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    paramObject.n = bool1;
    boolean bool1 = bool2;
    if (((FeedsProtocol.ShortVideoInfo)localObject).is_like.get() != 0) {
      bool1 = true;
    }
    paramObject.o = bool1;
    paramObject.h = ((FeedsProtocol.ShortVideoInfo)localObject).like_num.get();
    paramObject.m = ((FeedsProtocol.UserInfo)((FeedsProtocol.ShortVideoInfo)localObject).anchor_info.get()).head_img_url.get().toStringUtf8();
    paramObject.p = ((FeedsProtocol.ShortVideoInfo)localObject).view_times.get();
    paramObject.q = ((FeedsProtocol.ShortVideoInfo)localObject).user_info.age.get();
    paramObject.r = ((FeedsProtocol.ShortVideoInfo)localObject).user_info.user_gender.get();
    paramObject.C = ((FeedsProtocol.ShortVideoInfo)localObject).user_info.uid.get();
    paramObject.D = ((FeedsProtocol.ShortVideoInfo)localObject).user_info.explicit_uid.get();
    paramObject.E = ((FeedsProtocol.ShortVideoInfo)localObject).user_info.id_type.get();
    paramObject.A = "";
    paramObject.G = ((FeedsProtocol.ShortVideoInfo)localObject).feed_type.get();
    paramObject.H = ((FeedsProtocol.ShortVideoInfo)localObject).video_hight.get();
    paramObject.I = ((FeedsProtocol.ShortVideoInfo)localObject).video_width.get();
    paramObject.z = ((FeedsProtocol.ShortVideoInfo)localObject).video_time.get();
    paramObject.O = paramInt;
    Iterator localIterator = ((FeedsProtocol.ShortVideoInfo)localObject).rpt_msg_rich_title.get().iterator();
    while (localIterator.hasNext())
    {
      FeedsProtocol.RichTitleElement localRichTitleElement = (FeedsProtocol.RichTitleElement)localIterator.next();
      StringBuilder localStringBuilder;
      if (localRichTitleElement.type.get() == 1)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramObject.A);
        localStringBuilder.append(localRichTitleElement.text.get().toStringUtf8());
        paramObject.A = localStringBuilder.toString();
      }
      else if (localRichTitleElement.type.get() == 2)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramObject.A);
        localStringBuilder.append("#");
        localStringBuilder.append(localRichTitleElement.text.get().toStringUtf8());
        localStringBuilder.append("#");
        paramObject.A = localStringBuilder.toString();
      }
    }
    if (((FeedsProtocol.ShortVideoInfo)localObject).lbs_info.get() != null)
    {
      localObject = (FeedsProtocol.LbsInfo)((FeedsProtocol.ShortVideoInfo)localObject).lbs_info.get();
      paramObject.J = new LocationInfo();
      paramObject.J.init(((FeedsProtocol.LbsInfo)localObject).lng.get().toStringUtf8(), ((FeedsProtocol.LbsInfo)localObject).lat.get().toStringUtf8(), ((FeedsProtocol.LbsInfo)localObject).city.get().toStringUtf8(), ((FeedsProtocol.LbsInfo)localObject).name.get().toStringUtf8());
    }
    else
    {
      paramObject.J = new LocationInfo();
    }
    paramArrayList.add(((IModelUtil)QRoute.api(IModelUtil.class)).parseTopicInfoToVideoData(paramList, paramObject));
    return paramObject;
  }
  
  public void parseTextFeeds(int paramInt, List<Object> paramList, Object paramObject, ArrayList<VideoData> paramArrayList)
  {
    Object localObject = (FeedsProtocol.TextFeed)paramObject;
    paramObject = new VideoData();
    paramObject.c = ((FeedsProtocol.TextFeed)localObject).feeds_id.get();
    paramObject.y = ((FeedsProtocol.TextFeed)localObject).create_time.get();
    paramObject.B = ((FeedsProtocol.TextFeed)localObject).share_url.get();
    paramObject.b = VideoData.a;
    paramObject.s = ((FeedsProtocol.TextFeed)localObject).user_info.anchor_name.get().toStringUtf8();
    paramObject.i = ((FeedsProtocol.TextFeed)localObject).user_info.uid.get();
    paramObject.k = ((FeedsProtocol.TextFeed)localObject).user_info.explicit_uid.get();
    paramObject.j = ((FeedsProtocol.TextFeed)localObject).user_info.tinyid.get();
    paramObject.l = ((FeedsProtocol.TextFeed)localObject).user_info.id_type.get();
    paramObject.t = ((FeedsProtocol.TextFeed)localObject).user_info.anchor_name.get().toStringUtf8();
    paramObject.u = ((FeedsProtocol.TextFeed)localObject).user_info.uid.get();
    paramObject.v = ((FeedsProtocol.TextFeed)localObject).user_info.explicit_uid.get();
    paramObject.w = ((FeedsProtocol.TextFeed)localObject).user_info.id_type.get();
    paramObject.x = ((FeedsProtocol.TextFeed)localObject).user_info.head_img_url.get().toStringUtf8();
    paramObject.m = ((FeedsProtocol.TextFeed)localObject).user_info.head_img_url.get().toStringUtf8();
    paramObject.q = ((FeedsProtocol.TextFeed)localObject).user_info.age.get();
    paramObject.r = ((FeedsProtocol.TextFeed)localObject).user_info.user_gender.get();
    paramObject.C = ((FeedsProtocol.TextFeed)localObject).user_info.uid.get();
    paramObject.D = ((FeedsProtocol.TextFeed)localObject).user_info.explicit_uid.get();
    paramObject.E = ((FeedsProtocol.TextFeed)localObject).user_info.id_type.get();
    int i = ((FeedsProtocol.TextFeed)localObject).is_listen.get();
    boolean bool2 = false;
    if (i != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    paramObject.n = bool1;
    boolean bool1 = bool2;
    if (((FeedsProtocol.TextFeed)localObject).is_like.get() != 0) {
      bool1 = true;
    }
    paramObject.o = bool1;
    paramObject.h = ((FeedsProtocol.TextFeed)localObject).like_num.get();
    paramObject.m = ((FeedsProtocol.TextFeed)localObject).user_info.head_img_url.get().toStringUtf8();
    paramObject.p = ((FeedsProtocol.TextFeed)localObject).view_times.get();
    paramObject.G = VideoData.a;
    paramObject.O = paramInt;
    paramObject.A = "";
    Iterator localIterator = ((FeedsProtocol.TextFeed)localObject).rpt_msg_rich_title.get().iterator();
    while (localIterator.hasNext())
    {
      FeedsProtocol.RichTitleElement localRichTitleElement = (FeedsProtocol.RichTitleElement)localIterator.next();
      StringBuilder localStringBuilder;
      if (localRichTitleElement.type.get() == 1)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramObject.A);
        localStringBuilder.append(localRichTitleElement.text.get().toStringUtf8());
        paramObject.A = localStringBuilder.toString();
      }
      else if (localRichTitleElement.type.get() == 2)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("#");
        localStringBuilder.append(localRichTitleElement.text.get().toStringUtf8());
        localStringBuilder.append("#");
        localStringBuilder.toString();
      }
    }
    if (((FeedsProtocol.TextFeed)localObject).lbs_info != null)
    {
      localObject = (FeedsProtocol.LbsInfo)((FeedsProtocol.TextFeed)localObject).lbs_info.get();
      paramObject.J = new LocationInfo();
      paramObject.J.init(((FeedsProtocol.LbsInfo)localObject).lng.get().toStringUtf8(), ((FeedsProtocol.LbsInfo)localObject).lat.get().toStringUtf8(), ((FeedsProtocol.LbsInfo)localObject).city.get().toStringUtf8(), ((FeedsProtocol.LbsInfo)localObject).name.get().toStringUtf8());
    }
    else
    {
      paramObject.J = new LocationInfo();
    }
    paramArrayList.add(((IModelUtil)QRoute.api(IModelUtil.class)).parseTopicInfoToVideoData(paramList, paramObject));
  }
  
  public VideoData parseTopicInfoToVideoData(List<Object> paramList, VideoData paramVideoData)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      paramList = (FeedsProtocol.TopicCfg)paramList.get(0);
      paramVideoData.N = new TopicInfo();
      paramVideoData.N.d(paramList.jump_url.get());
      paramVideoData.N.b(paramList.topic_name.get());
      paramVideoData.N.a(paramList.topic_desc.get());
      paramVideoData.N.b(paramList.topic_parti_num.get());
      paramVideoData.N.c(paramList.topic_pic_url.get());
      paramVideoData.N.a(paramList.topic_tag.get());
      paramVideoData.N.c(paramList.topic_type.get());
    }
    return paramVideoData;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.model.impl.ModelUtilImpl
 * JD-Core Version:    0.7.0.1
 */