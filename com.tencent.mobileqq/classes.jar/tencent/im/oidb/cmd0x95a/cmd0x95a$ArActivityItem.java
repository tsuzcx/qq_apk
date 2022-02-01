package tencent.im.oidb.cmd0x95a;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class cmd0x95a$ArActivityItem
  extends MessageMicro<ArActivityItem>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 42, 48, 56, 66 }, new String[] { "uint32_activity_id", "uint32_activity_type", "str_activity_pic_url", "str_activity_name", "str_scan_name", "uint32_new_activity", "uint32_jump_type", "str_jump_url" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), "", "", "", Integer.valueOf(0), Integer.valueOf(0), "" }, ArActivityItem.class);
  public final PBStringField str_activity_name = PBField.initString("");
  public final PBStringField str_activity_pic_url = PBField.initString("");
  public final PBStringField str_jump_url = PBField.initString("");
  public final PBStringField str_scan_name = PBField.initString("");
  public final PBUInt32Field uint32_activity_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_activity_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_jump_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_new_activity = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.oidb.cmd0x95a.cmd0x95a.ArActivityItem
 * JD-Core Version:    0.7.0.1
 */