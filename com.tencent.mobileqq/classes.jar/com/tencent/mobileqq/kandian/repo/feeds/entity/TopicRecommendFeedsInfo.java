package com.tencent.mobileqq.kandian.repo.feeds.entity;

import android.text.TextUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.articlesummary.articlesummary.TopicRecommendFeedsInfo;
import tencent.im.oidb.articlesummary.articlesummary.TopicRecommendFeedsTitle;
import tencent.im.oidb.articlesummary.articlesummary.TopicRecommendInfo;

public class TopicRecommendFeedsInfo
{
  public long a;
  public int b;
  public long c;
  public String d;
  public TopicRecommendFeedsInfo.TopicRecommendFeedsTitle e;
  public TopicRecommendFeedsInfo.TopicRecommendFeedsTitle f;
  public ArrayList<TopicRecommendFeedsInfo.TopicRecommendInfo> g = new ArrayList();
  public String h;
  public String i;
  
  public static TopicRecommendFeedsInfo a(articlesummary.TopicRecommendFeedsInfo paramTopicRecommendFeedsInfo)
  {
    if (paramTopicRecommendFeedsInfo == null)
    {
      QLog.d("TopicRecommendFeedsInfo", 1, "convertPBToInfo feedsInfo == null");
      return null;
    }
    TopicRecommendFeedsInfo localTopicRecommendFeedsInfo = new TopicRecommendFeedsInfo();
    if (paramTopicRecommendFeedsInfo.uint64_feeds_id.has()) {
      localTopicRecommendFeedsInfo.a = paramTopicRecommendFeedsInfo.uint64_feeds_id.get();
    }
    if (paramTopicRecommendFeedsInfo.bytes_subscribe_name.has()) {
      localTopicRecommendFeedsInfo.i = paramTopicRecommendFeedsInfo.bytes_subscribe_name.get().toStringUtf8();
    }
    if (paramTopicRecommendFeedsInfo.uint32_feeds_style.has()) {
      localTopicRecommendFeedsInfo.b = paramTopicRecommendFeedsInfo.uint32_feeds_style.get();
    }
    Object localObject;
    if (paramTopicRecommendFeedsInfo.msg_topic_recommend_info.has())
    {
      localObject = paramTopicRecommendFeedsInfo.msg_topic_recommend_info.get().iterator();
      while (((Iterator)localObject).hasNext())
      {
        articlesummary.TopicRecommendInfo localTopicRecommendInfo = (articlesummary.TopicRecommendInfo)((Iterator)localObject).next();
        TopicRecommendFeedsInfo.TopicRecommendInfo localTopicRecommendInfo1 = new TopicRecommendFeedsInfo.TopicRecommendInfo();
        if (localTopicRecommendInfo.bytes_business_name.has()) {
          localTopicRecommendInfo1.b = localTopicRecommendInfo.bytes_business_name.get().toStringUtf8();
        }
        if (localTopicRecommendInfo.bytes_business_name_prefix.has()) {
          localTopicRecommendInfo1.d = localTopicRecommendInfo.bytes_business_name_prefix.get().toStringUtf8();
        }
        if (localTopicRecommendInfo.bytes_business_url.has()) {
          localTopicRecommendInfo1.c = localTopicRecommendInfo.bytes_business_url.get().toStringUtf8();
        }
        if (localTopicRecommendInfo.uint32_business_id.has()) {
          localTopicRecommendInfo1.a = localTopicRecommendInfo.uint32_business_id.get();
        }
        if (localTopicRecommendInfo.uint32_number_of_participants.has()) {
          localTopicRecommendInfo1.e = localTopicRecommendInfo.uint32_number_of_participants.get();
        }
        if (localTopicRecommendInfo.bytes_pic_url.has()) {
          localTopicRecommendInfo1.f = localTopicRecommendInfo.bytes_pic_url.get().toStringUtf8();
        }
        if (localTopicRecommendInfo.uint32_is_follow.has()) {
          localTopicRecommendInfo1.g = localTopicRecommendInfo.uint32_is_follow.get();
        }
        localTopicRecommendFeedsInfo.g.add(localTopicRecommendInfo1);
      }
    }
    if (paramTopicRecommendFeedsInfo.msg_left_title.has())
    {
      localObject = (articlesummary.TopicRecommendFeedsTitle)paramTopicRecommendFeedsInfo.msg_left_title.get();
      localTopicRecommendFeedsInfo.e = new TopicRecommendFeedsInfo.TopicRecommendFeedsTitle();
      if (((articlesummary.TopicRecommendFeedsTitle)localObject).bytes_title_content.has()) {
        localTopicRecommendFeedsInfo.e.a = ((articlesummary.TopicRecommendFeedsTitle)localObject).bytes_title_content.get().toStringUtf8();
      }
      if (((articlesummary.TopicRecommendFeedsTitle)localObject).bytes_url.has()) {
        localTopicRecommendFeedsInfo.e.b = ((articlesummary.TopicRecommendFeedsTitle)localObject).bytes_url.get().toStringUtf8();
      }
    }
    if (paramTopicRecommendFeedsInfo.msg_right_title.has())
    {
      localObject = (articlesummary.TopicRecommendFeedsTitle)paramTopicRecommendFeedsInfo.msg_right_title.get();
      localTopicRecommendFeedsInfo.f = new TopicRecommendFeedsInfo.TopicRecommendFeedsTitle();
      if (((articlesummary.TopicRecommendFeedsTitle)localObject).bytes_title_content.has()) {
        localTopicRecommendFeedsInfo.f.a = ((articlesummary.TopicRecommendFeedsTitle)localObject).bytes_title_content.get().toStringUtf8();
      }
      if (((articlesummary.TopicRecommendFeedsTitle)localObject).bytes_url.has()) {
        localTopicRecommendFeedsInfo.f.b = ((articlesummary.TopicRecommendFeedsTitle)localObject).bytes_url.get().toStringUtf8();
      }
    }
    if ((paramTopicRecommendFeedsInfo.bytes_comments.has()) && (paramTopicRecommendFeedsInfo.bytes_comments.get() != null)) {
      try
      {
        localTopicRecommendFeedsInfo.h = new String(paramTopicRecommendFeedsInfo.bytes_comments.get().toByteArray(), "utf-8");
      }
      catch (Exception localException)
      {
        QLog.d("TopicRecommendFeedsInfo", 1, "parse bytes_comments failed ", localException);
      }
    }
    if (paramTopicRecommendFeedsInfo.uint64_uin.has()) {
      localTopicRecommendFeedsInfo.c = paramTopicRecommendFeedsInfo.uint64_uin.get();
    }
    if (paramTopicRecommendFeedsInfo.bytes_subscribe_id.has())
    {
      paramTopicRecommendFeedsInfo = paramTopicRecommendFeedsInfo.bytes_subscribe_id.get().toByteArray();
      try
      {
        localTopicRecommendFeedsInfo.d = new String(paramTopicRecommendFeedsInfo, "utf-8");
        return localTopicRecommendFeedsInfo;
      }
      catch (Exception paramTopicRecommendFeedsInfo)
      {
        paramTopicRecommendFeedsInfo.printStackTrace();
      }
    }
    return localTopicRecommendFeedsInfo;
  }
  
