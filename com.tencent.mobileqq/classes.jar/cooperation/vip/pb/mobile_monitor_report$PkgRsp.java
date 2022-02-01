package cooperation.vip.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class mobile_monitor_report$PkgRsp
  extends MessageMicro<PkgRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32 }, new String[] { "ret", "err_msg", "mult_cnt", "mult_delay" }, new Object[] { Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0) }, PkgRsp.class);
  public final PBStringField err_msg = PBField.initString("");
  public final PBInt32Field mult_cnt = PBField.initInt32(0);
  public final PBInt32Field mult_delay = PBField.initInt32(0);
  public final PBUInt32Field ret = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.vip.pb.mobile_monitor_report.PkgRsp
 * JD-Core Version:    0.7.0.1
 */