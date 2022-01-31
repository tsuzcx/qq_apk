import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.articlesummary.articlesummary.ScripCmsInfo;

public class qce
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
  
  public qce()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_d_of_type_JavaLangString = "";
    this.jdField_a_of_type_Int = 1;
  }
  
  public static qce a(articlesummary.ScripCmsInfo paramScripCmsInfo)
  {
    qce localqce = new qce();
    localqce.jdField_a_of_type_JavaLangString = paramScripCmsInfo.bytes_main_title.get().toStringUtf8();
    localqce.b = paramScripCmsInfo.bytes_sub_title.get().toStringUtf8();
    localqce.jdField_c_of_type_JavaLangString = paramScripCmsInfo.bytes_background_url.get().toStringUtf8();
    localqce.jdField_d_of_type_JavaLangString = paramScripCmsInfo.bytes_left_bottom_txt.get().toStringUtf8();
    localqce.e = paramScripCmsInfo.bytes_icon_url.get().toStringUtf8();
    localqce.f = paramScripCmsInfo.bytes_background_animation_url.get().toStringUtf8();
    localqce.g = paramScripCmsInfo.bytes_guide_main_title.get().toStringUtf8();
    localqce.h = paramScripCmsInfo.bytes_guide_sub_title.get().toStringUtf8();
    localqce.i = paramScripCmsInfo.bytes_guide_background_url.get().toStringUtf8();
    localqce.jdField_a_of_type_Long = paramScripCmsInfo.uint64_from_uin.get();
    localqce.j = paramScripCmsInfo.bytes_scrip_tag.get().toStringUtf8();
    jdField_c_of_type_Int = paramScripCmsInfo.uint32_scrip_total_sum.get();
    jdField_d_of_type_Int = paramScripCmsInfo.uint32_frequency_limit.get();
    return localqce;
  }
  
  public qce a()
  {
    try
    {
      super.clone();
      qce localqce = new qce();
      localqce.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
      localqce.b = this.b;
      localqce.jdField_c_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
      localqce.jdField_d_of_type_JavaLangString = this.jdField_d_of_type_JavaLangString;
      localqce.e = this.e;
      localqce.f = this.f;
      localqce.i = this.i;
      localqce.g = this.g;
      localqce.h = this.h;
      localqce.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
      localqce.jdField_a_of_type_Long = this.jdField_a_of_type_Long;
      localqce.j = this.j;
      return localqce;
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
 * Qualified Name:     qce
 * JD-Core Version:    0.7.0.1
 */