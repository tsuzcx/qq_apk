package tencent.im.oidb.cmd0xbc9;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0xbc9$VideoBannerItem
  extends MessageMicro<VideoBannerItem>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_account_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_inner_uinque_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_share_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_title = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_video_cover = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_video_vid = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_busi_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_feeds_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_is_ugc = PBField.initUInt32(0);
  public final PBUInt32Field uint32_video_duration = PBField.initUInt32(0);
  public final PBUInt32Field uint32_video_height = PBField.initUInt32(0);
  public final PBUInt32Field uint32_video_width = PBField.initUInt32(0);
  public final PBUInt64Field uint64_account_uin = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_feeds_id = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro6 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32, 42, 50, 58, 64, 74, 82, 88, 96, 104, 112 }, new String[] { "bytes_share_url", "uint32_video_duration", "uint32_video_width", "uint32_video_height", "bytes_video_vid", "bytes_video_cover", "bytes_inner_uinque_id", "uint32_busi_type", "bytes_title", "bytes_account_name", "uint64_account_uin", "uint32_feeds_type", "uint64_feeds_id", "uint32_is_ugc" }, new Object[] { localByteStringMicro1, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, Integer.valueOf(0), localByteStringMicro5, localByteStringMicro6, Long.valueOf(0L), Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0) }, VideoBannerItem.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     tencent.im.oidb.cmd0xbc9.oidb_cmd0xbc9.VideoBannerItem
 * JD-Core Version:    0.7.0.1
 */