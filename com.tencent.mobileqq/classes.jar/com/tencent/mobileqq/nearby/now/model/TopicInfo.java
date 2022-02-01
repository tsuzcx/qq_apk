package com.tencent.mobileqq.nearby.now.model;

import com.tencent.mobileqq.nearby.profilecard.moment.data.MomentFeedInfo;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.pb.now.FeedsProtocol.TopicCfg;
import com.tencent.pb.now.ilive_feeds_read.TopicCfg;
import java.util.List;

public class TopicInfo
{
  private int jdField_a_of_type_Int;
  private String jdField_a_of_type_JavaLangString;
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString;
  private int jdField_c_of_type_Int;
  private String jdField_c_of_type_JavaLangString;
  private String d;
  
  public static VideoData a(List<FeedsProtocol.TopicCfg> paramList, VideoData paramVideoData)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      paramList = (FeedsProtocol.TopicCfg)paramList.get(0);
      paramVideoData.a = new TopicInfo();
      paramVideoData.a.d(paramList.jump_url.get());
      paramVideoData.a.b(paramList.topic_name.get());
      paramVideoData.a.a(paramList.topic_desc.get());
      paramVideoData.a.b(paramList.topic_parti_num.get());
      paramVideoData.a.c(paramList.topic_pic_url.get());
      paramVideoData.a.a(paramList.topic_tag.get());
      paramVideoData.a.c(paramList.topic_type.get());
    }
    return paramVideoData;
  }
  
  public static MomentFeedInfo a(List<ilive_feeds_read.TopicCfg> paramList, MomentFeedInfo paramMomentFeedInfo)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      paramList = (ilive_feeds_read.TopicCfg)paramList.get(0);
      paramMomentFeedInfo.a = new TopicInfo();
      paramMomentFeedInfo.a.d(paramList.jump_url.get());
      paramMomentFeedInfo.a.b(paramList.topic_name.get());
      paramMomentFeedInfo.a.a(paramList.topic_desc.get());
      paramMomentFeedInfo.a.b(paramList.topic_parti_num.get());
      paramMomentFeedInfo.a.c(paramList.topic_pic_url.get());
      paramMomentFeedInfo.a.a(paramList.topic_tag.get());
      paramMomentFeedInfo.a.c(paramList.topic_type.get());
    }
    return paramMomentFeedInfo;
  }
  
  public String a()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public String b()
  {
    return this.d;
  }
  
  public void b(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public void b(String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
  }
  
  public void c(int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
  }
  
  public void c(String paramString)
  {
    this.jdField_c_of_type_JavaLangString = paramString;
  }
  
  public void d(String paramString)
  {
    this.d = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.model.TopicInfo
 * JD-Core Version:    0.7.0.1
 */