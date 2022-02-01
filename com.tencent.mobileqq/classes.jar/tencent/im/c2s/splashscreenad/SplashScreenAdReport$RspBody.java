package tencent.im.c2s.splashscreenad;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class SplashScreenAdReport$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24 }, new String[] { "int32_ret", "str_msg", "uint32_stop_exposure" }, new Object[] { Integer.valueOf(0), "", Integer.valueOf(0) }, RspBody.class);
  public final PBInt32Field int32_ret = PBField.initInt32(0);
  public final PBStringField str_msg = PBField.initString("");
  public final PBUInt32Field uint32_stop_exposure = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.c2s.splashscreenad.SplashScreenAdReport.RspBody
 * JD-Core Version:    0.7.0.1
 */