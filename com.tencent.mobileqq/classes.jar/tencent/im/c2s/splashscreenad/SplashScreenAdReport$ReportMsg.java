package tencent.im.c2s.splashscreenad;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class SplashScreenAdReport$ReportMsg
  extends MessageMicro<ReportMsg>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "str_ad_id", "uint32_action_type" }, new Object[] { "", Integer.valueOf(0) }, ReportMsg.class);
  public final PBStringField str_ad_id = PBField.initString("");
  public final PBUInt32Field uint32_action_type = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.c2s.splashscreenad.SplashScreenAdReport.ReportMsg
 * JD-Core Version:    0.7.0.1
 */