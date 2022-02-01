package tencent.im.oidb.cmd0x44c;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cmd0x44c$ModifyConfInfoReq
  extends MessageMicro<ModifyConfInfoReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 40, 48 }, new String[] { "uint64_conf_uin", "uint32_last_passwd_red_bag_time", "uint32_conf_meeting_origin", "msg_self_member_info", "uint32_qidian_conf_type", "uint32_conf_meeting_option" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(0), Integer.valueOf(0) }, ModifyConfInfoReq.class);
  public cmd0x44c.ModifySelfMemberInfo msg_self_member_info = new cmd0x44c.ModifySelfMemberInfo();
  public final PBUInt32Field uint32_conf_meeting_option = PBField.initUInt32(0);
  public final PBUInt32Field uint32_conf_meeting_origin = PBField.initUInt32(0);
  public final PBUInt32Field uint32_last_passwd_red_bag_time = PBField.initUInt32(0);
  public final PBUInt32Field uint32_qidian_conf_type = PBField.initUInt32(0);
  public final PBUInt64Field uint64_conf_uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0x44c.cmd0x44c.ModifyConfInfoReq
 * JD-Core Version:    0.7.0.1
 */