import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.articlesummary.articlesummary.ScripCmsInfo;

public class rea
  implements Cloneable
{
  public static int c;
  public static int d;
  public int a;
  public long a;
  public String a;
  public int b;
  public String b = "";
  public String c;
  public String d;
  public String e = "";
  public String f = "";
  public String g = "";
  public String h = "";
  public String i = "";
  public String j = "";
  
  public rea()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_d_of_type_JavaLangString = "";
    this.jdField_a_of_type_Int = 1;
  }
  
  public static rea a(articlesummary.ScripCmsInfo paramScripCmsInfo)
  {
    rea localrea = new rea();
    localrea.jdField_a_of_type_JavaLangString = paramScripCmsInfo.bytes_main_title.get().toStringUtf8();
    localrea.b = paramScripCmsInfo.bytes_sub_title.get().toStringUtf8();
    localrea.jdField_c_of_type_JavaLangString = paramScripCmsInfo.bytes_background_url.get().toStringUtf8();
    localrea.jdField_d_of_type_JavaLangString = paramScripCmsInfo.bytes_left_bottom_txt.get().toStringUtf8();
    localrea.e = paramScripCmsInfo.bytes_icon_url.get().toStringUtf8();
    localrea.f = paramScripCmsInfo.bytes_background_animation_url.get().toStringUtf8();
    localrea.g = paramScripCmsInfo.bytes_guide_main_title.get().toStringUtf8();
    localrea.h = paramScripCmsInfo.bytes_guide_sub_title.get().toStringUtf8();
    localrea.i = paramScripCmsInfo.bytes_guide_background_url.get().toStringUtf8();
    localrea.jdField_a_of_type_Long = paramScripCmsInfo.uint64_from_uin.get();
    localrea.j = paramScripCmsInfo.bytes_scrip_tag.get().toStringUtf8();
    jdField_c_of_type_Int = paramScripCmsInfo.uint32_scrip_total_sum.get();
    jdField_d_of_type_Int = paramScripCmsInfo.uint32_frequency_limit.get();
    return localrea;
  }
  
  public rea a()
  {
    try
    {
      super.clone();
      rea localrea = new rea();
      localrea.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
      localrea.b = this.b;
      localrea.jdField_c_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
      localrea.jdField_d_of_type_JavaLangString = this.jdField_d_of_type_JavaLangString;
      localrea.e = this.e;
      localrea.f = this.f;
      localrea.i = this.i;
      localrea.g = this.g;
      localrea.h = this.h;
      localrea.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
      localrea.jdField_a_of_type_Long = this.jdField_a_of_type_Long;
      localrea.j = this.j;
      return localrea;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ScripCmsInfo", 2, new Object[] { "Clone not support: ", localCloneNotSupportedException.toString() });
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rea
 * JD-Core Version:    0.7.0.1
 */