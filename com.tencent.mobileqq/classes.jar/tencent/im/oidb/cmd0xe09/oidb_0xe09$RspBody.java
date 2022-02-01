package tencent.im.oidb.cmd0xe09;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class oidb_0xe09$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 18 }, new String[] { "rpt_online_info" }, new Object[] { null }, RspBody.class);
  public final PBRepeatMessageField<oidb_0xe09.OnlineInfo> rpt_online_info = PBField.initRepeatMessage(oidb_0xe09.OnlineInfo.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xe09.oidb_0xe09.RspBody
 * JD-Core Version:    0.7.0.1
 */