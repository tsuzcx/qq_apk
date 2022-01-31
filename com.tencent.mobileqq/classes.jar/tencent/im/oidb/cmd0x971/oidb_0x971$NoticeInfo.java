package tencent.im.oidb.cmd0x971;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0x971$NoticeInfo
  extends MessageMicro<NoticeInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42, 48 }, new String[] { "rule_id", "title", "summary", "icon", "url", "version" }, new Object[] { Integer.valueOf(0), "", "", "", "", Integer.valueOf(0) }, NoticeInfo.class);
  public final PBStringField icon = PBField.initString("");
  public final PBUInt32Field rule_id = PBField.initUInt32(0);
  public final PBStringField summary = PBField.initString("");
  public final PBStringField title = PBField.initString("");
  public final PBStringField url = PBField.initString("");
  public final PBUInt32Field version = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     tencent.im.oidb.cmd0x971.oidb_0x971.NoticeInfo
 * JD-Core Version:    0.7.0.1
 */