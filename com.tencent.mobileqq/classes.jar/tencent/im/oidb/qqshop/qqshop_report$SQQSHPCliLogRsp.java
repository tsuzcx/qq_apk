package tencent.im.oidb.qqshop;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class qqshop_report$SQQSHPCliLogRsp
  extends MessageMicro<SQQSHPCliLogRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "ret", "ret_msg" }, new Object[] { Integer.valueOf(0), "" }, SQQSHPCliLogRsp.class);
  public final PBInt32Field ret = PBField.initInt32(0);
  public final PBStringField ret_msg = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.qqshop.qqshop_report.SQQSHPCliLogRsp
 * JD-Core Version:    0.7.0.1
 */