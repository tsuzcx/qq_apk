package tencent.im.oidb.oidb_0x928;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x928$NoticeInfo
  extends MessageMicro<NoticeInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 48, 56, 64, 72 }, new String[] { "id", "title", "summary", "url", "icon", "type", "app_id", "show_expire", "hide_mode" }, new Object[] { "", "", "", "", "", Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0) }, NoticeInfo.class);
  public final PBUInt64Field app_id = PBField.initUInt64(0L);
  public final PBUInt32Field hide_mode = PBField.initUInt32(0);
  public final PBStringField icon = PBField.initString("");
  public final PBStringField id = PBField.initString("");
  public final PBUInt32Field show_expire = PBField.initUInt32(0);
  public final PBStringField summary = PBField.initString("");
  public final PBStringField title = PBField.initString("");
  public final PBUInt32Field type = PBField.initUInt32(0);
  public final PBStringField url = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     tencent.im.oidb.oidb_0x928.oidb_0x928.NoticeInfo
 * JD-Core Version:    0.7.0.1
 */