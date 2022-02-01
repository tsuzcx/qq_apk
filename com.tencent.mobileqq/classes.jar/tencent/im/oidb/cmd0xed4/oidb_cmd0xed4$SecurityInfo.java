package tencent.im.oidb.cmd0xed4;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

public final class oidb_cmd0xed4$SecurityInfo
  extends MessageMicro<SecurityInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 40, 50, 58 }, new String[] { "nickname", "device_id", "ip", "terminal_id", "os_type", "app_version", "extra" }, new Object[] { "", "", "", "", Integer.valueOf(0), "", null }, SecurityInfo.class);
  public final PBStringField app_version = PBField.initString("");
  public final PBStringField device_id = PBField.initString("");
  public final PBRepeatMessageField<oidb_cmd0xed4.ExtraInfo> extra = PBField.initRepeatMessage(oidb_cmd0xed4.ExtraInfo.class);
  public final PBStringField ip = PBField.initString("");
  public final PBStringField nickname = PBField.initString("");
  public final PBInt32Field os_type = PBField.initInt32(0);
  public final PBStringField terminal_id = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0xed4.oidb_cmd0xed4.SecurityInfo
 * JD-Core Version:    0.7.0.1
 */