package tencent.im.oidb.general_group_notify;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class general_group_notify$GroupNotify
  extends MessageMicro<GroupNotify>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "opt_uint32_msg_type", "opt_st_alliance_notify" }, new Object[] { Integer.valueOf(0), null }, GroupNotify.class);
  public general_group_notify.GroupAllianceNotify opt_st_alliance_notify = new general_group_notify.GroupAllianceNotify();
  public final PBUInt32Field opt_uint32_msg_type = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.oidb.general_group_notify.general_group_notify.GroupNotify
 * JD-Core Version:    0.7.0.1
 */