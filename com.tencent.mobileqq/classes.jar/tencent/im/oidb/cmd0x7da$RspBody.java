package tencent.im.oidb;

import appoint.define.appoint_define.AppointInfo;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class cmd0x7da$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24 }, new String[] { "str_wording", "rpt_msg_appoint_info", "uint32_operation_reason" }, new Object[] { "", null, Integer.valueOf(0) }, RspBody.class);
  public final PBRepeatMessageField<appoint_define.AppointInfo> rpt_msg_appoint_info = PBField.initRepeatMessage(appoint_define.AppointInfo.class);
  public final PBStringField str_wording = PBField.initString("");
  public final PBUInt32Field uint32_operation_reason = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     tencent.im.oidb.cmd0x7da.RspBody
 * JD-Core Version:    0.7.0.1
 */