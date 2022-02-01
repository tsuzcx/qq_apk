package tencent.im.oidb.cmd0xe83;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0xe83$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 42 }, new String[] { "group_id", "infos", "extra_info", "add_limit", "manage_info" }, new Object[] { Long.valueOf(0L), null, null, Integer.valueOf(0), null }, RspBody.class);
  public final PBUInt32Field add_limit = PBField.initUInt32(0);
  public oidb_0xe83.ExtraInfo extra_info = new oidb_0xe83.ExtraInfo();
  public final PBUInt64Field group_id = PBField.initUInt64(0L);
  public final PBRepeatMessageField<oidb_0xe83.AppInfo> infos = PBField.initRepeatMessage(oidb_0xe83.AppInfo.class);
  public oidb_0xe83.ManageInfo manage_info = new oidb_0xe83.ManageInfo();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0xe83.oidb_0xe83.RspBody
 * JD-Core Version:    0.7.0.1
 */