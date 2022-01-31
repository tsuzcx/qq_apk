package tencent.im.oidb.qqshop;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class qqshop_report$SQQSHPCliLogReq
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "logs" }, new Object[] { null }, SQQSHPCliLogReq.class);
  public final PBRepeatMessageField logs = PBField.initRepeatMessage(qqshop_report.SQQSHPCliLogInfo.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.qqshop.qqshop_report.SQQSHPCliLogReq
 * JD-Core Version:    0.7.0.1
 */