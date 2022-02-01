package tencent.im.oidb.cmd0xee9;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class oidb_cmd0xee9$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_msg_user_info" }, new Object[] { null }, RspBody.class);
  public final PBRepeatMessageField<oidb_cmd0xee9.UserInfoItem> rpt_msg_user_info = PBField.initRepeatMessage(oidb_cmd0xee9.UserInfoItem.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0xee9.oidb_cmd0xee9.RspBody
 * JD-Core Version:    0.7.0.1
 */