package tencent.im.oidb.cmd0x8d3;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class oidb_0x8d3$RspBody
  extends MessageMicro<RspBody>
{
  public static final int RPT_MSG_APPINFO_LIST_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_msg_appinfo_list" }, new Object[] { null }, RspBody.class);
  public final PBRepeatMessageField<oidb_0x8d3.AppInfo> rpt_msg_appinfo_list = PBField.initRepeatMessage(oidb_0x8d3.AppInfo.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     tencent.im.oidb.cmd0x8d3.oidb_0x8d3.RspBody
 * JD-Core Version:    0.7.0.1
 */