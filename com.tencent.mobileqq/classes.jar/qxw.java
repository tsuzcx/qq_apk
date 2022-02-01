import android.text.TextUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import tencent.im.oidb.articlesummary.feeds_info.IconWordingInfo;

public class qxw
{
  public int a;
  public String a;
  public int b;
  public String b;
  public int c;
  public String c;
  public String d;
  
  private static qxw b(feeds_info.IconWordingInfo paramIconWordingInfo)
  {
    qxw localqxw = new qxw();
    localqxw.jdField_a_of_type_Int = pnq.a(paramIconWordingInfo.uint32_type);
    if (paramIconWordingInfo.bytes_icon_url.has()) {
      localqxw.jdField_a_of_type_JavaLangString = paramIconWordingInfo.bytes_icon_url.get().toStringUtf8();
    }
    if (paramIconWordingInfo.bytes_wording.has()) {
      localqxw.jdField_b_of_type_JavaLangString = paramIconWordingInfo.bytes_wording.get().toStringUtf8();
    }
    if (paramIconWordingInfo.bytes_status_icon_url.has()) {
      localqxw.jdField_c_of_type_JavaLangString = paramIconWordingInfo.bytes_status_icon_url.get().toStringUtf8();
    }
    localqxw.jdField_b_of_type_Int = pnq.a(paramIconWordingInfo.uint32_status);
    if (paramIconWordingInfo.bytes_status.has()) {
      localqxw.d = paramIconWordingInfo.bytes_status.get().toStringUtf8();
    }
    localqxw.jdField_c_of_type_Int = pnq.a(paramIconWordingInfo.uint32_icon_show_mode);
    return localqxw;
  }
  
  public feeds_info.IconWordingInfo a()
  {
    feeds_info.IconWordingInfo localIconWordingInfo = new feeds_info.IconWordingInfo();
    localIconWordingInfo.uint32_type.set(this.jdField_a_of_type_Int);
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      localIconWordingInfo.bytes_icon_url.set(ByteStringMicro.copyFromUtf8(this.jdField_a_of_type_JavaLangString));
    }
    if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
      localIconWordingInfo.bytes_wording.set(ByteStringMicro.copyFromUtf8(this.jdField_b_of_type_JavaLangString));
    }
    if (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) {
      localIconWordingInfo.bytes_status_icon_url.set(ByteStringMicro.copyFromUtf8(this.jdField_c_of_type_JavaLangString));
    }
    localIconWordingInfo.uint32_status.set(this.jdField_b_of_type_Int);
    localIconWordingInfo.uint32_icon_show_mode.set(this.jdField_c_of_type_Int);
    if (!TextUtils.isEmpty(this.d)) {
      localIconWordingInfo.bytes_status.set(ByteStringMicro.copyFromUtf8(this.d));
    }
    return localIconWordingInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qxw
 * JD-Core Version:    0.7.0.1
 */