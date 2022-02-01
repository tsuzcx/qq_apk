package tencent.im.oidb.cmd0xd68;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0xd68$ForwardDataWireReqBody
  extends MessageMicro<ForwardDataWireReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_file_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_src_parent_folder = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_src_uuid = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBStringField cid = PBField.initString("");
  public final PBStringField str_file_name = PBField.initString("");
  public final PBUInt32Field uint32_client_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_src_svcid = PBField.initUInt32(0);
  public final PBUInt64Field uint64_dst_uin = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_file_size = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 40, 48, 58, 66, 72 }, new String[] { "uint32_src_svcid", "bytes_src_parent_folder", "bytes_src_uuid", "bytes_file_md5", "uint64_dst_uin", "uint64_file_size", "str_file_name", "cid", "uint32_client_type" }, new Object[] { localInteger, localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localLong, localLong, "", "", localInteger }, ForwardDataWireReqBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xd68.oidb_cmd0xd68.ForwardDataWireReqBody
 * JD-Core Version:    0.7.0.1
 */