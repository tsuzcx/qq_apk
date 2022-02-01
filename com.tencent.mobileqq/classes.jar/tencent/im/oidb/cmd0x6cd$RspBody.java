package tencent.im.oidb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class cmd0x6cd$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "rpt_msg_redpoint", "rpt_unfinished_redpoint" }, new Object[] { null, null }, RspBody.class);
  public final PBRepeatMessageField<cmd0x6cd.RedpointInfo> rpt_msg_redpoint = PBField.initRepeatMessage(cmd0x6cd.RedpointInfo.class);
  public final PBRepeatMessageField<cmd0x6cd.PullRedpointReq> rpt_unfinished_redpoint = PBField.initRepeatMessage(cmd0x6cd.PullRedpointReq.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0x6cd.RspBody
 * JD-Core Version:    0.7.0.1
 */