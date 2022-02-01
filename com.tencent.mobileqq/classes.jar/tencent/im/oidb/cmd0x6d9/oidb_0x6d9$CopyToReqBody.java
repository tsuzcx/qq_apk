package tencent.im.oidb.cmd0x6d9;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x6d9$CopyToReqBody
  extends MessageMicro<CopyToReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_tim_cloud_extension_info = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_tim_cloud_pdir_key = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_tim_cloud_ppdir_key = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBStringField str_new_file_name = PBField.initString("");
  public final PBStringField str_src_file_id = PBField.initString("");
  public final PBUInt32Field uint32_app_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_dst_bus_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_src_bus_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_tim_file_exist_option = PBField.initUInt32(0);
  public final PBUInt64Field uint64_dst_uin = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_group_code = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    Long localLong = Long.valueOf(0L);
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 40, 48, 322, 802, 810, 818, 824 }, new String[] { "uint64_group_code", "uint32_app_id", "uint32_src_bus_id", "str_src_file_id", "uint32_dst_bus_id", "uint64_dst_uin", "str_new_file_name", "bytes_tim_cloud_pdir_key", "bytes_tim_cloud_ppdir_key", "bytes_tim_cloud_extension_info", "uint32_tim_file_exist_option" }, new Object[] { localLong, localInteger, localInteger, "", localInteger, localLong, "", localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localInteger }, CopyToReqBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0x6d9.oidb_0x6d9.CopyToReqBody
 * JD-Core Version:    0.7.0.1
 */