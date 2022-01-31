package tencent.im.oidb.cmd0x5e3;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0xb4a$GroupInfo
  extends MessageMicro<GroupInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 40, 50 }, new String[] { "group_code", "group_name", "group_face", "group_desc", "last_msg_time", "group_label_list" }, new Object[] { Long.valueOf(0L), "", "", "", Integer.valueOf(0), null }, GroupInfo.class);
  public final PBUInt64Field group_code = PBField.initUInt64(0L);
  public final PBStringField group_desc = PBField.initString("");
  public final PBStringField group_face = PBField.initString("");
  public final PBRepeatMessageField<oidb_0xb4a.Label> group_label_list = PBField.initRepeatMessage(oidb_0xb4a.Label.class);
  public final PBStringField group_name = PBField.initString("");
  public final PBUInt32Field last_msg_time = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     tencent.im.oidb.cmd0x5e3.oidb_0xb4a.GroupInfo
 * JD-Core Version:    0.7.0.1
 */