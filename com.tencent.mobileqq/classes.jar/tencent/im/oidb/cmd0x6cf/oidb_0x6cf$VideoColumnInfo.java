package tencent.im.oidb.cmd0x6cf;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0x6cf$VideoColumnInfo
  extends MessageMicro<VideoColumnInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public oidb_0x6cf.UrlJumpInfo app_jump_info = new oidb_0x6cf.UrlJumpInfo();
  public final PBBytesField bytes_app_icon_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_app_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_column_icon_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_column_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public oidb_0x6cf.UrlJumpInfo default_jump_info = new oidb_0x6cf.UrlJumpInfo();
  public oidb_0x6cf.UrlJumpInfo subscribe_jump_info = new oidb_0x6cf.UrlJumpInfo();
  public final PBUInt32Field uint32_column_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_is_subscribed = PBField.initUInt32(0);
  public final PBUInt32Field uint32_subscribe_count = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 48, 56, 90, 98, 106, 122, 130 }, new String[] { "uint32_column_id", "bytes_column_name", "bytes_column_icon_url", "uint32_subscribe_count", "uint32_is_subscribed", "bytes_app_name", "bytes_app_icon_url", "default_jump_info", "subscribe_jump_info", "app_jump_info" }, new Object[] { Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro3, localByteStringMicro4, null, null, null }, VideoColumnInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     tencent.im.oidb.cmd0x6cf.oidb_0x6cf.VideoColumnInfo
 * JD-Core Version:    0.7.0.1
 */