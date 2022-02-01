package tencent.im.oidb.cmd0x777;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class cmd0x777$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_add_frd_info" }, new Object[] { null }, RspBody.class);
  public final PBRepeatMessageField<cmd0x777.AddFrdInfo> rpt_add_frd_info = PBField.initRepeatMessage(cmd0x777.AddFrdInfo.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.oidb.cmd0x777.cmd0x777.RspBody
 * JD-Core Version:    0.7.0.1
 */