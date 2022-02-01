package tencent.im.oidb.cmd0xd50;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class Oidb_0xd50$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBRepeatMessageField<Oidb_0xd50.ExtSnsFrdData> rpt_msg_update_data = PBField.initRepeatMessage(Oidb_0xd50.ExtSnsFrdData.class);
  public final PBRepeatField<Long> rpt_uint64_unfinished_uins = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  public final PBUInt32Field uint32_next_start = PBField.initUInt32(0);
  public final PBUInt32Field uint32_over = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 88, 96, 104 }, new String[] { "rpt_msg_update_data", "uint32_over", "uint32_next_start", "rpt_uint64_unfinished_uins" }, new Object[] { null, localInteger, localInteger, Long.valueOf(0L) }, RspBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0xd50.Oidb_0xd50.RspBody
 * JD-Core Version:    0.7.0.1
 */