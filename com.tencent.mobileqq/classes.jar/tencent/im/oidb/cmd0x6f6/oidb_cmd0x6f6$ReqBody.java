package tencent.im.oidb.cmd0x6f6;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class oidb_cmd0x6f6$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_msg_group_info" }, new Object[] { null }, ReqBody.class);
  public final PBRepeatMessageField<oidb_cmd0x6f6.GroupInfo> rpt_msg_group_info = PBField.initRepeatMessage(oidb_cmd0x6f6.GroupInfo.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0x6f6.oidb_cmd0x6f6.ReqBody
 * JD-Core Version:    0.7.0.1
 */