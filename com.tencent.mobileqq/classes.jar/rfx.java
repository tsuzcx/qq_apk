import android.text.TextUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import tencent.im.oidb.cmd0xbc9.oidb_cmd0xbc9.BannerItem;
import tencent.im.oidb.cmd0xbc9.oidb_cmd0xbc9.VideoBannerItem;

public class rfx
  extends rft
{
  public int b;
  public long b;
  public int c;
  public long c;
  public int d;
  public int e;
  public int f;
  public String f;
  public int g;
  public String g;
  public String h = "";
  public String i = "";
  
  public rfx()
  {
    super(2);
    this.jdField_f_of_type_JavaLangString = "";
    this.jdField_g_of_type_JavaLangString = "";
  }
  
  public static rft b(oidb_cmd0xbc9.BannerItem paramBannerItem)
  {
    if (!paramBannerItem.msg_video_banner_item.has()) {
      return null;
    }
    oidb_cmd0xbc9.VideoBannerItem localVideoBannerItem = (oidb_cmd0xbc9.VideoBannerItem)paramBannerItem.msg_video_banner_item.get();
    rfx localrfx = new rfx();
    if (localVideoBannerItem.bytes_share_url.has()) {
      localrfx.jdField_f_of_type_JavaLangString = localVideoBannerItem.bytes_share_url.get().toStringUtf8();
    }
    if (localVideoBannerItem.uint32_video_duration.has()) {
      localrfx.jdField_b_of_type_Int = localVideoBannerItem.uint32_video_duration.get();
    }
    if (localVideoBannerItem.uint32_video_width.has()) {
      localrfx.jdField_c_of_type_Int = localVideoBannerItem.uint32_video_width.get();
    }
    if (localVideoBannerItem.uint32_video_height.has()) {
      localrfx.d = localVideoBannerItem.uint32_video_height.get();
    }
    if (localVideoBannerItem.bytes_video_vid.has()) {
      localrfx.jdField_g_of_type_JavaLangString = localVideoBannerItem.bytes_video_vid.get().toStringUtf8();
    }
    if (localVideoBannerItem.bytes_video_cover.has()) {
      localrfx.jdField_c_of_type_JavaLangString = localVideoBannerItem.bytes_video_cover.get().toStringUtf8();
    }
    if (localVideoBannerItem.bytes_inner_uinque_id.has()) {
      localrfx.jdField_e_of_type_JavaLangString = localVideoBannerItem.bytes_inner_uinque_id.get().toStringUtf8();
    }
    if (localVideoBannerItem.uint32_busi_type.has()) {
      localrfx.jdField_e_of_type_Int = localVideoBannerItem.uint32_busi_type.get();
    }
    if (localVideoBannerItem.bytes_title.has()) {
      localrfx.i = localVideoBannerItem.bytes_title.get().toStringUtf8();
    }
    if (localVideoBannerItem.bytes_account_name.has()) {
      localrfx.h = localVideoBannerItem.bytes_account_name.get().toStringUtf8();
    }
    if (localVideoBannerItem.uint64_account_uin.has()) {
      localrfx.jdField_b_of_type_Long = localVideoBannerItem.uint64_account_uin.get();
    }
    if (localVideoBannerItem.uint32_is_ugc.has()) {
      localrfx.jdField_f_of_type_Int = localVideoBannerItem.uint32_is_ugc.get();
    }
    if (localVideoBannerItem.uint64_feeds_id.has()) {
      localrfx.jdField_c_of_type_Long = localVideoBannerItem.uint64_feeds_id.get();
    }
    if (localVideoBannerItem.uint32_feeds_type.has()) {
      localrfx.jdField_g_of_type_Int = localVideoBannerItem.uint32_feeds_type.get();
    }
    a(localrfx, paramBannerItem);
    a(paramBannerItem, localrfx);
    return localrfx;
  }
  
  public oidb_cmd0xbc9.BannerItem a()
  {
    oidb_cmd0xbc9.BannerItem localBannerItem = super.a();
    oidb_cmd0xbc9.VideoBannerItem localVideoBannerItem = new oidb_cmd0xbc9.VideoBannerItem();
    if (!TextUtils.isEmpty(this.jdField_f_of_type_JavaLangString)) {
      localVideoBannerItem.bytes_share_url.set(ByteStringMicro.copyFromUtf8(this.jdField_f_of_type_JavaLangString));
    }
    localVideoBannerItem.uint32_video_duration.set(this.jdField_b_of_type_Int);
    localVideoBannerItem.uint32_video_width.set(this.jdField_c_of_type_Int);
    localVideoBannerItem.uint32_video_height.set(this.d);
    if (!TextUtils.isEmpty(this.jdField_g_of_type_JavaLangString)) {
      localVideoBannerItem.bytes_video_vid.set(ByteStringMicro.copyFromUtf8(this.jdField_g_of_type_JavaLangString));
    }
    if (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) {
      localVideoBannerItem.bytes_video_cover.set(ByteStringMicro.copyFromUtf8(this.jdField_c_of_type_JavaLangString));
    }
    if (!TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString)) {
      localVideoBannerItem.bytes_inner_uinque_id.set(ByteStringMicro.copyFromUtf8(this.jdField_e_of_type_JavaLangString));
    }
    localVideoBannerItem.uint32_busi_type.set(this.jdField_e_of_type_Int);
    if (!TextUtils.isEmpty(this.i)) {
      localVideoBannerItem.bytes_title.set(ByteStringMicro.copyFromUtf8(this.i));
    }
    if (!TextUtils.isEmpty(this.h)) {
      localVideoBannerItem.bytes_account_name.set(ByteStringMicro.copyFromUtf8(this.h));
    }
    localVideoBannerItem.uint64_account_uin.set(this.jdField_b_of_type_Long);
    localVideoBannerItem.uint32_is_ugc.set(this.jdField_f_of_type_Int);
    localVideoBannerItem.uint64_feeds_id.set(this.jdField_c_of_type_Long);
    localVideoBannerItem.uint32_feeds_type.set(this.jdField_g_of_type_Int);
    localBannerItem.msg_video_banner_item.set(localVideoBannerItem);
    return localBannerItem;
  }
  
  public boolean a()
  {
    return this.jdField_f_of_type_Int == 1;
  }
  
  public String toString()
  {
    return super.toString() + " vid: " + this.jdField_g_of_type_JavaLangString + " puin : " + this.jdField_b_of_type_Long + " busitype " + this.jdField_e_of_type_Int + " accountName : " + this.h + "  shareUrl : " + this.jdField_f_of_type_JavaLangString + " isUgc " + this.jdField_f_of_type_Int + " feedsId " + this.jdField_c_of_type_Long + " feedsType " + this.jdField_g_of_type_Int + " videoTitle: " + this.i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rfx
 * JD-Core Version:    0.7.0.1
 */