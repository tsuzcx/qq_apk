package tencent.im.oidb.oidb_0xda6;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0xda6$UserTopicItem
  extends MessageMicro<UserTopicItem>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 42, 48, 56 }, new String[] { "uint32_topic_id", "str_topic", "uint32_total_num", "uint32_frd_num", "rpt_frd_item", "uint32_audit_state", "uint32_apply_num" }, new Object[] { Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(0), Integer.valueOf(0) }, UserTopicItem.class);
  public final PBRepeatMessageField<oidb_0xda6.UinItem> rpt_frd_item = PBField.initRepeatMessage(oidb_0xda6.UinItem.class);
  public final PBStringField str_topic = PBField.initString("");
  public final PBUInt32Field uint32_apply_num = PBField.initUInt32(0);
  public final PBUInt32Field uint32_audit_state = PBField.initUInt32(0);
  public final PBUInt32Field uint32_frd_num = PBField.initUInt32(0);
  public final PBUInt32Field uint32_topic_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_total_num = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.oidb.oidb_0xda6.oidb_0xda6.UserTopicItem
 * JD-Core Version:    0.7.0.1
 */