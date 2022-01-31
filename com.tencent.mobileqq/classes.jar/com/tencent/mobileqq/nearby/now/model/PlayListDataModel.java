package com.tencent.mobileqq.nearby.now.model;

import afbf;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.mobileqq.nearby.now.protocol.NowShortVideoProtoManager;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.pb.now.FeedsProtocol.GetMediaDetailRsp;
import com.tencent.pb.now.FeedsProtocol.LbsInfo;
import com.tencent.pb.now.FeedsProtocol.MediaInfo;
import com.tencent.pb.now.FeedsProtocol.PicFeedsInfo;
import com.tencent.pb.now.FeedsProtocol.PicInfo;
import com.tencent.pb.now.FeedsProtocol.RichTitleElement;
import com.tencent.pb.now.FeedsProtocol.ShortVideoInfo;
import com.tencent.pb.now.FeedsProtocol.UserInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PlayListDataModel
  extends BasePlayListDataModel
{
  private String a;
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString;
  
  public PlayListDataModel()
  {
    this.jdField_a_of_type_JavaLangString = "PlayListDataModel";
  }
  
  private VideoData a(FeedsProtocol.PicFeedsInfo paramPicFeedsInfo, ArrayList paramArrayList)
  {
    boolean bool2 = false;
    VideoData localVideoData = new VideoData();
    localVideoData.jdField_a_of_type_JavaLangString = paramPicFeedsInfo.feeds_id.get().toStringUtf8();
    localVideoData.jdField_c_of_type_Long = paramPicFeedsInfo.create_time.get();
    localVideoData.k = paramPicFeedsInfo.share_url.get().toStringUtf8();
    localVideoData.jdField_g_of_type_JavaLangString = paramPicFeedsInfo.user_info.anchor_name.get().toStringUtf8();
    localVideoData.jdField_a_of_type_Long = paramPicFeedsInfo.user_info.uid.get();
    localVideoData.jdField_h_of_type_JavaLangString = paramPicFeedsInfo.user_info.anchor_name.get().toStringUtf8();
    localVideoData.jdField_b_of_type_Long = paramPicFeedsInfo.user_info.uid.get();
    localVideoData.jdField_i_of_type_JavaLangString = paramPicFeedsInfo.user_info.head_img_url.get().toStringUtf8();
    if (paramPicFeedsInfo.is_listen.get() != 0) {}
    Object localObject;
    for (boolean bool1 = true;; bool1 = false)
    {
      localVideoData.jdField_a_of_type_Boolean = bool1;
      bool1 = bool2;
      if (paramPicFeedsInfo.is_like.get() != 0) {
        bool1 = true;
      }
      localVideoData.jdField_b_of_type_Boolean = bool1;
      localVideoData.jdField_b_of_type_Int = paramPicFeedsInfo.like_num.get();
      localVideoData.f = paramPicFeedsInfo.user_info.head_img_url.get().toStringUtf8();
      localVideoData.jdField_c_of_type_Int = paramPicFeedsInfo.view_times.get();
      localVideoData.jdField_d_of_type_Int = paramPicFeedsInfo.user_info.age.get();
      localVideoData.jdField_e_of_type_Int = paramPicFeedsInfo.user_info.user_gender.get();
      localVideoData.jdField_e_of_type_Long = paramPicFeedsInfo.user_info.uid.get();
      localVideoData.j = "";
      localVideoData.jdField_g_of_type_Int = paramPicFeedsInfo.feed_type.get();
      localIterator = paramPicFeedsInfo.pic_infos.get().iterator();
      while (localIterator.hasNext())
      {
        localObject = (FeedsProtocol.PicInfo)localIterator.next();
        localVideoData.jdField_a_of_type_JavaUtilArrayList.add(new ImageData(((FeedsProtocol.PicInfo)localObject).url.get().toStringUtf8(), ((FeedsProtocol.PicInfo)localObject).width.get(), ((FeedsProtocol.PicInfo)localObject).hight.get()));
      }
    }
    Iterator localIterator = paramPicFeedsInfo.rpt_msg_rich_title.get().iterator();
    while (localIterator.hasNext())
    {
      localObject = (FeedsProtocol.RichTitleElement)localIterator.next();
      if (((FeedsProtocol.RichTitleElement)localObject).type.get() == 1) {
        localVideoData.j += ((FeedsProtocol.RichTitleElement)localObject).text.get().toStringUtf8();
      } else if (((FeedsProtocol.RichTitleElement)localObject).type.get() == 2) {
        localVideoData.j = (localVideoData.j + "#" + ((FeedsProtocol.RichTitleElement)localObject).text.get().toStringUtf8() + "#");
      }
    }
    if (paramPicFeedsInfo.lbs_info != null)
    {
      paramPicFeedsInfo = (FeedsProtocol.LbsInfo)paramPicFeedsInfo.lbs_info.get();
      localVideoData.jdField_a_of_type_ComTencentMobileqqNearbyNowModelLocationInfo = new LocationInfo();
      localVideoData.jdField_a_of_type_ComTencentMobileqqNearbyNowModelLocationInfo.init(paramPicFeedsInfo.lng.get().toStringUtf8(), paramPicFeedsInfo.lat.get().toStringUtf8(), paramPicFeedsInfo.city.get().toStringUtf8(), paramPicFeedsInfo.name.get().toStringUtf8());
    }
    for (;;)
    {
      paramArrayList.add(localVideoData);
      return localVideoData;
      localVideoData.jdField_a_of_type_ComTencentMobileqqNearbyNowModelLocationInfo = new LocationInfo();
    }
  }
  
  private VideoData a(FeedsProtocol.ShortVideoInfo paramShortVideoInfo, ArrayList paramArrayList)
  {
    boolean bool2 = false;
    VideoData localVideoData = new VideoData();
    localVideoData.jdField_a_of_type_JavaLangString = paramShortVideoInfo.feeds_id.get().toStringUtf8();
    localVideoData.jdField_a_of_type_Int = 2;
    localVideoData.jdField_c_of_type_Long = paramShortVideoInfo.create_time.get();
    localVideoData.jdField_d_of_type_JavaLangString = paramShortVideoInfo.doodle_pic_url.get().toStringUtf8();
    localVideoData.k = paramShortVideoInfo.share_url.get().toStringUtf8();
    localVideoData.jdField_c_of_type_JavaLangString = paramShortVideoInfo.pic_url.get().toStringUtf8();
    localVideoData.jdField_b_of_type_JavaLangString = paramShortVideoInfo.video_url.get().toStringUtf8();
    localVideoData.jdField_g_of_type_JavaLangString = ((FeedsProtocol.UserInfo)paramShortVideoInfo.anchor_info.get()).anchor_name.get().toStringUtf8();
    localVideoData.jdField_a_of_type_Long = ((FeedsProtocol.UserInfo)paramShortVideoInfo.anchor_info.get()).uid.get();
    localVideoData.jdField_h_of_type_JavaLangString = paramShortVideoInfo.user_info.anchor_name.get().toStringUtf8();
    localVideoData.jdField_b_of_type_Long = paramShortVideoInfo.user_info.uid.get();
    localVideoData.jdField_i_of_type_JavaLangString = paramShortVideoInfo.user_info.head_img_url.get().toStringUtf8();
    boolean bool1;
    Iterator localIterator;
    if (paramShortVideoInfo.is_listen.get() != 0)
    {
      bool1 = true;
      localVideoData.jdField_a_of_type_Boolean = bool1;
      bool1 = bool2;
      if (paramShortVideoInfo.is_like.get() != 0) {
        bool1 = true;
      }
      localVideoData.jdField_b_of_type_Boolean = bool1;
      localVideoData.jdField_b_of_type_Int = paramShortVideoInfo.like_num.get();
      localVideoData.f = ((FeedsProtocol.UserInfo)paramShortVideoInfo.anchor_info.get()).head_img_url.get().toStringUtf8();
      localVideoData.jdField_c_of_type_Int = paramShortVideoInfo.view_times.get();
      localVideoData.jdField_d_of_type_Int = paramShortVideoInfo.user_info.age.get();
      localVideoData.jdField_e_of_type_Int = paramShortVideoInfo.user_info.user_gender.get();
      localVideoData.jdField_e_of_type_Long = paramShortVideoInfo.follow_uid.get();
      localVideoData.j = "";
      localVideoData.jdField_g_of_type_Int = paramShortVideoInfo.feed_type.get();
      localVideoData.jdField_h_of_type_Int = paramShortVideoInfo.video_hight.get();
      localVideoData.jdField_i_of_type_Int = paramShortVideoInfo.video_width.get();
      localVideoData.jdField_d_of_type_Long = paramShortVideoInfo.video_time.get();
      localIterator = paramShortVideoInfo.rpt_msg_rich_title.get().iterator();
    }
    for (;;)
    {
      if (!localIterator.hasNext()) {
        break label541;
      }
      FeedsProtocol.RichTitleElement localRichTitleElement = (FeedsProtocol.RichTitleElement)localIterator.next();
      if (localRichTitleElement.type.get() == 1)
      {
        localVideoData.j += localRichTitleElement.text.get().toStringUtf8();
        continue;
        bool1 = false;
        break;
      }
      if (localRichTitleElement.type.get() == 2) {
        localVideoData.j = (localVideoData.j + "#" + localRichTitleElement.text.get().toStringUtf8() + "#");
      }
    }
    label541:
    if (paramShortVideoInfo.lbs_info.get() != null)
    {
      paramShortVideoInfo = (FeedsProtocol.LbsInfo)paramShortVideoInfo.lbs_info.get();
      localVideoData.jdField_a_of_type_ComTencentMobileqqNearbyNowModelLocationInfo = new LocationInfo();
      localVideoData.jdField_a_of_type_ComTencentMobileqqNearbyNowModelLocationInfo.init(paramShortVideoInfo.lng.get().toStringUtf8(), paramShortVideoInfo.lat.get().toStringUtf8(), paramShortVideoInfo.city.get().toStringUtf8(), paramShortVideoInfo.name.get().toStringUtf8());
    }
    for (;;)
    {
      paramArrayList.add(localVideoData);
      return localVideoData;
      localVideoData.jdField_a_of_type_ComTencentMobileqqNearbyNowModelLocationInfo = new LocationInfo();
    }
  }
  
  private void a(FeedsProtocol.GetMediaDetailRsp paramGetMediaDetailRsp)
  {
    paramGetMediaDetailRsp = paramGetMediaDetailRsp.media_list.get().iterator();
    while (paramGetMediaDetailRsp.hasNext())
    {
      FeedsProtocol.MediaInfo localMediaInfo = (FeedsProtocol.MediaInfo)paramGetMediaDetailRsp.next();
      if ((localMediaInfo.type.get() != 1) && (localMediaInfo.type.get() != 2)) {
        if (localMediaInfo.type.get() == 3) {
          a((FeedsProtocol.ShortVideoInfo)localMediaInfo.short_video.get(), this.jdField_a_of_type_JavaUtilArrayList);
        } else if (localMediaInfo.type.get() == 5) {
          a((FeedsProtocol.PicFeedsInfo)localMediaInfo.pic_info.get(), this.jdField_a_of_type_JavaUtilArrayList);
        }
      }
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    new NowShortVideoProtoManager(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).b(this.jdField_b_of_type_JavaLangString + "&start=" + this.jdField_b_of_type_Int + "&num=" + 10, new afbf(this));
  }
  
  public void a(Bundle paramBundle)
  {
    if ("1".equals(paramBundle.getString("isLocal"))) {
      return;
    }
    this.jdField_b_of_type_JavaLangString = Uri.parse(paramBundle.getString("raw_url")).getQuery();
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.model.PlayListDataModel
 * JD-Core Version:    0.7.0.1
 */