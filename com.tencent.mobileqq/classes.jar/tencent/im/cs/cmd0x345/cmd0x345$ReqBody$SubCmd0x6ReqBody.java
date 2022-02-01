package tencent.im.cs.cmd0x345;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cmd0x345$ReqBody$SubCmd0x6ReqBody
  extends MessageMicro<SubCmd0x6ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_file_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_sig = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_uuid = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBStringField str_dst_phone_number = PBField.initString("");
  public final PBStringField str_file_name = PBField.initString("");
  public final PBStringField str_src_file_path = PBField.initString("");
  public final PBStringField str_src_parent_folder = PBField.initString("");
  public final PBUInt32Field uint32_client_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_dst_bus_id = PBField.initUInt32(0);
  public final PBUInt64Field uint64_app_id = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_dst_uin = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_file_size = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_src_uin = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_talk_type = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    Long localLong = Long.valueOf(0L);
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 40, 48, 58, 66, 74, 80, 88, 98, 106, 112 }, new String[] { "uint32_dst_bus_id", "uint64_src_uin", "bytes_uuid", "bytes_file_md5", "uint64_dst_uin", "uint64_file_size", "str_file_name", "str_src_file_path", "str_src_parent_folder", "uint32_client_type", "uint64_app_id", "str_dst_phone_number", "bytes_sig", "uint64_talk_type" }, new Object[] { localInteger, localLong, localByteStringMicro1, localByteStringMicro2, localLong, localLong, "", "", "", localInteger, localLong, "", localByteStringMicro3, localLong }, SubCmd0x6ReqBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.cs.cmd0x345.cmd0x345.ReqBody.SubCmd0x6ReqBody
 * JD-Core Version:    0.7.0.1
 */