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
    paramObject.jdField_a_of_type_JavaLangString = ((FeedsProtocol.PicFeedsInfo)localObject1).feeds_id.get().toStringUtf8();
    paramObject.jdField_f_of_type_Long = ((FeedsProtocol.PicFeedsInfo)localObject1).create_time.get();
    paramObject.jdField_k_of_type_JavaLangString = ((FeedsProtocol.PicFeedsInfo)localObject1).share_url.get().toStringUtf8();
    paramObject.jdField_g_of_type_JavaLangString = ((FeedsProtocol.PicFeedsInfo)localObject1).user_info.anchor_name.get().toStringUtf8();
    paramObject.jdField_a_of_type_Long = ((FeedsProtocol.PicFeedsInfo)localObject1).user_info.uid.get();
    paramObject.jdField_c_of_type_Long = ((FeedsProtocol.PicFeedsInfo)localObject1).user_info.explicit_uid.get();
    paramObject.jdField_b_of_type_Long = ((FeedsProtocol.PicFeedsInfo)localObject1).user_info.tinyid.get();
    paramObject.jdField_d_of_type_Int = ((FeedsProtocol.PicFeedsInfo)localObject1).user_info.id_type.get();
    paramObject.jdField_h_of_type_JavaLangString = ((FeedsProtocol.PicFeedsInfo)localObject1).user_info.anchor_name.get().toStringUtf8();
    paramObject.jdField_d_of_type_Long = ((FeedsProtocol.PicFeedsInfo)localObject1).user_info.uid.get();
    paramObject.jdField_e_of_type_Long = ((FeedsProtocol.PicFeedsInfo)localObject1).user_info.explicit_uid.get();
    paramObject.jdField_h_of_type_Int = ((FeedsProtocol.PicFeedsInfo)localObject1).user_info.id_type.get();
    paramObject.jdField_i_of_type_JavaLangString = ((FeedsProtocol.PicFeedsInfo)localObject1).user_info.head_img_url.get().toStringUtf8();
    int i = ((FeedsProtocol.PicFeedsInfo)localObject1).is_listen.get();
    boolean bool2 = false;
    if (i != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    paramObject.jdField_a_of_type_Boolean = bool1;
    boolean bool1 = bool2;
    if (((FeedsProtocol.PicFeedsInfo)localObject1).is_like.get() != 0) {
      bool1 = true;
    }
    paramObject.jdField_b_of_type_Boolean = bool1;
    paramObject.jdField_c_of_type_Int = ((FeedsProtocol.PicFeedsInfo)localObject1).like_num.get();
    paramObject.jdField_f_of_type_JavaLangString = ((FeedsProtocol.PicFeedsInfo)localObject1).user_info.head_img_url.get().toStringUtf8();
    paramObject.jdField_e_of_type_Int = ((FeedsProtocol.PicFeedsInfo)localObject1).view_times.get();
    paramObject.jdField_f_of_type_Int = ((FeedsProtocol.PicFeedsInfo)localObject1).user_info.age.get();
    paramObject.jdField_g_of_type_Int = ((FeedsProtocol.PicFeedsInfo)localObject1).user_info.user_gender.get();
    paramObject.jdField_h_of_type_Long = ((FeedsProtocol.PicFeedsInfo)localObject1).user_info.uid.get();
    paramObject.jdField_i_of_type_Long = ((FeedsProtocol.PicFeedsInfo)localObject1).user_info.explicit_uid.get();
    paramObject.jdField_i_of_type_Int = ((FeedsProtocol.PicFeedsInfo)localObject1).user_info.id_type.get();
    paramObject.j = "";
    paramObject.jdField_k_of_type_Int = ((FeedsProtocol.PicFeedsInfo)localObject1).feed_type.get();
    paramObject.n = paramInt;
    Iterator localIterator = ((FeedsProtocol.PicFeedsInfo)localObject1).pic_infos.get().iterator();
    Object localObject2;
    while (localIterator.hasNext())
    {
      localObject2 = (FeedsProtocol.PicInfo)localIterator.next();
      paramObject.jdField_a_of_type_JavaUtilArrayList.add(new ImageData(((FeedsProtocol.PicInfo)localObject2).url.get().toStringUtf8(), ((FeedsProtocol.PicInfo)localObject2).width.get(), ((FeedsProtocol.PicInfo)localObject2).hight.get()));
    }
    localIterator = ((FeedsProtocol.PicFeedsInfo)localObject1).rpt_msg_rich_title.get().iterator();
    while (localIterator.hasNext())
    {
      localObject2 = (FeedsProtocol.RichTitleElement)localIterator.next();
      StringBuilder localStringBuilder;
      if (((FeedsProtocol.RichTitleElement)localObject2).type.get() == 1)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramObject.j);
        localStringBuilder.append(((FeedsProtocol.RichTitleElement)localObject2).text.get().toStringUtf8());
        paramObject.j = localStringBuilder.toString();
      }
      else if (((FeedsProtocol.RichTitleElement)localObject2).type.get() == 2)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramObject.j);
        localStringBuilder.append("#");
        localStringBuilder.append(((FeedsProtocol.RichTitleElement)localObject2).text.get().toStringUtf8());
        localStringBuilder.append("#");
        paramObject.j = localStringBuilder.toString();
      }
    }
    if (((FeedsProtocol.PicFeedsInfo)localObject1).lbs_info != null)
    {
      localObject1 = (FeedsProtocol.LbsInfo)((FeedsProtocol.PicFeedsInfo)localObject1).lbs_info.get();
      paramObject.jdField_a_of_type_ComTencentMobileqqNearbyNowModelLocationInfo = new LocationInfo();
      paramObject.jdField_a_of_type_ComTencentMobileqqNearbyNowModelLocationInfo.init(((FeedsProtocol.LbsInfo)localObject1).lng.get().toStringUtf8(), ((FeedsProtocol.LbsInfo)localObject1).lat.get().toStringUtf8(), ((FeedsProtocol.LbsInfo)localObject1).city.get().toStringUtf8(), ((FeedsProtocol.LbsInfo)localObject1).name.get().toStringUtf8());
    }
    else
    {
      paramObject.jdField_a_of_type_ComTencentMobileqqNearbyNowModelLocationInfo = new LocationInfo();
    }
    paramArrayList.add(((IModelUtil)QRoute.api(IModelUtil.class)).parseTopicInfoToVideoData(paramList, paramObject));
    return paramObject;
  }
  
  public VideoData parseShortVideoData(int paramInt, List<Object> paramList, Object paramObject, ArrayList<VideoData> paramArrayList)
  {
    Object localObject = (FeedsProtocol.ShortVideoInfo)paramObject;
    paramObject = new VideoData();
    paramObject.jdField_a_of_type_JavaLangString = ((FeedsProtocol.ShortVideoInfo)localObject).feeds_id.get().toStringUtf8();
    paramObject.jdField_b_of_type_Int = 2;
    paramObject.jdField_f_of_type_Long = ((FeedsProtocol.ShortVideoInfo)localObject).create_time.get();
    paramObject.jdField_d_of_type_JavaLangString = ((FeedsProtocol.ShortVideoInfo)localObject).doodle_pic_url.get().toStringUtf8();
    paramObject.jdField_k_of_type_JavaLangString = ((FeedsProtocol.ShortVideoInfo)localObject).share_url.get().toStringUtf8();
    paramObject.jdField_c_of_type_JavaLangString = ((FeedsProtocol.ShortVideoInfo)localObject).pic_url.get().toStringUtf8();
    paramObject.jdField_b_of_type_JavaLangString = ((FeedsProtocol.ShortVideoInfo)localObject).video_url.get().toStringUtf8();
    paramObject.jdField_g_of_type_JavaLangString = ((FeedsProtocol.UserInfo)((FeedsProtocol.ShortVideoInfo)localObject).anchor_info.get()).anchor_name.get().toStringUtf8();
    paramObject.jdField_a_of_type_Long = ((FeedsProtocol.UserInfo)((FeedsProtocol.ShortVideoInfo)localObject).anchor_info.get()).uid.get();
    paramObject.jdField_c_of_type_Long = ((FeedsProtocol.ShortVideoInfo)localObject).anchor_info.explicit_uid.get();
    paramObject.jdField_b_of_type_Long = ((FeedsProtocol.ShortVideoInfo)localObject).anchor_info.tinyid.get();
    paramObject.jdField_d_of_type_Int = ((FeedsProtocol.ShortVideoInfo)localObject).anchor_info.id_type.get();
    paramObject.jdField_h_of_type_JavaLangString = ((FeedsProtocol.ShortVideoInfo)localObject).user_info.anchor_name.get().toStringUtf8();
    paramObject.jdField_d_of_type_Long = ((FeedsProtocol.ShortVideoInfo)localObject).user_info.uid.get();
    paramObject.jdField_e_of_type_Long = ((FeedsProtocol.ShortVideoInfo)localObject).user_info.explicit_uid.get();
    paramObject.jdField_h_of_type_Int = ((FeedsProtocol.ShortVideoInfo)localObject).user_info.id_type.get();
    paramObject.jdField_i_of_type_JavaLangString = ((FeedsProtocol.ShortVideoInfo)localObject).user_info.head_img_url.get().toStringUtf8();
    int i = ((FeedsProtocol.ShortVideoInfo)localObject).is_listen.get();
    boolean bool2 = false;
    if (i != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    paramObject.jdField_a_of_type_Boolean = bool1;
    boolean bool1 = bool2;
    if (((FeedsProtocol.ShortVideoInfo)localObject).is_like.get() != 0) {
      bool1 = true;
    }
    paramObject.jdField_b_of_type_Boolean = bool1;
    paramObject.jdField_c_of_type_Int = ((FeedsProtocol.ShortVideoInfo)localObject).like_num.get();
    paramObject.jdField_f_of_type_JavaLangString = ((FeedsProtocol.UserInfo)((FeedsProtocol.ShortVideoInfo)localObject).anchor_info.get()).head_img_url.get().toStringUtf8();
    paramObject.jdField_e_of_type_Int = ((FeedsProtocol.ShortVideoInfo)localObject).view_times.get();
    paramObject.jdField_f_of_type_Int = ((FeedsProtocol.ShortVideoInfo)localObject).user_info.age.get();
    paramObject.jdField_g_of_type_Int = ((FeedsProtocol.ShortVideoInfo)localObject).user_info.user_gender.get();
    paramObject.jdField_h_of_type_Long = ((FeedsProtocol.ShortVideoInfo)localObject).user_info.uid.get();
    paramObject.jdField_i_of_type_Long = ((FeedsProtocol.ShortVideoInfo)localObject).user_info.explicit_uid.get();
    paramObject.jdField_i_of_type_Int = ((FeedsProtocol.ShortVideoInfo)localObject).user_info.id_type.get();
    paramObject.j = "";
    paramObject.jdField_k_of_type_Int = ((FeedsProtocol.ShortVideoInfo)localObject).feed_type.get();
    paramObject.l = ((FeedsProtocol.ShortVideoInfo)localObject).video_hight.get();
    paramObject.m = ((FeedsProtocol.ShortVideoInfo)localObject).video_width.get();
    paramObject.jdField_g_of_type_Long = ((FeedsProtocol.ShortVideoInfo)localObject).video_time.get();
    paramObject.n = paramInt;
    Iterator localIterator = ((FeedsProtocol.ShortVideoInfo)localObject).rpt_msg_rich_title.get().iterator();
    while (localIterator.hasNext())
    {
      FeedsProtocol.RichTitleElement localRichTitleElement = (FeedsProtocol.RichTitleElement)localIterator.next();
      StringBuilder localStringBuilder;
      if (localRichTitleElement.type.get() == 1)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramObject.j);
        localStringBuilder.append(localRichTitleElement.text.get().toStringUtf8());
        paramObject.j = localStringBuilder.toString();
      }
      else if (localRichTitleElement.type.get() == 2)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramObject.j);
        localStringBuilder.append("#");
        localStringBuilder.append(localRichTitleElement.text.get().toStringUtf8());
        localStringBuilder.append("#");
        paramObject.j = localStringBuilder.toString();
      }
    }
    if (((FeedsProtocol.ShortVideoInfo)localObject).lbs_info.get() != null)
    {
      localObject = (FeedsProtocol.LbsInfo)((FeedsProtocol.ShortVideoInfo)localObject).lbs_info.get();
      paramObject.jdField_a_of_type_ComTencentMobileqqNearbyNowModelLocationInfo = new LocationInfo();
      paramObject.jdField_a_of_type_ComTencentMobileqqNearbyNowModelLocationInfo.init(((FeedsProtocol.LbsInfo)localObject).lng.get().toStringUtf8(), ((FeedsProtocol.LbsInfo)localObject).lat.get().toStringUtf8(), ((FeedsProtocol.LbsInfo)localObject).city.get().toStringUtf8(), ((FeedsProtocol.LbsInfo)localObject).name.get().toStringUtf8());
    }
    else
    {
      paramObject.jdField_a_of_type_ComTencentMobileqqNearbyNowModelLocationInfo = new LocationInfo();
    }
    paramArrayList.add(((IModelUtil)QRoute.api(IModelUtil.class)).parseTopicInfoToVideoData(paramList, paramObject));
    return paramObject;
  }
  
  public void parseTextFeeds(int paramInt, List<Object> paramList, Object paramObject, ArrayList<VideoData> paramArrayList)
  {
    Object localObject = (FeedsProtocol.TextFeed)paramObject;
    paramObject = new VideoData();
    paramObject.jdField_a_of_type_JavaLangString = ((FeedsProtocol.TextFeed)localObject).feeds_id.get();
    paramObject.jdField_f_of_type_Long = ((FeedsProtocol.TextFeed)localObject).create_time.get();
    paramObject.jdField_k_of_type_JavaLangString = ((FeedsProtocol.TextFeed)localObject).share_url.get();
    paramObject.jdField_b_of_type_Int = VideoData.jdField_a_of_type_Int;
    paramObject.jdField_g_of_type_JavaLangString = ((FeedsProtocol.TextFeed)localObject).user_info.anchor_name.get().toStringUtf8();
    paramObject.jdField_a_of_type_Long = ((FeedsProtocol.TextFeed)localObject).user_info.uid.get();
    paramObject.jdField_c_of_type_Long = ((FeedsProtocol.TextFeed)localObject).user_info.explicit_uid.get();
    paramObject.jdField_b_of_type_Long = ((FeedsProtocol.TextFeed)localObject).user_info.tinyid.get();
    paramObject.jdField_d_of_type_Int = ((FeedsProtocol.TextFeed)localObject).user_info.id_type.get();
    paramObject.jdField_h_of_type_JavaLangString = ((FeedsProtocol.TextFeed)localObject).user_info.anchor_name.get().toStringUtf8();
    paramObject.jdField_d_of_type_Long = ((FeedsProtocol.TextFeed)localObject).user_info.uid.get();
    paramObject.jdField_e_of_type_Long = ((FeedsProtocol.TextFeed)localObject).user_info.explicit_uid.get();
    paramObject.jdField_h_of_type_Int = ((FeedsProtocol.TextFeed)localObject).user_info.id_type.get();
    paramObject.jdField_i_of_type_JavaLangString = ((FeedsProtocol.TextFeed)localObject).user_info.head_img_url.get().toStringUtf8();
    paramObject.jdField_f_of_type_JavaLangString = ((FeedsProtocol.TextFeed)localObject).user_info.head_img_url.get().toStringUtf8();
    paramObject.jdField_f_of_type_Int = ((FeedsProtocol.TextFeed)localObject).user_info.age.get();
    paramObject.jdField_g_of_type_Int = ((FeedsProtocol.TextFeed)localObject).user_info.user_gender.get();
    paramObject.jdField_h_of_type_Long = ((FeedsProtocol.TextFeed)localObject).user_info.uid.get();
    paramObject.jdField_i_of_type_Long = ((FeedsProtocol.TextFeed)localObject).user_info.explicit_uid.get();
    paramObject.jdField_i_of_type_Int = ((FeedsProtocol.TextFeed)localObject).user_info.id_type.get();
    int i = ((FeedsProtocol.TextFeed)localObject).is_listen.get();
    boolean bool2 = false;
    if (i != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    paramObject.jdField_a_of_type_Boolean = bool1;
    boolean bool1 = bool2;
    if (((FeedsProtocol.TextFeed)localObject).is_like.get() != 0) {
      bool1 = true;
    }
    paramObject.jdField_b_of_type_Boolean = bool1;
    paramObject.jdField_c_of_type_Int = ((FeedsProtocol.TextFeed)localObject).like_num.get();
    paramObject.jdField_f_of_type_JavaLangString = ((FeedsProtocol.TextFeed)localObject).user_info.head_img_url.get().toStringUtf8();
    paramObject.jdField_e_of_type_Int = ((FeedsProtocol.TextFeed)localObject).view_times.get();
    paramObject.jdField_k_of_type_Int = VideoData.jdField_a_of_type_Int;
    paramObject.n = paramInt;
    paramObject.j = "";
    Iterator localIterator = ((FeedsProtocol.TextFeed)localObject).rpt_msg_rich_title.get().iterator();
    while (localIterator.hasNext())
    {
      FeedsProtocol.RichTitleElement localRichTitleElement = (FeedsProtocol.RichTitleElement)localIterator.next();
      StringBuilder localStringBuilder;
      if (localRichTitleElement.type.get() == 1)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramObject.j);
        localStringBuilder.append(localRichTitleElement.text.get().toStringUtf8());
        paramObject.j = localStringBuilder.toString();
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
      paramObject.jdField_a_of_type_ComTencentMobileqqNearbyNowModelLocationInfo = new LocationInfo();
      paramObject.jdField_a_of_type_ComTencentMobileqqNearbyNowModelLocationInfo.init(((FeedsProtocol.LbsInfo)localObject).lng.get().toStringUtf8(), ((FeedsProtocol.LbsInfo)localObject).lat.get().toStringUtf8(), ((FeedsProtocol.LbsInfo)localObject).city.get().toStringUtf8(), ((FeedsProtocol.LbsInfo)localObject).name.get().toStringUtf8());
    }
    else
    {
      paramObject.jdField_a_of_type_ComTencentMobileqqNearbyNowModelLocationInfo = new LocationInfo();
    }
    paramArrayList.add(((IModelUtil)QRoute.api(IModelUtil.class)).parseTopicInfoToVideoData(paramList, paramObject));
  }
  
  public VideoData parseTopicInfoToVideoData(List<Object> paramList, VideoData paramVideoData)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      paramList = (FeedsProtocol.TopicCfg)paramList.get(0);
      paramVideoData.jdField_a_of_type_ComTencentMobileqqNearbyNowModelTopicInfo = new TopicInfo();
      paramVideoData.jdField_a_of_type_ComTencentMobileqqNearbyNowModelTopicInfo.d(paramList.jump_url.get());
      paramVideoData.jdField_a_of_type_ComTencentMobileqqNearbyNowModelTopicInfo.b(paramList.topic_name.get());
      paramVideoData.jdField_a_of_type_ComTencentMobileqqNearbyNowModelTopicInfo.a(paramList.topic_desc.get());
      paramVideoData.jdField_a_of_type_ComTencentMobileqqNearbyNowModelTopicInfo.b(paramList.topic_parti_num.get());
      paramVideoData.jdField_a_of_type_ComTencentMobileqqNearbyNowModelTopicInfo.c(paramList.topic_pic_url.get());
      paramVideoData.jdField_a_of_type_ComTencentMobileqqNearbyNowModelTopicInfo.a(paramList.topic_tag.get());
      paramVideoData.jdField_a_of_type_ComTencentMobileqqNearbyNowModelTopicInfo.c(paramList.topic_type.get());
    }
    return paramVideoData;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.model.impl.ModelUtilImpl
 * JD-Core Version:    0.7.0.1
 */