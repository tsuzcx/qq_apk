package tencent.im.oidb.cmd0x80a;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_cmd0x80a$KDEventReportResp
  extends MessageMicro<KDEventReportResp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32 }, new String[] { "result", "err_msg", "condParams", "unit_reset" }, new Object[] { Integer.valueOf(0), "", null, Integer.valueOf(0) }, KDEventReportResp.class);
  public final PBRepeatMessageField<oidb_cmd0x80a.ReportConditionParam> condParams = PBField.initRepeatMessage(oidb_cmd0x80a.ReportConditionParam.class);
  public final PBStringField err_msg = PBField.initString("");
  public final PBUInt32Field result = PBField.initUInt32(0);
  public final PBUInt32Field unit_reset = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0x80a.oidb_cmd0x80a.KDEventReportResp
 * JD-Core Version:    0.7.0.1
 */