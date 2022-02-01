package tencent.im.oidb.cmd0x5e0;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class Oidb_0x5e0$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_svrcontext = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBRepeatMessageField<Oidb_0x5e0.UpdateProfileList> rpt_msg_update_profile_list = PBField.initRepeatMessage(Oidb_0x5e0.UpdateProfileList.class);
  public final PBRepeatField<Long> rpt_uint64_uinlist = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  public final PBUInt32Field uint32_forced_update = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32 }, new String[] { "rpt_msg_update_profile_list", "bytes_svrcontext", "rpt_uint64_uinlist", "uint32_forced_update" }, new Object[] { null, localByteStringMicro, Long.valueOf(0L), Integer.valueOf(0) }, ReqBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0x5e0.Oidb_0x5e0.ReqBody
 * JD-Core Version:    0.7.0.1
 */