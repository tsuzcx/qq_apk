package tencent.im.oidb.cmd0xea3;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0xea3$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32 }, new String[] { "result", "errmsg", "back_group_msg", "return_unchange_seq" }, new Object[] { Integer.valueOf(0), "", null, Long.valueOf(0L) }, RspBody.class);
  public final PBRepeatMessageField<oidb_0xea3.BackMsg> back_group_msg = PBField.initRepeatMessage(oidb_0xea3.BackMsg.class);
  public final PBStringField errmsg = PBField.initString("");
  public final PBUInt32Field result = PBField.initUInt32(0);
  public final PBRepeatField<Long> return_unchange_seq = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xea3.oidb_0xea3.RspBody
 * JD-Core Version:    0.7.0.1
 */