package tencent.im.s2c.msgtype0x210.submsgtype0x27;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class SubMsgType0x27$ModGroupProfile
  extends MessageMicro<ModGroupProfile>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBRepeatMessageField<SubMsgType0x27.GroupProfileInfo> rpt_msg_group_profile_infos = PBField.initRepeatMessage(SubMsgType0x27.GroupProfileInfo.class);
  public final PBUInt64Field uint64_cmd_uin = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_group_code = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_group_uin = PBField.initUInt64(0L);
  
  static
  {
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32 }, new String[] { "uint64_group_uin", "rpt_msg_group_profile_infos", "uint64_group_code", "uint64_cmd_uin" }, new Object[] { localLong, null, localLong, localLong }, ModGroupProfile.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.ModGroupProfile
 * JD-Core Version:    0.7.0.1
 */