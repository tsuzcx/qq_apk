import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.articlesummary.articlesummary.ScripCmsInfo;

public class pqi
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
  
  public pqi()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_d_of_type_JavaLangString = "";
    this.jdField_a_of_type_Int = 1;
  }
  
  public static pqi a(articlesummary.ScripCmsInfo paramScripCmsInfo)
  {
    pqi localpqi = new pqi();
    localpqi.jdField_a_of_type_JavaLangString = paramScripCmsInfo.bytes_main_title.get().toStringUtf8();
    localpqi.b = paramScripCmsInfo.bytes_sub_title.get().toStringUtf8();
    localpqi.jdField_c_of_type_JavaLangString = paramScripCmsInfo.bytes_background_url.get().toStringUtf8();
    localpqi.jdField_d_of_type_JavaLangString = paramScripCmsInfo.bytes_left_bottom_txt.get().toStringUtf8();
    localpqi.e = paramScripCmsInfo.bytes_icon_url.get().toStringUtf8();
    localpqi.f = paramScripCmsInfo.bytes_background_animation_url.get().toStringUtf8();
    localpqi.g = paramScripCmsInfo.bytes_guide_main_title.get().toStringUtf8();
    localpqi.h = paramScripCmsInfo.bytes_guide_sub_title.get().toStringUtf8();
    localpqi.i = paramScripCmsInfo.bytes_guide_background_url.get().toStringUtf8();
    localpqi.jdField_a_of_type_Long = paramScripCmsInfo.uint64_from_uin.get();
    localpqi.j = paramScripCmsInfo.bytes_scrip_tag.get().toStringUtf8();
    jdField_c_of_type_Int = paramScripCmsInfo.uint32_scrip_total_sum.get();
    jdField_d_of_type_Int = paramScripCmsInfo.uint32_frequency_limit.get();
    return localpqi;
  }
  
  public pqi a()
  {
    try
    {
      super.clone();
      pqi localpqi = new pqi();
      localpqi.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
      localpqi.b = this.b;
      localpqi.jdField_c_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
      localpqi.jdField_d_of_type_JavaLangString = this.jdField_d_of_type_JavaLangString;
      localpqi.e = this.e;
      localpqi.f = this.f;
      localpqi.i = this.i;
      localpqi.g = this.g;
      localpqi.h = this.h;
      localpqi.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
      localpqi.jdField_a_of_type_Long = this.jdField_a_of_type_Long;
      localpqi.j = this.j;
      return localpqi;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pqi
 * JD-Core Version:    0.7.0.1
 */