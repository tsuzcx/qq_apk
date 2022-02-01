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
  public articlesummary.PackInfo a;
  public String b;
  public long c;
  public String d;
  public int e = 6;
  public long f;
  public String g;
  public long h;
  public String i;
  public int j;
  public long k;
  public long l;
  public long m;
  public int n;
  public int o;
  public int p;
  public int q;
  public boolean r;
  
  public static PolymericInfo a(articlesummary.PackInfo paramPackInfo)
  {
    try
    {
      PolymericInfo localPolymericInfo = new PolymericInfo();
      localPolymericInfo.a = paramPackInfo;
      localPolymericInfo.b = ((articlesummary.SpecialTopicInfo)paramPackInfo.msg_special_topic_info.get()).str_header_title.get();
      localPolymericInfo.d = ((articlesummary.SpecialTopicInfo)paramPackInfo.msg_special_topic_info.get()).bytes_recommend_reason.get().toStringUtf8();
      localPolymericInfo.f = ((articlesummary.SpecialTopicInfo)paramPackInfo.msg_special_topic_info.get()).uint64_puin.get();
      localPolymericInfo.g = ((articlesummary.SpecialTopicInfo)paramPackInfo.msg_special_topic_info.get()).str_header_icon_url.get();
      localPolymericInfo.e = paramPackInfo.pack_type.get();
      localPolymericInfo.h = paramPackInfo.uint64_pack_id.get();
      localPolymericInfo.i = ((articlesummary.SpecialTopicInfo)paramPackInfo.msg_special_topic_info.get()).str_header_jump_url.get();
      localPolymericInfo.j = ((articlesummary.SpecialTopicInfo)paramPackInfo.msg_special_topic_info.get()).uint32_icon_shape.get();
      localPolymericInfo.l = ((articlesummary.SpecialTopicInfo)paramPackInfo.msg_special_topic_info.get()).uint64_algorithm_id.get();
      localPolymericInfo.k = ((articlesummary.SpecialTopicInfo)paramPackInfo.msg_special_topic_info.get()).uint32_strategy_id.get();
      localPolymericInfo.m = ((articlesummary.SpecialTopicInfo)paramPackInfo.msg_special_topic_info.get()).uint64_topic_id.get();
      localPolymericInfo.c = ((articlesummary.SpecialTopicInfo)paramPackInfo.msg_special_topic_info.get()).uint32_posttime.get();
      localPolymericInfo.p = paramPackInfo.uint32_follow_status.get();
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
    localStringBuilder.append(this.h);
    localStringBuilder.append("\n polymericType : ");
    localStringBuilder.append(this.e);
    localStringBuilder.append("\n algorithmID : ");
    localStringBuilder.append(this.l);
    localStringBuilder.append("\n strategyID : ");
    localStringBuilder.append(this.k);
    localStringBuilder.append("\n title : ");
    localStringBuilder.append(this.b);
    localStringBuilder.append("\n desc : ");
    localStringBuilder.append(this.d);
    localStringBuilder.append("\n publicTime : ");
    localStringBuilder.append(this.c);
    localStringBuilder.append("\n iconUrl : ");
    localStringBuilder.append(this.g);
    localStringBuilder.append("\n uin : ");
    localStringBuilder.append(this.f);
    localStringBuilder.append("\n topicID : ");
    localStringBuilder.append(this.m);
    localStringBuilder.append("\n topicMemberCount : ");
    localStringBuilder.append(this.n);
    localStringBuilder.append("\n jumpUrl : ");
    localStringBuilder.append(this.i);
    localStringBuilder.append("\n videoCount : ");
    localStringBuilder.append(this.o);
    localStringBuilder.append("\n followStatus : ");
    localStringBuilder.append(this.p);
    localStringBuilder.append("】");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.feeds.PolymericInfo
 * JD-Core Version:    0.7.0.1
 */