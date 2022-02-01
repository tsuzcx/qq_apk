package tencent.im.oidb.cmd0xcf0;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class cmd0xcf0$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint32_total_bind_contacts_frd_num", "rpt_msg_bind_contacts_frds" }, new Object[] { Integer.valueOf(0), null }, RspBody.class);
  public final PBRepeatMessageField<cmd0xcf0.BindContactsFriendInfo> rpt_msg_bind_contacts_frds = PBField.initRepeatMessage(cmd0xcf0.BindContactsFriendInfo.class);
  public final PBUInt32Field uint32_total_bind_contacts_frd_num = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.oidb.cmd0xcf0.cmd0xcf0.RspBody
 * JD-Core Version:    0.7.0.1
 */