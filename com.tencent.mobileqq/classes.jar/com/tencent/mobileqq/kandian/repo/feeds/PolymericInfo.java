package com.tencent.mobileqq.kandian.repo.feeds;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import tencent.im.oidb.articlesummary.articlesummary.PackInfo;
import tencent.im.oidb.articlesummary.articlesummary.SpecialTopicInfo;

public class PolymericInfo
{
  public int a;
  public long a;
  public String a;
  public articlesummary.PackInfo a;
  public boolean a;
  public int b;
  public long b;
  public String b;
  public int c;
  public long c;
  public String c;
  public int d;
  public long d;
  public String d;
  public int e;
  public long e;
  public int f;
  public long f;
  
  public PolymericInfo()
  {
    this.jdField_a_of_type_Int = 6;
  }
  
  public static PolymericInfo a(articlesummary.PackInfo paramPackInfo)
  {
    try
    {
      PolymericInfo localPolymericInfo = new PolymericInfo();
      localPolymericInfo.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$PackInfo = paramPackInfo;
      localPolymericInfo.jdField_a_of_type_JavaLangString = ((articlesummary.SpecialTopicInfo)paramPackInfo.msg_special_topic_info.get()).str_header_title.get();
      localPolymericInfo.jdField_b_of_type_JavaLangString = ((articlesummary.SpecialTopicInfo)paramPackInfo.msg_special_topic_info.get()).bytes_recommend_reason.get().toStringUtf8();
      localPolymericInfo.jdField_b_of_type_Long = ((articlesummary.SpecialTopicInfo)paramPackInfo.msg_special_topic_info.get()).uint64_puin.get();
      localPolymericInfo.jdField_c_of_type_JavaLangString = ((articlesummary.SpecialTopicInfo)paramPackInfo.msg_special_topic_info.get()).str_header_icon_url.get();
      localPolymericInfo.jdField_a_of_type_Int = paramPackInfo.pack_type.get();
      localPolymericInfo.jdField_c_of_type_Long = paramPackInfo.uint64_pack_id.get();
      localPolymericInfo.jdField_d_of_type_JavaLangString = ((articlesummary.SpecialTopicInfo)paramPackInfo.msg_special_topic_info.get()).str_header_jump_url.get();
      localPolymericInfo.jdField_b_of_type_Int = ((articlesummary.SpecialTopicInfo)paramPackInfo.msg_special_topic_info.get()).uint32_icon_shape.get();
      localPolymericInfo.jdField_e_of_type_Long = ((articlesummary.SpecialTopicInfo)paramPackInfo.msg_special_topic_info.get()).uint64_algorithm_id.get();
      localPolymericInfo.jdField_d_of_type_Long = ((articlesummary.SpecialTopicInfo)paramPackInfo.msg_special_topic_info.get()).uint32_strategy_id.get();
      localPolymericInfo.f = ((articlesummary.SpecialTopicInfo)paramPackInfo.msg_special_topic_info.get()).uint64_topic_id.get();
      localPolymericInfo.jdField_a_of_type_Long = ((articlesummary.SpecialTopicInfo)paramPackInfo.msg_special_topic_info.get()).uint32_posttime.get();
      localPolymericInfo.jdField_e_of_type_Int = paramPackInfo.uint32_follow_status.get();
      return localPolymericInfo;
    }
    catch (Exception paramPackInfo)
    {
      label253:
      break label253;
    }
    return null;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("PolymericInfo【 packID : ");
    localStringBuilder.append(this.jdField_c_of_type_Long);
    localStringBuilder.append("\n polymericType : ");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append("\n algorithmID : ");
    localStringBuilder.append(this.jdField_e_of_type_Long);
    localStringBuilder.append("\n strategyID : ");
    localStringBuilder.append(this.jdField_d_of_type_Long);
    localStringBuilder.append("\n title : ");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append("\n desc : ");
    localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append("\n publicTime : ");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append("\n iconUrl : ");
    localStringBuilder.append(this.jdField_c_of_type_JavaLangString);
    localStringBuilder.append("\n uin : ");
    localStringBuilder.append(this.jdField_b_of_type_Long);
    localStringBuilder.append("\n topicID : ");
    localStringBuilder.append(this.f);
    localStringBuilder.append("\n topicMemberCount : ");
    localStringBuilder.append(this.jdField_c_of_type_Int);
    localStringBuilder.append("\n jumpUrl : ");
    localStringBuilder.append(this.jdField_d_of_type_JavaLangString);
    localStringBuilder.append("\n videoCount : ");
    localStringBuilder.append(this.jdField_d_of_type_Int);
    localStringBuilder.append("\n followStatus : ");
    localStringBuilder.append(this.jdField_e_of_type_Int);
    localStringBuilder.append("】");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.feeds.PolymericInfo
 * JD-Core Version:    0.7.0.1
 */