import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.articlesummary.articlesummary.ScripCmsInfo;

public class qxc
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
  
  public qxc()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_d_of_type_JavaLangString = "";
    this.jdField_a_of_type_Int = 1;
  }
  
  public static qxc a(articlesummary.ScripCmsInfo paramScripCmsInfo)
  {
    qxc localqxc = new qxc();
    localqxc.jdField_a_of_type_JavaLangString = paramScripCmsInfo.bytes_main_title.get().toStringUtf8();
    localqxc.b = paramScripCmsInfo.bytes_sub_title.get().toStringUtf8();
    localqxc.jdField_c_of_type_JavaLangString = paramScripCmsInfo.bytes_background_url.get().toStringUtf8();
    localqxc.jdField_d_of_type_JavaLangString = paramScripCmsInfo.bytes_left_bottom_txt.get().toStringUtf8();
    localqxc.e = paramScripCmsInfo.bytes_icon_url.get().toStringUtf8();
    localqxc.f = paramScripCmsInfo.bytes_background_animation_url.get().toStringUtf8();
    localqxc.g = paramScripCmsInfo.bytes_guide_main_title.get().toStringUtf8();
    localqxc.h = paramScripCmsInfo.bytes_guide_sub_title.get().toStringUtf8();
    localqxc.i = paramScripCmsInfo.bytes_guide_background_url.get().toStringUtf8();
    localqxc.jdField_a_of_type_Long = paramScripCmsInfo.uint64_from_uin.get();
    localqxc.j = paramScripCmsInfo.bytes_scrip_tag.get().toStringUtf8();
    jdField_c_of_type_Int = paramScripCmsInfo.uint32_scrip_total_sum.get();
    jdField_d_of_type_Int = paramScripCmsInfo.uint32_frequency_limit.get();
    return localqxc;
  }
  
  public qxc a()
  {
    try
    {
      super.clone();
      qxc localqxc = new qxc();
      localqxc.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
      localqxc.b = this.b;
      localqxc.jdField_c_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
      localqxc.jdField_d_of_type_JavaLangString = this.jdField_d_of_type_JavaLangString;
      localqxc.e = this.e;
      localqxc.f = this.f;
      localqxc.i = this.i;
      localqxc.g = this.g;
      localqxc.h = this.h;
      localqxc.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
      localqxc.jdField_a_of_type_Long = this.jdField_a_of_type_Long;
      localqxc.j = this.j;
      return localqxc;
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
 * Qualified Name:     qxc
 * JD-Core Version:    0.7.0.1
 */