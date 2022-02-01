package tencent.im.oidb.cmd0x6cf;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0x6cf$ECommerceEntranceInfo
  extends MessageMicro<ECommerceEntranceInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public oidb_0x6cf.AppAdInfo appInfo = new oidb_0x6cf.AppAdInfo();
  public final PBBytesField bytes_common_data = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_jump_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_link_icon_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_subtitle = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_thumbnail_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_title = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_display_count_ver = PBField.initUInt32(0);
  public final PBUInt32Field uint32_ecommerce_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_jump_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_one_day_max_display_count = PBField.initUInt32(0);
  public final PBUInt32Field uint32_session_max_display_count = PBField.initUInt32(0);
  public final PBUInt32Field uint32_style = PBField.initUInt32(0);
  public final PBUInt32Field video_play_length = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro6 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42, 48, 58, 66, 72, 80, 88, 96, 106, 112 }, new String[] { "uint32_ecommerce_id", "bytes_title", "bytes_subtitle", "bytes_thumbnail_url", "bytes_link_icon_url", "uint32_jump_type", "bytes_jump_url", "bytes_common_data", "uint32_session_max_display_count", "uint32_one_day_max_display_count", "uint32_display_count_ver", "uint32_style", "appInfo", "video_play_length" }, new Object[] { localInteger, localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, localInteger, localByteStringMicro5, localByteStringMicro6, localInteger, localInteger, localInteger, localInteger, null, localInteger }, ECommerceEntranceInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0x6cf.oidb_0x6cf.ECommerceEntranceInfo
 * JD-Core Version:    0.7.0.1
 */