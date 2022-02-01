package tencent.im.nearfield_discuss;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class nearfield_discuss$NotifyList
  extends MessageMicro<NotifyList>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24 }, new String[] { "notify_type", "rpt_msg_update_list", "uint32_session_id" }, new Object[] { Integer.valueOf(0), null, Integer.valueOf(0) }, NotifyList.class);
  public final PBEnumField notify_type = PBField.initEnum(0);
  public final PBRepeatMessageField<nearfield_discuss.UpdateInfo> rpt_msg_update_list = PBField.initRepeatMessage(nearfield_discuss.UpdateInfo.class);
  public final PBUInt32Field uint32_session_id = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.nearfield_discuss.nearfield_discuss.NotifyList
 * JD-Core Version:    0.7.0.1
 */