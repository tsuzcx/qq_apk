package tencent.im.s2c.msgtype0x210.submsgtype0x3b;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class Submsgtype0x3b$MsgBody
  extends MessageMicro<MsgBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field uint32_member_level_changed = PBField.initUInt32(0);
  public final PBUInt32Field uint32_member_level_new_changed = PBField.initUInt32(0);
  public final PBUInt32Field uint32_officemode = PBField.initUInt32(0);
  public final PBUInt32Field uint32_sub_cmd = PBField.initUInt32(0);
  public final PBUInt32Field uint32_user_show_flag = PBField.initUInt32(0);
  public final PBUInt64Field uint64_group_code = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 56 }, new String[] { "uint32_sub_cmd", "uint64_group_code", "uint32_user_show_flag", "uint32_member_level_changed", "uint32_officemode", "uint32_member_level_new_changed" }, new Object[] { localInteger, Long.valueOf(0L), localInteger, localInteger, localInteger, localInteger }, MsgBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0x3b.Submsgtype0x3b.MsgBody
 * JD-Core Version:    0.7.0.1
 */