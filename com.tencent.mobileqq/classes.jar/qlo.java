import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import tencent.im.oidb.articlesummary.articlesummary.PackInfo;
import tencent.im.oidb.articlesummary.articlesummary.SpecialTopicInfo;

public class qlo
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
  
  public qlo()
  {
    this.jdField_a_of_type_Int = 6;
  }
  
  public static qlo a(articlesummary.PackInfo paramPackInfo)
  {
    try
    {
      qlo localqlo = new qlo();
      localqlo.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$PackInfo = paramPackInfo;
      localqlo.jdField_a_of_type_JavaLangString = ((articlesummary.SpecialTopicInfo)paramPackInfo.msg_special_topic_info.get()).str_header_title.get();
      localqlo.jdField_b_of_type_JavaLangString = ((articlesummary.SpecialTopicInfo)paramPackInfo.msg_special_topic_info.get()).bytes_recommend_reason.get().toStringUtf8();
      localqlo.jdField_b_of_type_Long = ((articlesummary.SpecialTopicInfo)paramPackInfo.msg_special_topic_info.get()).uint64_puin.get();
      localqlo.jdField_c_of_type_JavaLangString = ((articlesummary.SpecialTopicInfo)paramPackInfo.msg_special_topic_info.get()).str_header_icon_url.get();
      localqlo.jdField_a_of_type_Int = paramPackInfo.pack_type.get();
      localqlo.jdField_c_of_type_Long = paramPackInfo.uint64_pack_id.get();
      localqlo.jdField_d_of_type_JavaLangString = ((articlesummary.SpecialTopicInfo)paramPackInfo.msg_special_topic_info.get()).str_header_jump_url.get();
      localqlo.jdField_b_of_type_Int = ((articlesummary.SpecialTopicInfo)paramPackInfo.msg_special_topic_info.get()).uint32_icon_shape.get();
      localqlo.jdField_e_of_type_Long = ((articlesummary.SpecialTopicInfo)paramPackInfo.msg_special_topic_info.get()).uint64_algorithm_id.get();
      localqlo.jdField_d_of_type_Long = ((articlesummary.SpecialTopicInfo)paramPackInfo.msg_special_topic_info.get()).uint32_strategy_id.get();
      localqlo.f = ((articlesummary.SpecialTopicInfo)paramPackInfo.msg_special_topic_info.get()).uint64_topic_id.get();
      localqlo.jdField_a_of_type_Long = ((articlesummary.SpecialTopicInfo)paramPackInfo.msg_special_topic_info.get()).uint32_posttime.get();
      localqlo.jdField_e_of_type_Int = paramPackInfo.uint32_follow_status.get();
      return localqlo;
    }
    catch (Exception paramPackInfo) {}
    return null;
  }
  
  public String toString()
  {
    return "PolymericInfo【 packID : " + this.jdField_c_of_type_Long + "\n polymericType : " + this.jdField_a_of_type_Int + "\n algorithmID : " + this.jdField_e_of_type_Long + "\n strategyID : " + this.jdField_d_of_type_Long + "\n title : " + this.jdField_a_of_type_JavaLangString + "\n desc : " + this.jdField_b_of_type_JavaLangString + "\n publicTime : " + this.jdField_a_of_type_Long + "\n iconUrl : " + this.jdField_c_of_type_JavaLangString + "\n uin : " + this.jdField_b_of_type_Long + "\n topicID : " + this.f + "\n topicMemberCount : " + this.jdField_c_of_type_Int + "\n jumpUrl : " + this.jdField_d_of_type_JavaLangString + "\n videoCount : " + this.jdField_d_of_type_Int + "\n followStatus : " + this.jdField_e_of_type_Int + "】";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     qlo
 * JD-Core Version:    0.7.0.1
 */