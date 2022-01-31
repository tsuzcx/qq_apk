import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.articlesummary.articlesummary.ScripCmsInfo;

public class qcb
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
  
  public qcb()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_d_of_type_JavaLangString = "";
    this.jdField_a_of_type_Int = 1;
  }
  
  public static qcb a(articlesummary.ScripCmsInfo paramScripCmsInfo)
  {
    qcb localqcb = new qcb();
    localqcb.jdField_a_of_type_JavaLangString = paramScripCmsInfo.bytes_main_title.get().toStringUtf8();
    localqcb.b = paramScripCmsInfo.bytes_sub_title.get().toStringUtf8();
    localqcb.jdField_c_of_type_JavaLangString = paramScripCmsInfo.bytes_background_url.get().toStringUtf8();
    localqcb.jdField_d_of_type_JavaLangString = paramScripCmsInfo.bytes_left_bottom_txt.get().toStringUtf8();
    localqcb.e = paramScripCmsInfo.bytes_icon_url.get().toStringUtf8();
    localqcb.f = paramScripCmsInfo.bytes_background_animation_url.get().toStringUtf8();
    localqcb.g = paramScripCmsInfo.bytes_guide_main_title.get().toStringUtf8();
    localqcb.h = paramScripCmsInfo.bytes_guide_sub_title.get().toStringUtf8();
    localqcb.i = paramScripCmsInfo.bytes_guide_background_url.get().toStringUtf8();
    localqcb.jdField_a_of_type_Long = paramScripCmsInfo.uint64_from_uin.get();
    localqcb.j = paramScripCmsInfo.bytes_scrip_tag.get().toStringUtf8();
    jdField_c_of_type_Int = paramScripCmsInfo.uint32_scrip_total_sum.get();
    jdField_d_of_type_Int = paramScripCmsInfo.uint32_frequency_limit.get();
    return localqcb;
  }
  
  public qcb a()
  {
    try
    {
      super.clone();
      qcb localqcb = new qcb();
      localqcb.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
      localqcb.b = this.b;
      localqcb.jdField_c_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
      localqcb.jdField_d_of_type_JavaLangString = this.jdField_d_of_type_JavaLangString;
      localqcb.e = this.e;
      localqcb.f = this.f;
      localqcb.i = this.i;
      localqcb.g = this.g;
      localqcb.h = this.h;
      localqcb.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
      localqcb.jdField_a_of_type_Long = this.jdField_a_of_type_Long;
      localqcb.j = this.j;
      return localqcb;
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
 * Qualified Name:     qcb
 * JD-Core Version:    0.7.0.1
 */