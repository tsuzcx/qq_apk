import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.articlesummary.articlesummary.ScripCmsInfo;

public class rgj
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
  
  public rgj()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_d_of_type_JavaLangString = "";
    this.jdField_a_of_type_Int = 1;
  }
  
  public static rgj a(articlesummary.ScripCmsInfo paramScripCmsInfo)
  {
    rgj localrgj = new rgj();
    localrgj.jdField_a_of_type_JavaLangString = paramScripCmsInfo.bytes_main_title.get().toStringUtf8();
    localrgj.b = paramScripCmsInfo.bytes_sub_title.get().toStringUtf8();
    localrgj.jdField_c_of_type_JavaLangString = paramScripCmsInfo.bytes_background_url.get().toStringUtf8();
    localrgj.jdField_d_of_type_JavaLangString = paramScripCmsInfo.bytes_left_bottom_txt.get().toStringUtf8();
    localrgj.e = paramScripCmsInfo.bytes_icon_url.get().toStringUtf8();
    localrgj.f = paramScripCmsInfo.bytes_background_animation_url.get().toStringUtf8();
    localrgj.g = paramScripCmsInfo.bytes_guide_main_title.get().toStringUtf8();
    localrgj.h = paramScripCmsInfo.bytes_guide_sub_title.get().toStringUtf8();
    localrgj.i = paramScripCmsInfo.bytes_guide_background_url.get().toStringUtf8();
    localrgj.jdField_a_of_type_Long = paramScripCmsInfo.uint64_from_uin.get();
    localrgj.j = paramScripCmsInfo.bytes_scrip_tag.get().toStringUtf8();
    jdField_c_of_type_Int = paramScripCmsInfo.uint32_scrip_total_sum.get();
    jdField_d_of_type_Int = paramScripCmsInfo.uint32_frequency_limit.get();
    return localrgj;
  }
  
  public rgj a()
  {
    try
    {
      super.clone();
      rgj localrgj = new rgj();
      localrgj.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
      localrgj.b = this.b;
      localrgj.jdField_c_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
      localrgj.jdField_d_of_type_JavaLangString = this.jdField_d_of_type_JavaLangString;
      localrgj.e = this.e;
      localrgj.f = this.f;
      localrgj.i = this.i;
      localrgj.g = this.g;
      localrgj.h = this.h;
      localrgj.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
      localrgj.jdField_a_of_type_Long = this.jdField_a_of_type_Long;
      localrgj.j = this.j;
      return localrgj;
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
 * Qualified Name:     rgj
 * JD-Core Version:    0.7.0.1
 */