import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.articlesummary.articlesummary.ScripCmsInfo;

public class rqh
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
  
  public rqh()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_d_of_type_JavaLangString = "";
    this.jdField_a_of_type_Int = 1;
  }
  
  public static rqh a(articlesummary.ScripCmsInfo paramScripCmsInfo)
  {
    rqh localrqh = new rqh();
    localrqh.jdField_a_of_type_JavaLangString = paramScripCmsInfo.bytes_main_title.get().toStringUtf8();
    localrqh.b = paramScripCmsInfo.bytes_sub_title.get().toStringUtf8();
    localrqh.jdField_c_of_type_JavaLangString = paramScripCmsInfo.bytes_background_url.get().toStringUtf8();
    localrqh.jdField_d_of_type_JavaLangString = paramScripCmsInfo.bytes_left_bottom_txt.get().toStringUtf8();
    localrqh.e = paramScripCmsInfo.bytes_icon_url.get().toStringUtf8();
    localrqh.f = paramScripCmsInfo.bytes_background_animation_url.get().toStringUtf8();
    localrqh.g = paramScripCmsInfo.bytes_guide_main_title.get().toStringUtf8();
    localrqh.h = paramScripCmsInfo.bytes_guide_sub_title.get().toStringUtf8();
    localrqh.i = paramScripCmsInfo.bytes_guide_background_url.get().toStringUtf8();
    localrqh.jdField_a_of_type_Long = paramScripCmsInfo.uint64_from_uin.get();
    localrqh.j = paramScripCmsInfo.bytes_scrip_tag.get().toStringUtf8();
    jdField_c_of_type_Int = paramScripCmsInfo.uint32_scrip_total_sum.get();
    jdField_d_of_type_Int = paramScripCmsInfo.uint32_frequency_limit.get();
    return localrqh;
  }
  
  public rqh a()
  {
    try
    {
      super.clone();
      rqh localrqh = new rqh();
      localrqh.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
      localrqh.b = this.b;
      localrqh.jdField_c_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
      localrqh.jdField_d_of_type_JavaLangString = this.jdField_d_of_type_JavaLangString;
      localrqh.e = this.e;
      localrqh.f = this.f;
      localrqh.i = this.i;
      localrqh.g = this.g;
      localrqh.h = this.h;
      localrqh.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
      localrqh.jdField_a_of_type_Long = this.jdField_a_of_type_Long;
      localrqh.j = this.j;
      return localrqh;
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
 * Qualified Name:     rqh
 * JD-Core Version:    0.7.0.1
 */