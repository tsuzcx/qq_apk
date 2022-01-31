package tencent.im.oidb.cmd0x74b;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class oidb_0x74b$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_msg_uin_head_list" }, new Object[] { null }, RspBody.class);
  public final PBRepeatMessageField<oidb_0x74b.OneUinHeadInfo> rpt_msg_uin_head_list = PBField.initRepeatMessage(oidb_0x74b.OneUinHeadInfo.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0x74b.oidb_0x74b.RspBody
 * JD-Core Version:    0.7.0.1
 */