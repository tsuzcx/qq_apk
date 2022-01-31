package tencent.im.oidb.cmd0xbc9;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0xbc9$BannerItem
  extends MessageMicro<BannerItem>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_banner_title = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_superscript_color = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_superscript_text = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBRepeatMessageField<oidb_cmd0xbc9.AdReport> msg_ad_click_report = PBField.initRepeatMessage(oidb_cmd0xbc9.AdReport.class);
  public final PBRepeatMessageField<oidb_cmd0xbc9.AdReport> msg_ad_exposure_report = PBField.initRepeatMessage(oidb_cmd0xbc9.AdReport.class);
  public oidb_cmd0xbc9.ContentBannerItem msg_article_content_item = new oidb_cmd0xbc9.ContentBannerItem();
  public oidb_cmd0xbc9.VideoBannerItem msg_video_banner_item = new oidb_cmd0xbc9.VideoBannerItem();
  public final PBUInt32Field uint32_banner_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_is_ad = PBField.initUInt32(0);
  public final PBUInt64Field uint64_banner_id = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42, 50, 56, 66, 74, 80 }, new String[] { "uint32_banner_type", "msg_video_banner_item", "msg_article_content_item", "bytes_superscript_text", "bytes_superscript_color", "bytes_banner_title", "uint32_is_ad", "msg_ad_click_report", "msg_ad_exposure_report", "uint64_banner_id" }, new Object[] { Integer.valueOf(0), null, null, localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, Integer.valueOf(0), null, null, Long.valueOf(0L) }, BannerItem.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0xbc9.oidb_cmd0xbc9.BannerItem
 * JD-Core Version:    0.7.0.1
 */