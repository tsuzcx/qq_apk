package tencent.im.oidb.cmd0x6cf;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x6cf$VideoColumnInfo
  extends MessageMicro<VideoColumnInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public oidb_0x6cf.UrlJumpInfo app_jump_info = new oidb_0x6cf.UrlJumpInfo();
  public final PBBytesField bytes_app_icon_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_app_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_column_icon_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_column_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_from_txt = PBField.initBytes(ByteStringMicro.EMPTY);
  public oidb_0x6cf.UrlJumpInfo default_jump_info = new oidb_0x6cf.UrlJumpInfo();
  public oidb_0x6cf.UrlJumpInfo subscribe_jump_info = new oidb_0x6cf.UrlJumpInfo();
  public final PBUInt32Field uint32_column_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_is_subscribed = PBField.initUInt32(0);
  public final PBUInt32Field uint32_style = PBField.initUInt32(0);
  public final PBUInt32Field uint32_subscribe_count = PBField.initUInt32(0);
  public final PBUInt32Field uint32_update_count = PBField.initUInt32(0);
  public final PBUInt32Field uint32_video_count = PBField.initUInt32(0);
  public final PBUInt64Field uint64_last_update_time = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 40, 48, 56, 90, 98, 106, 122, 130, 136, 146, 160 }, new String[] { "uint32_column_id", "bytes_column_name", "bytes_column_icon_url", "uint64_last_update_time", "uint32_video_count", "uint32_subscribe_count", "uint32_is_subscribed", "bytes_app_name", "bytes_app_icon_url", "default_jump_info", "subscribe_jump_info", "app_jump_info", "uint32_style", "bytes_from_txt", "uint32_update_count" }, new Object[] { Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro3, localByteStringMicro4, null, null, null, Integer.valueOf(0), localByteStringMicro5, Integer.valueOf(0) }, VideoColumnInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0x6cf.oidb_0x6cf.VideoColumnInfo
 * JD-Core Version:    0.7.0.1
 */