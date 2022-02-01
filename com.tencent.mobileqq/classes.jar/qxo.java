import android.text.TextUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import tencent.im.oidb.articlesummary.feeds_info.AccountProfile;

public class qxo
{
  public int a;
  public long a;
  public String a;
  public String b;
  public String c;
  public String d;
  
  public static qxo a(feeds_info.AccountProfile paramAccountProfile)
  {
    Object localObject;
    if (paramAccountProfile == null) {
      localObject = null;
    }
    qxo localqxo;
    do
    {
      return localObject;
      localqxo = new qxo();
      localqxo.jdField_a_of_type_Long = paramAccountProfile.uint64_uin.get();
      localqxo.jdField_a_of_type_Int = paramAccountProfile.uint32_account_type.get();
      if (paramAccountProfile.bytes_desc.has()) {
        localqxo.c = paramAccountProfile.bytes_desc.get().toStringUtf8();
      }
      if (paramAccountProfile.bytes_profile_photo_url.has()) {
        localqxo.b = paramAccountProfile.bytes_profile_photo_url.get().toStringUtf8();
      }
      if (paramAccountProfile.bytes_nick.has()) {
        localqxo.jdField_a_of_type_JavaLangString = paramAccountProfile.bytes_nick.get().toStringUtf8();
      }
      localObject = localqxo;
    } while (!paramAccountProfile.bytes_home_page_url.has());
    localqxo.d = paramAccountProfile.bytes_home_page_url.get().toStringUtf8();
    return localqxo;
  }
  
  public feeds_info.AccountProfile a()
  {
    feeds_info.AccountProfile localAccountProfile = new feeds_info.AccountProfile();
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      localAccountProfile.bytes_nick.set(ByteStringMicro.copyFromUtf8(this.jdField_a_of_type_JavaLangString));
    }
    if (!TextUtils.isEmpty(this.b)) {
      localAccountProfile.bytes_profile_photo_url.set(ByteStringMicro.copyFromUtf8(this.b));
    }
    if (!TextUtils.isEmpty(this.c)) {
      localAccountProfile.bytes_desc.set(ByteStringMicro.copyFromUtf8(this.c));
    }
    if (!TextUtils.isEmpty(this.d)) {
      localAccountProfile.bytes_home_page_url.set(ByteStringMicro.copyFromUtf8(this.d));
    }
    localAccountProfile.uint32_account_type.set(this.jdField_a_of_type_Int);
    localAccountProfile.uint64_uin.set(this.jdField_a_of_type_Long);
    return localAccountProfile;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qxo
 * JD-Core Version:    0.7.0.1
 */