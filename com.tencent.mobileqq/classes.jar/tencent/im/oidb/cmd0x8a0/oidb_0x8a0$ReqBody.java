package tencent.im.oidb.cmd0x8a0;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x8a0$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_kick_msg = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt64Field opt_uint64_group_code = PBField.initUInt64(0L);
  public final PBRepeatField<Long> rpt_kick_list = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  public final PBRepeatMessageField<oidb_0x8a0.KickMemberInfo> rpt_msg_kick_list = PBField.initRepeatMessage(oidb_0x8a0.KickMemberInfo.class);
  public final PBUInt32Field uint32_kick_flag = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 42 }, new String[] { "opt_uint64_group_code", "rpt_msg_kick_list", "rpt_kick_list", "uint32_kick_flag", "bytes_kick_msg" }, new Object[] { Long.valueOf(0L), null, Long.valueOf(0L), Integer.valueOf(0), localByteStringMicro }, ReqBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     tencent.im.oidb.cmd0x8a0.oidb_0x8a0.ReqBody
 * JD-Core Version:    0.7.0.1
 */