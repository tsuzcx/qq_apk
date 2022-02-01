package tencent.im.oidb.cmd0xf4d;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0xf4d$ReportInfo
  extends MessageMicro<ReportInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "show_type", "show_text" }, new Object[] { Integer.valueOf(0), "" }, ReportInfo.class);
  public final PBStringField show_text = PBField.initString("");
  public final PBUInt32Field show_type = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0xf4d.oidb_0xf4d.ReportInfo
 * JD-Core Version:    0.7.0.1
 */