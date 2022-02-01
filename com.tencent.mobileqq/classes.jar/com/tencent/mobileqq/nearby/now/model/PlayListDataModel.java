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
  private String a;
  private int jdField_b_of_type_Int = 0;
  private String jdField_b_of_type_JavaLangString;
  
  public PlayListDataModel()
  {
    this.jdField_a_of_type_JavaLangString = "PlayListDataModel";
  }
  
  private void a(FeedsProtocol.GetMediaDetailRsp paramGetMediaDetailRsp)
  {
    paramGetMediaDetailRsp = paramGetMediaDetailRsp.media_list.get().iterator();
    while (paramGetMediaDetailRsp.hasNext())
    {
      FeedsProtocol.MediaInfo localMediaInfo = (FeedsProtocol.MediaInfo)paramGetMediaDetailRsp.next();
      if ((localMediaInfo.type.get() != 1) && (localMediaInfo.type.get() != 2)) {
        if (localMediaInfo.type.get() == 3) {
          ((IModelUtil)QRoute.api(IModelUtil.class)).parseShortVideoData(localMediaInfo.is_my_feeds.get(), localMediaInfo.topic_cfg.get(), localMediaInfo.short_video.get(), this.jdField_a_of_type_JavaUtilArrayList);
        } else if (localMediaInfo.type.get() == 5) {
          ((IModelUtil)QRoute.api(IModelUtil.class)).parseImageData(localMediaInfo.is_my_feeds.get(), localMediaInfo.topic_cfg.get(), localMediaInfo.pic_info.get(), this.jdField_a_of_type_JavaUtilArrayList);
        } else if (localMediaInfo.type.get() == 6) {
          ((IModelUtil)QRoute.api(IModelUtil.class)).parseTextFeeds(localMediaInfo.is_my_feeds.get(), localMediaInfo.topic_cfg.get(), localMediaInfo.text_feed.get(), this.jdField_a_of_type_JavaUtilArrayList);
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
    INowShortVideoProtoManager localINowShortVideoProtoManager = ((INowShortVideoProtoManager)QRoute.api(INowShortVideoProtoManager.class)).init(this.jdField_a_of_type_ComTencentCommonAppAppInterface);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append("&start=");
    localStringBuilder.append(this.jdField_b_of_type_Int);
    localStringBuilder.append("&num=");
    localStringBuilder.append(10);
    localINowShortVideoProtoManager.getMediaDetailInfo(localStringBuilder.toString(), new PlayListDataModel.1(this));
  }
  
  public void a(Bundle paramBundle)
  {
    if ("1".equals(paramBundle.getString("isLocal"))) {
      return;
    }
    paramBundle = paramBundle.getString("raw_url");
    this.jdField_b_of_type_JavaLangString = Uri.parse(paramBundle).getQuery();
    if (QLog.isColorLevel())
    {
      String str = this.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("PlayListDataModel, url=");
      localStringBuilder.append(paramBundle);
      QLog.d(str, 2, localStringBuilder.toString());
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.model.PlayListDataModel
 * JD-Core Version:    0.7.0.1
 */