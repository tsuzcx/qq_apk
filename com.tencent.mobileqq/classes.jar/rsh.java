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

public class rsh
{
  public int a;
  public long a;
  public String a;
  public ArrayList<rsj> a;
  public rsi a;
  public long b;
  public String b;
  public rsi b;
  public String c;
  
  public rsh()
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  public static rsh a(articlesummary.TopicRecommendFeedsInfo paramTopicRecommendFeedsInfo)
  {
    if (paramTopicRecommendFeedsInfo == null)
    {
      QLog.d("TopicRecommendFeedsInfo", 1, "convertPBToInfo feedsInfo == null");
      return null;
    }
    rsh localrsh = new rsh();
    if (paramTopicRecommendFeedsInfo.uint64_feeds_id.has()) {
      localrsh.jdField_a_of_type_Long = paramTopicRecommendFeedsInfo.uint64_feeds_id.get();
    }
    if (paramTopicRecommendFeedsInfo.bytes_subscribe_name.has()) {
      localrsh.jdField_c_of_type_JavaLangString = paramTopicRecommendFeedsInfo.bytes_subscribe_name.get().toStringUtf8();
    }
    if (paramTopicRecommendFeedsInfo.uint32_feeds_style.has()) {
      localrsh.jdField_a_of_type_Int = paramTopicRecommendFeedsInfo.uint32_feeds_style.get();
    }
    Object localObject;
    if (paramTopicRecommendFeedsInfo.msg_topic_recommend_info.has())
    {
      localObject = paramTopicRecommendFeedsInfo.msg_topic_recommend_info.get().iterator();
      while (((Iterator)localObject).hasNext())
      {
        articlesummary.TopicRecommendInfo localTopicRecommendInfo = (articlesummary.TopicRecommendInfo)((Iterator)localObject).next();
        rsj localrsj = new rsj();
        if (localTopicRecommendInfo.bytes_business_name.has()) {
          localrsj.jdField_a_of_type_JavaLangString = localTopicRecommendInfo.bytes_business_name.get().toStringUtf8();
        }
        if (localTopicRecommendInfo.bytes_business_name_prefix.has()) {
          localrsj.jdField_c_of_type_JavaLangString = localTopicRecommendInfo.bytes_business_name_prefix.get().toStringUtf8();
        }
        if (localTopicRecommendInfo.bytes_business_url.has()) {
          localrsj.jdField_b_of_type_JavaLangString = localTopicRecommendInfo.bytes_business_url.get().toStringUtf8();
        }
        if (localTopicRecommendInfo.uint32_business_id.has()) {
          localrsj.jdField_a_of_type_Int = localTopicRecommendInfo.uint32_business_id.get();
        }
        if (localTopicRecommendInfo.uint32_number_of_participants.has()) {
          localrsj.jdField_b_of_type_Int = localTopicRecommendInfo.uint32_number_of_participants.get();
        }
        if (localTopicRecommendInfo.bytes_pic_url.has()) {
          localrsj.d = localTopicRecommendInfo.bytes_pic_url.get().toStringUtf8();
        }
        if (localTopicRecommendInfo.uint32_is_follow.has()) {
          localrsj.jdField_c_of_type_Int = localTopicRecommendInfo.uint32_is_follow.get();
        }
        localrsh.jdField_a_of_type_JavaUtilArrayList.add(localrsj);
      }
    }
    if (paramTopicRecommendFeedsInfo.msg_left_title.has())
    {
      localObject = (articlesummary.TopicRecommendFeedsTitle)paramTopicRecommendFeedsInfo.msg_left_title.get();
      localrsh.jdField_a_of_type_Rsi = new rsi();
      if (((articlesummary.TopicRecommendFeedsTitle)localObject).bytes_title_content.has()) {
        localrsh.jdField_a_of_type_Rsi.jdField_a_of_type_JavaLangString = ((articlesummary.TopicRecommendFeedsTitle)localObject).bytes_title_content.get().toStringUtf8();
      }
      if (((articlesummary.TopicRecommendFeedsTitle)localObject).bytes_url.has()) {
        localrsh.jdField_a_of_type_Rsi.jdField_b_of_type_JavaLangString = ((articlesummary.TopicRecommendFeedsTitle)localObject).bytes_url.get().toStringUtf8();
      }
    }
    if (paramTopicRecommendFeedsInfo.msg_right_title.has())
    {
      localObject = (articlesummary.TopicRecommendFeedsTitle)paramTopicRecommendFeedsInfo.msg_right_title.get();
      localrsh.jdField_b_of_type_Rsi = new rsi();
      if (((articlesummary.TopicRecommendFeedsTitle)localObject).bytes_title_content.has()) {
        localrsh.jdField_b_of_type_Rsi.jdField_a_of_type_JavaLangString = ((articlesummary.TopicRecommendFeedsTitle)localObject).bytes_title_content.get().toStringUtf8();
      }
      if (((articlesummary.TopicRecommendFeedsTitle)localObject).bytes_url.has()) {
        localrsh.jdField_b_of_type_Rsi.jdField_b_of_type_JavaLangString = ((articlesummary.TopicRecommendFeedsTitle)localObject).bytes_url.get().toStringUtf8();
      }
    }
    if ((paramTopicRecommendFeedsInfo.bytes_comments.has()) && (paramTopicRecommendFeedsInfo.bytes_comments.get() != null)) {}
    try
    {
      localrsh.jdField_b_of_type_JavaLangString = new String(paramTopicRecommendFeedsInfo.bytes_comments.get().toByteArray(), "utf-8");
      if (paramTopicRecommendFeedsInfo.uint64_uin.has()) {
        localrsh.jdField_b_of_type_Long = paramTopicRecommendFeedsInfo.uint64_uin.get();
      }
      if (paramTopicRecommendFeedsInfo.bytes_subscribe_id.has()) {
        paramTopicRecommendFeedsInfo = paramTopicRecommendFeedsInfo.bytes_subscribe_id.get().toByteArray();
      }
    }
    catch (Exception localException)
    {
      try
      {
        localrsh.jdField_a_of_type_JavaLangString = new String(paramTopicRecommendFeedsInfo, "utf-8");
        return localrsh;
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
  
  private void a(List<articlesummary.TopicRecommendInfo> paramList)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      rsj localrsj = (rsj)localIterator.next();
      articlesummary.TopicRecommendInfo localTopicRecommendInfo = new articlesummary.TopicRecommendInfo();
      localTopicRecommendInfo.uint32_number_of_participants.set(localrsj.jdField_b_of_type_Int);
      if (!TextUtils.isEmpty(localrsj.jdField_a_of_type_JavaLangString)) {
        localTopicRecommendInfo.bytes_business_name.set(ByteStringMicro.copyFromUtf8(localrsj.jdField_a_of_type_JavaLangString));
      }
      if (!TextUtils.isEmpty(localrsj.jdField_c_of_type_JavaLangString)) {
        localTopicRecommendInfo.bytes_business_name_prefix.set(ByteStringMicro.copyFromUtf8(localrsj.jdField_c_of_type_JavaLangString));
      }
      if (!TextUtils.isEmpty(localrsj.jdField_b_of_type_JavaLangString)) {
        localTopicRecommendInfo.bytes_business_url.set(ByteStringMicro.copyFromUtf8(localrsj.jdField_b_of_type_JavaLangString));
      }
      if (!TextUtils.isEmpty(localrsj.d)) {
        localTopicRecommendInfo.bytes_pic_url.set(ByteStringMicro.copyFromUtf8(localrsj.d));
      }
      localTopicRecommendInfo.uint32_business_id.set(localrsj.jdField_a_of_type_Int);
      localTopicRecommendInfo.uint32_is_follow.set(localrsj.jdField_c_of_type_Int);
      paramList.add(localTopicRecommendInfo);
    }
  }
  
  private void a(articlesummary.TopicRecommendFeedsInfo paramTopicRecommendFeedsInfo)
  {
    if (this.jdField_a_of_type_Rsi != null)
    {
      articlesummary.TopicRecommendFeedsTitle localTopicRecommendFeedsTitle = new articlesummary.TopicRecommendFeedsTitle();
      if (!TextUtils.isEmpty(this.jdField_a_of_type_Rsi.jdField_b_of_type_JavaLangString)) {
        localTopicRecommendFeedsTitle.bytes_url.set(ByteStringMicro.copyFromUtf8(this.jdField_a_of_type_Rsi.jdField_b_of_type_JavaLangString));
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_Rsi.jdField_a_of_type_JavaLangString)) {
        localTopicRecommendFeedsTitle.bytes_title_content.set(ByteStringMicro.copyFromUtf8(this.jdField_a_of_type_Rsi.jdField_a_of_type_JavaLangString));
      }
      paramTopicRecommendFeedsInfo.msg_left_title.set(localTopicRecommendFeedsTitle);
    }
  }
  
  private void b(articlesummary.TopicRecommendFeedsInfo paramTopicRecommendFeedsInfo)
  {
    if (this.jdField_b_of_type_Rsi != null)
    {
      articlesummary.TopicRecommendFeedsTitle localTopicRecommendFeedsTitle = new articlesummary.TopicRecommendFeedsTitle();
      if (!TextUtils.isEmpty(this.jdField_b_of_type_Rsi.jdField_b_of_type_JavaLangString)) {
        localTopicRecommendFeedsTitle.bytes_url.set(ByteStringMicro.copyFromUtf8(this.jdField_b_of_type_Rsi.jdField_b_of_type_JavaLangString));
      }
      if (!TextUtils.isEmpty(this.jdField_b_of_type_Rsi.jdField_a_of_type_JavaLangString)) {
        localTopicRecommendFeedsTitle.bytes_title_content.set(ByteStringMicro.copyFromUtf8(this.jdField_b_of_type_Rsi.jdField_a_of_type_JavaLangString));
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
    return "feedsId = " + this.jdField_a_of_type_Long + ", topicAuthorUin = " + this.jdField_b_of_type_Long + ", subsribeId = " + this.jdField_a_of_type_JavaLangString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rsh
 * JD-Core Version:    0.7.0.1
 */