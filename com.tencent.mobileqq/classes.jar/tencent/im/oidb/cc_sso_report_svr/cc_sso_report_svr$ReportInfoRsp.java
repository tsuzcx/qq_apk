package tencent.im.oidb.cc_sso_report_svr;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class cc_sso_report_svr$ReportInfoRsp
  extends MessageMicro<ReportInfoRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "ret_code", "ret_msg" }, new Object[] { Integer.valueOf(0), "" }, ReportInfoRsp.class);
  public final PBUInt32Field ret_code = PBField.initUInt32(0);
  public final PBStringField ret_msg = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     tencent.im.oidb.cc_sso_report_svr.cc_sso_report_svr.ReportInfoRsp
 * JD-Core Version:    0.7.0.1
 */