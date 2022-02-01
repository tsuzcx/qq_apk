package tencent.im.oidb.cmd0x5cf;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class Oidb_0x5cf$DelMsgInfo
  extends MessageMicro<DelMsgInfo>
{
  public static final int RPT_MSG_DECIDE_INFO_FIELD_NUMBER = 1;
  public static final int RPT_MSG_UNDECIDE_INFO_FIELD_NUMBER = 2;
  public static final int UINT32_PLATFORM_FIELD_NUMBER = 3;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24 }, new String[] { "rpt_msg_decide_info", "rpt_msg_undecide_info", "uint32_platform" }, new Object[] { null, null, Integer.valueOf(0) }, DelMsgInfo.class);
  public final PBRepeatMessageField<Oidb_0x5cf.DelDecideInfo> rpt_msg_decide_info = PBField.initRepeatMessage(Oidb_0x5cf.DelDecideInfo.class);
  public final PBRepeatMessageField<Oidb_0x5cf.DelUnDecideInfo> rpt_msg_undecide_info = PBField.initRepeatMessage(Oidb_0x5cf.DelUnDecideInfo.class);
  public final PBUInt32Field uint32_platform = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0x5cf.Oidb_0x5cf.DelMsgInfo
 * JD-Core Version:    0.7.0.1
 */