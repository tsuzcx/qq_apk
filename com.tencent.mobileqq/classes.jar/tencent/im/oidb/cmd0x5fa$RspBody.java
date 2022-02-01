package tencent.im.oidb;

import appoint.define.appoint_define.StrangerInfo;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class cmd0x5fa$RspBody
  extends MessageMicro<RspBody>
{
  public static final int RPT_MSG_STRANGER_INFO_FIELD_NUMBER = 1;
  public static final int UINT32_REACH_END_FIELD_NUMBER = 3;
  public static final int UINT32_REACH_START_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24 }, new String[] { "rpt_msg_stranger_info", "uint32_reach_start", "uint32_reach_end" }, new Object[] { null, Integer.valueOf(0), Integer.valueOf(0) }, RspBody.class);
  public final PBRepeatMessageField<appoint_define.StrangerInfo> rpt_msg_stranger_info = PBField.initRepeatMessage(appoint_define.StrangerInfo.class);
  public final PBUInt32Field uint32_reach_end = PBField.initUInt32(0);
  public final PBUInt32Field uint32_reach_start = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0x5fa.RspBody
 * JD-Core Version:    0.7.0.1
 */