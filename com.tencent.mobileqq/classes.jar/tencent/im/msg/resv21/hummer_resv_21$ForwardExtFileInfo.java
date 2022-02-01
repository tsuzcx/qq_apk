package tencent.im.msg.resv21;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class hummer_resv_21$ForwardExtFileInfo
  extends MessageMicro<ForwardExtFileInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_file_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_file_sha1 = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_file_uuid = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBInt64Field int64_dead_time = PBField.initInt64(0L);
  public final PBStringField str_file_name = PBField.initString("");
  public final PBStringField str_fileidcrc = PBField.initString("");
  public final PBUInt32Field uint32_bus_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_file_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_img_height = PBField.initUInt32(0);
  public final PBUInt32Field uint32_img_width = PBField.initUInt32(0);
  public final PBUInt64Field uint64_file_size = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_receiver_uin = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_sender_uin = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_video_duration = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    Long localLong = Long.valueOf(0L);
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 42, 48, 58, 66, 72, 80, 88, 96, 104, 114 }, new String[] { "uint32_file_type", "uint64_sender_uin", "uint64_receiver_uin", "bytes_file_uuid", "str_file_name", "uint64_file_size", "bytes_file_sha1", "bytes_file_md5", "int64_dead_time", "uint32_img_width", "uint32_img_height", "uint64_video_duration", "uint32_bus_id", "str_fileidcrc" }, new Object[] { localInteger, localLong, localLong, localByteStringMicro1, "", localLong, localByteStringMicro2, localByteStringMicro3, localLong, localInteger, localInteger, localLong, localInteger, "" }, ForwardExtFileInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.msg.resv21.hummer_resv_21.ForwardExtFileInfo
 * JD-Core Version:    0.7.0.1
 */