  private void a(List<articlesummary.TopicRecommendInfo> paramList)
  {
    Iterator localIterator = this.g.iterator();
    while (localIterator.hasNext())
    {
      TopicRecommendFeedsInfo.TopicRecommendInfo localTopicRecommendInfo = (TopicRecommendFeedsInfo.TopicRecommendInfo)localIterator.next();
      articlesummary.TopicRecommendInfo localTopicRecommendInfo1 = new articlesummary.TopicRecommendInfo();
      localTopicRecommendInfo1.uint32_number_of_participants.set(localTopicRecommendInfo.e);
      if (!TextUtils.isEmpty(localTopicRecommendInfo.b)) {
        localTopicRecommendInfo1.bytes_business_name.set(ByteStringMicro.copyFromUtf8(localTopicRecommendInfo.b));
      }
      if (!TextUtils.isEmpty(localTopicRecommendInfo.d)) {
        localTopicRecommendInfo1.bytes_business_name_prefix.set(ByteStringMicro.copyFromUtf8(localTopicRecommendInfo.d));
      }
      if (!TextUtils.isEmpty(localTopicRecommendInfo.c)) {
        localTopicRecommendInfo1.bytes_business_url.set(ByteStringMicro.copyFromUtf8(localTopicRecommendInfo.c));
      }
      if (!TextUtils.isEmpty(localTopicRecommendInfo.f)) {
        localTopicRecommendInfo1.bytes_pic_url.set(ByteStringMicro.copyFromUtf8(localTopicRecommendInfo.f));
      }
      localTopicRecommendInfo1.uint32_business_id.set(localTopicRecommendInfo.a);
      localTopicRecommendInfo1.uint32_is_follow.set(localTopicRecommendInfo.g);
      paramList.add(localTopicRecommendInfo1);
    }
  }
  
