package tencent.im.oidb.cmd0xbd6;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_cmd0xbd6$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field invite_times_limit = PBField.initUInt32(0);
  public final PBUInt32Field remain_invite_times = PBField.initUInt32(0);
  public final PBRepeatMessageField<oidb_cmd0xbd6.Invitee> rpt_msg_invited = PBField.initRepeatMessage(oidb_cmd0xbd6.Invitee.class);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "invite_times_limit", "remain_invite_times", "rpt_msg_invited" }, new Object[] { localInteger, localInteger, null }, RspBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xbd6.oidb_cmd0xbd6.RspBody
 * JD-Core Version:    0.7.0.1
 */