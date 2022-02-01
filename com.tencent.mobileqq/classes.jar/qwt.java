import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import tencent.im.oidb.articlesummary.articlesummary.PackInfo;
import tencent.im.oidb.articlesummary.articlesummary.SpecialTopicInfo;

public class qwt
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
  
  public qwt()
  {
    this.jdField_a_of_type_Int = 6;
  }
  
  public static qwt a(articlesummary.PackInfo paramPackInfo)
  {
    try
    {
      qwt localqwt = new qwt();
      localqwt.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$PackInfo = paramPackInfo;
      localqwt.jdField_a_of_type_JavaLangString = ((articlesummary.SpecialTopicInfo)paramPackInfo.msg_special_topic_info.get()).str_header_title.get();
      localqwt.jdField_b_of_type_JavaLangString = ((articlesummary.SpecialTopicInfo)paramPackInfo.msg_special_topic_info.get()).bytes_recommend_reason.get().toStringUtf8();
      localqwt.jdField_b_of_type_Long = ((articlesummary.SpecialTopicInfo)paramPackInfo.msg_special_topic_info.get()).uint64_puin.get();
      localqwt.jdField_c_of_type_JavaLangString = ((articlesummary.SpecialTopicInfo)paramPackInfo.msg_special_topic_info.get()).str_header_icon_url.get();
      localqwt.jdField_a_of_type_Int = paramPackInfo.pack_type.get();
      localqwt.jdField_c_of_type_Long = paramPackInfo.uint64_pack_id.get();
      localqwt.jdField_d_of_type_JavaLangString = ((articlesummary.SpecialTopicInfo)paramPackInfo.msg_special_topic_info.get()).str_header_jump_url.get();
      localqwt.jdField_b_of_type_Int = ((articlesummary.SpecialTopicInfo)paramPackInfo.msg_special_topic_info.get()).uint32_icon_shape.get();
      localqwt.jdField_e_of_type_Long = ((articlesummary.SpecialTopicInfo)paramPackInfo.msg_special_topic_info.get()).uint64_algorithm_id.get();
      localqwt.jdField_d_of_type_Long = ((articlesummary.SpecialTopicInfo)paramPackInfo.msg_special_topic_info.get()).uint32_strategy_id.get();
      localqwt.f = ((articlesummary.SpecialTopicInfo)paramPackInfo.msg_special_topic_info.get()).uint64_topic_id.get();
      localqwt.jdField_a_of_type_Long = ((articlesummary.SpecialTopicInfo)paramPackInfo.msg_special_topic_info.get()).uint32_posttime.get();
      localqwt.jdField_e_of_type_Int = paramPackInfo.uint32_follow_status.get();
      return localqwt;
    }
    catch (Exception paramPackInfo) {}
    return null;
  }
  
  public String toString()
  {
    return "PolymericInfo【 packID : " + this.jdField_c_of_type_Long + "\n polymericType : " + this.jdField_a_of_type_Int + "\n algorithmID : " + this.jdField_e_of_type_Long + "\n strategyID : " + this.jdField_d_of_type_Long + "\n title : " + this.jdField_a_of_type_JavaLangString + "\n desc : " + this.jdField_b_of_type_JavaLangString + "\n publicTime : " + this.jdField_a_of_type_Long + "\n iconUrl : " + this.jdField_c_of_type_JavaLangString + "\n uin : " + this.jdField_b_of_type_Long + "\n topicID : " + this.f + "\n topicMemberCount : " + this.jdField_c_of_type_Int + "\n jumpUrl : " + this.jdField_d_of_type_JavaLangString + "\n videoCount : " + this.jdField_d_of_type_Int + "\n followStatus : " + this.jdField_e_of_type_Int + "】";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qwt
 * JD-Core Version:    0.7.0.1
 */