package cooperation.vip.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class adv_report$MobileAdvReportRsp
  extends MessageMicro<MobileAdvReportRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "ret_code", "error_msg" }, new Object[] { Integer.valueOf(0), "" }, MobileAdvReportRsp.class);
  public final PBStringField error_msg = PBField.initString("");
  public final PBInt32Field ret_code = PBField.initInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.vip.pb.adv_report.MobileAdvReportRsp
 * JD-Core Version:    0.7.0.1
 */