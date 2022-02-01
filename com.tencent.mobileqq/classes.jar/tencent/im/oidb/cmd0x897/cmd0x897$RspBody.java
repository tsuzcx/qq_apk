package tencent.im.oidb.cmd0x897;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class cmd0x897$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "uint32_result", "rpt_msg_grp_visitor_info", "str_err_msg" }, new Object[] { Integer.valueOf(0), null, "" }, RspBody.class);
  public final PBRepeatMessageField<cmd0x897.GroupVisitorInfo> rpt_msg_grp_visitor_info = PBField.initRepeatMessage(cmd0x897.GroupVisitorInfo.class);
  public final PBStringField str_err_msg = PBField.initString("");
  public final PBUInt32Field uint32_result = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0x897.cmd0x897.RspBody
 * JD-Core Version:    0.7.0.1
 */