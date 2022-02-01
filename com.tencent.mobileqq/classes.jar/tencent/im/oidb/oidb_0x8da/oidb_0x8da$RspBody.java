package tencent.im.oidb.oidb_0x8da;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class oidb_0x8da$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_msg_tiny_info" }, new Object[] { null }, RspBody.class);
  public final PBRepeatMessageField<oidb_0x8da.TinyInfo> rpt_msg_tiny_info = PBField.initRepeatMessage(oidb_0x8da.TinyInfo.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.oidb.oidb_0x8da.oidb_0x8da.RspBody
 * JD-Core Version:    0.7.0.1
 */