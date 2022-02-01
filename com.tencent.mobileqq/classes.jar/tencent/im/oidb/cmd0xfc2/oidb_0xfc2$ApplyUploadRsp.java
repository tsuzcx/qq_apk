package tencent.im.oidb.cmd0xfc2;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0xfc2$ApplyUploadRsp
  extends MessageMicro<ApplyUploadRsp>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBoolField bool_file_exist = PBField.initBool(false);
  public final PBBytesField bytes_upload_key = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBRepeatMessageField<oidb_0xfc2.Addr> msg_inner_addr = PBField.initRepeatMessage(oidb_0xfc2.Addr.class);
  public final PBRepeatMessageField<oidb_0xfc2.Addr> msg_out_addr = PBField.initRepeatMessage(oidb_0xfc2.Addr.class);
  public final PBRepeatMessageField<oidb_0xfc2.Addr> msg_out_addr_ipv6 = PBField.initRepeatMessage(oidb_0xfc2.Addr.class);
  public final PBStringField str_fileid = PBField.initString("");
  public final PBStringField str_upload_domain = PBField.initString("");
  public final PBUInt32Field uint32_pack_size = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 42, 50, 58, 66 }, new String[] { "str_fileid", "bytes_upload_key", "bool_file_exist", "uint32_pack_size", "str_upload_domain", "msg_out_addr", "msg_inner_addr", "msg_out_addr_ipv6" }, new Object[] { "", localByteStringMicro, Boolean.valueOf(false), Integer.valueOf(0), "", null, null, null }, ApplyUploadRsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xfc2.oidb_0xfc2.ApplyUploadRsp
 * JD-Core Version:    0.7.0.1
 */