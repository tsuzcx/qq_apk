package tencent.im.oidb.cmd0xfa4;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class oidb_cmd0xfa4$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "red_info", "rpt_msg_type_list" }, new Object[] { null, null }, RspBody.class);
  public oidb_cmd0xfa4.RedInfo red_info = new oidb_cmd0xfa4.RedInfo();
  public final PBRepeatMessageField<oidb_cmd0xfa4.MsgBoardTypeInfo> rpt_msg_type_list = PBField.initRepeatMessage(oidb_cmd0xfa4.MsgBoardTypeInfo.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xfa4.oidb_cmd0xfa4.RspBody
 * JD-Core Version:    0.7.0.1
 */