import android.text.TextUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
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

public class qdq
{
  public int a;
  public long a;
  public String a;
  public ArrayList<qds> a;
  public qdr a;
  public long b;
  public String b;
  public qdr b;
  public String c;
  
  public qdq()
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  public static qdq a(articlesummary.TopicRecommendFeedsInfo paramTopicRecommendFeedsInfo)
  {
    if (paramTopicRecommendFeedsInfo == null)
    {
      QLog.d("TopicRecommendFeedsInfo", 1, "convertPBToInfo feedsInfo == null");
      return null;
    }
    qdq localqdq = new qdq();
    if (paramTopicRecommendFeedsInfo.uint64_feeds_id.has()) {
      localqdq.jdField_a_of_type_Long = paramTopicRecommendFeedsInfo.uint64_feeds_id.get();
    }
    if (paramTopicRecommendFeedsInfo.bytes_subscribe_name.has()) {
      localqdq.jdField_c_of_type_JavaLangString = paramTopicRecommendFeedsInfo.bytes_subscribe_name.get().toStringUtf8();
    }
    if (paramTopicRecommendFeedsInfo.uint32_feeds_style.has()) {
      localqdq.jdField_a_of_type_Int = paramTopicRecommendFeedsInfo.uint32_feeds_style.get();
    }
    Object localObject;
    if (paramTopicRecommendFeedsInfo.msg_topic_recommend_info.has())
    {
      localObject = paramTopicRecommendFeedsInfo.msg_topic_recommend_info.get().iterator();
      while (((Iterator)localObject).hasNext())
      {
        articlesummary.TopicRecommendInfo localTopicRecommendInfo = (articlesummary.TopicRecommendInfo)((Iterator)localObject).next();
        qds localqds = new qds();
        if (localTopicRecommendInfo.bytes_business_name.has()) {
          localqds.jdField_a_of_type_JavaLangString = localTopicRecommendInfo.bytes_business_name.get().toStringUtf8();
        }
        if (localTopicRecommendInfo.bytes_business_name_prefix.has()) {
          localqds.jdField_c_of_type_JavaLangString = localTopicRecommendInfo.bytes_business_name_prefix.get().toStringUtf8();
        }
        if (localTopicRecommendInfo.bytes_business_url.has()) {
          localqds.jdField_b_of_type_JavaLangString = localTopicRecommendInfo.bytes_business_url.get().toStringUtf8();
        }
        if (localTopicRecommendInfo.uint32_business_id.has()) {
          localqds.jdField_a_of_type_Int = localTopicRecommendInfo.uint32_business_id.get();
        }
        if (localTopicRecommendInfo.uint32_number_of_participants.has()) {
          localqds.jdField_b_of_type_Int = localTopicRecommendInfo.uint32_number_of_participants.get();
        }
        if (localTopicRecommendInfo.bytes_pic_url.has()) {
          localqds.d = localTopicRecommendInfo.bytes_pic_url.get().toStringUtf8();
        }
        if (localTopicRecommendInfo.uint32_is_follow.has()) {
          localqds.jdField_c_of_type_Int = localTopicRecommendInfo.uint32_is_follow.get();
        }
        localqdq.jdField_a_of_type_JavaUtilArrayList.add(localqds);
      }
    }
    if (paramTopicRecommendFeedsInfo.msg_left_title.has())
    {
      localObject = (articlesummary.TopicRecommendFeedsTitle)paramTopicRecommendFeedsInfo.msg_left_title.get();
      localqdq.jdField_a_of_type_Qdr = new qdr();
      if (((articlesummary.TopicRecommendFeedsTitle)localObject).bytes_title_content.has()) {
        localqdq.jdField_a_of_type_Qdr.jdField_a_of_type_JavaLangString = ((articlesummary.TopicRecommendFeedsTitle)localObject).bytes_title_content.get().toStringUtf8();
      }
      if (((articlesummary.TopicRecommendFeedsTitle)localObject).bytes_url.has()) {
        localqdq.jdField_a_of_type_Qdr.jdField_b_of_type_JavaLangString = ((articlesummary.TopicRecommendFeedsTitle)localObject).bytes_url.get().toStringUtf8();
      }
    }
    if (paramTopicRecommendFeedsInfo.msg_right_title.has())
    {
      localObject = (articlesummary.TopicRecommendFeedsTitle)paramTopicRecommendFeedsInfo.msg_right_title.get();
      localqdq.jdField_b_of_type_Qdr = new qdr();
      if (((articlesummary.TopicRecommendFeedsTitle)localObject).bytes_title_content.has()) {
        localqdq.jdField_b_of_type_Qdr.jdField_a_of_type_JavaLangString = ((articlesummary.TopicRecommendFeedsTitle)localObject).bytes_title_content.get().toStringUtf8();
      }
      if (((articlesummary.TopicRecommendFeedsTitle)localObject).bytes_url.has()) {
        localqdq.jdField_b_of_type_Qdr.jdField_b_of_type_JavaLangString = ((articlesummary.TopicRecommendFeedsTitle)localObject).bytes_url.get().toStringUtf8();
      }
    }
    if ((paramTopicRecommendFeedsInfo.bytes_comments.has()) && (paramTopicRecommendFeedsInfo.bytes_comments.get() != null)) {}
    try
    {
      localqdq.jdField_b_of_type_JavaLangString = new String(paramTopicRecommendFeedsInfo.bytes_comments.get().toByteArray(), "utf-8");
      if (paramTopicRecommendFeedsInfo.uint64_uin.has()) {
        localqdq.jdField_b_of_type_Long = paramTopicRecommendFeedsInfo.uint64_uin.get();
      }
      if (paramTopicRecommendFeedsInfo.bytes_subscribe_id.has()) {
        paramTopicRecommendFeedsInfo = paramTopicRecommendFeedsInfo.bytes_subscribe_id.get().toByteArray();
      }
    }
    catch (Exception localException)
    {
      try
      {
        localqdq.jdField_a_of_type_JavaLangString = new String(paramTopicRecommendFeedsInfo, "utf-8");
        return localqdq;
        localException = localException;
        QLog.d("TopicRecommendFeedsInfo", 1, "parse bytes_comments failed ", localException);
      }
      catch (Exception paramTopicRecommendFeedsInfo)
      {
        for (;;)
        {
          paramTopicRecommendFeedsInfo.printStackTrace();
        }
      }
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
    Object localObject = new ArrayList();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      qds localqds = (qds)localIterator.next();
      articlesummary.TopicRecommendInfo localTopicRecommendInfo = new articlesummary.TopicRecommendInfo();
      localTopicRecommendInfo.uint32_number_of_participants.set(localqds.jdField_b_of_type_Int);
      if (!TextUtils.isEmpty(localqds.jdField_a_of_type_JavaLangString)) {
        localTopicRecommendInfo.bytes_business_name.set(ByteStringMicro.copyFromUtf8(localqds.jdField_a_of_type_JavaLangString));
      }
      if (!TextUtils.isEmpty(localqds.jdField_c_of_type_JavaLangString)) {
        localTopicRecommendInfo.bytes_business_name_prefix.set(ByteStringMicro.copyFromUtf8(localqds.jdField_c_of_type_JavaLangString));
      }
      if (!TextUtils.isEmpty(localqds.jdField_b_of_type_JavaLangString)) {
        localTopicRecommendInfo.bytes_business_url.set(ByteStringMicro.copyFromUtf8(localqds.jdField_b_of_type_JavaLangString));
      }
      if (!TextUtils.isEmpty(localqds.d)) {
        localTopicRecommendInfo.bytes_pic_url.set(ByteStringMicro.copyFromUtf8(localqds.d));
      }
      localTopicRecommendInfo.uint32_business_id.set(localqds.jdField_a_of_type_Int);
      localTopicRecommendInfo.uint32_is_follow.set(localqds.jdField_c_of_type_Int);
      ((List)localObject).add(localTopicRecommendInfo);
    }
    localTopicRecommendFeedsInfo.msg_topic_recommend_info.set((List)localObject);
    if (this.jdField_a_of_type_Qdr != null)
    {
      localObject = new articlesummary.TopicRecommendFeedsTitle();
      if (!TextUtils.isEmpty(this.jdField_a_of_type_Qdr.jdField_b_of_type_JavaLangString)) {
        ((articlesummary.TopicRecommendFeedsTitle)localObject).bytes_url.set(ByteStringMicro.copyFromUtf8(this.jdField_a_of_type_Qdr.jdField_b_of_type_JavaLangString));
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_Qdr.jdField_a_of_type_JavaLangString)) {
        ((articlesummary.TopicRecommendFeedsTitle)localObject).bytes_title_content.set(ByteStringMicro.copyFromUtf8(this.jdField_a_of_type_Qdr.jdField_a_of_type_JavaLangString));
      }
      localTopicRecommendFeedsInfo.msg_left_title.set((MessageMicro)localObject);
    }
    if (this.jdField_b_of_type_Qdr != null)
    {
      localObject = new articlesummary.TopicRecommendFeedsTitle();
      if (!TextUtils.isEmpty(this.jdField_b_of_type_Qdr.jdField_b_of_type_JavaLangString)) {
        ((articlesummary.TopicRecommendFeedsTitle)localObject).bytes_url.set(ByteStringMicro.copyFromUtf8(this.jdField_b_of_type_Qdr.jdField_b_of_type_JavaLangString));
      }
      if (!TextUtils.isEmpty(this.jdField_b_of_type_Qdr.jdField_a_of_type_JavaLangString)) {
        ((articlesummary.TopicRecommendFeedsTitle)localObject).bytes_title_content.set(ByteStringMicro.copyFromUtf8(this.jdField_b_of_type_Qdr.jdField_a_of_type_JavaLangString));
      }
      localTopicRecommendFeedsInfo.msg_right_title.set((MessageMicro)localObject);
    }
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
    return "feedsId = " + this.jdField_a_of_type_Long + ", topicAuthorUin = " + this.jdField_b_of_type_Long + ", subsribeId = " + this.jdField_a_of_type_JavaLangString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qdq
 * JD-Core Version:    0.7.0.1
 */