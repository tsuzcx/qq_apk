package tencent.im.oidb.cmd0x7c9;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class cmd0x7c9$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint32_next_time_gap", "rpt_hello_content" }, new Object[] { Integer.valueOf(0), null }, RspBody.class);
  public final PBRepeatMessageField<cmd0x7c9.RspHelloContent> rpt_hello_content = PBField.initRepeatMessage(cmd0x7c9.RspHelloContent.class);
  public final PBUInt32Field uint32_next_time_gap = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0x7c9.cmd0x7c9.RspBody
 * JD-Core Version:    0.7.0.1
 */