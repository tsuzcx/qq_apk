package tencent.im.oidb.cmd0x5e3;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x5e3$GetQQUinRsp
  extends MessageMicro<GetQQUinRsp>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_auto_remark = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_nick = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_qcall_nick = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_remark = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_birthday = PBField.initUInt32(0);
  public final PBUInt32Field uint32_gender = PBField.initUInt32(0);
  public final PBUInt32Field uint32_is_call_free = PBField.initUInt32(0);
  public final PBUInt32Field uint32_netstatus = PBField.initUInt32(0);
  public final PBUInt64Field uint64_qcall_id = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 160018, 160072, 160248, 560002, 560008, 560016, 560024, 560034, 800162 }, new String[] { "uint64_uin", "bytes_nick", "uint32_gender", "uint32_birthday", "bytes_remark", "uint32_netstatus", "uint64_qcall_id", "uint32_is_call_free", "bytes_auto_remark", "bytes_qcall_nick" }, new Object[] { Long.valueOf(0L), localByteStringMicro1, Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro2, Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), localByteStringMicro3, localByteStringMicro4 }, GetQQUinRsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     tencent.im.oidb.cmd0x5e3.oidb_0x5e3.GetQQUinRsp
 * JD-Core Version:    0.7.0.1
 */