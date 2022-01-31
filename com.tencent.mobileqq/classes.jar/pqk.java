import android.text.TextUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import tencent.im.oidb.articlesummary.feeds_info.AccountProfile;

public class pqk
{
  public int a;
  public long a;
  public String a;
  public String b;
  public String c;
  public String d;
  
  public static pqk a(feeds_info.AccountProfile paramAccountProfile)
  {
    Object localObject;
    if (paramAccountProfile == null) {
      localObject = null;
    }
    pqk localpqk;
    do
    {
      return localObject;
      localpqk = new pqk();
      localpqk.jdField_a_of_type_Long = paramAccountProfile.uint64_uin.get();
      localpqk.jdField_a_of_type_Int = paramAccountProfile.uint32_account_type.get();
      if (paramAccountProfile.bytes_desc.has()) {
        localpqk.c = paramAccountProfile.bytes_desc.get().toStringUtf8();
      }
      if (paramAccountProfile.bytes_profile_photo_url.has()) {
        localpqk.b = paramAccountProfile.bytes_profile_photo_url.get().toStringUtf8();
      }
      if (paramAccountProfile.bytes_nick.has()) {
        localpqk.jdField_a_of_type_JavaLangString = paramAccountProfile.bytes_nick.get().toStringUtf8();
      }
      localObject = localpqk;
    } while (!paramAccountProfile.bytes_home_page_url.has());
    localpqk.d = paramAccountProfile.bytes_home_page_url.get().toStringUtf8();
    return localpqk;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pqk
 * JD-Core Version:    0.7.0.1
 */