package tencent.im.cs.cmd0x388;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cmd0x388$GetPttUrlRsp
  extends MessageMicro<GetPttUrlRsp>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_client_ip6 = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_down_domain = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_down_para = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_fail_msg = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_file_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBRepeatField<ByteStringMicro> rpt_bytes_down_url = PBField.initRepeat(PBBytesField.__repeatHelper__);
  public final PBRepeatMessageField<cmd0x388.IPv6Info> rpt_msg_down_ip6 = PBField.initRepeatMessage(cmd0x388.IPv6Info.class);
  public final PBStringField rpt_str_domain = PBField.initString("");
  public final PBRepeatField<Integer> rpt_uint32_down_ip = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
  public final PBRepeatField<Integer> rpt_uint32_down_port = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
  public final PBUInt32Field uint32_allow_retry = PBField.initUInt32(0);
  public final PBUInt32Field uint32_result = PBField.initUInt32(0);
  public final PBUInt32Field uint32_transfer_type = PBField.initUInt32(0);
  public final PBUInt64Field uint64_file_id = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_fileid = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro6 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34, 42, 48, 56, 66, 74, 80, 88, 96, 210, 218, 226 }, new String[] { "uint64_fileid", "bytes_file_md5", "uint32_result", "bytes_fail_msg", "rpt_bytes_down_url", "rpt_uint32_down_ip", "rpt_uint32_down_port", "bytes_down_domain", "bytes_down_para", "uint64_file_id", "uint32_transfer_type", "uint32_allow_retry", "rpt_msg_down_ip6", "bytes_client_ip6", "rpt_str_domain" }, new Object[] { Long.valueOf(0L), localByteStringMicro1, Integer.valueOf(0), localByteStringMicro2, localByteStringMicro3, Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro4, localByteStringMicro5, Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), null, localByteStringMicro6, "" }, GetPttUrlRsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     tencent.im.cs.cmd0x388.cmd0x388.GetPttUrlRsp
 * JD-Core Version:    0.7.0.1
 */