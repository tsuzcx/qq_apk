package tencent.im.oidb.cmd0x8a0;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x8a0$ReqBody
  extends MessageMicro
{
  public static final int OPT_UINT64_GROUP_CODE_FIELD_NUMBER = 1;
  public static final int RPT_MSG_KICK_LIST_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "opt_uint64_group_code", "rpt_msg_kick_list" }, new Object[] { Long.valueOf(0L), null }, ReqBody.class);
  public final PBUInt64Field opt_uint64_group_code = PBField.initUInt64(0L);
  public final PBRepeatMessageField rpt_msg_kick_list = PBField.initRepeatMessage(oidb_0x8a0.KickMemberInfo.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x8a0.oidb_0x8a0.ReqBody
 * JD-Core Version:    0.7.0.1
 */