import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import tencent.im.oidb.articlesummary.articlesummary.PackInfo;
import tencent.im.oidb.articlesummary.articlesummary.SpecialTopicInfo;

public class qbs
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
  
  public qbs()
  {
    this.jdField_a_of_type_Int = 6;
  }
  
  public static qbs a(articlesummary.PackInfo paramPackInfo)
  {
    try
    {
      qbs localqbs = new qbs();
      localqbs.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$PackInfo = paramPackInfo;
      localqbs.jdField_a_of_type_JavaLangString = ((articlesummary.SpecialTopicInfo)paramPackInfo.msg_special_topic_info.get()).str_header_title.get();
      localqbs.jdField_b_of_type_JavaLangString = ((articlesummary.SpecialTopicInfo)paramPackInfo.msg_special_topic_info.get()).bytes_recommend_reason.get().toStringUtf8();
      localqbs.jdField_b_of_type_Long = ((articlesummary.SpecialTopicInfo)paramPackInfo.msg_special_topic_info.get()).uint64_puin.get();
      localqbs.jdField_c_of_type_JavaLangString = ((articlesummary.SpecialTopicInfo)paramPackInfo.msg_special_topic_info.get()).str_header_icon_url.get();
      localqbs.jdField_a_of_type_Int = paramPackInfo.pack_type.get();
      localqbs.jdField_c_of_type_Long = paramPackInfo.uint64_pack_id.get();
      localqbs.jdField_d_of_type_JavaLangString = ((articlesummary.SpecialTopicInfo)paramPackInfo.msg_special_topic_info.get()).str_header_jump_url.get();
      localqbs.jdField_b_of_type_Int = ((articlesummary.SpecialTopicInfo)paramPackInfo.msg_special_topic_info.get()).uint32_icon_shape.get();
      localqbs.jdField_e_of_type_Long = ((articlesummary.SpecialTopicInfo)paramPackInfo.msg_special_topic_info.get()).uint64_algorithm_id.get();
      localqbs.jdField_d_of_type_Long = ((articlesummary.SpecialTopicInfo)paramPackInfo.msg_special_topic_info.get()).uint32_strategy_id.get();
      localqbs.f = ((articlesummary.SpecialTopicInfo)paramPackInfo.msg_special_topic_info.get()).uint64_topic_id.get();
      localqbs.jdField_a_of_type_Long = ((articlesummary.SpecialTopicInfo)paramPackInfo.msg_special_topic_info.get()).uint32_posttime.get();
      localqbs.jdField_e_of_type_Int = paramPackInfo.uint32_follow_status.get();
      return localqbs;
    }
    catch (Exception paramPackInfo) {}
    return null;
  }
  
  public String toString()
  {
    return "PolymericInfo【 packID : " + this.jdField_c_of_type_Long + "\n polymericType : " + this.jdField_a_of_type_Int + "\n algorithmID : " + this.jdField_e_of_type_Long + "\n strategyID : " + this.jdField_d_of_type_Long + "\n title : " + this.jdField_a_of_type_JavaLangString + "\n desc : " + this.jdField_b_of_type_JavaLangString + "\n publicTime : " + this.jdField_a_of_type_Long + "\n iconUrl : " + this.jdField_c_of_type_JavaLangString + "\n uin : " + this.jdField_b_of_type_Long + "\n topicID : " + this.f + "\n topicMemberCount : " + this.jdField_c_of_type_Int + "\n jumpUrl : " + this.jdField_d_of_type_JavaLangString + "\n videoCount : " + this.jdField_d_of_type_Int + "\n followStatus : " + this.jdField_e_of_type_Int + "】";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qbs
 * JD-Core Version:    0.7.0.1
 */