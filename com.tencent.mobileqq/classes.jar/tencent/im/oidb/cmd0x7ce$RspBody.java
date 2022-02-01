package tencent.im.oidb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class cmd0x7ce$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26 }, new String[] { "rpt_msg_appoints_info", "uint32_secure_flag", "str_secure_tips" }, new Object[] { null, Integer.valueOf(0), "" }, RspBody.class);
  public final PBRepeatMessageField<cmd0x7ce.AppintDetail> rpt_msg_appoints_info = PBField.initRepeatMessage(cmd0x7ce.AppintDetail.class);
  public final PBStringField str_secure_tips = PBField.initString("");
  public final PBUInt32Field uint32_secure_flag = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.oidb.cmd0x7ce.RspBody
 * JD-Core Version:    0.7.0.1
 */