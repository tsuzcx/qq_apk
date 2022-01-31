package tencent.im.oidb.cmd0x82a;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class cmd0x82a$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "msg_status" }, new Object[] { null }, RspBody.class);
  public final PBRepeatMessageField<cmd0x82a.MsgStatus> msg_status = PBField.initRepeatMessage(cmd0x82a.MsgStatus.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     tencent.im.oidb.cmd0x82a.cmd0x82a.RspBody
 * JD-Core Version:    0.7.0.1
 */