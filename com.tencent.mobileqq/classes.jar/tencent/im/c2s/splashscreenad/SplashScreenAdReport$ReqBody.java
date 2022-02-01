package tencent.im.c2s.splashscreenad;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class SplashScreenAdReport$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint64_uin", "msg_report" }, new Object[] { Long.valueOf(0L), null }, ReqBody.class);
  public SplashScreenAdReport.ReportMsg msg_report = new SplashScreenAdReport.ReportMsg();
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.c2s.splashscreenad.SplashScreenAdReport.ReqBody
 * JD-Core Version:    0.7.0.1
 */