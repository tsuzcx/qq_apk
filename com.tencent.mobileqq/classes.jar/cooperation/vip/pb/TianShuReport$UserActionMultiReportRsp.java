package cooperation.vip.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class TianShuReport$UserActionMultiReportRsp
  extends MessageMicro<UserActionMultiReportRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24 }, new String[] { "err_code", "err_msg", "multi_duration" }, new Object[] { Integer.valueOf(0), "", Integer.valueOf(0) }, UserActionMultiReportRsp.class);
  public final PBInt32Field err_code = PBField.initInt32(0);
  public final PBStringField err_msg = PBField.initString("");
  public final PBInt32Field multi_duration = PBField.initInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.vip.pb.TianShuReport.UserActionMultiReportRsp
 * JD-Core Version:    0.7.0.1
 */