package tencent.im.oidb.cmd0x80a;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_cmd0x80a$KDEventReportResp
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "result", "err_msg", "condParams" }, new Object[] { Integer.valueOf(0), "", null }, KDEventReportResp.class);
  public final PBRepeatMessageField condParams = PBField.initRepeatMessage(oidb_cmd0x80a.ReportConditionParam.class);
  public final PBStringField err_msg = PBField.initString("");
  public final PBUInt32Field result = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x80a.oidb_cmd0x80a.KDEventReportResp
 * JD-Core Version:    0.7.0.1
 */