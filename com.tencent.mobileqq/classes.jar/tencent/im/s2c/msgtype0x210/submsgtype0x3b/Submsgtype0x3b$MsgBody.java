package tencent.im.s2c.msgtype0x210.submsgtype0x3b;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class Submsgtype0x3b$MsgBody
  extends MessageMicro
{
  public static final int UINT32_MEMBER_LEVEL_CHANGED_FIELD_NUMBER = 4;
  public static final int UINT32_OFFICEMODE_FIELD_NUMBER = 5;
  public static final int UINT32_SUB_CMD_FIELD_NUMBER = 1;
  public static final int UINT32_USER_SHOW_FLAG_FIELD_NUMBER = 3;
  public static final int UINT64_GROUP_CODE_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40 }, new String[] { "uint32_sub_cmd", "uint64_group_code", "uint32_user_show_flag", "uint32_member_level_changed", "uint32_officemode" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, MsgBody.class);
  public final PBUInt32Field uint32_member_level_changed = PBField.initUInt32(0);
  public final PBUInt32Field uint32_officemode = PBField.initUInt32(0);
  public final PBUInt32Field uint32_sub_cmd = PBField.initUInt32(0);
  public final PBUInt32Field uint32_user_show_flag = PBField.initUInt32(0);
  public final PBUInt64Field uint64_group_code = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0x3b.Submsgtype0x3b.MsgBody
 * JD-Core Version:    0.7.0.1
 */