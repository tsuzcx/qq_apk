package tencent.im.oidb.cmd0x5e3;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x5e3$GetPhoneRsp
  extends MessageMicro<GetPhoneRsp>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_phone = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_qq_status = PBField.initUInt32(0);
  public final PBUInt64Field uint64_contact_qq = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 88, 96 }, new String[] { "bytes_phone", "uint64_contact_qq", "uint32_qq_status" }, new Object[] { localByteStringMicro, Long.valueOf(0L), Integer.valueOf(0) }, GetPhoneRsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.oidb.cmd0x5e3.oidb_0x5e3.GetPhoneRsp
 * JD-Core Version:    0.7.0.1
 */