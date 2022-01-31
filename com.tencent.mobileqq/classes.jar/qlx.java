import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.articlesummary.articlesummary.ScripCmsInfo;

public class qlx
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
  
  public qlx()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_d_of_type_JavaLangString = "";
    this.jdField_a_of_type_Int = 1;
  }
  
  public static qlx a(articlesummary.ScripCmsInfo paramScripCmsInfo)
  {
    qlx localqlx = new qlx();
    localqlx.jdField_a_of_type_JavaLangString = paramScripCmsInfo.bytes_main_title.get().toStringUtf8();
    localqlx.b = paramScripCmsInfo.bytes_sub_title.get().toStringUtf8();
    localqlx.jdField_c_of_type_JavaLangString = paramScripCmsInfo.bytes_background_url.get().toStringUtf8();
    localqlx.jdField_d_of_type_JavaLangString = paramScripCmsInfo.bytes_left_bottom_txt.get().toStringUtf8();
    localqlx.e = paramScripCmsInfo.bytes_icon_url.get().toStringUtf8();
    localqlx.f = paramScripCmsInfo.bytes_background_animation_url.get().toStringUtf8();
    localqlx.g = paramScripCmsInfo.bytes_guide_main_title.get().toStringUtf8();
    localqlx.h = paramScripCmsInfo.bytes_guide_sub_title.get().toStringUtf8();
    localqlx.i = paramScripCmsInfo.bytes_guide_background_url.get().toStringUtf8();
    localqlx.jdField_a_of_type_Long = paramScripCmsInfo.uint64_from_uin.get();
    localqlx.j = paramScripCmsInfo.bytes_scrip_tag.get().toStringUtf8();
    jdField_c_of_type_Int = paramScripCmsInfo.uint32_scrip_total_sum.get();
    jdField_d_of_type_Int = paramScripCmsInfo.uint32_frequency_limit.get();
    return localqlx;
  }
  
  public qlx a()
  {
    try
    {
      super.clone();
      qlx localqlx = new qlx();
      localqlx.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
      localqlx.b = this.b;
      localqlx.jdField_c_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
      localqlx.jdField_d_of_type_JavaLangString = this.jdField_d_of_type_JavaLangString;
      localqlx.e = this.e;
      localqlx.f = this.f;
      localqlx.i = this.i;
      localqlx.g = this.g;
      localqlx.h = this.h;
      localqlx.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
      localqlx.jdField_a_of_type_Long = this.jdField_a_of_type_Long;
      localqlx.j = this.j;
      return localqlx;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     qlx
 * JD-Core Version:    0.7.0.1
 */