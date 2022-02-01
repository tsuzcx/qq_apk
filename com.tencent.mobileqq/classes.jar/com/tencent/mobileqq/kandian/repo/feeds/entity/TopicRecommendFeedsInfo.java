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
  public int a;
  public long a;
  public TopicRecommendFeedsInfo.TopicRecommendFeedsTitle a;
  public String a;
  public ArrayList<TopicRecommendFeedsInfo.TopicRecommendInfo> a;
  public long b;
  public TopicRecommendFeedsInfo.TopicRecommendFeedsTitle b;
  public String b;
  public String c;
  
  public TopicRecommendFeedsInfo()
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  public static TopicRecommendFeedsInfo a(articlesummary.TopicRecommendFeedsInfo paramTopicRecommendFeedsInfo)
  {
    if (paramTopicRecommendFeedsInfo == null)
    {
      QLog.d("TopicRecommendFeedsInfo", 1, "convertPBToInfo feedsInfo == null");
      return null;
    }
    TopicRecommendFeedsInfo localTopicRecommendFeedsInfo = new TopicRecommendFeedsInfo();
    if (paramTopicRecommendFeedsInfo.uint64_feeds_id.has()) {
      localTopicRecommendFeedsInfo.jdField_a_of_type_Long = paramTopicRecommendFeedsInfo.uint64_feeds_id.get();
    }
    if (paramTopicRecommendFeedsInfo.bytes_subscribe_name.has()) {
      localTopicRecommendFeedsInfo.jdField_c_of_type_JavaLangString = paramTopicRecommendFeedsInfo.bytes_subscribe_name.get().toStringUtf8();
    }
    if (paramTopicRecommendFeedsInfo.uint32_feeds_style.has()) {
      localTopicRecommendFeedsInfo.jdField_a_of_type_Int = paramTopicRecommendFeedsInfo.uint32_feeds_style.get();
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
          localTopicRecommendInfo1.jdField_a_of_type_JavaLangString = localTopicRecommendInfo.bytes_business_name.get().toStringUtf8();
        }
        if (localTopicRecommendInfo.bytes_business_name_prefix.has()) {
          localTopicRecommendInfo1.jdField_c_of_type_JavaLangString = localTopicRecommendInfo.bytes_business_name_prefix.get().toStringUtf8();
        }
        if (localTopicRecommendInfo.bytes_business_url.has()) {
          localTopicRecommendInfo1.jdField_b_of_type_JavaLangString = localTopicRecommendInfo.bytes_business_url.get().toStringUtf8();
        }
        if (localTopicRecommendInfo.uint32_business_id.has()) {
          localTopicRecommendInfo1.jdField_a_of_type_Int = localTopicRecommendInfo.uint32_business_id.get();
        }
        if (localTopicRecommendInfo.uint32_number_of_participants.has()) {
          localTopicRecommendInfo1.jdField_b_of_type_Int = localTopicRecommendInfo.uint32_number_of_participants.get();
        }
        if (localTopicRecommendInfo.bytes_pic_url.has()) {
          localTopicRecommendInfo1.d = localTopicRecommendInfo.bytes_pic_url.get().toStringUtf8();
        }
        if (localTopicRecommendInfo.uint32_is_follow.has()) {
          localTopicRecommendInfo1.jdField_c_of_type_Int = localTopicRecommendInfo.uint32_is_follow.get();
        }
        localTopicRecommendFeedsInfo.jdField_a_of_type_JavaUtilArrayList.add(localTopicRecommendInfo1);
      }
    }
    if (paramTopicRecommendFeedsInfo.msg_left_title.has())
    {
      localObject = (articlesummary.TopicRecommendFeedsTitle)paramTopicRecommendFeedsInfo.msg_left_title.get();
      localTopicRecommendFeedsInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityTopicRecommendFeedsInfo$TopicRecommendFeedsTitle = new TopicRecommendFeedsInfo.TopicRecommendFeedsTitle();
      if (((articlesummary.TopicRecommendFeedsTitle)localObject).bytes_title_content.has()) {
        localTopicRecommendFeedsInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityTopicRecommendFeedsInfo$TopicRecommendFeedsTitle.jdField_a_of_type_JavaLangString = ((articlesummary.TopicRecommendFeedsTitle)localObject).bytes_title_content.get().toStringUtf8();
      }
      if (((articlesummary.TopicRecommendFeedsTitle)localObject).bytes_url.has()) {
        localTopicRecommendFeedsInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityTopicRecommendFeedsInfo$TopicRecommendFeedsTitle.jdField_b_of_type_JavaLangString = ((articlesummary.TopicRecommendFeedsTitle)localObject).bytes_url.get().toStringUtf8();
      }
    }
    if (paramTopicRecommendFeedsInfo.msg_right_title.has())
    {
      localObject = (articlesummary.TopicRecommendFeedsTitle)paramTopicRecommendFeedsInfo.msg_right_title.get();
      localTopicRecommendFeedsInfo.jdField_b_of_type_ComTencentMobileqqKandianRepoFeedsEntityTopicRecommendFeedsInfo$TopicRecommendFeedsTitle = new TopicRecommendFeedsInfo.TopicRecommendFeedsTitle();
      if (((articlesummary.TopicRecommendFeedsTitle)localObject).bytes_title_content.has()) {
        localTopicRecommendFeedsInfo.jdField_b_of_type_ComTencentMobileqqKandianRepoFeedsEntityTopicRecommendFeedsInfo$TopicRecommendFeedsTitle.jdField_a_of_type_JavaLangString = ((articlesummary.TopicRecommendFeedsTitle)localObject).bytes_title_content.get().toStringUtf8();
      }
      if (((articlesummary.TopicRecommendFeedsTitle)localObject).bytes_url.has()) {
        localTopicRecommendFeedsInfo.jdField_b_of_type_ComTencentMobileqqKandianRepoFeedsEntityTopicRecommendFeedsInfo$TopicRecommendFeedsTitle.jdField_b_of_type_JavaLangString = ((articlesummary.TopicRecommendFeedsTitle)localObject).bytes_url.get().toStringUtf8();
      }
    }
    if ((paramTopicRecommendFeedsInfo.bytes_comments.has()) && (paramTopicRecommendFeedsInfo.bytes_comments.get() != null)) {
      try
      {
        localTopicRecommendFeedsInfo.jdField_b_of_type_JavaLangString = new String(paramTopicRecommendFeedsInfo.bytes_comments.get().toByteArray(), "utf-8");
      }
      catch (Exception localException)
      {
        QLog.d("TopicRecommendFeedsInfo", 1, "parse bytes_comments failed ", localException);
      }
    }
    if (paramTopicRecommendFeedsInfo.uint64_uin.has()) {
      localTopicRecommendFeedsInfo.jdField_b_of_type_Long = paramTopicRecommendFeedsInfo.uint64_uin.get();
    }
    if (paramTopicRecommendFeedsInfo.bytes_subscribe_id.has())
    {
      paramTopicRecommendFeedsInfo = paramTopicRecommendFeedsInfo.bytes_subscribe_id.get().toByteArray();
      try
      {
        localTopicRecommendFeedsInfo.jdField_a_of_type_JavaLangString = new String(paramTopicRecommendFeedsInfo, "utf-8");
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
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      TopicRecommendFeedsInfo.TopicRecommendInfo localTopicRecommendInfo = (TopicRecommendFeedsInfo.TopicRecommendInfo)localIterator.next();
      articlesummary.TopicRecommendInfo localTopicRecommendInfo1 = new articlesummary.TopicRecommendInfo();
      localTopicRecommendInfo1.uint32_number_of_participants.set(localTopicRecommendInfo.jdField_b_of_type_Int);
      if (!TextUtils.isEmpty(localTopicRecommendInfo.jdField_a_of_type_JavaLangString)) {
        localTopicRecommendInfo1.bytes_business_name.set(ByteStringMicro.copyFromUtf8(localTopicRecommendInfo.jdField_a_of_type_JavaLangString));
      }
      if (!TextUtils.isEmpty(localTopicRecommendInfo.jdField_c_of_type_JavaLangString)) {
        localTopicRecommendInfo1.bytes_business_name_prefix.set(ByteStringMicro.copyFromUtf8(localTopicRecommendInfo.jdField_c_of_type_JavaLangString));
      }
      if (!TextUtils.isEmpty(localTopicRecommendInfo.jdField_b_of_type_JavaLangString)) {
        localTopicRecommendInfo1.bytes_business_url.set(ByteStringMicro.copyFromUtf8(localTopicRecommendInfo.jdField_b_of_type_JavaLangString));
      }
      if (!TextUtils.isEmpty(localTopicRecommendInfo.d)) {
        localTopicRecommendInfo1.bytes_pic_url.set(ByteStringMicro.copyFromUtf8(localTopicRecommendInfo.d));
      }
      localTopicRecommendInfo1.uint32_business_id.set(localTopicRecommendInfo.jdField_a_of_type_Int);
      localTopicRecommendInfo1.uint32_is_follow.set(localTopicRecommendInfo.jdField_c_of_type_Int);
      paramList.add(localTopicRecommendInfo1);
    }
  }
  
  private void a(articlesummary.TopicRecommendFeedsInfo paramTopicRecommendFeedsInfo)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityTopicRecommendFeedsInfo$TopicRecommendFeedsTitle != null)
    {
      articlesummary.TopicRecommendFeedsTitle localTopicRecommendFeedsTitle = new articlesummary.TopicRecommendFeedsTitle();
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityTopicRecommendFeedsInfo$TopicRecommendFeedsTitle.jdField_b_of_type_JavaLangString)) {
        localTopicRecommendFeedsTitle.bytes_url.set(ByteStringMicro.copyFromUtf8(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityTopicRecommendFeedsInfo$TopicRecommendFeedsTitle.jdField_b_of_type_JavaLangString));
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityTopicRecommendFeedsInfo$TopicRecommendFeedsTitle.jdField_a_of_type_JavaLangString)) {
        localTopicRecommendFeedsTitle.bytes_title_content.set(ByteStringMicro.copyFromUtf8(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityTopicRecommendFeedsInfo$TopicRecommendFeedsTitle.jdField_a_of_type_JavaLangString));
      }
      paramTopicRecommendFeedsInfo.msg_left_title.set(localTopicRecommendFeedsTitle);
    }
  }
  
  private void b(articlesummary.TopicRecommendFeedsInfo paramTopicRecommendFeedsInfo)
  {
    if (this.jdField_b_of_type_ComTencentMobileqqKandianRepoFeedsEntityTopicRecommendFeedsInfo$TopicRecommendFeedsTitle != null)
    {
      articlesummary.TopicRecommendFeedsTitle localTopicRecommendFeedsTitle = new articlesummary.TopicRecommendFeedsTitle();
      if (!TextUtils.isEmpty(this.jdField_b_of_type_ComTencentMobileqqKandianRepoFeedsEntityTopicRecommendFeedsInfo$TopicRecommendFeedsTitle.jdField_b_of_type_JavaLangString)) {
        localTopicRecommendFeedsTitle.bytes_url.set(ByteStringMicro.copyFromUtf8(this.jdField_b_of_type_ComTencentMobileqqKandianRepoFeedsEntityTopicRecommendFeedsInfo$TopicRecommendFeedsTitle.jdField_b_of_type_JavaLangString));
      }
      if (!TextUtils.isEmpty(this.jdField_b_of_type_ComTencentMobileqqKandianRepoFeedsEntityTopicRecommendFeedsInfo$TopicRecommendFeedsTitle.jdField_a_of_type_JavaLangString)) {
        localTopicRecommendFeedsTitle.bytes_title_content.set(ByteStringMicro.copyFromUtf8(this.jdField_b_of_type_ComTencentMobileqqKandianRepoFeedsEntityTopicRecommendFeedsInfo$TopicRecommendFeedsTitle.jdField_a_of_type_JavaLangString));
      }
      paramTopicRecommendFeedsInfo.msg_right_title.set(localTopicRecommendFeedsTitle);
    }
  }
  
  public articlesummary.TopicRecommendFeedsInfo a()
  {
    articlesummary.TopicRecommendFeedsInfo localTopicRecommendFeedsInfo = new articlesummary.TopicRecommendFeedsInfo();
    localTopicRecommendFeedsInfo.uint32_feeds_style.set(this.jdField_a_of_type_Int);
    localTopicRecommendFeedsInfo.uint64_feeds_id.set(this.jdField_a_of_type_Long);
    if (this.jdField_c_of_type_JavaLangString != null) {
      localTopicRecommendFeedsInfo.bytes_subscribe_name.set(ByteStringMicro.copyFromUtf8(this.jdField_c_of_type_JavaLangString));
    }
    ArrayList localArrayList = new ArrayList();
    a(localArrayList);
    localTopicRecommendFeedsInfo.msg_topic_recommend_info.set(localArrayList);
    a(localTopicRecommendFeedsInfo);
    b(localTopicRecommendFeedsInfo);
    if (this.jdField_a_of_type_JavaLangString != null) {
      localTopicRecommendFeedsInfo.bytes_subscribe_id.set(ByteStringMicro.copyFromUtf8(this.jdField_a_of_type_JavaLangString));
    }
    localTopicRecommendFeedsInfo.uint64_uin.set(this.jdField_b_of_type_Long);
    if (this.jdField_b_of_type_JavaLangString != null) {
      localTopicRecommendFeedsInfo.bytes_comments.set(ByteStringMicro.copyFromUtf8(this.jdField_b_of_type_JavaLangString));
    }
    return localTopicRecommendFeedsInfo;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("feedsId = ");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append(", topicAuthorUin = ");
    localStringBuilder.append(this.jdField_b_of_type_Long);
    localStringBuilder.append(", subsribeId = ");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.feeds.entity.TopicRecommendFeedsInfo
 * JD-Core Version:    0.7.0.1
 */