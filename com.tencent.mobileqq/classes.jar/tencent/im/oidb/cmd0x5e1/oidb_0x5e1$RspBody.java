package tencent.im.oidb.cmd0x5e1;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x5e1$RspBody
  extends MessageMicro<RspBody>
{
  public static final int RPT_MSG_UIN_DATA_FIELD_NUMBER = 11;
  public static final int RPT_UINT64_UNFINISHED_UINS_FIELD_NUMBER = 12;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 90, 96 }, new String[] { "rpt_msg_uin_data", "rpt_uint64_unfinished_uins" }, new Object[] { null, Long.valueOf(0L) }, RspBody.class);
  public final PBRepeatMessageField<oidb_0x5e1.UdcUinData> rpt_msg_uin_data = PBField.initRepeatMessage(oidb_0x5e1.UdcUinData.class);
  public final PBRepeatField<Long> rpt_uint64_unfinished_uins = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0x5e1.oidb_0x5e1.RspBody
 * JD-Core Version:    0.7.0.1
 */