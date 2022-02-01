package tencent.im.oidb.cmd0x5d6;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0x5d6$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "uint32_Seq", "str_wording", "rpt_msg_update_result" }, new Object[] { Integer.valueOf(0), "", null }, RspBody.class);
  public final PBRepeatMessageField<oidb_0x5d6.SnsUpateResult> rpt_msg_update_result = PBField.initRepeatMessage(oidb_0x5d6.SnsUpateResult.class);
  public final PBStringField str_wording = PBField.initString("");
  public final PBUInt32Field uint32_Seq = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0x5d6.oidb_0x5d6.RspBody
 * JD-Core Version:    0.7.0.1
 */