  private void b(articlesummary.TopicRecommendFeedsInfo paramTopicRecommendFeedsInfo)
  {
    if (this.e != null)
    {
      articlesummary.TopicRecommendFeedsTitle localTopicRecommendFeedsTitle = new articlesummary.TopicRecommendFeedsTitle();
      if (!TextUtils.isEmpty(this.e.b)) {
        localTopicRecommendFeedsTitle.bytes_url.set(ByteStringMicro.copyFromUtf8(this.e.b));
      }
      if (!TextUtils.isEmpty(this.e.a)) {
        localTopicRecommendFeedsTitle.bytes_title_content.set(ByteStringMicro.copyFromUtf8(this.e.a));
      }
      paramTopicRecommendFeedsInfo.msg_left_title.set(localTopicRecommendFeedsTitle);
    }
  }
  
  private void c(articlesummary.TopicRecommendFeedsInfo paramTopicRecommendFeedsInfo)
  {
    if (this.f != null)
    {
      articlesummary.TopicRecommendFeedsTitle localTopicRecommendFeedsTitle = new articlesummary.TopicRecommendFeedsTitle();
      if (!TextUtils.isEmpty(this.f.b)) {
        localTopicRecommendFeedsTitle.bytes_url.set(ByteStringMicro.copyFromUtf8(this.f.b));
      }
      if (!TextUtils.isEmpty(this.f.a)) {
        localTopicRecommendFeedsTitle.bytes_title_content.set(ByteStringMicro.copyFromUtf8(this.f.a));
      }
      paramTopicRecommendFeedsInfo.msg_right_title.set(localTopicRecommendFeedsTitle);
    }
  }
  
  public articlesummary.TopicRecommendFeedsInfo a()
  {
    articlesummary.TopicRecommendFeedsInfo localTopicRecommendFeedsInfo = new articlesummary.TopicRecommendFeedsInfo();
    localTopicRecommendFeedsInfo.uint32_feeds_style.set(this.b);
    localTopicRecommendFeedsInfo.uint64_feeds_id.set(this.a);
    if (this.i != null) {
      localTopicRecommendFeedsInfo.bytes_subscribe_name.set(ByteStringMicro.copyFromUtf8(this.i));
    }
    ArrayList localArrayList = new ArrayList();
    a(localArrayList);
    localTopicRecommendFeedsInfo.msg_topic_recommend_info.set(localArrayList);
    b(localTopicRecommendFeedsInfo);
    c(localTopicRecommendFeedsInfo);
    if (this.d != null) {
      localTopicRecommendFeedsInfo.bytes_subscribe_id.set(ByteStringMicro.copyFromUtf8(this.d));
    }
    localTopicRecommendFeedsInfo.uint64_uin.set(this.c);
    if (this.h != null) {
      localTopicRecommendFeedsInfo.bytes_comments.set(ByteStringMicro.copyFromUtf8(this.h));
    }
    return localTopicRecommendFeedsInfo;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("feedsId = ");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", topicAuthorUin = ");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", subsribeId = ");
    localStringBuilder.append(this.d);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.feeds.entity.TopicRecommendFeedsInfo
 * JD-Core Version:    0.7.0.1
 */