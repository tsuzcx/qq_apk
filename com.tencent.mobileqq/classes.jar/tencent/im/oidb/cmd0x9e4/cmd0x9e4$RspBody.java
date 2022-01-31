package tencent.im.oidb.cmd0x9e4;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cmd0x9e4$RspBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 90, 96 }, new String[] { "rpt_msg_uin_data", "rpt_uint64_unfinished_uins" }, new Object[] { null, Long.valueOf(0L) }, RspBody.class);
  public final PBRepeatMessageField rpt_msg_uin_data = PBField.initRepeatMessage(cmd0x9e4.UdcUinData.class);
  public final PBRepeatField rpt_uint64_unfinished_uins = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x9e4.cmd0x9e4.RspBody
 * JD-Core Version:    0.7.0.1
 */