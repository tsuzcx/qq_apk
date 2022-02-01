package tencent.im.oidb.cmd0x5e3;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0x5e3$GetPhoneReq
  extends MessageMicro<GetPhoneReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBRepeatField<ByteStringMicro> rpt_bytes_phones = PBField.initRepeat(PBBytesField.__repeatHelper__);
  public final PBUInt32Field uint32_req_contact_qq = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_qq_status = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 88, 96 }, new String[] { "rpt_bytes_phones", "uint32_req_contact_qq", "uint32_req_qq_status" }, new Object[] { localByteStringMicro, localInteger, localInteger }, GetPhoneReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0x5e3.oidb_0x5e3.GetPhoneReq
 * JD-Core Version:    0.7.0.1
 */